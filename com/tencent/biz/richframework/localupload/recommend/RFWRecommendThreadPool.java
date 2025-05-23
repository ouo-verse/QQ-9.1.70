package com.tencent.biz.richframework.localupload.recommend;

import com.tencent.richframework.thread.factory.RFWThreadFactory;
import com.tencent.richframework.thread.pool.RFWThreadPool;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/biz/richframework/localupload/recommend/RFWRecommendThreadPool;", "Lcom/tencent/richframework/thread/pool/RFWThreadPool;", "()V", "Companion", "local-upload-recommend-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class RFWRecommendThreadPool extends RFWThreadPool {
    private static final int MAX_POOL_SIZE = RFWThreadPool.CPU_COUNT + 1;

    public RFWRecommendThreadPool() {
        super(0, MAX_POOL_SIZE, 10L, TimeUnit.SECONDS, new SynchronousQueue(), new RFWThreadFactory("RFWRecommendThreadPool"));
    }
}
