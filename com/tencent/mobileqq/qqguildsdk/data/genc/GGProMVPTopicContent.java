package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProMVPTopicContent;

/* loaded from: classes17.dex */
public class GGProMVPTopicContent implements IGProMVPTopicContent {
    public final GProMVPTopicContent mInfo;

    public GGProMVPTopicContent(GProMVPTopicContent gProMVPTopicContent) {
        this.mInfo = gProMVPTopicContent;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPTopicContent
    public String getSchema() {
        return this.mInfo.getSchema();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPTopicContent
    public int getShowStatus() {
        return this.mInfo.getShowStatus();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPTopicContent
    public long getTopicId() {
        return this.mInfo.getTopicId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPTopicContent
    public String getTopicName() {
        return this.mInfo.getTopicName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPTopicContent
    public String toString() {
        return this.mInfo.toString();
    }
}
