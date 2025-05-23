package com.tencent.mobileqq.troop.homework.clockin.detail.model.list;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolTaskCheckInInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolTaskCheckInInfoRsp;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolTaskCheckInStatusInfo;
import com.tencent.util.QQToastUtil;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/common/a;", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupSchoolTaskCheckInInfoRsp;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.troop.homework.clockin.detail.model.list.HWClockInDetailListStudentUseCase$switchDate$1", f = "HWClockInDetailListStudentUseCase.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes19.dex */
final class HWClockInDetailListStudentUseCase$switchDate$1 extends SuspendLambda implements Function2<com.tencent.mobileqq.troop.homework.common.a<GroupSchoolTaskCheckInInfoRsp>, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ HWClockInDetailListStudentUseCase this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HWClockInDetailListStudentUseCase$switchDate$1(HWClockInDetailListStudentUseCase hWClockInDetailListStudentUseCase, Continuation<? super HWClockInDetailListStudentUseCase$switchDate$1> continuation) {
        super(2, continuation);
        this.this$0 = hWClockInDetailListStudentUseCase;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) hWClockInDetailListStudentUseCase, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        HWClockInDetailListStudentUseCase$switchDate$1 hWClockInDetailListStudentUseCase$switchDate$1 = new HWClockInDetailListStudentUseCase$switchDate$1(this.this$0, continuation);
        hWClockInDetailListStudentUseCase$switchDate$1.L$0 = obj;
        return hWClockInDetailListStudentUseCase$switchDate$1;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull com.tencent.mobileqq.troop.homework.common.a<GroupSchoolTaskCheckInInfoRsp> aVar, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((HWClockInDetailListStudentUseCase$switchDate$1) create(aVar, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar, (Object) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        ArrayList<GroupSchoolTaskCheckInStatusInfo> arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                com.tencent.mobileqq.troop.homework.common.a aVar = (com.tencent.mobileqq.troop.homework.common.a) this.L$0;
                if (aVar.c()) {
                    HWClockInDetailListStudentUseCase hWClockInDetailListStudentUseCase = this.this$0;
                    GroupSchoolTaskCheckInInfoRsp groupSchoolTaskCheckInInfoRsp = (GroupSchoolTaskCheckInInfoRsp) aVar.b();
                    GroupSchoolTaskCheckInInfo groupSchoolTaskCheckInInfo = null;
                    if (groupSchoolTaskCheckInInfoRsp != null) {
                        arrayList = groupSchoolTaskCheckInInfoRsp.states;
                    } else {
                        arrayList = null;
                    }
                    hWClockInDetailListStudentUseCase.h(arrayList);
                    HWClockInDetailListStudentUseCase hWClockInDetailListStudentUseCase2 = this.this$0;
                    GroupSchoolTaskCheckInInfoRsp groupSchoolTaskCheckInInfoRsp2 = (GroupSchoolTaskCheckInInfoRsp) aVar.b();
                    if (groupSchoolTaskCheckInInfoRsp2 != null) {
                        groupSchoolTaskCheckInInfo = groupSchoolTaskCheckInInfoRsp2.records;
                    }
                    hWClockInDetailListStudentUseCase2.f(groupSchoolTaskCheckInInfo);
                    return Unit.INSTANCE;
                }
                String a16 = new com.tencent.mobileqq.troop.homework.clockin.a().a(aVar.a());
                if (a16 == null) {
                    a16 = "\u7f51\u7edc\u7e41\u5fd9\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5";
                }
                QQToastUtil.showQQToastInUiThread(1, a16);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }
}
