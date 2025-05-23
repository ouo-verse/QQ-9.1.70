package com.tencent.bugly.proguard;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class bc implements Comparable<bc> {

    /* renamed from: a, reason: collision with root package name */
    public long f98188a = -1;

    /* renamed from: b, reason: collision with root package name */
    public long f98189b = -1;

    /* renamed from: c, reason: collision with root package name */
    public String f98190c = null;

    /* renamed from: d, reason: collision with root package name */
    public boolean f98191d = false;

    /* renamed from: e, reason: collision with root package name */
    public boolean f98192e = false;

    /* renamed from: f, reason: collision with root package name */
    public int f98193f = 0;

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(bc bcVar) {
        bc bcVar2 = bcVar;
        if (bcVar2 != null) {
            long j3 = this.f98189b - bcVar2.f98189b;
            if (j3 <= 0) {
                if (j3 < 0) {
                    return -1;
                }
                return 0;
            }
            return 1;
        }
        return 1;
    }
}
