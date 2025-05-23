package com.tencent.mobileqq.facetoface;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes12.dex */
public class g extends e {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    public boolean f205760c;

    /* renamed from: d, reason: collision with root package name */
    public String f205761d;

    /* renamed from: e, reason: collision with root package name */
    public String f205762e;

    public g(String str, boolean z16, String str2, String str3) {
        super(1, str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Boolean.valueOf(z16), str2, str3);
            return;
        }
        this.f205760c = z16;
        this.f205761d = str2;
        this.f205762e = str3;
    }
}
