package com.tencent.mobileqq.soload.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.soload.api.ISoLoadTempApi;
import com.tencent.mobileqq.soload.download.SoPriorityDownloader;
import com.tencent.mobileqq.vip.DownloaderFactory;
import kotlin.Metadata;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/soload/api/impl/SoLoadTempApiImpl;", "Lcom/tencent/mobileqq/soload/api/ISoLoadTempApi;", "()V", "getQueueDownloaderType", "", "getSoPriorityDownloader", "", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes18.dex */
public final class SoLoadTempApiImpl implements ISoLoadTempApi {
    static IPatchRedirector $redirector_;

    public SoLoadTempApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.soload.api.ISoLoadTempApi
    public int getQueueDownloaderType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return 1;
    }

    @Override // com.tencent.mobileqq.soload.api.ISoLoadTempApi
    @NotNull
    public Object getSoPriorityDownloader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new SoPriorityDownloader(MobileQQ.sMobileQQ.peekAppRuntime(), new DownloaderFactory.b(false));
    }
}
