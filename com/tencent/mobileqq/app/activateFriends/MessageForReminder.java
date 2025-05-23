package com.tencent.mobileqq.app.activateFriends;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import tencent.im.s2c.msgtype0x210.submsgtype0x13a.submsgtype0x13a$MsgBody;

/* compiled from: P */
/* loaded from: classes11.dex */
public class MessageForReminder extends c<submsgtype0x13a$MsgBody> {
    static IPatchRedirector $redirector_;

    public MessageForReminder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.reminder.db.c
    public submsgtype0x13a$MsgBody createMsgBody() throws InvalidProtocolBufferMicroException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (submsgtype0x13a$MsgBody) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        submsgtype0x13a$MsgBody submsgtype0x13a_msgbody = new submsgtype0x13a$MsgBody();
        submsgtype0x13a_msgbody.mergeFrom(this.msgData);
        return submsgtype0x13a_msgbody;
    }
}
