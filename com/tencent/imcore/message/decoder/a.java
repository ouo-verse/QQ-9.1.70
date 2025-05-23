package com.tencent.imcore.message.decoder;

import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.app.AppRuntime;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76$MsgBody;

/* compiled from: P */
/* loaded from: classes7.dex */
public class a implements j {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.imcore.message.decoder.j
    public void a(Message message, IMessageManager iMessageManager, AppRuntime appRuntime) throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, message, iMessageManager, appRuntime);
        } else if (message.msgtype == -5003) {
            SubMsgType0x76$MsgBody subMsgType0x76$MsgBody = new SubMsgType0x76$MsgBody();
            subMsgType0x76$MsgBody.mergeFrom(message.msgData);
            message.f203106msg = ActivateFriendsManager.r(appRuntime.getApp(), subMsgType0x76$MsgBody);
        }
    }
}
