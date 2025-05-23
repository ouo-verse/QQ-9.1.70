package com.tencent.sqshow.zootopia.nativeui.view.color.picker;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Shader;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.thumbplayer.report.reportv1.TPReportParams;

/* loaded from: classes34.dex */
public class RectColorPickerView extends View {
    private Shader C;
    private Shader D;
    private b E;
    private int F;
    private float G;
    private float H;
    private float I;
    private boolean J;
    private String K;
    private int L;
    private long M;
    private Rect N;
    private Rect P;
    private Point Q;
    private c R;

    /* renamed from: d, reason: collision with root package name */
    private int f371533d;

    /* renamed from: e, reason: collision with root package name */
    private int f371534e;

    /* renamed from: f, reason: collision with root package name */
    private int f371535f;

    /* renamed from: h, reason: collision with root package name */
    private int f371536h;

    /* renamed from: i, reason: collision with root package name */
    private Paint f371537i;

    /* renamed from: m, reason: collision with root package name */
    private Paint f371538m;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes34.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        public Canvas f371539a;

        /* renamed from: b, reason: collision with root package name */
        public Bitmap f371540b;

        /* renamed from: c, reason: collision with root package name */
        public float f371541c;

        b() {
        }
    }

    /* loaded from: classes34.dex */
    public interface c {
        void a(int i3, boolean z16);
    }

    public RectColorPickerView(Context context) {
        this(context, null);
    }

    private void a(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(new TypedValue().data, new int[]{R.attr.textColorSecondary});
        if (this.L == -4342339) {
            this.L = obtainStyledAttributes.getColor(0, -4342339);
        }
        obtainStyledAttributes.recycle();
    }

    private void b(Canvas canvas) {
        Rect rect = this.P;
        if (this.C == null) {
            int i3 = rect.left;
            this.C = new LinearGradient(i3, rect.top, i3, rect.bottom, -1, -16777216, Shader.TileMode.CLAMP);
        }
        b bVar = this.E;
        if (bVar == null || bVar.f371541c != this.G) {
            if (bVar == null) {
                this.E = new b();
            }
            b bVar2 = this.E;
            if (bVar2.f371540b == null) {
                bVar2.f371540b = Bitmap.createBitmap(rect.width(), rect.height(), Bitmap.Config.ARGB_8888);
            }
            b bVar3 = this.E;
            if (bVar3.f371539a == null) {
                bVar3.f371539a = new Canvas(this.E.f371540b);
            }
            int HSVToColor = Color.HSVToColor(new float[]{this.G, 1.0f, 1.0f});
            float f16 = rect.left;
            int i16 = rect.top;
            this.D = new LinearGradient(f16, i16, rect.right, i16, -1, HSVToColor, Shader.TileMode.CLAMP);
            this.f371537i.setShader(new ComposeShader(this.C, this.D, PorterDuff.Mode.MULTIPLY));
            this.E.f371539a.drawRect(0.0f, 0.0f, r1.f371540b.getWidth(), this.E.f371540b.getHeight(), this.f371537i);
            this.E.f371541c = this.G;
        }
        canvas.drawBitmap(this.E.f371540b, (Rect) null, rect, (Paint) null);
        Point h16 = h(this.H, this.I);
        this.f371538m.setColor(-2236963);
        canvas.drawCircle(h16.x, h16.y, this.f371536h, this.f371538m);
    }

    private void e() {
        this.f371537i = new Paint();
        Paint paint = new Paint();
        this.f371538m = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.f371538m.setStrokeWidth(ViewUtils.dpToPx(2.0f));
        this.f371538m.setAntiAlias(true);
    }

    private boolean f(MotionEvent motionEvent) {
        Point point = this.Q;
        if (point == null) {
            return false;
        }
        if (!this.P.contains(point.x, point.y)) {
            return false;
        }
        float[] g16 = g(motionEvent.getX(), motionEvent.getY());
        this.H = g16[0];
        this.I = g16[1];
        return true;
    }

    private float[] g(float f16, float f17) {
        Rect rect = this.P;
        float[] fArr = new float[2];
        float width = rect.width();
        float height = rect.height();
        int i3 = rect.left;
        float f18 = f16 < ((float) i3) ? 0.0f : f16 > ((float) rect.right) ? width : f16 - i3;
        int i16 = rect.top;
        float f19 = f17 >= ((float) i16) ? f17 > ((float) rect.bottom) ? height : f17 - i16 : 0.0f;
        fArr[0] = (1.0f / width) * f18;
        fArr[1] = 1.0f - ((1.0f / height) * f19);
        return fArr;
    }

    private Point h(float f16, float f17) {
        Rect rect = this.P;
        float height = rect.height();
        float width = rect.width();
        Point point = new Point();
        point.x = (int) ((f16 * width) + rect.left);
        point.y = (int) (((1.0f - f17) * height) + rect.top);
        return point;
    }

    private void i() {
        Rect rect = this.N;
        int i3 = rect.left;
        int i16 = rect.top;
        int i17 = rect.bottom;
        int i18 = rect.right;
        int i19 = this.f371535f;
        int i26 = (i18 - i19) - this.f371533d;
        if (this.J) {
            i17 -= this.f371534e + i19;
        }
        this.P = new Rect(i3, i16, i26, i17);
    }

    public int c() {
        return Color.HSVToColor(this.F, new float[]{this.G, this.H, this.I});
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.N.width() <= 0 || this.N.height() <= 0) {
            return;
        }
        b(canvas);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0058, code lost:
    
        if (r0 != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0087, code lost:
    
        if (r1 > r6) goto L39;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onMeasure(int i3, int i16) {
        int i17;
        int mode = View.MeasureSpec.getMode(i3);
        int mode2 = View.MeasureSpec.getMode(i16);
        int size = (View.MeasureSpec.getSize(i3) - getPaddingLeft()) - getPaddingRight();
        int size2 = (View.MeasureSpec.getSize(i16) - getPaddingBottom()) - getPaddingTop();
        if (mode != 1073741824 && mode2 != 1073741824) {
            int i18 = this.f371535f;
            int i19 = this.f371533d;
            i17 = size2 + i18 + i19;
            int i26 = (size - i18) - i19;
            if (this.J) {
                int i27 = this.f371534e;
                i17 -= i18 + i27;
                i26 += i18 + i27;
            }
            boolean z16 = i17 <= size;
            boolean z17 = i26 <= size2;
            if (!z16 || !z17) {
                if (z17 || !z16) {
                    if (!z16) {
                    }
                }
                size = i17;
            }
            size2 = i26;
        } else if (mode == 1073741824 && mode2 != 1073741824) {
            int i28 = this.f371535f;
            int i29 = (size - i28) - this.f371533d;
            if (this.J) {
                i29 += i28 + this.f371534e;
            }
            if (i29 <= size2) {
                size2 = i29;
            }
        } else if (mode2 == 1073741824 && mode != 1073741824) {
            int i36 = this.f371535f;
            i17 = size2 + i36 + this.f371533d;
            if (this.J) {
                i17 -= i36 + this.f371534e;
            }
        }
        setMeasuredDimension(size + getPaddingLeft() + getPaddingRight(), size2 + getPaddingTop() + getPaddingBottom());
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.F = bundle.getInt(com.tencent.luggage.wxa.c8.c.f123400v);
            this.G = bundle.getFloat("hue");
            this.H = bundle.getFloat("sat");
            this.I = bundle.getFloat(TPReportParams.JSON_KEY_VAL);
            this.J = bundle.getBoolean("show_alpha");
            this.K = bundle.getString("alpha_text");
            parcelable = bundle.getParcelable("instanceState");
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putInt(com.tencent.luggage.wxa.c8.c.f123400v, this.F);
        bundle.putFloat("hue", this.G);
        bundle.putFloat("sat", this.H);
        bundle.putFloat(TPReportParams.JSON_KEY_VAL, this.I);
        bundle.putBoolean("show_alpha", this.J);
        bundle.putString("alpha_text", this.K);
        return bundle;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        Rect rect = new Rect();
        this.N = rect;
        rect.left = getPaddingLeft();
        this.N.right = i3 - getPaddingRight();
        this.N.top = getPaddingTop();
        this.N.bottom = i16 - getPaddingBottom();
        this.C = null;
        this.D = null;
        this.E = null;
        i();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x004d  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean f16;
        boolean z16;
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1) {
                f16 = f(motionEvent);
                this.Q = null;
                z16 = true;
            } else if (action != 2) {
                f16 = false;
                z16 = false;
            } else {
                f16 = f(motionEvent) && ca4.a.f30527a.a(this.M);
                if (f16) {
                    this.M = System.currentTimeMillis();
                }
            }
            if (!f16) {
                c cVar = this.R;
                if (cVar != null) {
                    cVar.a(Color.HSVToColor(new float[]{this.G, this.H, this.I}), z16);
                }
                invalidate();
                return true;
            }
            invalidate();
            return super.onTouchEvent(motionEvent);
        }
        this.Q = new Point((int) motionEvent.getX(), (int) motionEvent.getY());
        f16 = f(motionEvent);
        z16 = false;
        if (!f16) {
        }
    }

    public void setColor(int i3) {
        setColor(i3, false);
    }

    public void setHue(float f16, boolean z16, boolean z17) {
        this.G = f16;
        c cVar = this.R;
        if (cVar != null && z16) {
            cVar.a(Color.HSVToColor(new float[]{f16, this.H, this.I}), z17);
        }
        invalidate();
    }

    public void setOnColorChangedListener(c cVar) {
        this.R = cVar;
    }

    public RectColorPickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setColor(int i3, boolean z16) {
        c cVar;
        int alpha = Color.alpha(i3);
        float[] fArr = new float[3];
        Color.RGBToHSV(Color.red(i3), Color.green(i3), Color.blue(i3), fArr);
        this.F = alpha;
        float f16 = fArr[0];
        this.G = f16;
        float f17 = fArr[1];
        this.H = f17;
        float f18 = fArr[2];
        this.I = f18;
        if (z16 && (cVar = this.R) != null) {
            cVar.a(Color.HSVToColor(new float[]{f16, f17, f18}), false);
        }
        invalidate();
    }

    public RectColorPickerView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.F = 255;
        this.G = 360.0f;
        this.H = 0.0f;
        this.I = 0.0f;
        this.J = true;
        this.K = null;
        this.L = -4342339;
        this.M = 0L;
        this.Q = null;
        d(context, attributeSet);
    }

    private void d(Context context, AttributeSet attributeSet) {
        this.L = -4342339;
        a(context);
        this.f371533d = ViewUtils.dpToPx(0.0f);
        this.f371534e = ViewUtils.dpToPx(20.0f);
        this.f371535f = ViewUtils.dpToPx(0.0f);
        this.f371536h = ViewUtils.dpToPx(10.0f);
        e();
        setFocusable(true);
        setFocusableInTouchMode(true);
    }
}
