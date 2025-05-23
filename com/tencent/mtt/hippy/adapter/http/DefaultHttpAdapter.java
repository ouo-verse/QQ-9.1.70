package com.tencent.mtt.hippy.adapter.http;

import android.text.TextUtils;
import android.webkit.CookieManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.mtt.hippy.adapter.http.HippyHttpAdapter;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.utils.LogUtils;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.zip.GZIPInputStream;
import org.apache.http.client.methods.HttpPut;

/* compiled from: P */
/* loaded from: classes20.dex */
public class DefaultHttpAdapter implements HippyHttpAdapter {
    private static final String TAG = "DefaultHttpAdapter";
    private ExecutorService mExecutorService;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    protected class HttpTaskCallbackImpl implements HippyHttpAdapter.HttpTaskCallback {
        private final Promise mPromise;

        public HttpTaskCallbackImpl(Promise promise) {
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
                if (DefaultHttpAdapter.this.isGzipRequest(hippyHttpRequest)) {
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
            CookieManager cookieManager = DefaultHttpAdapter.this.getCookieManager();
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
                            if ("Set-Cookie".equalsIgnoreCase(str2) && cookieManager != null) {
                                cookieManager.setCookie(hippyHttpRequest.getUrl(), str3);
                                z16 = true;
                            }
                        }
                        if (z16) {
                            DefaultHttpAdapter.this.syncCookie();
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

    private URL toURL(String str) throws MalformedURLException {
        int indexOf;
        URL url = new URL(str);
        if (url.getPath() == null || "".equals(url.getPath())) {
            if (url.getFile() != null && url.getFile().startsWith(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER) && (indexOf = str.indexOf(63)) != -1) {
                url = new URL(str.substring(0, indexOf) + '/' + str.substring(indexOf));
            }
            if (url.getFile() == null || "".equals(url.getFile())) {
                return new URL(str + "/");
            }
            return url;
        }
        return url;
    }

    protected void clearCookie(@NonNull String str) {
        CookieManager cookieManager = getCookieManager();
        if (cookieManager == null) {
            return;
        }
        String cookie = cookieManager.getCookie(str);
        if (TextUtils.isEmpty(cookie)) {
            return;
        }
        for (String str2 : cookie.split(";")) {
            cookieManager.setCookie(str, str2 + ";Max-Age=0");
        }
        syncCookie();
    }

    protected HttpURLConnection createConnection(HippyHttpRequest hippyHttpRequest) throws Exception {
        if (!TextUtils.isEmpty(hippyHttpRequest.getUrl())) {
            HttpURLConnection httpURLConnection = (HttpURLConnection) toURL(hippyHttpRequest.getUrl()).openConnection();
            if (TextUtils.isEmpty(hippyHttpRequest.getMethod())) {
                hippyHttpRequest.setMethod("GET");
            }
            httpURLConnection.setRequestMethod(hippyHttpRequest.getMethod());
            httpURLConnection.setUseCaches(hippyHttpRequest.isUseCaches());
            httpURLConnection.setInstanceFollowRedirects(hippyHttpRequest.isInstanceFollowRedirects());
            httpURLConnection.setConnectTimeout(hippyHttpRequest.getConnectTimeout());
            httpURLConnection.setReadTimeout(hippyHttpRequest.getReadTimeout());
            if (hippyHttpRequest.getMethod().equalsIgnoreCase("POST") || hippyHttpRequest.getMethod().equalsIgnoreCase(HttpPut.METHOD_NAME) || hippyHttpRequest.getMethod().equalsIgnoreCase("PATCH")) {
                httpURLConnection.setDoOutput(true);
            }
            return httpURLConnection;
        }
        throw new RuntimeException("url is null");
    }

    protected HippyHttpResponse createResponse(HttpURLConnection httpURLConnection) throws Exception {
        boolean z16;
        InputStream inputStream;
        HippyHttpResponse hippyHttpResponse = new HippyHttpResponse();
        parseResponseHeaders(httpURLConnection, hippyHttpResponse);
        InputStream inputStream2 = null;
        try {
            inputStream = httpURLConnection.getInputStream();
            z16 = false;
        } catch (IOException e16) {
            e16.printStackTrace();
            z16 = true;
            inputStream = null;
        }
        if (z16 || httpURLConnection.getResponseCode() >= 400) {
            try {
                inputStream2 = httpURLConnection.getErrorStream();
            } catch (Exception e17) {
                e17.printStackTrace();
            }
        }
        if (z16) {
            inputStream = inputStream2;
        }
        hippyHttpResponse.setInputStream(inputStream);
        hippyHttpResponse.setErrorStream(inputStream2);
        hippyHttpResponse.setResponseMessage(httpURLConnection.getResponseMessage());
        return hippyHttpResponse;
    }

    @Override // com.tencent.mtt.hippy.adapter.http.HippyHttpAdapter
    public void destroyIfNeed() {
        ExecutorService executorService = this.mExecutorService;
        if (executorService != null && !executorService.isShutdown()) {
            this.mExecutorService.shutdown();
            this.mExecutorService = null;
        }
    }

    protected void execute(Runnable runnable) {
        if (this.mExecutorService == null) {
            this.mExecutorService = ProxyExecutors.newFixedThreadPool(3);
        }
        this.mExecutorService.execute(runnable);
    }

    @Override // com.tencent.mtt.hippy.adapter.http.HippyHttpAdapter
    public void fetch(HippyMap hippyMap, Promise promise, Map map) {
        HippyHttpRequest generateHttpRequest = generateHttpRequest(hippyMap, promise, map);
        if (generateHttpRequest != null) {
            handleRequestCookie(generateHttpRequest);
            sendRequest(generateHttpRequest, new HttpTaskCallbackImpl(promise));
        }
    }

    protected void fillHeader(URLConnection uRLConnection, HippyHttpRequest hippyHttpRequest) {
        Map<String, Object> headers = hippyHttpRequest.getHeaders();
        if (headers != null && !headers.isEmpty()) {
            for (String str : headers.keySet()) {
                Object obj = headers.get(str);
                if (obj instanceof String) {
                    uRLConnection.setRequestProperty(str, (String) obj);
                } else if (obj instanceof List) {
                    List<String> list = (List) obj;
                    if (!list.isEmpty()) {
                        for (String str2 : list) {
                            if (!TextUtils.isEmpty(str2)) {
                                uRLConnection.addRequestProperty(str, str2);
                            }
                        }
                    }
                }
            }
        }
    }

    protected void fillPostBody(HttpURLConnection httpURLConnection, HippyHttpRequest hippyHttpRequest) throws IOException {
        if (TextUtils.isEmpty(hippyHttpRequest.getBody())) {
            return;
        }
        httpURLConnection.setRequestProperty("Content-Length", hippyHttpRequest.getBody().getBytes().length + "");
        DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
        dataOutputStream.write(hippyHttpRequest.getBody().getBytes());
        dataOutputStream.flush();
        dataOutputStream.close();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public HippyHttpRequest generateHttpRequest(HippyMap hippyMap, Promise promise, @Nullable Map map) {
        String str;
        boolean z16;
        if (hippyMap == null) {
            str = "invalid request param";
        } else {
            String string = hippyMap.getString("url");
            String string2 = hippyMap.getString("method");
            if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                HippyHttpRequest hippyHttpRequest = new HippyHttpRequest();
                hippyHttpRequest.setConnectTimeout(10000);
                hippyHttpRequest.setReadTimeout(10000);
                String string3 = hippyMap.getString("redirect");
                if (!TextUtils.isEmpty(string3) && TextUtils.equals("follow", string3)) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                hippyHttpRequest.setInstanceFollowRedirects(z16);
                hippyHttpRequest.setUseCaches(false);
                hippyHttpRequest.setMethod(string2);
                hippyHttpRequest.setUrl(string);
                HippyMap map2 = hippyMap.getMap("headers");
                if (map2 != null) {
                    hippyHttpRequest.setRequestCookies(map2.getArray("Cookie"));
                    hippyMapToRequestHeaders(hippyHttpRequest, map2);
                }
                hippyHttpRequest.setBody(hippyMap.getString("body"));
                hippyHttpRequest.setNativeParams(map);
                hippyHttpRequest.setInitParams(hippyMap);
                return hippyHttpRequest;
            }
            str = "no valid url for request";
        }
        promise.reject(str);
        return null;
    }

    @Override // com.tencent.mtt.hippy.adapter.http.HippyHttpAdapter
    public void getCookie(String str, Promise promise) {
        CookieManager cookieManager = getCookieManager();
        if (cookieManager == null) {
            promise.reject("get cookie manager failed!");
        } else {
            promise.resolve(cookieManager.getCookie(str));
        }
    }

    @Nullable
    protected CookieManager getCookieManager() {
        try {
            CookieManager cookieManager = CookieManager.getInstance();
            if (!cookieManager.acceptCookie()) {
                cookieManager.setAcceptCookie(true);
            }
            return cookieManager;
        } catch (IllegalArgumentException unused) {
            return null;
        } catch (Exception e16) {
            LogUtils.w(TAG, "getCookieManager: " + e16.getMessage());
            return null;
        }
    }

    protected void handleRequestCookie(HippyHttpRequest hippyHttpRequest) {
        String url = hippyHttpRequest.getUrl();
        HippyArray requestCookies = hippyHttpRequest.getRequestCookies();
        if (url == null) {
            return;
        }
        if (requestCookies != null) {
            saveCookie2Manager(url, requestCookies);
        }
        CookieManager cookieManager = getCookieManager();
        if (cookieManager != null) {
            String cookie = cookieManager.getCookie(url);
            if (!TextUtils.isEmpty(cookie)) {
                hippyHttpRequest.addHeader("Cookie", cookie);
            }
        }
    }

    protected void hippyMapToRequestHeaders(HippyHttpRequest hippyHttpRequest, HippyMap hippyMap) {
        String str;
        StringBuilder sb5;
        if (hippyHttpRequest != null && hippyMap != null) {
            for (String str2 : hippyMap.keySet()) {
                Object obj = hippyMap.get(str2);
                if (obj instanceof HippyArray) {
                    HippyArray hippyArray = (HippyArray) obj;
                    ArrayList arrayList = new ArrayList();
                    for (int i3 = 0; i3 < hippyArray.size(); i3++) {
                        Object obj2 = hippyArray.get(i3);
                        if (obj2 instanceof Number) {
                            sb5 = new StringBuilder();
                        } else if (obj2 instanceof Boolean) {
                            sb5 = new StringBuilder();
                        } else if (obj2 instanceof String) {
                            str = (String) obj2;
                            arrayList.add(str);
                        } else {
                            LogUtils.e("hippy_console", "Unsupported Request Header List Type");
                        }
                        sb5.append(obj2);
                        sb5.append("");
                        str = sb5.toString();
                        arrayList.add(str);
                    }
                    if (!arrayList.isEmpty()) {
                        hippyHttpRequest.addHeader(str2, arrayList);
                    }
                } else {
                    LogUtils.e("hippy_console", "Unsupported Request Header Type, Header Field Should All be an Array!!!");
                }
            }
        }
    }

    protected void parseResponseHeaders(HttpURLConnection httpURLConnection, HippyHttpResponse hippyHttpResponse) throws Exception {
        if (httpURLConnection == null) {
            return;
        }
        hippyHttpResponse.setStatusCode(Integer.valueOf(httpURLConnection.getResponseCode()));
        hippyHttpResponse.setRspHeaderMap(httpURLConnection.getHeaderFields());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NonNull
    public String resetCookieIfNeeded(@NonNull String str, @Nullable String str2) {
        String[] split = str.split(ContainerUtils.KEY_VALUE_DELIMITER);
        if (split.length != 1 && (split.length < 2 || split[1].trim().length() != 0)) {
            if (!TextUtils.isEmpty(str2)) {
                return str + ";expires=" + str2;
            }
            return str;
        }
        return split[0] + "=;Max-Age=0";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void saveCookie2Manager(String str, @NonNull HippyArray hippyArray) {
        for (int i3 = 0; i3 < hippyArray.size(); i3++) {
            saveCookie2Manager(str, (String) hippyArray.get(i3), null);
        }
    }

    @Override // com.tencent.mtt.hippy.adapter.http.HippyHttpAdapter
    public void sendRequest(final HippyHttpRequest hippyHttpRequest, final HippyHttpAdapter.HttpTaskCallback httpTaskCallback) {
        execute(new Runnable() { // from class: com.tencent.mtt.hippy.adapter.http.DefaultHttpAdapter.1
            @Override // java.lang.Runnable
            public void run() {
                HttpURLConnection httpURLConnection;
                if (httpTaskCallback == null) {
                    return;
                }
                HippyHttpResponse hippyHttpResponse = null;
                try {
                    httpURLConnection = DefaultHttpAdapter.this.createConnection(hippyHttpRequest);
                } catch (Throwable th5) {
                    th = th5;
                    httpURLConnection = null;
                }
                try {
                    DefaultHttpAdapter.this.fillHeader(httpURLConnection, hippyHttpRequest);
                    DefaultHttpAdapter.this.fillPostBody(httpURLConnection, hippyHttpRequest);
                    hippyHttpResponse = DefaultHttpAdapter.this.createResponse(httpURLConnection);
                    httpTaskCallback.onTaskSuccess(hippyHttpRequest, hippyHttpResponse);
                    if (hippyHttpResponse != null) {
                        hippyHttpResponse.close();
                    }
                    if (httpURLConnection == null) {
                    }
                } catch (Throwable th6) {
                    th = th6;
                    try {
                        httpTaskCallback.onTaskFailed(hippyHttpRequest, th);
                    } finally {
                        if (hippyHttpResponse != null) {
                            hippyHttpResponse.close();
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                    }
                }
            }
        });
    }

    @Override // com.tencent.mtt.hippy.adapter.http.HippyHttpAdapter
    public void setCookie(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && str2 != null) {
            if (str2.trim().length() == 0) {
                clearCookie(str);
            } else {
                saveCookie2Manager(str, str2, str3);
            }
        }
    }

    protected void syncCookie() {
        if (getCookieManager() != null) {
            getCookieManager().flush();
        }
    }

    protected void saveCookie2Manager(@NonNull String str, @Nullable String str2, @Nullable String str3) {
        CookieManager cookieManager = getCookieManager();
        if (cookieManager == null || str2 == null) {
            return;
        }
        for (String str4 : str2.replaceAll("\\s+", "").split(";")) {
            if (str4 != null && str4.trim().length() > 0) {
                cookieManager.setCookie(str, resetCookieIfNeeded(str4, str3));
            }
        }
        syncCookie();
    }
}
