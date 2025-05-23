package com.tencent.mobileqq.qzonevip.gift.particle;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.Iterator;

/* loaded from: classes16.dex */
public class ParticleDropView extends ParticleTextureView {
    static IPatchRedirector $redirector_;
    private Bitmap K;
    private int L;

    public ParticleDropView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.L = 0;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    @Override // com.tencent.mobileqq.qzonevip.gift.particle.ParticleTextureView
    protected void b(Bitmap[] bitmapArr) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) bitmapArr);
            return;
        }
        if (bitmapArr != null && bitmapArr.length != 0 && this.f280178m != 0 && this.C != 0) {
            Bitmap bitmap = bitmapArr[0];
            int i16 = this.L + 1;
            this.L = i16;
            if (i16 < 3) {
                i3 = d(2, 4);
            } else {
                i3 = 4;
            }
            synchronized (this.G) {
                for (int i17 = 0; i17 < i3; i17++) {
                    a aVar = new a();
                    aVar.f280186f = bitmap;
                    aVar.f280190j = d(2000, QzoneConfig.DEFAULT_PHOTOVIEW_PHOTO_BYTES);
                    aVar.f280181a = d(0, this.f280178m + 100) - 100;
                    aVar.f280182b = d(0, (this.C * 4) / 5) - 200;
                    aVar.f280185e = 0;
                    aVar.f280184d = c(0.15f, 0.75f);
                    aVar.f280182b -= 300.0f;
                    aVar.f280183c = d(0, 360);
                    this.f280176h.add(aVar);
                }
                if (this.L % 2 == 0) {
                    a aVar2 = new a();
                    aVar2.f280186f = bitmap;
                    aVar2.f280190j = d(2000, QzoneConfig.DEFAULT_PHOTOVIEW_PHOTO_BYTES);
                    aVar2.f280181a = d(0, this.f280178m + 100) - 100;
                    aVar2.f280182b = d(0, 100) - 300;
                    aVar2.f280185e = 0;
                    aVar2.f280183c = d(0, 360);
                    this.f280176h.add(aVar2);
                }
            }
            return;
        }
        QLog.e("ParticleDropView", 1, "addData: bitmap = null error");
    }

    @Override // com.tencent.mobileqq.qzonevip.gift.particle.ParticleTextureView
    protected int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.qzonevip.gift.particle.ParticleTextureView
    protected Bitmap[] f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Bitmap[]) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return new Bitmap[]{this.K};
    }

    @Override // com.tencent.mobileqq.qzonevip.gift.particle.ParticleTextureView
    protected boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        if (this.H % 40 == 0 && !this.F) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qzonevip.gift.particle.ParticleTextureView
    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            super.j();
            setAlpha(1.0f);
        }
    }

    @Override // com.tencent.mobileqq.qzonevip.gift.particle.ParticleTextureView
    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        super.k();
        synchronized (this.G) {
            this.f280176h.clear();
        }
    }

    @Override // com.tencent.mobileqq.qzonevip.gift.particle.ParticleTextureView
    protected void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        synchronized (this.G) {
            Iterator<a> it = this.f280176h.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    if (next.f280184d > 0.75f) {
                        next.f280182b += 13.0f;
                    } else {
                        next.f280182b += 8.0f;
                    }
                    if (!next.f280188h) {
                        next.f280189i = d(-1, 1);
                        next.f280188h = true;
                    }
                    if (next.f280189i == 0) {
                        next.f280189i = 1;
                    }
                    next.f280181a += next.f280189i;
                    o(next);
                    if (next.f280185e == 0 || next.f280182b >= this.C) {
                        it.remove();
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void o(a aVar) {
        long j3;
        long j16;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) aVar);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - aVar.f280187g;
        long j17 = aVar.f280190j;
        int i16 = 255;
        if (currentTimeMillis <= j17 / 4) {
            j3 = j17 / 4;
            j16 = currentTimeMillis - j3;
        } else {
            if (currentTimeMillis >= j17 / 4 && currentTimeMillis < (j17 * 3) / 4) {
                i3 = 255;
                if (i3 <= 255) {
                    i16 = i3;
                }
                if (i16 < 0) {
                    i16 = 0;
                }
                aVar.f280185e = i16;
            }
            j3 = (j17 * 3) / 4;
            j16 = j3 - currentTimeMillis;
        }
        i3 = (int) (((((float) j16) * 255.0f) / ((float) j3)) + 255.0f);
        if (i3 <= 255) {
        }
        if (i16 < 0) {
        }
        aVar.f280185e = i16;
    }

    public void setBitmap(Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bitmap);
        } else {
            this.K = bitmap;
        }
    }

    public ParticleDropView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.L = 0;
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        }
    }

    public ParticleDropView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            this.L = 0;
        } else {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        }
    }
}
