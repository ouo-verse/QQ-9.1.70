package com.tencent.biz.pubaccount.weishi.event;

/* compiled from: P */
/* loaded from: classes32.dex */
public class WSAddCommentEvent extends WSSimpleBaseEvent {
    private long commentNum;
    private String feedId;
    private int position;

    public WSAddCommentEvent(String str, int i3, long j3) {
        this.feedId = str;
        this.position = i3;
        this.commentNum = j3;
    }

    public long getCommentNum() {
        return this.commentNum;
    }

    public String getFeedId() {
        return this.feedId;
    }

    public int getPosition() {
        return this.position;
    }

    public void setCommentNum(long j3) {
        this.commentNum = j3;
    }

    public void setFeedId(String str) {
        this.feedId = str;
    }

    public void setPosition(int i3) {
        this.position = i3;
    }
}
