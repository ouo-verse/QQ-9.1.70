package com.tencent.mobileqq.highway.api.impl;

import com.tencent.mobileqq.highway.api.IConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/highway/api/impl/ConfigImpl;", "Lcom/tencent/mobileqq/highway/api/IConfig;", "()V", DownloadInfo.spKey_Config, "Lcom/tencent/mobileqq/highway/api/impl/KernelConfigBean;", "getConfig", "()Lcom/tencent/mobileqq/highway/api/impl/KernelConfigBean;", "isAllUseKernel", "", "isUseKernel", "commandID", "", "Transfile_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes9.dex */
public final class ConfigImpl implements IConfig {
    static IPatchRedirector $redirector_;

    @NotNull
    private final KernelConfigBean config;

    public ConfigImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            KernelConfigBean kernelConfigBean = (KernelConfigBean) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig(ConfigImplKt.CONFIG_GROUP);
            this.config = kernelConfigBean == null ? new KernelConfigBean() : kernelConfigBean;
        }
    }

    @NotNull
    public final KernelConfigBean getConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (KernelConfigBean) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.config;
    }

    @Override // com.tencent.mobileqq.highway.api.IConfig
    public boolean isAllUseKernel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.config.isAllUseKernel();
    }

    @Override // com.tencent.mobileqq.highway.api.IConfig
    public boolean isUseKernel(int commandID) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, commandID)).booleanValue();
        }
        return this.config.getUseKernelCommands().contains(Integer.valueOf(commandID));
    }
}
