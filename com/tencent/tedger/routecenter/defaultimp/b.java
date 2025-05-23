package com.tencent.tedger.routecenter.defaultimp;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tedger.outapi.beans.EdgeFeatureList;
import com.tencent.tedger.outapi.beans.EdgeItem;
import com.tencent.tedger.outapi.beans.EdgePointWiseSample;
import com.tencent.tedger.outapi.beans.EdgeStatus;
import com.tencent.tedger.outapi.beans.EdgeUser;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class b extends h<ve4.b> implements ve4.b {
    static IPatchRedirector $redirector_;

    public b(com.tencent.tedger.routecenter.a aVar) {
        super(aVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
        }
    }

    @Override // com.tencent.tedger.outapi.api.k
    public List<EdgePointWiseSample> dump(String str, String str2, List<String> list, EdgeStatus edgeStatus) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, this, str, str2, list, edgeStatus);
        }
        if (v()) {
            return null;
        }
        return ((ve4.b) this.f375322c).dump(str, str2, list, edgeStatus);
    }

    @Override // com.tencent.tedger.outapi.api.k
    public void init(String str, EdgeStatus edgeStatus) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) edgeStatus);
        } else {
            if (v()) {
                return;
            }
            ((ve4.b) this.f375322c).init(str, edgeStatus);
            I(edgeStatus);
        }
    }

    @Override // com.tencent.tedger.outapi.api.k
    public List<EdgeFeatureList> parseItemFeatures(String str, List<EdgeItem> list, EdgeStatus edgeStatus) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, this, str, list, edgeStatus);
        }
        if (v()) {
            return new ArrayList();
        }
        List<EdgeFeatureList> parseItemFeatures = ((ve4.b) this.f375322c).parseItemFeatures(str, list, edgeStatus);
        I(edgeStatus);
        return parseItemFeatures;
    }

    @Override // com.tencent.tedger.outapi.api.k
    public EdgeFeatureList parseUserFeatures(String str, EdgeUser edgeUser, EdgeStatus edgeStatus) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (EdgeFeatureList) iPatchRedirector.redirect((short) 3, this, str, edgeUser, edgeStatus);
        }
        if (v()) {
            return null;
        }
        EdgeFeatureList parseUserFeatures = ((ve4.b) this.f375322c).parseUserFeatures(str, edgeUser, edgeStatus);
        I(edgeStatus);
        return parseUserFeatures;
    }
}
