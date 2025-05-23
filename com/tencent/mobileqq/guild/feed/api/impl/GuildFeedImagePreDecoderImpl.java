package com.tencent.mobileqq.guild.feed.api.impl;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedImagePreDecoder;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0096\u0001J#\u0010\b\u001a\u00020\t2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0096\u0001\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/api/impl/GuildFeedImagePreDecoderImpl;", "Lcom/tencent/mobileqq/guild/feed/api/IGuildFeedImagePreDecoder;", "()V", "get", "Landroid/graphics/drawable/Drawable;", "allUrlList", "", "", "putIfAbsent", "", "drawable", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public final class GuildFeedImagePreDecoderImpl implements IGuildFeedImagePreDecoder {
    private final /* synthetic */ GuildFeedImagePreDecoder $$delegate_0 = GuildFeedImagePreDecoder.INSTANCE;

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedImagePreDecoder
    @Nullable
    public Drawable get(@NotNull List<String> allUrlList) {
        Intrinsics.checkNotNullParameter(allUrlList, "allUrlList");
        return this.$$delegate_0.get(allUrlList);
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedImagePreDecoder
    public void putIfAbsent(@NotNull List<String> allUrlList, @Nullable Drawable drawable) {
        Intrinsics.checkNotNullParameter(allUrlList, "allUrlList");
        this.$$delegate_0.putIfAbsent(allUrlList, drawable);
    }
}
