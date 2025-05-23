package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProUserFreeGiftInfoRsp implements Serializable {
    public String checkContext;
    public int countdownSecond;
    public int currFreeGiftNum;
    public int dayFreeGiftNum;
    public ArrayList<Long> freeGiftIds;
    public int gotFreeGiftNum;
    public int maxFreeGiftNum;
    public ArrayList<Integer> needCheckThemeTypes;
    public long nextCheckTimeMS;
    public int reminderFreeGiftNum;
    long serialVersionUID;

    public GProUserFreeGiftInfoRsp() {
        this.serialVersionUID = 1L;
        this.checkContext = "";
        this.needCheckThemeTypes = new ArrayList<>();
        this.freeGiftIds = new ArrayList<>();
    }

    public String getCheckContext() {
        return this.checkContext;
    }

    public int getCountdownSecond() {
        return this.countdownSecond;
    }

    public int getCurrFreeGiftNum() {
        return this.currFreeGiftNum;
    }

    public int getDayFreeGiftNum() {
        return this.dayFreeGiftNum;
    }

    public ArrayList<Long> getFreeGiftIds() {
        return this.freeGiftIds;
    }

    public int getGotFreeGiftNum() {
        return this.gotFreeGiftNum;
    }

    public int getMaxFreeGiftNum() {
        return this.maxFreeGiftNum;
    }

    public ArrayList<Integer> getNeedCheckThemeTypes() {
        return this.needCheckThemeTypes;
    }

    public long getNextCheckTimeMS() {
        return this.nextCheckTimeMS;
    }

    public int getReminderFreeGiftNum() {
        return this.reminderFreeGiftNum;
    }

    public String toString() {
        return "GProUserFreeGiftInfoRsp{checkContext=" + this.checkContext + ",maxFreeGiftNum=" + this.maxFreeGiftNum + ",currFreeGiftNum=" + this.currFreeGiftNum + ",dayFreeGiftNum=" + this.dayFreeGiftNum + ",gotFreeGiftNum=" + this.gotFreeGiftNum + ",nextCheckTimeMS=" + this.nextCheckTimeMS + ",countdownSecond=" + this.countdownSecond + ",reminderFreeGiftNum=" + this.reminderFreeGiftNum + ",needCheckThemeTypes=" + this.needCheckThemeTypes + ",freeGiftIds=" + this.freeGiftIds + ",}";
    }

    public GProUserFreeGiftInfoRsp(String str, int i3, int i16, int i17, int i18, long j3, int i19, int i26, ArrayList<Integer> arrayList, ArrayList<Long> arrayList2) {
        this.serialVersionUID = 1L;
        this.checkContext = "";
        this.needCheckThemeTypes = new ArrayList<>();
        new ArrayList();
        this.checkContext = str;
        this.maxFreeGiftNum = i3;
        this.currFreeGiftNum = i16;
        this.dayFreeGiftNum = i17;
        this.gotFreeGiftNum = i18;
        this.nextCheckTimeMS = j3;
        this.countdownSecond = i19;
        this.reminderFreeGiftNum = i26;
        this.needCheckThemeTypes = arrayList;
        this.freeGiftIds = arrayList2;
    }
}
