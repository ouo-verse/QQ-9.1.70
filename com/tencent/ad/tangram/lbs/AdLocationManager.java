package com.tencent.ad.tangram.lbs;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.ad.tangram.annotation.AdKeep;
import com.tencent.ad.tangram.ipc.AdIPCManager;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.privacy.AdPrivacyPolicyManager;
import com.tencent.ad.tangram.process.AdProcessManager;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.biz.common.util.WebViewConstants;
import java.io.Serializable;
import java.lang.ref.WeakReference;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public final class AdLocationManager {
    private static final String TAG = "AdLocationManager";
    private static volatile AdLocationManager sInstance;
    private volatile WeakReference<AdLocationAdapter> adapter;
    private volatile IPCHandler ipcHandler;
    private volatile AdLocation location;
    private volatile boolean initialized = false;
    private volatile long tryToUpdateCacheTimeMillis = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class IPCHandler implements AdIPCManager.Handler {
        static final String ACTION = "GET_LBS_CACHE";
        static final String KEY_LOCATION = "LOCATION";

        @NonNull
        private AdIPCManager.Callback ipcCallback = new AdIPCManager.Callback() { // from class: com.tencent.ad.tangram.lbs.AdLocationManager.IPCHandler.1
            @Override // com.tencent.ad.tangram.ipc.AdIPCManager.Callback
            public void onCallback(AdIPCManager.Params params, @Nullable AdIPCManager.Result result) {
                AdLocation adLocation;
                Bundle bundle;
                Serializable serializable;
                Boolean isOnMainProcess = AdProcessManager.getInstance().isOnMainProcess();
                if (isOnMainProcess != null && !isOnMainProcess.booleanValue() && result != null && result.success && (bundle = result.bundle) != null && bundle.containsKey(IPCHandler.KEY_LOCATION) && (serializable = result.bundle.getSerializable(IPCHandler.KEY_LOCATION)) != null && (serializable instanceof AdLocation)) {
                    adLocation = (AdLocation) AdLocation.class.cast(serializable);
                    if (adLocation.isValid()) {
                        AdLocationManager.getInstance().setLocation(adLocation);
                        AdLog.i(AdLocationManager.TAG, String.format("IPCHandler.onCallback result:%s", adLocation));
                    }
                }
                adLocation = null;
                AdLog.i(AdLocationManager.TAG, String.format("IPCHandler.onCallback result:%s", adLocation));
            }
        };

        public IPCHandler() {
            AdIPCManager.getInstance().register(ACTION, this);
        }

        @Override // com.tencent.ad.tangram.ipc.AdIPCManager.Handler
        @NonNull
        public AdIPCManager.Result handle(@Nullable AdIPCManager.Params params) {
            AdLocation adLocation;
            Bundle bundle;
            Serializable serializable;
            AdIPCManager.Result result = new AdIPCManager.Result();
            Boolean isOnMainProcess = AdProcessManager.getInstance().isOnMainProcess();
            AdLocation adLocation2 = null;
            if (isOnMainProcess != null && isOnMainProcess.booleanValue()) {
                result.success = true;
                AdLocation updateLocationCacheOnCurrentProcess = AdLocationManager.getInstance().updateLocationCacheOnCurrentProcess();
                if (params != null && (bundle = params.bundle) != null && bundle.containsKey(KEY_LOCATION) && (serializable = params.bundle.getSerializable(KEY_LOCATION)) != null && (serializable instanceof AdLocation)) {
                    adLocation2 = (AdLocation) AdLocation.class.cast(serializable);
                }
                adLocation = adLocation2;
                adLocation2 = updateLocationCacheOnCurrentProcess;
            } else {
                adLocation = null;
            }
            AdLocation merge = AdLocation.merge(adLocation2, adLocation);
            AdLocationManager.getInstance().setLocation(merge);
            AdLog.i(AdLocationManager.TAG, String.format("IPCHandler.handle result:%s mainProcess:%s childProcess:%s", merge, adLocation2, adLocation));
            if (merge != null && merge.isValid()) {
                Bundle bundle2 = new Bundle();
                bundle2.putSerializable(KEY_LOCATION, merge);
                result.bundle = bundle2;
            }
            return result;
        }

        public void updateCacheByIPC(@Nullable Context context, @Nullable AdLocation adLocation) {
            Boolean isOnMainProcess = AdProcessManager.getInstance().isOnMainProcess();
            if (isOnMainProcess != null && !isOnMainProcess.booleanValue() && context != null) {
                Bundle bundle = new Bundle();
                bundle.putString(AdIPCManager.Params.KEY_ACTION, ACTION);
                bundle.putString(AdIPCManager.Params.KEY_TO_PROCESS_NAME, AdProcessManager.getInstance().getMainProcessName());
                if (adLocation != null && adLocation.isValid()) {
                    bundle.putSerializable(KEY_LOCATION, adLocation);
                }
                AdIPCManager.getInstance().send(context, new AdIPCManager.Params(bundle), new WeakReference<>(this.ipcCallback));
                AdLog.i(AdLocationManager.TAG, String.format("IPCHandler.updateCacheByIPC childProcess:%s", adLocation));
            }
        }
    }

    AdLocationManager() {
    }

    @Nullable
    private AdLocationAdapter getAdapter() {
        if (this.adapter != null) {
            return this.adapter.get();
        }
        return null;
    }

    public static AdLocationManager getInstance() {
        if (sInstance == null) {
            synchronized (AdLocationManager.class) {
                if (sInstance == null) {
                    sInstance = new AdLocationManager();
                }
            }
        }
        return sInstance;
    }

    private AdLocation getLocation() {
        return this.location;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLocation(final AdLocation adLocation) {
        AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.ad.tangram.lbs.AdLocationManager.1
            @Override // java.lang.Runnable
            public void run() {
                AdLocationManager.getInstance().location = adLocation;
            }
        }, 3);
    }

    private void updateLocationCacheOnChildProcess(Context context, AdLocation adLocation) {
        Boolean isOnMainProcess;
        if (this.initialized && (isOnMainProcess = AdProcessManager.getInstance().isOnMainProcess()) != null && !isOnMainProcess.booleanValue()) {
            if (this.tryToUpdateCacheTimeMillis == WebViewConstants.WV.ENABLE_WEBAIO_SWITCH || System.currentTimeMillis() - this.tryToUpdateCacheTimeMillis >= 60000) {
                this.tryToUpdateCacheTimeMillis = System.currentTimeMillis();
                this.ipcHandler.updateCacheByIPC(context, adLocation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public AdLocation updateLocationCacheOnCurrentProcess() {
        AdLocation adLocation;
        AdLocationAdapter adapter = getAdapter();
        if (adapter != null) {
            adLocation = adapter.getLocationCache();
        } else {
            adLocation = null;
        }
        AdLocation merge = AdLocation.merge(adLocation, getLocation());
        setLocation(merge);
        return merge;
    }

    @Nullable
    public AdLocation getLocationCache(Context context) {
        if (!isSwichOn()) {
            return null;
        }
        AdLocation updateLocationCacheOnCurrentProcess = updateLocationCacheOnCurrentProcess();
        updateLocationCacheOnChildProcess(context, updateLocationCacheOnCurrentProcess);
        return updateLocationCacheOnCurrentProcess;
    }

    public void init(Context context) {
        if (this.initialized) {
            return;
        }
        synchronized (this) {
            if (this.initialized) {
                return;
            }
            this.ipcHandler = new IPCHandler();
            this.initialized = true;
        }
    }

    public boolean isSwichOn() {
        return AdPrivacyPolicyManager.getInstance().isAllowed();
    }

    public void setAdapter(WeakReference<AdLocationAdapter> weakReference) {
        this.adapter = weakReference;
    }
}
