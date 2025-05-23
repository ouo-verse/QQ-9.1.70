package com.tencent.midas.api.request;

/* loaded from: classes9.dex */
public class APMidasGoodsRequest extends APMidasBaseRequest {
    public static final int GETTOKENTYPE_CLIENT = 3;
    public static final int GETTOKENTYPE_SDK = 2;
    public static final int GETTOKENTYPE_SERVER = 1;
    private static final long serialVersionUID = -4326761659903564582L;
    public int gameLogo = 0;
    public String developerPayload = "";
    public boolean mIsReceiptMode = false;
    public int tokenType = -1;
    public String goodsTokenUrl = "";
    public String prodcutId = "";

    public String getDeveloperPayload() {
        return this.developerPayload;
    }

    public int getGameLogo() {
        return this.gameLogo;
    }

    public String getGoodsTokenUrl() {
        return this.goodsTokenUrl;
    }

    public boolean getIsReceiptMode() {
        return this.mIsReceiptMode;
    }

    public String getProdcutId() {
        return this.prodcutId;
    }

    public int getTokenType() {
        return this.tokenType;
    }

    public void setDeveloperPayload(String str) {
        this.developerPayload = str;
    }

    public void setGameLogo(int i3) {
        this.gameLogo = i3;
    }

    public void setGoodsTokenUrl(String str) {
        this.goodsTokenUrl = str;
    }

    public void setIsReceiptMode(boolean z16) {
        this.mIsReceiptMode = z16;
    }

    public void setProdcutId(String str) {
        this.prodcutId = str;
    }

    public void setTokenType(int i3) {
        this.tokenType = i3;
    }
}
