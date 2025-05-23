package com.tencent.biz.qqcircle.immersive.feed.ad;

import android.text.TextUtils;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudMeta$StComment;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.List;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
/* loaded from: classes4.dex */
public class u {
    public static void a(FeedCloudMeta$StFeed feedCloudMeta$StFeed, List<FeedCloudMeta$StComment> list) {
        FeedCloudMeta$StFeed d16;
        if (feedCloudMeta$StFeed == null || !com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx.d.e(feedCloudMeta$StFeed) || (d16 = d(feedCloudMeta$StFeed)) == null) {
            return;
        }
        FeedCloudMeta$StComment feedCloudMeta$StComment = new FeedCloudMeta$StComment();
        feedCloudMeta$StComment.f398447id.set("ad_fake_desc_comment_id");
        feedCloudMeta$StComment.content.set(d16.content.get());
        feedCloudMeta$StComment.postUser = d16.poster;
        feedCloudMeta$StComment.createTime.set(feedCloudMeta$StFeed.createTime.get());
        feedCloudMeta$StComment.typeFlag.set(1);
        if (list == null) {
            new ArrayList(1).add(feedCloudMeta$StComment);
        } else {
            list.add(0, feedCloudMeta$StComment);
        }
    }

    public static boolean b() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_feedline_enable_ad_video_replace_feed", true);
    }

    public static FeedCloudMeta$StFeed c(e30.b bVar) {
        return (FeedCloudMeta$StFeed) bVar.b("DITTO_FEED_AD_FEED");
    }

    public static FeedCloudMeta$StFeed d(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == null || feedCloudMeta$StFeed.feedType.get() != 4) {
            return null;
        }
        byte[] byteArray = feedCloudMeta$StFeed.adBuffer.get().toByteArray();
        QLog.d("QFSFeedAdDataHelper", 4, "getAdFeed feedId: " + feedCloudMeta$StFeed.f398449id.get() + ",byte length:" + byteArray.length);
        if (byteArray.length <= 0) {
            return null;
        }
        try {
            FeedCloudMeta$StFeed feedCloudMeta$StFeed2 = new FeedCloudMeta$StFeed();
            feedCloudMeta$StFeed2.mergeFrom(byteArray);
            return feedCloudMeta$StFeed2;
        } catch (Exception e16) {
            QLog.e("QFSFeedAdDataHelper", 1, "getAdFeed error:" + e16);
            return null;
        }
    }

    public static qq_ad_get.QQAdGetRsp.AdInfo e(e30.b bVar) {
        return (qq_ad_get.QQAdGetRsp.AdInfo) bVar.b("DITTO_AD_FEED_BUSI_DATA");
    }

    public static boolean f(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == null) {
            return false;
        }
        for (FeedCloudCommon$Entry feedCloudCommon$Entry : feedCloudMeta$StFeed.extInfo.get()) {
            if (TextUtils.equals(feedCloudCommon$Entry.key.get(), "advAllowComment")) {
                return TextUtils.equals(feedCloudCommon$Entry.value.get(), "1");
            }
        }
        return false;
    }

    public static boolean g(GdtAd gdtAd) {
        int innerShowType = gdtAd.getInnerShowType();
        if (innerShowType != 49 && innerShowType != 36) {
            return false;
        }
        return true;
    }

    public static boolean h(GdtAd gdtAd) {
        int innerShowType = gdtAd.getInnerShowType();
        if (innerShowType != 50 && innerShowType != 49 && innerShowType != 36 && innerShowType != 35) {
            return false;
        }
        return true;
    }
}
