package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProStreamURL;

/* loaded from: classes17.dex */
public class GGProStreamURL implements IGProStreamURL {
    public final GProStreamURL mInfo;

    public GGProStreamURL(GProStreamURL gProStreamURL) {
        this.mInfo = gProStreamURL;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProStreamURL
    public String getPlayUrl() {
        return this.mInfo.getPlayUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProStreamURL
    public String getStreamName() {
        return this.mInfo.getStreamName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProStreamURL
    public String toString() {
        return this.mInfo.toString();
    }
}
