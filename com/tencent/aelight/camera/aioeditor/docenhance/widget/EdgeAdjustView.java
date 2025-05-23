package com.tencent.aelight.camera.aioeditor.docenhance.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.R;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes32.dex */
public class EdgeAdjustView extends View {
    private Path C;
    private Paint D;
    private Paint E;
    private int F;
    private int G;
    private int H;
    private int I;
    private final RectF J;
    private final RectF K;
    private int L;
    private int M;
    private int N;
    private Drawable P;
    private Drawable Q;
    private float R;
    private float S;
    private Canvas T;
    private Bitmap U;
    private int V;
    private BitmapShader W;

    /* renamed from: a0, reason: collision with root package name */
    private Paint f67406a0;

    /* renamed from: b0, reason: collision with root package name */
    private Matrix f67407b0;

    /* renamed from: c0, reason: collision with root package name */
    private int f67408c0;

    /* renamed from: d, reason: collision with root package name */
    private final float[] f67409d;

    /* renamed from: d0, reason: collision with root package name */
    private float f67410d0;

    /* renamed from: e, reason: collision with root package name */
    private final float[] f67411e;

    /* renamed from: f, reason: collision with root package name */
    private int f67412f;

    /* renamed from: h, reason: collision with root package name */
    private a f67413h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f67414i;

    /* renamed from: m, reason: collision with root package name */
    private Bitmap f67415m;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface a {
        void a(boolean z16);

        boolean b(float[] fArr);

        void c(boolean z16);
    }

    public EdgeAdjustView(Context context) {
        this(context, null);
    }

    private void a() {
        if (this.f67415m == null || this.J.isEmpty()) {
            return;
        }
        if ((this.f67415m.getHeight() * 1.0f) / this.f67415m.getWidth() > (this.J.height() * 1.0f) / this.J.width()) {
            float width = (this.J.width() - (this.f67415m.getWidth() * (this.J.height() / this.f67415m.getHeight()))) / 2.0f;
            RectF rectF = this.K;
            RectF rectF2 = this.J;
            rectF.set(rectF2.left + width, rectF2.top, rectF2.right - width, rectF2.bottom);
            return;
        }
        float height = (this.J.height() - (this.f67415m.getHeight() * (this.J.width() / this.f67415m.getWidth()))) / 2.0f;
        RectF rectF3 = this.K;
        RectF rectF4 = this.J;
        rectF3.set(rectF4.left, rectF4.top + height, rectF4.right, rectF4.bottom - height);
    }

    private void b() {
        if (this.K.isEmpty()) {
            return;
        }
        for (int i3 = 0; i3 < 4; i3++) {
            float[] fArr = this.f67411e;
            int i16 = i3 * 2;
            RectF rectF = this.K;
            fArr[i16] = rectF.left + (rectF.width() * this.f67409d[i16]);
            float[] fArr2 = this.f67411e;
            int i17 = i16 + 1;
            RectF rectF2 = this.K;
            fArr2[i17] = rectF2.top + (rectF2.height() * this.f67409d[i17]);
        }
    }

