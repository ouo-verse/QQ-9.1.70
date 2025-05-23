package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProFDLStComment {
    public String commentId;
    public GProFDLStLike like;

    public GProFDLStComment() {
        this.commentId = "";
        this.like = new GProFDLStLike();
    }

    public String getCommentId() {
        return this.commentId;
    }

    public GProFDLStLike getLike() {
        return this.like;
    }

    public void setCommentId(String str) {
        this.commentId = str;
    }

    public void setLike(GProFDLStLike gProFDLStLike) {
        this.like = gProFDLStLike;
    }

    public String toString() {
        return "GProFDLStComment{commentId=" + this.commentId + ",like=" + this.like + ",}";
    }

    public GProFDLStComment(String str, GProFDLStLike gProFDLStLike) {
        this.commentId = "";
        new GProFDLStLike();
        this.commentId = str;
        this.like = gProFDLStLike;
    }
}
