package com.sina.weibo.sdk.auth;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: i, reason: collision with root package name */
    private Map<String, WbAuthListener> f61227i;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private static class a {

        /* renamed from: j, reason: collision with root package name */
        private static final b f61228j = new b(0);
    }

    /* synthetic */ b(byte b16) {
        this();
    }

    public static synchronized b f() {
        b bVar;
        synchronized (b.class) {
            bVar = a.f61228j;
        }
        return bVar;
    }

    public final synchronized void a(String str, WbAuthListener wbAuthListener) {
        if (!TextUtils.isEmpty(str) && wbAuthListener != null) {
            this.f61227i.put(str, wbAuthListener);
        }
    }

    public final synchronized void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f61227i.remove(str);
    }

    b() {
        this.f61227i = new HashMap();
    }

    public final synchronized WbAuthListener a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f61227i.get(str);
    }
}
