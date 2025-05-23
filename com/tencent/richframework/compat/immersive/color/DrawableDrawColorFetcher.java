package com.tencent.richframework.compat.immersive.color;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Pair;
import android.view.View;
import com.tencent.gdtad.jsbridge.GdtGetUserInfoHandler;
import com.tencent.richframework.compat.immersive.color.IColorFetcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016J$\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/richframework/compat/immersive/color/DrawableDrawColorFetcher;", "Lcom/tencent/richframework/compat/immersive/color/CanvasDrawColorFetcher;", "()V", "canHandle", "", "drawable", "Landroid/graphics/drawable/Drawable;", "view", "Landroid/view/View;", "getColor", "Landroid/util/Pair;", "", GdtGetUserInfoHandler.KEY_AREA, "Lcom/tencent/richframework/compat/immersive/color/IColorFetcher$Area;", "compat-auto-immersive_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class DrawableDrawColorFetcher extends CanvasDrawColorFetcher {
    @Override // com.tencent.richframework.compat.immersive.color.IColorFetcher
    public boolean canHandle(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.getBackground() != null) {
            Drawable background = view.getBackground();
            Intrinsics.checkNotNullExpressionValue(background, "view.background");
            if (canHandle(background)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.richframework.compat.immersive.color.IColorFetcher
    @NotNull
    public Pair<Boolean, Integer> getColor(@NotNull View view, @NotNull IColorFetcher.Area area) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(area, "area");
        Drawable background = view.getBackground();
        Intrinsics.checkNotNullExpressionValue(background, "view.background");
        return super.getColor(background, area);
    }

    public boolean canHandle(@NotNull Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        return drawable.getClass().getClassLoader() != ColorDrawable.class.getClassLoader();
    }
}
