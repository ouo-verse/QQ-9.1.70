package com.qq.e.comm.plugin.tangramsplash.d;

import android.text.TextUtils;
import com.qq.e.comm.util.GDTLogger;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private volatile long f39874a = 0;

    /* renamed from: c, reason: collision with root package name */
    private final Object f39876c = new Object();

    /* renamed from: b, reason: collision with root package name */
    private ConcurrentHashMap<String, Long> f39875b = new ConcurrentHashMap<>();

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            GDTLogger.e("Splash record fail because of invalid flag");
        } else {
            this.f39875b.put(str, Long.valueOf(System.currentTimeMillis()));
        }
    }

    public long b(String str) {
        synchronized (this.f39876c) {
            if (this.f39875b.containsKey(str) && this.f39875b.get(str) != null) {
                return System.currentTimeMillis() - this.f39875b.get(str).longValue();
            }
            GDTLogger.e("compute cost time fail because of invalid flag");
            return -1L;
        }
    }

    public void c(String str) {
        synchronized (this.f39876c) {
            this.f39875b.remove(str);
        }
    }

    public void a() {
        synchronized (this.f39876c) {
            this.f39875b.clear();
        }
    }
}
