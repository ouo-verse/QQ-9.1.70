package bb0;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.biz.qcircleshadow.lib.QCircleHostRedPointHelper;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.broadcast.action.QCircleClearRedPointAction;
import com.tencent.biz.qqcircle.requests.QFSFeedCloudRenderFeedDetailRequest;
import com.tencent.biz.qqcircle.richframework.preload.coldbootV2.QCircleColdBootPreloadFeedManagerV2;
import com.tencent.biz.qqcircle.utils.ci;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qcircle.api.coldboot.IPreloadTask;
import com.tencent.mobileqq.qcircle.api.event.QCircleRedInfoEvent;
import com.tencent.mobileqq.qcircle.api.impl.QCircleServiceImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IRedPointUIManager;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.observer.RedpointObserver;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StPrePullCacheFeed;
import feedcloud.FeedCloudRead$StGetFeedListRsp;
import feedcloud.FeedCloudRenderFeedDetail$GetFeedDetailWithExtraDataRsp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import qqcircle.QQCircleFeedBase$PrePullRspFeedsOpActionDesc;
import trpc.tianshu.RedPointTransInfo;

/* compiled from: P */
/* loaded from: classes5.dex */
public class e extends RedpointObserver {

    /* renamed from: h, reason: collision with root package name */
    private static volatile e f28206h;

    /* renamed from: d, reason: collision with root package name */
    private final AtomicBoolean f28207d = new AtomicBoolean(false);

    /* renamed from: e, reason: collision with root package name */
    private final Map<String, BusinessInfoCheckUpdate.AppInfo> f28208e = new ConcurrentHashMap();

    /* renamed from: f, reason: collision with root package name */
    private final List<String> f28209f = new CopyOnWriteArrayList();

    private void d() {
        FeedCloudMeta$StFeed preloadFeed;
        IPreloadTask task = QCircleColdBootPreloadFeedManagerV2.getInstance().getTask(10000);
        if (task != null && (preloadFeed = task.getPreloadFeed()) != null) {
            QLog.d("QFSRedPoint_QFSRedpointDelayObserver", 1, "clearRedPointPreloadFeed :" + preloadFeed.f398449id.get());
            QQCircleFeedBase$PrePullRspFeedsOpActionDesc qQCircleFeedBase$PrePullRspFeedsOpActionDesc = new QQCircleFeedBase$PrePullRspFeedsOpActionDesc();
            qQCircleFeedBase$PrePullRspFeedsOpActionDesc.opActionDesc.set(2);
            FeedCloudMeta$StPrePullCacheFeed feedCloudMeta$StPrePullCacheFeed = new FeedCloudMeta$StPrePullCacheFeed();
            feedCloudMeta$StPrePullCacheFeed.f398456id.set(preloadFeed.f398449id.get());
            qQCircleFeedBase$PrePullRspFeedsOpActionDesc.feeds.add(feedCloudMeta$StPrePullCacheFeed);
            task.handlePreloadRsp(e(null), qQCircleFeedBase$PrePullRspFeedsOpActionDesc);
        }
    }

    private FeedCloudRead$StGetFeedListRsp e(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp = new FeedCloudRead$StGetFeedListRsp();
        ArrayList arrayList = new ArrayList();
        if (feedCloudMeta$StFeed != null) {
            arrayList.add(feedCloudMeta$StFeed);
        }
        feedCloudRead$StGetFeedListRsp.vecFeed.set(arrayList);
        return feedCloudRead$StGetFeedListRsp;
    }

    public static e f() {
        if (f28206h == null) {
            synchronized (e.class) {
                if (f28206h == null) {
                    f28206h = new e();
                }
            }
        }
        return f28206h;
    }

