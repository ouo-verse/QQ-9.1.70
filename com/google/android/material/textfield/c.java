package com.google.android.material.textfield;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.shape.MaterialShapeDrawable;

/* compiled from: P */
/* loaded from: classes2.dex */
class c extends MaterialShapeDrawable {

    @NonNull
    private final Paint W;

    @NonNull
    private final RectF X;

    c() {
        this(null);
    }

    private void r0() {
        this.W.setStyle(Paint.Style.FILL_AND_STROKE);
        this.W.setColor(-1);
        this.W.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean n0() {
        return !this.X.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o0() {
        p0(0.0f, 0.0f, 0.0f, 0.0f);
    }

    void p0(float f16, float f17, float f18, float f19) {
        RectF rectF = this.X;
        if (f16 != rectF.left || f17 != rectF.top || f18 != rectF.right || f19 != rectF.bottom) {
            rectF.set(f16, f17, f18, f19);
            invalidateSelf();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q0(@NonNull RectF rectF) {
        p0(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.material.shape.MaterialShapeDrawable
    public void r(@NonNull Canvas canvas) {
        if (this.X.isEmpty()) {
            super.r(canvas);
            return;
        }
        canvas.save();
        if (Build.VERSION.SDK_INT >= 26) {
            canvas.clipOutRect(this.X);
        } else {
            canvas.clipRect(this.X, Region.Op.DIFFERENCE);
        }
        super.r(canvas);
        canvas.restore();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(@Nullable com.google.android.material.shape.g gVar) {
        super(gVar == null ? new com.google.android.material.shape.g() : gVar);
        this.W = new Paint(1);
        r0();
        this.X = new RectF();
    }
}
