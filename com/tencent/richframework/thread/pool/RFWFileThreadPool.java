package com.tencent.richframework.thread.pool;

import com.tencent.richframework.thread.factory.RFWThreadFactory;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: classes25.dex */
public class RFWFileThreadPool extends RFWThreadPool {
    private static final int FILE_MAX_POOL_SIZE = Math.max(2, RFWThreadPool.DEFAULT_MAX_POOL_SIZE);

    public RFWFileThreadPool() {
        super(2, FILE_MAX_POOL_SIZE, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(64), new RFWThreadFactory("RFWFileThreadPool"));
    }
}
