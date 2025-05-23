package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProMVPRoleGroup;

/* loaded from: classes17.dex */
public class GGProMVPRoleGroup implements IGProMVPRoleGroup {
    public final GProMVPRoleGroup mInfo;

    public GGProMVPRoleGroup(GProMVPRoleGroup gProMVPRoleGroup) {
        this.mInfo = gProMVPRoleGroup;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPRoleGroup
    public int getColor() {
        return this.mInfo.getColor();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPRoleGroup
    public long getId() {
        return this.mInfo.getId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPRoleGroup
    public String getName() {
        return this.mInfo.getName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPRoleGroup
    public String toString() {
        return this.mInfo.toString();
    }
}
