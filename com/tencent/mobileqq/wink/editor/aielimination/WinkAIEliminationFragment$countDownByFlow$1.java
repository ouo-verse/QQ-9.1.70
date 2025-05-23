package com.tencent.mobileqq.wink.editor.aielimination;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.editor.aielimination.WinkAIEliminationFragment$countDownByFlow$1", f = "WinkAIEliminationFragment.kt", i = {0, 0, 1, 1}, l = {1062, 1063}, m = "invokeSuspend", n = {"$this$flow", WidgetCacheConstellationData.NUM, "$this$flow", WidgetCacheConstellationData.NUM}, s = {"L$0", "I$0", "L$0", "I$0"})
/* loaded from: classes21.dex */
public final class WinkAIEliminationFragment$countDownByFlow$1 extends SuspendLambda implements Function2<FlowCollector<? super Integer>, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $max;
    int I$0;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkAIEliminationFragment$countDownByFlow$1(int i3, Continuation<? super WinkAIEliminationFragment$countDownByFlow$1> continuation) {
        super(2, continuation);
        this.$max = i3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        WinkAIEliminationFragment$countDownByFlow$1 winkAIEliminationFragment$countDownByFlow$1 = new WinkAIEliminationFragment$countDownByFlow$1(this.$max, continuation);
        winkAIEliminationFragment$countDownByFlow$1.L$0 = obj;
        return winkAIEliminationFragment$countDownByFlow$1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x005e, code lost:
    
        if (r1 != 0) goto L16;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x003c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x005b -> B:6:0x005e). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        FlowCollector flowCollector;
        int i3;
        WinkAIEliminationFragment$countDownByFlow$1 winkAIEliminationFragment$countDownByFlow$1;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i16 = this.label;
        if (i16 != 0) {
            if (i16 != 1) {
                if (i16 == 2) {
                    i3 = this.I$0;
                    FlowCollector flowCollector2 = (FlowCollector) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    flowCollector = flowCollector2;
                    winkAIEliminationFragment$countDownByFlow$1 = this;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                i3 = this.I$0;
                FlowCollector flowCollector3 = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure(obj);
                flowCollector = flowCollector3;
                winkAIEliminationFragment$countDownByFlow$1 = this;
            }
            i3--;
            if (-1 < i3) {
                Integer boxInt = Boxing.boxInt(i3);
                winkAIEliminationFragment$countDownByFlow$1.L$0 = flowCollector;
                winkAIEliminationFragment$countDownByFlow$1.I$0 = i3;
                winkAIEliminationFragment$countDownByFlow$1.label = 1;
                if (flowCollector.emit(boxInt, winkAIEliminationFragment$countDownByFlow$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                if (i3 != 0) {
                    winkAIEliminationFragment$countDownByFlow$1.L$0 = flowCollector;
                    winkAIEliminationFragment$countDownByFlow$1.I$0 = i3;
                    winkAIEliminationFragment$countDownByFlow$1.label = 2;
                    if (DelayKt.delay(100L, winkAIEliminationFragment$countDownByFlow$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                i3--;
                if (-1 < i3) {
                    return Unit.INSTANCE;
                }
            }
        } else {
            ResultKt.throwOnFailure(obj);
            flowCollector = (FlowCollector) this.L$0;
            i3 = this.$max;
            winkAIEliminationFragment$countDownByFlow$1 = this;
            if (-1 < i3) {
            }
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull FlowCollector<? super Integer> flowCollector, @Nullable Continuation<? super Unit> continuation) {
        return ((WinkAIEliminationFragment$countDownByFlow$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
