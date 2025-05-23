package com.tencent.mobileqq.troop.troopgag.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes19.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f300234a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f300235b;

    /* renamed from: c, reason: collision with root package name */
    public String f300236c;

    /* renamed from: d, reason: collision with root package name */
    public long f300237d;

    public d(String str, boolean z16, String str2, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Boolean.valueOf(z16), str2, Long.valueOf(j3));
            return;
        }
        this.f300234a = str;
        this.f300235b = z16;
        this.f300236c = str2;
        this.f300237d = j3;
    }
}
