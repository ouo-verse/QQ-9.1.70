package com.tencent.mobileqq.imcore.proxy.basic;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static a f238021a;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface a {
        boolean a();
    }

    public static boolean a() {
        a aVar = f238021a;
        if (aVar != null) {
            return aVar.a();
        }
        return false;
    }

    public static void b(a aVar) {
        f238021a = aVar;
    }
}
