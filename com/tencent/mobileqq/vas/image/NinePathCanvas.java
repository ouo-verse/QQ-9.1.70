package com.tencent.mobileqq.vas.image;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.qq.e.comm.managers.plugin.PM;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/vas/image/NinePathCanvas;", "", "()V", "paint", "Landroid/graphics/Paint;", "draw", "", PM.CANVAS, "Landroid/graphics/Canvas;", "bm", "Landroid/graphics/Bitmap;", "bounds", "Landroid/graphics/Rect;", "setPaint", "", "vas_kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class NinePathCanvas {

    @Nullable
    private Paint paint;

    public final boolean draw(@NotNull Canvas canvas, @NotNull Bitmap bm5, @Nullable Rect bounds) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(bm5, "bm");
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        int width2 = bm5.getWidth();
        int height2 = bm5.getHeight();
        int i3 = 0;
        if (width < 1 || height < 1 || width2 < 1 || height2 < 1) {
            return false;
        }
        float f16 = width;
        float f17 = height;
        float f18 = 0.33333334f / (((height2 * f16) / f17) / width2);
        float[] fArr = new float[16];
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = f18;
        fArr[3] = 0.0f;
        float f19 = 1.0f - f18;
        fArr[4] = f19;
        fArr[5] = 0.0f;
        fArr[6] = 1.0f;
        fArr[7] = 0.0f;
        fArr[8] = 0.0f;
        fArr[9] = 1.0f;
        fArr[10] = f18;
        fArr[11] = 1.0f;
        fArr[12] = f19;
        fArr[13] = 1.0f;
        fArr[14] = 1.0f;
        fArr[15] = 1.0f;
        int i16 = 0;
        while (i3 < 16) {
            float f26 = fArr[i3];
            int i17 = i16 + 1;
            if (i16 % 2 == 0) {
                fArr[i16] = f26 * f16;
            } else {
                fArr[i16] = f26 * f17;
            }
            i3++;
            i16 = i17;
        }
        canvas.drawBitmapMesh(bm5, 3, 1, fArr, 0, null, 0, this.paint);
        return true;
    }

    public final void setPaint(@NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        this.paint = paint;
    }
}
