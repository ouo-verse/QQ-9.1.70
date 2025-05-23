package com.tencent.qqperf.monitor.crash.api.impl;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final List<String> f363180a;

    /* renamed from: b, reason: collision with root package name */
    private static volatile C9709a f363181b;

    /* compiled from: P */
    /* renamed from: com.tencent.qqperf.monitor.crash.api.impl.a$a, reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    static class C9709a extends b {

        /* renamed from: c, reason: collision with root package name */
        WeakReference<Activity> f363182c;

        /* renamed from: d, reason: collision with root package name */
        List<c> f363183d;

        /* renamed from: e, reason: collision with root package name */
        long f363184e;

        C9709a(@NonNull Activity activity, String str) {
            super(activity, str);
            this.f363184e = 0L;
            this.f363182c = new WeakReference<>(activity);
            this.f363183d = new CopyOnWriteArrayList();
            this.f363184e = System.currentTimeMillis();
        }

        synchronized void a(@NonNull Fragment fragment, @NonNull c cVar) {
            if (b(fragment)) {
                this.f363183d.add(cVar);
            } else {
                QLog.w("SaveInstanceStateInfoHelper", 2, "addChildFragmentInfo not compare! " + this.f363185a + "|" + fragment.toString());
            }
        }

        boolean b(@NonNull Fragment fragment) {
            FragmentActivity activity = fragment.getActivity();
            if (activity == null) {
                return false;
            }
            Activity activity2 = this.f363182c.get();
            if (activity2 != null) {
                if (activity != activity2) {
                    return false;
                }
                return true;
            }
            return activity.toString().equalsIgnoreCase(this.f363185a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        String f363185a;

        /* renamed from: b, reason: collision with root package name */
        String f363186b;

        b(Object obj, String str) {
            this.f363185a = obj.toString();
            this.f363186b = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class c extends b {

        /* renamed from: c, reason: collision with root package name */
        WeakReference<Fragment> f363187c;

        c(@NonNull Fragment fragment, String str) {
            super(fragment, str);
            this.f363187c = new WeakReference<>(fragment);
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        f363180a = arrayList;
        f363181b = null;
        arrayList.add(QZoneHelper.QZONE_PRELOAD_FROM_FRIEND_PROFILE);
        arrayList.add("SplashActivity");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(@NonNull Activity activity, @NonNull Bundle bundle) {
        if (!c(activity) || com.tencent.qqperf.tools.a.d(bundle) <= 307200) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b(@NonNull Fragment fragment) {
        if (f363181b == null) {
            return false;
        }
        return f363181b.b(fragment);
    }

    private static boolean c(@NonNull Activity activity) {
        String obj = activity.toString();
        for (String str : f363180a) {
            if (obj.contains(obj)) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public static String d() {
        if (f363181b == null) {
            return null;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("Last large save Activity " + f363181b.f363185a + " at " + ly3.a.f415787b.format(new Date(f363181b.f363184e)) + "\n");
        sb5.append(f363181b.f363186b);
        Iterator<c> it = f363181b.f363183d.iterator();
        while (it.hasNext()) {
            sb5.append("\n " + it.next().f363186b);
        }
        return sb5.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void e(@NonNull Activity activity, @NonNull String str) {
        f363181b = new C9709a(activity, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void f(@NonNull Fragment fragment, @NonNull String str) {
        if (f363181b != null) {
            f363181b.a(fragment, new c(fragment, str));
        }
    }
}
