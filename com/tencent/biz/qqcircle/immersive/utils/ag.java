package com.tencent.biz.qqcircle.immersive.utils;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StLive;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* compiled from: P */
/* loaded from: classes4.dex */
public class ag {
    public static String a(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        FeedCloudMeta$StLive feedCloudMeta$StLive;
        if (feedCloudMeta$StFeed != null && (feedCloudMeta$StLive = feedCloudMeta$StFeed.live) != null) {
            for (FeedCloudCommon$Entry feedCloudCommon$Entry : feedCloudMeta$StLive.liveExtInfo.get()) {
                if (c(feedCloudCommon$Entry.key.get())) {
                    return feedCloudCommon$Entry.value.get();
                }
            }
        }
        return "";
    }

    public static String b(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        String a16 = a(feedCloudMeta$StFeed);
        if (TextUtils.isEmpty(a16)) {
            return a16;
        }
        try {
            return URLEncoder.encode(a16, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            QLog.w("QFSLiveAbTokenUtil", 1, "encode originAbToken fail");
            return a16;
        }
    }

    static boolean c(String str) {
        return "rcmd_context".equalsIgnoreCase(str);
    }
}
