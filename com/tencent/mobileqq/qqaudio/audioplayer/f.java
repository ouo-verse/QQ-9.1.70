package com.tencent.mobileqq.qqaudio.audioplayer;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.av.so.ResInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes16.dex */
public class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static int f262189a;

    /* renamed from: b, reason: collision with root package name */
    private static a[] f262190b;

    /* renamed from: c, reason: collision with root package name */
    private static String f262191c;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f262192a;

        /* renamed from: b, reason: collision with root package name */
        public int f262193b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f262194c;

        public a(int i3, int i16, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16));
                return;
            }
            this.f262193b = i3;
            this.f262192a = i16;
            this.f262194c = z16;
        }

        public boolean equals(Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, obj)).booleanValue();
            }
            if (obj == this) {
                return true;
            }
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (aVar.f262193b == this.f262193b && aVar.f262192a == this.f262192a && aVar.f262194c == this.f262194c) {
                return true;
            }
            return false;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36994);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f262189a = 1000;
        f262190b = null;
        f262191c = null;
    }

    public static synchronized a[] a() {
        a[] aVarArr;
        synchronized (f.class) {
            if (f262190b == null) {
                a[] aVarArr2 = new a[5];
                f262190b = aVarArr2;
                aVarArr2[0] = e(0);
                f262190b[1] = e(1);
                f262190b[2] = e(2);
                f262190b[3] = e(3);
                f262190b[4] = e(4);
            }
            aVarArr = f262190b;
        }
        return aVarArr;
    }

    private static a b(int i3, a aVar) {
        a aVar2 = new a(aVar.f262193b, aVar.f262192a, aVar.f262194c);
        String str = f262191c;
        if (QLog.isColorLevel()) {
            QLog.d("AudioPlayerHelper", 2, "getDPCFixConfig | dpcConfig = " + str);
        }
        if (!TextUtils.isEmpty(str) && str.length() > 1) {
            try {
                String[] split = str.split("\\|");
                if (i3 == 0) {
                    if (!"-1".equals(split[0])) {
                        aVar2.f262192a = Integer.parseInt(split[0]);
                    }
                    if (!"-1".equals(split[1])) {
                        aVar2.f262193b = Integer.parseInt(split[1]);
                    }
                } else if (i3 == 1) {
                    if (!"-1".equals(split[2])) {
                        aVar2.f262192a = Integer.parseInt(split[2]);
                    }
                    if (!"-1".equals(split[3])) {
                        aVar2.f262193b = Integer.parseInt(split[3]);
                    }
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("AudioPlayerHelper", 2, "getDPCFixConfig error.", e16);
                }
            }
        }
        return aVar2;
    }

    @TargetApi(11)
    public static a c() {
        if (h()) {
            return new a(0, 0, false);
        }
        if (n()) {
            return new a(0, 0, false);
        }
        if (o()) {
            return new a(0, 0, false);
        }
        if (l()) {
            return new a(0, 0, false);
        }
        if (i()) {
            return new a(0, 0, false);
        }
        if (m()) {
            return new a(0, 0, false);
        }
        if (!j() && !t()) {
            if (q()) {
                return new a(0, 2, false);
            }
            if (s()) {
                return new a(0, 2, false);
            }
            if (p()) {
                return new a(3, 3, false);
            }
            if (r()) {
                return new a(0, 0, false);
            }
            return new a(0, 3, false);
        }
        return new a(0, 0, false);
    }

    public static a d() {
        if (k() && AudioDeviceHelperKt.f262108a.b()) {
            return new a(0, 0, true);
        }
        return new a(3, 0, true);
    }

    private static a e(int i3) {
        a f16;
        if (i3 == 0) {
            f16 = d();
        } else if (i3 == 1) {
            f16 = c();
        } else if (i3 == 2) {
            f16 = d();
            f16.f262194c = false;
        } else if (i3 == 3) {
            f16 = d();
            f16.f262194c = false;
        } else {
            f16 = f();
            f16.f262194c = false;
        }
        String str = "!@$#_" + i3 + "_";
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
        f16.f262192a = defaultSharedPreferences.getInt(str + QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, f16.f262192a);
        f16.f262193b = defaultSharedPreferences.getInt(str + ReportConstant.COSTREPORT_PREFIX, f16.f262193b);
        f16.f262194c = defaultSharedPreferences.getBoolean(str + ResInfo.RES_TYPE_SO, f16.f262194c);
        return b(i3, f16);
    }

    public static a f() {
        return new a(0, 2, true);
    }

    public static boolean g() {
        if (!ah.l0() && !ah.j0()) {
            return false;
        }
        return true;
    }

    private static boolean h() {
        DeviceInfoMonitor.getModel().contains("ME860");
        return false;
    }

    private static boolean i() {
        return DeviceInfoMonitor.getModel().contains("5910");
    }

    public static boolean j() {
        return DeviceInfoMonitor.getModel().contains("Lenovo K900");
    }

    private static boolean k() {
        boolean z16;
        String model = DeviceInfoMonitor.getModel();
        if (!Build.MANUFACTURER.equalsIgnoreCase("Samsung") && !model.contains("MI 2") && !model.contains("Nexus 4")) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return true;
        }
        model.contains("SCH-I699");
        return false;
    }

    private static boolean l() {
        DeviceInfoMonitor.getModel().contains("ZTE-T U960s");
        return false;
    }

    private static boolean m() {
        return DeviceInfoMonitor.getModel().contains("V926");
    }

    private static boolean n() {
        DeviceInfoMonitor.getModel().contains("HUAWEI Y 200T");
        return false;
    }

    private static boolean o() {
        DeviceInfoMonitor.getModel().contains("Lenovo A278t");
        return false;
    }

    private static boolean p() {
        return DeviceInfoMonitor.getModel().contains("Coolpad 5891Q");
    }

    private static boolean q() {
        return DeviceInfoMonitor.getModel().contains("ZTE N881E");
    }

    private static boolean r() {
        return DeviceInfoMonitor.getModel().contains("GT-S7500");
    }

    private static boolean s() {
        return DeviceInfoMonitor.getModel().contains("LNV-Lenovo S870e");
    }

    private static boolean t() {
        return DeviceInfoMonitor.getModel().contains("vivo X9");
    }

    public static void u(String str) {
        f262191c = str;
    }
}
