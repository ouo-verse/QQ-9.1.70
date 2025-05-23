package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.app.AppConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010.\u001a\u0004\u0018\u00010-\u00a2\u0006\u0004\b/\u00100B\u001b\b\u0016\u0012\b\u0010.\u001a\u0004\u0018\u00010-\u0012\u0006\u00102\u001a\u000201\u00a2\u0006\u0004\b/\u00103J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014J\u001e\u0010\f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tR$\u0010\u0014\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u001c\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b\f\u0010!R\"\u0010(\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010,\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010#\u001a\u0004\b*\u0010%\"\u0004\b+\u0010'\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/widget/SweepGradientCircleProgress;", "Lcom/tencent/mobileqq/widget/CircleProgress;", "", "c", "Landroid/graphics/Canvas;", PM.CANVAS, "a", "", "needSweepGradient", "", "startColor", "endColor", "setNeedSweepGradient", "Landroid/graphics/SweepGradient;", "L", "Landroid/graphics/SweepGradient;", "getMSweepGradient", "()Landroid/graphics/SweepGradient;", "setMSweepGradient", "(Landroid/graphics/SweepGradient;)V", "mSweepGradient", "Landroid/graphics/Matrix;", "M", "Landroid/graphics/Matrix;", "getMMatrixForSweepGradient", "()Landroid/graphics/Matrix;", "setMMatrixForSweepGradient", "(Landroid/graphics/Matrix;)V", "mMatrixForSweepGradient", "N", "Z", "getNeedSweepGradient", "()Z", "(Z)V", "P", "I", "getMStartProgressColor", "()I", "setMStartProgressColor", "(I)V", "mStartProgressColor", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "getMEndProgressColor", "setMEndProgressColor", "mEndProgressColor", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class SweepGradientCircleProgress extends CircleProgress {

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private SweepGradient mSweepGradient;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private Matrix mMatrixForSweepGradient;

    /* renamed from: N, reason: from kotlin metadata */
    private boolean needSweepGradient;

    /* renamed from: P, reason: from kotlin metadata */
    private int mStartProgressColor;

    /* renamed from: Q, reason: from kotlin metadata */
    private int mEndProgressColor;

    public SweepGradientCircleProgress(@Nullable Context context) {
        super(context);
    }

    private final void c() {
        float f16;
        if (this.needSweepGradient) {
            if (this.mSweepGradient == null) {
                this.mSweepGradient = new SweepGradient(this.I.centerX(), this.I.centerY(), this.mStartProgressColor, this.mEndProgressColor);
            }
            if (this.mMatrixForSweepGradient == null) {
                this.mMatrixForSweepGradient = new Matrix();
            }
            Matrix matrix = this.mMatrixForSweepGradient;
            if (matrix != null) {
                matrix.reset();
            }
            float f17 = this.H;
            if (f17 > 0.0f) {
                f16 = (float) ((f17 * 3.6d) + 270);
            } else {
                f16 = 270.0f;
            }
            Matrix matrix2 = this.mMatrixForSweepGradient;
            if (matrix2 != null) {
                matrix2.setRotate(f16, this.I.centerX(), this.I.centerY());
            }
            SweepGradient sweepGradient = this.mSweepGradient;
            if (sweepGradient != null) {
                sweepGradient.setLocalMatrix(this.mMatrixForSweepGradient);
                return;
            }
            return;
        }
        this.mSweepGradient = null;
    }

    @Override // com.tencent.mobileqq.widget.CircleProgress
    protected void a(@Nullable Canvas canvas) {
        this.G.setColor(this.f315492f);
        if (this.J) {
            this.G.setAlpha((this.f315495m * 255) / 100);
        }
        this.G.setShadowLayer(this.f315494i, 0.0f, 0.0f, this.f315493h);
        if (canvas != null) {
            canvas.drawArc(this.I, -90.0f, 360.0f, false, this.G);
        }
        this.G.setColor(this.C);
        if (this.K) {
            this.G.setAlpha((this.D * 255) / 100);
        }
        this.G.setShadowLayer(this.f315494i, 0.0f, 0.0f, this.f315493h);
        c();
        this.G.setShader(this.mSweepGradient);
        if (canvas != null) {
            canvas.drawArc(this.I, -90.0f, (float) (this.H * 3.6d), false, this.G);
        }
        this.G.setShader(null);
    }

    public final void setMEndProgressColor(int i3) {
        this.mEndProgressColor = i3;
    }

    public final void setMMatrixForSweepGradient(@Nullable Matrix matrix) {
        this.mMatrixForSweepGradient = matrix;
    }

    public final void setMStartProgressColor(int i3) {
        this.mStartProgressColor = i3;
    }

    public final void setMSweepGradient(@Nullable SweepGradient sweepGradient) {
        this.mSweepGradient = sweepGradient;
    }

    public final void setNeedSweepGradient(boolean z16) {
        this.needSweepGradient = z16;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SweepGradientCircleProgress(@Nullable Context context, @NotNull AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(attrs, "attrs");
    }

    public final void setNeedSweepGradient(boolean needSweepGradient, int startColor, int endColor) {
        this.needSweepGradient = needSweepGradient;
        if (needSweepGradient) {
            this.mStartProgressColor = startColor;
            this.mEndProgressColor = endColor;
        }
        this.mSweepGradient = null;
    }
}
