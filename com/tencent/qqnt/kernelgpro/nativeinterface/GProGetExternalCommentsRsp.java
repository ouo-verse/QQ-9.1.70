package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGetExternalCommentsRsp {
    public ArrayList<GProStComment> externalCommentList = new ArrayList<>();

    public ArrayList<GProStComment> getExternalCommentList() {
        return this.externalCommentList;
    }

    public String toString() {
        return "GProGetExternalCommentsRsp{externalCommentList=" + this.externalCommentList + ",}";
    }
}
