package com.tencent.gdtad.basics.motivevideo.hippy.web;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.webkit.ValueCallback;
import com.tencent.ad.tangram.statistics.metric.AdMetricID;
import com.tencent.ams.dsdk.view.webview.DKWebView;
import com.tencent.ams.dsdk.view.webview.DKWebViewLaunchMode;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.gdtad.basics.motivevideo.hippy.web.GdtMotiveHippyWebView;
import com.tencent.gdtad.basics.motivevideo.report.GdtAnalysisHelperForMotiveAd;
import com.tencent.mobileqq.webview.m;
import com.tencent.mtt.hippy.HippyInstanceContext;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class GdtMotiveHippyWebView extends TouchWebView implements DKWebView {
    private DKWebView.DKWebViewEventListener C;
    private DKWebView.OnTouchDownListener D;
    private int E;

    public GdtMotiveHippyWebView(Context context) {
        super(context);
        HippyInstanceContext hippyInstanceContext;
        Context context2;
        AppRuntime appRuntime;
        AppRuntime appRuntime2;
        this.E = DKWebViewLaunchMode.LAUNCH_WITH_CONFIRMATION;
        if (context instanceof HippyInstanceContext) {
            hippyInstanceContext = (HippyInstanceContext) context;
        } else {
            hippyInstanceContext = null;
        }
        if (hippyInstanceContext != null && hippyInstanceContext.getModuleParams() != null) {
            context2 = hippyInstanceContext.getModuleParams().context;
        } else {
            context2 = null;
        }
        if (!(context2 instanceof Activity)) {
            QLog.e("GdtMotiveHippyWebView", 1, "[constructor] error, activity is null");
            return;
        }
        Activity activity = (Activity) context2;
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        if (mobileQQ != null) {
            appRuntime = mobileQQ.peekAppRuntime();
        } else {
            appRuntime = null;
        }
        if (appRuntime != null) {
            appRuntime2 = appRuntime.getAppRuntime("modular_web");
        } else {
            appRuntime2 = null;
        }
        if (!(appRuntime2 instanceof AppInterface)) {
            QLog.e("GdtMotiveHippyWebView", 1, "[constructor] error, appInterface not instanceof AppInterface");
            return;
        }
        com.tencent.gdtad.basics.motivevideo.report.a.m("GdtMotiveHippyWebView", "[constructor]", AdMetricID.Reward.HIPPY_WEB_CONSTRUCTOR, null);
        b bVar = new b(activity, activity, (AppInterface) appRuntime2, new WeakReference(this));
        bVar.setWebView(this);
        new m(bVar).a(null, appRuntime, activity.getIntent());
        GdtAnalysisHelperForMotiveAd.r(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void u(ValueCallback valueCallback, String str) {
        if (valueCallback == null) {
            QLog.i("GdtMotiveHippyWebView", 1, "[evaluateJavaScript][callback] error, valueCallback is null");
            return;
        }
        QLog.i("GdtMotiveHippyWebView", 1, "[evaluateJavaScript][callback]" + str);
        valueCallback.onReceiveValue(str);
    }

    @Override // com.tencent.ams.dsdk.view.webview.DKWebView
    public void evaluateJavaScript(String str, final ValueCallback<String> valueCallback) {
        com.tencent.smtt.sdk.ValueCallback<String> valueCallback2 = new com.tencent.smtt.sdk.ValueCallback() { // from class: qm0.a
            @Override // com.tencent.smtt.sdk.ValueCallback, android.webkit.ValueCallback
            public final void onReceiveValue(Object obj) {
                GdtMotiveHippyWebView.u(valueCallback, (String) obj);
            }
        };
        QLog.i("GdtMotiveHippyWebView", 1, "[evaluateJavaScript]");
        evaluateJavascript(str, valueCallback2);
    }

    @Override // com.tencent.ams.dsdk.view.webview.DKWebView
    public String getUserAgent() {
        if (getSettings() == null) {
            QLog.e("GdtMotiveHippyWebView", 1, "[getUserAgent] error, setting is null");
            return null;
        }
        QLog.i("GdtMotiveHippyWebView", 1, "[getUserAgent]");
        return getSettings().getUserAgentString();
    }

    @Override // com.tencent.ams.dsdk.view.webview.DKWebView
    public void onDestroy() {
        QLog.i("GdtMotiveHippyWebView", 1, "[onDestroy]");
        destroy();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DKWebView.DKWebViewEventListener r() {
        return this.C;
    }

    @Override // com.tencent.ams.dsdk.view.webview.DKWebView
    public void registerOnScrollChangedListener(DKWebView.OnScrollChangeListener onScrollChangeListener) {
        QLog.i("GdtMotiveHippyWebView", 1, "[registerOnScrollChangedListener]");
    }

    @Override // com.tencent.ams.dsdk.view.webview.DKWebView
    public void registerOnTouchDownListener(DKWebView.OnTouchDownListener onTouchDownListener) {
        this.D = onTouchDownListener;
        setOnTouchListener(new c(new WeakReference(this)));
    }

    @Override // com.tencent.ams.dsdk.view.webview.DKWebView
    public void registerWebViewEventListener(DKWebView.DKWebViewEventListener dKWebViewEventListener) {
        this.C = dKWebViewEventListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int s() {
        return this.E;
    }

    @Override // com.tencent.ams.dsdk.view.webview.DKWebView
    public void setLaunchMode(int i3) {
        QLog.i("GdtMotiveHippyWebView", 1, "[setLaunchMode] mode:" + i3);
        this.E = i3;
    }

    @Override // com.tencent.ams.dsdk.view.webview.DKWebView
    public void setUserAgent(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("GdtMotiveHippyWebView", 1, "[setUserAgent] error, s is empty");
            return;
        }
        if (getSettings() == null) {
            QLog.e("GdtMotiveHippyWebView", 1, "[setUserAgent] error, setting is null");
            return;
        }
        QLog.i("GdtMotiveHippyWebView", 1, "[setUserAgent]" + str);
        getSettings().setUserAgent(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DKWebView.OnTouchDownListener t() {
        return this.D;
    }

    @Override // com.tencent.ams.dsdk.view.webview.DKWebView
    public void unRegisterOnScrollChangedListener(DKWebView.OnScrollChangeListener onScrollChangeListener) {
        QLog.i("GdtMotiveHippyWebView", 1, "[unRegisterOnScrollChangedListener]");
    }

    @Override // com.tencent.ams.dsdk.view.webview.DKWebView
    public void unRegisterOnTouchDownListener(DKWebView.OnTouchDownListener onTouchDownListener) {
        setOnTouchListener(null);
        this.D = null;
    }

    @Override // com.tencent.ams.dsdk.view.webview.DKWebView
    public View getDKWebView() {
        return this;
    }

    @Override // com.tencent.ams.dsdk.view.webview.DKWebView
    public void setIsWebViewScrollEnabled(boolean z16) {
    }
}
