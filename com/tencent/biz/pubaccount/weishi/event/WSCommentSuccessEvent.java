package com.tencent.biz.pubaccount.weishi.event;

/* compiled from: P */
/* loaded from: classes32.dex */
public class WSCommentSuccessEvent extends WSSimpleBaseEvent {
    private String commentId;
    private boolean isSendArk;
    private boolean isShowCommentPanel;
    private String replyId;

    public WSCommentSuccessEvent(boolean z16, boolean z17, String str, String str2) {
        this.isSendArk = z16;
        this.isShowCommentPanel = z17;
        this.commentId = str;
        this.replyId = str2;
    }

    public String getCommentId() {
        return this.commentId;
    }

    public String getReplyId() {
        return this.replyId;
    }

    public boolean isSendArk() {
        return this.isSendArk;
    }

    public boolean isShowCommentPanel() {
        return this.isShowCommentPanel;
    }
}
