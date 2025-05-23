package com.tencent.mobileqq.vasgift.countdown;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes20.dex */
public class CountDownInfo implements Serializable {
    private static final long serialVersionUID = 1;
    public long countDownTime;
    public int giftID;
    public long remainTime;

    public CountDownInfo(int i3, long j3, long j16) {
        this.giftID = i3;
        this.remainTime = j3;
        this.countDownTime = j16;
    }

    public float calProgress(long j3, long j16) {
        if (j16 == 0) {
            return 100.0f;
        }
        return 100.0f * (1.0f - ((((float) j3) * 1.0f) / ((float) j16)));
    }

    public String toString() {
        return "CountDownInfo{giftID=" + this.giftID + ", remainTime=" + this.remainTime + ", countDownTime=" + this.countDownTime + '}';
    }
}
