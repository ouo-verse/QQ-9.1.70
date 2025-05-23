package com.tencent.mobileqq.guild.widget;

import android.content.Context;
import android.widget.ImageView;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003\u00a8\u0006\u0007"}, d2 = {"Landroid/widget/ImageView;", "Lcom/tencent/mobileqq/guild/widget/TitleBarTheme;", "titleBarTheme", "Lcom/tencent/mobileqq/guild/widget/IconType;", "iconType", "", "a", "qqguild-api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class h {
    public static final void a(@NotNull ImageView imageView, @NotNull TitleBarTheme titleBarTheme, @NotNull IconType iconType) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(titleBarTheme, "titleBarTheme");
        Intrinsics.checkNotNullParameter(iconType, "iconType");
        Context context = imageView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        int iconRes = iconType.getIconRes();
        Context context2 = imageView.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        imageView.setImageDrawable(GuildUIUtils.y(context, iconRes, titleBarTheme.getIconColor(context2)));
    }
}
