package com.tencent.mobileqq.activity.aio.zhitu;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import com.tencent.image.NativeGifImage;
import com.tencent.mobileqq.activity.aio.zhitu.g;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a extends NativeGifImage {

    /* renamed from: a, reason: collision with root package name */
    private g.a f180377a;

    /* renamed from: b, reason: collision with root package name */
    private Paint f180378b;

    /* renamed from: c, reason: collision with root package name */
    private Paint f180379c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f180380d;

    public a(File file, boolean z16, float f16) throws IOException {
        super(file, z16, false, 0, 0, f16);
        this.f180380d = false;
    }

    private void d(Canvas canvas, Rect rect) {
        if (QLog.isColorLevel() && !this.f180380d) {
            QLog.d("ZhituManager", 2, " dst rect is " + rect + " but bitmap is " + getWidth() + " / " + getHeight());
            this.f180380d = true;
        }
        float width = rect.width() / getWidth();
        if (Math.abs(width - 1.0f) < 0.01d) {
            if (this.f180378b == null) {
                g.a aVar = this.f180377a;
                this.f180378b = aVar.f180411c;
                this.f180379c = aVar.f180412d;
            }
            width = 1.0f;
        } else if (this.f180378b == null) {
            Paint paint = new Paint(this.f180377a.f180411c);
            this.f180378b = paint;
            paint.setTextSize(this.f180377a.f180411c.getTextSize() * width);
            if (this.f180377a.f180412d != null) {
                Paint paint2 = new Paint(this.f180377a.f180412d);
                this.f180379c = paint2;
                paint2.setTextSize(this.f180377a.f180412d.getTextSize() * width);
            }
        }
        int i3 = 0;
        if (this.f180377a.f180413e != null) {
            while (true) {
                g.a aVar2 = this.f180377a;
                PointF[] pointFArr = aVar2.f180413e;
                if (i3 < pointFArr.length) {
                    float f16 = rect.top;
                    PointF pointF = pointFArr[i3];
                    float f17 = f16 + (pointF.y * width);
                    Paint paint3 = this.f180379c;
                    if (paint3 != null) {
                        canvas.drawText(aVar2.f180410b[i3], pointF.x, f17, paint3);
                    }
                    g.a aVar3 = this.f180377a;
                    canvas.drawText(aVar3.f180410b[i3], aVar3.f180413e[i3].x, f17, this.f180378b);
                    i3++;
                } else {
                    return;
                }
            }
        } else {
            while (true) {
                g.a aVar4 = this.f180377a;
                float[] fArr = aVar4.f180409a;
                if (i3 < fArr.length) {
                    float f18 = rect.top + (fArr[i3] * width);
                    if (this.f180379c != null) {
                        canvas.drawText(aVar4.f180410b[i3], rect.exactCenterX(), f18, this.f180379c);
                    }
                    canvas.drawText(this.f180377a.f180410b[i3], rect.exactCenterX(), f18, this.f180378b);
                    i3++;
                } else {
                    return;
                }
            }
        }
    }

    public Bitmap a() {
        return this.mCurrentFrameBitmap;
    }

    public void b() {
        getNextFrame();
        applyNextFrame();
    }

    public void c(Canvas canvas) {
        Rect rect = new Rect(0, 0, canvas.getWidth(), canvas.getHeight());
        if (QLog.isColorLevel()) {
            QLog.d("ZhituManager", 2, "draw text to file dst rect is " + rect + " and bitmap is " + getWidth() + " / " + getHeight());
        }
        d(canvas, rect);
    }

    @Override // com.tencent.image.NativeGifImage, com.tencent.image.AbstractGifImage
    public void draw(Canvas canvas, Rect rect, Paint paint, boolean z16) {
        super.draw(canvas, rect, paint, z16);
        d(canvas, rect);
    }

    @Override // com.tencent.image.NativeGifImage
    public void drawFirstFrame(Canvas canvas, Rect rect, Paint paint) {
        super.drawFirstFrame(canvas, rect, paint);
        d(canvas, rect);
    }

    public int e() {
        return this.mMetaData[NativeGifImage.WIDTH_INDEX];
    }

    public void f(g.a aVar) {
        this.f180377a = aVar;
    }

    public int getCurrentFrameIndex() {
        return this.mCurrentFrameIndex;
    }

    public int getFrameCount() {
        return this.mMetaData[NativeGifImage.FRAME_COUNT_INDEX];
    }

    public int getFrameDelay() {
        return this.mMetaData[NativeGifImage.POST_INVALIDATION_TIME_INDEX];
    }
}
