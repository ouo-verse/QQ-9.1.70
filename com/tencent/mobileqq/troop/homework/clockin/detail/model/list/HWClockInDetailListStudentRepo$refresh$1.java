package com.tencent.mobileqq.troop.homework.clockin.detail.model.list;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.r;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolTaskCheckInInfoReq;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolTaskCheckInInfoRsp;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupSchoolTaskCheckInInfoCallback;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/channels/ProducerScope;", "Lcom/tencent/mobileqq/troop/homework/common/a;", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupSchoolTaskCheckInInfoRsp;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.troop.homework.clockin.detail.model.list.HWClockInDetailListStudentRepo$refresh$1", f = "HWClockInDetailListStudentRepo.kt", i = {}, l = {35}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes19.dex */
public final class HWClockInDetailListStudentRepo$refresh$1 extends SuspendLambda implements Function2<ProducerScope<? super com.tencent.mobileqq.troop.homework.common.a<GroupSchoolTaskCheckInInfoRsp>>, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ long $date;
    final /* synthetic */ boolean $needState;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ HWClockInDetailListStudentRepo this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HWClockInDetailListStudentRepo$refresh$1(HWClockInDetailListStudentRepo hWClockInDetailListStudentRepo, long j3, boolean z16, Continuation<? super HWClockInDetailListStudentRepo$refresh$1> continuation) {
        super(2, continuation);
        this.this$0 = hWClockInDetailListStudentRepo;
        this.$date = j3;
        this.$needState = z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, hWClockInDetailListStudentRepo, Long.valueOf(j3), Boolean.valueOf(z16), continuation);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(ProducerScope producerScope, int i3, String errMsg, GroupSchoolTaskCheckInInfoRsp groupSchoolTaskCheckInInfoRsp) {
        QLog.i("HW.ClockIn.DETAIL.HWClockInDetailListTeacherRepo", 1, "refresh, errCode:" + i3 + ", errMsg:" + i3 + ", " + groupSchoolTaskCheckInInfoRsp);
        Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
        producerScope.mo2003trySendJP2dKIU(new com.tencent.mobileqq.troop.homework.common.a(i3, errMsg, groupSchoolTaskCheckInInfoRsp));
        SendChannel.DefaultImpls.close$default(producerScope, null, 1, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        HWClockInDetailListStudentRepo$refresh$1 hWClockInDetailListStudentRepo$refresh$1 = new HWClockInDetailListStudentRepo$refresh$1(this.this$0, this.$date, this.$needState, continuation);
        hWClockInDetailListStudentRepo$refresh$1.L$0 = obj;
        return hWClockInDetailListStudentRepo$refresh$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
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
                GroupSchoolTaskCheckInInfoReq groupSchoolTaskCheckInInfoReq = new GroupSchoolTaskCheckInInfoReq(this.this$0.b(), this.this$0.a(), this.$date, this.$needState);
                QLog.i("HW.ClockIn.DETAIL.HWClockInDetailListTeacherRepo", 1, "refresh, req:" + groupSchoolTaskCheckInInfoReq);
                r g16 = bg.f302144a.g();
                if (g16 != null) {
                    g16.getGroupSchoolTaskCheckInInfo(groupSchoolTaskCheckInInfoReq, new IGetGroupSchoolTaskCheckInInfoCallback() { // from class: com.tencent.mobileqq.troop.homework.clockin.detail.model.list.a
                        @Override // com.tencent.qqnt.kernel.nativeinterface.IGetGroupSchoolTaskCheckInInfoCallback
                        public final void onResult(int i16, String str, GroupSchoolTaskCheckInInfoRsp groupSchoolTaskCheckInInfoRsp) {
                            HWClockInDetailListStudentRepo$refresh$1.b(ProducerScope.this, i16, str, groupSchoolTaskCheckInInfoRsp);
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
    public final Object invoke(@NotNull ProducerScope<? super com.tencent.mobileqq.troop.homework.common.a<GroupSchoolTaskCheckInInfoRsp>> producerScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((HWClockInDetailListStudentRepo$refresh$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) producerScope, (Object) continuation);
    }
}
