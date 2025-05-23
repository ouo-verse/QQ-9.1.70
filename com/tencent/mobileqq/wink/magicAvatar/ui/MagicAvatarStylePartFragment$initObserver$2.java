package com.tencent.mobileqq.wink.magicAvatar.ui;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.wink.magicAvatar.model.PageInfoCallbackInfo;
import com.tencent.mobileqq.wink.magicAvatar.viewmodel.MagicAvatarStyleViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SharedFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.magicAvatar.ui.MagicAvatarStylePartFragment$initObserver$2", f = "MagicAvatarStylePartFragment.kt", i = {}, l = {425}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class MagicAvatarStylePartFragment$initObserver$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MagicAvatarStylePartFragment this$0;

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a implements FlowCollector<PageInfoCallbackInfo> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ MagicAvatarStylePartFragment f323567d;

        public a(MagicAvatarStylePartFragment magicAvatarStylePartFragment) {
            this.f323567d = magicAvatarStylePartFragment;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        @Nullable
        public Object emit(PageInfoCallbackInfo pageInfoCallbackInfo, @NotNull Continuation<? super Unit> continuation) {
            RecyclerView recyclerView;
            RecyclerView recyclerView2;
            p pVar;
            PageInfoCallbackInfo pageInfoCallbackInfo2 = pageInfoCallbackInfo;
            if (pageInfoCallbackInfo2 == null || pageInfoCallbackInfo2.b().isEmpty()) {
                this.f323567d.Th();
            } else {
                recyclerView = this.f323567d.recyclerView;
                RecyclerView recyclerView3 = null;
                if (recyclerView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                    recyclerView = null;
                }
                recyclerView2 = this.f323567d.recyclerView;
                if (recyclerView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                } else {
                    recyclerView3 = recyclerView2;
                }
                recyclerView.setBackgroundColor(ContextCompat.getColor(recyclerView3.getContext(), R.color.ajr));
                this.f323567d.hideLoading();
                pVar = this.f323567d.styleAdapter;
                if (pVar != null) {
                    pVar.k0(pageInfoCallbackInfo2.b());
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MagicAvatarStylePartFragment$initObserver$2(MagicAvatarStylePartFragment magicAvatarStylePartFragment, Continuation<? super MagicAvatarStylePartFragment$initObserver$2> continuation) {
        super(2, continuation);
        this.this$0 = magicAvatarStylePartFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MagicAvatarStylePartFragment$initObserver$2(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        MagicAvatarStyleViewModel Hh;
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
            Hh = this.this$0.Hh();
            SharedFlow<PageInfoCallbackInfo> S1 = Hh.S1();
            a aVar = new a(this.this$0);
            this.label = 1;
            if (S1.collect(aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((MagicAvatarStylePartFragment$initObserver$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
