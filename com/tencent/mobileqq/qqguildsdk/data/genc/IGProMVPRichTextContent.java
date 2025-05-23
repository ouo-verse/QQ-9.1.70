package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

/* loaded from: classes17.dex */
public interface IGProMVPRichTextContent extends Serializable {
    IGProMVPAtContent getAtContent();

    IGProMVPChannelContent getChannelContent();

    IGProMVPEmojiContent getEmojiContent();

    IGProMVPGroupContent getGroupContent();

    IGProMVPTextContent getTextContent();

    IGProMVPTopicContent getTopicContent();

    int getType();

    IGProMVPURLContent getUrlContent();

    String toString();
}
