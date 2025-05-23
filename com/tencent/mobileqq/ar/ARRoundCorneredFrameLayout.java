package com.tencent.mobileqq.ar;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ARRoundCorneredFrameLayout extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    public int f197344d;

    @TargetApi(11)
    public ARRoundCorneredFrameLayout(Context context) {
        super(context);
        this.f197344d = 6;
        setLayerType(1, null);
    }

    int a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.lbsroundCornerViewDefinedAttr);
        int i3 = obtainStyledAttributes.getInt(R.styleable.lbsroundCornerViewDefinedAttr_qqlbsArMapGuideRadius, 6);
        obtainStyledAttributes.recycle();
        return i3;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        Path path = new Path();
        path.moveTo(0.0f, this.f197344d);
        int i3 = this.f197344d;
        path.arcTo(new RectF(0.0f, 0.0f, i3 * 2, i3 * 2), -180.0f, 90.0f);
        path.lineTo(width - this.f197344d, 0.0f);
        int i16 = this.f197344d;
        float f16 = width;
        path.arcTo(new RectF(width - (i16 * 2), 0.0f, f16, i16 * 2), -90.0f, 90.0f);
        path.lineTo(f16, height - this.f197344d);
        int i17 = this.f197344d;
        float f17 = height;
        path.arcTo(new RectF(width - (i17 * 2), height - (i17 * 2), f16, f17), 0.0f, 90.0f);
        path.lineTo(this.f197344d, f17);
        int i18 = this.f197344d;
        path.arcTo(new RectF(0.0f, height - (i18 * 2), i18 * 2, f17), 90.0f, 90.0f);
        path.lineTo(0.0f, this.f197344d);
        path.close();
        canvas.clipPath(path);
        super.dispatchDraw(canvas);
    }

    @TargetApi(11)
    public ARRoundCorneredFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f197344d = 6;
        this.f197344d = BaseAIOUtils.f(a(context, attributeSet), context.getResources());
        setLayerType(1, null);
    }
}
