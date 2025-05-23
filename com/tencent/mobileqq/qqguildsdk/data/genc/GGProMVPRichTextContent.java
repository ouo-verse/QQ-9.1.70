package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProMVPRichTextContent;

/* loaded from: classes17.dex */
public class GGProMVPRichTextContent implements IGProMVPRichTextContent {
    public final GProMVPRichTextContent mInfo;

    public GGProMVPRichTextContent(GProMVPRichTextContent gProMVPRichTextContent) {
        this.mInfo = gProMVPRichTextContent;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPRichTextContent
    public IGProMVPAtContent getAtContent() {
        return new GGProMVPAtContent(this.mInfo.getAtContent());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPRichTextContent
    public IGProMVPChannelContent getChannelContent() {
        return new GGProMVPChannelContent(this.mInfo.getChannelContent());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPRichTextContent
    public IGProMVPEmojiContent getEmojiContent() {
        return new GGProMVPEmojiContent(this.mInfo.getEmojiContent());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPRichTextContent
    public IGProMVPGroupContent getGroupContent() {
        return new GGProMVPGroupContent(this.mInfo.getGroupContent());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPRichTextContent
    public IGProMVPTextContent getTextContent() {
        return new GGProMVPTextContent(this.mInfo.getTextContent());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPRichTextContent
    public IGProMVPTopicContent getTopicContent() {
        return new GGProMVPTopicContent(this.mInfo.getTopicContent());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPRichTextContent
    public int getType() {
        return this.mInfo.getType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPRichTextContent
    public IGProMVPURLContent getUrlContent() {
        return new GGProMVPURLContent(this.mInfo.getUrlContent());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPRichTextContent
    public String toString() {
        return this.mInfo.toString();
    }
}
