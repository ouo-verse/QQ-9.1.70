package com.tencent.tfd.sdk.wxa;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class Lynx {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final List<String> f375654a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62685);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            f375654a = new ArrayList();
        }
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.List<java.lang.String>, java.util.ArrayList] */
    public static synchronized List<String> a(ITuringPkgProvider iTuringPkgProvider) {
        ?? r16;
        List<String> pkgs;
        synchronized (Lynx.class) {
            r16 = f375654a;
            if (r16.isEmpty() && iTuringPkgProvider != null && (pkgs = iTuringPkgProvider.getPkgs()) != null && !pkgs.isEmpty()) {
                r16.addAll(pkgs);
            }
        }
        return r16;
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
