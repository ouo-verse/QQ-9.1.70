package com.tencent.mobileqq.qqlive.sail.ui.room;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.common.api.AegisLogger;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.qqlive.sail.ui.room.QQLiveTrtcRoomPart$prepare$1", f = "QQLiveTrtcRoomPart.kt", i = {}, l = {181, 186}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes17.dex */
public final class QQLiveTrtcRoomPart$prepare$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    int label;
    final /* synthetic */ QQLiveTrtcRoomPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQLiveTrtcRoomPart$prepare$1(QQLiveTrtcRoomPart qQLiveTrtcRoomPart, Continuation<? super QQLiveTrtcRoomPart$prepare$1> continuation) {
        super(2, continuation);
        this.this$0 = qQLiveTrtcRoomPart;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQLiveTrtcRoomPart, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new QQLiveTrtcRoomPart$prepare$1(this.this$0, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0067  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        com.tencent.mobileqq.qqlive.sail.room.d dVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        ResultKt.throwOnFailure(obj);
                        if (((Boolean) obj).booleanValue()) {
                            this.this$0.Sa();
                            return Unit.INSTANCE;
                        }
                        dVar = this.this$0.room;
                        if (dVar == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("room");
                            dVar = null;
                        }
                        dVar.j(new Function1<com.tencent.mobileqq.qqlive.sail.room.l<Boolean>, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.room.QQLiveTrtcRoomPart$prepare$1.1
                            static IPatchRedirector $redirector_;

                            {
                                super(1);
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveTrtcRoomPart.this);
                                }
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.qqlive.sail.room.l<Boolean> lVar) {
                                invoke2(lVar);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(@NotNull com.tencent.mobileqq.qqlive.sail.room.l<Boolean> it) {
                                com.tencent.mobileqq.qqlive.sail.room.d dVar2;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                                    return;
                                }
                                Intrinsics.checkNotNullParameter(it, "it");
                                if (it.b() == 0) {
                                    QQLiveTrtcRoomPart.this.vb();
                                    QQLiveTrtcRoomPart qQLiveTrtcRoomPart = QQLiveTrtcRoomPart.this;
                                    dVar2 = qQLiveTrtcRoomPart.room;
                                    if (dVar2 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("room");
                                        dVar2 = null;
                                    }
                                    qQLiveTrtcRoomPart.qb(dVar2);
                                    return;
                                }
                                AegisLogger.INSTANCE.w("Open_Live|QQLiveTrtcRoomPart", "initTrtc", "failed, retCode=" + it.b() + ", errMsg=" + it.c());
                            }
                        });
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            } else {
                ResultKt.throwOnFailure(obj);
                QQLiveTrtcRoomPart qQLiveTrtcRoomPart = this.this$0;
                this.label = 1;
                obj = qQLiveTrtcRoomPart.fb(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            if (!((Boolean) obj).booleanValue()) {
                this.this$0.Sa();
                return Unit.INSTANCE;
            }
            QQLiveTrtcRoomPart qQLiveTrtcRoomPart2 = this.this$0;
            this.label = 2;
            obj = qQLiveTrtcRoomPart2.Ra(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            if (((Boolean) obj).booleanValue()) {
            }
        } else {
            return iPatchRedirector.redirect((short) 2, (Object) this, obj);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((QQLiveTrtcRoomPart$prepare$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
