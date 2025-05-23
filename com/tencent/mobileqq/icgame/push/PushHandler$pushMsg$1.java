package com.tencent.mobileqq.icgame.push;

import com.tencent.mobileqq.qqlive.data.message.LiveMsgExtInfo;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rt0.a;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.icgame.push.PushHandler$pushMsg$1", f = "PushHandler.kt", i = {}, l = {120}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes15.dex */
public final class PushHandler$pushMsg$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $delayMs;
    final /* synthetic */ bz0.c $msg;
    final /* synthetic */ LiveMsgExtInfo.MsgSpeed $speed;
    int label;
    final /* synthetic */ PushHandler this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PushHandler$pushMsg$1(long j3, bz0.c cVar, PushHandler pushHandler, LiveMsgExtInfo.MsgSpeed msgSpeed, Continuation<? super PushHandler$pushMsg$1> continuation) {
        super(2, continuation);
        this.$delayMs = j3;
        this.$msg = cVar;
        this.this$0 = pushHandler;
        this.$speed = msgSpeed;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new PushHandler$pushMsg$1(this.$delayMs, this.$msg, this.this$0, this.$speed, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Map map;
        Function2 function2;
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
            long j3 = this.$delayMs;
            this.label = 1;
            if (DelayKt.delay(j3, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        a.Companion companion = rt0.a.INSTANCE;
        if (companion.m()) {
            companion.g("ICGamePush|ICGamePushHandler", "pushMsg", "push msg, delay=" + this.$delayMs + ", " + a.a(this.$msg));
        }
        map = this.this$0.pushFlowMap;
        MutableSharedFlow mutableSharedFlow = (MutableSharedFlow) map.get(Boxing.boxInt(this.$msg.f29441b));
        if (mutableSharedFlow != null) {
            Boxing.boxBoolean(mutableSharedFlow.tryEmit(this.$msg));
        }
        function2 = this.this$0.pushCallback;
        function2.invoke(this.$msg, this.$speed);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((PushHandler$pushMsg$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
