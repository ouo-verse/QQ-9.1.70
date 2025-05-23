package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class SearchHistoryItem {
    public int searchHistoryId;
    public SearchHistoryType type = SearchHistoryType.values()[0];
    public ArrayList<SearchContactItem> contactList = new ArrayList<>();
    public ArrayList<SearchGroupItem> groupInfos = new ArrayList<>();
    public ArrayList<SearchMsgItem> msgs = new ArrayList<>();
    public ArrayList<SearchFileItem> fileInfos = new ArrayList<>();
    public ArrayList<SearchFunctionItem> functionList = new ArrayList<>();
    public SearchPhoneItem phoneItem = new SearchPhoneItem();

    public ArrayList<SearchContactItem> getContactList() {
        return this.contactList;
    }

    public ArrayList<SearchFileItem> getFileInfos() {
        return this.fileInfos;
    }

    public ArrayList<SearchFunctionItem> getFunctionList() {
        return this.functionList;
    }

    public ArrayList<SearchGroupItem> getGroupInfos() {
        return this.groupInfos;
    }

    public ArrayList<SearchMsgItem> getMsgs() {
        return this.msgs;
    }

    public SearchPhoneItem getPhoneItem() {
        return this.phoneItem;
    }

    public int getSearchHistoryId() {
        return this.searchHistoryId;
    }

    public SearchHistoryType getType() {
        return this.type;
    }

    public String toString() {
        return "SearchHistoryItem{searchHistoryId=" + this.searchHistoryId + ",type=" + this.type + ",contactList=" + this.contactList + ",groupInfos=" + this.groupInfos + ",msgs=" + this.msgs + ",fileInfos=" + this.fileInfos + ",functionList=" + this.functionList + ",phoneItem=" + this.phoneItem + ",}";
    }
}
