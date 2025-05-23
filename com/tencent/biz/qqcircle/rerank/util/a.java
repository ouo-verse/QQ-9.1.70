package com.tencent.biz.qqcircle.rerank.util;

import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.utils.y;
import e30.b;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.Collection;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a {
    public static Collection<b> a(@NonNull List<b> list, @NonNull List<b> list2, boolean z16) {
        if (z16) {
            return w20.a.j().getUniqueData(b.class, list, list2);
        }
        return y.b(list, list2);
    }

    public static boolean b(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == null) {
            return false;
        }
        String str = feedCloudMeta$StFeed.recomInfo.recomTrace.get();
        if (!str.contains("cloudrerank=1") && !str.contains("edgererank=1")) {
            return false;
        }
        return true;
    }
}
