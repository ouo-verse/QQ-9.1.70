package com.tencent.kuikly.core.timer;

import com.tencent.kuikly.core.coroutines.BuildersKt;
import com.tencent.kuikly.core.coroutines.b;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lcom/tencent/kuikly/core/coroutines/b;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.kuikly.core.timer.Timer$start$1", f = "Timer.kt", i = {0, 1}, l = {38, 42}, m = "invokeSuspend", n = {"$this$launch", "$this$launch"}, s = {"L$0", "L$0"})
/* loaded from: classes33.dex */
public final class Timer$start$1 extends SuspendLambda implements Function2<b, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ Timer this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Timer$start$1(Timer timer, Continuation<? super Timer$start$1> continuation) {
        super(2, continuation);
        this.this$0 = timer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Timer$start$1 timer$start$1 = new Timer$start$1(this.this$0, continuation);
        timer$start$1.L$0 = obj;
        return timer$start$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(b bVar, Continuation<? super Unit> continuation) {
        return ((Timer$start$1) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Incorrect condition in loop: B:11:0x0047 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        b bVar;
        int i3;
        int i16;
        boolean z16;
        Function0 function0;
        int i17;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i18 = this.label;
        if (i18 == 0) {
            ResultKt.throwOnFailure(obj);
            bVar = (b) this.L$0;
            i3 = this.this$0.delay;
            if (i3 > 0) {
                i16 = this.this$0.delay;
                this.L$0 = bVar;
                this.label = 1;
                if (BuildersKt.c(bVar, i16, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i18 == 1 || i18 == 2) {
            bVar = (b) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        while (z16) {
            function0 = this.this$0.action;
            if (function0 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("action");
                function0 = null;
            }
            function0.invoke();
            i17 = this.this$0.period;
            this.L$0 = bVar;
            this.label = 2;
            if (BuildersKt.c(bVar, i17, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
