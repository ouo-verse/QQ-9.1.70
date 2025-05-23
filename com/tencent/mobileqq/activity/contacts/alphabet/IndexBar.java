package com.tencent.mobileqq.activity.contacts.alphabet;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes10.dex */
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

    /* renamed from: d, reason: collision with root package name */
    private a f181435d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f181436e;

    /* renamed from: f, reason: collision with root package name */
    private String[] f181437f;

    /* renamed from: h, reason: collision with root package name */
    private int f181438h;

    /* renamed from: i, reason: collision with root package name */
    private Paint f181439i;

    /* renamed from: m, reason: collision with root package name */
    private Paint f181440m;

    /* compiled from: P */
    /* loaded from: classes10.dex */
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
        String[] strArr = this.f181437f;
        if (strArr == null || (length = strArr.length) <= 0) {
            return;
        }
        int i3 = this.H / length;
        for (int i16 = 0; i16 < length; i16++) {
            if (i16 == this.f181438h) {
                paint = this.f181440m;
            } else {
                paint = this.f181439i;
            }
            canvas.drawText(this.f181437f[i16], this.G / 2, (i3 * r5) - (paint.measureText(this.f181437f[i16]) / 2.0f), paint);
        }
    }

    private void b(Context context, AttributeSet attributeSet) {
        this.E = context.getResources().getColor(R.color.black);
        this.F = context.getResources().getColor(R.color.black);
        this.C = context.getResources().getDimensionPixelSize(com.tencent.mobileqq.R.dimen.f159010tt);
        this.D = context.getResources().getDimensionPixelSize(com.tencent.mobileqq.R.dimen.f159011tu);
        this.I = context.getResources().getDimension(com.tencent.mobileqq.R.dimen.f159007tq);
        this.J = context.getResources().getDimension(com.tencent.mobileqq.R.dimen.f159009ts);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, com.tencent.mobileqq.R.styleable.IndexBar);
            this.E = obtainStyledAttributes.getColor(com.tencent.mobileqq.R.styleable.IndexBar_sidebarTextColor, this.E);
            this.F = obtainStyledAttributes.getColor(com.tencent.mobileqq.R.styleable.IndexBar_sidebarTextColorChoose, this.F);
            this.C = obtainStyledAttributes.getDimension(com.tencent.mobileqq.R.styleable.IndexBar_sidebarTextSize, this.C);
            this.D = obtainStyledAttributes.getDimension(com.tencent.mobileqq.R.styleable.IndexBar_sidebarTextSizeChoose, this.D);
            this.I = obtainStyledAttributes.getDimension(com.tencent.mobileqq.R.styleable.IndexBar_sidebarItemHeight, this.I);
            this.J = obtainStyledAttributes.getDimension(com.tencent.mobileqq.R.styleable.IndexBar_sidebarTextPadding, this.J);
            obtainStyledAttributes.recycle();
        }
        c();
    }

    private void c() {
        Paint paint = new Paint();
        this.f181439i = paint;
        paint.setTextSize(this.C);
        this.f181439i.setColor(this.E);
        this.f181439i.setTypeface(Typeface.DEFAULT);
        this.f181439i.setTextAlign(Paint.Align.CENTER);
        this.f181439i.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.f181440m = paint2;
        paint2.setTextSize(this.C);
        this.f181440m.setTypeface(Typeface.DEFAULT);
        this.f181440m.setTextAlign(Paint.Align.CENTER);
        this.f181440m.setColor(this.F);
        this.f181440m.setAntiAlias(true);
    }

    private int d(int i3, int i16) {
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
        this.f181439i.getTextBounds("W", 0, 1, rect);
        int width = rect.width() + ((int) this.J);
        int height = rect.height() + ((int) this.J);
        int paddingLeft = getPaddingLeft() + width + getPaddingRight();
        String[] strArr = this.f181437f;
        if (strArr != null) {
            i17 = height * strArr.length;
        }
        setMeasuredDimension(d(i3, paddingLeft), d(i16, getPaddingTop() + i17 + getPaddingBottom()));
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
        int i16 = this.f181438h;
        String[] strArr = this.f181437f;
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
            this.f181436e = false;
            a aVar = this.f181435d;
            if (aVar != null) {
                aVar.m(false);
            }
            invalidate();
            return true;
        }
        if (i16 != i3) {
            if (strArr != null && i3 >= 0 && i3 < strArr.length) {
                this.f181438h = i3;
                if (this.f181435d != null) {
                    Rect rect = new Rect();
                    Paint paint = this.f181439i;
                    String str = this.f181437f[this.f181438h];
                    paint.getTextBounds(str, 0, str.length(), rect);
                    String[] strArr2 = this.f181437f;
                    int length = this.H / strArr2.length;
                    this.f181435d.p1(this.f181437f[i3], action, (length * (r3 + 1)) - (this.f181439i.measureText(strArr2[this.f181438h]) / 2.0f));
                }
            }
            invalidate();
        }
        if (motionEvent.getAction() == 0) {
            this.f181436e = true;
            a aVar2 = this.f181435d;
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
            this.f181438h = i3;
            invalidate();
        }
    }

    public void setLetters(String[] strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) strArr);
            return;
        }
        this.f181437f = strArr;
        requestLayout();
        invalidate();
    }

    public void setOnIndexBarTouchListener(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) aVar);
        } else {
            this.f181435d = aVar;
        }
    }

    public void setSelectPaintColor(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        Paint paint = this.f181440m;
        if (paint != null) {
            paint.setColor(i3);
        }
        Paint paint2 = this.f181439i;
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
        } else {
            this.f181438h = -1;
            b(context, attributeSet);
        }
    }
}
