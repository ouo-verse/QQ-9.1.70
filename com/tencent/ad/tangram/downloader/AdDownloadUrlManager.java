package com.tencent.ad.tangram.downloader;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.ad.tangram.annotation.AdKeep;
import com.tencent.ad.tangram.ipc.AdIPCManager;
import com.tencent.ad.tangram.json.AdJSONUtil;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.net.AdHttp;
import com.tencent.ad.tangram.process.AdProcessManager;
import com.tencent.ad.tangram.util.AdStringUtil;
import java.lang.ref.WeakReference;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public final class AdDownloadUrlManager {
    private static final String KEY_APK_URL = "KEY_APK_URL";
    private static final String KEY_TRACE_ID = "KEY_TRACE_ID";
    private static final String TAG = "AdDownloadUrlManager";
    private static volatile AdDownloadUrlManager sInstance;
    private volatile IPCHandlerForQuery mIPCHandlerForQuery;
    private volatile IPCHandlerForUpdate mIPCHandlerForUpdate;
    private volatile boolean mInitialized = false;
    private ConcurrentHashMap<String, String> mMap = new ConcurrentHashMap<>();
    private volatile WeakReference<Context> mWeakAppContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class IPCHandlerForQuery implements AdIPCManager.Handler {
        private static final String ACTION_QUERY = "AdDownloadUrlManager_ACTION_QUERY";
        private WeakReference<Context> mWeakAppContext;

        public IPCHandlerForQuery(WeakReference<Context> weakReference) {
            AdIPCManager.getInstance().register(ACTION_QUERY, this);
            this.mWeakAppContext = weakReference;
        }

        @Override // com.tencent.ad.tangram.ipc.AdIPCManager.Handler
        public AdIPCManager.Result handle(AdIPCManager.Params params) {
            Bundle bundle;
            Boolean isOnMainProcess = AdProcessManager.getInstance().isOnMainProcess();
            String str = null;
            if (isOnMainProcess == null) {
                AdLog.e(AdDownloadUrlManager.TAG, "[IPCHandlerForQuery][handle] error, unknown process");
                return null;
            }
            if (!isOnMainProcess.booleanValue()) {
                AdLog.e(AdDownloadUrlManager.TAG, "[IPCHandlerForQuery][handle] error, not in main process");
                return null;
            }
            AdIPCManager.Result result = new AdIPCManager.Result();
            result.success = true;
            if (params != null && params.isValid() && (bundle = params.bundle) != null) {
                str = bundle.getString(AdDownloadUrlManager.KEY_TRACE_ID);
            }
            if (!TextUtils.isEmpty(str)) {
                String queryByCache = AdDownloadUrlManager.getInstance().queryByCache(str);
                AdLog.i(AdDownloadUrlManager.TAG, "[IPCHandlerForQuery][handle] traceId:" + str + " apkUrl:" + queryByCache);
                if (!TextUtils.isEmpty(queryByCache)) {
                    Bundle bundle2 = new Bundle();
                    result.bundle = bundle2;
                    bundle2.putString(AdDownloadUrlManager.KEY_APK_URL, queryByCache);
                }
                return result;
            }
            AdLog.e(AdDownloadUrlManager.TAG, "[IPCHandlerForQuery][handle] error, traceId:" + str);
            return result;
        }

        public String queryByCache(String str) {
            Context context;
            boolean z16;
            Bundle bundle;
            Boolean isOnMainProcess = AdProcessManager.getInstance().isOnMainProcess();
            String str2 = null;
            if (isOnMainProcess == null) {
                AdLog.e(AdDownloadUrlManager.TAG, "[IPCHandlerForQuery][queryByCache] error, unknown process");
                return null;
            }
            if (isOnMainProcess.booleanValue()) {
                AdLog.e(AdDownloadUrlManager.TAG, "[IPCHandlerForQuery][queryByCache] error, in main process");
                return null;
            }
            if (TextUtils.isEmpty(str)) {
                AdLog.e(AdDownloadUrlManager.TAG, "[IPCHandlerForQuery][queryByCache] error, traceId:" + str);
                return null;
            }
            WeakReference<Context> weakReference = this.mWeakAppContext;
            if (weakReference != null) {
                context = weakReference.get();
            } else {
                context = null;
            }
            if (context == null) {
                AdLog.e(AdDownloadUrlManager.TAG, "[IPCHandlerForQuery][queryByCache] error, context is null");
                return null;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString(AdIPCManager.Params.KEY_ACTION, ACTION_QUERY);
            bundle2.putString(AdIPCManager.Params.KEY_TO_PROCESS_NAME, AdProcessManager.getInstance().getMainProcessName());
            bundle2.putString(AdDownloadUrlManager.KEY_TRACE_ID, str);
            AdLog.i(AdDownloadUrlManager.TAG, "[IPCHandlerForQuery][queryByCache] before, traceId:" + str);
            AdIPCManager.Result send = AdIPCManager.getInstance().send(context, new AdIPCManager.Params(bundle2));
            if (send != null && send.success && (bundle = send.bundle) != null) {
                str2 = bundle.getString(AdDownloadUrlManager.KEY_APK_URL);
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[IPCHandlerForQuery][queryByCache] after, success:");
            if (send != null && send.success) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            sb5.append(" traceId:");
            sb5.append(str);
            sb5.append(" apkUrl:");
            sb5.append(str2);
            AdLog.i(AdDownloadUrlManager.TAG, sb5.toString());
            return str2;
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    static final class IPCHandlerForUpdate implements AdIPCManager.Handler {
        private static final String ACTION_UPDATE = "AdDownloadUrlManager_ACTION_UPDATE";
        private WeakReference<Context> mWeakAppContext;

        public IPCHandlerForUpdate(WeakReference<Context> weakReference) {
            AdIPCManager.getInstance().register(ACTION_UPDATE, this);
            this.mWeakAppContext = weakReference;
        }

        @Override // com.tencent.ad.tangram.ipc.AdIPCManager.Handler
        public AdIPCManager.Result handle(AdIPCManager.Params params) {
            String str;
            Bundle bundle;
            Bundle bundle2;
            Boolean isOnMainProcess = AdProcessManager.getInstance().isOnMainProcess();
            String str2 = null;
            if (isOnMainProcess == null) {
                AdLog.e(AdDownloadUrlManager.TAG, "[IPCHandlerForUpdate][handle] error, unknown process");
                return null;
            }
            if (!isOnMainProcess.booleanValue()) {
                AdLog.e(AdDownloadUrlManager.TAG, "[IPCHandlerForUpdate][handle] error, not in main process");
                return null;
            }
            AdIPCManager.Result result = new AdIPCManager.Result();
            result.success = true;
            if (params != null && params.isValid() && (bundle2 = params.bundle) != null) {
                str = bundle2.getString(AdDownloadUrlManager.KEY_TRACE_ID);
            } else {
                str = null;
            }
            if (params != null && params.isValid() && (bundle = params.bundle) != null) {
                str2 = bundle.getString(AdDownloadUrlManager.KEY_APK_URL);
            }
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                AdLog.i(AdDownloadUrlManager.TAG, "[IPCHandlerForUpdate][handle] traceId:" + str + " apkUrl:" + str2);
                AdDownloadUrlManager.getInstance().updateCache(str, str2, false);
                return result;
            }
            AdLog.e(AdDownloadUrlManager.TAG, "[IPCHandlerForUpdate][handle] error, traceId:" + str + " apkUrl:" + str2);
            return result;
        }

        public void updateCache(String str, String str2) {
            Context context;
            boolean z16;
            Boolean isOnMainProcess = AdProcessManager.getInstance().isOnMainProcess();
            if (isOnMainProcess == null) {
                AdLog.e(AdDownloadUrlManager.TAG, "[IPCHandlerForUpdate][updateCache] error, unknown process");
                return;
            }
            if (isOnMainProcess.booleanValue()) {
                AdLog.e(AdDownloadUrlManager.TAG, "[IPCHandlerForUpdate][updateCache] error, in main process");
                return;
            }
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                WeakReference<Context> weakReference = this.mWeakAppContext;
                if (weakReference != null) {
                    context = weakReference.get();
                } else {
                    context = null;
                }
                if (context == null) {
                    AdLog.e(AdDownloadUrlManager.TAG, "[IPCHandlerForUpdate][updateCache] error, context is null");
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putString(AdIPCManager.Params.KEY_ACTION, ACTION_UPDATE);
                bundle.putString(AdIPCManager.Params.KEY_TO_PROCESS_NAME, AdProcessManager.getInstance().getMainProcessName());
                bundle.putString(AdDownloadUrlManager.KEY_TRACE_ID, str);
                bundle.putString(AdDownloadUrlManager.KEY_APK_URL, str2);
                AdLog.i(AdDownloadUrlManager.TAG, "[IPCHandlerForUpdate][updateCache] before, traceId:" + str + " apkUrl:" + str2);
                AdIPCManager.Result send = AdIPCManager.getInstance().send(context, new AdIPCManager.Params(bundle));
                StringBuilder sb5 = new StringBuilder();
                sb5.append("[IPCHandlerForUpdate][updateCache] after, success:");
                if (send != null && send.success) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                sb5.append(z16);
                sb5.append(" traceId:");
                sb5.append(str);
                sb5.append(" apkUrl:");
                sb5.append(str2);
                AdLog.i(AdDownloadUrlManager.TAG, sb5.toString());
                return;
            }
            AdLog.e(AdDownloadUrlManager.TAG, "[IPCHandlerForUpdate][updateCache] error, traceId:" + str + " apkUrl:" + str2);
        }
    }

    AdDownloadUrlManager() {
    }

    public static AdDownloadUrlManager getInstance() {
        if (sInstance == null) {
            synchronized (AdDownloadUrlManager.class) {
                if (sInstance == null) {
                    sInstance = new AdDownloadUrlManager();
                }
            }
        }
        return sInstance;
    }

    private String queryByCGI(String str) {
        Context context = null;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            AdLog.e(TAG, "[queryByCGI] error, on main thread");
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            AdLog.e(TAG, "[queryByCGI] error, cgiUrl is empty");
            return null;
        }
        AdHttp.Params params = new AdHttp.Params();
        params.setUrl(str);
        params.method = "GET";
        params.contentType = "application/json";
        AdHttp.send(params);
        String optString = AdJSONUtil.optString(AdJSONUtil.newJSONObject(AdStringUtil.newString(params.responseData, StandardCharsets.UTF_8)), "apkUrl", null);
        if (this.mWeakAppContext != null) {
            context = this.mWeakAppContext.get();
        }
        AdAnalysisHelperForDownload.reportForQueryUrlByCGI(context, !TextUtils.isEmpty(optString), params.responseCode);
        return optString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String queryByCache(String str) {
        String str2;
        if (TextUtils.isEmpty(str) || !this.mMap.containsKey(str)) {
            str2 = null;
        } else {
            str2 = this.mMap.get(str);
            if (TextUtils.isEmpty(str2)) {
                this.mMap.remove(str);
            }
        }
        AdLog.i(TAG, "[queryByCache] traceId:" + str + " apkUrl:" + str2);
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean updateCache(String str, String str2, boolean z16) {
        boolean z17 = false;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String str3 = this.mMap.get(str);
            if (TextUtils.isEmpty(str3) || z16) {
                this.mMap.put(str, str2);
                z17 = !TextUtils.equals(str3, str2);
            }
            AdLog.i(TAG, "[updateCache] forced:" + z16 + " updated:" + z17 + " equals:" + TextUtils.equals(str3, str2) + " traceId:" + str + " apkUrl:" + str2 + " apkUrlFromCache:" + str3);
            return z17;
        }
        AdLog.e(TAG, "[updateCache] error, forced:" + z16 + " traceId:" + str + " apkUrl:" + str2);
        return false;
    }

    public void init(Context context) {
        WeakReference<Context> weakReference;
        if (this.mInitialized) {
            return;
        }
        if (context != null) {
            weakReference = new WeakReference<>(context.getApplicationContext());
        } else {
            weakReference = null;
        }
        if (weakReference != null && weakReference.get() != null) {
            synchronized (this) {
                if (this.mInitialized) {
                    return;
                }
                AdLog.i(TAG, "[init]");
                this.mWeakAppContext = weakReference;
                this.mIPCHandlerForQuery = new IPCHandlerForQuery(weakReference);
                this.mIPCHandlerForUpdate = new IPCHandlerForUpdate(weakReference);
                this.mInitialized = true;
                return;
            }
        }
        AdLog.e(TAG, "[init] error, context is null");
    }

    public String queryOnNetworkThread(String str) {
        Boolean isOnMainProcess;
        String queryByCache = queryByCache(str);
        if (TextUtils.isEmpty(queryByCache) && (isOnMainProcess = AdProcessManager.getInstance().isOnMainProcess()) != null && !isOnMainProcess.booleanValue()) {
            if (!this.mInitialized) {
                AdLog.e(TAG, "[queryOnNetworkThread] error, not initialized, traceId:" + str);
            } else {
                queryByCache = this.mIPCHandlerForQuery.queryByCache(str);
            }
        }
        AdLog.i(TAG, "[queryOnNetworkThread] traceId:" + str + " apkUrl:" + queryByCache);
        return queryByCache;
    }

    public String queryOnNetworkThread(String str, String str2) {
        Boolean isOnMainProcess;
        String queryOnNetworkThread = queryOnNetworkThread(str);
        if (TextUtils.isEmpty(queryOnNetworkThread)) {
            queryOnNetworkThread = queryByCGI(str2);
            if (!TextUtils.isEmpty(queryOnNetworkThread) && updateCache(str, queryOnNetworkThread, true) && (isOnMainProcess = AdProcessManager.getInstance().isOnMainProcess()) != null && !isOnMainProcess.booleanValue()) {
                if (!this.mInitialized) {
                    AdLog.e(TAG, "[queryOnNetworkThread] error, not initialized, traceId:" + str + " cgiUrl:" + str2);
                } else {
                    this.mIPCHandlerForUpdate.updateCache(str, queryOnNetworkThread);
                }
            }
        }
        AdLog.i(TAG, "[queryOnNetworkThread] traceId:" + str + " cgiUrl:" + str2 + " apkUrl:" + queryOnNetworkThread);
        return queryOnNetworkThread;
    }
}
