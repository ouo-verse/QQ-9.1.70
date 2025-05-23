package com.tencent.biz.qqcircle.beans;

import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSNvvTaskCompleteBean {
    private final long mCompleteTime;
    private final List<String> mFeedIds;
    private final int mVVCount;

    public QFSNvvTaskCompleteBean(long j3, int i3, List<String> list) {
        this.mCompleteTime = j3;
        this.mVVCount = i3;
        this.mFeedIds = list;
    }

    public long getCompleteTime() {
        return this.mCompleteTime;
    }

    public List<String> getFeedIds() {
        return this.mFeedIds;
    }

    public int getVVCount() {
        return this.mVVCount;
    }
}
