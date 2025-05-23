package com.tencent.mobileqq.power;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.pb.performance.ClientPerformance$SsoHighPowerConsumptionReportRequest;
import jy3.f;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/power/b;", "Ljy3/f;", "Lcom/tencent/pb/performance/ClientPerformance$SsoHighPowerConsumptionReportRequest;", Const.BUNDLE_KEY_REQUEST, "", "a", "<init>", "()V", "power_monitor_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public abstract class b extends f<ClientPerformance$SsoHighPowerConsumptionReportRequest> {
    static IPatchRedirector $redirector_;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public abstract void a(@NotNull ClientPerformance$SsoHighPowerConsumptionReportRequest request);
}
