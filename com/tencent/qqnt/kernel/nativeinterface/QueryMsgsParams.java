package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class QueryMsgsParams {
    public ChatInfo chatInfo;
    public long filterMsgFromTime;
    public long filterMsgToTime;
    public ArrayList<MsgTypeFilter> filterMsgType;
    public ArrayList<String> filterSendersUid;
    public boolean isIncludeCurrent;
    public boolean isReverseOrder;
    public int pageLimit;

    public QueryMsgsParams() {
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

    public boolean getIsIncludeCurrent() {
        return this.isIncludeCurrent;
    }

    public boolean getIsReverseOrder() {
        return this.isReverseOrder;
    }

    public int getPageLimit() {
        return this.pageLimit;
    }

    public String toString() {
        return "QueryMsgsParams{chatInfo=" + this.chatInfo + ",filterMsgType=" + this.filterMsgType + ",filterSendersUid=" + this.filterSendersUid + ",filterMsgFromTime=" + this.filterMsgFromTime + ",filterMsgToTime=" + this.filterMsgToTime + ",pageLimit=" + this.pageLimit + ",isReverseOrder=" + this.isReverseOrder + ",isIncludeCurrent=" + this.isIncludeCurrent + ",}";
    }

    public QueryMsgsParams(ChatInfo chatInfo, ArrayList<MsgTypeFilter> arrayList, ArrayList<String> arrayList2, long j3, long j16, int i3, boolean z16, boolean z17) {
        this.chatInfo = new ChatInfo();
        this.filterMsgType = new ArrayList<>();
        new ArrayList();
        this.chatInfo = chatInfo;
        this.filterMsgType = arrayList;
        this.filterSendersUid = arrayList2;
        this.filterMsgFromTime = j3;
        this.filterMsgToTime = j16;
        this.pageLimit = i3;
        this.isReverseOrder = z16;
        this.isIncludeCurrent = z17;
    }
}
