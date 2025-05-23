package fa3;

import com.tencent.richframework.thread.pool.RFWThreadPool;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00042\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0006"}, d2 = {"Lfa3/n;", "Lcom/tencent/richframework/thread/pool/RFWThreadPool;", "<init>", "()V", "e", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class n extends RFWThreadPool {

    /* renamed from: f, reason: collision with root package name */
    private static final int f398095f = Math.max(2, RFWThreadPool.DEFAULT_MAX_POOL_SIZE);

    public n() {
        super(2, f398095f, 2L, TimeUnit.SECONDS, new LinkedBlockingQueue(64), new m());
    }
}
