package com.tencent.tedger.flow;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tedger.event.EdgeFeatureProviderEvent;
import com.tencent.tedger.outapi.beans.EdgeFeatureList;
import com.tencent.tedger.outapi.beans.EdgeItem;
import com.tencent.tedger.outapi.beans.EdgeStatus;
import com.tencent.tedger.outapi.beans.EdgeUser;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class g extends r {
    static IPatchRedirector $redirector_;

    /* renamed from: k, reason: collision with root package name */
    private List<EdgeItem> f375200k;

    /* renamed from: l, reason: collision with root package name */
    private EdgeUser f375201l;

    public g(com.tencent.tedgecontext.a aVar) {
        super(aVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
        }
    }

    private void P() {
        String str;
        EdgeStatus edgeStatus = new EdgeStatus();
        List<EdgeItem> list = this.f375200k;
        if (list != null && list.size() != 0 && this.f375201l != null) {
            List<EdgeFeatureList> parseItemFeatures = getRouter().f375312j.parseItemFeatures(this.f375237e, this.f375200k, edgeStatus);
            if (edgeStatus.getCode() == 0) {
                com.tencent.tedgecontext.c cVar = this.mLog;
                String str2 = this.f375233a;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("featureProvider items ok reqId = ");
                sb5.append(this.f375237e);
                sb5.append(" size = ");
                if (parseItemFeatures != null) {
                    str = parseItemFeatures.size() + "";
                } else {
                    str = "0";
                }
                sb5.append(str);
                cVar.c(str2, sb5.toString());
                EdgeFeatureList parseUserFeatures = getRouter().f375312j.parseUserFeatures(this.f375237e, this.f375201l, edgeStatus);
                if (edgeStatus.getCode() == 0) {
                    this.mLog.c(this.f375233a, "featureProvider user ok reqId = " + this.f375237e);
                    this.f375235c.a(this.f375237e, edgeStatus, new Object[]{parseItemFeatures, parseUserFeatures});
                } else {
                    this.mLog.c(this.f375233a, "featureProvider user fail reqId = " + this.f375237e + " code = " + edgeStatus.getCode() + " msg = " + edgeStatus.getMsg());
                    this.f375235c.a(this.f375237e, edgeStatus, null);
                }
            } else {
                this.mLog.c(this.f375233a, "featureProvider item fail reqId = " + this.f375237e + " code = " + edgeStatus.getCode() + " msg = " + edgeStatus.getMsg());
                this.f375235c.a(this.f375237e, edgeStatus, null);
            }
            L();
            return;
        }
        this.mLog.c(this.f375233a, "featureProvider fail reqId = " + this.f375237e);
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
        arrayList.add(EdgeFeatureProviderEvent.class);
        return arrayList;
    }

    @Override // com.tencent.tedger.outapi.api.g
    public void v(com.tencent.tedger.outapi.api.f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) fVar);
            return;
        }
        if (!getRouter().a() && (fVar instanceof EdgeFeatureProviderEvent)) {
            EdgeFeatureProviderEvent edgeFeatureProviderEvent = (EdgeFeatureProviderEvent) fVar;
            this.f375235c = edgeFeatureProviderEvent.mCallBack;
            J(fVar);
            this.f375200k = edgeFeatureProviderEvent.itemList;
            this.f375201l = edgeFeatureProviderEvent.user;
            M();
        }
    }
}
