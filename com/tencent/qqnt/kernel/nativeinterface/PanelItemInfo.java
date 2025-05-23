package com.tencent.qqnt.kernel.nativeinterface;

import com.tencent.mobileqq.haoliyou.JefsClass;

/* loaded from: classes24.dex */
public final class PanelItemInfo {
    public String name = "";
    public String icon = "";
    public String url = "";
    public String color = "";
    public String fontColor = "";
    public String borderColor = "";

    public String getBorderColor() {
        return this.borderColor;
    }

    public String getColor() {
        return this.color;
    }

    public String getFontColor() {
        return this.fontColor;
    }

    public String getIcon() {
        return this.icon;
    }

    public String getName() {
        return this.name;
    }

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return "PanelItemInfo{name=" + this.name + ",icon=" + this.icon + JefsClass.INDEX_URL + this.url + ",color=" + this.color + ",fontColor=" + this.fontColor + ",borderColor=" + this.borderColor + ",}";
    }
}
