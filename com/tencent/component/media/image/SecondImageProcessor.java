package com.tencent.component.media.image;

import com.tencent.component.media.annotation.Public;

/* loaded from: classes5.dex */
public abstract class SecondImageProcessor {
    public final BitmapReference doProcess(BitmapReference bitmapReference, boolean z16) {
        if (bitmapReference == null) {
            return null;
        }
        BitmapReference process = process(bitmapReference);
        if (process != null && process != bitmapReference) {
            if (z16 && !bitmapReference.isRecycled()) {
                bitmapReference.release();
            }
            return process;
        }
        return bitmapReference;
    }

    @Public
    public abstract String id();

    @Public
    public abstract BitmapReference process(BitmapReference bitmapReference);
}
