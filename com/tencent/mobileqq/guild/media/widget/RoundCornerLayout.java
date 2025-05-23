package com.tencent.mobileqq.guild.media.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.utils.ViewUtils;

/* compiled from: P */
/* loaded from: classes14.dex */
public class RoundCornerLayout extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name */
    private final Paint f229798d;

    /* renamed from: e, reason: collision with root package name */
    private float[] f229799e;

    public RoundCornerLayout(Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        Path path = new Path();
        path.addRoundRect(new RectF(getPaddingLeft(), getPaddingTop(), width - getPaddingRight(), height - getPaddingBottom()), this.f229799e, Path.Direction.CW);
        float f16 = width;
        float f17 = height;
        canvas.saveLayer(new RectF(0.0f, 0.0f, f16, f17), null, 31);
        super.dispatchDraw(canvas);
        if (Build.VERSION.SDK_INT <= 27) {
            this.f229798d.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            canvas.drawPath(path, this.f229798d);
        } else {
            this.f229798d.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
            Path path2 = new Path();
            path2.addRect(0.0f, 0.0f, f16, f17, Path.Direction.CW);
            path2.op(path, Path.Op.DIFFERENCE);
            canvas.drawPath(path2, this.f229798d);
        }
        canvas.restore();
    }

    public void setRadius(float f16, float f17, float f18, float f19) {
        this.f229799e = new float[]{f16, f16, f17, f17, f18, f18, f19, f19};
    }

    public RoundCornerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundCornerLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Paint paint = new Paint();
        this.f229798d = paint;
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, up1.a.O8);
        int i16 = obtainStyledAttributes.getInt(up1.a.Q8, 0);
        int i17 = obtainStyledAttributes.getInt(up1.a.P8, 0);
        float f16 = i16;
        float f17 = obtainStyledAttributes.getInt(up1.a.S8, 0);
        float f18 = obtainStyledAttributes.getInt(up1.a.R8, 0);
        float f19 = i17;
        this.f229799e = new float[]{ViewUtils.dip2px(f16), ViewUtils.dip2px(f16), ViewUtils.dip2px(f17), ViewUtils.dip2px(f17), ViewUtils.dip2px(f18), ViewUtils.dip2px(f18), ViewUtils.dip2px(f19), ViewUtils.dip2px(f19)};
        obtainStyledAttributes.recycle();
    }
}
