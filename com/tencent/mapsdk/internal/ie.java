package com.tencent.mapsdk.internal;

import android.os.SystemClock;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class ie {

    /* renamed from: a, reason: collision with root package name */
    public static final long f148774a = -1;

    /* renamed from: b, reason: collision with root package name */
    public static final int f148775b = 0;

    /* renamed from: c, reason: collision with root package name */
    public static final int f148776c = 1;

    /* renamed from: d, reason: collision with root package name */
    public static final int f148777d = 2;

    /* renamed from: e, reason: collision with root package name */
    protected long f148778e;

    /* renamed from: h, reason: collision with root package name */
    private boolean f148781h;

    /* renamed from: i, reason: collision with root package name */
    private long f148782i;

    /* renamed from: g, reason: collision with root package name */
    private long f148780g = -1;

    /* renamed from: f, reason: collision with root package name */
    protected int f148779f = 0;

    public ie(long j3) {
        this.f148778e = j3;
    }

    private void a(long j3) {
        this.f148782i = j3;
    }

    private void e() {
        this.f148779f = 2;
    }

    private boolean f() {
        if (this.f148779f == 1) {
            return true;
        }
        return false;
    }

    protected abstract void a(GL10 gl10, long j3);

    public void b() {
        this.f148779f = 1;
        this.f148780g = -1L;
    }

    public boolean c() {
        if (this.f148779f == 2) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d() {
        this.f148779f = 1;
        this.f148780g = -1L;
    }

    private void a(boolean z16) {
        this.f148781h = z16;
    }

    public final long a() {
        return this.f148778e;
    }

    public void a(GL10 gl10) {
        if (this.f148779f != 1) {
            return;
        }
        if (this.f148780g == -1) {
            this.f148780g = SystemClock.elapsedRealtime();
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.f148780g;
        long j3 = this.f148782i;
        if (j3 - elapsedRealtime > 0) {
            return;
        }
        long j16 = elapsedRealtime - j3;
        if (j16 >= this.f148778e) {
            if (this.f148781h) {
                d();
            }
            this.f148779f = 2;
        }
        a(gl10, j16);
    }
}
