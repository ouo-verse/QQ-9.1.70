package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import tencent.im.s2c.msgtype0x210.submsgtype0x98.submsgtype0x98$MsgBody;

/* compiled from: P */
/* loaded from: classes7.dex */
public class bj implements a<com.tencent.imcore.message.af> {
    static IPatchRedirector $redirector_;

    public bj() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void b(MsgType0x210 msgType0x210) {
        submsgtype0x98$MsgBody submsgtype0x98_msgbody = new submsgtype0x98$MsgBody();
        try {
            submsgtype0x98_msgbody.mergeFrom(msgType0x210.vProtobuf);
        } catch (Throwable unused) {
        }
        submsgtype0x98_msgbody.uint64_uin.get();
        submsgtype0x98_msgbody.uint32_sub_cmd.get();
        submsgtype0x98_msgbody.msg_mod_block.get().uint32_op.get();
    }

    @Override // com.tencent.imcore.message.ext.codec.decoder.msgType0x210.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public MessageRecord decode(com.tencent.imcore.message.af afVar, MsgType0x210 msgType0x210, long j3, byte[] bArr, MsgInfo msgInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 2, this, afVar, msgType0x210, Long.valueOf(j3), bArr, msgInfo);
        }
        b(msgType0x210);
        return null;
    }
}
