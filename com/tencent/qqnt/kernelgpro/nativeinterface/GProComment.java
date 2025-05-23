package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProComment {
    public long commentCnt;
    public long msgSeq;
    public long parentSeq;
    public long referSeq;
    public long rootSeq;

    public long getCommentCnt() {
        return this.commentCnt;
    }

    public long getMsgSeq() {
        return this.msgSeq;
    }

    public long getParentSeq() {
        return this.parentSeq;
    }

    public long getReferSeq() {
        return this.referSeq;
    }

    public long getRootSeq() {
        return this.rootSeq;
    }

    public String toString() {
        return "GProComment{msgSeq=" + this.msgSeq + ",rootSeq=" + this.rootSeq + ",parentSeq=" + this.parentSeq + ",referSeq=" + this.referSeq + ",commentCnt=" + this.commentCnt + ",}";
    }
}
