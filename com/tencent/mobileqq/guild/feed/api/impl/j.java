package com.tencent.mobileqq.guild.feed.api.impl;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0018\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\u001a \u0010\u0007\u001a\u00020\u0004*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/api/impl/GuildFeedImagePreDecoder;", "", "", "allUrlList", "Landroid/graphics/drawable/Drawable;", "b", "drawable", "a", "qqguild_feed_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class j {
    @NotNull
    public static final Drawable a(@NotNull GuildFeedImagePreDecoder guildFeedImagePreDecoder, @NotNull List<String> allUrlList, @NotNull Drawable drawable) {
        Intrinsics.checkNotNullParameter(guildFeedImagePreDecoder, "<this>");
        Intrinsics.checkNotNullParameter(allUrlList, "allUrlList");
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        BitmapDrawable bitmapDrawable = guildFeedImagePreDecoder.get(allUrlList);
        if (bitmapDrawable != null) {
            return bitmapDrawable;
        }
        return drawable;
    }

    @NotNull
    public static final Drawable b(@NotNull GuildFeedImagePreDecoder guildFeedImagePreDecoder, @NotNull List<String> allUrlList) {
        Intrinsics.checkNotNullParameter(guildFeedImagePreDecoder, "<this>");
        Intrinsics.checkNotNullParameter(allUrlList, "allUrlList");
        Drawable TRANSPARENT = com.tencent.mobileqq.urldrawable.b.f306350a;
        Intrinsics.checkNotNullExpressionValue(TRANSPARENT, "TRANSPARENT");
        return a(guildFeedImagePreDecoder, allUrlList, TRANSPARENT);
    }
}
