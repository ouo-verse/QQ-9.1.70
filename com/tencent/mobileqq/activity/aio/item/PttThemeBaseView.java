package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes10.dex */
public abstract class PttThemeBaseView extends View {
    protected Xfermode C;
    protected PorterDuffXfermode D;
    protected Bitmap E;
    protected Canvas F;
    protected Bitmap G;
    protected Canvas H;
    protected int I;
    protected int J;
    protected Paint K;
    protected int L;
    protected int M;
    protected int N;
    protected boolean P;
    protected boolean Q;

    /* renamed from: d, reason: collision with root package name */
    protected int f179420d;

    /* renamed from: e, reason: collision with root package name */
    protected int f179421e;

    /* renamed from: f, reason: collision with root package name */
    protected int f179422f;

    /* renamed from: h, reason: collision with root package name */
    protected int f179423h;

    /* renamed from: i, reason: collision with root package name */
    protected RectF f179424i;

    /* renamed from: m, reason: collision with root package name */
    protected RectF f179425m;

    public PttThemeBaseView(Context context) {
        super(context);
        this.I = 1;
        this.J = 0;
        this.L = -1;
        this.M = -1;
        this.N = 8;
        this.P = false;
    }

    private void f() {
        this.H.drawColor(0, PorterDuff.Mode.CLEAR);
        int saveLayer = this.H.saveLayer(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), null, 31);
        c(this.H);
        d(this.H);
        this.H.restoreToCount(saveLayer);
    }

    private Bitmap h(Bitmap bitmap, int i3, int i16) {
        if (bitmap == null) {
            return Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_8888);
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width == i3 && height == i16) {
            return bitmap;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_8888);
        if (QLog.isColorLevel()) {
            QLog.d("PttBaseView", 2, "initBitmap change width =" + i3 + " height=" + i16 + " oldBitmapWidth =" + width + " oldBitmpHeight=" + height);
        }
        return createBitmap;
    }

    protected abstract boolean a();

    public void b() {
        Bitmap bitmap = this.E;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.E.recycle();
        }
        Bitmap bitmap2 = this.G;
        if (bitmap2 != null && !bitmap2.isRecycled()) {
            this.G.recycle();
        }
        this.E = null;
        this.G = null;
    }

    protected abstract void c(Canvas canvas);

    protected void d(Canvas canvas) {
        if (this.J != 0) {
            e();
            this.K.setXfermode(this.C);
            canvas.drawBitmap(this.E, this.f179420d, this.f179421e, this.K);
            this.K.setXfermode(null);
        }
    }

    protected void e() {
        if (this.F != null && this.E != null && this.P) {
            this.K.setXfermode(this.D);
            this.F.drawPaint(this.K);
            this.K.setXfermode(null);
            this.K.setColor(this.J);
            this.F.drawRect(this.f179425m, this.K);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(int i3) {
        Paint paint = new Paint();
        this.K = paint;
        paint.setAntiAlias(true);
        this.K.setStrokeWidth(this.I);
        this.C = new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP);
        this.D = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        this.N = Utils.n(i3, getContext().getResources());
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f179424i == null || this.P) {
            this.f179424i = new RectF(this.f179420d, this.f179421e, this.f179422f, this.f179423h);
        }
        if (a()) {
            if (this.P) {
                f();
                this.P = false;
            }
            canvas.save();
            canvas.drawBitmap(this.G, (Rect) null, this.f179425m, this.K);
            canvas.restore();
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        if (QLog.isColorLevel()) {
            QLog.d("PttBaseView", 2, "onLayout changed=" + z16 + " left=" + i3 + " top=" + i16 + " right=" + i17 + " bottom=" + i18);
        }
        if (z16) {
            this.L = ((getMeasuredWidth() - getPaddingRight()) + getPaddingLeft()) / 2;
            int measuredHeight = ((getMeasuredHeight() + getPaddingTop()) - getPaddingBottom()) / 2;
            this.M = measuredHeight;
            if (this.L < 0) {
                this.L = 0;
            }
            if (measuredHeight < 0) {
                this.M = 0;
            }
            int i19 = this.L;
            int i26 = this.N;
            this.f179420d = i19 - i26;
            this.f179422f = i19 + i26;
            int i27 = this.M;
            this.f179421e = i27 - i26;
            this.f179423h = i27 + i26;
        }
        boolean z17 = z16 | this.Q;
        this.Q = z17;
        if (z17) {
            this.E = h(this.E, getMeasuredWidth(), getMeasuredHeight());
            this.F = new Canvas(this.E);
            this.G = h(this.G, getMeasuredWidth(), getMeasuredHeight());
            this.H = new Canvas(this.G);
            this.f179425m = new RectF(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
            this.P = true;
            this.Q = false;
        }
    }

    public void setThemeColor(int i3) {
        if (this.J != i3) {
            if (QLog.isColorLevel()) {
                QLog.d("PttBaseView", 2, "setThemeColor " + Integer.toHexString(this.J));
            }
            this.J = i3;
            this.P = true;
            invalidate();
        }
    }

    public PttThemeBaseView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.I = 1;
        this.J = 0;
        this.L = -1;
        this.M = -1;
        this.N = 8;
        this.P = false;
    }

    public PttThemeBaseView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.I = 1;
        this.J = 0;
        this.L = -1;
        this.M = -1;
        this.N = 8;
        this.P = false;
    }
}
