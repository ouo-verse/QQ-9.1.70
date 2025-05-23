package com.tencent.mobileqq.picloader;

import android.os.Looper;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.libra.IPicLoader;
import com.tencent.libra.LibraPicLoaderFactory;
import com.tencent.libra.LoadState;
import com.tencent.libra.cache.BitmapPool;
import com.tencent.libra.cache.EngineResource;
import com.tencent.libra.cache.ICache;
import com.tencent.libra.decode.LibraRequestKey;
import com.tencent.libra.download.ILibraDownloader;
import com.tencent.libra.extension.gif.h;
import com.tencent.libra.listener.ILoaderResultListener;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.IpConnectConfig;
import com.tencent.libra.request.Option;
import com.tencent.libra.resource.IResourceDrawableFactory;
import com.tencent.libra.strategy.ILibraGlobalStrategy;
import com.tencent.libra.strategy.ILibraLibraryStrategy;
import com.tencent.libra.thread.ITaskExecutor;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOPicDownloaderProvider;
import com.tencent.qqnt.aio.adapter.api.IPicLoaderApi;
import g11.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00122\u00020\u0001:\u0004\u000b\u0012\r\u0003B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bR\u001b\u0010\u000f\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/picloader/PicLoader;", "", "Lcom/tencent/libra/IPicLoader;", "d", "Lcom/tencent/libra/request/Option;", "option", "", "e", "Lcom/tencent/libra/listener/IPicLoadStateListener;", "listener", "f", "a", "Lkotlin/Lazy;", "c", "()Lcom/tencent/libra/IPicLoader;", "innerPicLoader", "<init>", "()V", "b", "pic_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class PicLoader {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final Lazy<PicLoader> f258930c;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy innerPicLoader;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/picloader/PicLoader$a;", "", "Lcom/tencent/mobileqq/picloader/PicLoader;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/mobileqq/picloader/PicLoader;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "", "TAG", "Ljava/lang/String;", "<init>", "()V", "pic_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.picloader.PicLoader$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final PicLoader a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (PicLoader) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return (PicLoader) PicLoader.f258930c.getValue();
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/picloader/PicLoader$b;", "Lcom/tencent/libra/strategy/ILibraGlobalStrategy;", "Landroid/os/Looper;", "getErrorLooper", "<init>", "()V", "pic_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class b implements ILibraGlobalStrategy {
        static IPatchRedirector $redirector_;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
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

        @Override // com.tencent.libra.strategy.ILibraGlobalStrategy
        @NotNull
        public Looper getErrorLooper() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Looper) iPatchRedirector.redirect((short) 2, (Object) this);
            }
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

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\f\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b0\nH\u0016J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\nH\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/picloader/PicLoader$c;", "Lcom/tencent/libra/strategy/ILibraLibraryStrategy;", "", "getBusinessName", "Lcom/tencent/libra/cache/ICache;", "getCustomCache", "Lcom/tencent/libra/listener/ILoaderResultListener;", "getGlobalResultListener", "Lcom/tencent/libra/thread/ITaskExecutor;", "getTaskExecutor", "", "Lr01/a;", "getCustomDecoder", "Lcom/tencent/libra/download/ILibraDownloader;", "getCustomDownloaders", "<init>", "()V", "pic_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class c implements ILibraLibraryStrategy {
        static IPatchRedirector $redirector_;

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.libra.strategy.ILibraLibraryStrategy
        @NotNull
        public String getBusinessName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "tim";
        }

        @Override // com.tencent.libra.strategy.ILibraBaseStrategy
        @NotNull
        public ICache getCustomCache() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (ICache) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return new d();
        }

        @Override // com.tencent.libra.strategy.ILibraBaseStrategy
        @NotNull
        public List<r01.a<?>> getCustomDecoder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (List) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(new h());
            arrayList.add(new com.tencent.libra.extension.avif.b());
            arrayList.add(new com.tencent.libra.extension.a());
            arrayList.add(new com.tencent.libra.extension.b());
            return arrayList;
        }

        @Override // com.tencent.libra.strategy.ILibraBaseStrategy
        @NotNull
        public List<ILibraDownloader> getCustomDownloaders() {
            ArrayList arrayListOf;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
                arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(((IAIOPicDownloaderProvider) QRoute.api(IAIOPicDownloaderProvider.class)).provideDownloader());
                return arrayListOf;
            }
            return (List) iPatchRedirector.redirect((short) 7, (Object) this);
        }

        @Override // com.tencent.libra.strategy.ILibraBaseStrategy
        public /* synthetic */ IResourceDrawableFactory getDrawableFactory() {
            return a.d(this);
        }

        @Override // com.tencent.libra.strategy.ILibraBaseStrategy
        @NotNull
        public ILoaderResultListener getGlobalResultListener() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (ILoaderResultListener) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return ((IPicLoaderApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IPicLoaderApi.class)).getLoadResultListener();
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
        @Nullable
        public ITaskExecutor getTaskExecutor() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (ITaskExecutor) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return null;
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

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J*\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\f\u0010\u0006\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0012\u0010\r\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u000e\u001a\u00020\tH\u0016R8\u0010\u0015\u001a&\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00100\u0010 \u0011*\u0012\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00100\u0010\u0018\u00010\u00120\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/picloader/PicLoader$d;", "Lcom/tencent/libra/cache/ICache;", "Lcom/tencent/libra/decode/LibraRequestKey;", "key", "Lcom/tencent/libra/cache/EngineResource;", "getCache", "engineResource", "Lcom/tencent/libra/request/Option;", "option", "", "addToCache", "", "getCacheSize", "removeCache", "clearAll", "", "", "kotlin.jvm.PlatformType", "", "a", "Ljava/util/Set;", "mAllInjectCacheKey", "<init>", "()V", "pic_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class d implements ICache {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final Set<String> mAllInjectCacheKey;

        public d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.mAllInjectCacheKey = Collections.synchronizedSet(new HashSet());
            }
        }

        @Override // com.tencent.libra.cache.ICache
        public void addToCache(@Nullable LibraRequestKey key, @Nullable EngineResource<?> engineResource, @Nullable Option option) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, key, engineResource, option);
                return;
            }
            if (key != null && engineResource != null) {
                String libraRequestKey = key.toString();
                Intrinsics.checkNotNullExpressionValue(libraRequestKey, "key.toString()");
                this.mAllInjectCacheKey.add(libraRequestKey);
                ImageCacheHelper.f98636a.i(libraRequestKey, new com.tencent.mobileqq.pic.picloader.a(engineResource), Business.AIO);
            }
        }

        @Override // com.tencent.libra.cache.ICache
        public void clearAll() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this);
                return;
            }
            Iterator<String> it = this.mAllInjectCacheKey.iterator();
            while (it.hasNext()) {
                ImageCacheHelper.f98636a.m(it.next());
            }
            this.mAllInjectCacheKey.clear();
        }

        @Override // com.tencent.libra.cache.ICache
        public /* synthetic */ BitmapPool getBitmapPool() {
            return com.tencent.libra.cache.d.a(this);
        }

        @Override // com.tencent.libra.cache.ICache
        @Nullable
        public EngineResource<?> getCache(@Nullable LibraRequestKey key) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (EngineResource) iPatchRedirector.redirect((short) 2, (Object) this, (Object) key);
            }
            Object g16 = ImageCacheHelper.f98636a.g(String.valueOf(key));
            if (g16 instanceof com.tencent.mobileqq.pic.picloader.a) {
                return ((com.tencent.mobileqq.pic.picloader.a) g16).a();
            }
            return null;
        }

        @Override // com.tencent.libra.cache.ICache
        public int getCacheSize() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return com.tencent.cache.core.manager.api.c.f98725d.f().getFirst().intValue();
        }

        @Override // com.tencent.libra.cache.ICache
        public void removeCache(@Nullable LibraRequestKey key) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) key);
            } else {
                if (key == null) {
                    return;
                }
                String libraRequestKey = key.toString();
                Intrinsics.checkNotNullExpressionValue(libraRequestKey, "key.toString()");
                this.mAllInjectCacheKey.remove(libraRequestKey);
                ImageCacheHelper.f98636a.m(libraRequestKey);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/picloader/PicLoader$e", "Lcom/tencent/libra/listener/IPicLoadStateListener;", "Lcom/tencent/libra/LoadState;", "state", "Lcom/tencent/libra/request/Option;", "option", "", "onStateChange", "pic_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class e implements IPicLoadStateListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(@Nullable LoadState state, @Nullable Option option) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) state, (Object) option);
                return;
            }
            if (QLog.isColorLevel()) {
                if (option != null) {
                    str = option.getUrl();
                } else {
                    str = null;
                }
                QLog.i("PicLoader", 2, "loadPic CBack state: " + state + " path: " + str);
            }
        }
    }

    static {
        Lazy<PicLoader> lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29433);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        INSTANCE = new Companion(null);
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) PicLoader$Companion$instance$2.INSTANCE);
        f258930c = lazy;
    }

    public PicLoader() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<IPicLoader>() { // from class: com.tencent.mobileqq.picloader.PicLoader$innerPicLoader$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PicLoader.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final IPicLoader invoke() {
                    IPicLoader d16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (IPicLoader) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    d16 = PicLoader.this.d();
                    return d16;
                }
            });
            this.innerPicLoader = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IPicLoader d() {
        LibraPicLoaderFactory.setGlobalPicLoadStrategy(new b());
        IPicLoader picLoader = LibraPicLoaderFactory.getPicLoader(new c());
        Intrinsics.checkNotNullExpressionValue(picLoader, "getPicLoader(PicLoadStrategy())");
        return picLoader;
    }

    @NotNull
    public final IPicLoader c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (IPicLoader) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return (IPicLoader) this.innerPicLoader.getValue();
    }

    public final void e(@NotNull Option option) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) option);
            return;
        }
        Intrinsics.checkNotNullParameter(option, "option");
        option.disableHardwareDecode();
        c().loadImage(option, new e());
    }

    public final void f(@NotNull Option option, @Nullable IPicLoadStateListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) option, (Object) listener);
            return;
        }
        Intrinsics.checkNotNullParameter(option, "option");
        option.disableHardwareDecode();
        c().loadImage(option, listener);
    }
}
