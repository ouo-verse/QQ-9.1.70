package com.tencent.mobileqq.troop.troopsquare.home.part;

import android.app.Activity;
import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import com.google.android.material.appbar.AppBarLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.biz.qui.quishimmer.view.QUIShimmerImageView;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.utils.au;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.troopsquare.home.vm.TroopSquareHomeViewModel;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b)\u0010*J \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0002J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0016J\u0012\u0010\u0011\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0012\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016R\u001b\u0010\u0018\u001a\u00020\u00138BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u001b\u0010#\u001a\u00020\u001f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010\u0015\u001a\u0004\b!\u0010\"R\u001b\u0010(\u001a\u00020$8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u0010\u0015\u001a\u0004\b&\u0010'\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsquare/home/part/TroopSquareLoadingPart;", "Lcom/tencent/biz/richframework/part/Part;", "", "showContent", UIJsPlugin.EVENT_SHOW_LOADING, "showFailed", "", "J9", "isShown", "G9", "I9", "H9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartStart", "onPartStop", "Lcom/tencent/mobileqq/troop/troopsquare/home/vm/TroopSquareHomeViewModel;", "d", "Lkotlin/Lazy;", "E9", "()Lcom/tencent/mobileqq/troop/troopsquare/home/vm/TroopSquareHomeViewModel;", "viewModel", "Landroid/widget/RelativeLayout;", "e", "Landroid/widget/RelativeLayout;", "draggableLayout", "f", "loadingLayout", "Lcom/tencent/biz/qui/quishimmer/view/QUIShimmerImageView;", tl.h.F, "D9", "()Lcom/tencent/biz/qui/quishimmer/view/QUIShimmerImageView;", "loadingView", "Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState;", "i", "C9", "()Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState;", "failedView", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopSquareLoadingPart extends Part {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private RelativeLayout draggableLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private RelativeLayout loadingLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy loadingView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy failedView;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0018\u0010\u0006\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0014\u0010\t\u001a\u00028\u00008VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/troop/troopsquare/home/part/TroopSquareLoadingPart$a", "Lkotlin/Lazy;", "", "isInitialized", "d", "Landroidx/lifecycle/ViewModel;", "cached", "a", "()Landroidx/lifecycle/ViewModel;", "value", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class a implements Lazy<TroopSquareHomeViewModel> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private TroopSquareHomeViewModel cached;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Part f301608e;

        public a(Part part) {
            this.f301608e = part;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) part);
            }
        }

        /* JADX WARN: Type inference failed for: r0v4, types: [com.tencent.mobileqq.troop.troopsquare.home.vm.TroopSquareHomeViewModel, androidx.lifecycle.ViewModel, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r0v6, types: [com.tencent.mobileqq.troop.troopsquare.home.vm.TroopSquareHomeViewModel, androidx.lifecycle.ViewModel] */
        @Override // kotlin.Lazy
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TroopSquareHomeViewModel getValue() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (ViewModel) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            TroopSquareHomeViewModel troopSquareHomeViewModel = this.cached;
            Object partHost = this.f301608e.getPartHost();
            Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
            Fragment fragment = (Fragment) partHost;
            if (troopSquareHomeViewModel == null) {
                ViewModelProvider.Factory a16 = com.tencent.mobileqq.troop.homework.common.b.a(fragment);
                ViewModelStore viewModelStore = fragment.get_viewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "fragment.viewModelStore");
                ?? r06 = new ViewModelProvider(viewModelStore, a16).get(TroopSquareHomeViewModel.class);
                this.cached = r06;
                Intrinsics.checkNotNullExpressionValue(r06, "{\n                val fa\u2026          }\n            }");
                return r06;
            }
            return troopSquareHomeViewModel;
        }

        @Override // kotlin.Lazy
        public boolean isInitialized() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            if (this.cached != null) {
                return true;
            }
            return false;
        }
    }

    public TroopSquareLoadingPart() {
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.viewModel = new a(this);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QUIShimmerImageView>() { // from class: com.tencent.mobileqq.troop.troopsquare.home.part.TroopSquareLoadingPart$loadingView$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopSquareLoadingPart.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final QUIShimmerImageView invoke() {
                int screenWidth;
                RelativeLayout relativeLayout;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (QUIShimmerImageView) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                QUIShimmerImageView qUIShimmerImageView = new QUIShimmerImageView(TroopSquareLoadingPart.this.getContext());
                TroopSquareLoadingPart troopSquareLoadingPart = TroopSquareLoadingPart.this;
                qUIShimmerImageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                qUIShimmerImageView.setScaleType(ImageView.ScaleType.MATRIX);
                if (troopSquareLoadingPart.getActivity().getRequestedOrientation() == 0) {
                    screenWidth = ImmersiveUtils.getScreenHeight();
                } else {
                    screenWidth = ImmersiveUtils.getScreenWidth();
                }
                qUIShimmerImageView.setImageResource(R.drawable.lx_);
                Matrix matrix = new Matrix();
                float intrinsicWidth = screenWidth / qUIShimmerImageView.getDrawable().getIntrinsicWidth();
                matrix.setScale(intrinsicWidth, intrinsicWidth);
                qUIShimmerImageView.setImageMatrix(matrix);
                relativeLayout = troopSquareLoadingPart.loadingLayout;
                if (relativeLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("loadingLayout");
                    relativeLayout = null;
                }
                relativeLayout.addView(qUIShimmerImageView);
                return qUIShimmerImageView;
            }
        });
        this.loadingView = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new TroopSquareLoadingPart$failedView$2(this));
        this.failedView = lazy2;
    }

    private final QUIEmptyState C9() {
        return (QUIEmptyState) this.failedView.getValue();
    }

    private final QUIShimmerImageView D9() {
        return (QUIShimmerImageView) this.loadingView.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TroopSquareHomeViewModel E9() {
        return (TroopSquareHomeViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void G9(boolean isShown) {
        RelativeLayout relativeLayout = this.draggableLayout;
        RelativeLayout relativeLayout2 = null;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("draggableLayout");
            relativeLayout = null;
        }
        View findViewById = relativeLayout.findViewById(R.id.d4l);
        Intrinsics.checkNotNullExpressionValue(findViewById, "draggableLayout.findView\u2026View>(R.id.header_layout)");
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        if (layoutParams != null) {
            AppBarLayout.LayoutParams layoutParams2 = (AppBarLayout.LayoutParams) layoutParams;
            layoutParams2.g(isShown ? 1 : 0);
            findViewById.setLayoutParams(layoutParams2);
            RelativeLayout relativeLayout3 = this.draggableLayout;
            if (relativeLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("draggableLayout");
                relativeLayout3 = null;
            }
            View findViewById2 = relativeLayout3.findViewById(R.id.f100185rt);
            Boolean valueOf = Boolean.valueOf(isShown);
            findViewById2.setVisibility(0);
            if (((View) au.a(valueOf, findViewById2)) == null) {
                findViewById2.setVisibility(8);
            }
            RelativeLayout relativeLayout4 = this.draggableLayout;
            if (relativeLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("draggableLayout");
                relativeLayout4 = null;
            }
            View findViewById3 = relativeLayout4.findViewById(R.id.j_7);
            Boolean valueOf2 = Boolean.valueOf(isShown);
            findViewById3.setVisibility(0);
            if (((View) au.a(valueOf2, findViewById3)) == null) {
                findViewById3.setVisibility(8);
            }
            RelativeLayout relativeLayout5 = this.draggableLayout;
            if (relativeLayout5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("draggableLayout");
            } else {
                relativeLayout2 = relativeLayout5;
            }
            View findViewById4 = relativeLayout2.findViewById(R.id.kxy);
            Boolean valueOf3 = Boolean.valueOf(isShown);
            findViewById4.setVisibility(0);
            if (((View) au.a(valueOf3, findViewById4)) == null) {
                findViewById4.setVisibility(8);
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.google.android.material.appbar.AppBarLayout.LayoutParams");
    }

    private final void H9(boolean isShown) {
        QUIEmptyState C9 = C9();
        Boolean valueOf = Boolean.valueOf(isShown);
        C9.setVisibility(0);
        if (((View) au.a(valueOf, C9)) == null) {
            C9.setVisibility(8);
        }
    }

    private final void I9(boolean isShown) {
        QUIShimmerImageView D9 = D9();
        Boolean valueOf = Boolean.valueOf(isShown);
        D9.setVisibility(0);
        if (((View) au.a(valueOf, D9)) == null) {
            D9.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J9(boolean showContent, boolean showLoading, boolean showFailed) {
        G9(showContent);
        I9(showLoading);
        H9(showFailed);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.uln);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.draggable_layout)");
        this.draggableLayout = (RelativeLayout) findViewById;
        View findViewById2 = rootView.findViewById(R.id.loading_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.loading_layout)");
        this.loadingLayout = (RelativeLayout) findViewById2;
        J9(false, true, false);
        LiveData<Boolean> Q1 = E9().Q1();
        LifecycleOwner a16 = com.tencent.mobileqq.troop.troopsetting.part.i.a(this);
        Intrinsics.checkNotNull(a16);
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.troop.troopsquare.home.part.TroopSquareLoadingPart$onInitView$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopSquareLoadingPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(it, "it");
                if (it.booleanValue()) {
                    TroopSquareLoadingPart.this.J9(true, false, false);
                } else {
                    TroopSquareLoadingPart.this.J9(false, false, true);
                }
            }
        };
        Q1.observe(a16, new Observer() { // from class: com.tencent.mobileqq.troop.troopsquare.home.part.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopSquareLoadingPart.F9(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStart(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
        } else {
            super.onPartStart(activity);
            D9().startShimming(null);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStop(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
        } else {
            super.onPartStop(activity);
            D9().stopShimming(null);
        }
    }
}
