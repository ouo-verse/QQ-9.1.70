package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProStPlainTxtInfo {
    public int noticeType;
    public GProStNoticeTxtInfo txtInfo = new GProStNoticeTxtInfo();
    public GProNoticeOperation operation = new GProNoticeOperation();

    public int getNoticeType() {
        return this.noticeType;
    }

    public GProNoticeOperation getOperation() {
        return this.operation;
    }

    public GProStNoticeTxtInfo getTxtInfo() {
        return this.txtInfo;
    }

    public String toString() {
        return "GProStPlainTxtInfo{txtInfo=" + this.txtInfo + ",operation=" + this.operation + ",noticeType=" + this.noticeType + ",}";
    }
}
