package com.tencent.biz.qqcircle.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudCommon$StCommonExt;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class bh {
    public static void a(PBRepeatMessageField<FeedCloudCommon$Entry> pBRepeatMessageField, String str, String str2) {
        if (pBRepeatMessageField != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            FeedCloudCommon$Entry feedCloudCommon$Entry = new FeedCloudCommon$Entry();
            feedCloudCommon$Entry.key.set(str);
            feedCloudCommon$Entry.value.set(str2);
            pBRepeatMessageField.add(feedCloudCommon$Entry);
        }
    }

    public static void b(FeedCloudCommon$StCommonExt feedCloudCommon$StCommonExt, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (!feedCloudCommon$StCommonExt.has()) {
                feedCloudCommon$StCommonExt.set(new FeedCloudCommon$StCommonExt());
            }
            FeedCloudCommon$Entry feedCloudCommon$Entry = new FeedCloudCommon$Entry();
            feedCloudCommon$Entry.key.set(str);
            feedCloudCommon$Entry.value.set(str2);
            feedCloudCommon$StCommonExt.mapInfo.add(feedCloudCommon$Entry);
            feedCloudCommon$StCommonExt.setHasFlag(true);
        }
    }

    public static void c(FeedCloudCommon$StCommonExt feedCloudCommon$StCommonExt, List<FeedCloudCommon$Entry> list) {
        if (list != null && !list.isEmpty()) {
            if (!feedCloudCommon$StCommonExt.has()) {
                feedCloudCommon$StCommonExt.set(new FeedCloudCommon$StCommonExt());
            }
            feedCloudCommon$StCommonExt.mapInfo.addAll(list);
            feedCloudCommon$StCommonExt.setHasFlag(true);
        }
    }

    public static String d(List<FeedCloudCommon$Entry> list, String str) {
        if (list == null) {
            return "";
        }
        for (FeedCloudCommon$Entry feedCloudCommon$Entry : list) {
            if (feedCloudCommon$Entry != null && TextUtils.equals(feedCloudCommon$Entry.key.get(), str)) {
                return feedCloudCommon$Entry.value.get();
            }
        }
        return "";
    }
}
