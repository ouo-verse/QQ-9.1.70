package com.tencent.tedger.flow;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tedger.event.EdgeFeatureExtractorEvent;
import com.tencent.tedger.event.EdgeFeatureProviderEvent;
import com.tencent.tedger.event.EdgeGetItemListEvent;
import com.tencent.tedger.event.EdgeGetUserInfoEvent;
import com.tencent.tedger.event.EdgeInferEvent;
import com.tencent.tedger.outapi.beans.EdgeFeatureList;
import com.tencent.tedger.outapi.beans.EdgeItem;
import com.tencent.tedger.outapi.beans.EdgeItemInfer;
import com.tencent.tedger.outapi.beans.EdgeListWiseSample;
import com.tencent.tedger.outapi.beans.EdgeStatus;
import com.tencent.tedger.outapi.beans.EdgeUser;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class m extends r {
    static IPatchRedirector $redirector_;

    /* renamed from: k, reason: collision with root package name */
    private List<EdgeItem> f375218k;

    /* renamed from: l, reason: collision with root package name */
    private EdgeUser f375219l;

    /* renamed from: m, reason: collision with root package name */
    private List<EdgeFeatureList> f375220m;

    /* renamed from: n, reason: collision with root package name */
    private EdgeFeatureList f375221n;

    /* renamed from: o, reason: collision with root package name */
    private EdgeListWiseSample f375222o;

    /* renamed from: p, reason: collision with root package name */
    private List<EdgeItemInfer> f375223p;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class a implements com.tencent.tedger.outapi.api.h {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) m.this);
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
            if (edgeStatus.getCode() != 0 || objArr == null || (obj = objArr[0]) == null) {
                ((com.tencent.tedgecontext.b) m.this).mLog.c(m.this.f375233a, "getItemList fail reqId = " + str + " code = " + edgeStatus.getCode() + " msg = " + edgeStatus.getMsg());
                m.this.f375235c.a(str, edgeStatus, null);
                return;
            }
            ((com.tencent.tedgecontext.b) m.this).mLog.c(m.this.f375233a, "getItemList ok reqId = " + str);
            m.this.f375218k = (List) obj;
            m.this.j0();
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
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) m.this);
            }
        }

        @Override // com.tencent.tedger.outapi.api.h
        public void a(String str, EdgeStatus edgeStatus, Object[] objArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, edgeStatus, objArr);
                return;
            }
            if (edgeStatus.getCode() != 0) {
                ((com.tencent.tedgecontext.b) m.this).mLog.c(m.this.f375233a, "getUserInfo fail reqId = " + str);
                m.this.f375235c.a(str, edgeStatus, null);
                return;
            }
            Object obj = objArr[0];
            if (obj != null) {
                ((com.tencent.tedgecontext.b) m.this).mLog.c(m.this.f375233a, "getUserInfo ok reqId = " + str);
                m.this.f375219l = (EdgeUser) obj;
                m.this.h0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class c implements com.tencent.tedger.outapi.api.h {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) m.this);
            }
        }

        @Override // com.tencent.tedger.outapi.api.h
        public void a(String str, EdgeStatus edgeStatus, Object[] objArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, edgeStatus, objArr);
                return;
            }
            if (edgeStatus.getCode() == 0) {
                ((com.tencent.tedgecontext.b) m.this).mLog.c(m.this.f375233a, "featureProvider ok reqId = " + str);
                m.this.f375220m = (List) objArr[0];
                m.this.f375221n = (EdgeFeatureList) objArr[1];
                m.this.g0();
                return;
            }
            ((com.tencent.tedgecontext.b) m.this).mLog.c(m.this.f375233a, "featureProvider fail reqId = " + str);
            m.this.f375235c.a(str, edgeStatus, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class d implements com.tencent.tedger.outapi.api.h {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) m.this);
            }
        }

        @Override // com.tencent.tedger.outapi.api.h
        public void a(String str, EdgeStatus edgeStatus, Object[] objArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, edgeStatus, objArr);
                return;
            }
            if (edgeStatus.getCode() == 0) {
                ((com.tencent.tedgecontext.b) m.this).mLog.c(m.this.f375233a, "featureExtractor ok reqId = " + str);
                m.this.f375222o = (EdgeListWiseSample) objArr[0];
                m.this.k0();
                return;
            }
            ((com.tencent.tedgecontext.b) m.this).mLog.c(m.this.f375233a, "featureExtractor fail reqId = " + str);
            m.this.f375235c.a(str, edgeStatus, null);
        }
    }

    public m(com.tencent.tedgecontext.a aVar) {
        super(aVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g0() {
        EdgeFeatureExtractorEvent edgeFeatureExtractorEvent = new EdgeFeatureExtractorEvent(new d());
        edgeFeatureExtractorEvent.reqId = this.f375237e;
        edgeFeatureExtractorEvent.userFeature = this.f375221n;
        edgeFeatureExtractorEvent.itemFeatures = this.f375220m;
        getRouter().f375309g.k(edgeFeatureExtractorEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h0() {
        EdgeFeatureProviderEvent edgeFeatureProviderEvent = new EdgeFeatureProviderEvent(new c());
        edgeFeatureProviderEvent.itemList = this.f375218k;
        edgeFeatureProviderEvent.reqId = this.f375237e;
        edgeFeatureProviderEvent.user = this.f375219l;
        getRouter().f375309g.k(edgeFeatureProviderEvent);
    }

    private void i0() {
        EdgeGetItemListEvent edgeGetItemListEvent = new EdgeGetItemListEvent(new a());
        edgeGetItemListEvent.requestType = "client_rerank_data_source_type";
        edgeGetItemListEvent.reqId = this.f375237e;
        getRouter().f375309g.k(edgeGetItemListEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j0() {
        EdgeGetUserInfoEvent edgeGetUserInfoEvent = new EdgeGetUserInfoEvent(new b());
        edgeGetUserInfoEvent.reqId = this.f375237e;
        getRouter().f375309g.k(edgeGetUserInfoEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k0() {
        List<EdgeItemInfer> list;
        EdgeStatus edgeStatus = new EdgeStatus();
        this.f375223p = getRouter().f375313k.inference(this.f375222o, edgeStatus);
        if (edgeStatus.getCode() == 0 && (list = this.f375223p) != null && list.size() > 0) {
            this.mLog.c(this.f375233a, "infer ok reqId = " + this.f375237e + " itemInfers = " + this.f375223p.size());
            this.f375235c.a(this.f375237e, edgeStatus, new Object[]{this.f375223p});
        } else {
            this.mLog.c(this.f375233a, "infer fail reqId = " + this.f375237e + " code = " + edgeStatus.getCode() + " msg = " + edgeStatus.getMsg());
            if (edgeStatus.getCode() == 0) {
                edgeStatus.setCode(-100L);
            }
            this.f375235c.a(this.f375237e, edgeStatus, null);
        }
        this.f375239g = com.tencent.tedger.utils.a.a(getContext(), edgeStatus);
        H(edgeStatus);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.tedger.flow.r
    public void M() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.M();
        if (getRouter().f375303a.o()) {
            i0();
            return;
        }
        EdgeStatus edgeStatus = new EdgeStatus();
        edgeStatus.setCode(-104L);
        this.f375235c.a(this.f375237e, edgeStatus, null);
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
        arrayList.add(EdgeInferEvent.class);
        return arrayList;
    }

    @Override // com.tencent.tedger.outapi.api.g
    public void v(com.tencent.tedger.outapi.api.f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) fVar);
            return;
        }
        if (!getRouter().a() && (fVar instanceof EdgeInferEvent)) {
            EdgeInferEvent edgeInferEvent = (EdgeInferEvent) fVar;
            this.f375235c = edgeInferEvent.mCallBack;
            J(fVar);
            EdgeListWiseSample edgeListWiseSample = edgeInferEvent.sample;
            this.f375222o = edgeListWiseSample;
            if (edgeListWiseSample != null) {
                k0();
            } else {
                M();
            }
        }
    }
}
