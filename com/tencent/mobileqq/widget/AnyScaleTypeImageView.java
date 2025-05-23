package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

/* compiled from: P */
/* loaded from: classes20.dex */
public class AnyScaleTypeImageView extends URLTextImageView {
    private boolean C;
    private a D;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface a {
        Matrix a(Drawable drawable, int i3, int i16);
    }

    public AnyScaleTypeImageView(Context context) {
        super(context);
        this.C = false;
    }

    public void setDisplayRuleDef(a aVar) {
        this.D = aVar;
        if (aVar != null) {
            setScaleType(ImageView.ScaleType.MATRIX);
        }
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int i3, int i16, int i17, int i18) {
        this.C = true;
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return super.setFrame(i3, i16, i17, i18);
        }
        if (this.D != null) {
            setImageMatrix(this.D.a(drawable, ((i17 - i3) - getPaddingLeft()) - getPaddingRight(), ((i18 - i16) - getPaddingTop()) - getPaddingBottom()));
        }
        return super.setFrame(i3, i16, i17, i18);
    }

    @Override // com.tencent.image.URLImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (this.C && drawable != null && this.D != null) {
            setImageMatrix(this.D.a(drawable, (getWidth() - getPaddingLeft()) - getPaddingRight(), (getHeight() - getPaddingTop()) - getPaddingBottom()));
        }
        super.setImageDrawable(drawable);
    }

    public AnyScaleTypeImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.C = false;
    }

    public AnyScaleTypeImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.C = false;
    }
}
