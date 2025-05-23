package com.qzone.component.banner;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewStub;
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.model.AvatarCacheData;
import com.qzone.misc.network.ttt.TTTReportManager;
import com.qzone.misc.web.webview.QzoneWebViewPluginManager;
import com.qzone.proxy.covercomponent.CoverComponentProxy;
import com.qzone.proxy.covercomponent.adapter.WebviewWrapper;
import com.qzone.proxy.covercomponent.env.CoverEnv;
import com.qzone.util.an;
import com.qzone.widget.WebVewBannerContainer;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IQbossReportManager;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.webview.m;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import common.config.service.QzoneConfig;
import cooperation.qzone.CloseGuard;
import cooperation.qzone.Lbs.QzoneLbsConstant;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.webviewplugin.WebViewBannerInterface;
import cooperation.qzone.webviewwrapper.IWebviewListener;
import cooperation.qzone.webviewwrapper.IWebviewOnClassLoaded;
import cooperation.qzone.webviewwrapper.IWebviewWrapper;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import s7.b;

/* compiled from: P */
/* loaded from: classes39.dex */
public class WebViewBanner extends BasePushBanner implements WebViewBannerInterface {
    IWebviewWrapper G;
    private WebVewBannerContainer H;
    private Map<Integer, String> I;
    private boolean J;
    private String K;
    private String L;
    private String M;
    private int N;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    static class b extends WebviewWrapper {

        /* renamed from: a, reason: collision with root package name */
        private final CloseGuard f46552a;

        /* compiled from: P */
        /* loaded from: classes39.dex */
        class a implements b.InterfaceC11212b {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ IWebviewListener f46553a;

            a(IWebviewListener iWebviewListener) {
                this.f46553a = iWebviewListener;
            }

            @Override // s7.b.InterfaceC11212b
            public void onPageFinished() {
                if (((WebviewWrapper) b.this).mWebview.getVisibility() != 0) {
                    ((WebviewWrapper) b.this).mWebview.setVisibility(0);
                    IWebviewListener iWebviewListener = this.f46553a;
                    if (iWebviewListener != null) {
                        iWebviewListener.onPageFinished();
                    }
                }
                if (((WebviewWrapper) b.this).qzoneShowJSPlugin != null) {
                    if (((WebviewWrapper) b.this).qzoneShowJSPlugin.f433404h <= 0 || ((WebviewWrapper) b.this).qzoneShowJSPlugin.f433404h < ((WebviewWrapper) b.this).qzoneShowJSPlugin.f433401d) {
                        ((WebviewWrapper) b.this).qzoneShowJSPlugin.f433404h = System.currentTimeMillis();
                    }
                }
            }
        }

        public b(Context context) {
            super(context);
            this.f46552a = CloseGuard.get();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.qzone.proxy.covercomponent.adapter.WebviewWrapper
        public void finalize() throws Throwable {
            try {
                this.f46552a.warnIfOpen();
            } finally {
                super.finalize();
            }
        }

        @Override // com.qzone.proxy.covercomponent.adapter.WebviewWrapper, cooperation.qzone.webviewwrapper.IWebviewWrapper
        public void onDestroy() {
            this.f46552a.close();
            super.onDestroy();
        }

        @Override // com.qzone.proxy.covercomponent.adapter.WebviewWrapper, cooperation.qzone.webviewwrapper.IWebviewWrapper
        public void onInit(Activity activity, Intent intent, String str, IWebviewListener iWebviewListener) {
            this.f46552a.open(MosaicConstants$JsFunction.FUNC_ON_DESTROY);
            this.mWebViewBuilder = new s7.b(this.mContext, activity, intent, QzoneWebViewPluginManager.getInstance().getRuntime(), false);
            this.mWebview.setVisibility(4);
            this.mWebViewBuilder.setWebView(this.mWebview);
            this.mWebViewBuilder.a(new a(iWebviewListener));
            new m(this.mWebViewBuilder).a(null, QzoneWebViewPluginManager.getInstance().getRuntime(), null);
            WebViewPluginEngine pluginEngine = this.mWebview.getPluginEngine();
            if (pluginEngine != null) {
                s7.a aVar = (s7.a) pluginEngine.m("QzoneShow");
                this.qzoneShowJSPlugin = aVar;
                if (aVar != null) {
                    aVar.f433401d = this.mWebviewStartTime;
                    aVar.f433402e = System.currentTimeMillis();
                    this.qzoneShowJSPlugin.q(str);
                }
            }
        }
    }

    public WebViewBanner(Context context) {
        super(context);
    }

    public static void B(final IWebviewOnClassLoaded iWebviewOnClassLoaded) {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.component.banner.WebViewBanner.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (!com.tencent.mobileqq.webview.swift.utils.m.e()) {
                        long currentTimeMillis = System.currentTimeMillis();
                        com.tencent.mobileqq.webview.swift.utils.m.g();
                        QLog.i("WebViewBanner", 1, " \u9884\u52a0\u8f7d TbsAccelerator init cost " + (System.currentTimeMillis() - currentTimeMillis));
                    } else {
                        QLog.i("WebViewBanner", 1, " \u9884\u52a0\u8f7d TbsAccelerator is inited");
                    }
                    IWebviewOnClassLoaded iWebviewOnClassLoaded2 = IWebviewOnClassLoaded.this;
                    if (iWebviewOnClassLoaded2 != null) {
                        iWebviewOnClassLoaded2.onLoadClassFinish();
                    }
                } catch (Exception e16) {
                    QLog.e("WebViewBanner", 1, e16, new Object[0]);
                }
            }
        });
    }

    private String D(int i3, int i16) {
        int red = Color.red(i16);
        int green = Color.green(i16);
        int green2 = Color.green(i16);
        StringBuilder sb5 = new StringBuilder(64);
        sb5.append("[");
        sb5.append(red);
        sb5.append(",");
        sb5.append(green);
        sb5.append(",");
        sb5.append(green2);
        sb5.append(",");
        sb5.append(i3);
        sb5.append("]");
        return sb5.toString();
    }

    public static boolean E() {
        return QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.BANNER_USE_WEBSO, 1) == 1;
    }

    public void A(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        String jsScript = WebViewPlugin.toJsScript(str, jSONObject, jSONObject2);
        IWebviewWrapper iWebviewWrapper = this.G;
        if (iWebviewWrapper != null) {
            iWebviewWrapper.callJs(jsScript);
        }
    }

    @Override // com.qzone.component.banner.Banner
    public boolean c() {
        return super.c();
    }

    @Override // cooperation.qzone.webviewplugin.WebViewBannerInterface
    public void close() {
        if (QZLog.isColorLevel()) {
            QZLog.d("WebViewBanner", 2, "close");
        }
        g();
    }

    @Override // com.qzone.component.banner.Banner
    public int d() {
        return 700;
    }

    @Override // com.qzone.component.banner.Banner
    public void destroy() {
        p();
        if (QZLog.isColorLevel()) {
            QZLog.d("WebViewBanner", 2, "destroy");
        }
    }

    @Override // com.qzone.component.banner.Banner
    public int e() {
        return 19;
    }

    @Override // cooperation.qzone.webviewplugin.WebViewBannerInterface
    public void enableGesture(boolean z16) {
        WebVewBannerContainer webVewBannerContainer = this.H;
        if (webVewBannerContainer != null) {
            webVewBannerContainer.a(z16);
        }
    }

    @Override // cooperation.qzone.webviewplugin.WebViewBannerInterface
    public String getBannerData() {
        return this.K;
    }

    @Override // com.qzone.component.banner.Banner
    public void i(boolean z16) {
        IWebviewWrapper iWebviewWrapper;
        if (this.H == null) {
            QZLog.i("WebViewBanner", "parent==null");
            return;
        }
        QZLog.i("WebViewBanner", "internal_show:" + z16);
        if (z16) {
            if (l() && (iWebviewWrapper = this.G) != null) {
                iWebviewWrapper.getWebview().setTag(R.id.daa, null);
                this.G.onDestroy();
                setVisibility(8);
                this.H.setVisibility(8);
                this.G = null;
            }
            this.H.setVisibility(0);
            b bVar = new b(getContext());
            this.G = bVar;
            bVar.getWebview().setTag(R.id.daa, this);
            this.H.addView(this.G.getWebview(), new FrameLayout.LayoutParams(-1, 1));
            this.H.setBackgroundColor(0);
            this.G.getWebview().setVisibility(4);
            this.G.onInit((Activity) getContext(), null, "", new a());
            this.J = true;
            this.G.getWebview().loadUrl(an.b(this.L));
            if (this.G.getWebview().getX5WebViewExtension() != null) {
                try {
                    this.G.getWebview().getView().setBackgroundColor(0);
                } catch (Exception e16) {
                    QZLog.e("WebViewBanner", Log.getStackTraceString(e16));
                }
            } else {
                this.G.getWebview().setBackgroundColor(0);
            }
            if (QZLog.isDevelopLevel()) {
                QZLog.d("WebViewBanner", 2, "WebViewBanner internal_show after loadurl");
                return;
            }
            return;
        }
        this.J = false;
        IWebviewWrapper iWebviewWrapper2 = this.G;
        if (iWebviewWrapper2 != null) {
            if (iWebviewWrapper2.getWebview() != null) {
                this.G.getWebview().setTag(R.id.daa, null);
            }
            this.G.onDestroy();
            setVisibility(8);
            this.H.setVisibility(8);
            this.G = null;
        }
    }

    @Override // com.qzone.component.banner.Banner
    public boolean l() {
        if (this.J) {
            if (QZLog.isColorLevel()) {
                QZLog.d("WebViewBanner", 2, "isVisible,loading");
            }
            return true;
        }
        IWebviewWrapper iWebviewWrapper = this.G;
        return iWebviewWrapper != null && iWebviewWrapper.getWebview().isShown();
    }

    @Override // com.qzone.component.banner.Banner
    public void p() {
        super.p();
        IWebviewWrapper iWebviewWrapper = this.G;
        if (iWebviewWrapper != null) {
            iWebviewWrapper.onDestroy();
        }
    }

    @Override // com.qzone.component.banner.Banner
    public void q() {
        super.q();
        if (this.G != null) {
            if (QZLog.isColorLevel()) {
                QZLog.d("WebViewBanner", 2, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
            }
            A("Feeds_onPause_Event", null, null);
        }
    }

    @Override // com.qzone.component.banner.Banner
    public void r() {
        super.r();
        if (this.G != null) {
            if (QZLog.isColorLevel()) {
                QZLog.d("WebViewBanner", 2, "onResume");
            }
            A("Feeds_onResume_Event", null, null);
            int superCoverTrans = CoverComponentProxy.f50099g.getServiceInterface().getSuperCoverTrans(LoginData.getInstance().getUin());
            if (this.N != superCoverTrans) {
                this.N = superCoverTrans;
                String D = D(this.N, getResources().getColor(R.color.f157901a72));
                JSONObject jSONObject = new JSONObject();
                try {
                    QZLog.i("WebViewBanner", 2, "alpha changed:", Integer.valueOf(superCoverTrans));
                    jSONObject.put("color_rgba", D);
                    A("onBackgroudChanged", jSONObject, null);
                } catch (JSONException e16) {
                    QZLog.e("WebViewBanner", Log.getStackTraceString(e16));
                }
            }
        }
    }

    @Override // com.qzone.component.banner.Banner
    public void s(int i3) {
        super.s(i3);
        if (this.H == null) {
            return;
        }
        if (i3 == 0) {
            float dimension = getResources().getDimension(R.dimen.title_bar_height) + getResources().getDimension(R.dimen.f159598b01);
            int[] iArr = new int[2];
            this.H.getLocationInWindow(iArr);
            int i16 = iArr[1];
            int height = this.H.getHeight();
            if (height + i16 >= dimension && i16 <= ViewUtils.getScreenHeight()) {
                r();
                return;
            }
            QZLog.d("feilongzou", 2, "x=" + iArr[0] + ",y=" + iArr[1] + ",height=" + height + ",titleHeight:" + dimension + ",banner \u4e0d\u53ef\u89c1");
            return;
        }
        q();
    }

    @Override // cooperation.qzone.webviewplugin.WebViewBannerInterface
    public void setBannerHeight(int i3) {
        if (QZLog.isDevelopLevel()) {
            QZLog.d("WebViewBanner", 2, "WebViewBanner setBannerHeight:" + i3);
        }
        IWebviewWrapper iWebviewWrapper = this.G;
        if (iWebviewWrapper == null || iWebviewWrapper.getWebview() == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, i3);
        layoutParams.setMargins(0, 0, 0, 0);
        this.G.getWebview().setLayoutParams(layoutParams);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    @Override // com.qzone.component.banner.Banner
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void t(com.qzone.feed.business.model.a aVar) {
        JSONObject jSONObject;
        Object obj;
        Object obj2;
        Object obj3 = "";
        if (aVar == null) {
            QLog.e("WebViewBanner", 1, "updateBannerData data \u4e3anull");
            return;
        }
        if (!CoverEnv.isBestPerformanceDevice()) {
            QZLog.e("WebViewBanner", "\u4f4e\u7aef\u673a\u4e0d\u663e\u793a webview");
            return;
        }
        this.K = aVar.f47130n;
        this.I = aVar.f47132p;
        if (QZLog.isColorLevel()) {
            QLog.i("WebViewBanner", 2, "updateBannerData BannerStruct serverData\uff1a(" + this.K + "),strTraceInfo:" + aVar.f47127k);
        }
        if (!TextUtils.isEmpty(this.K)) {
            JSONObject jSONObject2 = null;
            try {
                jSONObject = new JSONObject(this.K);
            } catch (JSONException e16) {
                e = e16;
            }
            try {
                jSONObject.put(AvatarCacheData.STRTRACEINFO, aVar.f47127k);
                if (!jSONObject.has("type")) {
                    jSONObject.put("type", aVar.f47131o);
                }
                if (jSONObject.has("url") && (obj2 = jSONObject.get("url")) != null && (obj2 instanceof String)) {
                    jSONObject.put("url", BusinessADBannerData.getJumpTraceInfoUrl((String) obj2, aVar.f47127k));
                }
                String nickName = LoginData.getInstance().getNickName("");
                jSONObject.put("nickName", nickName);
                C(jSONObject, nickName);
                if (com.qzone.business.lbsv2.business.c.g(QzoneLbsConstant.BUSINESS_ID_QZONE_H5).a() == null) {
                    obj = "";
                } else {
                    obj3 = String.valueOf((r0.lat * 1.0d) / 1000000.0d);
                    obj = String.valueOf((r0.lon * 1.0d) / 1000000.0d);
                }
                jSONObject.put(QCircleSchemeAttr.Polymerize.LAT, obj3);
                jSONObject.put("lon", obj);
                this.N = CoverComponentProxy.f50099g.getServiceInterface().getSuperCoverTrans(LoginData.getInstance().getUin());
                Object D = D(this.N, getResources().getColor(R.color.qzone_skin_feed_background_color));
                QZLog.d("WebViewBanner", 2, "color_rgba:", D);
                jSONObject.put("color_rgba", D);
                this.K = jSONObject.toString();
                this.M = aVar.f47127k;
            } catch (JSONException e17) {
                e = e17;
                jSONObject2 = jSONObject;
                QZLog.e("WebViewBanner", Log.getStackTraceString(e));
                jSONObject = jSONObject2;
                if (jSONObject == null) {
                }
            }
            if (jSONObject == null) {
                String optString = jSONObject.optString("h5url");
                if (URLUtil.isNetworkUrl(optString)) {
                    this.L = optString;
                    c();
                    return;
                } else {
                    QZLog.e("WebViewBanner", "url \u4e0d\u662f\u7f51\u7edcurl\uff1a" + optString);
                    return;
                }
            }
            return;
        }
        QZLog.e("WebViewBanner", "updateBannerData:serverData \u4e3a\u7a7a\uff0c\u4e0d\u663e\u793a");
    }

    @Override // com.qzone.component.banner.Banner
    public void h(ViewStub viewStub) {
        if (viewStub == null) {
            return;
        }
        this.H = (WebVewBannerContainer) viewStub.inflate();
        this.f46297e = true;
    }

    private void C(JSONObject jSONObject, String str) {
        if (jSONObject == null || str == null) {
            return;
        }
        String optString = jSONObject.optString("nick_pattern");
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        try {
            jSONObject.put("nick_pattern", optString.replace("{nickname}", str).replace("{nickname}", str));
        } catch (JSONException e16) {
            QLog.e("WebViewBanner", 1, "", e16);
        }
    }

    @Override // cooperation.qzone.webviewplugin.WebViewBannerInterface
    public void qbossReport(int i3, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            if (this.I == null) {
                this.I = new HashMap();
            }
            String put = this.I.put(35, str2);
            if (put != null && QLog.isColorLevel()) {
                QZLog.w("WebViewBanner", "qbossReport: feedReportCookie has oldValue for e_elaborate_report_cookie._ELABORATE_REPORT_BANNER_ITEM_ID,actionUrl old value=" + put + ",new value=" + str2);
            }
        }
        if (1 == i3) {
            if (!TextUtils.isEmpty(str)) {
                ((IQbossReportManager) QRoute.api(IQbossReportManager.class)).reportExpose(str, null);
            }
            Map<Integer, String> map = this.I;
            if (map == null || map.size() == 0) {
                return;
            }
            TTTReportManager.s().q(12, 203, 19, System.currentTimeMillis(), null, this.I, -1000, 0, true);
            QZLog.d("WebViewBanner", 2, "TTT report: exposure");
            return;
        }
        if (2 == i3) {
            if (!TextUtils.isEmpty(str)) {
                ((IQbossReportManager) QRoute.api(IQbossReportManager.class)).reportClick(str, null);
            }
            Map<Integer, String> map2 = this.I;
            if (map2 == null || map2.size() == 0) {
                return;
            }
            TTTReportManager.s().q(12, 203, 1, System.currentTimeMillis(), null, this.I, -1000, 0, true);
            QZLog.d("WebViewBanner", 2, "TTT report: click");
            return;
        }
        if (3 == i3) {
            if (!TextUtils.isEmpty(str)) {
                ((IQbossReportManager) QRoute.api(IQbossReportManager.class)).reportClose(str, null);
            }
            Map<Integer, String> map3 = this.I;
            if (map3 == null || map3.size() == 0) {
                return;
            }
            TTTReportManager.s().q(12, 204, 1, System.currentTimeMillis(), null, this.I, -1000, 0, true);
            QZLog.d("WebViewBanner", 2, "TTT report: close");
            return;
        }
        QZLog.e(QZLog.TO_DEVICE_TAG, "WebViewBanner qbossReport type \u9519\u8bef type= " + i3);
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements IWebviewListener {
        a() {
        }

        @Override // cooperation.qzone.webviewwrapper.IWebviewListener
        public void onPageFinished() {
            WebViewBanner.this.J = false;
            if (QZLog.isDevelopLevel()) {
                QZLog.d("WebViewBanner", 2, "WebViewBanner onPageFinished");
            }
        }

        @Override // cooperation.qzone.webviewwrapper.IWebviewListener
        public void onReceiveError(int i3, String str, String str2) {
        }
    }
}
