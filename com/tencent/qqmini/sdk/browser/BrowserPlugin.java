package com.tencent.qqmini.sdk.browser;

import android.app.Activity;
import android.webkit.WebView;
import androidx.fragment.app.Fragment;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: classes23.dex */
public class BrowserPlugin {
    public static final String KEY_ERROR_CODE = "errorCode";
    public static final String KEY_ERROR_MSG = "errorMsg";
    public static final String KEY_PERFORMANCE = "performanceData";
    public static final String KEY_REQUEST_URL = "requestUrl";
    public static final String KEY_TARGET = "target";
    public static final String KEY_URL = "url";
    AtomicBoolean inited = new AtomicBoolean(false);
    WeakReference<Activity> mActivity;
    WeakReference<Fragment> mFragment;
    WeakReference<WebView> mWebView;

    public static JSONObject getJsonFromJSBridge(String str) {
        int i3;
        try {
            int indexOf = str.indexOf(ContainerUtils.KEY_VALUE_DELIMITER);
            if (indexOf != -1 && (i3 = indexOf + 1) <= str.length() - 1) {
                return new JSONObject(URLDecoder.decode(str.substring(i3), "UTF-8"));
            }
            throw new Exception("illegal json");
        } catch (Exception e16) {
            QMLog.e("WebViewPlugin", "getJsonFromJSBridge error!" + str, e16);
            return null;
        }
    }

    protected Object handleEvent(String str, long j3) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean handleJsRequest(String str, String str2, String str3, String... strArr) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void initRuntime(Activity activity) {
        if (this.inited.compareAndSet(false, true)) {
            this.mActivity = new WeakReference<>(activity);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onWebViewCreated(WebView webView) {
        if (webView != null) {
            this.mWebView = new WeakReference<>(webView);
        }
    }

    public void setFragment(Fragment fragment) {
        this.mFragment = new WeakReference<>(fragment);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean handleEvent(String str, long j3, Map<String, Object> map) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onCreate() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDestroy() {
    }
}
