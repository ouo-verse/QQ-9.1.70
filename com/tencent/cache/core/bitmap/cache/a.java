package com.tencent.cache.core.bitmap.cache;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes5.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final a f98655a;

    /* renamed from: b, reason: collision with root package name */
    public static final a f98656b;

    /* renamed from: c, reason: collision with root package name */
    public static final a f98657c;

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ a[] f98658d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13534);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        a aVar = new a("UnInited", 0);
        f98655a = aVar;
        a aVar2 = new a("Attached", 1);
        f98656b = aVar2;
        a aVar3 = new a("Detached", 2);
        f98657c = aVar3;
        f98658d = new a[]{aVar, aVar2, aVar3};
    }

    public a(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, i3);
        }
    }

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) f98658d.clone();
    }
}
