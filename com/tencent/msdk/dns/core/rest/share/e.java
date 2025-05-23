package com.tencent.msdk.dns.core.rest.share;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final List<com.tencent.msdk.dns.core.d> f336364a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17369);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            f336364a = new Vector();
        }
    }

    public static List<com.tencent.msdk.dns.core.d> a() {
        List<com.tencent.msdk.dns.core.d> arrayList;
        List<com.tencent.msdk.dns.core.d> list = f336364a;
        synchronized (list) {
            if (list.isEmpty()) {
                arrayList = Collections.emptyList();
            } else {
                arrayList = new ArrayList<>(list);
                list.clear();
            }
        }
        return arrayList;
    }

    public static void b(com.tencent.msdk.dns.core.d dVar) {
        f336364a.add(dVar);
    }
}
