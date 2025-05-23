package com.tencent.qqnt.kernelgpro.nativeinterface;

import com.tencent.mobileqq.haoliyou.JefsClass;
import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProElem implements Serializable {
    public int type;
    long serialVersionUID = 1;
    public GProTextElem text = new GProTextElem();
    public GProImageElem image = new GProImageElem();
    public GProVideoElem video = new GProVideoElem();
    public GProURLElem url = new GProURLElem();
    public GProEmojiElem emoji = new GProEmojiElem();

    /* renamed from: at, reason: collision with root package name */
    public GProAtElem f359287at = new GProAtElem();
    public GProChannelElem channel = new GProChannelElem();
    public GProTopicElem topic = new GProTopicElem();
    public GProGroupElem group = new GProGroupElem();

    public GProAtElem getAt() {
        return this.f359287at;
    }

    public GProChannelElem getChannel() {
        return this.channel;
    }

    public GProEmojiElem getEmoji() {
        return this.emoji;
    }

    public GProGroupElem getGroup() {
        return this.group;
    }

    public GProImageElem getImage() {
        return this.image;
    }

    public GProTextElem getText() {
        return this.text;
    }

    public GProTopicElem getTopic() {
        return this.topic;
    }

    public int getType() {
        return this.type;
    }

    public GProURLElem getUrl() {
        return this.url;
    }

    public GProVideoElem getVideo() {
        return this.video;
    }

    public String toString() {
        return "GProElem{text=" + this.text + ",image=" + this.image + ",video=" + this.video + JefsClass.INDEX_URL + this.url + ",emoji=" + this.emoji + ",at=" + this.f359287at + ",channel=" + this.channel + ",topic=" + this.topic + ",group=" + this.group + ",type=" + this.type + ",}";
    }
}
