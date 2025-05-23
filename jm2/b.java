package jm2;

import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public int f410604a;

    /* renamed from: b, reason: collision with root package name */
    public long f410605b;

    /* renamed from: c, reason: collision with root package name */
    public long f410606c;

    /* renamed from: d, reason: collision with root package name */
    public long f410607d;

    public b() {
        this.f410604a = 1;
        this.f410605b = 0L;
        this.f410606c = 5000L;
        this.f410607d = 1000L;
    }

    @NonNull
    public b a() {
        return new b(this);
    }

    public boolean b() {
        if (this.f410604a != 3) {
            return true;
        }
        return false;
    }

    @NonNull
    public String toString() {
        return "ParticleLifecycle{mState=" + this.f410604a + ", mStayTime=" + this.f410605b + ", mDuration=" + this.f410606c + ", mDisappearTime=" + this.f410607d + '}';
    }

    public b(b bVar) {
        this.f410604a = 1;
        this.f410605b = 0L;
        this.f410606c = 5000L;
        this.f410607d = 1000L;
        this.f410604a = bVar.f410604a;
        this.f410607d = bVar.f410607d;
        this.f410606c = bVar.f410606c;
        this.f410605b = bVar.f410605b;
    }
}
