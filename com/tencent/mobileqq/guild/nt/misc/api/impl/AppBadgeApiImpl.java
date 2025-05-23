package com.tencent.mobileqq.guild.nt.misc.api.impl;

import com.tencent.mobileqq.guild.nt.misc.api.IAppBadgeApi;
import com.tencent.mobileqq.guild.util.s;
import com.tencent.mobileqq.util.api.IAppBadgeService;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/nt/misc/api/impl/AppBadgeApiImpl;", "Lcom/tencent/mobileqq/guild/nt/misc/api/IAppBadgeApi;", "Lmqq/app/AppRuntime;", "app", "", "refreshAppBadge", "<init>", "()V", "Companion", "a", "qqguild-boundaries-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class AppBadgeApiImpl implements IAppBadgeApi {

    @NotNull
    private static final String TAG = "AppBadgeApiImpl";

    @Override // com.tencent.mobileqq.guild.nt.misc.api.IAppBadgeApi
    public void refreshAppBadge(@NotNull AppRuntime app) {
        Object m476constructorimpl;
        Intrinsics.checkNotNullParameter(app, "app");
        try {
            Result.Companion companion = Result.INSTANCE;
            IRuntimeService runtimeService = app.getRuntimeService(IAppBadgeService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IA\u2026va, ProcessConstant.MAIN)");
            ((IAppBadgeService) runtimeService).refreshAppBadge();
            m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
        if (m479exceptionOrNullimpl != null) {
            s.f(TAG, "refreshAppBadge()", m479exceptionOrNullimpl);
        }
    }
}
