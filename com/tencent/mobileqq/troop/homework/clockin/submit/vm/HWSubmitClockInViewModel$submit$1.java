package com.tencent.mobileqq.troop.homework.clockin.submit.vm;

import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.homework.clockin.HWClockInDetailEvent;
import com.tencent.mobileqq.troop.homework.clockin.submit.vm.a;
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
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/clockin/submit/model/b;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.troop.homework.clockin.submit.vm.HWSubmitClockInViewModel$submit$1", f = "HWSubmitClockInViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes19.dex */
public final class HWSubmitClockInViewModel$submit$1 extends SuspendLambda implements Function2<com.tencent.mobileqq.troop.homework.clockin.submit.model.b, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ HWSubmitClockInViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HWSubmitClockInViewModel$submit$1(HWSubmitClockInViewModel hWSubmitClockInViewModel, Continuation<? super HWSubmitClockInViewModel$submit$1> continuation) {
        super(2, continuation);
        this.this$0 = hWSubmitClockInViewModel;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) hWSubmitClockInViewModel, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        HWSubmitClockInViewModel$submit$1 hWSubmitClockInViewModel$submit$1 = new HWSubmitClockInViewModel$submit$1(this.this$0, continuation);
        hWSubmitClockInViewModel$submit$1.L$0 = obj;
        return hWSubmitClockInViewModel$submit$1;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull com.tencent.mobileqq.troop.homework.clockin.submit.model.b bVar, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((HWSubmitClockInViewModel$submit$1) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) bVar, (Object) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        MutableLiveData mUiState;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                com.tencent.mobileqq.troop.homework.clockin.submit.model.b bVar = (com.tencent.mobileqq.troop.homework.clockin.submit.model.b) this.L$0;
                if (bVar.b()) {
                    QQToastUtil.showQQToastInUiThread(2, "\u63d0\u4ea4\u6210\u529f");
                    mUiState = this.this$0.getMUiState();
                    mUiState.postValue(a.C8719a.f296550a);
                    SimpleEventBus.getInstance().dispatchEvent(new HWClockInDetailEvent.SubmitClockInSuc());
                } else {
                    String a16 = new com.tencent.mobileqq.troop.homework.clockin.a().a(bVar.a());
                    if (a16 == null) {
                        a16 = "\u63d0\u4ea4\u5931\u8d25";
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
