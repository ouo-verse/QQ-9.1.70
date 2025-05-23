package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class SearchLocalInfoResult {

    /* renamed from: id, reason: collision with root package name */
    public int f359215id;
    public SearchLocalInfoType type = SearchLocalInfoType.values()[0];
    public ArrayList<SearchBuddyItem> buddyList = new ArrayList<>();
    public ArrayList<SearchContactItem> contactList = new ArrayList<>();
    public ArrayList<SearchGroupItem> groupInfos = new ArrayList<>();
    public ArrayList<SearchChatSummaryItem> chatsSummary = new ArrayList<>();
    public ArrayList<SearchFileItem> fileInfos = new ArrayList<>();
    public ArrayList<SearchGameItem> gameInfos = new ArrayList<>();
    public ArrayList<SearchFunctionItem> functions = new ArrayList<>();
    public String recallReason = "";
    public String realKeywords = "";

    public ArrayList<SearchBuddyItem> getBuddyList() {
        return this.buddyList;
    }

    public ArrayList<SearchChatSummaryItem> getChatsSummary() {
        return this.chatsSummary;
    }

    public ArrayList<SearchContactItem> getContactList() {
        return this.contactList;
    }

    public ArrayList<SearchFileItem> getFileInfos() {
        return this.fileInfos;
    }

    public ArrayList<SearchFunctionItem> getFunctions() {
        return this.functions;
    }

    public ArrayList<SearchGameItem> getGameInfos() {
        return this.gameInfos;
    }

    public ArrayList<SearchGroupItem> getGroupInfos() {
        return this.groupInfos;
    }

    public int getId() {
        return this.f359215id;
    }

    public String getRealKeywords() {
        return this.realKeywords;
    }

    public String getRecallReason() {
        return this.recallReason;
    }

    public SearchLocalInfoType getType() {
        return this.type;
    }

    public String toString() {
        return "SearchLocalInfoResult{id=" + this.f359215id + ",type=" + this.type + ",buddyList=" + this.buddyList + ",contactList=" + this.contactList + ",groupInfos=" + this.groupInfos + ",chatsSummary=" + this.chatsSummary + ",fileInfos=" + this.fileInfos + ",gameInfos=" + this.gameInfos + ",functions=" + this.functions + ",recallReason=" + this.recallReason + ",realKeywords=" + this.realKeywords + ",}";
    }
}
