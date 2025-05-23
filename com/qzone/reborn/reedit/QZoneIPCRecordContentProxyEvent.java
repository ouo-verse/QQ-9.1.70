package com.qzone.reborn.reedit;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes37.dex */
public class QZoneIPCRecordContentProxyEvent extends SimpleBaseEvent {
    public int mAppid;
    public String mClientKey;
    public long mRecordTimeStamp;
    public long mUin;

    public QZoneIPCRecordContentProxyEvent(long j3, long j16, int i3, String str) {
        this.mUin = j3;
        this.mRecordTimeStamp = j16;
        this.mAppid = i3;
        this.mClientKey = str;
    }
}
