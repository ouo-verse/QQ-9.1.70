package com.tencent.qqnt.kernelgpro.nativeinterface;

import com.tencent.smtt.sdk.stat.MttLoader;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProSaveCustomApplicationReq {
    public int action;
    public long guildId;
    public String iconSelectorColor = "";
    public ArrayList<GProSaveNavigationItem> items = new ArrayList<>();
    public long version;

    public int getAction() {
        return this.action;
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

    public String toString() {
        return "GProSaveCustomApplicationReq{guildId=" + this.guildId + ",iconSelectorColor=" + this.iconSelectorColor + ",items=" + this.items + MttLoader.QQBROWSER_PARAMS_VERSION + this.version + ",action=" + this.action + ",}";
    }
}
