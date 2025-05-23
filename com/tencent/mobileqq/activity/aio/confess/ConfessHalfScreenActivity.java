package com.tencent.mobileqq.activity.aio.confess;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.api.IPublicAccountWebviewPlugin;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.api.IJsApi;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.component.b;
import com.tencent.mobileqq.webview.swift.component.v;
import com.tencent.mobileqq.webview.swift.utils.t;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.plugins.SensorJsPlugin;
import com.tencent.smtt.sdk.WebView;

/* compiled from: P */
/* loaded from: classes10.dex */
public class ConfessHalfScreenActivity extends QQBrowserActivity {

    /* renamed from: a0, reason: collision with root package name */
    private BroadcastReceiver f178330a0;

    /* renamed from: b0, reason: collision with root package name */
    private int f178331b0 = 0;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class ConfessBrowserFragment extends WebViewFragment {
        private boolean C;
        private int D;

        /* compiled from: P */
        /* loaded from: classes10.dex */
        class a implements b.d {
            a() {
            }

            @Override // com.tencent.mobileqq.webview.swift.component.b.d
            public Object a(int i3) {
                if (i3 != 2) {
                    return null;
                }
                return new c();
            }
        }

        /* compiled from: P */
        /* loaded from: classes10.dex */
        class b extends com.tencent.mobileqq.webview.swift.proxy.a {
            b(t tVar) {
                super(tVar);
            }

            @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
            public void onFinalState(Bundle bundle) {
                super.onFinalState(bundle);
                ConfessBrowserFragment.this.getSwiftTitleUI().X(false);
                ConfessBrowserFragment.this.getUIStyleHandler().T.setVisibility(8);
            }

            @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
            public void onInitUIContent(Bundle bundle) {
                ConfessBrowserFragment.this.getUIStyle().f314622e = 0L;
                super.onInitUIContent(bundle);
                ConfessBrowserFragment.this.getActivity().getWindow().setBackgroundDrawableResource(R.color.ajr);
                if (ConfessBrowserFragment.this.getUIStyleHandler().S instanceof RefreshView) {
                    ((RefreshView) ConfessBrowserFragment.this.getUIStyleHandler().S).a(false);
                }
                if (ConfessBrowserFragment.this.getUIStyleHandler().f314500b0 != null) {
                    ConfessBrowserFragment.this.getUIStyleHandler().f314500b0.setVisibility(8);
                }
                ConfessBrowserFragment.this.contentView.setBackgroundColor(0);
            }

            @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.z
            public void onReceivedError(WebView webView, int i3, String str, String str2) {
                super.onReceivedError(webView, i3, str, str2);
                if (QLog.isColorLevel()) {
                    QLog.d(WebViewFragment.TAG, 2, "ConfessBrowserFragment onReceivedError = ");
                }
                ConfessBrowserFragment.this.C = true;
                if (ConfessBrowserFragment.this.getActivity() != null) {
                    ConfessBrowserFragment.this.getActivity().finish();
                }
            }
        }

        /* compiled from: P */
        /* loaded from: classes10.dex */
        class c extends v {

            /* compiled from: P */
            /* loaded from: classes10.dex */
            class a implements View.OnClickListener {
                a() {
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    EventCollector.getInstance().onViewClickedBefore(view);
                    ConfessBrowserFragment.this.getHostActivity().finish();
                    EventCollector.getInstance().onViewClicked(view);
                }
            }

            c() {
            }

            @Override // com.tencent.mobileqq.webview.swift.component.v
            public void D() {
                if (this.f314441d.getWebView() != null) {
                    WebView webView = this.f314441d.getWebView();
                    webView.setId(R.id.webview);
                    int i3 = this.f314502d0;
                    if (i3 != 1) {
                        webView.setBackgroundColor(i3);
                    }
                    Activity activity = (Activity) webView.getContext();
                    if (activity instanceof ConfessHalfScreenActivity) {
                        ConfessBrowserFragment.this.D = ((ConfessHalfScreenActivity) activity).f178331b0;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i("SwiftBrowserUIStyleHandler", 2, "initWebViewInContentView height=" + ConfessBrowserFragment.this.D);
                    }
                    ViewGroup viewGroup = this.S;
                    if (viewGroup instanceof RelativeLayout) {
                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, ConfessBrowserFragment.this.D);
                        layoutParams.addRule(12);
                        this.S.addView(webView, 0, layoutParams);
                    } else {
                        viewGroup.addView(webView, 0, new ViewGroup.LayoutParams(-1, ConfessBrowserFragment.this.D));
                    }
                    this.S.setOnClickListener(new a());
                }
            }
        }

