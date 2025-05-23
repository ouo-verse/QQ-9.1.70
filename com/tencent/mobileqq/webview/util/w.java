package com.tencent.mobileqq.webview.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.HashSet;

/* compiled from: P */
/* loaded from: classes20.dex */
public class w {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static long f314884a;

    /* renamed from: b, reason: collision with root package name */
    public static final HashSet<String> f314885b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49593);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        HashSet<String> hashSet = new HashSet<>();
        f314885b = hashSet;
        hashSet.add("Meizu_M040");
        hashSet.add("YuLong_Coolpad8720Q");
        hashSet.add("YuLong_Coolpad 7269");
        hashSet.add("samsung_SM-G9006W");
    }

    public static boolean a(long j3) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - f314884a > j3) {
            f314884a = currentTimeMillis;
            return true;
        }
        return false;
    }
}
