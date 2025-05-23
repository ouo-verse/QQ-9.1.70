package com.tencent.mobileqq.imcore.proxy.basic;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static a f238022a;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface a {
        String a(StringBuffer stringBuffer, long j3, boolean z16, String str, boolean z17);
    }

    public static String a(StringBuffer stringBuffer, long j3, boolean z16, String str, boolean z17) {
        a aVar = f238022a;
        if (aVar != null) {
            return aVar.a(stringBuffer, j3, z16, str, z17);
        }
        return null;
    }

    public static void b(a aVar) {
        f238022a = aVar;
    }
}
