package j60;

import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QCircleTabInfo;
import com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment;
import com.tencent.biz.qqcircle.utils.bz;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.qcircle.api.utils.QCircleDeviceInfoUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import qqcircle.QQCircleFeedBase$StTabActivityReddotTimeRange;
import qqcircle.QQCircleFeedBase$StTabInfo;
import qqcircle.QQCircleFeedBase$StTobTabReddotInfo;
import uq3.c;
import uq3.k;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a {
    public static boolean a(QCircleTabInfo qCircleTabInfo) {
        QQCircleFeedBase$StTobTabReddotInfo tabRedDotConfig;
        if (qCircleTabInfo != null && !h(qCircleTabInfo) && (tabRedDotConfig = qCircleTabInfo.getTabRedDotConfig()) != null && tabRedDotConfig.shouldDisplayActivityReddot.get()) {
            List<QQCircleFeedBase$StTabActivityReddotTimeRange> list = tabRedDotConfig.activityReddotTimeRange.get();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            for (int i3 = 0; i3 < list.size(); i3++) {
                QQCircleFeedBase$StTabActivityReddotTimeRange qQCircleFeedBase$StTabActivityReddotTimeRange = list.get(i3).get();
                if (qQCircleFeedBase$StTabActivityReddotTimeRange != null && qQCircleFeedBase$StTabActivityReddotTimeRange.beginTime.get() < currentTimeMillis && currentTimeMillis < qQCircleFeedBase$StTabActivityReddotTimeRange.endTime.get()) {
                    if (qQCircleFeedBase$StTabActivityReddotTimeRange.beginTime.get() <= k.a().f("sp_key_normal_tab_last_show_new_tips_time_" + qCircleTabInfo.getTabTaskId(), 0L)) {
                        return false;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean b(QCircleTabInfo qCircleTabInfo) {
        QQCircleFeedBase$StTobTabReddotInfo tabRedDotConfig;
        if (qCircleTabInfo == null || h(qCircleTabInfo) || (tabRedDotConfig = qCircleTabInfo.getTabRedDotConfig()) == null || !tabRedDotConfig.shouldDisplayNewReddot.get()) {
            return false;
        }
        if (k.a().f("sp_key_normal_tab_last_show_new_tips_time_" + qCircleTabInfo.getTabTaskId(), 0L) != 0) {
            return false;
        }
        return true;
    }

    public static void c(@NonNull List<QFSFolderTabFragment> list, int i3) {
        QFSFolderTabFragment qFSFolderTabFragment;
        if (!c.W0("qqcircle", "qqcircle_main_tab_remove_fragment_when_exit", Boolean.TRUE).booleanValue()) {
            QLog.d("QFSTopTabUtils", 1, "[dealWithExitQCircle] wns close return");
            return;
        }
        QLog.d("QFSTopTabUtils", 1, "[dealWithExitQCircle] currentIndex:" + i3 + ",fragmentList size:" + list.size());
        for (int i16 = 0; i16 < list.size(); i16++) {
            if (i16 != i3 && (qFSFolderTabFragment = list.get(i16)) != null) {
                QLog.d("QFSTopTabUtils", 1, "[dealWithExitQCircle] clear page content:" + qFSFolderTabFragment.getTAG());
                qFSFolderTabFragment.mi(true);
            }
        }
    }

    public static void d(@NonNull List<QFSFolderTabFragment> list, int i3) {
        QFSFolderTabFragment qFSFolderTabFragment;
        if (list.size() <= i3) {
            QLog.d("QFSTopTabUtils", 1, "[dealWithPageLimit] currentIndex:" + i3 + ",fragmentList size:" + list.size());
            return;
        }
        QFSFolderTabFragment qFSFolderTabFragment2 = list.get(i3);
        qFSFolderTabFragment2.mi(false);
        QLog.d("QFSTopTabUtils", 1, "[dealWithPageLimit] setSelectPage with content state " + qFSFolderTabFragment2.getTAG());
        int g16 = g();
        if (g16 >= list.size()) {
            return;
        }
        Set<Integer> f16 = f(g16, i3, 0, list.size() - 1);
        for (int i16 = 0; i16 < list.size(); i16++) {
            if (i16 != i3 && (qFSFolderTabFragment = list.get(i16)) != null) {
                if (!f16.contains(Integer.valueOf(i16))) {
                    QLog.d("QFSTopTabUtils", 1, "[dealWithPageLimit] setPage empty state " + qFSFolderTabFragment.getTAG());
                    qFSFolderTabFragment.mi(true);
                } else if (qFSFolderTabFragment.Nh() && Math.abs(i16 - i3) <= 1) {
                    QLog.d("QFSTopTabUtils", 1, "[dealWithPageLimit] setPage content state " + qFSFolderTabFragment.getTAG());
                    qFSFolderTabFragment.mi(false);
                }
            }
        }
    }

    public static List<QQCircleFeedBase$StTabInfo> e(List<QQCircleFeedBase$StTabInfo> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            return arrayList;
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            QQCircleFeedBase$StTabInfo qQCircleFeedBase$StTabInfo = list.get(i3);
            if (qQCircleFeedBase$StTabInfo != null) {
                if (qQCircleFeedBase$StTabInfo.tabType.get() == 11) {
                    if (i()) {
                        arrayList.add(qQCircleFeedBase$StTabInfo);
                    } else {
                        RFWLog.d("QFSTopTabUtils", RFWLog.USR, "[filterSupportTabList] remove activity pad");
                    }
                } else {
                    arrayList.add(qQCircleFeedBase$StTabInfo);
                }
            }
        }
        return arrayList;
    }

    private static Set<Integer> f(int i3, int i16, int i17, int i18) {
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        copyOnWriteArraySet.add(Integer.valueOf(i16));
        int i19 = i16 - 1;
        int i26 = i16 + 1;
        while (copyOnWriteArraySet.size() < i3) {
            if (i19 >= i17) {
                copyOnWriteArraySet.add(Integer.valueOf(i19));
                i19--;
            }
            if (copyOnWriteArraySet.size() >= i3) {
                break;
            }
            if (i26 <= i18) {
                copyOnWriteArraySet.add(Integer.valueOf(i26));
                i26++;
            }
            if (i19 < i17 && i26 > i18) {
                break;
            }
        }
        return copyOnWriteArraySet;
    }

    private static int g() {
        if (QCircleDeviceInfoUtils.isHighDevice()) {
            return c.X0("qqcircle", "qqcircle_main_tab_limit_high_device", 5).intValue();
        }
        if (QCircleDeviceInfoUtils.isMediumDevice()) {
            return c.X0("qqcircle", "qqcircle_main_tab_limit_medium_device", 5).intValue();
        }
        return c.X0("qqcircle", "qqcircle_main_tab_limit_low_device", 4).intValue();
    }

    public static boolean h(QCircleTabInfo qCircleTabInfo) {
        if (qCircleTabInfo == null) {
            return false;
        }
        int type = qCircleTabInfo.getType();
        if (type != 1 && type != 6 && type != 8 && type != 9) {
            return false;
        }
        return true;
    }

    private static boolean i() {
        if (!bz.r()) {
            return true;
        }
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_activity_tab_support_pad", true);
    }

    public static void j(QCircleTabInfo qCircleTabInfo) {
        QQCircleFeedBase$StTobTabReddotInfo tabRedDotConfig;
        if (qCircleTabInfo == null || h(qCircleTabInfo) || (tabRedDotConfig = qCircleTabInfo.getTabRedDotConfig()) == null) {
            return;
        }
        if (!tabRedDotConfig.shouldDisplayActivityReddot.get() && !tabRedDotConfig.shouldDisplayNewReddot.get()) {
            return;
        }
        QLog.d("QFSTopTabUtils", 1, "[onTopTabRedPointClicked] tabId:" + qCircleTabInfo.getTabTaskId());
        k.a().n("sp_key_normal_tab_last_show_new_tips_time_" + qCircleTabInfo.getTabTaskId(), System.currentTimeMillis() / 1000);
    }
}
