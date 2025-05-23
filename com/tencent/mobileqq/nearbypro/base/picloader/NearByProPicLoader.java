package com.tencent.mobileqq.nearbypro.base.picloader;

import android.os.Looper;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.PageHierarchy;
import com.tencent.libra.IPicLoader;
import com.tencent.libra.LibraPicLoaderFactory;
import com.tencent.libra.cache.ICache;
import com.tencent.libra.cache.b;
import com.tencent.libra.cache.c;
import com.tencent.libra.cache.i;
import com.tencent.libra.listener.ILoaderResultListener;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.IpConnectConfig;
import com.tencent.libra.request.Option;
import com.tencent.libra.resource.IResourceDrawableFactory;
import com.tencent.libra.strategy.ILibraGlobalStrategy;
import com.tencent.libra.strategy.ILibraLibraryStrategy;
import com.tencent.libra.thread.ITaskExecutor;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.nearbypro.base.f;
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
import tl.h;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0002\u0018\nB\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0016R\u001b\u0010\u000e\u001a\u00020\u00048FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0013\u001a\u00020\u000f8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\r\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/base/picloader/NearByProPicLoader;", "Lcom/tencent/mobileqq/nearbypro/base/f;", "Lcom/tencent/libra/request/Option;", "Lcom/tencent/libra/listener/IPicLoadStateListener;", "Lcom/tencent/libra/IPicLoader;", "g", "op", "listener", "", h.F, "b", "Lkotlin/Lazy;", "f", "()Lcom/tencent/libra/IPicLoader;", "loader", "Lcom/tencent/libra/cache/i;", "c", "d", "()Lcom/tencent/libra/cache/i;", "cache", "e", "extInterface", "<init>", "()V", "a", "qq_nearby_pro_base_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class NearByProPicLoader implements f<Option, IPicLoadStateListener, IPicLoader> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final NearByProPicLoader f253241a = new NearByProPicLoader();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy loader;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy cache;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/base/picloader/NearByProPicLoader$a;", "Lcom/tencent/libra/strategy/ILibraGlobalStrategy;", "Landroid/os/Looper;", "getErrorLooper", "<init>", "()V", "qq_nearby_pro_base_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
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
        @NotNull
        public Looper getErrorLooper() {
            Looper qQCommonThreadLooper = ThreadManagerV2.getQQCommonThreadLooper();
            Intrinsics.checkNotNullExpressionValue(qQCommonThreadLooper, "getQQCommonThreadLooper()");
            return qQCommonThreadLooper;
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
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/base/picloader/NearByProPicLoader$b;", "Lcom/tencent/libra/strategy/ILibraLibraryStrategy;", "", "getBusinessName", "Lcom/tencent/libra/cache/i;", "a", "", "Lcom/tencent/libra/extension/gif/h;", "getCustomDecoder", "<init>", "()V", "qq_nearby_pro_base_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class b implements ILibraLibraryStrategy {
        @Override // com.tencent.libra.strategy.ILibraBaseStrategy
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public i getCustomCache() {
            return NearByProPicLoader.f253241a.d();
        }

        @Override // com.tencent.libra.strategy.ILibraLibraryStrategy
        @NotNull
        public String getBusinessName() {
            return "NBP";
        }

        @Override // com.tencent.libra.strategy.ILibraBaseStrategy
        @NotNull
        public List<com.tencent.libra.extension.gif.h> getCustomDecoder() {
            List<com.tencent.libra.extension.gif.h> mutableListOf;
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new com.tencent.libra.extension.gif.h());
            return mutableListOf;
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
        public /* synthetic */ String getUniKeyFromUrl(String str) {
            return g11.a.i(this, str);
        }

        @Override // com.tencent.libra.strategy.ILibraBaseStrategy
        public /* synthetic */ Boolean isSupportActiveResources() {
            return g11.a.j(this);
        }
    }

    static {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<IPicLoader>() { // from class: com.tencent.mobileqq.nearbypro.base.picloader.NearByProPicLoader$loader$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final IPicLoader invoke() {
                IPicLoader g16;
                g16 = NearByProPicLoader.f253241a.g();
                return g16;
            }
        });
        loader = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<i>() { // from class: com.tencent.mobileqq.nearbypro.base.picloader.NearByProPicLoader$cache$2

            @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"com/tencent/mobileqq/nearbypro/base/picloader/NearByProPicLoader$cache$2$a", "Lcom/tencent/libra/cache/c;", "qq_nearby_pro_base_kit_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes15.dex */
            public static final class a implements c {
                a() {
                }

                @Override // com.tencent.libra.cache.c
                public /* synthetic */ Business getBusiness(Option option) {
                    return b.a(this, option);
                }

                @Override // com.tencent.libra.cache.c
                public /* synthetic */ PageHierarchy getSubBusiness(Option option) {
                    return b.b(this, option);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final i invoke() {
                return new i(new a());
            }
        });
        cache = lazy2;
    }

    NearByProPicLoader() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IPicLoader g() {
        LibraPicLoaderFactory.setGlobalPicLoadStrategy(new a());
        IPicLoader picLoader = LibraPicLoaderFactory.getPicLoader(new b());
        Intrinsics.checkNotNullExpressionValue(picLoader, "getPicLoader(PicLoadStrategy())");
        return picLoader;
    }

    @NotNull
    public final i d() {
        return (i) cache.getValue();
    }

    @Override // com.tencent.mobileqq.nearbypro.base.f
    @NotNull
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public IPicLoader a() {
        return f();
    }

    @NotNull
    public final IPicLoader f() {
        return (IPicLoader) loader.getValue();
    }

    @Override // com.tencent.mobileqq.nearbypro.base.f
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void b(@NotNull Option op5, @Nullable IPicLoadStateListener listener) {
        Intrinsics.checkNotNullParameter(op5, "op");
        op5.disableHardwareDecode();
        f().loadImage(op5, listener);
    }
}
