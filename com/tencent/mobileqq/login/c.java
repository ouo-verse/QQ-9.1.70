package com.tencent.mobileqq.login;

import android.os.Bundle;
import com.tencent.mobileqq.login.LoginReportConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import tencent.im.login.GatewayVerify$ReqBody;

/* compiled from: P */
/* loaded from: classes15.dex */
public class c extends l {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    public String f242042f;

    /* renamed from: g, reason: collision with root package name */
    public String f242043g;

    /* renamed from: h, reason: collision with root package name */
    public byte[] f242044h;

    /* renamed from: i, reason: collision with root package name */
    public GatewayVerify$ReqBody f242045i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f242046j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f242047k;

    /* renamed from: l, reason: collision with root package name */
    public byte[] f242048l;

    /* renamed from: m, reason: collision with root package name */
    public Integer f242049m;

    /* renamed from: n, reason: collision with root package name */
    public String f242050n;

    /* renamed from: o, reason: collision with root package name */
    public byte[] f242051o;

    /* renamed from: p, reason: collision with root package name */
    public int f242052p;

    /* renamed from: q, reason: collision with root package name */
    public Bundle f242053q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f242054r;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private final int f242055a;

        /* renamed from: b, reason: collision with root package name */
        private final int f242056b;

        /* renamed from: c, reason: collision with root package name */
        private final String f242057c;

        /* renamed from: d, reason: collision with root package name */
        private final String f242058d;

        /* renamed from: e, reason: collision with root package name */
        private byte[] f242059e;

        /* renamed from: f, reason: collision with root package name */
        private GatewayVerify$ReqBody f242060f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f242061g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f242062h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f242063i;

        /* renamed from: j, reason: collision with root package name */
        private byte[] f242064j;

        /* renamed from: k, reason: collision with root package name */
        private Integer f242065k;

        /* renamed from: l, reason: collision with root package name */
        private int f242066l;

        /* renamed from: m, reason: collision with root package name */
        private byte[] f242067m;

        /* renamed from: n, reason: collision with root package name */
        private Bundle f242068n;

        /* renamed from: o, reason: collision with root package name */
        private boolean f242069o;

        /* renamed from: p, reason: collision with root package name */
        private boolean f242070p;

        /* renamed from: q, reason: collision with root package name */
        private String f242071q;

        public a(int i3, @LoginReportConstants.AccountLoginScene int i16, String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), str, str2);
                return;
            }
            this.f242066l = 64;
            this.f242055a = i3;
            this.f242056b = i16;
            this.f242057c = str;
            this.f242058d = str2;
        }

        public a A(GatewayVerify$ReqBody gatewayVerify$ReqBody) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (a) iPatchRedirector.redirect((short) 3, (Object) this, (Object) gatewayVerify$ReqBody);
            }
            this.f242060f = gatewayVerify$ReqBody;
            return this;
        }

        public a B(byte[] bArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bArr);
            }
            this.f242059e = bArr;
            return this;
        }

        public a C(byte[] bArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (a) iPatchRedirector.redirect((short) 12, (Object) this, (Object) bArr);
            }
            this.f242067m = bArr;
            return this;
        }

        public a D(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (a) iPatchRedirector.redirect((short) 10, (Object) this, i3);
            }
            this.f242066l = i3;
            return this;
        }

        public c r() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return (c) iPatchRedirector.redirect((short) 15, (Object) this);
            }
            return new c(this);
        }

        public a s(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (a) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            }
            this.f242071q = str;
            return this;
        }

        public a t(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return (a) iPatchRedirector.redirect((short) 13, (Object) this, z16);
            }
            this.f242069o = z16;
            return this;
        }

        public a u(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (a) iPatchRedirector.redirect((short) 5, (Object) this, z16);
            }
            this.f242061g = z16;
            return this;
        }

        public a v(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (a) iPatchRedirector.redirect((short) 6, (Object) this, z16);
            }
            this.f242062h = z16;
            return this;
        }

        public a w(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return (a) iPatchRedirector.redirect((short) 14, (Object) this, z16);
            }
            this.f242070p = z16;
            return this;
        }

        public a x(Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (a) iPatchRedirector.redirect((short) 11, (Object) this, (Object) bundle);
            }
            this.f242068n = bundle;
            return this;
        }

        public a y(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (a) iPatchRedirector.redirect((short) 9, (Object) this, i3);
            }
            this.f242065k = Integer.valueOf(i3);
            return this;
        }

        public a z(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (a) iPatchRedirector.redirect((short) 7, (Object) this, z16);
            }
            this.f242063i = z16;
            return this;
        }
    }

    c(a aVar) {
        super(aVar.f242055a, aVar.f242056b);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
            return;
        }
        this.f242202c = aVar.f242062h;
        this.f242203d = this.f242200a == 3;
        this.f242042f = aVar.f242057c;
        this.f242043g = aVar.f242058d;
        this.f242044h = aVar.f242059e;
        this.f242045i = aVar.f242060f;
        this.f242046j = aVar.f242061g;
        this.f242047k = aVar.f242063i;
        this.f242048l = aVar.f242064j;
        this.f242049m = aVar.f242065k;
        this.f242052p = aVar.f242066l;
        this.f242051o = aVar.f242067m;
        this.f242053q = aVar.f242068n;
        this.f242054r = aVar.f242069o;
        this.f242204e = aVar.f242070p;
        this.f242050n = aVar.f242071q;
    }
}
