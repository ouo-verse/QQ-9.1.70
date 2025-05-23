package com.tencent.ad.tangram.ipc;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.ad.tangram.annotation.AdKeep;
import com.tencent.ad.tangram.log.AdLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

@AdKeep
/* loaded from: classes3.dex */
public final class AdIPCManager {
    private static final String TAG = "AdIPCManager";
    private static volatile AdIPCManager sInstance;

    @Nullable
    private WeakReference<Adapter> adapter;
    private volatile boolean initialized = false;

    @NonNull
    private Map<String, Handler> map = new HashMap();

    @AdKeep
    /* loaded from: classes3.dex */
    public interface Adapter {
        @Nullable
        Handler getHandler(String str);

        void init(Context context);

        boolean register(String str, Handler handler);

        @Nullable
        Result send(Context context, Params params);

        void send(Context context, Params params, WeakReference<Callback> weakReference);
    }

    @AdKeep
    /* loaded from: classes3.dex */
    public interface Callback {
        void onCallback(Params params, Result result);
    }

    @AdKeep
    /* loaded from: classes3.dex */
    public interface Handler {
        @Nullable
        Result handle(Params params);
    }

    @AdKeep
    /* loaded from: classes3.dex */
    public static final class Params {
        public static final String KEY_ACTION = "IPC_ACTION";
        public static final String KEY_TO_PROCESS_NAME = "IPC_TO_PROCESS_NAME";
        public Bundle bundle;

        public Params(Bundle bundle) {
            this.bundle = bundle;
        }

        @Nullable
        public String getAction() {
            Bundle bundle = this.bundle;
            if (bundle != null) {
                return bundle.getString(KEY_ACTION);
            }
            return null;
        }

        @Nullable
        public String getToProcessName() {
            Bundle bundle = this.bundle;
            if (bundle != null) {
                return bundle.getString(KEY_TO_PROCESS_NAME);
            }
            return null;
        }

        public boolean isValid() {
            if (!TextUtils.isEmpty(getAction()) && !TextUtils.isEmpty(getToProcessName())) {
                return true;
            }
            return false;
        }
    }

    @AdKeep
    /* loaded from: classes3.dex */
    public static final class Result {
        public Bundle bundle;
        public boolean success = false;
    }

    AdIPCManager() {
    }

    public static AdIPCManager getInstance() {
        if (sInstance == null) {
            synchronized (AdIPCManager.class) {
                if (sInstance == null) {
                    sInstance = new AdIPCManager();
                }
            }
        }
        return sInstance;
    }

    @Nullable
    public Handler getHandler(String str) {
        Adapter adapter;
        WeakReference<Adapter> weakReference = this.adapter;
        if (weakReference != null) {
            adapter = weakReference.get();
        } else {
            adapter = null;
        }
        if (adapter == null) {
            return null;
        }
        return adapter.getHandler(str);
    }

    public void init(Context context, @Nullable WeakReference<Adapter> weakReference) {
        Adapter adapter;
        if (this.initialized) {
            return;
        }
        synchronized (this) {
            if (this.initialized) {
                return;
            }
            this.initialized = true;
            AdLog.i(TAG, String.format("init %b", Boolean.valueOf(this.initialized)));
            this.adapter = weakReference;
            if (weakReference != null) {
                adapter = weakReference.get();
            } else {
                adapter = null;
            }
            if (adapter != null) {
                adapter.init(context);
            }
        }
    }

    public boolean register(String str, Handler handler) {
        Adapter adapter;
        WeakReference<Adapter> weakReference = this.adapter;
        if (weakReference != null) {
            adapter = weakReference.get();
        } else {
            adapter = null;
        }
        if (adapter != null && adapter.register(str, handler)) {
            return true;
        }
        return false;
    }

    @Nullable
    public Result send(Context context, Params params) {
        WeakReference<Adapter> weakReference = this.adapter;
        Adapter adapter = weakReference != null ? weakReference.get() : null;
        if (adapter != null) {
            return adapter.send(context, params);
        }
        return null;
    }

    public void send(Context context, Params params, WeakReference<Callback> weakReference) {
        WeakReference<Adapter> weakReference2 = this.adapter;
        Adapter adapter = weakReference2 != null ? weakReference2.get() : null;
        if (adapter != null) {
            adapter.send(context, params, weakReference);
        }
    }
}
