package cooperation.qzone.webviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasOfflineImageUrlApi;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.webso.WebSoService;
import com.tencent.mobileqq.webview.webso.c;
import com.tencent.mobileqq.webview.webso.e;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes38.dex */
public class QzoneWebViewOfflinePlugin extends WebViewPlugin {
    private static final int CGI_CODE_ERROR = 101;
    private static final int CGI_CODE_SUCCESS = 0;
    private static final int CGI_STATUS_ERROR = 100;
    private static final int CGI_STATUS_OPEN = 1;
    private static final int CGI_STATUS_SEND = 2;
    private static final int CGI_STATUS_SUCCESS = 4;
    private static final String JS_FUNC_CHECK_OFFLINE = "offlineResourceIsCached";
    public static final String NAMESPACE = "QzoneData";
    public static final String STR_DEVIDER = "://";
    private static final String TAG = "QzoneWebViewOfflinePlugin";
    private Handler cgiRequestHandler;
    private String proxyUrl;
    private String callback = "";
    private Handler preloadHandler = null;

    private String getCurrentUrl() {
        WebViewPlugin.b bVar = this.mRuntime;
        CustomWebView e16 = bVar != null ? bVar.e() : null;
        if (e16 != null) {
            return e16.getUrl();
        }
        return null;
    }

    private void handleCheckOfflineCache(String... strArr) {
        if (strArr != null && strArr.length >= 1) {
            try {
                JSONObject jSONObject = new JSONObject(strArr[0]);
                String optString = jSONObject.optString("url");
                String optString2 = jSONObject.optString("callback");
                if (optString != null && optString.length() != 0) {
                    if (optString2 != null && optString2.length() != 0) {
                        if (QLog.isColorLevel()) {
                            QLog.i(TAG, 2, "QzoneData.offlineResourceIsCached url: " + optString + ",callback: " + optString2);
                        }
                        boolean checkFileIfExist = QzoneOfflineCacheHelper.checkFileIfExist(optString);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("url", optString);
                        jSONObject2.put("hasData", checkFileIfExist ? 1 : 0);
                        callJs(optString2, jSONObject2.toString());
                        if (QLog.isColorLevel()) {
                            QLog.i(TAG, 2, "QzoneData.offlineResourceIsCached callback :" + jSONObject2.toString());
                            return;
                        }
                        return;
                    }
                    QLog.w(TAG, 1, "QzoneData.offlineResourceIsCached callback is empty");
                    return;
                }
                QLog.w(TAG, 1, "QzoneData.offlineResourceIsCached url is empty");
                return;
            } catch (Throwable th5) {
                QLog.e(TAG, 1, th5, new Object[0]);
                return;
            }
        }
        QLog.d(TAG, 1, "QzoneData.offlineResourceIsCached args is empty");
    }

