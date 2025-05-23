package com.tencent.mobileqq.zplan.aigc.vm;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.zplan.aigc.vm.SuitFeedViewModel;
import com.tencent.mobileqq.zplan.servlet.ZPlanAIGCRequest;
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
@DebugMetadata(c = "com.tencent.mobileqq.zplan.aigc.vm.SuitFeedViewModel$fetchChannelSig$1", f = "SuitFeedViewModel.kt", i = {}, l = {138}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
public final class SuitFeedViewModel$fetchChannelSig$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SuitFeedViewModel.b $channelInfoCallback;
    int label;
    final /* synthetic */ SuitFeedViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuitFeedViewModel$fetchChannelSig$1(SuitFeedViewModel.b bVar, SuitFeedViewModel suitFeedViewModel, Continuation<? super SuitFeedViewModel$fetchChannelSig$1> continuation) {
        super(2, continuation);
        this.$channelInfoCallback = bVar;
        this.this$0 = suitFeedViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SuitFeedViewModel$fetchChannelSig$1(this.$channelInfoCallback, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                ZPlanAIGCRequest zPlanAIGCRequest = ZPlanAIGCRequest.f335341a;
                this.label = 1;
                obj = zPlanAIGCRequest.g(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            final String str = (String) obj;
            if (!TextUtils.isEmpty(str)) {
                Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                final SuitFeedViewModel.b bVar = this.$channelInfoCallback;
                final SuitFeedViewModel suitFeedViewModel = this.this$0;
                uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.vm.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        SuitFeedViewModel$fetchChannelSig$1.d(SuitFeedViewModel.b.this, str, suitFeedViewModel);
                    }
                });
            } else {
                Handler uIHandlerV22 = ThreadManagerV2.getUIHandlerV2();
                final SuitFeedViewModel.b bVar2 = this.$channelInfoCallback;
                uIHandlerV22.post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.vm.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        SuitFeedViewModel$fetchChannelSig$1.e(SuitFeedViewModel.b.this);
                    }
                });
            }
            return Unit.INSTANCE;
        } catch (Throwable unused) {
            Handler uIHandlerV23 = ThreadManagerV2.getUIHandlerV2();
            final SuitFeedViewModel.b bVar3 = this.$channelInfoCallback;
            uIHandlerV23.post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.vm.f
                @Override // java.lang.Runnable
                public final void run() {
                    SuitFeedViewModel$fetchChannelSig$1.f(SuitFeedViewModel.b.this);
                }
            });
            return Unit.INSTANCE;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SuitFeedViewModel$fetchChannelSig$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(SuitFeedViewModel.b bVar, String str, SuitFeedViewModel suitFeedViewModel) {
        if (bVar != null) {
            bVar.a(str);
        }
        suitFeedViewModel.channelSig = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(SuitFeedViewModel.b bVar) {
        if (bVar != null) {
            bVar.a(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(SuitFeedViewModel.b bVar) {
        if (bVar != null) {
            bVar.a(null);
        }
    }
}
