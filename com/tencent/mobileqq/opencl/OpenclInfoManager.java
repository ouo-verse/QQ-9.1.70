package com.tencent.mobileqq.opencl;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
public class OpenclInfoManager {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static String f256975a;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f256976b;

    /* renamed from: c, reason: collision with root package name */
    private static String f256977c;

    /* renamed from: d, reason: collision with root package name */
    private static Object f256978d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42644);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
            return;
        }
        f256975a = "OpenclInfoManager";
        f256976b = false;
        f256977c = null;
        f256978d = new Object();
        c();
    }

    public OpenclInfoManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private String b() {
        return MobileQQ.sMobileQQ.getSharedPreferences("qmcf_gpu_config", 4).getString("param_ocl_gpuinfo", "");
    }

    public static void c() {
        try {
            System.loadLibrary("oclInfo");
            f256976b = true;
        } catch (UnsatisfiedLinkError e16) {
            System.out.println(e16);
        }
    }

    private void d(String str) {
        if (!TextUtils.isEmpty(str) && !str.startsWith(NotificationCompat.CATEGORY_ERROR)) {
            SharedPreferences.Editor edit = MobileQQ.sMobileQQ.getSharedPreferences("qmcf_gpu_config", 4).edit();
            edit.putString("param_ocl_gpuinfo", str);
            edit.commit();
            if (QLog.isColorLevel()) {
                QLog.i(f256975a, 2, "saveOclGpuInfo:" + str);
            }
        }
    }

    private native String nativeGetOclVersion();

    private native String nativeGetPlatformName();

    private native int nativeGetSupportedType();

    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        synchronized (f256978d) {
            if (!TextUtils.isEmpty(f256977c)) {
                return f256977c;
            }
            String b16 = b();
            f256977c = b16;
            if (TextUtils.isEmpty(b16)) {
                try {
                    String nativeGetGPUInfo = nativeGetGPUInfo();
                    f256977c = nativeGetGPUInfo;
                    d(nativeGetGPUInfo);
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d(f256975a, 2, "getGPUInfo exception!", e16);
                    }
                } catch (UnsatisfiedLinkError unused) {
                    if (QLog.isColorLevel()) {
                        QLog.d(f256975a, 2, "getGPUInfo UnsatisfiedLinkError!");
                    }
                }
            }
            return f256977c;
        }
    }

    public native String nativeGetGPUInfo();

    public native int nativeGetGPUUnit();
}
