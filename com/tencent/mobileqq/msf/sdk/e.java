package com.tencent.mobileqq.msf.sdk;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes15.dex */
public final class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final e f250536a;

    /* renamed from: b, reason: collision with root package name */
    public static final e f250537b;

    /* renamed from: c, reason: collision with root package name */
    public static final e f250538c;

    /* renamed from: d, reason: collision with root package name */
    public static final e f250539d;

    /* renamed from: e, reason: collision with root package name */
    public static final e f250540e;

    /* renamed from: f, reason: collision with root package name */
    private static final /* synthetic */ e[] f250541f;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19551);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        e eVar = new e("qzone", 0);
        f250536a = eVar;
        e eVar2 = new e("picture", 1);
        f250537b = eVar2;
        e eVar3 = new e("peak", 2);
        f250538c = eVar3;
        e eVar4 = new e("LongConn", 3);
        f250539d = eVar4;
        e eVar5 = new e("ImgStore", 4);
        f250540e = eVar5;
        f250541f = new e[]{eVar, eVar2, eVar3, eVar4, eVar5};
    }

    e(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static e a(String str) {
        return (e) Enum.valueOf(e.class, str);
    }

    public static e[] values() {
        return (e[]) f250541f.clone();
    }
}
