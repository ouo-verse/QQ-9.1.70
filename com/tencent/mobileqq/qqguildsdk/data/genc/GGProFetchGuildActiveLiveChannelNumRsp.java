package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProFetchGuildActiveLiveChannelNumRsp;

/* loaded from: classes17.dex */
public class GGProFetchGuildActiveLiveChannelNumRsp implements IGProFetchGuildActiveLiveChannelNumRsp {
    public final GProFetchGuildActiveLiveChannelNumRsp mInfo;

    public GGProFetchGuildActiveLiveChannelNumRsp(GProFetchGuildActiveLiveChannelNumRsp gProFetchGuildActiveLiveChannelNumRsp) {
        this.mInfo = gProFetchGuildActiveLiveChannelNumRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProFetchGuildActiveLiveChannelNumRsp
    public int getActiveLiveChannelNum() {
        return this.mInfo.getActiveLiveChannelNum();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProFetchGuildActiveLiveChannelNumRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
