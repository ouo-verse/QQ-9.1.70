package com.tencent.ams.mosaic.jsengine.common.thread;

import com.tencent.ams.hippo.quickjs.android.JSFunction;
import com.tencent.ams.mosaic.jsengine.annotation.JSAgent;

/* compiled from: P */
@JSAgent
/* loaded from: classes3.dex */
interface IMosaicThread {
    IMosaicCountDownLatch createCountDownLatch(int i3);

    boolean isMainThread();

    void runOnAsyncThread(JSFunction jSFunction);

    void runOnUIThread(JSFunction jSFunction);

    void runOnUIThreadAtFrontOfQueue(JSFunction jSFunction);

    void runOnUIThreadDelay(JSFunction jSFunction, long j3);

    void sleep(long j3);
}
