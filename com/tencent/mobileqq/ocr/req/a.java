package com.tencent.mobileqq.ocr.req;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.FileUtils;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f254765a;

    /* renamed from: b, reason: collision with root package name */
    public int f254766b;

    /* renamed from: c, reason: collision with root package name */
    public String f254767c;

    /* renamed from: d, reason: collision with root package name */
    public String f254768d;

    /* renamed from: e, reason: collision with root package name */
    public long f254769e;

    /* renamed from: f, reason: collision with root package name */
    public String f254770f;

    /* renamed from: g, reason: collision with root package name */
    public String f254771g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f254772h;

    /* renamed from: i, reason: collision with root package name */
    public int f254773i;

    /* renamed from: j, reason: collision with root package name */
    public int f254774j;

    /* renamed from: k, reason: collision with root package name */
    public long f254775k;

    /* renamed from: l, reason: collision with root package name */
    public String f254776l;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Boolean) iPatchRedirector.redirect((short) 1, (Object) this)).booleanValue();
        }
        if (this.f254773i > 0 && this.f254774j > 0 && FileUtils.fileExistsAndNotEmpty(this.f254768d)) {
            return true;
        }
        return false;
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        this.f254768d = "";
        this.f254767c = "";
        this.f254776l = "";
        this.f254765a = "";
        this.f254770f = "";
        this.f254771g = "";
        this.f254772h = false;
        this.f254775k = 0L;
        this.f254769e = 0L;
        this.f254773i = 0;
        this.f254774j = 0;
    }

    public void c(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
        } else {
            this.f254772h = z16;
        }
    }

    public void d(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        } else {
            this.f254765a = str;
        }
    }

    public void e(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        } else {
            this.f254767c = str;
        }
    }

    public String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "OCRReqContext{chatType=" + this.f254766b + ", imagePath='" + this.f254767c + "', compressPath='" + this.f254768d + "', oriMd5='" + this.f254770f + "', comMd5='" + this.f254771g + "', hasCrop=" + this.f254772h + "', comWidth=" + this.f254773i + "', comHeiht=" + this.f254774j + "', serverUrl=" + this.f254776l + "', seqNumber=" + this.f254775k + "'}";
    }
}
