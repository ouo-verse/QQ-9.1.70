package com.tencent.mobileqq.vip.api;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vip.api.IVipDataUtils;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes20.dex */
public final /* synthetic */ class b {
    static {
        IVipDataUtils.Companion companion = IVipDataUtils.INSTANCE;
    }

    @JvmStatic
    @NotNull
    public static IVipDataUtils a() {
        IPatchRedirector iPatchRedirector = IVipDataUtils.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (IVipDataUtils) iPatchRedirector.redirect((short) 1);
        }
        return IVipDataUtils.INSTANCE.a();
    }
}
