package com.tencent.gdtad.basics.adshake.animatorview.animator;

import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorLayer;

/* compiled from: P */
/* loaded from: classes6.dex */
public class a extends RotationAnimator {

    /* renamed from: a, reason: collision with root package name */
    private final Camera f108723a;

    /* renamed from: b, reason: collision with root package name */
    private float f108724b;

    /* renamed from: c, reason: collision with root package name */
    private float f108725c;

    /* renamed from: d, reason: collision with root package name */
    private float f108726d;

    public a(AnimatorLayer animatorLayer) {
        super(animatorLayer);
        this.f108724b = 0.0f;
        this.f108725c = 0.0f;
        this.f108726d = -8.0f;
        this.f108723a = new Camera();
    }

    public a a(float f16, float f17, float f18) {
        this.f108724b = f16;
        this.f108725c = f17;
        this.f108726d = f18;
        return this;
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.animator.RotationAnimator
    protected void postRotation(Canvas canvas, AnimatorLayer animatorLayer, float f16) {
        Matrix matrix = new Matrix();
        resetMatrix(animatorLayer, matrix);
        this.f108723a.save();
        this.f108723a.setLocation(this.f108724b, this.f108725c, this.f108726d);
        this.f108723a.rotateY(f16);
        this.f108723a.getMatrix(matrix);
        this.f108723a.restore();
        if (animatorLayer.isMatrixNeedPreTranslate()) {
            matrix.preTranslate(animatorLayer.getX(), animatorLayer.getY());
        }
        float px5 = animatorLayer.getPx();
        float py5 = animatorLayer.getPy();
        matrix.preTranslate(-px5, -py5);
        matrix.postTranslate(px5, py5);
        animatorLayer.setMatrix(matrix);
        animatorLayer.setMatrixChanged(true);
        animatorLayer.postRotationY(f16);
    }
}
