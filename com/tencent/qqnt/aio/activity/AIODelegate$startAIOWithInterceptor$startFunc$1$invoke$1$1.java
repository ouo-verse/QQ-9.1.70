package com.tencent.qqnt.aio.activity;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.qqnt.aio.activity.AIODelegate$startAIOWithInterceptor$startFunc$1$invoke$1$1", f = "AIODelegate.kt", i = {}, l = {459}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes23.dex */
public final class AIODelegate$startAIOWithInterceptor$startFunc$1$invoke$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ int $chatType;
    final /* synthetic */ com.tencent.qqnt.aio.interceptor.g $it;
    final /* synthetic */ String $nick;
    final /* synthetic */ String $peerId;
    final /* synthetic */ long $startTime;
    int label;
    final /* synthetic */ AIODelegate this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIODelegate$startAIOWithInterceptor$startFunc$1$invoke$1$1(AIODelegate aIODelegate, int i3, com.tencent.qqnt.aio.interceptor.g gVar, long j3, String str, String str2, Continuation<? super AIODelegate$startAIOWithInterceptor$startFunc$1$invoke$1$1> continuation) {
        super(2, continuation);
        this.this$0 = aIODelegate;
        this.$chatType = i3;
        this.$it = gVar;
        this.$startTime = j3;
        this.$peerId = str;
        this.$nick = str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, aIODelegate, Integer.valueOf(i3), gVar, Long.valueOf(j3), str, str2, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new AIODelegate$startAIOWithInterceptor$startFunc$1$invoke$1$1(this.this$0, this.$chatType, this.$it, this.$startTime, this.$peerId, this.$nick, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        com.tencent.qqnt.aio.interceptor.e I;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
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
                I = this.this$0.I();
                AIODelegate$startAIOWithInterceptor$startFunc$1$invoke$1$1$intercept$1 aIODelegate$startAIOWithInterceptor$startFunc$1$invoke$1$1$intercept$1 = new AIODelegate$startAIOWithInterceptor$startFunc$1$invoke$1$1$intercept$1(this.$it, this.this$0, this.$chatType, this.$peerId, this.$nick, null);
                this.label = 1;
                obj = BuildersKt.withContext(I, aIODelegate$startAIOWithInterceptor$startFunc$1$invoke$1$1$intercept$1, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            boolean booleanValue = ((Boolean) obj).booleanValue();
            QLog.i("AIODelegate", 1, "[doStartAIO] chatType: " + this.$chatType + " intercept: " + booleanValue + " by: " + this.$it + " costTime=" + (System.currentTimeMillis() - this.$startTime) + " ms");
            return Unit.INSTANCE;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AIODelegate$startAIOWithInterceptor$startFunc$1$invoke$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
