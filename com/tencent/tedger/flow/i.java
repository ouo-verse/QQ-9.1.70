package com.tencent.tedger.flow;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tedger.event.EdgeGetItemListEvent;
import com.tencent.tedger.outapi.beans.EdgeItem;
import com.tencent.tedger.outapi.beans.EdgeStatus;
import com.tencent.tedger.outapi.delegate.d;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes26.dex */
public class i extends r {
    static IPatchRedirector $redirector_;

    /* renamed from: k, reason: collision with root package name */
    private String f375203k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class a implements d.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) i.this);
            }
        }

        @Override // com.tencent.tedger.outapi.delegate.d.a
        public void a(EdgeStatus edgeStatus, List<EdgeItem> list, Map<String, String> map) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, edgeStatus, list, map);
                return;
            }
            if (edgeStatus.getCode() != 0 || list == null || list.size() <= 0) {
                ((com.tencent.tedgecontext.b) i.this).mLog.c(i.this.f375233a, "getItemList fail reqId = " + i.this.f375237e + " code = " + edgeStatus.getCode() + " msg = " + edgeStatus.getMsg());
                i iVar = i.this;
                iVar.f375235c.a(iVar.f375237e, edgeStatus, null);
                return;
            }
            ((com.tencent.tedgecontext.b) i.this).mLog.c(i.this.f375233a, "getItemList ok reqId = " + i.this.f375237e + " requestType = " + i.this.f375203k + " itemList size = " + list.size());
            i iVar2 = i.this;
            iVar2.f375235c.a(iVar2.f375237e, edgeStatus, new Object[]{list});
        }
    }

    public i(com.tencent.tedgecontext.a aVar) {
        super(aVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
        }
    }

    private void S() {
        getRouter().f375308f.E(this.f375203k, new a());
        L();
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
        if (getRouter().f375303a.o()) {
            S();
            return;
        }
        EdgeStatus edgeStatus = new EdgeStatus();
        edgeStatus.setCode(-104L);
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
        arrayList.add(EdgeGetItemListEvent.class);
        return arrayList;
    }

    @Override // com.tencent.tedger.outapi.api.g
    public void v(com.tencent.tedger.outapi.api.f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) fVar);
            return;
        }
        if (!getRouter().a() && (fVar instanceof EdgeGetItemListEvent)) {
            EdgeGetItemListEvent edgeGetItemListEvent = (EdgeGetItemListEvent) fVar;
            this.f375235c = edgeGetItemListEvent.mCallBack;
            this.f375203k = edgeGetItemListEvent.requestType;
            J(fVar);
            M();
        }
    }
}
