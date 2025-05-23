package com.tencent.paysdk.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.paysdk.api.r;
import com.tencent.paysdk.util.ListenerMgr;

/* compiled from: P */
/* loaded from: classes22.dex */
public class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static ListenerMgr<r> f342091a;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a implements ListenerMgr.a<r> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f342092a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f342093b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f342094c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f342095d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f342096e;

        a(int i3, String str, String str2, String str3, String str4) {
            this.f342092a = i3;
            this.f342093b = str;
            this.f342094c = str2;
            this.f342095d = str3;
            this.f342096e = str4;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), str, str2, str3, str4);
            }
        }

        @Override // com.tencent.paysdk.util.ListenerMgr.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNotify(r rVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) rVar);
            } else {
                rVar.Jd(this.f342092a, this.f342093b, this.f342094c, this.f342095d, this.f342096e);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(8394);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f342091a = new ListenerMgr<>();
        }
    }

    public static void a(int i3, String str, String str2, String str3, String str4) {
        f342091a.b(new a(i3, str, str2, str3, str4));
    }

    public static void b(r rVar) {
        f342091a.a(rVar);
    }

    public static void c(r rVar) {
        f342091a.c(rVar);
    }
}
