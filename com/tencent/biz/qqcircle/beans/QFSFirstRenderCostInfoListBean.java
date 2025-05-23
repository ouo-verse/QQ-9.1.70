package com.tencent.biz.qqcircle.beans;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSFirstRenderCostInfoListBean {
    private long mLastToPreparedCost;
    private ArrayList<QFSFirstRenderCostInfo> mList;
    private long mOtherCost;
    private long mPrepareCost;
    private long mSceneSumCost;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class QFSFirstRenderCostInfo {
        private int mType = -1;
        private long mFrontCost = 0;
        private long mCurCost = 0;

        public long getCurCost() {
            return this.mCurCost;
        }

        public long getFrontCost() {
            return this.mFrontCost;
        }

        public int getType() {
            return this.mType;
        }

        public void setCurCost(long j3) {
            this.mCurCost = j3;
        }

        public void setFrontCost(long j3) {
            this.mFrontCost = j3;
        }

        public void setType(int i3) {
            this.mType = i3;
        }
    }

    public long getLastToPreparedCost() {
        return this.mLastToPreparedCost;
    }

    public ArrayList<QFSFirstRenderCostInfo> getList() {
        return this.mList;
    }

    public long getOtherCost() {
        return this.mOtherCost;
    }

    public long getPrepareCost() {
        return this.mPrepareCost;
    }

    public long getSceneSumCost() {
        return this.mSceneSumCost;
    }

    public void setLastToPreparedCost(long j3) {
        this.mLastToPreparedCost = j3;
    }

    public void setList(ArrayList<QFSFirstRenderCostInfo> arrayList) {
        this.mList = arrayList;
    }

    public void setOtherCost(long j3) {
        this.mOtherCost = j3;
    }

    public void setPrepareCost(long j3) {
        this.mPrepareCost = j3;
    }

    public void setSceneSumCost(long j3) {
        this.mSceneSumCost = j3;
    }
}
