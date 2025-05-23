package com.tencent.mobileqq.troop.troopsetting.modules.base;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a,\u0010\u0007\u001a\u00020\u0005*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0014\u0010\u0006\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0000\u00a8\u0006\b"}, d2 = {"Lcom/tencent/common/app/AppInterface;", "", "troopUin", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "", "callback", "c", "qqtroop-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class e {
    public static final void c(@NotNull AppInterface appInterface, @Nullable final String str, @NotNull final Function1<? super TroopInfo, Unit> callback) {
        Intrinsics.checkNotNullParameter(appInterface, "<this>");
        Intrinsics.checkNotNullParameter(callback, "callback");
        IRuntimeService runtimeService = appInterface.getRuntimeService(ITroopInfoService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "this.getRuntimeService(I\u2026va, ProcessConstant.MAIN)");
        final ITroopInfoService iTroopInfoService = (ITroopInfoService) runtimeService;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.troop.troopsetting.modules.base.c
            @Override // java.lang.Runnable
            public final void run() {
                e.d(ITroopInfoService.this, str, callback);
            }
        }, 32, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(ITroopInfoService troopInfoService, String str, final Function1 callback) {
        Intrinsics.checkNotNullParameter(troopInfoService, "$troopInfoService");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        final TroopInfo findTroopInfo = troopInfoService.findTroopInfo(str);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.troop.troopsetting.modules.base.d
            @Override // java.lang.Runnable
            public final void run() {
                e.e(Function1.this, findTroopInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(Function1 callback, TroopInfo troopInfo) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        callback.invoke(troopInfo);
    }
}
