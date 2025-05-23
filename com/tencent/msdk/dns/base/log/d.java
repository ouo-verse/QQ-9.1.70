package com.tencent.msdk.dns.base.log;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes21.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final List<a> f336215a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16359);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        ArrayList arrayList = new ArrayList();
        f336215a = arrayList;
        arrayList.add(new b());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(int i3, String str, String str2, Throwable th5) {
        Iterator<a> it = f336215a.iterator();
        while (it.hasNext()) {
            it.next().a(i3, str, str2, th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void b(a aVar) {
        synchronized (d.class) {
            if (aVar != null) {
                f336215a.add(aVar);
            }
        }
    }
}
