package com.tencent.mobileqq.addfriend.ui.fornt.verify.part;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.biz.qui.quisecnavbar.BaseAction;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.addfriend.ui.fornt.verify.AddFriendVerifyFragmentForNT;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tR\u001d\u0010\u0011\u001a\u0004\u0018\u00010\f8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u00128FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u001b\u001a\u0004\u0018\u00010\u00178FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/part/AddFriendTitleBarPart;", "Lcom/tencent/biz/richframework/part/Part;", "", "B9", "", "D9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartStart", "", "leftText", "C9", "Landroid/widget/RelativeLayout;", "d", "Lkotlin/Lazy;", "z9", "()Landroid/widget/RelativeLayout;", "titleRoot", "Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;", "e", "x9", "()Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;", "quiSecNavBar", "Lcom/tencent/mobileqq/widget/navbar/NavBarCommon;", "f", "A9", "()Lcom/tencent/mobileqq/widget/navbar/NavBarCommon;", "vg", "<init>", "()V", tl.h.F, "a", "qqaddfriend-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class AddFriendTitleBarPart extends Part {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy titleRoot;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy quiSecNavBar;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy vg;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/part/AddFriendTitleBarPart$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqaddfriend-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.addfriend.ui.fornt.verify.part.AddFriendTitleBarPart$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23936);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AddFriendTitleBarPart() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<RelativeLayout>() { // from class: com.tencent.mobileqq.addfriend.ui.fornt.verify.part.AddFriendTitleBarPart$titleRoot$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AddFriendTitleBarPart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final RelativeLayout invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (RelativeLayout) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    IPartHost partHost = AddFriendTitleBarPart.this.getPartHost();
                    QIphoneTitleBarFragment qIphoneTitleBarFragment = partHost instanceof QIphoneTitleBarFragment ? (QIphoneTitleBarFragment) partHost : null;
                    if (qIphoneTitleBarFragment != null) {
                        return qIphoneTitleBarFragment.titleRoot;
                    }
                    return null;
                }
            });
            this.titleRoot = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<QUISecNavBar>() { // from class: com.tencent.mobileqq.addfriend.ui.fornt.verify.part.AddFriendTitleBarPart$quiSecNavBar$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AddFriendTitleBarPart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final QUISecNavBar invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (QUISecNavBar) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    IPartHost partHost = AddFriendTitleBarPart.this.getPartHost();
                    QIphoneTitleBarFragment qIphoneTitleBarFragment = partHost instanceof QIphoneTitleBarFragment ? (QIphoneTitleBarFragment) partHost : null;
                    if (qIphoneTitleBarFragment != null) {
                        return qIphoneTitleBarFragment.quiSecNavBar;
                    }
                    return null;
                }
            });
            this.quiSecNavBar = lazy2;
            lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<NavBarCommon>() { // from class: com.tencent.mobileqq.addfriend.ui.fornt.verify.part.AddFriendTitleBarPart$vg$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AddFriendTitleBarPart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final NavBarCommon invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (NavBarCommon) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    RelativeLayout z95 = AddFriendTitleBarPart.this.z9();
                    if (z95 != null) {
                        return (NavBarCommon) z95.findViewById(R.id.rlCommenTitle);
                    }
                    return null;
                }
            });
            this.vg = lazy3;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private final void B9() {
        QIphoneTitleBarFragment qIphoneTitleBarFragment;
        ViewGroup.LayoutParams layoutParams;
        IPartHost partHost = getPartHost();
        ViewGroup.LayoutParams layoutParams2 = null;
        if (partHost instanceof QIphoneTitleBarFragment) {
            qIphoneTitleBarFragment = (QIphoneTitleBarFragment) partHost;
        } else {
            qIphoneTitleBarFragment = null;
        }
        if (qIphoneTitleBarFragment != null) {
            qIphoneTitleBarFragment.setTitle(HardCodeUtil.qqStr(R.string.f197254ji));
        }
        if (AppSetting.t(getContext())) {
            RelativeLayout z95 = z9();
            if (z95 != null) {
                z95.setFitsSystemWindows(false);
            }
            RelativeLayout z96 = z9();
            if (z96 != null) {
                z96.setPadding(0, 0, 0, 0);
            }
            NavBarCommon A9 = A9();
            if (A9 != null) {
                layoutParams = A9.getLayoutParams();
            } else {
                layoutParams = null;
            }
            if (layoutParams instanceof ViewGroup.LayoutParams) {
                layoutParams2 = layoutParams;
            }
            int statusBarHeight = ImmersiveUtils.getStatusBarHeight(getContext());
            if (layoutParams2 != null) {
                layoutParams2.height += statusBarHeight;
                NavBarCommon A92 = A9();
                if (A92 != null) {
                    A92.setLayoutParams(layoutParams2);
                }
            }
            NavBarCommon A93 = A9();
            if (A93 != null) {
                A93.setPadding(0, statusBarHeight, 0, 0);
            }
        }
        C9(getActivity().getResources().getString(R.string.j3m));
    }

    private final boolean D9() {
        AddFriendVerifyFragmentForNT addFriendVerifyFragmentForNT;
        IPartHost partHost = getPartHost();
        if (partHost instanceof AddFriendVerifyFragmentForNT) {
            addFriendVerifyFragmentForNT = (AddFriendVerifyFragmentForNT) partHost;
        } else {
            addFriendVerifyFragmentForNT = null;
        }
        if (addFriendVerifyFragmentForNT != null) {
            return addFriendVerifyFragmentForNT.useQUISecNavBar();
        }
        return false;
    }

    @Nullable
    public final NavBarCommon A9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (NavBarCommon) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return (NavBarCommon) this.vg.getValue();
    }

    public final void C9(@Nullable CharSequence leftText) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) leftText);
            return;
        }
        if (!D9()) {
            return;
        }
        QUISecNavBar x95 = x9();
        if (x95 != null) {
            x95.setLeftType(1);
        }
        QUISecNavBar x96 = x9();
        if (x96 != null) {
            x96.setLeftText(leftText);
        }
        QUISecNavBar x97 = x9();
        if (x97 != null) {
            x97.setOnBaseTitleBarClickListener(new Function2<View, BaseAction, Unit>() { // from class: com.tencent.mobileqq.addfriend.ui.fornt.verify.part.AddFriendTitleBarPart$setLeftTitle$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AddFriendTitleBarPart.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(View view, BaseAction baseAction) {
                    invoke2(view, baseAction);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable View view, @NotNull BaseAction baseAction) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) view, (Object) baseAction);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(baseAction, "baseAction");
                    if (baseAction == BaseAction.ACTION_LEFT_TEXT) {
                        IPartHost partHost = AddFriendTitleBarPart.this.getPartHost();
                        BasePartFragment basePartFragment = partHost instanceof BasePartFragment ? (BasePartFragment) partHost : null;
                        if (basePartFragment != null) {
                            basePartFragment.onBackEvent();
                        }
                    }
                }
            });
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStart(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity);
        } else {
            super.onPartStart(activity);
            B9();
        }
    }

    @Nullable
    public final QUISecNavBar x9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (QUISecNavBar) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return (QUISecNavBar) this.quiSecNavBar.getValue();
    }

    @Nullable
    public final RelativeLayout z9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (RelativeLayout) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return (RelativeLayout) this.titleRoot.getValue();
    }
}
