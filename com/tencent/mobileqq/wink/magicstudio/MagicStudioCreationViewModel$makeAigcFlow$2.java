package com.tencent.mobileqq.wink.magicstudio;

import com.tencent.mobileqq.wink.editor.cu;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.aigc.bean.AIGCContentOutput;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\b\u001a\u00020\u0007* \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00030\u00010\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\u008a@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/Pair;", "Lorg/light/aigc/bean/AIGCContentOutput;", "", "", "", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.magicstudio.MagicStudioCreationViewModel$makeAigcFlow$2", f = "MagicStudioCreationViewModel.kt", i = {}, l = {922}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class MagicStudioCreationViewModel$makeAigcFlow$2 extends SuspendLambda implements Function3<FlowCollector<? super Pair<? extends AIGCContentOutput, ? extends Map<String, ? extends String>>>, Throwable, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $allCount;
    final /* synthetic */ AtomicInteger $failCount;
    final /* synthetic */ AtomicInteger $successCount;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ MagicStudioCreationViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MagicStudioCreationViewModel$makeAigcFlow$2(AtomicInteger atomicInteger, int i3, AtomicInteger atomicInteger2, MagicStudioCreationViewModel magicStudioCreationViewModel, Continuation<? super MagicStudioCreationViewModel$makeAigcFlow$2> continuation) {
        super(3, continuation);
        this.$failCount = atomicInteger;
        this.$allCount = i3;
        this.$successCount = atomicInteger2;
        this.this$0 = magicStudioCreationViewModel;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Pair<? extends AIGCContentOutput, ? extends Map<String, ? extends String>>> flowCollector, Throwable th5, Continuation<? super Unit> continuation) {
        return invoke2((FlowCollector<? super Pair<? extends AIGCContentOutput, ? extends Map<String, String>>>) flowCollector, th5, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Map emptyMap;
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
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            Throwable th5 = (Throwable) this.L$1;
            w53.b.h("MagicStudioCreationViewModel", "aigcContent catch = " + this.$failCount.incrementAndGet() + " ", th5);
            if (this.$failCount.get() < this.$allCount && this.$successCount.get() != 0) {
                AIGCContentOutput aIGCContentOutput = new AIGCContentOutput();
                emptyMap = MapsKt__MapsKt.emptyMap();
                Pair pair = new Pair(aIGCContentOutput, emptyMap);
                this.L$0 = null;
                this.label = 1;
                if (flowCollector.emit(pair, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                w53.b.f("MagicStudioCreationViewModel", "firstAigcFlow emit all error");
                cu.w(this.$allCount, this.this$0.getReportSessionID(), -1);
                throw th5;
            }
        }
        return Unit.INSTANCE;
    }

    @Nullable
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull FlowCollector<? super Pair<? extends AIGCContentOutput, ? extends Map<String, String>>> flowCollector, @NotNull Throwable th5, @Nullable Continuation<? super Unit> continuation) {
        MagicStudioCreationViewModel$makeAigcFlow$2 magicStudioCreationViewModel$makeAigcFlow$2 = new MagicStudioCreationViewModel$makeAigcFlow$2(this.$failCount, this.$allCount, this.$successCount, this.this$0, continuation);
        magicStudioCreationViewModel$makeAigcFlow$2.L$0 = flowCollector;
        magicStudioCreationViewModel$makeAigcFlow$2.L$1 = th5;
        return magicStudioCreationViewModel$makeAigcFlow$2.invokeSuspend(Unit.INSTANCE);
    }
}
