package com.tencent.state.square;

import com.tencent.state.square.api.DefaultObserveRoleRegistService;
import com.tencent.state.square.api.DefaultSquareBatteryService;
import com.tencent.state.square.api.DefaultSquareFriendService;
import com.tencent.state.square.api.DefaultSquareMusicService;
import com.tencent.state.square.api.ISquareBatteryService;
import com.tencent.state.square.api.ISquareFriendService;
import com.tencent.state.square.api.ISquareMusicService;
import com.tencent.state.square.api.ISquareObserveRoleRegistService;
import com.tencent.state.square.api.ISquareOnlineStatusService;
import com.tencent.state.square.api.ISquarePushService;
import com.tencent.state.square.api.ISquareServiceFactory;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/state/square/DefaultServiceFactory;", "Lcom/tencent/state/square/api/ISquareServiceFactory;", "()V", "createBatteryService", "Lcom/tencent/state/square/api/ISquareBatteryService;", "createFriendService", "Lcom/tencent/state/square/api/ISquareFriendService;", "createMusicService", "Lcom/tencent/state/square/api/ISquareMusicService;", "createObserveRoleRegistService", "Lcom/tencent/state/square/api/ISquareObserveRoleRegistService;", "createPushService", "Lcom/tencent/state/square/api/ISquarePushService;", "createStatusService", "Lcom/tencent/state/square/api/ISquareOnlineStatusService;", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public final class DefaultServiceFactory implements ISquareServiceFactory {
    @Override // com.tencent.state.square.api.ISquareServiceFactory
    @NotNull
    public ISquareBatteryService createBatteryService() {
        return new DefaultSquareBatteryService();
    }

    @Override // com.tencent.state.square.api.ISquareServiceFactory
    @NotNull
    public ISquareFriendService createFriendService() {
        return new DefaultSquareFriendService();
    }

    @Override // com.tencent.state.square.api.ISquareServiceFactory
    @NotNull
    public ISquareMusicService createMusicService() {
        return new DefaultSquareMusicService();
    }

    @Override // com.tencent.state.square.api.ISquareServiceFactory
    @Nullable
    public ISquareObserveRoleRegistService createObserveRoleRegistService() {
        return new DefaultObserveRoleRegistService();
    }

    @Override // com.tencent.state.square.api.ISquareServiceFactory
    @NotNull
    public ISquarePushService createPushService() {
        return new DefaultTextSecurityPushService();
    }

    @Override // com.tencent.state.square.api.ISquareServiceFactory
    @NotNull
    public ISquareOnlineStatusService createStatusService() {
        return new DefaultSquareOnlineStatusService();
    }
}
