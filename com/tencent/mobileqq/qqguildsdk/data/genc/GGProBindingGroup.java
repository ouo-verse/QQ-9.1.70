package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProBindingGroup;

/* loaded from: classes17.dex */
public class GGProBindingGroup implements IGProBindingGroup {
    public final GProBindingGroup mInfo;

    public GGProBindingGroup(GProBindingGroup gProBindingGroup) {
        this.mInfo = gProBindingGroup;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBindingGroup
    public long getGroupCode() {
        return this.mInfo.getGroupCode();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBindingGroup
    public int getGroupFlag() {
        return this.mInfo.getGroupFlag();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBindingGroup
    public long getGroupMemberSize() {
        return this.mInfo.getGroupMemberSize();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBindingGroup
    public String getGroupName() {
        return this.mInfo.getGroupName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBindingGroup
    public String getGroupUrl() {
        return this.mInfo.getGroupUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBindingGroup
    public int getIsConfGroup() {
        return this.mInfo.getIsConfGroup();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBindingGroup
    public boolean getIsGroupMember() {
        return this.mInfo.getIsGroupMember();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBindingGroup
    public String getOnlineMemberSize() {
        return this.mInfo.getOnlineMemberSize();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBindingGroup
    public int getPrivilege() {
        return this.mInfo.getPrivilege();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBindingGroup
    public String getSignature() {
        return this.mInfo.getSignature();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBindingGroup
    public String toString() {
        return this.mInfo.toString();
    }
}
