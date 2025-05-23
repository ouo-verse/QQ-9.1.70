package com.tencent.mobileqq.zplan.aigc.vm;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.zplan.aigc.data.AIGCFeedItemInfo2;
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

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.aigc.vm.SuitFeedViewModel$requestLikeClick$1", f = "SuitFeedViewModel.kt", i = {}, l = {207, 210}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
final class SuitFeedViewModel$requestLikeClick$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SuitFeedViewModel.c $callback;
    final /* synthetic */ AIGCFeedItemInfo2 $item;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuitFeedViewModel$requestLikeClick$1(AIGCFeedItemInfo2 aIGCFeedItemInfo2, SuitFeedViewModel.c cVar, Continuation<? super SuitFeedViewModel$requestLikeClick$1> continuation) {
        super(2, continuation);
        this.$item = aIGCFeedItemInfo2;
        this.$callback = cVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SuitFeedViewModel$requestLikeClick$1(this.$item, this.$callback, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0054 A[Catch: all -> 0x0079, TryCatch #0 {all -> 0x0079, blocks: (B:6:0x000e, B:7:0x0069, B:9:0x0073, B:15:0x001b, B:16:0x004a, B:18:0x0054, B:20:0x0022, B:22:0x002a, B:24:0x002d, B:26:0x0039, B:29:0x0058), top: B:2:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0073 A[Catch: all -> 0x0079, TRY_LEAVE, TryCatch #0 {all -> 0x0079, blocks: (B:6:0x000e, B:7:0x0069, B:9:0x0073, B:15:0x001b, B:16:0x004a, B:18:0x0054, B:20:0x0022, B:22:0x002a, B:24:0x002d, B:26:0x0039, B:29:0x0058), top: B:2:0x0008 }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        SuitFeedViewModel.c cVar;
        SuitFeedViewModel.c cVar2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                if (this.$item.getLikeData() == null) {
                    return Unit.INSTANCE;
                }
                if (!this.$item.getLikeData().getIsLike()) {
                    ZPlanAIGCRequest zPlanAIGCRequest = ZPlanAIGCRequest.f335341a;
                    long ugcId = this.$item.getUgcId();
                    this.label = 1;
                    obj = zPlanAIGCRequest.r(ugcId, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    long longValue = ((Number) obj).longValue();
                    cVar = this.$callback;
                    if (cVar != null) {
                    }
                } else {
                    ZPlanAIGCRequest zPlanAIGCRequest2 = ZPlanAIGCRequest.f335341a;
                    long ugcId2 = this.$item.getUgcId();
                    this.label = 2;
                    obj = zPlanAIGCRequest2.i(ugcId2, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    long longValue2 = ((Number) obj).longValue();
                    cVar2 = this.$callback;
                    if (cVar2 != null) {
                    }
                }
            } else if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
                long longValue3 = ((Number) obj).longValue();
                cVar = this.$callback;
                if (cVar != null) {
                    cVar.a(longValue3);
                }
            } else if (i3 == 2) {
                ResultKt.throwOnFailure(obj);
                long longValue22 = ((Number) obj).longValue();
                cVar2 = this.$callback;
                if (cVar2 != null) {
                    cVar2.a(longValue22);
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        } catch (Throwable unused) {
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final SuitFeedViewModel.c cVar3 = this.$callback;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.vm.g
                @Override // java.lang.Runnable
                public final void run() {
                    SuitFeedViewModel$requestLikeClick$1.b(SuitFeedViewModel.c.this);
                }
            });
            return Unit.INSTANCE;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SuitFeedViewModel$requestLikeClick$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(SuitFeedViewModel.c cVar) {
        if (cVar != null) {
            cVar.a(-1L);
        }
    }
}
