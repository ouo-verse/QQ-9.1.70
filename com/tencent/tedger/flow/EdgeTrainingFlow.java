package com.tencent.tedger.flow;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.tedger.event.EdgeFeatureExtractorEvent;
import com.tencent.tedger.event.EdgeFeedBackEvent;
import com.tencent.tedger.event.EdgeTrainingEvent;
import com.tencent.tedger.outapi.beans.EdgeFeatureList;
import com.tencent.tedger.outapi.beans.EdgeListWiseSample;
import com.tencent.tedger.outapi.beans.EdgePointWiseSample;
import com.tencent.tedger.outapi.beans.EdgeStatus;
import com.tencent.tedger.outapi.proto.TEdgeSample$PointWiseSample;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes26.dex */
public class EdgeTrainingFlow extends r {
    static IPatchRedirector $redirector_;

    /* renamed from: n, reason: collision with root package name */
    public static AtomicBoolean f375160n;

    /* renamed from: k, reason: collision with root package name */
    private List<EdgePointWiseSample> f375161k;

    /* renamed from: l, reason: collision with root package name */
    private List<EdgePointWiseSample> f375162l;

    /* renamed from: m, reason: collision with root package name */
    private List<EdgeListWiseSample> f375163m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class a implements com.tencent.tedger.outapi.api.h {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) EdgeTrainingFlow.this);
            }
        }

        @Override // com.tencent.tedger.outapi.api.h
        public void a(String str, EdgeStatus edgeStatus, Object[] objArr) {
            Object obj;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, edgeStatus, objArr);
                return;
            }
            if (edgeStatus.getCode() != 0 || (obj = objArr[0]) == null) {
                ((com.tencent.tedgecontext.b) EdgeTrainingFlow.this).mLog.c(EdgeTrainingFlow.this.f375233a, "feedBack fail reqId = " + str + " msg = " + edgeStatus.getMsg());
                EdgeTrainingFlow.this.f375235c.a(str, edgeStatus, null);
                EdgeTrainingFlow.this.H(edgeStatus);
                return;
            }
            List list = (List) obj;
            ((com.tencent.tedgecontext.b) EdgeTrainingFlow.this).mLog.c(EdgeTrainingFlow.this.f375233a, "feedBack ok reqId = " + str + " result.size() = " + list.size());
            EdgeTrainingFlow.this.f375162l = list;
            EdgeTrainingFlow edgeTrainingFlow = EdgeTrainingFlow.this;
            edgeTrainingFlow.Z((EdgePointWiseSample) edgeTrainingFlow.f375162l.get(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class b implements com.tencent.tedger.outapi.api.h {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) EdgeTrainingFlow.this);
            }
        }

        @Override // com.tencent.tedger.outapi.api.h
        public void a(String str, EdgeStatus edgeStatus, Object[] objArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, edgeStatus, objArr);
                return;
            }
            if (edgeStatus.getCode() != 0 || objArr[0] == null || EdgeTrainingFlow.this.f375162l == null) {
                ((com.tencent.tedgecontext.b) EdgeTrainingFlow.this).mLog.c(EdgeTrainingFlow.this.f375233a, "featureExtractor fail reqId = " + str + " code = " + edgeStatus.getCode() + " msg = " + edgeStatus.getMsg() + " feedbackSamples = " + EdgeTrainingFlow.this.f375162l);
                EdgeTrainingFlow.this.f375235c.a(str, edgeStatus, null);
                EdgeTrainingFlow.this.H(edgeStatus);
                return;
            }
            EdgeTrainingFlow.this.f375163m.add((EdgeListWiseSample) objArr[0]);
            if (EdgeTrainingFlow.this.f375162l == null) {
                ((com.tencent.tedgecontext.b) EdgeTrainingFlow.this).mLog.c(EdgeTrainingFlow.this.f375233a, "featureExtractor feedbackSamples==null");
            }
            if (EdgeTrainingFlow.this.f375163m == null || EdgeTrainingFlow.this.f375162l == null || EdgeTrainingFlow.this.f375163m.size() >= EdgeTrainingFlow.this.f375162l.size()) {
                EdgeTrainingFlow.this.b0();
            } else {
                EdgeTrainingFlow edgeTrainingFlow = EdgeTrainingFlow.this;
                edgeTrainingFlow.Z((EdgePointWiseSample) edgeTrainingFlow.f375162l.get(EdgeTrainingFlow.this.f375163m.size()));
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30897);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            f375160n = new AtomicBoolean(false);
        }
    }

    public EdgeTrainingFlow(com.tencent.tedgecontext.a aVar) {
        super(aVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
        } else {
            this.f375163m = new ArrayList();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(EdgePointWiseSample edgePointWiseSample) {
        EdgeFeatureExtractorEvent edgeFeatureExtractorEvent = new EdgeFeatureExtractorEvent(new b());
        edgeFeatureExtractorEvent.reqId = this.f375237e;
        TEdgeSample$PointWiseSample tEdgeSample$PointWiseSample = new TEdgeSample$PointWiseSample();
        try {
            tEdgeSample$PointWiseSample.mergeFrom(edgePointWiseSample.readNativeData());
        } catch (InvalidProtocolBufferMicroException e16) {
            this.mLog.c(this.f375233a, "featureExtractor fail reqId = " + this.f375237e + " msg = " + e16);
        }
        EdgeFeatureList edgeFeatureList = new EdgeFeatureList(tEdgeSample$PointWiseSample.dupl.get());
        EdgeFeatureList edgeFeatureList2 = new EdgeFeatureList(tEdgeSample$PointWiseSample.item.get());
        edgeFeatureExtractorEvent.userFeature = edgeFeatureList;
        edgeFeatureExtractorEvent.itemFeatures.add(edgeFeatureList2);
        getRouter().f375309g.k(edgeFeatureExtractorEvent);
    }

    private void a0() {
        this.mLog.c(this.f375233a, "feedBack start reqId = " + this.f375237e);
        EdgeFeedBackEvent edgeFeedBackEvent = new EdgeFeedBackEvent(new a());
        edgeFeedBackEvent.samples = this.f375161k;
        edgeFeedBackEvent.reqId = this.f375237e;
        getRouter().f375309g.k(edgeFeedBackEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b0() {
        this.mLog.c(this.f375233a, "training start reqId = " + this.f375237e);
        EdgeStatus edgeStatus = new EdgeStatus();
        List<EdgeListWiseSample> list = this.f375163m;
        if (list != null && list.size() > 0) {
            getRouter().f375314l.train(this.f375163m, edgeStatus);
            if (edgeStatus.getCode() == 0) {
                this.mLog.d(this.f375233a, "training success reqId = " + this.f375237e);
                this.f375235c.a(this.f375237e, edgeStatus, new List[]{this.f375161k});
            } else {
                this.mLog.d(this.f375233a, "training fail reqId = " + this.f375237e + "code = " + edgeStatus.getCode() + " msg = " + edgeStatus.getMsg());
                this.f375235c.a(this.f375237e, edgeStatus, null);
            }
            this.f375239g = com.tencent.tedger.utils.a.a(getContext(), edgeStatus);
        } else {
            edgeStatus.setCode(-100L);
            this.mLog.d(this.f375233a, "training fail reqId = " + this.f375237e + "code = " + edgeStatus.getCode() + " msg = " + edgeStatus.getMsg());
            this.f375235c.a(this.f375237e, edgeStatus, null);
        }
        H(edgeStatus);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.tedger.flow.r
    public void H(EdgeStatus edgeStatus) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) edgeStatus);
            return;
        }
        super.H(edgeStatus);
        this.f375161k = null;
        this.f375162l = null;
        this.mLog.c(this.f375233a, "finish reqId = " + this.f375237e + " set feedbackSamples = null");
        this.f375163m = new ArrayList();
        f375160n.set(false);
    }

    @Override // com.tencent.tedger.flow.r
    public void M() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        super.M();
        if (f375160n.compareAndSet(false, true)) {
            O("tedge_n_training_start", "tedge_n_training_finish");
            List<EdgePointWiseSample> list = this.f375161k;
            if (list != null && list.size() > 0) {
                a0();
                return;
            }
            this.mLog.c(this.f375233a, "training fail samples in empty reqId = " + this.f375237e);
            EdgeStatus edgeStatus = new EdgeStatus();
            edgeStatus.setCode(-100L);
            this.f375235c.a(this.f375237e, edgeStatus, null);
            H(edgeStatus);
            return;
        }
        this.mLog.c(this.f375233a, "training fail reqId = " + this.f375237e);
        EdgeStatus edgeStatus2 = new EdgeStatus();
        edgeStatus2.setCode(-110L);
        this.f375235c.a(this.f375237e, edgeStatus2, null);
        H(edgeStatus2);
    }

    @Override // com.tencent.tedger.outapi.api.g
    public ArrayList<Integer> getActionType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ArrayList) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.f375240h;
    }

    @Override // com.tencent.tedger.outapi.api.g
    public ArrayList<Class> getEventClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ArrayList) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(EdgeTrainingEvent.class);
        return arrayList;
    }

    @Override // com.tencent.tedger.flow.r
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            super.onDestroy();
            f375160n.set(false);
        }
    }

    @Override // com.tencent.tedger.outapi.api.g
    public void v(com.tencent.tedger.outapi.api.f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) fVar);
        } else if (!getRouter().a() && (fVar instanceof EdgeTrainingEvent)) {
            getContext().m().f375305c.m(new Runnable((EdgeTrainingEvent) fVar) { // from class: com.tencent.tedger.flow.EdgeTrainingFlow.3
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ EdgeTrainingEvent f375164d;

                {
                    this.f375164d = r5;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) EdgeTrainingFlow.this, (Object) r5);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    EdgeTrainingFlow edgeTrainingFlow = EdgeTrainingFlow.this;
                    EdgeTrainingEvent edgeTrainingEvent = this.f375164d;
                    edgeTrainingFlow.f375235c = edgeTrainingEvent.mCallBack;
                    edgeTrainingFlow.J(edgeTrainingEvent);
                    EdgeTrainingFlow.this.f375161k = this.f375164d.samples;
                    EdgeTrainingFlow.this.M();
                }
            });
        }
    }
}
