package com.tencent.mobileqq.troop.halfscreennotification;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.troop.halfscreennotification.TroopHalfScreenNotificationHelper$onReceiveEvent$2", f = "TroopHalfScreenNotificationHelper.kt", i = {0}, l = {108, 117}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
/* loaded from: classes19.dex */
final class TroopHalfScreenNotificationHelper$onReceiveEvent$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ long $troopUin;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TroopHalfScreenNotificationHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopHalfScreenNotificationHelper$onReceiveEvent$2(long j3, TroopHalfScreenNotificationHelper troopHalfScreenNotificationHelper, Continuation<? super TroopHalfScreenNotificationHelper$onReceiveEvent$2> continuation) {
        super(2, continuation);
        this.$troopUin = j3;
        this.this$0 = troopHalfScreenNotificationHelper;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), troopHalfScreenNotificationHelper, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        TroopHalfScreenNotificationHelper$onReceiveEvent$2 troopHalfScreenNotificationHelper$onReceiveEvent$2 = new TroopHalfScreenNotificationHelper$onReceiveEvent$2(this.$troopUin, this.this$0, continuation);
        troopHalfScreenNotificationHelper$onReceiveEvent$2.L$0 = obj;
        return troopHalfScreenNotificationHelper$onReceiveEvent$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        CoroutineScope coroutineScope;
        ArrayList<String> arrayListOf;
        Object c16;
        Unit unit;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            try {
                if (i3 != 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            ResultKt.throwOnFailure(obj);
                            this.this$0.fetchJob = null;
                            return Unit.INSTANCE;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    coroutineScope = (CoroutineScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    ResultKt.throwOnFailure(obj);
                    coroutineScope = (CoroutineScope) this.L$0;
                    TroopHalfScreenNotificationRepository troopHalfScreenNotificationRepository = TroopHalfScreenNotificationRepository.f296194a;
                    long j3 = this.$troopUin;
                    arrayListOf = CollectionsKt__CollectionsKt.arrayListOf("1");
                    this.L$0 = coroutineScope;
                    this.label = 1;
                    obj = troopHalfScreenNotificationRepository.c(j3, arrayListOf, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                a aVar = (a) obj;
                if (aVar == null) {
                    QLog.i("TroopHalfScreenNotificationHelper", 1, "no data");
                    unit = Unit.INSTANCE;
                } else if (!JobKt.isActive(coroutineScope.getCoroutineContext())) {
                    QLog.w("TroopHalfScreenNotificationHelper", 1, "receive data but cancelled");
                    unit = Unit.INSTANCE;
                } else {
                    TroopHalfScreenNotificationHelper troopHalfScreenNotificationHelper = this.this$0;
                    this.L$0 = null;
                    this.label = 2;
                    c16 = troopHalfScreenNotificationHelper.c(aVar, this);
                    if (c16 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    this.this$0.fetchJob = null;
                    return Unit.INSTANCE;
                }
                return unit;
            } finally {
                this.this$0.fetchJob = null;
            }
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((TroopHalfScreenNotificationHelper$onReceiveEvent$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
