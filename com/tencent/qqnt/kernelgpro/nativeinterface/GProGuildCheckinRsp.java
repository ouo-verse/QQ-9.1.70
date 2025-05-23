package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProGuildCheckinRsp implements Serializable {
    public int checkinCnt;
    public int checkinStatus;
    public int firstCheckin;
    public int rank;
    long serialVersionUID = 1;
    public int todayActive;
    public int tomorrowActive;

    public int getCheckinCnt() {
        return this.checkinCnt;
    }

    public int getCheckinStatus() {
        return this.checkinStatus;
    }

    public int getFirstCheckin() {
        return this.firstCheckin;
    }

    public int getRank() {
        return this.rank;
    }

    public int getTodayActive() {
        return this.todayActive;
    }

    public int getTomorrowActive() {
        return this.tomorrowActive;
    }

    public String toString() {
        return "GProGuildCheckinRsp{checkinStatus=" + this.checkinStatus + ",checkinCnt=" + this.checkinCnt + ",rank=" + this.rank + ",firstCheckin=" + this.firstCheckin + ",todayActive=" + this.todayActive + ",tomorrowActive=" + this.tomorrowActive + ",}";
    }
}
