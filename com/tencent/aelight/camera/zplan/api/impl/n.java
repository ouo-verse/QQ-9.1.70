package com.tencent.aelight.camera.zplan.api.impl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import com.tencent.aelight.camera.zplan.api.impl.b;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0012\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001a\f\u0010\u0007\u001a\u00020\u0006*\u00020\u0005H\u0002\u001a\u0014\u0010\t\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\b\u001a\u00020\u0006H\u0002\u00a8\u0006\n"}, d2 = {"Lcom/tencent/aelight/camera/zplan/api/impl/b;", "Landroid/graphics/Rect;", "cropRect", "Landroid/graphics/Bitmap;", "e", "Landroid/view/View;", "Landroid/graphics/RectF;", "c", "containerRect", "d", "aelight_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class n {
    /* JADX INFO: Access modifiers changed from: private */
    public static final RectF c(View view) {
        return new RectF(0.0f, 0.0f, view.getWidth(), view.getHeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bitmap d(Bitmap bitmap, RectF rectF) {
        float width;
        float height;
        Pair pair = new Pair(Float.valueOf(rectF.width()), Float.valueOf(rectF.height()));
        float floatValue = ((Number) pair.component1()).floatValue();
        float floatValue2 = ((Number) pair.component2()).floatValue();
        float f16 = 0.0f;
        if (bitmap.getWidth() * floatValue2 > bitmap.getHeight() * floatValue) {
            width = floatValue2 / bitmap.getHeight();
            height = 0.0f;
            f16 = (floatValue - (bitmap.getWidth() * width)) * 0.5f;
        } else {
            width = floatValue / bitmap.getWidth();
            height = (floatValue2 - (bitmap.getHeight() * width)) * 0.5f;
        }
        Matrix matrix = new Matrix();
        matrix.setScale(width, width);
        matrix.postTranslate(f16, height);
        Bitmap createBitmap = Bitmap.createBitmap((int) floatValue, (int) floatValue2, Bitmap.Config.ARGB_8888);
        new Canvas(createBitmap).drawBitmap(bitmap, matrix, null);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(vwidth.toIn\u2026this, matrix, null)\n    }");
        return createBitmap;
    }

    public static final Bitmap e(b bVar, Rect cropRect) {
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        Intrinsics.checkNotNullParameter(cropRect, "cropRect");
        if (bVar instanceof b.ColorBackground) {
            Bitmap createBitmap = Bitmap.createBitmap(cropRect.width(), cropRect.height(), Bitmap.Config.ARGB_8888);
            new Canvas(createBitmap).drawColor(((b.ColorBackground) bVar).getColorInt());
            Intrinsics.checkNotNullExpressionValue(createBitmap, "{\n        cropRect.run {\u2026colorInt)\n        }\n    }");
            return createBitmap;
        }
        if (bVar instanceof b.PicBackground) {
            Bitmap createBitmap2 = Bitmap.createBitmap(((b.PicBackground) bVar).getBackgroundPic(), cropRect.left, cropRect.top, cropRect.width(), cropRect.height());
            Intrinsics.checkNotNullExpressionValue(createBitmap2, "{\n        cropRect.run {\u2026height())\n        }\n    }");
            return createBitmap2;
        }
        throw new NoWhenBranchMatchedException();
    }
}
