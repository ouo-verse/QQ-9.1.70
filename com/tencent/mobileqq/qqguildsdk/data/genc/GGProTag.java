package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProTag;

/* loaded from: classes17.dex */
public class GGProTag implements IGProTag {
    public final GProTag mInfo;

    public GGProTag(GProTag gProTag) {
        this.mInfo = gProTag;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProTag
    public byte[] getIcon() {
        return this.mInfo.getIcon();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProTag
    public byte[] getName() {
        return this.mInfo.getName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProTag
    public String toString() {
        return this.mInfo.toString();
    }
}
