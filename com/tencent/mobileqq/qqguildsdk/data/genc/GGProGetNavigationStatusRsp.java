package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetNavigationStatusRsp;

/* loaded from: classes17.dex */
public class GGProGetNavigationStatusRsp implements IGProGetNavigationStatusRsp {
    public final GProGetNavigationStatusRsp mInfo;

    public GGProGetNavigationStatusRsp(GProGetNavigationStatusRsp gProGetNavigationStatusRsp) {
        this.mInfo = gProGetNavigationStatusRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetNavigationStatusRsp
    public int getAuditStatus() {
        return this.mInfo.getAuditStatus();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetNavigationStatusRsp
    public int getEnableSetting() {
        return this.mInfo.getEnableSetting();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetNavigationStatusRsp
    public int getExistNavigation() {
        return this.mInfo.getExistNavigation();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetNavigationStatusRsp
    public int getLimit() {
        return this.mInfo.getLimit();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetNavigationStatusRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
