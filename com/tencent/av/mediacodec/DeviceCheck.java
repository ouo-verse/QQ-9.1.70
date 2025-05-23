package com.tencent.av.mediacodec;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import com.tencent.av.config.api.ICodecConfigParser;
import com.tencent.av.config.api.IConfigParser;
import com.tencent.avcore.jni.codec.DeviceCheckHelper;
import com.tencent.avcore.jni.codec.HWCodecAbility;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import du.a;

/* compiled from: P */
@SuppressLint({"NewApi"})
/* loaded from: classes3.dex */
public class DeviceCheck implements Runnable {
    public static boolean e() {
        return false;
    }

    public static boolean f() {
        return false;
    }

    @SuppressLint({"NewApi"})
    @TargetApi(16)
    public static boolean g() {
        return DeviceCheckHelper.isAVCDecSupportColorformats();
    }

    public static boolean h() {
        return DeviceCheckHelper.isAVCDecWhitelistDevices();
    }

    @SuppressLint({"NewApi"})
    @TargetApi(16)
    public static boolean i() {
        return DeviceCheckHelper.isAVCEncSupportColorformats();
    }

    public static boolean j() {
        return DeviceCheckHelper.isAVCEncWhitelistDevices();
    }

    @SuppressLint({"NewApi"})
    @TargetApi(16)
    public static boolean k() {
        return DeviceCheckHelper.isHevcDecSupportColorformats();
    }

    @SuppressLint({"NewApi"})
    @TargetApi(16)
    public static boolean l() {
        return DeviceCheckHelper.isHevcEncSupportColorformats();
    }

    public static boolean m() {
        if (f() || e()) {
            return false;
        }
        IConfigParser b16 = a.b(BaseApplication.getContext());
        ICodecConfigParser iCodecConfigParser = (ICodecConfigParser) QRoute.api(ICodecConfigParser.class);
        iCodecConfigParser.init(b16);
        HWCodecAbility aVCEncoderAbility = iCodecConfigParser.getAVCEncoderAbility();
        HWCodecAbility aVCDecoderAbility = iCodecConfigParser.getAVCDecoderAbility();
        if (aVCEncoderAbility == null || !aVCEncoderAbility.isHWCodec || !iCodecConfigParser.isEnableAsyncApi(2) || aVCDecoderAbility == null || !aVCDecoderAbility.isHWCodec || !iCodecConfigParser.isEnableAsyncApi(1)) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("DeviceCheck", 2, "SUPPORT Async API");
        }
        return true;
    }

    @Override // java.lang.Runnable
    public void run() {
    }
}
