package com.tencent.tedger.flow;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tedger.event.EdgeCloudRankEvent;
import com.tencent.tedger.event.EdgeIndependentCloudPolicyRankEvent;
import com.tencent.tedger.event.EdgeIndependentPolicyRankEvent;
import com.tencent.tedger.outapi.beans.EdgeItem;
import com.tencent.tedger.outapi.beans.EdgeStatus;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class k extends r {
    static IPatchRedirector $redirector_;

    /* renamed from: k, reason: collision with root package name */
    public String f375205k;

    /* renamed from: l, reason: collision with root package name */
    private List<EdgeItem> f375206l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class a implements com.tencent.tedger.outapi.api.h {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) k.this);
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
                ((com.tencent.tedgecontext.b) k.this).mLog.c(k.this.f375205k, "getItemList fail reqId = " + str + " code = " + edgeStatus.getCode() + " msg = " + edgeStatus.getMsg());
                k.this.f375235c.a(str, edgeStatus, null);
                k.this.H(edgeStatus);
                return;
            }
            Object obj = objArr[0];
            if (obj == null || !(obj instanceof List)) {
                ((com.tencent.tedgecontext.b) k.this).mLog.c(k.this.f375205k, "cloudRank fail reqId = no possibility" + str);
                k.this.f375235c.a(str, edgeStatus, null);
                k.this.H(edgeStatus);
                return;
            }
            List list = (List) obj;
            k.this.f375206l = list;
            ((com.tencent.tedgecontext.b) k.this).mLog.c(k.this.f375205k, "cloudRank ok reqId = " + str + " results = " + list.size());
            k.this.X();
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
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) k.this);
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
                    ((com.tencent.tedgecontext.b) k.this).mLog.c(k.this.f375205k, "cloudRank ok reqId = " + k.this.f375237e + " results = " + list.size());
                    k kVar = k.this;
                    com.tencent.tedger.outapi.api.h hVar = kVar.f375235c;
                    if (hVar != null) {
                        hVar.a(str, edgeStatus, new List[]{list});
                    } else {
                        com.tencent.tedger.outapi.delegate.d k3 = kVar.getContext().k();
                        k kVar2 = k.this;
                        k3.a(kVar2.f375237e, kVar2.f375236d, list);
                    }
                    k.this.H(edgeStatus);
                }
            }
            ((com.tencent.tedgecontext.b) k.this).mLog.c(k.this.f375205k, "getItemList fail reqId = " + k.this.f375237e);
            com.tencent.tedger.outapi.api.h hVar2 = k.this.f375235c;
            if (hVar2 != null) {
                hVar2.a(str, edgeStatus, null);
            }
            k.this.H(edgeStatus);
        }
    }

    public k(com.tencent.tedgecontext.a aVar) {
        super(aVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
        } else {
            this.f375205k = "EdgeIndependentCloudPolicyRankFlow";
        }
    }

    private void W() {
        this.mLog.c(this.f375205k, "EdgeIndependentCloudPolicyRankFlow  cloudRank start reqId = " + this.f375237e);
        EdgeCloudRankEvent edgeCloudRankEvent = new EdgeCloudRankEvent(new a(), this.f375236d);
        edgeCloudRankEvent.reqId = this.f375237e;
        edgeCloudRankEvent.isMutex = false;
        getRouter().f375309g.k(edgeCloudRankEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X() {
        this.mLog.c(this.f375205k, "EdgeIndependentCloudPolicyRankFlow  clientRank start reqId = " + this.f375237e);
        EdgeIndependentPolicyRankEvent edgeIndependentPolicyRankEvent = new EdgeIndependentPolicyRankEvent(new b(), this.f375236d);
        edgeIndependentPolicyRankEvent.reqId = this.f375237e;
        edgeIndependentPolicyRankEvent.isMutex = false;
        edgeIndependentPolicyRankEvent.itemList = this.f375206l;
        getRouter().f375309g.k(edgeIndependentPolicyRankEvent);
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
        this.f375206l = null;
        r.f375232j.set(false);
        this.f375236d = null;
        this.f375206l = null;
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
        O("tedge_n_independent_cloud_policy_start", "tedge_n_independent_cloud_policy_finish");
        if (getRouter().f375303a.o()) {
            W();
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
        arrayList.add(EdgeIndependentCloudPolicyRankEvent.class);
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
            if (!(fVar instanceof EdgeIndependentCloudPolicyRankEvent)) {
                r.f375232j.set(false);
                return;
            }
        }
        this.f375235c = ((EdgeIndependentCloudPolicyRankEvent) fVar).mCallBack;
        this.f375236d = fVar.getAction();
        J(fVar);
        M();
    }
}
