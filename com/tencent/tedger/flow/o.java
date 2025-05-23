package com.tencent.tedger.flow;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tedger.event.EdgeSelectItemEvent;
import com.tencent.tedger.outapi.beans.EdgeItem;
import com.tencent.tedger.outapi.beans.EdgeStatus;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class o extends r {
    static IPatchRedirector $redirector_;

    /* renamed from: k, reason: collision with root package name */
    private List<EdgeItem> f375231k;

    public o(com.tencent.tedgecontext.a aVar) {
        super(aVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
        }
    }

    private void P() {
        EdgeStatus edgeStatus = new EdgeStatus();
        List<EdgeItem> list = this.f375231k;
        if (list != null && list.size() != 0) {
            this.mLog.d(this.f375233a, "needselect itemList size:" + this.f375231k.size());
            int[] select = getRouter().f375315m.select(this.f375231k, edgeStatus);
            if (edgeStatus.getCode() == 0) {
                if (select != null && select.length != 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i3 : select) {
                        if (i3 < this.f375231k.size() && i3 >= 0) {
                            arrayList.add(this.f375231k.get(i3));
                        } else {
                            this.mLog.h(this.f375233a, "select item is null");
                            edgeStatus.setCode(-100L);
                            this.f375235c.a(this.f375237e, edgeStatus, null);
                            break;
                        }
                    }
                    this.f375235c.a(this.f375237e, edgeStatus, new List[]{arrayList});
                } else {
                    this.mLog.h(this.f375233a, "select item is null");
                    edgeStatus.setCode(-999L);
                    this.f375235c.a(this.f375237e, edgeStatus, null);
                }
            } else {
                this.mLog.h(this.f375233a, "select item is fail code = " + edgeStatus.getCode() + " msg = " + edgeStatus.getMsg());
                this.f375235c.a(this.f375237e, edgeStatus, null);
            }
        } else {
            this.mLog.h(this.f375233a, "itemList is null");
            edgeStatus.setCode(-999L);
            this.f375235c.a(this.f375237e, edgeStatus, null);
        }
        H(edgeStatus);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.tedger.flow.r
    public void H(EdgeStatus edgeStatus) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) edgeStatus);
        } else {
            super.H(edgeStatus);
            this.f375231k = null;
        }
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
        arrayList.add(EdgeSelectItemEvent.class);
        return arrayList;
    }

    @Override // com.tencent.tedger.outapi.api.g
    public void v(com.tencent.tedger.outapi.api.f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) fVar);
            return;
        }
        if (!getRouter().a() && (fVar instanceof EdgeSelectItemEvent)) {
            EdgeSelectItemEvent edgeSelectItemEvent = (EdgeSelectItemEvent) fVar;
            this.f375235c = edgeSelectItemEvent.mCallBack;
            this.f375231k = edgeSelectItemEvent.itemList;
            J(fVar);
            M();
        }
    }
}
