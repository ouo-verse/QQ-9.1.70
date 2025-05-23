package o40;

import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import feedcloud.FeedCloudMeta$RoomInfoData;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StLive;
import feedcloud.FeedCloudMeta$StVideo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u0010\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000\u001a\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000\u001a\u0010\u0010\u0007\u001a\u00020\u00062\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000\u001a\u0010\u0010\b\u001a\u00020\u00042\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000\u001a\u0010\u0010\t\u001a\u00020\u00042\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000\u00a8\u0006\n"}, d2 = {"Lfeedcloud/FeedCloudMeta$StFeed;", "feed", "", "b", "", "c", "", "a", "e", "d", "qcircle-plugin-module_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class a {
    /* JADX WARN: Removed duplicated region for block: B:10:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002b  */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final String a(@Nullable FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        boolean z16;
        boolean isBlank;
        if (feedCloudMeta$StFeed == null) {
            return "";
        }
        String str = feedCloudMeta$StFeed.cover.layerPicUrl.get();
        if (str != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank) {
                z16 = false;
                if (!z16) {
                    String str2 = feedCloudMeta$StFeed.cover.picUrl.get();
                    Intrinsics.checkNotNullExpressionValue(str2, "{\n        feed.cover.picUrl.get()\n    }");
                    return str2;
                }
                String str3 = feedCloudMeta$StFeed.cover.layerPicUrl.get();
                Intrinsics.checkNotNullExpressionValue(str3, "{\n        feed.cover.layerPicUrl.get()\n    }");
                return str3;
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    public static final long b(@Nullable FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        FeedCloudMeta$StLive feedCloudMeta$StLive;
        FeedCloudMeta$RoomInfoData feedCloudMeta$RoomInfoData;
        PBUInt64Field pBUInt64Field;
        if (feedCloudMeta$StFeed != null && (feedCloudMeta$StLive = feedCloudMeta$StFeed.live) != null && (feedCloudMeta$RoomInfoData = feedCloudMeta$StLive.room) != null && (pBUInt64Field = feedCloudMeta$RoomInfoData.roomId) != null) {
            return pBUInt64Field.get();
        }
        return 0L;
    }

    public static final int c(@Nullable FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        FeedCloudMeta$StLive feedCloudMeta$StLive;
        FeedCloudMeta$RoomInfoData feedCloudMeta$RoomInfoData;
        PBUInt32Field pBUInt32Field;
        if (feedCloudMeta$StFeed != null && (feedCloudMeta$StLive = feedCloudMeta$StFeed.live) != null && (feedCloudMeta$RoomInfoData = feedCloudMeta$StLive.room) != null && (pBUInt32Field = feedCloudMeta$RoomInfoData.roomType) != null) {
            return pBUInt32Field.get();
        }
        return 0;
    }

    public static final int d(@Nullable FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        FeedCloudMeta$StVideo feedCloudMeta$StVideo;
        FeedCloudMeta$StVideo feedCloudMeta$StVideo2;
        PBUInt32Field pBUInt32Field;
        if (feedCloudMeta$StFeed != null && (feedCloudMeta$StVideo = feedCloudMeta$StFeed.video) != null && (feedCloudMeta$StVideo2 = feedCloudMeta$StVideo.get()) != null && (pBUInt32Field = feedCloudMeta$StVideo2.height) != null) {
            return pBUInt32Field.get();
        }
        return 0;
    }

    public static final int e(@Nullable FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        FeedCloudMeta$StVideo feedCloudMeta$StVideo;
        FeedCloudMeta$StVideo feedCloudMeta$StVideo2;
        PBUInt32Field pBUInt32Field;
        if (feedCloudMeta$StFeed != null && (feedCloudMeta$StVideo = feedCloudMeta$StFeed.video) != null && (feedCloudMeta$StVideo2 = feedCloudMeta$StVideo.get()) != null && (pBUInt32Field = feedCloudMeta$StVideo2.width) != null) {
            return pBUInt32Field.get();
        }
        return 0;
    }
}
