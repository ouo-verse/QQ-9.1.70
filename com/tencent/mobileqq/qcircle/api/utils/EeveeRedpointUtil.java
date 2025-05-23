package com.tencent.mobileqq.qcircle.api.utils;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qcircle.api.constant.QCircleRedPointAppidContants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon$Entry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import qqcircle.QQCircleCounter$CountInfoRsp;
import qqcircle.QQCircleCounter$RedPointInfo;
import uq3.k;

/* compiled from: P */
/* loaded from: classes16.dex */
public class EeveeRedpointUtil {
    public static final String EEVEE_TRACE_ID = "eevee_trace_id";
    private static final String KEY_NUM_RED_ALIENATION = "psvAlienationAndInsert";
    private static final String KEY_NUM_RED_CLEAR = "numRedPointClear";
    private static final String KEY_RED_POINT_FEED_ID = "feedID";
    private static final String KEY_RED_POINT_ID = "redPointID";
    public static final String LOG_TAG_PREFIX = "QCircleEeveeRedPoint_";
    public static final String MAP_KEY_CIRCLE_FOLLOW_TAB_CLEAR_RED_DOT_DELAY_SECOND = "follow_page_delay_second";
    private static final String TAG = "QCircleEeveeRedPoint_Util";
    private static QQCircleCounter$RedPointInfo sLastExposeRedPointInfo;
    private static long sReceiveRedPointTimeStamp;
    private static final ConcurrentHashMap<String, String> sUinToFriendTabIdForReadOnlyWording = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, String> sUinToFriendTabIdForRead = new ConcurrentHashMap<>();

    public static boolean enableNumRedClear(QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo) {
        if (qQCircleCounter$RedPointInfo == null) {
            return false;
        }
        Iterator<FeedCloudCommon$Entry> it = qQCircleCounter$RedPointInfo.extInfo.mapInfo.get().iterator();
        while (it.hasNext()) {
            if (it.next().key.get().equals(KEY_NUM_RED_CLEAR)) {
                return true;
            }
        }
        return false;
    }

    public static boolean enableNumRedShowAvatar(QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo) {
        if (qQCircleCounter$RedPointInfo == null) {
            return false;
        }
        Iterator<FeedCloudCommon$Entry> it = qQCircleCounter$RedPointInfo.extInfo.mapInfo.get().iterator();
        while (it.hasNext()) {
            if (it.next().key.get().equals(KEY_NUM_RED_ALIENATION)) {
                return true;
            }
        }
        return false;
    }

    public static String getEeveeTraceId(QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo) {
        for (FeedCloudCommon$Entry feedCloudCommon$Entry : qQCircleCounter$RedPointInfo.extInfo.mapInfo.get()) {
            if (feedCloudCommon$Entry.key.get().equals(EEVEE_TRACE_ID)) {
                return feedCloudCommon$Entry.value.get();
            }
        }
        return "";
    }

    public static long getFollowTabClearRedDotDelayInSecond() {
        return k.a().f("qfs_follow_tab_clear_red_dot_delay", 0L);
    }

    public static long getFollowTabFeedListLastPreRspTimestamp() {
        return k.a().f("qfs_follow_tab_feed_list_last_pre_rsp_timestamp", 0L);
    }

    public static long getFollowTabFeedListLastRspTimestamp() {
        return k.a().f("qfs_follow_tab_feed_list_last_rsp_timestamp", 0L);
    }

    public static String getFriendTabIdForRead() {
        String str;
        String account = ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
        if (TextUtils.isEmpty(account) || (str = sUinToFriendTabIdForRead.get(account)) == null) {
            return "";
        }
        return str;
    }

    public static String getFriendTabIdForReadOnlyWording() {
        String str;
        String account = ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
        if (TextUtils.isEmpty(account) || (str = sUinToFriendTabIdForReadOnlyWording.get(account)) == null) {
            return "";
        }
        return str;
    }

    public static QQCircleCounter$RedPointInfo getLastExposeRedPointInfo() {
        return sLastExposeRedPointInfo;
    }

    public static long getLastOuterEntranceRedPointClearRspTimestamp() {
        return k.a().f("qfs_last_outer_red_point_clear_rsp_timestamp", 0L);
    }

    public static long getLastReadedNumRedPointTimestamp() {
        return k.a().f("qfs_last_read_num_red_point_timestamp", 0L);
    }

    public static long getLastReadedSmallRedPointTimestamp() {
        return k.a().f("qfs_last_read_small_red_point_timestamp", 0L);
    }

    public static long getNoticeFeedListLastRspTimestamp() {
        return k.a().f("qfs_notice_feed_list_last_rsp_timestamp", 0L);
    }

    public static long getReceiveRedPointTimeStamp() {
        return sReceiveRedPointTimeStamp;
    }

    public static String getRedPointFeedId(QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo) {
        for (FeedCloudCommon$Entry feedCloudCommon$Entry : qQCircleCounter$RedPointInfo.extInfo.mapInfo.get()) {
            if (feedCloudCommon$Entry.key.get().equals(KEY_RED_POINT_FEED_ID)) {
                return feedCloudCommon$Entry.value.get();
            }
        }
        return "";
    }

