package com.tencent.av.doodle;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
import com.tencent.mobileqq.R;

/* loaded from: classes32.dex */
public class ColorPickerView extends View {
    private float C;
    private float D;
    private float E;
    private float F;
    private float G;
    private float H;
    private float I;
    private boolean J;
    private boolean K;
    private float L;
    private Drawable M;
    private Drawable N;
    private Drawable P;
    private Drawable Q;
    private Drawable R;
    private Drawable S;
    private Drawable T;
    private int U;
    private int V;
    private a W;

    /* renamed from: d, reason: collision with root package name */
    private Paint f73574d;

    /* renamed from: e, reason: collision with root package name */
    private float f73575e;

    /* renamed from: f, reason: collision with root package name */
    private float f73576f;

    /* renamed from: h, reason: collision with root package name */
    private float f73577h;

    /* renamed from: i, reason: collision with root package name */
    private float f73578i;

    /* renamed from: m, reason: collision with root package name */
    private float f73579m;

    /* loaded from: classes32.dex */
    interface a {
        void onCancel();
    }

    public ColorPickerView(Context context) {
        super(context);
        this.J = false;
        this.K = false;
        this.L = -1.0f;
        this.M = null;
        this.N = null;
        this.P = null;
        this.Q = null;
        this.R = null;
        this.S = null;
        this.T = null;
        this.U = SupportMenu.CATEGORY_MASK;
        this.V = 1;
        this.W = null;
        a(context);
    }

