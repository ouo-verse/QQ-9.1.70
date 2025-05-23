package com.huya.huyasdk.data;

/* compiled from: P */
/* loaded from: classes2.dex */
public class LongRequestInfo {
    public LongRequest longRequest;
    public long start_send_time;
    public int retryCount = 0;
    public boolean isTimeOut = false;

    public LongRequestInfo(LongRequest longRequest, long j3) {
        this.longRequest = longRequest;
        this.start_send_time = j3;
    }
}
