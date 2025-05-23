package com.tencent.mobileqq.shortvideo.dancemachine;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes18.dex */
public class BoyDataReport {
    public long mGameDuration;
    public long mGameTotalScore;
    public boolean mHasReported = false;
    public ArrayList<BoyItem> mBoyData = new ArrayList<>();

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class BoyItem {
        public String mId;
        public boolean mEnd = false;
        public int mScore = 0;
        public int status = -1;
    }

    public void clear() {
        this.mBoyData.clear();
        this.mGameDuration = 0L;
        this.mGameTotalScore = 0L;
        this.mHasReported = false;
    }
}
