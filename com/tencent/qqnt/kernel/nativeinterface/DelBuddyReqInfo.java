package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class DelBuddyReqInfo implements IKernelModel {
    public ArrayList<DelBuddyReq> buddyReqs;
    public boolean isClearAll;

    public DelBuddyReqInfo() {
        this.buddyReqs = new ArrayList<>();
    }

    public ArrayList<DelBuddyReq> getBuddyReqs() {
        return this.buddyReqs;
    }

    public boolean getIsClearAll() {
        return this.isClearAll;
    }

    public void setBuddyReqs(ArrayList<DelBuddyReq> arrayList) {
        this.buddyReqs = arrayList;
    }

    public void setIsClearAll(boolean z16) {
        this.isClearAll = z16;
    }

    public DelBuddyReqInfo(boolean z16, ArrayList<DelBuddyReq> arrayList) {
        new ArrayList();
        this.isClearAll = z16;
        this.buddyReqs = arrayList;
    }
}
