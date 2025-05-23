package com.tencent.mobileqq.msg.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IMessageRecordFactory;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.service.message.q;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MessageRecordFactoryImpl implements IMessageRecordFactory {
    static IPatchRedirector $redirector_;

    public MessageRecordFactoryImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageRecordFactory
    public MessageRecord createMessageForStructing(BaseQQAppInterface baseQQAppInterface, String str, int i3, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 10, this, baseQQAppInterface, str, Integer.valueOf(i3), str2, str3);
        }
        if (baseQQAppInterface instanceof QQAppInterface) {
            return q.b((QQAppInterface) baseQQAppInterface, str, i3, str2, str3);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageRecordFactory
    public MessageRecord createMsgRecordByMsgType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }
        return q.d(i3);
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageRecordFactory
    public MessageRecord createMsgRecordFromDB(int i3, byte[] bArr, int i16, String str, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), bArr, Integer.valueOf(i16), str, Integer.valueOf(i17));
        }
        return q.l(i3, bArr, i16, str, i17);
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageRecordFactory
    public MessageRecord createResendMsg(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 4, (Object) this, (Object) messageRecord);
        }
        return q.n(messageRecord);
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageRecordFactory
    public MessageRecord createSendMSg_BlessPTV(BaseQQAppInterface baseQQAppInterface, String str, String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 7, this, baseQQAppInterface, str, str2, Integer.valueOf(i3));
        }
        if (baseQQAppInterface instanceof QQAppInterface) {
            return q.o((QQAppInterface) baseQQAppInterface, str, str2, i3);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageRecordFactory
    public MessageRecord createSendMSg_Pic(AppInterface appInterface, String str, String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 8, this, appInterface, str, str2, Integer.valueOf(i3));
        }
        return q.q((QQAppInterface) appInterface, str, str2, i3);
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageRecordFactory
    public MessageRecord createSendMSg_ShortVideo(BaseQQAppInterface baseQQAppInterface, String str, String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 5, this, baseQQAppInterface, str, str2, Integer.valueOf(i3));
        }
        if (baseQQAppInterface instanceof QQAppInterface) {
            return q.s((QQAppInterface) baseQQAppInterface, str, str2, i3);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageRecordFactory
    public MessageRecord createSendMSg_VideoEmoticon(BaseQQAppInterface baseQQAppInterface, String str, String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 6, this, baseQQAppInterface, str, str2, Integer.valueOf(i3));
        }
        if (baseQQAppInterface instanceof QQAppInterface) {
            return q.t((QQAppInterface) baseQQAppInterface, str, str2, i3);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageRecordFactory
    public void setSendingMsgRecordBaseInfo(AppRuntime appRuntime, MessageRecord messageRecord, String str, String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, appRuntime, messageRecord, str, str2, Integer.valueOf(i3));
        } else if (appRuntime instanceof QQAppInterface) {
            q.I((QQAppInterface) appRuntime, messageRecord, str, str2, i3);
        }
    }
}
