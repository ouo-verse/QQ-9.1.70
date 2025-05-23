package com.tencent.tedger.flow;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tedger.event.EdgeFeatureExtractorEvent;
import com.tencent.tedger.outapi.beans.EdgeFeatureList;
import com.tencent.tedger.outapi.beans.EdgeListWiseSample;
import com.tencent.tedger.outapi.beans.EdgeStatus;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class f extends r {
    static IPatchRedirector $redirector_;

    /* renamed from: k, reason: collision with root package name */
    public List<EdgeFeatureList> f375198k;

    /* renamed from: l, reason: collision with root package name */
    public EdgeFeatureList f375199l;

    public f(com.tencent.tedgecontext.a aVar) {
        super(aVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
        }
    }

    private void P() {
        List<EdgeFeatureList> list;
        EdgeStatus edgeStatus = new EdgeStatus();
        if (this.f375199l != null && (list = this.f375198k) != null && list.size() != 0) {
            EdgeListWiseSample extractFeatures = getRouter().f375311i.extractFeatures(this.f375199l, this.f375198k, edgeStatus);
            if (edgeStatus.getCode() == 0 && extractFeatures != null) {
                this.mLog.c(this.f375233a, "featureExtractor ok reqId = " + this.f375237e);
                this.f375235c.a(this.f375237e, edgeStatus, new Object[]{extractFeatures});
            } else {
                this.mLog.c(this.f375233a, "featureExtractor fail reqId = " + this.f375237e + " code = " + edgeStatus.getCode() + " msg = " + edgeStatus.getMsg());
                this.f375235c.a(this.f375237e, edgeStatus, null);
            }
            L();
            return;
        }
        this.mLog.c(this.f375233a, "featureExtractor item is null fail reqId = " + this.f375237e);
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
        arrayList.add(EdgeFeatureExtractorEvent.class);
        return arrayList;
    }

    @Override // com.tencent.tedger.outapi.api.g
    public void v(com.tencent.tedger.outapi.api.f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) fVar);
            return;
        }
        if (!getRouter().a() && (fVar instanceof EdgeFeatureExtractorEvent)) {
            synchronized (this) {
                EdgeFeatureExtractorEvent edgeFeatureExtractorEvent = (EdgeFeatureExtractorEvent) fVar;
                this.f375235c = edgeFeatureExtractorEvent.mCallBack;
                J(fVar);
                this.f375198k = edgeFeatureExtractorEvent.itemFeatures;
                this.f375199l = edgeFeatureExtractorEvent.userFeature;
                M();
            }
        }
    }
}
