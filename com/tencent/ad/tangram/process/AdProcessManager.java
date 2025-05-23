package com.tencent.ad.tangram.process;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.ad.tangram.annotation.AdKeep;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.lang.ref.WeakReference;
import java.util.List;

@AdKeep
/* loaded from: classes3.dex */
public final class AdProcessManager {
    private static final String TAG = "AdProcessManager";
    private static volatile AdProcessManager sInstance;
    private WeakReference<AdProcessManagerAdapter> adapter;

    @Nullable
    private volatile String currentProcessName;

    AdProcessManager() {
    }

    @Nullable
    private AdProcessManagerAdapter getAdapter() {
        WeakReference<AdProcessManagerAdapter> weakReference = this.adapter;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Nullable
    private static String getCurrentProcessNameInternal(@Nullable Context context) {
        if (context == null) {
            return null;
        }
        try {
            Object systemService = context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
            if (systemService != null && (systemService instanceof ActivityManager)) {
                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = SystemMethodProxy.getRunningAppProcesses((ActivityManager) ActivityManager.class.cast(systemService));
                if (runningAppProcesses != null && !runningAppProcesses.isEmpty()) {
                    for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                        if (runningAppProcessInfo.pid == Process.myPid()) {
                            return runningAppProcessInfo.processName;
                        }
                    }
                    return null;
                }
                AdLog.e(TAG, "getCurrentProcessNameInternal error");
                return null;
            }
            AdLog.e(TAG, "getCurrentProcessNameInternal error");
            return null;
        } catch (Throwable th5) {
            AdLog.e(TAG, "getCurrentProcessNameInternal", th5);
            return null;
        }
    }

    public static AdProcessManager getInstance() {
        if (sInstance == null) {
            synchronized (AdProcessManager.class) {
                if (sInstance == null) {
                    sInstance = new AdProcessManager();
                }
            }
        }
        return sInstance;
    }

    @Nullable
    public String getCurrentProcessName(Context context) {
        if (TextUtils.isEmpty(this.currentProcessName)) {
            synchronized (this) {
                if (TextUtils.isEmpty(this.currentProcessName)) {
                    this.currentProcessName = getCurrentProcessNameInternal(context);
                }
            }
        }
        return this.currentProcessName;
    }

    @Nullable
    public String getMainProcessName() {
        AdProcessManagerAdapter adapter = getAdapter();
        if (adapter != null) {
            return adapter.getMainProcessName();
        }
        return null;
    }

    @Nullable
    public String getWebProcessName() {
        AdProcessManagerAdapter adapter = getAdapter();
        if (adapter != null) {
            return adapter.getWebProcessName();
        }
        return null;
    }

    @Nullable
    public Boolean isOnMainProcess() {
        AdProcessManagerAdapter adapter = getAdapter();
        if (adapter != null) {
            return adapter.isOnMainProcess();
        }
        return null;
    }

    @Nullable
    public Boolean isOnWebProcess() {
        AdProcessManagerAdapter adapter = getAdapter();
        if (adapter != null) {
            return adapter.isOnWebProcess();
        }
        return null;
    }

    @Nullable
    public Boolean isWebProcessRunning() {
        AdProcessManagerAdapter adapter = getAdapter();
        if (adapter != null) {
            return adapter.isWebProcessRunning();
        }
        return null;
    }

    @Nullable
    public Boolean isWebProcessRunningForPreloading() {
        AdProcessManagerAdapter adapter = getAdapter();
        if (adapter != null) {
            return adapter.isWebProcessRunningForPreloading();
        }
        return null;
    }

    public void setAdapter(WeakReference<AdProcessManagerAdapter> weakReference) {
        this.adapter = weakReference;
    }
}
