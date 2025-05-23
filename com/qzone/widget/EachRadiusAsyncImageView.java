package com.qzone.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;

/* compiled from: P */
/* loaded from: classes37.dex */
public class EachRadiusAsyncImageView extends AsyncImageView {

    /* renamed from: d, reason: collision with root package name */
    private int f60210d;

    /* renamed from: e, reason: collision with root package name */
    private int f60211e;

    /* renamed from: f, reason: collision with root package name */
    private Path f60212f;

    /* renamed from: h, reason: collision with root package name */
    private float[] f60213h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f60214i;

    public EachRadiusAsyncImageView(Context context) {
        super(context);
        this.f60214i = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.widget.ExtendImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f60212f == null) {
            return;
        }
        canvas.save();
        if (this.f60214i) {
            canvas.clipPath(this.f60212f);
        }
        super.onDraw(canvas);
        canvas.restore();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.widget.ExtendImageView, android.view.View
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        int width = getWidth();
        int height = getHeight();
        if (width == this.f60211e && height == this.f60210d && this.f60212f != null) {
            return;
        }
        this.f60211e = width;
        this.f60210d = height;
        Path path = new Path();
        this.f60212f = path;
        if (!this.f60214i || this.f60213h == null) {
            return;
        }
        path.addRoundRect(new RectF(0.0f, 0.0f, this.f60211e, this.f60210d), this.f60213h, Path.Direction.CW);
    }

    public EachRadiusAsyncImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f60214i = false;
    }

    public EachRadiusAsyncImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f60214i = false;
    }

    public void setRadiusForEach(float f16, float f17, float f18, float f19) {
        if (f16 >= 0.0f && f17 >= 0.0f && f19 >= 0.0f && f18 >= 0.0f) {
            if (this.f60213h == null) {
                this.f60213h = new float[8];
            }
            float[] fArr = this.f60213h;
            fArr[1] = f16;
            fArr[0] = f16;
            fArr[3] = f17;
            fArr[2] = f17;
            fArr[5] = f18;
            fArr[4] = f18;
            fArr[7] = f19;
            fArr[6] = f19;
            this.f60214i = true;
            requestLayout();
            return;
        }
        this.f60214i = false;
        this.f60213h = null;
    }
}
