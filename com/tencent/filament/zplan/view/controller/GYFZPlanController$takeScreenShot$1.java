package com.tencent.filament.zplan.view.controller;

import com.tencent.filament.zplan.listener.GYScreenShotCallback;
import com.tencent.filament.zplanservice.util.log.FLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes6.dex */
final class GYFZPlanController$takeScreenShot$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ GYScreenShotCallback $callback;
    final /* synthetic */ GYFZPlanController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GYFZPlanController$takeScreenShot$1(GYFZPlanController gYFZPlanController, GYScreenShotCallback gYScreenShotCallback) {
        super(0);
        this.this$0 = gYFZPlanController;
        this.$callback = gYScreenShotCallback;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        GYFZPlanNativeAPI nativeAPI = this.this$0.getNativeAPI();
        Boolean valueOf = nativeAPI != null ? Boolean.valueOf(nativeAPI.renderAndTakeScreenShot(new GYFZPlanController$takeScreenShot$1$result$1(this))) : null;
        FLog.INSTANCE.i("GYFZPlanController", "takeScreenShot result " + valueOf);
    }
}
