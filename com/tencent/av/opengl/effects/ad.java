package com.tencent.av.opengl.effects;

import android.os.Build;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ad {

    /* renamed from: a, reason: collision with root package name */
    static int f73928a = -1;

    /* renamed from: b, reason: collision with root package name */
    private static Boolean f73929b;

    public static int a(boolean z16) {
        if (f73928a == -1) {
            mv.a a16 = mv.a.a();
            if ((a16 != null && a16.c()) || b()) {
                f73928a = 1;
            } else {
                f73928a = 0;
            }
            QLog.i("Render", 1, "getFrameAngle, mInversion[" + f73928a + "], manufacture[" + Build.MANUFACTURER + "], model[" + DeviceInfoMonitor.getModel() + "]");
        }
        if (!z16 || f73928a == 1) {
            return 1;
        }
        return 3;
    }

    private static boolean b() {
        if (f73929b == null) {
            String str = null;
            try {
                str = ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.isInversionWhenFaceDetect.name(), "0");
                if ("1".equals(str)) {
                    f73929b = Boolean.TRUE;
                } else if ("HUAWEI".equalsIgnoreCase(Build.MANUFACTURER) && ("TAH-AN00".equalsIgnoreCase(DeviceInfoMonitor.getModel()) || "TAH-AN00m".equalsIgnoreCase(DeviceInfoMonitor.getModel()))) {
                    f73929b = Boolean.TRUE;
                } else {
                    f73929b = Boolean.FALSE;
                }
            } catch (Throwable th5) {
                QLog.i("Render", 1, "isSpecialDevices", th5);
            }
            QLog.i("Render", 1, "isSpecialDevices, [" + f73929b + "], manufacture[" + Build.MANUFACTURER + "], model[" + DeviceInfoMonitor.getModel() + "], dpcValue[" + str + "]");
        }
        return f73929b.booleanValue();
    }
}
