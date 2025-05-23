package com.tencent.mobileqq.troop.homework.clockin.detail.model;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.homework.clockin.detail.vm.a;
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
@Metadata(d1 = {"\u0000\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.troop.homework.clockin.detail.model.HWClockInDetailUserCase$updateDetailFoldState$2", f = "HWClockInDetailUserCase.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes19.dex */
public final class HWClockInDetailUserCase$updateDetailFoldState$2 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    /* synthetic */ boolean Z$0;
    int label;
    final /* synthetic */ HWClockInDetailUserCase this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HWClockInDetailUserCase$updateDetailFoldState$2(HWClockInDetailUserCase hWClockInDetailUserCase, Continuation<? super HWClockInDetailUserCase$updateDetailFoldState$2> continuation) {
        super(2, continuation);
        this.this$0 = hWClockInDetailUserCase;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) hWClockInDetailUserCase, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        HWClockInDetailUserCase$updateDetailFoldState$2 hWClockInDetailUserCase$updateDetailFoldState$2 = new HWClockInDetailUserCase$updateDetailFoldState$2(this.this$0, continuation);
        hWClockInDetailUserCase$updateDetailFoldState$2.Z$0 = ((Boolean) obj).booleanValue();
        return hWClockInDetailUserCase$updateDetailFoldState$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Continuation<? super Unit> continuation) {
        return invoke(bool.booleanValue(), continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        MutableLiveData mutableLiveData;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                boolean z16 = this.Z$0;
                mutableLiveData = this.this$0.uiState;
                mutableLiveData.postValue(new a.e(z16));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Nullable
    public final Object invoke(boolean z16, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((HWClockInDetailUserCase$updateDetailFoldState$2) create(Boolean.valueOf(z16), continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), continuation);
    }
}