        @Override // com.tencent.mobileqq.webview.swift.WebViewFragment
        public com.tencent.mobileqq.webview.swift.component.b createComponentsProvider() {
            return new com.tencent.mobileqq.webview.swift.component.b(this, 1023, new a());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.webview.swift.WebViewFragment
        public boolean doOnCreate(Bundle bundle) {
            if (QLog.isColorLevel()) {
                QLog.d(WebViewFragment.TAG, 2, "ConfessBrowserFragment doOnCreate = ");
            }
            boolean doOnCreate = super.doOnCreate(bundle);
            TouchWebView touchWebView = this.webView;
            if (touchWebView != null && touchWebView.getPluginEngine() != null) {
                this.webView.getPluginEngine().D(new String[]{((IJsApi) QRoute.api(IJsApi.class)).getConfessPluginNameSpace(), ((IJsApi) QRoute.api(IJsApi.class)).getWebViewJumpPluginNameSpace(), ((IJsApi) QRoute.api(IJsApi.class)).getQQApiPluginNameSpace(), SensorJsPlugin.SENSOR_INTERVAL_UI, "share", IPublicAccountWebviewPlugin.NAME_SPACE});
            }
            return doOnCreate;
        }

        @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webviewplugin.s
        public t getWebViewKernelCallBack() {
            return new b(this.webViewSurface);
        }

        @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
        public void onDestroy() {
            super.onDestroy();
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("com.tencent.mobileqq.action.ACTION_CONFESS_FINISH_EVENT".equals(intent.getAction())) {
                if (QLog.isColorLevel()) {
                    QLog.d(QQBrowserActivity.TAG, 2, "Confess finish action! ");
                }
                ConfessHalfScreenActivity.this.finish();
            }
        }
    }

    public ConfessHalfScreenActivity() {
        this.mFragmentClass = ConfessBrowserFragment.class;
    }

    public static void H2() {
        BaseApplication.getContext().sendBroadcast(new Intent("com.tencent.mobileqq.action.ACTION_CONFESS_START_EVENT"));
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
        boolean doOnCreate = super.doOnCreate(bundle);
        getWindow().setBackgroundDrawableResource(R.color.ajr);
        View findViewById = findViewById(R.id.ae8);
        if (findViewById != null) {
            findViewById.setBackgroundResource(R.color.ajr);
        }
        int intExtra = getIntent().getIntExtra("confessDstHeight", 0);
        this.f178331b0 = intExtra;
        if (intExtra <= 0) {
            if (QLog.isColorLevel()) {
                QLog.i(QQBrowserActivity.TAG, 2, "height==0");
            }
            finish();
        }
        if (this.f178330a0 == null) {
            this.f178330a0 = new a();
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.tencent.mobileqq.action.ACTION_CONFESS_FINISH_EVENT");
                registerReceiver(this.f178330a0, intentFilter);
            } catch (Exception unused) {
                QLog.e(QQBrowserActivity.TAG, 1, "register mFinishReceiver receiver exception.");
            }
        }
        return doOnCreate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.QQBrowserActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        try {
            BroadcastReceiver broadcastReceiver = this.f178330a0;
            if (broadcastReceiver != null) {
                unregisterReceiver(broadcastReceiver);
                this.f178330a0 = null;
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(QQBrowserActivity.TAG, 2, "doOnDestroy mFinishReceiver unregisterReceiver, e:" + e16.getMessage());
            }
        }
        super.doOnDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        super.doOnResume();
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.confess.ConfessHalfScreenActivity.2
            @Override // java.lang.Runnable
            public void run() {
                Object[] g16 = com.tencent.mobileqq.campuscircle.a.c().g();
                if (g16 != null && g16.length == 2) {
                    boolean booleanValue = ((Boolean) g16[0]).booleanValue();
                    boolean booleanValue2 = ((Boolean) g16[1]).booleanValue();
                    QLog.e(QQBrowserActivity.TAG, 1, "doOnResume .isSucess =" + booleanValue + ", isInTroopAIO=" + booleanValue2);
                    if (booleanValue && !booleanValue2) {
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.confess.ConfessHalfScreenActivity.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ConfessHalfScreenActivity.this.finish();
                            }
                        });
                    }
                }
            }
        });
        new Handler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.confess.ConfessHalfScreenActivity.3
            @Override // java.lang.Runnable
            public void run() {
                ConfessHalfScreenActivity.H2();
            }
        }, 200L);
    }

    @Override // com.tencent.mobileqq.activity.QQBrowserActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
