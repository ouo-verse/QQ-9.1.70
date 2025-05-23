package com.qzone.module.covercomponent.utils;

import android.graphics.drawable.Drawable;
import com.tencent.component.media.image.ImageProcessor;
import com.tencent.component.media.image.drawable.ScaleDrawable;
import com.tencent.component.media.image.drawable.SpecifiedDrawable;

/* loaded from: classes39.dex */
public class QzoneCoverSquareImageProcessor extends ImageProcessor {

    /* renamed from: a, reason: collision with root package name */
    private int f48738a;

    public QzoneCoverSquareImageProcessor(int i3) {
        this.f48738a = i3;
    }

    @Override // com.tencent.component.media.image.ImageProcessor
    public int getType() {
        return 100;
    }

    @Override // com.tencent.component.media.image.ImageProcessor
    public Drawable process(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        try {
            return new SpecifiedDrawable(new ScaleDrawable(drawable, this.f48738a), drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        } catch (Throwable th5) {
            th5.printStackTrace();
            return null;
        }
    }
}
