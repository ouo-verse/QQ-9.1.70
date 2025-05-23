package com.tencent.mobileqq.onlinestatus.view.withAvatar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tc2.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 *2\u00020\u0001:\u0001\rB\u000f\u0012\u0006\u0010\u000f\u001a\u00020\f\u00a2\u0006\u0004\b(\u0010)J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\u000f\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0017\u0010\u0015\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010!\u001a\u00020\u001d8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010'\u001a\u00020\"8\u0006\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/view/withAvatar/OnlineStatusLikeWithAvatarBinding;", "", "", "likeType", "", "l", "Lcom/tencent/mobileqq/onlinestatus/viewmodel/i;", "viewModel", "Landroidx/lifecycle/LifecycleOwner;", "owner", "d", "g", "Landroid/view/View;", "a", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroidx/recyclerview/widget/RecyclerView;", "b", "Landroidx/recyclerview/widget/RecyclerView;", "j", "()Landroidx/recyclerview/widget/RecyclerView;", "onlineStatusCardListView", "", "Lcom/tencent/mobileqq/onlinestatus/view/withAvatar/b;", "c", "[Lcom/tencent/mobileqq/onlinestatus/view/withAvatar/b;", "i", "()[Lcom/tencent/mobileqq/onlinestatus/view/withAvatar/b;", "likeViewWrapperArray", "Ltc2/a;", "Lkotlin/Lazy;", "k", "()Ltc2/a;", "snapHelper", "Lcom/tencent/mobileqq/onlinestatus/view/withAvatar/DelayIdleStateUpdateRunnable;", "e", "Lcom/tencent/mobileqq/onlinestatus/view/withAvatar/DelayIdleStateUpdateRunnable;", tl.h.F, "()Lcom/tencent/mobileqq/onlinestatus/view/withAvatar/DelayIdleStateUpdateRunnable;", "delayIdleUpdateRun", "<init>", "(Landroid/view/View;)V", "f", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class OnlineStatusLikeWithAvatarBinding {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public final View rootView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RecyclerView onlineStatusCardListView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.onlinestatus.view.withAvatar.b[] likeViewWrapperArray;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy snapHelper;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final DelayIdleStateUpdateRunnable delayIdleUpdateRun;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/view/withAvatar/OnlineStatusLikeWithAvatarBinding$a;", "", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Lcom/tencent/mobileqq/onlinestatus/view/withAvatar/OnlineStatusLikeWithAvatarBinding;", "a", "<init>", "()V", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.onlinestatus.view.withAvatar.OnlineStatusLikeWithAvatarBinding$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final OnlineStatusLikeWithAvatarBinding a(@NotNull LayoutInflater inflater, @Nullable ViewGroup parent) {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            View root = inflater.inflate(R.layout.fqo, parent);
            Intrinsics.checkNotNullExpressionValue(root, "root");
            return new OnlineStatusLikeWithAvatarBinding(root);
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/onlinestatus/view/withAvatar/OnlineStatusLikeWithAvatarBinding$b", "Ltc2/a$a;", "", "position", "", "a", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class b implements a.InterfaceC11283a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.onlinestatus.viewmodel.i f256680a;

        b(com.tencent.mobileqq.onlinestatus.viewmodel.i iVar) {
            this.f256680a = iVar;
        }

        @Override // tc2.a.InterfaceC11283a
        public void a(int position) {
            com.tencent.mobileqq.onlinestatus.viewmodel.i.Z1(this.f256680a, position, false, false, 6, null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/onlinestatus/view/withAvatar/OnlineStatusLikeWithAvatarBinding$c", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class c extends RecyclerView.OnScrollListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.onlinestatus.viewmodel.i f256682e;

        c(com.tencent.mobileqq.onlinestatus.viewmodel.i iVar) {
            this.f256682e = iVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            ThreadManagerV2.getUIHandlerV2().removeCallbacks(OnlineStatusLikeWithAvatarBinding.this.getDelayIdleUpdateRun());
            if (newState == 0) {
                if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
                    RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                    Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                    LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                    int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
                    if (findFirstVisibleItemPosition == linearLayoutManager.findLastVisibleItemPosition()) {
                        com.tencent.mobileqq.onlinestatus.viewmodel.i.Z1(this.f256682e, findFirstVisibleItemPosition, false, false, 6, null);
                        if (recyclerView.getAdapter() instanceof a) {
                            Object adapter = recyclerView.getAdapter();
                            Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.tencent.mobileqq.onlinestatus.view.withAvatar.IOnlineStatusLikeAdapter");
                            ((a) adapter).A(recyclerView, findFirstVisibleItemPosition);
                        }
                    }
                }
                OnlineStatusLikeWithAvatarBinding.this.getDelayIdleUpdateRun().a(new WeakReference<>(recyclerView));
                ThreadManagerV2.getUIHandlerV2().postDelayed(OnlineStatusLikeWithAvatarBinding.this.getDelayIdleUpdateRun(), 100L);
            }
            if ((recyclerView.getAdapter() instanceof a) && newState != 0) {
                Object adapter2 = recyclerView.getAdapter();
                Intrinsics.checkNotNull(adapter2, "null cannot be cast to non-null type com.tencent.mobileqq.onlinestatus.view.withAvatar.IOnlineStatusLikeAdapter");
                ((a) adapter2).D(recyclerView, newState);
            }
        }
    }

    public OnlineStatusLikeWithAvatarBinding(@NotNull View rootView) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        this.rootView = rootView;
        View findViewById = rootView.findViewById(R.id.f125907nb);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026_online_status_card_list)");
        this.onlineStatusCardListView = (RecyclerView) findViewById;
        com.tencent.mobileqq.onlinestatus.view.withAvatar.b[] bVarArr = {new com.tencent.mobileqq.onlinestatus.view.withAvatar.b(R.id.f126007nl, 1, R.string.f230516zc), new com.tencent.mobileqq.onlinestatus.view.withAvatar.b(R.id.f125917nc, 2, R.string.f230526zd), new com.tencent.mobileqq.onlinestatus.view.withAvatar.b(R.id.f125987nj, 3, R.string.f230416z3), new com.tencent.mobileqq.onlinestatus.view.withAvatar.b(R.id.f125997nk, 4, R.string.f230506zb), new com.tencent.mobileqq.onlinestatus.view.withAvatar.b(R.id.f125927nd, 5, R.string.f230406z2)};
        this.likeViewWrapperArray = bVarArr;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<tc2.a>() { // from class: com.tencent.mobileqq.onlinestatus.view.withAvatar.OnlineStatusLikeWithAvatarBinding$snapHelper$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final tc2.a invoke() {
                return new tc2.a();
            }
        });
        this.snapHelper = lazy;
        this.delayIdleUpdateRun = new DelayIdleStateUpdateRunnable(null);
        for (com.tencent.mobileqq.onlinestatus.view.withAvatar.b bVar : bVarArr) {
            View findViewById2 = this.rootView.findViewById(bVar.getId());
            Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(wrapper.id)");
            bVar.g(findViewById2);
            String string = this.rootView.getContext().getString(bVar.getContentDescriptionRes());
            Intrinsics.checkNotNullExpressionValue(string, "rootView.context.getStri\u2026er.contentDescriptionRes)");
            bVar.f(string);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(int likeType) {
        int i3;
        boolean z16;
        for (com.tencent.mobileqq.onlinestatus.view.withAvatar.b bVar : this.likeViewWrapperArray) {
            View e16 = bVar.e();
            if (bVar.getType() == likeType) {
                i3 = R.drawable.qui_online_status_like_circle_select;
            } else {
                i3 = R.drawable.qui_online_status_like_circle_shadow;
            }
            e16.setBackgroundResource(i3);
            View e17 = bVar.e();
            String a16 = bVar.a();
            if (bVar.getType() == likeType) {
                z16 = true;
            } else {
                z16 = false;
            }
            AccessibilityUtil.x(e17, a16, z16, Button.class.getName());
        }
    }

    public final void d(@NotNull final com.tencent.mobileqq.onlinestatus.viewmodel.i viewModel, @NotNull LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(owner, "owner");
        MutableLiveData<Integer> S1 = viewModel.S1();
        final Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.onlinestatus.view.withAvatar.OnlineStatusLikeWithAvatarBinding$bindData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer num) {
                com.tencent.mobileqq.onlinestatus.viewmodel.i.this.O1();
            }
        };
        S1.observe(owner, new Observer() { // from class: com.tencent.mobileqq.onlinestatus.view.withAvatar.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                OnlineStatusLikeWithAvatarBinding.e(Function1.this, obj);
            }
        });
        MutableLiveData<Integer> Q1 = viewModel.Q1();
        final Function1<Integer, Unit> function12 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.onlinestatus.view.withAvatar.OnlineStatusLikeWithAvatarBinding$bindData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer it) {
                OnlineStatusLikeWithAvatarBinding onlineStatusLikeWithAvatarBinding = OnlineStatusLikeWithAvatarBinding.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                onlineStatusLikeWithAvatarBinding.l(it.intValue());
            }
        };
        Q1.observe(owner, new Observer() { // from class: com.tencent.mobileqq.onlinestatus.view.withAvatar.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                OnlineStatusLikeWithAvatarBinding.f(Function1.this, obj);
            }
        });
    }

    public final void g(@NotNull com.tencent.mobileqq.onlinestatus.viewmodel.i viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        k().a(new b(viewModel));
        this.onlineStatusCardListView.addOnScrollListener(new c(viewModel));
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final DelayIdleStateUpdateRunnable getDelayIdleUpdateRun() {
        return this.delayIdleUpdateRun;
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final com.tencent.mobileqq.onlinestatus.view.withAvatar.b[] getLikeViewWrapperArray() {
        return this.likeViewWrapperArray;
    }

    @NotNull
    /* renamed from: j, reason: from getter */
    public final RecyclerView getOnlineStatusCardListView() {
        return this.onlineStatusCardListView;
    }

    @NotNull
    public final tc2.a k() {
        return (tc2.a) this.snapHelper.getValue();
    }
}
