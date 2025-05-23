package com.tencent.mobileqq.uftransfer.proto;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.mobileqq.jsonconverter.Alias;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes19.dex */
public class d {
    static IPatchRedirector $redirector_;
    public byte[] A;

    @Alias("useMediaPlatform")
    public boolean B;

    @Alias("mediaPlatformUploadKey")
    public String C;
    public byte[] D;

    @Alias("strFileidcrc")
    public String E;

    @Alias("listIp")
    public List<String> F;

    /* renamed from: a, reason: collision with root package name */
    public int f305269a;

    /* renamed from: b, reason: collision with root package name */
    public String f305270b;

    /* renamed from: c, reason: collision with root package name */
    @Alias("totalSpace")
    public long f305271c;

    /* renamed from: d, reason: collision with root package name */
    @Alias("usedSpace")
    public long f305272d;

    /* renamed from: e, reason: collision with root package name */
    @Alias("fileSize")
    public long f305273e;

    /* renamed from: f, reason: collision with root package name */
    @Alias("strIP")
    public String f305274f;

    /* renamed from: g, reason: collision with root package name */
    @Alias("port")
    public int f305275g;

    /* renamed from: h, reason: collision with root package name */
    @Alias("uuid")
    public String f305276h;

    /* renamed from: i, reason: collision with root package name */
    public byte[] f305277i;

    /* renamed from: j, reason: collision with root package name */
    @Alias("key")
    public String f305278j;

    /* renamed from: k, reason: collision with root package name */
    public byte[] f305279k;

    /* renamed from: l, reason: collision with root package name */
    @Alias("fileExist")
    public boolean f305280l;

    /* renamed from: m, reason: collision with root package name */
    @Alias("packetSize")
    public int f305281m;

    /* renamed from: n, reason: collision with root package name */
    @Alias("md5")
    public String f305282n;

    /* renamed from: o, reason: collision with root package name */
    public byte[] f305283o;

    /* renamed from: p, reason: collision with root package name */
    @Alias("retStat")
    public int f305284p;

    /* renamed from: q, reason: collision with root package name */
    @Alias(WidgetCacheLunarData.SHA)
    public String f305285q;

    /* renamed from: r, reason: collision with root package name */
    public byte[] f305286r;

    /* renamed from: s, reason: collision with root package name */
    @Alias("sha3")
    public String f305287s;

    /* renamed from: t, reason: collision with root package name */
    public byte[] f305288t;

    /* renamed from: u, reason: collision with root package name */
    @Alias("httpsvrApiVer")
    public int f305289u;

    /* renamed from: v, reason: collision with root package name */
    @Alias("strHttpsDomain")
    public String f305290v;

    /* renamed from: w, reason: collision with root package name */
    @Alias("httpsPort")
    public int f305291w;

    /* renamed from: x, reason: collision with root package name */
    @Alias("dnsIPv6")
    public String f305292x;

    /* renamed from: y, reason: collision with root package name */
    @Alias("lanIp")
    public String f305293y;

