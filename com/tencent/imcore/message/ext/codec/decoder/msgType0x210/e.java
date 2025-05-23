package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import tencent.im.s2c.msgtype0x210.submsgtype0x117.submsgtype0x117$MsgBody;

/* compiled from: P */
/* loaded from: classes7.dex */
public class e implements a<com.tencent.imcore.message.af> {
    static IPatchRedirector $redirector_;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void b(byte[] bArr) {
        if (bArr == null) {
            return;
        }
        submsgtype0x117$MsgBody submsgtype0x117_msgbody = new submsgtype0x117$MsgBody();
        try {
            submsgtype0x117_msgbody.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        List<Integer> list = submsgtype0x117_msgbody.rpt_uint32_moudle_id.get();
        long j3 = submsgtype0x117_msgbody.uint64_uin.get();
        if (list != null && list.size() != 0) {
            StringBuilder sb5 = new StringBuilder(HardCodeUtil.qqStr(R.string.oye));
            sb5.append(j3);
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                if (intValue == 92) {
                    sb5.append("|\u97f3\u89c6\u9891");
                } else if (intValue == 93) {
                    sb5.append("|\u53cc\u4eba");
                } else if (intValue == 94) {
                    sb5.append("|\u591a\u4eba");
                }
            }
            sb5.append("\u3011");
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SuMsgType0x117 \u97f3\u89c6\u9891\u6d4b\u8bd5\u73af\u5883push" + sb5.toString());
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SuMsgType0x117 \u97f3\u89c6\u9891\u6d4b\u8bd5\u73af\u5883push,moudleIds==null || moudleIds.size()== 0");
        }
    }

    @Override // com.tencent.imcore.message.ext.codec.decoder.msgType0x210.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public MessageRecord decode(com.tencent.imcore.message.af afVar, MsgType0x210 msgType0x210, long j3, byte[] bArr, MsgInfo msgInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 2, this, afVar, msgType0x210, Long.valueOf(j3), bArr, msgInfo);
        }
        b(msgType0x210.vProtobuf);
        return null;
    }
}
