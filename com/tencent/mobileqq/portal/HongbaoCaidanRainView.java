package com.tencent.mobileqq.portal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes16.dex */
public class HongbaoCaidanRainView extends View {
    static IPatchRedirector $redirector_;
    private Random C;
    private boolean D;
    private boolean E;
    private Matrix F;
    private int G;
    private float H;
    private int I;
    private float J;
    private float K;
    private float L;
    private float M;
    private int N;

    /* renamed from: d, reason: collision with root package name */
    private long f259231d;

    /* renamed from: e, reason: collision with root package name */
    private long f259232e;

    /* renamed from: f, reason: collision with root package name */
    private long f259233f;

    /* renamed from: h, reason: collision with root package name */
    private List<a> f259234h;

    /* renamed from: i, reason: collision with root package name */
    private List<a> f259235i;

    /* renamed from: m, reason: collision with root package name */
    private List<Bitmap> f259236m;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.portal.HongbaoCaidanRainView$1, reason: invalid class name */
    /* loaded from: classes16.dex */
    class AnonymousClass1 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String[] f259237d;
        final /* synthetic */ HongbaoCaidanRainView this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            this.this$0.f259236m.clear();
            for (String str : this.f259237d) {
                try {
                    Bitmap decodeFile = BitmapFactory.decodeFile(str);
                    if (decodeFile != null) {
                        this.this$0.f259236m.add(decodeFile);
                    }
                } catch (OutOfMemoryError e16) {
                    QLog.d("HongbaoCaidanRainView", 1, "start, OutOfMemoryError oom=" + e16.getMessage());
                    if (QLog.isColorLevel()) {
                        e16.printStackTrace();
                    }
                } catch (Throwable th5) {
                    QLog.d("HongbaoCaidanRainView", 1, "start, throwable t=" + th5.getMessage());
                    if (QLog.isColorLevel()) {
                        th5.printStackTrace();
                    }
                }
            }
            if (this.this$0.f259236m.size() > 0) {
                this.this$0.f259231d = System.currentTimeMillis();
                HongbaoCaidanRainView hongbaoCaidanRainView = this.this$0;
                hongbaoCaidanRainView.f259233f = hongbaoCaidanRainView.f259231d;
                this.this$0.D = true;
                this.this$0.E = false;
                this.this$0.postInvalidate();
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.portal.HongbaoCaidanRainView$2, reason: invalid class name */
    /* loaded from: classes16.dex */
    class AnonymousClass2 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Bitmap[] f259238d;
        final /* synthetic */ HongbaoCaidanRainView this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            this.this$0.f259236m.clear();
            for (Bitmap bitmap : this.f259238d) {
                if (QLog.isColorLevel()) {
                    QLog.d("HongbaoCaidanRainView", 2, "start(), bitmap =" + bitmap);
                }
                this.this$0.f259236m.add(bitmap);
            }
            if (QLog.isColorLevel()) {
                QLog.d("HongbaoCaidanRainView", 2, "start(), mBitmapList.size() =" + this.this$0.f259236m.size());
            }
            if (this.this$0.f259236m.size() > 0) {
                this.this$0.f259231d = System.currentTimeMillis();
                HongbaoCaidanRainView hongbaoCaidanRainView = this.this$0;
                hongbaoCaidanRainView.f259233f = hongbaoCaidanRainView.f259231d;
                this.this$0.D = true;
                this.this$0.E = false;
                this.this$0.postInvalidate();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        int f259239a;

        /* renamed from: b, reason: collision with root package name */
        int f259240b;

        /* renamed from: c, reason: collision with root package name */
        float f259241c;

        /* renamed from: d, reason: collision with root package name */
        float f259242d;

        /* renamed from: e, reason: collision with root package name */
        float f259243e;

        /* renamed from: f, reason: collision with root package name */
        float f259244f;

        /* renamed from: g, reason: collision with root package name */
        float f259245g;

        /* renamed from: h, reason: collision with root package name */
        Bitmap f259246h;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f259239a = 0;
            this.f259240b = 0;
            this.f259241c = 0.0f;
            this.f259242d = 0.0f;
            this.f259243e = 0.0f;
            this.f259244f = 0.0f;
        }
    }

