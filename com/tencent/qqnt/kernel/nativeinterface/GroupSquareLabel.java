package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupSquareLabel {
    public int labelAttr;
    public int labelType;
    public String name = "";
    public GroupSquareColor textColor = new GroupSquareColor();
    public GroupSquareColor edgingColor = new GroupSquareColor();
    public String labelValue = "";
    public String icon = "";

    public GroupSquareColor getEdgingColor() {
        return this.edgingColor;
    }

    public String getIcon() {
        return this.icon;
    }

    public int getLabelAttr() {
        return this.labelAttr;
    }

    public int getLabelType() {
        return this.labelType;
    }

    public String getLabelValue() {
        return this.labelValue;
    }

    public String getName() {
        return this.name;
    }

    public GroupSquareColor getTextColor() {
        return this.textColor;
    }

    public String toString() {
        return "GroupSquareLabel{name=" + this.name + ",textColor=" + this.textColor + ",edgingColor=" + this.edgingColor + ",labelAttr=" + this.labelAttr + ",labelType=" + this.labelType + ",labelValue=" + this.labelValue + ",icon=" + this.icon + ",}";
    }
}
