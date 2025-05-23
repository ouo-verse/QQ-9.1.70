package com.tencent.mobileqq.wink.h5native;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.h5native.WinkAiPaintNativeExportManager$exportAiPaintVideoAsync$1$downloadMaterialJob$1", f = "WinkAiPaintNativeExportManager.kt", i = {}, l = {168}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
final class WinkAiPaintNativeExportManager$exportAiPaintVideoAsync$1$downloadMaterialJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super MetaMaterial>, Object> {
    final /* synthetic */ RenderReq $renderReq;
    final /* synthetic */ Map<String, String> $reportParams;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkAiPaintNativeExportManager$exportAiPaintVideoAsync$1$downloadMaterialJob$1(RenderReq renderReq, Map<String, String> map, Continuation<? super WinkAiPaintNativeExportManager$exportAiPaintVideoAsync$1$downloadMaterialJob$1> continuation) {
        super(2, continuation);
        this.$renderReq = renderReq;
        this.$reportParams = map;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkAiPaintNativeExportManager$exportAiPaintVideoAsync$1$downloadMaterialJob$1(this.$renderReq, this.$reportParams, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            WinkAiPaintNativeExportManager winkAiPaintNativeExportManager = WinkAiPaintNativeExportManager.f322863a;
            String materialID = this.$renderReq.getMaterialID();
            Map<String, String> map = this.$reportParams;
            this.label = 1;
            obj = winkAiPaintNativeExportManager.D(materialID, map, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return obj;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super MetaMaterial> continuation) {
        return ((WinkAiPaintNativeExportManager$exportAiPaintVideoAsync$1$downloadMaterialJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
