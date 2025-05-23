package com.tencent.filament.zplan.business.impl;

import com.tencent.filament.zplan.animation.ZPlanAction;
import com.tencent.filament.zplan.avatar.model.EnumUserGender;
import com.tencent.filament.zplan.data.FetchActionData;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.zplan.zplantracing.ZPlanSpanFactory;
import com.tencent.zplan.zplantracing.b;
import com.tencent.zplan.zplantracing.c;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00040\u0001*\u00020\u0000H\u008a@\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/Pair;", "", "Lcom/tencent/filament/zplan/animation/ZPlanAction;", "Lal0/a;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.filament.zplan.business.impl.AbsBusinessScene$fetchActionWithStatistic$2", f = "AbsBusinessScene.kt", i = {0, 0, 0}, l = {1102}, m = "invokeSuspend", n = {"fetchActionSpan", "statistic", "this_$iv"}, s = {"L$0", "L$1", "L$2"})
/* loaded from: classes6.dex */
public final class AbsBusinessScene$fetchActionWithStatistic$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends ZPlanAction[], ? extends al0.a>>, Object> {
    final /* synthetic */ EnumUserGender $gender;
    final /* synthetic */ c $zplanSpanContext;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ AbsBusinessScene this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbsBusinessScene$fetchActionWithStatistic$2(AbsBusinessScene absBusinessScene, c cVar, EnumUserGender enumUserGender, Continuation continuation) {
        super(2, continuation);
        this.this$0 = absBusinessScene;
        this.$zplanSpanContext = cVar;
        this.$gender = enumUserGender;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        AbsBusinessScene$fetchActionWithStatistic$2 absBusinessScene$fetchActionWithStatistic$2 = new AbsBusinessScene$fetchActionWithStatistic$2(this.this$0, this.$zplanSpanContext, this.$gender, completion);
        absBusinessScene$fetchActionWithStatistic$2.L$0 = obj;
        return absBusinessScene$fetchActionWithStatistic$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Pair<? extends ZPlanAction[], ? extends al0.a>> continuation) {
        return ((AbsBusinessScene$fetchActionWithStatistic$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0112  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        al0.a aVar;
        al0.a aVar2;
        b bVar;
        Object awaitAll;
        al0.a aVar3;
        int i3;
        Deferred async$default;
        Deferred async$default2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i16 = this.label;
        if (i16 != 0) {
            if (i16 == 1) {
                aVar3 = (al0.a) this.L$2;
                aVar2 = (al0.a) this.L$1;
                bVar = (b) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    aVar = aVar2;
                    awaitAll = obj;
                } catch (Throwable th5) {
                    th = th5;
                    if (bVar != null) {
                        bVar.a(th.getMessage());
                    }
                    FLog.INSTANCE.e(AbsBusinessScene.TAG, "loadAnimation exception: " + th.getMessage(), th);
                    aVar2.g(201004, th.getMessage());
                    return new Pair(null, aVar2);
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            b startSpan = ZPlanSpanFactory.INSTANCE.startSpan("fetchActionWithStatistic", this.$zplanSpanContext);
            al0.a aVar4 = new al0.a(0L, 0L, false, 0, null, 31, null);
            try {
                aVar4.l(al0.a.INSTANCE.b());
                ArrayList arrayList = new ArrayList();
                FetchActionData[] actionDataArray = this.this$0.getActionDataArray(this.$gender);
                if (actionDataArray != null) {
                    int length = actionDataArray.length;
                    int i17 = 0;
                    while (i17 < length) {
                        FetchActionData fetchActionData = actionDataArray[i17];
                        if (fetchActionData.isActionIdValid$zplan_android_release()) {
                            i3 = i17;
                            aVar = aVar4;
                            try {
                                async$default2 = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new AbsBusinessScene$fetchActionWithStatistic$2$invokeSuspend$$inlined$measure$lambda$1(fetchActionData, null, arrayList, this, coroutineScope, startSpan), 3, null);
                                arrayList.add(async$default2);
                            } catch (Throwable th6) {
                                th = th6;
                                aVar2 = aVar;
                                bVar = startSpan;
                                if (bVar != null) {
                                }
                                FLog.INSTANCE.e(AbsBusinessScene.TAG, "loadAnimation exception: " + th.getMessage(), th);
                                aVar2.g(201004, th.getMessage());
                                return new Pair(null, aVar2);
                            }
                        } else {
                            i3 = i17;
                            aVar = aVar4;
                            if (fetchActionData.isActionPathValid$zplan_android_release()) {
                                async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new AbsBusinessScene$fetchActionWithStatistic$2$invokeSuspend$$inlined$measure$lambda$2(fetchActionData, null, arrayList, this, coroutineScope, startSpan), 3, null);
                                arrayList.add(async$default);
                            }
                        }
                        i17 = i3 + 1;
                        aVar4 = aVar;
                    }
                }
                aVar = aVar4;
                this.L$0 = startSpan;
                this.L$1 = aVar;
                this.L$2 = aVar;
                this.label = 1;
                awaitAll = AwaitKt.awaitAll(arrayList, this);
                if (awaitAll == coroutine_suspended) {
                    return coroutine_suspended;
                }
                aVar3 = aVar;
                bVar = startSpan;
            } catch (Throwable th7) {
                th = th7;
                aVar = aVar4;
            }
        }
        try {
            Object[] array = ((Collection) awaitAll).toArray(new ZPlanAction[0]);
            if (array != null) {
                ZPlanAction[] zPlanActionArr = (ZPlanAction[]) array;
                aVar3.i(al0.a.INSTANCE.b());
                if (bVar != null) {
                    bVar.b();
                }
                return new Pair(zPlanActionArr, aVar);
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        } catch (Throwable th8) {
            th = th8;
            aVar2 = aVar;
            if (bVar != null) {
            }
            FLog.INSTANCE.e(AbsBusinessScene.TAG, "loadAnimation exception: " + th.getMessage(), th);
            aVar2.g(201004, th.getMessage());
            return new Pair(null, aVar2);
        }
    }
}
