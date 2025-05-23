package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProUserBarNodePermission;

/* loaded from: classes17.dex */
public class GGProUserBarNodePermission implements IGProUserBarNodePermission {
    public final GProUserBarNodePermission mInfo;

    public GGProUserBarNodePermission(GProUserBarNodePermission gProUserBarNodePermission) {
        this.mInfo = gProUserBarNodePermission;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUserBarNodePermission
    public int getNodeType() {
        return this.mInfo.getNodeType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUserBarNodePermission
    public int getVisibleType() {
        return this.mInfo.getVisibleType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUserBarNodePermission
    public String toString() {
        return this.mInfo.toString();
    }
}
