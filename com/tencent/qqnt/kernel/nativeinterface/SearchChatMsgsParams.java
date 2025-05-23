package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class SearchChatMsgsParams {
    public ChatInfo chatInfo;
    public long filterMsgFromTime;
    public long filterMsgToTime;
    public ArrayList<MsgTypeFilter> filterMsgType;
    public ArrayList<String> filterSendersUid;
    public int pageLimit;
    public int searchFields;

    public SearchChatMsgsParams() {
        this.chatInfo = new ChatInfo();
        this.filterMsgType = new ArrayList<>();
        this.filterSendersUid = new ArrayList<>();
    }

    public ChatInfo getChatInfo() {
        return this.chatInfo;
    }

    public long getFilterMsgFromTime() {
        return this.filterMsgFromTime;
    }

    public long getFilterMsgToTime() {
        return this.filterMsgToTime;
    }

    public ArrayList<MsgTypeFilter> getFilterMsgType() {
        return this.filterMsgType;
    }

    public ArrayList<String> getFilterSendersUid() {
        return this.filterSendersUid;
    }

    public int getPageLimit() {
        return this.pageLimit;
    }

    public int getSearchFields() {
        return this.searchFields;
    }

    public String toString() {
        return "SearchChatMsgsParams{chatInfo=" + this.chatInfo + ",searchFields=" + this.searchFields + ",filterMsgType=" + this.filterMsgType + ",filterSendersUid=" + this.filterSendersUid + ",filterMsgFromTime=" + this.filterMsgFromTime + ",filterMsgToTime=" + this.filterMsgToTime + ",pageLimit=" + this.pageLimit + ",}";
    }

    public SearchChatMsgsParams(ChatInfo chatInfo, int i3, ArrayList<MsgTypeFilter> arrayList, ArrayList<String> arrayList2, long j3, long j16, int i16) {
        this.chatInfo = new ChatInfo();
        this.filterMsgType = new ArrayList<>();
        new ArrayList();
        this.chatInfo = chatInfo;
        this.searchFields = i3;
        this.filterMsgType = arrayList;
        this.filterSendersUid = arrayList2;
        this.filterMsgFromTime = j3;
        this.filterMsgToTime = j16;
        this.pageLimit = i16;
    }
}
