package com.tencent.mobileqq.data;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import localpb.richMsg.SafeMsg$SafeMoreInfo;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MessageForSafeGrayTips extends ChatMessage {
    private String TAG = "Q.msg.SafeGrayTips";
    public SafeMsg$SafeMoreInfo safeInfo;

    @Override // com.tencent.mobileqq.data.ChatMessage
    public void doParse() {
        this.safeInfo = new SafeMsg$SafeMoreInfo();
        QLog.d(this.TAG, 2, "doParse versionCode:" + this.versionCode);
        if (this.versionCode < 3) {
            super.postRead();
            QLog.d(this.TAG, 2, "doParse oldversion");
            return;
        }
        try {
            this.safeInfo.mergeFrom(this.msgData);
            QLog.d(this.TAG, 2, "doParse msg:");
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
            QLog.d(this.TAG, 2, "dopase exception:" + e16.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    public void postRead() {
        this.msgId = MessageRecord.getLogicMsgID(getId(), this.versionCode);
        parse();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    public void prewrite() {
        QLog.d(this.TAG, 2, "prewrite versionCode:" + this.versionCode);
        if (this.versionCode < 3) {
            super.prewrite();
            return;
        }
        SafeMsg$SafeMoreInfo safeMsg$SafeMoreInfo = this.safeInfo;
        if (safeMsg$SafeMoreInfo == null) {
            return;
        }
        this.msgData = safeMsg$SafeMoreInfo.toByteArray();
    }
}
