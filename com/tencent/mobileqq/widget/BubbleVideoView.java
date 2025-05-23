package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.util.VersionUtils;

/* compiled from: P */
/* loaded from: classes20.dex */
public class BubbleVideoView extends BubbleImageView {

    /* renamed from: t0, reason: collision with root package name */
    private Bitmap f315471t0;

    /* renamed from: u0, reason: collision with root package name */
    private boolean f315472u0;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface a {
    }

    public BubbleVideoView(Context context) {
        super(context);
    }

    @Override // com.tencent.mobileqq.widget.BubbleImageView
    protected void c() {
        String upperCase = DeviceInfoMonitor.getModel().toUpperCase();
        if (upperCase.contains("M821") || upperCase.contains("A0001")) {
            this.J = 2;
        }
    }

    @Override // com.tencent.mobileqq.widget.BubbleImageView, android.view.View
    public void draw(Canvas canvas) {
        n(canvas);
        super.draw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.BubbleImageView
    public void g(Canvas canvas) {
        if (o()) {
            Bitmap bitmap = this.f315471t0;
            if (bitmap != null && (bitmap.getWidth() != getWidth() || this.f315471t0.getHeight() != getHeight())) {
                this.f315471t0.recycle();
                this.f315471t0 = null;
            }
            if (this.f315471t0 == null) {
                try {
                    try {
                        try {
                            this.f315471t0 = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
                        } catch (OutOfMemoryError unused) {
                            this.f315471t0 = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_4444);
                        }
                    } catch (OutOfMemoryError unused2) {
                    }
                } catch (OutOfMemoryError unused3) {
                    this.f315471t0 = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_4444);
                }
                if (this.f315471t0 != null) {
                    Canvas canvas2 = new Canvas(this.f315471t0);
                    canvas2.setDensity(getResources().getDisplayMetrics().densityDpi);
                    Paint paint = new Paint(1);
                    paint.setColor(-16777216);
                    canvas2.drawPath(this.f315453c0, paint);
                    Bitmap bitmap2 = this.f315471t0;
                    if (bitmap2.getPixel(bitmap2.getWidth() >> 1, this.f315471t0.getHeight() >> 1) != -16777216) {
                        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT));
                        canvas2.drawRect(0.0f, 0.0f, this.f315471t0.getWidth(), this.f315471t0.getHeight(), paint);
                        this.W.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
                    }
                }
            }
            Bitmap bitmap3 = this.f315471t0;
            if (bitmap3 != null) {
                canvas.drawBitmap(bitmap3, 0.0f, 0.0f, this.W);
                return;
            }
            return;
        }
        super.g(canvas);
    }

    @Override // com.tencent.mobileqq.widget.BubbleImageView
    protected void init() {
        String[] split;
        this.f315468o0 = BubbleImageView.f315450s0;
        if (VersionUtils.isHoneycomb()) {
            this.J = 1;
        } else {
            this.J = 2;
        }
        c();
        this.f315456f0 = getResources();
        if (Build.VERSION.SDK_INT >= 28) {
            this.f315469p0 = true;
            String str = (String) com.tencent.mobileqq.config.am.s().x(462);
            if (str != null && str.length() > 0 && (split = str.split("\\|")) != null && split.length > 0) {
                String upperCase = DeviceInfoMonitor.getModel().toUpperCase();
                int length = split.length;
                int i3 = 0;
                while (true) {
                    if (i3 < length) {
                        String str2 = split[i3];
                        if (str2 != null && str2.length() > 0 && upperCase.contains(str2)) {
                            this.f315469p0 = false;
                            break;
                        }
                        i3++;
                    } else {
                        break;
                    }
                }
            }
        }
        int i16 = this.J;
        if (i16 == 1) {
            Paint paint = new Paint();
            this.W = paint;
            paint.setStyle(Paint.Style.FILL);
            this.W.setAntiAlias(true);
            this.W.setFilterBitmap(true);
            this.W.setColor(-16777216);
            if (this.f315469p0) {
                this.W.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT));
            } else {
                this.W.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            }
            this.f315453c0 = new Path();
            this.f315454d0 = new RectF();
            this.f315451a0 = new float[8];
            return;
        }
        if (i16 == 2) {
            Paint paint2 = new Paint();
            this.L = paint2;
            paint2.setAntiAlias(true);
            this.L.setFilterBitmap(true);
            this.U = new RectF();
            this.V = new RectF();
            this.f315453c0 = new Path();
            this.f315454d0 = new RectF();
            this.f315451a0 = new float[8];
        }
    }

    public boolean o() {
        return this.f315472u0;
    }

    public void setUseXfermodeBitmap(boolean z16) {
        this.f315472u0 = z16;
    }

    public BubbleVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BubbleVideoView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }

    private void n(Canvas canvas) {
    }

    public static void setDrawListener(a aVar) {
    }
}
