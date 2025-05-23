package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProGetNavigationRsp {
    public GProGuildNavigationInfo guildNavigation;

    public GProGetNavigationRsp() {
        this.guildNavigation = new GProGuildNavigationInfo();
    }

    public GProGuildNavigationInfo getGuildNavigation() {
        return this.guildNavigation;
    }

    public String toString() {
        return "GProGetNavigationRsp{guildNavigation=" + this.guildNavigation + ",}";
    }

    public GProGetNavigationRsp(GProGuildNavigationInfo gProGuildNavigationInfo) {
        new GProGuildNavigationInfo();
        this.guildNavigation = gProGuildNavigationInfo;
    }
}
