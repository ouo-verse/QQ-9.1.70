package com.tencent.thumbplayer.core.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioDeviceCallback;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.annotation.RequiresApi;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/* loaded from: classes26.dex */
public class TPHeadsetPluginDetector {
    private static final int AUDIO_TYPE_BLUETOOTH_A2DP = 2;
    private static final int AUDIO_TYPE_BUILTIN_OTHERS = 99;
    private static final int AUDIO_TYPE_BUILTIN_SPEAKER = 0;
    private static final int AUDIO_TYPE_HEADPHONES = 1;
    private static final String TAG = "TPHeadsetPluginDetector";
    private static boolean hasRegisterReceiver = false;
    private static boolean isInitted = false;
    private static WeakReference<Context> mContextRef;
    private static BroadcastReceiver mReceiver;
    private static List<HeadsetPluginListener> mlisteners = new LinkedList();
    private static Set<Integer> mCurOutputs = null;
    private static HandlerThread mAudioDeviceCallbackHandlerThread = null;
    private static Handler mAudioDeviceCallbackHandler = null;
    private static final Object mListenersLock = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes26.dex */
    public interface HeadsetPluginListener {
        void onHeadsetPlugin(Set<Integer> set, Set<Integer> set2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes26.dex */
    public static class HeadsetPluginReceiver extends BroadcastReceiver {
        HeadsetPluginReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            TPNativeLog.printLog(2, TPHeadsetPluginDetector.TAG, "onReceive: " + intent.getAction());
            Set access$100 = TPHeadsetPluginDetector.access$100();
            int i3 = 0;
            if ("android.intent.action.HEADSET_PLUG".equals(intent.getAction())) {
                if (intent.hasExtra("state")) {
                    i3 = intent.getIntExtra("state", 0);
                }
                if (access$100 != null) {
                    if (i3 == 0) {
                        access$100.remove(1);
                    } else if (i3 == 1) {
                        access$100.add(1);
                    }
                }
                TPHeadsetPluginDetector.notifyAudioOutputStateChange(TPHeadsetPluginDetector.mCurOutputs, access$100);
                return;
            }
            if ("android.media.AUDIO_BECOMING_NOISY".equals(intent.getAction())) {
                if (access$100 != null) {
                    access$100.remove(1);
                }
                TPHeadsetPluginDetector.notifyAudioOutputStateChange(TPHeadsetPluginDetector.mCurOutputs, access$100);
            } else if ("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED".equals(intent.getAction())) {
                int intExtra = intent.getIntExtra("android.bluetooth.profile.extra.STATE", 0);
                if (access$100 != null) {
                    if (intExtra == 2) {
                        access$100.add(2);
                    } else if (intExtra == 0) {
                        access$100.remove(2);
                    }
                }
                TPHeadsetPluginDetector.notifyAudioOutputStateChange(TPHeadsetPluginDetector.mCurOutputs, access$100);
            }
        }
    }

    static /* synthetic */ Set access$100() {
        return getAudioOutputs();
    }

    public static void addHeadsetPluginListener(HeadsetPluginListener headsetPluginListener) {
        synchronized (mListenersLock) {
            if (mlisteners.add(headsetPluginListener) && !hasRegisterReceiver) {
                registerReceiver();
                hasRegisterReceiver = true;
            }
        }
    }

    private static Handler createAudioDeviceCallbackHandler() {
        if (mAudioDeviceCallbackHandlerThread == null && mAudioDeviceCallbackHandler == null) {
            mAudioDeviceCallbackHandlerThread = TPThreadPool.getInstance().obtainShareThread();
            mAudioDeviceCallbackHandler = new Handler(mAudioDeviceCallbackHandlerThread.getLooper());
        }
        return mAudioDeviceCallbackHandler;
    }

    public static void deinit() {
        WeakReference<Context> weakReference;
        synchronized (TPHeadsetPluginDetector.class) {
            if (isInitted && (weakReference = mContextRef) != null) {
                weakReference.clear();
                releaseAudioDeviceCallbackHandler();
                isInitted = false;
                TPNativeLog.printLog(2, TAG, "HeadsetPluginDetector deinit succeed!");
            }
        }
    }

    private static AudioManager getAudioManager() {
        WeakReference<Context> weakReference;
        if (isInitted && (weakReference = mContextRef) != null) {
            Context context = weakReference.get();
            if (context == null) {
                TPNativeLog.printLog(0, TAG, "getAudioManager failed, context is null, maybe is invalid!");
                return null;
            }
            try {
                return (AudioManager) context.getApplicationContext().getSystemService("audio");
            } catch (Exception unused) {
                return null;
            }
        }
        TPNativeLog.printLog(0, TAG, "getAudioManager failed, HeadsetPluginDetector is not init yet!");
        return null;
    }

    private static Set<Integer> getAudioOutputs() {
        HashSet hashSet = new HashSet();
        AudioManager audioManager = getAudioManager();
        if (audioManager == null) {
            TPNativeLog.printLog(0, TAG, "audioManager is null!");
            return hashSet;
        }
        AudioDeviceInfo[] devices = audioManager.getDevices(2);
        if (devices != null) {
            for (AudioDeviceInfo audioDeviceInfo : devices) {
                if (audioDeviceInfo.getType() == 2) {
                    hashSet.add(0);
                } else if (audioDeviceInfo.getType() == 8) {
                    hashSet.add(2);
                } else if (audioDeviceInfo.getType() == 3) {
                    hashSet.add(1);
                }
            }
        }
        return hashSet;
    }

