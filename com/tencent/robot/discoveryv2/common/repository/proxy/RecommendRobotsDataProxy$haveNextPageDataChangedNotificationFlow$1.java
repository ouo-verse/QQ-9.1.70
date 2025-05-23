package com.tencent.robot.discoveryv2.common.repository.proxy;

import com.tencent.robot.discoveryv2.common.data.SingleCategoryNextPageData;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/channels/ProducerScope;", "Lcom/tencent/robot/discoveryv2/common/data/i;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.robot.discoveryv2.common.repository.proxy.RecommendRobotsDataProxy$haveNextPageDataChangedNotificationFlow$1", f = "RecommendRobotsDataProxy.kt", i = {}, l = {92}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes25.dex */
public final class RecommendRobotsDataProxy$haveNextPageDataChangedNotificationFlow$1 extends SuspendLambda implements Function2<ProducerScope<? super SingleCategoryNextPageData>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ RecommendRobotsDataProxy this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecommendRobotsDataProxy$haveNextPageDataChangedNotificationFlow$1(RecommendRobotsDataProxy recommendRobotsDataProxy, Continuation<? super RecommendRobotsDataProxy$haveNextPageDataChangedNotificationFlow$1> continuation) {
        super(2, continuation);
        this.this$0 = recommendRobotsDataProxy;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        RecommendRobotsDataProxy$haveNextPageDataChangedNotificationFlow$1 recommendRobotsDataProxy$haveNextPageDataChangedNotificationFlow$1 = new RecommendRobotsDataProxy$haveNextPageDataChangedNotificationFlow$1(this.this$0, continuation);
        recommendRobotsDataProxy$haveNextPageDataChangedNotificationFlow$1.L$0 = obj;
        return recommendRobotsDataProxy$haveNextPageDataChangedNotificationFlow$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        ConcurrentHashMap concurrentHashMap;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            final ProducerScope producerScope = (ProducerScope) this.L$0;
            final Function1<SingleCategoryNextPageData, Unit> function1 = new Function1<SingleCategoryNextPageData, Unit>() { // from class: com.tencent.robot.discoveryv2.common.repository.proxy.RecommendRobotsDataProxy$haveNextPageDataChangedNotificationFlow$1$listener$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SingleCategoryNextPageData singleCategoryNextPageData) {
                    invoke2(singleCategoryNextPageData);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull SingleCategoryNextPageData it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    producerScope.mo2003trySendJP2dKIU(it);
                }
            };
            concurrentHashMap = this.this$0.mHaveNextPageDataChangedListener;
            concurrentHashMap.put(Boxing.boxInt(function1.hashCode()), function1);
            final RecommendRobotsDataProxy recommendRobotsDataProxy = this.this$0;
            Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.robot.discoveryv2.common.repository.proxy.RecommendRobotsDataProxy$haveNextPageDataChangedNotificationFlow$1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    ConcurrentHashMap concurrentHashMap2;
                    concurrentHashMap2 = RecommendRobotsDataProxy.this.mHaveNextPageDataChangedListener;
                    concurrentHashMap2.remove(Integer.valueOf(function1.hashCode()));
                }
            };
            this.label = 1;
            if (ProduceKt.awaitClose(producerScope, function0, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull ProducerScope<? super SingleCategoryNextPageData> producerScope, @Nullable Continuation<? super Unit> continuation) {
        return ((RecommendRobotsDataProxy$haveNextPageDataChangedNotificationFlow$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
