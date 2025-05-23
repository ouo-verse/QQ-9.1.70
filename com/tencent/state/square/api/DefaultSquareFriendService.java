package com.tencent.state.square.api;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/state/square/api/DefaultSquareFriendService;", "Lcom/tencent/state/square/api/ISquareFriendService;", "()V", "addObserver", "", "observer", "Lcom/tencent/state/square/api/ISquareFriendObserver;", "destroy", "init", "removeObserver", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public final class DefaultSquareFriendService implements ISquareFriendService {
    @Override // com.tencent.state.square.api.ISquareFriendService
    public void addObserver(@NotNull ISquareFriendObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
    }

    @Override // com.tencent.state.square.api.ISquareFriendService
    public void removeObserver(@NotNull ISquareFriendObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
    }

    @Override // com.tencent.state.square.api.ISquareFriendService
    public void destroy() {
    }

    @Override // com.tencent.state.square.api.ISquareFriendService
    public void init() {
    }
}
