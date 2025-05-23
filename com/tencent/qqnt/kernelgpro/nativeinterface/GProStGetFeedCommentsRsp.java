package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProStGetFeedCommentsRsp {
    public int isFinish;
    public int totalLikeCount;
    public int totalNum;
    public GProStCommonExt extInfo = new GProStCommonExt();
    public ArrayList<GProStComment> vecCommentList = new ArrayList<>();
    public String attchInfo = "";
    public GProStComment topComment = new GProStComment();

    public String getAttchInfo() {
        return this.attchInfo;
    }

    public GProStCommonExt getExtInfo() {
        return this.extInfo;
    }

    public int getIsFinish() {
        return this.isFinish;
    }

    public GProStComment getTopComment() {
        return this.topComment;
    }

    public int getTotalLikeCount() {
        return this.totalLikeCount;
    }

    public int getTotalNum() {
        return this.totalNum;
    }

    public ArrayList<GProStComment> getVecCommentList() {
        return this.vecCommentList;
    }

    public String toString() {
        return "GProStGetFeedCommentsRsp{extInfo=" + this.extInfo + ",vecCommentList=" + this.vecCommentList + ",totalNum=" + this.totalNum + ",isFinish=" + this.isFinish + ",attchInfo=" + this.attchInfo + ",totalLikeCount=" + this.totalLikeCount + ",topComment=" + this.topComment + ",}";
    }
}
