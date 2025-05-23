package com.tencent.thumbplayer.core.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes26.dex */
public class TPAudioPassThroughPluginDetector {
    private static final int DEFAULT_MAX_CHANNEL_COUNT = 8;
    private static final String TAG = "TPAudioPassThroughPluginDetector";
    private static boolean hasRegisterReceiver = false;
    private static boolean isInitted = false;
    private static WeakReference<Context> mContextRef;
    private static Handler mHandler;
    private static BroadcastReceiver mReceiver;
    private static List<AudioPassThroughPluginListener> listeners = new LinkedList();
    private static boolean mIsAudioPassThroughPlugin = false;
    private static ReentrantReadWriteLock mIsAudioPassThroughPluginLock = new ReentrantReadWriteLock();
    private static TPAudioPassThroughCapabilities mAudioPassThroughCapabilities = null;
    private static final Object mListenerLock = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes26.dex */
    public interface AudioPassThroughPluginListener {
        void onAudioPassThroughPlugin(boolean z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes26.dex */
    public static class HdmiAudioPlugBroadcastReceiver extends BroadcastReceiver {
        HdmiAudioPlugBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            TPNativeLog.printLog(2, TPAudioPassThroughPluginDetector.TAG, "HdmiAudioPlugBroadcastReceiver onReceive: " + intent.getAction());
            boolean z16 = false;
            int intExtra = intent.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0);
            if (intExtra != 0 && intExtra == 1) {
                z16 = true;
            }
            TPNativeLog.printLog(2, TPAudioPassThroughPluginDetector.TAG, "HdmiAudioPlugBroadcastReceiver audioPassThroughState:" + intExtra + " bPlugin:" + z16);
            TPAudioPassThroughPluginDetector.onUpdateAudioCapabilities(new TPAudioPassThroughCapabilities(intent.getIntArrayExtra("android.media.extra.ENCODINGS"), intent.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 8)));
            TPAudioPassThroughPluginDetector.notifyAudioPassThroughStateChange(z16);
        }
    }

    public static void addListener(AudioPassThroughPluginListener audioPassThroughPluginListener) {
        synchronized (mListenerLock) {
            if (listeners.add(audioPassThroughPluginListener) && !hasRegisterReceiver) {
                registerReceiver();
                hasRegisterReceiver = true;
            }
        }
    }

    public static void deinit() {
        WeakReference<Context> weakReference;
        synchronized (TPAudioPassThroughPluginDetector.class) {
            if (isInitted && (weakReference = mContextRef) != null) {
                weakReference.clear();
                isInitted = false;
                TPNativeLog.printLog(2, TAG, "TPAudioPassThroughPluginDetector deinit succeed!");
            }
        }
    }

    public static void init(Context context) {
        synchronized (TPAudioPassThroughPluginDetector.class) {
            TPNativeLog.printLog(2, TAG, "TPAudioPassThroughPluginDetector init enter!");
            if (isInitted) {
                return;
            }
            mContextRef = new WeakReference<>(context.getApplicationContext());
            isInitted = true;
            mHandler = new Handler(TPThreadPool.getInstance().obtainShareThread().getLooper());
            registerReceiver();
            hasRegisterReceiver = true;
            TPNativeLog.printLog(2, TAG, "TPAudioPassThroughPluginDetector init succeed!");
        }
    }

    public static boolean isAudioPassThroughPlugin() {
        mIsAudioPassThroughPluginLock.readLock().lock();
        try {
            return mIsAudioPassThroughPlugin;
        } finally {
            mIsAudioPassThroughPluginLock.readLock().unlock();
        }
    }

    public static boolean isAudioPassThroughSupport(int i3, int i16) {
        TPAudioPassThroughCapabilities tPAudioPassThroughCapabilities = mAudioPassThroughCapabilities;
        if (tPAudioPassThroughCapabilities != null) {
            if (!tPAudioPassThroughCapabilities.supportsEncoding(i3) || i16 > mAudioPassThroughCapabilities.getMaxChannelCount()) {
                return false;
            }
            return true;
        }
        TPNativeLog.printLog(0, TAG, "isAudioPassThroughSupport failed, mAudioPassThroughCapabilities is not init yet!");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void notifyAudioPassThroughStateChange(boolean z16) {
        if (isAudioPassThroughPlugin() == z16) {
            return;
        }
        mIsAudioPassThroughPluginLock.writeLock().lock();
        mIsAudioPassThroughPlugin = z16;
        mIsAudioPassThroughPluginLock.writeLock().unlock();
        synchronized (mListenerLock) {
            Iterator<AudioPassThroughPluginListener> it = listeners.iterator();
            while (it.hasNext()) {
                it.next().onAudioPassThroughPlugin(z16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void onUpdateAudioCapabilities(TPAudioPassThroughCapabilities tPAudioPassThroughCapabilities) {
        if (!tPAudioPassThroughCapabilities.equals(mAudioPassThroughCapabilities)) {
            mAudioPassThroughCapabilities = tPAudioPassThroughCapabilities;
            TPNativeLog.printLog(2, TAG, "onUpdateAudioCapabilities AudioCapabilities:" + mAudioPassThroughCapabilities.toString());
        }
    }

    private static void registerReceiver() {
        TPNativeLog.printLog(2, TAG, "registerReceiver enter");
        if (Build.VERSION.SDK_INT < 24) {
            return;
        }
        if (isInitted && mContextRef != null) {
            Intent intent = null;
            byte b16 = 0;
            if (mReceiver == null) {
                mReceiver = new HdmiAudioPlugBroadcastReceiver();
            }
            Context context = mContextRef.get();
            if (context == null) {
                TPNativeLog.printLog(0, TAG, "registerReceiver failed, context is null, maybe is invalid!");
                return;
            }
            if (mReceiver != null) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.media.action.HDMI_AUDIO_PLUG");
                intent = context.registerReceiver(mReceiver, intentFilter, null, mHandler);
            }
            mAudioPassThroughCapabilities = TPAudioPassThroughCapabilities.getCapabilities(context, intent);
            TPNativeLog.printLog(2, TAG, "registerReceiver leave");
            return;
        }
        TPNativeLog.printLog(0, TAG, "registerReceiver failed, TPAudioPassThroughPluginDetector is not init yet!");
    }

    public static void removeListener(AudioPassThroughPluginListener audioPassThroughPluginListener) {
        synchronized (mListenerLock) {
            listeners.remove(audioPassThroughPluginListener);
            if (listeners.isEmpty() && hasRegisterReceiver) {
                unregisterReceiver();
                hasRegisterReceiver = false;
            }
        }
    }

    private static void unregisterReceiver() {
        WeakReference<Context> weakReference;
        if (isInitted && (weakReference = mContextRef) != null) {
            Context context = weakReference.get();
            if (context == null) {
                TPNativeLog.printLog(0, TAG, "registerReceiver failed, context is null, maybe is invalid!");
                return;
            } else {
                context.unregisterReceiver(mReceiver);
                return;
            }
        }
        TPNativeLog.printLog(0, TAG, "registerReceiver failed, TPAudioPassThroughPluginDetector is not init yet!");
    }
}
