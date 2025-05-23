package com.tencent.mobileqq.troop.teamup.detail.part;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quisecnavbar.BaseAction;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.teamup.detail.vm.TroopTeamUpDetailVM;
import com.tencent.mobileqq.troop.teamup.home.fragment.TroopTeamUpHomeFragment;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u001b\u0010\u000b\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/detail/part/TroopTeamUpDetailTitleBarPart;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "Lcom/tencent/mobileqq/troop/teamup/detail/vm/TroopTeamUpDetailVM;", "d", "Lkotlin/Lazy;", "B9", "()Lcom/tencent/mobileqq/troop/teamup/detail/vm/TroopTeamUpDetailVM;", "detailVM", "Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;", "e", "Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;", "navBar", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopTeamUpDetailTitleBarPart extends Part {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy detailVM;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private QUISecNavBar navBar;

    public TroopTeamUpDetailTitleBarPart() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<TroopTeamUpDetailVM>() { // from class: com.tencent.mobileqq.troop.teamup.detail.part.TroopTeamUpDetailTitleBarPart$detailVM$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopTeamUpDetailTitleBarPart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final TroopTeamUpDetailVM invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (TroopTeamUpDetailVM) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    TroopTeamUpDetailVM.Companion companion = TroopTeamUpDetailVM.INSTANCE;
                    Fragment hostFragment = TroopTeamUpDetailTitleBarPart.this.getHostFragment();
                    Intrinsics.checkNotNullExpressionValue(hostFragment, "hostFragment");
                    return companion.a(hostFragment);
                }
            });
            this.detailVM = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TroopTeamUpDetailVM B9() {
        return (TroopTeamUpDetailVM) this.detailVM.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        QUISecNavBar qUISecNavBar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        if (rootView != null && (qUISecNavBar = (QUISecNavBar) rootView.findViewById(R.id.jo9)) != null) {
            Fragment hostFragment = getHostFragment();
            Intrinsics.checkNotNullExpressionValue(hostFragment, "hostFragment");
            qUISecNavBar.S(hostFragment);
            qUISecNavBar.setLeftType(2);
            qUISecNavBar.setCenterType(1);
            if (B9().h2()) {
                qUISecNavBar.setRightType(1);
                qUISecNavBar.setRightText(qUISecNavBar.getContext().getString(R.string.f235997d6));
            } else {
                qUISecNavBar.setRightType(0);
            }
            qUISecNavBar.setLeftImageRes(R.drawable.qui_chevron_left);
            qUISecNavBar.setCenterText(qUISecNavBar.getContext().getString(R.string.f235847cr));
            com.tencent.mobileqq.troop.teamup.detail.common.a.f298875a.c(qUISecNavBar.g(BaseAction.ACTION_RIGHT_TEXT));
            qUISecNavBar.setOnBaseTitleBarClickListener(new Function2<View, BaseAction, Unit>() { // from class: com.tencent.mobileqq.troop.teamup.detail.part.TroopTeamUpDetailTitleBarPart$onInitView$1$1
                static IPatchRedirector $redirector_;

                @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                /* loaded from: classes19.dex */
                public /* synthetic */ class a {
                    static IPatchRedirector $redirector_;

                    /* renamed from: a, reason: collision with root package name */
                    public static final /* synthetic */ int[] f298898a;

                    static {
                        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55486);
                        $redirector_ = redirector;
                        if (redirector != null && redirector.hasPatch((short) 1)) {
                            redirector.redirect((short) 1);
                            return;
                        }
                        int[] iArr = new int[BaseAction.values().length];
                        try {
                            iArr[BaseAction.ACTION_LEFT_BUTTON.ordinal()] = 1;
                        } catch (NoSuchFieldError unused) {
                        }
                        try {
                            iArr[BaseAction.ACTION_RIGHT_TEXT.ordinal()] = 2;
                        } catch (NoSuchFieldError unused2) {
                        }
                        f298898a = iArr;
                    }
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopTeamUpDetailTitleBarPart.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(View view, BaseAction baseAction) {
                    invoke2(view, baseAction);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull View v3, @NotNull BaseAction action) {
                    TroopTeamUpDetailVM B9;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) v3, (Object) action);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(v3, "v");
                    Intrinsics.checkNotNullParameter(action, "action");
                    int i3 = a.f298898a[action.ordinal()];
                    if (i3 == 1) {
                        TroopTeamUpDetailTitleBarPart.this.getActivity().finish();
                    } else {
                        if (i3 != 2) {
                            return;
                        }
                        TroopTeamUpHomeFragment.Companion companion = TroopTeamUpHomeFragment.INSTANCE;
                        B9 = TroopTeamUpDetailTitleBarPart.this.B9();
                        companion.a(B9.k2());
                    }
                }
            });
            this.navBar = qUISecNavBar;
            LiveData<com.tencent.mobileqq.troop.teamup.detail.vm.data.b> c26 = B9().c2();
            LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
            final Function1<com.tencent.mobileqq.troop.teamup.detail.vm.data.b, Unit> function1 = new Function1<com.tencent.mobileqq.troop.teamup.detail.vm.data.b, Unit>() { // from class: com.tencent.mobileqq.troop.teamup.detail.part.TroopTeamUpDetailTitleBarPart$onInitView$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopTeamUpDetailTitleBarPart.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.troop.teamup.detail.vm.data.b bVar) {
                    invoke2(bVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(com.tencent.mobileqq.troop.teamup.detail.vm.data.b bVar) {
                    QUISecNavBar qUISecNavBar2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) bVar);
                        return;
                    }
                    if (bVar.a() == 10002) {
                        qUISecNavBar2 = TroopTeamUpDetailTitleBarPart.this.navBar;
                        if (qUISecNavBar2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("navBar");
                            qUISecNavBar2 = null;
                        }
                        qUISecNavBar2.setRightType(0);
                    }
                }
            };
            c26.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.teamup.detail.part.o
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    TroopTeamUpDetailTitleBarPart.C9(Function1.this, obj);
                }
            });
        }
    }
}
