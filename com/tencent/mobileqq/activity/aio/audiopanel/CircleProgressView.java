package com.tencent.mobileqq.activity.aio.audiopanel;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes10.dex */
public class CircleProgressView extends ImageView implements com.tencent.mvp.c {
    private int C;
    private int D;
    private int E;
    private int F;
    private int G;
    private boolean H;
    private h I;

    /* renamed from: d, reason: collision with root package name */
    private Paint f178251d;

    /* renamed from: e, reason: collision with root package name */
    private Bitmap f178252e;

    /* renamed from: f, reason: collision with root package name */
    private Matrix f178253f;

    /* renamed from: h, reason: collision with root package name */
    private RectF f178254h;

    /* renamed from: i, reason: collision with root package name */
    private Rect f178255i;

    /* renamed from: m, reason: collision with root package name */
    private int f178256m;

    public CircleProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f178253f = new Matrix();
        this.f178254h = new RectF();
        this.f178255i = new Rect();
        this.f178256m = 0;
        this.C = -1;
        this.D = 0;
        this.E = -9013368;
        this.F = 6;
        this.G = ScreenUtil.dip2px(9.0f);
        this.H = false;
        g(context);
    }

    private void g(Context context) {
        Paint paint = new Paint();
        this.f178251d = paint;
        paint.setAntiAlias(true);
    }

    @Override // com.tencent.mvp.c
    public com.tencent.mvp.b getPresenter() {
        return this.I;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00d3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007f  */
    @Override // android.widget.ImageView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onDraw(Canvas canvas) {
        Bitmap createBitmap;
        Bitmap bitmap;
        int i3;
        float f16;
        int i16;
        int width = getWidth();
        int height = getHeight();
        int saveCount = canvas.getSaveCount();
        canvas.save();
        Bitmap bitmap2 = this.f178252e;
        if (bitmap2 != null) {
            try {
                createBitmap = Bitmap.createBitmap(bitmap2.getWidth(), this.f178252e.getHeight(), Bitmap.Config.ARGB_8888);
            } catch (OutOfMemoryError unused) {
            }
            bitmap = this.f178252e;
            if (bitmap == null && createBitmap != null) {
                this.f178255i.set(0, 0, bitmap.getWidth(), this.f178252e.getHeight());
                this.f178251d.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
                this.f178254h.set(0.0f, 0.0f, width, height);
                int i17 = (this.f178256m * 360) / 100;
                Canvas canvas2 = new Canvas(createBitmap);
                canvas2.drawBitmap(this.f178252e, (Rect) null, this.f178255i, (Paint) null);
                canvas2.drawArc(this.f178254h, i17 - 90, 360 - i17, true, this.f178251d);
                canvas.drawBitmap(createBitmap, (Rect) null, this.f178255i, (Paint) null);
                createBitmap.recycle();
            } else {
                i3 = this.C;
                if (i3 <= 0) {
                    f16 = i3;
                } else {
                    f16 = 3.0f;
                }
                RectF rectF = this.f178254h;
                int i18 = this.G;
                rectF.set(i18 + f16, i18 + f16, (width - f16) - i18, (height - f16) - i18);
                this.f178251d.setStyle(Paint.Style.STROKE);
                this.f178251d.setStrokeWidth(this.F);
                i16 = this.D;
                if (i16 != 0) {
                    this.f178251d.setColor(i16);
                    canvas.drawOval(this.f178254h, this.f178251d);
                }
                this.f178251d.setColor(this.E);
                canvas.drawArc(this.f178254h, 270.0f, (this.f178256m * 360) / 100, false, this.f178251d);
            }
            canvas.restoreToCount(saveCount);
            if (this.H) {
                try {
                    com.tencent.mvp.e.a(this, "startPlayAnim");
                    this.H = false;
                } catch (Exception unused2) {
                    if (QLog.isColorLevel()) {
                        QLog.e("AIOAudioPanel", 2, "CircleProgressView startPlayAnimByType error e=" + toString());
                    }
                    this.H = false;
                }
            }
            super.onDraw(canvas);
        }
        createBitmap = null;
        bitmap = this.f178252e;
        if (bitmap == null) {
        }
        i3 = this.C;
        if (i3 <= 0) {
        }
        RectF rectF2 = this.f178254h;
        int i182 = this.G;
        rectF2.set(i182 + f16, i182 + f16, (width - f16) - i182, (height - f16) - i182);
        this.f178251d.setStyle(Paint.Style.STROKE);
        this.f178251d.setStrokeWidth(this.F);
        i16 = this.D;
        if (i16 != 0) {
        }
        this.f178251d.setColor(this.E);
        canvas.drawArc(this.f178254h, 270.0f, (this.f178256m * 360) / 100, false, this.f178251d);
        canvas.restoreToCount(saveCount);
        if (this.H) {
        }
        super.onDraw(canvas);
    }

    public void setAnimFlag(boolean z16) {
        this.H = z16;
    }

    public void setPresenter(com.tencent.mvp.b bVar) {
        if (bVar == null) {
            this.I = null;
        } else if (bVar instanceof h) {
            this.I = (h) bVar;
        }
    }

    public void setProgress(int i3) {
        this.f178256m = i3;
        invalidate();
    }

    public void setProgressBitmap(Bitmap bitmap) {
        this.f178252e = bitmap;
    }

    public void setRingBgColor(int i3) {
        this.D = i3;
    }

    public void setRingColor(int i3) {
        this.E = i3;
    }

    public void setRingWidth(int i3) {
        this.F = i3;
    }

    public void setStrokeWidth(int i3) {
        this.C = i3;
    }

    public CircleProgressView(Context context) {
        super(context);
        this.f178253f = new Matrix();
        this.f178254h = new RectF();
        this.f178255i = new Rect();
        this.f178256m = 0;
        this.C = -1;
        this.D = 0;
        this.E = -9013368;
        this.F = 6;
        this.G = ScreenUtil.dip2px(9.0f);
        this.H = false;
        g(context);
    }
}
