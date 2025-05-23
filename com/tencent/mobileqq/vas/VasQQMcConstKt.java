package com.tencent.mobileqq.vas;

import com.tencent.mobileqq.vas.qqmc.VasUpdateSystemHttpDnsSwitch;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"QQMC_KEY_VAS_TEST", "", "QQMC_KEY_VAS_UPDATE_SYSTEM_HTTPDNS", "qqMcUpdateSystemHttpDns", "Lcom/tencent/mobileqq/vas/qqmc/VasUpdateSystemHttpDnsSwitch;", "getQqMcUpdateSystemHttpDns", "()Lcom/tencent/mobileqq/vas/qqmc/VasUpdateSystemHttpDnsSwitch;", "vas-temp-api_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class VasQQMcConstKt {

    @NotNull
    public static final String QQMC_KEY_VAS_TEST = "100117";

    @NotNull
    public static final String QQMC_KEY_VAS_UPDATE_SYSTEM_HTTPDNS = "100127";

    @NotNull
    private static final VasUpdateSystemHttpDnsSwitch qqMcUpdateSystemHttpDns = new VasUpdateSystemHttpDnsSwitch();

    @NotNull
    public static final VasUpdateSystemHttpDnsSwitch getQqMcUpdateSystemHttpDns() {
        return qqMcUpdateSystemHttpDns;
    }
}
