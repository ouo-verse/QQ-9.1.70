package com.tencent.mobileqq.perf.block;

import com.tencent.beacon.event.UserAction;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J^\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0018\u0010\f\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0007JF\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0018\u0010\b\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\r2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0007\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/perf/block/ReportMethodProxy;", "", "()V", "onUserActionToTunnel", "", "var0", "", "var1", "var2", "var3", "", "var5", "var7", "", "var8", "var9", "var4", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class ReportMethodProxy {
    static IPatchRedirector $redirector_;

    @NotNull
    public static final ReportMethodProxy INSTANCE;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28801);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            INSTANCE = new ReportMethodProxy();
        }
    }

    ReportMethodProxy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static final boolean onUserActionToTunnel(@Nullable String var0, @Nullable String var1, boolean var2, long var3, long var5, @Nullable Map<String, String> var7, boolean var8, boolean var9) {
        MainBlockMethodMonitor.onMethodStart();
        boolean onUserActionToTunnel = UserAction.onUserActionToTunnel(var0, var1, var2, var3, var5, var7, var8, var9);
        MainBlockMethodMonitor.onMethodEnd();
        return onUserActionToTunnel;
    }

    @JvmStatic
    public static final boolean onUserActionToTunnel(@Nullable String var0, @Nullable String var1, @Nullable Map<String, String> var2, boolean var3, boolean var4) {
        MainBlockMethodMonitor.onMethodStart();
        boolean onUserActionToTunnel = UserAction.onUserActionToTunnel(var0, var1, var2, var3, var4);
        MainBlockMethodMonitor.onMethodEnd();
        return onUserActionToTunnel;
    }
}
