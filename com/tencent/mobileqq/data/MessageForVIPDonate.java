package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes10.dex */
public class MessageForVIPDonate extends ChatMessage {
    public static final String DEFAULT_SUMMARYMSG = "[QQ\u4f1a\u5458\u8d60\u9001]";
    public VIPDonateMsg donateMsg;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.ChatMessage
    public void doParse() {
        try {
            this.donateMsg = (VIPDonateMsg) MessagePkgUtils.getObjectFromBytes(this.msgData);
            if (QLog.isColorLevel()) {
                QLog.d("MessageForVIPDonate", 2, "doParse :VIPDonateMsg = " + this.donateMsg);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.mobileqq.data.ChatMessage
    public String getSummaryMsg() {
        VIPDonateMsg vIPDonateMsg = this.donateMsg;
        if (vIPDonateMsg != null && !TextUtils.isEmpty(vIPDonateMsg.brief)) {
            return this.donateMsg.brief;
        }
        return DEFAULT_SUMMARYMSG;
    }

    @Override // com.tencent.mobileqq.data.ChatMessage
    public boolean isSupportReply() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    public void postRead() {
        parse();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    public void prewrite() {
        if (this.donateMsg != null) {
            if (QLog.isColorLevel()) {
                QLog.d("MessageForVIPDonate", 2, "prewrite :VIPDonateMsg = " + this.donateMsg);
            }
            try {
                this.msgData = MessagePkgUtils.getBytesFromObject(this.donateMsg);
                return;
            } catch (Exception e16) {
                e16.printStackTrace();
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("MessageForVIPDonate", 2, "prewrite :VIPDonateMsg = null");
        }
    }
}
