package com.tencent.trtc.hardwareearmonitor.daisy;

import android.content.Context;
import android.media.AudioManager;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.trtc.hardwareearmonitor.daisy.DaisyAudioKaraokeFeatureKit;
import com.tencent.trtc.hardwareearmonitor.daisy.DaisyAudioKit;
import java.util.List;

/* compiled from: P */
@JNINamespace("liteav::extensions")
/* loaded from: classes27.dex */
public class HardwareEarMonitorDaisy implements IDaisyAudioKitCallback {
    private DaisyAudioKit mDaisyAudioKit;
    private DaisyAudioKaraokeFeatureKit mDaisyKaraokeKit;
    private long mNativeHardwareEarMonitorHandle;
    private Object mLock = new Object();
    private AudioManager mAudioManager = (AudioManager) ContextUtils.getApplicationContext().getSystemService("audio");
    private Context mContext = ContextUtils.getApplicationContext();

    public HardwareEarMonitorDaisy(long j3) {
        this.mNativeHardwareEarMonitorHandle = j3;
        DaisyAudioKit daisyAudioKit = new DaisyAudioKit(ContextUtils.getApplicationContext(), this);
        this.mDaisyAudioKit = daisyAudioKit;
        daisyAudioKit.initialize();
    }

    public static HardwareEarMonitorDaisy create(long j3) {
        return new HardwareEarMonitorDaisy(j3);
    }

    public static boolean isAudioKitSupport() {
        return DaisyFeatureKitManager.isAudioKitSupport(ContextUtils.getApplicationContext());
    }

    private static native void nativeHandleResult(long j3, int i3);

    private int setEqualizer(int i3) {
        DaisyAudioKaraokeFeatureKit daisyAudioKaraokeFeatureKit = this.mDaisyKaraokeKit;
        if (daisyAudioKaraokeFeatureKit == null) {
            return 1806;
        }
        return daisyAudioKaraokeFeatureKit.setParameter(DaisyAudioKaraokeFeatureKit.ParameName.CMD_SET_VOCAL_EQUALIZER_MODE, i3);
    }

    private int setVolume(int i3) {
        DaisyAudioKaraokeFeatureKit daisyAudioKaraokeFeatureKit = this.mDaisyKaraokeKit;
        if (daisyAudioKaraokeFeatureKit == null) {
            return 1806;
        }
        return daisyAudioKaraokeFeatureKit.setParameter(DaisyAudioKaraokeFeatureKit.ParameName.CMD_SET_VOCAL_VOLUME_BASE, i3);
    }

    public void createKaraokeService() {
        this.mDaisyKaraokeKit = (DaisyAudioKaraokeFeatureKit) this.mDaisyAudioKit.createFeature(DaisyAudioKit.FeatureType.HWAUDIO_FEATURE_KARAOKE);
    }

    public void destroy() {
        synchronized (this.mLock) {
            this.mNativeHardwareEarMonitorHandle = 0L;
        }
        DaisyAudioKit daisyAudioKit = this.mDaisyAudioKit;
        if (daisyAudioKit != null) {
            daisyAudioKit.destroy();
            this.mDaisyAudioKit = null;
        }
        DaisyAudioKaraokeFeatureKit daisyAudioKaraokeFeatureKit = this.mDaisyKaraokeKit;
        if (daisyAudioKaraokeFeatureKit != null) {
            daisyAudioKaraokeFeatureKit.destroy();
            this.mDaisyKaraokeKit = null;
        }
    }

    public int enableKaraoke(boolean z16) {
        DaisyAudioKaraokeFeatureKit daisyAudioKaraokeFeatureKit = this.mDaisyKaraokeKit;
        if (daisyAudioKaraokeFeatureKit == null) {
            return 1806;
        }
        return daisyAudioKaraokeFeatureKit.enableKaraokeFeature(z16);
    }

    public int[] getKaraokeSupportedServices() {
        List<Integer> supportedFeatures = this.mDaisyAudioKit.getSupportedFeatures();
        if (supportedFeatures == null) {
            return null;
        }
        int[] iArr = new int[supportedFeatures.size()];
        for (int i3 = 0; i3 < supportedFeatures.size(); i3++) {
            iArr[i3] = supportedFeatures.get(i3).intValue();
        }
        return iArr;
    }

    public boolean isHardwareEarMonitorSupported() {
        DaisyAudioKit daisyAudioKit = this.mDaisyAudioKit;
        if (daisyAudioKit == null) {
            return false;
        }
        return daisyAudioKit.isFeatureSupported(DaisyAudioKit.FeatureType.HWAUDIO_FEATURE_KARAOKE);
    }

    public boolean isKaraokeServiceSupport() {
        return this.mDaisyAudioKit.isFeatureSupported(DaisyAudioKit.FeatureType.HWAUDIO_FEATURE_KARAOKE);
    }

    @Override // com.tencent.trtc.hardwareearmonitor.daisy.IDaisyAudioKitCallback
    public void onResult(int i3) {
        synchronized (this.mLock) {
            nativeHandleResult(this.mNativeHardwareEarMonitorHandle, i3);
        }
    }

    public boolean setAudioParams(String str) {
        try {
            this.mAudioManager.setParameters(str);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public int setReverberation(int i3) {
        DaisyAudioKaraokeFeatureKit daisyAudioKaraokeFeatureKit = this.mDaisyKaraokeKit;
        if (daisyAudioKaraokeFeatureKit == null) {
            return 1806;
        }
        return daisyAudioKaraokeFeatureKit.setParameter(DaisyAudioKaraokeFeatureKit.ParameName.CMD_SET_AUDIO_EFFECT_MODE_BASE, i3);
    }
}
