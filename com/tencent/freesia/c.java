package com.tencent.freesia;

import androidx.annotation.Nullable;
import com.tencent.freesia.ReportBridge;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes6.dex */
public final /* synthetic */ class c {
    @Nullable
    public static ReportBridge a() {
        IPatchRedirector iPatchRedirector = ReportBridge.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (ReportBridge) iPatchRedirector.redirect((short) 1);
        }
        return ReportBridge.CppProxy.getInstance();
    }
}
