package com.tencent.mobileqq.troop.troopgag.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public boolean f300230a;

    /* renamed from: b, reason: collision with root package name */
    public long f300231b;

    public b(boolean z16, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), Long.valueOf(j3));
        } else {
            this.f300230a = z16;
            this.f300231b = j3;
        }
    }
}
