package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.now.enter.pb.NowPushMsgList$MsgBody;
import com.tencent.mobileqq.now.enter.pb.NowPushMsgList$NowPushMsg;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes7.dex */
public class cf implements a<com.tencent.imcore.message.af> {
    static IPatchRedirector $redirector_;

    public cf() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void b(com.tencent.imcore.message.af afVar, MsgType0x210 msgType0x210) {
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "onLinePush receive 0x210_0xfb");
        }
        try {
            NowPushMsgList$MsgBody nowPushMsgList$MsgBody = new NowPushMsgList$MsgBody();
            if (afVar.L(msgType0x210)) {
                nowPushMsgList$MsgBody.mergeFrom(msgType0x210.vProtobuf);
                for (NowPushMsgList$NowPushMsg nowPushMsgList$NowPushMsg : nowPushMsgList$MsgBody.rpt_now_push_msg.get()) {
                    ((rb2.a) afVar.d().getManager(QQManagerFactory.NOW_HONG_BAO_PUSH_MANAGER)).d(nowPushMsgList$NowPushMsg);
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.msg.BaseMessageProcessor", 2, "onLinePush receive 0x210_0xfb " + nowPushMsgList$NowPushMsg.uint32_switch.get() + "  uint32_task_id " + nowPushMsgList$NowPushMsg.uint32_task_id.get() + "  uint32_type " + nowPushMsgList$NowPushMsg.uint32_type.get() + "  uint64_start_time " + nowPushMsgList$NowPushMsg.uint64_start_time.get() + "  uint64_end_time " + nowPushMsgList$NowPushMsg.uint64_end_time.get());
                    }
                }
            }
        } catch (Exception e16) {
            QLog.e("Q.msg.BaseMessageProcessor", 1, "[msg0x210.uSubMsgType == 0xfb], errInfo->" + e16.getMessage());
        }
    }

    @Override // com.tencent.imcore.message.ext.codec.decoder.msgType0x210.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public MessageRecord decode(com.tencent.imcore.message.af afVar, MsgType0x210 msgType0x210, long j3, byte[] bArr, MsgInfo msgInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 2, this, afVar, msgType0x210, Long.valueOf(j3), bArr, msgInfo);
        }
        b(afVar, msgType0x210);
        return null;
    }
}
