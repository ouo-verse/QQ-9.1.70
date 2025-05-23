package k30;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants;
import com.tencent.biz.qcircleshadow.lib.QCircleHostRedPointHelper;
import com.tencent.biz.qqcircle.beans.QCircleTabInfo;
import com.tencent.biz.qqcircle.helpers.y;
import com.tencent.biz.qqcircle.immersive.feed.ad.u;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSFeedVideoErrorEvent;
import com.tencent.biz.qqcircle.immersive.layer.biz.inside.tab.QFSTabFeedViewModel;
import com.tencent.biz.qqcircle.richframework.preload.coldbootV2.QCircleColdBootPreloadFeedManagerV2;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.video.rfw.player.playerprender.RFWPlayerPreRenderBean;
import com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerPreRenderHelper;
import com.tencent.biz.richframework.video.rfw.player.stinfo.RFWStVideo;
import com.tencent.biz.richframework.video.rfw.view.RFWPlayerReuseUtils;
import com.tencent.mobileqq.qcircle.api.coldboot.IPreloadTask;
import com.tencent.mobileqq.qcircle.api.constant.QCircleRedPointAppidContants;
import com.tencent.mobileqq.qcircle.api.utils.EeveeRedpointUtil;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.thread.RFWThreadManager;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.List;
import qqcircle.QQCircleCounter$RedPointInfo;
import uq3.o;

/* compiled from: P */
/* loaded from: classes4.dex */
public class h {

    /* renamed from: c, reason: collision with root package name */
    private static volatile h f411492c;

    /* renamed from: a, reason: collision with root package name */
    private e30.b f411493a;

    /* renamed from: b, reason: collision with root package name */
    private FeedCloudMeta$StFeed f411494b;

