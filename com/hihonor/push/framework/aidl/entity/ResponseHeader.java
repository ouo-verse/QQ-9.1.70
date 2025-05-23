package com.hihonor.push.framework.aidl.entity;

import com.hihonor.push.framework.aidl.IMessageEntity;
import com.hihonor.push.framework.aidl.annotation.Packed;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ResponseHeader implements IMessageEntity {

    @Packed
    public int statusCode;

    @Packed
    public String statusMessage;

    public ResponseHeader() {
        this.statusCode = -1;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public String getStatusMessage() {
        return this.statusMessage;
    }

    public void setStatusCode(int i3) {
        this.statusCode = i3;
    }

    public void setStatusMessage(String str) {
        this.statusMessage = str;
    }

    public ResponseHeader(int i3, String str) {
        this.statusCode = i3;
        this.statusMessage = str;
    }
}
