package com.tencent.mobileqq.uftransfer.api;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes19.dex */
public class m extends e {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name */
    private int f304953g;

    /* renamed from: h, reason: collision with root package name */
    private String f304954h;

    /* renamed from: i, reason: collision with root package name */
    private long f304955i;

    /* renamed from: j, reason: collision with root package name */
    private String f304956j;

    /* renamed from: k, reason: collision with root package name */
    private String f304957k;

    /* renamed from: l, reason: collision with root package name */
    private byte[] f304958l;

    /* renamed from: m, reason: collision with root package name */
    private byte[] f304959m;

    /* renamed from: n, reason: collision with root package name */
    private byte[] f304960n;

    /* renamed from: o, reason: collision with root package name */
    private int f304961o;

    public m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f304955i = 0L;
            this.f304961o = 0;
        }
    }

    public int m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.f304953g;
    }

    public int n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this)).intValue();
        }
        return this.f304961o;
    }

    public String o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.f304956j;
    }

    public String p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.f304957k;
    }

    public String q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f304954h;
    }

    public void r(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            this.f304953g = i3;
        }
    }

    public void s(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, i3);
        } else {
            this.f304961o = i3;
        }
    }

    public void t(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            this.f304954h = str;
        }
    }

    @Override // com.tencent.mobileqq.uftransfer.api.e
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (String) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return "UFTTroopUploadInfo{" + super.toString() + ", busId=" + this.f304953g + ", strParentId='" + this.f304954h + "', troopCode=" + this.f304955i + ", fileId='" + this.f304956j + "', serverDns='" + this.f304957k + "', bytesSha=" + Arrays.toString(this.f304958l) + ", bytesMd5=" + Arrays.toString(this.f304959m) + ", bytesSha3=" + Arrays.toString(this.f304960n) + ", entranceType=" + this.f304961o + '}';
    }
}
