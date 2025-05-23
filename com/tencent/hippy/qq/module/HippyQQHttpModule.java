package com.tencent.hippy.qq.module;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.tencent.ark.ark;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.hippy.qq.utils.HippyUtils;
import com.tencent.mobileqq.qqecommerce.biz.hr.api.IBaseHttpAdapterFactory;
import com.tencent.mobileqq.qqgamepub.utils.GamePubAccountHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.CookieManager;
import dk0.c;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Marker;

/* compiled from: P */
@HippyNativeModule(name = "http")
/* loaded from: classes7.dex */
public class HippyQQHttpModule extends HippyNativeModuleBase {
    private static final Pattern CHARSET_PATTERN = Pattern.compile("charset=([a-z0-9-]+)");
    private static final String CHARSET_UTF8 = "utf-8";
    static final String CLASSNAME = "http";
    public static final String HTPP_ERROR_TEXT = "errorText";
    public static final String HTTP_CODE = "code";
    public static final String HTTP_DATA = "data";
    public static final String HTTP_HEADER = "header";
    public static final String HTTP_METHOD_GET = "GET";
    public static final String HTTP_METHOD_POST = "POST";
    public static final String HTTP_SUCCESS = "success";
    public static final String MODULE_NAME = "http";
    public static String TAG = "HttpModule";
    private dk0.c mAdapter;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class HttpListener implements c.a {
        private long mHttpStartTime;
        private Map<String, String> mRespHeaders;
        private Map<String, Object> mResponse = new HashMap();
        private ResponseCallback mResponseCallback;

        public HttpListener(ResponseCallback responseCallback) {
            this.mResponseCallback = responseCallback;
        }

        @Override // dk0.c.a
        public void onHeadersReceived(int i3, Map<String, List<String>> map) {
            String key;
            this.mResponse.put("readyState", 2);
            this.mResponse.put("status", Integer.valueOf(i3));
            HashMap hashMap = new HashMap();
            if (map != null) {
                for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                    if (entry.getValue().size() > 0) {
                        if (entry.getKey() == null) {
                            key = "_";
                        } else {
                            key = entry.getKey();
                        }
                        hashMap.put(key, entry.getValue().get(0));
                    }
                }
            }
            this.mResponse.put("headers", hashMap);
            this.mRespHeaders = hashMap;
        }

        @Override // dk0.c.a
        public void onHttpFinish(dk0.b bVar) {
            ResponseCallback responseCallback = this.mResponseCallback;
            if (responseCallback != null) {
                responseCallback.onResponse(bVar, this.mRespHeaders);
            }
        }

        @Override // dk0.c.a
        public void onHttpStart() {
            this.mHttpStartTime = System.currentTimeMillis();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface ResponseCallback {
        void onResponse(dk0.b bVar, Map<String, String> map);
    }

    public HippyQQHttpModule(HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext);
        HippyQQEngine hippyQQEngine = getHippyQQEngine();
        if (hippyQQEngine != null) {
            this.mAdapter = hippyQQEngine.getHttpAdapter();
        }
        if (this.mAdapter == null) {
            this.mAdapter = ((IBaseHttpAdapterFactory) QRoute.api(IBaseHttpAdapterFactory.class)).create(HippyUtils.enableHttp2());
        }
    }

