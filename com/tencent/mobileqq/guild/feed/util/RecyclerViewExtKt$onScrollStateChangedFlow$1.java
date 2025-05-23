package com.tencent.mobileqq.guild.feed.util;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.ResultKt;
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
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/channels/ProducerScope;", "", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.util.RecyclerViewExtKt$onScrollStateChangedFlow$1", f = "RecyclerViewExt.kt", i = {}, l = {38}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
final class RecyclerViewExtKt$onScrollStateChangedFlow$1 extends SuspendLambda implements Function2<ProducerScope<? super Integer>, Continuation<? super Unit>, Object> {
    final /* synthetic */ RecyclerView $this_onScrollStateChangedFlow;
    private /* synthetic */ Object L$0;
    int label;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/feed/util/RecyclerViewExtKt$onScrollStateChangedFlow$1$a", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a extends RecyclerView.OnScrollListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ProducerScope<Integer> f223804d;

        /* JADX WARN: Multi-variable type inference failed */
        a(ProducerScope<? super Integer> producerScope) {
            this.f223804d = producerScope;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            this.f223804d.mo2003trySendJP2dKIU(Integer.valueOf(newState));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecyclerViewExtKt$onScrollStateChangedFlow$1(RecyclerView recyclerView, Continuation<? super RecyclerViewExtKt$onScrollStateChangedFlow$1> continuation) {
        super(2, continuation);
        this.$this_onScrollStateChangedFlow = recyclerView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        RecyclerViewExtKt$onScrollStateChangedFlow$1 recyclerViewExtKt$onScrollStateChangedFlow$1 = new RecyclerViewExtKt$onScrollStateChangedFlow$1(this.$this_onScrollStateChangedFlow, continuation);
        recyclerViewExtKt$onScrollStateChangedFlow$1.L$0 = obj;
        return recyclerViewExtKt$onScrollStateChangedFlow$1;
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
            this.$this_onScrollStateChangedFlow.addOnScrollListener(aVar);
            final RecyclerView recyclerView = this.$this_onScrollStateChangedFlow;
            Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.feed.util.RecyclerViewExtKt$onScrollStateChangedFlow$1.1
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

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull ProducerScope<? super Integer> producerScope, @Nullable Continuation<? super Unit> continuation) {
        return ((RecyclerViewExtKt$onScrollStateChangedFlow$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
