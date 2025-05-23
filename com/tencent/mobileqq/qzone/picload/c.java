package com.tencent.mobileqq.qzone.picload;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.PageHierarchy;
import com.tencent.component.media.image.ImageKey;
import com.tencent.component.media.image.ImageManager;
import com.tencent.libra.IPicLoader;
import com.tencent.libra.LibraPicLoaderFactory;
import com.tencent.libra.cache.ICache;
import com.tencent.libra.cache.i;
import com.tencent.libra.decode.LibraRequestKey;
import com.tencent.libra.download.LibraDownloadKey;
import com.tencent.libra.extension.gif.h;
import com.tencent.libra.listener.ILoaderResultListener;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.IpConnectConfig;
import com.tencent.libra.request.Option;
import com.tencent.libra.resource.IResourceDrawableFactory;
import com.tencent.libra.strategy.ILibraGlobalStrategy;
import com.tencent.libra.strategy.ILibraLibraryStrategy;
import com.tencent.libra.thread.ITaskExecutor;
import com.tencent.libra.util.LibraConfigUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.picload.listener.RFWPicLoaderResultListener;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.cn;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQZoneEnvApi;
import com.tencent.theme.SkinnableBitmapDrawable;
import common.config.service.QzoneConfig;
import cooperation.qzone.api.QZoneApiProxy;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static volatile c f279318d;

    /* renamed from: a, reason: collision with root package name */
    private final IPicLoader f279319a;

    /* renamed from: b, reason: collision with root package name */
    private final String f279320b;

    /* renamed from: c, reason: collision with root package name */
    private final Map<String, Integer> f279321c;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    private static class b implements ILibraGlobalStrategy {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
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

        /* synthetic */ b(a aVar) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qzone.picload.c$c, reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public static class C8489c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private String f279322a;

        /* renamed from: b, reason: collision with root package name */
        private String f279323b;

        /* renamed from: c, reason: collision with root package name */
        private int f279324c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f279325d;

        public C8489c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f279323b = "";
            }
        }

        public C8489c e(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (C8489c) iPatchRedirector.redirect((short) 4, (Object) this, i3);
            }
            this.f279324c = i3;
            return this;
        }

        public C8489c f(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (C8489c) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            }
            this.f279323b = str;
            return this;
        }

        public C8489c g(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (C8489c) iPatchRedirector.redirect((short) 5, (Object) this, z16);
            }
            this.f279325d = z16;
            return this;
        }

        public C8489c h(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (C8489c) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            }
            this.f279322a = str;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    private static class d implements ILibraLibraryStrategy, QzoneConfig.QzoneConfigChangeListener {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        /* loaded from: classes16.dex */
        class a implements com.tencent.libra.cache.c {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this);
                }
            }

            @Override // com.tencent.libra.cache.c
            public Business getBusiness(Option option) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (Business) iPatchRedirector.redirect((short) 2, (Object) this, (Object) option);
                }
                return Business.QZone;
            }

            @Override // com.tencent.libra.cache.c
            public /* synthetic */ PageHierarchy getSubBusiness(Option option) {
                return com.tencent.libra.cache.b.b(this, option);
            }
        }

        public d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                QzoneConfig.getInstance().addListener(this);
                a();
            }
        }

        private void a() {
            com.tencent.mobileqq.qzone.picload.b.f279315a.d();
        }

        @Override // com.tencent.libra.strategy.ILibraLibraryStrategy
        public String getBusinessName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "qzone";
        }

        @Override // com.tencent.libra.strategy.ILibraBaseStrategy
        public ICache getCustomCache() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (ICache) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return new i(new a());
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
            arrayList.add(new com.tencent.libra.extension.a());
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
            return new RFWPicLoaderResultListener("5");
        }

        @Override // com.tencent.libra.strategy.ILibraBaseStrategy
        public IpConnectConfig getIpConnectConfig(@NonNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (IpConnectConfig) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            }
            return com.tencent.mobileqq.qzone.picload.b.f279315a.b(str);
        }

        @Override // com.tencent.libra.strategy.ILibraBaseStrategy
        @NonNull
        public w01.a getLibraIpStrategyBean() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (w01.a) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            w01.a aVar = new w01.a();
            aVar.h(true);
            LibraConfigUtil libraConfigUtil = LibraConfigUtil.INSTANCE;
            aVar.g(libraConfigUtil.enableIpFailBlacklist());
            aVar.i(libraConfigUtil.enableIpRaceStrategy());
            return aVar;
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

        @Override // common.config.service.QzoneConfig.QzoneConfigChangeListener
        public void onConfigChange() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, (Object) this);
            } else {
                QLog.i("QZonePicLoader", 1, "onConfigChange update ipConfig");
            }
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        if (!QZoneApiProxy.isQZonePluginInit() && MobileQQ.sMobileQQ.peekAppRuntime() != null && MobileQQ.PACKAGE_NAME.equals(BaseApplication.processName)) {
            MobileQQ mobileQQ = MobileQQ.sMobileQQ;
            QZoneApiProxy.initEnv(mobileQQ, mobileQQ.peekAppRuntime());
            MobileQQ mobileQQ2 = MobileQQ.sMobileQQ;
            QZoneApiProxy.initServlet(mobileQQ2, mobileQQ2.peekAppRuntime());
            ((IQZoneEnvApi) QRoute.api(IQZoneEnvApi.class)).initImageEnv();
        }
        LibraPicLoaderFactory.setGlobalPicLoadStrategy(new b(null));
        this.f279319a = LibraPicLoaderFactory.getPicLoader(new d());
        this.f279320b = new File(ImageManager.getCachePath(MobileQQ.sMobileQQ)).getAbsolutePath();
        this.f279321c = new ConcurrentHashMap();
    }

    public static c a() {
        if (f279318d == null) {
            synchronized (c.class) {
                if (f279318d == null) {
                    f279318d = new c();
                }
            }
        }
        return f279318d;
    }

    public static Option e(String str) {
        Option url = Option.obtain().setUrl(str);
        a().n(url);
        if (!TextUtils.isEmpty(url.getLocalPath())) {
            url.setCacheKey(new LibraRequestKey.Builder(new LibraDownloadKey(url.getLocalPath())).build());
        }
        return url;
    }

    private boolean f() {
        if (QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_RETURN_EMPTY_PATH_WHEN_COPY_FAIL, 1) == 1) {
            return true;
        }
        return false;
    }

    public Drawable b(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (Drawable) iPatchRedirector.redirect((short) 16, (Object) this, (Object) context, (Object) str);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.startsWith("qui_")) {
            str = "qui_" + str;
        }
        Integer num = this.f279321c.get(str);
        try {
            if (num != null) {
                return ResourcesCompat.getDrawable(context.getResources(), num.intValue(), null);
            }
            Integer valueOf = Integer.valueOf(context.getResources().getIdentifier(str, "drawable", MobileQQ.sMobileQQ.getPackageName()));
            this.f279321c.put(str, valueOf);
            return ResourcesCompat.getDrawable(context.getResources(), valueOf.intValue(), null);
        } catch (Exception e16) {
            QLog.e("QZonePicLoader", 1, e16.getMessage(), e16);
            return null;
        }
    }

    public IPicLoader c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (IPicLoader) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f279319a;
    }

    public String d(@NonNull Option option) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this, (Object) option);
        }
        String str = this.f279320b + File.separator + ImageManager.urlKey2FileName(ImageKey.getUrlKey(option.getUrl(), true), true);
        if (str.startsWith("/qzone") && f()) {
            QLog.i("QZonePicLoader", 2, "return empty path when copy fail");
            return this.f279319a.getPicLocalPath(option);
        }
        return str;
    }

    public void g(ImageView imageView, Drawable drawable, @ColorInt int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, imageView, drawable, Integer.valueOf(i3));
        } else if (imageView != null && drawable != null && i3 != 0) {
            imageView.setImageDrawable(l(drawable, i3));
        }
    }

    public void h(@NonNull Option option) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) option);
        } else {
            i(option, null);
        }
    }

    public void i(@NonNull Option option, IPicLoadStateListener iPicLoadStateListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) option, (Object) iPicLoadStateListener);
            return;
        }
        option.disableHardwareDecode();
        com.tencent.libra.util.a.f118813a.t(option, true);
        n(option);
        this.f279319a.loadImage(option, iPicLoadStateListener);
    }

    public boolean j(ImageView imageView, C8489c c8489c) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) imageView, (Object) c8489c)).booleanValue();
        }
        if (c8489c == null) {
            QLog.e("QZonePicLoader", 1, "loadImageParam is null");
            return false;
        }
        Drawable b16 = b(imageView.getContext(), c8489c.f279322a);
        if (!c8489c.f279325d) {
            imageView.setVisibility(0);
        }
        if (b16 != null) {
            Drawable mutate = b16.mutate();
            if (mutate instanceof SkinnableBitmapDrawable) {
                mutate = ((SkinnableBitmapDrawable) mutate).mutate2();
            }
            if (c8489c.f279324c != 0) {
                mutate.setColorFilter(imageView.getResources().getColor(c8489c.f279324c), PorterDuff.Mode.SRC_IN);
            }
            imageView.setImageDrawable(mutate);
            return true;
        }
        if (!TextUtils.isEmpty(c8489c.f279323b)) {
            a().h(Option.obtain().setUrl(c8489c.f279323b).setTargetView(imageView));
            return true;
        }
        if (!c8489c.f279325d) {
            imageView.setVisibility(8);
        }
        return false;
    }

    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            this.f279319a.release();
        }
    }

    public Drawable l(Drawable drawable, @ColorInt int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (Drawable) iPatchRedirector.redirect((short) 15, (Object) this, (Object) drawable, i3);
        }
        if (drawable != null && i3 != 0) {
            Drawable f16 = cn.f(drawable);
            if (f16 == null) {
                return drawable;
            }
            f16.setColorFilter(i3, PorterDuff.Mode.SRC_IN);
            return f16;
        }
        return null;
    }

    public void m(ImageView imageView, @ColorInt int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) imageView, i3);
        } else if (imageView != null && imageView.getDrawable() != null) {
            g(imageView, imageView.getDrawable(), i3);
        }
    }

    public void n(Option option) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) option);
            return;
        }
        if (ImageManager.isNetworkUrl(option.getUrl()) && TextUtils.isEmpty(option.getLocalPath())) {
            String d16 = d(option);
            if (!d16.startsWith("/qzone")) {
                option.setLocalPath(d16);
            }
        }
    }
}
