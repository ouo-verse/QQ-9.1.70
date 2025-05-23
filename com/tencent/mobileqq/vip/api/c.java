package com.tencent.mobileqq.vip.api;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vip.api.IVipIconUtils;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes20.dex */
public final /* synthetic */ class c {
    static {
        IVipIconUtils.Companion companion = IVipIconUtils.INSTANCE;
    }

    @JvmStatic
    @NotNull
    public static IVipIconUtils a() {
        IPatchRedirector iPatchRedirector = IVipIconUtils.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (IVipIconUtils) iPatchRedirector.redirect((short) 1);
        }
        return IVipIconUtils.INSTANCE.api();
    }
}
