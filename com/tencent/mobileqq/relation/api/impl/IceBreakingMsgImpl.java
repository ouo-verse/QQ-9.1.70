package com.tencent.mobileqq.relation.api.impl;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.relation.api.IIceBreakingMsg;
import com.tencent.mobileqq.relationx.icebreaking.IceBreakingMng;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes17.dex */
public class IceBreakingMsgImpl implements IIceBreakingMsg {
    static IPatchRedirector $redirector_;

    public IceBreakingMsgImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.relation.api.IIceBreakingMsg
    public void handleGetIceBreakHotPicResponse(AppRuntime appRuntime, byte[] bArr, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, appRuntime, bArr, str);
        } else if ("BreakIceSvr.Pull".equals(str) && (appRuntime instanceof QQAppInterface)) {
            ((IceBreakingMng) appRuntime.getManager(QQManagerFactory.ICE_BREAKING_MNG)).A(bArr);
        }
    }
}
