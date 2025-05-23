package com.nostra13.universalimageloader.core.display;

import android.graphics.Bitmap;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.DecelerateInterpolator;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;

/* compiled from: P */
/* loaded from: classes2.dex */
public class FadeInBitmapDisplayer implements BitmapDisplayer {
    private final boolean animateFromDisk;
    private final boolean animateFromMemory;
    private final boolean animateFromNetwork;
    private final int durationMillis;

    public FadeInBitmapDisplayer(int i3) {
        this(i3, true, true, true);
    }

    public static void animate(View view, int i3) {
        if (view != null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(i3);
            alphaAnimation.setInterpolator(new DecelerateInterpolator());
            view.startAnimation(alphaAnimation);
        }
    }

    @Override // com.nostra13.universalimageloader.core.display.BitmapDisplayer
    public void display(Bitmap bitmap, ImageAware imageAware, LoadedFrom loadedFrom) {
        imageAware.setImageBitmap(bitmap);
        if ((this.animateFromNetwork && loadedFrom == LoadedFrom.NETWORK) || ((this.animateFromDisk && loadedFrom == LoadedFrom.DISC_CACHE) || (this.animateFromMemory && loadedFrom == LoadedFrom.MEMORY_CACHE))) {
            animate(imageAware.getWrappedView(), this.durationMillis);
        }
    }

    public FadeInBitmapDisplayer(int i3, boolean z16, boolean z17, boolean z18) {
        this.durationMillis = i3;
        this.animateFromNetwork = z16;
        this.animateFromDisk = z17;
        this.animateFromMemory = z18;
    }
}
