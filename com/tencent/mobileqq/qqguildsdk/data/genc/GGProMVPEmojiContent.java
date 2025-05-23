package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProMVPEmojiContent;

/* loaded from: classes17.dex */
public class GGProMVPEmojiContent implements IGProMVPEmojiContent {
    public final GProMVPEmojiContent mInfo;

    public GGProMVPEmojiContent(GProMVPEmojiContent gProMVPEmojiContent) {
        this.mInfo = gProMVPEmojiContent;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPEmojiContent
    public String getId() {
        return this.mInfo.getId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPEmojiContent
    public String getType() {
        return this.mInfo.getType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPEmojiContent
    public String toString() {
        return this.mInfo.toString();
    }
}
