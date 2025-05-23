package com.tencent.mobileqq.login;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class ay extends l {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    public String f241929f;

    /* renamed from: g, reason: collision with root package name */
    public String f241930g;

    /* renamed from: h, reason: collision with root package name */
    public String f241931h;

    /* renamed from: i, reason: collision with root package name */
    public byte[] f241932i;

    /* renamed from: j, reason: collision with root package name */
    public byte[] f241933j;

    /* renamed from: k, reason: collision with root package name */
    public String f241934k;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private final int f241935a;

        /* renamed from: b, reason: collision with root package name */
        private final String f241936b;

        /* renamed from: c, reason: collision with root package name */
        private final String f241937c;

        /* renamed from: d, reason: collision with root package name */
        private final byte[] f241938d;

        /* renamed from: e, reason: collision with root package name */
        private String f241939e;

        /* renamed from: f, reason: collision with root package name */
        private byte[] f241940f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f241941g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f241942h;

        /* renamed from: i, reason: collision with root package name */
        private String f241943i;

        /* renamed from: j, reason: collision with root package name */
        private boolean f241944j;

        public a(String str, String str2, byte[] bArr, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, str2, bArr, Integer.valueOf(i3));
                return;
            }
            this.f241936b = str;
            this.f241937c = str2;
            this.f241938d = bArr;
            this.f241935a = i3;
        }

        public ay k() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (ay) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            return new ay(this);
        }

        public a l(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (a) iPatchRedirector.redirect((short) 5, (Object) this, z16);
            }
            this.f241942h = z16;
            return this;
        }

        public a m(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (a) iPatchRedirector.redirect((short) 4, (Object) this, z16);
            }
            this.f241941g = z16;
            return this;
        }

        public a n(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (a) iPatchRedirector.redirect((short) 7, (Object) this, z16);
            }
            this.f241944j = z16;
            return this;
        }

        public a o(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (a) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            }
            this.f241943i = str;
            return this;
        }

        public a p(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (a) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            }
            this.f241939e = str;
            return this;
        }
    }

    ay(a aVar) {
        super(7, aVar.f241935a);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
            return;
        }
        this.f242204e = aVar.f241944j;
        this.f241929f = aVar.f241936b;
        this.f241931h = aVar.f241939e;
        this.f241932i = aVar.f241938d;
        this.f241933j = aVar.f241940f;
        this.f241930g = aVar.f241937c;
        this.f242202c = aVar.f241941g;
        this.f242203d = aVar.f241942h;
        this.f241934k = aVar.f241943i;
    }
}
