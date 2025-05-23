package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.Clip;

import android.graphics.Matrix;
import android.graphics.RectF;

/* compiled from: P */
/* loaded from: classes32.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final Matrix f68035a = new Matrix();

    public static void a(RectF rectF, RectF rectF2) {
        rectF2.offset(rectF.centerX() - rectF2.centerX(), rectF.centerY() - rectF2.centerY());
    }

    public static xr.b b(RectF rectF, RectF rectF2) {
        xr.b bVar = new xr.b(0.0f, 0.0f, 1.0f, 0.0f);
        if (rectF.equals(rectF2)) {
            return bVar;
        }
        bVar.f448423c = Math.max(rectF.width() / rectF2.width(), rectF.height() / rectF2.height());
        RectF rectF3 = new RectF();
        Matrix matrix = f68035a;
        float f16 = bVar.f448423c;
        matrix.setScale(f16, f16, rectF2.centerX(), rectF2.centerY());
        matrix.mapRect(rectF3, rectF2);
        bVar.f448421a += rectF.centerX() - rectF3.centerX();
        bVar.f448422b += rectF.centerY() - rectF3.centerY();
        return bVar;
    }

    public static xr.b c(RectF rectF, RectF rectF2, float f16, float f17) {
        xr.b bVar = new xr.b(0.0f, 0.0f, 1.0f, 0.0f);
        if (rectF2.contains(rectF)) {
            return bVar;
        }
        if (rectF2.width() < rectF.width() || rectF2.height() < rectF.height()) {
            bVar.f448423c = Math.max(rectF.width() / rectF2.width(), rectF.height() / rectF2.height());
        }
        RectF rectF3 = new RectF();
        Matrix matrix = f68035a;
        float f18 = bVar.f448423c;
        matrix.setScale(f18, f18, f16, f17);
        matrix.mapRect(rectF3, rectF2);
        float f19 = rectF3.left;
        float f26 = rectF.left;
        if (f19 > f26) {
            bVar.f448421a += f26 - f19;
        } else {
            float f27 = rectF3.right;
            float f28 = rectF.right;
            if (f27 < f28) {
                bVar.f448421a += f28 - f27;
            }
        }
        float f29 = rectF3.top;
        float f36 = rectF.top;
        if (f29 > f36) {
            bVar.f448422b += f36 - f29;
        } else {
            float f37 = rectF3.bottom;
            float f38 = rectF.bottom;
            if (f37 < f38) {
                bVar.f448422b += f38 - f37;
            }
        }
        return bVar;
    }

    public static void e(RectF rectF, RectF rectF2, float f16, float f17, float f18, float f19) {
        if (rectF.isEmpty() || rectF2.isEmpty()) {
            return;
        }
        if (rectF.width() < f16 + f18) {
            f16 = 0.0f;
            f18 = 0.0f;
        }
        if (rectF.height() < f17 + f19) {
            f17 = 0.0f;
            f19 = 0.0f;
        }
        float min = Math.min(((rectF.width() - f16) - f18) / rectF2.width(), ((rectF.height() - f17) - f19) / rectF2.height());
        rectF2.set(0.0f, 0.0f, rectF2.width() * min, rectF2.height() * min);
        rectF2.offset((rectF.centerX() + ((f16 - f18) / 2.0f)) - rectF2.centerX(), (rectF.centerY() + ((f17 - f19) / 2.0f)) - rectF2.centerY());
    }

    public static xr.b f(RectF rectF, RectF rectF2, float f16, float f17) {
        xr.b bVar = new xr.b(0.0f, 0.0f, 1.0f, 0.0f);
        if (rectF2.contains(rectF)) {
            return bVar;
        }
        if (rectF2.width() < rectF.width() && rectF2.height() < rectF.height()) {
            bVar.f448423c = Math.min(rectF.width() / rectF2.width(), rectF.height() / rectF2.height());
        }
        RectF rectF3 = new RectF();
        Matrix matrix = f68035a;
        float f18 = bVar.f448423c;
        matrix.setScale(f18, f18, f16, f17);
        matrix.mapRect(rectF3, rectF2);
        if (rectF3.width() < rectF.width()) {
            bVar.f448421a += rectF.centerX() - rectF3.centerX();
        } else {
            float f19 = rectF3.left;
            float f26 = rectF.left;
            if (f19 > f26) {
                bVar.f448421a += f26 - f19;
            } else {
                float f27 = rectF3.right;
                float f28 = rectF.right;
                if (f27 < f28) {
                    bVar.f448421a += f28 - f27;
                }
            }
        }
        if (rectF3.height() < rectF.height()) {
            bVar.f448422b += rectF.centerY() - rectF3.centerY();
        } else {
            float f29 = rectF3.top;
            float f36 = rectF.top;
            if (f29 > f36) {
                bVar.f448422b += f36 - f29;
            } else {
                float f37 = rectF3.bottom;
                float f38 = rectF.bottom;
                if (f37 < f38) {
                    bVar.f448422b += f38 - f37;
                }
            }
        }
        return bVar;
    }

    public static void d(RectF rectF, RectF rectF2, float f16) {
        e(rectF, rectF2, f16, f16, f16, f16);
    }
}
