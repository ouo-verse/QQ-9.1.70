package com.tencent.biz.qqstory.takevideo.view.widget.frameSelectBar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.util.x;
import hd0.c;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RangeSelectBar extends View {
    public static int S = 4;
    private int C;
    private int D;
    private float E;
    private int F;
    private int G;
    private Paint H;
    private Paint I;
    private boolean J;
    private boolean K;
    private int L;
    private Bitmap M;
    private Bitmap N;
    private a P;
    private int Q;
    private float R;

    /* renamed from: d, reason: collision with root package name */
    private int f94423d;

    /* renamed from: e, reason: collision with root package name */
    private int f94424e;

    /* renamed from: f, reason: collision with root package name */
    private int f94425f;

    /* renamed from: h, reason: collision with root package name */
    private int f94426h;

    /* renamed from: i, reason: collision with root package name */
    private int f94427i;

    /* renamed from: m, reason: collision with root package name */
    private int f94428m;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface a {
        void b(int i3, int i16);

        void c();
    }

    public RangeSelectBar(Context context) {
        super(context);
        this.J = false;
        this.K = false;
        this.Q = Color.rgb(32, 170, 239);
        d();
    }

    private void d() {
        this.L = x.c(getContext(), ScrollFrameSelectBar.T);
        this.f94428m = UIUtils.m(getContext());
        Paint paint = new Paint(1);
        this.H = paint;
        paint.setColor(this.Q);
        this.H.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.I = paint2;
        paint2.setColor(-16777216);
        this.I.setAlpha(80);
        this.I.setStyle(Paint.Style.FILL);
    }

    public int a() {
        return this.D;
    }

    public int b() {
        return this.L;
    }

    public int c() {
        return this.C;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i3 = this.C;
        int i16 = this.L;
        if (i3 > i16 * 2) {
            canvas.drawRect(i16, 0.0f, i3, this.f94425f, this.I);
        }
        int i17 = this.D;
        int i18 = this.G;
        if (i17 < i18 - this.L) {
            canvas.drawRect(i17, 0.0f, i18, this.f94425f, this.I);
        }
        canvas.drawBitmap(this.M, this.C - this.L, 0.0f, this.H);
        canvas.drawBitmap(this.N, this.D, 0.0f, this.H);
        canvas.drawRect(this.C, 0.0f, this.D, S, this.H);
        canvas.drawRect(this.C, r0 - S, this.D, this.f94425f, this.H);
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        this.f94423d = View.MeasureSpec.getSize(i3);
        this.f94424e = View.MeasureSpec.getSize(i16);
        super.onMeasure(i3, i16);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action == 3) {
                        c.a("Q.qqstory.frameWidget.RangeSelectBar", "ACTION_CANCEL");
                        if (!this.J && !this.K) {
                            this.J = false;
                            this.K = false;
                        } else {
                            this.J = false;
                            this.K = false;
                            return true;
                        }
                    }
                } else {
                    motionEvent.getX();
                    if (this.J) {
                        if (this.D - ((int) motionEvent.getX()) < this.f94427i) {
                            c.a("Q.qqstory.frameWidget.RangeSelectBar", "mStartIndex\u4e0d\u80fd\u518d\u622a\u53d6\u5c0f\u4e8e1s\u7684\u89c6\u9891");
                            this.C = this.D - this.f94427i;
                            invalidate();
                        } else if (motionEvent.getX() <= this.F) {
                            c.a("Q.qqstory.frameWidget.RangeSelectBar", "\u5411\u5de6\u8fb9\u8fb9\u6ed1\u52a8");
                            this.C = this.F;
                            invalidate();
                        } else {
                            this.C = (int) motionEvent.getX();
                            invalidate();
                        }
                    } else if (this.K) {
                        if (((int) motionEvent.getX()) - this.C < this.f94427i) {
                            c.a("Q.qqstory.frameWidget.RangeSelectBar", "mEndIndex\u4e0d\u80fd\u518d\u622a\u53d6\u5c0f\u4e8e1s\u7684\u89c6\u9891");
                            this.D = this.C + this.f94427i;
                            invalidate();
                        } else {
                            float x16 = motionEvent.getX();
                            int i3 = this.G;
                            if (x16 >= i3) {
                                this.D = i3;
                                c.a("Q.qqstory.frameWidget.RangeSelectBar", "\u5411\u53f3\u8fb9\u8fb9\u6ed1\u52a8");
                                invalidate();
                            } else {
                                this.D = (int) motionEvent.getX();
                                invalidate();
                            }
                        }
                    }
                    a aVar = this.P;
                    if (aVar != null) {
                        aVar.c();
                    }
                    return true;
                }
            } else {
                c.a("Q.qqstory.frameWidget.RangeSelectBar", "ACTION_UP");
                if (!this.J && !this.K) {
                    this.J = false;
                    this.K = false;
                } else {
                    this.J = false;
                    this.K = false;
                    a aVar2 = this.P;
                    if (aVar2 != null) {
                        aVar2.b(this.C - 20, this.D - 20);
                    }
                    return true;
                }
            }
        } else {
            float x17 = motionEvent.getX();
            float y16 = motionEvent.getY();
            this.R = x17;
            c.e("Q.qqstory.frameWidget.RangeSelectBar", "ACTION_DOWN x=%s,y=%s,mstart=%s,end=%s", Float.valueOf(x17), Float.valueOf(y16), Integer.valueOf(this.C), Integer.valueOf(this.D));
            int i16 = this.C;
            int i17 = this.L;
            if (x17 > (i16 - (i17 / 2)) - 40 && x17 < (i16 - (i17 / 2)) + 40) {
                this.J = true;
                return true;
            }
            int i18 = this.D;
            if (x17 > ((i17 / 2) + i18) - 40 && x17 < i18 + (i17 / 2) + 40) {
                this.K = true;
                return true;
            }
            c.a("Q.qqstory.frameWidget.RangeSelectBar", "\u6ca1\u6709\u89e6\u6478\u5230");
        }
        return false;
    }

    public void setEndIndex(int i3) {
        if (i3 - this.C < this.f94427i) {
            c.a("Q.qqstory.frameWidget.RangeSelectBar", "mEndIndex\u4e0d\u80fd\u518d\u622a\u53d6\u5c0f\u4e8e1s\u7684\u89c6\u9891");
            this.D = this.C + this.f94427i;
            return;
        }
        int i16 = this.G;
        if (i3 >= i16) {
            this.D = i16;
            c.a("Q.qqstory.frameWidget.RangeSelectBar", "\u5411\u53f3\u8fb9\u8fb9\u6ed1\u52a8");
        } else {
            this.D = i3;
        }
    }

    public void setFrameSize(int i3, int i16, int i17, float f16, float f17) {
        int i18 = this.L;
        if (i18 <= 0) {
            i18 = 100;
        }
        this.L = i18;
        this.f94425f = i3;
        this.f94426h = i16;
        float f18 = i16;
        this.f94427i = (int) (f18 / (i17 / f17));
        int i19 = i3 / 2;
        Bitmap f19 = UIUtils.f(getContext().getResources(), R.drawable.f162361gh4, this.L / 2, i19);
        Bitmap f26 = UIUtils.f(getContext().getResources(), R.drawable.gh6, this.L / 2, i19);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(this.Q);
        gradientDrawable.setCornerRadii(new float[]{5.0f, 5.0f, 0.0f, 0.0f, 0.0f, 0.0f, 5.0f, 5.0f});
        gradientDrawable.setStroke(x.c(getContext(), 3.0f), this.Q);
        gradientDrawable.setBounds(0, 0, this.L, i3);
        this.M = Bitmap.createBitmap(this.L, i3, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(this.M);
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        gradientDrawable.draw(canvas);
        if (f19 != null) {
            canvas.drawBitmap(f19, (this.L - f19.getWidth()) / 2, (i3 - f19.getHeight()) / 2, this.H);
        }
        Bitmap createBitmap = Bitmap.createBitmap(this.L, i3, Bitmap.Config.ARGB_8888);
        this.N = createBitmap;
        canvas.setBitmap(createBitmap);
        gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, 5.0f, 5.0f, 5.0f, 5.0f, 0.0f, 0.0f});
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        gradientDrawable.draw(canvas);
        if (f26 != null) {
            canvas.drawBitmap(f26, (this.L - f26.getWidth()) / 2, (i3 - f26.getHeight()) / 2, this.H);
        }
        int i26 = this.L;
        this.C = i26;
        int ceil = (int) (i26 + (Math.ceil(f16) * i16));
        this.D = ceil;
        this.E = this.L + (f16 * f18);
        this.F = this.C;
        this.G = ceil;
    }

    public void setRangeChangeListener(a aVar) {
        this.P = aVar;
    }

    public void setStartIndex(int i3) {
        if (this.D - i3 < this.f94427i) {
            c.a("Q.qqstory.frameWidget.RangeSelectBar", "mStartIndex\u4e0d\u80fd\u518d\u622a\u53d6\u5c0f\u4e8e1s\u7684\u89c6\u9891");
            this.C = this.D - this.f94427i;
        } else if (i3 <= this.F) {
            c.a("Q.qqstory.frameWidget.RangeSelectBar", "\u5411\u5de6\u8fb9\u8fb9\u6ed1\u52a8");
            this.C = this.F;
        } else {
            this.C = i3;
        }
    }

    public RangeSelectBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.J = false;
        this.K = false;
        this.Q = Color.rgb(32, 170, 239);
        d();
    }

    public RangeSelectBar(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.J = false;
        this.K = false;
        this.Q = Color.rgb(32, 170, 239);
        d();
    }
}
