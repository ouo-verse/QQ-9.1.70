package com.tencent.mobileqq.search.searchdetail.util;

import android.os.Looper;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.PageHierarchy;
import com.tencent.libra.IPicLoader;
import com.tencent.libra.LibraPicLoaderFactory;
import com.tencent.libra.cache.ICache;
import com.tencent.libra.listener.ILoaderResultListener;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.IpConnectConfig;
import com.tencent.libra.request.Option;
import com.tencent.libra.resource.IResourceDrawableFactory;
import com.tencent.libra.strategy.ILibraGlobalStrategy;
import com.tencent.libra.strategy.ILibraLibraryStrategy;
import com.tencent.libra.thread.ITaskExecutor;
import com.tencent.mobileqq.qcircle.picload.listener.RFWPicLoaderResultListener;
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

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002\u0014\nB\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006R\u001b\u0010\u000e\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0011\u001a\u00020\u000f8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\u000b\u001a\u0004\b\n\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/util/SearchPicLoader;", "", "Lcom/tencent/libra/IPicLoader;", "d", "Lcom/tencent/libra/request/Option;", "op", "Lcom/tencent/libra/listener/IPicLoadStateListener;", "listener", "", "e", "b", "Lkotlin/Lazy;", "c", "()Lcom/tencent/libra/IPicLoader;", "loader", "Lcom/tencent/libra/cache/i;", "()Lcom/tencent/libra/cache/i;", "cache", "<init>", "()V", "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class SearchPicLoader {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final SearchPicLoader f284726a = new SearchPicLoader();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy loader;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy cache;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/util/SearchPicLoader$a;", "Lcom/tencent/libra/strategy/ILibraGlobalStrategy;", "Landroid/os/Looper;", "getErrorLooper", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class a implements ILibraGlobalStrategy {
        @Override // com.tencent.libra.strategy.ILibraBaseStrategy
        public /* synthetic */ ICache getCustomCache() {
            return g11.a.a(this);
        }

        @Override // com.tencent.libra.strategy.ILibraBaseStrategy
        public /* synthetic */ List getCustomDecoder() {
            return g11.a.b(this);
        }

        @Override // com.tencent.libra.strategy.ILibraBaseStrategy
        public /* synthetic */ List getCustomDownloaders() {
            return g11.a.c(this);
        }

        @Override // com.tencent.libra.strategy.ILibraBaseStrategy
        public /* synthetic */ IResourceDrawableFactory getDrawableFactory() {
            return g11.a.d(this);
        }

        @Override // com.tencent.libra.strategy.ILibraGlobalStrategy
        @Nullable
        public Looper getErrorLooper() {
            return null;
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
        public /* synthetic */ String getUniKeyFromUrl(String str) {
            return g11.a.i(this, str);
        }

        @Override // com.tencent.libra.strategy.ILibraBaseStrategy
        public /* synthetic */ Boolean isSupportActiveResources() {
            return g11.a.j(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u001e\u0010\f\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u000e\b\u0001\u0012\n \u000b*\u0004\u0018\u00010\n0\n0\t0\bH\u0016J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002H\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/util/SearchPicLoader$b;", "Lcom/tencent/libra/strategy/ILibraLibraryStrategy;", "", "getBusinessName", "Lcom/tencent/libra/cache/i;", "a", "Lcom/tencent/libra/listener/ILoaderResultListener;", "getGlobalResultListener", "", "Lr01/a;", "", "kotlin.jvm.PlatformType", "getCustomDecoder", "url", "getUniKeyFromUrl", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b implements ILibraLibraryStrategy {
        @Override // com.tencent.libra.strategy.ILibraBaseStrategy
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.tencent.libra.cache.i getCustomCache() {
            return SearchPicLoader.f284726a.b();
        }

        @Override // com.tencent.libra.strategy.ILibraLibraryStrategy
        @NotNull
        public String getBusinessName() {
            return "qqsearch";
        }

        @Override // com.tencent.libra.strategy.ILibraBaseStrategy
        @NotNull
        public List<r01.a<? extends Object>> getCustomDecoder() {
            List<r01.a<? extends Object>> listOf;
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new r01.a[]{new com.tencent.libra.extension.gif.h(), new com.tencent.libra.extension.avif.b(), new z01.b(), new d11.a()});
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
        @NotNull
        public ILoaderResultListener getGlobalResultListener() {
            return new RFWPicLoaderResultListener("8");
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
            return url;
        }

        @Override // com.tencent.libra.strategy.ILibraBaseStrategy
        public /* synthetic */ Boolean isSupportActiveResources() {
            return g11.a.j(this);
        }
    }

    static {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<IPicLoader>() { // from class: com.tencent.mobileqq.search.searchdetail.util.SearchPicLoader$loader$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final IPicLoader invoke() {
                IPicLoader d16;
                d16 = SearchPicLoader.f284726a.d();
                return d16;
            }
        });
        loader = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.libra.cache.i>() { // from class: com.tencent.mobileqq.search.searchdetail.util.SearchPicLoader$cache$2

            @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"com/tencent/mobileqq/search/searchdetail/util/SearchPicLoader$cache$2$a", "Lcom/tencent/libra/cache/c;", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes18.dex */
            public static final class a implements com.tencent.libra.cache.c {
                a() {
                }

                @Override // com.tencent.libra.cache.c
                public /* synthetic */ Business getBusiness(Option option) {
                    return com.tencent.libra.cache.b.a(this, option);
                }

                @Override // com.tencent.libra.cache.c
                public /* synthetic */ PageHierarchy getSubBusiness(Option option) {
                    return com.tencent.libra.cache.b.b(this, option);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.libra.cache.i invoke() {
                return new com.tencent.libra.cache.i(new a());
            }
        });
        cache = lazy2;
    }

    SearchPicLoader() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IPicLoader d() {
        LibraPicLoaderFactory.setGlobalPicLoadStrategy(new a());
        IPicLoader picLoader = LibraPicLoaderFactory.getPicLoader(new b());
        Intrinsics.checkNotNullExpressionValue(picLoader, "getPicLoader(PicLoadStrategy())");
        return picLoader;
    }

    @NotNull
    public final com.tencent.libra.cache.i b() {
        return (com.tencent.libra.cache.i) cache.getValue();
    }

    @NotNull
    public final IPicLoader c() {
        return (IPicLoader) loader.getValue();
    }

    public final void e(@NotNull Option op5, @Nullable IPicLoadStateListener listener) {
        Intrinsics.checkNotNullParameter(op5, "op");
        op5.disableHardwareDecode();
        c().loadImage(op5, listener);
    }
}
