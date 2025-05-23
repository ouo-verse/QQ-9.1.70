package com.tencent.qqnt.kernelgpro.nativeinterface;

import com.tencent.smtt.sdk.stat.MttLoader;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProSaveGuildNavigationReq {
    public long guildId;
    public String iconSelectorColor;
    public ArrayList<GProSaveNavigationItem> items;
    public long version;

    public GProSaveGuildNavigationReq() {
        this.iconSelectorColor = "";
        this.items = new ArrayList<>();
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String getIconSelectorColor() {
        return this.iconSelectorColor;
    }

    public ArrayList<GProSaveNavigationItem> getItems() {
        return this.items;
    }

    public long getVersion() {
        return this.version;
    }

    public void setGuildId(long j3) {
        this.guildId = j3;
    }

    public void setIconSelectorColor(String str) {
        this.iconSelectorColor = str;
    }

    public void setItems(ArrayList<GProSaveNavigationItem> arrayList) {
        this.items = arrayList;
    }

    public void setVersion(long j3) {
        this.version = j3;
    }

    public String toString() {
        return "GProSaveGuildNavigationReq{guildId=" + this.guildId + ",iconSelectorColor=" + this.iconSelectorColor + ",items=" + this.items + MttLoader.QQBROWSER_PARAMS_VERSION + this.version + ",}";
    }

    public GProSaveGuildNavigationReq(long j3, String str, ArrayList<GProSaveNavigationItem> arrayList, long j16) {
        this.iconSelectorColor = "";
        new ArrayList();
        this.guildId = j3;
        this.iconSelectorColor = str;
        this.items = arrayList;
        this.version = j16;
    }
}
