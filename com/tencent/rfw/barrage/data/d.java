package com.tencent.rfw.barrage.data;

import tz3.e;
import tz3.i;
import wz3.g;

/* compiled from: P */
/* loaded from: classes25.dex */
public abstract class d<DATA, CONFIG extends e> extends a<DATA, CONFIG> {
    private float G;
    private float H;
    private float[] I;
    private float J;

    public d(i iVar) {
        super(iVar);
        this.G = 0.0f;
        this.H = -1.0f;
        this.I = null;
    }

    @Override // com.tencent.rfw.barrage.data.a
    public float[] A(long j3) {
        if (!U()) {
            return null;
        }
        float C0 = C0(j3);
        if (this.I == null) {
            this.I = new float[4];
        }
        float[] fArr = this.I;
        fArr[0] = C0;
        float f16 = this.H;
        fArr[1] = f16;
        fArr[2] = C0 + this.f365068i;
        fArr[3] = f16 + this.f365069j;
        return fArr;
    }

    @Override // com.tencent.rfw.barrage.data.a
    public long B(float f16) {
        return (f16 + this.f365068i) / this.J;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float C0(long j3) {
        return F() - (((float) (j3 - this.f365062c)) * this.J);
    }

    @Override // com.tencent.rfw.barrage.data.a
    public float D() {
        return this.G + this.f365068i;
    }

    public void D0(float f16) {
        this.G = f16;
    }

    public void E0(float f16) {
        this.J = f16;
    }

    public void F0(float f16) {
        this.H = f16;
    }

    @Override // com.tencent.rfw.barrage.data.a
    public float G() {
        return -this.J;
    }

    @Override // com.tencent.rfw.barrage.data.a
    public float I() {
        return this.H;
    }

    @Override // com.tencent.rfw.barrage.data.a
    public void b() {
        super.b();
        int F = (int) (F() + this.f365068i);
        if (g.b()) {
            wz3.b.i("RFWBaseBarrage", "[afterMeasure] mDuration.value(): ", Long.valueOf(this.f365063d.d()));
        }
        this.J = F / ((float) this.f365063d.d());
    }

    @Override // com.tencent.rfw.barrage.data.a
    public void c0(float f16, float f17, long j3, long j16) {
        if (N()) {
            return;
        }
        if (!Y(j3)) {
            this.G = C0(j16);
            if (!X()) {
                this.H = f17;
                B0(true);
                return;
            }
            return;
        }
        B0(false);
    }

    @Override // com.tencent.rfw.barrage.data.a
    public void d0(long j3) {
        if (N()) {
            return;
        }
        this.G = C0(j3);
    }

    @Override // com.tencent.rfw.barrage.data.a
    public float g() {
        return this.H + this.f365069j;
    }

    @Override // com.tencent.rfw.barrage.data.a
    public float[] h(long j3) {
        if (!U()) {
            return null;
        }
        float C0 = C0(j3);
        if (this.I == null) {
            this.I = new float[4];
        }
        this.I[0] = C0 - i.l().b();
        float[] fArr = this.I;
        float f16 = this.H;
        fArr[1] = f16;
        fArr[2] = C0 + this.f365068i + this.f365070k;
        fArr[3] = f16 + this.f365069j;
        return fArr;
    }

    @Override // com.tencent.rfw.barrage.data.a
    public float t() {
        return this.G;
    }
}
