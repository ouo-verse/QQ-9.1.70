package com.tencent.ams.mosaic.jsengine.common.thread;

import com.tencent.ams.mosaic.jsengine.annotation.JSAgent;

/* compiled from: P */
@JSAgent
/* loaded from: classes3.dex */
interface IMosaicCountDownLatch {
    void await();

    boolean awaitUntil(long j3);

    void countDown();
}
