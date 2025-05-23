package com.tencent.biz.qqcircle.immersive.views.mixfeed.piclayerpage;

import com.tencent.mobileqq.pb.PBUInt64Field;
import feedcloud.FeedCloudMeta$FeedAlbum;
import feedcloud.FeedCloudMeta$FeedAlbumInfo;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\f\u0010\u0004\u001a\u0004\u0018\u00010\u0003*\u00020\u0000\u001a\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005*\u00020\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lfeedcloud/FeedCloudMeta$StFeed;", "", "c", "", "b", "", "a", "(Lfeedcloud/FeedCloudMeta$StFeed;)Ljava/lang/Long;", "qcircle-plugin-module_release"}, k = 2, mv = {1, 7, 1})
@JvmName(name = "QFSNewContentDetailUtils")
/* loaded from: classes4.dex */
public final class o {
    @Nullable
    public static final Long a(@NotNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        Object orNull;
        FeedCloudMeta$FeedAlbum feedCloudMeta$FeedAlbum;
        PBUInt64Field pBUInt64Field;
        Intrinsics.checkNotNullParameter(feedCloudMeta$StFeed, "<this>");
        List<FeedCloudMeta$FeedAlbumInfo> list = feedCloudMeta$StFeed.album_infos.get();
        Intrinsics.checkNotNullExpressionValue(list, "album_infos.get()");
        orNull = CollectionsKt___CollectionsKt.getOrNull(list, 0);
        FeedCloudMeta$FeedAlbumInfo feedCloudMeta$FeedAlbumInfo = (FeedCloudMeta$FeedAlbumInfo) orNull;
        if (feedCloudMeta$FeedAlbumInfo != null && (feedCloudMeta$FeedAlbum = feedCloudMeta$FeedAlbumInfo.album) != null && (pBUInt64Field = feedCloudMeta$FeedAlbum.f398441id) != null) {
            return Long.valueOf(pBUInt64Field.get());
        }
        return null;
    }

    @Nullable
    public static final String b(@NotNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        FeedCloudMeta$FeedAlbum feedCloudMeta$FeedAlbum;
        Intrinsics.checkNotNullParameter(feedCloudMeta$StFeed, "<this>");
        if (feedCloudMeta$StFeed.album_infos.size() == 0 || (feedCloudMeta$FeedAlbum = feedCloudMeta$StFeed.album_infos.get(0).album.get()) == null) {
            return null;
        }
        return feedCloudMeta$FeedAlbum.title.get() + "\u00b7\u66f4\u65b0\u81f3\u7b2c" + feedCloudMeta$FeedAlbum.feed_count.get() + "\u96c6";
    }

    public static final boolean c(@NotNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        boolean isBlank;
        boolean isBlank2;
        Intrinsics.checkNotNullParameter(feedCloudMeta$StFeed, "<this>");
        String str = feedCloudMeta$StFeed.musicInfo.MID.get();
        String str2 = "";
        if (str == null) {
            str = "";
        }
        String str3 = feedCloudMeta$StFeed.musicInfo.playUrl.get();
        if (str3 != null) {
            str2 = str3;
        }
        isBlank = StringsKt__StringsJVMKt.isBlank(str);
        if (!isBlank) {
            isBlank2 = StringsKt__StringsJVMKt.isBlank(str2);
            if (!isBlank2) {
                return true;
            }
        }
        return false;
    }
}