    private BusinessInfoCheckUpdate.AppInfo g(com.tencent.mobileqq.tianshu.observer.b bVar) {
        if (bVar == null) {
            return null;
        }
        BusinessInfoCheckUpdate.AppInfo c16 = bVar.c();
        if (c16 != null && !c16.busi_data.get().isEmpty()) {
            return c16;
        }
        BusinessInfoCheckUpdate.AppInfo b16 = bVar.b();
        if (b16 == null || b16.busi_data.get().isEmpty()) {
            return null;
        }
        return b16;
    }

    private RedPointTransInfo h(BusinessInfoCheckUpdate.AppInfo appInfo) {
        if (appInfo == null) {
            return null;
        }
        try {
            return RedPointTransInfo.ADAPTER.decode(appInfo.busi_data.get().toByteArray());
        } catch (Exception e16) {
            RFWLog.e("QFSRedPoint_QFSRedpointDelayObserver", RFWLog.USR, "[getRedPointTransInfo] pb error:" + e16);
            return null;
        }
    }

    private boolean i(BusinessInfoCheckUpdate.AppInfo appInfo, RedPointTransInfo redPointTransInfo) {
        IPreloadTask task;
        FeedCloudMeta$StFeed preloadFeed;
        if (appInfo == null || redPointTransInfo == null || (task = QCircleColdBootPreloadFeedManagerV2.getInstance().getTask(10000)) == null || (preloadFeed = task.getPreloadFeed()) == null) {
            return false;
        }
        String str = preloadFeed.f398449id.get();
        if (TextUtils.isEmpty(str) || !TextUtils.equals(str, redPointTransInfo.feedID)) {
            return false;
        }
        return true;
    }

