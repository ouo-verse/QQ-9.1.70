package com.tencent.tfd.sdk.wxa;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class Core implements ITuringDID {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Cimplements f375567a;

    public Core(Cimplements cimplements) {
        this.f375567a = cimplements;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) cimplements);
        }
    }

    @Override // com.tencent.tfd.sdk.wxa.ITuringDID
    public final String getAIDCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return ((Cantaloupe) this.f375567a).f375501g;
    }

    @Override // com.tencent.tfd.sdk.wxa.ITuringDID
    public final String getAIDTicket() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return ((Cantaloupe) this.f375567a).f375500f;
    }

    @Override // com.tencent.tfd.sdk.wxa.ITuringDID
    public final int getErrorCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return ((Cantaloupe) this.f375567a).f375497c;
    }

    @Override // com.tencent.tfd.sdk.wxa.ITuringDID
    public final long getExpiredTimestamp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        return ((Cantaloupe) this.f375567a).f375496b;
    }

    @Override // com.tencent.tfd.sdk.wxa.ITuringDID
    public final String getOpenIdTicket() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return ((Cantaloupe) this.f375567a).f375495a;
    }

    @Override // com.tencent.tfd.sdk.wxa.ITuringDID
    public final String getTAIDTicket() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return ((Cantaloupe) this.f375567a).f375499e;
    }
}
