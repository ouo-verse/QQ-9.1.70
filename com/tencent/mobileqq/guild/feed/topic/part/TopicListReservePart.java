package com.tencent.mobileqq.guild.feed.topic.part;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.component.GuildQUIEmptyState;
import com.tencent.mobileqq.guild.component.animator.ScanningLightView;
import com.tencent.mobileqq.guild.feed.topic.TopicFeedsReloadEvent;
import com.tencent.mobileqq.guild.feed.topic.mvi.FeedListState;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/topic/part/TopicListReservePart;", "Lcom/tencent/mobileqq/guild/feed/topic/part/TopicListBasePart;", "Lcom/tencent/mobileqq/guild/feed/topic/mvi/a;", "state", "Landroid/view/View;", "H9", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class TopicListReservePart extends TopicListBasePart {
    /* JADX INFO: Access modifiers changed from: private */
    public final View H9(FeedListState state) {
        if (state.getSuccess().f431477a == -1) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            ScanningLightView scanningLightView = new ScanningLightView(context, null, 2, null);
            scanningLightView.setImageResource(R.drawable.guild_feed_square_loading_view);
            scanningLightView.setSkeletonColorRes(R.color.qui_common_fill_standard_primary);
            return scanningLightView;
        }
        if (!state.c().b().isEmpty()) {
            return null;
        }
        GuildQUIEmptyState.a aVar = new GuildQUIEmptyState.a(getContext());
        aVar.s(8);
        String string = getContext().getString(R.string.f145530rq);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026d_feed_square_emtpy_tips)");
        aVar.u(string);
        String string2 = getContext().getString(R.string.f157991oe);
        Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.string.guild_topic_empty_desc)");
        aVar.q(string2);
        return aVar.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        final FrameLayout reserveLayout = (FrameLayout) rootView.findViewById(R.id.f100345s9);
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        Intrinsics.checkNotNullExpressionValue(simpleEventBus, "getInstance()");
        final Flow callbackFlow = FlowKt.callbackFlow(new TopicListReservePart$onInitView$$inlined$eventFlow$1(simpleEventBus, null));
        FlowKt.launchIn(FlowKt.onEach(new Flow<TopicFeedsReloadEvent>() { // from class: com.tencent.mobileqq.guild.feed.topic.part.TopicListReservePart$onInitView$$inlined$filter$1

            @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\b"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$lambda-1$$inlined$collect$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 1, mv = {1, 7, 1}, xi = 48)
            /* renamed from: com.tencent.mobileqq.guild.feed.topic.part.TopicListReservePart$onInitView$$inlined$filter$1$2, reason: invalid class name */
            /* loaded from: classes13.dex */
            public static final class AnonymousClass2 implements FlowCollector<TopicFeedsReloadEvent> {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ FlowCollector f223683d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ TopicListReservePart f223684e;

                @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                @DebugMetadata(c = "com.tencent.mobileqq.guild.feed.topic.part.TopicListReservePart$onInitView$$inlined$filter$1$2", f = "TopicListReservePart.kt", i = {}, l = {136}, m = "emit", n = {}, s = {})
                /* renamed from: com.tencent.mobileqq.guild.feed.topic.part.TopicListReservePart$onInitView$$inlined$filter$1$2$1, reason: invalid class name */
                /* loaded from: classes13.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    Object L$1;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, TopicListReservePart topicListReservePart) {
                    this.f223683d = flowCollector;
                    this.f223684e = topicListReservePart;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public Object emit(TopicFeedsReloadEvent topicFeedsReloadEvent, @NotNull Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    Object coroutine_suspended;
                    int i3;
                    boolean z16;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        int i16 = anonymousClass1.label;
                        if ((i16 & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label = i16 - Integer.MIN_VALUE;
                            Object obj = anonymousClass1.result;
                            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            i3 = anonymousClass1.label;
                            if (i3 == 0) {
                                if (i3 == 1) {
                                    ResultKt.throwOnFailure(obj);
                                } else {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                            } else {
                                ResultKt.throwOnFailure(obj);
                                FlowCollector flowCollector = this.f223683d;
                                if (this.f223684e.z9().getTopicId() == topicFeedsReloadEvent.getTopicId()) {
                                    z16 = true;
                                } else {
                                    z16 = false;
                                }
                                if (z16) {
                                    anonymousClass1.label = 1;
                                    if (flowCollector.emit(topicFeedsReloadEvent, anonymousClass1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    anonymousClass1 = new AnonymousClass1(continuation);
                    Object obj2 = anonymousClass1.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = anonymousClass1.label;
                    if (i3 == 0) {
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super TopicFeedsReloadEvent> flowCollector, @NotNull Continuation continuation) {
                Object coroutine_suspended;
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, this), continuation);
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (collect == coroutine_suspended) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        }, new TopicListReservePart$onInitView$2(this, null)), com.tencent.mobileqq.guild.feed.part.a.d(this));
        LiveData<FeedListState> X1 = E9().X1();
        LifecycleOwner c16 = com.tencent.mobileqq.guild.feed.part.a.c(this);
        final Function1<FeedListState, Unit> function1 = new Function1<FeedListState, Unit>() { // from class: com.tencent.mobileqq.guild.feed.topic.part.TopicListReservePart$onInitView$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FeedListState feedListState) {
                invoke2(feedListState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FeedListState state) {
                View H9;
                TopicListReservePart topicListReservePart = TopicListReservePart.this;
                Intrinsics.checkNotNullExpressionValue(state, "state");
                H9 = topicListReservePart.H9(state);
                if (H9 != null) {
                    FrameLayout frameLayout = reserveLayout;
                    TopicListReservePart topicListReservePart2 = TopicListReservePart.this;
                    frameLayout.removeAllViews();
                    frameLayout.addView(H9);
                    frameLayout.setVisibility(0);
                    topicListReservePart2.A9().Z1(new com.tencent.mobileqq.guild.feed.topic.mvi.o(false));
                    return;
                }
                TopicListReservePart topicListReservePart3 = TopicListReservePart.this;
                FrameLayout frameLayout2 = reserveLayout;
                topicListReservePart3.A9().Z1(new com.tencent.mobileqq.guild.feed.topic.mvi.o(true));
                frameLayout2.setVisibility(8);
            }
        };
        X1.observe(c16, new Observer() { // from class: com.tencent.mobileqq.guild.feed.topic.part.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TopicListReservePart.I9(Function1.this, obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(reserveLayout, "reserveLayout");
        if1.a.b(reserveLayout, "em_sgrp_empty", null, null, ExposurePolicy.REPORT_ALL, null, null, null, null, 246, null);
    }
}
