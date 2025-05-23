package com.tencent.qqnt.kernelpublic.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class TextGiftElement implements Serializable {
    public String bgImageUrl;
    public int charmValue;
    public long giftId;
    public String giftName;
    public int level;
    public boolean needPlayAnimation;
    public String orderId;
    public String paddingTop;
    public long price;
    public String receiverNick;
    public long receiverUin;
    public int sendType;
    public String senderNick;
    public long senderUin;
    long serialVersionUID;
    public ArrayList<VASGiftSpendCoinItem> spendCoins;
    public long tianquanId;

    public TextGiftElement() {
        this.serialVersionUID = 1L;
        this.giftName = "";
        this.receiverNick = "";
        this.senderNick = "";
        this.orderId = "";
        this.bgImageUrl = "";
        this.paddingTop = "";
        this.spendCoins = new ArrayList<>();
    }

    public String getBgImageUrl() {
        return this.bgImageUrl;
    }

    public int getCharmValue() {
        return this.charmValue;
    }

    public long getGiftId() {
        return this.giftId;
    }

    public String getGiftName() {
        return this.giftName;
    }

    public int getLevel() {
        return this.level;
    }

    public boolean getNeedPlayAnimation() {
        return this.needPlayAnimation;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public String getPaddingTop() {
        return this.paddingTop;
    }

    public long getPrice() {
        return this.price;
    }

    public String getReceiverNick() {
        return this.receiverNick;
    }

    public long getReceiverUin() {
        return this.receiverUin;
    }

    public int getSendType() {
        return this.sendType;
    }

    public String getSenderNick() {
        return this.senderNick;
    }

    public long getSenderUin() {
        return this.senderUin;
    }

    public ArrayList<VASGiftSpendCoinItem> getSpendCoins() {
        return this.spendCoins;
    }

    public long getTianquanId() {
        return this.tianquanId;
    }

    public String toString() {
        return "TextGiftElement{giftId=" + this.giftId + ",giftName=" + this.giftName + ",receiverUin=" + this.receiverUin + ",senderUin=" + this.senderUin + ",receiverNick=" + this.receiverNick + ",senderNick=" + this.senderNick + ",price=" + this.price + ",orderId=" + this.orderId + ",bgImageUrl=" + this.bgImageUrl + ",tianquanId=" + this.tianquanId + ",level=" + this.level + ",paddingTop=" + this.paddingTop + ",spendCoins=" + this.spendCoins + ",needPlayAnimation=" + this.needPlayAnimation + ",sendType=" + this.sendType + ",charmValue=" + this.charmValue + ",}";
    }

    public TextGiftElement(long j3, String str, long j16, long j17, String str2, String str3, long j18, String str4, String str5, long j19, int i3, String str6, ArrayList<VASGiftSpendCoinItem> arrayList, boolean z16, int i16, int i17) {
        this.serialVersionUID = 1L;
        this.giftName = "";
        this.receiverNick = "";
        this.senderNick = "";
        this.orderId = "";
        this.bgImageUrl = "";
        this.paddingTop = "";
        new ArrayList();
        this.giftId = j3;
        this.giftName = str;
        this.receiverUin = j16;
        this.senderUin = j17;
        this.receiverNick = str2;
        this.senderNick = str3;
        this.price = j18;
        this.orderId = str4;
        this.bgImageUrl = str5;
        this.tianquanId = j19;
        this.level = i3;
        this.paddingTop = str6;
        this.spendCoins = arrayList;
        this.needPlayAnimation = z16;
        this.sendType = i16;
        this.charmValue = i17;
    }
}
