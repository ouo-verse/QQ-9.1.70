package com.hihonor.honorid;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: c, reason: collision with root package name */
    private static a f36251c;

    /* renamed from: a, reason: collision with root package name */
    private Map<String, List<String>> f36252a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private WeakReference<Context> f36253b;

    a() {
        new HashMap();
        new HashMap();
        new HashMap();
        new HashMap();
        this.f36253b = null;
    }

    public static synchronized a c() {
        a aVar;
        synchronized (a.class) {
            if (f36251c == null) {
                f36251c = new a();
            }
            aVar = f36251c;
        }
        return aVar;
    }

    public Context a() {
        WeakReference<Context> weakReference = this.f36253b;
        if (weakReference != null && weakReference.get() != null) {
            return this.f36253b.get();
        }
        return null;
    }

    public void b(Context context) {
        this.f36253b = new WeakReference<>(context);
    }
}
