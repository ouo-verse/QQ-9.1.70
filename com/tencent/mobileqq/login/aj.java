package com.tencent.mobileqq.login;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import oicq.wlogin_sdk.tools.ErrMsg;

/* compiled from: P */
/* loaded from: classes15.dex */
public class aj {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f241864a;

    /* renamed from: b, reason: collision with root package name */
    public int f241865b;

    /* renamed from: c, reason: collision with root package name */
    public String f241866c;

    /* renamed from: d, reason: collision with root package name */
    public ErrMsg f241867d;

    /* renamed from: e, reason: collision with root package name */
    public String f241868e;

    /* renamed from: f, reason: collision with root package name */
    public byte[] f241869f;

    /* renamed from: g, reason: collision with root package name */
    public byte[] f241870g;

    /* renamed from: h, reason: collision with root package name */
    public String f241871h;

    public aj() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public aj(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) str);
        } else {
            this.f241864a = i3;
            this.f241866c = str;
        }
    }

    public aj(int i3, int i16, String str, ErrMsg errMsg, String str2, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16), str, errMsg, str2, bArr);
            return;
        }
        this.f241864a = i3;
        this.f241865b = i16;
        this.f241866c = str;
        this.f241867d = errMsg;
        this.f241868e = str2;
        this.f241869f = bArr;
    }

    public aj(int i3, int i16, String str, ErrMsg errMsg, String str2, byte[] bArr, byte[] bArr2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16), str, errMsg, str2, bArr, bArr2);
            return;
        }
        this.f241864a = i3;
        this.f241865b = i16;
        this.f241866c = str;
        this.f241867d = errMsg;
        this.f241868e = str2;
        this.f241869f = bArr;
        this.f241870g = bArr2;
    }
}
