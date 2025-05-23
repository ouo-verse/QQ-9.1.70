package com.huawei.hms.availableupdate;

import android.app.Activity;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    public static final b f36759b = new b();

    /* renamed from: c, reason: collision with root package name */
    private static final Object f36760c = new Object();

    /* renamed from: a, reason: collision with root package name */
    private final List<Activity> f36761a = new ArrayList(1);

    public void a(Activity activity) {
        synchronized (f36760c) {
            for (Activity activity2 : this.f36761a) {
                if (activity2 != null && activity2 != activity && !activity2.isFinishing()) {
                    activity2.finish();
                }
            }
            this.f36761a.add(activity);
        }
    }

    public void b(Activity activity) {
        synchronized (f36760c) {
            this.f36761a.remove(activity);
        }
    }
}
