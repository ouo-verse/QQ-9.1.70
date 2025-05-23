package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProMVPReply {
    public long createTime;
    public boolean isSecBeat;

    /* renamed from: id, reason: collision with root package name */
    public String f359300id = "";
    public GProMVPUser poster = new GProMVPUser();
    public GProMVPRichText content = new GProMVPRichText();
    public ArrayList<GProMVPImage> images = new ArrayList<>();
    public GProMVPLike like = new GProMVPLike();
    public GProMVPUser targetUser = new GProMVPUser();
    public byte[] oldRichText = new byte[0];

    public GProMVPRichText getContent() {
        return this.content;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public String getId() {
        return this.f359300id;
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

    public GProMVPUser getTargetUser() {
        return this.targetUser;
    }

    public String toString() {
        return "GProMVPReply{id=" + this.f359300id + ",poster=" + this.poster + ",createTime=" + this.createTime + ",content=" + this.content + ",images=" + this.images + ",like=" + this.like + ",targetUser=" + this.targetUser + ",isSecBeat=" + this.isSecBeat + ",oldRichText=" + this.oldRichText + ",}";
    }
}
