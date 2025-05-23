package com.tencent.mobileqq.qqlive.push;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.data.message.LiveMsgExtInfo;
import com.tencent.qqlive.common.api.AegisLogger;
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
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.qqlive.push.PushHandler$pushMsg$1", f = "PushHandler.kt", i = {1}, l = {147, 154}, m = "invokeSuspend", n = {"begin"}, s = {"J$0"})
/* loaded from: classes17.dex */
public final class PushHandler$pushMsg$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ long $delayMs;
    final /* synthetic */ fp4.c $msg;
    final /* synthetic */ LiveMsgExtInfo.MsgSpeed $speed;
    long J$0;
    Object L$0;
    int label;
    final /* synthetic */ PushHandler this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PushHandler$pushMsg$1(long j3, PushHandler pushHandler, fp4.c cVar, LiveMsgExtInfo.MsgSpeed msgSpeed, Continuation<? super PushHandler$pushMsg$1> continuation) {
        super(2, continuation);
        this.$delayMs = j3;
        this.this$0 = pushHandler;
        this.$msg = cVar;
        this.$speed = msgSpeed;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), pushHandler, cVar, msgSpeed, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new PushHandler$pushMsg$1(this.$delayMs, this.this$0, this.$msg, this.$speed, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00da  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Map map;
        long j3;
        fp4.c cVar;
        Function2 function2;
        long currentTimeMillis;
        AegisLogger.Companion companion;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        j3 = this.J$0;
                        cVar = (fp4.c) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        currentTimeMillis = System.currentTimeMillis() - j3;
                        companion = AegisLogger.INSTANCE;
                        if (companion.isDevelopLevel()) {
                            companion.d("Push|PushHandler", "pushMsg", "push msg end, cost=" + currentTimeMillis + ", " + b.a(cVar));
                        }
                        if (currentTimeMillis > 2500) {
                            companion.w("Push|PushHandler", "pushMsg", "push msg cost too long, cost=" + currentTimeMillis + ", " + b.a(cVar));
                        }
                        function2 = this.this$0.pushCallback;
                        function2.invoke(this.$msg, this.$speed);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            } else {
                ResultKt.throwOnFailure(obj);
                long j16 = this.$delayMs;
                this.label = 1;
                if (DelayKt.delay(j16, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            map = this.this$0.pushFlowMap;
            MutableSharedFlow mutableSharedFlow = (MutableSharedFlow) map.get(Boxing.boxInt(this.$msg.f400284b));
            if (mutableSharedFlow != null) {
                long j17 = this.$delayMs;
                fp4.c cVar2 = this.$msg;
                AegisLogger.Companion companion2 = AegisLogger.INSTANCE;
                if (companion2.isDevelopLevel()) {
                    companion2.d("Push|PushHandler", "pushMsg", "push msg, delay=" + j17 + ", " + b.a(cVar2));
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                PushHandler$pushMsg$1$1$1 pushHandler$pushMsg$1$1$1 = new PushHandler$pushMsg$1$1$1(mutableSharedFlow, cVar2, null);
                this.L$0 = cVar2;
                this.J$0 = currentTimeMillis2;
                this.label = 2;
                if (TimeoutKt.withTimeout(5000L, pushHandler$pushMsg$1$1$1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                j3 = currentTimeMillis2;
                cVar = cVar2;
                currentTimeMillis = System.currentTimeMillis() - j3;
                companion = AegisLogger.INSTANCE;
                if (companion.isDevelopLevel()) {
                }
                if (currentTimeMillis > 2500) {
                }
            }
            function2 = this.this$0.pushCallback;
            function2.invoke(this.$msg, this.$speed);
            return Unit.INSTANCE;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((PushHandler$pushMsg$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
