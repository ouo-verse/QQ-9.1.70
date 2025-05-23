package com.nostra13.universalimageloader.core.imageaware;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.utils.L;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class ViewAware implements ImageAware {
    public static final String WARN_CANT_SET_BITMAP = "Can't set a bitmap into view. You should call ImageLoader on UI thread for it.";
    public static final String WARN_CANT_SET_DRAWABLE = "Can't set a drawable into view. You should call ImageLoader on UI thread for it.";
    protected boolean checkActualViewSize;
    protected Reference<View> viewRef;

    public ViewAware(View view) {
        this(view, true);
    }

    @Override // com.nostra13.universalimageloader.core.imageaware.ImageAware
    public int getHeight() {
        View view = this.viewRef.get();
        int i3 = 0;
        if (view == null) {
            return 0;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (this.checkActualViewSize && layoutParams != null && layoutParams.height != -2) {
            i3 = view.getHeight();
        }
        if (i3 <= 0 && layoutParams != null) {
            return layoutParams.height;
        }
        return i3;
    }

    @Override // com.nostra13.universalimageloader.core.imageaware.ImageAware
    public int getId() {
        View view = this.viewRef.get();
        if (view == null) {
            return super.hashCode();
        }
        return view.hashCode();
    }

    @Override // com.nostra13.universalimageloader.core.imageaware.ImageAware
    public ViewScaleType getScaleType() {
        return ViewScaleType.CROP;
    }

    @Override // com.nostra13.universalimageloader.core.imageaware.ImageAware
    public int getWidth() {
        View view = this.viewRef.get();
        int i3 = 0;
        if (view == null) {
            return 0;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (this.checkActualViewSize && layoutParams != null && layoutParams.width != -2) {
            i3 = view.getWidth();
        }
        if (i3 <= 0 && layoutParams != null) {
            return layoutParams.width;
        }
        return i3;
    }

    @Override // com.nostra13.universalimageloader.core.imageaware.ImageAware
    public View getWrappedView() {
        return this.viewRef.get();
    }

    @Override // com.nostra13.universalimageloader.core.imageaware.ImageAware
    public boolean isCollected() {
        if (this.viewRef.get() == null) {
            return true;
        }
        return false;
    }

    @Override // com.nostra13.universalimageloader.core.imageaware.ImageAware
    public boolean setImageBitmap(Bitmap bitmap) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            View view = this.viewRef.get();
            if (view != null) {
                setImageBitmapInto(bitmap, view);
                return true;
            }
        } else {
            L.w(WARN_CANT_SET_BITMAP, new Object[0]);
        }
        return false;
    }

    protected abstract void setImageBitmapInto(Bitmap bitmap, View view);

    @Override // com.nostra13.universalimageloader.core.imageaware.ImageAware
    public boolean setImageDrawable(Drawable drawable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            View view = this.viewRef.get();
            if (view != null) {
                setImageDrawableInto(drawable, view);
                return true;
            }
        } else {
            L.w(WARN_CANT_SET_DRAWABLE, new Object[0]);
        }
        return false;
    }

    protected abstract void setImageDrawableInto(Drawable drawable, View view);

    public ViewAware(View view, boolean z16) {
        if (view != null) {
            this.viewRef = new WeakReference(view);
            this.checkActualViewSize = z16;
            return;
        }
        throw new IllegalArgumentException("view must not be null");
    }
}
