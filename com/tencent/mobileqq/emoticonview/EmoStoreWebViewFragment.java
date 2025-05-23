package com.tencent.mobileqq.emoticonview;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewConstants;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewTabBarData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ArrowTextPopupWindow;

/* compiled from: P */
/* loaded from: classes12.dex */
public class EmoStoreWebViewFragment extends WebViewFragment implements com.tencent.mobileqq.webview.swift.h, IEmoStoreWebViewFragment {
    static IPatchRedirector $redirector_ = null;
    public static final String BUNDLE_KEY_INTENT = "intent";
    public static final String TAG = "EmoStoreWebViewFragment";
    private ArrowTextPopupWindow mGuidePopupWindow;

    public EmoStoreWebViewFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkURLIsEmoStore() {
        return EmoticonStoreTabEntryUtils.checkURLIsEmoStore(this.mUrl, EmoticonStoreTabEntryUtils.processEmoStoreHomeUrl(IndividuationUrlHelper.getMarketUrl(getQBaseActivity(), "emoji", "")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initTitleButton() {
        if (checkURLIsEmoStore()) {
            getSwiftTitleUI().M.setBackgroundDrawable(new ColorDrawable(-1));
            getSwiftTitleUI().W(-16777216);
            getSwiftTitleUI().f314054i.setTextColor(-16777216);
            getWebTitleBarInterface().jg("my_emoji_clk", "", "black", false, 18, 0, new View.OnClickListener() { // from class: com.tencent.mobileqq.emoticonview.EmoStoreWebViewFragment.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) EmoStoreWebViewFragment.this);
                    }
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    EventCollector.getInstance().onViewClickedBefore(view);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                    } else {
                        QBaseActivity qBaseActivity = EmoStoreWebViewFragment.this.getQBaseActivity();
                        if (qBaseActivity != null) {
                            if (EmoStoreWebViewFragment.this.checkURLIsEmoStore()) {
                                ReportController.r(null, "dc00898", "", "", "0X800B8C8", "0X800B8C8", 0, 0, "", "", "", "");
                            }
                            Intent intent = qBaseActivity.getIntent();
                            ActivityURIRequest activityURIRequest = new ActivityURIRequest(qBaseActivity, RouterConstants.UI_ROUTE_EMOSM_ACTIVITY);
                            activityURIRequest.extra().putInt(VasWebviewConstants.KEY_EMOJIMALL_DETAIL_CHAT_TYPE, intent.getIntExtra(VasWebviewConstants.KEY_EMOJIMALL_DETAIL_CHAT_TYPE, -1));
                            activityURIRequest.extra().putString(VasWebviewConstants.KEY_EMOJIMALL_DETAIL_CHAT_UIN, intent.getStringExtra(VasWebviewConstants.KEY_EMOJIMALL_DETAIL_CHAT_UIN));
                            activityURIRequest.extra().putInt("emojimall_src", intent.getIntExtra("emojimall_src", 1));
                            QRoute.startUri(activityURIRequest);
                        }
                    }
                    EventCollector.getInstance().onViewClicked(view);
                }
            }, null);
            showGuideTips();
        }
    }

