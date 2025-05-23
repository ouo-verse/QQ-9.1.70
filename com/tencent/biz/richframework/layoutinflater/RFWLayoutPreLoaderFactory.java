package com.tencent.biz.richframework.layoutinflater;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0007R\u001e\u0010\u0003\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/tencent/biz/richframework/layoutinflater/RFWLayoutPreLoaderFactory;", "", "()V", "sLoaders", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/lang/Class;", "Lcom/tencent/biz/richframework/layoutinflater/RFWLayoutPreLoader;", "getLayoutLoader", "layoutLoaderStrategy", "Lcom/tencent/biz/richframework/layoutinflater/RFWLayoutLoaderStrategy;", "layoutinflater_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class RFWLayoutPreLoaderFactory {

    @NotNull
    public static final RFWLayoutPreLoaderFactory INSTANCE = new RFWLayoutPreLoaderFactory();
    private static final ConcurrentHashMap<Class<?>, RFWLayoutPreLoader> sLoaders = new ConcurrentHashMap<>();

    RFWLayoutPreLoaderFactory() {
    }

    @JvmStatic
    @NotNull
    public static final RFWLayoutPreLoader getLayoutLoader(@NotNull RFWLayoutLoaderStrategy layoutLoaderStrategy) {
        RFWLayoutPreLoader rFWLayoutPreLoader;
        Intrinsics.checkNotNullParameter(layoutLoaderStrategy, "layoutLoaderStrategy");
        ConcurrentHashMap<Class<?>, RFWLayoutPreLoader> concurrentHashMap = sLoaders;
        RFWLayoutPreLoader rFWLayoutPreLoader2 = concurrentHashMap.get(layoutLoaderStrategy.getClass());
        if (rFWLayoutPreLoader2 == null) {
            synchronized (RFWLayoutPreLoaderFactory.class) {
                rFWLayoutPreLoader = concurrentHashMap.get(layoutLoaderStrategy.getClass());
                if (rFWLayoutPreLoader == null) {
                    rFWLayoutPreLoader = new RFWLayoutPreLoader(layoutLoaderStrategy);
                    concurrentHashMap.put(layoutLoaderStrategy.getClass(), rFWLayoutPreLoader);
                }
            }
            rFWLayoutPreLoader2 = rFWLayoutPreLoader;
        }
        Intrinsics.checkNotNullExpressionValue(rFWLayoutPreLoader2, "sLoaders[layoutLoaderStr\u2026          }\n            }");
        return rFWLayoutPreLoader2;
    }
}
