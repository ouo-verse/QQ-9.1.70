package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GetGroupSquareRedpointInfoRsp {
    public String content = "";
    public String ext = "";
    public int groupClassId;
    public long nextRequestTime;
    public boolean showRedpoint;

    public String getContent() {
        return this.content;
    }

    public String getExt() {
        return this.ext;
    }

    public int getGroupClassId() {
        return this.groupClassId;
    }

    public long getNextRequestTime() {
        return this.nextRequestTime;
    }

    public boolean getShowRedpoint() {
        return this.showRedpoint;
    }

    public String toString() {
        return "GetGroupSquareRedpointInfoRsp{content=" + this.content + ",showRedpoint=" + this.showRedpoint + ",nextRequestTime=" + this.nextRequestTime + ",groupClassId=" + this.groupClassId + ",ext=" + this.ext + ",}";
    }
}
