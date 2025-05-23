package com.tencent.luggage.wxa.ib;

import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f129680a = new b();

    public static final float a(float f16) {
        float f17 = 1.0f;
        if (f16 <= 1.0f) {
            f17 = 0.0f;
            if (f16 >= 0.0f) {
                return f16;
            }
        }
        return f17;
    }

    public final float[] a(int i3, int i16, int i17, Point textureValidLTPoint, Point textureValidRBPoint, int i18, int i19, int i26, Rect rect) {
        float f16;
        float f17;
        float f18;
        Intrinsics.checkNotNullParameter(textureValidLTPoint, "textureValidLTPoint");
        Intrinsics.checkNotNullParameter(textureValidRBPoint, "textureValidRBPoint");
        float[] fArr = com.tencent.luggage.wxa.jb.a.f130931d;
        float[] copyOf = Arrays.copyOf(fArr, fArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        RectF a16 = a(textureValidLTPoint, textureValidRBPoint, i16, i17);
        float f19 = a16.left;
        float f26 = a16.top;
        float f27 = a16.right;
        float f28 = a16.bottom;
        if (i3 == 2) {
            boolean z16 = i18 == 90 || i18 == 270;
            int i27 = textureValidRBPoint.x - textureValidLTPoint.x;
            int i28 = textureValidLTPoint.y - textureValidRBPoint.y;
            int i29 = z16 ? i28 : i27;
            if (!z16) {
                i27 = i28;
            }
            float f29 = i19;
            float f36 = i29;
            float f37 = f29 / f36;
            float f38 = i26;
            float f39 = i27;
            float f46 = f38 / f39;
            float f47 = 0.0f;
            if (f37 < f46) {
                f16 = f36 - (f29 / f46);
            } else if (f37 > f46) {
                f47 = f39 - (f38 / f37);
                f16 = 0.0f;
            } else {
                f16 = 0.0f;
            }
            if (z16) {
                f18 = (f47 / 2.0f) / f39;
                f17 = (f16 / 2.0f) / f36;
            } else {
                float f48 = (f16 / 2.0f) / f36;
                f17 = (f47 / 2.0f) / f39;
                f18 = f48;
            }
            f19 += f18;
            f27 -= f18;
            f28 += f17;
            f26 -= f17;
        } else if (i3 != 3) {
            if (i3 == 4 && rect != null) {
                float f49 = i16;
                float a17 = a(rect.left / f49);
                float a18 = a(rect.right / f49);
                float f56 = i17;
                float a19 = a(rect.bottom / f56);
                float a26 = a(rect.top / f56);
                float abs = Math.abs(f27 - f19);
                float abs2 = Math.abs(f28 - f26);
                f19 += a17 * abs;
                f27 = f19 + (abs * a18);
                f28 = Math.min(f26, f28) + (a19 * abs2);
                f26 = Math.min(f26, f28) + (abs2 * a26);
            }
        } else if (rect != null) {
            int width = rect.width();
            int height = rect.height();
            float f57 = (i16 - width) / i16;
            float f58 = 1.0f - f57;
            if (rect.left == 0) {
                f19 = f57;
                f27 = f58;
            } else {
                f27 = f57;
                f19 = f58;
            }
            if (rect.top == 0) {
                f26 = (i17 - height) / i17;
                f28 = 1.0f - f26;
            } else {
                f28 = (i17 - height) / i17;
                f26 = 1.0f - f28;
            }
        }
        copyOf[0] = f19;
        copyOf[1] = f26;
        copyOf[2] = f27;
        copyOf[3] = f26;
        copyOf[4] = f19;
        copyOf[5] = f28;
        copyOf[6] = f27;
        copyOf[7] = f28;
        return copyOf;
    }

    public final RectF a(Point point, Point point2, int i3, int i16) {
        float f16 = i3;
        float f17 = 1;
        float f18 = i16;
        return new RectF(point.x / f16, (point.y - f17) / f18, (point2.x - f17) / f16, point2.y / f18);
    }

    public final float[] a(int i3, int i16, int i17, Point textureValidLTPoint, Point textureValidRBPoint, int i18, int i19, int i26) {
        float f16;
        float f17;
        Intrinsics.checkNotNullParameter(textureValidLTPoint, "textureValidLTPoint");
        Intrinsics.checkNotNullParameter(textureValidRBPoint, "textureValidRBPoint");
        float[] fArr = com.tencent.luggage.wxa.jb.a.f130930c;
        float[] copyOf = Arrays.copyOf(fArr, fArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        float f18 = -1.0f;
        float f19 = 1.0f;
        if (i3 == 6) {
            boolean z16 = i18 == 90 || i18 == 270;
            int i27 = textureValidRBPoint.x - textureValidLTPoint.x;
            int i28 = textureValidLTPoint.y - textureValidRBPoint.y;
            int i29 = z16 ? i28 : i27;
            if (!z16) {
                i27 = i28;
            }
            float f26 = i19;
            float f27 = i29;
            float f28 = f26 / f27;
            float f29 = i26;
            float f36 = i27;
            float f37 = f29 / f36;
            if (f28 > f37) {
                float f38 = (((f28 - f37) * f27) * 1.0f) / f26;
                f17 = 1.0f - f38;
                f16 = f38 - 1.0f;
            } else {
                float f39 = (((f37 - f28) * f36) * 1.0f) / f29;
                f16 = -1.0f;
                f18 = f39 - 1.0f;
                f17 = 1.0f;
                f19 = 1.0f - f39;
            }
        } else {
            f16 = -1.0f;
            f17 = 1.0f;
        }
        copyOf[0] = f18;
        copyOf[1] = f16;
        copyOf[2] = f19;
        copyOf[3] = f16;
        copyOf[4] = f18;
        copyOf[5] = f17;
        copyOf[6] = f19;
        copyOf[7] = f17;
        return copyOf;
    }
}
