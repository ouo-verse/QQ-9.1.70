package com.tencent.mobileqq.vas.ui;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.vas.apng.api.DynamicDrawableOptions;
import java.io.File;
import java.net.URLEncoder;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u0003H\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\fH\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/vas/ui/IDynamicDrawableCachePool;", "", "cacheGroupName", "", "getCacheGroupName", "()Ljava/lang/String;", "generaCacheKey", "options", "Lcom/tencent/mobileqq/vas/apng/api/DynamicDrawableOptions;", "file", "Ljava/io/File;", "getCacheFromPool", "Lcom/tencent/mobileqq/vas/ui/AbsDynamicDrawableState;", "key", "putCacheToPool", "", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "Companion", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public interface IDynamicDrawableCachePool {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/vas/ui/IDynamicDrawableCachePool$Companion;", "", "()V", "sCache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mobileqq/vas/ui/AbsDynamicDrawableState;", "getSCache", "()Ljava/util/concurrent/ConcurrentHashMap;", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        @NotNull
        private static final ConcurrentHashMap<String, AbsDynamicDrawableState> sCache = new ConcurrentHashMap<>();

        Companion() {
        }

        @NotNull
        public final ConcurrentHashMap<String, AbsDynamicDrawableState> getSCache() {
            return sCache;
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class DefaultImpls {
        @NotNull
        public static String generaCacheKey(@NotNull IDynamicDrawableCachePool iDynamicDrawableCachePool, @NotNull DynamicDrawableOptions options, @NotNull File file) {
            Intrinsics.checkNotNullParameter(options, "options");
            Intrinsics.checkNotNullParameter(file, "file");
            String encode = URLEncoder.encode(options.toCacheKey() + "_" + file.getAbsolutePath());
            Intrinsics.checkNotNullExpressionValue(encode, "encode(options.toCacheKe\u2026 \"_\" + file.absolutePath)");
            return encode;
        }

        @Nullable
        public static AbsDynamicDrawableState getCacheFromPool(@NotNull IDynamicDrawableCachePool iDynamicDrawableCachePool, @NotNull String key) {
            Intrinsics.checkNotNullParameter(key, "key");
            AbsDynamicDrawableState absDynamicDrawableState = IDynamicDrawableCachePool.INSTANCE.getSCache().get(key);
            if (absDynamicDrawableState != null && absDynamicDrawableState.isReusable()) {
                return absDynamicDrawableState;
            }
            return null;
        }

        public static void putCacheToPool(@NotNull IDynamicDrawableCachePool iDynamicDrawableCachePool, @NotNull String key, @NotNull AbsDynamicDrawableState instance) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(instance, "instance");
            IDynamicDrawableCachePool.INSTANCE.getSCache().put(key, instance);
        }
    }

    @NotNull
    String generaCacheKey(@NotNull DynamicDrawableOptions options, @NotNull File file);

    @Nullable
    AbsDynamicDrawableState getCacheFromPool(@NotNull String key);

    @NotNull
    String getCacheGroupName();

    void putCacheToPool(@NotNull String key, @NotNull AbsDynamicDrawableState instance);
}
