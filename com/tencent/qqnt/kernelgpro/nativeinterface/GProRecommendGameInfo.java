package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProRecommendGameInfo implements Serializable {
    public String icon;

    /* renamed from: id, reason: collision with root package name */
    public int f359310id;
    public GProRecommendModeInfo modeInfo;
    public String name;
    long serialVersionUID;

    public GProRecommendGameInfo() {
        this.serialVersionUID = 1L;
        this.name = "";
        this.icon = "";
        this.modeInfo = new GProRecommendModeInfo();
    }

    public String getIcon() {
        return this.icon;
    }

    public int getId() {
        return this.f359310id;
    }

    public GProRecommendModeInfo getModeInfo() {
        return this.modeInfo;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return "GProRecommendGameInfo{id=" + this.f359310id + ",name=" + this.name + ",icon=" + this.icon + ",modeInfo=" + this.modeInfo + ",}";
    }

    public GProRecommendGameInfo(int i3, String str, String str2, GProRecommendModeInfo gProRecommendModeInfo) {
        this.serialVersionUID = 1L;
        this.name = "";
        this.icon = "";
        new GProRecommendModeInfo();
        this.f359310id = i3;
        this.name = str;
        this.icon = str2;
        this.modeInfo = gProRecommendModeInfo;
    }
}
