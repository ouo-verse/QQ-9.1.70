package k30;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QCircleTabInfo;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSFeedVideoErrorEvent;
import com.tencent.biz.qqcircle.immersive.layer.biz.inside.tab.QFSTabFeedViewModel;
import com.tencent.biz.qqcircle.immersive.repository.foldertab.QFSFeedRspProcessUtils;
import com.tencent.biz.qqcircle.immersive.utils.y;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.thread.RFWThreadManager;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import k30.e;
import qqcircle.QQCircleFeedBase$StTabInfo;

/* compiled from: P */
/* loaded from: classes4.dex */
public class n {

    /* renamed from: b, reason: collision with root package name */
    private static volatile n f411506b;

    /* renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<Integer, e.a> f411507a = new ConcurrentHashMap<>();

    public static boolean d() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_folder_use_one_feed_disk_cache_rsp", true);
    }

    private boolean e(a aVar) {
        if (aVar == null || aVar.G() == null || !d()) {
            return false;
        }
        QQCircleFeedBase$StTabInfo G = aVar.G();
        QLog.d("FeedLine_QCircleFolderDiskCacheHelper", 1, "canUseOneFeedDiskRspLogic tabInfo:" + G.tabType.get());
        if (G.tabType.get() != 6) {
            return false;
        }
        return true;
    }

    public static boolean g() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_folder_use_app_version_check", false);
    }

    private FeedCloudMeta$StFeed h(List<e30.b> list, int i3) {
        if (l40.i.F()) {
            i3++;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        if (i3 >= list.size()) {
            i3 = list.size() - 1;
        }
        FeedCloudMeta$StFeed g16 = list.get(i3).g();
        if (y.i(g16)) {
            QLog.d("FeedLine_QCircleFolderDiskCacheHelper", 1, "findNeedSaveFeed from saveFeedIndex :" + i3);
            return g16;
        }
        for (int i16 = 0; i16 < list.size(); i16++) {
            e30.b bVar = list.get(i16);
            if (bVar != null && y.i(bVar.g())) {
                QLog.d("FeedLine_QCircleFolderDiskCacheHelper", 1, "findNeedSaveFeed from consumeList :" + i16 + ",saveIndex:" + i3);
                return bVar.g();
            }
        }
        return null;
    }

    private static String i(int i3) {
        return "QCircleFolderDiskCacheHelper_AppVersion_" + i3;
    }

    private static String j(int i3) {
        return "QCircleFolderDiskCacheHelper_" + i3;
    }

    public static n k() {
        if (f411506b == null) {
            synchronized (n.class) {
                if (f411506b == null) {
                    f411506b = new n();
                }
            }
        }
        return f411506b;
    }

    public static void l(@NonNull final QFSTabFeedViewModel qFSTabFeedViewModel, final QFSFeedVideoErrorEvent qFSFeedVideoErrorEvent) {
        final QCircleTabInfo w26 = qFSTabFeedViewModel.w2();
        if (w26 != null && w26.getType() == 6) {
            if (!d()) {
                QLog.d("FeedLine_QCircleFolderDiskCacheHelper", 1, "[handlerRemovePlayErrorVideo] canUseOneFeedDiskRspLogic return false");
                return;
            }
            QLog.d("FeedLine_QCircleFolderDiskCacheHelper", 1, "[handlerRemovePlayErrorVideo] videoErrorEvent:" + qFSFeedVideoErrorEvent + "\uff0ctabInfo\uff1a" + w26.getType());
            if (qFSFeedVideoErrorEvent != null && qFSFeedVideoErrorEvent.getErrorPresenterInfo() != null) {
                RFWThreadManager.getUIHandler().post(new Runnable() { // from class: k30.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        n.m(QFSTabFeedViewModel.this, qFSFeedVideoErrorEvent, w26);
                    }
                });
                return;
            }
            return;
        }
        QLog.d("FeedLine_QCircleFolderDiskCacheHelper", 1, "[handlerRemovePlayErrorVideo] tab not support");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void m(QFSTabFeedViewModel qFSTabFeedViewModel, QFSFeedVideoErrorEvent qFSFeedVideoErrorEvent, QCircleTabInfo qCircleTabInfo) {
        QFSTabFeedViewModel.c value = qFSTabFeedViewModel.v2().getValue();
        if (value == null) {
            QLog.d("FeedLine_QCircleFolderDiskCacheHelper", 1, "[handlerRemovePlayErrorVideo] currentSnapshot is null");
            return;
        }
        List<e30.b> a16 = value.a();
        if (a16 != null && !a16.isEmpty()) {
            e30.b bVar = a16.get(0);
            if (bVar != null && bVar.i()) {
                FeedCloudMeta$StFeed d16 = qFSFeedVideoErrorEvent.getErrorPresenterInfo().d();
                if (d16 == null) {
                    QLog.d("FeedLine_QCircleFolderDiskCacheHelper", 1, "[handlerRemovePlayErrorVideo] playErrorFeed is null");
                    return;
                }
                String str = d16.f398449id.get();
                if (TextUtils.equals(bVar.g().f398449id.get(), str)) {
                    uq3.k.a().k(j(qCircleTabInfo.getType()), null);
                    QLog.d("FeedLine_QCircleFolderDiskCacheHelper", 1, "[handlerRemovePlayErrorVideo] real do remove play error feed: " + str);
                    a16.remove(bVar);
                    qFSTabFeedViewModel.e3(value);
                    qFSTabFeedViewModel.d3(UIStateData.obtainDelete().setDataList(value.a()).setFinish(value.b()));
                    return;
                }
                return;
            }
            QLog.d("FeedLine_QCircleFolderDiskCacheHelper", 1, "[handlerRemovePlayErrorVideo] isFromDiskCache return false");
            return;
        }
        QLog.d("FeedLine_QCircleFolderDiskCacheHelper", 1, "[handlerRemovePlayErrorVideo] feedList is empty");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n() {
        if (!d()) {
            QLog.e("FeedLine_QCircleFolderDiskCacheHelper", 1, "preloadCacheFeed can use return false");
            return;
        }
        e.a q16 = q(6);
        QLog.d("FeedLine_QCircleFolderDiskCacheHelper", 1, "preloadCacheFeed allPushCache:" + q16);
        if (q16 != null) {
            this.f411507a.put(6, q16);
            ArrayList<e30.b> f16 = q16.f();
            if (f16 != null && f16.size() > 0) {
                h.f().o(6, f16.get(0).g());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o(a aVar, int i3, int i16) {
        ArrayList<e30.b> f16;
        e.a o16 = e.a.o(aVar, i3, i16);
        if (o16 != null && o16.j() != null && (f16 = o16.f()) != null && !f16.isEmpty()) {
            int i17 = o16.j().tabType.get();
            FeedCloudMeta$StFeed h16 = h(f16, i3);
            if (h16 == null) {
                QLog.d("FeedLine_QCircleFolderDiskCacheHelper", 1, "savePageCache but find sourceData is null");
                return;
            }
            try {
                String n3 = AppSetting.n();
                uq3.k.a().k(j(i17), h16.toByteArray());
                uq3.k.a().p(i(i17), n3);
                QLog.d("FeedLine_QCircleFolderDiskCacheHelper", 1, "savePageCache success\uff01tabType:" + i17 + ",feedId\uff1a" + h16.f398449id.get() + ",appVersion:" + n3);
            } catch (Exception e16) {
                QLog.e("FeedLine_QCircleFolderDiskCacheHelper", 1, "savePageCache error:" + e16);
            }
        }
    }

    private e.a q(int i3) {
        String h16 = uq3.k.a().h(i(i3), "");
        if (g() && !TextUtils.equals(h16, AppSetting.n())) {
            QLog.e("FeedLine_QCircleFolderDiskCacheHelper", 1, "readCacheFromFile tabType:" + i3 + ",but appVersion not equals");
            return null;
        }
        byte[] d16 = uq3.k.a().d(j(i3), new byte[0]);
        if (d16 != null && d16.length != 0) {
            try {
                FeedCloudMeta$StFeed feedCloudMeta$StFeed = new FeedCloudMeta$StFeed();
                feedCloudMeta$StFeed.mergeFrom(d16);
                e.a aVar = new e.a();
                aVar.n(true);
                CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
                copyOnWriteArrayList.add(feedCloudMeta$StFeed);
                QLog.e("FeedLine_QCircleFolderDiskCacheHelper", 1, "readPageCache feed id:" + feedCloudMeta$StFeed.f398449id.get());
                QFSFeedRspProcessUtils.g(null, copyOnWriteArrayList, false);
                List<e30.b> c16 = QFSFeedRspProcessUtils.c(copyOnWriteArrayList, true);
                if (c16 != null && !c16.isEmpty()) {
                    Iterator<e30.b> it = c16.iterator();
                    while (it.hasNext()) {
                        it.next().k(true);
                    }
                }
                aVar.m(c16);
                return aVar;
            } catch (Exception e16) {
                QLog.e("FeedLine_QCircleFolderDiskCacheHelper", 1, "readPageCache error:" + e16);
            }
        }
        return null;
    }

    public static void s() {
        QLog.d("FeedLine_QCircleFolderDiskCacheHelper", 1, "releaseInstance");
        if (f411506b != null) {
            synchronized (n.class) {
                if (f411506b != null) {
                    f411506b = new n();
                }
            }
        }
    }

    public void f() {
        QLog.e("FeedLine_QCircleFolderDiskCacheHelper", 1, "clearAllPushCache");
        uq3.k.a().k(j(6), null);
        this.f411507a.remove(6);
    }

    public void p() {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: k30.l
            @Override // java.lang.Runnable
            public final void run() {
                n.this.n();
            }
        });
    }

    public boolean r(a aVar) {
        if (!e(aVar)) {
            QLog.e("FeedLine_QCircleFolderDiskCacheHelper", 1, "readPageCache can use return false");
            return false;
        }
        QQCircleFeedBase$StTabInfo G = aVar.G();
        if (G == null) {
            return false;
        }
        int i3 = G.tabType.get();
        e.a remove = this.f411507a.remove(Integer.valueOf(i3));
        if (remove == null) {
            remove = q(i3);
        }
        if (remove == null) {
            QLog.d("FeedLine_QCircleFolderDiskCacheHelper", 1, "readPageCache error folderPageCache is null; tabName:" + i3);
            return false;
        }
        aVar.Q0(remove);
        if (!aVar.M(remove)) {
            return false;
        }
        QLog.d("FeedLine_QCircleFolderDiskCacheHelper", 1, "readPageCache success\uff01tabName:" + i3);
        return true;
    }

    public void t(final a aVar, final int i3, final int i16) {
        if (!e(aVar)) {
            QLog.e("FeedLine_QCircleFolderDiskCacheHelper", 1, "savePageCache can use return false");
        } else {
            RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: k30.m
                @Override // java.lang.Runnable
                public final void run() {
                    n.this.o(aVar, i3, i16);
                }
            });
        }
    }
}
