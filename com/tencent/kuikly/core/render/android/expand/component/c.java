package com.tencent.kuikly.core.render.android.expand.component;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0002\u00a8\u0006\u0003"}, d2 = {"Landroid/view/View;", "Landroid/graphics/Bitmap;", "b", "core-render-android_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class c {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Bitmap b(View view) {
        Bitmap bitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(bitmap));
        Intrinsics.checkNotNullExpressionValue(bitmap, "bitmap");
        return bitmap;
    }
}
