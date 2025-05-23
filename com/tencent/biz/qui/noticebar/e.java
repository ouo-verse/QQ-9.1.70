package com.tencent.biz.qui.noticebar;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import androidx.annotation.DrawableRes;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u0012\u0010\u0004\u001a\u00020\u00002\b\b\u0001\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\t\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0002H&J\u0010\u0010\u000b\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\nH&J\u0010\u0010\f\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/biz/qui/noticebar/e;", "Lcom/tencent/biz/qui/noticebar/a;", "", "iconId", "setIcon", "Landroid/graphics/drawable/Drawable;", "drawable", h.F, "color", "d", "Landroid/content/res/ColorStateList;", "setLinkTextColor", "l", "QUINoticeBar_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes5.dex */
public interface e extends a<e> {
    @NotNull
    e d(int color);

    @NotNull
    e h(@NotNull Drawable drawable);

    @NotNull
    e l(@NotNull Drawable drawable);

    @NotNull
    e setIcon(@DrawableRes int iconId);

    @NotNull
    e setLinkTextColor(@NotNull ColorStateList color);
}
