package com.tencent.av.ui.effect.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.tencent.av.utils.aw;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;

/* compiled from: P */
/* loaded from: classes3.dex */
public class EffectMaterialImageView extends EffectMaterialBaseImageView {
    private RectF C;
    private boolean D;

    public EffectMaterialImageView(Context context) {
        this(context, null);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        int f16 = BaseAIOUtils.f(this.f75583h, getResources()) - 2;
        int f17 = BaseAIOUtils.f(this.f75584i, getResources());
        int f18 = BaseAIOUtils.f(12.0f, getResources());
        int width = getWidth() / 2;
        int height = getHeight() / 2;
        int min = Math.min(getWidth(), getHeight()) / 2;
        canvas.drawARGB(0, 0, 0, 0);
        Drawable drawable = getDrawable();
        if (drawable != null) {
            if (this.f75581e) {
                if (!(drawable instanceof aw)) {
                    drawable.setColorFilter(-10591367, PorterDuff.Mode.MULTIPLY);
                }
            } else if (drawable instanceof URLDrawable) {
                drawable.setColorFilter(-1, PorterDuff.Mode.MULTIPLY);
            } else if (!(drawable instanceof aw)) {
                drawable.clearColorFilter();
            }
            drawable.setBounds(f16, f16, getWidth() - f16, getHeight() - f16);
            drawable.draw(canvas);
        }
        if (this.f75580d && !this.f75581e) {
            this.f75582f.reset();
            this.f75582f.setAntiAlias(true);
            this.f75582f.setColor(this.f75585m);
            this.f75582f.setStyle(Paint.Style.STROKE);
            this.f75582f.setStrokeWidth(f17);
            if (this.D) {
                int i3 = (f17 + 1) / 2;
                if (getParent() != null && (getParent().getParent() instanceof LinearLayout)) {
                    min = Math.min(((LinearLayout) getParent().getParent()).getWidth() / 2, min);
                }
                canvas.drawCircle(width, height, (min - i3) - f16, this.f75582f);
                return;
            }
            RectF rectF = this.C;
            int i16 = this.f75584i;
            rectF.left = i16 + f16;
            rectF.top = i16 + f16;
            rectF.right = (getWidth() - this.f75584i) - f16;
            this.C.bottom = (getHeight() - this.f75584i) - f16;
            float f19 = f18;
            canvas.drawRoundRect(this.C, f19, f19, this.f75582f);
        }
    }

    public void setCircle(boolean z16) {
        this.D = z16;
    }

    public EffectMaterialImageView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EffectMaterialImageView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.C = new RectF();
        this.D = false;
    }
}
