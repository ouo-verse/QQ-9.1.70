package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProNoticeText {
    public String content = "";
    public long linkId;
    public int type;

    public String getContent() {
        return this.content;
    }

    public long getLinkId() {
        return this.linkId;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        return "GProNoticeText{type=" + this.type + ",content=" + this.content + ",linkId=" + this.linkId + ",}";
    }
}
