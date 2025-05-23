package com.tencent.mobileqq.guild.component.multitouchimg;

import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes12.dex */
class q {

    /* compiled from: P */
    /* loaded from: classes12.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f216013a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f216013a = iArr;
            try {
                iArr[ImageView.ScaleType.MATRIX.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(float f16, float f17, float f18) {
        if (f16 >= f17) {
            QLog.e("multitouch_util", 1, "[checkZoomLevels] minZoom=" + f16 + ", midZoom=" + f17 + ", Minimum zoom has to be less than Medium zoom. Call setMinimumZoom() with a more appropriate value");
            return;
        }
        if (f17 >= f18) {
            QLog.e("multitouch_util", 1, "[checkZoomLevels] midZoom=" + f17 + ", maxZoom=" + f18 + ", Medium zoom has to be less than Maximum zoom. Call setMaximumZoom() with a more appropriate value");
        }
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
        if (a.f216013a[scaleType.ordinal()] != 1) {
            return true;
        }
        throw new IllegalStateException("Matrix scale type is not supported");
    }
}
