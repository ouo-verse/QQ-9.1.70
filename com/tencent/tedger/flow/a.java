package com.tencent.tedger.flow;

import com.tencent.mobileqq.haoliyou.sso.CheckForwardServlet;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tedger.event.EdgeClientRankEvent;
import com.tencent.tedger.event.EdgeDumpSampleEvent;
import com.tencent.tedger.event.EdgeFeatureExtractorEvent;
import com.tencent.tedger.event.EdgeFeatureProviderEvent;
import com.tencent.tedger.event.EdgeGetItemListEvent;
import com.tencent.tedger.event.EdgeGetUserInfoEvent;
import com.tencent.tedger.event.EdgeInferEvent;
import com.tencent.tedger.event.EdgePolicyRankEvent;
import com.tencent.tedger.event.EdgeSelectItemEvent;
import com.tencent.tedger.outapi.beans.EdgeFeatureList;
import com.tencent.tedger.outapi.beans.EdgeItem;
import com.tencent.tedger.outapi.beans.EdgeItemInfer;
import com.tencent.tedger.outapi.beans.EdgeListWiseSample;
import com.tencent.tedger.outapi.beans.EdgeStatus;
import com.tencent.tedger.outapi.beans.EdgeUser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a extends r {
    static IPatchRedirector $redirector_;

    /* renamed from: k, reason: collision with root package name */
    public String f375167k;

    /* renamed from: l, reason: collision with root package name */
    private List<EdgeItem> f375168l;

    /* renamed from: m, reason: collision with root package name */
    private EdgeUser f375169m;

    /* renamed from: n, reason: collision with root package name */
    private List<EdgeFeatureList> f375170n;

    /* renamed from: o, reason: collision with root package name */
    private EdgeFeatureList f375171o;

    /* renamed from: p, reason: collision with root package name */
    private EdgeListWiseSample f375172p;

    /* renamed from: q, reason: collision with root package name */
    private List<EdgeItemInfer> f375173q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f375174r;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.tedger.flow.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public class C9897a implements com.tencent.tedger.outapi.api.h {
        static IPatchRedirector $redirector_;

        C9897a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
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
                ((com.tencent.tedgecontext.b) a.this).mLog.c(a.this.f375167k, "getUnexposedItemList fail reqId = " + str + " code = " + edgeStatus.getCode() + " msg = " + edgeStatus.getMsg());
                a.this.f375235c.a(str, edgeStatus, null);
                a.this.H(edgeStatus);
                return;
            }
            if (objArr != null && (obj = objArr[0]) != null) {
                List list = (List) obj;
                ((com.tencent.tedgecontext.b) a.this).mLog.c(a.this.f375167k, "getUnexposedItemList ok reqId = " + str + " result size = " + list.size());
                a.this.f375168l = list;
                a.this.C0();
                return;
            }
            edgeStatus.setCode(-102L);
            ((com.tencent.tedgecontext.b) a.this).mLog.c(a.this.f375167k, "getUnexposedItemList fail reqId = " + str + " code = " + edgeStatus.getCode() + " msg = " + edgeStatus.getMsg());
            a.this.f375235c.a(str, edgeStatus, null);
            a.this.f375238f.put(CheckForwardServlet.KEY_ERR_CODE, Long.valueOf(edgeStatus.getCode()));
            a.this.f375238f.put("err_msg", edgeStatus.getMsg());
            a.this.H(edgeStatus);
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
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
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
                ((com.tencent.tedgecontext.b) a.this).mLog.c(a.this.f375167k, "getCandidatePoolItemList fail reqId = " + str + " code = " + edgeStatus.getCode() + " msg = " + edgeStatus.getMsg());
                a.this.f375235c.a(str, edgeStatus, null);
                a.this.H(edgeStatus);
                return;
            }
            List list = (List) obj;
            if (list != null && list.size() > 0) {
                ((com.tencent.tedgecontext.b) a.this).mLog.c(a.this.f375167k, "getCandidatePoolItemList ok reqId = " + str + " result size = " + list.size());
                if (a.this.f375168l == null) {
                    a.this.f375168l = new ArrayList();
                }
                a.this.f375168l.addAll(list);
            }
            a.this.H0();
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
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
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
                ((com.tencent.tedgecontext.b) a.this).mLog.c(a.this.f375167k, "selectItem fail reqId = " + str + " code = " + edgeStatus.getCode() + " msg = " + edgeStatus.getMsg());
                a.this.f375235c.a(str, edgeStatus, null);
                a.this.H(edgeStatus);
                return;
            }
            List list = (List) obj;
            if (list != null && list.size() > 0) {
                ((com.tencent.tedgecontext.b) a.this).mLog.c(a.this.f375167k, "selectItem ok reqId = " + str + " result size = " + list.size());
                a.this.f375168l = list;
            }
            a.this.E0();
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
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
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
                ((com.tencent.tedgecontext.b) a.this).mLog.c(a.this.f375167k, "getUserInfo fail reqId = " + str + " code = " + edgeStatus.getCode() + " msg = " + edgeStatus.getMsg());
                a.this.f375235c.a(str, edgeStatus, null);
                a.this.H(edgeStatus);
                return;
            }
            Object obj = objArr[0];
            if (obj != null) {
                ((com.tencent.tedgecontext.b) a.this).mLog.c(a.this.f375167k, "getUserInfo ok reqId = " + str);
                a.this.f375169m = (EdgeUser) obj;
                a.this.B0();
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
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // com.tencent.tedger.outapi.api.h
        public void a(String str, EdgeStatus edgeStatus, Object[] objArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, edgeStatus, objArr);
                return;
            }
            if (edgeStatus.getCode() != 0 || objArr == null || objArr.length != 2 || objArr[0] == null || objArr[1] == null) {
                ((com.tencent.tedgecontext.b) a.this).mLog.c(a.this.f375167k, "featureProvider fail reqId = " + str + " code = " + edgeStatus.getCode() + " msg = " + edgeStatus.getMsg());
                a.this.f375235c.a(str, edgeStatus, null);
                a.this.H(edgeStatus);
                return;
            }
            ((com.tencent.tedgecontext.b) a.this).mLog.c(a.this.f375167k, "featureProvider ok reqId = " + str);
            a.this.f375170n = (List) objArr[0];
            a.this.f375171o = (EdgeFeatureList) objArr[1];
            a.this.A0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class f implements com.tencent.tedger.outapi.api.h {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // com.tencent.tedger.outapi.api.h
        public void a(String str, EdgeStatus edgeStatus, Object[] objArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, edgeStatus, objArr);
                return;
            }
            if (edgeStatus.getCode() != 0 || objArr == null || objArr[0] == null) {
                ((com.tencent.tedgecontext.b) a.this).mLog.c(a.this.f375167k, "featureExtractor fail reqId = " + str + " code = " + edgeStatus.getCode() + " msg = " + edgeStatus.getMsg());
                a.this.f375235c.a(str, edgeStatus, null);
                a.this.H(edgeStatus);
                return;
            }
            ((com.tencent.tedgecontext.b) a.this).mLog.c(a.this.f375167k, "featureExtractor ok reqId = " + str);
            a.this.f375172p = (EdgeListWiseSample) objArr[0];
            a.this.F0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class g implements com.tencent.tedger.outapi.api.h {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // com.tencent.tedger.outapi.api.h
        public void a(String str, EdgeStatus edgeStatus, Object[] objArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, edgeStatus, objArr);
                return;
            }
            if (edgeStatus.getCode() != 0 || objArr == null) {
                ((com.tencent.tedgecontext.b) a.this).mLog.c(a.this.f375167k, "infer fail reqId = " + str + " code = " + edgeStatus.getCode() + " msg = " + edgeStatus.getMsg());
                a.this.f375235c.a(str, edgeStatus, null);
                a.this.H(edgeStatus);
                return;
            }
            a.this.f375173q = (List) objArr[0];
            ((com.tencent.tedgecontext.b) a.this).mLog.c(a.this.f375167k, "infer ok reqId = " + str + " itemInfers size = " + a.this.f375173q.size());
            a.this.G0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class h implements com.tencent.tedger.outapi.api.h {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
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
                ((com.tencent.tedgecontext.b) a.this).mLog.c(a.this.f375167k, "policyRank fail reqId = " + str + " code = " + edgeStatus.getCode() + " msg = " + edgeStatus.getMsg());
                com.tencent.tedger.outapi.api.h hVar = a.this.f375235c;
                if (hVar != null) {
                    hVar.a(str, edgeStatus, null);
                }
                a.this.H(edgeStatus);
                return;
            }
            List<String> list = (List) obj;
            ArrayList arrayList = new ArrayList();
            if (list == null || list.size() <= 0 || a.this.f375168l == null || a.this.f375168l.size() <= 0) {
                ((com.tencent.tedgecontext.b) a.this).mLog.c(a.this.f375167k, "policyRank fail reqId = " + str + " code = " + edgeStatus.getCode() + " msg = " + edgeStatus.getMsg());
                com.tencent.tedger.outapi.api.h hVar2 = a.this.f375235c;
                if (hVar2 != null) {
                    hVar2.a(str, edgeStatus, null);
                }
                a.this.H(edgeStatus);
                return;
            }
            ((com.tencent.tedgecontext.b) a.this).mLog.c(a.this.f375167k, "policyRank ok reqId = " + str + " itemIds = " + list.size());
            for (String str2 : list) {
                Iterator it = a.this.f375168l.iterator();
                while (true) {
                    if (it.hasNext()) {
                        EdgeItem edgeItem = (EdgeItem) it.next();
                        if (str2.equals(edgeItem.getItemID())) {
                            arrayList.add(edgeItem);
                            break;
                        }
                    }
                }
            }
            a aVar = a.this;
            com.tencent.tedger.outapi.api.h hVar3 = aVar.f375235c;
            if (hVar3 != null) {
                hVar3.a(str, edgeStatus, new List[]{arrayList});
            } else {
                aVar.getContext().k().a(str, a.this.f375236d, arrayList);
            }
            a.this.z0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class i implements com.tencent.tedger.outapi.api.h {
        static IPatchRedirector $redirector_;

        i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
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
                ((com.tencent.tedgecontext.b) a.this).mLog.c(a.this.f375167k, "dumpSample ok reqId = " + str);
            } else {
                ((com.tencent.tedgecontext.b) a.this).mLog.c(a.this.f375167k, "dumpSample fail reqId = " + str + " code = " + edgeStatus.getCode() + " msg = " + edgeStatus.getMsg());
            }
            a.this.H(edgeStatus);
        }
    }

    public a(com.tencent.tedgecontext.a aVar) {
        super(aVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
        } else {
            this.f375167k = "EdgeClientRankFlow";
            this.f375174r = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0() {
        this.mLog.c(this.f375167k, "featureExtractor start reqId = " + this.f375237e);
        EdgeFeatureExtractorEvent edgeFeatureExtractorEvent = new EdgeFeatureExtractorEvent(new f());
        edgeFeatureExtractorEvent.reqId = this.f375237e;
        edgeFeatureExtractorEvent.userFeature = this.f375171o;
        edgeFeatureExtractorEvent.itemFeatures = this.f375170n;
        getRouter().f375309g.k(edgeFeatureExtractorEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B0() {
        this.mLog.c(this.f375167k, "EdgeClientRankEvent  featureProvider start reqId = " + this.f375237e);
        EdgeFeatureProviderEvent edgeFeatureProviderEvent = new EdgeFeatureProviderEvent(new e());
        edgeFeatureProviderEvent.itemList = this.f375168l;
        edgeFeatureProviderEvent.reqId = this.f375237e;
        edgeFeatureProviderEvent.user = this.f375169m;
        getRouter().f375309g.k(edgeFeatureProviderEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C0() {
        this.mLog.c(this.f375167k, "getCandidatePoolItemList start reqId = " + this.f375237e);
        EdgeGetItemListEvent edgeGetItemListEvent = new EdgeGetItemListEvent(new b());
        edgeGetItemListEvent.requestType = "client_rerank_data_source_type";
        edgeGetItemListEvent.reqId = this.f375237e;
        getRouter().f375309g.k(edgeGetItemListEvent);
    }

    private void D0() {
        this.mLog.c(this.f375167k, "EdgeClientRankEvent  getUnexposedItemList start reqId = " + this.f375237e);
        EdgeGetItemListEvent edgeGetItemListEvent = new EdgeGetItemListEvent(new C9897a());
        edgeGetItemListEvent.requestType = "unexposed_data_source_type";
        edgeGetItemListEvent.reqId = this.f375237e;
        getRouter().f375309g.k(edgeGetItemListEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E0() {
        this.mLog.c(this.f375167k, "EdgeClientRankEvent  getUserInfo start reqId = " + this.f375237e);
        EdgeGetUserInfoEvent edgeGetUserInfoEvent = new EdgeGetUserInfoEvent(new d());
        edgeGetUserInfoEvent.reqId = this.f375237e;
        getRouter().f375309g.k(edgeGetUserInfoEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F0() {
        this.mLog.c(this.f375167k, "infer start reqId = " + this.f375237e);
        EdgeInferEvent edgeInferEvent = new EdgeInferEvent(new g());
        edgeInferEvent.reqId = this.f375237e;
        edgeInferEvent.sample = this.f375172p;
        getRouter().f375309g.k(edgeInferEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G0() {
        this.mLog.c(this.f375167k, "policyRank start reqId = " + this.f375237e);
        EdgePolicyRankEvent edgePolicyRankEvent = new EdgePolicyRankEvent(new h());
        edgePolicyRankEvent.reqId = this.f375237e;
        edgePolicyRankEvent.user = this.f375169m;
        edgePolicyRankEvent.itemInfers = this.f375173q;
        edgePolicyRankEvent.itemList = this.f375168l;
        getRouter().f375309g.k(edgePolicyRankEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H0() {
        this.mLog.c(this.f375167k, "EdgeClientRankEvent  selectItem start reqId = " + this.f375237e);
        EdgeSelectItemEvent edgeSelectItemEvent = new EdgeSelectItemEvent(new c());
        edgeSelectItemEvent.reqId = this.f375237e;
        edgeSelectItemEvent.itemList = this.f375168l;
        getRouter().f375309g.k(edgeSelectItemEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0() {
        this.mLog.c(this.f375167k, "EdgeClientRankEvent  policyRank start reqId = " + this.f375237e);
        EdgeDumpSampleEvent edgeDumpSampleEvent = new EdgeDumpSampleEvent(new i());
        edgeDumpSampleEvent.reqId = this.f375237e;
        edgeDumpSampleEvent.userId = this.f375169m.getUserID();
        ArrayList arrayList = new ArrayList();
        List<EdgeItem> list = this.f375168l;
        if (list != null) {
            Iterator<EdgeItem> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getItemID());
            }
        }
        edgeDumpSampleEvent.itemIds = arrayList;
        getRouter().f375309g.k(edgeDumpSampleEvent);
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
        if (this.f375168l != null) {
            this.f375168l = null;
        }
        if (this.f375169m != null) {
            this.f375169m = null;
        }
        if (this.f375170n != null) {
            this.f375170n = null;
        }
        if (this.f375171o != null) {
            this.f375171o = null;
        }
        if (this.f375172p != null) {
            this.f375172p = null;
        }
        if (this.f375173q != null) {
            this.f375173q = null;
        }
        if (!this.f375174r) {
            r.f375232j.set(false);
        } else {
            this.f375174r = false;
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
        O("tedge_n_client_rerank_start", "tedge_n_client_rerank_finish");
        if (getRouter().f375303a.o()) {
            List<EdgeItem> list = this.f375168l;
            if (list != null && list.size() != 0) {
                C0();
                return;
            } else {
                D0();
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
        arrayList.add(EdgeClientRankEvent.class);
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
            if (!(fVar instanceof EdgeClientRankEvent)) {
                r.f375232j.set(false);
                return;
            }
        } else {
            this.f375174r = true;
        }
        EdgeClientRankEvent edgeClientRankEvent = (EdgeClientRankEvent) fVar;
        this.f375235c = edgeClientRankEvent.mCallBack;
        J(fVar);
        this.f375168l = edgeClientRankEvent.itemList;
        this.f375236d = fVar.getAction();
        M();
    }
}
