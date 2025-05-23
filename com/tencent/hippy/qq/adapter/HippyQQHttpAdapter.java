package com.tencent.hippy.qq.adapter;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.api.IBaseHttpAdapter;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.offline.HippyOfflineAssist;
import com.tencent.hippy.qq.utils.HippyAccessHelper;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.hippy.qq.utils.HippyUtils;
import com.tencent.mobileqq.pskey.api.IPskeyManager;
import com.tencent.mtt.hippy.adapter.http.DefaultHttpAdapter;
import com.tencent.mtt.hippy.adapter.http.HippyHttpAdapter;
import com.tencent.mtt.hippy.adapter.http.HippyHttpRequest;
import com.tencent.mtt.hippy.adapter.http.HippyHttpResponse;
import com.tencent.open.base.http.HttpBaseUtil;
import com.tencent.qphone.base.util.QLog;
import dk0.c;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes7.dex */
public class HippyQQHttpAdapter extends DefaultHttpAdapter {
    private static final String COOKIE_KEY_PSKEY = "p_skey";
    private static final String COOKIE_KEY_PUIN = "p_uin";
    private static final int HTTP_STATUS_CODE_OK = 200;
    private static final String TAG = "HippyQQHttpAdapter";
    IBaseHttpAdapter mHttpAdapter;
    OpenHippyInfo mOpenHippyInfo;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class PSKeyCallback implements sd2.a {
        private HippyHttpAdapter.HttpTaskCallback callback;
        private HippyHttpRequest hippyHttpRequest;
        private IBaseHttpAdapter httpAdapter;
        private OpenHippyInfo mOpenHippyInfo;
        private String domain = "";
        private boolean isRefreshPSKey = false;

        PSKeyCallback() {
        }

        @Override // sd2.a
        public void onFail(@NonNull String str) {
            QLog.e(HippyQQHttpAdapter.TAG, 1, "getPSKey failed:", str);
            IPskeyManager d16 = HippyQQHttpAdapter.d();
            if (!this.isRefreshPSKey || d16 == null) {
                HippyQQHttpAdapter.doSendRequest(this.httpAdapter, this.hippyHttpRequest, this.callback);
            } else {
                PSKeyCallback pSKeyCallback = new PSKeyCallback();
                pSKeyCallback.httpAdapter = this.httpAdapter;
                pSKeyCallback.hippyHttpRequest = this.hippyHttpRequest;
                pSKeyCallback.callback = this.callback;
                pSKeyCallback.mOpenHippyInfo = this.mOpenHippyInfo;
                pSKeyCallback.domain = this.domain;
                pSKeyCallback.isRefreshPSKey = false;
                d16.replacePskey(new String[]{this.domain}, pSKeyCallback);
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("domain", this.domain);
            hashMap.put("reportFrom", "dynamicLoad");
            hashMap.put(HippyReporter.EXTRA_KEY_REPORT_ERRMSG, str);
            HippyReporter.getInstance().reportToDengTa(this.mOpenHippyInfo.bundleName, 0, HippyReporter.EventCode.HIPPY_PSKEY, -1, hashMap);
        }

        @Override // sd2.a
        public void onSuccess(@NonNull Map<String, String> map) {
            String str = map.get(this.domain);
            String cookie = HippyQQHttpAdapter.getCookie(this.hippyHttpRequest);
            HashMap hashMap = new HashMap();
            hashMap.put("p_skey", str);
            hashMap.put("p_uin", HippyQQHttpAdapter.e());
            this.hippyHttpRequest.addHeader("Cookie", HippyQQHttpAdapter.addCookie(cookie, hashMap));
            HippyQQHttpAdapter.doSendRequest(this.httpAdapter, this.hippyHttpRequest, this.callback);
        }
    }

    public HippyQQHttpAdapter(IBaseHttpAdapter iBaseHttpAdapter, OpenHippyInfo openHippyInfo) {
        this.mHttpAdapter = iBaseHttpAdapter;
        this.mOpenHippyInfo = openHippyInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String addCookie(String str, HashMap<String, String> hashMap) {
        if (hashMap != null && hashMap.size() > 0) {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            HashMap<String, String> parseCookie = parseCookie(str);
            parseCookie.putAll(hashMap);
            return serializeCookie(parseCookie);
        }
        return str;
    }

    static /* bridge */ /* synthetic */ IPskeyManager d() {
        return getPSKeyManager();
    }

    private void doSSRRequest(HippyHttpRequest hippyHttpRequest, HippyHttpAdapter.HttpTaskCallback httpTaskCallback) {
        String str = this.mOpenHippyInfo.domain;
        if (TextUtils.isEmpty(str)) {
            str = HippyAccessHelper.getDomainByBundleName(this.mOpenHippyInfo.bundleName);
        }
        IPskeyManager pSKeyManager = getPSKeyManager();
        if (!TextUtils.isEmpty(str) && pSKeyManager != null) {
            PSKeyCallback pSKeyCallback = new PSKeyCallback();
            pSKeyCallback.httpAdapter = this.mHttpAdapter;
            pSKeyCallback.hippyHttpRequest = hippyHttpRequest;
            pSKeyCallback.callback = httpTaskCallback;
            pSKeyCallback.mOpenHippyInfo = this.mOpenHippyInfo;
            pSKeyCallback.domain = str;
            pSKeyCallback.isRefreshPSKey = false;
            pSKeyManager.getPskey(new String[]{str}, pSKeyCallback);
            return;
        }
        doSendRequest(this.mHttpAdapter, hippyHttpRequest, httpTaskCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void doSendRequest(IBaseHttpAdapter iBaseHttpAdapter, final HippyHttpRequest hippyHttpRequest, final HippyHttpAdapter.HttpTaskCallback httpTaskCallback) {
        dk0.a violaHttpRequest = toViolaHttpRequest(hippyHttpRequest);
        final HashMap hashMap = new HashMap();
        iBaseHttpAdapter.sendRequest(violaHttpRequest, new c.a() { // from class: com.tencent.hippy.qq.adapter.HippyQQHttpAdapter.1
            @Override // dk0.c.a
            public void onHeadersReceived(int i3, Map<String, List<String>> map) {
                if (map != null) {
                    hashMap.putAll(map);
                }
            }

            @Override // dk0.c.a
            public void onHttpFinish(dk0.b bVar) {
                HippyHttpResponse hippyHttpResponse = HippyQQHttpAdapter.toHippyHttpResponse(bVar, hashMap);
                HippyHttpAdapter.HttpTaskCallback httpTaskCallback2 = httpTaskCallback;
                if (httpTaskCallback2 != null) {
                    try {
                        httpTaskCallback2.onTaskSuccess(hippyHttpRequest, hippyHttpResponse);
                    } catch (Exception e16) {
                        QLog.e(HippyQQHttpAdapter.TAG, 1, "onHttpFinish e:", e16);
                    } catch (OutOfMemoryError e17) {
                        QLog.e(HippyQQHttpAdapter.TAG, 1, "onHttpFinish oom:", e17);
                    }
                }
            }

            @Override // dk0.c.a
            public void onHttpStart() {
            }
        }, false);
    }

    static /* bridge */ /* synthetic */ String e() {
        return getPUin();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getCookie(HippyHttpRequest hippyHttpRequest) {
        Map<String, Object> headers = hippyHttpRequest.getHeaders();
        if (headers == null) {
            return null;
        }
        Object obj = headers.get("Cookie");
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            if (list.size() > 0 && list.get(0) != null) {
                return list.get(0).toString();
            }
        }
        return null;
    }

    private static IPskeyManager getPSKeyManager() {
        AppInterface appInterface = HippyUtils.getAppInterface();
        if (appInterface != null) {
            return (IPskeyManager) appInterface.getRuntimeService(IPskeyManager.class, "all");
        }
        return null;
    }

    private static String getPUin() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            return HttpBaseUtil.a(peekAppRuntime.getAccount());
        }
        return null;
    }

    private static boolean isSSRRequest(String str) {
        if (TextUtils.isEmpty(str) || !str.startsWith("http")) {
            return false;
        }
        String queryParameter = Uri.parse(str).getQueryParameter("isSSRRequest");
        if (TextUtils.isEmpty(queryParameter) || !queryParameter.equals("1")) {
            return false;
        }
        return true;
    }

    private static HashMap<String, String> parseCookie(String str) {
        String[] split;
        HashMap<String, String> hashMap = new HashMap<>();
        String[] split2 = str.trim().split(";");
        if (split2 == null) {
            return hashMap;
        }
        for (String str2 : split2) {
            if (!TextUtils.isEmpty(str2) && (split = str2.trim().split(ContainerUtils.KEY_VALUE_DELIMITER)) != null && split.length > 1 && !TextUtils.isEmpty(split[0])) {
                hashMap.put(split[0], split[1]);
            }
        }
        return hashMap;
    }

    private boolean rspFromOffinePackage(HippyHttpRequest hippyHttpRequest, HippyHttpAdapter.HttpTaskCallback httpTaskCallback, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (!file.exists()) {
            return false;
        }
        try {
            HippyHttpResponse hippyHttpResponse = new HippyHttpResponse();
            hippyHttpResponse.setStatusCode(200);
            hippyHttpResponse.setResponseMessage("OK from cache");
            hippyHttpResponse.setInputStream(new FileInputStream(file));
            if (httpTaskCallback != null) {
                httpTaskCallback.onTaskSuccess(hippyHttpRequest, hippyHttpResponse);
            }
            return true;
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "convertToHippyHttpResponse e:" + th5);
            return false;
        }
    }

    private static String serializeCookie(HashMap<String, String> hashMap) {
        StringBuilder sb5 = new StringBuilder();
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            sb5.append(entry.getKey());
            sb5.append('=');
            sb5.append(entry.getValue());
            sb5.append(';');
        }
        if (sb5.length() > 0 && sb5.charAt(sb5.length() - 1) == ';') {
            sb5.deleteCharAt(sb5.length() - 1);
        }
        return sb5.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static HippyHttpResponse toHippyHttpResponse(dk0.b bVar, Map<String, List<String>> map) {
        try {
            HippyHttpResponse hippyHttpResponse = new HippyHttpResponse();
            if (bVar != null) {
                hippyHttpResponse.setStatusCode(Integer.valueOf(bVar.f394022a));
                hippyHttpResponse.setRspHeaderMap(map);
                if (bVar.f394023b != null) {
                    hippyHttpResponse.setInputStream(new ByteArrayInputStream(bVar.f394023b));
                }
            }
            return hippyHttpResponse;
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "convertToHippyHttpResponse e:" + th5);
            return null;
        }
    }

