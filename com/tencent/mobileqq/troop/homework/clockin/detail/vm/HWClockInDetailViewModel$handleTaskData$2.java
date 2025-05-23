package com.tencent.mobileqq.troop.homework.clockin.detail.vm;

import android.os.Handler;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopHWApi;
import com.tencent.mobileqq.troop.homework.clockin.detail.model.list.e;
import com.tencent.mobileqq.troop.homework.clockin.detail.vm.a;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolTaskData;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.troop.homework.clockin.detail.vm.HWClockInDetailViewModel$handleTaskData$2", f = "HWClockInDetailViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes19.dex */
public final class HWClockInDetailViewModel$handleTaskData$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ GroupSchoolTaskData $data;
    int label;
    final /* synthetic */ HWClockInDetailViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HWClockInDetailViewModel$handleTaskData$2(HWClockInDetailViewModel hWClockInDetailViewModel, GroupSchoolTaskData groupSchoolTaskData, Continuation<? super HWClockInDetailViewModel$handleTaskData$2> continuation) {
        super(2, continuation);
        this.this$0 = hWClockInDetailViewModel;
        this.$data = groupSchoolTaskData;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, hWClockInDetailViewModel, groupSchoolTaskData, continuation);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(HWClockInDetailViewModel hWClockInDetailViewModel) {
        String str;
        ITroopHWApi iTroopHWApi = (ITroopHWApi) QRoute.api(ITroopHWApi.class);
        String a26 = hWClockInDetailViewModel.a2();
        str = hWClockInDetailViewModel.clockInId;
        iTroopHWApi.notifyTroopBannerHWBizOpened(a26, str);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new HWClockInDetailViewModel$handleTaskData$2(this.this$0, this.$data, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0053, code lost:
    
        if (r8 != false) goto L19;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        boolean U1;
        boolean z16;
        e eVar;
        MutableLiveData mUiState;
        MutableLiveData<a> mUiState2;
        e eVar2;
        boolean z17;
        MutableLiveData mUiState3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.this$0.detailData = this.$data;
                U1 = this.this$0.U1(Boxing.boxLong(this.$data.authorUin));
                if (U1) {
                    mUiState3 = this.this$0.getMUiState();
                    mUiState3.setValue(a.k.f296403a);
                }
                if (!U1) {
                    Boolean bool = (Boolean) this.this$0._isTeacher.getValue();
                    z16 = false;
                    if (bool != null) {
                        z17 = bool.booleanValue();
                    } else {
                        z17 = false;
                    }
                }
                z16 = true;
                eVar = this.this$0.listUseCase;
                if (eVar == null) {
                    HWClockInDetailViewModel hWClockInDetailViewModel = this.this$0;
                    e.Companion companion = e.INSTANCE;
                    CoroutineScope viewModelScope = ViewModelKt.getViewModelScope(hWClockInDetailViewModel);
                    String a26 = this.this$0.a2();
                    GroupSchoolTaskData groupSchoolTaskData = this.$data;
                    mUiState2 = this.this$0.getMUiState();
                    hWClockInDetailViewModel.listUseCase = companion.a(viewModelScope, a26, groupSchoolTaskData, z16, mUiState2);
                    eVar2 = this.this$0.listUseCase;
                    if (eVar2 != null) {
                        eVar2.init();
                    }
                }
                mUiState = this.this$0.getMUiState();
                mUiState.setValue(new a.g(z16));
                Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                final HWClockInDetailViewModel hWClockInDetailViewModel2 = this.this$0;
                uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.troop.homework.clockin.detail.vm.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        HWClockInDetailViewModel$handleTaskData$2.b(HWClockInDetailViewModel.this);
                    }
                });
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
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((HWClockInDetailViewModel$handleTaskData$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
