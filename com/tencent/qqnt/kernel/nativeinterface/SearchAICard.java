package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class SearchAICard {
    public SearchText title = new SearchText();
    public SearchText content = new SearchText();
    public SearchVerticalList reference = new SearchVerticalList();
    public SearchText bottomTitle = new SearchText();
    public ArrayList<SearchText> reportTextList = new ArrayList<>();
    public SearchAIInfo aiInfo = new SearchAIInfo();
    public SearchButton button = new SearchButton();
    public SearchIcon icon = new SearchIcon();
    public String packageName = "";

    public SearchAIInfo getAiInfo() {
        return this.aiInfo;
    }

    public SearchText getBottomTitle() {
        return this.bottomTitle;
    }

    public SearchButton getButton() {
        return this.button;
    }

    public SearchText getContent() {
        return this.content;
    }

    public SearchIcon getIcon() {
        return this.icon;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public SearchVerticalList getReference() {
        return this.reference;
    }

    public ArrayList<SearchText> getReportTextList() {
        return this.reportTextList;
    }

    public SearchText getTitle() {
        return this.title;
    }

    public String toString() {
        return "SearchAICard{title=" + this.title + ",content=" + this.content + ",reference=" + this.reference + ",bottomTitle=" + this.bottomTitle + ",reportTextList=" + this.reportTextList + ",aiInfo=" + this.aiInfo + ",button=" + this.button + ",icon=" + this.icon + ",packageName=" + this.packageName + ",}";
    }
}
