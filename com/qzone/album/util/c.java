package com.qzone.album.util;

import android.graphics.drawable.Drawable;
import com.qzone.widget.AsyncImageView;
import com.qzone.widget.FlexiableProcessImageView;
import com.tencent.component.media.image.ImageProcessor;
import com.tencent.component.media.image.processor.RoundCornerProcessor;
import com.tencent.component.media.image.processor.SpecifiedSizeCropByPivotProcessor;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes39.dex */
public class c {

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a extends ImageProcessor {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f44362a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f44363b;

        a(int i3, int i16) {
            this.f44362a = i3;
            this.f44363b = i16;
        }

        @Override // com.tencent.component.media.image.ImageProcessor
        public Drawable process(Drawable drawable) {
            return new RoundCornerProcessor(6.0f).process(new SpecifiedSizeCropByPivotProcessor(this.f44362a, this.f44363b).process(drawable));
        }
    }

    public static void b(AsyncImageView asyncImageView) {
        a(asyncImageView, R.color.ach, R.drawable.fux);
    }

    private static void a(AsyncImageView asyncImageView, int i3, int i16) {
        if (asyncImageView == null || i3 == 0 || i16 == 0) {
            return;
        }
        asyncImageView.setDefaultImage(i3);
        asyncImageView.setFailImage(i16);
    }

    public static void c(FlexiableProcessImageView flexiableProcessImageView, int i3, int i16) {
        if (flexiableProcessImageView == null || i3 == 0 || i3 == 0) {
            return;
        }
        flexiableProcessImageView.setNonAsycnDrawableWidth(i3, i16);
        a aVar = new a(i3, i16);
        flexiableProcessImageView.setDefaultImage(R.drawable.aq5, null);
        flexiableProcessImageView.setFailedImage(R.drawable.fux, aVar);
    }
}
