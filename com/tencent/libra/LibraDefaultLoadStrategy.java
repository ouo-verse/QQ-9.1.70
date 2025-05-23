package com.tencent.libra;

import com.tencent.libra.cache.ICache;
import com.tencent.libra.listener.ILoaderResultListener;
import com.tencent.libra.request.IpConnectConfig;
import com.tencent.libra.resource.IResourceDrawableFactory;
import com.tencent.libra.strategy.ILibraLibraryStrategy;
import com.tencent.libra.thread.ITaskExecutor;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public class LibraDefaultLoadStrategy implements ILibraLibraryStrategy {
    @Override // com.tencent.libra.strategy.ILibraLibraryStrategy
    public String getBusinessName() {
        return "Libra";
    }

    @Override // com.tencent.libra.strategy.ILibraBaseStrategy
    public ICache getCustomCache() {
        return null;
    }

    @Override // com.tencent.libra.strategy.ILibraBaseStrategy
    public List<r01.a<?>> getCustomDecoder() {
        return null;
    }

    @Override // com.tencent.libra.strategy.ILibraBaseStrategy
    public /* synthetic */ List getCustomDownloaders() {
        return g11.a.c(this);
    }

    @Override // com.tencent.libra.strategy.ILibraBaseStrategy
    public IResourceDrawableFactory getDrawableFactory() {
        return null;
    }

    @Override // com.tencent.libra.strategy.ILibraBaseStrategy
    public ILoaderResultListener getGlobalResultListener() {
        return null;
    }

    @Override // com.tencent.libra.strategy.ILibraBaseStrategy
    public /* synthetic */ IpConnectConfig getIpConnectConfig(String str) {
        return g11.a.f(this, str);
    }

    @Override // com.tencent.libra.strategy.ILibraBaseStrategy
    public /* synthetic */ w01.a getLibraIpStrategyBean() {
        return g11.a.g(this);
    }

    @Override // com.tencent.libra.strategy.ILibraBaseStrategy
    public ITaskExecutor getTaskExecutor() {
        return null;
    }

    @Override // com.tencent.libra.strategy.ILibraBaseStrategy
    public /* synthetic */ String getUniKeyFromUrl(String str) {
        return g11.a.i(this, str);
    }

    @Override // com.tencent.libra.strategy.ILibraBaseStrategy
    public /* synthetic */ Boolean isSupportActiveResources() {
        return g11.a.j(this);
    }
}
