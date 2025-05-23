package com.tencent.biz.qqcircle.utils;

import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$PushBoxViewInfo;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StImage;
import feedcloud.FeedCloudMeta$StImageUrl;
import feedcloud.FeedCloudMeta$StPushList;
import feedcloud.FeedCloudMeta$StUser;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ac {
    public static void a(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        FeedCloudMeta$StImage feedCloudMeta$StImage;
        if (feedCloudMeta$StFeed == null) {
            QLog.d("QCircleProtoUtil", 1, "adjustFeedPicUrl stFeed is null");
            return;
        }
        if (feedCloudMeta$StFeed.images.size() > 0 && (feedCloudMeta$StImage = feedCloudMeta$StFeed.images.get(0)) != null && feedCloudMeta$StImage.vecImageUrl.size() > 0) {
            for (FeedCloudMeta$StImageUrl feedCloudMeta$StImageUrl : feedCloudMeta$StImage.vecImageUrl.get()) {
                if (feedCloudMeta$StImageUrl.levelType.get() == i3) {
                    QLog.d("QCircleProtoUtil", 1, "setPic levelType:" + i3 + "   url:" + feedCloudMeta$StImageUrl.url.get());
                    feedCloudMeta$StImage.picUrl.set(feedCloudMeta$StImageUrl.url.get());
                }
            }
        }
    }

    private static boolean b(int i3, List<FeedCloudMeta$StUser> list) {
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_remove_push_list_when_cancel_9065", true) || list == null) {
            return false;
        }
        String account = HostDataTransUtils.getAccount();
        if (i3 == 0 && list.size() > 0 && list.get(0).f398463id.get().equals(account)) {
            return true;
        }
        return false;
    }

    public static void c(FeedCloudMeta$StPushList feedCloudMeta$StPushList) {
        if (feedCloudMeta$StPushList == null) {
            QLog.d("QCircleProtoUtil", 1, "pushInfo is null");
            return;
        }
        int i3 = feedCloudMeta$StPushList.hasClickCount.get();
        int i16 = feedCloudMeta$StPushList.totalClickCount.get();
        feedCloudMeta$StPushList.status.set(0);
        feedCloudMeta$StPushList.totalClickCount.set(i16 - i3);
        feedCloudMeta$StPushList.hasClickCount.set(0);
        feedCloudMeta$StPushList.pushBoxViewInfo.set(new FeedCloudMeta$PushBoxViewInfo());
        List<FeedCloudMeta$StUser> list = feedCloudMeta$StPushList.vecUser.get();
        String account = HostDataTransUtils.getAccount();
        if (list.size() > 0 && list.get(0).f398463id.get().equals(account)) {
            list.remove(0);
            PBUInt32Field pBUInt32Field = feedCloudMeta$StPushList.count;
            pBUInt32Field.set(pBUInt32Field.get() - 1);
        }
    }

    public static void d(FeedCloudMeta$StPushList feedCloudMeta$StPushList, int i3) {
        int i16;
        if (feedCloudMeta$StPushList == null) {
            QLog.d("QCircleProtoUtil", 1, "pushInfo is null");
            return;
        }
        int i17 = i3 - feedCloudMeta$StPushList.hasClickCount.get();
        PBUInt32Field pBUInt32Field = feedCloudMeta$StPushList.status;
        if (i3 > 0) {
            i16 = 1;
        } else {
            i16 = 0;
        }
        pBUInt32Field.set(i16);
        List<FeedCloudMeta$StUser> list = feedCloudMeta$StPushList.vecUser.get();
        if (i3 > 0 && (list.size() <= 0 || !list.get(0).f398463id.get().equals(HostDataTransUtils.getAccount()))) {
            QLog.d("QCircleProtoUtil", 1, "is not in pushList add user");
            list.add(0, QCirclePluginGlobalInfo.m());
            PBUInt32Field pBUInt32Field2 = feedCloudMeta$StPushList.count;
            pBUInt32Field2.set(pBUInt32Field2.get() + 1);
        } else if (b(i3, list)) {
            list.remove(0);
            PBUInt32Field pBUInt32Field3 = feedCloudMeta$StPushList.count;
            pBUInt32Field3.set(pBUInt32Field3.get() - 1);
            QLog.d("QCircleProtoUtil", 1, "[updateTotalPushTimeAndStatus] remove push.");
        }
        PBUInt32Field pBUInt32Field4 = feedCloudMeta$StPushList.totalClickCount;
        pBUInt32Field4.set(i17 + pBUInt32Field4.get());
        feedCloudMeta$StPushList.hasClickCount.set(i3);
    }
}
