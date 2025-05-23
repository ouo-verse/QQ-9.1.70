package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProMVPGroupContent;

/* loaded from: classes17.dex */
public class GGProMVPGroupContent implements IGProMVPGroupContent {
    public final GProMVPGroupContent mInfo;

    public GGProMVPGroupContent(GProMVPGroupContent gProMVPGroupContent) {
        this.mInfo = gProMVPGroupContent;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPGroupContent
    public String getGroupAvatar() {
        return this.mInfo.getGroupAvatar();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPGroupContent
    public long getGroupCode() {
        return this.mInfo.getGroupCode();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPGroupContent
    public String getGroupJoinAuth() {
        return this.mInfo.getGroupJoinAuth();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPGroupContent
    public int getGroupMemberNum() {
        return this.mInfo.getGroupMemberNum();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPGroupContent
    public String getGroupName() {
        return this.mInfo.getGroupName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPGroupContent
    public String toString() {
        return this.mInfo.toString();
    }
}
