package com.tencent.filament.zplan.avatar;

import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.filament.zplan.avatar.ZPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$fetchTexturePacker$1", f = "ZPlanAvatarResourceHelper.kt", i = {}, l = {259}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class ZPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$fetchTexturePacker$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.tencent.zplan.zplantracing.b $fetchSplitShaderSpan;
    final /* synthetic */ FilamentUrlTemplate $urlTemplate;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$fetchTexturePacker$1(com.tencent.zplan.zplantracing.b bVar, FilamentUrlTemplate filamentUrlTemplate, Continuation continuation) {
        super(2, continuation);
        this.$fetchSplitShaderSpan = bVar;
        this.$urlTemplate = filamentUrlTemplate;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        return new ZPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$fetchTexturePacker$1(this.$fetchSplitShaderSpan, this.$urlTemplate, completion);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ZPlanAvatarResourceHelper$fetchReloadAvatarResourceNotUseCache$fetchTexturePacker$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        com.tencent.zplan.zplantracing.c cVar;
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
            ZPlanAvatarResourceHelper zPlanAvatarResourceHelper = ZPlanAvatarResourceHelper.f105660o;
            com.tencent.zplan.zplantracing.b bVar = this.$fetchSplitShaderSpan;
            if (bVar != null) {
                cVar = bVar.c();
            } else {
                cVar = null;
            }
            FilamentUrlTemplate filamentUrlTemplate = this.$urlTemplate;
            this.label = 1;
            if (zPlanAvatarResourceHelper.e0(cVar, filamentUrlTemplate, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
