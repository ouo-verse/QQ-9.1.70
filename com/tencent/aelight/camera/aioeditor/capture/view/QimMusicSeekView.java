package com.tencent.aelight.camera.aioeditor.capture.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.al;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes32.dex */
public class QimMusicSeekView extends View implements View.OnTouchListener {
    protected static final int[] U;
    protected static final int V;
    protected static int W;

    /* renamed from: a0, reason: collision with root package name */
    protected static int[] f67319a0;

    /* renamed from: b0, reason: collision with root package name */
    protected static int f67320b0;

    /* renamed from: c0, reason: collision with root package name */
    protected static int f67321c0;
    protected int C;
    protected int D;
    protected int E;
    protected int F;
    protected int G;
    protected a H;
    protected Rect I;
    protected int J;
    protected int K;
    protected int L;
    protected boolean M;
    protected Paint N;
    protected Paint P;
    protected Paint Q;
    protected Paint R;
    protected Paint S;
    float T;

    /* renamed from: d, reason: collision with root package name */
    protected int f67322d;

    /* renamed from: e, reason: collision with root package name */
    protected int f67323e;

    /* renamed from: f, reason: collision with root package name */
    protected int f67324f;

    /* renamed from: h, reason: collision with root package name */
    protected int f67325h;

    /* renamed from: i, reason: collision with root package name */
    protected int f67326i;

    /* renamed from: m, reason: collision with root package name */
    protected int f67327m;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface a {
        void a(int i3, int i16, int i17);

        void g(int i3, int i16, int i17);

        void h(int i3, int i16);

        void k(int i3, int i16, int i17);
    }

