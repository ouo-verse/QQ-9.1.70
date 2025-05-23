package com.tencent.biz.pubaccount.weishi.event;

/* compiled from: P */
/* loaded from: classes32.dex */
public class WSDramaFollowEvent extends WSSimpleBaseEvent {
    public static final int STATUS_FOLLOW = 1;
    public static final int STATUS_UNFOLLOW = 0;
    private String dramaId;
    private int status;

    public WSDramaFollowEvent(String str, int i3) {
        this.dramaId = str;
        this.status = i3;
    }

    public String getDramaId() {
        return this.dramaId;
    }

    public int getStatus() {
        return this.status;
    }

    public void setDramaId(String str) {
        this.dramaId = str;
    }

    public void setStatus(int i3) {
        this.status = i3;
    }
}
