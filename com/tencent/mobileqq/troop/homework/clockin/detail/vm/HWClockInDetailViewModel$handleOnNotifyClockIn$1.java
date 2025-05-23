package com.tencent.mobileqq.troop.homework.clockin.detail.vm;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.homework.clockin.detail.model.list.e;
import com.tencent.mobileqq.troop.homework.clockin.detail.vm.a;
import com.tencent.mobileqq.troop.homework.clockin.remind.data.RemindStatus;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.r;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolTaskData;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolTaskUnCheckInReq;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolTaskUnCheckInRsp;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolUncheckInStudent;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupSchoolTaskUnCheckInCallback;
import com.tencent.util.QQToastUtil;
import java.util.ArrayList;
import java.util.Iterator;
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
import kotlinx.coroutines.CoroutineScope;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.troop.homework.clockin.detail.vm.HWClockInDetailViewModel$handleOnNotifyClockIn$1", f = "HWClockInDetailViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes19.dex */
public final class HWClockInDetailViewModel$handleOnNotifyClockIn$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    int label;
    final /* synthetic */ HWClockInDetailViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HWClockInDetailViewModel$handleOnNotifyClockIn$1(HWClockInDetailViewModel hWClockInDetailViewModel, Continuation<? super HWClockInDetailViewModel$handleOnNotifyClockIn$1> continuation) {
        super(2, continuation);
        this.this$0 = hWClockInDetailViewModel;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) hWClockInDetailViewModel, (Object) continuation);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(HWClockInDetailViewModel hWClockInDetailViewModel, int i3, String str, GroupSchoolTaskUnCheckInRsp groupSchoolTaskUnCheckInRsp) {
        long j3;
        MutableLiveData mUiState;
        e eVar;
        GroupSchoolTaskData groupSchoolTaskData;
        String str2;
        RemindStatus remindStatus;
        MutableLiveData mUiState2;
        if (i3 != 0) {
            mUiState2 = hWClockInDetailViewModel.getMUiState();
            mUiState2.postValue(a.i.f296400a);
            String a16 = new com.tencent.mobileqq.troop.homework.clockin.a().a(i3);
            if (a16 == null) {
                a16 = "\u7f51\u7edc\u7e41\u5fd9\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5";
            }
            QQToastUtil.showQQToastInUiThread(1, a16);
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<GroupSchoolUncheckInStudent> it = groupSchoolTaskUnCheckInRsp.students.iterator();
        while (true) {
            j3 = 0;
            if (!it.hasNext()) {
                break;
            }
            GroupSchoolUncheckInStudent next = it.next();
            String valueOf = String.valueOf(next.uin);
            String str3 = next.name;
            Intrinsics.checkNotNullExpressionValue(str3, "student.name");
            long j16 = next.remindTime;
            if (j16 != 0) {
                remindStatus = RemindStatus.STATUS_HAD_REMINDED;
            } else {
                remindStatus = RemindStatus.STATUS_UNCHECKED;
            }
            arrayList.add(new com.tencent.mobileqq.troop.homework.clockin.remind.data.b(valueOf, str3, j16, remindStatus));
        }
        mUiState = hWClockInDetailViewModel.getMUiState();
        String a26 = hWClockInDetailViewModel.a2();
        eVar = hWClockInDetailViewModel.listUseCase;
        if (eVar != null) {
            j3 = eVar.a();
        }
        long j17 = j3;
        groupSchoolTaskData = hWClockInDetailViewModel.detailData;
        if (groupSchoolTaskData != null) {
            str2 = groupSchoolTaskData.taskId;
        } else {
            str2 = null;
        }
        if (str2 == null) {
            str2 = "0";
        }
        mUiState.postValue(new a.h(new com.tencent.mobileqq.troop.homework.clockin.remind.data.a(a26, j17, str2, arrayList, groupSchoolTaskUnCheckInRsp.isAllRemind, groupSchoolTaskUnCheckInRsp.isEnd, groupSchoolTaskUnCheckInRsp.total)));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new HWClockInDetailViewModel$handleOnNotifyClockIn$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Long longOrNull;
        long j3;
        GroupSchoolTaskData groupSchoolTaskData;
        String str;
        e eVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(this.this$0.a2());
                long j16 = 0;
                if (longOrNull != null) {
                    j3 = longOrNull.longValue();
                } else {
                    j3 = 0;
                }
                groupSchoolTaskData = this.this$0.detailData;
                if (groupSchoolTaskData != null) {
                    str = groupSchoolTaskData.taskId;
                } else {
                    str = null;
                }
                if (str == null) {
                    str = "0";
                }
                eVar = this.this$0.listUseCase;
                if (eVar != null) {
                    j16 = eVar.a();
                }
                GroupSchoolTaskUnCheckInReq groupSchoolTaskUnCheckInReq = new GroupSchoolTaskUnCheckInReq(j3, str, j16, 0, 50);
                r groupSchoolService = ((IKernelService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IKernelService.class, "all")).getGroupSchoolService();
                if (groupSchoolService != null) {
                    final HWClockInDetailViewModel hWClockInDetailViewModel = this.this$0;
                    groupSchoolService.getGroupSchoolTaskUnCheckInInfo(groupSchoolTaskUnCheckInReq, new IGetGroupSchoolTaskUnCheckInCallback() { // from class: com.tencent.mobileqq.troop.homework.clockin.detail.vm.c
                        @Override // com.tencent.qqnt.kernel.nativeinterface.IGetGroupSchoolTaskUnCheckInCallback
                        public final void onResult(int i3, String str2, GroupSchoolTaskUnCheckInRsp groupSchoolTaskUnCheckInRsp) {
                            HWClockInDetailViewModel$handleOnNotifyClockIn$1.b(HWClockInDetailViewModel.this, i3, str2, groupSchoolTaskUnCheckInRsp);
                        }
                    });
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((HWClockInDetailViewModel$handleOnNotifyClockIn$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
