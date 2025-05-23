package com.tencent.turingfd.sdk.xq;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Cantaloupe {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final List<String> f382636a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11043);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            f382636a = new ArrayList();
        }
    }

    public static synchronized List<String> a(ITuringPkgProvider iTuringPkgProvider) {
        List<String> list;
        List<String> pkgs;
        synchronized (Cantaloupe.class) {
            list = f382636a;
            if (((ArrayList) list).isEmpty() && iTuringPkgProvider != null && (pkgs = iTuringPkgProvider.getPkgs()) != null && !pkgs.isEmpty()) {
                ((ArrayList) list).addAll(pkgs);
            }
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
