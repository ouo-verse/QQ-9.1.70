package com.tencent.gdtad.basics.flip;

import com.tencent.gdtad.basics.adshake.RotationSensor;

/* compiled from: P */
/* loaded from: classes6.dex */
public class b implements RotationSensor.OnRotationChangeListener {
    private boolean D;
    private a E;

    /* renamed from: d, reason: collision with root package name */
    private float f108782d = 0.0f;

    /* renamed from: e, reason: collision with root package name */
    private float f108783e = 0.0f;

    /* renamed from: f, reason: collision with root package name */
    private boolean f108784f = true;

    /* renamed from: h, reason: collision with root package name */
    private float f108785h = 0.0f;

    /* renamed from: i, reason: collision with root package name */
    private boolean f108786i = false;

    /* renamed from: m, reason: collision with root package name */
    private boolean f108787m = false;
    private boolean C = false;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface a {
        void onError();

        void onFlipBackInteractProgress(float f16, float f17);

        void onFlipBackInteractStart();

        void onFlipInteractFinish(boolean z16, boolean z17);

        void onFlipInteractProgress(float f16, float f17);

        void onFlipInteractStart();

        void onRotationChanged(float f16, boolean z16);
    }

    private void a(boolean z16, boolean z17) {
        if (this.C) {
            return;
        }
        this.C = true;
        a aVar = this.E;
        if (aVar != null) {
            aVar.onFlipInteractFinish(z16, z17);
        }
    }

    public void b(float f16) {
        this.f108783e = f16;
    }

    public void c(a aVar) {
        this.E = aVar;
    }

    public void d(float f16) {
        this.f108782d = f16;
    }

    @Override // com.tencent.gdtad.basics.adshake.RotationSensor.OnRotationChangeListener
    public void onChanged(float f16, float f17, float f18) {
        float f19;
        float f26;
        boolean z16;
        boolean z17;
        if (!this.f108784f) {
            return;
        }
        float abs = Math.abs(f17);
        if (abs > this.f108785h) {
            this.f108785h = abs;
        }
        a aVar = this.E;
        if (aVar != null) {
            aVar.onRotationChanged(f17, this.f108787m);
        }
        if (abs > 5.0f || this.f108786i) {
            if (!this.f108786i) {
                this.f108786i = true;
                a aVar2 = this.E;
                if (aVar2 != null) {
                    aVar2.onFlipInteractStart();
                }
            }
            if (!this.f108787m && this.E != null) {
                this.E.onFlipInteractProgress(f17, Math.max(Math.min(f17 / this.f108782d, 1.0f), -1.0f));
            }
        }
        boolean z18 = false;
        if (abs >= this.f108782d && !this.C) {
            if (this.f108783e <= 0.0f) {
                if (f17 < 0.0f) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                a(true, z17);
            } else if (!this.f108787m) {
                this.f108787m = true;
                if (f17 < 0.0f) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                this.D = z16;
                a aVar3 = this.E;
                if (aVar3 != null) {
                    aVar3.onFlipBackInteractStart();
                }
            }
        }
        if (this.f108787m) {
            float f27 = this.f108783e;
            if (f27 > 0.0f && !this.C) {
                boolean z19 = this.D;
                if (z19) {
                    f19 = this.f108785h + f17;
                } else {
                    f19 = this.f108785h - f17;
                }
                if (z19) {
                    f26 = f19 - f27;
                } else {
                    f26 = f27 - f19;
                }
                float f28 = f26 / f27;
                if (f19 >= f27) {
                    z18 = true;
                }
                if (z18) {
                    a aVar4 = this.E;
                    if (aVar4 != null) {
                        aVar4.onFlipBackInteractProgress(f17, 0.0f);
                    }
                    a(true, !this.D);
                    return;
                }
                a aVar5 = this.E;
                if (aVar5 != null) {
                    aVar5.onFlipBackInteractProgress(f17, f28);
                }
            }
        }
    }

    @Override // com.tencent.gdtad.basics.adshake.RotationSensor.OnRotationChangeListener
    public void onError() {
        a aVar = this.E;
        if (aVar != null) {
            aVar.onError();
        }
    }
}
