package com.tencent.mobileqq.vas.social.service;

import com.tencent.mobileqq.vas.social.config.h;
import com.tencent.mobileqq.vas.social.config.l;
import com.tencent.state.square.api.DefaultSquareBatteryService;
import com.tencent.state.square.api.ISquareBatteryService;
import com.tencent.state.square.api.ISquareFriendService;
import com.tencent.state.square.api.ISquareMusicService;
import com.tencent.state.square.api.ISquareObserveRoleRegistService;
import com.tencent.state.square.api.ISquareOnlineStatusService;
import com.tencent.state.square.api.ISquarePushService;
import com.tencent.state.square.api.ISquareServiceFactory;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/vas/social/service/d;", "Lcom/tencent/state/square/api/ISquareServiceFactory;", "Lcom/tencent/state/square/api/ISquareOnlineStatusService;", "createStatusService", "Lcom/tencent/state/square/api/ISquareBatteryService;", "createBatteryService", "Lcom/tencent/state/square/api/ISquareFriendService;", "createFriendService", "Lcom/tencent/state/square/api/ISquareMusicService;", "createMusicService", "Lcom/tencent/state/square/api/ISquareObserveRoleRegistService;", "createObserveRoleRegistService", "Lcom/tencent/state/square/api/ISquarePushService;", "createPushService", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class d implements ISquareServiceFactory {
    @Override // com.tencent.state.square.api.ISquareServiceFactory
    public ISquareBatteryService createBatteryService() {
        return new DefaultSquareBatteryService();
    }

    @Override // com.tencent.state.square.api.ISquareServiceFactory
    public ISquareFriendService createFriendService() {
        return new h();
    }

    @Override // com.tencent.state.square.api.ISquareServiceFactory
    public ISquareMusicService createMusicService() {
        return new l();
    }

    @Override // com.tencent.state.square.api.ISquareServiceFactory
    public ISquareObserveRoleRegistService createObserveRoleRegistService() {
        return new SquareObserveRoleRegistServiceImpl();
    }

    @Override // com.tencent.state.square.api.ISquareServiceFactory
    public ISquarePushService createPushService() {
        return new c();
    }

    @Override // com.tencent.state.square.api.ISquareServiceFactory
    public ISquareOnlineStatusService createStatusService() {
        return new b();
    }
}
