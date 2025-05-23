package com.tencent.mobileqq.troop.homework.clockin.submit.model;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.r;
import com.tencent.qqnt.kernel.nativeinterface.CheckInGroupSchoolTaskReq;
import com.tencent.qqnt.kernel.nativeinterface.CheckInGroupSchoolTaskRsp;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolNoticeContent;
import com.tencent.qqnt.kernel.nativeinterface.ICheckInGroupSchoolTaskCallback;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/channels/ProducerScope;", "Lcom/tencent/mobileqq/troop/homework/clockin/submit/model/b;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.troop.homework.clockin.submit.model.HWSubmitClockInRepo$submit$1", f = "HWSubmitClockInRepo.kt", i = {}, l = {45}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes19.dex */
public final class HWSubmitClockInRepo$submit$1 extends SuspendLambda implements Function2<ProducerScope<? super b>, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ GroupSchoolNoticeContent $content;
    final /* synthetic */ long $date;
    final /* synthetic */ boolean $isMakeUp;
    final /* synthetic */ boolean $isModify;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ HWSubmitClockInRepo this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HWSubmitClockInRepo$submit$1(boolean z16, long j3, boolean z17, HWSubmitClockInRepo hWSubmitClockInRepo, GroupSchoolNoticeContent groupSchoolNoticeContent, Continuation<? super HWSubmitClockInRepo$submit$1> continuation) {
        super(2, continuation);
        this.$isModify = z16;
        this.$date = j3;
        this.$isMakeUp = z17;
        this.this$0 = hWSubmitClockInRepo;
        this.$content = groupSchoolNoticeContent;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), Long.valueOf(j3), Boolean.valueOf(z17), hWSubmitClockInRepo, groupSchoolNoticeContent, continuation);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(ProducerScope producerScope, int i3, String errMsg, CheckInGroupSchoolTaskRsp checkInGroupSchoolTaskRsp) {
        QLog.i("HW.ClockIn.SUBMIT.HWSubmitClockInRepo", 1, "submit, errCode:" + i3 + ", errMsg:" + errMsg + ", " + checkInGroupSchoolTaskRsp);
        Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
        producerScope.mo2003trySendJP2dKIU(new b(i3, errMsg));
        SendChannel.DefaultImpls.close$default(producerScope, null, 1, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        HWSubmitClockInRepo$submit$1 hWSubmitClockInRepo$submit$1 = new HWSubmitClockInRepo$submit$1(this.$isModify, this.$date, this.$isMakeUp, this.this$0, this.$content, continuation);
        hWSubmitClockInRepo$submit$1.L$0 = obj;
        return hWSubmitClockInRepo$submit$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        long j3;
        long j16;
        Long longOrNull;
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
                final ProducerScope producerScope = (ProducerScope) this.L$0;
                long j17 = 0;
                if (this.$isModify) {
                    j3 = this.$date;
                } else {
                    j3 = 0;
                }
                if (this.$isMakeUp) {
                    j16 = this.$date;
                } else {
                    j16 = 0;
                }
                longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(this.this$0.b());
                if (longOrNull != null) {
                    j17 = longOrNull.longValue();
                }
                CheckInGroupSchoolTaskReq checkInGroupSchoolTaskReq = new CheckInGroupSchoolTaskReq(j17, this.this$0.a(), this.$content, this.$isMakeUp, j16, j3);
                QLog.i("HW.ClockIn.SUBMIT.HWSubmitClockInRepo", 1, "submit, req:" + checkInGroupSchoolTaskReq);
                r g16 = bg.f302144a.g();
                if (g16 != null) {
                    g16.checkInGroupSchoolTask(checkInGroupSchoolTaskReq, new ICheckInGroupSchoolTaskCallback() { // from class: com.tencent.mobileqq.troop.homework.clockin.submit.model.a
                        @Override // com.tencent.qqnt.kernel.nativeinterface.ICheckInGroupSchoolTaskCallback
                        public final void onResult(int i16, String str, CheckInGroupSchoolTaskRsp checkInGroupSchoolTaskRsp) {
                            HWSubmitClockInRepo$submit$1.b(ProducerScope.this, i16, str, checkInGroupSchoolTaskRsp);
                        }
                    });
                }
                AnonymousClass3 anonymousClass3 = AnonymousClass3.INSTANCE;
                this.label = 1;
                if (ProduceKt.awaitClose(producerScope, anonymousClass3, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull ProducerScope<? super b> producerScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((HWSubmitClockInRepo$submit$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) producerScope, (Object) continuation);
    }
}
