package com.qzone.proxy.feedcomponent.text;

import android.text.TextUtils;
import com.qzone.proxy.feedcomponent.text.TextCellLayout;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes39.dex */
public class m {

    /* renamed from: c, reason: collision with root package name */
    private static m f50759c;

    /* renamed from: d, reason: collision with root package name */
    private static Object f50760d = new Object();

    /* renamed from: a, reason: collision with root package name */
    private SoftReference<ConcurrentHashMap<Integer, SoftReference<ArrayList<TextCell>>>> f50761a;

    /* renamed from: b, reason: collision with root package name */
    private SoftReference<ConcurrentHashMap<a, SoftReference<b>>> f50762b;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public ArrayList<TextCellLayout.g> f50766a;

        /* renamed from: b, reason: collision with root package name */
        public ArrayList<Integer> f50767b;

        /* renamed from: c, reason: collision with root package name */
        public int f50768c;

        public b(ArrayList<TextCellLayout.g> arrayList, ArrayList<Integer> arrayList2, int i3) {
            this.f50766a = (ArrayList) arrayList.clone();
            this.f50767b = (ArrayList) arrayList2.clone();
            this.f50768c = i3;
        }

        public b a() {
            return new b(this.f50766a, this.f50767b, this.f50768c);
        }
    }

    m() {
    }

    private ConcurrentHashMap<a, SoftReference<b>> a() {
        SoftReference<ConcurrentHashMap<a, SoftReference<b>>> softReference = this.f50762b;
        if ((softReference != null ? softReference.get() : null) == null) {
            synchronized (f50760d) {
                SoftReference<ConcurrentHashMap<a, SoftReference<b>>> softReference2 = this.f50762b;
                if (softReference2 == null || softReference2.get() == null) {
                    this.f50762b = new SoftReference<>(new ConcurrentHashMap());
                }
            }
        }
        return this.f50762b.get();
    }

    public static m b() {
        if (f50759c == null) {
            synchronized (f50760d) {
                if (f50759c == null) {
                    f50759c = new m();
                }
            }
        }
        return f50759c;
    }

    private ConcurrentHashMap<Integer, SoftReference<ArrayList<TextCell>>> d() {
        SoftReference<ConcurrentHashMap<Integer, SoftReference<ArrayList<TextCell>>>> softReference = this.f50761a;
        ConcurrentHashMap<Integer, SoftReference<ArrayList<TextCell>>> concurrentHashMap = softReference != null ? softReference.get() : null;
        if (concurrentHashMap != null) {
            return concurrentHashMap;
        }
        ConcurrentHashMap<Integer, SoftReference<ArrayList<TextCell>>> concurrentHashMap2 = new ConcurrentHashMap<>();
        this.f50761a = new SoftReference<>(concurrentHashMap2);
        return concurrentHashMap2;
    }

    public b c(int i3, int i16, String str) {
        a aVar;
        ConcurrentHashMap<a, SoftReference<b>> a16;
        SoftReference<b> softReference;
        if (!TextUtils.isEmpty(str) && (softReference = (a16 = a()).get((aVar = new a(i3, i16, str)))) != null) {
            b bVar = softReference.get();
            if (bVar != null) {
                return bVar.a();
            }
            a16.remove(aVar);
        }
        return null;
    }

    public ArrayList<TextCell> e(int i3) {
        SoftReference<ArrayList<TextCell>> softReference = d().get(Integer.valueOf(i3));
        if (softReference == null) {
            return null;
        }
        ArrayList<TextCell> arrayList = softReference.get();
        if (arrayList == null) {
            d().remove(Integer.valueOf(i3));
        }
        return arrayList;
    }

    public void f(int i3, int i16, String str, b bVar) {
        a().put(new a(i3, i16, str), new SoftReference<>(bVar));
    }

    public synchronized void g(int i3, ArrayList<TextCell> arrayList) {
        d().put(Integer.valueOf(i3), new SoftReference<>(arrayList));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f50763a;

        /* renamed from: b, reason: collision with root package name */
        public int f50764b;

        /* renamed from: c, reason: collision with root package name */
        public String f50765c;

        public a(int i3, int i16, String str) {
            this.f50763a = i3;
            this.f50764b = i16;
            this.f50765c = str;
        }

        public int hashCode() {
            int i3 = this.f50763a + this.f50764b;
            String str = this.f50765c;
            return i3 + (str != null ? str.hashCode() : 0);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f50763a == aVar.f50763a && this.f50764b == aVar.f50764b && this.f50765c.equals(aVar.f50765c);
        }
    }
}
