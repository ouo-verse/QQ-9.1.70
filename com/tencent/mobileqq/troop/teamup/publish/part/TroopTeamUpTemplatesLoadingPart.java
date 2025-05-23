package com.tencent.mobileqq.troop.teamup.publish.part;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.aio.utils.au;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.teamup.publish.view.TroopTeamUpTemplatesLayout;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.listitem.QUISettingsRecyclerView;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import com.tencent.util.LoadingUtil;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ&\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\u0012\u0010\f\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016R\u001b\u0010\u0012\u001a\u00020\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R#\u0010\u0017\u001a\n \u0013*\u0004\u0018\u00010\n0\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u001c\u001a\u00020\u00188BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/publish/part/TroopTeamUpTemplatesLoadingPart;", "Lcom/tencent/biz/richframework/part/Part;", "", "showContent", UIJsPlugin.EVENT_SHOW_LOADING, "showFailed", "", "E9", "", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/tencent/mobileqq/troop/teamup/publish/vm/d;", "d", "Lkotlin/Lazy;", "A9", "()Lcom/tencent/mobileqq/troop/teamup/publish/vm/d;", "data", "kotlin.jvm.PlatformType", "e", "C9", "()Landroid/view/View;", "loadingView", "Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState;", "f", "B9", "()Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState;", "failedView", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopTeamUpTemplatesLoadingPart extends Part {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy data;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy loadingView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy failedView;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0018\u0010\u0006\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0014\u0010\t\u001a\u00028\u00008VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/troop/teamup/publish/part/TroopTeamUpTemplatesLoadingPart$a", "Lkotlin/Lazy;", "", "isInitialized", "d", "Landroidx/lifecycle/ViewModel;", "cached", "a", "()Landroidx/lifecycle/ViewModel;", "value", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class a implements Lazy<com.tencent.mobileqq.troop.teamup.publish.vm.d> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private com.tencent.mobileqq.troop.teamup.publish.vm.d cached;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Part f299157e;

        public a(Part part) {
            this.f299157e = part;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) part);
            }
        }

        /* JADX WARN: Type inference failed for: r0v4, types: [androidx.lifecycle.ViewModel, java.lang.Object, com.tencent.mobileqq.troop.teamup.publish.vm.d] */
        /* JADX WARN: Type inference failed for: r0v6, types: [androidx.lifecycle.ViewModel, com.tencent.mobileqq.troop.teamup.publish.vm.d] */
        @Override // kotlin.Lazy
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.tencent.mobileqq.troop.teamup.publish.vm.d getValue() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (ViewModel) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            com.tencent.mobileqq.troop.teamup.publish.vm.d dVar = this.cached;
            Object partHost = this.f299157e.getPartHost();
            Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
            Fragment fragment = (Fragment) partHost;
            if (dVar == null) {
                ViewModelProvider.Factory a16 = com.tencent.mobileqq.troop.homework.common.b.a(fragment);
                ViewModelStore viewModelStore = fragment.get_viewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "fragment.viewModelStore");
                ?? r06 = new ViewModelProvider(viewModelStore, a16).get(com.tencent.mobileqq.troop.teamup.publish.vm.d.class);
                this.cached = r06;
                Intrinsics.checkNotNullExpressionValue(r06, "{\n                val fa\u2026          }\n            }");
                return r06;
            }
            return dVar;
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

    public TroopTeamUpTemplatesLoadingPart() {
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.data = new a(this);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.mobileqq.troop.teamup.publish.part.TroopTeamUpTemplatesLoadingPart$loadingView$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopTeamUpTemplatesLoadingPart.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final View invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (View) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                int dip2px = ViewUtils.dip2px(20.0f);
                View partRootView = TroopTeamUpTemplatesLoadingPart.this.getPartRootView();
                Intrinsics.checkNotNull(partRootView, "null cannot be cast to non-null type com.tencent.mobileqq.troop.teamup.publish.view.TroopTeamUpTemplatesLayout");
                TroopTeamUpTemplatesLayout troopTeamUpTemplatesLayout = (TroopTeamUpTemplatesLayout) partRootView;
                View loadingView = LoadingUtil.getLoadingView(TroopTeamUpTemplatesLoadingPart.this.getContext(), dip2px, dip2px, 2);
                ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-2, -2);
                layoutParams.topToBottom = troopTeamUpTemplatesLayout.z0().getId();
                layoutParams.leftToLeft = 0;
                layoutParams.rightToRight = 0;
                layoutParams.bottomToBottom = 0;
                loadingView.setLayoutParams(layoutParams);
                troopTeamUpTemplatesLayout.addView(loadingView);
                return loadingView;
            }
        });
        this.loadingView = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new TroopTeamUpTemplatesLoadingPart$failedView$2(this));
        this.failedView = lazy2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.troop.teamup.publish.vm.d A9() {
        return (com.tencent.mobileqq.troop.teamup.publish.vm.d) this.data.getValue();
    }

    private final QUIEmptyState B9() {
        return (QUIEmptyState) this.failedView.getValue();
    }

    private final View C9() {
        return (View) this.loadingView.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void E9(boolean showContent, boolean showLoading, boolean showFailed) {
        View partRootView = getPartRootView();
        Intrinsics.checkNotNull(partRootView, "null cannot be cast to non-null type com.tencent.mobileqq.troop.teamup.publish.view.TroopTeamUpTemplatesLayout");
        QUISettingsRecyclerView A0 = ((TroopTeamUpTemplatesLayout) partRootView).A0();
        Boolean valueOf = Boolean.valueOf(showContent);
        A0.setVisibility(0);
        if (((View) au.a(valueOf, A0)) == null) {
            A0.setVisibility(8);
        }
        View C9 = C9();
        Boolean valueOf2 = Boolean.valueOf(showLoading);
        C9.setVisibility(0);
        if (((View) au.a(valueOf2, C9)) == null) {
            C9.setVisibility(8);
        }
        QUIEmptyState B9 = B9();
        Boolean valueOf3 = Boolean.valueOf(showFailed);
        B9.setVisibility(0);
        if (((View) au.a(valueOf3, B9)) == null) {
            B9.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void F9(TroopTeamUpTemplatesLoadingPart troopTeamUpTemplatesLoadingPart, boolean z16, boolean z17, boolean z18, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        if ((i3 & 2) != 0) {
            z17 = false;
        }
        if ((i3 & 4) != 0) {
            z18 = false;
        }
        troopTeamUpTemplatesLoadingPart.E9(z16, z17, z18);
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    public String getLogTag() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            str = u.f299181a;
            return str;
        }
        return (String) iPatchRedirector.redirect((short) 2, (Object) this);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        Intrinsics.checkNotNull(rootView, "null cannot be cast to non-null type com.tencent.mobileqq.troop.teamup.publish.view.TroopTeamUpTemplatesLayout");
        MutableLiveData<Boolean> O1 = A9().O1();
        LifecycleOwner a16 = com.tencent.mobileqq.troop.troopsetting.part.i.a(this);
        Intrinsics.checkNotNull(a16);
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.troop.teamup.publish.part.TroopTeamUpTemplatesLoadingPart$onInitView$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopTeamUpTemplatesLoadingPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Boolean bool) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) bool);
                    return;
                }
                if (bool == null) {
                    TroopTeamUpTemplatesLoadingPart.F9(TroopTeamUpTemplatesLoadingPart.this, false, true, false, 5, null);
                } else if (Intrinsics.areEqual(bool, Boolean.FALSE)) {
                    TroopTeamUpTemplatesLoadingPart.F9(TroopTeamUpTemplatesLoadingPart.this, false, false, true, 3, null);
                } else if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                    TroopTeamUpTemplatesLoadingPart.F9(TroopTeamUpTemplatesLoadingPart.this, true, false, false, 6, null);
                }
            }
        };
        O1.observe(a16, new Observer() { // from class: com.tencent.mobileqq.troop.teamup.publish.part.s
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopTeamUpTemplatesLoadingPart.D9(Function1.this, obj);
            }
        });
    }
}
