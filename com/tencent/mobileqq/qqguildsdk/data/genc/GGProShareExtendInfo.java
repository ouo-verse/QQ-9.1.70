package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProShareExtendInfo;

/* loaded from: classes17.dex */
public class GGProShareExtendInfo implements IGProShareExtendInfo {
    public final GProShareExtendInfo mInfo;

    public GGProShareExtendInfo(GProShareExtendInfo gProShareExtendInfo) {
        this.mInfo = gProShareExtendInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProShareExtendInfo
    public long getFeedNum() {
        return this.mInfo.getFeedNum();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProShareExtendInfo
    public long getGuildMemberNum() {
        return this.mInfo.getGuildMemberNum();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProShareExtendInfo
    public String getShareCopywriting() {
        return this.mInfo.getShareCopywriting();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProShareExtendInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
