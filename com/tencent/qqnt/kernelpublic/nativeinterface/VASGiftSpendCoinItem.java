package com.tencent.qqnt.kernelpublic.nativeinterface;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class VASGiftSpendCoinItem implements Serializable {
    public int amt;
    public int coinType;
    long serialVersionUID = 1;

    public VASGiftSpendCoinItem() {
    }

    public int getAmt() {
        return this.amt;
    }

    public int getCoinType() {
        return this.coinType;
    }

    public String toString() {
        return "VASGiftSpendCoinItem{coinType=" + this.coinType + ",amt=" + this.amt + ",}";
    }

    public VASGiftSpendCoinItem(int i3, int i16) {
        this.coinType = i3;
        this.amt = i16;
    }
}
