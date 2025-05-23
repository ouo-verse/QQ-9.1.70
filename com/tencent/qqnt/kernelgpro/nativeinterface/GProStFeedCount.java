package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProStFeedCount implements Serializable {
    public long comment;
    public long liked;
    public long push;
    long serialVersionUID = 1;
    public long visitor;

    public long getComment() {
        return this.comment;
    }

    public long getLiked() {
        return this.liked;
    }

    public long getPush() {
        return this.push;
    }

    public long getVisitor() {
        return this.visitor;
    }

    public String toString() {
        return "GProStFeedCount{liked=" + this.liked + ",push=" + this.push + ",comment=" + this.comment + ",visitor=" + this.visitor + ",}";
    }
}
