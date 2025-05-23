package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class StyleList {
    public String type = "";
    public String icon = "";
    public ArrayList<StyleData> styleData = new ArrayList<>();

    public String getIcon() {
        return this.icon;
    }

    public ArrayList<StyleData> getStyleData() {
        return this.styleData;
    }

    public String getType() {
        return this.type;
    }

    public String toString() {
        return "StyleList{type=" + this.type + ",icon=" + this.icon + ",styleData=" + this.styleData + ",}";
    }
}
