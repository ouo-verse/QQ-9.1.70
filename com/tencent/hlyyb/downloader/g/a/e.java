package com.tencent.hlyyb.downloader.g.a;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import cooperation.qzone.api.QZoneContant;

/* compiled from: P */
/* loaded from: classes7.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static String f114670a;

    /* renamed from: b, reason: collision with root package name */
    public static String f114671b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(QZoneContant.QZ_SEARCH_LOCAL_REQUEST_CODE);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        }
    }

    public static String a() {
        if (!TextUtils.isEmpty(f114670a)) {
            return f114670a;
        }
        try {
            String lowerCase = Build.BRAND.toLowerCase();
            f114670a = lowerCase;
            return lowerCase;
        } catch (Throwable unused) {
            return f114670a;
        }
    }

    public static String b() {
        if (!TextUtils.isEmpty(f114671b)) {
            return f114671b;
        }
        try {
            String model = DeviceInfoMonitor.getModel();
            f114671b = model;
            return model;
        } catch (Throwable unused) {
            return f114671b;
        }
    }
}
