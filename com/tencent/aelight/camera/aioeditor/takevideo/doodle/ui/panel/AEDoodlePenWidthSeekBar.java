package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.R;

/* loaded from: classes32.dex */
public class AEDoodlePenWidthSeekBar extends View {
    private int C;
    private int D;
    private int E;
    private RectF F;
    private RectF G;
    private Paint H;
    private float I;
    private float J;
    private boolean K;
    private a L;
    private Runnable M;

    /* renamed from: d, reason: collision with root package name */
    private float f68582d;

    /* renamed from: e, reason: collision with root package name */
    private Bitmap f68583e;

    /* renamed from: f, reason: collision with root package name */
    private Bitmap f68584f;

    /* renamed from: h, reason: collision with root package name */
    private int f68585h;

    /* renamed from: i, reason: collision with root package name */
    private int f68586i;

    /* renamed from: m, reason: collision with root package name */
    private int f68587m;

    /* loaded from: classes32.dex */
    public interface a {
        void a(float f16);
    }

    public AEDoodlePenWidthSeekBar(Context context) {
        super(context);
        this.f68582d = 0.5f;
        this.D = 0;
        this.F = new RectF();
        this.G = new RectF();
        this.M = new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.AEDoodlePenWidthSeekBar.1
            @Override // java.lang.Runnable
            public void run() {
                AEDoodlePenWidthSeekBar aEDoodlePenWidthSeekBar = AEDoodlePenWidthSeekBar.this;
                aEDoodlePenWidthSeekBar.D = aEDoodlePenWidthSeekBar.E;
                AEDoodlePenWidthSeekBar.this.invalidate();
            }
        };
        g();
    }

    private void c() {
        getHandler().removeCallbacks(this.M);
    }

    private void d() {
        getHandler().postDelayed(this.M, 3000L);
    }

    public static int e(Context context, float f16) {
        return (int) ((f16 * f(context)) + 0.5f);
    }

    private void g() {
        Resources resources = getResources();
        this.f68583e = BitmapFactory.decodeResource(resources, R.drawable.mji);
        this.f68584f = BitmapFactory.decodeResource(resources, R.drawable.mjj);
        this.f68585h = e(getContext(), 21.25f);
        this.f68586i = e(getContext(), 15.5f);
        this.f68587m = e(getContext(), 270.0f);
        this.C = e(getContext(), 3.0f);
        int i3 = -e(getContext(), 18.0f);
        this.E = i3;
        this.D = i3;
        Paint paint = new Paint();
        this.H = paint;
        paint.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(this.D, 0.0f);
        int measuredHeight = getMeasuredHeight();
        float measuredWidth = getMeasuredWidth() / 2;
        float f16 = this.f68586i / 2;
        int i3 = this.f68585h;
        int i16 = this.C;
        this.F.set(measuredWidth - f16, i3 - i16, measuredWidth + f16, (measuredHeight - i3) + i16);
        canvas.drawBitmap(this.f68583e, (Rect) null, this.F, this.H);
        int i17 = this.f68585h;
        float f17 = ((measuredHeight - i17) - i17) * (1.0f - this.f68582d);
        RectF rectF = this.G;
        float f18 = (i17 + f17) - i17;
        float measuredWidth2 = getMeasuredWidth();
        int i18 = this.f68585h;
        rectF.set(0.0f, f18, measuredWidth2, i18 + f17 + i18);
        canvas.drawBitmap(this.f68584f, (Rect) null, this.G, this.H);
        canvas.restore();
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        int i17 = this.f68585h;
        int i18 = i17 + i17;
        int i19 = this.f68587m;
        int i26 = this.C;
        setMeasuredDimension(i18, ((i19 - i26) - i26) + i18);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0047  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float f16;
        if (!isEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.I = motionEvent.getX();
            float y16 = motionEvent.getY();
            this.J = y16;
            if (this.G.contains(this.I, y16)) {
                this.K = true;
            }
            c();
            if (this.D != 0) {
                this.D = 0;
                invalidate();
            }
        } else if (action == 1) {
            this.K = false;
            d();
        } else if (action == 2) {
            if (this.K) {
                float y17 = motionEvent.getY() - this.J;
                float centerY = this.G.centerY();
                int measuredHeight = getMeasuredHeight();
                float f17 = centerY + y17;
                int i3 = this.f68585h;
                if (f17 < i3) {
                    f16 = i3;
                } else {
                    if (f17 > measuredHeight - i3) {
                        f16 = measuredHeight - i3;
                    }
                    if (y17 != 0.0f) {
                        RectF rectF = this.G;
                        rectF.top += y17;
                        rectF.bottom += y17;
                        float centerY2 = 1.0f - ((rectF.centerY() - this.f68585h) / ((measuredHeight - r1) - r1));
                        this.f68582d = centerY2;
                        a aVar = this.L;
                        if (aVar != null) {
                            aVar.a(centerY2);
                        }
                        invalidate();
                    }
                }
                y17 = f16 - centerY;
                if (y17 != 0.0f) {
                }
            }
            this.J = motionEvent.getY();
        }
        return true;
    }

    public void setOnSeekBarChangeListener(a aVar) {
        this.L = aVar;
    }

    public static float f(Context context) {
        if (context == null) {
            return 0.0f;
        }
        return context.getResources().getDisplayMetrics().density;
    }

    public AEDoodlePenWidthSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f68582d = 0.5f;
        this.D = 0;
        this.F = new RectF();
        this.G = new RectF();
        this.M = new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.AEDoodlePenWidthSeekBar.1
            @Override // java.lang.Runnable
            public void run() {
                AEDoodlePenWidthSeekBar aEDoodlePenWidthSeekBar = AEDoodlePenWidthSeekBar.this;
                aEDoodlePenWidthSeekBar.D = aEDoodlePenWidthSeekBar.E;
                AEDoodlePenWidthSeekBar.this.invalidate();
            }
        };
        g();
    }

    public void setProgress(float f16) {
        if (f16 < 0.0f || f16 > 1.0f) {
            return;
        }
        this.f68582d = f16;
        if (Looper.getMainLooper() == Looper.myLooper()) {
            invalidate();
        } else {
            postInvalidate();
        }
    }
}
