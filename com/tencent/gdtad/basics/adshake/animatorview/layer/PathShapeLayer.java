package com.tencent.gdtad.basics.adshake.animatorview.layer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;

/* loaded from: classes6.dex */
public class PathShapeLayer extends AnimatorLayer {
    protected Path mPath;

    public PathShapeLayer() {
        this(null);
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorLayer
    public void draw(Canvas canvas) {
        if (this.mPath == null) {
            return;
        }
        this.mPaint.setAlpha(this.mAlpha);
        if (this.mMatrixChanged) {
            canvas.setMatrix(getMatrix());
            drawPath(canvas);
            canvas.setMatrix(null);
            return;
        }
        drawPath(canvas);
    }

    protected void drawPath(Canvas canvas) {
        canvas.drawPath(this.mPath, this.mPaint);
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorLayer
    public boolean isMatrixNeedPreTranslate() {
        return false;
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorLayer, com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorAction
    public void postTranslate(float f16, float f17) {
        Path path = this.mPath;
        if (path != null) {
            path.offset(f16 - getDistanceX(), f17 - getDistanceY());
        }
        super.postTranslate(f16, f17);
    }

    public void setColor(int i3) {
        this.mPaint.setColor(i3);
    }

    public void setPath(Path path) {
        this.mPath = path;
    }

    public void setShader(Shader shader) {
        if (shader != null) {
            this.mPaint.setShader(shader);
        }
    }

    public void setStyle(Paint.Style style) {
        if (style != null) {
            this.mPaint.setStyle(style);
        }
    }

    public PathShapeLayer(Path path) {
        this(path, null, null);
    }

    public PathShapeLayer(Path path, Shader shader, Paint.Style style) {
        this.mPath = path;
        setShader(shader);
        setStyle(style);
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorAction
    public void postProgress(float f16) {
    }
}
