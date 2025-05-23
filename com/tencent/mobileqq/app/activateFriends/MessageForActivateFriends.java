package com.tencent.mobileqq.app.activateFriends;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76$MsgBody;

/* compiled from: P */
/* loaded from: classes11.dex */
public class MessageForActivateFriends extends c<SubMsgType0x76$MsgBody> {
    static IPatchRedirector $redirector_;

    public MessageForActivateFriends() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.reminder.db.c
    public SubMsgType0x76$MsgBody createMsgBody() throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (SubMsgType0x76$MsgBody) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        SubMsgType0x76$MsgBody subMsgType0x76$MsgBody = new SubMsgType0x76$MsgBody();
        subMsgType0x76$MsgBody.mergeFrom(this.msgData);
        return subMsgType0x76$MsgBody;
    }
}
