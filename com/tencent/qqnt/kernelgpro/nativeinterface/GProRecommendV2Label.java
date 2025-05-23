package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProRecommendV2Label implements Serializable {
    public GProRecommendV2Color edgingColor;
    public int labelAttr;
    public int labelType;
    public String name;
    long serialVersionUID;
    public GProRecommendV2Color textColor;

    public GProRecommendV2Label() {
        this.serialVersionUID = 1L;
        this.name = "";
        this.textColor = new GProRecommendV2Color();
        this.edgingColor = new GProRecommendV2Color();
    }

    public GProRecommendV2Color getEdgingColor() {
        return this.edgingColor;
    }

    public int getLabelAttr() {
        return this.labelAttr;
    }

    public int getLabelType() {
        return this.labelType;
    }

    public String getName() {
        return this.name;
    }

    public GProRecommendV2Color getTextColor() {
        return this.textColor;
    }

    public String toString() {
        return "GProRecommendV2Label{name=" + this.name + ",textColor=" + this.textColor + ",edgingColor=" + this.edgingColor + ",labelAttr=" + this.labelAttr + ",labelType=" + this.labelType + ",}";
    }

    public GProRecommendV2Label(String str, GProRecommendV2Color gProRecommendV2Color, GProRecommendV2Color gProRecommendV2Color2, int i3, int i16) {
        this.serialVersionUID = 1L;
        this.name = "";
        this.textColor = new GProRecommendV2Color();
        new GProRecommendV2Color();
        this.name = str;
        this.textColor = gProRecommendV2Color;
        this.edgingColor = gProRecommendV2Color2;
        this.labelAttr = i3;
        this.labelType = i16;
    }
}
