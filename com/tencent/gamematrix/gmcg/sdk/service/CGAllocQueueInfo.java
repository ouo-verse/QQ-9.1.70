package com.tencent.gamematrix.gmcg.sdk.service;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGAllocQueueInfo {
    public int normalQueueSize;
    public int normalWaitSec;
    public int vipQueueSize;
    public int vipWaitSec;

    public int getCurAllocQueueSize(boolean z16) {
        if (z16) {
            return this.vipQueueSize + this.normalQueueSize;
        }
        return this.normalQueueSize;
    }

    public int getCurAllocQueueWaitSec(boolean z16) {
        if (z16) {
            return this.vipWaitSec + this.normalWaitSec;
        }
        return this.normalWaitSec;
    }
}