    public QimMusicSeekView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f67322d = 0;
        this.f67323e = 0;
        this.f67324f = 0;
        this.f67325h = 0;
        this.f67326i = 0;
        this.f67327m = 0;
        this.C = 0;
        this.D = 0;
        this.E = 0;
        this.F = 0;
        this.G = 0;
        this.H = null;
        this.I = null;
        this.J = 0;
        this.K = 0;
        this.L = 0;
        this.M = false;
        this.N = null;
        this.P = null;
        this.Q = null;
        this.R = null;
        this.S = null;
        this.T = 0.0f;
        this.J = (int) al.a(context, 8.0f);
        this.F = (int) al.a(context, 2.0f);
        this.G = (int) al.a(context, 2.0f);
        this.L = (int) al.a(context, 3.0f);
        W = (int) al.a(context, 4.0f);
        f67321c0 = (int) al.a(context, 50.0f);
        f67320b0 = (int) al.a(context, 36.0f);
        for (int i3 = 0; i3 < V; i3++) {
            f67319a0[i3] = (int) al.a(context, U[i3]);
        }
        Resources resources = context.getResources();
        Paint paint = new Paint();
        this.N = paint;
        paint.setAntiAlias(true);
        this.N.setColor(resources.getColor(R.color.f156970gg));
        Paint paint2 = new Paint();
        this.P = paint2;
        paint2.setAntiAlias(true);
        this.P.setColor(resources.getColor(R.color.f157748yb));
        Paint paint3 = new Paint();
        this.Q = paint3;
        paint3.setAntiAlias(true);
        this.Q.setColor(resources.getColor(R.color.al8));
        this.Q.setStrokeWidth(1.0f);
        this.Q.setStyle(Paint.Style.FILL);
        Paint paint4 = new Paint();
        this.R = paint4;
        paint4.setAntiAlias(true);
        this.R.setColor(resources.getColor(R.color.f156906ev));
        this.R.setStyle(Paint.Style.FILL);
        Paint paint5 = new Paint();
        this.S = paint5;
        paint5.setAntiAlias(true);
        this.S.setColor(0);
        this.S.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        super.setOnTouchListener(this);
    }

    protected void a(Canvas canvas, int i3, int i16, int i17, int i18, Paint paint) {
        Rect rect = new Rect();
        rect.left = i3;
        rect.top = i16;
        rect.bottom = i18;
        rect.right = i17;
        canvas.drawRect(rect, paint);
    }

    protected void b(Canvas canvas, int i3, int i16, int i17, int i18, float f16, Paint paint) {
        RectF rectF = new RectF();
        rectF.left = i3;
        rectF.top = i16;
        rectF.bottom = i18;
        rectF.right = i17;
        canvas.drawRoundRect(rectF, f16, f16, paint);
    }

    public void c(int i3) {
        this.f67326i = (int) ((i3 / 1000) * (W + this.F) * 2.5f);
        setPlayedPosition(-1);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int i3;
        int i16;
        int i17;
        int i18;
        Paint paint;
        this.N.setStrokeWidth(this.K);
        this.N.setStyle(Paint.Style.FILL);
        this.P.setStrokeWidth(this.K);
        this.P.setStyle(Paint.Style.FILL);
        int i19 = 0;
        int i26 = 0;
        while (i26 < this.f67323e) {
            int i27 = this.C;
            int i28 = this.f67326i;
            int i29 = i26 + 1;
            int i36 = (i27 - i28) + (W * i29);
            int i37 = this.F;
            int i38 = i36 + (i26 * i37);
            int i39 = this.f67324f;
            if (i38 > i27 + i39 && i28 == this.f67325h - i39) {
                break;
            }
            if (i38 >= 0) {
                if (i38 > this.D) {
                    break;
                }
                Paint paint2 = this.Q;
                if (!this.M) {
                    Rect rect = this.I;
                    if (i38 > rect.left - i37 && i38 < rect.right) {
                    }
                }
                int i46 = f67319a0[i26 % V];
                int i47 = (this.E - i46) / 2;
                b(canvas, i38, i47, i37 + i38, i47 + i46, 5.0f, paint2);
            }
            i26 = i29;
        }
        this.N.setStrokeWidth(1.0f);
        this.N.setStyle(Paint.Style.FILL);
        Rect rect2 = this.I;
        int i48 = rect2.left;
        int i49 = this.J;
        b(canvas, i48 - i49, rect2.top, rect2.right + i49, rect2.bottom, 10.0f, this.N);
        this.R.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        Rect rect3 = this.I;
        int i56 = rect3.left;
        int i57 = rect3.top;
        int i58 = this.G;
        a(canvas, i56, i57 + i58, rect3.right, rect3.bottom - i58, this.R);
        this.R.setXfermode(null);
        this.N.setStrokeWidth(this.K);
        this.N.setStyle(Paint.Style.FILL);
        this.P.setStrokeWidth(this.K);
        this.P.setStyle(Paint.Style.FILL);
        int i59 = -1;
        while (i19 < this.f67323e) {
            int i65 = this.C;
            int i66 = this.f67326i;
            int i67 = i19 + 1;
            int i68 = (i65 - i66) + (W * i67);
            int i69 = this.F;
            int i75 = i68 + (i19 * i69);
            int i76 = this.f67324f;
            if (i75 > i65 + i76 && i66 == this.f67325h - i76) {
                return;
            }
            if (i75 >= 0) {
                if (i75 > this.D) {
                    return;
                }
                boolean z16 = this.M;
                if (!z16) {
                    Rect rect4 = this.I;
                    int i77 = rect4.left;
                    if (i75 > i77 - i69 && i75 < (i16 = rect4.right)) {
                        int i78 = i75 + i69;
                        if (i75 >= i77 || i75 + i69 <= i77) {
                            i77 = i75;
                        } else {
                            i78 = i75 + i69;
                        }
                        if (i75 >= i16 || i69 + i75 <= i16) {
                            i17 = i78;
                            i18 = i77;
                        } else {
                            i17 = i16;
                            i18 = i75;
                        }
                        i3 = i59 == -1 ? i19 : i59;
                        if (i19 >= i3 && i19 < this.f67327m + i3) {
                            paint = this.P;
                        } else {
                            paint = this.N;
                        }
                        Paint paint3 = paint;
                        int i79 = f67319a0[i19 % V];
                        int i85 = (this.E - i79) / 2;
                        b(canvas, i18, i85, i17, i85 + i79, 5.0f, paint3);
                        i59 = i3;
                    }
                }
                if (z16) {
                    Rect rect5 = this.I;
                    if (i75 > rect5.left - i69 && i75 < rect5.right) {
                        i3 = i59 == -1 ? i19 : i59;
                        Paint paint4 = this.N;
                        int i86 = f67319a0[i19 % V];
                        int i87 = (this.E - i86) / 2;
                        b(canvas, i75, i87, i69 + i75, i87 + i86, 5.0f, paint4);
                        i59 = i3;
                    }
                }
            }
            i19 = i67;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        this.D = super.getMeasuredWidth();
        int paddingTop = f67321c0 + super.getPaddingTop() + super.getPaddingBottom();
        this.E = paddingTop;
        setMeasuredDimension(this.D, paddingTop);
        this.C = (this.D - this.f67324f) / 2;
        int i17 = (this.E - f67321c0) / 2;
        int i18 = this.C;
        this.I = new Rect(i18, i17, this.f67324f + i18, f67321c0 + i17);
        a aVar = this.H;
        if (aVar != null) {
            aVar.h(this.C, this.f67324f);
        }
        if (QLog.isColorLevel()) {
            QLog.d("zivonchen", 2, "onMeasure() mViewWidth: " + this.D + ", mViewHeight = " + this.E + ", mVideoViewOffsetX = " + this.C + ", mMusicMaxWidth = " + this.f67325h);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.M = false;
            this.T = motionEvent.getX();
            a aVar = this.H;
            if (aVar != null) {
                aVar.g(this.f67325h, this.f67324f, this.f67326i);
            }
        } else if (action == 1) {
            this.M = false;
            super.invalidate();
            a aVar2 = this.H;
            if (aVar2 != null) {
                aVar2.k(this.f67325h, this.f67324f, this.f67326i);
            }
        } else if (action == 2) {
            this.M = true;
            float x16 = motionEvent.getX();
            if (Math.abs(x16 - this.T) < 3.0f) {
                return true;
            }
            float f16 = (this.T - x16) / (W + this.F);
            int round = Math.round(Math.abs(f16));
            if (f16 > 0.0f && round >= 1) {
                this.f67326i += (W + this.F) * round;
            } else if (f16 < 0.0f && round >= 1) {
                this.f67326i -= (W + this.F) * round;
            }
            if (round == 0) {
                return true;
            }
            if (this.f67326i <= 0) {
                this.f67326i = 0;
            }
            int i3 = this.f67326i;
            int i16 = this.f67325h;
            int i17 = this.f67324f;
            if (i3 >= i16 - i17) {
                this.f67326i = i16 - i17;
            }
            super.invalidate();
            a aVar3 = this.H;
            if (aVar3 != null) {
                aVar3.a(this.f67325h, this.f67324f, this.f67326i);
            }
            this.T = x16;
        }
        return false;
    }

    public void setOnSeekListener(a aVar) {
        this.H = aVar;
    }

    public void setPlayedPosition(int i3) {
        this.f67327m = i3;
        super.invalidate();
    }

    static {
        int[] iArr = {18, 14, 9, 12, 14, 18};
        U = iArr;
        int length = iArr.length;
        V = length;
        W = 0;
        f67319a0 = new int[length];
        f67320b0 = 0;
        f67321c0 = 0;
    }

    public void setDurations(int i3, int i16) {
        int i17 = (int) (i3 * 2.5f);
        this.f67322d = i17;
        int i18 = (int) (i16 * 2.5f);
        this.f67323e = i18;
        int i19 = W;
        int i26 = this.F;
        this.f67324f = (i19 * i17) + ((i17 - 1) * i26);
        this.f67325h = (i19 * i18) + ((i18 - 1) * i26);
    }
}
