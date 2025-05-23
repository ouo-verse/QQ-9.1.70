package com.tencent.ad.tangram.views;

import android.support.annotation.NonNull;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public final class ImageLoadParams implements Serializable {
    public int currentLength;

    @NonNull
    public AtomicInteger firstImage = new AtomicInteger(0);
    public AtomicInteger hasLoadedFirstImages;
    public volatile boolean hasLoadedImage;

    public ImageLoadParams(int i3, boolean z16, AtomicInteger atomicInteger) {
        this.currentLength = i3;
        this.hasLoadedImage = z16;
        this.hasLoadedFirstImages = atomicInteger;
    }

    public int getCurrentLength() {
        return this.currentLength;
    }

    public AtomicInteger getHasLoadedFirstImages() {
        return this.hasLoadedFirstImages;
    }

    public boolean isHasLoadedImage() {
        return this.hasLoadedImage;
    }

    public void setCurrentLength(int i3) {
        this.currentLength = i3;
    }

    public void setHasLoadedFirstImages(AtomicInteger atomicInteger) {
        this.hasLoadedFirstImages = atomicInteger;
    }

    public void setHasLoadedImage(boolean z16) {
        this.hasLoadedImage = z16;
    }
}
