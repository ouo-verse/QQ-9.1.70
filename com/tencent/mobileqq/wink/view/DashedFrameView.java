package com.tencent.mobileqq.wink.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.util.Consumer;
import com.tencent.mobileqq.wink.editor.sticker.WinkStickerModel;
import com.tencent.videocut.model.SizeF;
import okio.ByteString;

/* compiled from: P */
/* loaded from: classes21.dex */
public class DashedFrameView extends View {

    /* renamed from: d, reason: collision with root package name */
    private Paint f326764d;

    /* renamed from: e, reason: collision with root package name */
    private RectF f326765e;

    /* renamed from: f, reason: collision with root package name */
    private WinkStickerModel f326766f;

    /* renamed from: h, reason: collision with root package name */
    public Consumer<RectF> f326767h;

    public DashedFrameView(Context context) {
        this(context, null);
    }

    private PointF b() {
        float[] fArr = {c(), d()};
        com.tencent.mobileqq.wink.editor.sticker.n.f(com.tencent.mobileqq.wink.editor.sticker.n.a(this.f326766f, this, false), new SizeF(getMeasuredWidth() * 1.0f, getMeasuredHeight() * 1.0f, ByteString.EMPTY)).mapPoints(fArr);
        return new PointF(fArr[0], fArr[1]);
    }

    private float c() {
        return ((this.f326766f.centerX + 1.0f) / 2.0f) * getMeasuredWidth();
    }

    private float d() {
        return (((-this.f326766f.centerY) + 1.0f) / 2.0f) * getMeasuredHeight();
    }

    private void e() {
        Paint paint = new Paint(1);
        this.f326764d = paint;
        paint.setStrokeWidth(com.tencent.mobileqq.util.x.c(getContext(), 1.0f));
        this.f326764d.setStyle(Paint.Style.STROKE);
        this.f326764d.setColor(-1);
        this.f326764d.setShadowLayer(2.0f, 0.0f, 1.0f, -16777216);
        this.f326764d.setPathEffect(new DashPathEffect(new float[]{com.tencent.mobileqq.util.x.c(getContext(), 5.0f), com.tencent.mobileqq.util.x.c(getContext(), 5.0f)}, 0.0f));
        this.f326765e = new RectF();
    }

    public void a(WinkStickerModel winkStickerModel) {
        this.f326766f = winkStickerModel;
        requestLayout();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        WinkStickerModel winkStickerModel = this.f326766f;
        if (winkStickerModel == null) {
            return;
        }
        WinkStickerFrameView.b(this, winkStickerModel, this.f326765e, null, null, null, Boolean.FALSE);
        PointF b16 = b();
        float f16 = b16.x;
        float f17 = b16.y;
        canvas.save();
        canvas.rotate(-this.f326766f.rotate, f16, f17);
        canvas.drawRect(this.f326765e, this.f326764d);
        canvas.restore();
        Consumer<RectF> consumer = this.f326767h;
        if (consumer != null) {
            consumer.accept(this.f326765e);
            this.f326767h = null;
        }
    }

    public DashedFrameView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DashedFrameView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f326767h = null;
        e();
    }
}
