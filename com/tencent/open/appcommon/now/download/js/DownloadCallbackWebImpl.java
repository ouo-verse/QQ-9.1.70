package com.tencent.open.appcommon.now.download.js;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.open.appcommon.now.download.b;
import com.tencent.open.base.f;
import com.tencent.open.business.base.c;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.smtt.sdk.WebView;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public class DownloadCallbackWebImpl implements b {

    /* renamed from: b, reason: collision with root package name */
    protected static DownloadCallbackWebImpl f340711b;

    /* renamed from: a, reason: collision with root package name */
    protected Handler f340712a;

    protected DownloadCallbackWebImpl() {
        this.f340712a = null;
        this.f340712a = new Handler(Looper.getMainLooper());
    }

    public static DownloadCallbackWebImpl h() {
        if (f340711b == null) {
            f340711b = new DownloadCallbackWebImpl();
        }
        return f340711b;
    }

    @Override // com.tencent.open.appcommon.now.download.b
    public void a(int i3) {
        d(g(i3));
    }

    @Override // com.tencent.open.appcommon.now.download.b
    public void b(DownloadInfo downloadInfo, int i3) {
        if (downloadInfo != null) {
            d(i(downloadInfo, i3).toString());
        }
    }

    protected void d(String str) {
        final String str2;
        a a16 = a.a();
        try {
            int size = a16.b().size();
            for (int i3 = 0; i3 < size; i3++) {
                c cVar = a16.b().get(i3);
                final WebView webview = cVar.getWebview();
                if (webview != null) {
                    if (TextUtils.isEmpty(cVar.getJsCallbackMethod())) {
                        str2 = "javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('loadProcess'," + str + ");}void(0);";
                    } else {
                        str2 = com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.js.jsapi.a.JAVASCRIPT_PREFIX + cVar.getJsCallbackMethod() + "(" + str + ")";
                    }
                    f.h("DownloadCallbackWebImpl", " commonJsCallBack >>> " + str2);
                    this.f340712a.post(new Runnable() { // from class: com.tencent.open.appcommon.now.download.js.DownloadCallbackWebImpl.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (webview != null && str2 != null && com.tencent.open.appcommon.b.a().b()) {
                                try {
                                    webview.loadUrl(str2);
                                } catch (Exception e16) {
                                    f.b("DownloadCallbackWebImpl", "doJsCallBack >>> ", e16);
                                }
                            }
                        }
                    });
                }
            }
        } catch (Exception e16) {
            f.d("DownloadCallbackWebImpl", "doJsCallback >>> ", e16);
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
            f.d("DownloadCallbackWebImpl", "getCallBackJsonObject >>> ", e16);
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
            f.d("DownloadCallbackWebImpl", "getCallBackJsonObject >>> ", e16);
        }
        return jSONObject.toString();
    }

    protected String g(int i3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(TPReportKeys.LiveExKeys.LIVE_EX_NET_TYPE, i3);
        } catch (JSONException e16) {
            f.d("DownloadCallbackWebImpl", "getCallBackJsonObject >>> ", e16);
        }
        return jSONObject.toString();
    }

    public JSONObject i(DownloadInfo downloadInfo, int i3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", downloadInfo.f341184e);
            jSONObject.put("state", downloadInfo.f());
            jSONObject.put(WadlResult.WEB_KEY_PROGRESS, downloadInfo.Q);
            jSONObject.put("packagename", downloadInfo.f341189h);
            jSONObject.put("ismyapp", downloadInfo.J);
            jSONObject.put("download_from", downloadInfo.W);
            jSONObject.put("realDownloadType", downloadInfo.K);
            jSONObject.put("via", downloadInfo.C);
            jSONObject.put(WadlResult.WEB_KEY_WRITE_CODE_STATE, downloadInfo.f341179a0);
            jSONObject.put("extraInfo", downloadInfo.f341181c0);
            jSONObject.put(WadlResult.WEB_KEY_IS_AUTO_INSTALL_BY_SDK, downloadInfo.f341183d0);
            jSONObject.put("queryResult", i3);
        } catch (JSONException e16) {
            f.d("DownloadCallbackWebImpl", "onNetworkConnect " + e16.getMessage(), e16);
        }
        return jSONObject;
    }

    @Override // com.tencent.open.downloadnew.DownloadListener
    public void installSucceed(String str, String str2) {
        d(f(str, 6, str2));
    }

    @Override // com.tencent.open.downloadnew.DownloadListener
    public void onDownloadCancel(DownloadInfo downloadInfo) {
        if (downloadInfo != null) {
            d(i(downloadInfo, -1).toString());
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
            d(i(downloadInfo, -1).toString());
        }
    }

    @Override // com.tencent.open.downloadnew.DownloadListener
    public void onDownloadPause(DownloadInfo downloadInfo) {
        if (downloadInfo != null) {
            d(i(downloadInfo, -1).toString());
        }
    }

    @Override // com.tencent.open.downloadnew.DownloadListener
    public void onDownloadUpdate(List<DownloadInfo> list) {
        if (list != null) {
            JSONArray jSONArray = new JSONArray();
            Iterator<DownloadInfo> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.mo162put(i(it.next(), -1));
            }
            d(jSONArray.toString());
        }
    }

    @Override // com.tencent.open.downloadnew.DownloadListener
    public void onDownloadWait(DownloadInfo downloadInfo) {
        if (downloadInfo != null) {
            d(i(downloadInfo, -1).toString());
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

    @Override // com.tencent.open.appcommon.now.download.b
    public void c(List<DownloadInfo> list) {
    }
}
