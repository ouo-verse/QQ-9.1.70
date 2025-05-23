package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class SearchBuddyInfoParams {
    public boolean excludeSelf;
    public ArrayList<String> keyWords = new ArrayList<>();
    public int pageLimit;
    public int robotShowType;
    public int searchType;

    public boolean getExcludeSelf() {
        return this.excludeSelf;
    }

    public ArrayList<String> getKeyWords() {
        return this.keyWords;
    }

    public int getPageLimit() {
        return this.pageLimit;
    }

    public int getRobotShowType() {
        return this.robotShowType;
    }

    public int getSearchType() {
        return this.searchType;
    }

    public String toString() {
        return "SearchBuddyInfoParams{searchType=" + this.searchType + ",robotShowType=" + this.robotShowType + ",excludeSelf=" + this.excludeSelf + ",keyWords=" + this.keyWords + ",pageLimit=" + this.pageLimit + ",}";
    }
}
