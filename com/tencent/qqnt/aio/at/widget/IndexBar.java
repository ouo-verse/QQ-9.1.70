package com.tencent.qqnt.aio.at.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes23.dex */
public class IndexBar extends View {
    static IPatchRedirector $redirector_;
    private float C;
    private float D;
    private int E;
    private int F;
    private int G;
    private int H;
    private float I;
    private float J;
    private boolean K;

    /* renamed from: d, reason: collision with root package name */
    private a f349486d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f349487e;

    /* renamed from: f, reason: collision with root package name */
    private String[] f349488f;

    /* renamed from: h, reason: collision with root package name */
    private int f349489h;

    /* renamed from: i, reason: collision with root package name */
    private Paint f349490i;

    /* renamed from: m, reason: collision with root package name */
    private Paint f349491m;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface a {
        void m(boolean z16);

        void p1(String str, int i3, float f16);
    }

    public IndexBar(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private void a(Canvas canvas) {
        int length;
        Paint paint;
        String[] strArr = this.f349488f;
        if (strArr == null || (length = strArr.length) <= 0) {
            return;
        }
        int i3 = this.H / length;
        for (int i16 = 0; i16 < length; i16++) {
            if (i16 == 0 && this.f349488f[i16].equals("$")) {
                b(canvas, i3);
            } else {
                if (i16 == this.f349489h) {
                    paint = this.f349491m;
                } else {
                    paint = this.f349490i;
                }
                canvas.drawText(this.f349488f[i16], this.G / 2, ((i16 + 1) * i3) - (paint.measureText(this.f349488f[i16]) / 2.0f), paint);
            }
        }
    }

    private void b(Canvas canvas, int i3) {
        int i16;
        Drawable drawable = getResources().getDrawable(R.drawable.f160878oa);
        float intrinsicWidth = (drawable.getIntrinsicWidth() * 1.0f) / drawable.getIntrinsicHeight();
        int i17 = (int) this.C;
        if (i3 > 0 && i17 > 0 && intrinsicWidth > 0.0f) {
            float f16 = i17;
            float f17 = i3;
            if (intrinsicWidth >= (1.0f * f16) / f17) {
                i16 = (int) (f16 / intrinsicWidth);
            } else {
                i17 = (int) (intrinsicWidth * f17);
                i16 = i3;
            }
            Rect rect = new Rect();
            int i18 = (this.G - i17) / 2;
            rect.left = i18;
            int i19 = (i3 - i16) / 2;
            rect.top = i19;
            rect.right = i18 + i17;
            rect.bottom = i19 + i16;
            drawable.setBounds(rect);
            drawable.draw(canvas);
        }
    }

    private void d(Context context, AttributeSet attributeSet) {
        this.E = context.getResources().getColor(android.R.color.black);
        this.F = context.getResources().getColor(android.R.color.black);
        this.C = context.getResources().getDimensionPixelSize(R.dimen.f159010tt);
        this.D = context.getResources().getDimensionPixelSize(R.dimen.f159011tu);
        this.I = context.getResources().getDimension(R.dimen.f159007tq);
        this.J = context.getResources().getDimension(R.dimen.f159009ts);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, qv3.a.A1);
            this.E = obtainStyledAttributes.getColor(qv3.a.D1, this.E);
            this.F = obtainStyledAttributes.getColor(qv3.a.E1, this.F);
            this.C = obtainStyledAttributes.getDimension(qv3.a.G1, this.C);
            this.D = obtainStyledAttributes.getDimension(qv3.a.H1, this.D);
            this.I = obtainStyledAttributes.getDimension(qv3.a.C1, this.I);
            this.J = obtainStyledAttributes.getDimension(qv3.a.F1, this.J);
            this.K = obtainStyledAttributes.getBoolean(qv3.a.B1, this.K);
            obtainStyledAttributes.recycle();
        }
        if (this.K && FontSettingManager.isFontSizeLarge()) {
            this.C = FontSettingManager.revertSize2Normal(context, this.C);
            this.D = FontSettingManager.revertSize2Normal(context, this.D);
            this.I = FontSettingManager.revertSize2Normal(context, this.I);
            this.J = FontSettingManager.revertSize2Normal(context, this.J);
        }
        e();
    }

    private void e() {
        Paint paint = new Paint();
        this.f349490i = paint;
        paint.setTextSize(this.C);
        this.f349490i.setColor(this.E);
        this.f349490i.setTypeface(Typeface.DEFAULT);
        this.f349490i.setTextAlign(Paint.Align.CENTER);
        this.f349490i.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.f349491m = paint2;
        paint2.setTextSize(this.C);
        this.f349491m.setTypeface(Typeface.DEFAULT);
        this.f349491m.setTextAlign(Paint.Align.CENTER);
        this.f349491m.setColor(this.F);
        this.f349491m.setAntiAlias(true);
    }

    private int f(int i3, int i16) {
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        if (mode == 1073741824) {
            return size;
        }
        if (mode == Integer.MIN_VALUE) {
            return Math.min(i16, size);
        }
        return i16;
    }

    public String[] c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String[]) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.f349488f;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) canvas);
        } else {
            super.onDraw(canvas);
            a(canvas);
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        super.onLayout(z16, i3, i16, i17, i18);
        this.G = getWidth();
        this.H = getHeight();
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i17 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        super.onMeasure(i3, i16);
        Rect rect = new Rect();
        this.f349490i.getTextBounds("W", 0, 1, rect);
        int width = rect.width() + ((int) this.J);
        int height = rect.height() + ((int) this.J);
        int paddingLeft = getPaddingLeft() + width + getPaddingRight();
        String[] strArr = this.f349488f;
        if (strArr != null) {
            i17 = height * strArr.length;
        }
        setMeasuredDimension(f(i3, paddingLeft), f(i16, getPaddingTop() + i17 + getPaddingBottom()));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) motionEvent)).booleanValue();
        }
        int action = motionEvent.getAction();
        float y16 = motionEvent.getY();
        int i16 = this.f349489h;
        String[] strArr = this.f349488f;
        if (strArr != null) {
            i3 = (int) ((y16 / this.H) * strArr.length);
        } else {
            i3 = -1;
        }
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        return false;
                    }
                }
            }
            this.f349487e = false;
            a aVar = this.f349486d;
            if (aVar != null) {
                aVar.m(false);
            }
            invalidate();
            return true;
        }
        if (i16 != i3) {
            if (strArr != null && i3 >= 0 && i3 < strArr.length) {
                this.f349489h = i3;
                if (this.f349486d != null) {
                    Rect rect = new Rect();
                    Paint paint = this.f349490i;
                    String str = this.f349488f[this.f349489h];
                    paint.getTextBounds(str, 0, str.length(), rect);
                    String[] strArr2 = this.f349488f;
                    int length = this.H / strArr2.length;
                    this.f349486d.p1(this.f349488f[i3], action, (length * (r3 + 1)) - (this.f349490i.measureText(strArr2[this.f349489h]) / 2.0f));
                }
            }
            invalidate();
        }
        if (motionEvent.getAction() == 0) {
            this.f349487e = true;
            a aVar2 = this.f349486d;
            if (aVar2 != null) {
                aVar2.m(true);
            }
            invalidate();
        }
        return true;
    }

    public void setChooseIndex(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3);
        } else {
            if (this.f349489h == i3) {
                return;
            }
            this.f349489h = i3;
            invalidate();
        }
    }

    public void setLetters(String[] strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) strArr);
            return;
        }
        this.f349488f = strArr;
        requestLayout();
        invalidate();
    }

    public void setOnIndexBarTouchListener(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) aVar);
        } else {
            this.f349486d = aVar;
        }
    }

    public void setSelectPaintColor(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        Paint paint = this.f349491m;
        if (paint != null) {
            paint.setColor(i3);
        }
        Paint paint2 = this.f349490i;
        if (paint2 != null) {
            paint2.setColor(i16);
        }
    }

    public IndexBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public IndexBar(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f349489h = -1;
        this.K = false;
        d(context, attributeSet);
    }

    public void setChooseIndex(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) str);
            return;
        }
        String[] strArr = this.f349488f;
        if (strArr == null || strArr.length == 0) {
            return;
        }
        int i3 = 0;
        while (true) {
            String[] strArr2 = this.f349488f;
            if (i3 >= strArr2.length) {
                return;
            }
            if (strArr2[i3].equals(str)) {
                setChooseIndex(i3);
            }
            i3++;
        }
    }
}
