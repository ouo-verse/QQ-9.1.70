package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupTopBannerInfo {
    public int bannerType;
    public int bizType;
    public long exprieTime;
    public byte[] msgId = new byte[0];
    public GameTeamUpBanner teamUpBanner = new GameTeamUpBanner();
    public TodoBanner toDoBanner = new TodoBanner();
    public InteractionBanner interactionBanner = new InteractionBanner();
    public NotifyBanner notifyBanner = new NotifyBanner();
    public GroupBannerPriority bannerPriority = new GroupBannerPriority();

    public GroupBannerPriority getBannerPriority() {
        return this.bannerPriority;
    }

    public int getBannerType() {
        return this.bannerType;
    }

    public int getBizType() {
        return this.bizType;
    }

    public long getExprieTime() {
        return this.exprieTime;
    }

    public InteractionBanner getInteractionBanner() {
        return this.interactionBanner;
    }

    public byte[] getMsgId() {
        return this.msgId;
    }

    public NotifyBanner getNotifyBanner() {
        return this.notifyBanner;
    }

    public GameTeamUpBanner getTeamUpBanner() {
        return this.teamUpBanner;
    }

    public TodoBanner getToDoBanner() {
        return this.toDoBanner;
    }

    public String toString() {
        return "GroupTopBannerInfo{bizType=" + this.bizType + ",bannerType=" + this.bannerType + ",msgId=" + this.msgId + ",exprieTime=" + this.exprieTime + ",teamUpBanner=" + this.teamUpBanner + ",toDoBanner=" + this.toDoBanner + ",interactionBanner=" + this.interactionBanner + ",notifyBanner=" + this.notifyBanner + ",bannerPriority=" + this.bannerPriority + ",}";
    }
}
