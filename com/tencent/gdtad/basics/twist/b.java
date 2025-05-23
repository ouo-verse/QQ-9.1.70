package com.tencent.gdtad.basics.twist;

import com.tencent.gdtad.basics.adshake.RotationSensor;

/* compiled from: P */
/* loaded from: classes6.dex */
public class b implements RotationSensor.OnRotationChangeListener {
    private a E;
    private boolean F;

    /* renamed from: d, reason: collision with root package name */
    private boolean f109136d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f109137e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f109138f;

    /* renamed from: m, reason: collision with root package name */
    private int f109141m;

    /* renamed from: h, reason: collision with root package name */
    private float f109139h = 0.0f;

    /* renamed from: i, reason: collision with root package name */
    private float f109140i = 0.0f;
    private int C = 0;
    private float D = 90.0f;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface a {
        void onBackInteractProgress(float f16, int i3);

        void onInteractProgress(float f16, int i3);

        void onInteractStart();

        void onInteractSuccess();
    }

    public b(a aVar) {
        this.E = aVar;
    }

    private void a() {
        a aVar = this.E;
        if (aVar != null) {
            aVar.onInteractSuccess();
            this.F = true;
        }
    }

    private void b(float f16, float f17) {
        boolean z16;
        float e16;
        a aVar;
        int i3 = 0;
        if (Math.abs(f16) >= 5.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 && !this.f109138f) {
            return;
        }
        if (z16 && !this.f109138f) {
            a aVar2 = this.E;
            if (aVar2 != null) {
                aVar2.onInteractStart();
            }
            this.f109138f = true;
        }
        this.f109139h = Math.max(this.f109139h, Math.abs(f17));
        float f18 = this.D;
        if (f16 > f18) {
            f16 = f18;
        } else if (f16 < (-f18)) {
            f16 = -f18;
        }
        int abs = (int) ((Math.abs(f16) * 100.0f) / this.D);
        if (!this.f109136d && (aVar = this.E) != null) {
            aVar.onInteractProgress(f16, abs);
        }
        if (abs == 100 && !this.F) {
            if (this.f109140i == 0.0f) {
                a();
                return;
            } else if (!this.f109136d) {
                this.f109136d = true;
                if (f17 > 0.0f) {
                    i3 = 1;
                }
                this.f109141m = i3;
            }
        }
        if (this.f109136d && this.f109140i > 0.0f && !this.F) {
            int d16 = d(f17);
            if (this.f109141m == 0) {
                e16 = e(f17) - this.f109140i;
            } else {
                e16 = this.f109140i - e(f17);
            }
            a aVar3 = this.E;
            if (aVar3 != null) {
                aVar3.onBackInteractProgress(e16, 100 - d16);
            }
            if (d16 >= 100) {
                a();
            }
        }
    }

    private boolean c(float f16) {
        if (this.f109136d) {
            return true;
        }
        if (f16 != 0.0f) {
            this.f109137e = false;
            return true;
        }
        if (this.f109137e) {
            return false;
        }
        this.f109137e = true;
        return true;
    }

    private int d(float f16) {
        float f17 = this.f109140i;
        if (f17 == 0.0f) {
            return 0;
        }
        return (int) ((Math.abs(e(f16)) * 100) / f17);
    }

    private int e(float f16) {
        float f17;
        float min;
        if (this.f109141m == 0) {
            f17 = -this.f109139h;
            min = Math.max(f16, f17);
        } else {
            f17 = this.f109139h;
            min = Math.min(f16, f17);
        }
        return (int) (f17 - min);
    }

    public void f(int i3) {
        this.C = i3;
    }

    public void g(float f16) {
        this.f109140i = f16;
    }

    public void h(float f16) {
        this.D = f16;
    }

    @Override // com.tencent.gdtad.basics.adshake.RotationSensor.OnRotationChangeListener
    public void onChanged(float f16, float f17, float f18) {
        int i3 = this.C;
        if (i3 == 1) {
            float max = Math.max(f18, 0.0f);
            if (c(max)) {
                b(max, f18);
                return;
            }
            return;
        }
        if (i3 == 0) {
            float min = Math.min(f18, 0.0f);
            if (c(min)) {
                b(min, f18);
                return;
            }
            return;
        }
        if (i3 == 2) {
            b(f18, f18);
        }
    }

    @Override // com.tencent.gdtad.basics.adshake.RotationSensor.OnRotationChangeListener
    public void onError() {
    }
}
