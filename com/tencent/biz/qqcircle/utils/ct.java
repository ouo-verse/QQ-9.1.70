package com.tencent.biz.qqcircle.utils;

import feedcloud.FeedCloudMeta$StImage;
import feedcloud.FeedCloudMeta$StImageUrl;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\"\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0015\u0010\b\u001a\u00020\u0005*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\"\u0015\u0010\n\u001a\u00020\u0005*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lfeedcloud/FeedCloudMeta$StImage;", "", "a", "(Lfeedcloud/FeedCloudMeta$StImage;)Z", "hasMaskLevel", "", "c", "(Lfeedcloud/FeedCloudMeta$StImage;)Ljava/lang/String;", "urlForEmoji", "b", "urlForDownload", "qcircle-plugin-module_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class ct {
    public static final boolean a(@NotNull FeedCloudMeta$StImage feedCloudMeta$StImage) {
        Object obj;
        boolean z16;
        Intrinsics.checkNotNullParameter(feedCloudMeta$StImage, "<this>");
        if (feedCloudMeta$StImage.vecImageUrl.isEmpty()) {
            return false;
        }
        List<FeedCloudMeta$StImageUrl> list = feedCloudMeta$StImage.vecImageUrl.get();
        Intrinsics.checkNotNullExpressionValue(list, "vecImageUrl.get()");
        Iterator<T> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((FeedCloudMeta$StImageUrl) obj).levelType.get() == 4) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        if (((FeedCloudMeta$StImageUrl) obj) == null) {
            return false;
        }
        return true;
    }

    @NotNull
    public static final String b(@NotNull FeedCloudMeta$StImage feedCloudMeta$StImage) {
        Object obj;
        boolean z16;
        Intrinsics.checkNotNullParameter(feedCloudMeta$StImage, "<this>");
        if (feedCloudMeta$StImage.vecImageUrl.isEmpty()) {
            return "";
        }
        List<FeedCloudMeta$StImageUrl> list = feedCloudMeta$StImage.vecImageUrl.get();
        Intrinsics.checkNotNullExpressionValue(list, "vecImageUrl.get()");
        Iterator<T> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((FeedCloudMeta$StImageUrl) obj).levelType.get() == 4) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        FeedCloudMeta$StImageUrl feedCloudMeta$StImageUrl = (FeedCloudMeta$StImageUrl) obj;
        if (feedCloudMeta$StImageUrl != null) {
            String str = feedCloudMeta$StImageUrl.url.get();
            Intrinsics.checkNotNullExpressionValue(str, "it.url.get()");
            return str;
        }
        String str2 = feedCloudMeta$StImage.picUrl.get();
        Intrinsics.checkNotNullExpressionValue(str2, "picUrl.get()");
        return str2;
    }

    @NotNull
    public static final String c(@NotNull FeedCloudMeta$StImage feedCloudMeta$StImage) {
        Object obj;
        boolean z16;
        Intrinsics.checkNotNullParameter(feedCloudMeta$StImage, "<this>");
        if (feedCloudMeta$StImage.vecImageUrl.isEmpty()) {
            String str = feedCloudMeta$StImage.picUrl.get();
            Intrinsics.checkNotNullExpressionValue(str, "picUrl.get()");
            return str;
        }
        List<FeedCloudMeta$StImageUrl> list = feedCloudMeta$StImage.vecImageUrl.get();
        Intrinsics.checkNotNullExpressionValue(list, "vecImageUrl.get()");
        Iterator<T> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((FeedCloudMeta$StImageUrl) obj).levelType.get() == 5) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        FeedCloudMeta$StImageUrl feedCloudMeta$StImageUrl = (FeedCloudMeta$StImageUrl) obj;
        if (feedCloudMeta$StImageUrl != null) {
            String str2 = feedCloudMeta$StImageUrl.url.get();
            Intrinsics.checkNotNullExpressionValue(str2, "it.url.get()");
            return str2;
        }
        String str3 = feedCloudMeta$StImage.picUrl.get();
        Intrinsics.checkNotNullExpressionValue(str3, "picUrl.get()");
        return str3;
    }
}
