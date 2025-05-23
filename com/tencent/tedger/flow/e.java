package com.tencent.tedger.flow;

import android.text.TextUtils;
import com.tencent.mobileqq.haoliyou.sso.CheckForwardServlet;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tedger.report.EdgeErrorEvent;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes26.dex */
public class e extends r {
    static IPatchRedirector $redirector_;

    public e(com.tencent.tedgecontext.a aVar) {
        super(aVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
        }
    }

    @Override // com.tencent.tedger.outapi.api.g
    public ArrayList<Integer> getActionType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ArrayList) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f375240h;
    }

    @Override // com.tencent.tedger.outapi.api.g
    public ArrayList<Class> getEventClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ArrayList) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(EdgeErrorEvent.class);
        return arrayList;
    }

    @Override // com.tencent.tedger.outapi.api.g
    public void v(com.tencent.tedger.outapi.api.f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) fVar);
            return;
        }
        if (!getRouter().a() && (fVar instanceof EdgeErrorEvent)) {
            EdgeErrorEvent edgeErrorEvent = (EdgeErrorEvent) fVar;
            getRouter().f375318p.d(this.f375233a, " code = " + edgeErrorEvent.mStatus.getCode() + " msg = " + edgeErrorEvent.mStatus.getMsg());
            this.f375238f.put("event_id", "tedge_n_error_info");
            if (!TextUtils.isEmpty(edgeErrorEvent.getReqId())) {
                this.f375238f.put(CheckForwardServlet.KEY_REQ_ID, edgeErrorEvent.getReqId());
                this.f375237e = edgeErrorEvent.getReqId();
            }
            HashMap<String, String> hashMap = edgeErrorEvent.extraInfo;
            if (hashMap != null && hashMap.size() > 0) {
                getRouter().f375318p.d(this.f375233a, " extraInfo = " + edgeErrorEvent.extraInfo.toString());
                this.f375238f.putAll(edgeErrorEvent.extraInfo);
            }
            M();
            H(edgeErrorEvent.mStatus);
        }
    }
}
