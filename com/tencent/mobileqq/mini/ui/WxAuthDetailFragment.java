package com.tencent.mobileqq.mini.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.config.business.MiniAppConfProcessor;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.wxmini.api.IWxMiniManager;
import com.tencent.mobileqq.wxsetting.WxMiniBindingLogic;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOStarterApi;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0014J\b\u0010\u0012\u001a\u00020\u0013H\u0014J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0015H\u0016J\u001a\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/mini/ui/WxAuthDetailFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "()V", "mBackBtn", "Landroid/widget/ImageView;", "mDesktopNavbarLayoutRl", "Landroid/widget/RelativeLayout;", "mMiniBindingLogic", "Lcom/tencent/mobileqq/wxsetting/WxMiniBindingLogic;", "mNotificationRootViewLl", "Landroid/widget/LinearLayout;", "mQQMiniAppNotificationRl", "mTitleViewTv", "Landroid/widget/TextView;", "mWechatBindingAndAuthContentView", "Lcom/tencent/mobileqq/mini/ui/WechatBindingAndAuthContentView;", "getContentLayoutId", "", "getLogTag", "", "initWindowStyleAndAnimation", "", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "needStatusTrans", "", MosaicConstants$JsFunction.FUNC_ON_DESTROY, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/view/View;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class WxAuthDetailFragment extends QPublicBaseFragment {
    private ImageView mBackBtn;
    private RelativeLayout mDesktopNavbarLayoutRl;
    private WxMiniBindingLogic mMiniBindingLogic;
    private LinearLayout mNotificationRootViewLl;
    private RelativeLayout mQQMiniAppNotificationRl;
    private TextView mTitleViewTv;
    private WechatBindingAndAuthContentView mWechatBindingAndAuthContentView;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$1(WxAuthDetailFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IAIOStarterApi iAIOStarterApi = (IAIOStarterApi) QRoute.api(IAIOStarterApi.class);
        QBaseActivity qBaseActivity = this$0.getQBaseActivity();
        Intrinsics.checkNotNullExpressionValue(qBaseActivity, "qBaseActivity");
        String b16 = MiniAppConfProcessor.b();
        Intrinsics.checkNotNullExpressionValue(b16, "getAppletsNotificationNickName()");
        String c16 = MiniAppConfProcessor.c();
        Intrinsics.checkNotNullExpressionValue(c16, "getAppletsNotificationUin()");
        iAIOStarterApi.navigateToAIOActivity(qBaseActivity, 114, QzoneConfig.DEFAULT_APPLETS_UID, b16, 67108864, Long.parseLong(c16), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$2(WxAuthDetailFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        WxMiniBindingLogic wxMiniBindingLogic = this$0.mMiniBindingLogic;
        Intrinsics.checkNotNull(wxMiniBindingLogic);
        if (!wxMiniBindingLogic.getMIsUserUnbinded() && ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).hasRecentShowWxMiniTipInfo()) {
            ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).restartRecentShowWxMiniTipInfo();
        }
        this$0.requireActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.dix;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    /* renamed from: getLogTag */
    public String getTAG() {
        return "WxAuthDetailFragment";
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(Activity activity) {
        super.initWindowStyleAndAnimation(activity);
        if (activity instanceof QBaseActivity) {
            QBaseActivity qBaseActivity = (QBaseActivity) activity;
            Window window = qBaseActivity.getWindow();
            window.requestFeature(1);
            window.clearFlags(67108864);
            window.getDecorView().setSystemUiVisibility(1024);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
            qBaseActivity.overridePendingTransition(0, 0);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        return false;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        WxMiniBindingLogic wxMiniBindingLogic = this.mMiniBindingLogic;
        if (wxMiniBindingLogic != null) {
            wxMiniBindingLogic.B();
        }
        QLog.d(getTAG(), 1, "onDestroy!");
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View rootView, Bundle savedInstanceState) {
        int roundToInt;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        ((LinearLayout) rootView.findViewById(R.id.f163691rh3)).setVisibility(0);
        View findViewById = rootView.findViewById(R.id.f163691rh3);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.LinearLayout");
        this.mNotificationRootViewLl = (LinearLayout) findViewById;
        View findViewById2 = rootView.findViewById(R.id.f163692rh4);
        Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type android.widget.RelativeLayout");
        this.mDesktopNavbarLayoutRl = (RelativeLayout) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.rh5);
        Intrinsics.checkNotNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        this.mTitleViewTv = (TextView) findViewById3;
        this.mWechatBindingAndAuthContentView = (WechatBindingAndAuthContentView) rootView.findViewById(R.id.rfe);
        View findViewById4 = rootView.findViewById(R.id.f163689rh1);
        Intrinsics.checkNotNull(findViewById4, "null cannot be cast to non-null type android.widget.ImageView");
        this.mBackBtn = (ImageView) findViewById4;
        WechatBindingAndAuthContentView wechatBindingAndAuthContentView = this.mWechatBindingAndAuthContentView;
        if (wechatBindingAndAuthContentView != null) {
            WxMiniBindingLogic wxMiniBindingLogic = new WxMiniBindingLogic(wechatBindingAndAuthContentView);
            this.mMiniBindingLogic = wxMiniBindingLogic;
            Intrinsics.checkNotNull(wxMiniBindingLogic);
            wxMiniBindingLogic.x(3);
            WxMiniBindingLogic wxMiniBindingLogic2 = this.mMiniBindingLogic;
            Intrinsics.checkNotNull(wxMiniBindingLogic2);
            wxMiniBindingLogic2.w(2);
            WxMiniBindingLogic wxMiniBindingLogic3 = this.mMiniBindingLogic;
            Intrinsics.checkNotNull(wxMiniBindingLogic3);
            wxMiniBindingLogic3.u();
        }
        RelativeLayout relativeLayout = (RelativeLayout) rootView.findViewById(R.id.rdq);
        this.mQQMiniAppNotificationRl = relativeLayout;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.mini.ui.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WxAuthDetailFragment.onViewCreated$lambda$1(WxAuthDetailFragment.this, view);
                }
            });
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, ViewUtils.dpToPx(46.0f));
        roundToInt = MathKt__MathJVMKt.roundToInt(ImmersiveUtils.getStatusBarHeight(getContext()));
        layoutParams.setMargins(0, roundToInt, 0, 0);
        RelativeLayout relativeLayout2 = this.mDesktopNavbarLayoutRl;
        ImageView imageView = null;
        if (relativeLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDesktopNavbarLayoutRl");
            relativeLayout2 = null;
        }
        relativeLayout2.setLayoutParams(layoutParams);
        ImageView imageView2 = this.mBackBtn;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBackBtn");
        } else {
            imageView = imageView2;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.mini.ui.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WxAuthDetailFragment.onViewCreated$lambda$2(WxAuthDetailFragment.this, view);
            }
        });
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, Class cls) {
        return ne0.a.c(this, str, cls);
    }
}
