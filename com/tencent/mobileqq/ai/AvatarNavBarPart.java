package com.tencent.mobileqq.ai;

import android.view.KeyEvent;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quisecnavbar.BaseAction;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.biz.qui.quisecnavbar.b;
import com.tencent.biz.richframework.part.Part;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.ai.main.AIAvatarMainViewModel;
import com.tencent.mobileqq.pad.SplitViewState;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
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

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u001b\u0010\u000b\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/ai/AvatarNavBarPart;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "Lcom/tencent/mobileqq/ai/main/AIAvatarMainViewModel;", "d", "Lkotlin/Lazy;", "A9", "()Lcom/tencent/mobileqq/ai/main/AIAvatarMainViewModel;", "vm", "Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;", "e", "Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;", "navBar", "<init>", "()V", "f", "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class AvatarNavBarPart extends Part {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy vm;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private QUISecNavBar navBar;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/ai/AvatarNavBarPart$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.ai.AvatarNavBarPart$a, reason: from kotlin metadata */
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

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R\u0014\u0010\u000b\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\n\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/ai/AvatarNavBarPart$b", "Lcom/tencent/biz/qui/quisecnavbar/b;", "", "b", "Landroid/view/View;", "view", "", "a", "", "getDrawable", "()I", "drawable", "d", "drawableInTransparent", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b implements com.tencent.biz.qui.quisecnavbar.b {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AvatarNavBarPart.this);
            }
        }

        @Override // com.tencent.biz.qui.quisecnavbar.b
        public void a(@Nullable View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
                return;
            }
            Integer value = AvatarNavBarPart.this.A9().W1().getValue();
            if (value == null) {
                value = 0;
            }
            AvatarNavBarPart.this.A9().W1().setValue(Integer.valueOf(value.intValue() + 1));
        }

        @Override // com.tencent.biz.qui.quisecnavbar.b
        @NotNull
        public String b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            String string = AvatarNavBarPart.this.getActivity().getString(R.string.cat);
            Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.string.more)");
            return string;
        }

        @Override // com.tencent.biz.qui.quisecnavbar.b
        public boolean c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
            }
            return b.a.a(this);
        }

        @Override // com.tencent.biz.qui.quisecnavbar.b
        public int d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return R.drawable.qui_nav_btm_contact_nor;
        }

        @Override // com.tencent.biz.qui.quisecnavbar.b
        public int getDrawable() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return R.drawable.qui_nav_btm_contact_nor;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21503);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AvatarNavBarPart() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<AIAvatarMainViewModel>() { // from class: com.tencent.mobileqq.ai.AvatarNavBarPart$vm$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AvatarNavBarPart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final AIAvatarMainViewModel invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (AIAvatarMainViewModel) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    AIAvatarMainViewModel.Companion companion = AIAvatarMainViewModel.INSTANCE;
                    Fragment hostFragment = AvatarNavBarPart.this.getHostFragment();
                    Intrinsics.checkNotNullExpressionValue(hostFragment, "hostFragment");
                    return companion.a(hostFragment);
                }
            });
            this.vm = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AIAvatarMainViewModel A9() {
        return (AIAvatarMainViewModel) this.vm.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B9(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        if (rootView == null) {
            return;
        }
        View findViewById = rootView.findViewById(R.id.zm9);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.nav_bar)");
        QUISecNavBar qUISecNavBar = (QUISecNavBar) findViewById;
        this.navBar = qUISecNavBar;
        if (qUISecNavBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navBar");
            qUISecNavBar = null;
        }
        qUISecNavBar.setLeftType(2);
        qUISecNavBar.setLeftImageRes(R.drawable.qui_chevron_left_icon_navigation_02_selector);
        qUISecNavBar.setRightType(2);
        qUISecNavBar.d(new b());
        Fragment hostFragment = getHostFragment();
        Intrinsics.checkNotNullExpressionValue(hostFragment, "hostFragment");
        qUISecNavBar.S(hostFragment);
        qUISecNavBar.setOnBaseTitleBarClickListener(new Function2<View, BaseAction, Unit>() { // from class: com.tencent.mobileqq.ai.AvatarNavBarPart$onInitView$1$2
            static IPatchRedirector $redirector_;

            @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
            /* loaded from: classes10.dex */
            public /* synthetic */ class a {
                static IPatchRedirector $redirector_;

                /* renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f187648a;

                static {
                    IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21449);
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
                    f187648a = iArr;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AvatarNavBarPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(View view, BaseAction baseAction) {
                invoke2(view, baseAction);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View view, @NotNull BaseAction action) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) view, (Object) action);
                    return;
                }
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(action, "action");
                int i3 = a.f187648a[action.ordinal()];
                boolean z16 = true;
                if (i3 == 1) {
                    boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("106189", true);
                    if (isSwitchOn) {
                        boolean z17 = PadUtil.a(AvatarNavBarPart.this.getActivity()) == DeviceType.FOLD;
                        if (com.tencent.mobileqq.pad.e.a() != SplitViewState.STATE_FLAT && (AvatarNavBarPart.this.getActivity() instanceof QPublicFragmentActivity)) {
                            z16 = false;
                        }
                        if (z17 && z16 && isSwitchOn) {
                            AvatarNavBarPart.this.getActivity().onKeyDown(4, new KeyEvent(4, 4));
                            return;
                        } else {
                            AvatarNavBarPart.this.getActivity().finishAfterTransition();
                            return;
                        }
                    }
                    AvatarNavBarPart.this.getActivity().finishAfterTransition();
                }
            }
        });
        qUISecNavBar.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.ai.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AvatarNavBarPart.B9(view);
            }
        });
        qUISecNavBar.findViewById(R.id.f81564ei).setBackgroundResource(R.drawable.qui_common_bg_bottom_light_bg);
    }
}
