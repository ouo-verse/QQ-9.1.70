package com.tencent.qqcamerakit.capture.camerastrategy;

import android.os.Build;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import java.util.Hashtable;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final String f344889a;

    /* renamed from: b, reason: collision with root package name */
    private static Hashtable<String, String> f344890b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11449);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f344889a = DeviceInfoMonitor.getModel();
            f344890b = c.f344891a;
        }
    }

    private static boolean a(String str, String str2) {
        boolean z16;
        if (str2 == null) {
            return false;
        }
        String[] split = str2.split("\\|");
        int length = split.length;
        int i3 = 0;
        while (true) {
            if (i3 < length) {
                if (split[i3].equalsIgnoreCase(str)) {
                    z16 = true;
                    break;
                }
                i3++;
            } else {
                z16 = false;
                break;
            }
        }
        if (com.tencent.qqcamerakit.common.e.f()) {
            com.tencent.qqcamerakit.common.e.a("CameraCompatible", 2, "isFound buildType:" + str + ", result:" + z16);
        }
        return z16;
    }

    public static boolean b(String str) {
        if (com.tencent.qqcamerakit.common.e.f()) {
            com.tencent.qqcamerakit.common.e.a("CameraCompatible", 2, "isFoundProduct key=" + str);
        }
        return a(f344889a, f344890b.get(str));
    }

    public static boolean c(String str) {
        if (com.tencent.qqcamerakit.common.e.f()) {
            com.tencent.qqcamerakit.common.e.a("CameraCompatible", 2, "isFoundProduct2 key=" + str);
        }
        return a(Build.MANUFACTURER + ";" + f344889a, f344890b.get(str));
    }

    public static boolean d(String str) {
        if (com.tencent.qqcamerakit.common.e.f()) {
            com.tencent.qqcamerakit.common.e.a("CameraCompatible", 2, "isFoundProductFeatureRom key=" + str);
        }
        Hashtable<String, String> hashtable = f344890b;
        if (hashtable == null) {
            return false;
        }
        return a(Build.MANUFACTURER + ";" + f344889a + ";" + Build.VERSION.SDK_INT + ";" + Build.ID, hashtable.get(str));
    }

    public static boolean e(String str) {
        if (com.tencent.qqcamerakit.common.e.f()) {
            com.tencent.qqcamerakit.common.e.a("CameraCompatible", 2, "isFoundProductFeatureRom2 key=" + str);
        }
        Hashtable<String, String> hashtable = f344890b;
        if (hashtable == null) {
            return false;
        }
        return a(Build.MANUFACTURER + ";" + f344889a + ";" + Build.VERSION.SDK_INT, hashtable.get(str));
    }
}
