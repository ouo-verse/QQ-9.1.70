package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildTaskCardText;

/* loaded from: classes17.dex */
public class GGProGuildTaskCardText implements IGProGuildTaskCardText {
    public final GProGuildTaskCardText mInfo;

    public GGProGuildTaskCardText(GProGuildTaskCardText gProGuildTaskCardText) {
        this.mInfo = gProGuildTaskCardText;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildTaskCardText
    public int getActionType() {
        return this.mInfo.getActionType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildTaskCardText
    public String getContent() {
        return this.mInfo.getContent();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildTaskCardText
    public int getTextClassify() {
        return this.mInfo.getTextClassify();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildTaskCardText
    public String getUrl() {
        return this.mInfo.getUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildTaskCardText
    public String toString() {
        return this.mInfo.toString();
    }
}
