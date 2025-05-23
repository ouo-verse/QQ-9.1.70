package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProStNotice {
    public int datongType;
    public boolean isCloseInteract;
    public int status;
    public int type;
    public GProStFeed psvFeed = new GProStFeed();
    public GProStFeed origineFeed = new GProStFeed();
    public GProStNoticePattonInfo pattonInfo = new GProStNoticePattonInfo();
    public String guildNumber = "";

    public int getDatongType() {
        return this.datongType;
    }

    public String getGuildNumber() {
        return this.guildNumber;
    }

    public boolean getIsCloseInteract() {
        return this.isCloseInteract;
    }

    public GProStFeed getOrigineFeed() {
        return this.origineFeed;
    }

    public GProStNoticePattonInfo getPattonInfo() {
        return this.pattonInfo;
    }

    public GProStFeed getPsvFeed() {
        return this.psvFeed;
    }

    public int getStatus() {
        return this.status;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        return "GProStNotice{psvFeed=" + this.psvFeed + ",origineFeed=" + this.origineFeed + ",pattonInfo=" + this.pattonInfo + ",datongType=" + this.datongType + ",type=" + this.type + ",status=" + this.status + ",guildNumber=" + this.guildNumber + ",isCloseInteract=" + this.isCloseInteract + ",}";
    }
}
