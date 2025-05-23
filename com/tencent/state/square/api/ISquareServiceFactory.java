package com.tencent.state.square.api;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\n\u0010\b\u001a\u0004\u0018\u00010\tH&J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\rH&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/state/square/api/ISquareServiceFactory;", "", "createBatteryService", "Lcom/tencent/state/square/api/ISquareBatteryService;", "createFriendService", "Lcom/tencent/state/square/api/ISquareFriendService;", "createMusicService", "Lcom/tencent/state/square/api/ISquareMusicService;", "createObserveRoleRegistService", "Lcom/tencent/state/square/api/ISquareObserveRoleRegistService;", "createPushService", "Lcom/tencent/state/square/api/ISquarePushService;", "createStatusService", "Lcom/tencent/state/square/api/ISquareOnlineStatusService;", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public interface ISquareServiceFactory {
    @NotNull
    ISquareBatteryService createBatteryService();

    @NotNull
    ISquareFriendService createFriendService();

    @NotNull
    ISquareMusicService createMusicService();

    @Nullable
    ISquareObserveRoleRegistService createObserveRoleRegistService();

    @NotNull
    ISquarePushService createPushService();

    @NotNull
    ISquareOnlineStatusService createStatusService();
}
