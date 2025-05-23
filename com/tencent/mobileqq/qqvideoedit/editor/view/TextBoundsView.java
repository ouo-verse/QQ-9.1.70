package com.tencent.mobileqq.qqvideoedit.editor.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.videocut.utils.e;

/* compiled from: P */
/* loaded from: classes17.dex */
public class TextBoundsView extends View {

    /* renamed from: d, reason: collision with root package name */
    private RectF f275849d;

    /* renamed from: e, reason: collision with root package name */
    private int f275850e;

    public TextBoundsView(Context context) {
        super(context);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f275849d == null) {
            return;
        }
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(this.f275850e);
        paint.setStyle(Paint.Style.STROKE);
        e eVar = e.f384236a;
        paint.setStrokeWidth(eVar.a(1.0f));
        paint.setPathEffect(new DashPathEffect(new float[]{eVar.a(4.0f), eVar.a(1.0f)}, 0.0f));
        RectF rectF = this.f275849d;
        float f16 = rectF.left;
        float f17 = rectF.top;
        canvas.drawLine(f16, f17, rectF.right, f17, paint);
        RectF rectF2 = this.f275849d;
        float f18 = rectF2.right;
        canvas.drawLine(f18, rectF2.top, f18, rectF2.bottom, paint);
        RectF rectF3 = this.f275849d;
        float f19 = rectF3.left;
        canvas.drawLine(f19, rectF3.top, f19, rectF3.bottom, paint);
        RectF rectF4 = this.f275849d;
        float f26 = rectF4.left;
        float f27 = rectF4.bottom;
        canvas.drawLine(f26, f27, rectF4.right, f27, paint);
    }

    public void setColor(int i3) {
        this.f275850e = i3;
    }

    public void setRect(RectF rectF) {
        this.f275849d = rectF;
    }

    public TextBoundsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
