package com.tencent.tedger.outapi.beans;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tedger.outapi.proto.TEdgeEngine$ItemInfer;

/* compiled from: P */
/* loaded from: classes26.dex */
public class EdgeItemInfer extends TEdgeRSBase {
    static IPatchRedirector $redirector_;
    private TEdgeEngine$ItemInfer mItemInfer;

    public EdgeItemInfer(TEdgeEngine$ItemInfer tEdgeEngine$ItemInfer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) tEdgeEngine$ItemInfer);
        } else {
            this.mItemInfer = tEdgeEngine$ItemInfer;
        }
    }

    private native byte[] readItemInferData();

    @Override // com.tencent.tedger.outapi.beans.TEdgeRSBase
    public byte[] readBussinessData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (byte[]) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.mItemInfer.toByteArray();
    }

    public byte[] readNativeData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (byte[]) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        try {
            return readItemInferData();
        } catch (Throwable unused) {
            return null;
        }
    }
}
