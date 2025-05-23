package com.tencent.mobileqq.flock.picloader;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.PageHierarchy;
import com.tencent.libra.IPicLoader;
import com.tencent.libra.LibraPicLoaderFactory;
import com.tencent.libra.cache.ICache;
import com.tencent.libra.cache.c;
import com.tencent.libra.cache.i;
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
import com.tencent.theme.SkinnableBitmapDrawable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes12.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    private static volatile a f210248c;

    /* renamed from: a, reason: collision with root package name */
    private final IPicLoader f210249a;

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, Integer> f210250b;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.flock.picloader.a$a, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    private static class C7607a implements ILibraLibraryStrategy {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.flock.picloader.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes12.dex */
        class C7608a implements c {
            static IPatchRedirector $redirector_;

            C7608a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) C7607a.this);
                }
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

        C7607a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.libra.strategy.ILibraLibraryStrategy
        public String getBusinessName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "flock";
        }

        @Override // com.tencent.libra.strategy.ILibraBaseStrategy
        public ICache getCustomCache() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (ICache) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return new i(new C7608a());
        }

        @Override // com.tencent.libra.strategy.ILibraBaseStrategy
        public List<r01.a<?>> getCustomDecoder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (List) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(new d11.a());
            arrayList.add(new com.tencent.libra.extension.avif.b());
            arrayList.add(new h());
            arrayList.add(new z01.b());
            return arrayList;
        }

        @Override // com.tencent.libra.strategy.ILibraBaseStrategy
        public /* synthetic */ List getCustomDownloaders() {
            return g11.a.c(this);
        }

        @Override // com.tencent.libra.strategy.ILibraBaseStrategy
        public IResourceDrawableFactory getDrawableFactory() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (IResourceDrawableFactory) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return null;
        }

        @Override // com.tencent.libra.strategy.ILibraBaseStrategy
        public ILoaderResultListener getGlobalResultListener() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (ILoaderResultListener) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return null;
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

    /* compiled from: P */
    /* loaded from: classes12.dex */
    private static class b implements ILibraGlobalStrategy {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

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
        public Looper getErrorLooper() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Looper) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return ThreadManagerV2.getQQCommonThreadLooper();
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

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        LibraPicLoaderFactory.setGlobalPicLoadStrategy(new b());
        this.f210249a = LibraPicLoaderFactory.getPicLoader(new C7607a());
        this.f210250b = new ConcurrentHashMap();
    }

    public static a a() {
        if (f210248c == null) {
            synchronized (a.class) {
                if (f210248c == null) {
                    f210248c = new a();
                }
            }
        }
        return f210248c;
    }

    public IPicLoader b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (IPicLoader) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f210249a;
    }

    public void c(@NonNull Option option) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) option);
        } else {
            d(option, null);
        }
    }

    public void d(@NonNull Option option, IPicLoadStateListener iPicLoadStateListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) option, (Object) iPicLoadStateListener);
        } else {
            option.disableHardwareDecode();
            this.f210249a.loadImage(option, iPicLoadStateListener);
        }
    }

    public Drawable e(Drawable drawable, @ColorInt int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Drawable) iPatchRedirector.redirect((short) 13, (Object) this, (Object) drawable, i3);
        }
        if (drawable != null && i3 != 0) {
            Drawable mutate = drawable.mutate();
            if (mutate instanceof SkinnableBitmapDrawable) {
                mutate = ((SkinnableBitmapDrawable) mutate).mutate2();
            }
            mutate.setColorFilter(i3, PorterDuff.Mode.SRC_IN);
            return mutate;
        }
        return null;
    }
}
