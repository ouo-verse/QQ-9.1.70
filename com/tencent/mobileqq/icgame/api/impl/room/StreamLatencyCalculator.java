package com.tencent.mobileqq.icgame.api.impl.room;

import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes15.dex */
public class StreamLatencyCalculator {
    private static final String TAG = "StreamLatencyCalculator";
    private final IAegisLogApi log = (IAegisLogApi) QRoute.api(IAegisLogApi.class);
    private long serverTimeStampOffset = 0;

    public long getStreamLatency(long j3) {
        return Math.abs((System.currentTimeMillis() - j3) - this.serverTimeStampOffset);
    }

    public void onEnterRoom(long j3) {
        this.serverTimeStampOffset = 0L;
        if (j3 == 0) {
            this.serverTimeStampOffset = 0L;
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.serverTimeStampOffset = currentTimeMillis - j3;
        this.log.i(TAG, "serverTimeStamp\uff1a" + j3 + ", localTimeStamp:" + currentTimeMillis + " offset:" + this.serverTimeStampOffset);
    }

    public void onExitRoom() {
        this.serverTimeStampOffset = 0L;
    }
}
