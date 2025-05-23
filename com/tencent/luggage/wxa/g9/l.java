package com.tencent.luggage.wxa.g9;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class l implements Runnable, Comparable {

    /* renamed from: d, reason: collision with root package name */
    public static int f126659d = 1000;

    /* renamed from: a, reason: collision with root package name */
    public String f126660a;

    /* renamed from: b, reason: collision with root package name */
    public final int f126661b;

    /* renamed from: c, reason: collision with root package name */
    public long f126662c = System.currentTimeMillis();

    public l(String str, int i3) {
        this.f126660a = str;
        this.f126661b = i3;
    }

    public void a() {
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(l lVar) {
        int abs = (int) (Math.abs(System.currentTimeMillis() - this.f126662c) / f126659d);
        int i3 = this.f126661b;
        if (abs > 0) {
            i3 += abs;
        }
        return lVar.f126661b - i3;
    }
}
