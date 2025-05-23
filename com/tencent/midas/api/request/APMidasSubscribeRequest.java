package com.tencent.midas.api.request;

/* loaded from: classes9.dex */
public class APMidasSubscribeRequest extends APMidasMonthRequest {
    private static final long serialVersionUID = 6111439524338439638L;
    public int gameLogo = 0;
    public String productId = "";

    @Override // com.tencent.midas.api.request.APMidasMonthRequest
    public int getGameLogo() {
        return this.gameLogo;
    }

    public String getProductId() {
        return this.productId;
    }

    @Override // com.tencent.midas.api.request.APMidasMonthRequest
    public void setGameLogo(int i3) {
        this.gameLogo = i3;
    }

    public void setProductId(String str) {
        this.productId = str;
    }
}
