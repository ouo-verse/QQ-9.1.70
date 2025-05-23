package k30;

import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QCircleTabInfo;
import com.tencent.biz.qqcircle.immersive.layer.biz.inside.tab.QFSTabFeedViewModel;
import com.tencent.biz.qqcircle.immersive.utils.y;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class j {
    private static void b(List<e30.b> list, List<e30.b> list2) {
        if (!f() || list == null || list2 == null || list2.isEmpty()) {
            return;
        }
        e30.b bVar = list2.get(list2.size() - 1);
        if (!y.e(bVar)) {
            QLog.e("FeedLine_QCircleFolderCropFeedHelper", 1, "[dealWithAdFeedCropLogic] last feed is not ad feed");
            return;
        }
        int size = list.size();
        int size2 = list2.size();
        if (size > size2) {
            e30.b bVar2 = list.get(size2);
            if (bVar2 != null && !y.e(bVar2)) {
                QLog.d("FeedLine_QCircleFolderCropFeedHelper", 1, "[dealWithAdFeedCropLogic] append normal feed");
                list2.add(bVar2);
                return;
            } else {
                QLog.d("FeedLine_QCircleFolderCropFeedHelper", 1, "[dealWithAdFeedCropLogic] remove last ad feed");
                list2.remove(bVar);
                return;
            }
        }
        QLog.d("FeedLine_QCircleFolderCropFeedHelper", 1, "[dealWithAdFeedCropLogic] remove last ad feed, reason no more feed");
        list2.remove(bVar);
    }

    private static List<e30.b> c(@NonNull List<e30.b> list, int i3, int i16) {
        if (com.tencent.mobileqq.qcircle.api.utils.b.c()) {
            QLog.e("FeedLine_QCircleFolderCropFeedHelper", 1, "[doCropFeedList] current hit clip data black list, end flow.");
            return list;
        }
        if (i3 >= 0 && i3 < list.size()) {
            int e16 = v30.b.e(list);
            if (i16 + e16 >= list.size()) {
                QLog.d("FeedLine_QCircleFolderCropFeedHelper", 1, "[doCropFeedList] not need crop\uff0clastUselessDataIndex\uff1a" + e16 + ",feedList:" + list.size());
                return null;
            }
            int i17 = 0;
            for (int i18 = e16; i18 <= i3; i18++) {
                if (i3 - i18 >= 5) {
                    v30.b.a(list, i18);
                } else {
                    i17++;
                }
            }
            ArrayList arrayList = new ArrayList();
            int i19 = i3 + 1;
            List<e30.b> subList = list.subList(0, Math.min(i19, list.size()));
            ArrayList arrayList2 = new ArrayList();
            int i26 = i16 - i17;
            if (list.size() > i19) {
                arrayList2.addAll(list.subList(i19, Math.min(list.size(), i26 + i19)));
            }
            arrayList.addAll(subList);
            arrayList.addAll(arrayList2);
            b(list, arrayList);
            QLog.d("FeedLine_QCircleFolderCropFeedHelper", 1, "[doCropFeedList] originFeed size:" + list.size() + ",historyKeepSize size:" + i17 + ",loadMoreList size:" + arrayList2.size() + ",curExposePos:" + i3 + ",lastUselessDataIndex:" + e16 + ",mergeResult size:" + arrayList.size());
            return arrayList;
        }
        QLog.e("FeedLine_QCircleFolderCropFeedHelper", 1, "[doCropFeedList] curExposePos error " + i3);
        return null;
    }

    public static int d() {
        String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_folder_feed_limit_when_exit_tab", "10");
        try {
            return Integer.parseInt(loadAsString);
        } catch (Exception e16) {
            QLog.e("FeedLine_QCircleFolderCropFeedHelper", 1, "[getFeedLimit] error: " + e16 + ",serverConfig:" + loadAsString);
            return 10;
        }
    }

    public static void e(@NonNull final QFSTabFeedViewModel qFSTabFeedViewModel) {
        if (!g()) {
            return;
        }
        final QCircleTabInfo w26 = qFSTabFeedViewModel.w2();
        if (w26 == null) {
            QLog.d("FeedLine_QCircleFolderCropFeedHelper", 1, "[handlerFeedLimitWhenExit] tab not support ");
            return;
        }
        final int d16 = d();
        if (d16 <= 0) {
            return;
        }
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: k30.i
            @Override // java.lang.Runnable
            public final void run() {
                j.h(d16, w26, qFSTabFeedViewModel);
            }
        });
    }

    private static boolean f() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_folder_enable_feed_crop_ad_limit_logic", true);
    }

    private static boolean g() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_folder_enable_feed_limit_when_exit_tab", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h(int i3, QCircleTabInfo qCircleTabInfo, QFSTabFeedViewModel qFSTabFeedViewModel) {
        QLog.d("FeedLine_QCircleFolderCropFeedHelper", 1, "[handlerFeedLimitWhenExit] feedLimit is:" + i3 + "\uff0ctabInfo\uff1a" + qCircleTabInfo.getType());
        QFSTabFeedViewModel.c value = qFSTabFeedViewModel.v2().getValue();
        if (value == null) {
            QLog.d("FeedLine_QCircleFolderCropFeedHelper", 1, "[handlerFeedLimitWhenExit] currentSnapshot is null");
            return;
        }
        List<e30.b> a16 = value.a();
        if (a16 != null && !a16.isEmpty()) {
            ArrayList arrayList = new ArrayList(a16);
            if (arrayList.size() <= i3) {
                QLog.d("FeedLine_QCircleFolderCropFeedHelper", 1, "[handlerFeedLimitWhenExit] feed size <= feedLimit");
                return;
            }
            int J = qFSTabFeedViewModel.J();
            List<e30.b> c16 = c(arrayList, J, i3);
            if (c16 == null) {
                QLog.d("FeedLine_QCircleFolderCropFeedHelper", 1, "[handlerFeedLimitWhenExit] mergeResult is null");
                return;
            }
            a16.clear();
            a16.addAll(c16);
            QLog.d("FeedLine_QCircleFolderCropFeedHelper", 1, "[handlerFeedLimitWhenExit] current feedList size: " + arrayList.size());
            qFSTabFeedViewModel.e3(value);
            qFSTabFeedViewModel.d3(UIStateData.obtainModify().setPos(J).setType(102).setDataList(value.a()).setFinish(value.b()));
            return;
        }
        QLog.d("FeedLine_QCircleFolderCropFeedHelper", 1, "[handlerFeedLimitWhenExit] feedList is empty");
    }
}
