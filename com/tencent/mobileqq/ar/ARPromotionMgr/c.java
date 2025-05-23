package com.tencent.mobileqq.ar.ARPromotionMgr;

import android.text.TextUtils;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.utils.m;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    static final String f196936a = f.f196950a;

    /* renamed from: b, reason: collision with root package name */
    static int f196937b = -1;

    /* renamed from: c, reason: collision with root package name */
    static int f196938c = -1;

    public static boolean a() {
        if (c() && b() && d()) {
            return true;
        }
        return false;
    }

    public static boolean b() {
        if (f196938c == -1) {
            String featureValueWithoutAccountManager = ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValueWithoutAccountManager(DPCNames.ARCfg.name());
            if (!TextUtils.isEmpty(featureValueWithoutAccountManager)) {
                String[] strArr = new String[13];
                int parseComplexParamsBySimpleStringParser = ((IDPCApi) QRoute.api(IDPCApi.class)).parseComplexParamsBySimpleStringParser(featureValueWithoutAccountManager, strArr);
                String str = strArr[12];
                boolean z16 = !TextUtils.equals(str, "1");
                f196938c = z16 ? 1 : 0;
                QLog.w(f196936a, 1, "isEnableInDPC, isEnable[" + z16 + "], arCfg[" + featureValueWithoutAccountManager + "], size[" + parseComplexParamsBySimpleStringParser + "], params[" + str + "]");
            } else {
                QLog.w(f196936a, 1, "isEnableInDPC, \u6ca1\u62c9\u5230dpc\u914d\u7f6e");
                return true;
            }
        }
        if (f196938c == 1) {
            return true;
        }
        return false;
    }

    public static boolean c() {
        boolean z16;
        int i3;
        if (f196937b == -1) {
            if (!e(8, 1367L, 2800000000L, 15) && !e(4, 2099L, 2800000000L, 15)) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            f196937b = i3;
            QLog.w(f196936a, 1, "isDevicesSupport, DeviceSupportFromLocal[" + f196937b + "]");
        }
        if (f196937b != 1) {
            return false;
        }
        return true;
    }

    public static boolean d() {
        if (!DeviceInfoMonitor.getModel().equalsIgnoreCase("ATH-AL00") && !DeviceInfoMonitor.getModel().equalsIgnoreCase("BND-AL10") && !DeviceInfoMonitor.getModel().equalsIgnoreCase("ASK-AL00x") && !DeviceInfoMonitor.getModel().equalsIgnoreCase("vivo X6S A")) {
            return true;
        }
        return false;
    }

    public static boolean e(int i3, long j3, long j16, int i16) {
        int K = ah.K();
        if (K < i16) {
            QLog.w(f196936a, 1, "isSupportOfDevice, error OSversion[" + i16 + "->" + K + "]");
            return false;
        }
        int n3 = ah.n();
        if (n3 < i3) {
            QLog.w(f196936a, 1, "isSupportOfDevice, error cpucount[" + i3 + "->" + n3 + "]");
            return false;
        }
        long l3 = ah.l();
        if (l3 < j3) {
            QLog.w(f196936a, 1, "isSupportOfDevice, error cpuFrequency[" + j3 + "->" + l3 + "]");
            return false;
        }
        long c16 = m.c();
        if (c16 >= j16) {
            return true;
        }
        QLog.w(f196936a, 1, "isSupportOfDevice, error memory[" + j16 + "->" + c16 + "]");
        return false;
    }
}
