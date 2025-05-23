package com.tencent.mobileqq.guild.feed.feedsquare.utils;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a>\u0010\u0005\u001a\u001e\u0012\f\u0012\n \u0004*\u0004\u0018\u00018\u00008\u0000\u0012\f\u0012\n \u0004*\u0004\u0018\u00018\u00018\u00010\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\u00a8\u0006\u0006"}, d2 = {ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "Landroid/util/Pair;", "Lkotlin/Pair;", "kotlin.jvm.PlatformType", "a", "qqguild_feed_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class r {
    @NotNull
    public static final <A, B> Pair<A, B> a(@NotNull android.util.Pair<A, B> pair) {
        Intrinsics.checkNotNullParameter(pair, "<this>");
        return new Pair<>(pair.first, pair.second);
    }
}
