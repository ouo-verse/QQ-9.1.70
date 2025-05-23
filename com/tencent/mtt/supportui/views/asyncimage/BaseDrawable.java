package com.tencent.mtt.supportui.views.asyncimage;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* compiled from: P */
/* loaded from: classes21.dex */
public abstract class BaseDrawable extends Drawable {
    protected RectF mRect = new RectF();
    protected float mShadowOffsetX;
    protected float mShadowOffsetY;
    protected float mShadowRadius;

    public void setShadowOffsetX(float f16) {
        this.mShadowOffsetX = f16;
        invalidateSelf();
    }

    public void setShadowOffsetY(float f16) {
        this.mShadowOffsetY = f16;
        invalidateSelf();
    }

    public void setShadowRadius(float f16) {
        this.mShadowRadius = f16;
        invalidateSelf();
    }

    public void updateContentRegion() {
        float f16 = getBounds().top;
        float f17 = this.mShadowRadius;
        float f18 = f16 + f17;
        float f19 = r0.left + f17;
        float f26 = r0.right - f17;
        float f27 = r0.bottom - f17;
        float f28 = this.mShadowOffsetX;
        if (f28 > 0.0f) {
            if (f17 >= f28) {
                f19 -= f28;
                f26 -= f28;
            } else {
                f19 -= f17;
            }
        } else {
            float abs = Math.abs(f28);
            float f29 = this.mShadowRadius;
            if (f29 >= abs) {
                f19 += abs;
                f26 += abs;
            } else {
                f26 += f29;
            }
        }
        float f36 = this.mShadowOffsetY;
        if (f36 > 0.0f) {
            float f37 = this.mShadowRadius;
            if (f37 >= f36) {
                f18 -= f36;
                f27 -= f36;
            } else {
                f18 -= f37;
            }
        } else {
            float abs2 = Math.abs(f36);
            float f38 = this.mShadowRadius;
            if (f38 >= abs2) {
                float f39 = this.mShadowOffsetY;
                f18 += f39;
                f27 += f39;
            } else {
                f27 += f38;
            }
        }
        this.mRect.set(new RectF(f19, f18, f26, f27));
    }
}
