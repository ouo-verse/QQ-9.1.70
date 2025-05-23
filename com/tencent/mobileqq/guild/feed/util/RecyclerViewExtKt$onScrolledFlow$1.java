package com.tencent.mobileqq.guild.feed.util;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlin/Pair;", "", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.util.RecyclerViewExtKt$onScrolledFlow$1", f = "RecyclerViewExt.kt", i = {}, l = {28}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
final class RecyclerViewExtKt$onScrolledFlow$1 extends SuspendLambda implements Function2<ProducerScope<? super Pair<? extends Integer, ? extends Integer>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ RecyclerView $this_onScrolledFlow;
    private /* synthetic */ Object L$0;
    int label;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/feed/util/RecyclerViewExtKt$onScrolledFlow$1$a", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a extends RecyclerView.OnScrollListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ProducerScope<Pair<Integer, Integer>> f223805d;

        /* JADX WARN: Multi-variable type inference failed */
        a(ProducerScope<? super Pair<Integer, Integer>> producerScope) {
            this.f223805d = producerScope;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NotNull RecyclerView recyclerView, int dx5, int dy5) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            this.f223805d.mo2003trySendJP2dKIU(TuplesKt.to(Integer.valueOf(dx5), Integer.valueOf(dy5)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecyclerViewExtKt$onScrolledFlow$1(RecyclerView recyclerView, Continuation<? super RecyclerViewExtKt$onScrolledFlow$1> continuation) {
        super(2, continuation);
        this.$this_onScrolledFlow = recyclerView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        RecyclerViewExtKt$onScrolledFlow$1 recyclerViewExtKt$onScrolledFlow$1 = new RecyclerViewExtKt$onScrolledFlow$1(this.$this_onScrolledFlow, continuation);
        recyclerViewExtKt$onScrolledFlow$1.L$0 = obj;
        return recyclerViewExtKt$onScrolledFlow$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(ProducerScope<? super Pair<? extends Integer, ? extends Integer>> producerScope, Continuation<? super Unit> continuation) {
        return invoke2((ProducerScope<? super Pair<Integer, Integer>>) producerScope, continuation);
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
            ProducerScope producerScope = (ProducerScope) this.L$0;
            final a aVar = new a(producerScope);
            this.$this_onScrolledFlow.addOnScrollListener(aVar);
            final RecyclerView recyclerView = this.$this_onScrolledFlow;
            Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.feed.util.RecyclerViewExtKt$onScrolledFlow$1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    RecyclerView.this.removeOnScrollListener(aVar);
                }
            };
            this.label = 1;
            if (ProduceKt.awaitClose(producerScope, function0, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Nullable
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull ProducerScope<? super Pair<Integer, Integer>> producerScope, @Nullable Continuation<? super Unit> continuation) {
        return ((RecyclerViewExtKt$onScrolledFlow$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
