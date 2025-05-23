package com.tencent.tgpa.lite.b;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes26.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    public static final b f375908b;

    /* renamed from: c, reason: collision with root package name */
    public static final b f375909c;

    /* renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ b[] f375910d;

    /* renamed from: a, reason: collision with root package name */
    private String f375911a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14873);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        b bVar = new b("VMP_INIT", 0, "TGPA_INIT");
        f375908b = bVar;
        b bVar2 = new b("VMP_REPORT_UNIQUE_ID", 1, "TGPA_UNIQUEID");
        f375909c = bVar2;
        f375910d = new b[]{bVar, bVar2};
    }

    b(String str, int i3, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), str2);
        } else {
            this.f375911a = str2;
        }
    }

    public static b valueOf(String str) {
        return (b) Enum.valueOf(b.class, str);
    }

    public static b[] values() {
        return (b[]) f375910d.clone();
    }

    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f375911a;
    }
}
