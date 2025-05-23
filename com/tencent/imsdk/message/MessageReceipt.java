package com.tencent.imsdk.message;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes7.dex */
public class MessageReceipt implements Serializable {
    private long receiptTimestamp;
    private String userID;

    public long getReceiptTimestamp() {
        return this.receiptTimestamp;
    }

    public String getUserID() {
        return this.userID;
    }
}
