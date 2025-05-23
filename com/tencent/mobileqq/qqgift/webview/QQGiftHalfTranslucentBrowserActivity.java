package com.tencent.mobileqq.qqgift.webview;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.ui.RefreshView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqgift.api.IQQGiftDataStore;
import com.tencent.mobileqq.qqgift.api.IQQGiftManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.an;
import com.tencent.mobileqq.webview.swift.utils.t;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.sdk.WebView;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QQGiftHalfTranslucentBrowserActivity extends QQBrowserActivity {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name */
    private int f265040a0;

    /* renamed from: b0, reason: collision with root package name */
    private int f265041b0;

    /* renamed from: c0, reason: collision with root package name */
    private View f265042c0;

    /* renamed from: d0, reason: collision with root package name */
    private View f265043d0;

    /* renamed from: e0, reason: collision with root package name */
    private View f265044e0;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class QQGiftRechargeBrowserFragment extends WebViewFragment {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        /* loaded from: classes16.dex */
        class a extends com.tencent.mobileqq.webview.swift.proxy.a {
            static IPatchRedirector $redirector_;

            a(t tVar) {
                super(tVar);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQGiftRechargeBrowserFragment.this, (Object) tVar);
                }
            }

            @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
            public void onFinalState(Bundle bundle) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle);
                } else {
                    QQGiftRechargeBrowserFragment.this.onFinalState(bundle, this.webViewKernelCallBack);
                }
            }

            @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
            public void onInitUIContent(Bundle bundle) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
                } else {
                    QQGiftRechargeBrowserFragment.this.onInitUIContent(bundle, this.webViewKernelCallBack);
                }
            }

            @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.z
            public void onReceivedError(WebView webView, int i3, String str, String str2) {
                View Q2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, this, webView, Integer.valueOf(i3), str, str2);
                    return;
                }
                super.onReceivedError(webView, i3, str, str2);
                QLog.e(WebViewFragment.TAG, 1, "onReceivedError errorCode:" + i3 + ", description:" + str + ", failingUrl:" + str2);
                FragmentActivity activity = QQGiftRechargeBrowserFragment.this.getActivity();
                if ((activity instanceof QQGiftHalfTranslucentBrowserActivity) && (Q2 = ((QQGiftHalfTranslucentBrowserActivity) activity).Q2()) != null) {
                    Q2.setVisibility(0);
                    ((TextView) Q2.findViewById(R.id.f107716b6)).setText("\u5145\u503c\u9762\u677f\u62c9\u53d6\u5931\u8d25\n\u8bf7\u91cd\u8fdb\u76f4\u64ad\u95f4\u540e\u5c1d\u8bd5");
                }
            }

            @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.z
            public boolean onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                View Q2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 5, this, webView, sslErrorHandler, sslError)).booleanValue();
                }
                boolean onReceivedSslError = super.onReceivedSslError(webView, sslErrorHandler, sslError);
                QLog.e(WebViewFragment.TAG, 1, "onReceivedSslError errorCode:" + sslError);
                FragmentActivity activity = QQGiftRechargeBrowserFragment.this.getActivity();
                if ((activity instanceof QQGiftHalfTranslucentBrowserActivity) && (Q2 = ((QQGiftHalfTranslucentBrowserActivity) activity).Q2()) != null) {
                    Q2.setVisibility(0);
                    ((TextView) Q2.findViewById(R.id.f107716b6)).setText("\u5145\u503c\u9762\u677f\u62c9\u53d6\u5931\u8d25\n\u8bf7\u91cd\u8fdb\u76f4\u64ad\u95f4\u540e\u5c1d\u8bd5");
                }
                return onReceivedSslError;
            }
        }

        public QQGiftRechargeBrowserFragment() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webviewplugin.s
        public t getWebViewKernelCallBack() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (t) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return new a(this.webViewSurface);
        }

        @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            View onCreateView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                onCreateView = (View) iPatchRedirector.redirect((short) 3, this, layoutInflater, viewGroup, bundle);
            } else {
                onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
                onCreateView.setBackgroundColor(0);
            }
            AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, onCreateView);
            return onCreateView;
        }

        @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
        public void onDestroy() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                super.onDestroy();
                ((IQQGiftDataStore) QRoute.api(IQQGiftDataStore.class)).clear();
            }
        }

        public void onFinalState(Bundle bundle, t tVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) bundle, (Object) tVar);
                return;
            }
            tVar.onFinalState(bundle);
            if (getActivity() != null && getActivity().getIntent() != null && this.intent.getIntExtra("key_dialog_type", -1) != -1) {
                getActivity().getWindow().setFlags(1024, 1024);
                getUIStyleHandler().T.setVisibility(8);
                getUIStyle().f314618a = true;
                an.e(super.getActivity());
                getWebTitleBarInterface().u5(false);
            }
        }

        @TargetApi(11)
        public void onInitUIContent(Bundle bundle, t tVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) bundle, (Object) tVar);
                return;
            }
            getUIStyle().f314622e = 0L;
            getUIStyleHandler().f314499a0 = true;
            getUIStyle().A = true;
            tVar.onInitUIContent(bundle);
            super.getActivity().getWindow().setBackgroundDrawableResource(R.color.ajr);
            if (getUIStyleHandler().S instanceof RefreshView) {
                ((RefreshView) getUIStyleHandler().S).a(false);
            }
            if (getUIStyleHandler().f314500b0 != null) {
                getUIStyleHandler().f314500b0.setVisibility(8);
            }
            if (this.webView.getX5WebViewExtension() != null) {
                try {
                    this.webView.getView().setBackgroundColor(0);
                    this.webView.setBackgroundColor(0);
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            } else {
                this.webView.setBackgroundColor(0);
            }
            this.contentView.setBackgroundColor(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQGiftHalfTranslucentBrowserActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                ((IQQGiftManager) QRoute.api(IQQGiftManager.class)).getSDKImpl(QQGiftHalfTranslucentBrowserActivity.this.f265040a0).f().a(QQGiftHalfTranslucentBrowserActivity.this.f265041b0, false, 9999, "\u7528\u6237\u624b\u52a8\u53d6\u6d88");
                QQGiftHalfTranslucentBrowserActivity.this.T2();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class b implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQGiftHalfTranslucentBrowserActivity.this);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            } else {
                QQGiftHalfTranslucentBrowserActivity.this.f265044e0.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class c implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQGiftHalfTranslucentBrowserActivity.this);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
                return;
            }
            if (QQGiftHalfTranslucentBrowserActivity.this.f265044e0 != null) {
                QQGiftHalfTranslucentBrowserActivity.this.f265044e0.setVisibility(8);
            }
            QQGiftHalfTranslucentBrowserActivity.this.finish();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class d implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQGiftHalfTranslucentBrowserActivity.this);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
            } else if (QQGiftHalfTranslucentBrowserActivity.this.f265043d0 != null) {
                QQGiftHalfTranslucentBrowserActivity.this.f265043d0.setVisibility(8);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            }
        }
    }

    public QQGiftHalfTranslucentBrowserActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f265040a0 = 0;
        this.f265041b0 = 0;
        this.mFragmentClass = QQGiftRechargeBrowserFragment.class;
    }

    private View M2(@NonNull DisplayMetrics displayMetrics, View view, int i3) {
        if (this.f265042c0 == null) {
            View view2 = new View(getApplicationContext());
            this.f265042c0 = view2;
            view2.setId(R.id.f70953mu);
            this.f265042c0.setBackgroundColor(0);
            this.f265042c0.setOnClickListener(new a());
            this.f265042c0.setLayoutParams(new FrameLayout.LayoutParams(-1, displayMetrics.heightPixels - i3));
        }
        return this.f265042c0;
    }

    private TranslateAnimation N2(Animation.AnimationListener animationListener) {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f);
        translateAnimation.setDuration(125L);
        translateAnimation.setAnimationListener(animationListener);
        return translateAnimation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TranslateAnimation P2() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation.setAnimationListener(new b());
        translateAnimation.setDuration(200L);
        return translateAnimation;
    }

    private View R2(ViewParent viewParent, int i3) {
        if (this.f265043d0 == null && (viewParent instanceof ViewGroup)) {
            View inflate = LayoutInflater.from(getApplicationContext()).inflate(R.layout.h8z, (ViewGroup) viewParent, false);
            this.f265043d0 = inflate;
            inflate.setVisibility(8);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, i3);
            layoutParams.gravity = 80;
            this.f265043d0.setLayoutParams(layoutParams);
            this.f265043d0.setBackgroundColor(Color.parseColor("#FF1B1C26"));
        }
        return this.f265043d0;
    }

    public static void S2(Context context, String str, int i3, int i16) {
        Integer num;
        Context context2;
        Bundle bundle = new Bundle();
        bundle.putBoolean("isTransparentTitle", true);
        bundle.putInt("extra_web_recharge_callback_key", i3);
        bundle.putInt("extra_web_open_recharge_process_id_key", MobileQQ.sProcessId);
        bundle.putBoolean(QQBrowserActivity.EXTRA_FINISH_ANIMATION_NONE, true);
        bundle.putInt("extra_web_scene_id_key", i16);
        bundle.putBoolean("hide_more_button", true);
        bundle.putBoolean(IPCConst.KEY_HIDE_LEFT_BUTTON, true);
        bundle.putBoolean("hide_more_button", true);
        if (context instanceof Activity) {
            context2 = context;
            num = null;
        } else {
            num = 268435456;
            context2 = BaseApplication.getContext();
        }
        com.tencent.qqlive.common.webview.a.f(context2, str, bundle, QQGiftHalfTranslucentBrowserActivity.class, null, num);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T2() {
        View view = this.f265044e0;
        if (view != null) {
            view.startAnimation(N2(new c()));
        }
        View view2 = this.f265043d0;
        if (view2 != null && view2.getVisibility() == 0) {
            this.f265043d0.startAnimation(N2(new d()));
        }
    }

    private void U2() {
        View view;
        if (this.f265044e0 != null && (view = this.f265043d0) != null) {
            view.setVisibility(8);
            this.f265044e0.setVisibility(4);
            this.f265044e0.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.qqgift.webview.QQGiftHalfTranslucentBrowserActivity.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQGiftHalfTranslucentBrowserActivity.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (QQGiftHalfTranslucentBrowserActivity.this.f265044e0 != null) {
                        QQGiftHalfTranslucentBrowserActivity.this.f265044e0.startAnimation(QQGiftHalfTranslucentBrowserActivity.this.P2());
                    }
                    if (QQGiftHalfTranslucentBrowserActivity.this.f265043d0 != null) {
                        QQGiftHalfTranslucentBrowserActivity.this.f265043d0.startAnimation(QQGiftHalfTranslucentBrowserActivity.this.P2());
                    }
                }
            }, 100L);
        }
    }

    @Nullable
    public View Q2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f265043d0;
    }

    @Override // com.tencent.mobileqq.activity.QQBrowserActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.mobileqq.activity.QQBrowserActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle)).booleanValue();
        }
        boolean doOnCreate = super.doOnCreate(bundle);
        getWindow().setBackgroundDrawableResource(R.color.chd);
        View findViewById = findViewById(R.id.ae8);
        if (findViewById != null) {
            findViewById.setBackgroundResource(R.color.ajr);
        }
        this.f265044e0 = findViewById(R.id.b9v);
        DisplayMetrics displayMetrics = getApplication().getResources().getDisplayMetrics();
        if (displayMetrics == null) {
            QLog.e("QQGiftHalfTranslucentBrowserActivity", 1, "doOnCreate dm is null");
            return doOnCreate;
        }
        int i3 = (int) (displayMetrics.scaledDensity * 393.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, i3);
        layoutParams.gravity = 80;
        this.f265044e0.setLayoutParams(layoutParams);
        ViewParent parent = this.f265044e0.getParent();
        if (parent instanceof FrameLayout) {
            FrameLayout frameLayout = (FrameLayout) parent;
            frameLayout.addView(M2(displayMetrics, this.f265044e0, i3));
            frameLayout.addView(R2(parent, i3));
        }
        U2();
        return doOnCreate;
    }

    @Override // com.tencent.mobileqq.activity.QQBrowserActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.QQBrowserActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
            return;
        }
        super.onCreate(bundle);
        this.f265040a0 = getIntent().getIntExtra("extra_web_scene_id_key", 0);
        this.f265041b0 = getIntent().getIntExtra("extra_web_recharge_callback_key", 0);
        if (QLog.isColorLevel()) {
            QLog.d("QQGiftHalfTranslucentBrowserActivity", 2, "onCreate sceneId:" + this.f265040a0 + ", callbackKey:" + this.f265041b0);
        }
    }
}
