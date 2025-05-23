package com.tencent.ad.tangram.thread;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import com.tencent.ad.tangram.annotation.AdKeep;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.lang.ref.WeakReference;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public final class AdThreadManager {
    public static final int FILE = 5;
    public static final int MAIN_THREAD = 0;
    public static final int NETWORK = 4;
    public static final int NORMAL = 3;
    private static final String TAG = "AdThreadManager";
    private static volatile AdThreadManager sInstance;
    private WeakReference<AdThreadManagerAdapter> adapter;
    private final ScheduledExecutorService executorService = ProxyExecutors.newScheduledThreadPool(0);

    AdThreadManager() {
    }

    @Nullable
    private AdThreadManagerAdapter getAdapter() {
        WeakReference<AdThreadManagerAdapter> weakReference = this.adapter;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public static AdThreadManager getInstance() {
        if (sInstance == null) {
            synchronized (AdThreadManager.class) {
                if (sInstance == null) {
                    sInstance = new AdThreadManager();
                }
            }
        }
        return sInstance;
    }

    public boolean post(@Nullable Runnable runnable, int i3) {
        return postDelayed(runnable, i3, 0L);
    }

    public boolean postDelayed(@Nullable Runnable runnable, int i3, long j3) {
        AdThreadManagerAdapter adapter = getAdapter();
        if (adapter != null) {
            return adapter.postDelayed(runnable, i3, j3);
        }
        if (i3 == 0) {
            return new Handler(Looper.getMainLooper()).postDelayed(runnable, j3);
        }
        try {
            this.executorService.schedule(runnable, j3, TimeUnit.MILLISECONDS);
            return true;
        } catch (Throwable th5) {
            AdLog.e(TAG, "postDelayedOnWorkerThread", th5);
            return false;
        }
    }

    public void setAdapter(WeakReference<AdThreadManagerAdapter> weakReference) {
        this.adapter = weakReference;
    }
}
