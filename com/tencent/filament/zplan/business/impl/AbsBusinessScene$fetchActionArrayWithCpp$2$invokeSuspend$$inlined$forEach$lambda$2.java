package com.tencent.filament.zplan.business.impl;

import com.tencent.filament.zplan.animation.FilamentAnimationHelper;
import com.tencent.filament.zplan.animation.ZPlanAction;
import com.tencent.filament.zplan.data.FetchActionData;
import com.tencent.filament.zplanservice.download.ZPlanAvatarService;
import java.util.ArrayList;
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
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"<anonymous>", "Lcom/tencent/filament/zplan/animation/ZPlanAction;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/filament/zplan/business/impl/AbsBusinessScene$fetchActionArrayWithCpp$2$1$2"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.filament.zplan.business.impl.AbsBusinessScene$fetchActionArrayWithCpp$2$1$2", f = "AbsBusinessScene.kt", i = {}, l = {922}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class AbsBusinessScene$fetchActionArrayWithCpp$2$invokeSuspend$$inlined$forEach$lambda$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ZPlanAction>, Object> {
    final /* synthetic */ FetchActionData $fetchActionData;
    final /* synthetic */ ArrayList $jobList$inlined;
    final /* synthetic */ CoroutineScope $this_coroutineScope$inlined;
    int label;
    final /* synthetic */ AbsBusinessScene$fetchActionArrayWithCpp$2 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbsBusinessScene$fetchActionArrayWithCpp$2$invokeSuspend$$inlined$forEach$lambda$2(FetchActionData fetchActionData, Continuation continuation, AbsBusinessScene$fetchActionArrayWithCpp$2 absBusinessScene$fetchActionArrayWithCpp$2, CoroutineScope coroutineScope, ArrayList arrayList) {
        super(2, continuation);
        this.$fetchActionData = fetchActionData;
        this.this$0 = absBusinessScene$fetchActionArrayWithCpp$2;
        this.$this_coroutineScope$inlined = coroutineScope;
        this.$jobList$inlined = arrayList;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        return new AbsBusinessScene$fetchActionArrayWithCpp$2$invokeSuspend$$inlined$forEach$lambda$2(this.$fetchActionData, completion, this.this$0, this.$this_coroutineScope$inlined, this.$jobList$inlined);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ZPlanAction> continuation) {
        return ((AbsBusinessScene$fetchActionArrayWithCpp$2$invokeSuspend$$inlined$forEach$lambda$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            FilamentAnimationHelper filamentAnimationHelper = FilamentAnimationHelper.f105573a;
            ZPlanAvatarService zPlanAvatarService = this.this$0.$avatarService;
            String actionFacePath = this.$fetchActionData.getActionFacePath();
            Intrinsics.checkNotNull(actionFacePath);
            String actionBodyPath = this.$fetchActionData.getActionBodyPath();
            Intrinsics.checkNotNull(actionBodyPath);
            this.label = 1;
            obj = filamentAnimationHelper.b(zPlanAvatarService, actionFacePath, actionBodyPath, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return obj;
    }
}
