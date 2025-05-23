package com.tencent.beacon.c.a;

import android.app.Activity;
import android.app.Application;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.SparseArray;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.beacon.a.d.a;
import com.tencent.beacon.module.StatModule;
import com.tencent.bugly.common.constants.Constants;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public class c implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a, reason: collision with root package name */
    private static SparseArray<WeakReference<Activity>> f77796a = new SparseArray<>();

    /* renamed from: b, reason: collision with root package name */
    private boolean f77797b = false;

    /* renamed from: c, reason: collision with root package name */
    private long f77798c = 0;

    /* renamed from: d, reason: collision with root package name */
    private long f77799d = 0;

    /* renamed from: e, reason: collision with root package name */
    private long f77800e = 20000;

    /* renamed from: f, reason: collision with root package name */
    private String f77801f = "";

    /* renamed from: g, reason: collision with root package name */
    private Map<String, String> f77802g;

    /* renamed from: h, reason: collision with root package name */
    private StatModule f77803h;

    public c(StatModule statModule) {
        this.f77803h = statModule;
        HashMap hashMap = new HashMap(6);
        this.f77802g = hashMap;
        hashMap.put(Constants.HAS_HOOK_FRAME, "N");
        this.f77802g.put("A66", UserInfo.SEX_FEMALE);
    }

    private void c() {
        com.tencent.beacon.a.b.a.a().a(new a(this));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        a(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        a(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        a(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        a(activity);
        a(true, activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        a(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        a(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        a(activity);
        a(false, activity);
    }

    private void a(boolean z16, Activity activity) {
        if (z16) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.f77798c > 0) {
                long j3 = this.f77799d;
                if (j3 > 0 && j3 + a() <= currentTimeMillis) {
                    com.tencent.beacon.base.util.c.a("[lifecycle] -> return foreground more than 20s.", new Object[0]);
                    c();
                    StatModule statModule = this.f77803h;
                    if (statModule != null) {
                        statModule.a();
                    }
                }
            }
            this.f77798c = currentTimeMillis;
            this.f77799d = 0L;
            return;
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        this.f77799d = currentTimeMillis2;
        long j16 = this.f77798c;
        if (800 + j16 > currentTimeMillis2) {
            com.tencent.beacon.base.util.c.a("[lifecycle] -> debounce activity switch.", new Object[0]);
            this.f77798c = 0L;
            return;
        }
        if (j16 == 0) {
            this.f77798c = currentTimeMillis2;
        }
        StatModule statModule2 = this.f77803h;
        if (statModule2 != null) {
            statModule2.b();
        }
    }

    private static void b(Activity activity) {
        if (activity == null || f77796a == null) {
            return;
        }
        int hashCode = activity.hashCode();
        if (f77796a.get(hashCode) == null) {
            f77796a.put(hashCode, new WeakReference<>(activity));
        }
    }

    private boolean b() {
        String d16 = com.tencent.beacon.base.util.b.d();
        if ("".equals(this.f77801f)) {
            this.f77801f = com.tencent.beacon.a.d.a.a().getString("LAUEVE_DENGTA", "");
        }
        boolean z16 = false;
        if (!d16.equals(this.f77801f)) {
            a.SharedPreferencesEditorC0784a edit = com.tencent.beacon.a.d.a.a().edit();
            if (com.tencent.beacon.base.util.b.a((SharedPreferences.Editor) edit)) {
                edit.putString("LAUEVE_DENGTA", d16);
            }
            if (!"".equals(this.f77801f)) {
                com.tencent.beacon.base.util.c.a("[core] -> report new day launcher event.", new Object[0]);
                z16 = true;
            }
            this.f77801f = d16;
        }
        return z16;
    }

    private void a(Activity activity) {
        com.tencent.beacon.a.c.b.f77633d = true;
        b(activity);
        if (!this.f77797b) {
            com.tencent.beacon.base.util.c.a("[event] lifecycle callback recover active user.", new Object[0]);
            com.tencent.beacon.a.b.a.a().a(new b(this, activity));
            this.f77797b = true;
        }
        if (b()) {
            c();
        }
    }

    private long a() {
        if (this.f77800e <= 20000) {
            String a16 = com.tencent.beacon.d.a.a().a("hotLauncher");
            if (a16 != null) {
                try {
                    this.f77800e = Long.valueOf(a16).longValue();
                    com.tencent.beacon.base.util.c.a("[strategy] -> change launcher time: %s ms", a16);
                } catch (NumberFormatException unused) {
                    com.tencent.beacon.base.util.c.b("[strategy] -> event param 'hotLauncher' error.", new Object[0]);
                }
            }
            this.f77800e++;
        }
        return this.f77800e;
    }
}
