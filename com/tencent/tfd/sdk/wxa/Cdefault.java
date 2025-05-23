package com.tencent.tfd.sdk.wxa;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* renamed from: com.tencent.tfd.sdk.wxa.default, reason: invalid class name */
/* loaded from: classes26.dex */
public final class Cdefault {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static Map<Integer, Long> f375755a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62821);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            f375755a = new HashMap();
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.HashMap, java.util.Map<java.lang.Integer, java.lang.Long>] */
    public static void a(int i3, long j3) {
        f375755a.put(Integer.valueOf(i3), Long.valueOf(j3));
    }
}
