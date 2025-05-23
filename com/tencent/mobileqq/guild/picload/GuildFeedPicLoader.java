package com.tencent.mobileqq.guild.picload;

import com.tencent.cache.api.Business;
import com.tencent.cache.api.PageHierarchy;
import com.tencent.libra.IPicLoader;
import com.tencent.libra.LibraPicLoaderFactory;
import com.tencent.libra.cache.i;
import com.tencent.libra.extension.gif.h;
import com.tencent.libra.listener.ILoaderResultListener;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.IpConnectConfig;
import com.tencent.libra.request.Option;
import com.tencent.libra.resource.IResourceDrawableFactory;
import com.tencent.libra.strategy.ILibraLibraryStrategy;
import com.tencent.libra.thread.ITaskExecutor;
import com.tencent.mobileqq.guild.picload.GuildFeedPicLoader;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0014B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\b\u001a\u00020\u0006R\u001b\u0010\u000e\u001a\u00020\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0011\u001a\u00020\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\u000b\u001a\u0004\b\n\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/picload/GuildFeedPicLoader;", "", "Lcom/tencent/libra/request/Option;", "op", "Lcom/tencent/libra/listener/IPicLoadStateListener;", "listener", "", "d", "f", "Lcom/tencent/libra/IPicLoader;", "b", "Lkotlin/Lazy;", "c", "()Lcom/tencent/libra/IPicLoader;", "g", "Lcom/tencent/mobileqq/guild/picload/CountLimitCache;", "()Lcom/tencent/mobileqq/guild/picload/CountLimitCache;", "cache", "<init>", "()V", "a", "qqguild-picload-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildFeedPicLoader {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GuildFeedPicLoader f231079a = new GuildFeedPicLoader();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy g;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy cache;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u001e\u0010\n\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u000e\b\u0001\u0012\n \t*\u0004\u0018\u00010\b0\b0\u00070\u0006H\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/picload/GuildFeedPicLoader$a;", "Lcom/tencent/libra/strategy/ILibraLibraryStrategy;", "", "getBusinessName", "Lcom/tencent/mobileqq/guild/picload/CountLimitCache;", "a", "", "Lr01/a;", "", "kotlin.jvm.PlatformType", "getCustomDecoder", "url", "getUniKeyFromUrl", "<init>", "()V", "qqguild-picload-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a implements ILibraLibraryStrategy {
        @Override // com.tencent.libra.strategy.ILibraBaseStrategy
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public CountLimitCache getCustomCache() {
            return GuildFeedPicLoader.f231079a.b();
        }

        @Override // com.tencent.libra.strategy.ILibraLibraryStrategy
        @NotNull
        public String getBusinessName() {
            return "guild";
        }

        @Override // com.tencent.libra.strategy.ILibraBaseStrategy
        @NotNull
        public List<r01.a<? extends Object>> getCustomDecoder() {
            List<r01.a<? extends Object>> listOf;
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new r01.a[]{new h(), new com.tencent.libra.extension.avif.b(), new z01.b(), new d11.a()});
            return listOf;
        }

        @Override // com.tencent.libra.strategy.ILibraBaseStrategy
        public /* synthetic */ List getCustomDownloaders() {
            return g11.a.c(this);
        }

        @Override // com.tencent.libra.strategy.ILibraBaseStrategy
        public /* synthetic */ IResourceDrawableFactory getDrawableFactory() {
            return g11.a.d(this);
        }

        @Override // com.tencent.libra.strategy.ILibraBaseStrategy
        public /* synthetic */ ILoaderResultListener getGlobalResultListener() {
            return g11.a.e(this);
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
        public /* synthetic */ ITaskExecutor getTaskExecutor() {
            return g11.a.h(this);
        }

        @Override // com.tencent.libra.strategy.ILibraBaseStrategy
        @NotNull
        public String getUniKeyFromUrl(@NotNull String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            String d16 = e.d(url);
            Intrinsics.checkNotNullExpressionValue(d16, "getUniKeyFromUrl(url)");
            return d16;
        }

        @Override // com.tencent.libra.strategy.ILibraBaseStrategy
        public /* synthetic */ Boolean isSupportActiveResources() {
            return g11.a.j(this);
        }
    }

    static {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<IPicLoader>() { // from class: com.tencent.mobileqq.guild.picload.GuildFeedPicLoader$g$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final IPicLoader invoke() {
                return LibraPicLoaderFactory.getPicLoader(new GuildFeedPicLoader.a());
            }
        });
        g = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<CountLimitCache>() { // from class: com.tencent.mobileqq.guild.picload.GuildFeedPicLoader$cache$2

            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/picload/GuildFeedPicLoader$cache$2$a", "Lcom/tencent/libra/cache/c;", "Lcom/tencent/libra/request/Option;", "option", "Lcom/tencent/cache/api/Business;", "getBusiness", "qqguild-picload-api_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes14.dex */
            public static final class a implements com.tencent.libra.cache.c {
                a() {
                }

                @Override // com.tencent.libra.cache.c
                @NotNull
                public Business getBusiness(@Nullable Option option) {
                    return Business.Guild;
                }

                @Override // com.tencent.libra.cache.c
                public /* synthetic */ PageHierarchy getSubBusiness(Option option) {
                    return com.tencent.libra.cache.b.b(this, option);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final CountLimitCache invoke() {
                return new CountLimitCache(new i(new a()), 10);
            }
        });
        cache = lazy2;
    }

    GuildFeedPicLoader() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CountLimitCache b() {
        return (CountLimitCache) cache.getValue();
    }

    private final IPicLoader c() {
        Object value = g.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-g>(...)");
        return (IPicLoader) value;
    }

    public static /* synthetic */ void e(GuildFeedPicLoader guildFeedPicLoader, Option option, IPicLoadStateListener iPicLoadStateListener, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            iPicLoadStateListener = null;
        }
        guildFeedPicLoader.d(option, iPicLoadStateListener);
    }

    public final void d(@NotNull Option op5, @Nullable IPicLoadStateListener listener) {
        Intrinsics.checkNotNullParameter(op5, "op");
        op5.disableHardwareDecode();
        c().loadImage(op5, listener);
    }

    public final void f() {
        c().release();
    }
}
