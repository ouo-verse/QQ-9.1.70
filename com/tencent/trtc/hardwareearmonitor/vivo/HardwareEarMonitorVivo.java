package com.tencent.trtc.hardwareearmonitor.vivo;

import android.media.AudioManager;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.annotations.JNINamespace;

/* compiled from: P */
@JNINamespace("liteav::extensions")
/* loaded from: classes27.dex */
public class HardwareEarMonitorVivo {
    private AudioManager mAudioManager = (AudioManager) ContextUtils.getApplicationContext().getSystemService("audio");
    private long mNativeHardwareEarMonitorHandle;

    public HardwareEarMonitorVivo(long j3) {
        this.mNativeHardwareEarMonitorHandle = j3;
    }

    public static HardwareEarMonitorVivo create(long j3) {
        return new HardwareEarMonitorVivo(j3);
    }

    public String getParameters(String str) {
        try {
            return this.mAudioManager.getParameters(str);
        } catch (Throwable unused) {
            return "";
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
}
