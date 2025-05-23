package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProMVPRichTextContent implements Serializable {
    public GProMVPAtContent atContent;
    public GProMVPChannelContent channelContent;
    public GProMVPEmojiContent emojiContent;
    public GProMVPGroupContent groupContent;
    long serialVersionUID;
    public GProMVPTextContent textContent;
    public GProMVPTopicContent topicContent;
    public int type;
    public GProMVPURLContent urlContent;

    public GProMVPRichTextContent() {
        this.serialVersionUID = 1L;
        this.textContent = new GProMVPTextContent();
        this.atContent = new GProMVPAtContent();
        this.urlContent = new GProMVPURLContent();
        this.emojiContent = new GProMVPEmojiContent();
        this.channelContent = new GProMVPChannelContent();
        this.topicContent = new GProMVPTopicContent();
        this.groupContent = new GProMVPGroupContent();
    }

    public GProMVPAtContent getAtContent() {
        return this.atContent;
    }

    public GProMVPChannelContent getChannelContent() {
        return this.channelContent;
    }

    public GProMVPEmojiContent getEmojiContent() {
        return this.emojiContent;
    }

    public GProMVPGroupContent getGroupContent() {
        return this.groupContent;
    }

    public GProMVPTextContent getTextContent() {
        return this.textContent;
    }

    public GProMVPTopicContent getTopicContent() {
        return this.topicContent;
    }

    public int getType() {
        return this.type;
    }

    public GProMVPURLContent getUrlContent() {
        return this.urlContent;
    }

    public String toString() {
        return "GProMVPRichTextContent{type=" + this.type + ",textContent=" + this.textContent + ",atContent=" + this.atContent + ",urlContent=" + this.urlContent + ",emojiContent=" + this.emojiContent + ",channelContent=" + this.channelContent + ",topicContent=" + this.topicContent + ",groupContent=" + this.groupContent + ",}";
    }

    public GProMVPRichTextContent(int i3, GProMVPTextContent gProMVPTextContent, GProMVPAtContent gProMVPAtContent, GProMVPURLContent gProMVPURLContent, GProMVPEmojiContent gProMVPEmojiContent, GProMVPChannelContent gProMVPChannelContent) {
        this.serialVersionUID = 1L;
        this.textContent = new GProMVPTextContent();
        this.atContent = new GProMVPAtContent();
        this.urlContent = new GProMVPURLContent();
        this.emojiContent = new GProMVPEmojiContent();
        this.channelContent = new GProMVPChannelContent();
        this.topicContent = new GProMVPTopicContent();
        this.groupContent = new GProMVPGroupContent();
        this.type = i3;
        this.textContent = gProMVPTextContent;
        this.atContent = gProMVPAtContent;
        this.urlContent = gProMVPURLContent;
        this.emojiContent = gProMVPEmojiContent;
        this.channelContent = gProMVPChannelContent;
    }
}
