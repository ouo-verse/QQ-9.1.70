package com.tencent.richframework.strategy;

import android.os.Looper;
import com.tencent.libra.cache.ICache;
import com.tencent.libra.listener.ILoaderResultListener;
import com.tencent.libra.request.IpConnectConfig;
import com.tencent.libra.resource.IResourceDrawableFactory;
import com.tencent.libra.strategy.ILibraGlobalStrategy;
import com.tencent.libra.thread.ITaskExecutor;
import com.tencent.mobileqq.app.ThreadManagerV2;
import g11.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/richframework/strategy/GlobalPicLoadStrategy;", "Lcom/tencent/libra/strategy/ILibraGlobalStrategy;", "()V", "getErrorLooper", "Landroid/os/Looper;", "qq-rfw-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public final class GlobalPicLoadStrategy implements ILibraGlobalStrategy {
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

    @Override // com.tencent.libra.strategy.ILibraGlobalStrategy
    @NotNull
    public Looper getErrorLooper() {
        Looper qQCommonThreadLooper = ThreadManagerV2.getQQCommonThreadLooper();
        Intrinsics.checkNotNullExpressionValue(qQCommonThreadLooper, "getQQCommonThreadLooper()");
        return qQCommonThreadLooper;
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
