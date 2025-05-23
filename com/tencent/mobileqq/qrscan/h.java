package com.tencent.mobileqq.qrscan;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public byte[] f276637a;

    /* renamed from: b, reason: collision with root package name */
    public int f276638b;

    /* renamed from: c, reason: collision with root package name */
    public int f276639c;

    /* renamed from: d, reason: collision with root package name */
    public String f276640d;

    public h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public String toString() {
        int length;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("ImageData{previewData length=");
        byte[] bArr = this.f276637a;
        if (bArr == null) {
            length = 0;
        } else {
            length = bArr.length;
        }
        sb5.append(length);
        sb5.append(", previewW=");
        sb5.append(this.f276638b);
        sb5.append(", previewH=");
        sb5.append(this.f276639c);
        sb5.append(", imagePath='");
        sb5.append(this.f276640d);
        sb5.append('\'');
        sb5.append('}');
        return sb5.toString();
    }
}
