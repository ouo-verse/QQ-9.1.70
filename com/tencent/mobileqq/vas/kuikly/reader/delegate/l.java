package com.tencent.mobileqq.vas.kuikly.reader.delegate;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a$\u0010\u0005\u001a\u0004\u0018\u00010\u0001*\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u001a\u0012\u0010\t\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\n"}, d2 = {"Landroid/view/View;", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "Landroid/graphics/Canvas;", PM.CANVAS, "a", "Lcom/tencent/mobileqq/vas/kuikly/reader/delegate/e;", "canvasRecorder", "", "b", "vas-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class l {
    @Nullable
    public static final Bitmap a(@NotNull View view, @Nullable Bitmap bitmap, @Nullable Canvas canvas) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        if (view.getWidth() <= 0 || view.getHeight() <= 0) {
            return null;
        }
        if (bitmap != null && bitmap.getWidth() == view.getWidth() && bitmap.getHeight() == view.getHeight()) {
            bitmap.eraseColor(0);
        } else {
            if (bitmap != null) {
                bitmap.recycle();
            }
            bitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        }
        if (canvas == null) {
            canvas = new Canvas();
        }
        canvas.setBitmap(bitmap);
        canvas.save();
        canvas.translate(-view.getScrollX(), -view.getScrollY());
        view.draw(canvas);
        canvas.restore();
        canvas.setBitmap(null);
        bitmap.prepareToDraw();
        return bitmap;
    }

    public static final void b(@NotNull View view, @NotNull e canvasRecorder) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(canvasRecorder, "canvasRecorder");
        if (view.getWidth() > 0 && view.getHeight() > 0) {
            try {
                Canvas a16 = canvasRecorder.a(view.getWidth(), view.getHeight());
                int save = a16.save();
                try {
                    view.draw(a16);
                } finally {
                    a16.restoreToCount(save);
                }
            } finally {
                canvasRecorder.b();
            }
        }
    }
}
