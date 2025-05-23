package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProFetchUserJoinedGuildListRsp;

/* loaded from: classes17.dex */
public class GGProFetchUserJoinedGuildListRsp implements IGProFetchUserJoinedGuildListRsp {
    public final GProFetchUserJoinedGuildListRsp mInfo;

    public GGProFetchUserJoinedGuildListRsp(GProFetchUserJoinedGuildListRsp gProFetchUserJoinedGuildListRsp) {
        this.mInfo = gProFetchUserJoinedGuildListRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProFetchUserJoinedGuildListRsp
    public String getCookie() {
        return this.mInfo.getCookie();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProFetchUserJoinedGuildListRsp
    public boolean getIsEnd() {
        return this.mInfo.getIsEnd();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProFetchUserJoinedGuildListRsp
    public IGProUserJoinedGuildSummary getJoinedGuildSummary() {
        return new GGProUserJoinedGuildSummary(this.mInfo.getJoinedGuildSummary());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProFetchUserJoinedGuildListRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
