package com.tencent.mobileqq.guild.window;

import android.app.Activity;
import java.util.HashMap;
import java.util.Map;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes7.dex */
public class o {

    /* renamed from: b, reason: collision with root package name */
    private static o f236711b = new o();

    /* renamed from: a, reason: collision with root package name */
    private Map<String, WeakReference<Activity>> f236712a = new HashMap();

    o() {
    }

    public static o a() {
        return f236711b;
    }

    public Activity b(String str) {
        if (this.f236712a.get(str) != null) {
            return this.f236712a.get(str).get();
        }
        return null;
    }

    public void c(String str, Activity activity) {
        this.f236712a.put(str, new WeakReference<>(activity));
    }
}
