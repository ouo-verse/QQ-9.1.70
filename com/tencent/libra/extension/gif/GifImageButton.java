package com.tencent.libra.extension.gif;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.ImageButton;
import com.tencent.libra.extension.gif.e;

/* compiled from: P */
/* loaded from: classes7.dex */
public class GifImageButton extends ImageButton {

    /* renamed from: d, reason: collision with root package name */
    private boolean f118730d;

    public GifImageButton(Context context) {
        super(context);
    }

    private void a(e.a aVar) {
        this.f118730d = aVar.f118751a;
        int i3 = aVar.f118749c;
        if (i3 > 0) {
            super.setImageResource(i3);
        }
        int i16 = aVar.f118750d;
        if (i16 > 0) {
            super.setBackgroundResource(i16);
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof GifViewSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        GifViewSavedState gifViewSavedState = (GifViewSavedState) parcelable;
        super.onRestoreInstanceState(gifViewSavedState.getSuperState());
        gifViewSavedState.a(getDrawable(), 0);
        gifViewSavedState.a(getBackground(), 1);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Drawable drawable;
        Drawable drawable2 = null;
        if (this.f118730d) {
            drawable = getDrawable();
        } else {
            drawable = null;
        }
        if (this.f118730d) {
            drawable2 = getBackground();
        }
        return new GifViewSavedState(super.onSaveInstanceState(), drawable, drawable2);
    }

    @Override // android.view.View
    public void setBackgroundResource(int i3) {
        if (!e.e(this, false, i3)) {
            super.setBackgroundResource(i3);
        }
    }

    public void setFreezesAnimation(boolean z16) {
        this.f118730d = z16;
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i3) {
        if (!e.e(this, true, i3)) {
            super.setImageResource(i3);
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        if (!e.d(this, uri)) {
            super.setImageURI(uri);
        }
    }

    public GifImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(e.c(this, attributeSet, 0, 0));
    }

    public GifImageButton(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        a(e.c(this, attributeSet, i3, 0));
    }
}
