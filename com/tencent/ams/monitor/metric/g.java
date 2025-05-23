package com.tencent.ams.monitor.metric;

import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private d f70584a;

    public g(WeakReference<j> weakReference) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) weakReference);
        } else {
            this.f70584a = new d(weakReference);
        }
    }

    private Uri a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return Uri.parse(str);
        } catch (Throwable th5) {
            this.f70584a.d("AdMetricUriHelper", "parse", th5);
            return null;
        }
    }

    private String c(String str, String str2, String str3) {
        Uri a16;
        Uri.Builder buildUpon;
        Uri.Builder scheme;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || (a16 = a(str)) == null || !str2.equalsIgnoreCase(a16.getScheme()) || (buildUpon = a16.buildUpon()) == null || (scheme = buildUpon.scheme(str3)) == null) {
            return str;
        }
        return scheme.toString();
    }

    public String b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        if (TextUtils.isEmpty(DeviceInfoMonitor.getModel()) || !DeviceInfoMonitor.getModel().toLowerCase().contains(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_VIVO) || !DeviceInfoMonitor.getModel().toLowerCase().contains("y67") || Build.VERSION.SDK_INT != 23) {
            return str;
        }
        return c(str, "https", "http");
    }
}
