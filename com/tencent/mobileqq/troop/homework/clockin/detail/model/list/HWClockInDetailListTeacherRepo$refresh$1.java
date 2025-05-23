package com.tencent.mobileqq.troop.homework.clockin.detail.model.list;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.r;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolTaskStatisticsReq;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolTaskStatisticsRsp;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupSchoolTaskStatisticsCallback;
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
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/channels/ProducerScope;", "Lcom/tencent/mobileqq/troop/homework/common/a;", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupSchoolTaskStatisticsRsp;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.troop.homework.clockin.detail.model.list.HWClockInDetailListTeacherRepo$refresh$1", f = "HWClockInDetailListTeacherRepo.kt", i = {}, l = {45}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes19.dex */
public final class HWClockInDetailListTeacherRepo$refresh$1 extends SuspendLambda implements Function2<ProducerScope<? super com.tencent.mobileqq.troop.homework.common.a<GroupSchoolTaskStatisticsRsp>>, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ long $date;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ HWClockInDetailListTeacherRepo this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HWClockInDetailListTeacherRepo$refresh$1(HWClockInDetailListTeacherRepo hWClockInDetailListTeacherRepo, long j3, Continuation<? super HWClockInDetailListTeacherRepo$refresh$1> continuation) {
        super(2, continuation);
        this.this$0 = hWClockInDetailListTeacherRepo;
        this.$date = j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, hWClockInDetailListTeacherRepo, Long.valueOf(j3), continuation);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(HWClockInDetailListTeacherRepo hWClockInDetailListTeacherRepo, ProducerScope producerScope, int i3, String errMsg, GroupSchoolTaskStatisticsRsp groupSchoolTaskStatisticsRsp) {
        QLog.i("HW.ClockIn.DETAIL.HWClockInDetailListTeacherRepo", 1, "refresh, errCode:" + i3 + ", errMsg:" + i3 + ", " + groupSchoolTaskStatisticsRsp);
        hWClockInDetailListTeacherRepo.isEnd = groupSchoolTaskStatisticsRsp.isEnd;
        Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
        producerScope.mo2003trySendJP2dKIU(new com.tencent.mobileqq.troop.homework.common.a(i3, errMsg, groupSchoolTaskStatisticsRsp));
        SendChannel.DefaultImpls.close$default(producerScope, null, 1, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        HWClockInDetailListTeacherRepo$refresh$1 hWClockInDetailListTeacherRepo$refresh$1 = new HWClockInDetailListTeacherRepo$refresh$1(this.this$0, this.$date, continuation);
        hWClockInDetailListTeacherRepo$refresh$1.L$0 = obj;
        return hWClockInDetailListTeacherRepo$refresh$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i17 = this.label;
            if (i17 != 0) {
                if (i17 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                final ProducerScope producerScope = (ProducerScope) this.L$0;
                this.this$0.curPage = 1;
                this.this$0.curDate = this.$date;
                long i18 = this.this$0.i();
                String h16 = this.this$0.h();
                long j3 = this.$date;
                i3 = this.this$0.curPage;
                i16 = this.this$0.pageSize;
                GroupSchoolTaskStatisticsReq groupSchoolTaskStatisticsReq = new GroupSchoolTaskStatisticsReq(i18, h16, j3, i3, i16);
                QLog.i("HW.ClockIn.DETAIL.HWClockInDetailListTeacherRepo", 1, "refresh, req:" + groupSchoolTaskStatisticsReq);
                r g16 = bg.f302144a.g();
                if (g16 != null) {
                    final HWClockInDetailListTeacherRepo hWClockInDetailListTeacherRepo = this.this$0;
                    g16.getGroupSchoolTaskStatistics(groupSchoolTaskStatisticsReq, new IGetGroupSchoolTaskStatisticsCallback() { // from class: com.tencent.mobileqq.troop.homework.clockin.detail.model.list.c
                        @Override // com.tencent.qqnt.kernel.nativeinterface.IGetGroupSchoolTaskStatisticsCallback
                        public final void onResult(int i19, String str, GroupSchoolTaskStatisticsRsp groupSchoolTaskStatisticsRsp) {
                            HWClockInDetailListTeacherRepo$refresh$1.b(HWClockInDetailListTeacherRepo.this, producerScope, i19, str, groupSchoolTaskStatisticsRsp);
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
    public final Object invoke(@NotNull ProducerScope<? super com.tencent.mobileqq.troop.homework.common.a<GroupSchoolTaskStatisticsRsp>> producerScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((HWClockInDetailListTeacherRepo$refresh$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) producerScope, (Object) continuation);
    }
}
