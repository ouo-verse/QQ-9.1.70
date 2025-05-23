package com.tencent.mobileqq.transfile.predownload.api.impl;

import com.tencent.mobileqq.power.api.IQQMonitorApi;
import com.tencent.mobileqq.power.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.predownload.api.IMonitorNetPowerApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/transfile/predownload/api/impl/MonitorNetPowerApiImpl;", "Lcom/tencent/mobileqq/transfile/predownload/api/IMonitorNetPowerApi;", "()V", "reportNetInBackground", "", "tag", "", "url", "path", "power_monitor_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public final class MonitorNetPowerApiImpl implements IMonitorNetPowerApi {
    static IPatchRedirector $redirector_;

    public MonitorNetPowerApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.transfile.predownload.api.IMonitorNetPowerApi
    public void reportNetInBackground(@NotNull String tag, @NotNull String url, @NotNull String path) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, tag, url, path);
            return;
        }
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(path, "path");
        if (c.f259407a.a()) {
            ((IQQMonitorApi) QRoute.api(IQQMonitorApi.class)).reportNetUrl(tag, url, path);
        }
    }
}
