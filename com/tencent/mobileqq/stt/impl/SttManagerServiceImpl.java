package com.tencent.mobileqq.stt.impl;

import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.stt.ISttManagerService;
import com.tencent.mobileqq.stt.SttManager;
import com.tencent.mobileqq.stt.a;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SttManagerServiceImpl implements ISttManagerService {
    static IPatchRedirector $redirector_;
    SttManager sttManager;

    public SttManagerServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.stt.ISttManagerService
    public boolean isTranslating(MessageForPtt messageForPtt) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) messageForPtt)).booleanValue();
        }
        SttManager sttManager = this.sttManager;
        if (sttManager != null) {
            return sttManager.e(messageForPtt);
        }
        return false;
    }

    @Override // com.tencent.mobileqq.stt.ISttManagerService
    public boolean needAuotoChange(MessageForPtt messageForPtt) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) messageForPtt)).booleanValue();
        }
        SttManager sttManager = this.sttManager;
        if (sttManager != null) {
            return sttManager.g(messageForPtt);
        }
        return false;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) appRuntime);
        } else {
            this.sttManager = new SttManager(appRuntime);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        SttManager sttManager = this.sttManager;
        if (sttManager != null) {
            sttManager.onDestroy();
        }
    }

    @Override // com.tencent.mobileqq.stt.ISttManagerService
    public void onSttResultPush(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) bArr);
            return;
        }
        SttManager sttManager = this.sttManager;
        if (sttManager != null) {
            sttManager.j(bArr);
        }
    }

    @Override // com.tencent.mobileqq.stt.ISttManagerService
    public Long queryVideoSubtitle(String str, String str2, int i3, String str3, a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Long) iPatchRedirector.redirect((short) 5, this, str, str2, Integer.valueOf(i3), str3, aVar);
        }
        SttManager sttManager = this.sttManager;
        if (sttManager != null) {
            return sttManager.k(str, str2, i3, str3, aVar);
        }
        return -1L;
    }

    @Override // com.tencent.mobileqq.stt.ISttManagerService
    public void setListener(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) aVar);
            return;
        }
        SttManager sttManager = this.sttManager;
        if (sttManager != null) {
            sttManager.l(aVar);
        }
    }

    @Override // com.tencent.mobileqq.stt.ISttManagerService
    public Long translate(MessageForPtt messageForPtt, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Long) iPatchRedirector.redirect((short) 3, (Object) this, (Object) messageForPtt, i3);
        }
        SttManager sttManager = this.sttManager;
        if (sttManager != null) {
            return sttManager.o(messageForPtt, i3);
        }
        return -1L;
    }

    @Override // com.tencent.mobileqq.stt.ISttManagerService
    public Long translateVideoSubtitle(MessageForPtt messageForPtt, String str, a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Long) iPatchRedirector.redirect((short) 6, this, messageForPtt, str, aVar);
        }
        SttManager sttManager = this.sttManager;
        if (sttManager != null) {
            return sttManager.q(messageForPtt, str, aVar);
        }
        return -1L;
    }

    @Override // com.tencent.mobileqq.stt.ISttManagerService
    public Long translate(MessageForPtt messageForPtt, int i3, a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Long) iPatchRedirector.redirect((short) 4, this, messageForPtt, Integer.valueOf(i3), aVar);
        }
        SttManager sttManager = this.sttManager;
        if (sttManager != null) {
            return sttManager.p(messageForPtt, i3, aVar);
        }
        return -1L;
    }
}
