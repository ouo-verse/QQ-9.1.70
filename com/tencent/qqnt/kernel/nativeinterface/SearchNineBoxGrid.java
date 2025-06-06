package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class SearchNineBoxGrid {
    public SearchInteractiveComponents interactiveComponents;
    public boolean isLongPost;
    public int nineBoxGridType;
    public SearchText title = new SearchText();
    public SearchButton button = new SearchButton();
    public SearchIcon icon = new SearchIcon();
    public SearchText text = new SearchText();
    public ArrayList<SearchNineBoxContent> contentList = new ArrayList<>();
    public SearchIcon describe = new SearchIcon();
    public String stringExtension = "";
    public SearchRichText richText = new SearchRichText();
    public SearchIcon bizIcon = new SearchIcon();
    public SearchIcon tag = new SearchIcon();

    public SearchIcon getBizIcon() {
        return this.bizIcon;
    }

    public SearchButton getButton() {
        return this.button;
    }

    public ArrayList<SearchNineBoxContent> getContentList() {
        return this.contentList;
    }

    public SearchIcon getDescribe() {
        return this.describe;
    }

    public SearchIcon getIcon() {
        return this.icon;
    }

    public SearchInteractiveComponents getInteractiveComponents() {
        return this.interactiveComponents;
    }

    public boolean getIsLongPost() {
        return this.isLongPost;
    }

    public int getNineBoxGridType() {
        return this.nineBoxGridType;
    }

    public SearchRichText getRichText() {
        return this.richText;
    }

    public String getStringExtension() {
        return this.stringExtension;
    }

    public SearchIcon getTag() {
        return this.tag;
    }

    public SearchText getText() {
        return this.text;
    }

    public SearchText getTitle() {
        return this.title;
    }

    public String toString() {
        return "SearchNineBoxGrid{title=" + this.title + ",button=" + this.button + ",icon=" + this.icon + ",text=" + this.text + ",contentList=" + this.contentList + ",describe=" + this.describe + ",stringExtension=" + this.stringExtension + ",nineBoxGridType=" + this.nineBoxGridType + ",richText=" + this.richText + ",bizIcon=" + this.bizIcon + ",interactiveComponents=" + this.interactiveComponents + ",isLongPost=" + this.isLongPost + ",tag=" + this.tag + ",}";
    }
}
