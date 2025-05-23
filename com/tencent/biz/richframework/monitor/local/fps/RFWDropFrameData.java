package com.tencent.biz.richframework.monitor.local.fps;

import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWDropFrameData {
    public long[] dropTimes;
    public String scene;
    public long frameCount = 0;
    public long firstFrameTime = 0;
    public long finalFrameTime = 0;
    public long scrollDurationMs = 0;

    public RFWDropFrameData(int i3) {
        this.dropTimes = new long[i3];
    }

    public void reset() {
        this.scene = null;
        this.frameCount = 0L;
        this.firstFrameTime = 0L;
        int i3 = 0;
        while (true) {
            long[] jArr = this.dropTimes;
            if (i3 < jArr.length) {
                jArr[i3] = 0;
                i3++;
            } else {
                this.finalFrameTime = 0L;
                this.scrollDurationMs = 0L;
                return;
            }
        }
    }

    public String toString() {
        return "DropFrameData{scene='" + this.scene + "', frameCount=" + this.frameCount + ", dropTimes=" + Arrays.toString(this.dropTimes) + ", scrollDurationMs=" + this.scrollDurationMs + '}';
    }
}
