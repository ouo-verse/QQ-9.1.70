package com.tencent.robot.discover.part;

import com.tencent.util.LongSparseArray;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.robot.discover.part.RobotTroopObserverPart$dispatchOnAddRobotCallback$1", f = "RobotTroopObserverPart.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes25.dex */
public final class RobotTroopObserverPart$dispatchOnAddRobotCallback$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $robotUin;
    final /* synthetic */ boolean $success;
    int label;
    final /* synthetic */ RobotTroopObserverPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RobotTroopObserverPart$dispatchOnAddRobotCallback$1(boolean z16, RobotTroopObserverPart robotTroopObserverPart, long j3, Continuation<? super RobotTroopObserverPart$dispatchOnAddRobotCallback$1> continuation) {
        super(2, continuation);
        this.$success = z16;
        this.this$0 = robotTroopObserverPart;
        this.$robotUin = j3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new RobotTroopObserverPart$dispatchOnAddRobotCallback$1(this.$success, this.this$0, this.$robotUin, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        LongSparseArray longSparseArray;
        LongSparseArray longSparseArray2;
        Function0 function0;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.$success) {
                longSparseArray2 = this.this$0.mAddRobotCallbackSparseArray;
                Pair pair = (Pair) longSparseArray2.get(this.$robotUin);
                if (pair != null && (function0 = (Function0) pair.getSecond()) != null) {
                    function0.invoke();
                }
            }
            longSparseArray = this.this$0.mAddRobotCallbackSparseArray;
            longSparseArray.remove(this.$robotUin);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((RobotTroopObserverPart$dispatchOnAddRobotCallback$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
