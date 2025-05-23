package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class UfsLabel {
    public int attr;
    public int enumType;
    public int type;
    public UfsColor edgingColor = new UfsColor();
    public String name = "";
    public UfsColor textColor = new UfsColor();

    public int getAttr() {
        return this.attr;
    }

    public UfsColor getEdgingColor() {
        return this.edgingColor;
    }

    public int getEnumType() {
        return this.enumType;
    }

    public String getName() {
        return this.name;
    }

    public UfsColor getTextColor() {
        return this.textColor;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        return "UfsLabel{attr=" + this.attr + ",edgingColor=" + this.edgingColor + ",enumType=" + this.enumType + ",name=" + this.name + ",textColor=" + this.textColor + ",type=" + this.type + ",}";
    }
}
