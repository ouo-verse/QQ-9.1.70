package com.tencent.mobileqq.wink.view.multitouchview;

import android.widget.ImageView;

/* compiled from: P */
/* loaded from: classes21.dex */
class e {

    /* compiled from: P */
    /* loaded from: classes21.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f327060a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f327060a = iArr;
            try {
                iArr[ImageView.ScaleType.MATRIX.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i3) {
        return (i3 & 65280) >> 8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b(ImageView imageView) {
        if (imageView.getDrawable() != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            return false;
        }
        if (a.f327060a[scaleType.ordinal()] != 1) {
            return true;
        }
        throw new IllegalStateException("Matrix scale type is not supported");
    }
}
