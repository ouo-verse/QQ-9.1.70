package com.tencent.filament.zplan.avatar;

import com.tencent.smtt.sdk.TbsListener;
import cooperation.qzone.report.lp.LpReportInfoConfig;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0086@"}, d2 = {"Lcom/tencent/zplan/zplantracing/c;", "zplanSpanContext", "", "url", "", "slotId", "itemId", "Lcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;", "urlTemplate", "Lkotlin/coroutines/Continuation;", "Lcom/tencent/filament/zplan/avatar/model/b;", "continuation", "", "fetchAIGCResourceToFolder"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.filament.zplan.avatar.ZPlanAvatarResourceHelper", f = "ZPlanAvatarResourceHelper.kt", i = {0, 0, 0, 0, 1, 1}, l = {TbsListener.ErrorCode.STATIC_TBS_INSTALL_HAS_INSTALLED_EXCEPTION, LpReportInfoConfig.ACTION_VIDEO_EDITOR}, m = "fetchAIGCResourceToFolder", n = {"urlTemplate", "fetchAIGCResourceSpan", "res", "coroutineScope", "fetchAIGCResourceSpan", "res"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1"})
/* loaded from: classes6.dex */
public final class ZPlanAvatarResourceHelper$fetchAIGCResourceToFolder$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ZPlanAvatarResourceHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanAvatarResourceHelper$fetchAIGCResourceToFolder$1(ZPlanAvatarResourceHelper zPlanAvatarResourceHelper, Continuation continuation) {
        super(continuation);
        this.this$0 = zPlanAvatarResourceHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.y(null, null, 0L, 0L, null, this);
    }
}
