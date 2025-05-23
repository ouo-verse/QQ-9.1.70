package com.tencent.mobileqq.zplan.meme.frameanim.overlay;

import androidx.lifecycle.MutableLiveData;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.CancellationException;
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

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.meme.frameanim.overlay.ZPlanAvatarOverlayViewModel$doOnLoadingStart$1", f = "ZPlanAvatarOverlayViewModel.kt", i = {}, l = {68}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
public final class ZPlanAvatarOverlayViewModel$doOnLoadingStart$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $needTimeout;
    int label;
    final /* synthetic */ ZPlanAvatarOverlayViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanAvatarOverlayViewModel$doOnLoadingStart$1(ZPlanAvatarOverlayViewModel zPlanAvatarOverlayViewModel, boolean z16, Continuation<? super ZPlanAvatarOverlayViewModel$doOnLoadingStart$1> continuation) {
        super(2, continuation);
        this.this$0 = zPlanAvatarOverlayViewModel;
        this.$needTimeout = z16;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ZPlanAvatarOverlayViewModel$doOnLoadingStart$1(this.this$0, this.$needTimeout, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        MutableLiveData mutableLiveData;
        MutableLiveData mutableLiveData2;
        Object h26;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                QLog.i("ZPlanAvatarOverlayViewModel", 1, this.this$0 + ", start record waiting timer.");
                ZPlanAvatarOverlayViewModel zPlanAvatarOverlayViewModel = this.this$0;
                boolean z16 = this.$needTimeout;
                this.label = 1;
                h26 = zPlanAvatarOverlayViewModel.h2(z16, this);
                if (h26 == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (CancellationException unused) {
            QLog.i("ZPlanAvatarOverlayViewModel", 1, this.this$0 + ", onLoadingStart count down and progression cancelled.");
            mutableLiveData = this.this$0.isRecordingMut;
            mutableLiveData.postValue(Boxing.boxBoolean(false));
            mutableLiveData2 = this.this$0.isTimeOutMut;
            mutableLiveData2.postValue(Boxing.boxBoolean(false));
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ZPlanAvatarOverlayViewModel$doOnLoadingStart$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
