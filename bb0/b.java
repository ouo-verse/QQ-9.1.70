package bb0;

import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants;
import com.tencent.biz.qqcircle.immersive.manager.g;
import com.tencent.biz.qqcircle.launcher.parser.QCircleContentDetailSchemeParser;
import com.tencent.biz.qqcircle.requests.QFSFeedCloudRenderFeedDetailRequest;
import com.tencent.biz.qqcircle.richframework.preload.coldbootV2.QCircleColdBootPreloadFeedManagerV2;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.video.rfw.player.playerprender.RFWPlayerPreRenderBean;
import com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerPreRenderHelper;
import com.tencent.biz.richframework.video.rfw.player.stinfo.RFWStVideo;
import com.tencent.biz.richframework.video.rfw.view.RFWPlayerReuseUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.beans.QCircleSchemeBean;
import cooperation.vip.ad.event.TianshuReceivePushEvent;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StVideoUrl;
import feedcloud.FeedCloudRenderFeedDetail$GetFeedDetailWithExtraDataRsp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import uq3.k;
import uq3.o;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b implements SimpleEventReceiver {

    /* renamed from: i, reason: collision with root package name */
    private static volatile b f28191i;

    /* renamed from: d, reason: collision with root package name */
    private FeedCloudMeta$StFeed f28192d;

    /* renamed from: e, reason: collision with root package name */
    private FeedCloudMeta$StFeed f28193e;

    /* renamed from: f, reason: collision with root package name */
    private String f28194f;

    /* renamed from: h, reason: collision with root package name */
    private final AtomicBoolean f28195h = new AtomicBoolean(false);

    b() {
        this.f28192d = null;
        this.f28193e = null;
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_push_feed_cache", true)) {
            FeedCloudMeta$StFeed p16 = p();
            this.f28193e = p16;
            this.f28192d = p16;
        }
    }

    private String b(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (g.l(str)) {
            return str;
        }
        return g.b(str, "fDd", str2);
    }

    private void c(FeedCloudMeta$StFeed feedCloudMeta$StFeed, String str) {
        if (!TextUtils.isEmpty(str) && feedCloudMeta$StFeed != null) {
            PBStringField pBStringField = feedCloudMeta$StFeed.video.playUrl;
            pBStringField.set(b(pBStringField.get(), str));
            List<FeedCloudMeta$StVideoUrl> list = feedCloudMeta$StFeed.video.vecVideoUrl.get();
            for (int i3 = 0; i3 < list.size(); i3++) {
                PBStringField pBStringField2 = list.get(i3).playUrl;
                pBStringField2.set(b(pBStringField2.get(), str));
            }
        }
    }

    private void f(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == null || !((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_0vv_fluency_exp_push_video_pre_render", true)) {
            return;
        }
        gb0.a.a(feedCloudMeta$StFeed);
        QLog.d("QCirclePushPreloadManager", 1, "triggerVideoPreRender");
        e30.b bVar = new e30.b(feedCloudMeta$StFeed);
        RFWStVideo i3 = gb0.b.i(bVar);
        if (i3 == null) {
            QLog.d("QCirclePushPreloadManager", 1, "triggerVideoPreRender stVideo is null");
        } else if (RFWPlayerReuseUtils.hasReusePlayer(i3.getFileId())) {
            QLog.d("QCirclePushPreloadManager", 1, "triggerVideoPreRender needPreRenderVideo has reUsePlayer");
        } else {
            RFWPlayerPreRenderHelper.getInstance().playerRender(gb0.b.f(new RFWPlayerPreRenderBean(QCircleHostConstants._SceneID.QQ_CIRCLE_VIDEO(), 10002).setSourceType("cold_boot_push").setIsJumpTrigger(o.U0()).setPreloadVideo(i3).setPreloadOriginData(gb0.b.m(bVar)).setMultiLevel(true)));
        }
    }

    public static boolean g() {
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_0vv_fluency_exp_push_video_pre_download_9_0_90", true)) {
            return false;
        }
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_push_force_download_video", false)) {
            return true;
        }
        return com.tencent.mobileqq.qcircle.api.utils.c.i();
    }

    private static String h(HashMap<String, String> hashMap) {
        if (hashMap == null) {
            return null;
        }
        String str = hashMap.get("feedid");
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        return hashMap.get("key_forced_inserted_feed_id");
    }

    public static b i() {
        if (f28191i == null) {
            synchronized (b.class) {
                if (f28191i == null) {
                    f28191i = new b();
                }
            }
        }
        return f28191i;
    }

    private void l(FeedCloudMeta$StFeed feedCloudMeta$StFeed, HashMap<String, String> hashMap) {
        String str;
        if (feedCloudMeta$StFeed == null) {
            return;
        }
        if (hashMap != null) {
            str = hashMap.get("fDd");
        } else {
            str = null;
        }
        RFWLog.d("QCirclePushPreloadManager", RFWLog.USR, "[handlerReceivePushFeed] stFeed :" + feedCloudMeta$StFeed.f398449id.get() + ",hitName:" + str);
        c(feedCloudMeta$StFeed, str);
        this.f28192d = feedCloudMeta$StFeed;
        r(feedCloudMeta$StFeed);
        if (g() || TextUtils.equals(str, "1")) {
            RFWLog.d("QCirclePushPreloadManager", RFWLog.USR, "[handlerReceivePushFeed] real download video");
            ArrayList arrayList = new ArrayList();
            arrayList.add(feedCloudMeta$StFeed);
            fb0.b.b(arrayList, "cold_boot_push");
            QCircleColdBootPreloadFeedManagerV2.getInstance().doPreloadImage(feedCloudMeta$StFeed);
            QCircleColdBootPreloadFeedManagerV2.getInstance().preDownloadVideo(feedCloudMeta$StFeed);
        }
    }

    public static boolean m() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_0vv_fluency_exp_push", true);
    }

    public static boolean n(FeedCloudMeta$StFeed feedCloudMeta$StFeed, HashMap<String, String> hashMap) {
        if (feedCloudMeta$StFeed == null || hashMap == null) {
            return false;
        }
        String h16 = h(hashMap);
        if (TextUtils.isEmpty(h16) || !TextUtils.equals(h16, feedCloudMeta$StFeed.f398449id.get())) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o(HashMap hashMap, BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudRenderFeedDetail$GetFeedDetailWithExtraDataRsp feedCloudRenderFeedDetail$GetFeedDetailWithExtraDataRsp) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        if (z16 && j3 == 0 && (feedCloudMeta$StFeed = feedCloudRenderFeedDetail$GetFeedDetailWithExtraDataRsp.feed_detail) != null) {
            RFWLog.d("QCirclePushPreloadManager", RFWLog.USR, "[dealWithNotificationInfo] stFeed get succeed, traceId\uff1a" + baseRequest.getTraceId());
            l(feedCloudMeta$StFeed, hashMap);
            return;
        }
        RFWLog.e("QCirclePushPreloadManager", RFWLog.USR, "[dealWithNotificationInfo] stFeed get error:" + j3 + ",errMsg:" + str);
    }

    private FeedCloudMeta$StFeed p() {
        try {
            byte[] d16 = k.a().d("sp_key_last_push_feed_info", new byte[0]);
            if (d16 != null && d16.length != 0) {
                FeedCloudMeta$StFeed feedCloudMeta$StFeed = new FeedCloudMeta$StFeed();
                feedCloudMeta$StFeed.mergeFrom(d16);
                QLog.e("QCirclePushPreloadManager", 1, "loadLastPushFeed is :" + feedCloudMeta$StFeed.f398449id.get());
                return feedCloudMeta$StFeed;
            }
            QLog.e("QCirclePushPreloadManager", 1, "loadLastPushFeed is null");
            return null;
        } catch (Exception e16) {
            QLog.e("QCirclePushPreloadManager", 1, "loadLastPushFeed error:" + e16);
            return null;
        }
    }

    private void r(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == null) {
            return;
        }
        try {
            this.f28193e = feedCloudMeta$StFeed;
            k.a().k("sp_key_last_push_feed_info", feedCloudMeta$StFeed.toByteArray());
            RFWLog.d("QCirclePushPreloadManager", RFWLog.USR, "[savePushCache] :" + feedCloudMeta$StFeed.f398449id.get());
        } catch (Exception e16) {
            RFWLog.e("QCirclePushPreloadManager", RFWLog.USR, "[savePushCache] :" + e16);
        }
    }

    private void t() {
        if (this.f28193e != null) {
            this.f28193e = null;
            RFWLog.d("QCirclePushPreloadManager", RFWLog.USR, "[clearPushCache]");
            k.a().k("sp_key_last_push_feed_info", null);
        }
    }

    public void d(String str, String str2) {
        if (!m()) {
            return;
        }
        RFWLog.d("QCirclePushPreloadManager", RFWLog.USR, "[dealWithNotificationInfo] jumpUrl:" + str + ",pushID:" + str2);
        final HashMap<String, String> c16 = com.tencent.biz.qqcircle.d.c(str);
        FeedCloudMeta$StFeed p16 = QCircleContentDetailSchemeParser.p(c16);
        if (p16 != null) {
            RFWLog.d("QCirclePushPreloadManager", RFWLog.USR, "[dealWithNotificationInfo] stFeed is not null," + p16.f398449id.get());
            l(p16, c16);
            return;
        }
        String h16 = h(c16);
        if (TextUtils.isEmpty(h16)) {
            RFWLog.e("QCirclePushPreloadManager", RFWLog.USR, "[dealWithNotificationInfo] feedId is null");
        } else {
            VSNetworkHelper.getInstance().sendRequest(new QFSFeedCloudRenderFeedDetailRequest(h16, str, 1, true), new VSDispatchObserver.OnVSRspCallBack() { // from class: bb0.a
                @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
                public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str3, Object obj) {
                    b.this.o(c16, baseRequest, z16, j3, str3, (FeedCloudRenderFeedDetail$GetFeedDetailWithExtraDataRsp) obj);
                }
            });
        }
    }

    public void e(QCircleSchemeBean qCircleSchemeBean) {
        if (m() && qCircleSchemeBean != null && qCircleSchemeBean.getAttrs() != null) {
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f28192d;
            String h16 = h(qCircleSchemeBean.getAttrs());
            if (feedCloudMeta$StFeed != null && !TextUtils.isEmpty(h16) && TextUtils.equals(feedCloudMeta$StFeed.f398449id.get(), h16)) {
                RFWLog.d("QCirclePushPreloadManager", RFWLog.USR, "[dealWithVideoScreenSchema] is push feed:" + h16);
                f(feedCloudMeta$StFeed);
                this.f28194f = h16;
            }
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(TianshuReceivePushEvent.class);
        return arrayList;
    }

    public String j() {
        return this.f28194f;
    }

    public FeedCloudMeta$StFeed k(boolean z16) {
        if (!m()) {
            return null;
        }
        RFWLog.d("QCirclePushPreloadManager", RFWLog.USR, "[getWaitConsumePushFeed] mWaitConsumePushFeed is " + this.f28192d + ",needConsume:" + z16);
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f28192d;
        if (z16) {
            t();
            this.f28192d = null;
        }
        return feedCloudMeta$StFeed;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof TianshuReceivePushEvent) {
            TianshuReceivePushEvent tianshuReceivePushEvent = (TianshuReceivePushEvent) simpleBaseEvent;
            RFWLog.d("QCirclePushPreloadManager", RFWLog.USR, "[onReceiveTianshuPush] tianshuPushEvent is " + tianshuReceivePushEvent.getPushId() + ",schema:" + tianshuReceivePushEvent.getJumpScheme());
            d(tianshuReceivePushEvent.getJumpScheme(), String.valueOf(tianshuReceivePushEvent.getPushId()));
        }
    }

    public void q() {
        if (this.f28195h.compareAndSet(false, true)) {
            try {
                RFWLog.d("QCirclePushPreloadManager", RFWLog.USR, "[registerTianshuPushListener]");
                SimpleEventBus.getInstance().registerReceiver(this);
            } catch (Exception e16) {
                RFWLog.e("QCirclePushPreloadManager", RFWLog.USR, "[registerTianshuPushListener] error\uff1a" + e16);
            }
        }
    }

    public void s() {
    }
}
