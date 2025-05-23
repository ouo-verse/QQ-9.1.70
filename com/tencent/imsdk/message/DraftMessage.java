package com.tencent.imsdk.message;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes7.dex */
public class DraftMessage implements Serializable {
    private long editTime;
    private Message message;
    private byte[] userDefinedData;

    public long getEditTime() {
        return this.editTime;
    }

    public byte[] getUserDefinedData() {
        return this.userDefinedData;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public void setUserDefinedData(byte[] bArr) {
        this.userDefinedData = bArr;
    }
}
