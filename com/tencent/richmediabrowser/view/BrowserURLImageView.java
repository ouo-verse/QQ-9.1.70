package com.tencent.richmediabrowser.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;

/* compiled from: P */
/* loaded from: classes25.dex */
public class BrowserURLImageView extends URLImageView {
    public boolean ignoreLayout;
    public URLDrawable mDecoding;

    public BrowserURLImageView(Context context) {
        super(context);
        this.ignoreLayout = false;
    }

    public void destory() {
        setDecodingDrawble(null);
        setImageDrawable(null);
    }

    @Override // com.tencent.image.URLImageView, com.tencent.image.URLDrawable.URLDrawableListener
    public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
        URLDrawable uRLDrawable2 = this.mDecoding;
        if (uRLDrawable == uRLDrawable2) {
            setImageDrawable(uRLDrawable2);
        } else {
            super.onLoadFialed(uRLDrawable, th5);
        }
    }

    @Override // com.tencent.image.URLImageView, com.tencent.image.URLDrawable.URLDrawableListener
    @TargetApi(11)
    public void onLoadSuccessed(URLDrawable uRLDrawable) {
        if (uRLDrawable == this.mDecoding) {
            Drawable drawable = getDrawable();
            if (drawable != null && drawable.getIntrinsicWidth() == uRLDrawable.getIntrinsicWidth() && drawable.getIntrinsicHeight() == uRLDrawable.getIntrinsicHeight()) {
                this.ignoreLayout = true;
                setImageDrawable(this.mDecoding);
                this.ignoreLayout = false;
                return;
            }
            setImageDrawable(this.mDecoding);
            return;
        }
        super.onLoadSuccessed(uRLDrawable);
    }

    @Override // android.view.View
    public void requestLayout() {
        if (!this.ignoreLayout) {
            super.requestLayout();
        }
    }

    public void setDecodingDrawble(URLDrawable uRLDrawable) {
        URLDrawable uRLDrawable2 = this.mDecoding;
        if (uRLDrawable2 != null) {
            uRLDrawable2.setURLDrawableListener(null);
        }
        uRLDrawable.setURLDrawableListener(this);
        this.mDecoding = uRLDrawable;
    }

    @Override // com.tencent.image.URLImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        URLDrawable uRLDrawable = this.mDecoding;
        if (uRLDrawable != null) {
            uRLDrawable.setURLDrawableListener(null);
            this.mDecoding = null;
        }
    }

    public BrowserURLImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ignoreLayout = false;
    }
}
