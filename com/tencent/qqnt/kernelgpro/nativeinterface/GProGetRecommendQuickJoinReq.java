package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProGetRecommendQuickJoinReq {
    public int cardType;
    public byte[] cookies;
    public int scene;

    public GProGetRecommendQuickJoinReq() {
        this.cookies = new byte[0];
    }

    public int getCardType() {
        return this.cardType;
    }

    public byte[] getCookies() {
        return this.cookies;
    }

    public int getScene() {
        return this.scene;
    }

    public void setCardType(int i3) {
        this.cardType = i3;
    }

    public void setCookies(byte[] bArr) {
        this.cookies = bArr;
    }

    public void setScene(int i3) {
        this.scene = i3;
    }

    public String toString() {
        return "GProGetRecommendQuickJoinReq{cardType=" + this.cardType + ",scene=" + this.scene + ",cookies=" + this.cookies + ",}";
    }

    public GProGetRecommendQuickJoinReq(int i3, int i16, byte[] bArr) {
        this.cardType = i3;
        this.scene = i16;
        this.cookies = bArr;
    }
}
