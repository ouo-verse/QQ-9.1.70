package com.tencent.biz.pubaccount.weishi.event;

/* compiled from: P */
/* loaded from: classes32.dex */
public class FollowEvent extends WSSimpleBaseEvent {
    private int isFollow;
    private String personId;

    public int getIsFollow() {
        return this.isFollow;
    }

    public String getPersonId() {
        return this.personId;
    }

    public boolean hasFollowed() {
        int i3 = this.isFollow;
        return i3 == 1 || i3 == 3;
    }

    public void setIsFollow(int i3) {
        this.isFollow = i3;
    }

    public void setPersonId(String str) {
        this.personId = str;
    }
}
