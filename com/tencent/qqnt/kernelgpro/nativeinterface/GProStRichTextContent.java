package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProStRichTextContent implements Serializable {
    public int type;
    long serialVersionUID = 1;
    public String patternId = "";
    public GProStRichTextTextContent textContent = new GProStRichTextTextContent();
    public GProStRichTextAtContent atContent = new GProStRichTextAtContent();
    public GProStRichTextURLContent urlContent = new GProStRichTextURLContent();
    public GProStRichTextEmojiContent emojiContent = new GProStRichTextEmojiContent();
    public GProStRichTextChannelContent channelContent = new GProStRichTextChannelContent();
    public GProStRichTextGuildContent guildContent = new GProStRichTextGuildContent();
    public GProStRichTextIconContent iconContent = new GProStRichTextIconContent();
    public GProStRichTextTopicContent topicContent = new GProStRichTextTopicContent();
    public GProStRichTextGroupContent groupContent = new GProStRichTextGroupContent();

    public GProStRichTextAtContent getAtContent() {
        return this.atContent;
    }

    public GProStRichTextChannelContent getChannelContent() {
        return this.channelContent;
    }

    public GProStRichTextEmojiContent getEmojiContent() {
        return this.emojiContent;
    }

    public GProStRichTextGroupContent getGroupContent() {
        return this.groupContent;
    }

    public GProStRichTextGuildContent getGuildContent() {
        return this.guildContent;
    }

    public GProStRichTextIconContent getIconContent() {
        return this.iconContent;
    }

    public String getPatternId() {
        return this.patternId;
    }

    public GProStRichTextTextContent getTextContent() {
        return this.textContent;
    }

    public GProStRichTextTopicContent getTopicContent() {
        return this.topicContent;
    }

    public int getType() {
        return this.type;
    }

    public GProStRichTextURLContent getUrlContent() {
        return this.urlContent;
    }

    public String toString() {
        return "GProStRichTextContent{type=" + this.type + ",patternId=" + this.patternId + ",textContent=" + this.textContent + ",atContent=" + this.atContent + ",urlContent=" + this.urlContent + ",emojiContent=" + this.emojiContent + ",channelContent=" + this.channelContent + ",guildContent=" + this.guildContent + ",iconContent=" + this.iconContent + ",topicContent=" + this.topicContent + ",groupContent=" + this.groupContent + ",}";
    }
}
