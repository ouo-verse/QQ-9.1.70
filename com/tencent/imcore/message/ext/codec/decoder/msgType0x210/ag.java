package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqsec.api.ISafeBlockApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import tencent.im.s2c.msgtype0x210.submsgtype0x15b.SubMsgType0x15b$LoginNotify;

/* compiled from: P */
/* loaded from: classes7.dex */
public class ag implements a<com.tencent.imcore.message.af> {
    static IPatchRedirector $redirector_;

    public ag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.imcore.message.ext.codec.decoder.msgType0x210.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public MessageRecord decode(com.tencent.imcore.message.af afVar, MsgType0x210 msgType0x210, long j3, byte[] bArr, MsgInfo msgInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 2, this, afVar, msgType0x210, Long.valueOf(j3), bArr, msgInfo);
        }
        SubMsgType0x15b$LoginNotify subMsgType0x15b$LoginNotify = new SubMsgType0x15b$LoginNotify();
        try {
            subMsgType0x15b$LoginNotify.mergeFrom(bArr);
            ((ISafeBlockApi) QRoute.api(ISafeBlockApi.class)).handleLoginOnlinePush(subMsgType0x15b$LoginNotify.uint32_seq.get(), subMsgType0x15b$LoginNotify.bytes_title.get().toStringUtf8(), subMsgType0x15b$LoginNotify.bytes_wording.get().toStringUtf8());
            return null;
        } catch (Exception e16) {
            QLog.w("SubType0x15b", 1, "merge from exception", e16);
            return null;
        }
    }
}
