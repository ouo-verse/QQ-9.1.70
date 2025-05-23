package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProThumbImage;

/* loaded from: classes17.dex */
public class GGProThumbImage implements IGProThumbImage {
    public final GProThumbImage mInfo;

    public GGProThumbImage(GProThumbImage gProThumbImage) {
        this.mInfo = gProThumbImage;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProThumbImage
    public int getHeight() {
        return this.mInfo.getHeight();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProThumbImage
    public int getLevel() {
        return this.mInfo.getLevel();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProThumbImage
    public String getUrl() {
        return this.mInfo.getUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProThumbImage
    public int getWidth() {
        return this.mInfo.getWidth();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProThumbImage
    public String toString() {
        return this.mInfo.toString();
    }
}
