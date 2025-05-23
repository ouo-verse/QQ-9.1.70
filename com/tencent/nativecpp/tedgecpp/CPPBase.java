package com.tencent.nativecpp.tedgecpp;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tedger.outapi.beans.TEdgeRSBase;
import com.tencent.tedger.outapi.jnishare.TEdgeRSSharedBase;
import java.util.List;

/* loaded from: classes21.dex */
public class CPPBase extends TEdgeRSSharedBase {
    static IPatchRedirector $redirector_;

    public CPPBase() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    protected <T extends TEdgeRSBase> long toNative(T t16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this, (Object) t16)).longValue();
        }
        if (t16 == null) {
            return 0L;
        }
        try {
            return t16.getNativePointAndCreateIfNecessary();
        } catch (Throwable unused) {
            return 0L;
        }
    }

    protected <T extends TEdgeRSBase> long[] toNativeArray(List<T> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (long[]) iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
        }
        if (list == null) {
            return new long[0];
        }
        long[] jArr = new long[list.size()];
        for (int i3 = 0; i3 < list.size(); i3++) {
            jArr[i3] = list.get(i3).getNativePointAndCreateIfNecessary();
        }
        return jArr;
    }
}
