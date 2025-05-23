package com.huawei.hms.adapter.sysobs;

import android.os.Handler;
import android.os.Looper;
import com.huawei.hms.support.log.HMSLog;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ApkResolutionFailedManager {

    /* renamed from: c, reason: collision with root package name */
    private static final ApkResolutionFailedManager f36680c = new ApkResolutionFailedManager();

    /* renamed from: a, reason: collision with root package name */
    private final Handler f36681a = new Handler(Looper.getMainLooper());

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, Runnable> f36682b = new HashMap(2);

    ApkResolutionFailedManager() {
    }

    public static ApkResolutionFailedManager getInstance() {
        return f36680c;
    }

    public void postTask(String str, Runnable runnable) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HMSLog.e("ApkResolutionFailedManager", "postTask is not in main thread");
        } else {
            this.f36682b.put(str, runnable);
            this.f36681a.postDelayed(runnable, 2000L);
        }
    }

    public void removeTask(String str) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HMSLog.e("ApkResolutionFailedManager", "removeTask is not in main thread");
            return;
        }
        Runnable remove = this.f36682b.remove(str);
        if (remove == null) {
            HMSLog.e("ApkResolutionFailedManager", "cancel runnable is null");
        } else {
            this.f36681a.removeCallbacks(remove);
        }
    }

    public void removeValueOnly(String str) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HMSLog.e("ApkResolutionFailedManager", "removeValueOnly is not in main thread");
        } else {
            this.f36682b.remove(str);
        }
    }
}
