package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProGlobalBanner {
    public long operateTime;
    public long operatorTinyId;
    public String guildId = "";
    public String bannerId = "";
    public GProGuildBannerBizId bizId = new GProGuildBannerBizId();
    public byte[] content = new byte[0];
    public GProGuildBannerGameDownloadInfo bannerGameDownloadeInfo = new GProGuildBannerGameDownloadInfo();

    public GProGuildBannerGameDownloadInfo getBannerGameDownloadeInfo() {
        return this.bannerGameDownloadeInfo;
    }

    public String getBannerId() {
        return this.bannerId;
    }

    public GProGuildBannerBizId getBizId() {
        return this.bizId;
    }

    public byte[] getContent() {
        return this.content;
    }

    public String getGuildId() {
        return this.guildId;
    }

    public long getOperateTime() {
        return this.operateTime;
    }

    public long getOperatorTinyId() {
        return this.operatorTinyId;
    }

    public void setBannerGameDownloadeInfo(GProGuildBannerGameDownloadInfo gProGuildBannerGameDownloadInfo) {
        this.bannerGameDownloadeInfo = gProGuildBannerGameDownloadInfo;
    }

    public void setBannerId(String str) {
        this.bannerId = str;
    }

    public void setBizId(GProGuildBannerBizId gProGuildBannerBizId) {
        this.bizId = gProGuildBannerBizId;
    }

    public void setContent(byte[] bArr) {
        this.content = bArr;
    }

    public void setGuildId(String str) {
        this.guildId = str;
    }

    public void setOperateTime(long j3) {
        this.operateTime = j3;
    }

    public void setOperatorTinyId(long j3) {
        this.operatorTinyId = j3;
    }

    public String toString() {
        return "GProGlobalBanner{guildId=" + this.guildId + ",operateTime=" + this.operateTime + ",operatorTinyId=" + this.operatorTinyId + ",bannerId=" + this.bannerId + ",bizId=" + this.bizId + ",content=" + this.content + ",bannerGameDownloadeInfo=" + this.bannerGameDownloadeInfo + ",}";
    }
}
