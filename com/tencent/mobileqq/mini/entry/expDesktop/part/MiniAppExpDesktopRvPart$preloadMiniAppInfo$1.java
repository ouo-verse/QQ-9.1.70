package com.tencent.mobileqq.mini.entry.expDesktop.part;

import com.tencent.mobileqq.mini.entry.desktop.GetAppListV2Scene;
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
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopRvPart$preloadMiniAppInfo$1", f = "MiniAppExpDesktopRvPart.kt", i = {}, l = {138, 139}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes33.dex */
public final class MiniAppExpDesktopRvPart$preloadMiniAppInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ GetAppListV2Scene $scene;
    int label;
    final /* synthetic */ MiniAppExpDesktopRvPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniAppExpDesktopRvPart$preloadMiniAppInfo$1(MiniAppExpDesktopRvPart miniAppExpDesktopRvPart, GetAppListV2Scene getAppListV2Scene, Continuation<? super MiniAppExpDesktopRvPart$preloadMiniAppInfo$1> continuation) {
        super(2, continuation);
        this.this$0 = miniAppExpDesktopRvPart;
        this.$scene = getAppListV2Scene;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MiniAppExpDesktopRvPart$preloadMiniAppInfo$1(this.this$0, this.$scene, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            MiniAppExpDesktopViewModel mMiniAppDesktopViewModel = this.this$0.getMMiniAppDesktopViewModel();
            MiniAppExpDesktopIntent.GetMiniAppDesktopLocalData getMiniAppDesktopLocalData = MiniAppExpDesktopIntent.GetMiniAppDesktopLocalData.INSTANCE;
            this.label = 1;
            if (mMiniAppDesktopViewModel.sendUserIntent(getMiniAppDesktopLocalData, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i3 != 1) {
                if (i3 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        MiniAppExpDesktopViewModel mMiniAppDesktopViewModel2 = this.this$0.getMMiniAppDesktopViewModel();
        MiniAppExpDesktopIntent.GetMiniAppDesktopNetworkData getMiniAppDesktopNetworkData = new MiniAppExpDesktopIntent.GetMiniAppDesktopNetworkData(false, this.$scene);
        this.label = 2;
        if (mMiniAppDesktopViewModel2.sendUserIntent(getMiniAppDesktopNetworkData, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MiniAppExpDesktopRvPart$preloadMiniAppInfo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
