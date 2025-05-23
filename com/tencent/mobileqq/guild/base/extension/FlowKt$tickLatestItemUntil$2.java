package com.tencent.mobileqq.guild.base.extension;

import com.tencent.mobileqq.guild.util.Logger;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@"}, d2 = {"T", "Lkotlinx/coroutines/flow/FlowCollector;", "latestValue", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.base.extension.FlowKt$tickLatestItemUntil$2", f = "Flow.kt", i = {0, 0, 1, 1, 2, 2}, l = {134, 136, 137}, m = "invokeSuspend", n = {"$this$transformLatest", "latestValue", "$this$transformLatest", "latestValue", "$this$transformLatest", "latestValue"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1"})
/* loaded from: classes12.dex */
public final class FlowKt$tickLatestItemUntil$2<T> extends SuspendLambda implements Function3<FlowCollector<? super T>, T, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $duration;
    final /* synthetic */ Function1<T, Boolean> $predict;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt$tickLatestItemUntil$2(Function1<? super T, Boolean> function1, long j3, Continuation<? super FlowKt$tickLatestItemUntil$2> continuation) {
        super(3, continuation);
        this.$predict = function1;
        this.$duration = j3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Continuation<? super Unit> continuation) {
        return invoke((FlowCollector<? super FlowCollector<? super T>>) obj, (FlowCollector<? super T>) obj2, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0070 A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x006e -> B:12:0x0047). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Object obj2;
        FlowCollector flowCollector;
        FlowKt$tickLatestItemUntil$2<T> flowKt$tickLatestItemUntil$2;
        FlowCollector flowCollector2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    obj2 = this.L$1;
                    FlowCollector flowCollector3 = (FlowCollector) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    flowKt$tickLatestItemUntil$2 = this;
                    FlowCollector flowCollector4 = flowCollector3;
                    flowKt$tickLatestItemUntil$2.L$0 = flowCollector4;
                    flowKt$tickLatestItemUntil$2.L$1 = obj2;
                    flowKt$tickLatestItemUntil$2.label = 3;
                    Object emit = flowCollector4.emit(obj2, flowKt$tickLatestItemUntil$2);
                    flowCollector2 = flowCollector4;
                    if (emit == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    if (!((Boolean) flowKt$tickLatestItemUntil$2.$predict.invoke(obj2)).booleanValue()) {
                        long j3 = flowKt$tickLatestItemUntil$2.$duration;
                        flowKt$tickLatestItemUntil$2.L$0 = flowCollector2;
                        flowKt$tickLatestItemUntil$2.L$1 = obj2;
                        flowKt$tickLatestItemUntil$2.label = 2;
                        flowCollector4 = flowCollector2;
                        if (DelayKt.delay(j3, flowKt$tickLatestItemUntil$2) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        flowKt$tickLatestItemUntil$2.L$0 = flowCollector4;
                        flowKt$tickLatestItemUntil$2.L$1 = obj2;
                        flowKt$tickLatestItemUntil$2.label = 3;
                        Object emit2 = flowCollector4.emit(obj2, flowKt$tickLatestItemUntil$2);
                        flowCollector2 = flowCollector4;
                        if (emit2 == coroutine_suspended) {
                        }
                        if (!((Boolean) flowKt$tickLatestItemUntil$2.$predict.invoke(obj2)).booleanValue()) {
                            Logger logger = Logger.f235387a;
                            Logger.b bVar = new Logger.b();
                            bVar.a().add("tickLatestItemUntil: predict true, stop");
                            Iterator<T> it = bVar.a().iterator();
                            while (it.hasNext()) {
                                Logger.f235387a.d().e("FlowEx", 1, (String) it.next(), null);
                            }
                            return Unit.INSTANCE;
                        }
                    }
                }
            }
            obj2 = this.L$1;
            FlowCollector flowCollector5 = (FlowCollector) this.L$0;
            ResultKt.throwOnFailure(obj);
            flowCollector = flowCollector5;
        } else {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector6 = (FlowCollector) this.L$0;
            obj2 = this.L$1;
            this.L$0 = flowCollector6;
            this.L$1 = obj2;
            this.label = 1;
            Object emit3 = flowCollector6.emit(obj2, this);
            flowCollector = flowCollector6;
            if (emit3 == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        flowKt$tickLatestItemUntil$2 = this;
        flowCollector2 = flowCollector;
        if (!((Boolean) flowKt$tickLatestItemUntil$2.$predict.invoke(obj2)).booleanValue()) {
        }
    }

    @Nullable
    public final Object invoke(@NotNull FlowCollector<? super T> flowCollector, T t16, @Nullable Continuation<? super Unit> continuation) {
        FlowKt$tickLatestItemUntil$2 flowKt$tickLatestItemUntil$2 = new FlowKt$tickLatestItemUntil$2(this.$predict, this.$duration, continuation);
        flowKt$tickLatestItemUntil$2.L$0 = flowCollector;
        flowKt$tickLatestItemUntil$2.L$1 = t16;
        return flowKt$tickLatestItemUntil$2.invokeSuspend(Unit.INSTANCE);
    }
}
