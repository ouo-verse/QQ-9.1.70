package com.tencent.mobileqq.data;

import com.tencent.imcore.message.ad;
import com.tencent.mobileqq.app.message.RecordForTest;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MessageForLongTextMsg extends MessageForText {
    public boolean loading;

    @RecordForTest
    public StructMsgForGeneralShare structingMsg;
    public String mResid = null;
    public String mFileName = null;
    public long mFileSize = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.MessageForText, com.tencent.mobileqq.data.RecommendCommonMessage, com.tencent.mobileqq.data.ChatMessage
    public void doParse() {
        doParse(false);
    }

    @Override // com.tencent.mobileqq.data.MessageForText, com.tencent.mobileqq.data.ChatMessage
    public String getSummaryMsg() {
        return this.charStr.toString();
    }

    @Override // com.tencent.mobileqq.data.MessageForText, com.tencent.mobileqq.data.MessageRecord
    public boolean isSupportFTS() {
        return ad.s(this.istroop);
    }

    @Override // com.tencent.mobileqq.data.MessageForText, com.tencent.mobileqq.data.ChatMessage
    public boolean isSupportReply() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.MessageForText, com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    public void postRead() {
        super.postRead();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.MessageForText, com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    public void prewrite() {
        super.prewrite();
    }
}
