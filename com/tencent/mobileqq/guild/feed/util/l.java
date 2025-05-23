package com.tencent.mobileqq.guild.feed.util;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.api.IGProSession;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000\u00a2\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0001*\u00020\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0003\"\u0013\u0010\b\u001a\u0004\u0018\u00010\u00058F\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\"\u0013\u0010\f\u001a\u0004\u0018\u00010\t8F\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000b\"\u0013\u0010\u0010\u001a\u0004\u0018\u00010\r8F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "a", "(Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;)Lkotlin/Unit;", "b", "Lcom/tencent/mobileqq/qqguildsdk/api/IGProSession;", "e", "()Lcom/tencent/mobileqq/qqguildsdk/api/IGProSession;", "kernelGProSession", "Lcom/tencent/qqnt/kernel/api/o;", "c", "()Lcom/tencent/qqnt/kernel/api/o;", "feedChannelService", "Luh2/h;", "d", "()Luh2/h;", "guildFileTransferService", "qqguild_feed_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class l {
    @Nullable
    public static final Unit a(@NotNull GPServiceObserver gPServiceObserver) {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        Intrinsics.checkNotNullParameter(gPServiceObserver, "<this>");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        } else {
            iRuntimeService = null;
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        if (iGPSService == null) {
            return null;
        }
        iGPSService.addObserver(gPServiceObserver);
        return Unit.INSTANCE;
    }

    @Nullable
    public static final Unit b(@NotNull GPServiceObserver gPServiceObserver) {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        Intrinsics.checkNotNullParameter(gPServiceObserver, "<this>");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        } else {
            iRuntimeService = null;
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        if (iGPSService == null) {
            return null;
        }
        iGPSService.deleteObserver(gPServiceObserver);
        return Unit.INSTANCE;
    }

    @Nullable
    public static final com.tencent.qqnt.kernel.api.o c() {
        IGProSession e16 = e();
        if (e16 == null) {
            return null;
        }
        if (!e16.isInit()) {
            e16 = null;
        }
        if (e16 == null) {
            return null;
        }
        return e16.getFeedService();
    }

    @Nullable
    public static final uh2.h d() {
        IGProSession e16 = e();
        if (e16 == null) {
            return null;
        }
        if (!e16.isInit()) {
            e16 = null;
        }
        if (e16 == null) {
            return null;
        }
        return e16.getGuildFileTransferService();
    }

    @Nullable
    public static final IGProSession e() {
        AppInterface appInterface;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IRuntimeService iRuntimeService = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGProSession.class, "");
        }
        return (IGProSession) iRuntimeService;
    }
}
