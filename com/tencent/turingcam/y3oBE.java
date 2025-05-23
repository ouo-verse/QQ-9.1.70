package com.tencent.turingcam;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class y3oBE extends UMDtK {
    static IPatchRedirector $redirector_;
    public String A;
    public String B;
    public String C;
    public String D;
    public String E;
    public String F;
    public String G;
    public int H;
    public int I;
    public boolean J;
    public String K;
    public String L;
    public String M;
    public boolean N;
    public boolean O;
    public String P;
    public int Q;
    public String R;
    public String S;
    public String T;
    public String U;
    public String V;
    public String W;
    public String X;
    public String Y;
    public String Z;

    /* renamed from: a, reason: collision with root package name */
    public String f382426a;

    /* renamed from: a0, reason: collision with root package name */
    public long f382427a0;

    /* renamed from: b, reason: collision with root package name */
    public String f382428b;

    /* renamed from: b0, reason: collision with root package name */
    public String f382429b0;

    /* renamed from: c, reason: collision with root package name */
    public String f382430c;

    /* renamed from: c0, reason: collision with root package name */
    public String f382431c0;

    /* renamed from: d, reason: collision with root package name */
    public String f382432d;

    /* renamed from: d0, reason: collision with root package name */
    public int f382433d0;

    /* renamed from: e, reason: collision with root package name */
    public String f382434e;

    /* renamed from: e0, reason: collision with root package name */
    public String f382435e0;

    /* renamed from: f, reason: collision with root package name */
    public int f382436f;

    /* renamed from: f0, reason: collision with root package name */
    public String f382437f0;

    /* renamed from: g, reason: collision with root package name */
    public String f382438g;

    /* renamed from: g0, reason: collision with root package name */
    public String f382439g0;

    /* renamed from: h, reason: collision with root package name */
    public int f382440h;

    /* renamed from: i, reason: collision with root package name */
    public String f382441i;

    /* renamed from: j, reason: collision with root package name */
    public int f382442j;

    /* renamed from: k, reason: collision with root package name */
    public int f382443k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f382444l;

    /* renamed from: m, reason: collision with root package name */
    public String f382445m;

    /* renamed from: n, reason: collision with root package name */
    public String f382446n;

    /* renamed from: o, reason: collision with root package name */
    public int f382447o;

    /* renamed from: p, reason: collision with root package name */
    public String f382448p;

    /* renamed from: q, reason: collision with root package name */
    public short f382449q;

    /* renamed from: r, reason: collision with root package name */
    public int f382450r;

    /* renamed from: s, reason: collision with root package name */
    public String f382451s;

    /* renamed from: t, reason: collision with root package name */
    public String f382452t;

    /* renamed from: u, reason: collision with root package name */
    public int f382453u;

    /* renamed from: v, reason: collision with root package name */
    public String f382454v;

    /* renamed from: w, reason: collision with root package name */
    public long f382455w;

    /* renamed from: x, reason: collision with root package name */
    public long f382456x;

    /* renamed from: y, reason: collision with root package name */
    public long f382457y;

    /* renamed from: z, reason: collision with root package name */
    public String f382458z;

    public y3oBE() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f382426a = "";
        this.f382428b = "";
        this.f382430c = "";
        this.f382432d = "";
        this.f382434e = "";
        this.f382436f = 1;
        this.f382438g = "";
        this.f382440h = 0;
        this.f382441i = "";
        this.f382442j = 0;
        this.f382443k = 0;
        this.f382444l = false;
        this.f382445m = "";
        this.f382446n = "";
        this.f382447o = 0;
        this.f382448p = "";
        this.f382449q = (short) 0;
        this.f382450r = 0;
        this.f382451s = "";
        this.f382452t = "";
        this.f382453u = 0;
        this.f382454v = "";
        this.f382455w = 0L;
        this.f382456x = 0L;
        this.f382457y = 0L;
        this.f382458z = "";
        this.A = "";
        this.B = "";
        this.C = "";
        this.D = "";
        this.E = "";
        this.F = "";
        this.G = "";
        this.H = 0;
        this.I = 0;
        this.J = false;
        this.K = "";
        this.L = "";
        this.M = "";
        this.N = false;
        this.O = false;
        this.P = "";
        this.Q = 1;
        this.R = "";
        this.S = "";
        this.T = "";
        this.U = "";
        this.V = "";
        this.W = "";
        this.X = "";
        this.Y = "";
        this.Z = "";
        this.f382427a0 = 0L;
        this.f382429b0 = "";
        this.f382431c0 = "";
        this.f382433d0 = 0;
        this.f382435e0 = "";
        this.f382437f0 = "";
        this.f382439g0 = "";
    }

    @Override // com.tencent.turingcam.UMDtK
    public UMDtK a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? new y3oBE() : (UMDtK) iPatchRedirector.redirect((short) 2, (Object) this);
    }

    @Override // com.tencent.turingcam.UMDtK
    public void a(Xjpd8 xjpd8) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) xjpd8);
            return;
        }
        xjpd8.a(this.f382426a, 0);
        String str = this.f382428b;
        if (str != null) {
            xjpd8.a(str, 1);
        }
        String str2 = this.f382430c;
        if (str2 != null) {
            xjpd8.a(str2, 2);
        }
        String str3 = this.f382432d;
        if (str3 != null) {
            xjpd8.a(str3, 3);
        }
        String str4 = this.f382434e;
        if (str4 != null) {
            xjpd8.a(str4, 4);
        }
        int i3 = this.f382436f;
        if (1 != i3) {
            xjpd8.a(i3, 5);
        }
        String str5 = this.f382438g;
        if (str5 != null) {
            xjpd8.a(str5, 6);
        }
        int i16 = this.f382440h;
        if (i16 != 0) {
            xjpd8.a(i16, 7);
        }
        String str6 = this.f382441i;
        if (str6 != null) {
            xjpd8.a(str6, 8);
        }
        int i17 = this.f382442j;
        if (i17 != 0) {
            xjpd8.a(i17, 9);
        }
        int i18 = this.f382443k;
        if (i18 != 0) {
            xjpd8.a(i18, 10);
        }
        xjpd8.a(this.f382444l ? (byte) 1 : (byte) 0, 11);
        String str7 = this.f382445m;
        if (str7 != null) {
            xjpd8.a(str7, 12);
        }
        String str8 = this.f382446n;
        if (str8 != null) {
            xjpd8.a(str8, 13);
        }
        int i19 = this.f382447o;
        if (i19 != 0) {
            xjpd8.a(i19, 14);
        }
        String str9 = this.f382448p;
        if (str9 != null) {
            xjpd8.a(str9, 15);
        }
        short s16 = this.f382449q;
        if (s16 != 0) {
            xjpd8.a(s16, 16);
        }
        int i26 = this.f382450r;
        if (i26 != 0) {
            xjpd8.a(i26, 17);
        }
        String str10 = this.f382451s;
        if (str10 != null) {
            xjpd8.a(str10, 18);
        }
        String str11 = this.f382452t;
        if (str11 != null) {
            xjpd8.a(str11, 19);
        }
        int i27 = this.f382453u;
        if (i27 != 0) {
            xjpd8.a(i27, 20);
        }
        String str12 = this.f382454v;
        if (str12 != null) {
            xjpd8.a(str12, 21);
        }
        long j3 = this.f382455w;
        if (j3 != 0) {
            xjpd8.a(j3, 22);
        }
        long j16 = this.f382456x;
        if (j16 != 0) {
            xjpd8.a(j16, 23);
        }
        long j17 = this.f382457y;
        if (j17 != 0) {
            xjpd8.a(j17, 24);
        }
        String str13 = this.f382458z;
        if (str13 != null) {
            xjpd8.a(str13, 25);
        }
        String str14 = this.A;
        if (str14 != null) {
            xjpd8.a(str14, 26);
        }
        String str15 = this.B;
        if (str15 != null) {
            xjpd8.a(str15, 27);
        }
        String str16 = this.C;
        if (str16 != null) {
            xjpd8.a(str16, 28);
        }
        String str17 = this.D;
        if (str17 != null) {
            xjpd8.a(str17, 29);
        }
        String str18 = this.E;
        if (str18 != null) {
            xjpd8.a(str18, 30);
        }
        String str19 = this.F;
        if (str19 != null) {
            xjpd8.a(str19, 31);
        }
        String str20 = this.G;
        if (str20 != null) {
            xjpd8.a(str20, 32);
        }
        int i28 = this.H;
        if (i28 != 0) {
            xjpd8.a(i28, 33);
        }
        int i29 = this.I;
        if (i29 != 0) {
            xjpd8.a(i29, 34);
        }
        xjpd8.a(this.J ? (byte) 1 : (byte) 0, 35);
        String str21 = this.K;
        if (str21 != null) {
            xjpd8.a(str21, 36);
        }
        String str22 = this.L;
        if (str22 != null) {
            xjpd8.a(str22, 37);
        }
        String str23 = this.M;
        if (str23 != null) {
            xjpd8.a(str23, 38);
        }
        xjpd8.a(this.N ? (byte) 1 : (byte) 0, 39);
        xjpd8.a(this.O ? (byte) 1 : (byte) 0, 40);
        String str24 = this.P;
        if (str24 != null) {
            xjpd8.a(str24, 41);
        }
        int i36 = this.Q;
        if (i36 != 1) {
            xjpd8.a(i36, 42);
        }
        String str25 = this.R;
        if (str25 != null) {
            xjpd8.a(str25, 43);
        }
        String str26 = this.S;
        if (str26 != null) {
            xjpd8.a(str26, 44);
        }
        String str27 = this.T;
        if (str27 != null) {
            xjpd8.a(str27, 45);
        }
        String str28 = this.U;
        if (str28 != null) {
            xjpd8.a(str28, 46);
        }
        String str29 = this.V;
        if (str29 != null) {
            xjpd8.a(str29, 47);
        }
        String str30 = this.W;
        if (str30 != null) {
            xjpd8.a(str30, 48);
        }
        String str31 = this.X;
        if (str31 != null) {
            xjpd8.a(str31, 49);
        }
        String str32 = this.Y;
        if (str32 != null) {
            xjpd8.a(str32, 50);
        }
        String str33 = this.Z;
        if (str33 != null) {
            xjpd8.a(str33, 51);
        }
        long j18 = this.f382427a0;
        if (j18 != 0) {
            xjpd8.a(j18, 52);
        }
        String str34 = this.f382429b0;
        if (str34 != null) {
            xjpd8.a(str34, 53);
        }
        String str35 = this.f382431c0;
        if (str35 != null) {
            xjpd8.a(str35, 54);
        }
        int i37 = this.f382433d0;
        if (i37 != 0) {
            xjpd8.a(i37, 55);
        }
        String str36 = this.f382435e0;
        if (str36 != null) {
            xjpd8.a(str36, 56);
        }
        String str37 = this.f382437f0;
        if (str37 != null) {
            xjpd8.a(str37, 57);
        }
        String str38 = this.f382439g0;
        if (str38 != null) {
            xjpd8.a(str38, 58);
        }
    }

    @Override // com.tencent.turingcam.UMDtK
    public void a(YunKQ yunKQ) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) yunKQ);
            return;
        }
        this.f382426a = yunKQ.b(0, true);
        this.f382428b = yunKQ.b(1, false);
        this.f382430c = yunKQ.b(2, false);
        this.f382432d = yunKQ.b(3, false);
        this.f382434e = yunKQ.b(4, false);
        this.f382436f = yunKQ.a(this.f382436f, 5, false);
        this.f382438g = yunKQ.b(6, false);
        this.f382440h = yunKQ.a(this.f382440h, 7, false);
        this.f382441i = yunKQ.b(8, false);
        this.f382442j = yunKQ.a(this.f382442j, 9, false);
        this.f382443k = yunKQ.a(this.f382443k, 10, false);
        this.f382444l = yunKQ.a(this.f382444l, 11, false);
        this.f382445m = yunKQ.b(12, false);
        this.f382446n = yunKQ.b(13, false);
        this.f382447o = yunKQ.a(this.f382447o, 14, false);
        this.f382448p = yunKQ.b(15, false);
        this.f382449q = yunKQ.a(this.f382449q, 16, false);
        this.f382450r = yunKQ.a(this.f382450r, 17, false);
        this.f382451s = yunKQ.b(18, false);
        this.f382452t = yunKQ.b(19, false);
        this.f382453u = yunKQ.a(this.f382453u, 20, false);
        this.f382454v = yunKQ.b(21, false);
        this.f382455w = yunKQ.a(this.f382455w, 22, false);
        this.f382456x = yunKQ.a(this.f382456x, 23, false);
        this.f382457y = yunKQ.a(this.f382457y, 24, false);
        this.f382458z = yunKQ.b(25, false);
        this.A = yunKQ.b(26, false);
        this.B = yunKQ.b(27, false);
        this.C = yunKQ.b(28, false);
        this.D = yunKQ.b(29, false);
        this.E = yunKQ.b(30, false);
        this.F = yunKQ.b(31, false);
        this.G = yunKQ.b(32, false);
        this.H = yunKQ.a(this.H, 33, false);
        this.I = yunKQ.a(this.I, 34, false);
        this.J = yunKQ.a(this.J, 35, false);
        this.K = yunKQ.b(36, false);
        this.L = yunKQ.b(37, false);
        this.M = yunKQ.b(38, false);
        this.N = yunKQ.a(this.N, 39, false);
        this.O = yunKQ.a(this.O, 40, false);
        this.P = yunKQ.b(41, false);
        this.Q = yunKQ.a(this.Q, 42, false);
        this.R = yunKQ.b(43, false);
        this.S = yunKQ.b(44, false);
        this.T = yunKQ.b(45, false);
        this.U = yunKQ.b(46, false);
        this.V = yunKQ.b(47, false);
        this.W = yunKQ.b(48, false);
        this.X = yunKQ.b(49, false);
        this.Y = yunKQ.b(50, false);
        this.Z = yunKQ.b(51, false);
        this.f382427a0 = yunKQ.a(this.f382427a0, 52, false);
        this.f382429b0 = yunKQ.b(53, false);
        this.f382431c0 = yunKQ.b(54, false);
        this.f382433d0 = yunKQ.a(this.f382433d0, 55, false);
        this.f382435e0 = yunKQ.b(56, false);
        this.f382437f0 = yunKQ.b(57, false);
        this.f382439g0 = yunKQ.b(58, false);
    }
}
