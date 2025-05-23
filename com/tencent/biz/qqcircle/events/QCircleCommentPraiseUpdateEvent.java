package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes4.dex */
public class QCircleCommentPraiseUpdateEvent extends SimpleBaseEvent {
    public String mCommentId;
    public String mFeedId;
    public int mPraisedNum;
    public int mPraisedStatus;
    public String mReplyId;
    public final int mSender;
    public int mType;

    public QCircleCommentPraiseUpdateEvent(int i3, int i16, String str, String str2, String str3, int i17, int i18) {
        this.mType = i3;
        this.mPraisedStatus = i16;
        this.mFeedId = str;
        this.mCommentId = str2;
        this.mReplyId = str3;
        this.mPraisedNum = i17;
        this.mSender = i18;
    }
}
