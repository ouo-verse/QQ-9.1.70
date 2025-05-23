package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.mobileqq.qqguildsdk.data.GGProCmd0xf5dGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.GProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.GProSecurityInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProCmd0xf5dGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProJoinGuildResult;

/* loaded from: classes17.dex */
public class GGProJoinGuildResult implements IGProJoinGuildResult {
    public final GProJoinGuildResult mInfo;

    public GGProJoinGuildResult(GProJoinGuildResult gProJoinGuildResult) {
        this.mInfo = gProJoinGuildResult;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProJoinGuildResult
    public IGProCmd0xf5dGuildInfo getGuildChannels() {
        return new GGProCmd0xf5dGuildInfo(this.mInfo.getGuildChannels());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProJoinGuildResult
    public long getGuildId() {
        return this.mInfo.getGuildId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProJoinGuildResult
    public IGProGuildInfo getGuildInfo() {
        return new GProGuildInfo(this.mInfo.getGuildInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProJoinGuildResult
    public int getOpenTab() {
        return this.mInfo.getOpenTab();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProJoinGuildResult
    public int getQqMsgInList() {
        return this.mInfo.getQqMsgInList();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProJoinGuildResult
    public int getRetCode() {
        return this.mInfo.getRetCode();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProJoinGuildResult
    public IGProSecurityResult getSecRet() {
        return new GProSecurityInfo(this.mInfo.getSecRet());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProJoinGuildResult
    public String toString() {
        return this.mInfo.toString();
    }
}
