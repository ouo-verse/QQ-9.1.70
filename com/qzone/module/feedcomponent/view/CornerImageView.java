package com.qzone.module.feedcomponent.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.qzone.widget.AsyncImageView;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CornerImageView extends AsyncImageView {
    private Path mPath;
    private RectF mTmpRectF;
    private float[] radius;

    public CornerImageView(Context context) {
        super(context);
        this.radius = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        this.mTmpRectF = new RectF();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.widget.ExtendImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.mPath == null) {
            this.mPath = new Path();
        }
        int save = canvas.save();
        try {
            try {
                Path path = this.mPath;
                RectF rectF = this.mTmpRectF;
                rectF.set(0.0f, 0.0f, getWidth(), getHeight());
                path.reset();
                path.addRoundRect(rectF, this.radius, Path.Direction.CW);
                canvas.clipPath(path);
                super.onDraw(canvas);
            } catch (UnsupportedOperationException unused) {
                super.onDraw(canvas);
            }
        } finally {
            canvas.restoreToCount(save);
        }
    }

    public void setRadius(float[] fArr) {
        this.radius = fArr;
    }

    public CornerImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.radius = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        this.mTmpRectF = new RectF();
    }

    public CornerImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.radius = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        this.mTmpRectF = new RectF();
    }
}
