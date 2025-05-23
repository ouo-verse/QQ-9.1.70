package com.tencent.mobileqq.guild.message.data;

import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;

/* compiled from: P */
/* loaded from: classes33.dex */
public class d extends com.tencent.mobileqq.guild.message.base.d {
    private void d(MessageRecord messageRecord, MessageRecord messageRecord2) {
        MessageForPic messageForPic = (MessageForPic) messageRecord;
        MessageForPic messageForPic2 = (MessageForPic) messageRecord2;
        messageForPic.picExtraData = messageForPic2.picExtraData;
        messageForPic.groupFileID = messageForPic2.groupFileID;
        messageForPic.bigMsgUrl = messageForPic2.bigMsgUrl;
        messageForPic.rawMsgUrl = messageForPic2.rawMsgUrl;
        messageForPic.serial();
    }

    @Override // com.tencent.mobileqq.guild.message.base.d
    public void c(com.tencent.imcore.message.f fVar, MessageRecord messageRecord, MessageRecord messageRecord2) {
        if (messageRecord.isSendFromLocal()) {
            if ((messageRecord2 instanceof MessageForPic) && (messageRecord instanceof MessageForPic)) {
                d(messageRecord, messageRecord2);
                fVar.B0(messageRecord.frienduin, 10014, messageRecord.uniseq, messageRecord.msgData);
            }
            if ((messageRecord2 instanceof MessageForMixedMsg) && (messageRecord instanceof MessageForMixedMsg)) {
                for (MessageRecord messageRecord3 : ((MessageForMixedMsg) messageRecord2).msgElemList) {
                    if (messageRecord3 instanceof MessageForPic) {
                        for (MessageRecord messageRecord4 : ((MessageForMixedMsg) messageRecord).msgElemList) {
                            if ((messageRecord4 instanceof MessageForPic) && ((MessageForPic) messageRecord4).subMsgId == ((MessageForPic) messageRecord3).subMsgId) {
                                d(messageRecord4, messageRecord3);
                            }
                        }
                    }
                }
                ((MessageForMixedMsg) messageRecord).prewrite();
                fVar.B0(messageRecord.frienduin, 10014, messageRecord.uniseq, messageRecord.msgData);
            }
        }
    }
}