    private List<e30.b> c(List<e30.b> list) {
        e30.b bVar;
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            e30.b bVar2 = list.get(0);
            if (bVar2 != null && bVar2.i()) {
                arrayList.add(bVar2);
            }
            if (list.size() > 1 && (bVar = list.get(1)) != null && z20.f.n(bVar.g())) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    private FeedCloudMeta$StFeed e() {
        if (!com.tencent.biz.qqcircle.richframework.preload.coldbootV2.h.b()) {
            return null;
        }
        IPreloadTask task = QCircleColdBootPreloadFeedManagerV2.getInstance().getTask(10000);
        if (task == null) {
            QLog.d("QCircleFolderClickPreRenderHelper", 1, "getFeedFromBackUp IPreloadTask is null");
            return null;
        }
        return task.getPreloadFeed();
    }

    public static h f() {
        synchronized (h.class) {
            if (f411492c == null) {
                f411492c = new h();
            }
        }
        return f411492c;
    }

    private FeedCloudMeta$StFeed i() {
        FeedCloudMeta$StFeed preloadFeed;
        IPreloadTask task = QCircleColdBootPreloadFeedManagerV2.getInstance().getTask(10);
        if (task == null || (preloadFeed = task.getPreloadFeed()) == null) {
            return null;
        }
        QLog.d("QCircleFolderClickPreRenderHelper", 1, "getAllPushNeedPreRenderVideo return from mAllPushNormalPreloadFeed");
        return preloadFeed;
    }

    private FeedCloudMeta$StFeed j() {
        QQCircleCounter$RedPointInfo qQMainTabOuterEntranceRedPointInfoByAppid = QCircleHostRedPointHelper.getQQMainTabOuterEntranceRedPointInfoByAppid(QCircleRedPointAppidContants.QCIRCLE_ENTRANCE);
        if (qQMainTabOuterEntranceRedPointInfoByAppid == null) {
            QLog.d("QCircleFolderClickPreRenderHelper", 1, "getRedPointNeedPreRenderFeed redPointInfo is null");
            return null;
        }
        IPreloadTask task = QCircleColdBootPreloadFeedManagerV2.getInstance().getTask(10000);
        if (task == null) {
            QLog.d("QCircleFolderClickPreRenderHelper", 1, "getRedPointNeedPreRenderFeed IPreloadTask is null");
            return null;
        }
        FeedCloudMeta$StFeed preloadFeed = task.getPreloadFeed();
        if (preloadFeed == null) {
            QLog.d("QCircleFolderClickPreRenderHelper", 1, "getRedPointNeedPreRenderFeed allPushRedPointPreloadFeed is null");
            return null;
        }
        String redPointFeedId = EeveeRedpointUtil.getRedPointFeedId(qQMainTabOuterEntranceRedPointInfoByAppid);
        if (TextUtils.isEmpty(redPointFeedId)) {
            QLog.d("QCircleFolderClickPreRenderHelper", 1, "getRedPointNeedPreRenderFeed redPointFeedId is null");
            return null;
        }
        if (!y.q(qQMainTabOuterEntranceRedPointInfoByAppid)) {
            QLog.d("QCircleFolderClickPreRenderHelper", 1, "getRedPointNeedPreRenderFeed redPointNeedRefreshFeed return false");
            return null;
        }
        int i3 = qQMainTabOuterEntranceRedPointInfoByAppid.tabType.get();
        QLog.d("QCircleFolderClickPreRenderHelper", 1, "getAllPushNeedPreRenderVideo return from redPoint;tabType:" + i3);
        if (i3 != 6 || !TextUtils.equals(preloadFeed.f398449id.get(), redPointFeedId)) {
            return null;
        }
        return preloadFeed;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(QFSTabFeedViewModel qFSTabFeedViewModel, QFSFeedVideoErrorEvent qFSFeedVideoErrorEvent) {
        QFSTabFeedViewModel.c value = qFSTabFeedViewModel.v2().getValue();
        if (value == null) {
            QLog.d("QCircleFolderClickPreRenderHelper", 1, "[handlerRemovePlayErrorVideo] currentSnapshot is null");
            return;
        }
        List<e30.b> a16 = value.a();
        if (a16 != null && !a16.isEmpty()) {
            List<e30.b> c16 = c(a16);
            if (c16.isEmpty()) {
                QLog.d("QCircleFolderClickPreRenderHelper", 1, "[handlerRemovePlayErrorVideo] isFromDiskCache return false");
                return;
            }
            FeedCloudMeta$StFeed d16 = qFSFeedVideoErrorEvent.getErrorPresenterInfo().d();
            if (d16 == null) {
                QLog.d("QCircleFolderClickPreRenderHelper", 1, "[handlerRemovePlayErrorVideo] playErrorFeed is null");
                return;
            }
            String str = d16.f398449id.get();
            for (int i3 = 0; i3 < c16.size(); i3++) {
                e30.b bVar = c16.get(i3);
                if (TextUtils.equals(bVar.g().f398449id.get(), str)) {
                    QLog.d("QCircleFolderClickPreRenderHelper", 1, "[handlerRemovePlayErrorVideo] real do remove play error feed: " + str);
                    n(bVar.g());
                    a16.remove(bVar);
                    qFSTabFeedViewModel.e3(value);
                    qFSTabFeedViewModel.d3(UIStateData.obtainDelete().setDataList(value.a()).setFinish(value.b()));
                    return;
                }
            }
            return;
        }
        QLog.d("QCircleFolderClickPreRenderHelper", 1, "[handlerRemovePlayErrorVideo] feedList is empty");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void m(boolean z16) {
        QLog.d("QCircleFolderClickPreRenderHelper", 1, "triggerVideoSDKInitIfNeed isSucceed:" + z16);
    }

    private void s() {
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_init_sdk_when_click_prerender", true)) {
            return;
        }
        if (!QQVideoPlaySDKManager.isSDKReady()) {
            QLog.d("QCircleFolderClickPreRenderHelper", 1, "triggerVideoSDKInitIfNeed read do");
            QQVideoPlaySDKManager.initSDKAsync(RFWApplication.getApplication(), new SDKInitListener() { // from class: k30.g
                @Override // com.tencent.mobileqq.videoplatform.SDKInitListener
                public final void onSDKInited(boolean z16) {
                    h.m(z16);
                }
            });
        } else {
            QLog.d("QCircleFolderClickPreRenderHelper", 1, "triggerVideoSDKInitIfNeed sdk is ready");
        }
    }

    public FeedCloudMeta$StFeed d() {
        return this.f411494b;
    }

    public FeedCloudMeta$StFeed g(boolean z16) {
        FeedCloudMeta$StFeed h16 = h(z16);
        if (h16 == null) {
            QLog.d("QCircleFolderClickPreRenderHelper", 1, "getNeedPreRenderFeed needPreRenderOriginFeed null");
            return null;
        }
        if (!u.b()) {
            return h16;
        }
        e30.b bVar = this.f411493a;
        if (bVar != null && bVar.g() == h16) {
            FeedCloudMeta$StFeed c16 = u.c(bVar);
            if (c16 != null) {
                QLog.d("QCircleFolderClickPreRenderHelper", 1, "getNeedPreRenderFeed return from lastPlay ad feed");
                return c16;
            }
            QLog.d("QCircleFolderClickPreRenderHelper", 1, "getNeedPreRenderFeed return from lastPlay origin");
            return bVar.g();
        }
        return h16;
    }

    public FeedCloudMeta$StFeed h(boolean z16) {
        FeedCloudMeta$StFeed k3 = bb0.b.i().k(false);
        String j3 = bb0.b.i().j();
        if (k3 != null && TextUtils.equals(j3, k3.f398449id.get())) {
            QLog.d("QCircleFolderClickPreRenderHelper", 1, "getNeedPreRenderOriginFeed return from push preload data");
            return k3;
        }
        FeedCloudMeta$StFeed j16 = j();
        if (j16 != null) {
            return j16;
        }
        if (this.f411493a != null) {
            QLog.d("QCircleFolderClickPreRenderHelper", 1, "getAllPushNeedPreRenderVideo return from mLastFolderPlayFeed");
            return this.f411493a.g();
        }
        FeedCloudMeta$StFeed i3 = i();
        if (i3 != null) {
            return i3;
        }
        if (this.f411494b != null) {
            QLog.d("QCircleFolderClickPreRenderHelper", 1, "getAllPushNeedPreRenderVideo return from mAllPushDiskCacheFeed");
            return this.f411494b;
        }
        FeedCloudMeta$StFeed e16 = e();
        if (e16 != null) {
            QLog.d("QCircleFolderClickPreRenderHelper", 1, "getAllPushNeedPreRenderVideo return from redPoint backup");
            return e16;
        }
        e30.b h16 = z20.f.k().h("");
        if (h16 != null) {
            QLog.d("QCircleFolderClickPreRenderHelper", 1, "getAllPushNeedPreRenderVideo return from loadMore backup feed");
            return h16.g();
        }
        return null;
    }

    public void k(final QFSTabFeedViewModel qFSTabFeedViewModel, final QFSFeedVideoErrorEvent qFSFeedVideoErrorEvent) {
        if (qFSTabFeedViewModel == null || qFSFeedVideoErrorEvent == null || qFSFeedVideoErrorEvent.getErrorPresenterInfo() == null || !((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_cache_feed_play_error_remove_logic", true)) {
            return;
        }
        QCircleTabInfo w26 = qFSTabFeedViewModel.w2();
        if (w26 != null && w26.getType() == 6) {
            QLog.d("QCircleFolderClickPreRenderHelper", 1, "[handlerRemovePlayErrorVideo] videoErrorEvent:" + qFSFeedVideoErrorEvent + "\uff0ctabInfo\uff1a" + w26.getType());
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: k30.f
                @Override // java.lang.Runnable
                public final void run() {
                    h.this.l(qFSTabFeedViewModel, qFSFeedVideoErrorEvent);
                }
            });
            return;
        }
        QLog.d("QCircleFolderClickPreRenderHelper", 1, "[handlerRemovePlayErrorVideo] tab not support");
    }

    public void n(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == this.f411494b) {
            QLog.d("QCircleFolderClickPreRenderHelper", 1, "onFeedExpired for diskCache feed");
            this.f411494b = null;
            n.k().f();
        } else if (z20.f.n(feedCloudMeta$StFeed)) {
            QLog.d("QCircleFolderClickPreRenderHelper", 1, "onFeedExpired for loadMore backup feed");
            z20.f.k().p(feedCloudMeta$StFeed);
        }
    }

    public void o(int i3, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed != null && i3 == 6) {
            QLog.d("QCircleFolderClickPreRenderHelper", 1, "setDiskCacheFeedInfo feed id:" + feedCloudMeta$StFeed.f398449id.get());
            this.f411494b = feedCloudMeta$StFeed;
            q(feedCloudMeta$StFeed);
        }
    }

