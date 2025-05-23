package com.tencent.mobileqq.mini.entry.expDesktop.part;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.config.business.MiniAppConfProcessor;
import com.tencent.mobileqq.mini.entry.expDesktop.mvi.MiniAppExpDesktopUIState;
import com.tencent.mobileqq.mini.ui.WechatBindingAndAuthContentView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.wxsetting.WxMiniBindingLogic;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOStarterApi;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \"2\u00020\u00012\u00020\u0002:\u0001\"B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0014H\u0002J\u0006\u0010\u001b\u001a\u00020\tJ\u0006\u0010\u001c\u001a\u00020\tJ\u0012\u0010\u001d\u001a\u00020\u00142\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010 \u001a\u00020\u0014H\u0002J\b\u0010!\u001a\u00020\u0014H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/part/MiniAppExpDesktopNotificationPart;", "Lcom/tencent/mobileqq/mini/entry/expDesktop/part/MiniAppExpDesktopAbstractPart;", "Landroid/view/View$OnClickListener;", "()V", "mBackBtn", "Landroid/widget/ImageView;", "mDesktopNavbarLayoutRl", "Landroid/widget/RelativeLayout;", "mIsViewInit", "", "mMiniBindingLogic", "Lcom/tencent/mobileqq/wxsetting/WxMiniBindingLogic;", "mNotificationRootViewLl", "Landroid/widget/LinearLayout;", "mQQMiniAppNotificationRl", "mTitleViewTv", "Landroid/widget/TextView;", "mWechatBindingAndAuthContentView", "Lcom/tencent/mobileqq/mini/ui/WechatBindingAndAuthContentView;", "closeSubPage", "", "getLogTag", "", "handleUiState", "uiState", "Lcom/tencent/mobileqq/mini/entry/expDesktop/mvi/MiniAppExpDesktopUIState;", "initView", "isSubPageVisible", "onBackPressed", NodeProps.ON_CLICK, "v", "Landroid/view/View;", "openSubPage", "setLiveDataObserver", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniAppExpDesktopNotificationPart extends MiniAppExpDesktopAbstractPart implements View.OnClickListener {
    private static final String ANIMATION_ALPHA = "alpha";
    private static final long ANIMATION_DURATION = 400;
    private static final String ANIMATION_TRANSLATION_X = "translationX";
    private ImageView mBackBtn;
    private RelativeLayout mDesktopNavbarLayoutRl;
    private boolean mIsViewInit;
    private WxMiniBindingLogic mMiniBindingLogic;
    private LinearLayout mNotificationRootViewLl;
    private RelativeLayout mQQMiniAppNotificationRl;
    private TextView mTitleViewTv;
    private WechatBindingAndAuthContentView mWechatBindingAndAuthContentView;

    private final void closeSubPage() {
        LinearLayout linearLayout = this.mNotificationRootViewLl;
        if (linearLayout != null && linearLayout.getVisibility() == 8) {
            QLog.w(getLogTag(), 1, "closeSubPage but rootView is gone");
            return;
        }
        LinearLayout linearLayout2 = this.mNotificationRootViewLl;
        Intrinsics.checkNotNull(getPartRootView());
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(linearLayout2, ANIMATION_TRANSLATION_X, 0.0f, r5.getWidth());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mNotificationRootViewLl, "alpha", 1.0f, 0.0f);
        ofFloat.setDuration(400L);
        ofFloat2.setDuration(400L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopNotificationPart$closeSubPage$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                LinearLayout linearLayout3;
                WxMiniBindingLogic wxMiniBindingLogic;
                QLog.d(MiniAppExpDesktopNotificationPart.this.getLogTag(), 4, " --rightOutAnim onAnimationRepeat-- ");
                linearLayout3 = MiniAppExpDesktopNotificationPart.this.mNotificationRootViewLl;
                if (linearLayout3 != null) {
                    linearLayout3.setVisibility(8);
                }
                MiniAppExpDesktopNotificationPart.this.getMMiniAppDesktopViewModel().updateSubLayoutOpenState(false);
                wxMiniBindingLogic = MiniAppExpDesktopNotificationPart.this.mMiniBindingLogic;
                if (wxMiniBindingLogic != null) {
                    wxMiniBindingLogic.B();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                QLog.d(MiniAppExpDesktopNotificationPart.this.getLogTag(), 4, " --rightOutAnim onAnimationStart-- ");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
            }
        });
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initView() {
        int roundToInt;
        if (this.mIsViewInit) {
            QLog.i(getLogTag(), 1, "initView is init!");
            return;
        }
        View partRootView = getPartRootView();
        ImageView imageView = null;
        View findViewById = partRootView != null ? partRootView.findViewById(R.id.f163691rh3) : null;
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.LinearLayout");
        this.mNotificationRootViewLl = (LinearLayout) findViewById;
        View partRootView2 = getPartRootView();
        View findViewById2 = partRootView2 != null ? partRootView2.findViewById(R.id.f163692rh4) : null;
        Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type android.widget.RelativeLayout");
        this.mDesktopNavbarLayoutRl = (RelativeLayout) findViewById2;
        View findViewById3 = getPartRootView().findViewById(R.id.rh5);
        Intrinsics.checkNotNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        this.mTitleViewTv = (TextView) findViewById3;
        this.mWechatBindingAndAuthContentView = (WechatBindingAndAuthContentView) getPartRootView().findViewById(R.id.rfe);
        View findViewById4 = getPartRootView().findViewById(R.id.f163689rh1);
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
        }
        RelativeLayout relativeLayout = (RelativeLayout) getPartRootView().findViewById(R.id.rdq);
        this.mQQMiniAppNotificationRl = relativeLayout;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.part.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MiniAppExpDesktopNotificationPart.initView$lambda$2(MiniAppExpDesktopNotificationPart.this, view);
                }
            });
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, ViewUtils.dpToPx(46.0f));
        roundToInt = MathKt__MathJVMKt.roundToInt(ImmersiveUtils.getStatusBarHeight(getContext()));
        layoutParams.setMargins(0, roundToInt, 0, 0);
        RelativeLayout relativeLayout2 = this.mDesktopNavbarLayoutRl;
        if (relativeLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDesktopNavbarLayoutRl");
            relativeLayout2 = null;
        }
        relativeLayout2.setLayoutParams(layoutParams);
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "partHost.hostLifecycleOwner");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), null, null, new MiniAppExpDesktopNotificationPart$initView$3(this, null), 3, null);
        LinearLayout linearLayout = this.mNotificationRootViewLl;
        Intrinsics.checkNotNull(linearLayout);
        linearLayout.setOnClickListener(this);
        ImageView imageView2 = this.mBackBtn;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBackBtn");
        } else {
            imageView = imageView2;
        }
        imageView.setOnClickListener(this);
        this.mIsViewInit = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(MiniAppExpDesktopNotificationPart this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IAIOStarterApi iAIOStarterApi = (IAIOStarterApi) QRoute.api(IAIOStarterApi.class);
        Context context = this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        String b16 = MiniAppConfProcessor.b();
        Intrinsics.checkNotNullExpressionValue(b16, "getAppletsNotificationNickName()");
        String c16 = MiniAppConfProcessor.c();
        Intrinsics.checkNotNullExpressionValue(c16, "getAppletsNotificationUin()");
        iAIOStarterApi.navigateToAIO(context, 114, QzoneConfig.DEFAULT_APPLETS_UID, b16, Long.parseLong(c16), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void openSubPage() {
        LinearLayout linearLayout = this.mNotificationRootViewLl;
        Intrinsics.checkNotNull(getPartRootView());
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(linearLayout, ANIMATION_TRANSLATION_X, r3.getWidth(), 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mNotificationRootViewLl, "alpha", 0.0f, 1.0f);
        ofFloat.setDuration(400L);
        ofFloat2.setDuration(400L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopNotificationPart$openSubPage$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                WxMiniBindingLogic wxMiniBindingLogic;
                WxMiniBindingLogic wxMiniBindingLogic2;
                QLog.d(MiniAppExpDesktopNotificationPart.this.getLogTag(), 4, " --rightInAnim onAnimationRepeat--");
                wxMiniBindingLogic = MiniAppExpDesktopNotificationPart.this.mMiniBindingLogic;
                if (wxMiniBindingLogic != null) {
                    wxMiniBindingLogic.u();
                }
                MiniAppExpDesktopNotificationPart.this.getMMiniAppDesktopViewModel().updateSubLayoutOpenState(true);
                wxMiniBindingLogic2 = MiniAppExpDesktopNotificationPart.this.mMiniBindingLogic;
                if (wxMiniBindingLogic2 != null) {
                    wxMiniBindingLogic2.p();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                LinearLayout linearLayout2;
                QLog.d(MiniAppExpDesktopNotificationPart.this.getLogTag(), 4, " --rightInAnim onAnimationStart-- ");
                linearLayout2 = MiniAppExpDesktopNotificationPart.this.mNotificationRootViewLl;
                if (linearLayout2 == null) {
                    return;
                }
                linearLayout2.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
            }
        });
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setLiveDataObserver$lambda$0(MiniAppExpDesktopNotificationPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LifecycleOwner lifecycleOwner = this$0.getPartHost().getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "partHost.hostLifecycleOwner");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), null, null, new MiniAppExpDesktopNotificationPart$setLiveDataObserver$1$1(this$0, null), 3, null);
        QLog.i(this$0.getLogTag(), 1, "setLiveDataObserver");
    }

    @Override // com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopAbstractPart, com.tencent.biz.richframework.part.Part
    public String getLogTag() {
        return "MiniAppExpDesktopPart.MiniAppExpDesktopNotificationPart";
    }

    @Override // com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopAbstractPart, com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopPartInterface
    public void handleUiState(MiniAppExpDesktopUIState uiState) {
        Intrinsics.checkNotNullParameter(uiState, "uiState");
        QLog.i(getLogTag(), 1, "handleUiState, uiState:" + uiState);
        if (uiState instanceof MiniAppExpDesktopUIState.CloseMiniAppSubPage) {
            closeSubPage();
        }
    }

    public final boolean isSubPageVisible() {
        LinearLayout linearLayout = this.mNotificationRootViewLl;
        return linearLayout != null && linearLayout.getVisibility() == 0;
    }

    public final boolean onBackPressed() {
        if (!isSubPageVisible()) {
            return false;
        }
        closeSubPage();
        return true;
    }

    @Override // com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopAbstractPart, com.tencent.biz.richframework.part.Part
    public /* bridge */ /* synthetic */ void onPartCreate(Activity activity, Bundle bundle) {
        com.tencent.biz.richframework.part.b.a(this, activity, bundle);
    }

    @Override // com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopAbstractPart, com.tencent.biz.richframework.part.Part
    public /* bridge */ /* synthetic */ void onPartPause(Activity activity) {
        com.tencent.biz.richframework.part.b.c(this, activity);
    }

    @Override // com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopAbstractPart, com.tencent.biz.richframework.part.Part
    public /* bridge */ /* synthetic */ void onPartResume(Activity activity) {
        com.tencent.biz.richframework.part.b.d(this, activity);
    }

    @Override // com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopAbstractPart, com.tencent.biz.richframework.part.Part
    public /* bridge */ /* synthetic */ void onPartSaveInstanceState(Activity activity, Bundle bundle) {
        com.tencent.biz.richframework.part.b.e(this, activity, bundle);
    }

    @Override // com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopAbstractPart, com.tencent.biz.richframework.part.Part
    public /* bridge */ /* synthetic */ void onPartStart(Activity activity) {
        com.tencent.biz.richframework.part.b.f(this, activity);
    }

    @Override // com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopAbstractPart, com.tencent.biz.richframework.part.Part
    public /* bridge */ /* synthetic */ void onPartStop(Activity activity) {
        com.tencent.biz.richframework.part.b.g(this, activity);
    }

    @Override // com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopAbstractPart, com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopPartInterface
    public void setLiveDataObserver() {
        if (getPartRootView() == null) {
            QLog.e(getLogTag(), 1, "setLiveDataObserver rootView is null");
        } else {
            getPartRootView().post(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.part.f
                @Override // java.lang.Runnable
                public final void run() {
                    MiniAppExpDesktopNotificationPart.setLiveDataObserver$lambda$0(MiniAppExpDesktopNotificationPart.this);
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        Integer valueOf = v3 != null ? Integer.valueOf(v3.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.f163689rh1) {
            closeSubPage();
        }
    }
}