    public void b() {
        float f16 = (this.L - (this.f73576f / 2.0f)) / this.C;
        Bitmap bitmap = ((BitmapDrawable) this.R).getBitmap();
        int pixel = ((BitmapDrawable) this.R).getBitmap().getPixel(bitmap.getWidth() / 2, e.c((int) (f16 * bitmap.getHeight()), 0, bitmap.getHeight() - 1));
        this.U = pixel;
        this.P.setColorFilter(pixel, PorterDuff.Mode.SRC_ATOP);
        this.f73574d.setColor(this.U);
        this.V = 1;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable drawable;
        Drawable drawable2;
        this.R.draw(canvas);
        float f16 = this.L;
        float f17 = this.f73576f;
        float b16 = e.b(f16, f17 / 2.0f, (f17 / 2.0f) + this.C);
        int i3 = this.V;
        if (i3 == 1) {
            drawable = this.M;
            drawable2 = this.P;
        } else if (i3 != 3) {
            drawable = this.M;
            drawable2 = this.P;
        } else {
            drawable = this.N;
            drawable2 = this.Q;
        }
        float f18 = this.D;
        float f19 = this.f73577h;
        drawable.setBounds((int) (f18 - (f19 / 2.0f)), (int) (b16 - (f19 / 2.0f)), (int) (f18 + (f19 / 2.0f)), (int) ((f19 / 2.0f) + b16));
        drawable.draw(canvas);
        if (this.V == 1) {
            canvas.drawCircle(this.D, b16, this.f73578i, this.f73574d);
        }
        if (this.J) {
            float f26 = this.f73576f;
            drawable2.setBounds(0, (int) (b16 - (f26 / 2.0f)), (int) this.f73575e, (int) (b16 + (f26 / 2.0f)));
            drawable2.draw(canvas);
        }
        this.T.draw(canvas);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0066, code lost:
    
        if (r14 != 2) goto L47;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        a aVar;
        float x16 = motionEvent.getX();
        float y16 = motionEvent.getY();
        float f16 = this.D;
        float f17 = f16 - (this.f73577h / 2.0f);
        float f18 = this.f73576f;
        float f19 = f18 / 2.0f;
        float f26 = this.C;
        boolean z16 = x16 > f17 && x16 < f17 + this.I && y16 > f19 && y16 < (f18 / 2.0f) + f26;
        float f27 = this.G;
        float f28 = f16 - (f27 / 2.0f);
        float f29 = f16 + (f27 / 2.0f);
        float f36 = this.E;
        float f37 = this.F;
        boolean z17 = x16 > f28 && x16 < f29 && y16 > (((f18 / 2.0f) + f26) + f36) + f37 && y16 < ((((f18 / 2.0f) + f26) + f36) + f37) + this.H;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.J = z16;
            if (z16) {
                this.L = y16;
                b();
            } else {
                this.K = z17;
                if (this.J) {
                    this.L = y16;
                    b();
                }
                this.K = z17;
            }
        } else if (action == 1) {
            if (this.J) {
                this.L = y16;
                b();
                DoodleSurfaceView doodleSurfaceView = (DoodleSurfaceView) ((View) getParent()).findViewById(R.id.g7u);
                if (doodleSurfaceView != null) {
                    doodleSurfaceView.setColor(this.U, this.V, this.L);
                }
            }
            if (this.K && (aVar = this.W) != null) {
                aVar.onCancel();
            }
            this.J = false;
            this.K = false;
        }
        return z16 || z17;
    }

    public void setOnCancelClickListener(a aVar) {
        this.W = aVar;
    }

    private void a(Context context) {
        setId(R.id.g7k);
        Resources resources = context.getResources();
        this.f73575e = resources.getDimension(R.dimen.a2x);
        this.f73576f = resources.getDimension(R.dimen.a2w);
        this.f73577h = resources.getDimension(R.dimen.a2u);
        this.f73578i = resources.getDimension(R.dimen.a2v);
        this.f73579m = resources.getDimension(R.dimen.f159329a30);
        this.C = resources.getDimension(R.dimen.a2y);
        this.D = resources.getDimension(R.dimen.f159330a31);
        this.G = resources.getDimension(R.dimen.cyv);
        this.H = resources.getDimension(R.dimen.cyv);
        this.E = resources.getDimension(R.dimen.a2z);
        this.F = resources.getDimension(R.dimen.cyu);
        this.I = resources.getDimension(R.dimen.f159331a32);
        this.M = resources.getDrawable(R.drawable.das);
        this.N = resources.getDrawable(R.drawable.dat);
        this.P = resources.getDrawable(R.drawable.dau);
        this.Q = resources.getDrawable(R.drawable.dav);
        this.S = resources.getDrawable(R.drawable.dax);
        this.R = resources.getDrawable(R.drawable.daw);
        this.T = resources.getDrawable(R.drawable.f161336n70);
        Paint paint = new Paint(1);
        this.f73574d = paint;
        paint.setStyle(Paint.Style.FILL);
        this.P.setColorFilter(this.U, PorterDuff.Mode.SRC_ATOP);
        Drawable drawable = this.R;
        float f16 = this.D;
        float f17 = this.f73579m;
        float f18 = this.f73576f;
        drawable.setBounds((int) (f16 - (f17 / 2.0f)), (int) (f18 / 2.0f), (int) (f16 + (f17 / 2.0f)), (int) ((f18 / 2.0f) + this.C));
        Drawable drawable2 = this.S;
        float f19 = this.D;
        float f26 = this.f73579m;
        float f27 = this.f73576f;
        float f28 = this.C;
        float f29 = this.E;
        drawable2.setBounds((int) (f19 - (f26 / 2.0f)), (int) ((f27 / 2.0f) + f28 + f29), (int) (f19 + (f26 / 2.0f)), (int) ((f27 / 2.0f) + f28 + f29 + f26));
        Drawable drawable3 = this.T;
        float f36 = this.D;
        float f37 = this.G;
        float f38 = this.f73576f;
        float f39 = this.C;
        float f46 = this.E;
        float f47 = this.F;
        drawable3.setBounds((int) (f36 - (f37 / 2.0f)), (int) ((f38 / 2.0f) + f39 + f46 + f47), (int) (f36 + (f37 / 2.0f)), (int) ((f38 / 2.0f) + f39 + f46 + f47 + this.H));
        DoodleLogic b16 = DoodleLogic.b();
        int i3 = b16.f73586e;
        this.U = i3;
        this.V = b16.f73587f;
        this.L = b16.f73588g;
        this.f73574d.setColor(i3);
    }

    public ColorPickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.J = false;
        this.K = false;
        this.L = -1.0f;
        this.M = null;
        this.N = null;
        this.P = null;
        this.Q = null;
        this.R = null;
        this.S = null;
        this.T = null;
        this.U = SupportMenu.CATEGORY_MASK;
        this.V = 1;
        this.W = null;
        a(context);
    }

    public ColorPickerView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.J = false;
        this.K = false;
        this.L = -1.0f;
        this.M = null;
        this.N = null;
        this.P = null;
        this.Q = null;
        this.R = null;
        this.S = null;
        this.T = null;
        this.U = SupportMenu.CATEGORY_MASK;
        this.V = 1;
        this.W = null;
        a(context);
    }
}
