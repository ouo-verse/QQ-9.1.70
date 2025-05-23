package com.tencent.richframework.thread.pool;

import com.tencent.richframework.thread.factory.RFWThreadFactory;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: classes25.dex */
public class RFWAsyncDisplayPool extends RFWThreadPool {
    private static final int NET_MAX_POOL_SIZE = Math.max(2, RFWThreadPool.DEFAULT_MAX_POOL_SIZE);

    public RFWAsyncDisplayPool() {
        super(2, NET_MAX_POOL_SIZE, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(64), new RFWThreadFactory("RFWAsyncDisplayPool"));
    }
}
