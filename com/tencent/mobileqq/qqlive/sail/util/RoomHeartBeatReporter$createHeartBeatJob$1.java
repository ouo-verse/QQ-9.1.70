package com.tencent.mobileqq.qqlive.sail.util;

import android.os.SystemClock;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.sail.model.d;
import com.tencent.qqlive.common.api.AegisLogger;
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
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.qqlive.sail.util.RoomHeartBeatReporter$createHeartBeatJob$1", f = "RoomHeartBeatReporter.kt", i = {0}, l = {88}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
/* loaded from: classes17.dex */
public final class RoomHeartBeatReporter$createHeartBeatJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ RoomHeartBeatReporter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomHeartBeatReporter$createHeartBeatJob$1(RoomHeartBeatReporter roomHeartBeatReporter, Continuation<? super RoomHeartBeatReporter$createHeartBeatJob$1> continuation) {
        super(2, continuation);
        this.this$0 = roomHeartBeatReporter;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) roomHeartBeatReporter, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        RoomHeartBeatReporter$createHeartBeatJob$1 roomHeartBeatReporter$createHeartBeatJob$1 = new RoomHeartBeatReporter$createHeartBeatJob$1(this.this$0, continuation);
        roomHeartBeatReporter$createHeartBeatJob$1.L$0 = obj;
        return roomHeartBeatReporter$createHeartBeatJob$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        CoroutineScope coroutineScope;
        String i3;
        d h16;
        Long l3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i16 = this.label;
            if (i16 != 0) {
                if (i16 == 1) {
                    coroutineScope = (CoroutineScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
                this.this$0.lastHeartBeatTime = SystemClock.elapsedRealtime();
                coroutineScope = coroutineScope2;
            }
            while (CoroutineScopeKt.isActive(coroutineScope)) {
                if (this.this$0.j()) {
                    this.this$0.l();
                } else {
                    AegisLogger.Companion companion = AegisLogger.INSTANCE;
                    i3 = this.this$0.i();
                    h16 = this.this$0.h();
                    if (h16 != null) {
                        l3 = Boxing.boxLong(h16.getRoomId());
                    } else {
                        l3 = null;
                    }
                    companion.i(i3, "createHeartBeatJob", "roomId=" + l3 + ", room is not entered");
                    CoroutineScopeKt.cancel$default(coroutineScope, null, 1, null);
                }
                this.L$0 = coroutineScope;
                this.label = 1;
                if (DelayKt.delay(5000L, this) == coroutine_suspended) {
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
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((RoomHeartBeatReporter$createHeartBeatJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
