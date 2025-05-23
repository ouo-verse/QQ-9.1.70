package com.tencent.biz.qqcircle.beans;

/* loaded from: classes4.dex */
public class QFSPublishTempInfo {
    private boolean mIsHdr;
    private String mLocalPath;

    public String getLocalPath() {
        return this.mLocalPath;
    }

    public boolean isHdr() {
        return this.mIsHdr;
    }

    public QFSPublishTempInfo setIsHdr(boolean z16) {
        this.mIsHdr = z16;
        return this;
    }

    public QFSPublishTempInfo setLocalPath(String str) {
        this.mLocalPath = str;
        return this;
    }
}
