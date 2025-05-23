package com.tencent.mobileqq.qqlive.sail.player;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.sail.player.LiveVideoContext;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.superplayer.api.ISuperPlayer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.qqlive.sail.player.LiveVideoPlayer$switchStream$1", f = "LiveVideoPlayer.kt", i = {}, l = {152}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes17.dex */
public final class LiveVideoPlayer$switchStream$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ String $url;
    int label;
    final /* synthetic */ LiveVideoPlayer this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveVideoPlayer$switchStream$1(LiveVideoPlayer liveVideoPlayer, String str, Continuation<? super LiveVideoPlayer$switchStream$1> continuation) {
        super(2, continuation);
        this.this$0 = liveVideoPlayer;
        this.$url = str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, liveVideoPlayer, str, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new LiveVideoPlayer$switchStream$1(this.this$0, this.$url, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        boolean isBlank;
        LiveVideoContext liveVideoContext;
        LiveVideoContext liveVideoContext2;
        LiveVideoContext liveVideoContext3;
        LiveVideoContext liveVideoContext4;
        com.tencent.mobileqq.qqlive.sail.player.state.b d16;
        ISuperPlayer h16;
        long j3;
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
                AegisLogger.Companion companion = AegisLogger.INSTANCE;
                if (companion.isColorLevel()) {
                    j3 = this.this$0.roomId;
                    companion.i("QQLive_Player|LiveVideoPlayer", "switchStream", "roomId=" + j3 + ", url=" + this.$url);
                }
                isBlank = StringsKt__StringsJVMKt.isBlank(this.$url);
                if (!isBlank) {
                    liveVideoContext = this.this$0.videoContext;
                    boolean z16 = false;
                    if (liveVideoContext != null && (h16 = liveVideoContext.h()) != null && h16.isPlaying()) {
                        z16 = true;
                    }
                    if (z16) {
                        liveVideoContext2 = this.this$0.videoContext;
                        if (liveVideoContext2 != null) {
                            liveVideoContext2.A(this.$url);
                        }
                        liveVideoContext3 = this.this$0.videoContext;
                        if (liveVideoContext3 != null) {
                            liveVideoContext3.t(LiveVideoContext.PlayerOperate.SWITCH);
                        }
                        liveVideoContext4 = this.this$0.videoContext;
                        if (liveVideoContext4 != null && (d16 = liveVideoContext4.d()) != null) {
                            this.label = 1;
                            if (d16.a(this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                    } else {
                        companion.w("QQLive_Player|LiveVideoPlayer", "switchStream", "video is not playing");
                    }
                } else {
                    companion.w("QQLive_Player|LiveVideoPlayer", "switchStream", "invalid url");
                    return Unit.INSTANCE;
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
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((LiveVideoPlayer$switchStream$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