    @TPMethodCalledByNative
    public static Set<Integer> getCurrentRoutes() {
        return mCurOutputs;
    }

    public static void init(Context context) {
        synchronized (TPHeadsetPluginDetector.class) {
            if (isInitted) {
                return;
            }
            mContextRef = new WeakReference<>(context.getApplicationContext());
            isInitted = true;
            initCurrentOutputs();
            TPNativeLog.printLog(2, TAG, "HeadsetPluginDetector init succeed!");
        }
    }

    private static void initCurrentOutputs() {
        mCurOutputs = getAudioOutputs();
    }

    @TPMethodCalledByNative
    public static boolean isAudioRouteTypeOn(int i3) {
        Set<Integer> set = mCurOutputs;
        if (set == null) {
            return false;
        }
        return set.contains(Integer.valueOf(i3));
    }

    @TPMethodCalledByNative
    public static boolean isBluetoothPlugin() {
        AudioManager audioManager = getAudioManager();
        if (audioManager == null) {
            TPNativeLog.printLog(0, TAG, "audioManager is null!");
            return false;
        }
        return audioManager.isBluetoothA2dpOn();
    }

    @TPMethodCalledByNative
    public static boolean isHeadsetPlugin() {
        AudioManager audioManager = getAudioManager();
        if (audioManager == null) {
            TPNativeLog.printLog(0, TAG, "audioManager is null!");
            return false;
        }
        return audioManager.isWiredHeadsetOn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void notifyAudioOutputStateChange(Set<Integer> set, Set<Integer> set2) {
        boolean z16;
        if (set != null && set2 != null && set.size() == set2.size() && set2.containsAll(set)) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            return;
        }
        mCurOutputs = set2;
        synchronized (mListenersLock) {
            Iterator<HeadsetPluginListener> it = mlisteners.iterator();
            while (it.hasNext()) {
                it.next().onHeadsetPlugin(set, set2);
            }
        }
    }

    @RequiresApi(api = 23)
    private static boolean registerDeviceCallback() {
        AudioManager audioManager = getAudioManager();
        if (audioManager == null) {
            TPNativeLog.printLog(0, TAG, "audioManager is null!");
            return false;
        }
        audioManager.registerAudioDeviceCallback(new AudioDeviceCallback() { // from class: com.tencent.thumbplayer.core.utils.TPHeadsetPluginDetector.1
            @Override // android.media.AudioDeviceCallback
            public void onAudioDevicesAdded(AudioDeviceInfo[] audioDeviceInfoArr) {
                TPNativeLog.printLog(2, TPHeadsetPluginDetector.TAG, "onAudioDevicesAdded!");
                TPHeadsetPluginDetector.notifyAudioOutputStateChange(TPHeadsetPluginDetector.mCurOutputs, TPHeadsetPluginDetector.access$100());
            }

            @Override // android.media.AudioDeviceCallback
            public void onAudioDevicesRemoved(AudioDeviceInfo[] audioDeviceInfoArr) {
                TPNativeLog.printLog(2, TPHeadsetPluginDetector.TAG, "onAudioDevicesRemoved!");
                TPHeadsetPluginDetector.notifyAudioOutputStateChange(TPHeadsetPluginDetector.mCurOutputs, TPHeadsetPluginDetector.access$100());
            }
        }, createAudioDeviceCallbackHandler());
        return true;
    }

    private static void registerReceiver() {
        WeakReference<Context> weakReference;
        if (registerDeviceCallback()) {
            return;
        }
        if (mReceiver == null) {
            mReceiver = new HeadsetPluginReceiver();
        }
        if (isInitted && (weakReference = mContextRef) != null) {
            Context context = weakReference.get();
            if (context == null) {
                TPNativeLog.printLog(0, TAG, "registerReceiver failed, context is null, maybe is invalid!");
                return;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.HEADSET_PLUG");
            intentFilter.addAction("android.media.AUDIO_BECOMING_NOISY");
            intentFilter.addAction("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED");
            context.registerReceiver(mReceiver, intentFilter);
            return;
        }
        TPNativeLog.printLog(0, TAG, "registerReceiver failed, TPHeadsetPluginDetector is not init yet!");
    }

    private static void releaseAudioDeviceCallbackHandler() {
        TPThreadPool.getInstance().recycle(mAudioDeviceCallbackHandlerThread, mAudioDeviceCallbackHandler);
        mAudioDeviceCallbackHandlerThread = null;
        mAudioDeviceCallbackHandler = null;
    }

    public static void removeHeadsetPluginListener(HeadsetPluginListener headsetPluginListener) {
        synchronized (mListenersLock) {
            mlisteners.remove(headsetPluginListener);
            if (mlisteners.isEmpty() && hasRegisterReceiver) {
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
        TPNativeLog.printLog(0, TAG, "registerReceiver failed, HeadsetPluginDetector is not init yet!");
    }
}
