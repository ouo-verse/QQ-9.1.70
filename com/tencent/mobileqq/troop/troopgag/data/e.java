package com.tencent.mobileqq.troop.troopgag.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes19.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f300238a;

    /* renamed from: b, reason: collision with root package name */
    public long f300239b;

    public e(String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Long.valueOf(j3));
        } else {
            this.f300238a = str;
            this.f300239b = j3;
        }
    }
}
