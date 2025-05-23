package c.t.m.g;

import android.os.Looper;

/* compiled from: P */
/* loaded from: classes.dex */
public abstract class i0 extends i1 {

    /* renamed from: a, reason: collision with root package name */
    public volatile boolean f29760a = false;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f29761b = new byte[0];

    public abstract int a(Looper looper);

    public abstract String a();

    public boolean b() {
        boolean z16;
        synchronized (this.f29761b) {
            z16 = this.f29760a;
        }
        return z16;
    }

    public abstract void c();
}
