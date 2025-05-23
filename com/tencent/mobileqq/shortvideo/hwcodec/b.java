package com.tencent.mobileqq.shortvideo.hwcodec;

import android.os.Build;
import com.tencent.aelight.camera.api.ICameraCompatible;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static int f288003a = 1500;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f288004b = false;

    public static boolean a() {
        if (QLog.isColorLevel()) {
            QLog.d("HwEnvData", 2, "[@] supportHardWareCodec:SDK_INT=" + Build.VERSION.SDK_INT + "dpcSupportHwCodec=" + f288004b);
        }
        boolean isFoundProductFeature = ((ICameraCompatible) QRoute.api(ICameraCompatible.class)).isFoundProductFeature(com.tencent.aelight.camera.constants.a.f69004r);
        if (isFoundProductFeature) {
            if (QLog.isColorLevel()) {
                QLog.d("HwEnvData", 2, "[@] supportHardWareCodec:black=" + isFoundProductFeature);
                return false;
            }
            return false;
        }
        return f288004b;
    }
}
