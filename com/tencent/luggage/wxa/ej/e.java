package com.tencent.luggage.wxa.ej;

import android.util.SparseIntArray;
import com.tencent.luggage.wxa.ei.j;
import com.tencent.luggage.wxa.ic.l;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public final l f124913a;

    /* renamed from: b, reason: collision with root package name */
    public final b f124914b;

    /* renamed from: c, reason: collision with root package name */
    public final SparseIntArray f124915c = new SparseIntArray();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum a {
        Service,
        Worker
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface b {
        a a();

        void a(int i3, Map map);

        j getJsRuntime();
    }

    public e(b bVar, l lVar) {
        this.f124914b = bVar;
        this.f124913a = lVar;
    }

    public abstract int a();

    public void a(int i3) {
        boolean z16;
        synchronized (this) {
            z16 = !(this.f124915c.size() <= 0);
            this.f124915c.put(i3, 1);
        }
        if (z16) {
            return;
        }
        c();
    }

    public abstract void b();

    public void b(int i3) {
        boolean z16;
        synchronized (this) {
            int indexOfKey = this.f124915c.indexOfKey(i3);
            if (indexOfKey >= 0) {
                this.f124915c.removeAt(indexOfKey);
            }
            if (this.f124915c.size() <= 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                return;
            }
            b();
        }
    }

    public abstract void c();

    public void a(Map map) {
        int size;
        int[] iArr;
        int i3;
        synchronized (this) {
            size = this.f124915c.size();
            iArr = new int[size];
            for (int i16 = 0; i16 < this.f124915c.size(); i16++) {
                iArr[i16] = this.f124915c.keyAt(i16);
            }
        }
        for (i3 = 0; i3 < size; i3++) {
            this.f124914b.a(iArr[i3], map);
        }
    }
}
