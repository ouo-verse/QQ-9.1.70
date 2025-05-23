package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class StyleFunction {
    public String title = "";
    public ArrayList<StyleList> styleList = new ArrayList<>();

    public ArrayList<StyleList> getStyleList() {
        return this.styleList;
    }

    public String getTitle() {
        return this.title;
    }

    public String toString() {
        return "StyleFunction{title=" + this.title + ",styleList=" + this.styleList + ",}";
    }
}
