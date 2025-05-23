package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGetPreviewNavigationRsp {
    public GProGuildNavigationInfo guildNavigation = new GProGuildNavigationInfo();
    public ArrayList<GProGuildNavIconTheme> iconThemes = new ArrayList<>();
    public int total;

    public GProGuildNavigationInfo getGuildNavigation() {
        return this.guildNavigation;
    }

    public ArrayList<GProGuildNavIconTheme> getIconThemes() {
        return this.iconThemes;
    }

    public int getTotal() {
        return this.total;
    }

    public String toString() {
        return "GProGetPreviewNavigationRsp{guildNavigation=" + this.guildNavigation + ",iconThemes=" + this.iconThemes + ",total=" + this.total + ",}";
    }
}
