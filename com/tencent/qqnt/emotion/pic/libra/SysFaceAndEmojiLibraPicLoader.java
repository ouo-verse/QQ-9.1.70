package com.tencent.qqnt.emotion.pic.libra;

import android.content.ComponentCallbacks2;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.libra.IPicLoader;
import com.tencent.libra.LibraPicLoaderFactory;
import com.tencent.libra.cache.ICache;
import com.tencent.libra.download.ILibraDownloader;
import com.tencent.libra.listener.ILoaderResultListener;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.IpConnectConfig;
import com.tencent.libra.request.Option;
import com.tencent.libra.resource.IResourceDrawableFactory;
import com.tencent.libra.strategy.ILibraGlobalStrategy;
import com.tencent.libra.strategy.ILibraLibraryStrategy;
import com.tencent.libra.thread.ITaskExecutor;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResMgr;
import com.tencent.mobileqq.emoticon.QQSysFaceSwitcher;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Foreground;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00172\u00020\u0001:\u0003\u0010\u0017\u0018B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fR\u001b\u0010\u0014\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/qqnt/emotion/pic/libra/SysFaceAndEmojiLibraPicLoader;", "", "Lcom/tencent/libra/IPicLoader;", "f", "Landroidx/lifecycle/LifecycleOwner;", "d", "Lcom/tencent/libra/request/Option;", "option", "Lcom/tencent/libra/listener/IPicLoadStateListener;", "listener", "", "i", "Lcom/tencent/qqnt/emotion/pic/libra/j;", "sysFaceAndEmojiLibraPicOption", "Lvw3/a;", "g", "a", "Lkotlin/Lazy;", "e", "()Lcom/tencent/libra/IPicLoader;", "innerPicLoader", "<init>", "()V", "b", "c", "emotionpanel_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class SysFaceAndEmojiLibraPicLoader {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final Lazy<SysFaceAndEmojiLibraPicLoader> f356319c;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy innerPicLoader;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/emotion/pic/libra/SysFaceAndEmojiLibraPicLoader$a;", "", "Lcom/tencent/qqnt/emotion/pic/libra/SysFaceAndEmojiLibraPicLoader;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/qqnt/emotion/pic/libra/SysFaceAndEmojiLibraPicLoader;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "", "TAG", "Ljava/lang/String;", "<init>", "()V", "emotionpanel_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.emotion.pic.libra.SysFaceAndEmojiLibraPicLoader$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final SysFaceAndEmojiLibraPicLoader a() {
            return (SysFaceAndEmojiLibraPicLoader) SysFaceAndEmojiLibraPicLoader.f356319c.getValue();
        }

        Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/qqnt/emotion/pic/libra/SysFaceAndEmojiLibraPicLoader$b;", "Lcom/tencent/libra/strategy/ILibraGlobalStrategy;", "Landroid/os/Looper;", "getErrorLooper", "<init>", "()V", "emotionpanel_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class b implements ILibraGlobalStrategy {
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
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\n\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\bH\u0016J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\bH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqnt/emotion/pic/libra/SysFaceAndEmojiLibraPicLoader$c;", "Lcom/tencent/libra/strategy/ILibraLibraryStrategy;", "", "getBusinessName", "Lcom/tencent/libra/cache/ICache;", "getCustomCache", "Lcom/tencent/libra/thread/ITaskExecutor;", "getTaskExecutor", "", "Lr01/a;", "getCustomDecoder", "Lcom/tencent/libra/download/ILibraDownloader;", "getCustomDownloaders", "<init>", "()V", "emotionpanel_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class c implements ILibraLibraryStrategy {
        @Override // com.tencent.libra.strategy.ILibraLibraryStrategy
        @NotNull
        public String getBusinessName() {
            return "QQSysAndEmoji";
        }

        @Override // com.tencent.libra.strategy.ILibraBaseStrategy
        @NotNull
        public ICache getCustomCache() {
            return new f();
        }

        @Override // com.tencent.libra.strategy.ILibraBaseStrategy
        @NotNull
        public List<r01.a<?>> getCustomDecoder() {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new com.tencent.libra.extension.gif.h());
            if (QQSysFaceSwitcher.f204652a.t()) {
                arrayList.add(new c11.b(BaseApplication.getContext().getResources()));
            } else {
                arrayList.add(new d());
            }
            return arrayList;
        }

        @Override // com.tencent.libra.strategy.ILibraBaseStrategy
        @NotNull
        public List<ILibraDownloader> getCustomDownloaders() {
            ArrayList arrayListOf;
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(g.f356335d);
            return arrayListOf;
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
        @Nullable
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

    static {
        Lazy<SysFaceAndEmojiLibraPicLoader> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) SysFaceAndEmojiLibraPicLoader$Companion$instance$2.INSTANCE);
        f356319c = lazy;
    }

    public SysFaceAndEmojiLibraPicLoader() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<IPicLoader>() { // from class: com.tencent.qqnt.emotion.pic.libra.SysFaceAndEmojiLibraPicLoader$innerPicLoader$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final IPicLoader invoke() {
                IPicLoader f16;
                f16 = SysFaceAndEmojiLibraPicLoader.this.f();
                return f16;
            }
        });
        this.innerPicLoader = lazy;
    }

    private final LifecycleOwner d() {
        Object lastOrNull;
        ComponentCallbacks2 topActivity = Foreground.getTopActivity();
        if (topActivity == null) {
            return null;
        }
        if (!(topActivity instanceof FragmentActivity)) {
            if (!(topActivity instanceof LifecycleOwner)) {
                return null;
            }
            return (LifecycleOwner) topActivity;
        }
        List<Fragment> fragments = ((FragmentActivity) topActivity).getSupportFragmentManager().getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "topActivity.supportFragmentManager.fragments");
        lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) fragments);
        return (LifecycleOwner) lastOrNull;
    }

    private final IPicLoader e() {
        return (IPicLoader) this.innerPicLoader.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IPicLoader f() {
        LibraPicLoaderFactory.setGlobalPicLoadStrategy(new b());
        IPicLoader picLoader = LibraPicLoaderFactory.getPicLoader(new c());
        Intrinsics.checkNotNullExpressionValue(picLoader, "getPicLoader(PicLoadStrategy())");
        return picLoader;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(SysFaceAndEmojiLibraPicLoader this$0, vw3.a sysAndEmojiLibraDrawable, SysFaceAndEmojiLibraPicOption sysFaceAndEmojiLibraPicOption, Drawable loadingDrawable) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(sysAndEmojiLibraDrawable, "$sysAndEmojiLibraDrawable");
        Intrinsics.checkNotNullParameter(sysFaceAndEmojiLibraPicOption, "$sysFaceAndEmojiLibraPicOption");
        Intrinsics.checkNotNullParameter(loadingDrawable, "$loadingDrawable");
        Option libraPicOption = Option.obtain();
        libraPicOption.setLocalPath(QQSysAndEmojiResMgr.getInstance().getFullResPath(sysFaceAndEmojiLibraPicOption.getPicType(), sysFaceAndEmojiLibraPicOption.getEmoId()));
        libraPicOption.setLoadingDrawable(loadingDrawable);
        libraPicOption.setFailedDrawable(loadingDrawable);
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put("extraKeyEmoType", Integer.valueOf(sysFaceAndEmojiLibraPicOption.getEmoType()));
        concurrentHashMap.put("extraKeyEmoId", Integer.valueOf(sysFaceAndEmojiLibraPicOption.getEmoId()));
        concurrentHashMap.put("extraKeyPicType", Integer.valueOf(sysFaceAndEmojiLibraPicOption.getPicType()));
        libraPicOption.setExtraData(concurrentHashMap);
        Intrinsics.checkNotNullExpressionValue(libraPicOption, "libraPicOption");
        this$0.i(libraPicOption, sysAndEmojiLibraDrawable.b());
    }

    private final void i(Option option, IPicLoadStateListener listener) {
        option.disableHardwareDecode();
        e().loadImage(option, listener);
    }

    @NotNull
    public final vw3.a g(@NotNull final SysFaceAndEmojiLibraPicOption sysFaceAndEmojiLibraPicOption) {
        Intrinsics.checkNotNullParameter(sysFaceAndEmojiLibraPicOption, "sysFaceAndEmojiLibraPicOption");
        final Drawable loadingDrawable = sysFaceAndEmojiLibraPicOption.getLoadingDrawable();
        final vw3.a aVar = new vw3.a(loadingDrawable);
        QQSysFaceSwitcher qQSysFaceSwitcher = QQSysFaceSwitcher.f204652a;
        if (qQSysFaceSwitcher.m()) {
            Option libraPicOption = Option.obtain();
            libraPicOption.setLocalPath(QQSysAndEmojiResMgr.getInstance().getFullResPath(sysFaceAndEmojiLibraPicOption.getPicType(), QQSysFaceUtil.convertToServer(sysFaceAndEmojiLibraPicOption.getEmoId())));
            libraPicOption.setLoadingDrawable(loadingDrawable);
            libraPicOption.setFailedDrawable(loadingDrawable);
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            concurrentHashMap.put("extraKeyEmoType", Integer.valueOf(sysFaceAndEmojiLibraPicOption.getEmoType()));
            concurrentHashMap.put("extraKeyEmoId", Integer.valueOf(sysFaceAndEmojiLibraPicOption.getEmoId()));
            concurrentHashMap.put("extraKeyPicType", Integer.valueOf(sysFaceAndEmojiLibraPicOption.getPicType()));
            libraPicOption.setExtraData(concurrentHashMap);
            if (qQSysFaceSwitcher.u()) {
                libraPicOption.setLifecycleOwner(d());
            }
            Intrinsics.checkNotNullExpressionValue(libraPicOption, "libraPicOption");
            i(libraPicOption, aVar.b());
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.emotion.pic.libra.h
                @Override // java.lang.Runnable
                public final void run() {
                    SysFaceAndEmojiLibraPicLoader.h(SysFaceAndEmojiLibraPicLoader.this, aVar, sysFaceAndEmojiLibraPicOption, loadingDrawable);
                }
            }, 64, null, true);
        }
        return aVar;
    }
}
