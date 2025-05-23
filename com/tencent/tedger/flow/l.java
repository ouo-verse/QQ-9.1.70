package com.tencent.tedger.flow;

import com.tencent.mobileqq.haoliyou.sso.CheckForwardServlet;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tedger.event.EdgeGetItemListEvent;
import com.tencent.tedger.event.EdgeGetUserInfoEvent;
import com.tencent.tedger.event.EdgeIndependentPolicyRankEvent;
import com.tencent.tedger.event.EdgePolicyRankEvent;
import com.tencent.tedger.event.EdgeSelectItemEvent;
import com.tencent.tedger.outapi.beans.EdgeItem;
import com.tencent.tedger.outapi.beans.EdgeStatus;
import com.tencent.tedger.outapi.beans.EdgeUser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class l extends r {
    static IPatchRedirector $redirector_;

    /* renamed from: k, reason: collision with root package name */
    public String f375209k;

    /* renamed from: l, reason: collision with root package name */
    private List<EdgeItem> f375210l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f375211m;

    /* renamed from: n, reason: collision with root package name */
    private EdgeUser f375212n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class a implements com.tencent.tedger.outapi.api.h {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) l.this);
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
            if (edgeStatus.getCode() != 0) {
                ((com.tencent.tedgecontext.b) l.this).mLog.c(l.this.f375209k, "getUnexposedItemList fail reqId = " + str + " code = " + edgeStatus.getCode() + " msg = " + edgeStatus.getMsg());
                l.this.f375235c.a(str, edgeStatus, null);
                l.this.H(edgeStatus);
                return;
            }
            if (objArr != null && (obj = objArr[0]) != null) {
                List list = (List) obj;
                ((com.tencent.tedgecontext.b) l.this).mLog.c(l.this.f375209k, "getUnexposedItemList ok reqId = " + str + " result size = " + list.size());
                l.this.f375210l = list;
                l.this.j0();
                return;
            }
            edgeStatus.setCode(-102L);
            ((com.tencent.tedgecontext.b) l.this).mLog.c(l.this.f375209k, "getUnexposedItemList fail reqId = " + str + " code = " + edgeStatus.getCode() + " msg = " + edgeStatus.getMsg());
            l.this.f375235c.a(str, edgeStatus, null);
            l.this.f375238f.put(CheckForwardServlet.KEY_ERR_CODE, Long.valueOf(edgeStatus.getCode()));
            l.this.f375238f.put("err_msg", edgeStatus.getMsg());
            l.this.H(edgeStatus);
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
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) l.this);
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
                ((com.tencent.tedgecontext.b) l.this).mLog.c(l.this.f375209k, "getCandidatePoolItemList fail reqId = " + str + " code = " + edgeStatus.getCode() + " msg = " + edgeStatus.getMsg());
            } else {
                List list = (List) obj;
                if (list != null && list.size() > 0) {
                    ((com.tencent.tedgecontext.b) l.this).mLog.c(l.this.f375209k, "getCandidatePoolItemList ok reqId = " + str + " result size = " + list.size());
                    if (l.this.f375210l == null) {
                        l.this.f375210l = new ArrayList();
                    }
                    l.this.f375210l.addAll(list);
                }
            }
            l.this.n0();
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
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) l.this);
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
                ((com.tencent.tedgecontext.b) l.this).mLog.c(l.this.f375209k, "selectItem fail reqId = " + str + " code = " + edgeStatus.getCode() + " msg = " + edgeStatus.getMsg());
                l.this.f375235c.a(str, edgeStatus, null);
                l.this.H(edgeStatus);
                return;
            }
            List list = (List) obj;
            if (list != null && list.size() > 0) {
                ((com.tencent.tedgecontext.b) l.this).mLog.c(l.this.f375209k, "selectItem ok reqId = " + str + " result size = " + list.size());
                l.this.f375210l = list;
            }
            l.this.l0();
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
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) l.this);
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
                ((com.tencent.tedgecontext.b) l.this).mLog.c(l.this.f375209k, "getUserInfo fail reqId = " + str + " code = " + edgeStatus.getCode() + " msg = " + edgeStatus.getMsg());
                l.this.f375235c.a(str, edgeStatus, null);
                l.this.H(edgeStatus);
                return;
            }
            Object obj = objArr[0];
            if (obj != null) {
                ((com.tencent.tedgecontext.b) l.this).mLog.c(l.this.f375209k, "getUserInfo ok reqId = " + str);
                l.this.f375212n = (EdgeUser) obj;
                l.this.m0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class e implements com.tencent.tedger.outapi.api.h {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) l.this);
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
            if (edgeStatus.getCode() == 0 && (obj = objArr[0]) != null) {
                List<String> list = (List) obj;
                ArrayList arrayList = new ArrayList();
                if (list != null && list.size() > 0 && l.this.f375210l != null && l.this.f375210l.size() > 0) {
                    ((com.tencent.tedgecontext.b) l.this).mLog.c(l.this.f375209k, "policyRank ok reqId = " + str + " itemIds = " + list.size());
                    for (String str2 : list) {
                        Iterator it = l.this.f375210l.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                EdgeItem edgeItem = (EdgeItem) it.next();
                                if (str2.equals(edgeItem.getItemID())) {
                                    ((com.tencent.tedgecontext.b) l.this).mLog.d(l.this.f375209k, "rerank item:" + edgeItem.getItemID());
                                    arrayList.add(edgeItem);
                                    break;
                                }
                            }
                        }
                    }
                    l lVar = l.this;
                    com.tencent.tedger.outapi.api.h hVar = lVar.f375235c;
                    if (hVar != null) {
                        hVar.a(str, edgeStatus, new List[]{arrayList});
                    } else {
                        lVar.getContext().k().a(str, l.this.f375236d, arrayList);
                    }
                } else {
                    ((com.tencent.tedgecontext.b) l.this).mLog.c(l.this.f375209k, "policyRank fail reqId = " + str + " code = " + edgeStatus.getCode() + " msg = " + edgeStatus.getMsg());
                    com.tencent.tedger.outapi.api.h hVar2 = l.this.f375235c;
                    if (hVar2 != null) {
                        hVar2.a(str, edgeStatus, null);
                    }
                }
            } else {
                ((com.tencent.tedgecontext.b) l.this).mLog.c(l.this.f375209k, "policyRank fail reqId = " + str + " code = " + edgeStatus.getCode() + " msg = " + edgeStatus.getMsg());
                com.tencent.tedger.outapi.api.h hVar3 = l.this.f375235c;
                if (hVar3 != null) {
                    hVar3.a(str, edgeStatus, null);
                }
            }
            l.this.H(edgeStatus);
        }
    }

    public l(com.tencent.tedgecontext.a aVar) {
        super(aVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
        } else {
            this.f375209k = "EdgeIndependentPolicyRankFlow";
            this.f375211m = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j0() {
        this.mLog.c(this.f375209k, "getCandidatePoolItemList start reqId = " + this.f375237e);
        EdgeGetItemListEvent edgeGetItemListEvent = new EdgeGetItemListEvent(new b());
        edgeGetItemListEvent.requestType = "client_rerank_data_source_type";
        edgeGetItemListEvent.reqId = this.f375237e;
        getRouter().f375309g.k(edgeGetItemListEvent);
    }

    private void k0() {
        this.mLog.c(this.f375209k, "EdgeIndependentPolicyRankFlow  getUnexposedItemList start reqId = " + this.f375237e);
        EdgeGetItemListEvent edgeGetItemListEvent = new EdgeGetItemListEvent(new a());
        edgeGetItemListEvent.requestType = "unexposed_data_source_type";
        edgeGetItemListEvent.reqId = this.f375237e;
        getRouter().f375309g.k(edgeGetItemListEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l0() {
        this.mLog.c(this.f375209k, "EdgeIndependentPolicyRankFlow  getUserInfo start reqId = " + this.f375237e);
        EdgeGetUserInfoEvent edgeGetUserInfoEvent = new EdgeGetUserInfoEvent(new d());
        edgeGetUserInfoEvent.reqId = this.f375237e;
        getRouter().f375309g.k(edgeGetUserInfoEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m0() {
        this.mLog.c(this.f375209k, "policyRank start reqId = " + this.f375237e);
        EdgePolicyRankEvent edgePolicyRankEvent = new EdgePolicyRankEvent(new e());
        edgePolicyRankEvent.reqId = this.f375237e;
        edgePolicyRankEvent.user = this.f375212n;
        edgePolicyRankEvent.itemList = this.f375210l;
        getRouter().f375309g.k(edgePolicyRankEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n0() {
        this.mLog.c(this.f375209k, "EdgeIndependentPolicyRankFlow  selectItem start reqId = " + this.f375237e);
        EdgeSelectItemEvent edgeSelectItemEvent = new EdgeSelectItemEvent(new c());
        edgeSelectItemEvent.reqId = this.f375237e;
        edgeSelectItemEvent.itemList = this.f375210l;
        getRouter().f375309g.k(edgeSelectItemEvent);
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
        if (this.f375210l != null) {
            this.f375210l = null;
        }
        if (this.f375212n != null) {
            this.f375212n = null;
        }
        if (!this.f375211m) {
            r.f375232j.set(false);
        } else {
            this.f375211m = false;
        }
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
        O("tedge_n_independent_policy_start", "tedge_n_independent_policy_finish");
        if (getRouter().f375303a.o()) {
            List<EdgeItem> list = this.f375210l;
            if (list != null && list.size() != 0) {
                j0();
                return;
            } else {
                k0();
                return;
            }
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
        arrayList.add(EdgeIndependentPolicyRankEvent.class);
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
            if (!(fVar instanceof EdgeIndependentPolicyRankEvent)) {
                r.f375232j.set(false);
                return;
            }
        } else {
            this.f375211m = true;
        }
        EdgeIndependentPolicyRankEvent edgeIndependentPolicyRankEvent = (EdgeIndependentPolicyRankEvent) fVar;
        this.f375235c = edgeIndependentPolicyRankEvent.mCallBack;
        this.f375236d = fVar.getAction();
        this.f375210l = edgeIndependentPolicyRankEvent.itemList;
        J(fVar);
        M();
    }
}
