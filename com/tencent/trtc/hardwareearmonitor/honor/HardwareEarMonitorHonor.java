package com.tencent.trtc.hardwareearmonitor.honor;

import android.content.Context;
import android.media.AudioManager;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.trtc.hardwareearmonitor.honor.HonorAudioClient;
import com.tencent.trtc.hardwareearmonitor.honor.HonorEarReturnClient;
import java.util.List;

/* compiled from: P */
@JNINamespace("liteav::extensions")
/* loaded from: classes27.dex */
public class HardwareEarMonitorHonor implements IHonorAudioServiceCallback {
    private HonorAudioClient mHnAudioClient;
    private HonorEarReturnClient mHnEarReturnClient;
    private long mNativeHardwareEarMonitorHandle;
    private Object mLock = new Object();
    private AudioManager mAudioManager = (AudioManager) ContextUtils.getApplicationContext().getSystemService("audio");
    private Context mContext = ContextUtils.getApplicationContext();

    public HardwareEarMonitorHonor(long j3) {
        this.mNativeHardwareEarMonitorHandle = j3;
        HonorAudioClient honorAudioClient = new HonorAudioClient(this.mContext, this);
        this.mHnAudioClient = honorAudioClient;
        honorAudioClient.initialize();
    }

    public static HardwareEarMonitorHonor create(long j3) {
        return new HardwareEarMonitorHonor(j3);
    }

    public static boolean isAudioKitSupport() {
        return HonorAudioClient.isDeviceSupported(ContextUtils.getApplicationContext());
    }

    private static native void nativeHandleResult(long j3, int i3);

    public void createKaraokeService() {
        this.mHnEarReturnClient = (HonorEarReturnClient) this.mHnAudioClient.createService(HonorAudioClient.ServiceType.HNAUDIO_SERVICE_EARRETURN);
    }

    public void destroy() {
        synchronized (this.mLock) {
            this.mNativeHardwareEarMonitorHandle = 0L;
        }
        HonorAudioClient honorAudioClient = this.mHnAudioClient;
        if (honorAudioClient != null) {
            honorAudioClient.destroy();
            this.mHnAudioClient = null;
        }
        HonorEarReturnClient honorEarReturnClient = this.mHnEarReturnClient;
        if (honorEarReturnClient != null) {
            honorEarReturnClient.destroy();
            this.mHnEarReturnClient = null;
        }
    }

    public int enableKaraoke(boolean z16) {
        HonorEarReturnClient honorEarReturnClient = this.mHnEarReturnClient;
        if (honorEarReturnClient == null) {
            return 1806;
        }
        return honorEarReturnClient.enableEarReturn(z16);
    }

    public int[] getKaraokeSupportedServices() {
        List<Integer> supportedServices = this.mHnAudioClient.getSupportedServices();
        if (supportedServices == null) {
            return null;
        }
        int[] iArr = new int[supportedServices.size()];
        for (int i3 = 0; i3 < supportedServices.size(); i3++) {
            iArr[i3] = supportedServices.get(i3).intValue();
        }
        return iArr;
    }

    public boolean isHardwareEarMonitorSupported() {
        HonorEarReturnClient honorEarReturnClient = this.mHnEarReturnClient;
        if (honorEarReturnClient == null) {
            return false;
        }
        return honorEarReturnClient.isServiceSupported();
    }

    public boolean isKaraokeServiceSupport() {
        return this.mHnAudioClient.isServiceSupported(HonorAudioClient.ServiceType.HNAUDIO_SERVICE_EARRETURN);
    }

    @Override // com.tencent.trtc.hardwareearmonitor.honor.IHonorAudioServiceCallback
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

    public int setEqualizer(int i3) {
        HonorEarReturnClient honorEarReturnClient = this.mHnEarReturnClient;
        if (honorEarReturnClient == null) {
            return 1806;
        }
        return honorEarReturnClient.setParameter(HonorEarReturnClient.ParameName.CMD_SET_VOCAL_EQUALIZER_MODE, i3);
    }

    public int setReverberation(int i3) {
        HonorEarReturnClient honorEarReturnClient = this.mHnEarReturnClient;
        if (honorEarReturnClient == null) {
            return 1806;
        }
        return honorEarReturnClient.setParameter(HonorEarReturnClient.ParameName.CMD_SET_AUDIO_EFFECT_MODE_BASE, i3);
    }

    public int setVolume(int i3) {
        HonorEarReturnClient honorEarReturnClient = this.mHnEarReturnClient;
        if (honorEarReturnClient == null) {
            return 1806;
        }
        return honorEarReturnClient.setParameter(HonorEarReturnClient.ParameName.CMD_SET_VOCAL_VOLUME_BASE, i3);
    }
}
