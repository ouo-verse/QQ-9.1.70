package com.tencent.mobileqq.qqlive.sail.room;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.sail.error.a;
import com.tencent.qqlive.common.api.AegisLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.qqlive.sail.room.LiveAudienceRoom$start$1", f = "LiveAudienceRoom.kt", i = {}, l = {98, 100}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes17.dex */
final class LiveAudienceRoom$start$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ Function1<l<Boolean>, Unit> $callback;
    int label;
    final /* synthetic */ LiveAudienceRoom this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public LiveAudienceRoom$start$1(LiveAudienceRoom liveAudienceRoom, Function1<? super l<Boolean>, Unit> function1, Continuation<? super LiveAudienceRoom$start$1> continuation) {
        super(2, continuation);
        this.this$0 = liveAudienceRoom;
        this.$callback = function1;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, liveAudienceRoom, function1, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new LiveAudienceRoom$start$1(this.this$0, this.$callback, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        String U;
        long j3;
        b bVar;
        b bVar2;
        String U2;
        long j16;
        b bVar3;
        b bVar4;
        b bVar5;
        b bVar6;
        String str;
        String U3;
        long j17;
        b bVar7;
        String U4;
        long j18;
        l lVar;
        String U5;
        long j19;
        b bVar8;
        b bVar9;
        String U6;
        long j26;
        b bVar10;
        b bVar11;
        String U7;
        long j27;
        b bVar12;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        ResultKt.throwOnFailure(obj);
                        lVar = (l) obj;
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    lVar = (l) obj;
                }
            } else {
                ResultKt.throwOnFailure(obj);
                AegisLogger.Companion companion = AegisLogger.INSTANCE;
                U = this.this$0.U();
                j3 = this.this$0.roomId;
                companion.i(U, "start", "roomId=" + j3);
                bVar = this.this$0.roomState;
                if (bVar.c() == 30) {
                    U4 = this.this$0.U();
                    j18 = this.this$0.roomId;
                    companion.i(U4, "start", "roomId=" + j18 + ", room is starting");
                    return Unit.INSTANCE;
                }
                bVar2 = this.this$0.roomState;
                if (bVar2.c() != 40) {
                    bVar4 = this.this$0.roomState;
                    if (bVar4.c() != 60) {
                        bVar5 = this.this$0.roomState;
                        if (!bVar5.b(30)) {
                            U3 = this.this$0.U();
                            j17 = this.this$0.roomId;
                            bVar7 = this.this$0.roomState;
                            companion.w(U3, "start", "roomId=" + j17 + ", cannot change to starting state, " + bVar7);
                            this.$callback.invoke(a.Companion.c(com.tencent.mobileqq.qqlive.sail.error.a.INSTANCE, -10000003L, Boxing.boxBoolean(false), null, 4, null));
                            return Unit.INSTANCE;
                        }
                        bVar6 = this.this$0.roomState;
                        bVar6.a(30);
                        str = this.this$0.platform;
                        if (Intrinsics.areEqual("huya", str)) {
                            LiveAudienceRoom liveAudienceRoom = this.this$0;
                            this.label = 1;
                            obj = liveAudienceRoom.P(this);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            lVar = (l) obj;
                        } else {
                            LiveAudienceRoom liveAudienceRoom2 = this.this$0;
                            this.label = 2;
                            obj = liveAudienceRoom2.Q(this);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            lVar = (l) obj;
                        }
                    }
                }
                U2 = this.this$0.U();
                j16 = this.this$0.roomId;
                bVar3 = this.this$0.roomState;
                companion.i(U2, "start", "roomId=" + j16 + ", room is " + bVar3);
                this.$callback.invoke(new l<>(Boxing.boxBoolean(true), 0L, null, 0, 12, null));
                return Unit.INSTANCE;
            }
            if (lVar.b() == 0) {
                bVar9 = this.this$0.roomState;
                if (bVar9.b(40)) {
                    AegisLogger.Companion companion2 = AegisLogger.INSTANCE;
                    U7 = this.this$0.U();
                    j27 = this.this$0.roomId;
                    companion2.i(U7, "start", "roomId=" + j27 + ", start success");
                    bVar12 = this.this$0.roomState;
                    bVar12.a(40);
                    this.$callback.invoke(new l<>(Boxing.boxBoolean(true), 0L, null, 0, 12, null));
                } else {
                    AegisLogger.Companion companion3 = AegisLogger.INSTANCE;
                    U6 = this.this$0.U();
                    j26 = this.this$0.roomId;
                    bVar10 = this.this$0.roomState;
                    companion3.w(U6, "start", "roomId=" + j26 + ", cannot change to started state, " + bVar10);
                    bVar11 = this.this$0.roomState;
                    bVar11.a(0);
                    this.$callback.invoke(a.Companion.c(com.tencent.mobileqq.qqlive.sail.error.a.INSTANCE, -10000003L, Boxing.boxBoolean(false), null, 4, null));
                }
            } else {
                AegisLogger.Companion companion4 = AegisLogger.INSTANCE;
                U5 = this.this$0.U();
                j19 = this.this$0.roomId;
                companion4.e(U5, "start", "roomId=" + j19 + ", start failed, " + lVar);
                bVar8 = this.this$0.roomState;
                bVar8.a(0);
                this.$callback.invoke(new l<>(Boxing.boxBoolean(false), lVar.b(), lVar.c(), 0, 8, null));
            }
            return Unit.INSTANCE;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((LiveAudienceRoom$start$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
