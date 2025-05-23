package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildCheckinRsp;

/* loaded from: classes17.dex */
public class GGProGuildCheckinRsp implements IGProGuildCheckinRsp {
    public final GProGuildCheckinRsp mInfo;

    public GGProGuildCheckinRsp(GProGuildCheckinRsp gProGuildCheckinRsp) {
        this.mInfo = gProGuildCheckinRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildCheckinRsp
    public int getCheckinCnt() {
        return this.mInfo.getCheckinCnt();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildCheckinRsp
    public int getCheckinStatus() {
        return this.mInfo.getCheckinStatus();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildCheckinRsp
    public int getFirstCheckin() {
        return this.mInfo.getFirstCheckin();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildCheckinRsp
    public int getRank() {
        return this.mInfo.getRank();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildCheckinRsp
    public int getTodayActive() {
        return this.mInfo.getTodayActive();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildCheckinRsp
    public int getTomorrowActive() {
        return this.mInfo.getTomorrowActive();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildCheckinRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
