package com.tencent.imsdk.relationship;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public class FriendSearchParam implements Serializable {
    public static final int FIELD_ID_NICK_NAME = 2;
    public static final int FIELD_ID_REMARK = 4;
    public static final int FIELD_ID_USER_ID = 1;
    private List<String> keywordList;
    private List<Integer> searchFieldList = new ArrayList();

    public void addSearchField(int i3) {
        this.searchFieldList.add(Integer.valueOf(i3));
    }

    public List<String> getKeywordList() {
        return this.keywordList;
    }

    public void removeSearchField(int i3) {
        this.searchFieldList.remove(Integer.valueOf(i3));
    }

    public void setKeywordList(List<String> list) {
        this.keywordList = list;
    }
}
