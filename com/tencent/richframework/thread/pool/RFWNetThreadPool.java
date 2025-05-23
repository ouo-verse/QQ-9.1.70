package com.tencent.richframework.thread.pool;

import com.tencent.richframework.thread.factory.RFWThreadFactory;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: classes25.dex */
public class RFWNetThreadPool extends RFWThreadPool {
    private static final int NET_MAX_POOL_SIZE = Math.max(2, RFWThreadPool.DEFAULT_MAX_POOL_SIZE);

    public RFWNetThreadPool() {
        super(2, NET_MAX_POOL_SIZE, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(64), new RFWThreadFactory("RFWNetThreadPool"));
    }
}
