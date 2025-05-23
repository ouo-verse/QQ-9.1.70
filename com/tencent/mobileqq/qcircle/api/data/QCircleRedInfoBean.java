package com.tencent.mobileqq.qcircle.api.data;

import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.qcircle.api.event.QCircleFrameEvent;
import com.tencent.mobileqq.qcircle.api.helper.QCircleRedDotDataHelper;
import com.tencent.mobileqq.qcircle.api.utils.QCircleHostUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import qqcircle.QQCircleCounter$RedPointInfo;
import qqcircle.QQCircleCounterMsg$RedDisplayInfo;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QCircleRedInfoBean implements Serializable {
    public static final String RED_ENTRANCE_TYPE_BUBBLE = "showRedPointBubbleView";
    public static final int RED_ENTRANCE_TYPE_LEBA = 3;
    public static final int RED_ENTRANCE_TYPE_MAIN_TAB = 1;
    public static final int RED_ENTRANCE_TYPE_MESSAGE = 2;
    private static final int REPORT_QQCIRCLE_RED_DOT_ACTION_LEBA_ENTRY = 1;
    private static final String TAG = "QCircleRedInfoBean";
    private static final long serialVersionUID = 8760141975470995080L;
    private String mRedDotJumpUrl;
    private String mRedDotReportExt;
    private final int mRedEntranceType;
    private boolean mShouldReportRed;
    private String mTabTipWording;
    private int mRedNum = 0;
    private byte[] mRedDotTransInfo = null;
    private int mEntranceTabType = -1;
    private boolean mIsShowActiveRedDot = false;
    private boolean mIsShowPymkRedDot = false;
    private boolean mIsShowRecommendRedDot = false;
    private int mActionEntry = 1;
    private QQCircleCounter$RedPointInfo mRedPointInfo = new QQCircleCounter$RedPointInfo();
    private List<QQCircleCounterMsg$RedDisplayInfo> mRedDisplayInfoList = new ArrayList();
    private QQCircleCounter$RedPointInfo mLastExposedRedPoint = new QQCircleCounter$RedPointInfo();
    private QQCircleCounter$RedPointInfo mLastExposedBubble = new QQCircleCounter$RedPointInfo();

    public QCircleRedInfoBean(int i3) {
        this.mRedEntranceType = i3;
    }

    private void isNeedSendRedNumChangeEvent(int i3) {
        if (i3 != this.mRedNum) {
            QCircleFrameEvent qCircleFrameEvent = new QCircleFrameEvent();
            qCircleFrameEvent.mIsRefreshRedNum = true;
            SimpleEventBus.getInstance().dispatchEvent(qCircleFrameEvent);
        }
    }

    public int getAllRedNum() {
        return this.mRedNum;
    }

    public int getEntranceTabType() {
        return this.mEntranceTabType;
    }

    public QQCircleCounter$RedPointInfo getLastExposedBubble() {
        return this.mLastExposedBubble;
    }

    public QQCircleCounter$RedPointInfo getLastExposedRedPointInfo() {
        return this.mLastExposedRedPoint;
    }

    public List<QQCircleCounterMsg$RedDisplayInfo> getRedDisplayInfoList() {
        return this.mRedDisplayInfoList;
    }

    public String getRedDotJumpUrl() {
        return this.mRedDotJumpUrl;
    }

    public String getRedDotReportExt() {
        return this.mRedDotReportExt;
    }

    public byte[] getRedDotTransInfo() {
        return this.mRedDotTransInfo;
    }

    public QQCircleCounter$RedPointInfo getRedPointInfo() {
        return this.mRedPointInfo;
    }

    public String getTabTipWording() {
        return this.mTabTipWording;
    }

    public boolean hasAvatarCornerRedPoint() {
        if (this.mRedPointInfo.allPushInfo.styleBottomTab.red.typ.get() != 0) {
            return true;
        }
        return false;
    }

    public boolean isNeedReportRedDot() {
        return this.mShouldReportRed;
    }

    public boolean isShowActiveRedDot() {
        return this.mIsShowActiveRedDot;
    }

    public boolean isShowRecommendRedDot() {
        return this.mIsShowRecommendRedDot;
    }

    public boolean isShowRedDot() {
        if (this.mRedNum <= 0 && !this.mIsShowActiveRedDot && !this.mIsShowPymkRedDot && !this.mIsShowRecommendRedDot) {
            return false;
        }
        return true;
    }

    public void refreshRedDotInfo(QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo) {
        String str;
        List<Integer> list;
        QLog.d(TAG, 1, "refreshRedDotInfo");
        if (qQCircleCounter$RedPointInfo == null) {
            QLog.d(TAG, 1, "refreshRedDotInfo: redInfo is null");
            return;
        }
        int allRedNum = QCircleRedDotDataHelper.getAllRedNum(qQCircleCounter$RedPointInfo);
        boolean isShowActiveRedDot = QCircleRedDotDataHelper.isShowActiveRedDot(qQCircleCounter$RedPointInfo);
        boolean isShowPymkRedDot = QCircleRedDotDataHelper.isShowPymkRedDot(qQCircleCounter$RedPointInfo);
        boolean isShowRecommendRedDot = QCircleRedDotDataHelper.isShowRecommendRedDot(qQCircleCounter$RedPointInfo, this.mRedEntranceType);
        this.mRedDotReportExt = qQCircleCounter$RedPointInfo.extend.get();
        this.mRedDisplayInfoList = qQCircleCounter$RedPointInfo.rptRedInfo.get();
        this.mShouldReportRed = true ^ QCircleHostUtil.isRedDotSame(qQCircleCounter$RedPointInfo, this.mRedPointInfo);
        this.mRedPointInfo = qQCircleCounter$RedPointInfo;
        isNeedSendRedNumChangeEvent(allRedNum);
        if (isShowRecommendRedDot && qQCircleCounter$RedPointInfo.redJumpInfo.has() && (list = qQCircleCounter$RedPointInfo.redJumpInfo.redPointSources.get()) != null && list.size() > 0 && list.contains(3)) {
            str = qQCircleCounter$RedPointInfo.redJumpInfo.jumpLink.get();
        } else {
            str = null;
        }
        this.mRedNum = allRedNum;
        this.mIsShowActiveRedDot = isShowActiveRedDot;
        this.mIsShowPymkRedDot = isShowPymkRedDot;
        this.mIsShowRecommendRedDot = isShowRecommendRedDot;
        this.mRedDotJumpUrl = str;
        this.mTabTipWording = qQCircleCounter$RedPointInfo.allPushInfo.tabTipWording.get();
        if (this.mRedNum <= 0 && !this.mIsShowActiveRedDot && !this.mIsShowPymkRedDot && !this.mIsShowRecommendRedDot) {
            this.mRedDotTransInfo = null;
            this.mEntranceTabType = -1;
        } else {
            this.mRedDotTransInfo = QCircleRedDotDataHelper.getTransInfo(qQCircleCounter$RedPointInfo);
            this.mEntranceTabType = QCircleRedDotDataHelper.getEntranceATabType(qQCircleCounter$RedPointInfo);
        }
    }

    public void reset() {
        QLog.d(TAG, 1, "reset");
        this.mRedNum = 0;
        this.mIsShowActiveRedDot = false;
        this.mIsShowPymkRedDot = false;
        this.mIsShowRecommendRedDot = false;
        this.mRedDotTransInfo = null;
        this.mEntranceTabType = -1;
        this.mRedDotReportExt = null;
    }

    public void setLastExposedBubble(QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo) {
        this.mLastExposedBubble = qQCircleCounter$RedPointInfo;
    }

    public void setLastExposedRedPointInfo(QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo) {
        this.mLastExposedRedPoint = qQCircleCounter$RedPointInfo;
    }

    public void setNeedReportRedDot(boolean z16) {
        this.mShouldReportRed = z16;
    }
}
