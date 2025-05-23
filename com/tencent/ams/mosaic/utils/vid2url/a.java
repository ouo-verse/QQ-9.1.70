package com.tencent.ams.mosaic.utils.vid2url;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f71575a;

    /* renamed from: b, reason: collision with root package name */
    public String f71576b;

    /* renamed from: c, reason: collision with root package name */
    public String f71577c;

    /* renamed from: d, reason: collision with root package name */
    public int f71578d;

    /* renamed from: e, reason: collision with root package name */
    public int f71579e;

    /* renamed from: f, reason: collision with root package name */
    public long f71580f;

    /* renamed from: g, reason: collision with root package name */
    public String f71581g;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.f71580f = -1L;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return super.toString() + "[url: " + this.f71575a + ", vid: " + this.f71577c + ", md5: " + this.f71576b + ", fileSize: " + this.f71578d + ", progress: " + this.f71579e + ", format: " + this.f71581g + "]";
    }

    public a(String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, str2, str3);
            return;
        }
        this.f71577c = str;
        this.f71576b = str2;
        this.f71579e = 0;
        this.f71575a = str3;
        this.f71580f = 0L;
    }
}
