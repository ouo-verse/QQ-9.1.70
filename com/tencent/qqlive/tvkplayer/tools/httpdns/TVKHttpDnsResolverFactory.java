package com.tencent.qqlive.tvkplayer.tools.httpdns;

import com.tencent.qqlive.tvkplayer.api.ITVKHttpDnsResolver;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKHttpDnsResolverFactory {
    private static final ITVKHttpDnsResolver sInnerHttpDnsResolver = TVKHttpDnsResolver.getInstance();
    private static ITVKHttpDnsResolver sExternalHttpDnsResolver = null;

    TVKHttpDnsResolverFactory() {
    }

    public static ITVKHttpDnsResolver getHttpDnsResolver() {
        ITVKHttpDnsResolver iTVKHttpDnsResolver = sExternalHttpDnsResolver;
        if (iTVKHttpDnsResolver == null) {
            return sInnerHttpDnsResolver;
        }
        return iTVKHttpDnsResolver;
    }

    public static void setExternalHttpDnsResolver(ITVKHttpDnsResolver iTVKHttpDnsResolver) {
        sExternalHttpDnsResolver = iTVKHttpDnsResolver;
    }
}
