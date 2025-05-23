package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGuildNavIconTheme {
    public String iconSelectorColor;
    public String iconSelectorUrl;
    public ArrayList<GProGuildNavIconInfo> icons;

    public GProGuildNavIconTheme() {
        this.iconSelectorColor = "";
        this.iconSelectorUrl = "";
        this.icons = new ArrayList<>();
    }

    public String getIconSelectorColor() {
        return this.iconSelectorColor;
    }

    public String getIconSelectorUrl() {
        return this.iconSelectorUrl;
    }

    public ArrayList<GProGuildNavIconInfo> getIcons() {
        return this.icons;
    }

    public String toString() {
        return "GProGuildNavIconTheme{iconSelectorColor=" + this.iconSelectorColor + ",iconSelectorUrl=" + this.iconSelectorUrl + ",icons=" + this.icons + ",}";
    }

    public GProGuildNavIconTheme(String str, String str2, ArrayList<GProGuildNavIconInfo> arrayList) {
        this.iconSelectorColor = "";
        this.iconSelectorUrl = "";
        new ArrayList();
        this.iconSelectorColor = str;
        this.iconSelectorUrl = str2;
        this.icons = arrayList;
    }
}
