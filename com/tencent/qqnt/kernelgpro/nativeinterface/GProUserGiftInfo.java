package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProUserGiftInfo implements Serializable {
    public long giftPrice;
    long serialVersionUID = 1;
    public String showGiftPrice = "";
    public String giftTipsMsg = "";

    public long getGiftPrice() {
        return this.giftPrice;
    }

    public String getGiftTipsMsg() {
        return this.giftTipsMsg;
    }

    public String getShowGiftPrice() {
        return this.showGiftPrice;
    }

    public String toString() {
        return "GProUserGiftInfo{giftPrice=" + this.giftPrice + ",showGiftPrice=" + this.showGiftPrice + ",giftTipsMsg=" + this.giftTipsMsg + ",}";
    }
}
