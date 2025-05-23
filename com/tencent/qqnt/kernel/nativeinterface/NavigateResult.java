package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class NavigateResult {
    public long beginSeq;
    public ArrayList<NavigateInfo> seqList;
    public long unread;

    public NavigateResult() {
        this.seqList = new ArrayList<>();
    }

    public long getBeginSeq() {
        return this.beginSeq;
    }

    public ArrayList<NavigateInfo> getSeqList() {
        return this.seqList;
    }

    public long getUnread() {
        return this.unread;
    }

    public String toString() {
        return "NavigateResult{seqList=" + this.seqList + ",beginSeq=" + this.beginSeq + ",unread=" + this.unread + ",}";
    }

    public NavigateResult(ArrayList<NavigateInfo> arrayList, long j3, long j16) {
        new ArrayList();
        this.seqList = arrayList;
        this.beginSeq = j3;
        this.unread = j16;
    }
}
