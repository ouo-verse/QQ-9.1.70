package com.tencent.mobileqq.qqlive.sail.room;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.qqlive.sail.room.LiveAnchorTrtcRoom$destroy$1", f = "LiveAnchorTrtcRoom.kt", i = {}, l = {177}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes17.dex */
final class LiveAnchorTrtcRoom$destroy$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    int label;
    final /* synthetic */ LiveAnchorTrtcRoom this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveAnchorTrtcRoom$destroy$1(LiveAnchorTrtcRoom liveAnchorTrtcRoom, Continuation<? super LiveAnchorTrtcRoom$destroy$1> continuation) {
        super(2, continuation);
        this.this$0 = liveAnchorTrtcRoom;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) liveAnchorTrtcRoom, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new LiveAnchorTrtcRoom$destroy$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        RoomTrtcProxyImpl roomTrtcProxyImpl;
        boolean z16;
        RoomTrtcProxyImpl roomTrtcProxyImpl2;
        RoomTrtcProxyImpl roomTrtcProxyImpl3;
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
                companion.i(this.this$0.N(), "destroy");
                if (!this.this$0.M().b(80)) {
                    companion.w(this.this$0.N(), "destroy", "cannot change to destroyed state, " + this.this$0.M());
                    return Unit.INSTANCE;
                }
                this.this$0.M().a(80);
                roomTrtcProxyImpl = this.this$0.trtcProxy;
                roomTrtcProxyImpl.r();
                z16 = this.this$0.isStreamPushed;
                if (z16) {
                    LiveAnchorTrtcRoom liveAnchorTrtcRoom = this.this$0;
                    this.label = 1;
                    if (liveAnchorTrtcRoom.I(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                roomTrtcProxyImpl2 = this.this$0.trtcProxy;
                roomTrtcProxyImpl2.o();
                AegisLogger.INSTANCE.i(this.this$0.N(), "destroy", "room is destroyed");
                CoroutineScopeKt.cancel$default(this.this$0, null, 1, null);
                return Unit.INSTANCE;
            }
            roomTrtcProxyImpl3 = this.this$0.trtcProxy;
            roomTrtcProxyImpl3.e();
            roomTrtcProxyImpl2 = this.this$0.trtcProxy;
            roomTrtcProxyImpl2.o();
            AegisLogger.INSTANCE.i(this.this$0.N(), "destroy", "room is destroyed");
            CoroutineScopeKt.cancel$default(this.this$0, null, 1, null);
            return Unit.INSTANCE;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((LiveAnchorTrtcRoom$destroy$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
