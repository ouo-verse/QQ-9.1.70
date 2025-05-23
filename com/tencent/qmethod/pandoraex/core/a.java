package com.tencent.qmethod.pandoraex.core;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.tencent.qmethod.pandoraex.monitor.MethodMonitor;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {

    /* renamed from: d, reason: collision with root package name */
    private static String f344014d;

    /* renamed from: a, reason: collision with root package name */
    private static final b f344011a = new b();

    /* renamed from: b, reason: collision with root package name */
    private static final AtomicBoolean f344012b = new AtomicBoolean(false);

    /* renamed from: c, reason: collision with root package name */
    public static final AtomicBoolean f344013c = new AtomicBoolean(false);

    /* renamed from: e, reason: collision with root package name */
    private static final List<com.tencent.qmethod.pandoraex.api.s> f344015e = new LinkedList();

    /* renamed from: f, reason: collision with root package name */
    private static final List<com.tencent.qmethod.pandoraex.api.s> f344016f = new LinkedList();

    /* renamed from: g, reason: collision with root package name */
    private static final Object f344017g = new Object();

    /* renamed from: h, reason: collision with root package name */
    private static final Object f344018h = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.qmethod.pandoraex.core.a$a, reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public class C9338a implements com.tencent.qmethod.pandoraex.api.a {
        C9338a() {
        }

        @Override // com.tencent.qmethod.pandoraex.api.a
        public void a(Activity activity, int i3, int i16, @Nullable Intent intent) {
            a.g(activity, 8);
        }

        @Override // com.tencent.qmethod.pandoraex.api.a
        public void c(Activity activity, Intent intent) {
            a.g(activity, 7);
        }
    }

    public static com.tencent.qmethod.pandoraex.api.s[] b() {
        com.tencent.qmethod.pandoraex.api.s[] sVarArr;
        if (!f344012b.get()) {
            o.a("ActivityMonitor", "getRecentOperatorArray failed, ActivityMonitor has not inited");
            return null;
        }
        synchronized (f344018h) {
            int size = f344016f.size();
            sVarArr = new com.tencent.qmethod.pandoraex.api.s[size];
            for (int i3 = 0; i3 < size; i3++) {
                com.tencent.qmethod.pandoraex.api.s sVar = f344016f.get((size - i3) - 1);
                sVarArr[i3] = new com.tencent.qmethod.pandoraex.api.s(sVar.f343958a, sVar.f343959b, sVar.f343960c);
            }
        }
        return sVarArr;
    }

    public static com.tencent.qmethod.pandoraex.api.s[] c() {
        com.tencent.qmethod.pandoraex.api.s[] sVarArr;
        if (!f344012b.get()) {
            o.a("ActivityMonitor", "getRecentSceneArray failed, ActivityMonitor has not inited");
            return null;
        }
        synchronized (f344017g) {
            int size = f344015e.size();
            sVarArr = new com.tencent.qmethod.pandoraex.api.s[size];
            for (int i3 = 0; i3 < size; i3++) {
                com.tencent.qmethod.pandoraex.api.s sVar = f344015e.get((size - i3) - 1);
                sVarArr[i3] = new com.tencent.qmethod.pandoraex.api.s(sVar.f343958a, sVar.f343960c);
            }
        }
        return sVarArr;
    }

    public static String d() {
        if (!f344012b.get()) {
            o.a("ActivityMonitor", "getTopActivityName failed, ActivityMonitor has not inited");
            return null;
        }
        return f344014d;
    }

    public static void e() {
        Context b16 = com.tencent.qmethod.pandoraex.api.q.b();
        if (b16 != null) {
            if (f344012b.compareAndSet(false, true)) {
                if (f344013c.get()) {
                    np.a.e(f344011a);
                } else {
                    ((Application) b16).registerActivityLifecycleCallbacks(f344011a);
                }
                MethodMonitor.registerImplClass(new C9338a());
                o.a("ActivityMonitor", "ActivityMonitor init success");
                return;
            }
            o.a("ActivityMonitor", "ActivityMonitor has already inited");
            return;
        }
        o.a("ActivityMonitor", "context is null");
    }

    private static void f(String str) {
        if (str.equals(f344014d)) {
            return;
        }
        f344014d = str;
        synchronized (f344017g) {
            com.tencent.qmethod.pandoraex.api.s sVar = new com.tencent.qmethod.pandoraex.api.s(f344014d, System.currentTimeMillis());
            List<com.tencent.qmethod.pandoraex.api.s> list = f344015e;
            list.add(sVar);
            if (list.size() > 3) {
                list.remove(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(Activity activity, int i3) {
        String name = activity.getClass().getName();
        if (i3 < 4) {
            f(name);
        }
        synchronized (f344018h) {
            com.tencent.qmethod.pandoraex.api.s sVar = new com.tencent.qmethod.pandoraex.api.s(f344014d, i3, System.currentTimeMillis());
            List<com.tencent.qmethod.pandoraex.api.s> list = f344016f;
            list.add(sVar);
            if (list.size() > 15) {
                list.remove(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class b implements Application.ActivityLifecycleCallbacks {
        b() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            a.g(activity, 1);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            a.g(activity, 6);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            a.g(activity, 4);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            a.g(activity, 3);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            a.g(activity, 2);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            a.g(activity, 5);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }
    }
}
