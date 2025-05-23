package com.tencent.tedger.flow;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tedger.event.EdgePolicyRankEvent;
import com.tencent.tedger.outapi.beans.EdgeItem;
import com.tencent.tedger.outapi.beans.EdgeItemInfer;
import com.tencent.tedger.outapi.beans.EdgeStatus;
import com.tencent.tedger.outapi.beans.EdgeUser;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class n extends r {
    static IPatchRedirector $redirector_;

    /* renamed from: k, reason: collision with root package name */
    public EdgeUser f375228k;

    /* renamed from: l, reason: collision with root package name */
    private List<EdgeItem> f375229l;

    /* renamed from: m, reason: collision with root package name */
    public List<EdgeItemInfer> f375230m;

    public n(com.tencent.tedgecontext.a aVar) {
        super(aVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
        }
    }

    private synchronized void P() {
        int i3;
        EdgeStatus edgeStatus = new EdgeStatus();
        List<EdgeItem> list = this.f375229l;
        List<EdgeItemInfer> list2 = this.f375230m;
        if (this.f375228k != null && list != null && list.size() != 0) {
            com.tencent.tedgecontext.c cVar = this.mLog;
            String str = this.f375233a;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("policyRank start reqId = ");
            sb5.append(this.f375237e);
            sb5.append(" policyItemList = ");
            sb5.append(list.size());
            sb5.append(" policyItemInfers = ");
            if (list2 != null) {
                i3 = list2.size();
            } else {
                i3 = 0;
            }
            sb5.append(i3);
            cVar.c(str, sb5.toString());
            ArrayList<String> rank = getRouter().f375315m.rank(this.f375228k, list, list2, edgeStatus);
            if (edgeStatus.getCode() == 0 && rank != null) {
                this.mLog.c(this.f375233a, "policyRank ok reqId = " + this.f375237e + " rankItems = " + rank.size());
                this.f375235c.a(this.f375237e, edgeStatus, new List[]{rank});
            } else {
                this.mLog.c(this.f375233a, "policyRank fail reqId = " + this.f375237e + " code = " + edgeStatus.getCode() + " msg = " + edgeStatus.getMsg());
                this.f375235c.a(this.f375237e, edgeStatus, null);
            }
            this.f375239g = com.tencent.tedger.utils.a.a(getContext(), edgeStatus);
            H(edgeStatus);
            return;
        }
        this.mLog.c(this.f375233a, "policyRank fail list is null reqId = " + this.f375237e);
        edgeStatus.setCode(-999L);
        this.f375235c.a(this.f375237e, edgeStatus, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.tedger.flow.r
    public void M() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            super.M();
            P();
        }
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
        arrayList.add(EdgePolicyRankEvent.class);
        return arrayList;
    }

    @Override // com.tencent.tedger.outapi.api.g
    public void v(com.tencent.tedger.outapi.api.f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) fVar);
            return;
        }
        if (!getRouter().a() && (fVar instanceof EdgePolicyRankEvent)) {
            EdgePolicyRankEvent edgePolicyRankEvent = (EdgePolicyRankEvent) fVar;
            this.f375235c = edgePolicyRankEvent.mCallBack;
            J(fVar);
            this.f375228k = edgePolicyRankEvent.user;
            this.f375229l = edgePolicyRankEvent.itemList;
            this.f375230m = edgePolicyRankEvent.itemInfers;
            M();
        }
    }
}
