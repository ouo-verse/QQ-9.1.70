package com.tencent.biz.qqcircle.aspectj;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.aspectj.utils.QCircleScrollMonitorConfig;
import com.tencent.biz.qqcircle.bizparts.QCircleBaseBlockPart;
import com.tencent.biz.qqcircle.immersive.part.QFSBaseBlockPart;
import com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart;
import com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalFeedFragment;
import com.tencent.biz.qqcircle.list.QCircleBaseListBlock;
import com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.richframework.monitor.RFWMonitorManager;
import com.tencent.biz.richframework.part.utils.RFSafeMapUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleReportBean;
import java.util.Map;

/* loaded from: classes4.dex */
public class QCircleAspectScrollProcessor {
    private static final int SCROLL_ILLEGAL_STATE = -2;
    private static final String TAG = "QCircleAspectScrollProcessor";
    private static volatile QCircleAspectScrollProcessor sInstance;
    private final Map<Integer, Integer> mRepeatMap = new ArrayMap();
    private final QCircleScrollMonitorConfig mQCircleScrollMonitorConfig = new QCircleScrollMonitorConfig();

    QCircleAspectScrollProcessor() {
    }

    public static QCircleAspectScrollProcessor getInstance() {
        if (sInstance == null) {
            synchronized (QCircleAspectScrollProcessor.class) {
                if (sInstance == null) {
                    sInstance = new QCircleAspectScrollProcessor();
                }
            }
        }
        return sInstance;
    }

    private void handleBlockPart(QCircleBaseBlockPart qCircleBaseBlockPart, int i3) {
        QCircleReportBean reportBean = qCircleBaseBlockPart.getReportBean();
        if (reportBean == null) {
            printLogMsg("[handleBlockPart] bean should not be null.");
        } else {
            handleScrollStateChange(reportBean.getPageId(), i3);
        }
    }

    private void handleListBlock(@NonNull BaseListBlock baseListBlock, int i3) {
        QCircleReportBean reportBean = baseListBlock.getReportBean();
        if (reportBean == null) {
            printLogMsg("[handleListBlock] bean should not be null.");
        } else {
            handleScrollStateChange(reportBean.getPageId(), i3);
        }
    }

    private void handlePersonalProductFeed(QFSPersonalFeedFragment qFSPersonalFeedFragment, int i3) {
        QCircleReportBean reportBean = qFSPersonalFeedFragment.getReportBean();
        if (reportBean == null) {
            printLogMsg("[handlePersonalProductFeed] bean should not be null.");
        } else {
            handleScrollStateChange(reportBean.getPageId(), i3);
        }
    }

    private void handleQFSBlockPart(QFSBaseBlockPart qFSBaseBlockPart, int i3) {
        QCircleReportBean reportBean = qFSBaseBlockPart.getReportBean();
        if (reportBean == null) {
            printLogMsg("[handleQFSBlockPart] bean should not be null.");
        } else {
            handleScrollStateChange(reportBean.getPageId(), i3);
        }
    }

    private void handleScrollLayer(@NonNull QFSLayerBasePart qFSLayerBasePart, int i3) {
        QCircleReportBean reportBean = qFSLayerBasePart.getReportBean();
        if (reportBean == null) {
            printLogMsg("[handleScrollLayer] bean should not be null.");
        } else {
            handleScrollStateChange(reportBean.getPageId(), i3);
        }
    }

    private void handleScrollState(Object obj, int i3) {
        if (obj instanceof QFSLayerBasePart) {
            handleScrollLayer((QFSLayerBasePart) obj, i3);
        } else if (obj instanceof QCircleBaseBlockPart) {
            handleBlockPart((QCircleBaseBlockPart) obj, i3);
        } else if (obj instanceof QFSBaseBlockPart) {
            handleQFSBlockPart((QFSBaseBlockPart) obj, i3);
        } else if (obj instanceof QFSPersonalFeedFragment) {
            handlePersonalProductFeed((QFSPersonalFeedFragment) obj, i3);
        } else if (obj instanceof QCircleBaseListBlock) {
            handleListBlock((BaseListBlock) obj, i3);
        } else if (obj instanceof QCircleBaseWidgetView) {
            handleWidgetView((QCircleBaseWidgetView) obj, i3);
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "[onScrollState] object: ", obj);
        }
    }

    private void handleScrollStateChange(int i3, int i16) {
        int intValue;
        if (i3 == -1) {
            return;
        }
        Integer num = (Integer) RFSafeMapUtils.getVal(this.mRepeatMap, Integer.valueOf(i3));
        if (num == null) {
            intValue = -2;
        } else {
            intValue = num.intValue();
        }
        if (Integer.valueOf(intValue).intValue() == i16) {
            return;
        }
        if (i16 == 1) {
            printMonitorMsg(i3, "SCROLL_STATE_DRAGGING");
            RFWMonitorManager.instance().startPageScroll(i3);
        } else if (QCirclePluginGlobalInfo.f() && i16 == 2) {
            printMonitorMsg(i3, "SCROLL_STATE_SETTLING");
            RFWMonitorManager.instance().startPageScroll(i3);
        } else if (i16 == 0) {
            printMonitorMsg(i3, "SCROLL_STATE_IDLE");
            RFWMonitorManager.instance().endPageScroll(i3);
        }
        RFSafeMapUtils.put(this.mRepeatMap, Integer.valueOf(i3), Integer.valueOf(i16));
    }

    private void handleWidgetView(@NonNull QCircleBaseWidgetView qCircleBaseWidgetView, int i3) {
        QCircleReportBean reportBean = qCircleBaseWidgetView.getReportBean();
        if (reportBean == null) {
            printLogMsg("[handleWidgetView] bean should not be null.");
        } else {
            handleScrollStateChange(reportBean.getPageId(), i3);
        }
    }

    private void printLogMsg(String str) {
        if (!TextUtils.isEmpty(str) && QLog.isColorLevel()) {
            QLog.d(TAG, 2, str);
        }
    }

    private void printMonitorMsg(int i3, String str) {
        if (QLog.isColorLevel()) {
            printLogMsg("[handleScrollStateChange] page id: " + i3 + ", state is: " + str);
        }
    }

    public void onScrollPageIdState(int i3, int i16) {
        if (!this.mQCircleScrollMonitorConfig.isPackageVersionEnabled() || !this.mQCircleScrollMonitorConfig.isWnsMonitorEnabled()) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "[onScrollPageIdState] scrollState: " + i3);
        }
        handleScrollStateChange(i16, i3);
    }

    public void onScrollState(Object obj, int i3) {
        if (!this.mQCircleScrollMonitorConfig.isPackageVersionEnabled() || !this.mQCircleScrollMonitorConfig.isWnsMonitorEnabled()) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "[onScrollState] target: ", obj);
        }
        handleScrollState(obj, i3);
    }
}
