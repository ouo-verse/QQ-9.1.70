package com.tencent.mobileqq.activity.guild;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService;
import com.tencent.mobileqq.guild.message.base.d;
import com.tencent.mobileqq.troop.data.c;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a extends d {

    /* renamed from: a, reason: collision with root package name */
    private static String f182451a = "GuildMsgProcessorTextMsgCallback";

    private static void d(AppInterface appInterface, c cVar, c cVar2, MessageRecord messageRecord) {
        if (cVar == null) {
            return;
        }
        cVar2.f294893c.j(14, messageRecord.uniseq);
        cVar2.f294893c.j(25, messageRecord.uniseq);
        IGuildMsgSeqTimeService.a readedMsgSeq = ((IGuildMsgSeqTimeService) appInterface.getRuntimeService(IGuildMsgSeqTimeService.class, "")).getReadedMsgSeq(String.valueOf(messageRecord.frienduin));
        if (messageRecord.shmsgseq > readedMsgSeq.f230119d && cVar2.h()) {
            cVar.i(cVar2);
            messageRecord.mMessageInfo = cVar2;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f182451a, 2, "updateCurMsgInfo: mMessageInfo + " + messageRecord.mMessageInfo + ", messageRecord.shmsgseq = " + messageRecord.shmsgseq + ", readedMsgSeq.msgSeq = " + readedMsgSeq.f230119d + ", curMsgInfo.hasFlag() = " + cVar2.h());
        }
    }

    @Override // com.tencent.mobileqq.guild.message.base.d
    public void a(AppInterface appInterface, c cVar, c cVar2, MessageRecord messageRecord) {
        d(appInterface, cVar, cVar2, messageRecord);
    }

    @Override // com.tencent.mobileqq.guild.message.base.d
    public void b(MessageRecord messageRecord, MessageRecord messageRecord2) {
        if ((messageRecord instanceof MessageForText) && (messageRecord2 instanceof MessageForText)) {
            if (messageRecord.getRepeatCount() > 0) {
                messageRecord2.setRepeatCount(messageRecord.getRepeatCount());
                if (QLog.isColorLevel()) {
                    QLog.d(f182451a, 2, "onHandleSelfSendMsg ===> update findMr.repeatCount=" + messageRecord2.getRepeatCount());
                }
            }
            messageRecord2.saveExtInfoToExtStr("key_message_extra_info_flag", messageRecord.getExtInfoFromExtStr("key_message_extra_info_flag"));
        }
    }
}
