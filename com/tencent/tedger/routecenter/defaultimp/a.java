package com.tencent.tedger.routecenter.defaultimp;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tedger.outapi.beans.EdgeFeatureList;
import com.tencent.tedger.outapi.beans.EdgeListWiseSample;
import com.tencent.tedger.outapi.beans.EdgeStatus;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a extends h<ve4.a> implements ve4.a {
    static IPatchRedirector $redirector_;

    public a(com.tencent.tedger.routecenter.a aVar) {
        super(aVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
        }
    }

    @Override // com.tencent.tedger.outapi.api.j
    public EdgeListWiseSample extractFeatures(EdgeFeatureList edgeFeatureList, List<EdgeFeatureList> list, EdgeStatus edgeStatus) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (EdgeListWiseSample) iPatchRedirector.redirect((short) 2, this, edgeFeatureList, list, edgeStatus);
        }
        if (v()) {
            return null;
        }
        EdgeListWiseSample extractFeatures = ((ve4.a) this.f375322c).extractFeatures(edgeFeatureList, list, edgeStatus);
        I(edgeStatus);
        return extractFeatures;
    }

    @Override // com.tencent.tedger.outapi.api.j
    public void init(String str, EdgeStatus edgeStatus) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) edgeStatus);
        } else {
            ((ve4.a) this.f375322c).init(str, edgeStatus);
            I(edgeStatus);
        }
    }
}
