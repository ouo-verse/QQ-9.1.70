package com.tencent.turingcam;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.turingface.sdk.mfa.f;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes27.dex */
public class OCkqn {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final List<String> f381959a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18453);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            f381959a = new ArrayList();
        }
    }

    public static synchronized List<String> a(f fVar) {
        List<String> list;
        synchronized (OCkqn.class) {
            list = f381959a;
            ((ArrayList) list).isEmpty();
        }
        return list;
    }

    public static String a(Set<String> set) {
        StringBuilder sb5 = new StringBuilder();
        try {
            for (String str : set) {
                if (sb5.length() > 0) {
                    sb5.append("|");
                }
                sb5.append(str);
            }
        } catch (Throwable unused) {
        }
        return sb5.toString();
    }
}
