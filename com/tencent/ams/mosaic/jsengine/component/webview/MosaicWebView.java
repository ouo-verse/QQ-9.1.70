package com.tencent.ams.mosaic.jsengine.component.webview;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tencent.ams.hippo.quickjs.android.JSFunction;
import com.tencent.ams.mosaic.utils.MosaicUtils;
import com.tencent.ams.mosaic.utils.f;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qimei.webview.QmWebview;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes3.dex */
public class MosaicWebView extends QmWebview {
    static IPatchRedirector $redirector_;
    private JSFunction C;
    private long D;
    private long E;

    /* renamed from: i, reason: collision with root package name */
    private final Context f71423i;

    /* renamed from: m, reason: collision with root package name */
    private com.tencent.ams.mosaic.jsengine.a f71424m;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a extends WebViewClient {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MosaicWebView.this);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) webView, (Object) str);
                return;
            }
            super.onPageFinished(webView, str);
            HashMap hashMap = new HashMap();
            hashMap.put("url", str);
            MosaicWebView mosaicWebView = MosaicWebView.this;
            mosaicWebView.b(mosaicWebView.C, 0, "event", "onWebViewLoadFinish", hashMap);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            JsInjector.getInstance().onPageStarted(webView);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, webView, str, bitmap);
                return;
            }
            f.e("MosaicWebView ", "onPageStarted, url: " + str);
            HashMap hashMap = new HashMap();
            hashMap.put("url", str);
            super.onPageStarted(webView, str, bitmap);
            MosaicWebView mosaicWebView = MosaicWebView.this;
            mosaicWebView.b(mosaicWebView.C, 0, "event", "onWebViewLoadStart", hashMap);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, webView, webResourceRequest, webResourceError);
                return;
            }
            f.e("MosaicWebView ", "onReceivedError, request: " + webResourceRequest + ", error: " + webResourceError);
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            HashMap hashMap = new HashMap();
            hashMap.put("error", Integer.valueOf(webResourceError.getErrorCode()));
            hashMap.put("url", webResourceRequest.getUrl());
            MosaicWebView mosaicWebView = MosaicWebView.this;
            mosaicWebView.b(mosaicWebView.C, 0, "event", "onWebViewLoadError", hashMap);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) webView, (Object) str)).booleanValue();
            }
            f.e("MosaicWebView ", "shouldOverrideUrlLoading, url: " + str);
            return false;
        }
    }

    public MosaicWebView(Context context) {
        super(context);
        Context context2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.E = 0L;
        if (context != null) {
            context2 = context.getApplicationContext();
        } else {
            context2 = null;
        }
        this.f71423i = context2;
    }

    private void c(int i3, int i16, int i17, int i18) {
        HashMap hashMap = new HashMap();
        hashMap.put(HippyTKDListViewAdapter.X, Float.valueOf(MosaicUtils.E(i3)));
        hashMap.put("y", Float.valueOf(MosaicUtils.E(i16)));
        hashMap.put("oldx", Float.valueOf(MosaicUtils.E(i17)));
        hashMap.put("oldy", Float.valueOf(MosaicUtils.E(i18)));
        f.e("MosaicWebView ", "onScrollChange webView didScrollNoti scrollX\uff1a" + i3 + " scrollY\uff1a" + i16 + " oldX\uff1a" + i17 + " oldY\uff1a" + i18);
        b(this.C, 0, "event", "onWebViewScrolled", hashMap);
    }

    private void d(int i3, int i16, int i17, int i18) {
        long j3 = this.E;
        if (j3 <= 0) {
            c(i3, i16, i17, i18);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.D == 0) {
            this.D = System.currentTimeMillis();
        }
        if (currentTimeMillis - this.D >= j3) {
            this.D = currentTimeMillis;
            c(i3, i16, i17, i18);
        }
    }

    public void b(JSFunction jSFunction, int i3, String str, Object obj, Map map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, jSFunction, Integer.valueOf(i3), str, obj, map);
            return;
        }
        f.e("MosaicWebView ", "result\uff1a" + i3 + " mapDataValue\uff1a" + obj + " mapData\uff1a" + map);
        if (this.f71424m == null) {
            f.b("MosaicWebView ", "callBackResult: mQuickJSEngine is null");
            return;
        }
        if (jSFunction == null) {
            f.b("MosaicWebView ", "callBackResult: callback is null");
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            if (!TextUtils.isEmpty(str) && obj != null) {
                hashMap.put(str, obj);
            }
            if (map != null) {
                hashMap.put("eventParams", map);
            }
            f.e("MosaicWebView ", "callBackResult callJsFunction start respMap = " + hashMap);
            this.f71424m.u(jSFunction, new Object[]{Integer.valueOf(i3), hashMap}, null);
        } catch (Throwable th5) {
            f.c("MosaicWebView ", "callBackResult", th5);
        }
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onScrollChanged(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        } else {
            super.onScrollChanged(i3, i16, i17, i18);
            d(i3, i16, i17, i18);
        }
    }

    public void setMosaicJSEngine(com.tencent.ams.mosaic.jsengine.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
        } else {
            this.f71424m = aVar;
        }
    }

    public void setMosaicWebViewClient() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            setWebViewClient(new a());
        }
    }

    public void setPlatformViewEventCallBack(JSFunction jSFunction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) jSFunction);
        } else {
            this.C = jSFunction;
        }
    }

    public void setWebViewScrollChangeNotiDurationMS(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, j3);
        } else {
            this.E = j3;
        }
    }

    public void setWebViewSettings(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
            return;
        }
        WebSettings settings = getSettings();
        if (settings != null) {
            settings.setJavaScriptEnabled(true);
            settings.setBuiltInZoomControls(true);
            settings.setDisplayZoomControls(false);
            settings.setDomStorageEnabled(true);
            settings.setSupportZoom(true);
            settings.setAllowFileAccess(true);
            settings.setGeolocationEnabled(true);
            settings.setDatabaseEnabled(true);
            settings.setLoadWithOverviewMode(true);
            settings.setUseWideViewPort(true);
            settings.setAppCacheEnabled(false);
            settings.setSupportMultipleWindows(false);
            settings.setLoadsImagesAutomatically(true);
            settings.setAllowContentAccess(false);
            settings.setDatabaseEnabled(true);
            settings.setDomStorageEnabled(true);
            settings.setLoadWithOverviewMode(true);
            settings.setUseWideViewPort(true);
            settings.setBuiltInZoomControls(true);
            settings.setDisplayZoomControls(false);
            settings.setSupportZoom(true);
            settings.setAppCachePath(context.getDir("hwebview_appcache", 0).getPath());
            settings.setDatabasePath(context.getDir("hwebview_databases", 0).getPath());
            settings.setGeolocationDatabasePath(context.getDir("hwebview_geolocation", 0).getPath());
            settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
            if (Build.VERSION.SDK_INT >= 26) {
                settings.setSafeBrowsingEnabled(true);
            }
        }
    }
}
