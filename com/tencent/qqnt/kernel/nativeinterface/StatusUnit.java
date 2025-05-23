package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class StatusUnit {
    public boolean isNeedContinueQuery;
    public int status;
    public String mediaId = "";
    public String errMsg = "";

    public String getErrMsg() {
        return this.errMsg;
    }

    public boolean getIsNeedContinueQuery() {
        return this.isNeedContinueQuery;
    }

    public String getMediaId() {
        return this.mediaId;
    }

    public int getStatus() {
        return this.status;
    }
}
