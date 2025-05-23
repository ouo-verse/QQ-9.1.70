package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.operation.QQOperationViopTipTask;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import tencent.im.s2c.msgtype0x210.submsgtype0x54.submsgtype0x54$MsgBody;

/* compiled from: P */
/* loaded from: classes7.dex */
public class au implements a<com.tencent.imcore.message.af> {
    static IPatchRedirector $redirector_;

    public au() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void b(QQAppInterface qQAppInterface, MsgType0x210 msgType0x210) {
        int i3;
        if (QLog.isColorLevel()) {
            QLog.d("QQOperateVoIP", 2, "get voip_tips from handleC2COnlinePushMsg0x210Resp");
        }
        ConfigHandler configHandler = (ConfigHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER);
        if (configHandler != null) {
            submsgtype0x54$MsgBody submsgtype0x54_msgbody = new submsgtype0x54$MsgBody();
            try {
                submsgtype0x54_msgbody.mergeFrom(msgType0x210.vProtobuf);
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
            }
            int i16 = submsgtype0x54_msgbody.peer_type.get();
            List<submsgtype0x54$MsgBody.TaskInfo> list = submsgtype0x54_msgbody.task_list.get();
            ArrayList<QQOperationViopTipTask> arrayList = new ArrayList<>();
            if (list != null && list.size() > 0) {
                for (submsgtype0x54$MsgBody.TaskInfo taskInfo : list) {
                    QQOperationViopTipTask qQOperationViopTipTask = new QQOperationViopTipTask();
                    qQOperationViopTipTask.taskid = taskInfo.task_id.get();
                    arrayList.add(qQOperationViopTipTask);
                }
            }
            String valueOf = String.valueOf(submsgtype0x54_msgbody.peer_uin.get());
            if (i16 == 1) {
                i3 = 0;
            } else {
                i3 = 3000;
            }
            configHandler.n3(valueOf, i3, arrayList);
        }
    }

    @Override // com.tencent.imcore.message.ext.codec.decoder.msgType0x210.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public MessageRecord decode(com.tencent.imcore.message.af afVar, MsgType0x210 msgType0x210, long j3, byte[] bArr, MsgInfo msgInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 2, this, afVar, msgType0x210, Long.valueOf(j3), bArr, msgInfo);
        }
        b((QQAppInterface) afVar.d(), msgType0x210);
        return null;
    }
}
