package com.tencent.turingfd.sdk.xq;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class White implements ITuringDID {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Gemini f383216a;

    public White(Gemini gemini) {
        this.f383216a = gemini;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) gemini);
        }
    }

    @Override // com.tencent.turingfd.sdk.xq.ITuringDID
    public String getAIDCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return ((Sultana) this.f383216a).f383119g;
    }

    @Override // com.tencent.turingfd.sdk.xq.ITuringDID
    public String getAIDTicket() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return ((Sultana) this.f383216a).f383118f;
    }

    @Override // com.tencent.turingfd.sdk.xq.ITuringDID
    public int getErrorCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return ((Sultana) this.f383216a).f383115c;
    }

    @Override // com.tencent.turingfd.sdk.xq.ITuringDID
    public long getExpiredTimestamp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        return ((Sultana) this.f383216a).f383114b;
    }

    @Override // com.tencent.turingfd.sdk.xq.ITuringDID
    public String getOpenIdTicket() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return ((Sultana) this.f383216a).f383113a;
    }

    @Override // com.tencent.turingfd.sdk.xq.ITuringDID
    public String getTAIDTicket() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return ((Sultana) this.f383216a).f383117e;
    }
}
