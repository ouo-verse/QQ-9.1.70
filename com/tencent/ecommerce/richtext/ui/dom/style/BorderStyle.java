package com.tencent.ecommerce.richtext.ui.dom.style;

import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.support.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes5.dex */
public enum BorderStyle {
    SOLID,
    DASHED,
    DOTTED;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f105334a;

        static {
            int[] iArr = new int[BorderStyle.values().length];
            f105334a = iArr;
            try {
                iArr[BorderStyle.DOTTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f105334a[BorderStyle.DASHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public Shader getLineShader(float f16, int i3, int i16) {
        int i17 = a.f105334a[ordinal()];
        if (i17 != 1) {
            if (i17 != 2) {
                return null;
            }
            if (i16 != 1 && i16 != 3) {
                if (i16 == 2 || i16 == 4) {
                    return new LinearGradient(0.0f, 0.0f, f16 * 6.0f, 0.0f, new int[]{i3, 0}, new float[]{0.5f, 0.5f}, Shader.TileMode.REPEAT);
                }
            } else {
                return new LinearGradient(0.0f, 0.0f, 0.0f, f16 * 6.0f, new int[]{i3, 0}, new float[]{0.5f, 0.5f}, Shader.TileMode.REPEAT);
            }
        } else if (i16 != 1 && i16 != 3) {
            if (i16 == 2 || i16 == 4) {
                return new LinearGradient(0.0f, 0.0f, f16 * 2.0f, 0.0f, new int[]{i3, 0}, new float[]{0.5f, 0.5f}, Shader.TileMode.REPEAT);
            }
        } else {
            return new LinearGradient(0.0f, 0.0f, 0.0f, f16 * 2.0f, new int[]{i3, 0}, new float[]{0.5f, 0.5f}, Shader.TileMode.REPEAT);
        }
        return null;
    }
}
