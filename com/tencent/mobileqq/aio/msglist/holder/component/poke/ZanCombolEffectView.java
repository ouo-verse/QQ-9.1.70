package com.tencent.mobileqq.aio.msglist.holder.component.poke;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ZanCombolEffectView extends View {
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
    private String P;
    private int Q;
    private boolean R;

    /* renamed from: d, reason: collision with root package name */
    private long f191606d;

    /* renamed from: e, reason: collision with root package name */
    private long f191607e;

    /* renamed from: f, reason: collision with root package name */
    private long f191608f;

    /* renamed from: h, reason: collision with root package name */
    private List<a> f191609h;

    /* renamed from: i, reason: collision with root package name */
    private List<a> f191610i;

    /* renamed from: m, reason: collision with root package name */
    private List<Bitmap> f191611m;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        int f191614a;

        /* renamed from: b, reason: collision with root package name */
        int f191615b;

        /* renamed from: c, reason: collision with root package name */
        float f191616c;

        /* renamed from: d, reason: collision with root package name */
        float f191617d;

        /* renamed from: e, reason: collision with root package name */
        float f191618e;

        /* renamed from: f, reason: collision with root package name */
        float f191619f;

        /* renamed from: g, reason: collision with root package name */
        float f191620g;

        /* renamed from: h, reason: collision with root package name */
        Bitmap f191621h;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f191614a = 0;
            this.f191615b = 0;
            this.f191616c = 0.0f;
            this.f191617d = 0.0f;
            this.f191618e = 0.0f;
            this.f191619f = 0.0f;
        }
    }

    public ZanCombolEffectView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f191606d = 0L;
        this.f191607e = 0L;
        this.f191608f = 0L;
        this.f191609h = new ArrayList();
        this.f191610i = new ArrayList();
        this.f191611m = new ArrayList(5);
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
        this.P = "chat_item_for_likeplus";
        this.R = false;
    }

    private void h(int i3) {
        int i16;
        if (this.f191611m.size() == 0) {
            return;
        }
        for (int i17 = 0; i17 < i3; i17++) {
            a aVar = new a();
            aVar.f191614a = getWidth() / 2;
            aVar.f191616c = this.C.nextInt(360);
            float nextFloat = this.C.nextFloat() * this.J;
            int i18 = -1;
            if (this.C.nextFloat() > 0.5d) {
                i16 = 1;
            } else {
                i16 = -1;
            }
            aVar.f191619f = nextFloat * i16;
            List<Bitmap> list = this.f191611m;
            aVar.f191621h = list.get(this.C.nextInt(list.size()));
            aVar.f191620g = 1.0f;
            aVar.f191618e = (this.C.nextFloat() * this.M) + this.K;
            float nextFloat2 = (float) (this.C.nextFloat() * this.M * 0.2d);
            if (this.C.nextFloat() > 0.5d) {
                i18 = 1;
            }
            float f16 = this.L;
            aVar.f191617d = (nextFloat2 * i18) + (f16 * f16);
            aVar.f191615b = (int) ((-this.N) * 0.12d);
            this.f191609h.add(aVar);
        }
    }

    @TargetApi(11)
    public void i(int i3, int i16, float f16, float f17, float f18, float f19, float f26, int i17, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16), Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19), Float.valueOf(f26), Integer.valueOf(i17), Boolean.valueOf(z16));
            return;
        }
        this.G = i3;
        this.H = f16;
        this.I = i16;
        this.J = f17;
        this.K = f18;
        this.M = f26;
        this.N = i17;
        this.L = f19;
        this.R = z16;
        setLayerType(2, null);
    }

    public void j(Integer... numArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) numArr);
        } else {
            post(new Runnable(numArr) { // from class: com.tencent.mobileqq.aio.msglist.holder.component.poke.ZanCombolEffectView.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Integer[] f191612d;

                {
                    this.f191612d = numArr;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ZanCombolEffectView.this, (Object) numArr);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    ZanCombolEffectView.this.f191611m.clear();
                    for (Integer num : this.f191612d) {
                        try {
                            Bitmap decodeResource = BitmapFactory.decodeResource(ZanCombolEffectView.this.getResources(), num.intValue());
                            if (decodeResource != null) {
                                ZanCombolEffectView.this.f191611m.add(decodeResource);
                            }
                        } catch (OutOfMemoryError e16) {
                            e16.printStackTrace();
                        } catch (Throwable unused) {
                        }
                    }
                    if (ZanCombolEffectView.this.f191611m.size() > 0) {
                        ZanCombolEffectView.this.f191606d = System.currentTimeMillis();
                        ZanCombolEffectView zanCombolEffectView = ZanCombolEffectView.this;
                        zanCombolEffectView.f191608f = zanCombolEffectView.f191606d;
                        ZanCombolEffectView.this.D = true;
                        ZanCombolEffectView.this.E = false;
                        ZanCombolEffectView.this.postInvalidate();
                    }
                    if (ZanCombolEffectView.this.R) {
                        ThreadManagerV2.postImmediately(new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.poke.ZanCombolEffectView.1.1
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                    iPatchRedirector3.redirect((short) 2, (Object) this);
                                }
                            }
                        }, null, true);
                    }
                }
            });
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) canvas);
            return;
        }
        if (!this.E && this.D) {
            super.onDraw(canvas);
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f191606d < 800 && currentTimeMillis - this.f191607e > 10) {
                h(1);
                this.f191607e = currentTimeMillis;
            }
            float f16 = (float) (((currentTimeMillis - this.f191608f) * 1.0d) / 1000.0d);
            this.f191608f = currentTimeMillis;
            int size = this.f191609h.size();
            for (int i3 = 0; i3 < size; i3++) {
                a aVar = this.f191609h.get(i3);
                int i16 = (int) (aVar.f191615b + (aVar.f191618e * f16));
                aVar.f191615b = i16;
                if (i16 > this.N) {
                    this.f191610i.add(aVar);
                } else {
                    aVar.f191614a = (int) (aVar.f191614a + (2.0f * f16 * r8) + (aVar.f191617d * 0.02d));
                    aVar.f191616c += aVar.f191619f * f16;
                }
            }
            this.f191609h.removeAll(this.f191610i);
            this.f191610i.clear();
            int size2 = this.f191609h.size();
            if (size2 == 0) {
                this.D = false;
                if (this.R) {
                    this.Q = 0;
                    return;
                }
                return;
            }
            for (int i17 = 0; i17 < size2; i17++) {
                a aVar2 = this.f191609h.get(i17);
                this.F.reset();
                this.F.setTranslate((-aVar2.f191621h.getWidth()) / 2, (-aVar2.f191621h.getHeight()) / 2);
                this.F.postRotate(aVar2.f191616c);
                Matrix matrix = this.F;
                float f17 = aVar2.f191620g;
                matrix.preScale(f17, f17);
                this.F.postTranslate(aVar2.f191614a, aVar2.f191615b);
                canvas.drawBitmap(aVar2.f191621h, this.F, null);
            }
            invalidate();
        }
    }

    public void setPause(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
            return;
        }
        this.E = z16;
        if (z16) {
            this.f191609h.clear();
        }
    }

    public ZanCombolEffectView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f191606d = 0L;
        this.f191607e = 0L;
        this.f191608f = 0L;
        this.f191609h = new ArrayList();
        this.f191610i = new ArrayList();
        this.f191611m = new ArrayList(5);
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
        this.P = "chat_item_for_likeplus";
        this.R = false;
    }

    public ZanCombolEffectView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f191606d = 0L;
        this.f191607e = 0L;
        this.f191608f = 0L;
        this.f191609h = new ArrayList();
        this.f191610i = new ArrayList();
        this.f191611m = new ArrayList(5);
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
        this.P = "chat_item_for_likeplus";
        this.R = false;
    }
}
