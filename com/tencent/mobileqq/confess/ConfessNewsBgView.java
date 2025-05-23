package com.tencent.mobileqq.confess;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.confess.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ConfessNewsBgView extends View {
    static IPatchRedirector $redirector_;
    private Path C;
    private int D;
    private boolean E;

    /* renamed from: d, reason: collision with root package name */
    c.a[] f202138d;

    /* renamed from: e, reason: collision with root package name */
    Paint f202139e;

    /* renamed from: f, reason: collision with root package name */
    private float[] f202140f;

    /* renamed from: h, reason: collision with root package name */
    int f202141h;

    /* renamed from: i, reason: collision with root package name */
    int f202142i;

    /* renamed from: m, reason: collision with root package name */
    RectF f202143m;

    public ConfessNewsBgView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f202138d = null;
        this.f202139e = new Paint(1);
        this.f202140f = new float[]{16.0f, 16.0f, 16.0f, 16.0f, 16.0f, 16.0f, 16.0f, 16.0f};
        this.f202141h = -6807359;
        this.f202142i = 0;
        this.f202143m = new RectF();
        this.D = 0;
        a();
    }

    /*  JADX ERROR: NullPointerException in pass: LoopRegionVisitor
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.use(jadx.core.dex.instructions.args.RegisterArg)" because "ssaVar" is null
        	at jadx.core.dex.nodes.InsnNode.rebindArgs(InsnNode.java:489)
        	at jadx.core.dex.nodes.InsnNode.rebindArgs(InsnNode.java:492)
        */
    private void a() {
        /*
            r11 = this;
            int r0 = r11.D
            r1 = 2
            r2 = 0
            if (r0 != r1) goto L77
            int r1 = r11.f202142i
            com.tencent.mobileqq.confess.c$a[] r0 = com.tencent.mobileqq.confess.c.a(r0, r1)
            r11.f202138d = r0
            android.content.res.Resources r0 = r11.getResources()
            android.util.DisplayMetrics r1 = r0.getDisplayMetrics()
            int r1 = r1.widthPixels
            android.util.DisplayMetrics r0 = r0.getDisplayMetrics()
            int r0 = r0.heightPixels
            if (r1 == 0) goto L4a
            int r3 = r1 + (-1080)
            int r3 = java.lang.Math.abs(r3)
            r4 = 200(0xc8, float:2.8E-43)
            if (r3 <= r4) goto L4a
            com.tencent.mobileqq.confess.c$a[] r3 = r11.f202138d
            int r4 = r3.length
            r5 = r2
        L2e:
            if (r5 >= r4) goto L4a
            r6 = r3[r5]
            int r7 = r6.f202171b
            float r8 = (float) r7
            float r9 = (float) r1
            r10 = 1080(0x438, float:1.513E-42)
            float r10 = (float) r10
            float r9 = r9 / r10
            float r8 = r8 * r9
            int r8 = (int) r8
            int r8 = r1 - r8
            r10 = 100
            if (r8 <= r10) goto L47
            float r7 = (float) r7
            float r7 = r7 * r9
            int r7 = (int) r7
            r6.f202171b = r7
        L47:
            int r5 = r5 + 1
            goto L2e
        L4a:
            if (r0 == 0) goto L9d
            double r0 = (double) r0
            r3 = 4605380978949069210(0x3fe999999999999a, double:0.8)
            double r0 = r0 * r3
            r3 = 1800(0x708, float:2.522E-42)
            double r4 = (double) r3
            double r4 = r0 - r4
            double r4 = java.lang.Math.abs(r4)
            r6 = 4641240890982006784(0x4069000000000000, double:200.0)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 <= 0) goto L9d
            com.tencent.mobileqq.confess.c$a[] r4 = r11.f202138d
            int r5 = r4.length
        L65:
            if (r2 >= r5) goto L9d
            r6 = r4[r2]
            int r7 = r6.f202172c
            double r7 = (double) r7
            float r9 = (float) r3
            double r9 = (double) r9
            double r9 = r0 / r9
            double r7 = r7 * r9
            int r7 = (int) r7
            r6.f202172c = r7
            int r2 = r2 + 1
            goto L65
        L77:
            java.lang.String[] r0 = com.tencent.mobileqq.confess.c.f202169a
            r1 = r0[r2]
            int r3 = r11.f202142i
            if (r3 < 0) goto L8b
            int r4 = r0.length
            if (r3 >= r4) goto L8b
            r1 = r0[r3]
            com.tencent.mobileqq.confess.c$a[] r0 = com.tencent.mobileqq.confess.c.a(r2, r3)
            r11.f202138d = r0
            goto L91
        L8b:
            com.tencent.mobileqq.confess.c$a[] r0 = com.tencent.mobileqq.confess.c.a(r2, r2)
            r11.f202138d = r0
        L91:
            int r0 = android.graphics.Color.parseColor(r1)     // Catch: java.lang.Exception -> L98
            r11.f202141h = r0     // Catch: java.lang.Exception -> L98
            goto L9d
        L98:
            r0 = -6807359(0xffffffffff9820c1, float:NaN)
            r11.f202141h = r0
        L9d:
            android.graphics.Paint r0 = r11.f202139e
            android.graphics.Paint$Style r1 = android.graphics.Paint.Style.FILL
            r0.setStyle(r1)
            android.graphics.Paint r0 = r11.f202139e
            int r1 = r11.f202141h
            r0.setColor(r1)
            boolean r0 = com.tencent.util.VersionUtils.isJellyBeanMA2()
            if (r0 != 0) goto Lb6
            r0 = 0
            r1 = 1
            r11.setLayerType(r1, r0)
        Lb6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mobileqq.confess.ConfessNewsBgView.a():void");
    }

    @Override // android.view.View
    protected void drawableStateChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.drawableStateChanged();
        if (this.E) {
            if (isPressed()) {
                this.f202141h = Color.argb(100, Color.red(this.f202141h), Color.green(this.f202141h), Color.blue(this.f202141h));
            } else {
                this.f202141h = Color.argb(255, Color.red(this.f202141h), Color.green(this.f202141h), Color.blue(this.f202141h));
            }
            postInvalidate();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) canvas);
            return;
        }
        super.onDraw(canvas);
        this.f202143m.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
        if (this.C == null) {
            this.C = new Path();
        }
        int save = canvas.save();
        try {
            Path path = this.C;
            path.reset();
            path.addRoundRect(this.f202143m, this.f202140f, Path.Direction.CW);
            canvas.clipPath(path);
        } catch (UnsupportedOperationException unused) {
        }
        canvas.drawRect(this.f202143m, this.f202139e);
        c.a[] aVarArr = this.f202138d;
        if (aVarArr != null && aVarArr.length > 0) {
            for (c.a aVar : aVarArr) {
                try {
                    Drawable drawable = getResources().getDrawable(aVar.f202170a);
                    if (aVar.f202170a != R.drawable.epo) {
                        int intrinsicWidth = drawable.getIntrinsicWidth();
                        int intrinsicHeight = drawable.getIntrinsicHeight();
                        int i16 = aVar.f202171b;
                        float f16 = intrinsicWidth;
                        float f17 = aVar.f202174e;
                        int i17 = aVar.f202172c;
                        float f18 = intrinsicHeight;
                        drawable.setBounds((int) ((i16 * 1.8f) - (((f16 * f17) * 1.0f) / 2.0f)), (int) ((i17 * 1.6f) - (((f18 * f17) * 1.0f) / 2.0f)), (int) ((i16 * 1.8f) + (((f16 * f17) * 1.0f) / 2.0f)), (int) ((i17 * 1.6f) + (((f18 * f17) * 1.0f) / 2.0f)));
                        if (aVar.f202173d) {
                            if (this.D == 2) {
                                i3 = 128;
                            } else {
                                i3 = 77;
                            }
                            drawable.setAlpha(i3);
                            drawable.setColorFilter(this.f202141h, PorterDuff.Mode.MULTIPLY);
                        }
                        drawable.draw(canvas);
                    }
                } catch (Exception unused2) {
                }
            }
        }
        canvas.restoreToCount(save);
    }

    public void setBgColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
        } else if (this.f202141h != i3) {
            this.f202141h = i3;
        }
    }

    public void setBgType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else if (this.f202142i != i3) {
            this.f202142i = i3;
            a();
            postInvalidate();
        }
    }

    public void setPressMask(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
        } else {
            this.E = z16;
        }
    }

    public void setSize(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
        } else if (this.D != i3) {
            this.D = i3;
            a();
            postInvalidate();
        }
    }

    public ConfessNewsBgView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f202138d = null;
        this.f202139e = new Paint(1);
        this.f202140f = new float[]{16.0f, 16.0f, 16.0f, 16.0f, 16.0f, 16.0f, 16.0f, 16.0f};
        this.f202141h = -6807359;
        this.f202142i = 0;
        this.f202143m = new RectF();
        this.D = 0;
        a();
    }

    public ConfessNewsBgView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f202138d = null;
        this.f202139e = new Paint(1);
        this.f202140f = new float[]{16.0f, 16.0f, 16.0f, 16.0f, 16.0f, 16.0f, 16.0f, 16.0f};
        this.f202141h = -6807359;
        this.f202142i = 0;
        this.f202143m = new RectF();
        this.D = 0;
        a();
    }
}
