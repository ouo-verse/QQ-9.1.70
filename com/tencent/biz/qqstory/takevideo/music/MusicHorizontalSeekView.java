package com.tencent.biz.qqstory.takevideo.music;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.al;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes5.dex */
public class MusicHorizontalSeekView extends View implements View.OnTouchListener {
    protected static final int[] P;
    protected static final int Q;
    protected static int R;
    protected static int[] S;
    protected static int T;
    protected int C;
    protected int D;
    protected int E;
    protected a F;
    protected Rect G;
    protected int H;
    protected int I;
    protected boolean J;
    protected Paint K;
    protected Paint L;
    protected Paint M;
    float N;

    /* renamed from: d, reason: collision with root package name */
    protected int f94273d;

    /* renamed from: e, reason: collision with root package name */
    protected int f94274e;

    /* renamed from: f, reason: collision with root package name */
    protected int f94275f;

    /* renamed from: h, reason: collision with root package name */
    protected int f94276h;

    /* renamed from: i, reason: collision with root package name */
    protected int f94277i;

    /* renamed from: m, reason: collision with root package name */
    protected int f94278m;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface a {
        void a(int i3, int i16, int i17);

        void g(int i3, int i16, int i17);

        void h(int i3, int i16);

        void k(int i3, int i16, int i17);
    }

    static {
        int[] iArr = {6, 8, 10, 12, 12, 10, 8, 6};
        P = iArr;
        int length = iArr.length;
        Q = length;
        R = 0;
        S = new int[length];
        T = 0;
    }

