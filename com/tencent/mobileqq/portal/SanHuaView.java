package com.tencent.mobileqq.portal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes16.dex */
public class SanHuaView extends View {
    static IPatchRedirector $redirector_;
    long C;
    Matrix D;
    float E;
    float F;
    int G;
    int H;

    /* renamed from: d, reason: collision with root package name */
    private int[] f259339d;

    /* renamed from: e, reason: collision with root package name */
    private Bitmap[] f259340e;

    /* renamed from: f, reason: collision with root package name */
    int f259341f;

    /* renamed from: h, reason: collision with root package name */
    ArrayList<r> f259342h;

    /* renamed from: i, reason: collision with root package name */
    Resources f259343i;

    /* renamed from: m, reason: collision with root package name */
    boolean f259344m;

    public SanHuaView(Context context, int i3, int i16) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        int i17 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        int[] iArr = {R.drawable.eue, R.drawable.euf, R.drawable.eug, R.drawable.euh, R.drawable.eui, R.drawable.euj, R.drawable.euk, R.drawable.eul};
        this.f259339d = iArr;
        this.f259340e = new Bitmap[iArr.length];
        this.f259342h = new ArrayList<>();
        this.f259344m = false;
        this.D = new Matrix();
        this.f259343i = getResources();
        this.E = i3;
        this.F = i16;
        while (true) {
            try {
                Bitmap[] bitmapArr = this.f259340e;
                if (i17 < bitmapArr.length) {
                    bitmapArr[i17] = BitmapFactory.decodeResource(this.f259343i, this.f259339d[i17]);
                    i17++;
                } else {
                    return;
                }
            } catch (OutOfMemoryError e16) {
                e16.printStackTrace();
                return;
            }
        }
    }

    public void a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
            return;
        }
        for (int i16 = 0; i16 < i3; i16++) {
            Bitmap bitmap = this.f259340e[(int) (this.f259340e.length * Math.random())];
            if (bitmap != null) {
                this.f259342h.add(r.a(bitmap, this.E, this.F, this.f259343i));
            }
        }
        this.f259341f += i3;
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        this.f259344m = true;
        this.C = System.currentTimeMillis();
        invalidate();
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        this.f259344m = false;
        this.f259342h.clear();
        this.f259341f = 0;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) canvas);
            return;
        }
        if (!this.f259344m) {
            return;
        }
        super.onDraw(canvas);
        float currentTimeMillis = ((float) (System.currentTimeMillis() - this.C)) / 1000.0f;
        for (int i3 = 0; i3 < this.f259341f; i3++) {
            r rVar = this.f259342h.get(i3);
            if (rVar != null) {
                if (rVar.f259403f < 0.0d) {
                    float f16 = rVar.f259405h * currentTimeMillis;
                    float f17 = (rVar.f259406i * currentTimeMillis) + (BaseAIOUtils.f(270.0f, this.f259343i) * 0.5f * currentTimeMillis * currentTimeMillis);
                    float[] fArr = rVar.f259400c;
                    fArr[0] = this.E - f16;
                    fArr[1] = this.F + f17;
                } else {
                    float f18 = rVar.f259405h * currentTimeMillis;
                    float f19 = (rVar.f259406i * currentTimeMillis) - (((BaseAIOUtils.f(270.0f, this.f259343i) * 0.5f) * currentTimeMillis) * currentTimeMillis);
                    float[] fArr2 = rVar.f259400c;
                    fArr2[0] = this.E + f18;
                    fArr2[1] = this.F - f19;
                }
            }
        }
        int i16 = 0;
        for (int i17 = 0; i17 < this.f259341f; i17++) {
            r rVar2 = this.f259342h.get(i17);
            if (rVar2 != null) {
                float[] fArr3 = rVar2.f259400c;
                float f26 = fArr3[0];
                if (f26 < this.G && f26 > 0.0f) {
                    float f27 = fArr3[1];
                    if (f27 < this.H && f27 > 0.0f) {
                        this.D.setTranslate((-rVar2.f259398a) / 2, (-rVar2.f259399b) / 2);
                        this.D.postRotate(rVar2.f259401d);
                        Matrix matrix = this.D;
                        float f28 = rVar2.f259398a / 2;
                        float[] fArr4 = rVar2.f259400c;
                        matrix.postTranslate(f28 + fArr4[0], (rVar2.f259399b / 2) + fArr4[1]);
                        canvas.drawBitmap(rVar2.f259402e, this.D, null);
                        i16++;
                    }
                }
            }
        }
        if (i16 == 0) {
            c();
        }
        if (this.f259344m) {
            invalidate();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        } else {
            this.G = i3;
            this.H = i16;
        }
    }
}
