package com.tencent.hippy.qq.adapter;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.hippy.qq.api.IBaseHttpAdapter;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.mtt.hippy.adapter.http.HippyHttpAdapter;
import com.tencent.mtt.hippy.adapter.http.HippyHttpRequest;
import com.tencent.mtt.hippy.adapter.http.HippyHttpResponse;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.CookieManager;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/* compiled from: P */
/* loaded from: classes7.dex */
public class HippyQQNewHttpAdapter extends HippyQQHttpAdapter {
    private static final String TAG = "HippyQQHttpAdapter";

    /* compiled from: P */
    /* loaded from: classes7.dex */
    protected class QQHttpTaskCallbackImpl implements HippyHttpAdapter.HttpTaskCallback {
        private final Promise mPromise;

        public QQHttpTaskCallbackImpl(Promise promise) {
            this.mPromise = promise;
        }

        @Override // com.tencent.mtt.hippy.adapter.http.HippyHttpAdapter.HttpTaskCallback
        public void onTaskFailed(HippyHttpRequest hippyHttpRequest, Throwable th5) {
            if (th5 != null) {
                this.mPromise.resolve(th5.getMessage());
            }
        }

        @Override // com.tencent.mtt.hippy.adapter.http.HippyHttpAdapter.HttpTaskCallback
        public void onTaskSuccess(HippyHttpRequest hippyHttpRequest, HippyHttpResponse hippyHttpResponse) throws Exception {
            String str;
            if (hippyHttpResponse.getInputStream() != null) {
                InputStream inputStream = hippyHttpResponse.getInputStream();
                if (HippyQQNewHttpAdapter.this.isGzipRequest(hippyHttpRequest)) {
                    inputStream = new GZIPInputStream(inputStream);
                }
                StringBuilder sb5 = new StringBuilder();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb5.append(readLine);
                    sb5.append("\r\n");
                }
                str = sb5.toString();
            } else {
                str = null;
            }
            CookieManager qQCookieManager = HippyQQNewHttpAdapter.this.getQQCookieManager();
            HippyMap hippyMap = new HippyMap();
            hippyMap.pushInt(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, hippyHttpResponse.getStatusCode().intValue());
            hippyMap.pushString("statusLine", hippyHttpResponse.getResponseMessage());
            HippyMap hippyMap2 = new HippyMap();
            if (hippyHttpResponse.getRspHeaderMaps() != null && !hippyHttpResponse.getRspHeaderMaps().isEmpty()) {
                for (String str2 : hippyHttpResponse.getRspHeaderMaps().keySet()) {
                    List<String> list = hippyHttpResponse.getRspHeaderMaps().get(str2);
                    HippyArray hippyArray = new HippyArray();
                    if (list != null && !list.isEmpty()) {
                        boolean z16 = false;
                        for (int i3 = 0; i3 < list.size(); i3++) {
                            String str3 = list.get(i3);
                            hippyArray.pushString(str3);
                            if ("Set-Cookie".equalsIgnoreCase(str2) && qQCookieManager != null) {
                                qQCookieManager.setCookie(hippyHttpRequest.getUrl(), str3);
                                z16 = true;
                            }
                        }
                        if (z16) {
                            HippyQQNewHttpAdapter.this.syncCookie();
                        }
                    }
                    hippyMap2.pushArray(str2, hippyArray);
                }
            }
            hippyMap.pushMap("respHeaders", hippyMap2);
            if (str == null) {
                str = "";
            }
            hippyMap.pushString("respBody", str);
            this.mPromise.resolve(hippyMap);
        }
    }

    public HippyQQNewHttpAdapter(IBaseHttpAdapter iBaseHttpAdapter, OpenHippyInfo openHippyInfo) {
        super(iBaseHttpAdapter, openHippyInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isGzipRequest(HippyHttpRequest hippyHttpRequest) {
        Map<String, Object> headers;
        if (hippyHttpRequest == null || (headers = hippyHttpRequest.getHeaders()) == null) {
            return false;
        }
        for (Map.Entry<String, Object> entry : headers.entrySet()) {
            String key = entry.getKey();
            if (key != null && key.equalsIgnoreCase("Accept-Encoding")) {
                Object value = entry.getValue();
                if (value instanceof ArrayList) {
                    Iterator it = ((ArrayList) value).iterator();
                    while (it.hasNext()) {
                        String str = (String) it.next();
                        if (str.equalsIgnoreCase("gzip") || str.equalsIgnoreCase("deflate")) {
                            return true;
                        }
                    }
                } else {
                    continue;
                }
            }
        }
        return false;
    }

    @Override // com.tencent.mtt.hippy.adapter.http.DefaultHttpAdapter
    protected void clearCookie(@NonNull String str) {
        CookieManager qQCookieManager = getQQCookieManager();
        if (qQCookieManager == null) {
            return;
        }
        String cookie = qQCookieManager.getCookie(str);
        if (TextUtils.isEmpty(cookie)) {
            return;
        }
        for (String str2 : cookie.split(";")) {
            qQCookieManager.setCookie(str, str2 + ";Max-Age=0");
        }
        syncCookie();
    }

    @Override // com.tencent.mtt.hippy.adapter.http.DefaultHttpAdapter, com.tencent.mtt.hippy.adapter.http.HippyHttpAdapter
    public void fetch(HippyMap hippyMap, Promise promise, Map map) {
        HippyHttpRequest generateHttpRequest = generateHttpRequest(hippyMap, promise, map);
        if (generateHttpRequest != null) {
            handleRequestCookie(generateHttpRequest);
            sendRequest(generateHttpRequest, new QQHttpTaskCallbackImpl(promise));
        }
    }

    @Override // com.tencent.mtt.hippy.adapter.http.DefaultHttpAdapter, com.tencent.mtt.hippy.adapter.http.HippyHttpAdapter
    public void getCookie(String str, Promise promise) {
        CookieManager qQCookieManager = getQQCookieManager();
        if (qQCookieManager == null) {
            promise.reject("get cookie manager failed!");
        } else {
            promise.resolve(qQCookieManager.getCookie(str));
        }
    }

    @Nullable
    protected CookieManager getQQCookieManager() {
        try {
            CookieManager cookieManager = CookieManager.getInstance();
            if (cookieManager != null && !cookieManager.acceptCookie()) {
                cookieManager.setAcceptCookie(true);
            }
            return cookieManager;
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "getQQCookieManager e:", th5);
            return null;
        }
    }

    @Override // com.tencent.mtt.hippy.adapter.http.DefaultHttpAdapter
    protected void handleRequestCookie(HippyHttpRequest hippyHttpRequest) {
        String url = hippyHttpRequest.getUrl();
        HippyArray requestCookies = hippyHttpRequest.getRequestCookies();
        if (url == null) {
            return;
        }
        if (requestCookies != null) {
            saveCookie2Manager(url, requestCookies);
        }
        CookieManager qQCookieManager = getQQCookieManager();
        if (qQCookieManager != null) {
            String cookie = qQCookieManager.getCookie(url);
            if (!TextUtils.isEmpty(cookie)) {
                hippyHttpRequest.addHeader("Cookie", cookie);
            }
        }
    }

    @Override // com.tencent.mtt.hippy.adapter.http.DefaultHttpAdapter
    protected void saveCookie2Manager(@NonNull String str, @Nullable String str2, @Nullable String str3) {
        CookieManager qQCookieManager = getQQCookieManager();
        if (qQCookieManager != null && str2 != null) {
            for (String str4 : str2.replaceAll("\\s+", "").split(";")) {
                if (str4 != null && str4.trim().length() > 0) {
                    qQCookieManager.setCookie(str, resetCookieIfNeeded(str4, str3));
                }
            }
            syncCookie();
        }
    }

    @Override // com.tencent.mtt.hippy.adapter.http.DefaultHttpAdapter
    protected void syncCookie() {
        if (getQQCookieManager() != null) {
            getQQCookieManager().flush();
        }
    }
}
