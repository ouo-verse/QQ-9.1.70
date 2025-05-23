package com.tencent.mobileqq.troop.homework.clockin.detail.model;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.r;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolTaskData;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolTaskDetailReq;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolTaskDetailRsp;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupSchoolTaskDetailCallback;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
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
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/channels/ProducerScope;", "Lcom/tencent/mobileqq/troop/homework/clockin/detail/model/i;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.troop.homework.clockin.detail.model.HWClockInDetailRepo$getDetail$1", f = "HWClockInDetailRepo.kt", i = {}, l = {29}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes19.dex */
public final class HWClockInDetailRepo$getDetail$1 extends SuspendLambda implements Function2<ProducerScope<? super i>, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ String $clockInId;
    final /* synthetic */ String $troopUin;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HWClockInDetailRepo$getDetail$1(String str, String str2, Continuation<? super HWClockInDetailRepo$getDetail$1> continuation) {
        super(2, continuation);
        this.$troopUin = str;
        this.$clockInId = str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, continuation);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(ProducerScope producerScope, int i3, String errMsg, GroupSchoolTaskDetailRsp groupSchoolTaskDetailRsp) {
        GroupSchoolTaskData groupSchoolTaskData;
        QLog.i("HW.ClockIn.DETAIL.HWClockInDetailRepo", 1, "getDetail result, " + i3 + "-" + errMsg + ", " + groupSchoolTaskDetailRsp);
        Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
        if (groupSchoolTaskDetailRsp != null) {
            groupSchoolTaskData = groupSchoolTaskDetailRsp.data;
        } else {
            groupSchoolTaskData = null;
        }
        producerScope.mo2003trySendJP2dKIU(new i(i3, errMsg, groupSchoolTaskData));
        SendChannel.DefaultImpls.close$default(producerScope, null, 1, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        HWClockInDetailRepo$getDetail$1 hWClockInDetailRepo$getDetail$1 = new HWClockInDetailRepo$getDetail$1(this.$troopUin, this.$clockInId, continuation);
        hWClockInDetailRepo$getDetail$1.L$0 = obj;
        return hWClockInDetailRepo$getDetail$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Long longOrNull;
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
                final ProducerScope producerScope = (ProducerScope) this.L$0;
                longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(this.$troopUin);
                if (longOrNull != null) {
                    j3 = longOrNull.longValue();
                } else {
                    j3 = 0;
                }
                GroupSchoolTaskDetailReq groupSchoolTaskDetailReq = new GroupSchoolTaskDetailReq(j3, this.$clockInId);
                QLog.i("HW.ClockIn.DETAIL.HWClockInDetailRepo", 1, "getDetail, req:" + groupSchoolTaskDetailReq);
                r g16 = bg.f302144a.g();
                if (g16 != null) {
                    g16.getGroupSchoolTaskDetail(groupSchoolTaskDetailReq, new IGetGroupSchoolTaskDetailCallback() { // from class: com.tencent.mobileqq.troop.homework.clockin.detail.model.h
                        @Override // com.tencent.qqnt.kernel.nativeinterface.IGetGroupSchoolTaskDetailCallback
                        public final void onResult(int i16, String str, GroupSchoolTaskDetailRsp groupSchoolTaskDetailRsp) {
                            HWClockInDetailRepo$getDetail$1.b(ProducerScope.this, i16, str, groupSchoolTaskDetailRsp);
                        }
                    });
                } else {
                    Boxing.boxBoolean(producerScope.cancel(new IllegalStateException("getGroupSchoolService is null!")));
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
    public final Object invoke(@NotNull ProducerScope<? super i> producerScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((HWClockInDetailRepo$getDetail$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) producerScope, (Object) continuation);
    }
}
