package com.tencent.mobileqq.data;

import com.tencent.mobileqq.data.MessageRecord;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MessageRecordDummyCallback implements MessageRecord.Callback {
    @Override // com.tencent.mobileqq.data.MessageRecord.Callback
    public String getTableName(MessageRecord messageRecord) {
        return MessageRecord.getTableName(messageRecord.frienduin, messageRecord.istroop);
    }

    @Override // com.tencent.mobileqq.data.MessageRecord.Callback
    public boolean isSend(MessageRecord messageRecord) {
        return com.tencent.mobileqq.service.message.remote.a.b(messageRecord.issend);
    }
}
