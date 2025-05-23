package com.tencent.luggage.wxa.l4;

import android.os.SystemClock;
import com.tencent.luggage.wxa.oe.i;
import com.tencent.luggage.wxa.tn.w;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a implements i {

    /* renamed from: a, reason: collision with root package name */
    public static final a f133011a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final ArrayList f133012b = new ArrayList(5);

    /* renamed from: c, reason: collision with root package name */
    public static final HashMap f133013c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public static int f133014d;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.l4.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6418a {

        /* renamed from: a, reason: collision with root package name */
        public final int f133015a;

        /* renamed from: b, reason: collision with root package name */
        public final long f133016b;

        public C6418a(int i3, long j3) {
            this.f133015a = i3;
            this.f133016b = j3;
        }

        public final long a() {
            return this.f133016b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C6418a)) {
                return false;
            }
            C6418a c6418a = (C6418a) obj;
            if (this.f133015a == c6418a.f133015a && this.f133016b == c6418a.f133016b) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.f133015a * 31) + androidx.fragment.app.a.a(this.f133016b);
        }

        public String toString() {
            return "LastScan(id=" + this.f133015a + ", timeStamp=" + this.f133016b + ')';
        }
    }

    @Override // com.tencent.luggage.wxa.oe.i
    public synchronized int U() {
        int i3;
        w.d("MicroMsg.AppBrand.LuggageBLEScanStats", "recordScanStart");
        i3 = f133014d;
        f133014d = i3 + 1;
        f133013c.put(Integer.valueOf(i3), new C6418a(i3, SystemClock.elapsedRealtime()));
        return i3;
    }

    @Override // com.tencent.luggage.wxa.oe.i
    public synchronized boolean X() {
        ArrayList arrayList = f133012b;
        boolean z16 = false;
        if (arrayList.size() < 5) {
            return false;
        }
        if (SystemClock.elapsedRealtime() - ((C6418a) arrayList.get(0)).a() < 30000) {
            z16 = true;
        }
        return z16;
    }

    @Override // com.tencent.luggage.wxa.oe.i
    public synchronized void c(int i3) {
        w.d("MicroMsg.AppBrand.LuggageBLEScanStats", "recordScanStop, id: " + i3);
        C6418a c6418a = (C6418a) f133013c.remove(Integer.valueOf(i3));
        if (c6418a == null) {
            w.f("MicroMsg.AppBrand.LuggageBLEScanStats", "recordScanStop, scan is null");
            return;
        }
        ArrayList arrayList = f133012b;
        if (arrayList.size() >= 5) {
            arrayList.remove(0);
        }
        arrayList.add(c6418a);
    }
}
