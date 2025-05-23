package com.tencent.mobileqq.uftransfer.proto;

import com.tencent.mobileqq.jsonconverter.Alias;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes19.dex */
public class j {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private int f305330a;

    /* renamed from: b, reason: collision with root package name */
    private String f305331b;

    /* renamed from: c, reason: collision with root package name */
    @Alias("clientWording")
    public String f305332c;

    /* renamed from: d, reason: collision with root package name */
    @Alias("fileId")
    public String f305333d;

    /* renamed from: e, reason: collision with root package name */
    @Alias("uploadIp")
    public String f305334e;

    /* renamed from: f, reason: collision with root package name */
    @Alias("serverDns")
    public String f305335f;

    /* renamed from: g, reason: collision with root package name */
    @Alias("checkKey")
    public String f305336g;

    /* renamed from: h, reason: collision with root package name */
    public byte[] f305337h;

    /* renamed from: i, reason: collision with root package name */
    @Alias("busid")
    public int f305338i;

    /* renamed from: j, reason: collision with root package name */
    @Alias("lanIpV4List")
    public List<String> f305339j;

    /* renamed from: k, reason: collision with root package name */
    @Alias("lanIpV6List")
    public List<String> f305340k;

    /* renamed from: l, reason: collision with root package name */
    @Alias("lanPort")
    public int f305341l;

    public j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f305330a = 0;
            this.f305341l = 0;
        }
    }

    public byte[] a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (byte[]) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.f305337h;
    }

    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.f305332c;
    }

    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.f305333d;
    }

    public List<String> d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (List) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return this.f305339j;
    }

    public List<String> e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (List) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return this.f305340k;
    }

    public int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Integer) iPatchRedirector.redirect((short) 22, (Object) this)).intValue();
        }
        return this.f305341l;
    }

    public int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.f305330a;
    }

    public String h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f305331b;
    }

    public String i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.f305335f;
    }

    public String j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.f305334e;
    }

    public void k(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, i3);
        } else {
            this.f305338i = i3;
        }
    }

    public void l(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) bArr);
        } else {
            this.f305337h = bArr;
        }
    }

    public void m(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        } else {
            this.f305332c = str;
        }
    }

    public void n(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        } else {
            this.f305333d = str;
        }
    }

    public void o(List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) list);
        } else {
            this.f305339j = list;
        }
    }

    public void p(List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) list);
        } else {
            this.f305340k = list;
        }
    }

    public void q(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, i3);
        } else {
            this.f305341l = i3;
        }
    }

    public void r(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            this.f305330a = i3;
        }
    }

    public void s(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            this.f305331b = str;
        }
    }

    public void t(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
        } else {
            this.f305335f = str;
        }
    }

    public String toString() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (String) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("UFTTroopUploadRsp{retCode=");
        sb5.append(this.f305330a);
        sb5.append(", retMsg='");
        sb5.append(this.f305331b);
        sb5.append('\'');
        sb5.append(", clientWording='");
        sb5.append(this.f305332c);
        sb5.append('\'');
        sb5.append(", fileId='");
        sb5.append(this.f305333d);
        sb5.append('\'');
        sb5.append(", uploadIp='");
        sb5.append(this.f305334e);
        sb5.append('\'');
        sb5.append(", serverDns='");
        sb5.append(this.f305335f);
        sb5.append('\'');
        sb5.append(", checkKey=");
        sb5.append(com.tencent.mobileqq.uftransfer.depend.a.a(this.f305337h));
        sb5.append(", busid=");
        sb5.append(this.f305338i);
        sb5.append(", lanIpV4List=");
        List<String> list = this.f305339j;
        String str2 = "null";
        if (list == null) {
            str = "null";
        } else {
            str = list.toString();
        }
        sb5.append(str);
        sb5.append(", lanIpV6List=");
        List<String> list2 = this.f305340k;
        if (list2 != null) {
            str2 = list2.toString();
        }
        sb5.append(str2);
        sb5.append(", lanPort=");
        sb5.append(this.f305341l);
        sb5.append('}');
        return sb5.toString();
    }

    public void u(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
        } else {
            this.f305334e = str;
        }
    }
}
