package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProStCircleRankItem {
    public long feedNum;
    public long fuelValue;
    public int rankNo;
    public String circleName = "";
    public String circleID = "";

    public String getCircleID() {
        return this.circleID;
    }

    public String getCircleName() {
        return this.circleName;
    }

    public long getFeedNum() {
        return this.feedNum;
    }

    public long getFuelValue() {
        return this.fuelValue;
    }

    public int getRankNo() {
        return this.rankNo;
    }

    public String toString() {
        return "GProStCircleRankItem{rankNo=" + this.rankNo + ",circleName=" + this.circleName + ",fuelValue=" + this.fuelValue + ",feedNum=" + this.feedNum + ",circleID=" + this.circleID + ",}";
    }
}
