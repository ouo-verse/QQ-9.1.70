package com.tencent.tedger.outapi.beans;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tedger.outapi.proto.TEdgeSample$PointWiseSample;

/* loaded from: classes26.dex */
public class EdgePointWiseSample extends TEdgeRSBase {
    static IPatchRedirector $redirector_;
    public boolean hasUsed;
    private TEdgeSample$PointWiseSample mSample;

    public EdgePointWiseSample(TEdgeSample$PointWiseSample tEdgeSample$PointWiseSample) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) tEdgeSample$PointWiseSample);
        } else {
            this.hasUsed = false;
            this.mSample = tEdgeSample$PointWiseSample;
        }
    }

    private native byte[] readSampleData();

    public TEdgeSample$PointWiseSample getData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (TEdgeSample$PointWiseSample) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mSample;
    }

    public boolean getHasUsed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.hasUsed;
    }

    @Override // com.tencent.tedger.outapi.beans.TEdgeRSBase
    public byte[] readBussinessData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (byte[]) iPatchRedirector.redirect((short) 6, (Object) this);
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

    public void setData(TEdgeSample$PointWiseSample tEdgeSample$PointWiseSample) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) tEdgeSample$PointWiseSample);
        } else {
            this.mSample = tEdgeSample$PointWiseSample;
        }
    }
}
