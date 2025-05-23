package com.tencent.biz.qqcircle.beans;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSCommentExtendInfo implements Serializable {
    public String mCommentId;
    public long mCreateTime;
    public String mFeedId;
    public String mPostUin;
    public String mReplyId;

    public QFSCommentExtendInfo(String str, String str2) {
        this.mCommentId = str;
        this.mReplyId = str2;
    }

    public String toString() {
        return "QFSCommentExtendInfo{mCommentId='" + this.mCommentId + "', mReplyId='" + this.mReplyId + "', mFeedId='" + this.mFeedId + "', mCreateTime=" + this.mCreateTime + ", mPostUin='" + this.mPostUin + "'}";
    }
}
