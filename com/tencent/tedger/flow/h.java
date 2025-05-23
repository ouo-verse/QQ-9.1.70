package com.tencent.tedger.flow;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tedger.event.EdgeFeedBackEvent;
import com.tencent.tedger.outapi.beans.EdgePointWiseSample;
import com.tencent.tedger.outapi.beans.EdgeStatus;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class h extends r {
    static IPatchRedirector $redirector_;

    /* renamed from: k, reason: collision with root package name */
    private List<EdgePointWiseSample> f375202k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(com.tencent.tedgecontext.a aVar) {
        super(aVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
        }
    }

    private void P() {
        EdgeStatus edgeStatus = new EdgeStatus();
        List<EdgePointWiseSample> list = this.f375202k;
        if (list != null && list.size() != 0) {
            this.f375202k = getRouter().f375317o.convertFeedBack(this.f375202k, edgeStatus);
            if (edgeStatus.getCode() == 0) {
                this.mLog.c(this.f375233a, "feedBack ok reqId = " + this.f375237e);
                this.f375235c.a(this.f375237e, edgeStatus, new Object[]{this.f375202k});
                return;
            }
            this.mLog.c(this.f375233a, "feedBack fail reqId = " + this.f375237e + " code = " + edgeStatus.getCode() + " msg = " + edgeStatus.getMsg());
            this.f375235c.a(this.f375237e, edgeStatus, null);
            return;
        }
        this.mLog.c(this.f375233a, "feedBack fail samples is null reqId = " + this.f375237e);
        edgeStatus.setCode(-999L);
        this.f375235c.a(this.f375237e, edgeStatus, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.tedger.flow.r
    public void M() {
        List<EdgePointWiseSample> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.M();
        if (getRouter().f375304b.j() && (list = this.f375202k) != null && list.size() > 0) {
            P();
            return;
        }
        getRouter().f375318p.d(this.f375233a, "EdgeFeedBackFlow run closeTrain or samples is null");
        EdgeStatus edgeStatus = new EdgeStatus();
        edgeStatus.setCode(-111L);
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
        arrayList.add(EdgeFeedBackEvent.class);
        return arrayList;
    }

    @Override // com.tencent.tedger.outapi.api.g
    public void v(com.tencent.tedger.outapi.api.f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) fVar);
            return;
        }
        if (!getRouter().a() && (fVar instanceof EdgeFeedBackEvent)) {
            EdgeFeedBackEvent edgeFeedBackEvent = (EdgeFeedBackEvent) fVar;
            this.f375235c = edgeFeedBackEvent.mCallBack;
            this.f375202k = edgeFeedBackEvent.samples;
            J(fVar);
            M();
        }
    }
}
