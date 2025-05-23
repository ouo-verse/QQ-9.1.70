package com.tencent.mobileqq.guild.aisearch.parts;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.aisearch.AIChatListViewModel;
import com.tencent.mobileqq.guild.aisearch.models.AiChatSession;
import com.tencent.mobileqq.guild.aisearch.models.i;
import com.tencent.mobileqq.guild.base.extension.m;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import ef1.c;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.TimeSource;
import kotlin.time.TimedValue;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u001b\u0010\u000e\u001a\u00020\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0010\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/parts/PageToggleAnimatorPart;", "Lcom/tencent/biz/richframework/part/Part;", "", "newChat", "", "A9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/tencent/mobileqq/guild/aisearch/AIChatListViewModel;", "d", "Lkotlin/Lazy;", "z9", "()Lcom/tencent/mobileqq/guild/aisearch/AIChatListViewModel;", "aiChatListViewModel", "e", "Landroid/view/View;", "chatListView", "f", "emptyView", "<init>", "()V", h.F, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class PageToggleAnimatorPart extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy aiChatListViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View chatListView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private View emptyView;

    public PageToggleAnimatorPart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<AIChatListViewModel>() { // from class: com.tencent.mobileqq.guild.aisearch.parts.PageToggleAnimatorPart$aiChatListViewModel$2

            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/base/mvvm/SingleViewModelProvider$Companion$factory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes12.dex */
            public static final class a implements ViewModelProvider.Factory {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ ViewModelStoreOwner f214215a;

                public a(ViewModelStoreOwner viewModelStoreOwner) {
                    this.f214215a = viewModelStoreOwner;
                }

                @Override // androidx.lifecycle.ViewModelProvider.Factory
                @NotNull
                public <T extends ViewModel> T create(@NotNull Class<T> p06) {
                    Intrinsics.checkNotNullParameter(p06, "p0");
                    TimedValue timedValue = new TimedValue(new AIChatListViewModel(), TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto()), null);
                    Logger logger = Logger.f235387a;
                    if (QLog.isColorLevel()) {
                        logger.d().d("GuildViewModelProvider", 2, "create " + m.a(timedValue.getValue()) + " cost " + Duration.m1875toStringimpl(timedValue.m1981getDurationUwyO8pc()));
                    }
                    return (T) timedValue.getValue();
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final AIChatListViewModel invoke() {
                c.Companion companion = ef1.c.INSTANCE;
                Fragment hostFragment = PageToggleAnimatorPart.this.getHostFragment();
                Intrinsics.checkNotNullExpressionValue(hostFragment, "hostFragment");
                ViewModel viewModel = new ViewModelProvider(hostFragment, new a(hostFragment)).get(AIChatListViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, \u2026k(this) })[T::class.java]");
                return (AIChatListViewModel) viewModel;
            }
        });
        this.aiChatListViewModel = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A9(boolean newChat) {
        Logger.f235387a.d().d("PageToggleAnimatorPart", 1, "[playToggleAnimation] newChat: " + newChat);
        View view = null;
        if (newChat) {
            View view2 = this.chatListView;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("chatListView");
                view2 = null;
            }
            view2.setVisibility(4);
            View view3 = this.emptyView;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("emptyView");
            } else {
                view = view3;
            }
            view.setVisibility(0);
            return;
        }
        View view4 = this.emptyView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emptyView");
            view4 = null;
        }
        view4.setVisibility(4);
        View view5 = this.chatListView;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chatListView");
        } else {
            view = view5;
        }
        view.setVisibility(0);
    }

    private final AIChatListViewModel z9() {
        return (AIChatListViewModel) this.aiChatListViewModel.getValue();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.sfu);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.ai_chat_list)");
        this.chatListView = findViewById;
        View findViewById2 = rootView.findViewById(R.id.f165093uv1);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.empty_view_recycler)");
        this.emptyView = findViewById2;
        final Flow filterNotNull = FlowKt.filterNotNull(z9().Q1());
        Flow onEach = FlowKt.onEach(FlowKt.distinctUntilChangedBy(new Flow<Pair<? extends AiChatSession, ? extends Boolean>>() { // from class: com.tencent.mobileqq.guild.aisearch.parts.PageToggleAnimatorPart$onInitView$$inlined$map$1

            @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\b"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$lambda-1$$inlined$collect$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 1, mv = {1, 7, 1}, xi = 48)
            /* renamed from: com.tencent.mobileqq.guild.aisearch.parts.PageToggleAnimatorPart$onInitView$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes12.dex */
            public static final class AnonymousClass2 implements FlowCollector<AiChatSession> {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ FlowCollector f214214d;

                @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                @DebugMetadata(c = "com.tencent.mobileqq.guild.aisearch.parts.PageToggleAnimatorPart$onInitView$$inlined$map$1$2", f = "PageToggleAnimatorPart.kt", i = {}, l = {136}, m = "emit", n = {}, s = {})
                /* renamed from: com.tencent.mobileqq.guild.aisearch.parts.PageToggleAnimatorPart$onInitView$$inlined$map$1$2$1, reason: invalid class name */
                /* loaded from: classes12.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
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

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.f214214d = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public Object emit(AiChatSession aiChatSession, @NotNull Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    Object coroutine_suspended;
                    int i3;
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
                                FlowCollector flowCollector = this.f214214d;
                                AiChatSession aiChatSession2 = aiChatSession;
                                Pair pair = new Pair(aiChatSession2, Boxing.boxBoolean(Intrinsics.areEqual(aiChatSession2.getSessionState(), i.c.f214153a)));
                                anonymousClass1.label = 1;
                                if (flowCollector.emit(pair, anonymousClass1) == coroutine_suspended) {
                                    return coroutine_suspended;
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
            public Object collect(@NotNull FlowCollector<? super Pair<? extends AiChatSession, ? extends Boolean>> flowCollector, @NotNull Continuation continuation) {
                Object coroutine_suspended;
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (collect == coroutine_suspended) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        }, new Function1<Pair<? extends AiChatSession, ? extends Boolean>, Boolean>() { // from class: com.tencent.mobileqq.guild.aisearch.parts.PageToggleAnimatorPart$onInitView$2
            @NotNull
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Boolean invoke2(@NotNull Pair<AiChatSession, Boolean> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getSecond();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(Pair<? extends AiChatSession, ? extends Boolean> pair) {
                return invoke2((Pair<AiChatSession, Boolean>) pair);
            }
        }), new PageToggleAnimatorPart$onInitView$3(this, null));
        Fragment hostFragment = getHostFragment();
        Intrinsics.checkNotNullExpressionValue(hostFragment, "hostFragment");
        FlowKt.launchIn(onEach, LifecycleOwnerKt.getLifecycleScope(hostFragment));
    }
}
