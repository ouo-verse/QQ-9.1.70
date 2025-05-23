package com.tencent.open.downloadnew;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebView;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public class WebViewDownloadListener implements DownloadListener {

    /* renamed from: b, reason: collision with root package name */
    protected static WebViewDownloadListener f341427b;

    /* renamed from: a, reason: collision with root package name */
    protected Handler f341428a;

    protected WebViewDownloadListener() {
        this.f341428a = null;
        this.f341428a = new Handler(Looper.getMainLooper());
    }

    public static WebViewDownloadListener g() {
        if (f341427b == null) {
            f341427b = new WebViewDownloadListener();
        }
        return f341427b;
    }

    protected void d(String str) {
        final String str2;
        com.tencent.open.business.base.d a16 = com.tencent.open.business.base.d.a();
        try {
            int size = a16.b().size();
            for (int i3 = 0; i3 < size; i3++) {
                com.tencent.open.business.base.c cVar = a16.b().get(i3);
                final WebView webview = cVar.getWebview();
                if (webview != null) {
                    if (TextUtils.isEmpty(cVar.getJsCallbackMethod())) {
                        str2 = "javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('loadProcess'," + str + ");}void(0);";
                    } else {
                        str2 = com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.js.jsapi.a.JAVASCRIPT_PREFIX + cVar.getJsCallbackMethod() + "(" + str + ")";
                    }
                    com.tencent.open.base.f.h("WebViewDownloadListener", " commonJsCallBack >>> " + str2);
                    this.f341428a.post(new Runnable() { // from class: com.tencent.open.downloadnew.WebViewDownloadListener.1

                        /* compiled from: P */
                        /* renamed from: com.tencent.open.downloadnew.WebViewDownloadListener$1$a */
                        /* loaded from: classes22.dex */
                        class a implements ValueCallback<String> {
                            a() {
                            }

                            @Override // com.tencent.smtt.sdk.ValueCallback, android.webkit.ValueCallback
                            /* renamed from: a, reason: merged with bridge method [inline-methods] */
                            public void onReceiveValue(String str) {
                                com.tencent.open.base.f.h("WebViewDownloadListener", "[onReceiveValue]:" + str);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            if (webview != null && str2 != null && com.tencent.open.appcommon.b.a().b()) {
                                try {
                                    com.tencent.open.base.f.h("WebViewDownloadListener", "wb.loadUrl(loadJs):" + str2);
                                    webview.evaluateJavascript(str2, new a());
                                } catch (Exception e16) {
                                    com.tencent.open.base.f.b("WebViewDownloadListener", "doJsCallBack >>> ", e16);
                                }
                            }
                        }
                    });
                }
            }
        } catch (Exception e16) {
            com.tencent.open.base.f.d("WebViewDownloadListener", "doJsCallback >>> ", e16);
        }
    }

    protected String e(String str, int i3, int i16, String str2, int i17, String str3, int i18, int i19) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("packagename", str2);
            jSONObject.put("appid", str);
            jSONObject.put("state", i3);
            jSONObject.put(WadlResult.WEB_KEY_PROGRESS, i16);
            jSONObject.put("ismyapp", i17);
            jSONObject.put("errorMsg", str3);
            jSONObject.put("errorCode", i18);
            jSONObject.put(WadlResult.WEB_KEY_WRITE_CODE_STATE, i19);
        } catch (JSONException e16) {
            com.tencent.open.base.f.d("WebViewDownloadListener", "getCallBackJsonObject >>> ", e16);
        }
        return jSONObject.toString();
    }

    protected String f(String str, int i3, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("packagename", str2);
            jSONObject.put("appid", str);
            jSONObject.put("state", i3);
            jSONObject.put(WadlResult.WEB_KEY_PROGRESS, 0);
        } catch (JSONException e16) {
            com.tencent.open.base.f.d("WebViewDownloadListener", "getCallBackJsonObject >>> ", e16);
        }
        return jSONObject.toString();
    }

    @Override // com.tencent.open.downloadnew.DownloadListener
    public void installSucceed(String str, String str2) {
        d(f(str, 6, str2));
    }

    @Override // com.tencent.open.downloadnew.DownloadListener
    public void onDownloadCancel(DownloadInfo downloadInfo) {
        if (downloadInfo != null) {
            d(downloadInfo.l().toString());
        }
    }

    @Override // com.tencent.open.downloadnew.DownloadListener
    public void onDownloadError(DownloadInfo downloadInfo, int i3, String str, int i16) {
        if (downloadInfo != null) {
            d(e(downloadInfo.f341184e, i16, downloadInfo.Q, downloadInfo.f341189h, downloadInfo.J, str, i3, downloadInfo.f341179a0));
        }
    }

    @Override // com.tencent.open.downloadnew.DownloadListener
    public void onDownloadFinish(DownloadInfo downloadInfo) {
        if (downloadInfo != null) {
            d(downloadInfo.l().toString());
        }
    }

    @Override // com.tencent.open.downloadnew.DownloadListener
    public void onDownloadPause(DownloadInfo downloadInfo) {
        if (downloadInfo != null) {
            d(downloadInfo.l().toString());
        }
    }

    @Override // com.tencent.open.downloadnew.DownloadListener
    public void onDownloadUpdate(List<DownloadInfo> list) {
        if (list != null) {
            JSONArray jSONArray = new JSONArray();
            Iterator<DownloadInfo> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.mo162put(it.next().l());
            }
            d(jSONArray.toString());
        }
    }

    @Override // com.tencent.open.downloadnew.DownloadListener
    public void onDownloadWait(DownloadInfo downloadInfo) {
        if (downloadInfo != null) {
            d(downloadInfo.l().toString());
        }
    }

    @Override // com.tencent.open.downloadnew.DownloadListener
    public void packageReplaced(String str, String str2) {
        d(f(str, 13, str2));
    }

    @Override // com.tencent.open.downloadnew.DownloadListener
    public void uninstallSucceed(String str, String str2) {
        d(f(str, 9, str2));
    }
}
