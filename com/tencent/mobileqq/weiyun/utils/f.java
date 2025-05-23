package com.tencent.mobileqq.weiyun.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.File;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes20.dex */
public class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static String f315302a;

    /* renamed from: b, reason: collision with root package name */
    private static String f315303b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21134);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f315302a = null;
            f315303b = null;
        }
    }

    public static String a() {
        String str = f315303b;
        if (str != null) {
            return str;
        }
        String str2 = d() + "Tencent/weiyun/";
        f315303b = str2;
        return str2;
    }

    public static String b(long j3) {
        return c(j3) + "disk_file_cache/";
    }

    private static String c(long j3) {
        return a() + j3 + "/";
    }

    public static String d() {
        String str = f315302a;
        if (str != null) {
            return str;
        }
        File externalFilesDir = MobileQQ.sMobileQQ.getExternalFilesDir(null);
        if (externalFilesDir == null) {
            externalFilesDir = MobileQQ.sMobileQQ.getFilesDir();
        }
        String absolutePath = externalFilesDir.getAbsolutePath();
        if (!absolutePath.endsWith("/")) {
            absolutePath = absolutePath + "/";
        }
        f315302a = absolutePath;
        return absolutePath;
    }
}
