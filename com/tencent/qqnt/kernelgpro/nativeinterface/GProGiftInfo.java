package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProGiftInfo implements Serializable {
    public int allComboCnt;
    public boolean comboOver;
    public long comboSeq;
    public int effectLevel;
    public int giftId;
    public String giftName;
    public int giftNum;
    public long giftPrice;
    public int giftType;
    public int materialId;
    public int sendType;
    long serialVersionUID;

    public GProGiftInfo() {
        this.serialVersionUID = 1L;
        this.giftName = "";
    }

    public int getAllComboCnt() {
        return this.allComboCnt;
    }

    public boolean getComboOver() {
        return this.comboOver;
    }

    public long getComboSeq() {
        return this.comboSeq;
    }

    public int getEffectLevel() {
        return this.effectLevel;
    }

    public int getGiftId() {
        return this.giftId;
    }

    public String getGiftName() {
        return this.giftName;
    }

    public int getGiftNum() {
        return this.giftNum;
    }

    public long getGiftPrice() {
        return this.giftPrice;
    }

    public int getGiftType() {
        return this.giftType;
    }

    public int getMaterialId() {
        return this.materialId;
    }

    public int getSendType() {
        return this.sendType;
    }

    public String toString() {
        return "GProGiftInfo{giftType=" + this.giftType + ",giftId=" + this.giftId + ",giftName=" + this.giftName + ",giftNum=" + this.giftNum + ",sendType=" + this.sendType + ",comboSeq=" + this.comboSeq + ",comboOver=" + this.comboOver + ",allComboCnt=" + this.allComboCnt + ",materialId=" + this.materialId + ",effectLevel=" + this.effectLevel + ",giftPrice=" + this.giftPrice + ",}";
    }

    public GProGiftInfo(int i3, int i16, String str, int i17, int i18, long j3, boolean z16, int i19, int i26, int i27, long j16) {
        this.serialVersionUID = 1L;
        this.giftType = i3;
        this.giftId = i16;
        this.giftName = str;
        this.giftNum = i17;
        this.sendType = i18;
        this.comboSeq = j3;
        this.comboOver = z16;
        this.allComboCnt = i19;
        this.materialId = i26;
        this.effectLevel = i27;
        this.giftPrice = j16;
    }
}
