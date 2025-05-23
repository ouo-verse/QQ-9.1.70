package com.tencent.qqnt.kernelgpro.nativeinterface;

import com.tencent.mobileqq.haoliyou.JefsClass;
import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProRichTextContentCount implements Serializable {

    /* renamed from: at, reason: collision with root package name */
    public long f359312at;
    public long emoji;
    public long image;
    long serialVersionUID = 1;
    public long textWord;
    public long url;
    public long video;

    public long getAt() {
        return this.f359312at;
    }

    public long getEmoji() {
        return this.emoji;
    }

    public long getImage() {
        return this.image;
    }

    public long getTextWord() {
        return this.textWord;
    }

    public long getUrl() {
        return this.url;
    }

    public long getVideo() {
        return this.video;
    }

    public String toString() {
        return "GProRichTextContentCount{textWord=" + this.textWord + ",at=" + this.f359312at + JefsClass.INDEX_URL + this.url + ",emoji=" + this.emoji + ",image=" + this.image + ",video=" + this.video + ",}";
    }
}
