package com.tencent.mobileqq.vip.api;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vip.api.IVipInfoUtils;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes20.dex */
public final /* synthetic */ class d {
    static {
        IVipInfoUtils.Companion companion = IVipInfoUtils.INSTANCE;
    }

    @JvmStatic
    @NotNull
    public static IVipInfoUtils a() {
        IPatchRedirector iPatchRedirector = IVipInfoUtils.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (IVipInfoUtils) iPatchRedirector.redirect((short) 1);
        }
        return IVipInfoUtils.INSTANCE.a();
    }
}
