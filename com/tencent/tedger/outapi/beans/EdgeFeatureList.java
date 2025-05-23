package com.tencent.tedger.outapi.beans;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tedger.outapi.proto.TEdgeFeature$FeatureList;

/* compiled from: P */
/* loaded from: classes26.dex */
public class EdgeFeatureList extends TEdgeRSBase {
    static IPatchRedirector $redirector_;
    private TEdgeFeature$FeatureList mFeatureList;

    public EdgeFeatureList(TEdgeFeature$FeatureList tEdgeFeature$FeatureList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) tEdgeFeature$FeatureList);
        } else {
            this.mFeatureList = tEdgeFeature$FeatureList;
        }
    }

    private native byte[] readFeatureListData();

    @Override // com.tencent.tedger.outapi.beans.TEdgeRSBase
    public byte[] readBussinessData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (byte[]) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.mFeatureList.toByteArray();
    }

    public byte[] readNativeData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (byte[]) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        try {
            return readFeatureListData();
        } catch (Throwable unused) {
            return null;
        }
    }
}
