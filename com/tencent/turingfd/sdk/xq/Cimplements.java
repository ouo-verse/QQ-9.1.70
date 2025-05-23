package com.tencent.turingfd.sdk.xq;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* renamed from: com.tencent.turingfd.sdk.xq.implements, reason: invalid class name */
/* loaded from: classes27.dex */
public class Cimplements {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static Map<Integer, Long> f383368a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13634);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            f383368a = new HashMap();
        }
    }

    public static void a(int i3, long j3) {
        ((HashMap) f383368a).put(Integer.valueOf(i3), Long.valueOf(j3));
    }
}