    public HongbaoCaidanRainView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f259231d = 0L;
        this.f259232e = 0L;
        this.f259233f = 0L;
        this.f259234h = new ArrayList();
        this.f259235i = new ArrayList();
        this.f259236m = new ArrayList(5);
        this.C = new Random(System.currentTimeMillis());
        this.D = false;
        this.E = false;
        this.F = new Matrix();
        this.G = 1000;
        this.H = 0.0f;
        this.I = 0;
        this.J = 0.0f;
        this.K = 10.0f;
        this.L = 1.0f;
        this.M = 0.0f;
        this.N = 0;
    }

    private void g(int i3) {
        int i16;
        if (this.f259236m.size() == 0) {
            return;
        }
        for (int i17 = 0; i17 < i3; i17++) {
            a aVar = new a();
            aVar.f259239a = this.C.nextInt(this.G);
            aVar.f259241c = this.C.nextInt(360);
            float nextFloat = this.C.nextFloat() * this.J;
            int i18 = -1;
            if (this.C.nextFloat() > 0.5d) {
                i16 = 1;
            } else {
                i16 = -1;
            }
            aVar.f259244f = nextFloat * i16;
            List<Bitmap> list = this.f259236m;
            aVar.f259246h = list.get(this.C.nextInt(list.size()));
            if (QLog.isColorLevel()) {
                QLog.d("HongbaoCaidanRainView", 2, "addNode n.bitmap = " + aVar.f259246h);
            }
            aVar.f259245g = ((this.I * 1.0f) / aVar.f259246h.getWidth()) * ((this.C.nextFloat() * this.H) + 1.0f);
            aVar.f259243e = (this.C.nextFloat() * this.M) + this.K;
            float nextFloat2 = this.C.nextFloat() * this.L;
            if (this.C.nextFloat() > 0.5d) {
                i18 = 1;
            }
            aVar.f259242d = nextFloat2 * i18;
            aVar.f259240b = (int) ((-aVar.f259246h.getHeight()) * aVar.f259245g);
            this.f259234h.add(aVar);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) canvas);
            return;
        }
        if (!this.E && this.D) {
            super.onDraw(canvas);
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f259231d < 1300 && currentTimeMillis - this.f259232e > 40) {
                g(1);
                this.f259232e = currentTimeMillis;
            }
            float f16 = (float) (((currentTimeMillis - this.f259233f) * 1.0d) / 1000.0d);
            this.f259233f = currentTimeMillis;
            int size = this.f259234h.size();
            for (int i3 = 0; i3 < size; i3++) {
                a aVar = this.f259234h.get(i3);
                int i16 = (int) (aVar.f259240b + (aVar.f259243e * f16));
                aVar.f259240b = i16;
                if (i16 > this.N) {
                    this.f259235i.add(aVar);
                } else {
                    aVar.f259239a = (int) (aVar.f259239a + (aVar.f259242d * f16));
                    aVar.f259241c += aVar.f259244f * f16;
                }
            }
            this.f259234h.removeAll(this.f259235i);
            this.f259235i.clear();
            int size2 = this.f259234h.size();
            if (size2 == 0) {
                this.D = false;
                return;
            }
            for (int i17 = 0; i17 < size2; i17++) {
                a aVar2 = this.f259234h.get(i17);
                this.F.reset();
                this.F.setTranslate((-aVar2.f259246h.getWidth()) / 2, (-aVar2.f259246h.getHeight()) / 2);
                this.F.postRotate(aVar2.f259241c);
                Matrix matrix = this.F;
                float f17 = aVar2.f259245g;
                matrix.preScale(f17, f17);
                this.F.postTranslate(aVar2.f259239a, aVar2.f259240b);
                canvas.drawBitmap(aVar2.f259246h, this.F, null);
            }
            invalidate();
        }
    }

    public void setPause(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
            return;
        }
        this.E = z16;
        if (z16) {
            this.f259234h.clear();
        }
    }

    public HongbaoCaidanRainView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f259231d = 0L;
        this.f259232e = 0L;
        this.f259233f = 0L;
        this.f259234h = new ArrayList();
        this.f259235i = new ArrayList();
        this.f259236m = new ArrayList(5);
        this.C = new Random(System.currentTimeMillis());
        this.D = false;
        this.E = false;
        this.F = new Matrix();
        this.G = 1000;
        this.H = 0.0f;
        this.I = 0;
        this.J = 0.0f;
        this.K = 10.0f;
        this.L = 1.0f;
        this.M = 0.0f;
        this.N = 0;
    }

    public HongbaoCaidanRainView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f259231d = 0L;
        this.f259232e = 0L;
        this.f259233f = 0L;
        this.f259234h = new ArrayList();
        this.f259235i = new ArrayList();
        this.f259236m = new ArrayList(5);
        this.C = new Random(System.currentTimeMillis());
        this.D = false;
        this.E = false;
        this.F = new Matrix();
        this.G = 1000;
        this.H = 0.0f;
        this.I = 0;
        this.J = 0.0f;
        this.K = 10.0f;
        this.L = 1.0f;
        this.M = 0.0f;
        this.N = 0;
    }
}
