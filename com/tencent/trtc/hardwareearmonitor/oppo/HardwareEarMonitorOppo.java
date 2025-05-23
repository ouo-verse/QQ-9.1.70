package com.tencent.trtc.hardwareearmonitor.oppo;

import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.annotations.JNINamespace;

/* compiled from: P */
@JNINamespace("liteav::extensions")
/* loaded from: classes27.dex */
public class HardwareEarMonitorOppo {
    private AudioManager mAudioManager = (AudioManager) ContextUtils.getApplicationContext().getSystemService("audio");
    private Context mContext = ContextUtils.getApplicationContext();
    private long mNativeHardwareEarMonitorHandle;

    public HardwareEarMonitorOppo(long j3) {
        this.mNativeHardwareEarMonitorHandle = j3;
    }

    public static HardwareEarMonitorOppo create(long j3) {
        return new HardwareEarMonitorOppo(j3);
    }

    public String getParameters(String str) {
        try {
            return this.mAudioManager.getParameters(str);
        } catch (Throwable unused) {
            return "";
        }
    }

    public int getUidFromPackage() {
        int packageUid;
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                packageUid = this.mContext.getPackageManager().getPackageUid(this.mContext.getPackageName(), 0);
                return packageUid;
            }
            return 0;
        } catch (Throwable unused) {
            return 0;
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

    public boolean systemFeatureSupported(String str) {
        try {
            if (Build.VERSION.SDK_INT < 24) {
                return false;
            }
            return this.mContext.getPackageManager().hasSystemFeature(str);
        } catch (Throwable unused) {
            return false;
        }
    }
}
