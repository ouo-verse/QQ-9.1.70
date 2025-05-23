package com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.logic;

import com.tencent.mobileqq.guild.feed.nativedetail.bottom.base.GuideBarGuildInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u0002H\u008a@\u00a8\u0006\u0004"}, d2 = {"T", BdhLogUtil.LogTag.Tag_Req, "Lkotlinx/coroutines/flow/FlowCollector;", "", "kotlinx/coroutines/flow/FlowKt__EmittersKt$transform$1", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.logic.BottomGuideBarDelegateDefaultImpl$fetchGuildInfoModels$$inlined$transform$1", f = "BottomGuideBarDelegateDefaultImpl.kt", i = {}, l = {223}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class BottomGuideBarDelegateDefaultImpl$fetchGuildInfoModels$$inlined$transform$1 extends SuspendLambda implements Function2<FlowCollector<? super GuideBarGuildInfo>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow $this_transform;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ BottomGuideBarDelegateDefaultImpl this$0;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$transform$1$invokeSuspend$$inlined$collect$1"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements FlowCollector<GuideBarGuildInfo> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ FlowCollector f220639d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ BottomGuideBarDelegateDefaultImpl f220640e;

        public a(FlowCollector flowCollector, BottomGuideBarDelegateDefaultImpl bottomGuideBarDelegateDefaultImpl) {
            this.f220640e = bottomGuideBarDelegateDefaultImpl;
            this.f220639d = flowCollector;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        @Nullable
        public Object emit(GuideBarGuildInfo guideBarGuildInfo, @NotNull Continuation continuation) {
            GuideBarGuildInfo guideBarGuildInfo2;
            Object coroutine_suspended;
            FlowCollector flowCollector = this.f220639d;
            GuideBarGuildInfo guideBarGuildInfo3 = guideBarGuildInfo;
            guideBarGuildInfo2 = this.f220640e.modelCached;
            if (guideBarGuildInfo2 != null) {
                this.f220640e.isCacheReusable = true;
                GuideBarGuildInfo b16 = GuideBarGuildInfo.b(guideBarGuildInfo2, null, null, null, null, null, 31, null);
                if (guideBarGuildInfo3.getGuildName() != null && !Intrinsics.areEqual(guideBarGuildInfo3.getGuildName(), b16.getGuildName())) {
                    b16.l(guideBarGuildInfo3.getGuildName());
                }
                if (guideBarGuildInfo3.getGuildIcon() != null && !Intrinsics.areEqual(guideBarGuildInfo3.getGuildIcon(), b16.getGuildIcon())) {
                    b16.k(guideBarGuildInfo3.getGuildIcon());
                }
                if (guideBarGuildInfo3.getIsMember() != null && !Intrinsics.areEqual(guideBarGuildInfo3.getIsMember(), b16.getIsMember())) {
                    b16.m(guideBarGuildInfo3.getIsMember());
                }
                if (guideBarGuildInfo3.getRecommendTag() != null && !Intrinsics.areEqual(guideBarGuildInfo3.getRecommendTag(), b16.getRecommendTag())) {
                    b16.n(guideBarGuildInfo3.getRecommendTag());
                }
                guideBarGuildInfo3 = b16;
            }
            this.f220640e.modelCached = guideBarGuildInfo3;
            Object emit = flowCollector.emit(guideBarGuildInfo3, continuation);
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (emit == coroutine_suspended) {
                return emit;
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BottomGuideBarDelegateDefaultImpl$fetchGuildInfoModels$$inlined$transform$1(Flow flow, Continuation continuation, BottomGuideBarDelegateDefaultImpl bottomGuideBarDelegateDefaultImpl) {
        super(2, continuation);
        this.$this_transform = flow;
        this.this$0 = bottomGuideBarDelegateDefaultImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        BottomGuideBarDelegateDefaultImpl$fetchGuildInfoModels$$inlined$transform$1 bottomGuideBarDelegateDefaultImpl$fetchGuildInfoModels$$inlined$transform$1 = new BottomGuideBarDelegateDefaultImpl$fetchGuildInfoModels$$inlined$transform$1(this.$this_transform, continuation, this.this$0);
        bottomGuideBarDelegateDefaultImpl$fetchGuildInfoModels$$inlined$transform$1.L$0 = obj;
        return bottomGuideBarDelegateDefaultImpl$fetchGuildInfoModels$$inlined$transform$1;
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
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            Flow flow = this.$this_transform;
            a aVar = new a(flowCollector, this.this$0);
            this.label = 1;
            if (flow.collect(aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull FlowCollector<? super GuideBarGuildInfo> flowCollector, @Nullable Continuation<? super Unit> continuation) {
        return ((BottomGuideBarDelegateDefaultImpl$fetchGuildInfoModels$$inlined$transform$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
