package com.tencent.turingface.sdk.mfa;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class j {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final int f382527a;

    /* renamed from: b, reason: collision with root package name */
    public final int f382528b;

    /* renamed from: c, reason: collision with root package name */
    public final int f382529c;

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f382530d;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f382531a;

        /* renamed from: b, reason: collision with root package name */
        public int f382532b;

        /* renamed from: c, reason: collision with root package name */
        public int f382533c;

        /* renamed from: d, reason: collision with root package name */
        public byte[] f382534d;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f382531a = 0;
            this.f382532b = 0;
            this.f382533c = 0;
            this.f382534d = new byte[0];
        }
    }

    public j(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
            return;
        }
        this.f382527a = aVar.f382531a;
        this.f382528b = aVar.f382532b;
        this.f382529c = aVar.f382533c;
        this.f382530d = aVar.f382534d;
    }

    public static j a(int i3) {
        a aVar = new a();
        aVar.f382531a = i3;
        return new j(aVar);
    }

    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? this.f382527a == 0 : ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
    }
}