    private void handlePreDownloadZip(String... strArr) {
        if (strArr != null && strArr.length >= 1) {
            try {
                JSONObject jSONObject = new JSONObject(strArr[0]);
                String optString = jSONObject.optString(QzoneZipCacheHelper.ZIPURL);
                final String optString2 = jSONObject.optString("business");
                if (QzoneZipCacheHelper.isDangerousLocalPath(optString2)) {
                    QLog.w(TAG, 1, "handlePreDownloadZip business \u53c2\u6570\u9519\u8bef\u3002");
                    return;
                }
                final String optString3 = jSONObject.optString(QzoneZipCacheHelper.DIR);
                if (QzoneZipCacheHelper.isDangerousLocalPath(optString3)) {
                    QLog.w(TAG, 1, "handlePreDownloadZip dir \u53c2\u6570\u9519\u8bef\u3002");
                    return;
                }
                int i3 = jSONObject.getInt("count");
                final String optString4 = jSONObject.optString("callback");
                if (optString != null && optString.length() != 0) {
                    if (optString4 != null && optString4.length() != 0) {
                        if (QLog.isColorLevel()) {
                            QLog.i(TAG, 2, "QzoneData.ResourceIsCached url: " + optString + ",dir " + optString3 + ",callback: " + optString4);
                        }
                        WebViewPlugin.b bVar = this.mRuntime;
                        if (QzoneZipCacheHelper.checkAndDownLoadFileIfNeeded(bVar != null ? bVar.b() : null, optString, optString2, optString3, i3, new QzoneZipCacheHelperCallBack() { // from class: cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin.2
                            @Override // cooperation.qzone.webviewplugin.QzoneZipCacheHelperCallBack
                            public void onResult(boolean z16) {
                                QzoneWebViewOfflinePlugin.this.jsCallback(z16, optString2, optString3, optString4);
                            }

                            @Override // cooperation.qzone.webviewplugin.QzoneZipCacheHelperCallBack
                            public void onResultOfNativeRequest(boolean z16, String str, String str2) {
                            }
                        })) {
                            jsCallback(true, optString2, optString3, optString4);
                            return;
                        }
                        return;
                    }
                    QLog.w(TAG, 1, "QzoneData.ResourceIsCached callback is empty");
                    return;
                }
                QLog.w(TAG, 1, "QzoneData.ResourceIsCached url is empty");
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        QLog.d(TAG, 1, "QzoneData.offlineResourceIsCached args is empty");
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00a0, code lost:
    
        r8 = r6.toString();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void handleWnsCgi(String... strArr) {
        if (strArr != null && strArr.length >= 1) {
            c.a aVar = new c.a();
            try {
                JSONObject jSONObject = new JSONObject(strArr[0]);
                aVar.f315008f = jSONObject.optString("callback");
                String optString = jSONObject.optString("url");
                aVar.f315003a = optString;
                if (!TextUtils.isEmpty(optString)) {
                    if (isUrlHostEqual(getCurrentUrl(), aVar.f315003a)) {
                        String optString2 = jSONObject.optString("method");
                        aVar.f315004b = optString2;
                        if (!"GET".equalsIgnoreCase(optString2) && !"POST".equalsIgnoreCase(aVar.f315004b)) {
                            throw new Exception("no such method support!!!");
                        }
                        Object opt = jSONObject.opt("body");
                        String str = null;
                        if (opt instanceof JSONObject) {
                            aVar.f315007e = "application/x-www-form-urlencoded";
                            aVar.f315006d = json2UrlEncoded((JSONObject) opt);
                        } else {
                            aVar.f315007e = null;
                            aVar.f315006d = opt.toString();
                        }
                        Object opt2 = jSONObject.opt("header");
                        if (opt2 != null && !(opt2 instanceof JSONObject)) {
                            throw new Exception("header format error!!!");
                        }
                        aVar.f315005c = str;
                        aVar.f315009g = jSONObject.optBoolean("dataNeedBase64", false);
                        aVar.f315010h = (int) (jSONObject.optDouble("timeout", 0.0d) * 1000.0d);
                        aVar.f315011i = jSONObject.opt("userinfo");
                        if (this.cgiRequestHandler == null) {
                            this.cgiRequestHandler = new Handler(Looper.getMainLooper()) { // from class: cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin.3
                                @Override // android.os.Handler
                                public void handleMessage(Message message) {
                                    Object obj = message.obj;
                                    if ((obj instanceof c.b) && message.what == 204) {
                                        QzoneWebViewOfflinePlugin.this.onCgiRsp((c.b) obj);
                                    }
                                }
                            };
                        }
                        if (c.c().h(aVar, this.cgiRequestHandler)) {
                            return;
                        }
                        c.b bVar = new c.b();
                        bVar.f315013b = aVar.f315003a;
                        bVar.f315016e = 1;
                        bVar.f315020i = 101;
                        bVar.f315021j = "send req fail!";
                        notifyCgiStatus(bVar, aVar.f315008f);
                        return;
                    }
                    throw new Exception("not support for cross-domain request!!! current host=" + getUrlHost(getCurrentUrl()) + ",req host=" + getUrlHost(aVar.f315003a));
                }
                throw new Exception("url is empty!!!");
            } catch (Exception e16) {
                QLog.w(TAG, 1, "wnscgi error,args is " + strArr[0], e16);
                c.b bVar2 = new c.b();
                bVar2.f315013b = aVar.f315003a;
                bVar2.f315016e = 3;
                bVar2.f315020i = 101;
                bVar2.f315021j = e16.getMessage();
                String str2 = aVar.f315008f;
                bVar2.f315019h = str2;
                notifyCgiStatus(bVar2, str2);
                return;
            }
        }
        QLog.d(TAG, 1, "QzoneData.handleWnsCgi args is empty");
    }

    public static boolean isUrlHostEqual(String str, String str2) {
        return TextUtils.equals(getUrlHost(str), getUrlHost(str2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jsCallback(boolean z16, String str, String str2, String str3) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (z16) {
                String[] folderFileNameList = QzoneZipCacheHelper.getFolderFileNameList(str, str2);
                JSONArray jSONArray = new JSONArray();
                if (folderFileNameList != null) {
                    for (String str4 : folderFileNameList) {
                        jSONArray.mo162put(str4);
                    }
                }
                jSONObject.put(QzoneZipCacheHelper.FILEB_NAME_LIST, jSONArray);
            }
            callJs(str3, jSONObject.toString());
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "QzoneData.offlineResourceIsCached callback :" + jSONObject.toString());
            }
        } catch (Throwable unused) {
        }
    }

    public static String json2UrlEncoded(JSONObject jSONObject) {
        StringBuilder sb5 = new StringBuilder();
        try {
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                String string = jSONObject.getString(str);
                sb5.append(URLEncoder.encode(str, "UTF-8"));
                sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                sb5.append(URLEncoder.encode(string, "UTF-8"));
                sb5.append(ContainerUtils.FIELD_DELIMITER);
            }
            if (sb5.length() > 0) {
                sb5.deleteCharAt(sb5.length() - 1);
            }
            return sb5.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    private void notifyCgiStatus(c.b bVar, String str) {
        String str2;
        if (TextUtils.isEmpty(str) || bVar == null) {
            return;
        }
        QLog.i(TAG, 1, "state is " + bVar);
        try {
            JSONObject jSONObject = new JSONObject();
            int i3 = bVar.f315016e;
            if (i3 == 1) {
                jSONObject.put("status", 2);
            } else if (i3 == 2) {
                jSONObject.put("status", 4);
            } else if (i3 == 3) {
                jSONObject.put("status", 1);
            } else if (i3 == 4) {
                jSONObject.put("status", 100);
            }
            if (!TextUtils.isEmpty(bVar.f315013b)) {
                jSONObject.put("url", bVar.f315013b);
            }
            jSONObject.put("code", bVar.f315020i);
            if (!TextUtils.isEmpty(bVar.f315021j)) {
                jSONObject.put("msg", bVar.f315021j);
            }
            jSONObject.put("dataIsBase64", bVar.f315018g);
            if (!TextUtils.isEmpty(bVar.f315015d)) {
                if (bVar.f315018g) {
                    str2 = PluginBaseInfoHelper.Base64Helper.encodeToString(bVar.f315015d.getBytes(), 0);
                } else {
                    str2 = bVar.f315015d;
                }
                jSONObject.put("data", str2);
            } else {
                jSONObject.put("data", "");
            }
            int i16 = bVar.f315017f;
            if (i16 > 0) {
                jSONObject.put("httpStatusCode", i16);
            }
            if (!TextUtils.isEmpty(bVar.f315014c)) {
                jSONObject.put("header", new JSONObject(bVar.f315014c));
            }
            Object obj = bVar.f315022k;
            if (obj != null) {
                jSONObject.put("userinfo", obj);
            }
            callJs(str, jSONObject.toString());
            QLog.i(TAG, 1, "wnscgi@ status=" + bVar.f315016e + ",total cost " + (System.currentTimeMillis() - bVar.f315025n) + " ms");
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private Object shouldInterceptRequest(String str) {
        WebViewPlugin.b bVar = this.mRuntime;
        Activity a16 = bVar != null ? bVar.a() : null;
        Intent intent = a16 != null ? a16.getIntent() : null;
        String stringExtra = intent != null ? intent.getStringExtra("url") : null;
        WebViewPlugin.b bVar2 = this.mRuntime;
        AppInterface b16 = bVar2 != null ? bVar2.b() : null;
        WebViewPlugin.b bVar3 = this.mRuntime;
        return QzoneOfflinePluginJsForQQ.shouldInterceptRequest(b16, bVar3 != null ? bVar3.e() : null, str, stringExtra);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "QzoneData";
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public long getWebViewEventByNameSpace(String str) {
        return 8L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleEvent(String str, long j3, Map<String, Object> map) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        if (!"QzoneData".equals(str2)) {
            return false;
        }
        if (JS_FUNC_CHECK_OFFLINE.equalsIgnoreCase(str3)) {
            handleCheckOfflineCache(strArr);
            return true;
        }
        if ("wnsCgi".equalsIgnoreCase(str3)) {
            handleWnsCgi(strArr);
            return true;
        }
        if (QZoneJsConstants.METHOD_PREDOWNLOAD_ZIP.equalsIgnoreCase(str3)) {
            handlePreDownloadZip(strArr);
            return true;
        }
        if (!"offlineHttpProxy".equals(str3) || strArr.length != 1) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(strArr[0]);
            if (jSONObject.has("proxyUrl") && jSONObject.has("isCheckCache")) {
                this.proxyUrl = jSONObject.optString("proxyUrl");
                boolean z16 = jSONObject.getBoolean("isCheckCache");
                this.callback = jSONObject.getString("callback");
                if (z16 && !TextUtils.isEmpty(e.o(this.proxyUrl))) {
                    if (!TextUtils.isEmpty(this.callback)) {
                        callJs(this.callback + "({\"code\":0});");
                    }
                    return true;
                }
                if (this.preloadHandler == null) {
                    this.preloadHandler = new Handler(Looper.getMainLooper()) { // from class: cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin.1
                        @Override // android.os.Handler
                        public void handleMessage(Message message) {
                            if (message.what == 203) {
                                Object obj = message.obj;
                                if (obj instanceof Bundle) {
                                    Bundle bundle = (Bundle) obj;
                                    String string = bundle.getString("url");
                                    if (bundle.getInt("req_state", 0) != 2 || TextUtils.isEmpty(QzoneWebViewOfflinePlugin.this.callback) || TextUtils.isEmpty(QzoneWebViewOfflinePlugin.this.proxyUrl) || !QzoneWebViewOfflinePlugin.this.proxyUrl.equals(string)) {
                                        return;
                                    }
                                    int i3 = bundle.getInt("result_code");
                                    JSONObject jSONObject2 = new JSONObject();
                                    try {
                                        if (i3 == 0) {
                                            jSONObject2.put("code", 0);
                                        } else {
                                            jSONObject2.put("code", i3);
                                            jSONObject2.put("msg", bundle.getString("error_message"));
                                        }
                                    } catch (Exception unused) {
                                    }
                                    QzoneWebViewOfflinePlugin.this.callJs(QzoneWebViewOfflinePlugin.this.callback + "(" + jSONObject2.toString() + ");");
                                }
                            }
                        }
                    };
                }
                WebSoService.j().G(this.proxyUrl, this.preloadHandler);
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "exception =" + e16);
            }
        }
        return true;
    }

    protected void onCgiRsp(c.b bVar) {
        notifyCgiStatus(bVar, bVar.f315019h);
    }

    private String getStringValue(String str) {
        Intent intent;
        Bundle extras;
        try {
            Activity a16 = this.mRuntime.a();
            if (a16 == null || (intent = a16.getIntent()) == null || (extras = intent.getExtras()) == null) {
                return null;
            }
            return extras.getString(str);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public Object handleEvent(String str, long j3) {
        Object interceptRequest;
        if (j3 != 8) {
            return null;
        }
        if (this.mRuntime != null) {
            QzoneOfflinePluginJsForQQ.mWebView = new WeakReference<>(this.mRuntime.e());
            QzoneOfflinePluginJsForQQ.mActivity = new WeakReference<>(this.mRuntime.a());
        }
        WebViewPlugin.b bVar = this.mRuntime;
        return (bVar == null || bVar.a() == null || TextUtils.isEmpty(str) || !str.contains("vas_use_local_image=1") || (interceptRequest = ((IVasOfflineImageUrlApi) QRoute.api(IVasOfflineImageUrlApi.class)).interceptRequest(this.mRuntime.a(), str, j3)) == null) ? shouldInterceptRequest(str) : interceptRequest;
    }

    public static String getUrlHost(String str) {
        if (str == null) {
            return null;
        }
        try {
            return new URL(str).getHost().toLowerCase();
        } catch (Throwable unused) {
            return null;
        }
    }

    private static long getUrlClickTime(WebViewPlugin.b bVar) {
        if (bVar == null) {
            return 0L;
        }
        try {
            return bVar.a().getIntent().getLongExtra("preAct_time", 0L);
        } catch (Exception e16) {
            QLog.w(TAG, 2, "can not get click time", e16);
            return 0L;
        }
    }
}