    public void p(e30.b bVar) {
        if (bVar != null && bVar.g() != null) {
            QLog.d("QCircleFolderClickPreRenderHelper", 1, "setLastCanRestorePlayFeed feed id:" + bVar.g().f398449id.get());
        } else {
            QLog.d("QCircleFolderClickPreRenderHelper", 1, "setLastCanRestorePlayFeed null");
        }
        this.f411493a = bVar;
    }

    public void q(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        QLog.d("QCircleFolderClickPreRenderHelper", 1, "triggerPreRenderWhenDiskCacheSet diskFeed\uff1a" + feedCloudMeta$StFeed);
        if (feedCloudMeta$StFeed == null || !((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_can_use_folder_disk_cache_set_pre_render", true)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(feedCloudMeta$StFeed);
        fb0.b.b(arrayList, "cold_boot_disk_cache");
        QCircleColdBootPreloadFeedManagerV2.getInstance().doPreloadImage(feedCloudMeta$StFeed);
        QCircleColdBootPreloadFeedManagerV2.getInstance().doPreloadVideo(feedCloudMeta$StFeed, false);
        QCircleColdBootPreloadFeedManagerV2.getInstance().preInitWillPlayFeed();
    }

    public void r(Activity activity) {
        s();
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_click_render_exp_v2", true)) {
            return;
        }
        FeedCloudMeta$StFeed g16 = g(true);
        if (g16 == null) {
            QLog.d("QCircleFolderClickPreRenderHelper", 1, "triggerVideoPreRender needPreRenderVideo is null");
            return;
        }
        gb0.a.a(g16);
        e30.b bVar = new e30.b(g16);
        RFWStVideo i3 = gb0.b.i(bVar);
        if (i3 == null) {
            QLog.d("QCircleFolderClickPreRenderHelper", 1, "triggerVideoPreRender stVideo is null");
            return;
        }
        if (RFWPlayerReuseUtils.hasReusePlayer(i3.getFileId())) {
            QLog.d("QCircleFolderClickPreRenderHelper", 1, "triggerVideoPreRender needPreRenderVideo has reUsePlayer");
            return;
        }
        RFWPlayerPreRenderHelper.getInstance().playerRender(gb0.b.f(new RFWPlayerPreRenderBean(QCircleHostConstants._SceneID.QQ_CIRCLE_VIDEO(), 10002).setSourceType("bottom_icon_click").setIsJumpTrigger(o.U0()).setPreloadVideo(i3).setPreloadOriginData(gb0.b.m(bVar)).setMultiLevel(true).setActivity(activity)));
        com.tencent.mobileqq.qcircle.api.global.a.i(true);
        QLog.d("QCircleFolderClickPreRenderHelper", 1, "triggerVideoPreRender feedId:" + g16.f398449id.get());
    }
}
