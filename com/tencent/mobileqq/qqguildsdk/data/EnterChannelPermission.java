package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.mobileqq.qqguildsdk.data.genc.GGProEnterChannelPermission;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProEnterChannelPermission;

/* loaded from: classes17.dex */
public class EnterChannelPermission extends GGProEnterChannelPermission implements IEnterChannelPermission {
    private GProEnterChannelPermission enterChannelPermission;

    public EnterChannelPermission(GProEnterChannelPermission gProEnterChannelPermission) {
        super(gProEnterChannelPermission);
        this.enterChannelPermission = gProEnterChannelPermission;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.GGProEnterChannelPermission, com.tencent.mobileqq.qqguildsdk.data.genc.IGProEnterChannelPermission, com.tencent.mobileqq.qqguildsdk.data.IEnterChannelPermission
    public boolean getAllowEnter() {
        return this.enterChannelPermission.getAllowEnter();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.GGProEnterChannelPermission, com.tencent.mobileqq.qqguildsdk.data.genc.IGProEnterChannelPermission, com.tencent.mobileqq.qqguildsdk.data.IEnterChannelPermission
    public boolean getAllowLive() {
        return this.enterChannelPermission.getAllowLive();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.GGProEnterChannelPermission, com.tencent.mobileqq.qqguildsdk.data.genc.IGProEnterChannelPermission, com.tencent.mobileqq.qqguildsdk.data.IEnterChannelPermission
    public String getDisallowLiveReason() {
        return this.enterChannelPermission.getDisallowLiveReason();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.GGProEnterChannelPermission, com.tencent.mobileqq.qqguildsdk.data.genc.IGProEnterChannelPermission, com.tencent.mobileqq.qqguildsdk.data.IEnterChannelPermission
    public String getDisallowReason() {
        return this.enterChannelPermission.getDisallowReason();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.GGProEnterChannelPermission, com.tencent.mobileqq.qqguildsdk.data.genc.IGProEnterChannelPermission, com.tencent.mobileqq.qqguildsdk.data.IEnterChannelPermission
    public int getLiveType() {
        return this.enterChannelPermission.getLiveType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.GGProEnterChannelPermission, com.tencent.mobileqq.qqguildsdk.data.genc.IGProEnterChannelPermission, com.tencent.mobileqq.qqguildsdk.data.IEnterChannelPermission
    public String getLiveUrl() {
        return this.enterChannelPermission.getLiveUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.GGProEnterChannelPermission, com.tencent.mobileqq.qqguildsdk.data.genc.IGProEnterChannelPermission, com.tencent.mobileqq.qqguildsdk.data.IEnterChannelPermission
    public long getMsgSeq() {
        return this.enterChannelPermission.getMsgSeq();
    }
}