    public static void encodeDataFromJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String obj = keys.next().toString();
                    String string = jSONObject.getString(obj);
                    if (!TextUtils.isEmpty(string)) {
                        String encode = URLEncoder.encode(string);
                        if (!TextUtils.isEmpty(encode)) {
                            jSONObject.put(obj, encode.replace(Marker.ANY_NON_NULL_MARKER, "%20"));
                        }
                    }
                }
            } catch (Exception e16) {
                QLog.e(TAG, 1, "encodeDataFromJson Exception e:" + e16.getMessage());
            }
        }
    }

    private CookieManager getCookieManager() {
        try {
            CookieManager cookieManager = CookieManager.getInstance();
            if (!cookieManager.acceptCookie()) {
                cookieManager.setAcceptCookie(true);
            }
            return cookieManager;
        } catch (Exception e16) {
            QLog.e(TAG, 1, "getCookieManager exception=", e16);
            return null;
        }
    }

    public static String getHeader(Map<String, String> map, String str) {
        if (map != null && str != null) {
            if (map.containsKey(str)) {
                return map.get(str);
            }
            return map.get(str.toLowerCase());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public HippyMap getResponseHeaderMap(Map<String, String> map, dk0.a aVar) {
        HippyMap hippyMap = new HippyMap();
        if (map != null && !map.isEmpty()) {
            Set<String> keySet = map.keySet();
            CookieManager cookieManager = getCookieManager();
            boolean z16 = false;
            for (String str : keySet) {
                String str2 = map.get(str);
                if (!TextUtils.isEmpty(str2)) {
                    if ("Set-Cookie".equalsIgnoreCase(str) && cookieManager != null) {
                        cookieManager.setCookie(aVar.f394018b, str2);
                        z16 = true;
                    }
                    hippyMap.pushString(str, str2);
                }
            }
            if (z16) {
                syncCookie();
            }
        }
        return hippyMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String readAsString(byte[] bArr, String str) {
        String str2;
        try {
            if (str != null) {
                Matcher matcher = CHARSET_PATTERN.matcher(str.toLowerCase());
                if (matcher.find()) {
                    str2 = matcher.group(1);
                    if (TextUtils.isEmpty(str2)) {
                        str2 = "utf-8";
                    }
                    return new String(bArr, str2);
                }
            }
            return new String(bArr, str2);
        } catch (UnsupportedEncodingException e16) {
            Log.e("", e16.getMessage());
            return new String(bArr);
        }
        str2 = null;
        if (TextUtils.isEmpty(str2)) {
        }
    }

    private void reuqestHttp(String str, JSONObject jSONObject, JSONObject jSONObject2, int i3, Promise promise, String str2, boolean z16) {
        reuqestHttp(str, jSONObject, jSONObject2, i3, promise, str2, z16, false);
    }

    private void syncCookie() {
        if (getCookieManager() != null) {
            getCookieManager().flush();
        }
    }

    protected final HippyQQEngine getHippyQQEngine() {
        return HippyQQEngine.getEngineInstance(this.mContext.getEngineId());
    }

    Object parseData(String str, String str2) throws JSONException {
        if (ark.ARKMETADATA_JSON.equals(str2)) {
            return new JSONObject(str);
        }
        if ("jsonp".equals(str2)) {
            if (str != null && !str.isEmpty()) {
                int indexOf = str.indexOf("(") + 1;
                int lastIndexOf = str.lastIndexOf(")");
                if (indexOf != 0 && indexOf < lastIndexOf && lastIndexOf > 0) {
                    return new JSONObject(str.substring(indexOf, lastIndexOf));
                }
                return new JSONObject();
            }
            return new JSONObject();
        }
        return str;
    }

    @HippyMethod(name = Const.BUNDLE_KEY_REQUEST)
    public void request(HippyMap hippyMap, Promise promise) {
        JSONObject jSONObject;
        if (hippyMap != null) {
            jSONObject = hippyMap.toJSONObject();
        } else {
            jSONObject = new JSONObject();
        }
        if (TextUtils.isEmpty(jSONObject.optString("url"))) {
            return;
        }
        int optInt = jSONObject.optInt("timeout", 10000);
        boolean optBoolean = jSONObject.optBoolean("forReport", false);
        GamePubAccountHelper.U(jSONObject.optString("url"), System.currentTimeMillis());
        reuqestHttp(jSONObject.optString("url"), jSONObject.optJSONObject("data"), jSONObject.optJSONObject("headers"), optInt, promise, jSONObject.optString("method", "POST").toUpperCase(), optBoolean, jSONObject.optBoolean("returnHeader", false));
    }

    @HippyMethod(name = "requestGet")
    public void requestGet(String str, HippyMap hippyMap, Promise promise) {
        JSONObject jSONObject;
        if (hippyMap != null) {
            jSONObject = hippyMap.toJSONObject();
        } else {
            jSONObject = new JSONObject();
        }
        reuqestHttp(str, jSONObject, null, 10000, promise, "GET", false);
    }

    @HippyMethod(name = "requestPost")
    public void requestPost(String str, HippyMap hippyMap, Promise promise) {
        JSONObject jSONObject;
        if (hippyMap != null) {
            jSONObject = hippyMap.toJSONObject();
        } else {
            jSONObject = new JSONObject();
        }
        reuqestHttp(str, jSONObject, null, 10000, promise, "POST", false);
    }

    private void reuqestHttp(String str, JSONObject jSONObject, JSONObject jSONObject2, int i3, final Promise promise, String str2, boolean z16, final boolean z17) {
        final dk0.a aVar = new dk0.a();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "request, url=", str, ", time=", Long.valueOf(System.currentTimeMillis()), ", request=", aVar);
        }
        aVar.f394018b = str;
        aVar.f394019c = str2;
        if (str2.equals("GET")) {
            if (jSONObject != null) {
                try {
                    JSONObject jSONObject3 = new JSONObject(jSONObject.toString());
                    encodeDataFromJson(jSONObject3);
                    aVar.f394018b = com.tencent.ecommerce.richtext.utils.e.y(jSONObject3, str);
                } catch (JSONException unused) {
                    aVar.f394018b = com.tencent.ecommerce.richtext.utils.e.y(jSONObject, str);
                }
            } else {
                aVar.f394018b = com.tencent.ecommerce.richtext.utils.e.y(jSONObject, str);
            }
        }
        aVar.f394021e = i3;
        HashMap hashMap = new HashMap();
        if (jSONObject2 != null) {
            Iterator keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String str3 = (String) keys.next();
                hashMap.put(str3, jSONObject2.optString(str3));
            }
            aVar.f394017a = hashMap;
        }
        if (jSONObject != null) {
            if (hashMap.containsKey("Content-Type") && !TextUtils.isEmpty((CharSequence) hashMap.get("Content-Type")) && ((String) hashMap.get("Content-Type")).contains("application/json")) {
                aVar.f394020d = jSONObject.toString();
            } else {
                aVar.f394020d = com.tencent.ecommerce.richtext.utils.e.x(jSONObject);
            }
        }
        this.mAdapter.sendRequest(aVar, new HttpListener(new ResponseCallback() { // from class: com.tencent.hippy.qq.module.HippyQQHttpModule.1
            /* JADX WARN: Removed duplicated region for block: B:26:0x00eb A[Catch: Exception -> 0x0148, TryCatch #1 {Exception -> 0x0148, blocks: (B:7:0x0019, B:10:0x0027, B:13:0x0033, B:18:0x0047, B:22:0x0052, B:23:0x007b, B:24:0x00d1, B:26:0x00eb, B:27:0x00f1, B:29:0x00f8, B:30:0x0106, B:32:0x010c, B:33:0x013b, B:38:0x0058, B:39:0x0063, B:41:0x0067, B:43:0x0074, B:48:0x008a, B:49:0x00b4, B:50:0x00a2), top: B:6:0x0019, inners: #0 }] */
            /* JADX WARN: Removed duplicated region for block: B:29:0x00f8 A[Catch: Exception -> 0x0148, TryCatch #1 {Exception -> 0x0148, blocks: (B:7:0x0019, B:10:0x0027, B:13:0x0033, B:18:0x0047, B:22:0x0052, B:23:0x007b, B:24:0x00d1, B:26:0x00eb, B:27:0x00f1, B:29:0x00f8, B:30:0x0106, B:32:0x010c, B:33:0x013b, B:38:0x0058, B:39:0x0063, B:41:0x0067, B:43:0x0074, B:48:0x008a, B:49:0x00b4, B:50:0x00a2), top: B:6:0x0019, inners: #0 }] */
            /* JADX WARN: Removed duplicated region for block: B:32:0x010c A[Catch: Exception -> 0x0148, TryCatch #1 {Exception -> 0x0148, blocks: (B:7:0x0019, B:10:0x0027, B:13:0x0033, B:18:0x0047, B:22:0x0052, B:23:0x007b, B:24:0x00d1, B:26:0x00eb, B:27:0x00f1, B:29:0x00f8, B:30:0x0106, B:32:0x010c, B:33:0x013b, B:38:0x0058, B:39:0x0063, B:41:0x0067, B:43:0x0074, B:48:0x008a, B:49:0x00b4, B:50:0x00a2), top: B:6:0x0019, inners: #0 }] */
            @Override // com.tencent.hippy.qq.module.HippyQQHttpModule.ResponseCallback
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onResponse(dk0.b bVar, Map<String, String> map) {
                String str4;
                JSONObject g16;
                int i16;
                String str5;
                GamePubAccountHelper.b(aVar.f394018b, System.currentTimeMillis());
                Promise promise2 = promise;
                if (promise2 != null && promise2.isCallback()) {
                    try {
                        JSONObject jSONObject4 = new JSONObject();
                        if (bVar != null && !"-1".equals(bVar.f394022a)) {
                            int parseInt = Integer.parseInt(bVar.f394022a);
                            jSONObject4.put("code", parseInt);
                            if (parseInt >= 200 && parseInt <= 299) {
                                i16 = 1;
                            } else {
                                i16 = 0;
                            }
                            jSONObject4.put("success", i16);
                            byte[] bArr = bVar.f394023b;
                            if (bArr == null) {
                                jSONObject4.put("data", (Object) null);
                            } else {
                                if (map != null) {
                                    str5 = HippyQQHttpModule.getHeader(map, "Content-Type");
                                } else {
                                    str5 = "";
                                }
                                try {
                                    jSONObject4.put("data", HippyQQHttpModule.this.parseData(HippyQQHttpModule.readAsString(bArr, str5), ark.ARKMETADATA_JSON));
                                } catch (JSONException unused2) {
                                    jSONObject4.put("success", 0);
                                    jSONObject4.put("code", -1);
                                }
                            }
                            jSONObject4.put(HippyQQHttpModule.HTPP_ERROR_TEXT, ek0.a.a(bVar.f394022a));
                            HippyMap hippyMap = new HippyMap();
                            GamePubAccountHelper.b(aVar.f394018b, System.currentTimeMillis());
                            g16 = GamePubAccountHelper.g(aVar.f394018b);
                            if (g16 != null) {
                                jSONObject4.put("requestCostTime", g16);
                            }
                            hippyMap.pushJSONObject(jSONObject4);
                            if (z17) {
                                hippyMap.pushMap("header", HippyQQHttpModule.this.getResponseHeaderMap(map, aVar));
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d(HippyQQHttpModule.TAG, 2, "request, onResponse, url=", aVar.f394018b, ", time=", Long.valueOf(System.currentTimeMillis()), ", request=", aVar);
                            }
                            promise.resolve(hippyMap);
                            GamePubAccountHelper.L(aVar.f394018b);
                        }
                        if (bVar != null) {
                            str4 = "ERR_CONNECT_FAILED," + bVar.f394025d;
                        } else {
                            str4 = "ERR_CONNECT_FAILED,response is null";
                        }
                        jSONObject4.put("success", 0);
                        jSONObject4.put(HippyQQHttpModule.HTPP_ERROR_TEXT, str4);
                        QLog.e(HippyQQHttpModule.TAG, 1, "connect failed and msg is " + str4);
                        HippyMap hippyMap2 = new HippyMap();
                        GamePubAccountHelper.b(aVar.f394018b, System.currentTimeMillis());
                        g16 = GamePubAccountHelper.g(aVar.f394018b);
                        if (g16 != null) {
                        }
                        hippyMap2.pushJSONObject(jSONObject4);
                        if (z17) {
                        }
                        if (QLog.isColorLevel()) {
                        }
                        promise.resolve(hippyMap2);
                        GamePubAccountHelper.L(aVar.f394018b);
                    } catch (Exception e16) {
                        QLog.e(HippyQQHttpModule.TAG, 1, "onResponse exception=", e16);
                    }
                }
            }
        }), z16);
    }

    @Override // com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase
    public void destroy() {
    }
}
