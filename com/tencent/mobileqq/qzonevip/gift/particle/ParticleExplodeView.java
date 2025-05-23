package com.tencent.mobileqq.qzonevip.gift.particle;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;

/* loaded from: classes16.dex */
public class ParticleExplodeView extends ParticleTextureView {
    static IPatchRedirector $redirector_;

    public ParticleExplodeView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private void o(int i3, int i16, int i17, Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3) {
        int i18;
        int i19;
        for (int i26 = 0; i26 < i3; i26++) {
            a aVar = new a();
            aVar.f280186f = q(bitmap, bitmap2, bitmap3);
            if (i17 == 0) {
                i19 = d(0, 360);
            } else if (i17 == 1) {
                i19 = d(0, 180);
            } else if (i17 == 2) {
                i19 = d(180, 360);
            } else {
                i18 = i16;
                i19 = 0;
                double[] p16 = p(i18, i19);
                aVar.f280181a = (float) ((this.f280178m / 2) + p16[0]);
                aVar.f280182b = (float) ((this.C / 2) + p16[1]);
                aVar.f280183c = d(0, 360);
                this.f280176h.add(aVar);
            }
            i18 = i16;
            double[] p162 = p(i18, i19);
            aVar.f280181a = (float) ((this.f280178m / 2) + p162[0]);
            aVar.f280182b = (float) ((this.C / 2) + p162[1]);
            aVar.f280183c = d(0, 360);
            this.f280176h.add(aVar);
        }
    }

    private double[] p(int i3, int i16) {
        double d16 = i3;
        double d17 = i16;
        return new double[]{Math.cos(Math.toRadians(d17)) * d16, d16 * Math.sin(Math.toRadians(d17))};
    }

    private Bitmap q(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3) {
        int d16 = d(0, 3);
        if (d16 == 0) {
            return bitmap;
        }
        if (d16 == 1) {
            return bitmap2;
        }
        return bitmap3;
    }

    private float r(float f16, float f17, float f18) {
        float f19 = this.f280178m / 2;
        float f26 = this.C / 2;
        float f27 = (f26 - f17) / (f19 - f16);
        return (((f18 + f16) * f27) + f26) - (f19 * f27);
    }

    private float s(float f16) {
        return (f16 - (this.f280178m / 2)) / 2.0f;
    }

    @Override // com.tencent.mobileqq.qzonevip.gift.particle.ParticleTextureView
    protected void b(Bitmap[] bitmapArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) bitmapArr);
            return;
        }
        if (bitmapArr != null && bitmapArr.length != 0 && this.f280178m != 0 && this.C != 0) {
            synchronized (this.G) {
                Bitmap bitmap = bitmapArr[0];
                Bitmap bitmap2 = bitmapArr[1];
                Bitmap bitmap3 = bitmapArr[2];
                o(5, this.f280178m / 40, 0, bitmap, bitmap2, bitmap3);
                o(5, this.f280178m / 20, 0, bitmap, bitmap2, bitmap3);
                o(5, this.f280178m / 10, 0, bitmap, bitmap2, bitmap3);
                o(5, this.f280178m / 7, 0, bitmap, bitmap2, bitmap3);
                o(5, this.f280178m / 5, 0, bitmap, bitmap2, bitmap3);
                o(5, this.f280178m / 4, 0, bitmap, bitmap2, bitmap3);
                o(5, this.f280178m / 3, 0, bitmap, bitmap2, bitmap3);
                o(5, this.f280178m / 2, 1, bitmap, bitmap2, bitmap3);
                o(5, this.f280178m / 2, 2, bitmap, bitmap2, bitmap3);
                o(5, (this.f280178m * 3) / 5, 1, bitmap, bitmap2, bitmap3);
                o(5, (this.f280178m * 3) / 5, 2, bitmap, bitmap2, bitmap3);
            }
            return;
        }
        QLog.e("ParticleExplodeView", 1, "updateData: bitmap = null error");
    }

    @Override // com.tencent.mobileqq.qzonevip.gift.particle.ParticleTextureView
    protected int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return 20;
    }

    @Override // com.tencent.mobileqq.qzonevip.gift.particle.ParticleTextureView
    protected Bitmap[] f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Bitmap[]) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return new Bitmap[]{BitmapFactory.decodeResource(this.f280177i.getResources(), R.drawable.g4f), BitmapFactory.decodeResource(this.f280177i.getResources(), R.drawable.g4g), BitmapFactory.decodeResource(this.f280177i.getResources(), R.drawable.g4h)};
    }

    @Override // com.tencent.mobileqq.qzonevip.gift.particle.ParticleTextureView
    protected boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0036, code lost:
    
        if (r3 < 5.0f) goto L19;
     */
    @Override // com.tencent.mobileqq.qzonevip.gift.particle.ParticleTextureView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void n() {
        float f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        synchronized (this.G) {
            Iterator<a> it = this.f280176h.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    float s16 = s(next.f280181a);
                    if (s16 > 0.0f) {
                        f16 = 5.0f;
                    }
                    f16 = -5.0f;
                    if (s16 > -5.0f && s16 < 0.0f) {
                        s16 = f16;
                    }
                    next.f280182b = r(next.f280181a, next.f280182b, s16);
                    float f17 = next.f280181a + s16;
                    next.f280181a = f17;
                    next.f280183c += 15.0f;
                    if (f17 >= 0.0f) {
                        if (f17 <= this.f280178m && f17 != r2 / 2) {
                        }
                    }
                    it.remove();
                }
            }
        }
    }

    public ParticleExplodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public ParticleExplodeView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
    }
}
