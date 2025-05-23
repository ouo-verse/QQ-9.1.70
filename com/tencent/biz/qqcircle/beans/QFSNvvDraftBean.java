package com.tencent.biz.qqcircle.beans;

import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSNvvDraftBean {
    private final long mDraftTime;
    private final int mVVCount;
    private final List<Integer> mWaitConsumeIndexList;

    public QFSNvvDraftBean(long j3, int i3, List<Integer> list) {
        this.mDraftTime = j3;
        this.mVVCount = i3;
        this.mWaitConsumeIndexList = list;
    }

    public long getDraftTime() {
        return this.mDraftTime;
    }

    public int getVVCount() {
        return this.mVVCount;
    }

    public List<Integer> getWaitConsumeIndexList() {
        return this.mWaitConsumeIndexList;
    }
}
