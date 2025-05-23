package com.tencent.mobileqq.wink.editor.clipping.timeline.reorder;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/reorder/o;", "Landroid/graphics/drawable/BitmapDrawable;", "Landroid/graphics/Canvas;", PM.CANVAS, "", "draw", "Landroid/content/res/Resources;", "res", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "<init>", "(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class o extends BitmapDrawable {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(@NotNull Resources res, @Nullable Bitmap bitmap) {
        super(res, bitmap);
        Intrinsics.checkNotNullParameter(res, "res");
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void draw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (getBitmap() != null && !getBitmap().isRecycled()) {
            super.draw(canvas);
        }
    }
}
