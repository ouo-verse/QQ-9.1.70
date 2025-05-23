package com.huawei.hms.availableupdate;

import android.app.Activity;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: c, reason: collision with root package name */
    public static final a f36755c = new a();

    /* renamed from: d, reason: collision with root package name */
    private static final Object f36756d = new Object();

    /* renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f36757a = new AtomicBoolean(false);

    /* renamed from: b, reason: collision with root package name */
    private final List<Activity> f36758b = new ArrayList(1);

    public void a(Activity activity) {
        synchronized (f36756d) {
            for (Activity activity2 : this.f36758b) {
                if (activity2 != null && activity2 != activity && !activity2.isFinishing()) {
                    activity2.finish();
                }
            }
            this.f36758b.add(activity);
        }
    }

    public void b(Activity activity) {
        synchronized (f36756d) {
            this.f36758b.remove(activity);
        }
    }

    public void a(boolean z16) {
        this.f36757a.set(z16);
    }

    public AtomicBoolean a() {
        return this.f36757a;
    }
}
