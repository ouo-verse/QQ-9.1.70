package com.tencent.gdtad.basics.flip;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorLayer;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GradientLayer extends AnimatorLayer {

    /* renamed from: d, reason: collision with root package name */
    LinearGradient f108770d;

    /* renamed from: e, reason: collision with root package name */
    private int f108771e;

    /* renamed from: f, reason: collision with root package name */
    private int f108772f;

    /* renamed from: h, reason: collision with root package name */
    private int f108773h;

    /* renamed from: i, reason: collision with root package name */
    private int f108774i;

    /* renamed from: m, reason: collision with root package name */
    @GradientDirection
    private int f108775m;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public @interface GradientDirection {
        public static final int LEFT_TO_RIGHT = 1;
        public static final int RIGHT_TO_LEFT = 2;
    }

    public void a(@GradientDirection int i3) {
        int width = getWidth() / 2;
        int height = getHeight() / 2;
        this.f108771e = ((int) getCenterX()) - width;
        this.f108773h = ((int) getCenterY()) - height;
        this.f108772f = ((int) getCenterX()) + width;
        this.f108774i = ((int) getCenterY()) + height;
        this.f108775m = i3;
        if (i3 == 1) {
            float f16 = this.f108771e;
            int i16 = this.f108773h;
            this.f108770d = new LinearGradient(f16, i16, this.f108772f, i16, Integer.MAX_VALUE, 16777215, Shader.TileMode.MIRROR);
        } else {
            float f17 = this.f108772f;
            int i17 = this.f108773h;
            this.f108770d = new LinearGradient(f17, i17, this.f108771e, i17, Integer.MAX_VALUE, 16777215, Shader.TileMode.MIRROR);
        }
        this.mPaint.setShader(this.f108770d);
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorLayer
    public void draw(Canvas canvas) {
        if (this.mMatrixChanged) {
            canvas.setMatrix(getMatrix());
            canvas.drawRect(this.f108771e, this.f108773h, this.f108772f, this.f108774i, this.mPaint);
            canvas.setMatrix(null);
            return;
        }
        canvas.drawRect(this.f108771e, this.f108773h, this.f108772f, this.f108774i, this.mPaint);
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorLayer
    public boolean isMatrixNeedPreTranslate() {
        return false;
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorLayer, com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorAction
    public void postRotationY(float f16) {
        super.postRotationY(f16);
        int i3 = this.f108775m;
        boolean z16 = true;
        if ((i3 != 1 || f16 >= 0.0f) && (i3 != 2 || f16 <= 0.0f)) {
            z16 = false;
        }
        if (z16) {
            postAlpha((int) (Math.min(Math.abs(f16) / 30.0f, 1.0f) * 255.0f));
        } else {
            postAlpha(0);
        }
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorAction
    public void postProgress(float f16) {
    }
}
