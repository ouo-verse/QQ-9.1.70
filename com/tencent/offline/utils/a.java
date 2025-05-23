package com.tencent.offline.utils;

import android.os.StatFs;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static String f339495a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23271);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f339495a = "unknown_";
        }
    }

    public static long a(String str) {
        try {
            StatFs statFs = new StatFs(str);
            return statFs.getBlockSizeLong() * statFs.getAvailableBlocksLong();
        } catch (Exception e16) {
            e16.printStackTrace();
            return 0L;
        }
    }
}
