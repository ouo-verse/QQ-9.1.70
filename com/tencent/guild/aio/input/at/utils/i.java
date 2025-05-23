package com.tencent.guild.aio.input.at.utils;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.theme.SkinnableBitmapDrawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ-\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/guild/aio/input/at/utils/i;", "", "Landroid/content/Context;", "context", "", "drawableRes", "filterColor", "Landroid/graphics/drawable/Drawable;", "a", "(Landroid/content/Context;ILjava/lang/Integer;)Landroid/graphics/drawable/Drawable;", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final i f111117a = new i();

    i() {
    }

    @Nullable
    public final Drawable a(@NotNull Context context, @DrawableRes int drawableRes, @ColorRes @Nullable Integer filterColor) {
        Drawable mutate;
        Intrinsics.checkNotNullParameter(context, "context");
        Drawable drawable = ResourcesCompat.getDrawable(context.getResources(), drawableRes, null);
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof SkinnableBitmapDrawable) {
            mutate = ((SkinnableBitmapDrawable) drawable).mutate2();
            Intrinsics.checkNotNullExpressionValue(mutate, "{\n            drawable.mutate2()\n        }");
        } else {
            mutate = drawable.mutate();
            Intrinsics.checkNotNullExpressionValue(mutate, "{\n            drawable.mutate()\n        }");
        }
        if (filterColor != null) {
            mutate.setColorFilter(new PorterDuffColorFilter(context.getResources().getColor(filterColor.intValue()), PorterDuff.Mode.SRC_IN));
        }
        return mutate;
    }
}
