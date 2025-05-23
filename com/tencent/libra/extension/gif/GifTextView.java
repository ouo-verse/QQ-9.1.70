package com.tencent.libra.extension.gif;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.libra.extension.gif.e;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes7.dex */
public class GifTextView extends TextView {

    /* renamed from: d, reason: collision with root package name */
    private e.b f118733d;

    public GifTextView(Context context) {
        super(context);
    }

    private void a() {
        if (this.f118733d.f118752b < 0) {
            return;
        }
        for (Drawable drawable : getCompoundDrawables()) {
            e.a(this.f118733d.f118752b, drawable);
        }
        for (Drawable drawable2 : getCompoundDrawablesRelative()) {
            e.a(this.f118733d.f118752b, drawable2);
        }
        e.a(this.f118733d.f118752b, getBackground());
    }

    private Drawable b(int i3) {
        if (i3 == 0) {
            return null;
        }
        Resources resources = getResources();
        String resourceTypeName = resources.getResourceTypeName(i3);
        if (!isInEditMode() && e.f118748a.contains(resourceTypeName)) {
            try {
                return new GifDrawable(resources, i3);
            } catch (Resources.NotFoundException | IOException unused) {
            }
        }
        return resources.getDrawable(i3, getContext().getTheme());
    }

    private void c(AttributeSet attributeSet, int i3, int i16) {
        if (attributeSet != null) {
            Drawable b16 = b(attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "drawableLeft", 0));
            Drawable b17 = b(attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "drawableTop", 0));
            Drawable b18 = b(attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "drawableRight", 0));
            Drawable b19 = b(attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "drawableBottom", 0));
            Drawable b26 = b(attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "drawableStart", 0));
            Drawable b27 = b(attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "drawableEnd", 0));
            if (getLayoutDirection() == 0) {
                if (b26 != null) {
                    b16 = b26;
                }
                if (b27 == null) {
                    b27 = b18;
                }
            } else {
                if (b26 != null) {
                    b18 = b26;
                }
                if (b27 == null) {
                    b27 = b16;
                }
                b16 = b18;
            }
            setCompoundDrawablesRelativeWithIntrinsicBounds(b16, b17, b27, b19);
            setBackground(b(attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "background", 0)));
            this.f118733d = new e.b(this, attributeSet, i3, i16);
            a();
        }
        this.f118733d = new e.b();
    }

    private void d(boolean z16) {
        e(getCompoundDrawables(), z16);
        e(getCompoundDrawablesRelative(), z16);
    }

    private static void e(Drawable[] drawableArr, boolean z16) {
        for (Drawable drawable : drawableArr) {
            if (drawable != null) {
                drawable.setVisible(z16, false);
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        d(true);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d(false);
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof GifViewSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        GifViewSavedState gifViewSavedState = (GifViewSavedState) parcelable;
        super.onRestoreInstanceState(gifViewSavedState.getSuperState());
        Drawable[] compoundDrawables = getCompoundDrawables();
        gifViewSavedState.a(compoundDrawables[0], 0);
        gifViewSavedState.a(compoundDrawables[1], 1);
        gifViewSavedState.a(compoundDrawables[2], 2);
        gifViewSavedState.a(compoundDrawables[3], 3);
        Drawable[] compoundDrawablesRelative = getCompoundDrawablesRelative();
        gifViewSavedState.a(compoundDrawablesRelative[0], 4);
        gifViewSavedState.a(compoundDrawablesRelative[2], 5);
        gifViewSavedState.a(getBackground(), 6);
    }

    @Override // android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        Drawable[] drawableArr = new Drawable[7];
        if (this.f118733d.f118751a) {
            Drawable[] compoundDrawables = getCompoundDrawables();
            System.arraycopy(compoundDrawables, 0, drawableArr, 0, compoundDrawables.length);
            Drawable[] compoundDrawablesRelative = getCompoundDrawablesRelative();
            drawableArr[4] = compoundDrawablesRelative[0];
            drawableArr[5] = compoundDrawablesRelative[2];
            drawableArr[6] = getBackground();
        }
        return new GifViewSavedState(super.onSaveInstanceState(), drawableArr);
    }

    @Override // android.view.View
    public void setBackgroundResource(int i3) {
        setBackground(b(i3));
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i3, int i16, int i17, int i18) {
        setCompoundDrawablesRelativeWithIntrinsicBounds(b(i3), b(i16), b(i17), b(i18));
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i3, int i16, int i17, int i18) {
        setCompoundDrawablesWithIntrinsicBounds(b(i3), b(i16), b(i17), b(i18));
    }

    public void setFreezesAnimation(boolean z16) {
        this.f118733d.f118751a = z16;
    }

    public GifTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c(attributeSet, 0, 0);
    }

    public GifTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        c(attributeSet, i3, 0);
    }
}
