package com.tencent.tedger.outapi.beans;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tedger.outapi.proto.TEdgeSample$ListWiseSample;

/* compiled from: P */
/* loaded from: classes26.dex */
public class EdgeListWiseSample extends TEdgeRSBase {
    static IPatchRedirector $redirector_;
    private TEdgeSample$ListWiseSample mSample;

    public EdgeListWiseSample(TEdgeSample$ListWiseSample tEdgeSample$ListWiseSample) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) tEdgeSample$ListWiseSample);
        } else {
            this.mSample = tEdgeSample$ListWiseSample;
        }
    }

    private native byte[] readSampleData();

    @Override // com.tencent.tedger.outapi.beans.TEdgeRSBase
    public byte[] readBussinessData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (byte[]) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.mSample.toByteArray();
    }

    public byte[] readNativeData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (byte[]) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        try {
            return readSampleData();
        } catch (Throwable unused) {
            return null;
        }
    }
}
