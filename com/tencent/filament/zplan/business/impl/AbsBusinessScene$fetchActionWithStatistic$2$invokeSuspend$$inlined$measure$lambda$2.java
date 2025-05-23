package com.tencent.filament.zplan.business.impl;

import com.tencent.filament.zplan.animation.ZPlanAction;
import com.tencent.filament.zplan.avatar.ZPlanAvatarResourceHelper;
import com.tencent.filament.zplan.avatar.model.EnumUserGender;
import com.tencent.filament.zplan.data.FetchActionData;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import com.tencent.zplan.zplantracing.b;
import com.tencent.zplan.zplantracing.c;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0006"}, d2 = {"<anonymous>", "Lcom/tencent/filament/zplan/animation/ZPlanAction;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/filament/zplan/business/impl/AbsBusinessScene$fetchActionWithStatistic$2$actions$1$1$2", "com/tencent/filament/zplan/business/impl/AbsBusinessScene$fetchActionWithStatistic$2$$special$$inlined$forEach$lambda$2"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.filament.zplan.business.impl.AbsBusinessScene$fetchActionWithStatistic$2$actions$1$1$2", f = "AbsBusinessScene.kt", i = {}, l = {1098}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class AbsBusinessScene$fetchActionWithStatistic$2$invokeSuspend$$inlined$measure$lambda$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ZPlanAction>, Object> {
    final /* synthetic */ FetchActionData $fetchActionData;
    final /* synthetic */ b $fetchActionSpan$inlined;
    final /* synthetic */ ArrayList $jobList$inlined;
    final /* synthetic */ CoroutineScope $this_supervisorScope$inlined;
    int label;
    final /* synthetic */ AbsBusinessScene$fetchActionWithStatistic$2 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbsBusinessScene$fetchActionWithStatistic$2$invokeSuspend$$inlined$measure$lambda$2(FetchActionData fetchActionData, Continuation continuation, ArrayList arrayList, AbsBusinessScene$fetchActionWithStatistic$2 absBusinessScene$fetchActionWithStatistic$2, CoroutineScope coroutineScope, b bVar) {
        super(2, continuation);
        this.$fetchActionData = fetchActionData;
        this.$jobList$inlined = arrayList;
        this.this$0 = absBusinessScene$fetchActionWithStatistic$2;
        this.$this_supervisorScope$inlined = coroutineScope;
        this.$fetchActionSpan$inlined = bVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        return new AbsBusinessScene$fetchActionWithStatistic$2$invokeSuspend$$inlined$measure$lambda$2(this.$fetchActionData, completion, this.$jobList$inlined, this.this$0, this.$this_supervisorScope$inlined, this.$fetchActionSpan$inlined);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ZPlanAction> continuation) {
        return ((AbsBusinessScene$fetchActionWithStatistic$2$invokeSuspend$$inlined$measure$lambda$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        c cVar;
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
            b bVar = this.$fetchActionSpan$inlined;
            if (bVar != null) {
                cVar = bVar.c();
            } else {
                cVar = null;
            }
            EnumUserGender enumUserGender = this.this$0.$gender;
            String actionFacePath = this.$fetchActionData.getActionFacePath();
            Intrinsics.checkNotNull(actionFacePath);
            String actionBodyPath = this.$fetchActionData.getActionBodyPath();
            Intrinsics.checkNotNull(actionBodyPath);
            FilamentUrlTemplate urlTemplate = this.this$0.this$0.getUrlTemplate();
            this.label = 1;
            obj = zPlanAvatarResourceHelper.B(cVar, enumUserGender, actionFacePath, actionBodyPath, urlTemplate, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return obj;
    }
}
