package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildNavIconInfo;

/* loaded from: classes17.dex */
public class GGProGuildNavIconInfo implements IGProGuildNavIconInfo {
    public final GProGuildNavIconInfo mInfo;

    public GGProGuildNavIconInfo(GProGuildNavIconInfo gProGuildNavIconInfo) {
        this.mInfo = gProGuildNavIconInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildNavIconInfo
    public long getIconId() {
        return this.mInfo.getIconId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildNavIconInfo
    public String getIconName() {
        return this.mInfo.getIconName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildNavIconInfo
    public String getIconUrl() {
        return this.mInfo.getIconUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildNavIconInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
