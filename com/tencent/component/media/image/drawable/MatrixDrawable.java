package com.tencent.component.media.image.drawable;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import com.tencent.component.media.image.drawable.DrawableContainer;

/* compiled from: P */
/* loaded from: classes5.dex */
public class MatrixDrawable extends DrawableContainer {
    private final Matrix mMatrix;
    private final MatrixState mState;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class MatrixState extends DrawableContainer.ContainerState {
        MatrixState(Drawable drawable, DrawableContainer drawableContainer) {
            super(drawable, drawableContainer);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new MatrixDrawable(this, null);
        }

        MatrixState(DrawableContainer.ContainerState containerState, DrawableContainer drawableContainer, Resources resources) {
            super(containerState, drawableContainer, resources);
        }
    }

    @Override // com.tencent.component.media.image.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.mMatrix.isIdentity()) {
            super.draw(canvas);
            return;
        }
        int saveCount = canvas.getSaveCount();
        canvas.save();
        canvas.concat(this.mMatrix);
        super.draw(canvas);
        canvas.restoreToCount(saveCount);
    }

    public Matrix getMatrix() {
        return this.mMatrix;
    }

    public void setMatrix(Matrix matrix) {
        if (matrix != null && matrix.isIdentity()) {
            matrix = null;
        }
        if ((matrix == null && !this.mMatrix.isIdentity()) || (matrix != null && !this.mMatrix.equals(matrix))) {
            this.mMatrix.set(matrix);
            invalidateSelf();
        }
    }

    public MatrixDrawable(Drawable drawable) {
        this(drawable, (Matrix) null);
    }

    public MatrixDrawable(Drawable drawable, Matrix matrix) {
        this.mMatrix = new Matrix();
        MatrixState matrixState = new MatrixState(drawable, this);
        this.mState = matrixState;
        setConstantState(matrixState);
        setMatrix(matrix);
    }

    MatrixDrawable(MatrixState matrixState, Resources resources) {
        this.mMatrix = new Matrix();
        MatrixState matrixState2 = new MatrixState(matrixState, this, resources);
        this.mState = matrixState2;
        setConstantState(matrixState2);
    }
}
