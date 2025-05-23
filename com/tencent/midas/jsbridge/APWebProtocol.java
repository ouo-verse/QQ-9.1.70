package com.tencent.midas.jsbridge;

import android.app.Activity;
import android.text.TextUtils;
import android.webkit.JsResult;
import android.webkit.WebView;
import com.tencent.midas.api.APMidasResponse;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.control.APMidasPayHelper;
import com.tencent.midas.data.APPluginDataInterface;
import com.tencent.midas.data.APPluginReportManager;
import com.tencent.midas.plugin.APPluginUtils;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.js.jsapi.a;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* loaded from: classes9.dex */
public class APWebProtocol {
    public static String URL_KEY_HEAD_CONTROL = "midasheader";
    public static String URL_KEY_HEAD_TITLE = "midastitle";
    public static String WEBACTION_CLOSE = "closeWeb";
    public static String WEBACTION_GETCGIEXTEND = "getCgiExtend";
    public static String WEBACTION_HEAD = "setHead";

    /* JADX INFO: Access modifiers changed from: protected */
    public static void AnalyzeWebEntry(Activity activity, Object obj, IAPWebPage iAPWebPage, String str) {
        HashMap<String, String> url2Map = APPluginUtils.url2Map(str);
        url2Map.get("page");
        String str2 = url2Map.get("action");
        url2Map.get("saveNumber");
        url2Map.get("saveType");
        String str3 = url2Map.get("callback");
        if (WEBACTION_GETCGIEXTEND.equals(str2)) {
            String reserv = APPluginDataInterface.singleton().getReserv();
            APLog.d("APWebResultPage", "sendCgiExtends() callback=" + str3 + ", extendStr=" + reserv);
            if (!TextUtils.isEmpty(reserv)) {
                try {
                    reserv = URLEncoder.encode(reserv, "UTF-8");
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
            H5CallBack(obj, str3, reserv);
            return;
        }
        if (WEBACTION_CLOSE.equals(str2)) {
            APPluginReportManager.getInstance().insertData(APPluginDataInterface.singleton().getLaunchInterface(), APPluginReportManager.MIDASPLUGIN_WEBPAGE_WEBCLOSE, "", "");
            APMidasResponse aPMidasResponse = new APMidasResponse();
            aPMidasResponse.resultCode = 100;
            aPMidasResponse.resultMsg = "\u5173\u95ed";
            APMidasPayHelper.midasCallBack(aPMidasResponse);
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        if (WEBACTION_HEAD.equals(str2)) {
            try {
                iAPWebPage.initHead(activity, url2Map.get(URL_KEY_HEAD_CONTROL), url2Map.get(URL_KEY_HEAD_TITLE));
            } catch (Exception e17) {
                e17.printStackTrace();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0016, code lost:
    
        if ((r2 instanceof org.json.JSONArray) != false) goto L8;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x001e A[Catch: Exception -> 0x007e, TRY_ENTER, TryCatch #0 {Exception -> 0x007e, blocks: (B:10:0x001e, B:11:0x003d, B:14:0x0050, B:17:0x0065, B:19:0x0069, B:22:0x002e), top: B:8:0x001c }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0050 A[Catch: Exception -> 0x007e, TRY_ENTER, TryCatch #0 {Exception -> 0x007e, blocks: (B:10:0x001e, B:11:0x003d, B:14:0x0050, B:17:0x0065, B:19:0x0069, B:22:0x002e), top: B:8:0x001c }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0065 A[Catch: Exception -> 0x007e, TryCatch #0 {Exception -> 0x007e, blocks: (B:10:0x001e, B:11:0x003d, B:14:0x0050, B:17:0x0065, B:19:0x0069, B:22:0x002e), top: B:8:0x001c }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x002e A[Catch: Exception -> 0x007e, TryCatch #0 {Exception -> 0x007e, blocks: (B:10:0x001e, B:11:0x003d, B:14:0x0050, B:17:0x0065, B:19:0x0069, B:22:0x002e), top: B:8:0x001c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void H5CallBack(Object obj, String str, String str2) {
        boolean z16;
        String format;
        Object nextValue;
        try {
            nextValue = new JSONTokener(str2).nextValue();
        } catch (JSONException | Exception unused) {
        }
        try {
            if (nextValue != null) {
                if (!(nextValue instanceof JSONObject)) {
                }
                z16 = true;
                if (!z16) {
                    format = String.format("typeof window[\"%s\"]==='function' && window[\"%s\"](%s);", str, str, str2);
                } else {
                    format = String.format("typeof window[\"%s\"]==='function' && window[\"%s\"](\"%s\");", str, str, str2);
                }
                APLog.i("callback", str);
                APLog.i("cb", format);
                if (!(obj instanceof WebView)) {
                    ((WebView) obj).loadUrl(a.JAVASCRIPT_PREFIX + format);
                    return;
                }
                if (obj instanceof com.tencent.smtt.sdk.WebView) {
                    ((com.tencent.smtt.sdk.WebView) obj).loadUrl(a.JAVASCRIPT_PREFIX + format);
                    return;
                }
                return;
            }
            if (!z16) {
            }
            APLog.i("callback", str);
            APLog.i("cb", format);
            if (!(obj instanceof WebView)) {
            }
        } catch (Exception e16) {
            APLog.d("H5CallBack", "H5CallBack() ex = " + e16.toString());
            return;
        }
        z16 = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean hookH5Method(Activity activity, WebView webView, String str, String str2, JsResult jsResult, IAPWebViewCallback iAPWebViewCallback) {
        if (TextUtils.isEmpty(str2) || !str2.startsWith("http://unipay.sdk.android/?")) {
            return false;
        }
        iAPWebViewCallback.WebChromeClientJsAlert(webView, str, str2, jsResult);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean hookH5Method(Activity activity, com.tencent.smtt.sdk.WebView webView, String str, String str2, com.tencent.smtt.export.external.interfaces.JsResult jsResult, IAPX5WebViewCallback iAPX5WebViewCallback) {
        if (TextUtils.isEmpty(str2) || !str2.startsWith("http://unipay.sdk.android/?")) {
            return false;
        }
        iAPX5WebViewCallback.WebChromeClientJsAlert(webView, str, str2, jsResult);
        return true;
    }
}
