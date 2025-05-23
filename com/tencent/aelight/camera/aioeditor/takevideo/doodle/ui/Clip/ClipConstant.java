package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.Clip;

import android.graphics.RectF;

/* compiled from: P */
/* loaded from: classes32.dex */
public interface ClipConstant {

    /* renamed from: a, reason: collision with root package name */
    public static final float[] f68030a = {0.0f, 1.0f, 0.33f, 0.66f};

    /* renamed from: b, reason: collision with root package name */
    public static final float[] f68031b = {0.0f, 3.0f, -3.0f};

    /* renamed from: c, reason: collision with root package name */
    public static final float[] f68032c = {0.0f, 48.0f, -48.0f};

    /* renamed from: d, reason: collision with root package name */
    public static final byte[] f68033d = {8, 8, 9, 8, 6, 8, 4, 8, 4, 8, 4, 1, 4, 10, 4, 8, 4, 4, 6, 4, 9, 4, 8, 4, 8, 4, 8, 6, 8, 9, 8, 8};

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public enum Anchor {
        LEFT(1),
        RIGHT(2),
        TOP(4),
        BOTTOM(8),
        LEFT_TOP(5),
        RIGHT_TOP(6),
        LEFT_BOTTOM(9),
        RIGHT_BOTTOM(10);

        static final int[] PN = {1, -1};

        /* renamed from: v, reason: collision with root package name */
        private int f68034v;

        Anchor(int i3) {
            this.f68034v = i3;
        }

        public static boolean isCohesionContains(RectF rectF, float f16, float f17, float f18) {
            return rectF.left + f16 < f17 && rectF.right - f16 > f17 && rectF.top + f16 < f18 && rectF.bottom - f16 > f18;
        }

        public static float revise(float f16, float f17, float f18) {
            return Math.min(Math.max(f16, f17), f18);
        }

        public static float[] cohesion(RectF rectF, float f16) {
            return new float[]{rectF.left + f16, rectF.right - f16, rectF.top + f16, rectF.bottom - f16};
        }

        public static Anchor valueOf(int i3) {
            for (Anchor anchor : values()) {
                if (anchor.f68034v == i3) {
                    return anchor;
                }
            }
            return null;
        }

        public void moveFrame(RectF rectF, RectF rectF2, float f16, float f17) {
            float[] cohesion = cohesion(rectF, 60.0f);
            float[] cohesion2 = cohesion(rectF2, 150.72f);
            float[] cohesion3 = cohesion(rectF2, 0.0f);
            float[] fArr = {f16, 0.0f, f17};
            for (int i3 = 0; i3 < 4; i3++) {
                if (((1 << i3) & this.f68034v) != 0) {
                    int i16 = PN[i3 & 1];
                    float f18 = i16;
                    cohesion3[i3] = f18 * revise((cohesion3[i3] + fArr[i3 & 2]) * f18, cohesion[i3] * f18, cohesion2[i16 + i3] * f18);
                }
            }
            rectF2.set(cohesion3[0], cohesion3[2], cohesion3[1], cohesion3[3]);
        }
    }
}
