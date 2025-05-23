package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class SearchNetSugInfo {
    public int sugWordType;
    public String sugWord = "";
    public String hitKeyWord = "";
    public SearchFloatButtonIcon icon = new SearchFloatButtonIcon();
    public String tag = "";
    public String stringExtension = "";

    public String getHitKeyWord() {
        return this.hitKeyWord;
    }

    public SearchFloatButtonIcon getIcon() {
        return this.icon;
    }

    public String getStringExtension() {
        return this.stringExtension;
    }

    public String getSugWord() {
        return this.sugWord;
    }

    public int getSugWordType() {
        return this.sugWordType;
    }

    public String getTag() {
        return this.tag;
    }

    public String toString() {
        return "SearchNetSugInfo{sugWord=" + this.sugWord + ",hitKeyWord=" + this.hitKeyWord + ",icon=" + this.icon + ",tag=" + this.tag + ",sugWordType=" + this.sugWordType + ",stringExtension=" + this.stringExtension + ",}";
    }
}
