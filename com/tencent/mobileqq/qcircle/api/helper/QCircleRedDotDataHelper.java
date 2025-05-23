package com.tencent.mobileqq.qcircle.api.helper;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qcircle.api.IQCircleRedPointService;
import com.tencent.mobileqq.qcircle.api.constant.QCircleRedPointAppidContants;
import com.tencent.mobileqq.qcircle.api.data.QCircleRedInfoBean;
import com.tencent.mobileqq.qcircle.api.utils.EeveeRedpointUtil;
import com.tencent.mobileqq.qcircle.api.utils.QCircleHostUtil;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon$Entry;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import qqcircle.QQCircleCounter$RedPointInfo;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QCircleRedDotDataHelper {
    private static final String TAG = "QCircleRedDotDataHelper";

    public static int getAllRedNum(QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo) {
        int max = Math.max(qQCircleCounter$RedPointInfo.redTotalNum.get(), 0);
        QLog.d(TAG, 2, String.format("%s : pushUnReadNum = %d,", EeveeRedpointUtil.LOG_TAG_PREFIX, Integer.valueOf(max)));
        return max;
    }

    public static int getEntranceATabType(QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo) {
        int i3 = qQCircleCounter$RedPointInfo.tabType.get();
        QLog.d(TAG, 2, String.format("%s : entranceTargetTabType = %d", EeveeRedpointUtil.LOG_TAG_PREFIX, Integer.valueOf(i3)));
        return i3;
    }

    public static QQCircleCounter$RedPointInfo getQQMainTabRedPointInfo() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return new QQCircleCounter$RedPointInfo();
        }
        try {
            return ((IQCircleRedPointService) peekAppRuntime.getRuntimeService(IQCircleRedPointService.class, "")).getQQMainTabOuterEntranceRedPointInfoByAppId(QCircleRedPointAppidContants.QCIRCLE_ENTRANCE);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "[getQQMainTabRedPointInfo] ex: ", th5);
            return null;
        }
    }

    public static byte[] getTransInfo(QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo) {
        ByteStringMicro byteStringMicro = qQCircleCounter$RedPointInfo.transInfo.get();
        Object[] objArr = new Object[2];
        int i3 = 0;
        objArr[0] = EeveeRedpointUtil.LOG_TAG_PREFIX;
        if (byteStringMicro != null) {
            i3 = byteStringMicro.size();
        }
        objArr[1] = Integer.valueOf(i3);
        QLog.d(TAG, 2, String.format("%s : getTransInfo = %d", objArr));
        if (byteStringMicro != null && byteStringMicro.size() > 0) {
            return byteStringMicro.toByteArray();
        }
        return null;
    }

    private static boolean isInvalidRecommendRedDot(QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo, int i3) {
        if (i3 != 1 || qQCircleCounter$RedPointInfo.allPushInfo.msgType.get() != 4) {
            return false;
        }
        return true;
    }

    public static boolean isShowActiveRedDot(QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo) {
        boolean checkOperateMaskEnabled = QCircleHostUtil.checkOperateMaskEnabled(qQCircleCounter$RedPointInfo.outLayerInfo.combineRedTypes.get(), 1);
        QLog.d(TAG, 2, String.format("%s : showActiveRedDot = %b", EeveeRedpointUtil.LOG_TAG_PREFIX, Boolean.valueOf(checkOperateMaskEnabled)));
        return checkOperateMaskEnabled;
    }

    public static boolean isShowBubbleRedDot(QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo) {
        Iterator<FeedCloudCommon$Entry> it = qQCircleCounter$RedPointInfo.extInfo.mapInfo.get().iterator();
        while (it.hasNext()) {
            if (it.next().key.get().equals(QCircleRedInfoBean.RED_ENTRANCE_TYPE_BUBBLE)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isShowPymkRedDot(QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo) {
        boolean checkOperateMaskEnabled = QCircleHostUtil.checkOperateMaskEnabled(qQCircleCounter$RedPointInfo.outLayerInfo.combineRedTypes.get(), 6);
        QLog.d(TAG, 2, String.format("%s : showPYMKRedDot = %b", EeveeRedpointUtil.LOG_TAG_PREFIX, Boolean.valueOf(checkOperateMaskEnabled)));
        return checkOperateMaskEnabled;
    }

    public static boolean isShowRecommendRedDot(QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo, int i3) {
        boolean checkOperateMaskEnabled = QCircleHostUtil.checkOperateMaskEnabled(qQCircleCounter$RedPointInfo.outLayerInfo.combineRedTypes.get(), 3);
        QLog.d(TAG, 2, String.format("%s : showRecommendRedDot = %b, RedEntranceType:%d", EeveeRedpointUtil.LOG_TAG_PREFIX, Boolean.valueOf(checkOperateMaskEnabled), Integer.valueOf(i3)));
        if (isInvalidRecommendRedDot(qQCircleCounter$RedPointInfo, i3)) {
            QLog.d(TAG, 2, String.format("%s : showRecommendRedDot = %b, RedEntranceType:%d, isInvalidRecommendRedDot", EeveeRedpointUtil.LOG_TAG_PREFIX, Boolean.valueOf(checkOperateMaskEnabled), Integer.valueOf(i3)));
            return false;
        }
        return checkOperateMaskEnabled;
    }
}
