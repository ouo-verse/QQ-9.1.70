package com.tencent.qqmini.proxyimpl;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.mini.util.StorageUtil;
import com.tencent.mobileqq.mini.utils.MiniAppGlobal;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.vip.diy.common.DIYLottieLoader;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.action.ActionBridge;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.KingCardProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.AppMode;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import cooperation.qzone.widget.QzoneGuideBubbleHelper;

@ProxyService(proxy = KingCardProxy.class)
/* loaded from: classes34.dex */
public class KingCardProxyImpl implements KingCardProxy {

    /* renamed from: a, reason: collision with root package name */
    private final String f347370a = "KingCardProxyImpl";

    /* renamed from: b, reason: collision with root package name */
    private String f347371b = "mini_app_kingcard_guide_";

    /* renamed from: c, reason: collision with root package name */
    private String f347372c;

    /* renamed from: d, reason: collision with root package name */
    private DIYLottieLoader f347373d;

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e() {
        return StorageUtil.getPreference().getBoolean(this.f347371b + BaseApplicationImpl.getApplication().getRuntime().getAccount(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        StorageUtil.getPreference().edit().putBoolean(this.f347371b + BaseApplicationImpl.getApplication().getRuntime().getAccount(), true).apply();
    }

    private boolean g(MiniAppInfo miniAppInfo) {
        AppMode appMode;
        if (!AppNetConnInfo.isMobileConn()) {
            QLog.i("KingCardProxyImpl", 1, "shouldShowKingCardTip network type is wifi + " + AppNetConnInfo.isWifiConn());
            return false;
        }
        if (!((miniAppInfo == null || (appMode = miniAppInfo.appMode) == null || !appMode.isWangKa) ? false : true)) {
            QLog.i("KingCardProxyImpl", 1, "shouldShowKingCardTip\uff0c not wangka app");
            return false;
        }
        int a16 = com.tencent.mobileqq.vip.e.a();
        QLog.i("KingCardProxyImpl", 1, "shouldShowKingCardTip\uff0c king card status = " + a16);
        return a16 == 1;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.KingCardProxy
    public ImageView getCapsuleButtonMoreView(Context context) {
        String str = MiniAppGlobal.KINGCARD_GUIDE_TEXT;
        if (TextUtils.isEmpty(str)) {
            str = context.getResources().getString(R.string.iui);
        }
        this.f347372c = str;
        this.f347373d = new DIYLottieLoader(context);
        this.f347373d.setMemoryCacheSize((int) (sy3.b.a() / 2));
        LottieAnimationView lottieAnimationView = new LottieAnimationView(context);
        lottieAnimationView.setVisibility(0);
        lottieAnimationView.setContentDescription(HardCodeUtil.qqStr(R.string.k7p));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(DisplayUtil.dip2px(context, 40.0f), -1);
        layoutParams.addRule(9, -1);
        lottieAnimationView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        lottieAnimationView.setLayoutParams(layoutParams);
        return lottieAnimationView;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.KingCardProxy
    public boolean showKingCardTips(final IMiniAppContext iMiniAppContext, ImageView imageView) {
        MiniAppInfo miniAppInfo;
        QLog.i("KingCardProxyImpl", 1, "showKingCardTips trigger");
        final Activity attachActivity = iMiniAppContext.getAttachActivity();
        if (attachActivity != null && !attachActivity.isFinishing()) {
            if (!(imageView instanceof LottieAnimationView) || (miniAppInfo = iMiniAppContext.getMiniAppInfo()) == null) {
                return false;
            }
            if (this.f347373d == null) {
                QMLog.w("KingCardProxyImpl", "lottie loader is null");
                return false;
            }
            final LottieAnimationView lottieAnimationView = (LottieAnimationView) imageView;
            if (lottieAnimationView.getVisibility() != 0) {
                QLog.i("KingCardProxyImpl", 1, "showKingCardTips \u5c0f\u7a0b\u5e8f\u5b98\u65b9\u6a21\u5f0f\u4e0b\u662f GONE\u72b6\u6001\uff0c\u4e0d\u9700\u8981\u5c55\u793a");
                return false;
            }
            if (imageView != null && !attachActivity.isFinishing() && g(miniAppInfo)) {
                AppBrandTask.runTaskOnUiThreadIfNot(new Runnable() { // from class: com.tencent.qqmini.proxyimpl.KingCardProxyImpl.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!KingCardProxyImpl.this.e()) {
                            QzoneGuideBubbleHelper.getInstance().showGuideBubble(attachActivity, lottieAnimationView, KingCardProxyImpl.this.f347372c, 1, 14.0f, 5.0d, 10.0d, 3000L, -16578534, false, true, 0, null, 0);
                            KingCardProxyImpl.this.f();
                        } else {
                            QLog.i("KingCardProxyImpl", 1, "showKingCardTips, guide had been showed, not show this time");
                        }
                        lottieAnimationView.addAnimatorListener(new a());
                        if (iMiniAppContext.isMiniGame()) {
                            DIYLottieLoader dIYLottieLoader = KingCardProxyImpl.this.f347373d;
                            LottieAnimationView lottieAnimationView2 = lottieAnimationView;
                            String str = MiniAppGlobal.KINGCARD_GUIDE_DARK_LOTTIE;
                            dIYLottieLoader.fromNetworkWithCacheBitmap(lottieAnimationView2, str, AppConstants.SDCARD_MINIAPP_WANGKA_PATH + str.hashCode() + ".zip", true);
                            return;
                        }
                        DIYLottieLoader dIYLottieLoader2 = KingCardProxyImpl.this.f347373d;
                        LottieAnimationView lottieAnimationView3 = lottieAnimationView;
                        String str2 = MiniAppGlobal.KINGCARD_GUIDE_LOTTIE;
                        dIYLottieLoader2.fromNetworkWithCacheBitmap(lottieAnimationView3, str2, AppConstants.SDCARD_MINIAPP_WANGKA_PATH + str2.hashCode() + ".zip", true);
                    }

                    /* renamed from: com.tencent.qqmini.proxyimpl.KingCardProxyImpl$1$a */
                    /* loaded from: classes34.dex */
                    class a extends com.tencent.mobileqq.widget.f {
                        a() {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                            ActionBridge.UpdateUIActionBridge.updateRedDot(iMiniAppContext);
                        }

                        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            ActionBridge.UpdateUIActionBridge.updateRedDot(iMiniAppContext);
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationRepeat(Animator animator) {
                        }

                        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                        }
                    }
                });
            }
            return true;
        }
        QLog.i("KingCardProxyImpl", 1, "activity is null");
        return false;
    }
}
