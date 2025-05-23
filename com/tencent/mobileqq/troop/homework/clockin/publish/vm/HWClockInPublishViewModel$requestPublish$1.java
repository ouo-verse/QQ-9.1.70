package com.tencent.mobileqq.troop.homework.clockin.publish.vm;

import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.homework.clockin.list.event.HWClockInListUpdateEvent;
import com.tencent.mobileqq.troop.homework.clockin.publish.vm.a;
import com.tencent.qqnt.kernel.nativeinterface.PublishGroupSchoolTaskReq;
import com.tencent.qqnt.kernel.nativeinterface.PublishGroupSchoolTaskRsp;
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

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/clockin/publish/model/b;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.troop.homework.clockin.publish.vm.HWClockInPublishViewModel$requestPublish$1", f = "HWClockInPublishViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes19.dex */
public final class HWClockInPublishViewModel$requestPublish$1 extends SuspendLambda implements Function2<com.tencent.mobileqq.troop.homework.clockin.publish.model.b, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ PublishGroupSchoolTaskReq $req;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ HWClockInPublishViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HWClockInPublishViewModel$requestPublish$1(PublishGroupSchoolTaskReq publishGroupSchoolTaskReq, HWClockInPublishViewModel hWClockInPublishViewModel, Continuation<? super HWClockInPublishViewModel$requestPublish$1> continuation) {
        super(2, continuation);
        this.$req = publishGroupSchoolTaskReq;
        this.this$0 = hWClockInPublishViewModel;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, publishGroupSchoolTaskReq, hWClockInPublishViewModel, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        HWClockInPublishViewModel$requestPublish$1 hWClockInPublishViewModel$requestPublish$1 = new HWClockInPublishViewModel$requestPublish$1(this.$req, this.this$0, continuation);
        hWClockInPublishViewModel$requestPublish$1.L$0 = obj;
        return hWClockInPublishViewModel$requestPublish$1;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull com.tencent.mobileqq.troop.homework.clockin.publish.model.b bVar, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((HWClockInPublishViewModel$requestPublish$1) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) bVar, (Object) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        String U1;
        MutableLiveData mUiState;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                com.tencent.mobileqq.troop.homework.clockin.publish.model.b bVar = (com.tencent.mobileqq.troop.homework.clockin.publish.model.b) this.L$0;
                if (bVar.c()) {
                    QQToastUtil.showQQToastInUiThread(2, "\u53d1\u5e03\u6210\u529f");
                    SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
                    PublishGroupSchoolTaskReq publishGroupSchoolTaskReq = this.$req;
                    PublishGroupSchoolTaskRsp b16 = bVar.b();
                    U1 = this.this$0.U1();
                    simpleEventBus.dispatchEvent(new HWClockInListUpdateEvent.ClockInPublished(publishGroupSchoolTaskReq, b16, U1));
                    mUiState = this.this$0.getMUiState();
                    mUiState.postValue(a.b.f296488a);
                } else {
                    String a16 = new com.tencent.mobileqq.troop.homework.clockin.a().a(bVar.a());
                    if (a16 == null) {
                        a16 = "\u53d1\u5e03\u5931\u8d25";
                    }
                    QQToastUtil.showQQToastInUiThread(1, a16);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }
}
