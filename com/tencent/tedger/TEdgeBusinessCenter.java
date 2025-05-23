package com.tencent.tedger;

import androidx.annotation.NonNull;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.haoliyou.sso.CheckForwardServlet;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.nativecpp.tedgecpp.CPPAlgorithmServer;
import com.tencent.nativecpp.tedgecpp.CPPAlgorithmServerCallback;
import com.tencent.tedgecontext.c;
import com.tencent.tedger.event.EdgeClientRankEvent;
import com.tencent.tedger.event.EdgeCloudAndClientRankEvent;
import com.tencent.tedger.event.EdgeCloudRankEvent;
import com.tencent.tedger.event.EdgeInferEvent;
import com.tencent.tedger.event.EdgeUserActionEvent;
import com.tencent.tedger.eventcenter.EdgeEventCenter;
import com.tencent.tedger.flow.r;
import com.tencent.tedger.init.EdgeInitStateManager;
import com.tencent.tedger.outapi.api.IInitStateManager;
import com.tencent.tedger.outapi.api.ITEdgeRSServer;
import com.tencent.tedger.outapi.api.b;
import com.tencent.tedger.outapi.api.d;
import com.tencent.tedger.outapi.api.h;
import com.tencent.tedger.outapi.api.m;
import com.tencent.tedger.outapi.beans.EdgeAction;
import com.tencent.tedger.outapi.beans.EdgeStatus;
import com.tencent.tedger.outapi.beans.EdgeUser;
import com.tencent.tedger.outapi.delegate.f;
import com.tencent.tedger.resource.ResourceManagerImp;
import com.tencent.tedger.sample.EdgeSampleCenter;
import com.tencent.video.decode.AVDecodeError;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import ve4.j;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TEdgeBusinessCenter implements ITEdgeRSServer {
    static IPatchRedirector $redirector_ = null;
    public static final String DB_VERSION = "1.0.2";
    private static final int SDK_INNER_VERSION = 4;
    private static final String TAG = "TEdgeRSServer";
    private final int MaxRetryCount;
    private final int RetryInterval;
    private long lastRetryTime;
    private CPPAlgorithmServer mAlgorithmServer;
    private final com.tencent.tedgecontext.a mContext;
    private final c mLog;
    private int mRetryCount;
    private final IInitStateManager.a mStepCallback;
    private HashMap<String, Object> reportMap;
    private List<r> tEdgeBaseFlows;

    public TEdgeBusinessCenter(@NonNull ITEdgeRSServer.a aVar, @NonNull f fVar, IInitStateManager.a aVar2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, aVar, fVar, aVar2);
            return;
        }
        this.tEdgeBaseFlows = new ArrayList();
        this.reportMap = new HashMap<>();
        this.MaxRetryCount = 3;
        this.RetryInterval = 10000;
        this.lastRetryTime = 0L;
        this.mRetryCount = 0;
        c cVar = new c(null);
        this.mLog = cVar;
        com.tencent.tedgecontext.a aVar3 = new com.tencent.tedgecontext.a(new com.tencent.tedger.routecenter.a(cVar), fVar, aVar);
        this.mContext = aVar3;
        this.mStepCallback = aVar2;
        initRouter();
        initFlows();
        cVar.g(aVar3);
    }

    private void initFlows() {
        this.tEdgeBaseFlows.addAll(r.K(this.mContext));
    }

    private void initRouter() {
        com.tencent.tedger.routecenter.a m3 = this.mContext.m();
        m3.f375303a.H(new EdgeInitStateManager(this.mContext));
        m3.f375309g.H(new EdgeEventCenter(this.mContext));
        m3.f375304b.H(new com.tencent.tedger.config.a(this.mContext));
        m3.f375305c.H(new ResourceManagerImp(this.mContext));
        m3.f375308f.H(new com.tencent.tedger.item.a(this.mContext));
        m3.f375307e.H(new com.tencent.tedger.user.a(this.mContext));
        m3.f375306d.H(new EdgeSampleCenter(this.mContext));
        m3.f375310h.H(new com.tencent.tedger.trigger.a(this.mContext));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initSO(@NonNull j.b bVar) {
        try {
            if (!CPPAlgorithmServer.canUseSo(4)) {
                this.mLog.f(TAG, 13, "so version is not for current sdk version");
                bVar.a(13);
                return;
            }
            this.mAlgorithmServer = new CPPAlgorithmServer(this.mContext.c(), new CPPAlgorithmServerCallback(this.mContext));
            this.mContext.m().f375311i.H(this.mAlgorithmServer.getCPPActionsFeature());
            this.mContext.m().f375312j.H(this.mAlgorithmServer.getCPPActionsFeatureProvider());
            this.mContext.m().f375313k.H(this.mAlgorithmServer.getCPPCollaborativeInference());
            this.mContext.m().f375314l.H(this.mAlgorithmServer.getCPPCollaborativeTraining());
            this.mContext.m().f375315m.H(this.mAlgorithmServer.getCPPPolicyManager());
            this.mContext.m().f375316n.H(this.mAlgorithmServer.getCPPTriggerManager());
            this.mContext.m().f375317o.H(this.mAlgorithmServer.getConvertFeedBackProvider());
            bVar.success();
        } catch (Throwable th5) {
            this.mLog.e(TAG, 13, th5.toString());
            bVar.a(13);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setConfigToFlows() {
        Iterator<r> it = this.tEdgeBaseFlows.iterator();
        while (it.hasNext()) {
            it.next().I();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setConfigToRouter() {
        if (this.mContext.m().f375307e != null) {
            this.mContext.m().f375307e.b();
        }
        if (this.mContext.m().f375306d != null) {
            this.mContext.m().f375306d.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EdgeStatus setConfigToSO() {
        EdgeStatus edgeStatus = new EdgeStatus();
        this.mContext.m().f375311i.init(this.mContext.e(), edgeStatus);
        this.mLog.h(TAG, "initSO:mActionsFeature " + edgeStatus.getMsg() + "  code = " + edgeStatus.getCode());
        if (edgeStatus.getCode() != 0) {
            return edgeStatus;
        }
        this.mContext.m().f375312j.init(this.mContext.e(), edgeStatus);
        this.mLog.h(TAG, "initSO:mActionFeatureProvider " + edgeStatus.getMsg() + "  code = " + edgeStatus.getCode());
        if (edgeStatus.getCode() != 0) {
            return edgeStatus;
        }
        this.mContext.m().f375313k.init(this.mContext.e(), edgeStatus);
        this.mLog.h(TAG, "initSO:mCollaborativeInference " + edgeStatus.getMsg() + "  code = " + edgeStatus.getCode());
        if (edgeStatus.getCode() != 0) {
            return edgeStatus;
        }
        this.mContext.m().f375314l.init(this.mContext.e(), edgeStatus);
        this.mLog.h(TAG, "initSO:mCollaborativeTraining " + edgeStatus.getMsg() + "  code = " + edgeStatus.getCode());
        if (edgeStatus.getCode() != 0) {
            return edgeStatus;
        }
        this.mContext.m().f375315m.init(this.mContext.e(), edgeStatus);
        this.mLog.h(TAG, "initSO:mPolicyManager " + edgeStatus.getMsg() + "  code = " + edgeStatus.getCode());
        if (edgeStatus.getCode() != 0) {
            return edgeStatus;
        }
        this.mContext.m().f375316n.init(this.mContext.e(), edgeStatus);
        this.mLog.h(TAG, "initSO:mTriggerManager " + edgeStatus.getMsg() + "  code = " + edgeStatus.getCode());
        if (edgeStatus.getCode() != 0) {
            return edgeStatus;
        }
        this.mContext.m().f375317o.init(this.mContext.e(), edgeStatus);
        this.mLog.h(TAG, "initSO:mConvertFeedBackProvider " + edgeStatus.getMsg() + "  code = " + edgeStatus.getCode());
        return edgeStatus;
    }

    @Override // com.tencent.tedger.outapi.api.ITEdgeRSServer
    public void addUserAction(EdgeAction edgeAction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) edgeAction);
            return;
        }
        if (isSDKReady()) {
            EdgeStatus edgeStatus = new EdgeStatus();
            if (edgeAction != null && this.mContext.m().f375309g != null) {
                this.mContext.m().f375309g.k(new EdgeUserActionEvent(edgeAction));
                edgeStatus.setCode(0L);
            } else {
                edgeStatus.setCode(-100L);
            }
        }
    }

    public EdgeStatus edgeClientRank(h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (EdgeStatus) iPatchRedirector.redirect((short) 14, (Object) this, (Object) hVar);
        }
        EdgeStatus edgeStatus = new EdgeStatus();
        if (!this.mContext.m().f375304b.x()) {
            edgeStatus.setCode(-111L);
        } else if (r.f375232j.get()) {
            edgeStatus.setCode(-110L);
        } else {
            this.mContext.m().f375309g.k(new EdgeClientRankEvent(hVar));
            edgeStatus.setCode(0L);
        }
        return edgeStatus;
    }

    public EdgeStatus edgeCloudAndClientRank(h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (EdgeStatus) iPatchRedirector.redirect((short) 16, (Object) this, (Object) hVar);
        }
        EdgeStatus edgeStatus = new EdgeStatus();
        if (!this.mContext.m().f375304b.t()) {
            edgeStatus.setCode(-111L);
            return edgeStatus;
        }
        if (!r.f375232j.get()) {
            this.mContext.m().f375309g.k(new EdgeCloudAndClientRankEvent(hVar));
            edgeStatus.setCode(0L);
        } else {
            edgeStatus.setCode(-110L);
        }
        return edgeStatus;
    }

    public EdgeStatus edgeCloudRank(h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (EdgeStatus) iPatchRedirector.redirect((short) 15, (Object) this, (Object) hVar);
        }
        EdgeStatus edgeStatus = new EdgeStatus();
        if (!this.mContext.m().f375304b.t()) {
            edgeStatus.setCode(-111L);
            return edgeStatus;
        }
        if (!r.f375232j.get()) {
            this.mContext.m().f375309g.k(new EdgeCloudRankEvent(hVar));
            edgeStatus.setCode(0L);
        } else {
            edgeStatus.setCode(-110L);
        }
        return edgeStatus;
    }

    public EdgeStatus edgeInfer(h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (EdgeStatus) iPatchRedirector.redirect((short) 18, (Object) this, (Object) hVar);
        }
        EdgeStatus edgeStatus = new EdgeStatus();
        if (!this.mContext.m().f375304b.r()) {
            edgeStatus.setCode(-111L);
            return edgeStatus;
        }
        this.mContext.m().f375309g.k(new EdgeInferEvent(hVar));
        edgeStatus.setCode(0L);
        return edgeStatus;
    }

    public EdgeStatus edgeTraining(h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (EdgeStatus) iPatchRedirector.redirect((short) 17, (Object) this, (Object) hVar);
        }
        EdgeStatus edgeStatus = new EdgeStatus();
        if (!this.mContext.m().f375304b.j()) {
            edgeStatus.setCode(-111L);
            return edgeStatus;
        }
        this.mContext.m().f375306d.p(edgeStatus);
        edgeStatus.setCode(0L);
        return edgeStatus;
    }

    public b getCollaborativeInference() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (b) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.mContext.m().f375313k;
    }

    public com.tencent.tedger.outapi.api.c getCollaborativeTraining() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (com.tencent.tedger.outapi.api.c) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.mContext.m().f375314l;
    }

    public IInitStateManager getComponentManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (IInitStateManager) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mContext.m().f375303a;
    }

    @Override // com.tencent.tedger.outapi.api.ITEdgeRSServer
    public d getConfigManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (d) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.mContext.m().f375304b;
    }

    public com.tencent.tedger.outapi.api.j getFeatureManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (com.tencent.tedger.outapi.api.j) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.mContext.m().f375311i;
    }

    public m getPolicyManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (m) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.mContext.m().f375315m;
    }

    @Override // com.tencent.tedger.outapi.api.ITEdgeRSServer
    public void init() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.reportMap.put("event_id", "tedge_n_rerank_init_start");
        this.reportMap.put("ret_code", 0);
        this.mContext.d().c(new HashMap(this.reportMap));
        this.reportMap.clear();
        this.mContext.m().f375305c.l(new Runnable(System.currentTimeMillis()) { // from class: com.tencent.tedger.TEdgeBusinessCenter.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ long f375129d;

            /* compiled from: P */
            /* renamed from: com.tencent.tedger.TEdgeBusinessCenter$1$a */
            /* loaded from: classes26.dex */
            class a implements j.a {
                static IPatchRedirector $redirector_;

                a() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                    }
                }

                @Override // ve4.j.a
                public void a(@NonNull j.b bVar) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        TEdgeBusinessCenter.this.initSO(bVar);
                    } else {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar);
                    }
                }
            }

            /* compiled from: P */
            /* renamed from: com.tencent.tedger.TEdgeBusinessCenter$1$b */
            /* loaded from: classes26.dex */
            class b implements IInitStateManager.a {
                static IPatchRedirector $redirector_;

                b() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                    }
                }

                @Override // com.tencent.tedger.outapi.api.IInitStateManager.a
                public void a(IInitStateManager.TEdgeRSInitStep tEdgeRSInitStep, IInitStateManager.a.InterfaceC9900a interfaceC9900a) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        iPatchRedirector.redirect((short) 3, (Object) this, (Object) tEdgeRSInitStep, (Object) interfaceC9900a);
                        return;
                    }
                    if (tEdgeRSInitStep == IInitStateManager.TEdgeRSInitStep.End) {
                        EdgeStatus configToSO = TEdgeBusinessCenter.this.setConfigToSO();
                        TEdgeBusinessCenter.this.setConfigToRouter();
                        TEdgeBusinessCenter.this.setConfigToFlows();
                        TEdgeBusinessCenter.this.reportMap.put("event_id", "tedge_n_rerank_init_end");
                        TEdgeBusinessCenter.this.reportMap.put("time_cost", Long.valueOf(System.currentTimeMillis() - AnonymousClass1.this.f375129d));
                        if (configToSO != null && configToSO.getCode() != 0) {
                            TEdgeBusinessCenter.this.reportMap.put(DownloadInfo.spKey_Config, TEdgeBusinessCenter.this.mContext.e());
                        }
                        TEdgeBusinessCenter.this.reportMap.put("ret_code", Long.valueOf(configToSO.getCode()));
                        TEdgeBusinessCenter.this.mContext.d().c(new HashMap(TEdgeBusinessCenter.this.reportMap));
                        TEdgeBusinessCenter.this.reportMap.clear();
                    }
                    if (tEdgeRSInitStep == IInitStateManager.TEdgeRSInitStep.CheckedConfig) {
                        interfaceC9900a.a();
                    } else if (TEdgeBusinessCenter.this.mStepCallback != null) {
                        TEdgeBusinessCenter.this.mStepCallback.a(tEdgeRSInitStep, interfaceC9900a);
                    }
                }

                @Override // com.tencent.tedger.outapi.api.IInitStateManager.a
                public boolean b(IInitStateManager.TEdgeRSInitStep tEdgeRSInitStep, int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) tEdgeRSInitStep, i3)).booleanValue();
                    }
                    TEdgeBusinessCenter.this.reportMap.put("event_id", "tedge_n_rerank_init_end");
                    TEdgeBusinessCenter.this.reportMap.put("time_cost", Long.valueOf(System.currentTimeMillis() - AnonymousClass1.this.f375129d));
                    TEdgeBusinessCenter.this.reportMap.put("ret_code", Integer.valueOf(i3));
                    TEdgeBusinessCenter.this.reportMap.put(CheckForwardServlet.KEY_ERR_CODE, Integer.valueOf(i3));
                    TEdgeBusinessCenter.this.reportMap.put("err_msg", tEdgeRSInitStep.toString());
                    TEdgeBusinessCenter.this.mContext.d().c(new HashMap(TEdgeBusinessCenter.this.reportMap));
                    TEdgeBusinessCenter.this.reportMap.clear();
                    if (TEdgeBusinessCenter.this.mStepCallback != null) {
                        return TEdgeBusinessCenter.this.mStepCallback.b(tEdgeRSInitStep, i3);
                    }
                    return false;
                }
            }

            {
                this.f375129d = r6;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, TEdgeBusinessCenter.this, Long.valueOf(r6));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    if (TEdgeBusinessCenter.this.mContext.m().f375303a.y() == IInitStateManager.TEdgeRSInitStep.End) {
                        return;
                    }
                    TEdgeBusinessCenter.this.mContext.m().f375303a.g(new a(), new b());
                }
            }
        });
    }

    @Override // com.tencent.tedger.outapi.api.ITEdgeRSServer
    public boolean isSDKReady() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        try {
            if (this.mContext.m().a()) {
                this.mLog.e(TAG, -888, "isSDKReady: router is destroyed, return");
                return false;
            }
            if (this.mContext.m().f375303a == null || this.mContext.m().f375303a.y() != IInitStateManager.TEdgeRSInitStep.End) {
                return false;
            }
            return true;
        } catch (Throwable th5) {
            this.mLog.e(TAG, -104, "isSDKReady: " + th5);
            return false;
        }
    }

    @Override // com.tencent.tedger.outapi.api.ITEdgeRSServer
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        this.mLog.c(TAG, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        if (!this.tEdgeBaseFlows.isEmpty()) {
            Iterator<r> it = this.tEdgeBaseFlows.iterator();
            while (it.hasNext()) {
                it.next().onDestroy();
            }
        }
        this.mContext.m().b();
    }

    @Override // com.tencent.tedger.outapi.api.ITEdgeRSServer
    public void reInitAllIfNecessary() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (this.mContext.m().a()) {
            this.mLog.e(TAG, -888, "reInitAllIfNecessary: router is destroyed, return");
            return;
        }
        if (System.currentTimeMillis() - this.lastRetryTime < 10000) {
            this.mLog.e(TAG, AVDecodeError.VIDEO_DECODE_A_ERR, "reInitAllIfNecessary: retry interval is not enough, return");
            return;
        }
        this.lastRetryTime = System.currentTimeMillis();
        int i3 = this.mRetryCount + 1;
        this.mRetryCount = i3;
        if (i3 > 3) {
            this.mLog.e(TAG, AVDecodeError.JNI_BITMAP_STRIDE_ERR, "reInitAllIfNecessary: retry count is more than max retry count, return");
        } else {
            init();
        }
    }

    public void setDebug() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            this.mContext.u(true);
        }
    }

    @Override // com.tencent.tedger.outapi.api.ITEdgeRSServer
    public void setVerboseLogMode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            this.mContext.v(true);
        }
    }

    @Override // com.tencent.tedger.outapi.api.ITEdgeRSServer
    public void updateUserBaseInfo(EdgeUser edgeUser, EdgeStatus edgeStatus) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) edgeUser, (Object) edgeStatus);
        } else if (isSDKReady()) {
            this.mContext.m().f375305c.l(new Runnable(edgeUser, edgeStatus) { // from class: com.tencent.tedger.TEdgeBusinessCenter.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ EdgeUser f375132d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ EdgeStatus f375133e;

                {
                    this.f375132d = edgeUser;
                    this.f375133e = edgeStatus;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, TEdgeBusinessCenter.this, edgeUser, edgeStatus);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else if (this.f375132d != null) {
                        TEdgeBusinessCenter.this.mContext.m().f375307e.updateUserBaseInfo(this.f375132d, this.f375133e);
                    } else {
                        this.f375133e.setCode(-100L);
                    }
                }
            });
        } else {
            this.mLog.e(TAG, -888, "updateUserBaseInfo: router is destroyed, return");
        }
    }
}
