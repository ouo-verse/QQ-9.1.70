package com.tencent.tedger.flow;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tedger.event.EdgeCloudRankEvent;
import com.tencent.tedger.event.EdgeGetItemListEvent;
import com.tencent.tedger.outapi.beans.EdgeAction;
import com.tencent.tedger.outapi.beans.EdgeItem;
import com.tencent.tedger.outapi.beans.EdgeStatus;
import com.tencent.tedger.outapi.delegate.d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes26.dex */
public class c extends r {
    static IPatchRedirector $redirector_;

    /* renamed from: k, reason: collision with root package name */
    public String f375188k;

    /* renamed from: l, reason: collision with root package name */
    private List<EdgeItem> f375189l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f375190m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class a implements com.tencent.tedger.outapi.api.h {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
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
                ((com.tencent.tedgecontext.b) c.this).mLog.c(c.this.f375188k, "getUnexposedItemList fail reqId = " + str + " code = " + edgeStatus.getCode() + " msg = " + edgeStatus.getMsg());
                c.this.f375235c.a(str, edgeStatus, null);
                c.this.H(edgeStatus);
                return;
            }
            Object obj = objArr[0];
            if (obj == null || !(obj instanceof List)) {
                ((com.tencent.tedgecontext.b) c.this).mLog.c(c.this.f375188k, "getUnexposedItemList results size 0 fail reqId = " + str);
                edgeStatus.setCode(-102L);
                c.this.f375235c.a(str, edgeStatus, null);
                c.this.H(edgeStatus);
                return;
            }
            List list = (List) obj;
            ((com.tencent.tedgecontext.b) c.this).mLog.c(c.this.f375188k, "getUnexposedItemList ok reqId = " + str + " size = " + list.size());
            c.this.f375189l = list;
            c.this.V();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class b implements d.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ EdgeStatus[] f375192a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ List[] f375193b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ CountDownLatch f375194c;

