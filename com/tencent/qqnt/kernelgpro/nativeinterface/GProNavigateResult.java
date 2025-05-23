package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProNavigateResult {
    public long beginSeq;
    public ArrayList<GProNavigateInfo> seqList;
    public long unread;

    public GProNavigateResult() {
        this.seqList = new ArrayList<>();
    }

    public long getBeginSeq() {
        return this.beginSeq;
    }

    public ArrayList<GProNavigateInfo> getSeqList() {
        return this.seqList;
    }

    public long getUnread() {
        return this.unread;
    }

    public String toString() {
        return "GProNavigateResult{seqList=" + this.seqList + ",beginSeq=" + this.beginSeq + ",unread=" + this.unread + ",}";
    }

    public GProNavigateResult(ArrayList<GProNavigateInfo> arrayList, long j3, long j16) {
        new ArrayList();
        this.seqList = arrayList;
        this.beginSeq = j3;
        this.unread = j16;
    }
}
