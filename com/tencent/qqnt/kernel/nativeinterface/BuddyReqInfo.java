package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class BuddyReqInfo implements IKernelModel {
    public ArrayList<BuddyReq> buddyReqs;
    public int unreadNums;

    public BuddyReqInfo() {
        this.buddyReqs = new ArrayList<>();
    }

    public ArrayList<BuddyReq> getBuddyReqs() {
        return this.buddyReqs;
    }

    public int getUnreadNums() {
        return this.unreadNums;
    }

    public void setBuddyReqs(ArrayList<BuddyReq> arrayList) {
        this.buddyReqs = arrayList;
    }

    public void setUnreadNums(int i3) {
        this.unreadNums = i3;
    }

    public String toString() {
        return "BuddyReqInfo{unreadNums=" + this.unreadNums + ",buddyReqs=" + this.buddyReqs + ",}";
    }

    public BuddyReqInfo(int i3, ArrayList<BuddyReq> arrayList) {
        new ArrayList();
        this.unreadNums = i3;
        this.buddyReqs = arrayList;
    }
}
