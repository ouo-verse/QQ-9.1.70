package com.qzone.module.feedcomponent.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import com.qzone.widget.AsyncImageView;

/* compiled from: P */
/* loaded from: classes39.dex */
public class RoundedTouchFlipView extends AsyncImageView {
    private Paint mBitmapPaint;
    private int mCenterX;
    private int mCenterY;
    private Matrix mMatrix;
    private int mRadius;
    private int mWidth;

    /* renamed from: p, reason: collision with root package name */
    private Path f48760p;

    public RoundedTouchFlipView(Context context) {
        super(context);
        this.f48760p = new Path();
        init();
    }

    public int getRadius() {
        return this.mRadius;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.widget.ExtendImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (getDrawable() == null) {
            return;
        }
        this.f48760p.reset();
        this.f48760p.addCircle(this.mCenterX, this.mCenterY, this.mRadius, Path.Direction.CCW);
        canvas.clipPath(this.f48760p);
        super.onDraw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.widget.ExtendImageView, android.widget.ImageView, android.view.View
    public void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        this.mWidth = Math.min(getMeasuredWidth(), getMeasuredHeight());
    }

    public void setCenterPostion(int i3, int i16) {
        this.mCenterX = i3;
        this.mCenterY = i16;
    }

    public void setRadius(int i3) {
        this.mRadius = i3;
    }

    private void init() {
        this.mRadius = 0;
    }

    public RoundedTouchFlipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f48760p = new Path();
        init();
    }

    public RoundedTouchFlipView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f48760p = new Path();
        init();
    }
}
