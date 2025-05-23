package com.tencent.robot.discoveryv2.common.repository.proxy;

import com.tencent.robot.discoveryv2.common.data.LoadState;
import com.tencent.robot.discoveryv2.common.data.c;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0006J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\tR\u0016\u0010\r\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR,\u0010\u0012\u001a\u001a\u0012\u0004\u0012\u00020\u000f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u00100\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/robot/discoveryv2/common/repository/proxy/FirstScreenLoadStateProxy;", "", "", "c", "Lcom/tencent/robot/discoveryv2/common/data/LoadState;", "loadState", "", "e", "d", "Lkotlinx/coroutines/flow/Flow;", "b", "a", "Lcom/tencent/robot/discoveryv2/common/data/LoadState;", "mFirstScreenLoadState", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lkotlin/Function1;", "Ljava/util/concurrent/ConcurrentHashMap;", "mFirstScreenLoadStateListener", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class FirstScreenLoadStateProxy {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private LoadState mFirstScreenLoadState = LoadState.NONE;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<Integer, Function1<LoadState, Unit>> mFirstScreenLoadStateListener = new ConcurrentHashMap<>();

    @NotNull
    public final Flow<LoadState> b() {
        return FlowKt.callbackFlow(new FirstScreenLoadStateProxy$firstScreenLoadStateNotificationFlow$1(this, null));
    }

    public final boolean c() {
        return c.b(this.mFirstScreenLoadState);
    }

    public final void d() {
        Iterator<Map.Entry<Integer, Function1<LoadState, Unit>>> it = this.mFirstScreenLoadStateListener.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().invoke(this.mFirstScreenLoadState);
        }
    }

    public final void e(@NotNull LoadState loadState) {
        Intrinsics.checkNotNullParameter(loadState, "loadState");
        if (loadState == this.mFirstScreenLoadState) {
            return;
        }
        this.mFirstScreenLoadState = loadState;
    }
}
