package com.tencent.mobileqq.msfcore;

import androidx.annotation.Nullable;
import com.tencent.mobileqq.msfcore.MSFKernelBridge;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public final /* synthetic */ class a {
    @Nullable
    public static MSFKernelBridge a(@Nullable UpperBridges upperBridges, boolean z16) {
        IPatchRedirector iPatchRedirector = MSFKernelBridge.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (MSFKernelBridge) iPatchRedirector.redirect((short) 1, (Object) upperBridges, z16);
        }
        return MSFKernelBridge.CppProxy.create(upperBridges, z16);
    }

    @Nullable
    public static MSFKernelBridge b() {
        IPatchRedirector iPatchRedirector = MSFKernelBridge.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MSFKernelBridge) iPatchRedirector.redirect((short) 2);
        }
        return MSFKernelBridge.CppProxy.getInstance();
    }
}
