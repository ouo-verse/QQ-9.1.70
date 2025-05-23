package com.qzone.module.covercomponent.utils;

import android.graphics.drawable.Drawable;
import com.qzone.proxy.covercomponent.adapter.CoverLog;
import com.tencent.component.media.image.ImageProcessor;
import com.tencent.component.media.image.drawable.ScaleDrawable;

/* loaded from: classes39.dex */
public class QzoneCoverFullScreenImageProcessor extends ImageProcessor {
    public static final int ALIGN_BOTTOM = 2;
    public static final int ALIGN_CENTER = 0;
    public static final int ALIGN_TOP = 1;

    /* renamed from: a, reason: collision with root package name */
    private int f48737a;

    public QzoneCoverFullScreenImageProcessor(String str) {
        if (str == null) {
            this.f48737a = 0;
            return;
        }
        try {
            this.f48737a = Integer.parseInt(str);
        } catch (Exception e16) {
            CoverLog.e("QzoneCoverFullScreenImageProcessor", "parseInt alignType fail,use default ALIGN_CENTER", e16);
            this.f48737a = 0;
        }
    }

    @Override // com.tencent.component.media.image.ImageProcessor
    public int getType() {
        return this.f48737a + 102;
    }

    @Override // com.tencent.component.media.image.ImageProcessor
    public Drawable process(Drawable drawable) {
        try {
            int i3 = this.f48737a;
            return new ScaleDrawable(drawable, i3 != 1 ? i3 != 2 ? 8 : 7 : 6);
        } catch (Throwable th5) {
            th5.printStackTrace();
            return drawable;
        }
    }
}