    private boolean j(BusinessInfoCheckUpdate.AppInfo appInfo) {
        if (appInfo == null) {
            return false;
        }
        BusinessInfoCheckUpdate.AppInfo appInfo2 = this.f28208e.get(appInfo.path.get());
        if (appInfo2 == null) {
            return false;
        }
        return com.tencent.mobileqq.tianshu.ui.a.f(appInfo2, appInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(String str, Runnable runnable, RedPointTransInfo redPointTransInfo, IPreloadTask iPreloadTask, BaseRequest baseRequest, boolean z16, long j3, String str2, FeedCloudRenderFeedDetail$GetFeedDetailWithExtraDataRsp feedCloudRenderFeedDetail$GetFeedDetailWithExtraDataRsp) {
        if (z16 && j3 == 0 && feedCloudRenderFeedDetail$GetFeedDetailWithExtraDataRsp.feed_detail != null) {
            RFWLog.d("QFSRedPoint_QFSRedpointDelayObserver", RFWLog.USR, "[preloadRedPointFeed] stFeed get succeed, traceId\uff1a" + baseRequest.getTraceId() + ",feedId:" + str);
            runnable.run();
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = feedCloudRenderFeedDetail$GetFeedDetailWithExtraDataRsp.feed_detail;
            ci.a(feedCloudMeta$StFeed, redPointTransInfo);
            QQCircleFeedBase$PrePullRspFeedsOpActionDesc qQCircleFeedBase$PrePullRspFeedsOpActionDesc = new QQCircleFeedBase$PrePullRspFeedsOpActionDesc();
            qQCircleFeedBase$PrePullRspFeedsOpActionDesc.opActionDesc.set(1);
            iPreloadTask.handlePreloadRsp(e(feedCloudMeta$StFeed), qQCircleFeedBase$PrePullRspFeedsOpActionDesc);
        } else {
            runnable.run();
            RFWLog.e("QFSRedPoint_QFSRedpointDelayObserver", RFWLog.USR, "[preloadRedPointFeed] stFeed get error:" + j3 + ",errMsg:" + str2 + ",feedId:" + str);
        }
        this.f28209f.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(BusinessInfoCheckUpdate.AppInfo appInfo, RedPointTransInfo redPointTransInfo, com.tencent.mobileqq.tianshu.observer.b bVar, com.tencent.mobileqq.tianshu.observer.c cVar) {
        QCircleHostRedPointHelper.saveTianshuOuterEntranceRedPointInfo(appInfo, redPointTransInfo);
        if (appInfo != null) {
            if (!j(appInfo)) {
                SimpleEventBus.getInstance().dispatchEvent(new QCircleRedInfoEvent("QFSRedpointDelayObserver new RedPoint", false));
            }
            this.f28208e.put(appInfo.path.get(), appInfo);
        }
        bVar.h("show");
        Function1<com.tencent.mobileqq.tianshu.observer.b, Unit> d16 = cVar.d();
        if (d16 != null) {
            d16.invoke(bVar);
        }
    }

    private void m(BusinessInfoCheckUpdate.AppInfo appInfo, final RedPointTransInfo redPointTransInfo, @NonNull final Runnable runnable) {
        if (appInfo != null && redPointTransInfo != null && !TextUtils.isEmpty(redPointTransInfo.feedID)) {
            final String str = redPointTransInfo.feedID;
            if (this.f28209f.contains(str)) {
                RFWLog.e("QFSRedPoint_QFSRedpointDelayObserver", RFWLog.DEV, "[preloadRedPointFeed] feed is request ing");
                runnable.run();
                return;
            }
            final IPreloadTask task = QCircleColdBootPreloadFeedManagerV2.getInstance().getTask(10000);
            if (task == null) {
                RFWLog.e("QFSRedPoint_QFSRedpointDelayObserver", RFWLog.USR, "[preloadRedPointFeed] preload task is null");
                runnable.run();
                return;
            }
            FeedCloudMeta$StFeed preloadFeed = task.getPreloadFeed();
            if (preloadFeed != null && TextUtils.equals(preloadFeed.f398449id.get(), str)) {
                RFWLog.d("QFSRedPoint_QFSRedpointDelayObserver", RFWLog.USR, "[preloadRedPointFeed] feed have preload:" + str);
                runnable.run();
                return;
            }
            this.f28209f.add(str);
            QFSFeedCloudRenderFeedDetailRequest qFSFeedCloudRenderFeedDetailRequest = new QFSFeedCloudRenderFeedDetailRequest(str, "", 2, false);
            qFSFeedCloudRenderFeedDetailRequest.setAllPushTransInfo(redPointTransInfo);
            VSNetworkHelper.getInstance().sendRequest(qFSFeedCloudRenderFeedDetailRequest, new VSDispatchObserver.OnVSRspCallBack() { // from class: bb0.d
                @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
                public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str2, Object obj) {
                    e.this.k(str, runnable, redPointTransInfo, task, baseRequest, z16, j3, str2, (FeedCloudRenderFeedDetail$GetFeedDetailWithExtraDataRsp) obj);
                }
            });
            return;
        }
        runnable.run();
    }

    private void n(@NonNull final com.tencent.mobileqq.tianshu.observer.b bVar, @NonNull final com.tencent.mobileqq.tianshu.observer.c cVar) {
        String str;
        final BusinessInfoCheckUpdate.AppInfo g16 = g(bVar);
        final RedPointTransInfo h16 = h(g16);
        int i3 = RFWLog.USR;
        Object[] objArr = new Object[1];
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[realDoPreload] needPreload feedId:");
        if (h16 != null) {
            str = h16.feedID;
        } else {
            str = null;
        }
        sb5.append(str);
        objArr[0] = sb5.toString();
        RFWLog.d("QFSRedPoint_QFSRedpointDelayObserver", i3, objArr);
        Runnable runnable = new Runnable() { // from class: bb0.c
            @Override // java.lang.Runnable
            public final void run() {
                e.this.l(g16, h16, bVar, cVar);
            }
        };
        if (g16 == null) {
            RFWLog.d("QFSRedPoint_QFSRedpointDelayObserver", RFWLog.DEV, "[realDoPreload] not needPreload");
            runnable.run();
            return;
        }
        boolean j3 = j(g16);
        boolean i16 = i(g16, h16);
        if (j3 && i16) {
            RFWLog.d("QFSRedPoint_QFSRedpointDelayObserver", RFWLog.DEV, "[realDoPreload] is same redPoint and preload succeed");
            runnable.run();
        } else {
            m(g16, h16, runnable);
        }
    }

    private void p() {
        BusinessInfoCheckUpdate.AppInfo appInfo;
        if (!((IRedPointUIManager) QRoute.api(IRedPointUIManager.class)).isSwitchOn()) {
            return;
        }
        if (QCirclePluginGlobalInfo.J()) {
            QLog.e("QFSRedPoint_QFSRedpointDelayObserver", 1, "updateRedPoint but on qcircle");
            return;
        }
        AppRuntime appRunTime = QCircleServiceImpl.getAppRunTime();
        if (appRunTime == null) {
            QLog.e("QFSRedPoint_QFSRedpointDelayObserver", 1, "updateRedPoint appRunTime isnull");
            return;
        }
        IRedTouchManager iRedTouchManager = (IRedTouchManager) appRunTime.getRuntimeService(IRedTouchManager.class, "");
        if (iRedTouchManager == null) {
            QLog.e("QFSRedPoint_QFSRedpointDelayObserver", 1, "updateRedPoint redTouchManager isnull");
            return;
        }
        Iterator<String> it = ci.f92747a.iterator();
        while (true) {
            if (it.hasNext()) {
                String next = it.next();
                appInfo = iRedTouchManager.getAppInfoByPath(QCircleClearRedPointAction.c(next));
                if (ci.b(appInfo)) {
                    break;
                }
                appInfo = iRedTouchManager.getAppInfoByPath(next);
                if (ci.b(appInfo)) {
                    break;
                }
            } else {
                appInfo = null;
                break;
            }
        }
        if (appInfo == null) {
            QLog.d("QFSRedPoint_QFSRedpointDelayObserver", 1, "updateRedPoint real clear redPoint");
            QCircleHostRedPointHelper.saveTianshuOuterEntranceRedPointInfo(null, null);
            d();
            this.f28208e.clear();
        }
    }

    public void c() {
        if (this.f28207d.compareAndSet(false, true)) {
            QLog.d("QFSRedPoint_QFSRedpointDelayObserver", 1, "[addRedPointObserver] useNewSwitch:" + ((IRedPointUIManager) QRoute.api(IRedPointUIManager.class)).isSwitchOn());
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (!(peekAppRuntime instanceof AppInterface)) {
                QLog.e("QFSRedPoint_QFSRedpointDelayObserver", 1, "[addRedPointObserver] failed");
            } else {
                ((AppInterface) peekAppRuntime).addObserver(f());
            }
        }
    }

    public void o() {
        QLog.d("QFSRedPoint_QFSRedpointDelayObserver", 1, "[removeRedPointObserver]");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!(peekAppRuntime instanceof AppInterface)) {
            QLog.e("QFSRedPoint_QFSRedpointDelayObserver", 1, "[removeRedPointObserver] failed");
        } else {
            ((AppInterface) peekAppRuntime).removeObserver(f());
            this.f28207d.set(false);
        }
    }

    @Override // com.tencent.mobileqq.tianshu.observer.RedpointObserver
    public void onDataChange(boolean z16) {
        super.onDataChange(z16);
        if (z16) {
            p();
        }
    }

    @Override // com.tencent.mobileqq.tianshu.observer.RedpointObserver, com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        super.onUpdate(i3, z16, obj);
        if (i3 == 1 && (obj instanceof com.tencent.mobileqq.tianshu.observer.c)) {
            com.tencent.mobileqq.tianshu.observer.c cVar = (com.tencent.mobileqq.tianshu.observer.c) obj;
            com.tencent.mobileqq.tianshu.observer.b c16 = cVar.c();
            if (!zd2.a.a(c16)) {
                return;
            }
            n(c16, cVar);
        }
    }
}
