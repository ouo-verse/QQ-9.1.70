package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class ShareTopicRsp {
    public String arkJson = "";
    public String picUrl = "";
    public String title = "";
    public String desc = "";
    public String jumpUrl = "";

    public String getArkJson() {
        return this.arkJson;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getJumpUrl() {
        return this.jumpUrl;
    }

    public String getPicUrl() {
        return this.picUrl;
    }

    public String getTitle() {
        return this.title;
    }

    public String toString() {
        return "ShareTopicRsp{arkJson=" + this.arkJson + ",picUrl=" + this.picUrl + ",title=" + this.title + ",desc=" + this.desc + ",jumpUrl=" + this.jumpUrl + ",}";
    }
}
