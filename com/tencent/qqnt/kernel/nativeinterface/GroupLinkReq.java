package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupLinkReq {
    public String additionalParam;
    public long groupCode;
    public boolean needShortUrl;
    public int srcId;

    public GroupLinkReq() {
        this.additionalParam = "";
    }

    public String getAdditionalParam() {
        return this.additionalParam;
    }

    public long getGroupCode() {
        return this.groupCode;
    }

    public boolean getNeedShortUrl() {
        return this.needShortUrl;
    }

    public int getSrcId() {
        return this.srcId;
    }

    public String toString() {
        return "GroupLinkReq{groupCode=" + this.groupCode + ",srcId=" + this.srcId + ",additionalParam=" + this.additionalParam + ",needShortUrl=" + this.needShortUrl + ",}";
    }

    public GroupLinkReq(long j3, int i3, String str, boolean z16) {
        this.groupCode = j3;
        this.srcId = i3;
        this.additionalParam = str;
        this.needShortUrl = z16;
    }
}
