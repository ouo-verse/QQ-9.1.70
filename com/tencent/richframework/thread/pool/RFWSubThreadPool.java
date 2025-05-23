package com.tencent.richframework.thread.pool;

import com.tencent.richframework.thread.factory.RFWThreadFactory;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: classes25.dex */
public class RFWSubThreadPool extends RFWThreadPool {
    private static final int SUB_MAX_POOL_SIZE = Math.max(3, RFWThreadPool.DEFAULT_MAX_POOL_SIZE) * 2;

    public RFWSubThreadPool() {
        super(3, SUB_MAX_POOL_SIZE, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(128), new RFWThreadFactory("RFWSubThreadPool"));
    }
}
