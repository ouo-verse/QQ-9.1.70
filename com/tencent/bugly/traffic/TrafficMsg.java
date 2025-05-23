package com.tencent.bugly.traffic;

/* compiled from: P */
/* loaded from: classes5.dex */
public class TrafficMsg {
    public String mCollectType;
    public int mFore;
    public String mHost;
    public long mId;
    public int mNet;
    public int mRx;
    public long mTime;
    public int mTx;

    public TrafficMsg() {
        this.mCollectType = "auto";
    }

    public TrafficMsg(String str, int i3, int i16, int i17, int i18, long j3, long j16) {
        this.mHost = str;
        this.mRx = i3;
        this.mTx = i16;
        this.mNet = i17;
        this.mFore = i18;
        this.mTime = j3;
        this.mCollectType = "auto";
        this.mId = j16;
    }

    public TrafficMsg(TrafficMsg trafficMsg) {
        this.mCollectType = "auto";
        this.mHost = trafficMsg.mHost;
        this.mRx = trafficMsg.mRx;
        this.mTx = trafficMsg.mTx;
        this.mNet = trafficMsg.mNet;
        this.mFore = trafficMsg.mFore;
        this.mTime = trafficMsg.mTime;
        this.mCollectType = trafficMsg.mCollectType;
    }
}
