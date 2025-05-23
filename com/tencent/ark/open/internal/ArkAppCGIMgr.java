package com.tencent.ark.open.internal;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.Logger;
import com.tencent.ark.ark;
import com.tencent.ark.open.ArkAppConfigMgr;
import com.tencent.ark.open.ArkAppInfo;
import com.tencent.ark.open.delegate.ArkDelegateManager;
import com.tencent.ark.open.delegate.IArkDelegateHTTPCallback;
import com.tencent.ark.open.delegate.IArkDelegateNet;
import com.tencent.ark.open.delegate.IArkDelegateSSO;
import com.tencent.ark.open.delegate.IArkDelegateSSOCallback;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.vas.VasUserData;
import com.tencent.util.QQCustomArkDialogUtil;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ArkAppCGIMgr {
    public static final int AppUpdateState_NeedUpdate = 1;
    public static final int AppUpdateState_NoUpdate = 2;
    public static final int AppUpdateState_None = 0;
    public static final int AppUpdateState_Offline = 3;
    private static final int DEFAULT_UPDATE_APP_INTERVAL = 300;
    private static final ArkEnvironmentManager ENV = ArkEnvironmentManager.getInstance();
    private static final int MIN_UPDATE_APP_INTERVAL = 60;
    private static final int QUERY_APP_INFO_LIMIT;
    private static final String TAG = "ArkApp.ArkAppCGIMgr";
    private static PublicKey mAppPackagePubKey;
    private final ArrayList<QueryTask> mTaskList = new ArrayList<>();

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class AppNameVersion {
        public String appName;
        public String appVersion;
        public String bizSrc;
        public String expectAppVersion;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class Holder {
        static final ArkAppCGIMgr gInstance = new ArkAppCGIMgr();

        Holder() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface IQueryAppInfoRequestCallback {
        void onResult(String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface ITaskHttpResult {
        void onTaskHttpResult(QueryTask queryTask, boolean z16, byte[] bArr);
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class QueryAppInfoByAppNameBatchResult {
        public final HashMap<String, QueryAppInfoResult> resultList = new HashMap<>();
        public int updateInterval;
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class QueryAppInfoResult {
        public static final int RET_APP_NOT_EXIST = 5;
        public static final int RET_APP_OFFLINE = -5;
        public static final int RET_APP_VIEW_ERROR = -8;
        public static final int RET_COPY_APP_FAIL = -3;
        public static final int RET_FAIL_NETWORK = -2;
        public static final int RET_LOADLIB_FAIL = -6;
        public static final int RET_META_CONTAIN_INVALID_URL = -4;
        public static final int RET_OTHER_ERROR = -1;
        public static final int RET_SDK_VER_TOO_HIGH = 7;
        public static final int RET_SDK_VER_TOO_LOW = 6;
        public static final int RET_SUCCESS = 0;
        public static final int RET_TIMEOUT = -7;
        public ArkAppInfo.AppDownloadInfo info;

        /* renamed from: msg, reason: collision with root package name */
        public String f72568msg;
        public int retCode;
        public int state;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class QueryTask {
        public final ArrayList<ArkAppCGICallback> callback;
        public String cookie;
        ITaskHttpResult onParseReply;
        public byte[] postData;
        public String referer;
        public String url;
        public final ArrayList<Object> userdata;

        QueryTask() {
            this.userdata = new ArrayList<>();
            this.callback = new ArrayList<>();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class QueryTask_DownloadAppPackage extends QueryTask {
        public byte[] appSign;

        QueryTask_DownloadAppPackage() {
            super();
        }
    }

    static {
        int i3;
        if (ArkEnvironmentManager.getInstance().getDebugFlag()) {
            i3 = 2;
        } else {
            i3 = 10;
        }
        QUERY_APP_INFO_LIMIT = i3;
    }

    private static String getAppUpdateReqString(ArrayList<AppNameVersion> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("os", "android");
                jSONObject.put("platformVer", ark.arkGetPlatformVersion());
                jSONObject.put("minPlatformVer", ark.arkGetMinPlatformVersion());
                JSONArray jSONArray = new JSONArray();
                Iterator<AppNameVersion> it = arrayList.iterator();
                while (it.hasNext()) {
                    AppNameVersion next = it.next();
                    if (!TextUtils.isEmpty(next.appName)) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("app", next.appName);
                        if (TextUtils.isEmpty(next.appVersion)) {
                            jSONObject2.put("ver", "0.0.0.0");
                        } else {
                            jSONObject2.put("ver", next.appVersion);
                        }
                        if (!TextUtils.isEmpty(next.expectAppVersion)) {
                            jSONObject2.put("expectVersion", next.expectAppVersion);
                        }
                        jSONObject2.put("cfgver", ArkAppConfigMgr.getInstance().getAppConfigVersion(next.appName, next.bizSrc));
                        if (!TextUtils.isEmpty(next.bizSrc)) {
                            jSONObject2.put(QQCustomArkDialogUtil.BIZ_SRC, next.bizSrc);
                        }
                        jSONArray.mo162put(jSONObject2);
                    }
                }
                jSONObject.put("apps", jSONArray);
                jSONObject.put(VasUserData.Key.QQ_VER, ArkEnvironmentManager.getInstance().getQQVersion());
                jSONObject.put("supportTemplate", 0);
                return jSONObject.toString();
            } catch (JSONException e16) {
                Logger.logI(TAG, String.format("getAppUpdateReqString, exception: %s", e16.getMessage()));
            }
        }
        return null;
    }

    private static synchronized PublicKey getArkAppPackagePubliceKey() {
        synchronized (ArkAppCGIMgr.class) {
            PublicKey publicKey = mAppPackagePubKey;
            if (publicKey != null) {
                return publicKey;
            }
            try {
                mAppPackagePubKey = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDEm0juTTzu7HrGYmuzivAGFHszLkHfJjcy0+yzNRTaSfoH0Xqcdy2766NJxfVmxKpC69IpPXcElY7ywJ/0jwO40pQ+cQDc5buM9T7SWZYGZ1k4eKSAJR31jf5i6xTgKxhN2gLMMBboKs0DYH77cdEOI4/yXhX0HdctT3ZR6YIq3QIDAQAB", 0)));
            } catch (Exception e16) {
                Logger.logI(TAG, "generatePublic fail, Exception:" + e16.getMessage());
            }
            return mAppPackagePubKey;
        }
    }

    public static ArkAppCGIMgr getInstance() {
        return Holder.gInstance;
    }

    static Signature getVerifySignature() {
        PublicKey arkAppPackagePubliceKey = getArkAppPackagePubliceKey();
        if (arkAppPackagePubliceKey == null) {
            return null;
        }
        try {
            Signature signature = Signature.getInstance("SHA1withRSA");
            signature.initVerify(arkAppPackagePubliceKey);
            return signature;
        } catch (Exception e16) {
            Logger.logI(TAG, "getVerifySignature, failed, exception:" + e16.getMessage());
            return null;
        }
    }

    private boolean mergeRequestByUrl(String str, Object obj, ArkAppCGICallback arkAppCGICallback) {
        synchronized (this.mTaskList) {
            Iterator<QueryTask> it = this.mTaskList.iterator();
            while (it.hasNext()) {
                QueryTask next = it.next();
                if (next.url.equalsIgnoreCase(str)) {
                    next.userdata.add(obj);
                    next.callback.add(arkAppCGICallback);
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected static void onDownloadAppPackage(QueryTask_DownloadAppPackage queryTask_DownloadAppPackage, boolean z16, byte[] bArr) {
        int i3;
        boolean z17;
        if (!z16) {
            Logger.logI(TAG, String.format("onDownloadAppPackage: net fail, url=%s", queryTask_DownloadAppPackage.url));
        } else {
            byte[] bArr2 = queryTask_DownloadAppPackage.appSign;
            if (bArr2 == null || !verifyAppPackage(bArr, bArr2)) {
                Logger.logI(TAG, String.format("onDownloadAppPackage: verifyAppPackage fail, url=%s", queryTask_DownloadAppPackage.url));
            }
            for (i3 = 0; i3 < queryTask_DownloadAppPackage.callback.size(); i3++) {
                Object obj = queryTask_DownloadAppPackage.userdata.get(i3);
                ArkAppCGICallback arkAppCGICallback = queryTask_DownloadAppPackage.callback.get(i3);
                if (arkAppCGICallback != null) {
                    if (bArr != null) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    arkAppCGICallback.onDownloadAppPackage(z17, bArr, obj);
                }
            }
        }
        bArr = null;
        while (i3 < queryTask_DownloadAppPackage.callback.size()) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onHttpRequestResult(final QueryTask queryTask, final boolean z16, final byte[] bArr) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.ark.open.internal.ArkAppCGIMgr.6
            @Override // java.lang.Runnable
            public void run() {
                synchronized (ArkAppCGIMgr.this.mTaskList) {
                    ArkAppCGIMgr.this.mTaskList.remove(queryTask);
                }
                QueryTask queryTask2 = queryTask;
                queryTask2.onParseReply.onTaskHttpResult(queryTask2, z16, bArr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public QueryAppInfoByAppNameBatchResult parserReply_queryAppInfoByAppNameBatch(String str) {
        JSONObject optJSONObject;
        if (ArkEnvironmentManager.getInstance().getDebugFlag()) {
            Logger.logI(TAG, String.format("ArkTemp.ArkSafe.parserReply_queryAppInfoByAppNameBatch,config=%s", str));
        }
        QueryAppInfoByAppNameBatchResult queryAppInfoByAppNameBatchResult = new QueryAppInfoByAppNameBatchResult();
        queryAppInfoByAppNameBatchResult.updateInterval = 0;
        if (str == null) {
            Logger.logI(TAG, "parserReply_queryAppInfoByAppNameBatch, data is empty");
            return queryAppInfoByAppNameBatchResult;
        }
        try {
            optJSONObject = new JSONObject(str).optJSONObject("data");
        } catch (JSONException e16) {
            Logger.logI(TAG, String.format("ArkTemp.parserReply_queryAppInfoByAppNameBatch, exception: %s", e16.getMessage()));
        }
        if (optJSONObject == null) {
            Logger.logI(TAG, "parserReply_queryAppInfoByAppNameBatch, 'data' not found");
            return queryAppInfoByAppNameBatchResult;
        }
        int optInt = optJSONObject.optInt("updateInterval", 300);
        queryAppInfoByAppNameBatchResult.updateInterval = optInt;
        queryAppInfoByAppNameBatchResult.updateInterval = Math.max(60, optInt);
        JSONArray optJSONArray = optJSONObject.optJSONArray("apps");
        if (optJSONArray == null) {
            return queryAppInfoByAppNameBatchResult;
        }
        for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
            JSONObject optJSONObject2 = optJSONArray.optJSONObject(i3);
            if (optJSONObject2 != null) {
                String optString = optJSONObject2.optString("app");
                String optString2 = optJSONObject2.optString(QQCustomArkDialogUtil.BIZ_SRC);
                if (TextUtils.isEmpty(optString)) {
                    Logger.logI(TAG, "parserReply_queryAppInfoByAppNameBatch, 'app' not found");
                } else {
                    int optInt2 = optJSONObject2.optInt("ret", -1);
                    String optString3 = optJSONObject2.optString("msg", "");
                    if (optInt2 != 0) {
                        QueryAppInfoResult queryAppInfoResult = new QueryAppInfoResult();
                        queryAppInfoResult.retCode = optInt2;
                        queryAppInfoResult.f72568msg = optString3;
                        queryAppInfoResult.info = null;
                        queryAppInfoByAppNameBatchResult.resultList.put(ArkAppConfigMgr.getAppConfigCacheKey(optString, optString2), queryAppInfoResult);
                    } else {
                        QueryAppInfoResult queryAppInfoResult2 = new QueryAppInfoResult();
                        queryAppInfoResult2.retCode = 0;
                        queryAppInfoResult2.f72568msg = optString3;
                        ArkAppInfo.AppDownloadInfo appDownloadInfo = new ArkAppInfo.AppDownloadInfo();
                        queryAppInfoResult2.info = appDownloadInfo;
                        appDownloadInfo.desc = new ArkAppInfo.AppDesc();
                        JSONObject optJSONObject3 = optJSONObject2.optJSONObject(DownloadInfo.spKey_Config);
                        if (optJSONObject3 != null) {
                            queryAppInfoResult2.info.config = ArkAppConfigMgr.convertJsonToConfig(optJSONObject3);
                        }
                        int optInt3 = optJSONObject2.optInt("state", 0);
                        queryAppInfoResult2.state = optInt3;
                        if (optInt3 == 0) {
                            Logger.logI(TAG, "ArkTemp.parserReply_queryAppInfoByAppNameBatch, invalid 'state'");
                            queryAppInfoResult2.retCode = -1;
                            queryAppInfoByAppNameBatchResult.resultList.put(ArkAppConfigMgr.getAppConfigCacheKey(optString, optString2), queryAppInfoResult2);
                        } else {
                            if (optInt3 == 1) {
                                String optString4 = optJSONObject2.optString("ver", null);
                                String optString5 = optJSONObject2.optString("url", null);
                                String optString6 = optJSONObject2.optString("sign", null);
                                int optInt4 = optJSONObject2.optInt("updatePeriod", 0);
                                if (!TextUtils.isEmpty(optString4) && !TextUtils.isEmpty(optString5) && !TextUtils.isEmpty(optString6)) {
                                    byte[] decode = Base64.decode(optString6, 0);
                                    if (decode != null && decode.length != 0) {
                                        ArkAppInfo.AppDownloadInfo appDownloadInfo2 = queryAppInfoResult2.info;
                                        appDownloadInfo2.downloadUrl = optString5;
                                        appDownloadInfo2.sign = decode;
                                        appDownloadInfo2.updatePeriodByMinutes = optInt4;
                                        ArkAppInfo.AppDesc appDesc = appDownloadInfo2.desc;
                                        appDesc.name = optString;
                                        appDesc.bizSrc = optString2;
                                        appDesc.version = optString4;
                                    }
                                    Logger.logI(TAG, String.format("ArkTemp.parserReply_queryAppInfoByAppNameBatch, invalid sign, app=%s", optString));
                                }
                                Logger.logI(TAG, String.format("ArkTemp.parserReply_queryAppInfoByAppNameBatch, invalid app info, app=%s", optString));
                            }
                            queryAppInfoByAppNameBatchResult.resultList.put(ArkAppConfigMgr.getAppConfigCacheKey(optString, optString2), queryAppInfoResult2);
                        }
                    }
                }
            }
        }
        return queryAppInfoByAppNameBatchResult;
    }

    private void runTask(final QueryTask queryTask, ITaskHttpResult iTaskHttpResult) {
        queryTask.onParseReply = iTaskHttpResult;
        synchronized (this.mTaskList) {
            this.mTaskList.add(queryTask);
        }
        ArkDispatchTask.getInstance().postToArkThread(new Runnable() { // from class: com.tencent.ark.open.internal.ArkAppCGIMgr.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    IArkDelegateNet netDelegate = ArkDelegateManager.getInstance().getNetDelegate();
                    if (netDelegate != null) {
                        HashMap<String, String> hashMap = new HashMap<>(2);
                        String str = queryTask.cookie;
                        if (str != null) {
                            hashMap.put("Cookie", str);
                        }
                        String str2 = queryTask.referer;
                        if (str2 != null) {
                            hashMap.put("Referer", str2);
                        }
                        netDelegate.get(queryTask.url, hashMap, new IArkDelegateHTTPCallback() { // from class: com.tencent.ark.open.internal.ArkAppCGIMgr.5.1
                            @Override // com.tencent.ark.open.delegate.IArkDelegateHTTPCallback
                            public void onComplete(int i3, byte[] bArr) {
                                if (i3 == 0 && bArr != null) {
                                    AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                                    ArkAppCGIMgr.this.onHttpRequestResult(queryTask, true, bArr);
                                } else {
                                    AnonymousClass5 anonymousClass52 = AnonymousClass5.this;
                                    ArkAppCGIMgr.this.onHttpRequestResult(queryTask, false, null);
                                }
                            }
                        });
                        return;
                    }
                    Logger.logI(ArkAppCGIMgr.TAG, String.format("download fail, url=%s for ark net delegate is null", queryTask.url));
                } catch (Exception e16) {
                    Logger.logI(ArkAppCGIMgr.TAG, String.format("runTask fail, url=%s, msg=%s", queryTask.url, e16.getMessage()));
                    ArkAppCGIMgr.this.onHttpRequestResult(queryTask, false, null);
                }
            }
        });
    }

    public static boolean verifyAppPackage(File file, byte[] bArr) {
        BufferedInputStream bufferedInputStream = null;
        try {
            try {
                if (!file.exists()) {
                    return false;
                }
                Signature verifySignature = getVerifySignature();
                if (verifySignature == null) {
                    Logger.logW(TAG, "verifyAppPackage, sign is null");
                    return true;
                }
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
                try {
                    byte[] bArr2 = new byte[131072];
                    while (true) {
                        int read = bufferedInputStream2.read(bArr2, 0, 131072);
                        if (read <= 0) {
                            break;
                        }
                        verifySignature.update(bArr2, 0, read);
                    }
                    boolean verify = verifySignature.verify(bArr);
                    try {
                        bufferedInputStream2.close();
                    } catch (Exception e16) {
                        Logger.logI(TAG, "verifyAppPackage, file close Exception:" + e16.getMessage());
                    }
                    return verify;
                } catch (Exception e17) {
                    e = e17;
                    bufferedInputStream = bufferedInputStream2;
                    Logger.logI(TAG, "verifyAppPackage, verify exception:" + e.getMessage());
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (Exception e18) {
                            Logger.logI(TAG, "verifyAppPackage, file close Exception:" + e18.getMessage());
                        }
                    }
                    return true;
                } catch (OutOfMemoryError e19) {
                    e = e19;
                    bufferedInputStream = bufferedInputStream2;
                    Logger.logI(TAG, "verifyAppPackage, oom:" + e.getMessage());
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (Exception e26) {
                            Logger.logI(TAG, "verifyAppPackage, file close Exception:" + e26.getMessage());
                        }
                    }
                    return true;
                } catch (Throwable th5) {
                    th = th5;
                    bufferedInputStream = bufferedInputStream2;
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (Exception e27) {
                            Logger.logI(TAG, "verifyAppPackage, file close Exception:" + e27.getMessage());
                        }
                    }
                    throw th;
                }
            } catch (Exception e28) {
                e = e28;
            } catch (OutOfMemoryError e29) {
                e = e29;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public void downloadAppIcon(String str, Object obj, ArkAppCGICallback arkAppCGICallback) {
        if (!TextUtils.isEmpty(str) && arkAppCGICallback != null) {
            Logger.logI(TAG, String.format("ArkSafe.downloadAppIcon:url=%s", str));
            QueryTask queryTask = new QueryTask();
            queryTask.url = str;
            queryTask.callback.add(arkAppCGICallback);
            queryTask.userdata.add(obj);
            runTask(queryTask, new ITaskHttpResult() { // from class: com.tencent.ark.open.internal.ArkAppCGIMgr.7
                @Override // com.tencent.ark.open.internal.ArkAppCGIMgr.ITaskHttpResult
                public void onTaskHttpResult(QueryTask queryTask2, boolean z16, byte[] bArr) {
                    for (int i3 = 0; i3 < queryTask2.callback.size(); i3++) {
                        ArkAppCGICallback arkAppCGICallback2 = queryTask2.callback.get(i3);
                        if (arkAppCGICallback2 != null) {
                            arkAppCGICallback2.onDownloadAppIcon(z16, bArr, queryTask2.userdata.get(0));
                        }
                    }
                }
            });
        }
    }

    public void downloadAppPackage(String str, byte[] bArr, Object obj, ArkAppCGICallback arkAppCGICallback) {
        if (mergeRequestByUrl(str, obj, arkAppCGICallback)) {
            return;
        }
        QueryTask_DownloadAppPackage queryTask_DownloadAppPackage = new QueryTask_DownloadAppPackage();
        queryTask_DownloadAppPackage.url = str;
        queryTask_DownloadAppPackage.appSign = bArr;
        queryTask_DownloadAppPackage.userdata.add(obj);
        queryTask_DownloadAppPackage.callback.add(arkAppCGICallback);
        runTask(queryTask_DownloadAppPackage, new ITaskHttpResult() { // from class: com.tencent.ark.open.internal.ArkAppCGIMgr.4
            @Override // com.tencent.ark.open.internal.ArkAppCGIMgr.ITaskHttpResult
            public void onTaskHttpResult(QueryTask queryTask, boolean z16, byte[] bArr2) {
                ArkAppCGIMgr.onDownloadAppPackage((QueryTask_DownloadAppPackage) queryTask, z16, bArr2);
            }
        });
    }

    public void queryAppInfoByAppName(ArrayList<AppNameVersion> arrayList, final ArkAppCGICallback arkAppCGICallback) {
        if (arrayList != null && arrayList.size() != 0) {
            String appUpdateReqString = getAppUpdateReqString(arrayList);
            if (TextUtils.isEmpty(appUpdateReqString)) {
                Logger.logI(TAG, "queryAppInfoByAppNameBatch, request string is empty");
            } else {
                Logger.logI(TAG, String.format("queryAppInfoByAppNameBatch, request, req=%s", appUpdateReqString));
                sendQueryAppInfoRequest(appUpdateReqString, new IQueryAppInfoRequestCallback() { // from class: com.tencent.ark.open.internal.ArkAppCGIMgr.1
                    @Override // com.tencent.ark.open.internal.ArkAppCGIMgr.IQueryAppInfoRequestCallback
                    public void onResult(String str) {
                        QueryAppInfoByAppNameBatchResult parserReply_queryAppInfoByAppNameBatch = ArkAppCGIMgr.this.parserReply_queryAppInfoByAppNameBatch(str);
                        ArkAppCGICallback arkAppCGICallback2 = arkAppCGICallback;
                        if (arkAppCGICallback2 != null) {
                            arkAppCGICallback2.onQueryAppInfoByAppName(parserReply_queryAppInfoByAppNameBatch);
                        }
                    }
                });
            }
        }
    }

    void sendQueryAppInfoRequest(String str, IQueryAppInfoRequestCallback iQueryAppInfoRequestCallback) {
        if (sendQueryAppInfoRequestBySSO(str, iQueryAppInfoRequestCallback) || sendQueryAppInfoRequestByHTTP(str, iQueryAppInfoRequestCallback)) {
            return;
        }
        iQueryAppInfoRequestCallback.onResult(null);
    }

    boolean sendQueryAppInfoRequestByHTTP(String str, final IQueryAppInfoRequestCallback iQueryAppInfoRequestCallback) {
        IArkDelegateNet netDelegate = ArkDelegateManager.getInstance().getNetDelegate();
        if (netDelegate == null) {
            return false;
        }
        netDelegate.post("https://cgi.ark.qq.com/proxy/apps", null, str.getBytes(StandardCharsets.UTF_8), new IArkDelegateHTTPCallback() { // from class: com.tencent.ark.open.internal.ArkAppCGIMgr.3
            @Override // com.tencent.ark.open.delegate.IArkDelegateHTTPCallback
            public void onComplete(int i3, byte[] bArr) {
                if (i3 == 0 && bArr != null) {
                    iQueryAppInfoRequestCallback.onResult(new String(bArr, StandardCharsets.UTF_8));
                } else {
                    iQueryAppInfoRequestCallback.onResult(null);
                }
            }
        });
        return true;
    }

    boolean sendQueryAppInfoRequestBySSO(String str, final IQueryAppInfoRequestCallback iQueryAppInfoRequestCallback) {
        IArkDelegateSSO sSODelegate = ArkDelegateManager.getInstance().getSSODelegate();
        if (sSODelegate == null) {
            return false;
        }
        sSODelegate.send("ArkAppInfo.QueryAppInfo", str, 10000, new IArkDelegateSSOCallback() { // from class: com.tencent.ark.open.internal.ArkAppCGIMgr.2
            @Override // com.tencent.ark.open.delegate.IArkDelegateSSOCallback
            public void onComplete(boolean z16, Object obj) {
                if (!z16) {
                    Logger.logI(ArkAppCGIMgr.TAG, "sendQueryAppInfoRequestBySSO, sso request failed");
                    iQueryAppInfoRequestCallback.onResult(null);
                } else {
                    iQueryAppInfoRequestCallback.onResult((String) obj);
                }
            }
        });
        return true;
    }

    static boolean verifyAppPackage(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            return false;
        }
        try {
            Signature verifySignature = getVerifySignature();
            if (verifySignature == null) {
                Logger.logI(TAG, "verifyAppPackage, get sign failed");
                return true;
            }
            verifySignature.update(bArr);
            boolean verify = verifySignature.verify(bArr2);
            Logger.logI(TAG, "verifyAppPackage, verify result is " + verify);
            return verify;
        } catch (Exception e16) {
            Logger.logI(TAG, "verifyAppPackage, verify Exception:" + e16.getMessage());
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class ArkAppCGICallback {
        public void onQueryAppInfoByAppName(QueryAppInfoByAppNameBatchResult queryAppInfoByAppNameBatchResult) {
        }

        public void onDownloadAppIcon(boolean z16, byte[] bArr, Object obj) {
        }

        public void onDownloadAppPackage(boolean z16, byte[] bArr, Object obj) {
        }
    }
}
