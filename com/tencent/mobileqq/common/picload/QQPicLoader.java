package com.tencent.mobileqq.common.picload;

import android.graphics.drawable.Animatable;
import com.tencent.libra.IPicLoader;
import com.tencent.libra.cache.i;
import com.tencent.libra.extension.avif.b;
import com.tencent.libra.extension.gif.h;
import com.tencent.libra.listener.ILoaderResultListener;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.IpConnectConfig;
import com.tencent.libra.request.Option;
import com.tencent.libra.resource.IResourceDrawableFactory;
import com.tencent.libra.strategy.ILibraLibraryStrategy;
import com.tencent.libra.thread.ITaskExecutor;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
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

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0016B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\u0002J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007R\u001b\u0010\u000f\u001a\u00020\u000b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0004\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0013\u001a\u00020\u00108FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/common/picload/QQPicLoader;", "", "Lr01/a;", "Landroid/graphics/drawable/Animatable;", "b", "Lcom/tencent/libra/request/Option;", "op", "Lcom/tencent/libra/listener/IPicLoadStateListener;", "listener", "", "e", "Lcom/tencent/libra/IPicLoader;", "Lkotlin/Lazy;", "d", "()Lcom/tencent/libra/IPicLoader;", "loader", "Lcom/tencent/libra/cache/i;", "c", "()Lcom/tencent/libra/cache/i;", "cache", "<init>", "()V", "a", "qq-picload-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class QQPicLoader {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final QQPicLoader f201806a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy loader;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy cache;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\t\u001a\u0012\u0012\u000e\u0012\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\b0\u00070\u0006H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/common/picload/QQPicLoader$a;", "Lcom/tencent/libra/strategy/ILibraLibraryStrategy;", "", "getBusinessName", "Lcom/tencent/libra/cache/i;", "a", "", "Lr01/a;", "", "getCustomDecoder", "<init>", "()V", "qq-picload-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    public static final class a implements ILibraLibraryStrategy {
        static IPatchRedirector $redirector_;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.libra.strategy.ILibraBaseStrategy
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public i getCustomCache() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (i) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return QQPicLoader.f201806a.c();
        }

        @Override // com.tencent.libra.strategy.ILibraLibraryStrategy
        @NotNull
        public String getBusinessName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "QQCommon";
        }

        @Override // com.tencent.libra.strategy.ILibraBaseStrategy
        @NotNull
        public List<r01.a<? extends Object>> getCustomDecoder() {
            List<r01.a<? extends Object>> mutableListOf;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new h(), new b(), QQPicLoader.f201806a.b(), new d11.a());
                return mutableListOf;
            }
            return (List) iPatchRedirector.redirect((short) 4, (Object) this);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42242);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        f201806a = new QQPicLoader();
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) QQPicLoader$loader$2.INSTANCE);
        loader = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(QQPicLoader$cache$2.INSTANCE);
        cache = lazy2;
    }

    QQPicLoader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final r01.a<Animatable> b() {
        int i3 = 1;
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qq_pic_loader_use_apng_lib", true);
        QLog.i("QQPicLoader", 1, "getAPNGDecoder switchOn:" + isSwitchOn);
        if (isSwitchOn) {
            return new c11.b(null, i3, 0 == true ? 1 : 0);
        }
        return new z01.b();
    }

    @NotNull
    public final i c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (i) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return (i) cache.getValue();
    }

    @NotNull
    public final IPicLoader d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (IPicLoader) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        Object value = loader.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-loader>(...)");
        return (IPicLoader) value;
    }

    public final void e(@NotNull Option op5, @Nullable IPicLoadStateListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) op5, (Object) listener);
            return;
        }
        Intrinsics.checkNotNullParameter(op5, "op");
        op5.disableHardwareDecode();
        d().loadImage(op5, listener);
    }
}
