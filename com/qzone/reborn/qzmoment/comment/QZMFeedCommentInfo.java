package com.qzone.reborn.qzmoment.comment;

import java.io.Serializable;
import qzonemoment.QZMomentMeta$StComment;
import qzonemoment.QZMomentMeta$StFeed;
import qzonemoment.QZMomentMeta$StReply;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZMFeedCommentInfo implements Serializable {
    public static final String FEED_COMMENT_INFO_KEY = "feed_comment_info_key";
    public QZMomentMeta$StComment mComment;
    public QZMomentMeta$StFeed mFeed;
    public String mHintText;
    public boolean mIsFromHostPraise;
    public boolean mIsGuest;
    public String mPermissionText;
    public QZMomentMeta$StReply mReply;
    public int mTotalCommentCount;

    public QZMFeedCommentInfo() {
    }

    public QZMFeedCommentInfo(QZMomentMeta$StFeed qZMomentMeta$StFeed) {
        this.mFeed = qZMomentMeta$StFeed;
    }

    public QZMFeedCommentInfo(QZMomentMeta$StFeed qZMomentMeta$StFeed, int i3) {
        this.mFeed = qZMomentMeta$StFeed;
        this.mTotalCommentCount = i3;
    }

    public QZMFeedCommentInfo(QZMomentMeta$StFeed qZMomentMeta$StFeed, int i3, String str) {
        this.mFeed = qZMomentMeta$StFeed;
        this.mTotalCommentCount = i3;
        this.mPermissionText = str;
    }
}
