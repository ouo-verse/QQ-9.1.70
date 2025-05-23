package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.InstructionReceiver;
import java.util.HashMap;
import java.util.List;
import tencent.im.s2c.msgtype0x210.submsgtype0x14a.MsgBody;

/* compiled from: P */
/* loaded from: classes7.dex */
public class v implements a<com.tencent.imcore.message.af> {
    static IPatchRedirector $redirector_;

    public v() {
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
        InstructionReceiver instructionReceiver = InstructionReceiver.getInstance();
        if (QLog.isColorLevel()) {
            QLog.d("SubType0x14a", 1, "start decode");
        }
        MsgBody msgBody = new MsgBody();
        try {
            msgBody.mergeFrom(bArr);
            int i3 = msgBody.enum_cmd.get();
            if (QLog.isColorLevel()) {
                QLog.d("SubType0x14a", 1, "cmd::" + i3);
            }
            List<MsgBody.Param> list = msgBody.rpt_msg_params.get();
            HashMap hashMap = new HashMap();
            if (list != null) {
                for (MsgBody.Param param : list) {
                    String str = param.string_key.get();
                    String stringUtf8 = param.bytes_value.get().toStringUtf8();
                    hashMap.put(str, stringUtf8);
                    if (QLog.isColorLevel()) {
                        QLog.d("SubType0x14a", 1, str + MsgSummary.STR_COLON + stringUtf8);
                    }
                }
            } else {
                QLog.e("SubType0x14a", 1, "params are null");
            }
            instructionReceiver.analyzeInstruction(i3, hashMap);
            return null;
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("SubType0x14a", 1, e16.toString());
            return null;
        }
    }
}
