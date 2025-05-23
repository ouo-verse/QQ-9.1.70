package com.tencent.luggage.wxa.re;

import android.util.SparseArray;
import com.tencent.luggage.wxa.tn.w;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public boolean f139596a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f139597b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f139598c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f139599d;

    /* renamed from: e, reason: collision with root package name */
    public SparseArray f139600e;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public static a f139601a = new a();
    }

    public static a b() {
        return b.f139601a;
    }

    public e a(int i3) {
        WeakReference weakReference;
        if (this.f139600e.indexOfKey(i3) < 0 || (weakReference = (WeakReference) this.f139600e.get(i3)) == null) {
            return null;
        }
        return (e) weakReference.get();
    }

    public void c(boolean z16) {
        this.f139598c = z16;
    }

    public boolean d() {
        if (!this.f139597b) {
            w.d("MicroMsg.AppBrandCameraMrg", "no camera permission");
        }
        return this.f139597b;
    }

    public boolean e() {
        if (!this.f139596a) {
            w.d("MicroMsg.AppBrandCameraMrg", "no external storage permission");
        }
        return this.f139596a;
    }

    public boolean f() {
        return this.f139599d;
    }

    public a() {
        this.f139596a = true;
        this.f139597b = true;
        this.f139598c = true;
        this.f139599d = false;
        this.f139600e = new SparseArray();
    }

    public boolean b(int i3) {
        return a(i3, true);
    }

    public boolean c() {
        if (!this.f139597b || !this.f139598c) {
            w.d("MicroMsg.AppBrandCameraMrg", "no all permission");
        }
        return this.f139597b && this.f139598c;
    }

    public void b(boolean z16) {
        w.d("MicroMsg.AppBrandCameraMrg", "has external storage permission: %b", Boolean.valueOf(z16));
        this.f139596a = z16;
    }

    public void a(int i3, e eVar) {
        this.f139600e.put(i3, new WeakReference(eVar));
    }

    public void d(boolean z16) {
        this.f139599d = z16;
    }

    public boolean a(int i3, boolean z16) {
        if (this.f139600e.indexOfKey(i3) < 0) {
            return false;
        }
        WeakReference weakReference = (WeakReference) this.f139600e.get(i3);
        if (weakReference != null) {
            e eVar = (e) weakReference.get();
            if (eVar != null) {
                eVar.release();
            } else {
                w.d("MicroMsg.AppBrandCameraMrg", "release a recycled camera instance");
            }
        } else {
            w.d("MicroMsg.AppBrandCameraMrg", "release client fail, weak reference not exist");
        }
        if (!z16) {
            return true;
        }
        this.f139600e.remove(i3);
        return true;
    }

    public int[] a() {
        SparseArray sparseArray = this.f139600e;
        if (sparseArray == null || sparseArray.size() == 0) {
            return new int[0];
        }
        int[] iArr = new int[this.f139600e.size()];
        for (int i3 = 0; i3 < this.f139600e.size(); i3++) {
            iArr[i3] = this.f139600e.keyAt(i3);
        }
        return iArr;
    }

    public void a(boolean z16) {
        this.f139597b = z16;
    }
}
