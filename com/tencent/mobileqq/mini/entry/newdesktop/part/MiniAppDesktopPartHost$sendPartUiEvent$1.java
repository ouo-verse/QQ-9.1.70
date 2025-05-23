package com.tencent.mobileqq.mini.entry.newdesktop.part;

import com.tencent.mobileqq.mini.entry.newdesktop.mvi.MiniAppDeskTopIntent;
import com.tencent.mobileqq.mini.entry.newdesktop.mvi.MiniAppDeskTopViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopPartHost$sendPartUiEvent$1", f = "MiniAppDesktopPartHost.kt", i = {}, l = {253}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes33.dex */
public final class MiniAppDesktopPartHost$sendPartUiEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MiniAppDeskTopIntent $miniAppDeskTopIntent;
    int label;
    final /* synthetic */ MiniAppDesktopPartHost this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniAppDesktopPartHost$sendPartUiEvent$1(MiniAppDesktopPartHost miniAppDesktopPartHost, MiniAppDeskTopIntent miniAppDeskTopIntent, Continuation<? super MiniAppDesktopPartHost$sendPartUiEvent$1> continuation) {
        super(2, continuation);
        this.this$0 = miniAppDesktopPartHost;
        this.$miniAppDeskTopIntent = miniAppDeskTopIntent;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MiniAppDesktopPartHost$sendPartUiEvent$1(this.this$0, this.$miniAppDeskTopIntent, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            MiniAppDeskTopViewModel mMiniAppDesktopViewModel = this.this$0.getMMiniAppDesktopViewModel();
            MiniAppDeskTopIntent miniAppDeskTopIntent = this.$miniAppDeskTopIntent;
            this.label = 1;
            if (mMiniAppDesktopViewModel.sendUserIntent(miniAppDeskTopIntent, this) == coroutine_suspended) {
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
        return ((MiniAppDesktopPartHost$sendPartUiEvent$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
