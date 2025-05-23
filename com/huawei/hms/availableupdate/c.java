package com.huawei.hms.availableupdate;

import android.app.Activity;
import com.huawei.hms.support.log.HMSLog;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes2.dex */
public class c {

    /* renamed from: b, reason: collision with root package name */
    public static final c f36762b = new c();

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<Activity> f36763a;

    public boolean a(Activity activity) {
        HMSLog.i("UpdateAdapterMgr", "onActivityCreate");
        Activity a16 = a();
        if (a16 != null && !a16.isFinishing()) {
            activity.finish();
            HMSLog.i("UpdateAdapterMgr", "finish one");
            return false;
        }
        this.f36763a = new WeakReference<>(activity);
        return true;
    }

    public void b(Activity activity) {
        HMSLog.i("UpdateAdapterMgr", "onActivityDestroy");
        Activity a16 = a();
        if (activity != null && activity.equals(a16)) {
            HMSLog.i("UpdateAdapterMgr", "reset");
            this.f36763a = null;
        }
    }

    private Activity a() {
        WeakReference<Activity> weakReference = this.f36763a;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }
}