    public static EmoStoreWebViewFragment newInstance(Intent intent) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("intent", intent);
        EmoStoreWebViewFragment emoStoreWebViewFragment = new EmoStoreWebViewFragment();
        emoStoreWebViewFragment.setArguments(bundle);
        return emoStoreWebViewFragment;
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoStoreWebViewFragment
    public void doOnEmoStorePageFinshed(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
        } else if (checkURLIsEmoStore() && activity != null) {
            activity.overridePendingTransition(R.anim.f154454a3, R.anim.f154458a7);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webviewplugin.s
    public com.tencent.mobileqq.webview.swift.utils.t getWebViewKernelCallBack() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.webview.swift.utils.t) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new com.tencent.mobileqq.webview.swift.proxy.a(this.webViewSurface) { // from class: com.tencent.mobileqq.emoticonview.EmoStoreWebViewFragment.1
            static IPatchRedirector $redirector_;

            {
                super(r5);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) EmoStoreWebViewFragment.this, (Object) r5);
                }
            }

            @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
            public void onInitTitleBar(Bundle bundle) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) bundle);
                } else {
                    super.onInitTitleBar(bundle);
                    EmoStoreWebViewFragment.this.initTitleButton();
                }
            }
        };
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void initWindowStyleAndAnimation(Activity activity) {
        com.tencent.biz.richframework.compat.f.c(this, activity);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ boolean isSupportScreenShot() {
        return com.tencent.biz.richframework.compat.f.d(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ boolean isWrapContent() {
        return com.tencent.biz.richframework.compat.f.e(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ boolean needImmersive() {
        return com.tencent.biz.richframework.compat.f.f(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ boolean needStatusTrans() {
        return com.tencent.biz.richframework.compat.f.g(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onPreThemeChanged() {
        com.tencent.biz.richframework.compat.f.l(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public /* bridge */ /* synthetic */ boolean overrideFinish() {
        return com.tencent.biz.richframework.compat.f.o(this);
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoStoreWebViewFragment
    public void reportEmoStorePageCloseClickEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else if (checkURLIsEmoStore()) {
            ReportController.r(null, "dc00898", "", "", "0X800B8C7", "0X800B8C7", 0, 0, "", "", "", "");
        }
    }

    protected void showGuideTips() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else if (EmoticonStoreTabEntryUtils.isHasShowedTitleGuide()) {
            QLog.i(TAG, 1, "showGuideTips has show");
        } else {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.emoticonview.EmoStoreWebViewFragment.3
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) EmoStoreWebViewFragment.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    QBaseActivity qBaseActivity = EmoStoreWebViewFragment.this.getQBaseActivity();
                    SwiftIphoneTitleBarUI swiftTitleUI = EmoStoreWebViewFragment.this.getSwiftTitleUI();
                    if (qBaseActivity != null && swiftTitleUI != null && swiftTitleUI.E != null) {
                        try {
                        } catch (Exception e16) {
                            QLog.i(EmoStoreWebViewFragment.TAG, 1, "showGuideTips", e16);
                        }
                        if (!qBaseActivity.isFinishing() && !qBaseActivity.isDestroyed() && !EmoStoreWebViewFragment.this.isDestroyed()) {
                            if (EmoStoreWebViewFragment.this.mGuidePopupWindow == null) {
                                EmoStoreWebViewFragment.this.mGuidePopupWindow = new ArrowTextPopupWindow(qBaseActivity);
                            }
                            if (!EmoStoreWebViewFragment.this.mGuidePopupWindow.isShowing()) {
                                swiftTitleUI.E.post(new Runnable(qBaseActivity, swiftTitleUI) { // from class: com.tencent.mobileqq.emoticonview.EmoStoreWebViewFragment.3.1
                                    static IPatchRedirector $redirector_;
                                    final /* synthetic */ QBaseActivity val$context;
                                    final /* synthetic */ SwiftIphoneTitleBarUI val$titleBarUI;

                                    {
                                        this.val$context = qBaseActivity;
                                        this.val$titleBarUI = swiftTitleUI;
                                        IPatchRedirector iPatchRedirector3 = $redirector_;
                                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                            iPatchRedirector3.redirect((short) 1, this, AnonymousClass3.this, qBaseActivity, swiftTitleUI);
                                        }
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        IPatchRedirector iPatchRedirector3 = $redirector_;
                                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                            iPatchRedirector3.redirect((short) 2, (Object) this);
                                            return;
                                        }
                                        if (!this.val$context.isFinishing() && !this.val$context.isDestroyed() && !EmoStoreWebViewFragment.this.isDestroyed()) {
                                            try {
                                                EmoStoreWebViewFragment.this.mGuidePopupWindow.showAlignRight(this.val$titleBarUI.E, this.val$context.getResources().getString(R.string.zuw));
                                                return;
                                            } catch (Exception e17) {
                                                QLog.i(EmoStoreWebViewFragment.TAG, 1, "showAlignRight", e17);
                                                return;
                                            }
                                        }
                                        QLog.i(EmoStoreWebViewFragment.TAG, 1, "showGuideTips error isFinishing");
                                    }
                                });
                            }
                            EmoticonStoreTabEntryUtils.savaHasTitleGuideShowed();
                            QLog.i(EmoStoreWebViewFragment.TAG, 1, "showGuideTips sava");
                            return;
                        }
                        QLog.i(EmoStoreWebViewFragment.TAG, 1, "showGuideTips error isFinishing");
                        return;
                    }
                    QLog.i(EmoStoreWebViewFragment.TAG, 1, "showGuideTips error");
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, @NonNull Class cls) {
        return ne0.a.c(this, str, cls);
    }

    @Override // com.tencent.mobileqq.webview.swift.h
    public WebViewFragment newInstance(int i3, com.tencent.mobileqq.webview.swift.u uVar, WebViewTabBarData webViewTabBarData, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? newInstance(intent) : (WebViewFragment) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), uVar, webViewTabBarData, intent);
    }
}
