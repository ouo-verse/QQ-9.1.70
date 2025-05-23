package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class RecentContactListChangedInfo {
    public boolean atTheBottom;
    public boolean atTheTop;
    public long cacheLocation;
    public ArrayList<RecentContactInfo> changedList;
    public long firstContactPos;
    public int listType;
    public boolean moreDataAtTheBottom;
    public int notificationType;
    public ArrayList<Long> sortedContactList;
    public long unreadCnt;
    public UnreadTotalCntDetail unreadCntDetail;
    public long unreadFlag;

    public RecentContactListChangedInfo() {
        this.sortedContactList = new ArrayList<>();
        this.changedList = new ArrayList<>();
        this.unreadCntDetail = new UnreadTotalCntDetail();
    }

    public boolean getAtTheBottom() {
        return this.atTheBottom;
    }

    public boolean getAtTheTop() {
        return this.atTheTop;
    }

    public long getCacheLocation() {
        return this.cacheLocation;
    }

    public ArrayList<RecentContactInfo> getChangedList() {
        return this.changedList;
    }

    public long getFirstContactPos() {
        return this.firstContactPos;
    }

    public int getListType() {
        return this.listType;
    }

    public boolean getMoreDataAtTheBottom() {
        return this.moreDataAtTheBottom;
    }

    public int getNotificationType() {
        return this.notificationType;
    }

    public ArrayList<Long> getSortedContactList() {
        return this.sortedContactList;
    }

    public long getUnreadCnt() {
        return this.unreadCnt;
    }

    public UnreadTotalCntDetail getUnreadCntDetail() {
        return this.unreadCntDetail;
    }

    public long getUnreadFlag() {
        return this.unreadFlag;
    }

    public String toString() {
        return "RecentContactListChangedInfo{listType=" + this.listType + ",sortedContactList=" + this.sortedContactList + ",changedList=" + this.changedList + ",notificationType=" + this.notificationType + ",unreadCnt=" + this.unreadCnt + ",unreadFlag=" + this.unreadFlag + ",cacheLocation=" + this.cacheLocation + ",firstContactPos=" + this.firstContactPos + ",atTheTop=" + this.atTheTop + ",atTheBottom=" + this.atTheBottom + ",moreDataAtTheBottom=" + this.moreDataAtTheBottom + ",unreadCntDetail=" + this.unreadCntDetail + ",}";
    }

    public RecentContactListChangedInfo(int i3, ArrayList<Long> arrayList, ArrayList<RecentContactInfo> arrayList2, int i16, long j3, long j16, long j17, long j18, boolean z16, boolean z17) {
        this.sortedContactList = new ArrayList<>();
        this.changedList = new ArrayList<>();
        this.unreadCntDetail = new UnreadTotalCntDetail();
        this.listType = i3;
        this.sortedContactList = arrayList;
        this.changedList = arrayList2;
        this.notificationType = i16;
        this.unreadCnt = j3;
        this.unreadFlag = j16;
        this.cacheLocation = j17;
        this.firstContactPos = j18;
        this.atTheTop = z16;
        this.atTheBottom = z17;
    }
}
