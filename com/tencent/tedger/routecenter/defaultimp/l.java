package com.tencent.tedger.routecenter.defaultimp;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tedger.outapi.beans.EdgeItem;
import com.tencent.tedger.outapi.beans.EdgeItemInfer;
import com.tencent.tedger.outapi.beans.EdgeStatus;
import com.tencent.tedger.outapi.beans.EdgeUser;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class l extends h<ve4.e> implements ve4.e {
    static IPatchRedirector $redirector_;

    public l(com.tencent.tedger.routecenter.a aVar) {
        super(aVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
        }
    }

    @Override // com.tencent.tedger.outapi.api.m
    public void init(String str, EdgeStatus edgeStatus) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) edgeStatus);
        } else {
            ((ve4.e) this.f375322c).init(str, edgeStatus);
            I(edgeStatus);
        }
    }

    @Override // com.tencent.tedger.outapi.api.m
    public ArrayList<String> rank(EdgeUser edgeUser, List<EdgeItem> list, List<EdgeItemInfer> list2, EdgeStatus edgeStatus) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ArrayList) iPatchRedirector.redirect((short) 4, this, edgeUser, list, list2, edgeStatus);
        }
        if (v()) {
            return new ArrayList<>();
        }
        ArrayList<String> rank = ((ve4.e) this.f375322c).rank(edgeUser, list, list2, edgeStatus);
        I(edgeStatus);
        return rank;
    }

    @Override // com.tencent.tedger.outapi.api.m
    public int[] select(List<EdgeItem> list, EdgeStatus edgeStatus) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (int[]) iPatchRedirector.redirect((short) 3, (Object) this, (Object) list, (Object) edgeStatus);
        }
        if (v()) {
            return null;
        }
        int[] select = ((ve4.e) this.f375322c).select(list, edgeStatus);
        I(edgeStatus);
        return select;
    }
}
