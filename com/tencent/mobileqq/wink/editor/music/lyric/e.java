package com.tencent.mobileqq.wink.editor.music.lyric;

/* compiled from: P */
/* loaded from: classes21.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private long f320875a;

    /* renamed from: b, reason: collision with root package name */
    private long f320876b;

    /* renamed from: c, reason: collision with root package name */
    private long f320877c;

    /* renamed from: d, reason: collision with root package name */
    private long f320878d;

    /* renamed from: e, reason: collision with root package name */
    private long f320879e;

    /* compiled from: P */
    /* loaded from: classes21.dex */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        static final e f320880a = new e();
    }

    e() {
    }

    public static e a() {
        return a.f320880a;
    }

    public long b(long j3, boolean z16) {
        long j16;
        this.f320875a = j3;
        long j17 = this.f320879e;
        if (j17 >= this.f320876b) {
            j16 = this.f320877c;
        } else {
            if (z16) {
                return this.f320877c + (j3 % j17);
            }
            j16 = this.f320877c;
        }
        return j16 + j3;
    }

    public long c(boolean z16) {
        return b(this.f320875a, z16);
    }

    public void d(long j3, long j16) {
        this.f320877c = j3;
        this.f320878d = j16;
        this.f320879e = j16 - j3;
    }

    public void e(long j3, long j16) {
        this.f320875a = j3;
        this.f320876b = j16;
    }
}
