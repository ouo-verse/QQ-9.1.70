package com.tencent.libra.strategy;

import androidx.annotation.NonNull;
import com.tencent.libra.cache.ICache;
import com.tencent.libra.download.ILibraDownloader;
import com.tencent.libra.listener.ILoaderResultListener;
import com.tencent.libra.request.IpConnectConfig;
import com.tencent.libra.resource.IResourceDrawableFactory;
import com.tencent.libra.thread.ITaskExecutor;
import java.util.List;
import r01.a;

/* compiled from: P */
/* loaded from: classes7.dex */
public interface ILibraBaseStrategy {
    ICache getCustomCache();

    List<a<?>> getCustomDecoder();

    List<ILibraDownloader> getCustomDownloaders();

    IResourceDrawableFactory getDrawableFactory();

    ILoaderResultListener getGlobalResultListener();

    IpConnectConfig getIpConnectConfig(@NonNull String str);

    @NonNull
    w01.a getLibraIpStrategyBean();

    ITaskExecutor getTaskExecutor();

    @NonNull
    String getUniKeyFromUrl(@NonNull String str);

    Boolean isSupportActiveResources();
}
