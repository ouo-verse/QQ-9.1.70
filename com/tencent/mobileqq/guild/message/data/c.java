package com.tencent.mobileqq.guild.message.data;

import com.tencent.mobileqq.data.MessageForAniSticker;
import com.tencent.mobileqq.data.MessageRecord;

/* compiled from: P */
/* loaded from: classes33.dex */
public class c extends com.tencent.mobileqq.guild.message.base.d {
    @Override // com.tencent.mobileqq.guild.message.base.d
    public void c(com.tencent.imcore.message.f fVar, MessageRecord messageRecord, MessageRecord messageRecord2) {
        if (messageRecord.isSendFromLocal() && (messageRecord2 instanceof MessageForAniSticker) && (messageRecord instanceof MessageForAniSticker)) {
            MessageForAniSticker messageForAniSticker = (MessageForAniSticker) messageRecord2;
            MessageForAniSticker messageForAniSticker2 = (MessageForAniSticker) messageRecord;
            messageForAniSticker2.resultId = messageForAniSticker.resultId;
            messageForAniSticker2.packId = messageForAniSticker.packId;
            messageForAniSticker2.stickerId = messageForAniSticker.stickerId;
            messageForAniSticker2.sevrId = messageForAniSticker.sevrId;
            messageForAniSticker2.sourceType = messageForAniSticker.sourceType;
            messageForAniSticker2.stickerType = messageForAniSticker.stickerType;
            messageForAniSticker2.randomType = messageForAniSticker.randomType;
            byte[] serializeMsgData = messageForAniSticker2.serializeMsgData();
            messageForAniSticker2.msgData = serializeMsgData;
            fVar.B0(messageForAniSticker2.frienduin, 10014, messageForAniSticker2.uniseq, serializeMsgData);
        }
    }
}
