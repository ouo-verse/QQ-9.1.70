package com.tencent.mobileqq.qqecommerce.biz.kuikly.adapter;

import android.graphics.ImageDecoder;
import android.graphics.drawable.Drawable;
import android.os.Build;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.PageHierarchy;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.libra.IPicLoader;
import com.tencent.libra.LibraPicLoaderFactory;
import com.tencent.libra.LoadState;
import com.tencent.libra.cache.EngineResource;
import com.tencent.libra.cache.ICache;
import com.tencent.libra.cache.Key;
import com.tencent.libra.cache.Resource;
import com.tencent.libra.decode.LibraRequestKey;
import com.tencent.libra.download.ILibraDownloader;
import com.tencent.libra.download.LibraDownloadKey;
import com.tencent.libra.listener.ILoaderResultListener;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.IpConnectConfig;
import com.tencent.libra.request.Option;
import com.tencent.libra.resource.IResourceDrawableFactory;
import com.tencent.libra.strategy.ILibraLibraryStrategy;
import com.tencent.libra.thread.ITaskExecutor;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcircle.picload.listener.RFWPicLoaderResultListener;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001/B\t\b\u0002\u00a2\u0006\u0004\b-\u0010.J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J$\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0003J,\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J9\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00042'\u0010\u0015\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\r\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\b0\u0011j\u0002`\u0014H\u0003J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0004H\u0002J\u001a\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0018\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\u001f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001e2\u0006\u0010\u000b\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J*\u0010!\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u001eH\u0002J\u000e\u0010\"\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002J\"\u0010#\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u001e\u0010,\u001a\n )*\u0004\u0018\u00010(0(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/adapter/QQKuiklyPicLoader;", "", "Lcom/tencent/libra/request/Option;", "option", "", "imageCacheKey", "Lcom/tencent/libra/listener/IPicLoadStateListener;", "listener", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "imageOption", "u", "Landroid/graphics/drawable/Drawable;", "drawable", "w", "path", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lcom/tencent/ecommerce/base/imageloader/api/Callback;", "callback", "j", "", HippyTKDListViewAdapter.X, "url", "r", "Lcom/tencent/libra/decode/LibraRequestKey;", "p", DomainData.DOMAIN_NAME, "Lcom/tencent/libra/cache/Resource;", "o", "nonOwnedDrawableResource", tl.h.F, ReportConstant.COSTREPORT_PREFIX, "t", "Lcom/tencent/libra/cache/i;", "b", "Lcom/tencent/libra/cache/i;", "cache", "Lcom/tencent/libra/IPicLoader;", "kotlin.jvm.PlatformType", "c", "Lcom/tencent/libra/IPicLoader;", "picLoader", "<init>", "()V", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class QQKuiklyPicLoader {

    /* renamed from: a, reason: collision with root package name */
    public static final QQKuiklyPicLoader f262774a = new QQKuiklyPicLoader();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final com.tencent.libra.cache.i cache = new com.tencent.libra.cache.i(new c());

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static IPicLoader picLoader = LibraPicLoaderFactory.getPicLoader(new a());

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0011\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H\u0016J\u0012\u0010\u0016\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150\u0014H\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/adapter/QQKuiklyPicLoader$a;", "Lcom/tencent/libra/strategy/ILibraLibraryStrategy;", "", "getBusinessName", "Lcom/tencent/libra/listener/ILoaderResultListener;", "getGlobalResultListener", "Lcom/tencent/libra/resource/IResourceDrawableFactory;", "getDrawableFactory", "Lcom/tencent/libra/thread/ITaskExecutor;", "getTaskExecutor", "", "isSupportActiveResources", "()Ljava/lang/Boolean;", "url", "getUniKeyFromUrl", "Lcom/tencent/libra/cache/ICache;", "getCustomCache", "", "Lcom/tencent/libra/download/ILibraDownloader;", "getCustomDownloaders", "", "Lr01/a;", "getCustomDecoder", "<init>", "()V", "d", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    private static final class a implements ILibraLibraryStrategy {
        @Override // com.tencent.libra.strategy.ILibraLibraryStrategy
        public String getBusinessName() {
            return "kuikly";
        }

        @Override // com.tencent.libra.strategy.ILibraBaseStrategy
        public ICache getCustomCache() {
            return QQKuiklyPicLoader.cache;
        }

        @Override // com.tencent.libra.strategy.ILibraBaseStrategy
        public List<r01.a<?>> getCustomDecoder() {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new z01.b());
            arrayList.add(new com.tencent.libra.extension.avif.b());
            arrayList.add(new com.tencent.libra.extension.gif.h());
            return arrayList;
        }

        @Override // com.tencent.libra.strategy.ILibraBaseStrategy
        public List<ILibraDownloader> getCustomDownloaders() {
            return null;
        }

        @Override // com.tencent.libra.strategy.ILibraBaseStrategy
        public IResourceDrawableFactory getDrawableFactory() {
            return null;
        }

        @Override // com.tencent.libra.strategy.ILibraBaseStrategy
        public ILoaderResultListener getGlobalResultListener() {
            return new RFWPicLoaderResultListener("7");
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
        public ITaskExecutor getTaskExecutor() {
            return null;
        }

        @Override // com.tencent.libra.strategy.ILibraBaseStrategy
        public String getUniKeyFromUrl(String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            return url;
        }

        @Override // com.tencent.libra.strategy.ILibraBaseStrategy
        public Boolean isSupportActiveResources() {
            return null;
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f262778a;

        static {
            int[] iArr = new int[LoadState.values().length];
            try {
                iArr[LoadState.STATE_DOWNLOAD_SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LoadState.STATE_SUCCESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LoadState.STATE_DOWNLOAD_FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[LoadState.STATE_CANCEL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[LoadState.STATE_URL_ILLEGAL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f262778a = iArr;
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/qqecommerce/biz/kuikly/adapter/QQKuiklyPicLoader$c", "Lcom/tencent/libra/cache/c;", "Lcom/tencent/libra/request/Option;", "option", "Lcom/tencent/cache/api/Business;", "getBusiness", "Lcom/tencent/cache/api/PageHierarchy;", "getSubBusiness", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements com.tencent.libra.cache.c {
        c() {
        }

        @Override // com.tencent.libra.cache.c
        public Business getBusiness(Option option) {
            return Business.Default;
        }

        @Override // com.tencent.libra.cache.c
        public PageHierarchy getSubBusiness(Option option) {
            return null;
        }
    }

    QQKuiklyPicLoader() {
    }

    private final void h(Option imageOption, String imageCacheKey, Resource<Drawable> nonOwnedDrawableResource) {
        LibraRequestKey p16 = p(imageOption, imageCacheKey);
        cache.addToCache(p16, new EngineResource(nonOwnedDrawableResource, true, false, p16, new EngineResource.ResourceListener() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.adapter.j
            @Override // com.tencent.libra.cache.EngineResource.ResourceListener
            public final void onResourceReleased(Key key, EngineResource engineResource) {
                QQKuiklyPicLoader.i(key, engineResource);
            }
        }), imageOption);
    }

    private final void j(final String path, final Function1<? super Drawable, Unit> callback) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.adapter.k
            @Override // java.lang.Runnable
            public final void run() {
                QQKuiklyPicLoader.k(path, callback);
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(String path, final Function1 callback) {
        ImageDecoder.Source createSource;
        final Drawable decodeDrawable;
        Intrinsics.checkNotNullParameter(path, "$path");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        try {
            createSource = ImageDecoder.createSource(new File(path));
            Intrinsics.checkNotNullExpressionValue(createSource, "createSource(File(path))");
            decodeDrawable = ImageDecoder.decodeDrawable(createSource);
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.adapter.l
                @Override // java.lang.Runnable
                public final void run() {
                    QQKuiklyPicLoader.l(Function1.this, decodeDrawable);
                }
            });
        } catch (Throwable th5) {
            QLog.e("QQKuiklyPicLoader", 1, "decodeWebpAnimate failed, " + path + ", " + th5);
            callback.invoke(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(Function1 callback, Drawable drawable) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        callback.invoke(drawable);
    }

    private final void m(Option option, IPicLoadStateListener listener) {
        picLoader.download(option, listener);
    }

    private final LibraRequestKey n(Option option, String imageCacheKey) {
        LibraRequestKey build = new LibraRequestKey.Builder(new LibraDownloadKey(imageCacheKey)).setExplicitSize(option.isExplicitSize()).setRequestWith(option.getRequestWidth()).setRequestHeight(option.getRequestHeight()).setRegionScaleType(option.getRegionScaleType()).setNinePatch(option.isNinePatch()).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder(LibraDownloadKey\u2026tch)\n            .build()");
        return build;
    }

    private final Resource<?> o(Option imageOption, String imageCacheKey) {
        return cache.getCache(p(imageOption, imageCacheKey));
    }

    private final LibraRequestKey p(Option option, String imageCacheKey) {
        if (imageCacheKey == null) {
            imageCacheKey = option.getUrl();
        }
        LibraRequestKey build = new LibraRequestKey.Builder(new LibraDownloadKey(imageCacheKey)).setRequestWith(option.getRequestWidth()).setRequestHeight(option.getRequestHeight()).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder(LibraDownloadKey\u2026ght)\n            .build()");
        return build;
    }

    private final boolean r(String url) {
        boolean endsWith;
        endsWith = StringsKt__StringsJVMKt.endsWith(url, ".webp", true);
        return endsWith;
    }

    private final void u(final Option imageOption, final String imageCacheKey, final IPicLoadStateListener listener) {
        Resource<?> o16 = o(imageOption, imageCacheKey);
        if (o16 != null) {
            imageOption.setResource(o16);
            if (listener != null) {
                listener.onStateChange(LoadState.STATE_SUCCESS, imageOption);
                return;
            }
            return;
        }
        m(imageOption, new IPicLoadStateListener() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.adapter.i
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option) {
                QQKuiklyPicLoader.v(Option.this, imageCacheKey, listener, loadState, option);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(final Option imageOption, final String str, final IPicLoadStateListener iPicLoadStateListener, LoadState loadState, Option option) {
        Intrinsics.checkNotNullParameter(imageOption, "$imageOption");
        int i3 = loadState == null ? -1 : b.f262778a[loadState.ordinal()];
        if (i3 == 1 || i3 == 2) {
            QQKuiklyPicLoader qQKuiklyPicLoader = f262774a;
            String localPath = option.getLocalPath();
            Intrinsics.checkNotNullExpressionValue(localPath, "option.localPath");
            qQKuiklyPicLoader.j(localPath, new Function1<Drawable, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.adapter.QQKuiklyPicLoader$loadWebp$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Drawable drawable) {
                    invoke2(drawable);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Drawable drawable) {
                    if (drawable != null) {
                        QQKuiklyPicLoader.f262774a.w(drawable, Option.this, str, iPicLoadStateListener);
                    } else {
                        QQKuiklyPicLoader.f262774a.q(Option.this, str, iPicLoadStateListener);
                    }
                }
            });
            return;
        }
        if (i3 == 3 || i3 == 4 || i3 == 5) {
            QLog.e("QQKuiklyPicLoader", 1, "download webp file failed: " + loadState + ", " + imageOption.getUrl());
            f262774a.q(imageOption, str, iPicLoadStateListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(Drawable drawable, Option imageOption, String imageCacheKey, IPicLoadStateListener listener) {
        Resource<Drawable> b16 = com.tencent.libra.cache.f.b(drawable);
        imageOption.setResource(b16);
        h(imageOption, imageCacheKey, b16);
        if (listener != null) {
            listener.onStateChange(LoadState.STATE_SUCCESS, imageOption);
        }
    }

    private final boolean x(Option option) {
        String url = option.getUrl();
        if (url == null) {
            url = "";
        }
        return Build.VERSION.SDK_INT >= 28 && r(url);
    }

    public final void s(Option option) {
        Intrinsics.checkNotNullParameter(option, "option");
        t(option, null, null);
    }

    public final void t(Option option, String imageCacheKey, IPicLoadStateListener listener) {
        Intrinsics.checkNotNullParameter(option, "option");
        option.disableHardwareDecode();
        if (x(option)) {
            u(option, imageCacheKey, listener);
        } else {
            q(option, imageCacheKey, listener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(Option option, String imageCacheKey, IPicLoadStateListener listener) {
        if (imageCacheKey != null) {
            option.setCacheKey(n(option, imageCacheKey));
        }
        option.setPredecode(true);
        picLoader.loadImage(option, listener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(Key key, EngineResource engineResource) {
    }
}
