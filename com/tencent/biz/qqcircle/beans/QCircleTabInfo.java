package com.tencent.biz.qqcircle.beans;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import com.tencent.richframework.engineer.test.api.RFWTestMock;
import feedcloud.FeedCloudCommon$Entry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import qqcircle.QQCircleFeedBase$StTabActivityReddotTimeRange;
import qqcircle.QQCircleFeedBase$StTabEffectiveTimeRange;
import qqcircle.QQCircleFeedBase$StTabInfo;
import qqcircle.QQCircleFeedBase$StTabOpInfo;
import qqcircle.QQCircleFeedBase$StTobTabReddotInfo;
import qqcircle.QQCircleFeedBase$StTopTabIconInfo;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleTabInfo {
    private static final String TAG = "QCircleTabInfo";
    private boolean mIsCacheData = false;
    private int mPriority;
    public QQCircleFeedBase$StTabInfo mTab;
    private QQCircleFeedBase$StTabOpInfo mTabDiyInfo;

    public QCircleTabInfo(QQCircleFeedBase$StTabInfo qQCircleFeedBase$StTabInfo) {
        this.mTab = qQCircleFeedBase$StTabInfo;
        this.mTabDiyInfo = qQCircleFeedBase$StTabInfo.tabInfoByOperators;
    }

    public static QCircleTabInfo initFakeTabInfo(String str, int i3) {
        return new QCircleTabInfo(str, i3);
    }

    public static void initTabPriority(ArrayList<QCircleTabInfo> arrayList) {
        ArrayList arrayList2 = new ArrayList(arrayList);
        Collections.sort(arrayList2, new Comparator() { // from class: com.tencent.biz.qqcircle.beans.a
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int lambda$initTabPriority$0;
                lambda$initTabPriority$0 = QCircleTabInfo.lambda$initTabPriority$0((QCircleTabInfo) obj, (QCircleTabInfo) obj2);
                return lambda$initTabPriority$0;
            }
        });
        for (int i3 = 0; i3 < arrayList2.size(); i3++) {
            QCircleTabInfo qCircleTabInfo = (QCircleTabInfo) arrayList2.get(i3);
            if (qCircleTabInfo != null) {
                qCircleTabInfo.setPriority(i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$initTabPriority$0(QCircleTabInfo qCircleTabInfo, QCircleTabInfo qCircleTabInfo2) {
        try {
            return ((int) (qCircleTabInfo.getBeginTimeDistance() % TTL.MAX_VALUE)) - ((int) (qCircleTabInfo2.getBeginTimeDistance() % TTL.MAX_VALUE));
        } catch (Exception e16) {
            QLog.e(TAG, 1, "initTabPriority error:" + e16);
            return 0;
        }
    }

    @RFWTestMock(id = "QFS_TAB_PAG_ICON")
    public static QCircleTabInfo wrapper(QQCircleFeedBase$StTabInfo qQCircleFeedBase$StTabInfo) {
        return new QCircleTabInfo(qQCircleFeedBase$StTabInfo);
    }

    public String getAttachInfo() {
        return this.mTab.attachInfo.get();
    }

    public long getBeginTimeDistance() {
        if (this.mTabDiyInfo == null) {
            return Long.MAX_VALUE;
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        PBRepeatMessageField<QQCircleFeedBase$StTabActivityReddotTimeRange> pBRepeatMessageField = this.mTabDiyInfo.tabReddotInfo.activityReddotTimeRange;
        long j3 = Long.MAX_VALUE;
        for (int i3 = 0; i3 < pBRepeatMessageField.size(); i3++) {
            j3 = Math.min(Math.abs(currentTimeMillis - pBRepeatMessageField.get(i3).beginTime.get()), j3);
        }
        if (j3 == Long.MAX_VALUE) {
            PBRepeatMessageField<QQCircleFeedBase$StTabEffectiveTimeRange> pBRepeatMessageField2 = this.mTabDiyInfo.effectiveTimeRange;
            for (int i16 = 0; i16 < pBRepeatMessageField2.size(); i16++) {
                j3 = Math.min(Math.abs(currentTimeMillis - pBRepeatMessageField2.get(i16).beginTime.get()), j3);
            }
        }
        return j3;
    }

    public int getContentPoolId() {
        QQCircleFeedBase$StTabOpInfo qQCircleFeedBase$StTabOpInfo = this.mTabDiyInfo;
        if (qQCircleFeedBase$StTabOpInfo != null) {
            try {
                if (!TextUtils.isEmpty(qQCircleFeedBase$StTabOpInfo.tabPoolID.get())) {
                    return Integer.parseInt(this.mTabDiyInfo.tabPoolID.get());
                }
                return 0;
            } catch (Exception e16) {
                QLog.e(TAG, 1, "getContentPoolId error:" + e16);
                return 0;
            }
        }
        return 0;
    }

    public Collection<FeedCloudCommon$Entry> getExtInfo() {
        return this.mTab.tabExtInfo.get();
    }

    public QQCircleFeedBase$StTopTabIconInfo getIconInfo() {
        QQCircleFeedBase$StTabOpInfo qQCircleFeedBase$StTabOpInfo = this.mTabDiyInfo;
        if (qQCircleFeedBase$StTabOpInfo != null && qQCircleFeedBase$StTabOpInfo.tabIconInfo.IconType.get() == 2) {
            return this.mTabDiyInfo.tabIconInfo.get();
        }
        return null;
    }

    public boolean getIsCacheData() {
        return this.mIsCacheData;
    }

    public String getName() {
        QQCircleFeedBase$StTabOpInfo qQCircleFeedBase$StTabOpInfo = this.mTabDiyInfo;
        if (qQCircleFeedBase$StTabOpInfo != null && qQCircleFeedBase$StTabOpInfo.tabIconInfo.IconType.get() == 1) {
            return this.mTabDiyInfo.tabIconInfo.text.get();
        }
        return this.mTab.tabName.get();
    }

    public int getPriority() {
        return this.mPriority;
    }

    public int getSource() {
        int i3 = this.mTab.sourceType.get();
        if (i3 > 0) {
            return i3;
        }
        int type = getType();
        if (type == 1) {
            return 1;
        }
        if (type == 2) {
            return 4;
        }
        if (type == 3) {
            return 6;
        }
        if (type != 4) {
            if (type != 6) {
                if (type != 8) {
                    if (type == 9) {
                        return 75;
                    }
                    return i3;
                }
                return 55;
            }
            return 10;
        }
        return 5;
    }

    public int getStatus() {
        return this.mTab.status.get();
    }

    public QQCircleFeedBase$StTabOpInfo getTabDiyConfig() {
        return this.mTabDiyInfo;
    }

    public QQCircleFeedBase$StTobTabReddotInfo getTabRedDotConfig() {
        QQCircleFeedBase$StTabOpInfo qQCircleFeedBase$StTabOpInfo = this.mTabDiyInfo;
        if (qQCircleFeedBase$StTabOpInfo != null) {
            return qQCircleFeedBase$StTabOpInfo.tabReddotInfo.get();
        }
        return null;
    }

    public String getTabTaskId() {
        QQCircleFeedBase$StTabOpInfo qQCircleFeedBase$StTabOpInfo = this.mTabDiyInfo;
        if (qQCircleFeedBase$StTabOpInfo != null) {
            String str = qQCircleFeedBase$StTabOpInfo.tab_id.get();
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return this.mTab.tabName.get();
    }

    public int getType() {
        return this.mTab.tabType.get();
    }

    public QCircleTabInfo setIsCacheData(boolean z16) {
        this.mIsCacheData = z16;
        return this;
    }

    public void setPriority(int i3) {
        QLog.d(TAG, 1, "setPriority priority:" + i3 + ", taskId " + getTabTaskId() + ", name:" + getName());
        this.mPriority = i3;
    }

    public void updateName(String str) {
        this.mTab.tabName.set(str);
    }

    QCircleTabInfo(String str, int i3) {
        QQCircleFeedBase$StTabInfo qQCircleFeedBase$StTabInfo = new QQCircleFeedBase$StTabInfo();
        this.mTab = qQCircleFeedBase$StTabInfo;
        qQCircleFeedBase$StTabInfo.tabName.set(str);
        this.mTab.tabType.set(i3);
    }
}
