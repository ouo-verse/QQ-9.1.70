package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes20.dex */
public class MyCheckBox extends CompoundButton {

    /* renamed from: d, reason: collision with root package name */
    private Drawable f315860d;

    /* renamed from: e, reason: collision with root package name */
    private Paint f315861e;

    /* renamed from: f, reason: collision with root package name */
    private Bitmap f315862f;

    public MyCheckBox(Context context) {
        this(context, null);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f315860d != null) {
            this.f315860d.setState(getDrawableState());
            invalidate();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        return 0;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        int height;
        super.onDraw(canvas);
        Drawable drawable = this.f315860d;
        if (drawable != null) {
            int gravity = getGravity() & 112;
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (gravity != 16) {
                if (gravity != 80) {
                    height = 0;
                } else {
                    height = getHeight() - intrinsicHeight;
                }
            } else {
                height = (getHeight() - intrinsicHeight) / 2;
            }
            drawable.setBounds(getWidth() - drawable.getIntrinsicWidth(), height, getWidth(), height + intrinsicHeight);
            drawable.draw(canvas);
            if (this.f315862f == null) {
                this.f315862f = BitmapFactory.decodeResource(getResources(), R.drawable.f162502by0);
            }
            if (isChecked()) {
                this.f315861e.setColor(-1);
                float f16 = getResources().getDisplayMetrics().density;
                this.f315861e.setTextSize(getResources().getDimension(R.dimen.f158882rj));
                this.f315861e.setAntiAlias(true);
                this.f315861e.setTextAlign(Paint.Align.CENTER);
                canvas.drawText(getResources().getString(R.string.hhi), (getWidth() - ((drawable.getIntrinsicWidth() * 2) / 3)) - (2.0f * f16), (intrinsicHeight / 2) + height + (f16 * 4.0f), this.f315861e);
                canvas.drawBitmap(this.f315862f, getWidth() - this.f315862f.getWidth(), height, (Paint) null);
                return;
            }
            this.f315861e.setColor(-8814455);
            float f17 = getResources().getDisplayMetrics().density;
            this.f315861e.setTextSize(getResources().getDimension(R.dimen.f158882rj));
            this.f315861e.setAntiAlias(true);
            this.f315861e.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(getResources().getString(R.string.f173116hh1), (getWidth() - (drawable.getIntrinsicWidth() / 3)) + (2.0f * f17), (intrinsicHeight / 2) + height + (f17 * 4.0f), this.f315861e);
            canvas.drawBitmap(this.f315862f, getWidth() - drawable.getIntrinsicWidth(), height, (Paint) null);
        }
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        boolean z16;
        if (drawable != null) {
            Drawable drawable2 = this.f315860d;
            if (drawable2 != null) {
                drawable2.setCallback(null);
                unscheduleDrawable(this.f315860d);
            }
            drawable.setCallback(this);
            drawable.setState(getDrawableState());
            if (getVisibility() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            drawable.setVisible(z16, false);
            this.f315860d = drawable;
            setMinHeight(drawable.getIntrinsicHeight());
        }
        refreshDrawableState();
    }

    public void setButtonGray(boolean z16) {
        if (z16) {
            this.f315860d.setAlpha(255);
        } else {
            this.f315860d.setAlpha(128);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        if (!super.verifyDrawable(drawable) && drawable != this.f315860d) {
            return false;
        }
        return true;
    }

    public MyCheckBox(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, android.R.attr.checkboxStyle);
    }

    public MyCheckBox(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f315861e = new Paint();
        this.f315862f = null;
    }
}
