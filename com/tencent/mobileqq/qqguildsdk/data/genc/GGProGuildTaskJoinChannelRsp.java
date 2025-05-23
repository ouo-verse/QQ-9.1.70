package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.mobileqq.qqguildsdk.data.GGProCmd0xf5dGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.GProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProCmd0xf5dGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildTaskJoinChannelRsp;

/* loaded from: classes17.dex */
public class GGProGuildTaskJoinChannelRsp implements IGProGuildTaskJoinChannelRsp {
    public final GProGuildTaskJoinChannelRsp mInfo;

    public GGProGuildTaskJoinChannelRsp(GProGuildTaskJoinChannelRsp gProGuildTaskJoinChannelRsp) {
        this.mInfo = gProGuildTaskJoinChannelRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildTaskJoinChannelRsp
    public long getChannelId() {
        return this.mInfo.getChannelId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildTaskJoinChannelRsp
    public IGProCmd0xf5dGuildInfo getGuildChannels() {
        return new GGProCmd0xf5dGuildInfo(this.mInfo.getGuildChannels());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildTaskJoinChannelRsp
    public long getGuildId() {
        return this.mInfo.getGuildId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildTaskJoinChannelRsp
    public IGProGuildInfo getGuildInfo() {
        return new GProGuildInfo(this.mInfo.getGuildInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildTaskJoinChannelRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
