package com.tencent.mobileqq.guild.api.impl;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.guild.api.IGuildGProService;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.api.IGProGlobalService;
import com.tencent.mobileqq.qqguildsdk.api.IGProSession;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000f\u001a\u00020\rH\u0016R\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0015\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/guild/api/impl/GuildGProServiceImpl;", "Lcom/tencent/mobileqq/guild/api/IGuildGProService;", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "getGproService", "", "isReady", "", "guildId", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "getGuildInfo", "Lmqq/app/AppRuntime;", "appRuntime", "", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lmqq/app/AppRuntime;", "Lcom/tencent/mobileqq/qqguildsdk/api/IGProGlobalService;", "gproGlobalService", "Lcom/tencent/mobileqq/qqguildsdk/api/IGProGlobalService;", "Lkotlinx/coroutines/CompletableDeferred;", "Lkotlinx/coroutines/CompletableDeferred;", "<init>", "()V", "Companion", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class GuildGProServiceImpl implements IGuildGProService {

    @NotNull
    private static final String TAG = "GuildGProServiceImpl";
    private AppRuntime appRuntime;
    private IGProGlobalService gproGlobalService;

    @NotNull
    private CompletableDeferred<Boolean> isReady = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0014\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/guild/api/impl/GuildGProServiceImpl$b", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "onStartGProComplete", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b extends GPServiceObserver {
        b() {
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onStartGProComplete() {
            Logger.f235387a.d().i(GuildGProServiceImpl.TAG, 1, "GProService is ready from onStartGProComplete");
            GuildGProServiceImpl.this.isReady.complete(Boolean.TRUE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGPSService getGproService() {
        AppRuntime appRuntime = this.appRuntime;
        if (appRuntime == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appRuntime");
            appRuntime = null;
        }
        IRuntimeService runtimeService = appRuntime.getRuntimeService(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "runtimeService");
        return (IGPSService) runtimeService;
    }

    private final boolean isReady() {
        AppRuntime appRuntime = this.appRuntime;
        if (appRuntime == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appRuntime");
            appRuntime = null;
        }
        IRuntimeService runtimeService = appRuntime.getRuntimeService(IGProSession.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "runtimeService");
        if (((IGProSession) runtimeService).getGuildService() != null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildGProService
    @NotNull
    public Flow<IGProGuildInfo> getGuildInfo(@NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        return FlowKt.callbackFlow(new GuildGProServiceImpl$getGuildInfo$1(this, guildId, null));
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(@NotNull AppRuntime appRuntime) {
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        this.appRuntime = appRuntime;
        IRuntimeService runtimeService = appRuntime.getRuntimeService(IGProGlobalService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "runtimeService");
        IGProGlobalService iGProGlobalService = (IGProGlobalService) runtimeService;
        this.gproGlobalService = iGProGlobalService;
        if (iGProGlobalService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gproGlobalService");
            iGProGlobalService = null;
        }
        iGProGlobalService.addObserver(new b());
        if (isReady()) {
            Logger.f235387a.d().i(TAG, 1, "GProService is ready from onCreate");
            this.isReady.complete(Boolean.TRUE);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
    }
}
