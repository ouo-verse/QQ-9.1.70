package com.tencent.mobileqq.mini.entry.newdesktop.part;

import com.tencent.mobileqq.mini.entry.newdesktop.mvi.MiniAppDeskTopIntent;
import com.tencent.mobileqq.mini.entry.newdesktop.mvi.MiniAppDeskTopViewModel;
import com.tencent.view.FilterEnum;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopRvPart$doSetAdapterWithMainThread$2", f = "MiniAppDesktopRvPart.kt", i = {}, l = {FilterEnum.MIC_PTU_BAIXI}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes33.dex */
final class MiniAppDesktopRvPart$doSetAdapterWithMainThread$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MiniAppDesktopRvPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniAppDesktopRvPart$doSetAdapterWithMainThread$2(MiniAppDesktopRvPart miniAppDesktopRvPart, Continuation<? super MiniAppDesktopRvPart$doSetAdapterWithMainThread$2> continuation) {
        super(2, continuation);
        this.this$0 = miniAppDesktopRvPart;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MiniAppDesktopRvPart$doSetAdapterWithMainThread$2(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            MiniAppDeskTopViewModel mMiniAppDesktopViewModel = this.this$0.getMMiniAppDesktopViewModel();
            MiniAppDeskTopIntent.GetMiniAppDesktopLocalData getMiniAppDesktopLocalData = MiniAppDeskTopIntent.GetMiniAppDesktopLocalData.INSTANCE;
            this.label = 1;
            if (mMiniAppDesktopViewModel.sendUserIntent(getMiniAppDesktopLocalData, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MiniAppDesktopRvPart$doSetAdapterWithMainThread$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
