package com.huawei.hms.api;

import android.app.Activity;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
class BindingFailedResolveMgr {

    /* renamed from: b, reason: collision with root package name */
    static final BindingFailedResolveMgr f36704b = new BindingFailedResolveMgr();

    /* renamed from: c, reason: collision with root package name */
    private static final Object f36705c = new Object();

    /* renamed from: a, reason: collision with root package name */
    List<Activity> f36706a = new ArrayList(1);

    BindingFailedResolveMgr() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Activity activity) {
        synchronized (f36705c) {
            for (Activity activity2 : this.f36706a) {
                if (activity2 != null && activity2 != activity && !activity2.isFinishing()) {
                    activity2.finish();
                }
            }
            this.f36706a.add(activity);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Activity activity) {
        synchronized (f36705c) {
            this.f36706a.remove(activity);
        }
    }
}
