package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProUserListGroupInfo;

/* loaded from: classes17.dex */
public class GGProUserListGroupInfo implements IGProUserListGroupInfo {
    public final GProUserListGroupInfo mInfo;

    public GGProUserListGroupInfo(GProUserListGroupInfo gProUserListGroupInfo) {
        this.mInfo = gProUserListGroupInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUserListGroupInfo
    public int getGroupType() {
        return this.mInfo.getGroupType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUserListGroupInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
