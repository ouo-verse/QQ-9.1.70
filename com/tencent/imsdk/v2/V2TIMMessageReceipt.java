package com.tencent.imsdk.v2;

import com.tencent.imsdk.message.MessageReceipt;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes7.dex */
public class V2TIMMessageReceipt implements Serializable {
    private MessageReceipt messageReceipt;

    public long getTimestamp() {
        MessageReceipt messageReceipt = this.messageReceipt;
        if (messageReceipt != null) {
            return messageReceipt.getReceiptTimestamp();
        }
        return 0L;
    }

    public String getUserID() {
        MessageReceipt messageReceipt = this.messageReceipt;
        if (messageReceipt != null) {
            return messageReceipt.getUserID();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setMessageReceipt(MessageReceipt messageReceipt) {
        this.messageReceipt = messageReceipt;
    }
}
