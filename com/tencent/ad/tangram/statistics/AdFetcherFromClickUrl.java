package com.tencent.ad.tangram.statistics;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.ipc.AdIPCManager;
import com.tencent.ad.tangram.json.AdJSON;
import com.tencent.ad.tangram.json.AdJSONUtil;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.net.AdHttp;
import com.tencent.ad.tangram.process.AdProcessManager;
import com.tencent.ad.tangram.protocol.click;
import com.tencent.ad.tangram.util.AdStringUtil;
import com.tencent.ad.tangram.util.AdUriUtil;
import com.tencent.biz.common.util.WebViewConstants;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class AdFetcherFromClickUrl {
    private static final String TAG = "AdFetcherFromClickUrl";
    private static AdFetcherFromClickUrl sInstance;
    private CacheGetterIPCHandler mCacheGetterIPCHandler;
    private CacheSetterIPCHandler mCacheSetterIPCHandler;
    private volatile boolean mInitialized = false;
    private final ConcurrentHashMap<String, Result> mMap = new ConcurrentHashMap<>();
    private WeakReference<Context> mWeakContext;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private static final class CacheGetterIPCHandler implements AdIPCManager.Handler {
        private static final String ACTION_GET_CACHE = "AdFetcherFromClickUrl_ACTION_GET_CACHE";
        private static final String KEY_AID = "IPC_AID";
        private static final String KEY_RESULT = "IPC_RESULT";
        private static final String KEY_TRACE_ID = "IPC_TRACE_ID";
        private static final String KEY_UUID = "IPC_UUID";
        private final WeakReference<Context> mWeakAppContext;

        public CacheGetterIPCHandler(WeakReference<Context> weakReference) {
            AdIPCManager.getInstance().register(ACTION_GET_CACHE, this);
            this.mWeakAppContext = weakReference;
        }

        public Result getCache(String str, Ad ad5) {
            long j3;
            String str2;
            Context context;
            Serializable serializable;
            Bundle bundle;
            if (ad5 != null) {
                j3 = ad5.getAId();
            } else {
                j3 = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
            }
            if (ad5 != null) {
                str2 = ad5.getTraceId();
            } else {
                str2 = null;
            }
            if (TextUtils.isEmpty(str)) {
                AdLog.e(AdFetcherFromClickUrl.TAG, "[CacheGetterIPCHandler][getCache] error, uuid is empty, uuid:" + str + " aid:" + j3 + " traceId:" + str2);
                return null;
            }
            Boolean isOnMainProcess = AdProcessManager.getInstance().isOnMainProcess();
            if (isOnMainProcess == null) {
                AdLog.e(AdFetcherFromClickUrl.TAG, "[CacheGetterIPCHandler][getCache] error, unknown process, uuid:" + str + " aid:" + j3 + " traceId:" + str2);
                return null;
            }
            if (isOnMainProcess.booleanValue()) {
                AdLog.e(AdFetcherFromClickUrl.TAG, "[CacheGetterIPCHandler][getCache] error, should not on main process, uuid:" + str + " aid:" + j3 + " traceId:" + str2);
                return null;
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                AdLog.e(AdFetcherFromClickUrl.TAG, "[CacheGetterIPCHandler][getCache] error, should not on main thread, uuid:" + str + " aid:" + j3 + " traceId:" + str2);
                return null;
            }
            WeakReference<Context> weakReference = this.mWeakAppContext;
            if (weakReference != null) {
                context = weakReference.get();
            } else {
                context = null;
            }
            if (context == null) {
                AdLog.e(AdFetcherFromClickUrl.TAG, "[CacheGetterIPCHandler][getCache] error, context is null, uuid:" + str + " aid:" + j3 + " traceId:" + str2);
                return null;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString(AdIPCManager.Params.KEY_ACTION, ACTION_GET_CACHE);
            bundle2.putString(AdIPCManager.Params.KEY_TO_PROCESS_NAME, AdProcessManager.getInstance().getMainProcessName());
            bundle2.putString(KEY_UUID, str);
            bundle2.putLong(KEY_AID, j3);
            bundle2.putString(KEY_TRACE_ID, str2);
            AdLog.i(AdFetcherFromClickUrl.TAG, "[CacheGetterIPCHandler][getCache] start, uuid:" + str + " aid:" + j3 + " traceId:" + str2);
            AdIPCManager.Result send = AdIPCManager.getInstance().send(context, new AdIPCManager.Params(bundle2));
            if (send != null && send.success && (bundle = send.bundle) != null && bundle.containsKey(KEY_RESULT)) {
                serializable = send.bundle.getSerializable(KEY_RESULT);
            } else {
                serializable = null;
            }
            if (!(serializable instanceof Result)) {
                AdLog.e(AdFetcherFromClickUrl.TAG, "[CacheGetterIPCHandler][getCache] error, serializable not instanceof Result, uuid:" + str + " aid:" + j3 + " traceId:" + str2);
                return null;
            }
            Result result = (Result) serializable;
            if (!result.isSuccess()) {
                AdLog.e(AdFetcherFromClickUrl.TAG, "[CacheGetterIPCHandler][getCache] error, result is not success, uuid:" + str + " aid:" + j3 + " traceId:" + str2);
                return null;
            }
            AdLog.i(AdFetcherFromClickUrl.TAG, "[CacheGetterIPCHandler][getCache] success, uuid:" + str + " aid:" + j3 + " traceId:" + str2);
            return result;
        }

        @Override // com.tencent.ad.tangram.ipc.AdIPCManager.Handler
        public AdIPCManager.Result handle(AdIPCManager.Params params) {
            String str;
            long j3;
            String str2;
            Bundle bundle;
            Bundle bundle2;
            Bundle bundle3;
            Boolean isOnMainProcess = AdProcessManager.getInstance().isOnMainProcess();
            if (isOnMainProcess == null) {
                AdLog.e(AdFetcherFromClickUrl.TAG, "[CacheGetterIPCHandler][handle] error, unknown process");
                return null;
            }
            if (!isOnMainProcess.booleanValue()) {
                AdLog.e(AdFetcherFromClickUrl.TAG, "[CacheGetterIPCHandler][handle] error, should on main process");
                return null;
            }
            if (params != null && params.isValid() && (bundle3 = params.bundle) != null && bundle3.containsKey(KEY_UUID)) {
                str = params.bundle.getString(KEY_UUID);
            } else {
                str = null;
            }
            if (params != null && params.isValid() && (bundle2 = params.bundle) != null && bundle2.containsKey(KEY_AID)) {
                j3 = params.bundle.getLong(KEY_AID);
            } else {
                j3 = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
            }
            if (params != null && params.isValid() && (bundle = params.bundle) != null && bundle.containsKey(KEY_TRACE_ID)) {
                str2 = params.bundle.getString(KEY_TRACE_ID);
            } else {
                str2 = null;
            }
            if (TextUtils.isEmpty(str)) {
                AdLog.i(AdFetcherFromClickUrl.TAG, "[CacheGetterIPCHandler][handle] error, uuid is empty, uuid:" + str + " aid:" + j3 + " traceId:" + str2);
                return null;
            }
            if (!AdFetcherFromClickUrl.getInstance().mMap.containsKey(str)) {
                AdLog.i(AdFetcherFromClickUrl.TAG, "[CacheGetterIPCHandler][handle] error, uuid not exists, uuid:" + str + " aid:" + j3 + " traceId:" + str2);
                return null;
            }
            Result result = (Result) AdFetcherFromClickUrl.getInstance().mMap.get(str);
            if (result == null || !result.isSuccess()) {
                AdLog.e(AdFetcherFromClickUrl.TAG, "[CacheGetterIPCHandler][handle] error, result is not success, uuid:" + str + " aid:" + j3 + " traceId:" + str2);
            }
            AdLog.i(AdFetcherFromClickUrl.TAG, "[CacheGetterIPCHandler][handle]uuid:" + str + " aid:" + j3 + " traceId:" + str2);
            AdIPCManager.Result result2 = new AdIPCManager.Result();
            result2.success = true;
            Bundle bundle4 = new Bundle();
            result2.bundle = bundle4;
            bundle4.putSerializable(KEY_RESULT, result);
            return result2;
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private static final class CacheSetterIPCHandler implements AdIPCManager.Handler {
        private static final String ACTION_SET_CACHE = "AdFetcherFromClickUrl_ACTION_SET_CACHE";
        private static final String KEY_AID = "IPC_AID";
        private static final String KEY_RESULT = "IPC_RESULT";
        private static final String KEY_TRACE_ID = "IPC_TRACE_ID";
        private final WeakReference<Context> mWeakAppContext;

        public CacheSetterIPCHandler(WeakReference<Context> weakReference) {
            AdIPCManager.getInstance().register(ACTION_SET_CACHE, this);
            this.mWeakAppContext = weakReference;
        }

        @Override // com.tencent.ad.tangram.ipc.AdIPCManager.Handler
        public AdIPCManager.Result handle(AdIPCManager.Params params) {
            long j3;
            String str;
            Serializable serializable;
            Bundle bundle;
            Bundle bundle2;
            Bundle bundle3;
            Boolean isOnMainProcess = AdProcessManager.getInstance().isOnMainProcess();
            if (isOnMainProcess == null) {
                AdLog.e(AdFetcherFromClickUrl.TAG, "[CacheGetterIPCHandler][handle] error, unknown process");
                return null;
            }
            if (!isOnMainProcess.booleanValue()) {
                AdLog.e(AdFetcherFromClickUrl.TAG, "[CacheGetterIPCHandler][handle] error, not on main process");
                return null;
            }
            if (params != null && params.isValid() && (bundle3 = params.bundle) != null && bundle3.containsKey(KEY_AID)) {
                j3 = params.bundle.getLong(KEY_AID);
            } else {
                j3 = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
            }
            if (params != null && params.isValid() && (bundle2 = params.bundle) != null && bundle2.containsKey(KEY_TRACE_ID)) {
                str = params.bundle.getString(KEY_TRACE_ID);
            } else {
                str = null;
            }
            if (params != null && params.isValid() && (bundle = params.bundle) != null && bundle.containsKey(KEY_RESULT)) {
                serializable = params.bundle.getSerializable(KEY_RESULT);
            } else {
                serializable = null;
            }
            if (!(serializable instanceof Result)) {
                AdLog.e(AdFetcherFromClickUrl.TAG, "[CacheGetterIPCHandler][handle] error, serializable not instanceof Result, aid:" + j3 + " traceId:" + str);
                return null;
            }
            Result result = (Result) serializable;
            if (!result.isSuccess()) {
                AdLog.e(AdFetcherFromClickUrl.TAG, "[CacheGetterIPCHandler][handle] error, result is not success, aid:" + j3 + " traceId:" + str);
                return null;
            }
            if (AdFetcherFromClickUrl.getInstance().mMap.containsKey(result.getUUID())) {
                AdLog.e(AdFetcherFromClickUrl.TAG, "[CacheGetterIPCHandler][handle] error, uuid is exists, uuid:" + result.getUUID() + " aid:" + j3 + " traceId:" + str + " clickId:" + result.getClickId() + " url:" + result.getUrl());
                return null;
            }
            AdLog.i(AdFetcherFromClickUrl.TAG, "[CacheGetterIPCHandler][handle] uuid:" + result.getUUID() + " aid:" + j3 + " traceId:" + str + " clickId:" + result.getClickId() + " url:" + result.getUrl());
            AdFetcherFromClickUrl.getInstance().mMap.put(result.getUUID(), result);
            AdIPCManager.Result result2 = new AdIPCManager.Result();
            result2.success = true;
            return result2;
        }

        public void setCache(Ad ad5, Result result) {
            long j3;
            String str;
            boolean z16;
            if (ad5 != null) {
                j3 = ad5.getAId();
            } else {
                j3 = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
            }
            Context context = null;
            if (ad5 != null) {
                str = ad5.getTraceId();
            } else {
                str = null;
            }
            if (result != null && result.isSuccess()) {
                Boolean isOnMainProcess = AdProcessManager.getInstance().isOnMainProcess();
                if (isOnMainProcess == null) {
                    AdLog.e(AdFetcherFromClickUrl.TAG, "[CacheSetterIPCHandler][setCache] error, unknown process, aid:" + j3 + " traceId:" + str + " clickId:" + result.getClickId() + " url:" + result.getUrl());
                    return;
                }
                if (isOnMainProcess.booleanValue()) {
                    AdLog.e(AdFetcherFromClickUrl.TAG, "[CacheSetterIPCHandler][setCache] error, should not on main process, aid:" + j3 + " traceId:" + str + " clickId:" + result.getClickId() + " url:" + result.getUrl());
                    return;
                }
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    AdLog.e(AdFetcherFromClickUrl.TAG, "[CacheSetterIPCHandler][setCache] error, should not on main thread, aid:" + j3 + " traceId:" + str + " clickId:" + result.getClickId() + " url:" + result.getUrl());
                    return;
                }
                WeakReference<Context> weakReference = this.mWeakAppContext;
                if (weakReference != null) {
                    context = weakReference.get();
                }
                if (context == null) {
                    AdLog.e(AdFetcherFromClickUrl.TAG, "[CacheSetterIPCHandler][setCache] error, context is null, aid:" + j3 + " traceId:" + str + " clickId:" + result.getClickId() + " url:" + result.getUrl());
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putString(AdIPCManager.Params.KEY_ACTION, ACTION_SET_CACHE);
                bundle.putString(AdIPCManager.Params.KEY_TO_PROCESS_NAME, AdProcessManager.getInstance().getMainProcessName());
                bundle.putLong(KEY_AID, j3);
                bundle.putString(KEY_TRACE_ID, str);
                bundle.putSerializable(KEY_RESULT, result);
                AdLog.i(AdFetcherFromClickUrl.TAG, "[CacheSetterIPCHandler][setCache] start, aid:" + j3 + " traceId:" + str + " clickId:" + result.getClickId() + " url:" + result.getUrl());
                AdIPCManager.Result send = AdIPCManager.getInstance().send(context, new AdIPCManager.Params(bundle));
                StringBuilder sb5 = new StringBuilder();
                sb5.append("[CacheSetterIPCHandler][setCache] end, success:");
                if (send != null && send.success) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                sb5.append(z16);
                sb5.append(" aid:");
                sb5.append(j3);
                sb5.append(" traceId:");
                sb5.append(str);
                sb5.append(" clickId:");
                sb5.append(result.getClickId());
                sb5.append(" url:");
                sb5.append(result.getUrl());
                AdLog.i(AdFetcherFromClickUrl.TAG, sb5.toString());
                return;
            }
            AdLog.e(AdFetcherFromClickUrl.TAG, "[CacheSetterIPCHandler][setCache] error, result not valid, aid:" + j3 + " traceId:" + str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class Result implements Serializable {
        private final click.Response mResponse;
        private final String mUUID;

        public Result(String str, click.Response response) {
            this.mUUID = str;
            this.mResponse = response;
        }

        public String getClickId() {
            if (isSuccess()) {
                return this.mResponse.data.clickid;
            }
            return null;
        }

        public String getUUID() {
            if (isSuccess()) {
                return this.mUUID;
            }
            return null;
        }

        public String getUrl() {
            if (isSuccess()) {
                return this.mResponse.data.dstlink;
            }
            return null;
        }

        public boolean isSuccess() {
            click.Response response;
            click.Response.Data data;
            if (!TextUtils.isEmpty(this.mUUID) && (response = this.mResponse) != null && response.ret == 0 && (data = response.data) != null && !TextUtils.isEmpty(data.clickid) && !TextUtils.isEmpty(this.mResponse.data.dstlink)) {
                return true;
            }
            return false;
        }
    }

    AdFetcherFromClickUrl() {
    }

    private static String formatClickUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            AdLog.e(TAG, "[formatClickUrl] error, clickUrl is empty");
            return null;
        }
        Uri parse = AdUriUtil.parse(str);
        if (parse == null) {
            AdLog.e(TAG, "[formatClickUrl] error, uri is null");
            return null;
        }
        Uri.Builder buildUpon = parse.buildUpon();
        if (buildUpon == null) {
            AdLog.e(TAG, "[formatClickUrl] error, builder is null");
            return null;
        }
        if (TextUtils.equals(AdUriUtil.getQueryParameter(parse, "rt"), "1")) {
            AdLog.i(TAG, "[formatClickUrl] error, param exists");
            return str;
        }
        Uri.Builder appendQueryParameter = buildUpon.appendQueryParameter("rt", "1");
        if (appendQueryParameter == null) {
            AdLog.e(TAG, "[formatClickUrl] error, after append parameter, builder is null");
            return null;
        }
        return appendQueryParameter.toString();
    }

    public static AdFetcherFromClickUrl getInstance() {
        if (sInstance == null) {
            synchronized (AdFetcherFromClickUrl.class) {
                if (sInstance == null) {
                    sInstance = new AdFetcherFromClickUrl();
                }
            }
        }
        return sInstance;
    }

    private static click.Response query(WeakReference<Context> weakReference, Ad ad5, String str) {
        String str2;
        String formatClickUrl = formatClickUrl(str);
        click.Response response = null;
        if (TextUtils.isEmpty(formatClickUrl)) {
            AdLog.e(TAG, "[query] error, clickUrlFormatted is empty, clickUrl:" + str);
            return null;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            AdLog.e(TAG, "[query] error, should not on main thread, clickUrlFormatted:" + formatClickUrl);
            return null;
        }
        AdReporterLogger.logStart(TAG, "[query] start, clickUrlFormatted:" + formatClickUrl, 1, weakReference, ad5);
        AdHttp.Params params = new AdHttp.Params();
        params.setUrl(formatClickUrl);
        params.method = "GET";
        AdHttp.send(params);
        if (params.responseCode == 200) {
            String newString = AdStringUtil.newString(params.responseData, StandardCharsets.UTF_8);
            try {
                str2 = newString;
                response = (click.Response) AdJSON.toObject(AdJSONUtil.newJSONObject(newString), click.Response.class);
            } catch (Throwable th5) {
                AdLog.e(TAG, "[query]", th5);
                str2 = newString;
            }
        } else {
            str2 = null;
        }
        AdReporterLogger.logEnd(TAG, "[query] end", 1, new int[]{200}, params, response, str2, weakReference, ad5);
        return response;
    }

    private Result queryByIPCOnNetworkThread(String str, Ad ad5) {
        long j3;
        String str2;
        if (ad5 != null) {
            j3 = ad5.getAId();
        } else {
            j3 = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        }
        if (ad5 != null) {
            str2 = ad5.getTraceId();
        } else {
            str2 = null;
        }
        if (TextUtils.isEmpty(str)) {
            AdLog.e(TAG, "[queryByIPCOnNetworkThread] error, uuid is empty, uuid:" + str + " aid:" + j3 + " traceId:" + str2);
            return null;
        }
        if (!this.mInitialized) {
            AdLog.e(TAG, "[queryByIPCOnNetworkThread] error, not initialized, uuid:" + str + " aid:" + j3 + " traceId:" + str2);
            return null;
        }
        Boolean isOnMainProcess = AdProcessManager.getInstance().isOnMainProcess();
        if (isOnMainProcess == null) {
            AdLog.e(TAG, "[queryByIPCOnNetworkThread] error, unknown process, uuid:" + str + " aid:" + j3 + " traceId:" + str2);
            return null;
        }
        Result result = this.mMap.get(str);
        if (!isOnMainProcess.booleanValue() && result == null && (result = this.mCacheGetterIPCHandler.getCache(str, ad5)) != null && result.isSuccess()) {
            this.mMap.put(str, result);
        }
        return result;
    }

    public void init(WeakReference<Context> weakReference) {
        Context context;
        if (this.mInitialized) {
            return;
        }
        Context context2 = null;
        if (weakReference != null) {
            context = weakReference.get();
        } else {
            context = null;
        }
        if (context != null) {
            context2 = context.getApplicationContext();
        }
        if (context2 == null) {
            AdLog.e(TAG, "[init] error, context is null");
            return;
        }
        WeakReference<Context> weakReference2 = new WeakReference<>(context2);
        synchronized (this) {
            if (this.mInitialized) {
                return;
            }
            AdLog.i(TAG, "[init]");
            this.mWeakContext = weakReference2;
            this.mCacheSetterIPCHandler = new CacheSetterIPCHandler(weakReference2);
            this.mCacheGetterIPCHandler = new CacheGetterIPCHandler(weakReference2);
            this.mInitialized = true;
        }
    }

    public Result queryByCGIOnNetworkThread(String str, Ad ad5, String str2) {
        long j3;
        String str3;
        if (ad5 != null) {
            j3 = ad5.getAId();
        } else {
            j3 = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        }
        if (ad5 != null) {
            str3 = ad5.getTraceId();
        } else {
            str3 = null;
        }
        if (TextUtils.isEmpty(str)) {
            AdLog.e(TAG, "[queryByCGIOnNetworkThread] error, uuid is empty, uuid:" + str + " aid:" + j3 + " traceId:" + str3);
            return null;
        }
        if (this.mMap.containsKey(str)) {
            AdLog.e(TAG, "[queryByCGIOnNetworkThread] error, too frequently, uuid:" + str + " aid:" + j3 + " traceId:" + str3);
            return null;
        }
        if (TextUtils.isEmpty(str2)) {
            AdLog.e(TAG, "[queryByCGIOnNetworkThread] error, clickUrl is empty, uuid:" + str + " aid:" + j3 + " traceId:" + str3);
            return null;
        }
        if (!this.mInitialized) {
            AdLog.e(TAG, "[queryByCGIOnNetworkThread] error, not initialized, uuid:" + str + " aid:" + j3 + " traceId:" + str3);
            return null;
        }
        Boolean isOnMainProcess = AdProcessManager.getInstance().isOnMainProcess();
        if (isOnMainProcess == null) {
            AdLog.e(TAG, "[queryByCGIOnNetworkThread] error, unknown process, uuid:" + str + " aid:" + j3 + " traceId:" + str3);
            return null;
        }
        Result result = new Result(str, query(this.mWeakContext, ad5, str2));
        if (!result.isSuccess()) {
            AdLog.e(TAG, "[queryByCGIOnNetworkThread] error, result is not valid, uuid:" + str + " aid:" + j3 + " traceId:" + str3);
            return result;
        }
        this.mMap.put(str, result);
        if (!isOnMainProcess.booleanValue()) {
            this.mCacheSetterIPCHandler.setCache(ad5, result);
        }
        AdLog.i(TAG, "[queryByCGIOnNetworkThread]uuid:" + str + " aid:" + j3 + " traceId:" + str3 + " clickId:" + result.getClickId() + " url:" + result.getUrl());
        return result;
    }

    public Result queryByCache(String str, Ad ad5) {
        long j3;
        String str2;
        if (ad5 != null) {
            j3 = ad5.getAId();
        } else {
            j3 = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        }
        if (ad5 != null) {
            str2 = ad5.getTraceId();
        } else {
            str2 = null;
        }
        if (!this.mInitialized) {
            AdLog.e(TAG, "[queryByCache] error, not initialized, uuid:" + str + " aid:" + j3 + " traceId:" + str2);
            return null;
        }
        return this.mMap.get(str);
    }
}
