package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProConditionalTag;

/* loaded from: classes17.dex */
public class GGProConditionalTag implements IGProConditionalTag {
    public final GProConditionalTag mInfo;

    public GGProConditionalTag(GProConditionalTag gProConditionalTag) {
        this.mInfo = gProConditionalTag;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProConditionalTag
    public byte[] getBuff() {
        return this.mInfo.getBuff();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProConditionalTag
    public String getName() {
        return this.mInfo.getName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProConditionalTag
    public String toString() {
        return this.mInfo.toString();
    }
}
