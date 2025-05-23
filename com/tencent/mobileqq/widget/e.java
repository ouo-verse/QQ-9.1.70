package com.tencent.mobileqq.widget;

import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;

/* compiled from: P */
/* loaded from: classes20.dex */
public abstract class e implements AnyScaleTypeImageView.a {

    /* renamed from: a, reason: collision with root package name */
    public static final AnyScaleTypeImageView.a f316872a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final AnyScaleTypeImageView.a f316873b = new b();

    /* renamed from: c, reason: collision with root package name */
    public static final AnyScaleTypeImageView.a f316874c = new c();

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements AnyScaleTypeImageView.a {
        a() {
        }

        @Override // com.tencent.mobileqq.widget.AnyScaleTypeImageView.a
        public Matrix a(Drawable drawable, int i3, int i16) {
            float f16;
            float f17;
            float f18;
            Matrix matrix = new Matrix();
            if (drawable == null) {
                return matrix;
            }
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth == intrinsicHeight) {
                float f19 = i16 / intrinsicHeight;
                matrix.setScale(f19, f19);
            } else {
                float f26 = 0.0f;
                if (intrinsicWidth > i3 && intrinsicHeight > i16) {
                    if (intrinsicWidth * i16 > i3 * intrinsicHeight) {
                        f18 = i16 / intrinsicHeight;
                        f26 = (i3 - (intrinsicWidth * f18)) * 0.5f;
                        f17 = 0.0f;
                    } else {
                        float f27 = i3 / intrinsicWidth;
                        float f28 = (i16 - intrinsicHeight) * f27;
                        if (f28 < 0.0f) {
                            f17 = f28 * 0.1f;
                        } else {
                            f17 = f28 * 0.5f;
                        }
                        f18 = f27;
                    }
                    matrix.setScale(f18, f18);
                    matrix.postTranslate((int) (f26 + 0.5f), (int) (f17 + 0.5f));
                } else {
                    float f29 = (i3 - intrinsicWidth) * 0.5f;
                    float f36 = i16 - intrinsicHeight;
                    if (f36 < 0.0f) {
                        f16 = f36 * 0.1f;
                    } else {
                        f16 = f36 * 0.5f;
                    }
                    matrix.postTranslate((int) (f29 + 0.5f), (int) (f16 + 0.5f));
                }
            }
            return matrix;
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class b implements AnyScaleTypeImageView.a {
        b() {
        }

        @Override // com.tencent.mobileqq.widget.AnyScaleTypeImageView.a
        public Matrix a(Drawable drawable, int i3, int i16) {
            Matrix matrix = new Matrix();
            if (drawable == null) {
                return matrix;
            }
            float max = Math.max(i3 / drawable.getIntrinsicWidth(), i16 / drawable.getIntrinsicHeight());
            matrix.setScale(max, max);
            float f16 = (int) 0.5f;
            matrix.postTranslate(f16, f16);
            return matrix;
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class c implements AnyScaleTypeImageView.a {
        c() {
        }

        @Override // com.tencent.mobileqq.widget.AnyScaleTypeImageView.a
        public Matrix a(Drawable drawable, int i3, int i16) {
            Matrix matrix = new Matrix();
            if (drawable == null) {
                return matrix;
            }
            float intrinsicWidth = i3 / drawable.getIntrinsicWidth();
            matrix.setScale(intrinsicWidth, intrinsicWidth);
            return matrix;
        }
    }
}