    public static String getRedPointId(QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo) {
        if (qQCircleCounter$RedPointInfo == null) {
            return "";
        }
        for (FeedCloudCommon$Entry feedCloudCommon$Entry : qQCircleCounter$RedPointInfo.extInfo.mapInfo.get()) {
            if (feedCloudCommon$Entry.key.get().equals(KEY_RED_POINT_ID)) {
                return feedCloudCommon$Entry.value.get();
            }
        }
        return "";
    }

    @NonNull
    public static List<QQCircleCounter$RedPointInfo> getRedPointInfoListByAppid(String str, BaseRequest baseRequest, QQCircleCounter$CountInfoRsp qQCircleCounter$CountInfoRsp) {
        List<QQCircleCounter$RedPointInfo> list;
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str) && qQCircleCounter$CountInfoRsp != null && (list = qQCircleCounter$CountInfoRsp.rptRedPoint.get()) != null && list.size() > 0) {
            for (QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo : list) {
                if (qQCircleCounter$RedPointInfo != null && TextUtils.equals(str, qQCircleCounter$RedPointInfo.appid.get())) {
                    if (baseRequest != null) {
                        FeedCloudCommon$Entry feedCloudCommon$Entry = new FeedCloudCommon$Entry();
                        feedCloudCommon$Entry.key.set(EEVEE_TRACE_ID);
                        feedCloudCommon$Entry.value.set(baseRequest.getTraceId());
                        qQCircleCounter$RedPointInfo.extInfo.mapInfo.add(feedCloudCommon$Entry);
                    }
                    arrayList.add(qQCircleCounter$RedPointInfo);
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x01a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean isValidRedPointInfo(String str, int i3, QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo) {
        boolean z16;
        boolean z17;
        if (TextUtils.isEmpty(str)) {
            QLog.d(TAG, 1, "[filterInvalidRedPointInfo] reddot has been filtered! appid is empty!");
            return false;
        }
        if (qQCircleCounter$RedPointInfo != null && QCircleRedPointAppidContants.QCIRCLE_ENTRANCE.equals(str)) {
            int i16 = qQCircleCounter$RedPointInfo.redType.get();
            if (i16 != 1) {
                if (i16 != 2) {
                    if (i16 != 71) {
                        switch (i16) {
                            case 9:
                                String redPointId = getRedPointId(qQCircleCounter$RedPointInfo);
                                String friendTabIdForRead = getFriendTabIdForRead();
                                if (!TextUtils.isEmpty(redPointId) && TextUtils.equals(friendTabIdForRead, redPointId)) {
                                    z16 = false;
                                } else {
                                    z16 = true;
                                }
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append("[filterInvalidRedPointInfo] FriendRedPoint");
                                sb5.append(", friendTabId: ");
                                sb5.append(redPointId);
                                sb5.append(", lastFriendTabIdForRead: ");
                                sb5.append(friendTabIdForRead);
                                sb5.append(", combineRedTypes : ");
                                sb5.append(qQCircleCounter$RedPointInfo.outLayerInfo.combineRedTypes.get());
                                sb5.append(", reportInfo: ");
                                sb5.append(qQCircleCounter$RedPointInfo.extend.get());
                                QLog.d(TAG, 1, sb5);
                                break;
                        }
                        if (!z16) {
                            QLog.d(TAG, 1, "[filterInvalidRedPointInfo] reddot has been filtered! ");
                        }
                        return z16;
                    }
                    long j3 = qQCircleCounter$RedPointInfo.lastVisitTime.get();
                    long lastOuterEntranceRedPointClearRspTimestamp = getLastOuterEntranceRedPointClearRspTimestamp();
                    long followTabFeedListLastRspTimestamp = getFollowTabFeedListLastRspTimestamp();
                    if (j3 >= lastOuterEntranceRedPointClearRspTimestamp && j3 >= followTabFeedListLastRspTimestamp) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("[filterInvalidRedPointInfo] OutLayerRedPoint");
                    sb6.append(", redDotLastVisitTime: ");
                    sb6.append(j3);
                    sb6.append(", lastOuterEntranceRedPointClearRspTimestamp: ");
                    sb6.append(lastOuterEntranceRedPointClearRspTimestamp);
                    sb6.append(", followTabFeedListLastRspTimestamp: ");
                    sb6.append(followTabFeedListLastRspTimestamp);
                    sb6.append(", lastReadedOuterEntranceRedPointTimestamp: ");
                    sb6.append(", combineRedTypes : ");
                    sb6.append(qQCircleCounter$RedPointInfo.outLayerInfo.combineRedTypes.get());
                    sb6.append(", reportInfo: ");
                    sb6.append(qQCircleCounter$RedPointInfo.extend.get());
                    QLog.d(TAG, 1, sb6);
                }
                long j16 = qQCircleCounter$RedPointInfo.lastVisitTime.get();
                long noticeFeedListLastRspTimestamp = getNoticeFeedListLastRspTimestamp();
                long lastReadedNumRedPointTimestamp = getLastReadedNumRedPointTimestamp();
                if (j16 >= noticeFeedListLastRspTimestamp && j16 >= lastReadedNumRedPointTimestamp) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                StringBuilder sb7 = new StringBuilder();
                sb7.append("[filterInvalidRedPointInfo] NumRedPoint");
                sb7.append(", redDotLastVisitTime: ");
                sb7.append(j16);
                sb7.append(", noticeFeedListLastRspTimestamp: ");
                sb7.append(noticeFeedListLastRspTimestamp);
                sb7.append(", lastReadedNumRedPointTimestamp: ");
                sb7.append(lastReadedNumRedPointTimestamp);
                sb7.append(", reportInfo: ");
                sb7.append(qQCircleCounter$RedPointInfo.extend.get());
                QLog.d(TAG, 1, sb7);
            } else {
                long j17 = qQCircleCounter$RedPointInfo.lastVisitTime.get();
                long followTabFeedListLastRspTimestamp2 = getFollowTabFeedListLastRspTimestamp();
                long lastReadedSmallRedPointTimestamp = getLastReadedSmallRedPointTimestamp();
                if (j17 >= followTabFeedListLastRspTimestamp2 && j17 >= lastReadedSmallRedPointTimestamp) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                StringBuilder sb8 = new StringBuilder();
                sb8.append("[filterInvalidRedPointInfo] SmallRedPoint");
                sb8.append(", redDotLastVisitTime: ");
                sb8.append(j17);
                sb8.append(", followTabFeedListLastRspTimestamp: ");
                sb8.append(followTabFeedListLastRspTimestamp2);
                sb8.append(", lastReadedSmallRedPointTimestamp: ");
                sb8.append(lastReadedSmallRedPointTimestamp);
                sb8.append(", reportInfo: ");
                sb8.append(qQCircleCounter$RedPointInfo.extend.get());
                QLog.d(TAG, 1, sb8);
            }
            z16 = z17;
            if (!z16) {
            }
            return z16;
        }
        z16 = true;
        if (!z16) {
        }
        return z16;
    }

    public static void saveFollowTabClearRedDotDelayInSecond(long j3) {
        QLog.d(TAG, 1, "saveFollowTabClearRedDotDelayInSecond = " + j3);
        k.a().n("qfs_follow_tab_clear_red_dot_delay", j3);
    }

    public static void saveFollowTabFeedListLastPreRspTimestamp(long j3) {
        QLog.d(TAG, 1, "saveFollowTabFeedListLastPreRspTimestamp = " + j3);
        k.a().n("qfs_follow_tab_feed_list_last_pre_rsp_timestamp", j3);
    }

    public static void saveFollowTabFeedListLastRspTimestamp(long j3) {
        QLog.d(TAG, 1, "saveFollowTabFeedListLastRspTimestamp = " + j3);
        k.a().n("qfs_follow_tab_feed_list_last_rsp_timestamp", j3);
    }

    public static void saveFriendTabIdForRead(String str) {
        String account = ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
        if (TextUtils.isEmpty(account)) {
            return;
        }
        sUinToFriendTabIdForRead.put(account, str);
    }

    public static void saveFriendTabIdForReadOnlyWording(String str) {
        String account = ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
        if (TextUtils.isEmpty(account)) {
            return;
        }
        sUinToFriendTabIdForReadOnlyWording.put(account, str);
    }

    public static void saveLastOuterEntranceRedPointClearRspTimestamp(long j3) {
        QLog.d(TAG, 1, "saveLastOuterEntranceRedPointClearRspTimestamp = " + j3);
        k.a().n("qfs_last_outer_red_point_clear_rsp_timestamp", j3);
    }

    public static void saveLastReadedNumRedPointTimestamp(long j3) {
        QLog.d(TAG, 1, "saveLastReadedNumRedPointTimestamp = " + j3);
        k.a().n("qfs_last_read_num_red_point_timestamp", j3);
    }

    public static void saveLastReadedSmallRedPointTimestamp(long j3) {
        QLog.d(TAG, 1, "saveLastReadedSmallRedPointTimestamp = " + j3);
        k.a().n("qfs_last_read_small_red_point_timestamp", j3);
    }

    public static void saveNoticeFeedListLastRspTimestamp(long j3) {
        QLog.d(TAG, 1, "saveNoticeFeedListLastRspTimestamp = " + j3);
        k.a().n("qfs_notice_feed_list_last_rsp_timestamp", j3);
    }

    public static void setLastExposeRedPointInfo(QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo) {
        String str;
        int i3 = RFWLog.USR;
        Object[] objArr = new Object[1];
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[reportRedPoint-setLastExposeRedPointInfo] :");
        if (qQCircleCounter$RedPointInfo == null) {
            str = null;
        } else {
            str = qQCircleCounter$RedPointInfo.extend.get();
        }
        sb5.append(str);
        objArr[0] = sb5.toString();
        RFWLog.d(TAG, i3, objArr);
        sLastExposeRedPointInfo = qQCircleCounter$RedPointInfo;
    }

    public static void setReceiveRedPointTimeStamp(long j3) {
        sReceiveRedPointTimeStamp = j3;
    }
}
