package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProMVPBusinessCard;

/* loaded from: classes17.dex */
public class GGProMVPBusinessCard implements IGProMVPBusinessCard {
    public final GProMVPBusinessCard mInfo;

    public GGProMVPBusinessCard(GProMVPBusinessCard gProMVPBusinessCard) {
        this.mInfo = gProMVPBusinessCard;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPBusinessCard
    public boolean getHasCard() {
        return this.mInfo.getHasCard();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPBusinessCard
    public String toString() {
        return this.mInfo.toString();
    }
}
