package com.tencent.biz.qqcircle.immersive.utils;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudMeta$StDebugInfo;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class ba {
    public static void a(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed, @NonNull String str) {
        if (feedCloudMeta$StFeed.debugInfo == null) {
            feedCloudMeta$StFeed.debugInfo = new FeedCloudMeta$StDebugInfo();
        }
        List<FeedCloudCommon$Entry> list = feedCloudMeta$StFeed.debugInfo.debugMap.get();
        for (FeedCloudCommon$Entry feedCloudCommon$Entry : list) {
            if (feedCloudCommon$Entry != null && "traceid".contains(feedCloudCommon$Entry.key.get()) && !TextUtils.isEmpty(feedCloudCommon$Entry.value.get())) {
                return;
            }
        }
        FeedCloudCommon$Entry feedCloudCommon$Entry2 = new FeedCloudCommon$Entry();
        feedCloudCommon$Entry2.key.set("traceid");
        feedCloudCommon$Entry2.value.set(str);
        list.add(feedCloudCommon$Entry2);
    }

    public static String b(FeedCloudMeta$StFeed feedCloudMeta$StFeed, String str) {
        FeedCloudMeta$StDebugInfo feedCloudMeta$StDebugInfo;
        PBRepeatMessageField<FeedCloudCommon$Entry> pBRepeatMessageField;
        List<FeedCloudCommon$Entry> list;
        if (feedCloudMeta$StFeed == null || TextUtils.isEmpty(str) || (feedCloudMeta$StDebugInfo = feedCloudMeta$StFeed.debugInfo) == null || (pBRepeatMessageField = feedCloudMeta$StDebugInfo.debugMap) == null || (list = pBRepeatMessageField.get()) == null) {
            return "";
        }
        for (FeedCloudCommon$Entry feedCloudCommon$Entry : list) {
            if (feedCloudCommon$Entry != null && str.contains(feedCloudCommon$Entry.key.get())) {
                return feedCloudCommon$Entry.value.get();
            }
        }
        return "";
    }

    public static String c(e30.b bVar) {
        if (bVar == null) {
            return "";
        }
        return d(bVar.g());
    }

    public static String d(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        return b(feedCloudMeta$StFeed, "traceid");
    }

    public static void e(List<e30.b> list, int i3) {
        e30.b bVar;
        if (list == null) {
            return;
        }
        QLog.d("QFSTraceIdUtils", 1, "FeedLine_ printFeedInfo feed size:" + list.size());
        if (!QLog.isColorLevel()) {
            return;
        }
        ArrayList arrayList = new ArrayList(list);
        int i16 = i3 - 10;
        if (i16 < 0) {
            i16 = 0;
        }
        int i17 = i16 + 20;
        if (i17 >= list.size()) {
            i17 = list.size() - 1;
        }
        StringBuilder sb5 = new StringBuilder();
        while (i16 < i17) {
            if (arrayList.size() > i16 && (bVar = (e30.b) arrayList.get(i16)) != null && bVar.g() != null) {
                FeedCloudMeta$StFeed g16 = bVar.g();
                sb5.append("printFeedInfo index:");
                sb5.append(i16);
                sb5.append(", feedId:");
                sb5.append(g16.f398449id.get());
                sb5.append(", traceId:");
                sb5.append(d(g16));
                sb5.append("\n");
            }
            i16++;
        }
        QLog.d("QFSTraceIdUtils", 2, sb5.toString());
    }
}
