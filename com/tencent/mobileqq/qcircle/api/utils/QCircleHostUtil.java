package com.tencent.mobileqq.qcircle.api.utils;

import android.text.TextUtils;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.framebusiness.controllerinject.TabDataHelper;
import com.tencent.mobileqq.activity.framebusiness.controllerinject.n;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qcircle.tempapi.api.IQQBaseService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StTagInfo;
import feedcloud.FeedCloudMeta$StUser;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.MobileQQ;
import qqcircle.QQCircleBase$StUserBusiData;
import qqcircle.QQCircleCounter$RedPointInfo;
import qqcircle.QQCircleCounterMsg$RedDisplayInfo;
import uq3.k;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QCircleHostUtil {
    private static final String TAG = "QCircleHostUtil";

    public static String bigNumberFormatTranfer(long j3) {
        return bigNumberFormatTranfer(j3, false);
    }

    public static boolean checkOperateMaskEnabled(long j3, int i3) {
        if ((j3 & (1 << i3)) != 0) {
            return true;
        }
        return false;
    }

    public static List<String> convertRedDisplayInfoToString(List<QQCircleCounterMsg$RedDisplayInfo> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() != 0) {
            for (QQCircleCounterMsg$RedDisplayInfo qQCircleCounterMsg$RedDisplayInfo : list) {
                if (!TextUtils.isEmpty(qQCircleCounterMsg$RedDisplayInfo.avatarURL.get())) {
                    arrayList.add(qQCircleCounterMsg$RedDisplayInfo.avatarURL.get());
                } else {
                    arrayList.add(qQCircleCounterMsg$RedDisplayInfo.headImg.get());
                }
            }
        }
        return arrayList;
    }

    public static int convertSourceFromType(int i3) {
        if (i3 == 1) {
            return 1;
        }
        if (i3 == 2) {
            return 4;
        }
        if (i3 == 3) {
            return 6;
        }
        if (i3 != 4) {
            if (i3 != 6) {
                return 0;
            }
            return 10;
        }
        return 5;
    }

    public static String fansNumberFormatTranfer(long j3) {
        if (j3 < 10000) {
            return String.valueOf(j3);
        }
        if (j3 < 1000000) {
            DecimalFormat decimalFormat = new DecimalFormat();
            decimalFormat.setMaximumFractionDigits(1);
            decimalFormat.setGroupingSize(0);
            decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
            return decimalFormat.format(j3 / 10000.0d) + "\u4e07";
        }
        if (j3 < SafeBitmapFactory.PX_THRESHOID_DEFAULTS) {
            return (j3 / 10000) + "w";
        }
        return "9999w";
    }

    public static String getFeedTagName(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        List<FeedCloudMeta$StTagInfo> list = feedCloudMeta$StFeed.tagInfos.get();
        StringBuilder sb5 = new StringBuilder();
        for (FeedCloudMeta$StTagInfo feedCloudMeta$StTagInfo : list) {
            if (!TextUtils.isEmpty(sb5)) {
                sb5.append("|");
            }
            sb5.append(feedCloudMeta$StTagInfo.tagName.get());
        }
        return sb5.toString();
    }

    public static int[] getReportFeedType(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        int[] iArr = new int[2];
        if (feedCloudMeta$StFeed != null) {
            if (feedCloudMeta$StFeed.dittoFeed.dittoId.get() != 0) {
                iArr[0] = 3;
                iArr[1] = 1;
            } else if (feedCloudMeta$StFeed.type.get() == 2) {
                iArr[0] = 1;
                iArr[1] = 1;
            } else if (feedCloudMeta$StFeed.type.get() == 3) {
                iArr[0] = 1;
                iArr[1] = 2;
            }
        }
        return iArr;
    }

    public static FeedCloudMeta$StFeed getSimpleFeed(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == null) {
            QLog.e(TAG, 1, "getSimpleFeed param feed is null");
            return null;
        }
        FeedCloudMeta$StFeed feedCloudMeta$StFeed2 = new FeedCloudMeta$StFeed();
        feedCloudMeta$StFeed2.f398449id.set(feedCloudMeta$StFeed.f398449id.get());
        feedCloudMeta$StFeed2.createTime.set(feedCloudMeta$StFeed.createTime.get());
        if (feedCloudMeta$StFeed.poster != null) {
            FeedCloudMeta$StUser feedCloudMeta$StUser = new FeedCloudMeta$StUser();
            feedCloudMeta$StUser.f398463id.set(feedCloudMeta$StFeed.poster.f398463id.get());
            feedCloudMeta$StFeed2.poster.set(feedCloudMeta$StUser);
        } else {
            QLog.e(TAG, 1, "getSimpleFeed poster is null");
        }
        return feedCloudMeta$StFeed2;
    }

    public static QQCircleBase$StUserBusiData getUserExtraData(FeedCloudMeta$StUser feedCloudMeta$StUser) {
        if (feedCloudMeta$StUser != null && feedCloudMeta$StUser.busiData.get() != null) {
            try {
                QQCircleBase$StUserBusiData qQCircleBase$StUserBusiData = new QQCircleBase$StUserBusiData();
                qQCircleBase$StUserBusiData.mergeFrom(feedCloudMeta$StUser.busiData.get().toByteArray());
                return qQCircleBase$StUserBusiData;
            } catch (Exception e16) {
                e16.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public static boolean isAuth(FeedCloudMeta$StUser feedCloudMeta$StUser) {
        QQCircleBase$StUserBusiData userExtraData = getUserExtraData(feedCloudMeta$StUser);
        if (userExtraData != null && userExtraData.certification.get() == 1) {
            return true;
        }
        return false;
    }

    public static boolean isFeedOwner(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == null) {
            return false;
        }
        if (feedCloudMeta$StFeed.isRecomFd.get()) {
            return isOwner(feedCloudMeta$StFeed.recomForward.poster.get());
        }
        return isOwner(feedCloudMeta$StFeed.poster.get());
    }

    public static boolean isFollow(FeedCloudMeta$StUser feedCloudMeta$StUser) {
        if (feedCloudMeta$StUser != null && !isOwner(feedCloudMeta$StUser) && (feedCloudMeta$StUser.followState.get() == 1 || feedCloudMeta$StUser.followState.get() == 3)) {
            return true;
        }
        return false;
    }

    public static boolean isOwner(FeedCloudMeta$StUser feedCloudMeta$StUser) {
        if (feedCloudMeta$StUser != null && MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount().equals(feedCloudMeta$StUser.f398463id.get())) {
            return true;
        }
        return false;
    }

    private static boolean isRedDisplaySame(List<QQCircleCounterMsg$RedDisplayInfo> list, List<QQCircleCounterMsg$RedDisplayInfo> list2) {
        if (list == list2) {
            return true;
        }
        if (list == null || list2 == null || list.size() != list2.size()) {
            return false;
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (!TextUtils.equals(list.get(i3).headImg.get(), list2.get(i3).headImg.get())) {
                return false;
            }
        }
        return true;
    }

    public static boolean isRedDotSame(QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo, QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo2) {
        if (qQCircleCounter$RedPointInfo == qQCircleCounter$RedPointInfo2) {
            return true;
        }
        if (qQCircleCounter$RedPointInfo == null || qQCircleCounter$RedPointInfo2 == null || qQCircleCounter$RedPointInfo.outLayerInfo.combineRedTypes.get() != qQCircleCounter$RedPointInfo2.outLayerInfo.combineRedTypes.get() || qQCircleCounter$RedPointInfo.redTotalNum.get() != qQCircleCounter$RedPointInfo2.redTotalNum.get() || !qQCircleCounter$RedPointInfo.allPushInfo.tabTipWording.get().equals(qQCircleCounter$RedPointInfo2.allPushInfo.tabTipWording.get()) || !qQCircleCounter$RedPointInfo.allPushInfo.wording.get().equals(qQCircleCounter$RedPointInfo2.allPushInfo.wording.get()) || !qQCircleCounter$RedPointInfo.wording.get().equals(qQCircleCounter$RedPointInfo2.wording.get()) || !isRedDisplaySame(qQCircleCounter$RedPointInfo.rptRedInfo.get(), qQCircleCounter$RedPointInfo2.rptRedInfo.get())) {
            return false;
        }
        if (!QCircleStyleTabExtKt.isSameBubbleContent(qQCircleCounter$RedPointInfo.allPushInfo.styleBottomTab.bubble.get(), qQCircleCounter$RedPointInfo2.allPushInfo.styleBottomTab.bubble.get())) {
            QLog.i(TAG, 1, "isSameBubbleContent false");
            return false;
        }
        if (QCircleStyleTabExtKt.isSameTabAvatar(qQCircleCounter$RedPointInfo.allPushInfo.styleBottomTab.button.get(), qQCircleCounter$RedPointInfo2.allPushInfo.styleBottomTab.button.get())) {
            return true;
        }
        QLog.i(TAG, 1, "isSameTabAvatar false");
        return false;
    }

    public static boolean isUnFollow(FeedCloudMeta$StUser feedCloudMeta$StUser) {
        if (feedCloudMeta$StUser != null && !isOwner(feedCloudMeta$StUser) && feedCloudMeta$StUser.followState.get() == 0) {
            return true;
        }
        return false;
    }

    public static boolean isVideoFeed(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed != null && !TextUtils.isEmpty(feedCloudMeta$StFeed.video.fileId.get())) {
            return true;
        }
        return false;
    }

    public static void jumpQQBottomSettingPage() {
        n.h(1);
    }

    public static boolean needHideSmallRedDotInLeba(QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo) {
        if (qQCircleCounter$RedPointInfo == null) {
            return false;
        }
        if (EeveeRedpointUtil.enableNumRedShowAvatar(qQCircleCounter$RedPointInfo) && TextUtils.equals(EeveeRedpointUtil.getRedPointId(qQCircleCounter$RedPointInfo), k.a().h("sp_key_last_insert_red_point_id", ""))) {
            return true;
        }
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_leba_schema_red_dot", true)) {
            return false;
        }
        String str = qQCircleCounter$RedPointInfo.redJumpInfo.jumpLink.get();
        if (qQCircleCounter$RedPointInfo.redJumpInfo.jumpType.get() == 0 || str.isEmpty()) {
            return false;
        }
        return true;
    }

    public static void setQCircleToBottomTab() {
        uq3.c.h7("qqcircle", QzoneConfig.SECONDARY_QQCIRCLE_SHOW_BOTTOM_TAB_SWITCH, "1");
        HashMap<String, Boolean> hashMap = new HashMap<>();
        hashMap.put(TabDataHelper.TAB_RIJ, Boolean.FALSE);
        hashMap.put(TabDataHelper.TAB_NEW_WORLD, Boolean.TRUE);
        ((IQQBaseService) QRoute.api(IQQBaseService.class)).setQCircleToBottomTab(hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put(TabDataHelper.TAB_RIJ, 3);
        hashMap2.put(TabDataHelper.TAB_NEW_WORLD, 2);
        TabDataHelper.updateTabLocalSwitch(BaseApplication.getContext(), MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount(), hashMap2);
    }

    public static String bigNumberFormatTranfer(long j3, boolean z16) {
        String qqStr = z16 ? HardCodeUtil.qqStr(R.string.f181613e9) : "W";
        if (j3 < 10000) {
            return String.valueOf(j3);
        }
        if (j3 < 1000000) {
            DecimalFormat decimalFormat = new DecimalFormat();
            decimalFormat.setMaximumFractionDigits(1);
            decimalFormat.setGroupingSize(0);
            decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
            return decimalFormat.format(j3 / 10000.0d) + qqStr;
        }
        if (j3 < SafeBitmapFactory.PX_THRESHOID_DEFAULTS) {
            return (j3 / 10000) + qqStr;
        }
        return "9999" + qqStr;
    }
}
