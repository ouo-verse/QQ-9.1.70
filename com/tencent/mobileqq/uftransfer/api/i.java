package com.tencent.mobileqq.uftransfer.api;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes19.dex */
public class i {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private String f304877a;

    /* renamed from: b, reason: collision with root package name */
    private String f304878b;

    /* renamed from: c, reason: collision with root package name */
    private String f304879c;

    /* renamed from: d, reason: collision with root package name */
    private int f304880d;

    /* renamed from: e, reason: collision with root package name */
    private byte[] f304881e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f304882f;

    /* renamed from: g, reason: collision with root package name */
    private String f304883g;

    public i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f304880d = 0;
            this.f304882f = false;
        }
    }

    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f304877a;
    }

    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.f304883g;
    }

    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.f304879c;
    }

    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return this.f304880d;
    }

    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.f304882f;
    }

    public void f(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) bArr);
        } else {
            this.f304881e = bArr;
        }
    }

    public void g(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            this.f304877a = str;
        }
    }

    public void h(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        } else {
            this.f304883g = str;
        }
    }

    public void i(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            this.f304878b = str;
        }
    }

    public void j(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
        } else {
            this.f304882f = z16;
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return "UFTFileUploadBusiInfo{fileId='" + this.f304877a + "', uploadIp='" + this.f304878b + "', svrPath='" + this.f304879c + "', svrPathHostType=" + this.f304880d + ", checkKey=" + Arrays.toString(this.f304881e) + ", useMediaPlatform=" + this.f304882f + ", mediaPlatFileIdCrc='" + this.f304883g + "'}";
    }
}
