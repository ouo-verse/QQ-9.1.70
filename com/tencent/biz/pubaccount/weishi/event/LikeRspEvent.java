package com.tencent.biz.pubaccount.weishi.event;

/* compiled from: P */
/* loaded from: classes32.dex */
public class LikeRspEvent extends WSSimpleBaseEvent {
    public static final int REQUEST_POST_DING_FAILED = 4302;
    public static final int REQUEST_POST_DING_SUCCESS = 4301;
    private String feedId;
    private boolean isFromRsp;
    private int position;
    private String posterId;
    private int rpsStatus;
    private int rspIsDing;

    public LikeRspEvent(String str, String str2, int i3) {
        this.posterId = str;
        this.feedId = str2;
        this.position = i3;
    }

    public String getFeedId() {
        return this.feedId;
    }

    public int getPosition() {
        return this.position;
    }

    public String getPosterId() {
        return this.posterId;
    }

    public int getRpsStatus() {
        return this.rpsStatus;
    }

    public int getRspIsDing() {
        return this.rspIsDing;
    }

    public boolean isFromRsp() {
        return this.isFromRsp;
    }

    public void setFeedId(String str) {
        this.feedId = str;
    }

    public void setFromRsp(boolean z16) {
        this.isFromRsp = z16;
    }

    public void setPosition(int i3) {
        this.position = i3;
    }

    public void setPosterId(String str) {
        this.posterId = str;
    }

    public void setRpsStatus(int i3) {
        this.rpsStatus = i3;
    }

    public void setRspIsDing(int i3) {
        this.rspIsDing = i3;
    }
}
