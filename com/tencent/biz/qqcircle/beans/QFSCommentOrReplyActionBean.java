package com.tencent.biz.qqcircle.beans;

import com.tencent.biz.qqcircle.comment.effect.d;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSCommentOrReplyActionBean {
    public static final int DEFAULT_FEED_DESC_CONTENT_LIMIT_LINES = 3;
    public static final int FEED_DESC_CONTENT_LIMIT_LINES = 3;
    public static final int ITEM_AD_DESC_COMMENT = 9;
    public static final int ITEM_CMT_FEEDBACK_CARD = 10;
    public static final int ITEM_DEFAULT_COMMENT = 4;
    public static final int ITEM_FAST_COMMENT = 2;
    public static final int ITEM_FEED_DESC = 1;
    public static final int ITEM_SHARE_AD = 3;
    public static final int LESS_REPLY_ITEM = 7;
    public static final int LOADING_MORE_REPLY_ITEM = 8;
    public static final int MORE_REPLY_ITEM = 6;
    public static final int REPLY_ITEM = 5;
    private int mContentHeight;
    public int mContentLimitLines;
    public boolean mDefaultExpanded;
    public d mEffectBean;
    private boolean mIsFolded;
    public boolean mNeedDoCommentPraise;
    public boolean mNeedTopAnimation;

    public int getContentHeight() {
        return this.mContentHeight;
    }

    public boolean isFolded() {
        return this.mIsFolded;
    }

    public void setContentHeight(int i3) {
        this.mContentHeight = i3;
    }

    public void setFolded(boolean z16) {
        this.mIsFolded = z16;
    }
}
