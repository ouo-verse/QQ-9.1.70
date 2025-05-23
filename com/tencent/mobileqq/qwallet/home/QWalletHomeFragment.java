package com.tencent.mobileqq.qwallet.home;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Process;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Space;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.heytap.databaseengine.model.UserInfo;
import com.qwallet.home.BackendControlPopViewModel;
import com.qwallet.home.NativePopViewModel;
import com.qwallet.home.PopDialog;
import com.qwallet.home.QWalletHomePopViewModel;
import com.qwallet.home.b;
import com.qwallet.protocol.Wallet.pb.QWalletHomePage$GetPopWindowRsp;
import com.qwallet.utils.QWalletUtils;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.utils.GlobalDisplayMetricsManager;
import com.tencent.mobileqq.base.FragmentAnimation;
import com.tencent.mobileqq.base.QWalletBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qui.QUIImmersiveHelper;
import com.tencent.mobileqq.qwallet.ad.AdEvent;
import com.tencent.mobileqq.qwallet.ad.BaseGdtAdView;
import com.tencent.mobileqq.qwallet.consecutivescroller.ConsecutiveScrollerLayout;
import com.tencent.mobileqq.qwallet.home.PullRefreshAppBarLayout;
import com.tencent.mobileqq.qwallet.home.QWalletHomePreviewController;
import com.tencent.mobileqq.qwallet.home.QWalletHomeVipPopVM;
import com.tencent.mobileqq.qwallet.home.pop.QWalletHomeKuiklyPopFragment;
import com.tencent.mobileqq.qwallet.pet.download.PetDownloadManager;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 b2\u00020\u0001:\u0001cB\u0007\u00a2\u0006\u0004\b`\u0010aJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J&\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016J\b\u0010\u0014\u001a\u00020\u0004H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0017\u001a\u00020\tH\u0016J\"\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001e\u001a\u00020\u0004H\u0016J\b\u0010\u001f\u001a\u00020\u0004H\u0002J\b\u0010 \u001a\u00020\u0004H\u0002J\b\u0010!\u001a\u00020\u0004H\u0002J\b\u0010\"\u001a\u00020\u0004H\u0002R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010*\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u001b\u00100\u001a\u00020+8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u001b\u00105\u001a\u0002018FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b2\u0010-\u001a\u0004\b3\u00104R\u001d\u0010:\u001a\u0004\u0018\u0001068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b7\u0010-\u001a\u0004\b8\u00109R\u001d\u0010?\u001a\u0004\u0018\u00010;8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b<\u0010-\u001a\u0004\b=\u0010>R\"\u0010F\u001a\u00020\u000f8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u0016\u0010J\u001a\u00020G8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010N\u001a\u00020K8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010R\u001a\u00020O8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010V\u001a\u00020S8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0018\u0010Z\u001a\u0004\u0018\u00010W8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010]\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010\\R\u0016\u0010_\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010\\\u00a8\u0006d"}, d2 = {"Lcom/tencent/mobileqq/qwallet/home/QWalletHomeFragment;", "Lcom/tencent/mobileqq/base/QWalletBaseFragment;", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "", "isAllowLandscape", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "Lcom/tencent/mobileqq/base/FragmentAnimation;", "getFragmentAnimation", "onBackEvent", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Qh", "Uh", "Fh", "Lh", "Lcom/tencent/mobileqq/qwallet/home/report/d;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/qwallet/home/report/d;", "techReporter", "Lcom/tencent/mobileqq/qwallet/home/report/b;", "D", "Lcom/tencent/mobileqq/qwallet/home/report/b;", "adClickReporter", "Lcom/tencent/mobileqq/qwallet/home/QWalletHomeViewModel;", "E", "Lkotlin/Lazy;", "Oh", "()Lcom/tencent/mobileqq/qwallet/home/QWalletHomeViewModel;", "viewModel", "Lcom/tencent/mobileqq/qwallet/home/QWalletHomeAdViewModel;", UserInfo.SEX_FEMALE, "Mh", "()Lcom/tencent/mobileqq/qwallet/home/QWalletHomeAdViewModel;", "adViewModel", "Lcom/qwallet/home/QWalletHomePopViewModel;", "G", "Nh", "()Lcom/qwallet/home/QWalletHomePopViewModel;", "qwalletPopViewModel", "Lcom/tencent/mobileqq/qwallet/home/QWalletHomeVipPopVM;", "H", "Ph", "()Lcom/tencent/mobileqq/qwallet/home/QWalletHomeVipPopVM;", "vipPopupViewModel", "I", "Landroid/view/View;", "getRootView", "()Landroid/view/View;", "Th", "(Landroid/view/View;)V", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lcom/tencent/mobileqq/qwallet/consecutivescroller/ConsecutiveScrollerLayout;", "J", "Lcom/tencent/mobileqq/qwallet/consecutivescroller/ConsecutiveScrollerLayout;", "scrollerLayout", "Lcom/tencent/mobileqq/qwallet/home/PullRefreshAppBarLayout;", "K", "Lcom/tencent/mobileqq/qwallet/home/PullRefreshAppBarLayout;", "appBarLayout", "Lcom/tencent/mobileqq/qwallet/home/HomeAdView;", "L", "Lcom/tencent/mobileqq/qwallet/home/HomeAdView;", "adView", "Landroid/widget/Space;", "M", "Landroid/widget/Space;", "adViewTopSpace", "Lcom/tencent/mobileqq/qwallet/home/af;", "N", "Lcom/tencent/mobileqq/qwallet/home/af;", "webViewController", "P", "Z", "adDismissed", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "isPreview", "<init>", "()V", BdhLogUtil.LogTag.Tag_Req, "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class QWalletHomeFragment extends QWalletBaseFragment {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.qwallet.home.report.d techReporter = new com.tencent.mobileqq.qwallet.home.report.d();

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.qwallet.home.report.b adClickReporter = new com.tencent.mobileqq.qwallet.home.report.b();

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy adViewModel;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy qwalletPopViewModel;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Lazy vipPopupViewModel;

    /* renamed from: I, reason: from kotlin metadata */
    public View rootView;

    /* renamed from: J, reason: from kotlin metadata */
    private ConsecutiveScrollerLayout scrollerLayout;

    /* renamed from: K, reason: from kotlin metadata */
    private PullRefreshAppBarLayout appBarLayout;

    /* renamed from: L, reason: from kotlin metadata */
    private HomeAdView adView;

    /* renamed from: M, reason: from kotlin metadata */
    private Space adViewTopSpace;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private af webViewController;

    /* renamed from: P, reason: from kotlin metadata */
    private boolean adDismissed;

    /* renamed from: Q, reason: from kotlin metadata */
    private boolean isPreview;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f277965a;

        static {
            int[] iArr = new int[QWalletHomePreviewController.EnumEnterMode.values().length];
            try {
                iArr[QWalletHomePreviewController.EnumEnterMode.PREVIEW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[QWalletHomePreviewController.EnumEnterMode.TOOL_PAGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[QWalletHomePreviewController.EnumEnterMode.NORMAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[QWalletHomePreviewController.EnumEnterMode.NORMAL_WITH_LOADING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f277965a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/qwallet/home/QWalletHomeFragment$c", "Lcom/tencent/mobileqq/qwallet/home/PullRefreshAppBarLayout$b;", "", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class c implements PullRefreshAppBarLayout.b {
        c() {
        }

        @Override // com.tencent.mobileqq.qwallet.home.PullRefreshAppBarLayout.b
        public void a() {
            if (!QWalletHomeFragment.this.adDismissed) {
                QWalletHomeFragment.this.Mh().Q1();
            }
            af afVar = QWalletHomeFragment.this.webViewController;
            boolean z16 = false;
            if (afVar != null && afVar.h()) {
                z16 = true;
            }
            if (!z16) {
                PullRefreshAppBarLayout pullRefreshAppBarLayout = QWalletHomeFragment.this.appBarLayout;
                if (pullRefreshAppBarLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("appBarLayout");
                    pullRefreshAppBarLayout = null;
                }
                pullRefreshAppBarLayout.R(true);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/qwallet/home/QWalletHomeFragment$d", "Lcom/tencent/mobileqq/qwallet/ad/BaseGdtAdView$a;", "Lcom/tencent/mobileqq/qwallet/ad/AdEvent;", "event", "", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class d implements BaseGdtAdView.a {

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes16.dex */
        public /* synthetic */ class a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f277968a;

            static {
                int[] iArr = new int[AdEvent.values().length];
                try {
                    iArr[AdEvent.DISMISS.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[AdEvent.ORIGINAL_EXPOSURE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[AdEvent.VIEW_LAYOUT.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[AdEvent.EXPOSURE_TIMER_TICK.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[AdEvent.STRICT_EXPOSURE.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[AdEvent.CLICK.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                f277968a = iArr;
            }
        }

        d() {
        }

        @Override // com.tencent.mobileqq.qwallet.ad.BaseGdtAdView.a
        public void a(@NotNull AdEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            Space space = null;
            Long l3 = null;
            switch (a.f277968a[event.ordinal()]) {
                case 1:
                    QWalletHomeFragment.this.adDismissed = true;
                    HomeAdView homeAdView = QWalletHomeFragment.this.adView;
                    if (homeAdView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adView");
                        homeAdView = null;
                    }
                    homeAdView.setVisibility(8);
                    Space space2 = QWalletHomeFragment.this.adViewTopSpace;
                    if (space2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adViewTopSpace");
                    } else {
                        space = space2;
                    }
                    space.setVisibility(8);
                    return;
                case 2:
                    QWalletHomeFragment.this.techReporter.e();
                    return;
                case 3:
                    int[] iArr = new int[2];
                    HomeAdView homeAdView2 = QWalletHomeFragment.this.adView;
                    if (homeAdView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adView");
                        homeAdView2 = null;
                    }
                    homeAdView2.getLocationOnScreen(iArr);
                    com.tencent.mobileqq.qwallet.home.report.d dVar = QWalletHomeFragment.this.techReporter;
                    int screenHeight = ViewUtils.getScreenHeight();
                    HomeAdView homeAdView3 = QWalletHomeFragment.this.adView;
                    if (homeAdView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adView");
                        homeAdView3 = null;
                    }
                    dVar.i(screenHeight, homeAdView3.getHeight(), iArr[1]);
                    com.tencent.mobileqq.qwallet.home.report.b.c(QWalletHomeFragment.this.adClickReporter, false, 1, null);
                    return;
                case 4:
                    QWalletHomeAdViewModel Mh = QWalletHomeFragment.this.Mh();
                    Object param = event.getParam();
                    if (param instanceof Long) {
                        l3 = (Long) param;
                    }
                    Mh.P1(l3);
                    return;
                case 5:
                    QWalletHomeFragment.this.techReporter.f();
                    return;
                case 6:
                    QWalletHomeFragment.this.techReporter.d();
                    QWalletHomeFragment.this.adClickReporter.e();
                    return;
                default:
                    return;
            }
        }
    }

    public QWalletHomeFragment() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QWalletHomeViewModel>() { // from class: com.tencent.mobileqq.qwallet.home.QWalletHomeFragment$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final QWalletHomeViewModel invoke() {
                ViewModel viewModel = new ViewModelProvider(QWalletHomeFragment.this).get(QWalletHomeViewModel.class);
                QWalletHomeFragment qWalletHomeFragment = QWalletHomeFragment.this;
                QWalletHomeViewModel qWalletHomeViewModel = (QWalletHomeViewModel) viewModel;
                qWalletHomeViewModel.k2(qWalletHomeFragment.techReporter);
                qWalletHomeFragment.getLifecycle().addObserver(qWalletHomeViewModel);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this).\u2026addObserver(vm)\n        }");
                return qWalletHomeViewModel;
            }
        });
        this.viewModel = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<QWalletHomeAdViewModel>() { // from class: com.tencent.mobileqq.qwallet.home.QWalletHomeFragment$adViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final QWalletHomeAdViewModel invoke() {
                ViewModel viewModel = new ViewModelProvider(QWalletHomeFragment.this).get(QWalletHomeAdViewModel.class);
                QWalletHomeFragment qWalletHomeFragment = QWalletHomeFragment.this;
                QWalletHomeAdViewModel qWalletHomeAdViewModel = (QWalletHomeAdViewModel) viewModel;
                qWalletHomeAdViewModel.S1(qWalletHomeFragment.techReporter);
                qWalletHomeFragment.getLifecycle().addObserver(qWalletHomeAdViewModel);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this).\u2026addObserver(vm)\n        }");
                return qWalletHomeAdViewModel;
            }
        });
        this.adViewModel = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<QWalletHomePopViewModel>() { // from class: com.tencent.mobileqq.qwallet.home.QWalletHomeFragment$qwalletPopViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final QWalletHomePopViewModel invoke() {
                boolean z16;
                z16 = QWalletHomeFragment.this.isPreview;
                if (z16) {
                    return null;
                }
                ViewModel viewModel = new ViewModelProvider(QWalletHomeFragment.this).get(QWalletHomePopViewModel.class);
                QWalletHomeFragment qWalletHomeFragment = QWalletHomeFragment.this;
                QWalletHomePopViewModel qWalletHomePopViewModel = (QWalletHomePopViewModel) viewModel;
                qWalletHomeFragment.getLifecycle().addObserver(qWalletHomePopViewModel);
                qWalletHomePopViewModel.Z1(qWalletHomeFragment);
                return qWalletHomePopViewModel;
            }
        });
        this.qwalletPopViewModel = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<QWalletHomeVipPopVM>() { // from class: com.tencent.mobileqq.qwallet.home.QWalletHomeFragment$vipPopupViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final QWalletHomeVipPopVM invoke() {
                boolean z16;
                z16 = QWalletHomeFragment.this.isPreview;
                if (z16) {
                    return null;
                }
                QWalletHomeVipPopVM qWalletHomeVipPopVM = new QWalletHomeVipPopVM(QWalletHomeFragment.this);
                QWalletHomeFragment.this.getLifecycle().addObserver(qWalletHomeVipPopVM);
                return qWalletHomeVipPopVM;
            }
        });
        this.vipPopupViewModel = lazy4;
    }

    private final void Fh() {
        BackendControlPopViewModel T1;
        LiveData<QWalletHomePage$GetPopWindowRsp> T12;
        final NativePopViewModel U1;
        MutableLiveData<Pair<GdtAd, Long>> L1 = Mh().L1();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Pair<? extends GdtAd, ? extends Long>, Unit> function1 = new Function1<Pair<? extends GdtAd, ? extends Long>, Unit>() { // from class: com.tencent.mobileqq.qwallet.home.QWalletHomeFragment$addDataObservers$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends GdtAd, ? extends Long> pair) {
                invoke2((Pair<? extends GdtAd, Long>) pair);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r7v5, types: [android.widget.Space] */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Pair<? extends GdtAd, Long> pair) {
                HomeAdView homeAdView = QWalletHomeFragment.this.adView;
                HomeAdView homeAdView2 = null;
                if (homeAdView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adView");
                    homeAdView = null;
                }
                boolean d16 = homeAdView.d1(pair.getFirst(), QWalletHomeFragment.this.getActivity());
                QLog.d("QWalletHomeFragment", 2, "addDataObservers: isAdShowed " + d16 + " " + pair.getFirst().getCreativeSize());
                if (d16) {
                    HomeAdView homeAdView3 = QWalletHomeFragment.this.adView;
                    if (homeAdView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adView");
                        homeAdView3 = null;
                    }
                    homeAdView3.setVisibility(0);
                    Space space = QWalletHomeFragment.this.adViewTopSpace;
                    if (space == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adViewTopSpace");
                        space = null;
                    }
                    space.setVisibility(0);
                    HomeAdView homeAdView4 = QWalletHomeFragment.this.adView;
                    if (homeAdView4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adView");
                    } else {
                        homeAdView2 = homeAdView4;
                    }
                    homeAdView2.H0(pair.getFirst(), pair.getSecond());
                    return;
                }
                HomeAdView homeAdView5 = QWalletHomeFragment.this.adView;
                if (homeAdView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adView");
                    homeAdView5 = null;
                }
                homeAdView5.setVisibility(8);
                ?? r75 = QWalletHomeFragment.this.adViewTopSpace;
                if (r75 == 0) {
                    Intrinsics.throwUninitializedPropertyAccessException("adViewTopSpace");
                } else {
                    homeAdView2 = r75;
                }
                homeAdView2.setVisibility(8);
            }
        };
        L1.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.qwallet.home.o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QWalletHomeFragment.Ih(Function1.this, obj);
            }
        });
        QWalletHomePopViewModel Nh = Nh();
        if (Nh != null && (U1 = Nh.U1()) != null) {
            LiveData<NativePopViewModel.PopInfo> W1 = U1.W1();
            LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
            final Function1<NativePopViewModel.PopInfo, Unit> function12 = new Function1<NativePopViewModel.PopInfo, Unit>() { // from class: com.tencent.mobileqq.qwallet.home.QWalletHomeFragment$addDataObservers$2$1

                /* compiled from: P */
                @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/qwallet/home/QWalletHomeFragment$addDataObservers$2$1$a", "Lcom/qwallet/home/b$b;", "", NodeProps.ON_CLICK, "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CLOSE_TYPE, "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
                /* loaded from: classes16.dex */
                public static final class a implements b.InterfaceC0306b {

                    /* renamed from: a, reason: collision with root package name */
                    final /* synthetic */ QWalletHomeFragment f277962a;

                    /* renamed from: b, reason: collision with root package name */
                    final /* synthetic */ NativePopViewModel.PopInfo f277963b;

                    /* renamed from: c, reason: collision with root package name */
                    final /* synthetic */ NativePopViewModel f277964c;

                    a(QWalletHomeFragment qWalletHomeFragment, NativePopViewModel.PopInfo popInfo, NativePopViewModel nativePopViewModel) {
                        this.f277962a = qWalletHomeFragment;
                        this.f277963b = popInfo;
                        this.f277964c = nativePopViewModel;
                    }

                    @Override // com.qwallet.home.b.InterfaceC0306b
                    public void a(@NotNull String closeType) {
                        Intrinsics.checkNotNullParameter(closeType, "closeType");
                        QLog.i("QWalletHomeFragment", 1, "dialog close type: " + closeType);
                        this.f277964c.reportClose();
                    }

                    @Override // com.qwallet.home.b.InterfaceC0306b
                    public void onClick() {
                        com.tencent.mobileqq.qwallet.utils.k.h(this.f277962a.getActivity(), this.f277963b.getJumpUrl());
                        this.f277964c.f2();
                    }
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(NativePopViewModel.PopInfo popInfo) {
                    invoke2(popInfo);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(NativePopViewModel.PopInfo it) {
                    MutableLiveData<QWalletHomeVipPopVM.PopInfo> e26;
                    if (it.i()) {
                        QWalletHomeVipPopVM Ph = QWalletHomeFragment.this.Ph();
                        QWalletHomeVipPopVM.PopInfo value = (Ph == null || (e26 = Ph.e2()) == null) ? null : e26.getValue();
                        if (value == null) {
                            return;
                        }
                        value.n(true);
                        return;
                    }
                    Context context = QWalletHomeFragment.this.getContext();
                    if (context == null) {
                        return;
                    }
                    com.qwallet.home.b hVar = it.h() ? new com.qwallet.home.h(context) : new PopDialog(context);
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    hVar.P(it, new a(QWalletHomeFragment.this, it, U1)).show();
                    U1.g2();
                }
            };
            W1.observe(viewLifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.qwallet.home.p
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QWalletHomeFragment.Jh(Function1.this, obj);
                }
            });
        }
        QWalletHomePopViewModel Nh2 = Nh();
        if (Nh2 != null && (T1 = Nh2.T1()) != null && (T12 = T1.T1()) != null) {
            LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
            final Function1<QWalletHomePage$GetPopWindowRsp, Unit> function13 = new Function1<QWalletHomePage$GetPopWindowRsp, Unit>() { // from class: com.tencent.mobileqq.qwallet.home.QWalletHomeFragment$addDataObservers$3
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(QWalletHomePage$GetPopWindowRsp qWalletHomePage$GetPopWindowRsp) {
                    invoke2(qWalletHomePage$GetPopWindowRsp);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(QWalletHomePage$GetPopWindowRsp qWalletHomePage$GetPopWindowRsp) {
                    int i3 = qWalletHomePage$GetPopWindowRsp.type.get();
                    boolean z16 = true;
                    QLog.i("QWalletHomeFragment", 1, "GetPopWindowRsp: type=" + i3 + ", biz_rsp=" + qWalletHomePage$GetPopWindowRsp.biz_response.get());
                    if (i3 != 1) {
                        return;
                    }
                    String kuiklyActionPageName = qWalletHomePage$GetPopWindowRsp.kuikly_action.get().page_name.get();
                    String str = qWalletHomePage$GetPopWindowRsp.kuikly_action.get().bundle_name.get();
                    QLog.i("QWalletHomeFragment", 1, "GetPopWindowRsp action:kuikly pageName=" + kuiklyActionPageName + ", bundleName=" + str);
                    if (kuiklyActionPageName == null || kuiklyActionPageName.length() == 0) {
                        return;
                    }
                    if (str != null && str.length() != 0) {
                        z16 = false;
                    }
                    if (z16) {
                        return;
                    }
                    QWalletHomePopViewModel.INSTANCE.a();
                    QWalletHomeKuiklyPopFragment.Companion companion = QWalletHomeKuiklyPopFragment.INSTANCE;
                    FragmentActivity requireActivity = QWalletHomeFragment.this.requireActivity();
                    Intrinsics.checkNotNullExpressionValue(kuiklyActionPageName, "kuiklyActionPageName");
                    companion.b(requireActivity, kuiklyActionPageName, str, qWalletHomePage$GetPopWindowRsp.biz_response.get());
                }
            };
            T12.observe(viewLifecycleOwner3, new Observer() { // from class: com.tencent.mobileqq.qwallet.home.q
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QWalletHomeFragment.Kh(Function1.this, obj);
                }
            });
        }
        MediatorLiveData<String> W12 = Oh().W1();
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        final Function1<String, Unit> function14 = new Function1<String, Unit>() { // from class: com.tencent.mobileqq.qwallet.home.QWalletHomeFragment$addDataObservers$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                QWalletHomeFragment.this.techReporter.m(str);
                af afVar = QWalletHomeFragment.this.webViewController;
                if (afVar != null) {
                    final QWalletHomeFragment qWalletHomeFragment = QWalletHomeFragment.this;
                    afVar.d(str, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.qwallet.home.QWalletHomeFragment$addDataObservers$4.1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean z16) {
                            PullRefreshAppBarLayout pullRefreshAppBarLayout = QWalletHomeFragment.this.appBarLayout;
                            if (pullRefreshAppBarLayout == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("appBarLayout");
                                pullRefreshAppBarLayout = null;
                            }
                            pullRefreshAppBarLayout.R(z16);
                        }
                    });
                }
                if (str == null || str.length() == 0) {
                    PullRefreshAppBarLayout pullRefreshAppBarLayout = QWalletHomeFragment.this.appBarLayout;
                    if (pullRefreshAppBarLayout == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("appBarLayout");
                        pullRefreshAppBarLayout = null;
                    }
                    pullRefreshAppBarLayout.M();
                }
            }
        };
        W12.observe(viewLifecycleOwner4, new Observer() { // from class: com.tencent.mobileqq.qwallet.home.r
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QWalletHomeFragment.Gh(Function1.this, obj);
            }
        });
        MutableLiveData<Boolean> X1 = Oh().X1();
        LifecycleOwner viewLifecycleOwner5 = getViewLifecycleOwner();
        final Function1<Boolean, Unit> function15 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.qwallet.home.QWalletHomeFragment$addDataObservers$5
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Boolean bool) {
                if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                    QWalletHomePreviewController qWalletHomePreviewController = QWalletHomePreviewController.f277969a;
                    QWalletHomeFragment qWalletHomeFragment = QWalletHomeFragment.this;
                    qWalletHomePreviewController.e(qWalletHomeFragment, qWalletHomeFragment.getRootView());
                }
            }
        };
        X1.observe(viewLifecycleOwner5, new Observer() { // from class: com.tencent.mobileqq.qwallet.home.s
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QWalletHomeFragment.Hh(Function1.this, obj);
            }
        });
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ih(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Jh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Kh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void Lh() {
        if (com.tencent.mobileqq.qwallet.utils.g.c("qwalley_key_exit_kill_tool", false) && !QWalletHomePreviewController.f277969a.j(this)) {
            SystemMethodProxy.killProcess(Process.myPid());
        }
    }

    private final QWalletHomePopViewModel Nh() {
        return (QWalletHomePopViewModel) this.qwalletPopViewModel.getValue();
    }

    private final void Qh() {
        Resources resources = super.getResources();
        if (resources != null) {
            Configuration configuration = resources.getConfiguration();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            displayMetrics.setTo(GlobalDisplayMetricsManager.sQQDisplayMetrics);
            resources.updateConfiguration(configuration, displayMetrics);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Rh(QWalletHomeFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sendBroadcast(new Intent("com.qwallet.dialog.QWalletLoadingDialog.dismiss"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Sh(HomeToolbar homeToolbar, TopAppsLayout topAppsLayout, QWalletHomeFragment this$0, View view, int i3, int i16, int i17) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(topAppsLayout, "topAppsLayout");
        homeToolbar.m(topAppsLayout);
        if (i17 == 0) {
            PullRefreshAppBarLayout pullRefreshAppBarLayout = this$0.appBarLayout;
            if (pullRefreshAppBarLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("appBarLayout");
                pullRefreshAppBarLayout = null;
            }
            if (pullRefreshAppBarLayout.Q()) {
                HomeAdView homeAdView = this$0.adView;
                if (homeAdView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adView");
                    homeAdView = null;
                }
                homeAdView.c1();
                com.tencent.mobileqq.qwallet.home.report.b.c(this$0.adClickReporter, false, 1, null);
            }
        }
        QWalletHomeVipPopVM Ph = this$0.Ph();
        if (Ph != null) {
            Ph.d2();
        }
    }

    private final void Uh() {
        d dVar = new d();
        HomeAdView homeAdView = this.adView;
        if (homeAdView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adView");
            homeAdView = null;
        }
        homeAdView.setAdEventCallback(dVar);
    }

    @NotNull
    public final QWalletHomeAdViewModel Mh() {
        return (QWalletHomeAdViewModel) this.adViewModel.getValue();
    }

    @NotNull
    public final QWalletHomeViewModel Oh() {
        return (QWalletHomeViewModel) this.viewModel.getValue();
    }

    @Nullable
    public final QWalletHomeVipPopVM Ph() {
        return (QWalletHomeVipPopVM) this.vipPopupViewModel.getValue();
    }

    public final void Th(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.rootView = view;
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment
    @NotNull
    public FragmentAnimation getFragmentAnimation() {
        int i3 = b.f277965a[QWalletHomePreviewController.f277969a.h(this).ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        return FragmentAnimation.IN_NONE_OUT_DEFAULT;
                    }
                    throw new NoWhenBranchMatchedException();
                }
                return FragmentAnimation.IN_NONE_OUT_DEFAULT;
            }
            return FragmentAnimation.FAKE_IN_OUT_TOOL;
        }
        return FragmentAnimation.FAKE_IN_OUT_PREVIEW;
    }

    @NotNull
    public final View getRootView() {
        View view = this.rootView;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
        return null;
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment
    public boolean isAllowLandscape() {
        return true;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        HomeLegacyBizManager.f277929d.q(requestCode, resultCode, data);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        u.m("index.back", "2", String.valueOf(NetConnInfoCenter.getServerTimeMillis()), null, null, 0, 56, null);
        return super.onBackEvent();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        Qh();
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Bundle bundle;
        int i3;
        super.onCreate(savedInstanceState);
        Qh();
        com.tencent.mobileqq.qwallet.home.d.f278053a.h();
        QWalletHomePreviewController qWalletHomePreviewController = QWalletHomePreviewController.f277969a;
        QLog.d("QWalletHomeFragment", 1, "onCreate pageType=" + qWalletHomePreviewController.h(this) + ", isNightMode=" + Oh().getIsNightMode() + ", isElderMode=" + ol2.a.c());
        qWalletHomePreviewController.k(this);
        Intent intent = getIntent();
        if (intent != null) {
            bundle = intent.getExtras();
        } else {
            bundle = null;
        }
        QWalletUtils.r(bundle);
        this.isPreview = qWalletHomePreviewController.j(this);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            if (Oh().getIsNightMode()) {
                i3 = R.style.a6n;
            } else {
                i3 = R.style.a6m;
            }
            activity.setTheme(i3);
            activity.getLifecycle().addObserver(HomeLegacyBizManager.f277929d);
            Window window = activity.getWindow();
            if (window != null) {
                Intrinsics.checkNotNullExpressionValue(window, "window");
                window.addFlags(Integer.MIN_VALUE);
                com.tencent.mobileqq.qwallet.utils.m mVar = com.tencent.mobileqq.qwallet.utils.m.f279290a;
                QBaseActivity qBaseActivity = getQBaseActivity();
                Intrinsics.checkNotNullExpressionValue(qBaseActivity, "qBaseActivity");
                window.setStatusBarColor(mVar.a(qBaseActivity, R.attr.akw));
                ImmersiveUtils.setStatusTextColor(false, window);
            }
        }
        this.techReporter.j(this, true, true);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        if (this.isPreview) {
            inflate = inflater.inflate(R.layout.his, container, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "{\n            inflater.i\u2026ntainer, false)\n        }");
        } else {
            inflate = inflater.inflate(R.layout.hit, container, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "{\n            inflater.i\u2026ntainer, false)\n        }");
        }
        Th(inflate);
        View rootView = getRootView();
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, rootView);
        return rootView;
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        QWalletUtils.w();
        PetDownloadManager.f278805a.n();
        af afVar = this.webViewController;
        if (afVar != null) {
            afVar.e();
        }
        this.techReporter.k(this);
        QWalletHomePreviewController.f277969a.d(this);
        Lh();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        af afVar = this.webViewController;
        if (afVar != null) {
            afVar.f();
        }
        this.adClickReporter.g();
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        af afVar = this.webViewController;
        if (afVar != null) {
            afVar.g();
        }
        this.techReporter.q();
        this.adClickReporter.h();
        QUIImmersiveHelper.s(requireActivity(), true, true);
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        QWalletHomePreviewController qWalletHomePreviewController = QWalletHomePreviewController.f277969a;
        qWalletHomePreviewController.m(this, getRootView());
        View findViewById = view.findViewById(R.id.u5j);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.c\u2026secutive_scroller_layout)");
        this.scrollerLayout = (ConsecutiveScrollerLayout) findViewById;
        View findViewById2 = view.findViewById(R.id.sqk);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.app_bar_layout)");
        this.appBarLayout = (PullRefreshAppBarLayout) findViewById2;
        final TopAppsLayout topAppsLayout = (TopAppsLayout) view.findViewById(R.id.f99705qi);
        topAppsLayout.getLayoutParams().height = com.tencent.mobileqq.util.x.c(getContext(), 120.0f);
        final HomeToolbar homeToolBar = (HomeToolbar) view.findViewById(R.id.xan);
        view.post(new Runnable() { // from class: com.tencent.mobileqq.qwallet.home.m
            @Override // java.lang.Runnable
            public final void run() {
                QWalletHomeFragment.Rh(QWalletHomeFragment.this);
            }
        });
        View findViewById3 = view.findViewById(R.id.scg);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.ad_view)");
        HomeAdView homeAdView = (HomeAdView) findViewById3;
        this.adView = homeAdView;
        com.tencent.mobileqq.qwallet.home.report.b bVar = this.adClickReporter;
        PullRefreshAppBarLayout pullRefreshAppBarLayout = null;
        if (homeAdView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adView");
            homeAdView = null;
        }
        bVar.i(homeAdView);
        View findViewById4 = view.findViewById(R.id.sch);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.ad_view_top_space)");
        this.adViewTopSpace = (Space) findViewById4;
        if (!this.isPreview) {
            af afVar = new af(this, this.techReporter);
            afVar.c(view);
            this.webViewController = afVar;
        }
        Uh();
        ConsecutiveScrollerLayout consecutiveScrollerLayout = this.scrollerLayout;
        if (consecutiveScrollerLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scrollerLayout");
            consecutiveScrollerLayout = null;
        }
        consecutiveScrollerLayout.setOnVerticalScrollChangeListener(new ConsecutiveScrollerLayout.b() { // from class: com.tencent.mobileqq.qwallet.home.n
            @Override // com.tencent.mobileqq.qwallet.consecutivescroller.ConsecutiveScrollerLayout.b
            public final void a(View view2, int i3, int i16, int i17) {
                QWalletHomeFragment.Sh(HomeToolbar.this, topAppsLayout, this, view2, i3, i16, i17);
            }
        });
        PullRefreshAppBarLayout pullRefreshAppBarLayout2 = this.appBarLayout;
        if (pullRefreshAppBarLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appBarLayout");
        } else {
            pullRefreshAppBarLayout = pullRefreshAppBarLayout2;
        }
        pullRefreshAppBarLayout.setPullRefreshListener(new c());
        this.techReporter.r();
        Fh();
        Intrinsics.checkNotNullExpressionValue(homeToolBar, "homeToolBar");
        qWalletHomePreviewController.l(this, homeToolBar);
    }
}