        b(EdgeStatus[] edgeStatusArr, List[] listArr, CountDownLatch countDownLatch) {
            this.f375192a = edgeStatusArr;
            this.f375193b = listArr;
            this.f375194c = countDownLatch;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, c.this, edgeStatusArr, listArr, countDownLatch);
            }
        }

        @Override // com.tencent.tedger.outapi.delegate.d.a
        public void a(EdgeStatus edgeStatus, List<EdgeItem> list, Map<String, String> map) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, edgeStatus, list, map);
                return;
            }
            this.f375192a[0] = edgeStatus;
            this.f375193b[0] = list;
            ((com.tencent.tedgecontext.b) c.this).mLog.c(c.this.f375188k, "cloudRank sever call back reqId = " + c.this.f375237e);
            this.f375194c.countDown();
        }
    }

    public c(com.tencent.tedgecontext.a aVar) {
        super(aVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
        } else {
            this.f375188k = "EdgeCloudRankFlow";
            this.f375190m = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V() {
        this.mLog.c(this.f375188k, "cloudRank start reqId = " + this.f375237e);
        HashMap hashMap = new HashMap();
        EdgeAction edgeAction = this.f375236d;
        if (edgeAction != null) {
            hashMap.put("trigger_user_action", edgeAction);
        } else {
            this.mLog.c(this.f375188k, "cloudRank mAction is null");
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        EdgeStatus[] edgeStatusArr = new EdgeStatus[1];
        List<EdgeItem>[] listArr = {null};
        getRouter().f375308f.n(this.f375189l, hashMap, new b(edgeStatusArr, listArr, countDownLatch));
        EdgeStatus edgeStatus = new EdgeStatus();
        try {
            if (countDownLatch.await(3L, TimeUnit.SECONDS)) {
                W(edgeStatusArr[0], listArr[0]);
                edgeStatus = edgeStatusArr[0];
            } else {
                this.mLog.c(this.f375188k, "cloudRank timeout fail reqId = " + this.f375237e);
                if (this.f375235c != null) {
                    edgeStatus.setCode(-113L);
                    edgeStatusArr[0] = edgeStatus;
                    W(edgeStatus, null);
                }
            }
        } catch (Exception e16) {
            this.mLog.c(this.f375188k, "cloudRank crash fail reqId = " + this.f375237e + " e = " + e16);
            if (this.f375235c != null) {
                edgeStatus.setCode(-114L);
                this.f375235c.a(this.f375237e, edgeStatus, null);
            }
        }
        H(edgeStatus);
    }

    private void W(EdgeStatus edgeStatus, List<EdgeItem> list) {
        if (edgeStatus != null && edgeStatus.getCode() == 0 && list != null && list.size() > 0) {
            this.mLog.c(this.f375188k, "cloudRank ok reqId = " + this.f375237e + " size = " + list.size() + " isSubFlow = " + this.f375190m);
            List<EdgeItem> list2 = this.f375189l;
            if (list2 != null && list2.size() > 0) {
                for (EdgeItem edgeItem : list) {
                    if (edgeItem != null) {
                        this.f375189l.add(edgeItem);
                    }
                }
            } else {
                this.mLog.c(this.f375188k, "cloudRank ok reqId = " + this.f375237e + " itemList is null");
            }
            if (this.f375190m) {
                com.tencent.tedger.outapi.api.h hVar = this.f375235c;
                if (hVar != null) {
                    hVar.a(this.f375237e, edgeStatus, new List[]{this.f375189l});
                    return;
                } else {
                    getContext().k().a(this.f375237e, this.f375236d, this.f375189l);
                    return;
                }
            }
            com.tencent.tedger.outapi.api.h hVar2 = this.f375235c;
            if (hVar2 != null) {
                hVar2.a(this.f375237e, edgeStatus, new List[]{list});
                return;
            } else {
                getContext().k().a(this.f375237e, this.f375236d, list);
                return;
            }
        }
        if (this.f375190m) {
            edgeStatus.setCode(0L);
            if (this.f375235c != null && this.f375189l != null) {
                this.mLog.c(this.f375188k, "cloudRank isSubFlow fail callback reqId = " + this.f375237e + " status = " + edgeStatus.getCode() + " itemList = " + this.f375189l.size());
                this.f375235c.a(this.f375237e, edgeStatus, new List[]{this.f375189l});
                return;
            }
            this.mLog.c(this.f375188k, "cloudRank isSubFlow fail no callback reqId= " + this.f375237e + " status = " + edgeStatus.getCode() + " list = " + list);
            return;
        }
        this.mLog.c(this.f375188k, "cloudRank fail reqId = " + this.f375237e + " code = " + edgeStatus.getCode() + " msg = " + edgeStatus.getMsg() + " list = " + list);
        if (edgeStatus.getCode() == 0) {
            edgeStatus.setCode(-112L);
        }
        com.tencent.tedger.outapi.api.h hVar3 = this.f375235c;
        if (hVar3 != null) {
            hVar3.a(this.f375237e, edgeStatus, null);
        } else {
            getContext().k().a(this.f375237e, this.f375236d, null);
        }
    }

    private void X() {
        this.mLog.c(this.f375188k, "getUnexposedItemList start reqId = " + this.f375237e);
        EdgeGetItemListEvent edgeGetItemListEvent = new EdgeGetItemListEvent(new a());
        edgeGetItemListEvent.requestType = "unexposed_data_source_type";
        edgeGetItemListEvent.reqId = this.f375237e;
        getRouter().f375309g.k(edgeGetItemListEvent);
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
        this.f375189l = null;
        if (!this.f375190m) {
            r.f375232j.set(false);
        } else {
            this.f375190m = false;
        }
        this.f375189l = null;
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
        O("tedge_n_cloud_rerank_start", "tedge_n_cloud_rerank_finish");
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
        arrayList.add(EdgeCloudRankEvent.class);
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
            if (!(fVar instanceof EdgeCloudRankEvent)) {
                r.f375232j.set(false);
                return;
            }
        } else {
            this.f375190m = true;
        }
        this.f375235c = ((EdgeCloudRankEvent) fVar).mCallBack;
        this.f375236d = fVar.getAction();
        J(fVar);
        M();
    }
}
