package com.tencent.tedger.flow;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tedger.event.EdgeDumpSampleEvent;
import com.tencent.tedger.outapi.beans.EdgePointWiseSample;
import com.tencent.tedger.outapi.beans.EdgeStatus;
import com.tencent.tedger.report.EdgeErrorEvent;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class d extends r {
    static IPatchRedirector $redirector_;

    /* renamed from: k, reason: collision with root package name */
    public String f375196k;

    /* renamed from: l, reason: collision with root package name */
    public List<String> f375197l;

    public d(com.tencent.tedgecontext.a aVar) {
        super(aVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
        }
    }

    private void P() {
        List<String> list;
        EdgeStatus edgeStatus = new EdgeStatus();
        if (!TextUtils.isEmpty(this.f375196k) && (list = this.f375197l) != null && list.size() > 0) {
            this.mLog.c(this.f375233a, "dumpSample  reqId = " + this.f375237e);
            if (getContext().s()) {
                this.mLog.h(this.f375233a, "dumpSample  reqId = " + this.f375237e + " userId = " + this.f375196k + " itemIds = " + this.f375197l.toString());
            }
            List<EdgePointWiseSample> dump = getRouter().f375312j.dump(this.f375237e, this.f375196k, this.f375197l, edgeStatus);
            if (edgeStatus.getCode() == 0 && dump != null && !dump.isEmpty()) {
                this.mLog.c(this.f375233a, "dumpSample ok reqId = " + this.f375237e + " sample size = " + dump.size());
                getRouter().f375306d.G(dump);
            } else {
                this.mLog.c(this.f375233a, "dumpSample fail reqId = " + this.f375237e + " code = " + edgeStatus.getCode() + " msg = " + edgeStatus.getMsg());
                getRouter().f375309g.k(new EdgeErrorEvent(edgeStatus, this.f375237e));
            }
        } else {
            edgeStatus.setCode(-999L);
            edgeStatus.setMsg("dumpSample fail, has wrong param");
            getRouter().f375309g.k(new EdgeErrorEvent(edgeStatus, this.f375237e));
        }
        this.f375235c.a(this.f375237e, edgeStatus, null);
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
        O("tedge_n_dumpsample_start", "tedge_n_dumpsample_finish");
        P();
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
        arrayList.add(EdgeDumpSampleEvent.class);
        return arrayList;
    }

    @Override // com.tencent.tedger.outapi.api.g
    public void v(com.tencent.tedger.outapi.api.f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) fVar);
            return;
        }
        if (!getRouter().a() && (fVar instanceof EdgeDumpSampleEvent)) {
            EdgeDumpSampleEvent edgeDumpSampleEvent = (EdgeDumpSampleEvent) fVar;
            this.f375235c = edgeDumpSampleEvent.mCallBack;
            J(fVar);
            this.f375196k = edgeDumpSampleEvent.userId;
            this.f375197l = edgeDumpSampleEvent.itemIds;
            M();
        }
    }
}