    private static dk0.a toViolaHttpRequest(HippyHttpRequest hippyHttpRequest) {
        dk0.a aVar = new dk0.a();
        aVar.f394017a = new HashMap();
        aVar.f394018b = hippyHttpRequest.getUrl();
        aVar.f394019c = hippyHttpRequest.getMethod();
        aVar.f394020d = hippyHttpRequest.getBody();
        aVar.f394021e = hippyHttpRequest.getConnectTimeout() + hippyHttpRequest.getReadTimeout();
        if (hippyHttpRequest.getHeaders() != null) {
            for (Map.Entry<String, Object> entry : hippyHttpRequest.getHeaders().entrySet()) {
                String key = entry.getKey();
                if (!TextUtils.isEmpty(key)) {
                    Object value = entry.getValue();
                    if (value instanceof String) {
                        aVar.f394017a.put(key, (String) value);
                    } else if (value instanceof List) {
                        List list = (List) value;
                        if (list.size() > 0 && list.get(0) != null) {
                            aVar.f394017a.put(key, list.get(0).toString());
                        }
                    }
                }
            }
        }
        return aVar;
    }

    @Override // com.tencent.mtt.hippy.adapter.http.DefaultHttpAdapter, com.tencent.mtt.hippy.adapter.http.HippyHttpAdapter
    public void sendRequest(HippyHttpRequest hippyHttpRequest, HippyHttpAdapter.HttpTaskCallback httpTaskCallback) {
        if (hippyHttpRequest == null || rspFromOffinePackage(hippyHttpRequest, httpTaskCallback, HippyOfflineAssist.getOfflineResPath(hippyHttpRequest.getUrl()))) {
            return;
        }
        if (isSSRRequest(hippyHttpRequest.getUrl())) {
            doSSRRequest(hippyHttpRequest, httpTaskCallback);
        } else {
            doSendRequest(this.mHttpAdapter, hippyHttpRequest, httpTaskCallback);
        }
    }

    @Override // com.tencent.mtt.hippy.adapter.http.DefaultHttpAdapter, com.tencent.mtt.hippy.adapter.http.HippyHttpAdapter
    public void destroyIfNeed() {
    }
}
