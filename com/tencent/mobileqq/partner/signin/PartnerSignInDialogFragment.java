package com.tencent.mobileqq.partner.signin;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.airbnb.lottie.LottieAnimationView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.partner.signin.view.PartnerSignedInCardView;
import com.tencent.mobileqq.partner.signin.view.PartnerUnsignedInCardView;
import com.tencent.mobileqq.util.m;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenFloatingView;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.widget.ToastView;
import com.tencent.util.LoadingUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;

@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 D2\u00020\u0001:\u0001EB\u0017\u0012\u0006\u0010#\u001a\u00020 \u0012\u0006\u0010'\u001a\u00020$\u00a2\u0006\u0004\bB\u0010CJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u001c\u0010\r\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0002J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J$\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u001a\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010\u001c\u001a\u00020\u001b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u0010\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001dH\u0016R\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0018\u00109\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010;\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u00108R\u001b\u0010A\u001a\u00020<8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\u00a8\u0006F"}, d2 = {"Lcom/tencent/mobileqq/partner/signin/PartnerSignInDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "Landroid/view/View;", "Dh", "", ToastView.ICON_LOADING, "", "Nh", "Lcom/tencent/mobileqq/partner/signin/b;", "signInData", "Jh", "frontView", "backView", "Lh", "Mh", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", "floatingView", "Ih", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Landroid/app/Dialog;", "onCreateDialog", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "Landroid/app/Activity;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/partner/signin/i;", "D", "Lcom/tencent/mobileqq/partner/signin/i;", "param", "E", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", "Lcom/tencent/mobileqq/partner/signin/view/PartnerSignedInCardView;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/partner/signin/view/PartnerSignedInCardView;", "signedInLayout", "Lcom/tencent/mobileqq/partner/signin/view/PartnerUnsignedInCardView;", "G", "Lcom/tencent/mobileqq/partner/signin/view/PartnerUnsignedInCardView;", "unsignedInLayout", "Landroid/widget/ImageView;", "H", "Landroid/widget/ImageView;", "loadingIv", "Landroid/widget/FrameLayout;", "I", "Landroid/widget/FrameLayout;", "emptyLayout", "J", "animLayout", "Lcom/tencent/mobileqq/partner/signin/PartnerSignInVM;", "K", "Lkotlin/Lazy;", "Ch", "()Lcom/tencent/mobileqq/partner/signin/PartnerSignInVM;", "viewModel", "<init>", "(Landroid/app/Activity;Lcom/tencent/mobileqq/partner/signin/i;)V", "L", "a", "mutualmark_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class PartnerSignInDialogFragment extends DialogFragment {

    /* renamed from: C, reason: from kotlin metadata */
    private final Activity activity;

    /* renamed from: D, reason: from kotlin metadata */
    private i param;

    /* renamed from: E, reason: from kotlin metadata */
    private QUSHalfScreenFloatingView floatingView;

    /* renamed from: F, reason: from kotlin metadata */
    private PartnerSignedInCardView signedInLayout;

    /* renamed from: G, reason: from kotlin metadata */
    private PartnerUnsignedInCardView unsignedInLayout;

    /* renamed from: H, reason: from kotlin metadata */
    private ImageView loadingIv;

    /* renamed from: I, reason: from kotlin metadata */
    private FrameLayout emptyLayout;

    /* renamed from: J, reason: from kotlin metadata */
    private FrameLayout animLayout;

    /* renamed from: K, reason: from kotlin metadata */
    private final Lazy viewModel;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/partner/signin/PartnerSignInDialogFragment$b", "Lcom/tencent/mobileqq/widget/qus/e;", "Landroid/view/View;", "createContentView", "", "showMode", "mutualmark_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class b extends com.tencent.mobileqq.widget.qus.e {
        b() {
        }

        @Override // com.tencent.mobileqq.widget.qus.d
        /* renamed from: createContentView */
        public View getF52508d() {
            return PartnerSignInDialogFragment.this.Dh();
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int showMode() {
            return 1;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/partner/signin/PartnerSignInDialogFragment$d", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "onAnimationCancel", "mutualmark_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class d extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ LottieAnimationView f257204d;

        d(LottieAnimationView lottieAnimationView) {
            this.f257204d = lottieAnimationView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            this.f257204d.setVisibility(8);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            this.f257204d.setVisibility(8);
        }
    }

    public PartnerSignInDialogFragment(Activity activity, i param) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(param, "param");
        this.activity = activity;
        this.param = param;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.tencent.mobileqq.partner.signin.PartnerSignInDialogFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(PartnerSignInVM.class), new Function0<ViewModelStore>() { // from class: com.tencent.mobileqq.partner.signin.PartnerSignInDialogFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) Function0.this.invoke()).getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, null);
    }

    private final PartnerSignInVM Ch() {
        return (PartnerSignInVM) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View Dh() {
        View inflate = LayoutInflater.from(this.activity).inflate(R.layout.cvy, (ViewGroup) null);
        this.signedInLayout = (PartnerSignedInCardView) inflate.findViewById(R.id.oh6);
        this.unsignedInLayout = (PartnerUnsignedInCardView) inflate.findViewById(R.id.oh5);
        this.loadingIv = (ImageView) inflate.findViewById(R.id.oh8);
        this.emptyLayout = (FrameLayout) inflate.findViewById(R.id.ohd);
        PartnerUnsignedInCardView partnerUnsignedInCardView = this.unsignedInLayout;
        if (partnerUnsignedInCardView != null) {
            partnerUnsignedInCardView.setOnSignInClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.partner.signin.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PartnerSignInDialogFragment.Eh(PartnerSignInDialogFragment.this, view);
                }
            });
        }
        Nh(true);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(activity).inflate(R\u2026LoadingUI(true)\n        }");
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Eh(PartnerSignInDialogFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Ch().O1(this$0.param.a(), this$0.param.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fh(PartnerSignInDialogFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            this$0.dismiss();
        } catch (Exception e16) {
            QLog.e("PartnerSignInDialogFragment", 1, "dismiss error: ", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Gh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Hh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void Ih(QUSHalfScreenFloatingView floatingView) {
        if (BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels > ViewUtils.dpToPx(500.0f)) {
            floatingView.setMaxWidthDp(500);
        } else {
            floatingView.setMaxWidthDp(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Jh(com.tencent.mobileqq.partner.signin.b signInData) {
        String string;
        String str;
        FrameLayout frameLayout = this.emptyLayout;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        FrameLayout frameLayout2 = this.emptyLayout;
        boolean z16 = false;
        if (frameLayout2 != null) {
            frameLayout2.setVisibility(0);
        }
        QUIEmptyState.Builder backgroundColorType = new QUIEmptyState.Builder(getContext()).setImageType(16).setHalfScreenState(true).setBackgroundColorType(0);
        if (signInData != null && signInData.d() == 0 && signInData.i() != 1) {
            z16 = true;
        }
        if (z16) {
            if (signInData == null || (str = signInData.h()) == null) {
                str = "\u642d\u5b50";
            }
            string = "\u7ed1\u5b9a" + str + "\u540e\u5373\u53ef\u6253\u5361";
        } else {
            string = BaseApplication.getContext().getString(R.string.cib);
            Intrinsics.checkNotNullExpressionValue(string, "{\n                      \u2026                        }");
        }
        backgroundColorType.setTitle(string);
        if (z16) {
            backgroundColorType.setButton("\u53bb\u7ed1\u5b9a", new View.OnClickListener() { // from class: com.tencent.mobileqq.partner.signin.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PartnerSignInDialogFragment.Kh(PartnerSignInDialogFragment.this, view);
                }
            });
        }
        QUIEmptyState build = backgroundColorType.build();
        FrameLayout frameLayout3 = this.emptyLayout;
        if (frameLayout3 != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            Unit unit = Unit.INSTANCE;
            frameLayout3.addView(build, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Kh(PartnerSignInDialogFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = this$0.floatingView;
        if (qUSHalfScreenFloatingView != null) {
            qUSHalfScreenFloatingView.t();
        }
        com.tencent.mobileqq.activity.aio.intimate.e.g(this$0.activity, this$0.param.a(), this$0.param.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Mh() {
        FrameLayout frameLayout = this.animLayout;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        LottieAnimationView lottieAnimationView = new LottieAnimationView(this.activity);
        lottieAnimationView.setAnimationFromUrl("https://static-res.qq.com/static-res/partner/boom.json");
        lottieAnimationView.addAnimatorListener(new d(lottieAnimationView));
        FrameLayout frameLayout2 = this.animLayout;
        if (frameLayout2 != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ViewUtils.dpToPx(512.0f), ViewUtils.dpToPx(512.0f));
            layoutParams.gravity = 81;
            Unit unit = Unit.INSTANCE;
            frameLayout2.addView(lottieAnimationView, layoutParams);
        }
        lottieAnimationView.playAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Nh(boolean loading) {
        int i3;
        ImageView imageView = this.loadingIv;
        if (imageView != null) {
            if (loading) {
                imageView.setImageDrawable(LoadingUtil.getLoadingDrawable(this.activity, 2));
                i3 = 0;
            } else {
                imageView.setImageDrawable(null);
                i3 = 8;
            }
            imageView.setVisibility(i3);
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = this.floatingView;
        if (qUSHalfScreenFloatingView != null) {
            qUSHalfScreenFloatingView.L();
            Ih(qUSHalfScreenFloatingView);
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = new Dialog(this.activity, R.style.f173448dl);
        Window window = dialog.getWindow();
        if (window != null) {
            window.requestFeature(1);
            try {
                ImmersiveUtils.clearCoverForStatus(window, true);
            } catch (Exception e16) {
                QLog.e("PartnerSignInDialogFragment", 1, "clearCoverForStatus fail:", e16);
            }
            window.setGravity(80);
            window.setNavigationBarColor(ContextCompat.getColor(this.activity, R.color.qui_common_bg_middle_light));
        }
        return dialog;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = new QUSHalfScreenFloatingView(this.activity);
        qUSHalfScreenFloatingView.setQUSDragFloatController(new b());
        qUSHalfScreenFloatingView.setIsHeightWrapContent(true);
        Ih(qUSHalfScreenFloatingView);
        qUSHalfScreenFloatingView.setOnDismissListener(new QUSBaseHalfScreenFloatingView.l() { // from class: com.tencent.mobileqq.partner.signin.f
            @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.l
            public final void onDismiss() {
                PartnerSignInDialogFragment.Fh(PartnerSignInDialogFragment.this);
            }
        });
        this.floatingView = qUSHalfScreenFloatingView;
        FrameLayout frameLayout = new FrameLayout(this.activity);
        frameLayout.addView(this.floatingView, new ViewGroup.LayoutParams(-1, -1));
        FrameLayout frameLayout2 = new FrameLayout(this.activity);
        this.animLayout = frameLayout2;
        frameLayout.addView(frameLayout2, new ViewGroup.LayoutParams(-1, -1));
        return frameLayout;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Unit unit;
        Intrinsics.checkNotNullParameter(view, "view");
        MutableLiveData<com.tencent.mobileqq.partner.signin.b> M1 = Ch().M1();
        final Function1<com.tencent.mobileqq.partner.signin.b, Unit> function1 = new Function1<com.tencent.mobileqq.partner.signin.b, Unit>() { // from class: com.tencent.mobileqq.partner.signin.PartnerSignInDialogFragment$onViewCreated$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(b bVar) {
                invoke2(bVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(b bVar) {
                i iVar;
                i iVar2;
                i iVar3;
                PartnerUnsignedInCardView partnerUnsignedInCardView;
                PartnerSignedInCardView partnerSignedInCardView;
                PartnerUnsignedInCardView partnerUnsignedInCardView2;
                PartnerSignedInCardView partnerSignedInCardView2;
                PartnerUnsignedInCardView partnerUnsignedInCardView3;
                PartnerSignedInCardView partnerSignedInCardView3;
                i iVar4;
                PartnerSignInDialogFragment.this.Nh(false);
                if (bVar == null || bVar.d() != 0 || bVar.i() != 1) {
                    PartnerSignInDialogFragment.this.Jh(bVar);
                    return;
                }
                iVar = PartnerSignInDialogFragment.this.param;
                iVar.e(bVar);
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                String currentAccountUin = peekAppRuntime != null ? peekAppRuntime.getCurrentAccountUin() : null;
                if (currentAccountUin == null) {
                    currentAccountUin = "";
                }
                boolean z16 = false;
                for (a aVar : bVar.g()) {
                    if (Intrinsics.areEqual(aVar.a(), currentAccountUin)) {
                        z16 = aVar.c();
                    }
                }
                iVar2 = PartnerSignInDialogFragment.this.param;
                String a16 = iVar2.a();
                iVar3 = PartnerSignInDialogFragment.this.param;
                m.PartnerReportData partnerReportData = new m.PartnerReportData("pg_bas_surname_clock_superposed_layer", "em_bas_surname_clock_superposed_layer", "dt_imp", bVar, a16, iVar3.d());
                if (z16) {
                    partnerSignedInCardView2 = PartnerSignInDialogFragment.this.signedInLayout;
                    if (partnerSignedInCardView2 != null) {
                        partnerSignedInCardView2.setVisibility(0);
                    }
                    partnerUnsignedInCardView3 = PartnerSignInDialogFragment.this.unsignedInLayout;
                    if (partnerUnsignedInCardView3 != null) {
                        partnerUnsignedInCardView3.setVisibility(4);
                    }
                    partnerSignedInCardView3 = PartnerSignInDialogFragment.this.signedInLayout;
                    if (partnerSignedInCardView3 != null) {
                        iVar4 = PartnerSignInDialogFragment.this.param;
                        partnerSignedInCardView3.A0(iVar4.a(), partnerReportData);
                        return;
                    }
                    return;
                }
                partnerUnsignedInCardView = PartnerSignInDialogFragment.this.unsignedInLayout;
                if (partnerUnsignedInCardView != null) {
                    partnerUnsignedInCardView.setVisibility(0);
                }
                partnerSignedInCardView = PartnerSignInDialogFragment.this.signedInLayout;
                if (partnerSignedInCardView != null) {
                    partnerSignedInCardView.setVisibility(4);
                }
                partnerUnsignedInCardView2 = PartnerSignInDialogFragment.this.unsignedInLayout;
                if (partnerUnsignedInCardView2 != null) {
                    partnerUnsignedInCardView2.C0(partnerReportData);
                }
            }
        };
        M1.observe(this, new Observer() { // from class: com.tencent.mobileqq.partner.signin.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PartnerSignInDialogFragment.Gh(Function1.this, obj);
            }
        });
        MutableLiveData<com.tencent.mobileqq.partner.signin.b> L1 = Ch().L1();
        final Function1<com.tencent.mobileqq.partner.signin.b, Unit> function12 = new Function1<com.tencent.mobileqq.partner.signin.b, Unit>() { // from class: com.tencent.mobileqq.partner.signin.PartnerSignInDialogFragment$onViewCreated$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(b bVar) {
                invoke2(bVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(b bVar) {
                i iVar;
                PartnerSignedInCardView partnerSignedInCardView;
                PartnerSignedInCardView partnerSignedInCardView2;
                PartnerUnsignedInCardView partnerUnsignedInCardView;
                PartnerSignedInCardView partnerSignedInCardView3;
                i iVar2;
                i iVar3;
                i iVar4;
                if (bVar != null && bVar.d() == 0) {
                    iVar = PartnerSignInDialogFragment.this.param;
                    iVar.e(bVar);
                    partnerSignedInCardView = PartnerSignInDialogFragment.this.signedInLayout;
                    if (partnerSignedInCardView != null) {
                        partnerSignedInCardView.setVisibility(0);
                    }
                    partnerSignedInCardView2 = PartnerSignInDialogFragment.this.signedInLayout;
                    if (partnerSignedInCardView2 != null) {
                        iVar2 = PartnerSignInDialogFragment.this.param;
                        String a16 = iVar2.a();
                        iVar3 = PartnerSignInDialogFragment.this.param;
                        String a17 = iVar3.a();
                        iVar4 = PartnerSignInDialogFragment.this.param;
                        partnerSignedInCardView2.A0(a16, new m.PartnerReportData("pg_bas_surname_clock_superposed_layer", "em_bas_surname_clock_superposed_layer", "dt_imp", bVar, a17, iVar4.d()));
                    }
                    PartnerSignInDialogFragment partnerSignInDialogFragment = PartnerSignInDialogFragment.this;
                    partnerUnsignedInCardView = partnerSignInDialogFragment.unsignedInLayout;
                    partnerSignedInCardView3 = PartnerSignInDialogFragment.this.signedInLayout;
                    partnerSignInDialogFragment.Lh(partnerUnsignedInCardView, partnerSignedInCardView3);
                    PartnerSignInDialogFragment.this.Mh();
                    return;
                }
                QQToast.makeText(BaseApplication.context, 1, "\u6253\u5361\u5931\u8d25", 0).show();
            }
        };
        L1.observe(this, new Observer() { // from class: com.tencent.mobileqq.partner.signin.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PartnerSignInDialogFragment.Hh(Function1.this, obj);
            }
        });
        com.tencent.mobileqq.partner.signin.b c16 = this.param.c();
        if (c16 != null) {
            Ch().P1(c16);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            Ch().N1(this.param.a(), this.param.b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Lh(View frontView, View backView) {
        Resources resources;
        DisplayMetrics displayMetrics;
        if (frontView == null || backView == null) {
            return;
        }
        frontView.setVisibility(0);
        backView.setVisibility(4);
        Context context = getContext();
        float f16 = (context == null || (resources = context.getResources()) == null || (displayMetrics = resources.getDisplayMetrics()) == null) ? 3.0f : displayMetrics.density;
        com.tencent.mobileqq.together.clockin.g gVar = new com.tencent.mobileqq.together.clockin.g(f16, 0.0f, -90.0f, frontView.getWidth() / 2.0f, frontView.getHeight() / 2.0f, 400.0f, true);
        gVar.setDuration(200L);
        gVar.setInterpolator(new AccelerateInterpolator());
        com.tencent.mobileqq.together.clockin.g gVar2 = new com.tencent.mobileqq.together.clockin.g(f16, 90.0f, 0.0f, backView.getWidth() / 2.0f, backView.getHeight() / 2.0f, 400.0f, false);
        gVar2.setDuration(200L);
        gVar2.setInterpolator(new DecelerateInterpolator());
        gVar.setAnimationListener(new c(frontView, backView, gVar2));
        frontView.startAnimation(gVar);
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/partner/signin/PartnerSignInDialogFragment$c", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "mutualmark_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class c implements Animation.AnimationListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f257201d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f257202e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.together.clockin.g f257203f;

        c(View view, View view2, com.tencent.mobileqq.together.clockin.g gVar) {
            this.f257201d = view;
            this.f257202e = view2;
            this.f257203f = gVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f257201d.setVisibility(4);
            this.f257202e.setVisibility(0);
            this.f257202e.startAnimation(this.f257203f);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }
}
