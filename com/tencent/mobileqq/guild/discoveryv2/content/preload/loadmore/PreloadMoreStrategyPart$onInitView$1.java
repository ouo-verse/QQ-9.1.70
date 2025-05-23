package com.tencent.mobileqq.guild.discoveryv2.content.preload.loadmore;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qh1.MVPFeedsUIState;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.discoveryv2.content.preload.loadmore.PreloadMoreStrategyPart$onInitView$1", f = "PreloadMoreStrategyPart.kt", i = {}, l = {61}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
final class PreloadMoreStrategyPart$onInitView$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ PreloadMoreStrategyPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lqh1/e;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.guild.discoveryv2.content.preload.loadmore.PreloadMoreStrategyPart$onInitView$1$1", f = "PreloadMoreStrategyPart.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.guild.discoveryv2.content.preload.loadmore.PreloadMoreStrategyPart$onInitView$1$1, reason: invalid class name */
    /* loaded from: classes13.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<MVPFeedsUIState, Continuation<? super Boolean>, Object> {
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        /* JADX WARN: Code restructure failed: missing block: B:6:0x0028, code lost:
        
            if ((!r2.getListState().d().isEmpty()) != false) goto L10;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(@NotNull Object obj) {
            boolean z16;
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                if (((MVPFeedsUIState) this.L$0).getSuccess().d()) {
                    z16 = true;
                }
                z16 = false;
                return Boxing.boxBoolean(z16);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull MVPFeedsUIState mVPFeedsUIState, @Nullable Continuation<? super Boolean> continuation) {
            return ((AnonymousClass1) create(mVPFeedsUIState, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreloadMoreStrategyPart$onInitView$1(PreloadMoreStrategyPart preloadMoreStrategyPart, Continuation<? super PreloadMoreStrategyPart$onInitView$1> continuation) {
        super(2, continuation);
        this.this$0 = preloadMoreStrategyPart;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new PreloadMoreStrategyPart$onInitView$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
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
            Object broadcastGetMessage = this.this$0.broadcastGetMessage(Reflection.getOrCreateKotlinClass(MVPFeedsUIState.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(MVPFeedsUIState.class));
            Intrinsics.checkNotNull(broadcastGetMessage, "null cannot be cast to non-null type kotlinx.coroutines.flow.StateFlow<T of com.tencent.mobileqq.guild.discoveryv2.content.part.MVPFeedsPart.getStateFlow>");
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(null);
            this.label = 1;
            if (FlowKt.first((StateFlow) broadcastGetMessage, anonymousClass1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        this.this$0.F9();
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((PreloadMoreStrategyPart$onInitView$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
