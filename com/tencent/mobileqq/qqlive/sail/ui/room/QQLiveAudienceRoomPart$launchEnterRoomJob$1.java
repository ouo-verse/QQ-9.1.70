package com.tencent.mobileqq.qqlive.sail.ui.room;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.sail.model.ReportExtKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.qqlive.sail.ui.room.QQLiveAudienceRoomPart$launchEnterRoomJob$1", f = "QQLiveAudienceRoomPart.kt", i = {}, l = {137}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes17.dex */
public final class QQLiveAudienceRoomPart$launchEnterRoomJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    int label;
    final /* synthetic */ QQLiveAudienceRoomPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQLiveAudienceRoomPart$launchEnterRoomJob$1(QQLiveAudienceRoomPart qQLiveAudienceRoomPart, Continuation<? super QQLiveAudienceRoomPart$launchEnterRoomJob$1> continuation) {
        super(2, continuation);
        this.this$0 = qQLiveAudienceRoomPart;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQLiveAudienceRoomPart, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new QQLiveAudienceRoomPart$launchEnterRoomJob$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        long j3;
        com.tencent.mobileqq.qqlive.sail.room.e qa5;
        com.tencent.mobileqq.qqlive.sail.room.e qa6;
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
                j3 = QQLiveAudienceRoomPart.G;
                this.label = 1;
                if (DelayKt.delay(j3, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            qa5 = this.this$0.qa();
            if (qa5 != null) {
                ReportExtKt.b(qa5, "begin enter video room", null, null, null, 14, null);
            }
            long currentTimeMillis = System.currentTimeMillis();
            qa6 = this.this$0.qa();
            if (qa6 != null) {
                qa6.v(new Function1<com.tencent.mobileqq.qqlive.sail.room.l<Boolean>, Unit>(currentTimeMillis, this.this$0) { // from class: com.tencent.mobileqq.qqlive.sail.ui.room.QQLiveAudienceRoomPart$launchEnterRoomJob$1.1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ long $startTime;
                    final /* synthetic */ QQLiveAudienceRoomPart this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                        this.$startTime = currentTimeMillis;
                        this.this$0 = r7;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, Long.valueOf(currentTimeMillis), r7);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.qqlive.sail.room.l<Boolean> lVar) {
                        invoke2(lVar);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull com.tencent.mobileqq.qqlive.sail.room.l<Boolean> result) {
                        com.tencent.mobileqq.qqlive.sail.room.e qa7;
                        com.tencent.mobileqq.qqlive.sail.room.e qa8;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) result);
                            return;
                        }
                        Intrinsics.checkNotNullParameter(result, "result");
                        long currentTimeMillis2 = System.currentTimeMillis() - this.$startTime;
                        if (Intrinsics.areEqual(result.d(), Boolean.TRUE)) {
                            qa8 = this.this$0.qa();
                            if (qa8 != null) {
                                ReportExtKt.b(qa8, "success", Long.valueOf(currentTimeMillis2), null, null, 12, null);
                            }
                            this.this$0.va();
                            return;
                        }
                        this.this$0.ua(result.b(), result.c());
                        qa7 = this.this$0.qa();
                        if (qa7 != null) {
                            ReportExtKt.a(qa7, "fail", Long.valueOf(currentTimeMillis2), Long.valueOf(result.b()), result.c());
                        }
                    }
                });
            }
            return Unit.INSTANCE;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((QQLiveAudienceRoomPart$launchEnterRoomJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
