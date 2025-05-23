package com.tencent.mobileqq.qqlive.push;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.data.message.LiveMsgExtInfo;
import com.tencent.qqlive.common.api.AegisLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.Channel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.qqlive.push.PushHandler$setupPushHuYaJob$1", f = "PushHandler.kt", i = {0}, l = {129}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
/* loaded from: classes17.dex */
public final class PushHandler$setupPushHuYaJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PushHandler this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PushHandler$setupPushHuYaJob$1(PushHandler pushHandler, Continuation<? super PushHandler$setupPushHuYaJob$1> continuation) {
        super(2, continuation);
        this.this$0 = pushHandler;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) pushHandler, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        PushHandler$setupPushHuYaJob$1 pushHandler$setupPushHuYaJob$1 = new PushHandler$setupPushHuYaJob$1(this.this$0, continuation);
        pushHandler$setupPushHuYaJob$1.L$0 = obj;
        return pushHandler$setupPushHuYaJob$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x009b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x005a -> B:12:0x005f). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Channel channel;
        CoroutineScope coroutineScope;
        PushHandler$setupPushHuYaJob$1 pushHandler$setupPushHuYaJob$1;
        Channel channel2;
        Job h16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 != 0) {
                if (i3 == 1) {
                    CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    CoroutineScope coroutineScope3 = coroutineScope2;
                    Object obj2 = coroutine_suspended;
                    PushHandler$setupPushHuYaJob$1 pushHandler$setupPushHuYaJob$12 = this;
                    PushHandler pushHandler = pushHandler$setupPushHuYaJob$12.this$0;
                    fp4.c cVar = (fp4.c) obj;
                    AegisLogger.Companion companion = AegisLogger.INSTANCE;
                    if (companion.isDevelopLevel()) {
                        companion.d("Push|PushHandler", "setupPushHuYaJob", "receive msg, " + b.a(cVar));
                    }
                    h16 = pushHandler.h(cVar, 0L, LiveMsgExtInfo.MsgSpeed.CONST);
                    h16.invokeOnCompletion(PushHandler$setupPushHuYaJob$1$2$1.INSTANCE);
                    pushHandler$setupPushHuYaJob$1 = pushHandler$setupPushHuYaJob$12;
                    coroutine_suspended = obj2;
                    coroutineScope = coroutineScope3;
                    if (CoroutineScopeKt.isActive(coroutineScope)) {
                        channel2 = pushHandler$setupPushHuYaJob$1.this$0.huYaChannel;
                        pushHandler$setupPushHuYaJob$1.L$0 = coroutineScope;
                        pushHandler$setupPushHuYaJob$1.label = 1;
                        Object receive = channel2.receive(pushHandler$setupPushHuYaJob$1);
                        if (receive == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        Object obj3 = coroutine_suspended;
                        pushHandler$setupPushHuYaJob$12 = pushHandler$setupPushHuYaJob$1;
                        obj = receive;
                        coroutineScope3 = coroutineScope;
                        obj2 = obj3;
                        PushHandler pushHandler2 = pushHandler$setupPushHuYaJob$12.this$0;
                        fp4.c cVar2 = (fp4.c) obj;
                        AegisLogger.Companion companion2 = AegisLogger.INSTANCE;
                        if (companion2.isDevelopLevel()) {
                        }
                        h16 = pushHandler2.h(cVar2, 0L, LiveMsgExtInfo.MsgSpeed.CONST);
                        h16.invokeOnCompletion(PushHandler$setupPushHuYaJob$1$2$1.INSTANCE);
                        pushHandler$setupPushHuYaJob$1 = pushHandler$setupPushHuYaJob$12;
                        coroutine_suspended = obj2;
                        coroutineScope = coroutineScope3;
                        if (CoroutineScopeKt.isActive(coroutineScope)) {
                            return Unit.INSTANCE;
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope4 = (CoroutineScope) this.L$0;
                channel = this.this$0.huYaChannel;
                if (channel == null) {
                    return Unit.INSTANCE;
                }
                coroutineScope = coroutineScope4;
                pushHandler$setupPushHuYaJob$1 = this;
                if (CoroutineScopeKt.isActive(coroutineScope)) {
                }
            }
        } else {
            return iPatchRedirector.redirect((short) 2, (Object) this, obj);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((PushHandler$setupPushHuYaJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
