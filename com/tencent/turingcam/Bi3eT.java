package com.tencent.turingcam;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Bi3eT {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static Map<Integer, Long> f381729a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12518);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            f381729a = new HashMap();
        }
    }

    public static void a(int i3, long j3) {
        ((HashMap) f381729a).put(Integer.valueOf(i3), Long.valueOf(j3));
    }
}
