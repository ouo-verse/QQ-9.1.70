package com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.viewHolder;

import com.tencent.mobileqq.mini.entry.expDesktop.mvi.MiniAppExpDesktopIntent;
import com.tencent.mobileqq.mini.entry.expDesktop.mvi.MiniAppExpDesktopViewModel;
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
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.viewHolder.MyMiniAppDragManager$myMiniAppDragDrop$1", f = "MyMiniAppDragManager.kt", i = {}, l = {108}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes33.dex */
public final class MyMiniAppDragManager$myMiniAppDragDrop$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $fromPosition;
    final /* synthetic */ int $toPosition;
    int label;
    final /* synthetic */ MyMiniAppDragManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MyMiniAppDragManager$myMiniAppDragDrop$1(MyMiniAppDragManager myMiniAppDragManager, int i3, int i16, Continuation<? super MyMiniAppDragManager$myMiniAppDragDrop$1> continuation) {
        super(2, continuation);
        this.this$0 = myMiniAppDragManager;
        this.$fromPosition = i3;
        this.$toPosition = i16;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MyMiniAppDragManager$myMiniAppDragDrop$1(this.this$0, this.$fromPosition, this.$toPosition, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        MiniAppExpDesktopViewModel miniAppExpDesktopViewModel;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            miniAppExpDesktopViewModel = this.this$0.mMiniAppDesktopViewModel;
            if (miniAppExpDesktopViewModel != null) {
                MiniAppExpDesktopIntent.MyMiniAppSwitchPosition myMiniAppSwitchPosition = new MiniAppExpDesktopIntent.MyMiniAppSwitchPosition(this.$fromPosition, this.$toPosition);
                this.label = 1;
                if (miniAppExpDesktopViewModel.sendUserIntent(myMiniAppSwitchPosition, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
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
        return ((MyMiniAppDragManager$myMiniAppDragDrop$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
