package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGameGiftInfo implements Serializable {
    public int giftNum;
    long serialVersionUID = 1;
    public ArrayList<String> giftIconList = new ArrayList<>();
    public String jumpUrl = "";

    public ArrayList<String> getGiftIconList() {
        return this.giftIconList;
    }

    public int getGiftNum() {
        return this.giftNum;
    }

    public String getJumpUrl() {
        return this.jumpUrl;
    }

    public String toString() {
        return "GProGameGiftInfo{giftNum=" + this.giftNum + ",giftIconList=" + this.giftIconList + ",jumpUrl=" + this.jumpUrl + ",}";
    }
}
