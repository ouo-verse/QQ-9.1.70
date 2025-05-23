package com.tencent.qqlive.tvkplayer.tools.utils;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.Spatializer;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKAudioSpatializer {
    private static final String TAG = "TVKAudioSpatializer";
    private static TVKAudioSpatializer mInstance;
    private Spatializer mSpatializer;
    private boolean mIsInited = false;
    private boolean mIsAvailableOutputDeviceOnceConnected = false;
    private final CopyOnWriteArraySet<IOutputDeviceStateChangedListener> mSpatializerStateListeners = new CopyOnWriteArraySet<>();

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface IOutputDeviceStateChangedListener {
        void onOutputDeviceAvailableChanged(boolean z16);

        void onOutputDeviceSwitchChanged(boolean z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @RequiresApi(api = 32)
    /* loaded from: classes23.dex */
    public class SpatialierStateChangedListener implements Spatializer.OnSpatializerStateChangedListener {
        SpatialierStateChangedListener() {
        }

        @Override // android.media.Spatializer.OnSpatializerStateChangedListener
        public void onSpatializerAvailableChanged(@NonNull Spatializer spatializer, boolean z16) {
            TVKLogUtil.i(TVKAudioSpatializer.TAG, "onSpatializerAvailableChanged isAvailable:" + z16);
            if (!TVKAudioSpatializer.this.mIsAvailableOutputDeviceOnceConnected && z16) {
                TVKAudioSpatializer.this.mIsAvailableOutputDeviceOnceConnected = true;
            }
            TVKAudioSpatializer.this.notifyOutputDeviceAvailableChanged(z16);
        }

        @Override // android.media.Spatializer.OnSpatializerStateChangedListener
        public void onSpatializerEnabledChanged(@NonNull Spatializer spatializer, boolean z16) {
            TVKLogUtil.i(TVKAudioSpatializer.TAG, "onSpatializerEnabledChanged isEnabled:" + z16);
            TVKAudioSpatializer.this.notifyOutputDeviceSwitchStateChanged(z16);
        }
    }

    TVKAudioSpatializer() {
    }

    private void createAndInitSpatializer(Context context) {
        AudioManager audioManager;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 33) {
            if (context == null) {
                TVKLogUtil.e(TAG, "createAndInitSpatializer context null");
                return;
            }
            try {
                audioManager = (AudioManager) context.getSystemService("audio");
            } catch (Exception unused) {
                audioManager = null;
            }
            if (audioManager == null) {
                TVKLogUtil.e(TAG, "createAndInitSpatializer audioManager null");
                return;
            }
            try {
                Spatializer spatializer = audioManager.getSpatializer();
                this.mSpatializer = spatializer;
                if (spatializer != null) {
                    spatializer.addOnSpatializerStateChangedListener(TVKThreadPool.getInstance().obtainNormalPriorityExecutor(), new SpatialierStateChangedListener());
                    return;
                }
                return;
            } catch (Exception e16) {
                TVKLogUtil.e(TAG, e16, "createAndInitSpatializer internal exception: ");
                return;
            }
        }
        TVKLogUtil.i(TAG, "createAndInitSpatializer invalid sdk version:" + i3);
    }

    public static TVKAudioSpatializer getInstance() {
        if (mInstance == null) {
            synchronized (TVKAudioSpatializer.class) {
                if (mInstance == null) {
                    mInstance = new TVKAudioSpatializer();
                }
            }
        }
        return mInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyOutputDeviceAvailableChanged(boolean z16) {
        Iterator it = new CopyOnWriteArraySet(this.mSpatializerStateListeners).iterator();
        while (it.hasNext()) {
            ((IOutputDeviceStateChangedListener) it.next()).onOutputDeviceAvailableChanged(z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyOutputDeviceSwitchStateChanged(boolean z16) {
        Iterator it = new CopyOnWriteArraySet(this.mSpatializerStateListeners).iterator();
        while (it.hasNext()) {
            ((IOutputDeviceStateChangedListener) it.next()).onOutputDeviceSwitchChanged(z16);
        }
    }

    public void addListener(@NonNull IOutputDeviceStateChangedListener iOutputDeviceStateChangedListener) {
        this.mSpatializerStateListeners.add(iOutputDeviceStateChangedListener);
    }

    public synchronized void init(@NonNull Context context) {
        if (this.mIsInited) {
            return;
        }
        createAndInitSpatializer(context);
        this.mIsInited = true;
        this.mIsAvailableOutputDeviceOnceConnected = isOutputDeviceSupported();
    }

    public boolean isAvailableOutputDeviceOnceConnected() {
        return this.mIsAvailableOutputDeviceOnceConnected;
    }

    public boolean isOutputDeviceSupported() {
        Spatializer spatializer;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 32) {
            if (!this.mIsInited || (spatializer = this.mSpatializer) == null) {
                return false;
            }
            return spatializer.isAvailable();
        }
        TVKLogUtil.i(TAG, "isOutputDeviceSupported invalid sdk version:" + i3);
        return false;
    }

    public boolean isOutputDeviceSwitchOn() {
        Spatializer spatializer;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 32) {
            if (!this.mIsInited || (spatializer = this.mSpatializer) == null) {
                return false;
            }
            return spatializer.isEnabled();
        }
        TVKLogUtil.i(TAG, "isOutputDeviceSwitchOn invalid sdk version:" + i3);
        return false;
    }

    public boolean isSpatialAudioSupported() {
        Spatializer spatializer;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 32) {
            if (!this.mIsInited || (spatializer = this.mSpatializer) == null) {
                return false;
            }
            int immersiveAudioLevel = spatializer.getImmersiveAudioLevel();
            TVKLogUtil.i(TAG, "isSpatialAudioSupported device level:" + immersiveAudioLevel);
            if (immersiveAudioLevel == 0) {
                return false;
            }
            return true;
        }
        TVKLogUtil.i(TAG, "isSpatialAudioSupported invalid sdk version:" + i3);
        return false;
    }

    public boolean isSpatialAudioSupportedWithFormat(int i3, int i16) {
        Spatializer spatializer;
        int i17 = Build.VERSION.SDK_INT;
        if (i17 >= 32) {
            if (!this.mIsInited || (spatializer = this.mSpatializer) == null) {
                return false;
            }
            int immersiveAudioLevel = spatializer.getImmersiveAudioLevel();
            TVKLogUtil.i(TAG, "isSpatialAudioSupportedWithFormat device level:" + immersiveAudioLevel + " encodingFormat:" + i3 + " channelMask:" + i16);
            if (immersiveAudioLevel == 0) {
                TVKLogUtil.i(TAG, "isSpatialAudioSupportedWithFormat not support");
                return false;
            }
            return this.mSpatializer.canBeSpatialized(new AudioAttributes.Builder().setContentType(2).setUsage(1).setIsContentSpatialized(true).build(), new AudioFormat.Builder().setSampleRate(48000).setChannelMask(i16).setEncoding(i3).build());
        }
        TVKLogUtil.i(TAG, "isSpatialAudioSupportedWithFormat invalid sdk version:" + i17);
        return false;
    }

    public void removeListener(@NonNull IOutputDeviceStateChangedListener iOutputDeviceStateChangedListener) {
        this.mSpatializerStateListeners.remove(iOutputDeviceStateChangedListener);
    }
}