    public float[] d() {
        return Arrays.copyOf(this.f67409d, 8);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Bitmap bitmap = this.U;
        if (bitmap != null) {
            bitmap.recycle();
            this.U = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f67414i) {
            this.E.setColor(this.M);
        } else {
            this.E.setColor(this.N);
        }
        if (this.f67412f != -1) {
            c(this.T);
            canvas.drawBitmap(this.U, 0.0f, 0.0f, (Paint) null);
            float[] fArr = this.f67411e;
            int i3 = this.f67412f;
            float f16 = fArr[i3 * 2];
            float f17 = fArr[(i3 * 2) + 1];
            float max = Math.max((f17 - this.f67408c0) - this.V, this.F - r4);
            this.f67407b0.reset();
            Matrix matrix = this.f67407b0;
            float f18 = this.f67410d0;
            matrix.postScale(f18, f18);
            Matrix matrix2 = this.f67407b0;
            float f19 = this.f67410d0;
            matrix2.postTranslate(f16 - (f16 * f19), max - (f17 * f19));
            this.W.setLocalMatrix(this.f67407b0);
            canvas.drawCircle(f16, max, this.V, this.f67406a0);
            this.E.setColor(-1);
            canvas.drawCircle(f16, max, this.V - 3, this.E);
            return;
        }
        c(canvas);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        this.J.set(0.0f, 0.0f, i3, i16);
        RectF rectF = this.J;
        rectF.top += this.F;
        rectF.bottom -= this.G;
        rectF.left += this.H;
        rectF.right -= this.I;
        a();
        b();
        Bitmap bitmap = this.U;
        if (bitmap != null) {
            bitmap.recycle();
        }
        this.U = Bitmap.createBitmap(i3, i16, Bitmap.Config.RGB_565);
        this.T = new Canvas(this.U);
        Bitmap bitmap2 = this.U;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap2, tileMode, tileMode);
        this.W = bitmapShader;
        this.f67406a0.setShader(bitmapShader);
        invalidate();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() > 1) {
            return true;
        }
        int actionMasked = motionEvent.getActionMasked();
        float x16 = motionEvent.getX();
        float y16 = motionEvent.getY();
        if (actionMasked == 0) {
            this.f67412f = -1;
            if (!this.K.isEmpty()) {
                float[] fArr = this.f67411e;
                if (f(fArr[0], fArr[1], x16, y16)) {
                    this.f67412f = 0;
                } else {
                    float[] fArr2 = this.f67411e;
                    if (f(fArr2[2], fArr2[3], x16, y16)) {
                        this.f67412f = 1;
                    } else {
                        float[] fArr3 = this.f67411e;
                        if (f(fArr3[4], fArr3[5], x16, y16)) {
                            this.f67412f = 2;
                        } else {
                            float[] fArr4 = this.f67411e;
                            if (f(fArr4[6], fArr4[7], x16, y16)) {
                                this.f67412f = 3;
                            }
                        }
                    }
                }
            }
            this.R = x16;
            this.S = y16;
        } else if (actionMasked != 1) {
            if (actionMasked == 2) {
                int i3 = this.f67412f;
                if (i3 != -1) {
                    this.f67411e[i3 * 2] = Math.min(Math.max(x16, this.K.left), this.K.right);
                    this.f67411e[(this.f67412f * 2) + 1] = Math.min(Math.max(y16, this.K.top), this.K.bottom);
                    float[] fArr5 = this.f67409d;
                    int i16 = this.f67412f;
                    int i17 = i16 * 2;
                    float f16 = this.f67411e[i16 * 2];
                    RectF rectF = this.K;
                    fArr5[i17] = (f16 - rectF.left) / rectF.width();
                    float[] fArr6 = this.f67409d;
                    int i18 = this.f67412f;
                    int i19 = (i18 * 2) + 1;
                    float f17 = this.f67411e[(i18 * 2) + 1];
                    RectF rectF2 = this.K;
                    fArr6[i19] = (f17 - rectF2.top) / rectF2.height();
                    a aVar = this.f67413h;
                    if (aVar != null) {
                        boolean b16 = aVar.b(this.f67409d);
                        this.f67414i = b16;
                        this.f67413h.c(b16);
                    }
                    invalidate();
                }
                this.R = x16;
                this.S = y16;
            }
        } else if (this.f67412f != -1) {
            a aVar2 = this.f67413h;
            if (aVar2 != null) {
                aVar2.a(this.f67414i);
            }
            this.f67412f = -1;
            invalidate();
        }
        return true;
    }

    public void setBitmap(Bitmap bitmap) {
        this.f67415m = bitmap;
        a();
        b();
        invalidate();
    }

    public void setInteractionListener(a aVar) {
        this.f67413h = aVar;
    }

    public EdgeAdjustView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f67409d = new float[8];
        this.f67411e = new float[8];
        this.f67412f = -1;
        this.f67414i = true;
        this.C = new Path();
        this.D = new Paint();
        this.E = new Paint();
        this.J = new RectF();
        this.K = new RectF();
        this.L = Integer.MIN_VALUE;
        this.M = -16725252;
        this.N = -42646;
        this.f67406a0 = new Paint();
        this.f67407b0 = new Matrix();
        this.f67410d0 = 1.5384616f;
        e();
    }

    private void c(Canvas canvas) {
        Drawable drawable;
        canvas.drawColor(-16777216);
        Bitmap bitmap = this.f67415m;
        if (bitmap != null && !bitmap.isRecycled()) {
            canvas.drawBitmap(this.f67415m, (Rect) null, this.K, (Paint) null);
        }
        canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null);
        canvas.drawColor(this.L);
        this.C.reset();
        Path path = this.C;
        float[] fArr = this.f67411e;
        path.moveTo(fArr[0], fArr[1]);
        Path path2 = this.C;
        float[] fArr2 = this.f67411e;
        path2.lineTo(fArr2[2], fArr2[3]);
        Path path3 = this.C;
        float[] fArr3 = this.f67411e;
        path3.lineTo(fArr3[4], fArr3[5]);
        Path path4 = this.C;
        float[] fArr4 = this.f67411e;
        path4.lineTo(fArr4[6], fArr4[7]);
        this.C.close();
        canvas.drawPath(this.C, this.D);
        canvas.drawPath(this.C, this.E);
        if (this.f67414i) {
            drawable = this.P;
        } else {
            drawable = this.Q;
        }
        if (drawable != null && drawable.getIntrinsicWidth() > 0) {
            float intrinsicWidth = drawable.getIntrinsicWidth() / 2.0f;
            for (int i3 = 0; i3 < 4; i3++) {
                if (i3 != this.f67412f) {
                    float[] fArr5 = this.f67411e;
                    int i16 = i3 * 2;
                    float f16 = fArr5[i16];
                    float f17 = fArr5[i16 + 1];
                    drawable.setBounds((int) (f16 - intrinsicWidth), (int) (f17 - intrinsicWidth), (int) (f16 + intrinsicWidth), (int) (f17 + intrinsicWidth));
                    drawable.draw(canvas);
                }
            }
        }
        canvas.restore();
    }

    private void e() {
        setLayerType(1, null);
        this.F = UIUtils.b(getContext(), 100.0f);
        this.G = UIUtils.b(getContext(), 17.5f);
        this.H = UIUtils.b(getContext(), 18.0f);
        this.I = UIUtils.b(getContext(), 18.0f);
        this.V = UIUtils.b(getContext(), 50.0f);
        this.f67408c0 = UIUtils.b(getContext(), 20.0f);
        this.P = getResources().getDrawable(R.drawable.ivy);
        this.Q = getResources().getDrawable(R.drawable.ivx);
        this.D.setAntiAlias(true);
        this.D.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.D.setStyle(Paint.Style.FILL);
        this.E.setAntiAlias(true);
        this.E.setStrokeWidth(3.0f);
        this.E.setStyle(Paint.Style.STROKE);
        this.f67406a0.setAntiAlias(true);
    }

    public void setAdjustPoints(float[] fArr) {
        if (fArr == null || fArr.length != 8) {
            return;
        }
        for (int i3 = 0; i3 < 8; i3++) {
            this.f67409d[i3] = Math.min(Math.max(0.0f, fArr[i3]), 1.0f);
        }
        b();
        invalidate();
    }

    private boolean f(float f16, float f17, float f18, float f19) {
        float f26 = f16 - f18;
        float f27 = f17 - f19;
        return Math.sqrt((double) ((f26 * f26) + (f27 * f27))) <= 100.0d;
    }
}
