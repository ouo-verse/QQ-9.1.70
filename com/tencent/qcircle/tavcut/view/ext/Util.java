package com.tencent.qcircle.tavcut.view.ext;

import android.widget.ImageView;

/* compiled from: P */
/* loaded from: classes22.dex */
class Util {

    /* compiled from: P */
    /* renamed from: com.tencent.qcircle.tavcut.view.ext.Util$1, reason: invalid class name */
    /* loaded from: classes22.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$widget$ImageView$ScaleType;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            $SwitchMap$android$widget$ImageView$ScaleType = iArr;
            try {
                iArr[ImageView.ScaleType.MATRIX.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    Util() {
    }

    static void checkZoomLevels(float f16, float f17, float f18) {
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
    public static int getPointerIndex(int i3) {
        return (i3 & 65280) >> 8;
    }

    static boolean hasDrawable(ImageView imageView) {
        if (imageView.getDrawable() != null) {
            return true;
        }
        return false;
    }

    static boolean isSupportedScaleType(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            return false;
        }
        if (AnonymousClass1.$SwitchMap$android$widget$ImageView$ScaleType[scaleType.ordinal()] != 1) {
            return true;
        }
        throw new IllegalStateException("Matrix scale type is not supported");
    }
}
