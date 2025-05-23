package com.tencent.biz.qui.noticebar;

import android.graphics.drawable.Drawable;
import androidx.annotation.DrawableRes;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u0012\u0010\u0004\u001a\u00020\u00002\b\b\u0001\u0010\u0003\u001a\u00020\u0002H&J\u0012\u0010\u0004\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/biz/qui/noticebar/d;", "Lcom/tencent/biz/qui/noticebar/a;", "", "iconId", "setIcon", "Landroid/graphics/drawable/Drawable;", "icon", "QUINoticeBar_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes5.dex */
public interface d extends a<d> {
    @NotNull
    d setIcon(@DrawableRes int iconId);

    @NotNull
    d setIcon(@Nullable Drawable icon);
}
