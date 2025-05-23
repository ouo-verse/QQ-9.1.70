package com.tencent.biz.qqcircle.widgets.multitouchimg;

import android.widget.ImageView;

/* compiled from: P */
/* loaded from: classes5.dex */
class p {

    /* compiled from: P */
    /* loaded from: classes5.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f93684a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f93684a = iArr;
            try {
                iArr[ImageView.ScaleType.MATRIX.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c(ImageView imageView) {
        if (imageView.getDrawable() != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean d(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            return false;
        }
        if (a.f93684a[scaleType.ordinal()] != 1) {
            return true;
        }
        throw new IllegalStateException("Matrix scale type is not supported");
    }
}
