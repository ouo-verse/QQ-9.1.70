package com.tencent.mobileqq.camera.adapter;

import android.os.Build;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mapsdk.internal.ky;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.slf4j.Marker;

/* compiled from: P */
/* loaded from: classes11.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private static String f201018b;

    /* renamed from: c, reason: collision with root package name */
    private static final String[] f201019c;

    /* renamed from: d, reason: collision with root package name */
    private static final String[] f201020d;

    /* renamed from: e, reason: collision with root package name */
    private static final b f201021e;

    /* renamed from: a, reason: collision with root package name */
    private HashMap<String, String> f201022a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(71190);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        f201018b = b.class.getSimpleName();
        f201019c = new String[]{"motorola", "mot", "FIH", CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_SONY, CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_SANXING, "HTC", "HUN", "LGE", "alps", "OPPO", ky.f149095a, "LENOVO", "ZTE", CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_MEIZU, CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_XIAOMI, "HUAWEI", "TIANYU", "sprd", "K-Touch", "YuLong", "CoolPad", "Amazon", "Hisense", "Acer", "GIONEE", "Philips", CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_ASUS, "snda.com", "koobee", "AMOI", "Fason", "ainol", "Dell", "dlkjl12389", "haier", "sharp", "BBK", CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_NUBIA, "KONKA"};
        f201020d = new String[]{"MOTOROLA", "MOTOROLA", "MOTOROLA", "SONYERICSSON", "SAMSUNG", "HTC", "HTC", "LG", "OPPO", "OPPO", ky.f149095a, "LENOVO", "ZTE", "MEIZU", "XIAOMI", "HUAWEI", "TIANYU", "TIANYU", "TIANYU", "COOLPAD", "COOLPAD", "AMAZON", "HISENSE", "ACER", "JINLI", "PHILIPS", "GOOGLE", "SHENGDA", "KUBI", "XIAXIN", "FANSHANG", "AINUO", "DELL", "DPD", "HAIER", "SHARP", "BBK", "NUBIA", "KONKA"};
        f201021e = new b();
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f201022a = new HashMap<>();
        int i3 = 0;
        while (true) {
            String[] strArr = f201019c;
            if (i3 < strArr.length) {
                this.f201022a.put(strArr[i3].toUpperCase(), f201020d[i3]);
                i3++;
            } else {
                d();
                return;
            }
        }
    }

    public static b c() {
        return f201021e;
    }

    private void d() {
        if (QLog.isColorLevel()) {
            QLog.i(f201018b, 2, "****** DeviceInfo  (+) *****");
            QLog.i(f201018b, 2, "BRAND_KEYS.len = " + f201019c.length);
            QLog.i(f201018b, 2, "BRAND_NAMES.len = " + f201020d.length);
            QLog.i(f201018b, 2, "DeviceTypeName = " + b());
            String str = f201018b;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("SubTagName = ");
            sb5.append(b());
            sb5.append("_");
            String str2 = Build.DISPLAY;
            sb5.append(str2.replace(" ", "_").toUpperCase());
            QLog.i(str, 2, sb5.toString());
            QLog.i(f201018b, 2, "MODEL = " + DeviceInfoMonitor.getModel());
            QLog.i(f201018b, 2, "SDK_INT = " + Build.VERSION.SDK_INT);
            QLog.i(f201018b, 2, "BRAND = " + Build.BRAND);
            QLog.i(f201018b, 2, "DEVICE = " + Build.DEVICE);
            QLog.i(f201018b, 2, "DISPLAY = " + str2);
            QLog.i(f201018b, 2, "HARDWARE = " + Build.HARDWARE);
            QLog.i(f201018b, 2, "MANUFACTURER = " + Build.MANUFACTURER);
            QLog.i(f201018b, 2, "PRODUCT = " + Build.PRODUCT);
            QLog.i(f201018b, 2, "TAGS = " + Build.TAGS);
            QLog.i(f201018b, 2, "USER = " + Build.USER);
            QLog.i(f201018b, 2, "TYPE = " + Build.TYPE);
            QLog.i(f201018b, 2, "****** DeviceInfo (-) *****");
        }
    }

    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return b() + "_" + Build.DISPLAY.replace(" ", "_").toUpperCase();
    }

    public String b() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        if (DeviceInfoMonitor.getModel().equalsIgnoreCase("K-Touch W619")) {
            str = this.f201022a.get("TIANYU") + " " + DeviceInfoMonitor.getModel();
        } else if (DeviceInfoMonitor.getModel().equalsIgnoreCase("8150") && Build.BRAND.equalsIgnoreCase("COOLPAD")) {
            str = this.f201022a.get("COOLPAD") + " " + DeviceInfoMonitor.getModel();
        } else {
            str = this.f201022a.get(Build.MANUFACTURER.toUpperCase()) + " " + DeviceInfoMonitor.getModel();
        }
        return str.replace(" ", "_").replace(Marker.ANY_NON_NULL_MARKER, "").replace("(t)", "");
    }
}
