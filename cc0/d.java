package cc0;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.immersive.repository.foldertab.l;
import com.tencent.biz.qqcircle.immersive.utils.y;
import com.tencent.biz.qqcircle.rerank.request.QFSRankEdgeGetFeedsReq;
import com.tencent.biz.qqcircle.rerank.util.QFSRankEdgeReportHelper;
import com.tencent.biz.qqcircle.tedgers2.bean.QFSEdgeAction;
import com.tencent.biz.qqcircle.tedgers2.bean.QFSEdgeItem;
import com.tencent.biz.qqcircle.tedgers2.bean.QFSEdgeUser;
import com.tencent.biz.qqcircle.tedgers2.bean.pb.TEdgeAction$Action;
import com.tencent.biz.qqcircle.tedgers2.bean.pb.TEdgeUser$User;
import com.tencent.biz.qqcircle.tedgers2.bean.pb.TEdgeUserProfile$UserProfile;
import com.tencent.biz.qqcircle.tedgers2.behavior.QFSEdgeBasedAction;
import com.tencent.biz.qqcircle.tedgers2.behavior.a;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.tedger.outapi.api.IInitStateManager;
import com.tencent.tedger.outapi.api.ITEdgeRSServer;
import com.tencent.tedger.outapi.beans.EdgeStatus;
import com.tencent.tedger.outapi.delegate.ITEdgeRSSDKComponentDelegate;
import com.tencent.tedger.outapi.proto.TEdgeCommon$MapEntry;
import com.tencent.tedger.outapi.proto.TEdgeEvent$Event;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qzone.remote.ServiceConst;
import feedcloud.FeedCloudRead$StGetCloudSealFeedRsp;
import hc0.n;
import hc0.o;
import hc0.r;
import hc0.s;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class d implements a.b {

    /* renamed from: r, reason: collision with root package name */
    private static WeakReference<d> f30604r;

    /* renamed from: s, reason: collision with root package name */
    private static WeakReference<ITEdgeRSServer> f30605s;

    /* renamed from: a, reason: collision with root package name */
    private ITEdgeRSServer f30606a;

    /* renamed from: b, reason: collision with root package name */
    private o f30607b;

    /* renamed from: c, reason: collision with root package name */
    private hc0.f f30608c;

    /* renamed from: d, reason: collision with root package name */
    private s f30609d;

    /* renamed from: e, reason: collision with root package name */
    private n f30610e;

    /* renamed from: f, reason: collision with root package name */
    private hc0.e f30611f;

    /* renamed from: g, reason: collision with root package name */
    private final r f30612g;

    /* renamed from: h, reason: collision with root package name */
    private int f30613h;

    /* renamed from: i, reason: collision with root package name */
    private int f30614i;

    /* renamed from: j, reason: collision with root package name */
    private int f30615j;

    /* renamed from: l, reason: collision with root package name */
    private TEdgeUserProfile$UserProfile f30617l;

    /* renamed from: m, reason: collision with root package name */
    private String f30618m;

    /* renamed from: n, reason: collision with root package name */
    private FeedCloudRead$StGetCloudSealFeedRsp f30619n;

    /* renamed from: p, reason: collision with root package name */
    private final com.tencent.tedger.outapi.delegate.f f30621p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f30622q;

    /* renamed from: k, reason: collision with root package name */
    private boolean f30616k = false;

    /* renamed from: o, reason: collision with root package name */
    private final Runnable f30620o = new Runnable() { // from class: cc0.a
        @Override // java.lang.Runnable
        public final void run() {
            d.this.C();
        }
    };

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a implements com.tencent.tedger.outapi.delegate.f {
        a() {
        }

        @Override // com.tencent.tedger.outapi.delegate.f
        @NonNull
        @NotNull
        public com.tencent.tedger.outapi.delegate.a a() {
            return d.this.v();
        }

        @Override // com.tencent.tedger.outapi.delegate.f
        @NonNull
        @NotNull
        public com.tencent.tedger.outapi.delegate.c b() {
            return d.this.x();
        }

        @Override // com.tencent.tedger.outapi.delegate.f
        @NonNull
        @NotNull
        public ITEdgeRSSDKComponentDelegate c() {
            return d.this.u();
        }

        @Override // com.tencent.tedger.outapi.delegate.f
        @NonNull
        @NotNull
        public com.tencent.tedger.outapi.delegate.d d() {
            return d.this.f30612g;
        }

        @Override // com.tencent.tedger.outapi.delegate.f
        @NonNull
        @NotNull
        public com.tencent.tedger.outapi.delegate.b e() {
            return d.this.w();
        }

        @Override // com.tencent.tedger.outapi.delegate.f
        @Nullable
        @org.jetbrains.annotations.Nullable
        public com.tencent.tedger.outapi.delegate.e getLogDelegate() {
            return d.this.y();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class b implements IInitStateManager.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FeedCloudRead$StGetCloudSealFeedRsp f30624a;

        b(FeedCloudRead$StGetCloudSealFeedRsp feedCloudRead$StGetCloudSealFeedRsp) {
            this.f30624a = feedCloudRead$StGetCloudSealFeedRsp;
        }

        @Override // com.tencent.tedger.outapi.api.IInitStateManager.a
        public void a(IInitStateManager.TEdgeRSInitStep tEdgeRSInitStep, IInitStateManager.a.InterfaceC9900a interfaceC9900a) {
            if (tEdgeRSInitStep == IInitStateManager.TEdgeRSInitStep.End) {
                d.this.m(this.f30624a);
            }
        }

        @Override // com.tencent.tedger.outapi.api.IInitStateManager.a
        public boolean b(IInitStateManager.TEdgeRSInitStep tEdgeRSInitStep, int i3) {
            return false;
        }
    }

    public d() {
        a aVar = new a();
        this.f30621p = aVar;
        this.f30622q = false;
        f30604r = new WeakReference<>(this);
        this.f30612g = new r(aVar);
        QLog.d("TEDGEQFS_EdgeRSManagerV2", 1, "QFSEdgeRerankManager init");
        String a16 = ic0.a.a();
        if (!TextUtils.isEmpty(a16)) {
            J(a16);
        } else {
            QLog.e("TEDGEQFS_EdgeRSManagerV2", 1, "QFSEdgeRerankManager globalConfig is null");
        }
    }

    private boolean A() {
        return false;
    }

    private boolean B() {
        boolean h16 = com.tencent.biz.qqcircle.richframework.video.player.playinterceptor.g.h();
        if (A()) {
            QFSRankEdgeReportHelper.g(new QFSRankEdgeReportHelper.a().n("tedgeRSV2_high_drop_frame").l(com.tencent.biz.qqcircle.richframework.video.player.playinterceptor.g.f92027d + ""));
        }
        if (h16) {
            QLog.e("TEDGEQFS_EdgeRSManagerV2", 1, "onNewAction isHighDropFrame");
            return false;
        }
        boolean g16 = com.tencent.biz.qqcircle.richframework.video.player.playinterceptor.g.g();
        if (A()) {
            QFSRankEdgeReportHelper.g(new QFSRankEdgeReportHelper.a().n("tedgeRSV2_high_cpu_usage").l(g16 + ""));
        }
        if (!g16) {
            return true;
        }
        com.tencent.biz.qqcircle.richframework.video.player.playinterceptor.g.f();
        QLog.e("TEDGEQFS_EdgeRSManagerV2", 1, "onNewAction highCpuUsageStatus");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C() {
        QLog.d("TEDGEQFS_EdgeRSManagerV2", 1, " reloadSdkManagerIfNeed runnable call");
        I(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void D() {
        try {
            System.gc();
        } catch (Throwable th5) {
            QLog.e("TEDGEQFS_EdgeRSManagerV2", 1, "[releaseRerankManager] gc error:" + th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E(QFSRankEdgeGetFeedsReq qFSRankEdgeGetFeedsReq, String str, BaseRequest baseRequest, boolean z16, long j3, String str2, FeedCloudRead$StGetCloudSealFeedRsp feedCloudRead$StGetCloudSealFeedRsp) {
        QLog.d("TEDGEQFS_EdgeRSManagerV2", 1, "getUserDetail onReceive: dispatch result:" + z16 + " | TraceId:" + qFSRankEdgeGetFeedsReq.getTraceId() + " | SeqId:" + qFSRankEdgeGetFeedsReq.getCurrentSeq() + " | retCode:" + j3 + " | retMessage:" + str2);
        this.f30618m = str;
        this.f30619n = feedCloudRead$StGetCloudSealFeedRsp;
        s(str, feedCloudRead$StGetCloudSealFeedRsp);
    }

    private void H() {
        QLog.d("TEDGEQFS_EdgeRSManagerV2", 1, "[releaseRerankManager]");
        RFWThreadManager.getUIHandler().removeCallbacks(this.f30620o);
        ITEdgeRSServer iTEdgeRSServer = this.f30606a;
        if (iTEdgeRSServer != null) {
            iTEdgeRSServer.onDestroy();
            this.f30606a = null;
            RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: cc0.b
                @Override // java.lang.Runnable
                public final void run() {
                    d.D();
                }
            });
            com.tencent.biz.qqcircle.richframework.video.player.playinterceptor.g.k();
        }
    }

    private synchronized void I(boolean z16) {
        RFWThreadManager.getUIHandler().removeCallbacks(this.f30620o);
        if (o()) {
            QLog.e("TEDGEQFS_EdgeRSManagerV2", 1, "[reloadSdkManagerIfNeed] have sdk instance;needErrorRetry:" + z16);
            if (z16) {
                RFWThreadManager.getUIHandler().postDelayed(this.f30620o, 8000L);
            }
            return;
        }
        String str = this.f30618m;
        FeedCloudRead$StGetCloudSealFeedRsp feedCloudRead$StGetCloudSealFeedRsp = this.f30619n;
        QLog.d("TEDGEQFS_EdgeRSManagerV2", 1, "[reloadSdkManagerIfNeed] globalConfig:" + str + ",userInfoRsp:" + feedCloudRead$StGetCloudSealFeedRsp);
        if (!TextUtils.isEmpty(str) && feedCloudRead$StGetCloudSealFeedRsp != null) {
            s(str, feedCloudRead$StGetCloudSealFeedRsp);
        }
    }

    private void J(final String str) {
        final QFSRankEdgeGetFeedsReq qFSRankEdgeGetFeedsReq = new QFSRankEdgeGetFeedsReq(true);
        VSNetworkHelper.getInstance().sendRequest(qFSRankEdgeGetFeedsReq, new VSDispatchObserver.OnVSRspCallBack() { // from class: cc0.c
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str2, Object obj) {
                d.this.E(qFSRankEdgeGetFeedsReq, str, baseRequest, z16, j3, str2, (FeedCloudRead$StGetCloudSealFeedRsp) obj);
            }
        });
    }

    private void M(TEdgeUserProfile$UserProfile tEdgeUserProfile$UserProfile) {
        QLog.d("TEDGEQFS_EdgeRSManagerV2", 1, "updateUserProfileInfo userProfile :" + tEdgeUserProfile$UserProfile);
        ITEdgeRSServer iTEdgeRSServer = this.f30606a;
        if (iTEdgeRSServer == null) {
            QLog.e("TEDGEQFS_EdgeRSManagerV2", 1, "updateUserProfileInfo manager == null");
            return;
        }
        String str = HostDataTransUtils.getLongAccountUin() + "";
        TEdgeUser$User tEdgeUser$User = new TEdgeUser$User();
        tEdgeUser$User.user_id.set(str);
        ArrayList arrayList = new ArrayList();
        arrayList.add(ic0.b.d(ServiceConst.PARA_SESSION_ID, QCircleNativeSessionManager.g().getSession()));
        arrayList.add(ic0.b.d("last_ad_timestamp", e.f30627b + ""));
        arrayList.add(ic0.b.d("last_ad_index", e.f30628c + ""));
        arrayList.add(ic0.b.d("last_feed_index", (this.f30613h - 1) + ""));
        arrayList.add(ic0.b.d("last_expose_feed_index", this.f30614i + ""));
        arrayList.add(ic0.b.d("last_cache_ad_index", this.f30615j + ""));
        if (tEdgeUserProfile$UserProfile == null) {
            tEdgeUserProfile$UserProfile = new TEdgeUserProfile$UserProfile();
        }
        tEdgeUser$User.profile.set(tEdgeUserProfile$UserProfile);
        tEdgeUser$User.context.set(arrayList);
        iTEdgeRSServer.updateUserBaseInfo(new QFSEdgeUser(tEdgeUser$User), new EdgeStatus());
    }

    private QFSEdgeAction l(@NonNull a.C0931a c0931a, @NonNull e30.b bVar) {
        int a16 = QFSEdgeBasedAction.a(c0931a.a());
        QFSEdgeItem qFSEdgeItem = new QFSEdgeItem(bVar, 0);
        TEdgeAction$Action tEdgeAction$Action = new TEdgeAction$Action();
        tEdgeAction$Action.item.set(qFSEdgeItem.getItemInfo());
        tEdgeAction$Action.item_id.set(bVar.g().f398449id.get());
        TEdgeEvent$Event tEdgeEvent$Event = new TEdgeEvent$Event();
        tEdgeEvent$Event.item_id.set(qFSEdgeItem.getItemID());
        tEdgeEvent$Event.type.set(a16);
        PBRepeatMessageField<TEdgeCommon$MapEntry> pBRepeatMessageField = tEdgeEvent$Event.properties;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(c0931a.i());
        String str = "";
        sb5.append("");
        pBRepeatMessageField.add(ic0.b.d(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_END_PLAY_TIME, sb5.toString()));
        tEdgeEvent$Event.properties.add(ic0.b.d("video_time", c0931a.j() + ""));
        tEdgeEvent$Event.properties.add(ic0.b.d("session_index", c0931a.e() + ""));
        String reqId = qFSEdgeItem.getReqId();
        if (reqId != null) {
            str = reqId;
        }
        tEdgeEvent$Event.req_id.set(str);
        tEdgeEvent$Event.timestamp.set(System.currentTimeMillis());
        tEdgeAction$Action.events.add(tEdgeEvent$Event);
        int a17 = c0931a.a();
        int f16 = c0931a.f();
        long j3 = e.f30630e;
        QLog.d("TEDGEQFS_EdgeRSManagerV2", 1, "[convertToEdgeAction] Collected ActionType: " + a17 + ",SubActionType: " + f16 + ",convertType: " + a16 + ",reqId\uff1a" + bVar.f() + ",pageRefreshToken\uff1a" + j3 + ",feedId\uff1a" + bVar.g().f398449id.get());
        QFSEdgeAction qFSEdgeAction = new QFSEdgeAction(tEdgeAction$Action);
        qFSEdgeAction.pageRefreshToken = j3;
        return qFSEdgeAction;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(FeedCloudRead$StGetCloudSealFeedRsp feedCloudRead$StGetCloudSealFeedRsp) {
        ITEdgeRSServer iTEdgeRSServer = this.f30606a;
        QLog.d("TEDGEQFS_EdgeRSManagerV2", 1, "[dealWithSdkInitSucceed] edgeRSServer:" + iTEdgeRSServer);
        if (iTEdgeRSServer == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(iTEdgeRSServer.getConfigManager().z());
            r(jSONObject);
            if (iTEdgeRSServer.getConfigManager().s()) {
                if (iTEdgeRSServer.getConfigManager().a()) {
                    boolean e16 = iTEdgeRSServer.getConfigManager().e();
                    QLog.e("TEDGEQFS_EdgeRSManagerV2", 1, "[dealWithSdkInitSucceed] is low device,openLowPerformancePolicy:" + e16);
                    if (e16) {
                        q(jSONObject);
                    }
                } else {
                    QLog.e("TEDGEQFS_EdgeRSManagerV2", 1, "[dealWithSdkInitSucceed] device is high device");
                    this.f30612g.i(jSONObject);
                    q(jSONObject);
                }
            }
            t(feedCloudRead$StGetCloudSealFeedRsp);
        } catch (Exception e17) {
            QLog.e("TEDGEQFS_EdgeRSManagerV2", 1, "[dealWithSdkInitSucceed] init error:" + e17);
        }
    }

    public static boolean n() {
        WeakReference<d> weakReference = f30604r;
        if (weakReference != null && weakReference.get() != null) {
            return true;
        }
        return false;
    }

    public static boolean o() {
        WeakReference<ITEdgeRSServer> weakReference = f30605s;
        if (weakReference != null && weakReference.get() != null) {
            return true;
        }
        return false;
    }

    private void q(JSONObject jSONObject) {
        boolean z16;
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("sdk");
            if (jSONObject2.has("pull_ads_up")) {
                z16 = jSONObject2.getBoolean("pull_ads_up");
            } else {
                z16 = false;
            }
            bc0.a.g().k(z16);
            QLog.d("TEDGEQFS_EdgeRSManagerV2", 1, "initAdLoadConfigs enablePullAdBackUp:" + z16);
        } catch (Exception e16) {
            QLog.e("TEDGEQFS_EdgeRSManagerV2", 1, "initAdLoadConfigs parse failed,e:" + e16);
        }
    }

    private void r(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("sdk");
            if (jSONObject2.has("isInsertJustNext")) {
                this.f30616k = jSONObject2.getBoolean("isInsertJustNext");
            }
            QLog.d("TEDGEQFS_EdgeRSManagerV2", 1, "initGlobalConfigs mIsInsertJustNext:" + this.f30616k);
        } catch (Exception e16) {
            QLog.e("TEDGEQFS_EdgeRSManagerV2", 1, "initGlobalConfigs parse failed,e:" + e16);
        }
    }

    private void s(String str, FeedCloudRead$StGetCloudSealFeedRsp feedCloudRead$StGetCloudSealFeedRsp) {
        if (this.f30622q) {
            QLog.e("TEDGEQFS_EdgeRSManagerV2", 1, "initRerank but is is destroyed");
            return;
        }
        QLog.d("TEDGEQFS_EdgeRSManagerV2", 1, "initRerank globalConfig:" + str);
        ITEdgeRSServer.a aVar = new ITEdgeRSServer.a();
        String str2 = HostDataTransUtils.getLongAccountUin() + "";
        aVar.f375265a = QQHealthReportApiImpl.MSG_EXPOSE_KEY;
        aVar.f375271g = uq3.a.a();
        aVar.f375266b = "qcircle";
        aVar.f375267c = str2;
        aVar.f375268d = str;
        aVar.f375269e = ITEdgeRSServer.TEdgeServerScene.CloudAndClientRank;
        aVar.f375270f = BaseApplication.getContext();
        aVar.f375272h = com.tencent.mobileqq.statistics.o.c();
        ITEdgeRSServer a16 = com.tencent.tedger.a.a(aVar, this.f30621p, new b(feedCloudRead$StGetCloudSealFeedRsp));
        if (A()) {
            a16.setVerboseLogMode();
            QLog.d("TEDGEQFS_EdgeRSManagerV2", 1, "setVerboseLogMode true");
        }
        a16.init();
        this.f30606a = a16;
        f30605s = new WeakReference<>(a16);
        com.tencent.biz.qqcircle.tedgers2.behavior.a.d().h();
        com.tencent.biz.qqcircle.tedgers2.behavior.a.d().k(this);
    }

    private void t(FeedCloudRead$StGetCloudSealFeedRsp feedCloudRead$StGetCloudSealFeedRsp) {
        QLog.d("TEDGEQFS_EdgeRSManagerV2", 1, "initUserProfile");
        byte[] byteArray = feedCloudRead$StGetCloudSealFeedRsp.sealClientInfo.get().toByteArray();
        TEdgeUserProfile$UserProfile tEdgeUserProfile$UserProfile = new TEdgeUserProfile$UserProfile();
        try {
            tEdgeUserProfile$UserProfile.mergeFrom(byteArray);
            this.f30617l = tEdgeUserProfile$UserProfile;
            M(tEdgeUserProfile$UserProfile);
            QLog.d("TEDGEQFS_EdgeRSManagerV2", 1, "initUserProfile userProfile age:" + tEdgeUserProfile$UserProfile.age.get());
        } catch (Exception e16) {
            QLog.e("TEDGEQFS_EdgeRSManagerV2", 1, "initUserProfile userProfile.mergeFrom error:" + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ITEdgeRSSDKComponentDelegate u() {
        hc0.e eVar = this.f30611f;
        if (eVar == null) {
            hc0.e eVar2 = new hc0.e();
            this.f30611f = eVar2;
            return eVar2;
        }
        return eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.tencent.tedger.outapi.delegate.a v() {
        hc0.f fVar = this.f30608c;
        if (fVar == null) {
            hc0.f fVar2 = new hc0.f();
            this.f30608c = fVar2;
            return fVar2;
        }
        return fVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.tencent.tedger.outapi.delegate.b w() {
        n nVar = this.f30610e;
        if (nVar == null) {
            n nVar2 = new n();
            this.f30610e = nVar2;
            return nVar2;
        }
        return nVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.tencent.tedger.outapi.delegate.c x() {
        o oVar = this.f30607b;
        if (oVar == null) {
            o oVar2 = new o();
            this.f30607b = oVar2;
            return oVar2;
        }
        return oVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.tencent.tedger.outapi.delegate.e y() {
        s sVar = this.f30609d;
        if (sVar == null) {
            s sVar2 = new s();
            this.f30609d = sVar2;
            return sVar2;
        }
        return sVar;
    }

    public void F() {
        QLog.d("TEDGEQFS_EdgeRSManagerV2", 1, "[onDestroy]");
        r rVar = this.f30612g;
        if (rVar != null) {
            rVar.l();
        }
        this.f30622q = true;
        H();
    }

    public void G() {
        QLog.d("TEDGEQFS_EdgeRSManagerV2", 1, "[onStop]");
        r rVar = this.f30612g;
        if (rVar != null) {
            rVar.f().l();
        }
        H();
    }

    public void K() {
        QLog.d("TEDGEQFS_EdgeRSManagerV2", 1, "[restart]");
        r rVar = this.f30612g;
        if (rVar != null) {
            rVar.f().i();
        }
        I(true);
    }

    public void L(l.a aVar) {
        if (aVar == null) {
            return;
        }
        int i3 = aVar.f89807d;
        int i16 = aVar.f89805b;
        List<e30.b> list = aVar.f89808e;
        int i17 = 0;
        int i18 = -1;
        if (list != null) {
            int size = list.size();
            while (i17 < list.size()) {
                if (y.e(list.get(i17))) {
                    i18 = i17 + i16 + 1;
                }
                i17++;
            }
            i17 = size;
        }
        if (i3 != this.f30613h || this.f30615j != i18 || i16 != this.f30614i) {
            this.f30613h = i3;
            this.f30615j = i18;
            this.f30614i = i16;
            QLog.d("TEDGEQFS_EdgeRSManagerV2", 1, "updateUnExposeFeedInfo needKeepFeedSize:" + this.f30613h + ",mLastCacheAdIndex:" + this.f30615j + ",mLastExposeFeedIndex:" + this.f30614i + ",needKeepUnExposeFeedSize:" + i17);
            M(this.f30617l);
        }
    }

    @Override // com.tencent.biz.qqcircle.tedgers2.behavior.a.b
    public void a(a.C0931a c0931a, e30.b bVar) {
        ITEdgeRSServer iTEdgeRSServer = this.f30606a;
        if (iTEdgeRSServer == null) {
            QLog.e("TEDGEQFS_EdgeRSManagerV2", 1, "onNewAction edgeRSServer == null");
            return;
        }
        if (!B()) {
            return;
        }
        if (!iTEdgeRSServer.isSDKReady()) {
            QLog.d("TEDGEQFS_EdgeRSManagerV2", 1, "[onNewAction] edgeRSServer not init\uff0cdo reInit");
            iTEdgeRSServer.reInitAllIfNecessary();
            return;
        }
        if (!e.f30629d) {
            QLog.d("TEDGEQFS_EdgeRSManagerV2", 1, "do updateUserProfileInfo");
            e.f30629d = true;
            M(this.f30617l);
        }
        try {
            iTEdgeRSServer.addUserAction(l(c0931a, bVar));
        } catch (Exception e16) {
            QLog.d("TEDGEQFS_EdgeRSManagerV2", 1, "addUserAction error" + e16);
        }
    }

    protected void finalize() throws Throwable {
        QLog.d("TEDGEQFS_EdgeRSManagerV2", 1, "[finalize]");
        super.finalize();
    }

    public void p(int i3, r.a aVar) {
        com.tencent.biz.qqcircle.tedgers2.behavior.a.d().l(i3);
        this.f30612g.m(aVar);
    }

    public boolean z() {
        return this.f30616k;
    }
}
