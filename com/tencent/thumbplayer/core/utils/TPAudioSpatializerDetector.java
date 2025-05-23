package com.tencent.thumbplayer.core.utils;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.Spatializer;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.collection.ArraySet;
import java.util.Iterator;

/* loaded from: classes26.dex */
public class TPAudioSpatializerDetector {
    private static final String TAG = "TPAudioSpatializerDetector";
    private static boolean mIsInited = false;
    private static Spatializer mSpatializer;
    private static final ArraySet<IOutputDeviceStateChangedListener> mSpatializerStateListeners = new ArraySet<>();

    /* loaded from: classes26.dex */
    public interface IOutputDeviceStateChangedListener {
        void onOutputDeviceAvailableChanged(boolean z16);

        void onOutputDeviceSwitchChanged(boolean z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(api = 32)
    /* loaded from: classes26.dex */
    public static class SpatializerStateChangedListener implements Spatializer.OnSpatializerStateChangedListener {
        SpatializerStateChangedListener() {
        }

        @Override // android.media.Spatializer.OnSpatializerStateChangedListener
        public void onSpatializerAvailableChanged(@NonNull Spatializer spatializer, boolean z16) {
            TPNativeLog.printLog(2, TPAudioSpatializerDetector.TAG, "onSpatializerAvailableChanged isAvailable:" + z16);
            TPAudioSpatializerDetector.notifyOutputDeviceAvailableChanged(z16);
        }

        @Override // android.media.Spatializer.OnSpatializerStateChangedListener
        public void onSpatializerEnabledChanged(@NonNull Spatializer spatializer, boolean z16) {
            TPNativeLog.printLog(2, TPAudioSpatializerDetector.TAG, "onSpatializerEnabledChanged isEnabled:" + z16);
            TPAudioSpatializerDetector.notifyOutputDeviceSwitchStateChanged(z16);
        }
    }

    public static synchronized void addListener(@NonNull IOutputDeviceStateChangedListener iOutputDeviceStateChangedListener) {
        synchronized (TPAudioSpatializerDetector.class) {
            TPNativeLog.printLog(2, TAG, "addListener:" + iOutputDeviceStateChangedListener);
            mSpatializerStateListeners.add(iOutputDeviceStateChangedListener);
        }
    }

    private static void createAndInitSpatializer(@NonNull Context context) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 33) {
            try {
                try {
                    Spatializer spatializer = ((AudioManager) context.getSystemService("audio")).getSpatializer();
                    mSpatializer = spatializer;
                    if (spatializer != null) {
                        spatializer.addOnSpatializerStateChangedListener(com.tencent.thumbplayer.common.thread.TPThreadPool.getInstance().obtainSharedThreadPoolExecutor(), new SpatializerStateChangedListener());
                    }
                    TPNativeLog.printLog(2, TAG, "createAndInitSpatializer done");
                    return;
                } catch (Exception e16) {
                    TPNativeLog.printLog(0, TAG, "createAndInitSpatializer internal exception: " + e16);
                    return;
                }
            } catch (Exception unused) {
                TPNativeLog.printLog(0, TAG, "createAndInitSpatializer audioManager null");
                return;
            }
        }
        TPNativeLog.printLog(2, TAG, "createAndInitSpatializer invalid sdk version:" + i3);
    }

    public static synchronized void init(@NonNull Context context) {
        synchronized (TPAudioSpatializerDetector.class) {
            if (mIsInited) {
                return;
            }
            createAndInitSpatializer(context);
            mIsInited = true;
        }
    }

    public static synchronized boolean isOutputDeviceAvailable() {
        Spatializer spatializer;
        synchronized (TPAudioSpatializerDetector.class) {
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 32) {
                if (mIsInited && (spatializer = mSpatializer) != null) {
                    return spatializer.isAvailable();
                }
                return false;
            }
            TPNativeLog.printLog(3, TAG, "is_output_device_available invalid sdk version:" + i3);
            return false;
        }
    }

    public static synchronized boolean isOutputDeviceSwitchOn() {
        Spatializer spatializer;
        synchronized (TPAudioSpatializerDetector.class) {
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 32) {
                if (mIsInited && (spatializer = mSpatializer) != null) {
                    return spatializer.isEnabled();
                }
                return false;
            }
            TPNativeLog.printLog(3, TAG, "is_output_device_switchOn invalid sdk version:" + i3);
            return false;
        }
    }

    public static synchronized boolean isSpatialAudioSupported() {
        Spatializer spatializer;
        synchronized (TPAudioSpatializerDetector.class) {
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 32) {
                if (mIsInited && (spatializer = mSpatializer) != null) {
                    int immersiveAudioLevel = spatializer.getImmersiveAudioLevel();
                    TPNativeLog.printLog(3, TAG, "isSpatialAudioSupported device level:" + immersiveAudioLevel);
                    if (immersiveAudioLevel == 0) {
                        return false;
                    }
                    return true;
                }
                return false;
            }
            TPNativeLog.printLog(3, TAG, "isSpatialAudioSupported invalid sdk version:" + i3);
            return false;
        }
    }

    public static synchronized boolean isSpatialAudioSupportedWithFormat(int i3, int i16) {
        Spatializer spatializer;
        synchronized (TPAudioSpatializerDetector.class) {
            int i17 = Build.VERSION.SDK_INT;
            if (i17 >= 32) {
                if (mIsInited && (spatializer = mSpatializer) != null) {
                    int immersiveAudioLevel = spatializer.getImmersiveAudioLevel();
                    TPNativeLog.printLog(3, TAG, "isSpatialAudioSupportedWithFormat device level:" + immersiveAudioLevel + " encodingFormat:" + i3 + " channelMask:" + i16);
                    if (immersiveAudioLevel == 0) {
                        TPNativeLog.printLog(3, TAG, "isSpatialAudioSupportedWithFormat not support");
                        return false;
                    }
                    return mSpatializer.canBeSpatialized(new AudioAttributes.Builder().setContentType(2).setUsage(1).setIsContentSpatialized(true).build(), new AudioFormat.Builder().setChannelMask(i16).setEncoding(i3).build());
                }
                return false;
            }
            TPNativeLog.printLog(3, TAG, "isSpatialAudioSupportedWithFormat invalid sdk version:" + i17);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void notifyOutputDeviceAvailableChanged(boolean z16) {
        synchronized (TPAudioSpatializerDetector.class) {
            Iterator<IOutputDeviceStateChangedListener> it = mSpatializerStateListeners.iterator();
            while (it.hasNext()) {
                it.next().onOutputDeviceAvailableChanged(z16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void notifyOutputDeviceSwitchStateChanged(boolean z16) {
        synchronized (TPAudioSpatializerDetector.class) {
            Iterator<IOutputDeviceStateChangedListener> it = mSpatializerStateListeners.iterator();
            while (it.hasNext()) {
                it.next().onOutputDeviceSwitchChanged(z16);
            }
        }
    }

    public static synchronized void removeListener(@NonNull IOutputDeviceStateChangedListener iOutputDeviceStateChangedListener) {
        synchronized (TPAudioSpatializerDetector.class) {
            TPNativeLog.printLog(2, TAG, "removeListener:" + iOutputDeviceStateChangedListener);
            mSpatializerStateListeners.remove(iOutputDeviceStateChangedListener);
        }
    }
}
