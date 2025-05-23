package com.tencent.mobileqq.qqguildsdk.data;

/* loaded from: classes17.dex */
public class GProScreenShareUserData implements IGProScreenShareUser {
    private int state;
    private long tinyId;

    public GProScreenShareUserData(long j3, int i3) {
        this.tinyId = j3;
        this.state = i3;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProScreenShareUser
    public int getScreenState() {
        return this.state;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProScreenShareUser
    public long getTinyId() {
        return this.tinyId;
    }
}
