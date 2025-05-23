package com.tencent.mobileqq.imcore.proxy.msg;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.text.AbsQQText;

/* compiled from: P */
/* loaded from: classes15.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static a f238042a;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface a {
        AbsQQText a(CharSequence charSequence, int i3, int i16);
    }

    public static AbsQQText a(CharSequence charSequence, int i3, int i16) {
        a aVar = f238042a;
        if (aVar != null) {
            return aVar.a(charSequence, i3, i16);
        }
        return null;
    }

    public static void b(a aVar) {
        f238042a = aVar;
    }
}
