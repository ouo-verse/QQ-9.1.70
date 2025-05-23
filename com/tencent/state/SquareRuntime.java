package com.tencent.state;

import com.tencent.qqmini.sdk.request.GetAdInfoRequest;
import com.tencent.state.square.SquareBaseKt;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0010J\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0013J\u0006\u0010\u0015\u001a\u00020\u0013J\u0006\u0010\u0016\u001a\u00020\u0013R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/state/SquareRuntime;", "", "()V", "TAG", "", "markCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "nearbyMarkCount", GetAdInfoRequest.SOURCE_FROM, "getSourceFrom", "()Ljava/lang/String;", "setSourceFrom", "(Ljava/lang/String;)V", "getQMetaContextSource", "", "hasMark", "", "hasNearbyMark", "mark", "", "markNearby", "removeMark", "removeNearbyMark", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class SquareRuntime {
    private static final String TAG = "SquareRuntime";
    public static final SquareRuntime INSTANCE = new SquareRuntime();
    private static String sourceFrom = "";
    private static AtomicInteger markCount = new AtomicInteger(0);
    private static AtomicInteger nearbyMarkCount = new AtomicInteger(0);

    SquareRuntime() {
    }

    public final int getQMetaContextSource() {
        return hasNearbyMark() ? 6 : 0;
    }

    public final String getSourceFrom() {
        return sourceFrom;
    }

    public final boolean hasMark() {
        return markCount.get() > 0;
    }

    public final boolean hasNearbyMark() {
        return nearbyMarkCount.get() > 0;
    }

    public final void mark() {
        int incrementAndGet = markCount.incrementAndGet();
        SquareBaseKt.getSquareLog().i(TAG, "mark, count=" + incrementAndGet);
    }

    public final void markNearby() {
        int incrementAndGet = nearbyMarkCount.incrementAndGet();
        SquareBaseKt.getSquareLog().i(TAG, "mark, count=" + incrementAndGet);
    }

    public final void removeMark() {
        int decrementAndGet = markCount.decrementAndGet();
        SquareBaseKt.getSquareLog().i(TAG, "mark remove, count=" + decrementAndGet);
    }

    public final void removeNearbyMark() {
        int decrementAndGet = nearbyMarkCount.decrementAndGet();
        SquareBaseKt.getSquareLog().i(TAG, "mark remove, count=" + decrementAndGet);
    }

    public final void setSourceFrom(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        sourceFrom = str;
    }
}
