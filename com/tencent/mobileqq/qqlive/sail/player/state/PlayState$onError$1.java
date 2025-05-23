package com.tencent.mobileqq.qqlive.sail.player.state;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.sail.player.LiveVideoContext;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.qqlive.sail.player.state.PlayState$onError$1", f = "PlayState.kt", i = {}, l = {117}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes17.dex */
final class PlayState$onError$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ int $errorCode;
    final /* synthetic */ int $errorType;
    final /* synthetic */ String $extraInfo;
    final /* synthetic */ int $module;
    int label;
    final /* synthetic */ PlayState this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlayState$onError$1(PlayState playState, int i3, String str, int i16, int i17, Continuation<? super PlayState$onError$1> continuation) {
        super(2, continuation);
        this.this$0 = playState;
        this.$errorCode = i3;
        this.$extraInfo = str;
        this.$errorType = i16;
        this.$module = i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, playState, Integer.valueOf(i3), str, Integer.valueOf(i16), Integer.valueOf(i17), continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new PlayState$onError$1(this.this$0, this.$errorCode, this.$extraInfo, this.$errorType, this.$module, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        LiveVideoContext liveVideoContext;
        LiveVideoContext liveVideoContext2;
        LiveVideoContext liveVideoContext3;
        LiveVideoContext liveVideoContext4;
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
                liveVideoContext = this.this$0.context;
                long j3 = this.$errorCode;
                String str = this.$extraInfo;
                if (str == null) {
                    str = "";
                }
                liveVideoContext.q(new d(j3, str, this.$errorType, this.$module));
                AegisLogger.Companion companion = AegisLogger.INSTANCE;
                liveVideoContext2 = this.this$0.context;
                long l3 = liveVideoContext2.l();
                liveVideoContext3 = this.this$0.context;
                companion.e("QQLive_Player|State|PlayState", "onError", "roomId=" + l3 + ", error=" + liveVideoContext3.e());
                liveVideoContext4 = this.this$0.context;
                this.label = 1;
                if (liveVideoContext4.a(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((PlayState$onError$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
