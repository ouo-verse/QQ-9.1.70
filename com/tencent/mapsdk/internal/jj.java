package com.tencent.mapsdk.internal;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class jj extends jm {

    /* renamed from: b, reason: collision with root package name */
    private a f148890b;

    /* renamed from: q, reason: collision with root package name */
    private long f148891q;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface a {
        void a();
    }

    public jj() {
        super(null);
        this.f148891q = -1L;
    }

    @Override // com.tencent.mapsdk.internal.jm
    protected final void a(float f16) {
    }

    @Override // com.tencent.mapsdk.internal.jm
    protected final boolean c(long j3) {
        if (this.f148910j == 0) {
            this.f148910j = 1;
            long j16 = this.f148909i;
            if (j16 < 0) {
                this.f148908h = j3;
            } else {
                this.f148908h = j3 - j16;
                this.f148909i = -1L;
            }
        }
        if (this.f148890b != null) {
            this.f148891q = j3;
            return false;
        }
        return false;
    }

    private void a(a aVar) {
        this.f148890b = aVar;
    }
}
