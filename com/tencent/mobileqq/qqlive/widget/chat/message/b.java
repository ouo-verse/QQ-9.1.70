package com.tencent.mobileqq.qqlive.widget.chat.message;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.data.message.LiveMessageData;

/* compiled from: P */
/* loaded from: classes17.dex */
public class b implements f {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public LiveMessageData.SpeakerInfo f273851d;

    /* renamed from: e, reason: collision with root package name */
    private i f273852e;

    public b(LiveMessageData.SpeakerInfo speakerInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) speakerInfo);
        } else {
            this.f273852e = new i();
            this.f273851d = speakerInfo;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.widget.chat.message.f
    public i getHeader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (i) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f273852e;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "EnterRoomMsg{SpeakerName=" + this.f273851d.mSpeakerName + '}';
    }
}
