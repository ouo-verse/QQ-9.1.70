package com.tencent.biz.qqcircle.immersive.utils;

import feedcloud.FeedCloudCommon$Entry;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class af {
    public static String a(List<FeedCloudCommon$Entry> list, String str) {
        if (list != null && list.size() > 0) {
            for (FeedCloudCommon$Entry feedCloudCommon$Entry : list) {
                if (feedCloudCommon$Entry.key.get().equals(str)) {
                    return feedCloudCommon$Entry.value.get();
                }
            }
        }
        return "";
    }
}
