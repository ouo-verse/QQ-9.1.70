package com.qzone.module.feedcomponent.ui.common;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Region;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/* compiled from: P */
/* loaded from: classes39.dex */
public class RoundedCornerRelativeLayout extends RelativeLayout {
    private boolean enableRoundedCorner;
    private Region mAreaRegion;
    private Path mClipPath;
    private RectF mLayer;
    private Paint mPaint;
    private float[] radii;

    public RoundedCornerRelativeLayout(Context context) {
        super(context);
        this.enableRoundedCorner = false;
        this.radii = new float[8];
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.enableRoundedCorner) {
            canvas.saveLayer(this.mLayer, null, 31);
            super.dispatchDraw(canvas);
            this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            this.mPaint.setColor(-1);
            this.mPaint.setStyle(Paint.Style.FILL);
            canvas.drawPath(this.mClipPath, this.mPaint);
            canvas.restore();
            return;
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (this.enableRoundedCorner) {
            canvas.save();
            canvas.clipPath(this.mClipPath);
            super.draw(canvas);
            canvas.restore();
            return;
        }
        super.draw(canvas);
    }

    public void enableRoundedCorner(boolean z16) {
        this.enableRoundedCorner = z16;
        this.mClipPath = new Path();
        this.mAreaRegion = new Region();
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setColor(-1);
        this.mPaint.setAntiAlias(true);
        this.radii = new float[]{12.0f, 12.0f, 12.0f, 12.0f, 12.0f, 12.0f, 12.0f, 12.0f};
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        if (this.enableRoundedCorner) {
            this.mLayer = new RectF(0.0f, 0.0f, i3, i16);
            RectF rectF = new RectF();
            rectF.left = getPaddingLeft();
            rectF.top = getPaddingTop();
            rectF.right = i3 - getPaddingRight();
            rectF.bottom = i16 - getPaddingBottom();
            this.mClipPath.reset();
            this.mClipPath.addRoundRect(rectF, this.radii, Path.Direction.CW);
            this.mAreaRegion.setPath(this.mClipPath, new Region((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom));
        }
    }

    public RoundedCornerRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.enableRoundedCorner = false;
        this.radii = new float[8];
    }

    public RoundedCornerRelativeLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.enableRoundedCorner = false;
        this.radii = new float[8];
    }
}
