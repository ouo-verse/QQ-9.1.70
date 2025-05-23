package com.tencent.state.square;

import com.tencent.state.square.api.ISquareOnlineStatusService;
import com.tencent.state.square.api.OnlineStatusListener;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/state/square/DefaultSquareOnlineStatusService;", "Lcom/tencent/state/square/api/ISquareOnlineStatusService;", "()V", "listeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/tencent/state/square/api/OnlineStatusListener;", "destroy", "", "init", "registerListener", "listener", "unRegisterListener", "updateOnlineStatus", "onlineStatus", "", "Companion", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public final class DefaultSquareOnlineStatusService implements ISquareOnlineStatusService {
    private static final String TAG = "StatusHelper";
    private final CopyOnWriteArrayList<OnlineStatusListener> listeners = new CopyOnWriteArrayList<>();

    @Override // com.tencent.state.square.api.ISquareOnlineStatusService
    public void destroy() {
        SquareBaseKt.getSquareLog().d(TAG, "destroy");
        this.listeners.clear();
    }

    @Override // com.tencent.state.square.api.ISquareOnlineStatusService
    public void init() {
        SquareBaseKt.getSquareLog().d(TAG, "init");
    }

    @Override // com.tencent.state.square.api.ISquareOnlineStatusService
    public void registerListener(@NotNull OnlineStatusListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.addIfAbsent(listener);
    }

    @Override // com.tencent.state.square.api.ISquareOnlineStatusService
    public void unRegisterListener(@NotNull OnlineStatusListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.remove(listener);
    }

    @Override // com.tencent.state.square.api.ISquareOnlineStatusService
    public void updateOnlineStatus(int onlineStatus) {
        SquareBaseKt.getSquareLog().d(TAG, "updateOnlineStatus " + onlineStatus);
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((OnlineStatusListener) it.next()).onStatusChange(true, onlineStatus);
        }
    }
}
