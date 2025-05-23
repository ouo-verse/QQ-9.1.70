package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProMVPComment {
    public long createTime;
    public boolean isSecBeat;
    public long sequence;

    /* renamed from: id, reason: collision with root package name */
    public String f359296id = "";
    public GProMVPUser poster = new GProMVPUser();
    public GProMVPRichText content = new GProMVPRichText();
    public ArrayList<GProMVPImage> images = new ArrayList<>();
    public GProMVPLike like = new GProMVPLike();
    public GProMVPReplys replys = new GProMVPReplys();
    public byte[] oldRichText = new byte[0];

    public GProMVPRichText getContent() {
        return this.content;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public String getId() {
        return this.f359296id;
    }

    public ArrayList<GProMVPImage> getImages() {
        return this.images;
    }

    public boolean getIsSecBeat() {
        return this.isSecBeat;
    }

    public GProMVPLike getLike() {
        return this.like;
    }

    public byte[] getOldRichText() {
        return this.oldRichText;
    }

    public GProMVPUser getPoster() {
        return this.poster;
    }

    public GProMVPReplys getReplys() {
        return this.replys;
    }

    public long getSequence() {
        return this.sequence;
    }

    public String toString() {
        return "GProMVPComment{id=" + this.f359296id + ",poster=" + this.poster + ",createTime=" + this.createTime + ",sequence=" + this.sequence + ",content=" + this.content + ",images=" + this.images + ",like=" + this.like + ",replys=" + this.replys + ",isSecBeat=" + this.isSecBeat + ",oldRichText=" + this.oldRichText + ",}";
    }
}
