package com.tencent.mobileqq.teamwork;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.IGetExternalInterface;
import com.tencent.mobileqq.webview.swift.SwiftReuseTouchWebView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class bo {

    /* renamed from: a, reason: collision with root package name */
    private static List<TouchWebView> f292107a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private static final byte[] f292108b = new byte[0];

    /* renamed from: c, reason: collision with root package name */
    private static int f292109c = 1;

    /* renamed from: d, reason: collision with root package name */
    private static volatile bo f292110d = null;

    /* renamed from: e, reason: collision with root package name */
    public static HashMap<String, Integer> f292111e = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a extends WebChromeClient {
        a() {
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public void onProgressChanged(WebView webView, int i3) {
            JsInjector.getInstance().onProgressChanged(webView, i3);
            super.onProgressChanged(webView, i3);
            QLog.i("TenDocWebViewPool", 1, "tendocpreload onProgressChanged = " + i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b extends WebViewClient {
        b() {
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            QLog.i("TenDocWebViewPool", 1, "tendocpreload onPageFinished = " + str);
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            JsInjector.getInstance().onPageStarted(webView);
            QLog.i("TenDocWebViewPool", 1, "tendocpreload onPageStarted = " + str);
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            return super.shouldOverrideUrlLoading(webView, webResourceRequest);
        }
    }

    bo() {
        f292107a = new ArrayList();
    }

    public static bo b() {
        if (f292110d == null) {
            synchronized (bo.class) {
                if (f292110d == null) {
                    f292110d = new bo();
                }
            }
        }
        return f292110d;
    }

    public static synchronized void f(String str, TouchWebView touchWebView) {
        synchronized (bo.class) {
            if (f292111e == null) {
                f292111e = new HashMap<>();
            }
            if (str != null) {
                Integer num = f292111e.get(str);
                if (num == null) {
                    f292111e.put(str, 1);
                } else {
                    f292111e.put(str, Integer.valueOf(num.intValue() + 1));
                }
            }
            ((IGetExternalInterface) QRoute.api(IGetExternalInterface.class)).sendDocsDataBack(str, touchWebView);
        }
    }

    public List<TouchWebView> a() {
        return f292107a;
    }

    public TouchWebView c(Context context) {
        TouchWebView touchWebView;
        synchronized (f292108b) {
            QLog.e("TenDocWebViewPool", 1, "tendocpreload getWebView =  " + f292107a.size());
            if (f292107a.size() > 0) {
                touchWebView = f292107a.get(0);
                f292107a.remove(0);
                ViewGroup viewGroup = (ViewGroup) touchWebView.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(touchWebView);
                }
                ((MutableContextWrapper) touchWebView.getContext()).setBaseContext(context);
            } else {
                touchWebView = null;
            }
        }
        return touchWebView;
    }

    public void d(String str) {
        QLog.i("TenDocWebViewPool", 1, "tendocpreload init" + e());
        synchronized (f292108b) {
            if (!e()) {
                ((IGetExternalInterface) QRoute.api(IGetExternalInterface.class)).webAcceleratorSmartSchedule();
                QLog.i("TenDocWebViewPool", 1, "init");
                SwiftReuseTouchWebView q16 = SwiftReuseTouchWebView.q(BaseApplication.getContext());
                q16.setWebViewClient(new b());
                q16.setWebChromeClient(new a());
                f292107a.add(q16);
            }
            TenDocWebPreLoadHelper.f291578a = str;
        }
    }

    public boolean e() {
        if (f292107a.size() > 0) {
            return true;
        }
        return false;
    }

    public boolean g(String str) {
        if (!e() || TextUtils.isEmpty(str)) {
            return false;
        }
        TouchWebView touchWebView = a().get(0);
        touchWebView.setWebViewClient(new b());
        touchWebView.setWebChromeClient(new a());
        touchWebView.loadUrlOriginal(str);
        return true;
    }

    public void h(TouchWebView touchWebView) {
        QLog.i("TenDocWebViewPool", 1, "tendocpreload recycleWebView  ");
        if (touchWebView != null) {
            ViewGroup viewGroup = (ViewGroup) touchWebView.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(touchWebView);
            }
            synchronized (f292108b) {
                if (touchWebView instanceof SwiftReuseTouchWebView) {
                    Context context = touchWebView.getContext();
                    if (context instanceof MutableContextWrapper) {
                        ((MutableContextWrapper) context).setBaseContext(BaseApplication.getContext());
                    }
                    if (f292107a.size() < f292109c) {
                        QLog.i("TenDocWebViewPool", 1, "tendocpreload recycleWebView  ");
                        f292107a.add(touchWebView);
                    } else {
                        touchWebView.destroy();
                    }
                }
            }
        }
    }
}