    /* renamed from: z, reason: collision with root package name */
    @Alias("bufRspPbContent")
    public String f305294z;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f305269a = 0;
        this.f305270b = "";
        this.f305271c = 0L;
        this.f305272d = 0L;
        this.f305273e = 0L;
        this.f305274f = "";
        this.f305275g = 0;
        this.f305277i = null;
        this.f305279k = null;
        this.f305280l = false;
        this.f305281m = 0;
        this.f305284p = -1;
        this.f305286r = null;
        this.f305288t = null;
        this.f305289u = 0;
        this.f305290v = "";
        this.f305291w = 0;
        this.f305292x = "";
        this.f305293y = "";
        this.B = false;
        this.D = null;
        this.E = "";
    }

    public void A(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, (Object) this, (Object) bArr);
        } else {
            this.D = bArr;
        }
    }

    public void B(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, i3);
        } else {
            this.f305281m = i3;
        }
    }

    public void C(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3);
        } else {
            this.f305275g = i3;
        }
    }

    public void D(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            this.f305269a = i3;
        }
    }

    public void E(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            this.f305270b = str;
        }
    }

    public void F(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) bArr);
        } else {
            this.f305286r = bArr;
        }
    }

    public void G(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            iPatchRedirector.redirect((short) 49, (Object) this, (Object) str);
        } else {
            this.E = str;
        }
    }

    public void H(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, (Object) str);
        } else {
            this.f305290v = str;
        }
    }

    public void I(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
        } else {
            this.f305274f = str;
        }
    }

    public void J(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, j3);
        } else {
            this.f305271c = j3;
        }
    }

    public void K(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, (Object) this, z16);
        } else {
            this.B = z16;
        }
    }

    public void L(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, j3);
        } else {
            this.f305272d = j3;
        }
    }

    public void M(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) bArr);
        } else {
            this.f305277i = bArr;
        }
    }

    public byte[] a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return (byte[]) iPatchRedirector.redirect((short) 42, (Object) this);
        }
        return this.A;
    }

    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return (String) iPatchRedirector.redirect((short) 38, (Object) this);
        }
        return this.f305292x;
    }

    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return ((Integer) iPatchRedirector.redirect((short) 36, (Object) this)).intValue();
        }
        return this.f305291w;
    }

    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Integer) iPatchRedirector.redirect((short) 32, (Object) this)).intValue();
        }
        return this.f305289u;
    }

    public byte[] e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (byte[]) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return this.f305279k;
    }

    public List<String> f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            return (List) iPatchRedirector.redirect((short) 50, (Object) this);
        }
        return this.F;
    }

    public byte[] g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            return (byte[]) iPatchRedirector.redirect((short) 46, (Object) this);
        }
        return this.D;
    }

    public int h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        return this.f305275g;
    }

    public int i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.f305269a;
    }

    public String j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f305270b;
    }

    public byte[] k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (byte[]) iPatchRedirector.redirect((short) 28, (Object) this);
        }
        return this.f305286r;
    }

    public String l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            return (String) iPatchRedirector.redirect((short) 48, (Object) this);
        }
        return this.E;
    }

    public String m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return (String) iPatchRedirector.redirect((short) 34, (Object) this);
        }
        return this.f305290v;
    }

    public String n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.f305274f;
    }

    public byte[] o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (byte[]) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.f305277i;
    }

    public boolean p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this)).booleanValue();
        }
        return this.f305280l;
    }

    public boolean q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            return ((Boolean) iPatchRedirector.redirect((short) 44, (Object) this)).booleanValue();
        }
        return this.B;
    }

    public void r(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this, (Object) bArr);
        } else {
            this.A = bArr;
        }
    }

    public void s(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this, (Object) str);
        } else {
            this.f305292x = str;
        }
    }

    public void t(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, z16);
        } else {
            this.f305280l = z16;
        }
    }

    public String toString() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            return (String) iPatchRedirector.redirect((short) 52, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("UFTC2CUploadRsp{retCode=");
        sb5.append(this.f305269a);
        sb5.append(", retMsg='");
        sb5.append(this.f305270b);
        sb5.append('\'');
        sb5.append(", totalSpace=");
        sb5.append(this.f305271c);
        sb5.append(", usedSpace=");
        sb5.append(this.f305272d);
        sb5.append(", fileSize=");
        sb5.append(this.f305273e);
        sb5.append(", strIP='");
        sb5.append(this.f305274f);
        sb5.append('\'');
        sb5.append(", port=");
        sb5.append(this.f305275g);
        sb5.append(", uuid=");
        sb5.append(com.tencent.mobileqq.uftransfer.depend.a.a(this.f305277i));
        sb5.append(", key=");
        sb5.append(com.tencent.mobileqq.uftransfer.depend.a.a(this.f305279k));
        sb5.append(", fileExist=");
        sb5.append(this.f305280l);
        sb5.append(", packetSize=");
        sb5.append(this.f305281m);
        sb5.append(", md5=");
        sb5.append(com.tencent.mobileqq.uftransfer.depend.a.a(this.f305283o));
        sb5.append(", retStat=");
        sb5.append(this.f305284p);
        sb5.append(", sha=");
        sb5.append(com.tencent.mobileqq.uftransfer.depend.a.a(this.f305286r));
        sb5.append(", sha3=");
        sb5.append(com.tencent.mobileqq.uftransfer.depend.a.a(this.f305288t));
        sb5.append(", httpsvrApiVer=");
        sb5.append(this.f305289u);
        sb5.append(", strHttpsDomain='");
        sb5.append(this.f305290v);
        sb5.append('\'');
        sb5.append(", httpsPort=");
        sb5.append(this.f305291w);
        sb5.append(", dnsIPv6='");
        sb5.append(this.f305292x);
        sb5.append('\'');
        sb5.append(", lanIp='");
        sb5.append(this.f305293y);
        sb5.append('\'');
        sb5.append(", bufRspPbContent=");
        byte[] bArr = this.A;
        if (bArr != null) {
            i3 = bArr.length;
        } else {
            i3 = 0;
        }
        sb5.append(i3);
        sb5.append(", useMediaPlatform=");
        sb5.append(this.B);
        sb5.append(", mediaPlatformUploadKey=");
        sb5.append(com.tencent.mobileqq.uftransfer.depend.a.a(this.D));
        sb5.append(", strFileidcrc='");
        sb5.append(this.E);
        sb5.append('\'');
        sb5.append(", listIp=");
        sb5.append(this.F);
        sb5.append('}');
        return sb5.toString();
    }

    public void u(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, j3);
        } else {
            this.f305273e = j3;
        }
    }

    public void v(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, i3);
        } else {
            this.f305291w = i3;
        }
    }

    public void w(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, i3);
        } else {
            this.f305289u = i3;
        }
    }

    public void x(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) bArr);
        } else {
            this.f305279k = bArr;
        }
    }

    public void y(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, (Object) this, (Object) str);
        } else {
            this.f305293y = str;
        }
    }

    public void z(List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            iPatchRedirector.redirect((short) 51, (Object) this, (Object) list);
        } else {
            this.F = list;
        }
    }
}
