package com.tencent.mobileqq.msf.core.auth;

import com.huawei.hms.framework.common.ContainerUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import org.apache.httpcore.HttpHeaders;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes15.dex */
public class a {
    static IPatchRedirector $redirector_ = null;
    public static final String B = "MSF.C.Account";
    private long A;

    /* renamed from: a, reason: collision with root package name */
    private String f247351a;

    /* renamed from: b, reason: collision with root package name */
    private byte[] f247352b;

    /* renamed from: c, reason: collision with root package name */
    private byte[] f247353c;

    /* renamed from: d, reason: collision with root package name */
    private byte[] f247354d;

    /* renamed from: e, reason: collision with root package name */
    private byte[] f247355e;

    /* renamed from: f, reason: collision with root package name */
    private byte[] f247356f;

    /* renamed from: g, reason: collision with root package name */
    private byte[] f247357g;

    /* renamed from: h, reason: collision with root package name */
    private byte[] f247358h;

    /* renamed from: i, reason: collision with root package name */
    private byte[] f247359i;

    /* renamed from: j, reason: collision with root package name */
    private byte[] f247360j;

    /* renamed from: k, reason: collision with root package name */
    private byte[] f247361k;

    /* renamed from: l, reason: collision with root package name */
    int f247362l;

    /* renamed from: m, reason: collision with root package name */
    private byte[] f247363m;

    /* renamed from: n, reason: collision with root package name */
    private byte[] f247364n;

    /* renamed from: o, reason: collision with root package name */
    private int f247365o;

    /* renamed from: p, reason: collision with root package name */
    private int f247366p;

    /* renamed from: q, reason: collision with root package name */
    private int f247367q;

    /* renamed from: r, reason: collision with root package name */
    private byte[] f247368r;

    /* renamed from: s, reason: collision with root package name */
    private byte[] f247369s;

    /* renamed from: t, reason: collision with root package name */
    private long f247370t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f247371u;

    /* renamed from: v, reason: collision with root package name */
    private int f247372v;

    /* renamed from: w, reason: collision with root package name */
    private String f247373w;

    /* renamed from: x, reason: collision with root package name */
    private long f247374x;

    /* renamed from: y, reason: collision with root package name */
    private long f247375y;

    /* renamed from: z, reason: collision with root package name */
    private long f247376z;

