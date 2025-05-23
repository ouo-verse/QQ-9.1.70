package com.tencent.common.danmaku.data;

import com.tencent.common.danmaku.inject.h;
import com.tencent.common.danmaku.util.e;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class d<DATA, CONFIG extends h> extends a<DATA, CONFIG> {
    static IPatchRedirector $redirector_;
    private float D;
    private float E;
    private float[] F;
    private float G;

    public d(com.tencent.common.danmaku.inject.b bVar) {
        super(bVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar);
            return;
        }
        this.D = 0.0f;
        this.E = -1.0f;
        this.F = null;
    }

    @Override // com.tencent.common.danmaku.data.a
    public float[] B(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (float[]) iPatchRedirector.redirect((short) 13, (Object) this, j3);
        }
        if (!S()) {
            return null;
        }
        float x06 = x0(j3);
        if (this.F == null) {
            this.F = new float[4];
        }
        float[] fArr = this.F;
        fArr[0] = x06;
        float f16 = this.E;
        fArr[1] = f16;
        fArr[2] = x06 + this.f99672i;
        fArr[3] = f16 + this.f99673j;
        return fArr;
    }

    @Override // com.tencent.common.danmaku.data.a
    public float D() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Float) iPatchRedirector.redirect((short) 18, (Object) this)).floatValue();
        }
        return this.D + this.f99672i;
    }

    @Override // com.tencent.common.danmaku.data.a
    public float G() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Float) iPatchRedirector.redirect((short) 3, (Object) this)).floatValue();
        }
        return -this.G;
    }

    @Override // com.tencent.common.danmaku.data.a
    public float I() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Float) iPatchRedirector.redirect((short) 16, (Object) this)).floatValue();
        }
        return this.E;
    }

    @Override // com.tencent.common.danmaku.data.a
    public void Z(float f16, float f17, long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Float.valueOf(f16), Float.valueOf(f17), Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        if (!W(j3)) {
            e.e("BaseDanmaku", "onLayout, Y = " + f17 + ", danmaku = ", this);
            this.D = x0(j16);
            if (!V()) {
                this.E = f17;
                w0(true);
                return;
            }
            return;
        }
        w0(false);
    }

    @Override // com.tencent.common.danmaku.data.a
    public void a0(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, j3);
        } else {
            this.D = x0(j3);
        }
    }

    @Override // com.tencent.common.danmaku.data.a
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            super.b();
            this.G = ((int) (F() + this.f99672i)) / ((float) this.f99667d.c());
        }
    }

    @Override // com.tencent.common.danmaku.data.a
    public float g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Float) iPatchRedirector.redirect((short) 19, (Object) this)).floatValue();
        }
        return this.E + this.f99673j;
    }

    @Override // com.tencent.common.danmaku.data.a
    public float h(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Float) iPatchRedirector.redirect((short) 12, (Object) this, j3)).floatValue();
        }
        return x0(j3) - com.tencent.common.danmaku.inject.b.p().b();
    }

    @Override // com.tencent.common.danmaku.data.a
    public float i(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Float) iPatchRedirector.redirect((short) 11, (Object) this, j3)).floatValue();
        }
        return x0(j3) + this.f99672i + com.tencent.common.danmaku.inject.b.p().c();
    }

    @Override // com.tencent.common.danmaku.data.a
    public float t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Float) iPatchRedirector.redirect((short) 14, (Object) this)).floatValue();
        }
        return this.D;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float x0(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Float) iPatchRedirector.redirect((short) 9, (Object) this, j3)).floatValue();
        }
        return F() - (((float) (j3 - this.f99666c)) * this.G);
    }

    public void y0(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Float.valueOf(f16));
        } else {
            this.D = f16;
        }
    }

    public void z0(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Float.valueOf(f16));
        } else {
            this.E = f16;
        }
    }
}
