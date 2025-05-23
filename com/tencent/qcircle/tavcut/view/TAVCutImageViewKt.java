package com.tencent.qcircle.tavcut.view;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.RectF;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003\u001a \u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n\u00a8\u0006\u000b"}, d2 = {"calcDistance", "", "a", "Landroid/graphics/PointF;", "b", "calculateBitmap", "Landroid/graphics/RectF;", "containerWidth", "containerHeight", MimeHelper.IMAGE_SUBTYPE_BITMAP, "Landroid/graphics/Bitmap;", "libtavcut_debug"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes22.dex */
public final class TAVCutImageViewKt {
    public static final float calcDistance(@NotNull PointF a16, @NotNull PointF b16) {
        Intrinsics.checkParameterIsNotNull(a16, "a");
        Intrinsics.checkParameterIsNotNull(b16, "b");
        double d16 = 2;
        return (float) Math.sqrt(((float) Math.pow(a16.x - b16.x, d16)) + ((float) Math.pow(a16.y - b16.y, d16)));
    }

    @Nullable
    public static final RectF calculateBitmap(float f16, float f17, @NotNull Bitmap bitmap) {
        Intrinsics.checkParameterIsNotNull(bitmap, "bitmap");
        float width = bitmap.getWidth();
        float height = bitmap.getHeight();
        float min = Math.min(f16 / width, f17 / height);
        float f18 = width * min;
        float f19 = height * min;
        float f26 = 2;
        return new RectF((f16 - f18) / f26, (f17 - f19) / f26, (f16 + f18) / f26, (f17 + f19) / f26);
    }
}