    public a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        this.f247352b = new byte[0];
        this.f247353c = new byte[0];
        this.f247354d = new byte[0];
        this.f247355e = new byte[0];
        this.f247356f = new byte[0];
        this.f247357g = new byte[0];
        this.f247358h = new byte[0];
        this.f247359i = new byte[0];
        this.f247360j = new byte[0];
        this.f247361k = new byte[0];
        this.f247363m = new byte[0];
        this.f247364n = new byte[0];
        this.f247365o = 0;
        this.f247366p = 0;
        this.f247367q = 0;
        this.f247368r = new byte[0];
        this.f247369s = new byte[0];
        this.f247372v = -1;
        this.f247373w = "";
        this.f247374x = 0L;
        this.f247375y = 0L;
        this.f247376z = 0L;
        this.A = 0L;
        k.a(str, k.f247491e);
        this.f247351a = str;
    }

    public byte[] A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (byte[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f247359i;
    }

    public boolean B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Boolean) iPatchRedirector.redirect((short) 28, (Object) this)).booleanValue();
        }
        return this.f247371u;
    }

    public String C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return (String) iPatchRedirector.redirect((short) 31, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(",uin=");
        sb5.append(this.f247351a);
        if (m() > 0) {
            sb5.append(",loginTime=");
            sb5.append(m());
        }
        sb5.append(",active=");
        sb5.append(this.f247371u);
        if (a() != null && a().length > 0) {
            sb5.append(",A1=");
            sb5.append(HexUtil.bytes2HexStr(a()));
        }
        if (b() != null && b().length > 0) {
            sb5.append(",A2=");
            sb5.append(HexUtil.bytes2HexStr(b()));
        }
        if (c() != null && c().length > 0) {
            sb5.append(",A3=");
            sb5.append(HexUtil.bytes2HexStr(c()));
        }
        if (g() != null && g().length > 0) {
            sb5.append(",D1=");
            sb5.append(HexUtil.bytes2HexStr(g()));
        }
        if (h() != null && h().length > 0) {
            sb5.append(",D2=");
            sb5.append(HexUtil.bytes2HexStr(h()));
        }
        if (v() != null && v().length > 0) {
            sb5.append(",S2=");
            sb5.append(HexUtil.bytes2HexStr(v()));
        }
        if (k() != null && k().length > 0) {
            sb5.append(",key=");
            sb5.append(HexUtil.bytes2HexStr(k()));
        }
        if (p() != null && p().length > 0) {
            sb5.append(",MiniA2=");
            sb5.append(HexUtil.bytes2HexStr(p()));
        }
        if (o() != null && o().length > 0) {
            sb5.append(",MainAccount=");
            sb5.append(HexUtil.bytes2HexStr(o()));
        }
        if (A() != null && A().length > 0) {
            sb5.append(",vkey=");
            sb5.append(HexUtil.bytes2HexStr(A()));
        }
        if (x() != null && x().length > 0) {
            sb5.append(",skey=");
            sb5.append(HexUtil.bytes2HexStr(x()));
        }
        if (y() != null && y().length > 0) {
            sb5.append(",stweb=");
            sb5.append(HexUtil.bytes2HexStr(y()));
        }
        sb5.append(",FaceId=");
        sb5.append(i());
        sb5.append(",Age=");
        sb5.append(d());
        sb5.append(",Gender=");
        sb5.append(j());
        if (q() != null && q().length > 0) {
            sb5.append(",NickName=");
            sb5.append(HexUtil.bytes2HexStr(q()));
        }
        sb5.append(",renewA2D2Time=");
        sb5.append(r());
        sb5.append(",renewSidTime=");
        sb5.append(s());
        sb5.append(",renewSkeyTime=");
        sb5.append(t());
        sb5.append(",renewWebviewKeyTime=");
        sb5.append(u());
        sb5.append(",loginedProcess=");
        sb5.append(this.f247373w);
        return sb5.toString();
    }

    public byte[] a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) ? this.f247352b : (byte[]) iPatchRedirector.redirect((short) 10, (Object) this);
    }

    public byte[] b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) ? this.f247353c : (byte[]) iPatchRedirector.redirect((short) 12, (Object) this);
    }

    public void c(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        } else {
            k.a(str, k.f247491e);
            this.f247351a = str;
        }
    }

    public void d(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 25)) {
            this.f247369s = bArr;
        } else {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) bArr);
        }
    }

    public void e(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 17)) {
            this.f247355e = bArr;
        } else {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) bArr);
        }
    }

    public void f(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 19)) {
            this.f247356f = bArr;
        } else {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) bArr);
        }
    }

    public byte[] g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 16)) ? this.f247355e : (byte[]) iPatchRedirector.redirect((short) 16, (Object) this);
    }

    public byte[] h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 18)) ? this.f247356f : (byte[]) iPatchRedirector.redirect((short) 18, (Object) this);
    }

    public void i(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 33)) {
            this.f247363m = bArr;
        } else {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) bArr);
        }
    }

    public int j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 40)) ? this.f247367q : ((Integer) iPatchRedirector.redirect((short) 40, (Object) this)).intValue();
    }

    public void k(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 21)) {
            this.f247357g = bArr;
        } else {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) bArr);
        }
    }

    public void l(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            this.f247360j = bArr;
        } else {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bArr);
        }
    }

    public void m(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            this.f247361k = bArr;
        } else {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) bArr);
        }
    }

    public void n(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            this.f247359i = bArr;
        } else {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bArr);
        }
    }

    public byte[] o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return (byte[]) iPatchRedirector.redirect((short) 34, (Object) this);
        }
        return this.f247364n;
    }

    public byte[] p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return (byte[]) iPatchRedirector.redirect((short) 32, (Object) this);
        }
        return this.f247363m;
    }

    public byte[] q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return (byte[]) iPatchRedirector.redirect((short) 42, (Object) this);
        }
        return this.f247368r;
    }

    public long r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            return ((Long) iPatchRedirector.redirect((short) 50, (Object) this)).longValue();
        }
        long j3 = this.f247374x;
        if (j3 == 0) {
            return this.f247370t;
        }
        return j3;
    }

    public long s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            return ((Long) iPatchRedirector.redirect((short) 52, (Object) this)).longValue();
        }
        long j3 = this.f247375y;
        if (j3 == 0) {
            return this.f247370t;
        }
        return j3;
    }

    public long t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            return ((Long) iPatchRedirector.redirect((short) 54, (Object) this)).longValue();
        }
        long j3 = this.f247376z;
        if (j3 == 0) {
            return this.f247370t;
        }
        return j3;
    }

    public long u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            return ((Long) iPatchRedirector.redirect((short) 56, (Object) this)).longValue();
        }
        long j3 = this.A;
        if (j3 == 0) {
            return this.f247370t;
        }
        return j3;
    }

    public byte[] v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (byte[]) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return this.f247357g;
    }

    public SimpleAccount w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (SimpleAccount) iPatchRedirector.redirect((short) 30, (Object) this);
        }
        SimpleAccount simpleAccount = new SimpleAccount();
        simpleAccount.setUin(this.f247351a);
        simpleAccount.setAttribute(SimpleAccount._ISLOGINED, String.valueOf(this.f247371u));
        simpleAccount.setAttribute(SimpleAccount._LOGINTIME, String.valueOf(this.f247370t));
        simpleAccount.setAttribute(SimpleAccount._LOGINPROCESS, this.f247373w);
        return simpleAccount;
    }

    public byte[] x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (byte[]) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f247360j;
    }

    public byte[] y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (byte[]) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.f247361k;
    }

    public String z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.f247351a;
    }

    public void a(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
            this.f247352b = bArr;
        } else {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) bArr);
        }
    }

    public void b(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) {
            this.f247353c = bArr;
        } else {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) bArr);
        }
    }

    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 38)) ? this.f247366p : ((Integer) iPatchRedirector.redirect((short) 38, (Object) this)).intValue();
    }

    public byte[] e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 24)) ? this.f247369s : (byte[]) iPatchRedirector.redirect((short) 24, (Object) this);
    }

    public int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 44)) ? this.f247362l : ((Integer) iPatchRedirector.redirect((short) 44, (Object) this)).intValue();
    }

    public void g(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 23)) {
            this.f247358h = bArr;
        } else {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) bArr);
        }
    }

    public void h(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 35)) {
            this.f247364n = bArr;
        } else {
            iPatchRedirector.redirect((short) 35, (Object) this, (Object) bArr);
        }
    }

    public int i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 36)) ? this.f247365o : ((Integer) iPatchRedirector.redirect((short) 36, (Object) this)).intValue();
    }

    public void j(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 43)) {
            this.f247368r = bArr;
        } else {
            iPatchRedirector.redirect((short) 43, (Object) this, (Object) bArr);
        }
    }

    public byte[] k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 22)) ? this.f247358h : (byte[]) iPatchRedirector.redirect((short) 22, (Object) this);
    }

    public int l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 46)) ? this.f247372v : ((Integer) iPatchRedirector.redirect((short) 46, (Object) this)).intValue();
    }

    public long m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 26)) ? this.f247370t : ((Long) iPatchRedirector.redirect((short) 26, (Object) this)).longValue();
    }

    public String n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 48)) ? this.f247373w : (String) iPatchRedirector.redirect((short) 48, (Object) this);
    }

    public void a(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 27)) {
            this.f247370t = j3;
        } else {
            iPatchRedirector.redirect((short) 27, (Object) this, j3);
        }
    }

    public void b(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 45)) {
            this.f247362l = i3;
        } else {
            iPatchRedirector.redirect((short) 45, (Object) this, i3);
        }
    }

    public byte[] c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) ? this.f247354d : (byte[]) iPatchRedirector.redirect((short) 14, (Object) this);
    }

    public void d(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 41)) {
            this.f247367q = i3;
        } else {
            iPatchRedirector.redirect((short) 41, (Object) this, i3);
        }
    }

    public void e(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 47)) {
            this.f247372v = i3;
        } else {
            iPatchRedirector.redirect((short) 47, (Object) this, i3);
        }
    }

    public void a(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 29)) {
            this.f247371u = z16;
        } else {
            iPatchRedirector.redirect((short) 29, (Object) this, z16);
        }
    }

    public void b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 49)) {
            this.f247373w = str;
        } else {
            iPatchRedirector.redirect((short) 49, (Object) this, (Object) str);
        }
    }

    public void c(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 15)) {
            this.f247354d = bArr;
        } else {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) bArr);
        }
    }

    public void d(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 55)) {
            this.f247376z = j3;
        } else {
            iPatchRedirector.redirect((short) 55, (Object) this, j3);
        }
    }

    public void e(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 57)) {
            this.A = j3;
        } else {
            iPatchRedirector.redirect((short) 57, (Object) this, j3);
        }
    }

    public static a a(String str) {
        a aVar = null;
        if (str != null) {
            try {
                if (str.length() > 0) {
                    for (String str2 : str.split(",")) {
                        if (str2.length() > 0) {
                            String[] split = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
                            if (split.length == 2) {
                                if ("uin".equals(split[0])) {
                                    aVar = new a(split[1]);
                                } else if ("loginTime".equals(split[0])) {
                                    aVar.a(Long.parseLong(split[1]));
                                } else if ("active".equals(split[0])) {
                                    aVar.a(Boolean.parseBoolean(split[1]));
                                } else if ("A1".equals(split[0])) {
                                    aVar.a(HexUtil.hexStr2Bytes(split[1]));
                                } else if (NowProxyConstants.AccountInfoKey.A2.equals(split[0])) {
                                    aVar.b(HexUtil.hexStr2Bytes(split[1]));
                                } else if ("A3".equals(split[0])) {
                                    aVar.c(HexUtil.hexStr2Bytes(split[1]));
                                } else if (com.tencent.bugly.common.constants.Constants.BASE_IN_PLUGIN_ID.equals(split[0])) {
                                    aVar.e(HexUtil.hexStr2Bytes(split[1]));
                                } else if (com.tencent.bugly.common.constants.Constants.BASE_IN_PLUGIN_VERSION.equals(split[0])) {
                                    aVar.f(HexUtil.hexStr2Bytes(split[1]));
                                } else if ("S2".equals(split[0])) {
                                    aVar.k(HexUtil.hexStr2Bytes(split[1]));
                                } else if ("key".equals(split[0])) {
                                    aVar.g(HexUtil.hexStr2Bytes(split[1]));
                                } else if (!"sid".equals(split[0])) {
                                    if ("MiniA2".equals(split[0])) {
                                        aVar.i(HexUtil.hexStr2Bytes(split[1]));
                                    } else if ("MainAccount".equals(split[0])) {
                                        aVar.h(HexUtil.hexStr2Bytes(split[1]));
                                    } else if ("FaceId".equalsIgnoreCase(split[0])) {
                                        aVar.c(Integer.parseInt(split[1]));
                                    } else if (HttpHeaders.AGE.equalsIgnoreCase(split[0])) {
                                        aVar.a(Integer.parseInt(split[1]));
                                    } else if ("Gender".equalsIgnoreCase(split[0])) {
                                        aVar.d(Integer.parseInt(split[1]));
                                    } else if ("NickName".equals(split[0])) {
                                        aVar.j(HexUtil.hexStr2Bytes(split[1]));
                                    } else if (!"sid".equals(split[0])) {
                                        if ("renewA2D2Time".equals(split[0])) {
                                            aVar.b(Long.parseLong(split[1]));
                                        } else if ("renewSidTime".equals(split[0])) {
                                            aVar.c(Long.parseLong(split[1]));
                                        } else if ("loginedProcess".equals(split[0])) {
                                            aVar.b(split[1]);
                                        } else if ("vkey".equals(split[0])) {
                                            aVar.n(HexUtil.hexStr2Bytes(split[1]));
                                        } else if ("skey".equals(split[0])) {
                                            aVar.l(HexUtil.hexStr2Bytes(split[1]));
                                        } else if ("stweb".equals(split[0])) {
                                            aVar.m(HexUtil.hexStr2Bytes(split[1]));
                                        } else if ("renewSkeyTime".equals(split[0])) {
                                            aVar.d(Long.parseLong(split[1]));
                                        } else if ("renewWebviewKeyTime".equals(split[0])) {
                                            aVar.e(Long.parseLong(split[1]));
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (Exception e16) {
                QLog.e(B, 2, "parse account error", e16);
            }
        }
        return aVar;
    }

    public void b(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 51)) {
            this.f247374x = j3;
        } else {
            iPatchRedirector.redirect((short) 51, (Object) this, j3);
        }
    }

    public void c(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 37)) {
            this.f247365o = i3;
        } else {
            iPatchRedirector.redirect((short) 37, (Object) this, i3);
        }
    }

    public void c(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 53)) {
            this.f247375y = j3;
        } else {
            iPatchRedirector.redirect((short) 53, (Object) this, j3);
        }
    }

    public void a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 39)) {
            this.f247366p = i3;
        } else {
            iPatchRedirector.redirect((short) 39, (Object) this, i3);
        }
    }
}
