package com.tencent.mobileqq.troop.homework.clockin.detail.model.list;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolTaskStatisticsRsp;
import com.tencent.util.QQToastUtil;
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
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/common/a;", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupSchoolTaskStatisticsRsp;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.troop.homework.clockin.detail.model.list.HWClockInDetailListTeacherUseCase$loadMore$1", f = "HWClockInDetailListTeacherUseCase.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes19.dex */
final class HWClockInDetailListTeacherUseCase$loadMore$1 extends SuspendLambda implements Function2<com.tencent.mobileqq.troop.homework.common.a<GroupSchoolTaskStatisticsRsp>, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ HWClockInDetailListTeacherUseCase this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HWClockInDetailListTeacherUseCase$loadMore$1(HWClockInDetailListTeacherUseCase hWClockInDetailListTeacherUseCase, Continuation<? super HWClockInDetailListTeacherUseCase$loadMore$1> continuation) {
        super(2, continuation);
        this.this$0 = hWClockInDetailListTeacherUseCase;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) hWClockInDetailListTeacherUseCase, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        HWClockInDetailListTeacherUseCase$loadMore$1 hWClockInDetailListTeacherUseCase$loadMore$1 = new HWClockInDetailListTeacherUseCase$loadMore$1(this.this$0, continuation);
        hWClockInDetailListTeacherUseCase$loadMore$1.L$0 = obj;
        return hWClockInDetailListTeacherUseCase$loadMore$1;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull com.tencent.mobileqq.troop.homework.common.a<GroupSchoolTaskStatisticsRsp> aVar, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((HWClockInDetailListTeacherUseCase$loadMore$1) create(aVar, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar, (Object) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        HWClockInDetailListTeacherRepo hWClockInDetailListTeacherRepo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                com.tencent.mobileqq.troop.homework.common.a aVar = (com.tencent.mobileqq.troop.homework.common.a) this.L$0;
                if (aVar.c()) {
                    HWClockInDetailListTeacherUseCase hWClockInDetailListTeacherUseCase = this.this$0;
                    hWClockInDetailListTeacherRepo = hWClockInDetailListTeacherUseCase.repo;
                    hWClockInDetailListTeacherUseCase.i(hWClockInDetailListTeacherRepo.g(), (GroupSchoolTaskStatisticsRsp) aVar.b(), true);
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
