package com.tencent.mobileqq.wink.publish.widget.multitouchimg;

import android.widget.ImageView;

/* compiled from: P */
/* loaded from: classes21.dex */
public class n {

    /* compiled from: P */
    /* loaded from: classes21.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f326133a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f326133a = iArr;
            try {
                iArr[ImageView.ScaleType.MATRIX.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public static void a(float f16, float f17, float f18) {
        if (f16 < f17) {
            if (f17 < f18) {
                return;
            } else {
                throw new IllegalArgumentException("Medium zoom has to be less than Maximum zoom. Call setMaximumZoom() with a more appropriate value");
            }
        }
        throw new IllegalArgumentException("Minimum zoom has to be less than Medium zoom. Call setMinimumZoom() with a more appropriate value");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(int i3) {
        return (i3 & 65280) >> 8;
    }

    public static boolean c(ImageView imageView) {
        if (imageView.getDrawable() != null) {
            return true;
        }
        return false;
    }

    public static boolean d(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            return false;
        }
        if (a.f326133a[scaleType.ordinal()] != 1) {
            return true;
        }
        throw new IllegalStateException("Matrix scale type is not supported");
    }
}
