package com.tencent.mobileqq.multimsg.api.impl;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.multimsg.api.IMultiMsg;
import com.tencent.mobileqq.multimsg.api.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MultiMsgImpl implements IMultiMsg {
    static IPatchRedirector $redirector_;

    public MultiMsgImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.multimsg.api.IMultiMsg
    public a getMultiMsgValue() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        SessionInfo H = MultiMsgManager.w().H();
        a aVar = new a();
        aVar.f251588a = com.tencent.mobileqq.service.message.remote.a.b(MultiMsgManager.w().x());
        if (H != null) {
            aVar.f251591d = H;
            aVar.f251590c = H.f179557e;
            aVar.f251589b = H.f179555d;
        }
        return aVar;
    }

    @Override // com.tencent.mobileqq.multimsg.api.IMultiMsg
    public String getPicDefaultPath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return MultiMsgManager.F((QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime());
    }

    @Override // com.tencent.mobileqq.multimsg.api.IMultiMsg
    public long getPicDefaultSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
        }
        return MultiMsgManager.G();
    }
}
