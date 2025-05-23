package com.tencent.tedger.flow;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tedger.event.EdgeClientRankEvent;
import com.tencent.tedger.event.EdgeCloudAndClientRankEvent;
import com.tencent.tedger.event.EdgeCloudRankEvent;
import com.tencent.tedger.outapi.beans.EdgeItem;
import com.tencent.tedger.outapi.beans.EdgeStatus;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class b extends r {
    static IPatchRedirector $redirector_;

    /* renamed from: k, reason: collision with root package name */
    public String f375184k;

    /* renamed from: l, reason: collision with root package name */
    private List<EdgeItem> f375185l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class a implements com.tencent.tedger.outapi.api.h {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // com.tencent.tedger.outapi.api.h
        public void a(String str, EdgeStatus edgeStatus, Object[] objArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, edgeStatus, objArr);
                return;
            }
            if (edgeStatus.getCode() != 0 || objArr == null || objArr.length <= 0) {
                ((com.tencent.tedgecontext.b) b.this).mLog.c(b.this.f375184k, "getItemList fail reqId = " + str + " code = " + edgeStatus.getCode() + " msg = " + edgeStatus.getMsg());
                b.this.f375235c.a(str, edgeStatus, null);
                b.this.H(edgeStatus);
                return;
            }
            Object obj = objArr[0];
            if (obj == null || !(obj instanceof List)) {
                ((com.tencent.tedgecontext.b) b.this).mLog.c(b.this.f375184k, "cloudRank fail reqId = no possibility" + str);
                b.this.f375235c.a(str, edgeStatus, null);
                b.this.H(edgeStatus);
                return;
            }
            List list = (List) obj;
            b.this.f375185l = list;
            ((com.tencent.tedgecontext.b) b.this).mLog.c(b.this.f375184k, "cloudRank ok reqId = " + str + " results = " + list.size());
            b.this.W();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.tedger.flow.b$b, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public class C9898b implements com.tencent.tedger.outapi.api.h {
        static IPatchRedirector $redirector_;

        C9898b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // com.tencent.tedger.outapi.api.h
        public void a(String str, EdgeStatus edgeStatus, Object[] objArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, edgeStatus, objArr);
                return;
            }
            if (edgeStatus.getCode() == 0 && objArr != null && objArr.length > 0) {
                Object obj = objArr[0];
                if (obj instanceof List) {
                    List<EdgeItem> list = (List) obj;
                    ((com.tencent.tedgecontext.b) b.this).mLog.c(b.this.f375184k, "cloudRank ok reqId = " + b.this.f375237e + " results = " + list.size());
                    b bVar = b.this;
                    com.tencent.tedger.outapi.api.h hVar = bVar.f375235c;
                    if (hVar != null) {
                        hVar.a(str, edgeStatus, new List[]{list});
                    } else {
                        com.tencent.tedger.outapi.delegate.d k3 = bVar.getContext().k();
                        b bVar2 = b.this;
                        k3.a(bVar2.f375237e, bVar2.f375236d, list);
                    }
                    b.this.H(edgeStatus);
                }
            }
            ((com.tencent.tedgecontext.b) b.this).mLog.c(b.this.f375184k, "getItemList fail reqId = " + b.this.f375237e);
            com.tencent.tedger.outapi.api.h hVar2 = b.this.f375235c;
            if (hVar2 != null) {
                hVar2.a(str, edgeStatus, null);
            }
            b.this.H(edgeStatus);
        }
    }

    public b(com.tencent.tedgecontext.a aVar) {
        super(aVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
        } else {
            this.f375184k = "EdgeCloudAndClientRankFlow";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W() {
        this.mLog.c(this.f375184k, "EdgeCloudAndClientRankFlow  clientRank start reqId = " + this.f375237e);
        EdgeClientRankEvent edgeClientRankEvent = new EdgeClientRankEvent(new C9898b(), this.f375236d);
        edgeClientRankEvent.reqId = this.f375237e;
        edgeClientRankEvent.isMutex = false;
        edgeClientRankEvent.itemList = this.f375185l;
        getRouter().f375309g.k(edgeClientRankEvent);
    }

    private void X() {
        this.mLog.c(this.f375184k, "EdgeCloudAndClientRankFlow  cloudRank start reqId = " + this.f375237e);
        EdgeCloudRankEvent edgeCloudRankEvent = new EdgeCloudRankEvent(new a(), this.f375236d);
        edgeCloudRankEvent.reqId = this.f375237e;
        edgeCloudRankEvent.isMutex = false;
        getRouter().f375309g.k(edgeCloudRankEvent);
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
        this.f375185l = null;
        r.f375232j.set(false);
        this.f375236d = null;
        this.f375185l = null;
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
        O("tedge_n_cloud_client_rerank_start", "tedge_n_cloud_client_rerank_finish");
        if (getRouter().f375303a.o()) {
            X();
            return;
        }
        EdgeStatus edgeStatus = new EdgeStatus();
        edgeStatus.setCode(-104L);
        this.f375235c.a(this.f375237e, edgeStatus, null);
        H(edgeStatus);
    }

    @Override // com.tencent.tedger.outapi.api.g
    public ArrayList<Integer> getActionType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ArrayList) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return new ArrayList<>(Arrays.asList(-1));
    }

    @Override // com.tencent.tedger.outapi.api.g
    public ArrayList<Class> getEventClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ArrayList) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(EdgeCloudAndClientRankEvent.class);
        return arrayList;
    }

    @Override // com.tencent.tedger.outapi.api.g
    public void v(com.tencent.tedger.outapi.api.f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) fVar);
            return;
        }
        if (getRouter().a()) {
            return;
        }
        if (fVar.isMutex()) {
            if (!r.f375232j.compareAndSet(false, true)) {
                return;
            }
            if (!(fVar instanceof EdgeCloudAndClientRankEvent)) {
                r.f375232j.set(false);
                return;
            }
        }
        this.f375235c = ((EdgeCloudAndClientRankEvent) fVar).mCallBack;
        this.f375236d = fVar.getAction();
        J(fVar);
        M();
    }
}