    public MusicHorizontalSeekView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f94273d = 0;
        this.f94274e = 0;
        this.f94275f = 0;
        this.f94276h = 0;
        this.f94277i = 0;
        this.f94278m = 0;
        this.C = 0;
        this.D = 0;
        this.E = 0;
        this.F = null;
        this.G = null;
        this.H = 0;
        this.I = 0;
        this.J = false;
        this.K = null;
        this.L = null;
        this.M = null;
        this.N = 0.0f;
        this.H = (int) al.a(context, 2.0f);
        this.I = (int) al.a(context, 1.0f);
        R = (int) al.a(context, 10.0f);
        T = (int) al.a(context, 21.0f);
        for (int i3 = 0; i3 < Q; i3++) {
            S[i3] = (int) al.a(context, P[i3]);
        }
        Resources resources = context.getResources();
        Paint paint = new Paint();
        this.K = paint;
        paint.setAntiAlias(true);
        this.K.setColor(resources.getColor(R.color.f156970gg));
        Paint paint2 = new Paint();
        this.L = paint2;
        paint2.setAntiAlias(true);
        this.L.setColor(resources.getColor(R.color.f157855a34));
        Paint paint3 = new Paint();
        this.M = paint3;
        paint3.setAntiAlias(true);
        this.M.setColor(resources.getColor(R.color.a36));
        this.M.setStrokeWidth(this.I);
        super.setOnTouchListener(this);
    }

    public static void a(int i3, int i16) {
        if (i3 >= 30) {
            R = i16 / (i3 + 16);
        }
    }

    protected void b(Canvas canvas, int i3, int i16, int i17, Paint paint) {
        float f16 = i3;
        canvas.drawLine(f16, i16, f16, i17, paint);
    }

    public void c(int i3) {
        this.f94277i = (i3 * R) / 1000;
        setPlayedPosition(-1);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int i3;
        System.currentTimeMillis();
        this.K.setStrokeWidth(this.I);
        this.L.setStrokeWidth(this.I);
        int i16 = 0;
        int i17 = -1;
        while (i16 < this.f94274e) {
            int i18 = this.C;
            int i19 = this.f94277i;
            int i26 = i16 + 1;
            int i27 = (i18 - i19) + (R * i26);
            if (i27 > i18 + this.f94275f && i19 == this.f94276h) {
                break;
            }
            if (i27 >= 0) {
                if (i27 > this.D) {
                    break;
                }
                Paint paint = this.M;
                if (!this.J) {
                    Rect rect = this.G;
                    if (i27 > rect.left && i27 < rect.right) {
                        if (i17 == -1) {
                            i17 = i16;
                        }
                        paint = (i16 < i17 || i16 >= this.f94278m + i17) ? this.K : this.L;
                    }
                }
                int i28 = S[i16 % Q];
                int i29 = (this.E - i28) / 2;
                b(canvas, i27, i29, i29 + i28, paint);
            }
            i16 = i26;
        }
        if (!this.J && (i3 = this.f94278m) < this.f94273d) {
            if (i3 == -1) {
                this.K.setStrokeWidth(this.H);
                Rect rect2 = this.G;
                b(canvas, rect2.left, rect2.top, rect2.bottom, this.K);
                Rect rect3 = this.G;
                b(canvas, rect3.right, rect3.top, rect3.bottom, this.K);
            } else {
                this.L.setStrokeWidth(this.H);
                Rect rect4 = this.G;
                b(canvas, rect4.left, rect4.top, rect4.bottom, this.L);
                this.K.setStrokeWidth(this.H);
                Rect rect5 = this.G;
                b(canvas, rect5.right, rect5.top, rect5.bottom, this.K);
            }
        } else {
            this.L.setStrokeWidth(this.H);
            Rect rect6 = this.G;
            b(canvas, rect6.left, rect6.top, rect6.bottom, this.L);
            Rect rect7 = this.G;
            b(canvas, rect7.right, rect7.top, rect7.bottom, this.L);
        }
        QLog.isColorLevel();
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        this.D = super.getMeasuredWidth();
        int paddingTop = T + super.getPaddingTop() + super.getPaddingBottom();
        this.E = paddingTop;
        setMeasuredDimension(this.D, paddingTop);
        this.C = (this.D - this.f94275f) / 2;
        int i17 = (this.E - T) / 2;
        int i18 = this.C;
        this.G = new Rect(i18, i17, (this.f94273d * R) + i18, T + i17);
        a aVar = this.F;
        if (aVar != null) {
            aVar.h(this.C, this.f94275f);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    float x16 = motionEvent.getX();
                    if (Math.abs(x16 - this.N) < 2.0f) {
                        return true;
                    }
                    this.J = true;
                    float f16 = this.f94277i;
                    float f17 = this.N;
                    int i3 = (int) (f16 + ((f17 - x16) / 2.0f));
                    this.f94277i = i3;
                    if (x16 > f17) {
                        if (i3 <= R) {
                            this.f94277i = 0;
                            super.invalidate();
                            a aVar = this.F;
                            if (aVar != null) {
                                aVar.a(this.f94276h, this.f94275f, this.f94277i);
                            }
                            this.N = x16;
                            return false;
                        }
                    } else {
                        int i16 = this.f94276h;
                        int i17 = this.f94275f;
                        if (i3 >= i16 - i17) {
                            this.f94277i = i16 - i17;
                            super.invalidate();
                            a aVar2 = this.F;
                            if (aVar2 != null) {
                                aVar2.a(this.f94276h, this.f94275f, this.f94277i);
                            }
                            this.N = x16;
                            return false;
                        }
                    }
                    super.invalidate();
                    a aVar3 = this.F;
                    if (aVar3 != null) {
                        aVar3.a(this.f94276h, this.f94275f, this.f94277i);
                    }
                    this.N = x16;
                }
            } else {
                this.J = false;
                super.invalidate();
                a aVar4 = this.F;
                if (aVar4 != null) {
                    aVar4.k(this.f94276h, this.f94275f, this.f94277i);
                }
            }
        } else {
            this.J = false;
            this.N = motionEvent.getX();
            a aVar5 = this.F;
            if (aVar5 != null) {
                aVar5.g(this.f94276h, this.f94275f, this.f94277i);
            }
        }
        return false;
    }

    public void setDurations(int i3, int i16) {
        this.f94273d = i3;
        this.f94274e = i16;
        int i17 = R;
        this.f94275f = i3 * i17;
        this.f94276h = i17 * i16;
    }

    public void setOnSeekListener(a aVar) {
        this.F = aVar;
    }

    public void setPlayedPosition(int i3) {
        this.f94278m = i3;
        super.invalidate();
    }
}
