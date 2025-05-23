package com.tencent.gdtad.basics.flip;

import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorLayer;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes6.dex */
public class ArrowShapeLayer extends AnimatorLayer {
    private final Paint C;
    private final Path D;
    private final Paint E;

    /* renamed from: h, reason: collision with root package name */
    private int f108741h;

    /* renamed from: i, reason: collision with root package name */
    private float f108742i;

    /* renamed from: d, reason: collision with root package name */
    private float f108738d = 0.0f;

    /* renamed from: e, reason: collision with root package name */
    private float f108739e = 0.75f;

    /* renamed from: f, reason: collision with root package name */
    private float f108740f = 0.33333334f;

    /* renamed from: m, reason: collision with root package name */
    private final Path f108743m = new Path();

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes6.dex */
    public @interface ArrowDirection {
        public static final int LEFT_TO_RIGHT = 1;
        public static final int RIGHT_TO_LEFT = 2;
    }

    public ArrowShapeLayer() {
        Paint paint = new Paint();
        this.C = paint;
        this.D = new Path();
        Paint paint2 = new Paint();
        this.E = paint2;
        paint.setStyle(Paint.Style.FILL);
        paint2.setStyle(Paint.Style.FILL);
    }

    private float[] a(float f16, float[] fArr) {
        return new float[]{fArr[0], (f16 * 2.0f) - fArr[1]};
    }

    private void c(float f16) {
        float f17;
        float f18;
        RectF rectF;
        float[] fArr;
        float[] fArr2;
        float[] fArr3;
        if (f16 < 0.0f) {
            f17 = 0.0f;
        } else if (f16 > 1.0f) {
            f17 = 1.0f;
        } else {
            f17 = f16;
        }
        float width = getWidth() / 2.0f;
        float height = getHeight() / 2.0f;
        float height2 = getHeight() * this.f108739e;
        float width2 = getWidth() * this.f108740f;
        float width3 = getWidth() - width2;
        float f19 = height2 / 2.0f;
        float min = Math.min(f17 / this.f108740f, 1.0f);
        float f26 = this.f108740f;
        if (f17 > f26) {
            f18 = (f17 - f26) / (1.0f - f26);
        } else {
            f18 = 0.0f;
        }
        this.f108743m.reset();
        this.D.reset();
        if (this.f108741h == 1) {
            rectF = new RectF(getCenterX() - width, getCenterY() + f19, (getCenterX() - width) + (min * width2), getCenterY() - f19);
            float f27 = this.f108742i;
            fArr = new float[]{f27, f27, 0.0f, 0.0f, 0.0f, 0.0f, f27, f27};
        } else {
            rectF = new RectF((getCenterX() + width) - (min * width2), getCenterY() + f19, getCenterX() + width, getCenterY() - f19);
            float f28 = this.f108742i;
            fArr = new float[]{0.0f, 0.0f, f28, f28, f28, f28, 0.0f, 0.0f};
        }
        this.f108743m.addRoundRect(rectF, fArr, Path.Direction.CW);
        if (f18 <= 0.0f) {
            return;
        }
        if (this.f108741h == 1) {
            fArr2 = new float[]{(getCenterX() - width) + width2, getCenterY() + height};
            fArr3 = new float[]{(getCenterX() - width) + width2 + (width3 * f18), getCenterY() + (height * (1.0f - f18))};
        } else {
            fArr2 = new float[]{(getCenterX() + width) - width2, getCenterY() + height};
            fArr3 = new float[]{((getCenterX() + width) - width2) - (width3 * f18), getCenterY() + (height * (1.0f - f18))};
        }
        float[] a16 = a(getCenterY(), fArr3);
        float[] a17 = a(getCenterY(), fArr2);
        this.D.moveTo(fArr2[0], fArr2[1]);
        this.D.lineTo(fArr3[0], fArr3[1]);
        this.D.lineTo(a16[0], a16[1]);
        this.D.lineTo(a17[0], a17[1]);
        this.D.close();
    }

    public void b(int i3, int i16, int i17, int i18, int i19, int i26, float f16, float f17, float f18, float f19) {
        this.f108741h = i19;
        this.f108739e = f16;
        this.f108740f = f17;
        this.f108742i = f18;
        this.C.setColor(i26);
        this.E.setColor(i26);
        this.E.setPathEffect(new CornerPathEffect(f19));
        this.f108738d = 0.0f;
        setCenterX(i3);
        setCenterY(i16);
        setWidth(i17);
        setHeight(i18);
        c(this.f108738d);
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorLayer
    public void draw(Canvas canvas) {
        if (this.mMatrixChanged) {
            canvas.setMatrix(getMatrix());
            canvas.drawPath(this.f108743m, this.C);
            canvas.drawPath(this.D, this.E);
            canvas.setMatrix(null);
            return;
        }
        canvas.drawPath(this.f108743m, this.C);
        canvas.drawPath(this.D, this.E);
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorLayer, com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorAction
    public void postAlpha(int i3) {
        super.postAlpha(i3);
        this.C.setAlpha(this.mAlpha);
        this.E.setAlpha(this.mAlpha);
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorAction
    public void postProgress(float f16) {
        this.f108738d = f16;
        c(f16);
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorLayer, com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorAction
    public void postTranslate(float f16, float f17) {
        this.D.offset(f16 - getDistanceX(), f17 - getDistanceY());
        this.f108743m.offset(f16 - getDistanceX(), f17 - getDistanceY());
        super.postTranslate(f16, f17);
    }
}
