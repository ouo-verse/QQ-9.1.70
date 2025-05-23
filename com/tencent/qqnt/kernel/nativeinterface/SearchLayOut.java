package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class SearchLayOut {
    public float bottomCorner;
    public boolean fullWidthLayout;
    public String highlight = "";
    public float marginTop;
    public boolean showBottomDivider;
    public boolean showDivider;
    public float topCorner;
    public boolean useOneCard;

    public float getBottomCorner() {
        return this.bottomCorner;
    }

    public boolean getFullWidthLayout() {
        return this.fullWidthLayout;
    }

    public String getHighlight() {
        return this.highlight;
    }

    public float getMarginTop() {
        return this.marginTop;
    }

    public boolean getShowBottomDivider() {
        return this.showBottomDivider;
    }

    public boolean getShowDivider() {
        return this.showDivider;
    }

    public float getTopCorner() {
        return this.topCorner;
    }

    public boolean getUseOneCard() {
        return this.useOneCard;
    }

    public String toString() {
        return "SearchLayOut{highlight=" + this.highlight + ",marginTop=" + this.marginTop + ",topCorner=" + this.topCorner + ",bottomCorner=" + this.bottomCorner + ",showDivider=" + this.showDivider + ",useOneCard=" + this.useOneCard + ",fullWidthLayout=" + this.fullWidthLayout + ",showBottomDivider=" + this.showBottomDivider + ",}";
    }
}
