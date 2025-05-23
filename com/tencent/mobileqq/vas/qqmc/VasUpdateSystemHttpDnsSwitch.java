package com.tencent.mobileqq.vas.qqmc;

import com.tencent.mobileqq.vas.VasQQMcConstKt;
import com.tencent.mobileqq.vas.qqmc.bean.UpdateSystemHttpDns;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\b\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/vas/qqmc/VasUpdateSystemHttpDnsSwitch;", "Lcom/tencent/mobileqq/vas/qqmc/VasJsonQQMC;", "Lcom/tencent/mobileqq/vas/qqmc/bean/UpdateSystemHttpDns;", "()V", "defaultConfig", "getGroup", "", "isUseHttpDns", "", "isUseVasDownload", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class VasUpdateSystemHttpDnsSwitch extends VasJsonQQMC<UpdateSystemHttpDns> {
    @Override // com.tencent.mobileqq.vas.qqmc.VasQQMC
    @NotNull
    public String getGroup() {
        return VasQQMcConstKt.QQMC_KEY_VAS_UPDATE_SYSTEM_HTTPDNS;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean isUseHttpDns() {
        boolean z16;
        if (!isSwitchOn(false)) {
            return false;
        }
        UpdateSystemHttpDns updateSystemHttpDns = (UpdateSystemHttpDns) loadConfig();
        if (updateSystemHttpDns != null) {
            z16 = updateSystemHttpDns.getUseHttpDns();
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean isUseVasDownload() {
        boolean z16;
        if (!isSwitchOn(false)) {
            return false;
        }
        UpdateSystemHttpDns updateSystemHttpDns = (UpdateSystemHttpDns) loadConfig();
        if (updateSystemHttpDns != null) {
            z16 = updateSystemHttpDns.getUseVasDownloader();
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NotNull
    public UpdateSystemHttpDns defaultConfig() {
        return new UpdateSystemHttpDns(false, false, 3, null);
    }
}
