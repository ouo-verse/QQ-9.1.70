package com.tencent.biz.richframework.network.quic.strategy;

import com.tencent.libra.cache.ICache;
import com.tencent.libra.listener.ILoaderResultListener;
import com.tencent.libra.request.IpConnectConfig;
import com.tencent.libra.resource.IResourceDrawableFactory;
import com.tencent.libra.strategy.ILibraLibraryStrategy;
import com.tencent.libra.thread.ITaskExecutor;
import g11.a;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class VSNetWorkStrategy implements ILibraLibraryStrategy {
    private static final String BUSINESS_NAME_TAG = "VS_NET_WORK";

    @Override // com.tencent.libra.strategy.ILibraLibraryStrategy
    public String getBusinessName() {
        return BUSINESS_NAME_TAG;
    }

    @Override // com.tencent.libra.strategy.ILibraBaseStrategy
    public /* synthetic */ ICache getCustomCache() {
        return a.a(this);
    }

    @Override // com.tencent.libra.strategy.ILibraBaseStrategy
    public /* synthetic */ List getCustomDecoder() {
        return a.b(this);
    }

    @Override // com.tencent.libra.strategy.ILibraBaseStrategy
    public /* synthetic */ List getCustomDownloaders() {
        return a.c(this);
    }

    @Override // com.tencent.libra.strategy.ILibraBaseStrategy
    public /* synthetic */ IResourceDrawableFactory getDrawableFactory() {
        return a.d(this);
    }

    @Override // com.tencent.libra.strategy.ILibraBaseStrategy
    public /* synthetic */ ILoaderResultListener getGlobalResultListener() {
        return a.e(this);
    }

    @Override // com.tencent.libra.strategy.ILibraBaseStrategy
    public /* synthetic */ IpConnectConfig getIpConnectConfig(String str) {
        return a.f(this, str);
    }

    @Override // com.tencent.libra.strategy.ILibraBaseStrategy
    public /* synthetic */ w01.a getLibraIpStrategyBean() {
        return a.g(this);
    }

    @Override // com.tencent.libra.strategy.ILibraBaseStrategy
    public /* synthetic */ ITaskExecutor getTaskExecutor() {
        return a.h(this);
    }

    @Override // com.tencent.libra.strategy.ILibraBaseStrategy
    public /* synthetic */ String getUniKeyFromUrl(String str) {
        return a.i(this, str);
    }

    @Override // com.tencent.libra.strategy.ILibraBaseStrategy
    public /* synthetic */ Boolean isSupportActiveResources() {
        return a.j(this);
    }
}
