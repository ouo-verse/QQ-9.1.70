package com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/LongFeedParseSceneType;", "", "a", "qqguild_feed_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class c {
    public static final boolean a(@NotNull LongFeedParseSceneType longFeedParseSceneType) {
        Intrinsics.checkNotNullParameter(longFeedParseSceneType, "<this>");
        if (longFeedParseSceneType == LongFeedParseSceneType.SHARE) {
            return true;
        }
        return false;
    }
}
