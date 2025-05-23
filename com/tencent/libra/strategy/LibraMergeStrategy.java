package com.tencent.libra.strategy;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.libra.cache.ICache;
import com.tencent.libra.listener.ILoaderResultListener;
import com.tencent.libra.request.IpConnectConfig;
import com.tencent.libra.resource.IResourceDrawableFactory;
import com.tencent.libra.thread.ITaskExecutor;
import java.util.ArrayList;
import java.util.List;
import r01.a;

/* compiled from: P */
/* loaded from: classes7.dex */
public class LibraMergeStrategy implements ILibraBaseStrategy {
    private final ILibraGlobalStrategy mGlobalStrategy;
    private final ILibraLibraryStrategy mLibraryStrategy;

    public LibraMergeStrategy(ILibraLibraryStrategy iLibraLibraryStrategy, ILibraGlobalStrategy iLibraGlobalStrategy) {
        this.mLibraryStrategy = iLibraLibraryStrategy;
        this.mGlobalStrategy = iLibraGlobalStrategy;
    }

    @Override // com.tencent.libra.strategy.ILibraBaseStrategy
    public ICache getCustomCache() {
        ILibraGlobalStrategy iLibraGlobalStrategy;
        ICache customCache = this.mLibraryStrategy.getCustomCache();
        if (customCache == null && (iLibraGlobalStrategy = this.mGlobalStrategy) != null) {
            return iLibraGlobalStrategy.getCustomCache();
        }
        return customCache;
    }

    @Override // com.tencent.libra.strategy.ILibraBaseStrategy
    public List<a<?>> getCustomDecoder() {
        ArrayList arrayList = new ArrayList();
        if (this.mLibraryStrategy.getCustomDecoder() != null) {
            arrayList.addAll(this.mLibraryStrategy.getCustomDecoder());
        }
        ILibraGlobalStrategy iLibraGlobalStrategy = this.mGlobalStrategy;
        if (iLibraGlobalStrategy != null && iLibraGlobalStrategy.getCustomDecoder() != null) {
            arrayList.addAll(this.mGlobalStrategy.getCustomDecoder());
        }
        return arrayList;
    }

    @Override // com.tencent.libra.strategy.ILibraBaseStrategy
    public /* synthetic */ List getCustomDownloaders() {
        return g11.a.c(this);
    }

    @Override // com.tencent.libra.strategy.ILibraBaseStrategy
    public IResourceDrawableFactory getDrawableFactory() {
        ILibraGlobalStrategy iLibraGlobalStrategy;
        IResourceDrawableFactory drawableFactory = this.mLibraryStrategy.getDrawableFactory();
        if (drawableFactory == null && (iLibraGlobalStrategy = this.mGlobalStrategy) != null) {
            return iLibraGlobalStrategy.getDrawableFactory();
        }
        return drawableFactory;
    }

    @Override // com.tencent.libra.strategy.ILibraBaseStrategy
    public ILoaderResultListener getGlobalResultListener() {
        ILibraGlobalStrategy iLibraGlobalStrategy;
        ILoaderResultListener globalResultListener = this.mLibraryStrategy.getGlobalResultListener();
        if (globalResultListener == null && (iLibraGlobalStrategy = this.mGlobalStrategy) != null) {
            return iLibraGlobalStrategy.getGlobalResultListener();
        }
        return globalResultListener;
    }

    @Override // com.tencent.libra.strategy.ILibraBaseStrategy
    public IpConnectConfig getIpConnectConfig(@NonNull String str) {
        IpConnectConfig ipConnectConfig = this.mLibraryStrategy.getIpConnectConfig(str);
        ILibraGlobalStrategy iLibraGlobalStrategy = this.mGlobalStrategy;
        if (iLibraGlobalStrategy != null && ipConnectConfig == null) {
            return iLibraGlobalStrategy.getIpConnectConfig(str);
        }
        return ipConnectConfig;
    }

    @Override // com.tencent.libra.strategy.ILibraBaseStrategy
    public /* synthetic */ w01.a getLibraIpStrategyBean() {
        return g11.a.g(this);
    }

    @Override // com.tencent.libra.strategy.ILibraBaseStrategy
    public ITaskExecutor getTaskExecutor() {
        ILibraGlobalStrategy iLibraGlobalStrategy;
        ITaskExecutor taskExecutor = this.mLibraryStrategy.getTaskExecutor();
        if (taskExecutor == null && (iLibraGlobalStrategy = this.mGlobalStrategy) != null) {
            return iLibraGlobalStrategy.getTaskExecutor();
        }
        return taskExecutor;
    }

    @Override // com.tencent.libra.strategy.ILibraBaseStrategy
    @NonNull
    public String getUniKeyFromUrl(@NonNull String str) {
        ILibraGlobalStrategy iLibraGlobalStrategy;
        String uniKeyFromUrl = this.mLibraryStrategy.getUniKeyFromUrl(str);
        if (TextUtils.isEmpty(uniKeyFromUrl) && (iLibraGlobalStrategy = this.mGlobalStrategy) != null) {
            return iLibraGlobalStrategy.getUniKeyFromUrl(str);
        }
        return uniKeyFromUrl;
    }

    @Override // com.tencent.libra.strategy.ILibraBaseStrategy
    public Boolean isSupportActiveResources() {
        boolean z16;
        ILibraGlobalStrategy iLibraGlobalStrategy;
        Boolean isSupportActiveResources = this.mLibraryStrategy.isSupportActiveResources();
        if (isSupportActiveResources == null && (iLibraGlobalStrategy = this.mGlobalStrategy) != null) {
            isSupportActiveResources = iLibraGlobalStrategy.isSupportActiveResources();
        }
        if (isSupportActiveResources != null) {
            z16 = isSupportActiveResources.booleanValue();
        } else {
            z16 = false;
        }
        return Boolean.valueOf(z16);
    }
}
