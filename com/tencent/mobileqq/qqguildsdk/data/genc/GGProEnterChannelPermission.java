package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProEnterChannelPermission;

/* loaded from: classes17.dex */
public class GGProEnterChannelPermission implements IGProEnterChannelPermission {
    public final GProEnterChannelPermission mInfo;

    public GGProEnterChannelPermission(GProEnterChannelPermission gProEnterChannelPermission) {
        this.mInfo = gProEnterChannelPermission;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProEnterChannelPermission, com.tencent.mobileqq.qqguildsdk.data.IEnterChannelPermission
    public boolean getAllowEnter() {
        return this.mInfo.getAllowEnter();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProEnterChannelPermission, com.tencent.mobileqq.qqguildsdk.data.IEnterChannelPermission
    public boolean getAllowLive() {
        return this.mInfo.getAllowLive();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProEnterChannelPermission, com.tencent.mobileqq.qqguildsdk.data.IEnterChannelPermission
    public String getDisallowLiveReason() {
        return this.mInfo.getDisallowLiveReason();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProEnterChannelPermission, com.tencent.mobileqq.qqguildsdk.data.IEnterChannelPermission
    public String getDisallowReason() {
        return this.mInfo.getDisallowReason();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProEnterChannelPermission, com.tencent.mobileqq.qqguildsdk.data.IEnterChannelPermission
    public int getLiveType() {
        return this.mInfo.getLiveType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProEnterChannelPermission, com.tencent.mobileqq.qqguildsdk.data.IEnterChannelPermission
    public String getLiveUrl() {
        return this.mInfo.getLiveUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProEnterChannelPermission, com.tencent.mobileqq.qqguildsdk.data.IEnterChannelPermission
    public long getMsgSeq() {
        return this.mInfo.getMsgSeq();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProEnterChannelPermission
    public String toString() {
        return this.mInfo.toString();
    }
}
