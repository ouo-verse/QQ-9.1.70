package com.tencent.mobileqq.gateway.localphone.ecdh;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.kernel.nativeinterface.IKernelECDHService;
import com.tencent.qqnt.kernel.nativeinterface.ci;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/gateway/localphone/ecdh/a;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelECDHService;", "a", "b", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelECDHService;", "ecdhService", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f213611a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static IKernelECDHService ecdhService;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18249);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f213611a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Nullable
    public final IKernelECDHService a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (IKernelECDHService) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        if (ecdhService == null) {
            synchronized (a.class) {
                if (ecdhService == null) {
                    ecdhService = ci.k().getECDHService();
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        return ecdhService;
    }
}
