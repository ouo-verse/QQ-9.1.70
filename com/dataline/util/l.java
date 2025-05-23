package com.dataline.util;

import android.widget.BaseAdapter;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class l extends BaseAdapter {

    /* renamed from: d, reason: collision with root package name */
    long f32465d = 0;

    /* renamed from: e, reason: collision with root package name */
    private Map<Long, Long> f32466e = new HashMap();

    public abstract long a(int i3);

    public abstract long b(int i3);

    public abstract int c();

    public boolean d(long j3) {
        return this.f32466e.containsKey(Long.valueOf(j3));
    }

    public void e() {
        this.f32465d = 0L;
        this.f32466e.clear();
        int c16 = c();
        if (c16 > 0) {
            for (int i3 = 0; i3 < c16; i3++) {
                long b16 = b(i3);
                if (b16 > this.f32465d + 180) {
                    this.f32465d = b16;
                    this.f32466e.put(Long.valueOf(a(i3)), Long.valueOf(this.f32465d));
                }
            }
        }
    }

    public void f() {
        int c16 = c();
        if (c16 == 0) {
            return;
        }
        int i3 = c16 - 1;
        long b16 = b(i3);
        if (b16 > this.f32465d + 180) {
            this.f32465d = b16;
            this.f32466e.put(Long.valueOf(a(i3)), Long.valueOf(this.f32465d));
        }
    }
}
