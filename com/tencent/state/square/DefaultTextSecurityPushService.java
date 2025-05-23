package com.tencent.state.square;

import com.tencent.state.square.api.ISquarePushListener;
import com.tencent.state.square.api.ISquarePushService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/state/square/DefaultTextSecurityPushService;", "Lcom/tencent/state/square/api/ISquarePushService;", "()V", "addListener", "", "type", "", "listener", "Lcom/tencent/state/square/api/ISquarePushListener;", "init", "release", "removeListener", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public final class DefaultTextSecurityPushService implements ISquarePushService {
    @Override // com.tencent.state.square.api.ISquarePushService
    public void addListener(int type, @NotNull ISquarePushListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    @Override // com.tencent.state.square.api.ISquarePushService
    public void removeListener(int type, @NotNull ISquarePushListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    @Override // com.tencent.state.square.api.ISquarePushService
    public void init() {
    }

    @Override // com.tencent.state.square.api.ISquarePushService
    public void release() {
    }
}
