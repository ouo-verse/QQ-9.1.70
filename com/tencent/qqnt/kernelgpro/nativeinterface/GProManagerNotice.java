package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProManagerNotice {
    public long createTimeSec;
    public long guildId;
    public boolean needNotify;
    public String noticeTitle = "";
    public String noticeContent = "";

    public long getCreateTimeSec() {
        return this.createTimeSec;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public boolean getNeedNotify() {
        return this.needNotify;
    }

    public String getNoticeContent() {
        return this.noticeContent;
    }

    public String getNoticeTitle() {
        return this.noticeTitle;
    }

    public String toString() {
        return "GProManagerNotice{guildId=" + this.guildId + ",needNotify=" + this.needNotify + ",createTimeSec=" + this.createTimeSec + ",noticeTitle=" + this.noticeTitle + ",noticeContent=" + this.noticeContent + ",}";
    }
}
