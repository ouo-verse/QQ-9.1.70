package com.tencent.qqmini.proxyimpl;

import android.content.Context;
import android.os.Environment;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.mini.cache.DiskLruCache;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.CacheProxy;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.core.utils.ImageItem;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@ProxyService(proxy = com.tencent.qqmini.sdk.core.utils.a.class)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001:\u0002\u000b\u0010B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0016R\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/qqmini/proxyimpl/CacheProxy;", "Lcom/tencent/qqmini/sdk/core/utils/a;", "", "key", "f", "Lcom/tencent/qqmini/sdk/core/utils/ImageItem;", "get", "", "has", "value", "", "a", "Lcom/tencent/qqmini/proxyimpl/CacheProxy$b;", "Lcom/tencent/qqmini/proxyimpl/CacheProxy$b;", "memoryCache", "Lcom/tencent/qqmini/proxyimpl/CacheProxy$a;", "b", "Lcom/tencent/qqmini/proxyimpl/CacheProxy$a;", "fileCache", "c", "Ljava/lang/String;", "TAG", "d", "PRE", "<init>", "()V", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class CacheProxy implements com.tencent.qqmini.sdk.core.utils.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final b memoryCache = new b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final a fileCache = new a();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final String TAG = "CacheProxy";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final String PRE = "MINI_IMG_CACHE_PROXY";

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\"\u0010#J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u0004H\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0004H\u0016J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\tH\u0016R\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00108\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0011R\u0014\u0010\u0017\u001a\u00020\u00108\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0011R\u0014\u0010\u0019\u001a\u00020\u00108\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0011R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006$"}, d2 = {"Lcom/tencent/qqmini/proxyimpl/CacheProxy$a;", "Lcom/tencent/qqmini/sdk/core/utils/a;", "Landroid/content/Context;", "context", "", "uniqueName", "Ljava/io/File;", "b", "key", "Lcom/tencent/qqmini/sdk/core/utils/ImageItem;", "get", "", "has", "value", "", "a", "", "I", "VALUE_COUNT", "MIME_TYPE", "c", "IMG_CONTENT", "d", "cacheVersion", "e", "maxSize", "Ljava/lang/Object;", "f", "Ljava/lang/Object;", "ioObj", "Lcom/tencent/mobileqq/mini/cache/DiskLruCache;", "g", "Lcom/tencent/mobileqq/mini/cache/DiskLruCache;", AppConstants.PATH_URLDRAWABLE_DISKCACHE, "<init>", "()V", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a implements com.tencent.qqmini.sdk.core.utils.a {

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final int MIME_TYPE;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        private final DiskLruCache diskcache;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int VALUE_COUNT = 2;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final int IMG_CONTENT = 1;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int cacheVersion = 1;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final int maxSize = 10485760;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final Object ioObj = new Object();

        public a() {
            BaseApplication context = BaseApplication.context;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            DiskLruCache open = DiskLruCache.open(b(context, "miniAppImgCache"), 1, 2, 10485760);
            Intrinsics.checkNotNullExpressionValue(open, "open(\n                ge\u2026ze.toLong()\n            )");
            this.diskcache = open;
        }

        private final File b(Context context, String uniqueName) {
            String path;
            if (!Intrinsics.areEqual("mounted", Environment.getExternalStorageState()) && Environment.isExternalStorageRemovable()) {
                path = context.getCacheDir().getPath();
                Intrinsics.checkNotNullExpressionValue(path, "{\n                    co\u2026ir.path\n                }");
            } else {
                File externalCacheDir = context.getExternalCacheDir();
                Intrinsics.checkNotNull(externalCacheDir);
                path = externalCacheDir.getPath();
                Intrinsics.checkNotNullExpressionValue(path, "{\n                    co\u2026!!.path\n                }");
            }
            return new File(path + File.separator + uniqueName);
        }

        @Override // com.tencent.qqmini.sdk.core.utils.a
        public void a(String key, ImageItem value) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            if (value.d() != null) {
                synchronized (this.ioObj) {
                    try {
                        QLog.i("DiskCacheImpl", 1, "set disk cache " + key);
                        DiskLruCache.Editor edit = this.diskcache.edit(key);
                        if (edit != null) {
                            Intrinsics.checkNotNullExpressionValue(edit, "edit(key)");
                            OutputStream newOutputStream = edit.newOutputStream(this.MIME_TYPE);
                            try {
                                String str = value.f348072a;
                                Intrinsics.checkNotNullExpressionValue(str, "value.mimeType");
                                byte[] bytes = str.getBytes(Charsets.UTF_8);
                                Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                                newOutputStream.write(bytes);
                                Unit unit = Unit.INSTANCE;
                                CloseableKt.closeFinally(newOutputStream, null);
                                newOutputStream = edit.newOutputStream(this.IMG_CONTENT);
                                try {
                                    newOutputStream.write(value.d());
                                    CloseableKt.closeFinally(newOutputStream, null);
                                    edit.commit();
                                } finally {
                                }
                            } finally {
                            }
                        }
                    } catch (IOException e16) {
                        QLog.e("DiskCacheImpl", 1, e16, new Object[0]);
                        Unit unit2 = Unit.INSTANCE;
                    }
                }
            }
        }

        @Override // com.tencent.qqmini.sdk.core.utils.a
        public ImageItem get(String key) {
            Intrinsics.checkNotNullParameter(key, "key");
            synchronized (this.ioObj) {
                if (has(key)) {
                    try {
                        DiskLruCache.Snapshot snapshot = this.diskcache.get(key);
                        InputStream inputStream = snapshot.getInputStream(this.MIME_TYPE);
                        Intrinsics.checkNotNullExpressionValue(inputStream, "snapshot.getInputStream(MIME_TYPE)");
                        String str = new String(ByteStreamsKt.readBytes(inputStream), Charsets.UTF_8);
                        snapshot.getInputStream(this.MIME_TYPE).close();
                        return new ImageItem(str, snapshot.getInputStream(this.IMG_CONTENT));
                    } catch (IOException e16) {
                        QLog.e("DiskCacheImpl", 1, e16, new Object[0]);
                    }
                }
                Unit unit = Unit.INSTANCE;
                return null;
            }
        }

        @Override // com.tencent.qqmini.sdk.core.utils.a
        public boolean has(String key) {
            Intrinsics.checkNotNullParameter(key, "key");
            try {
                DiskLruCache.Snapshot snapshot = this.diskcache.get(key);
                boolean z16 = snapshot != null;
                if (snapshot != null) {
                    snapshot.close();
                }
                return z16;
            } catch (IOException e16) {
                QLog.e("DiskCacheImpl", 1, e16, new Object[0]);
                return false;
            }
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqmini/proxyimpl/CacheProxy$b;", "Lcom/tencent/qqmini/sdk/core/utils/a;", "", "key", "Lcom/tencent/qqmini/sdk/core/utils/ImageItem;", "get", "", "has", "value", "", "a", "<init>", "()V", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements com.tencent.qqmini.sdk.core.utils.a {
        @Override // com.tencent.qqmini.sdk.core.utils.a
        public void a(String key, ImageItem value) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            QLog.i("MemoryCacheImpl", 1, "set memory cache, key:" + key);
            if (value.d() != null) {
                ImageCacheHelper imageCacheHelper = ImageCacheHelper.f98636a;
                String str = value.f348072a;
                Intrinsics.checkNotNullExpressionValue(str, "value.mimeType");
                imageCacheHelper.i(key, new aa(str, value), Business.Conversation);
            }
        }

        @Override // com.tencent.qqmini.sdk.core.utils.a
        public ImageItem get(String key) {
            Intrinsics.checkNotNullParameter(key, "key");
            QLog.i("MemoryCacheImpl", 1, "get memory cache, key:" + key);
            Object g16 = ImageCacheHelper.f98636a.g(key);
            if (g16 instanceof aa) {
                return ((aa) g16).getCom.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME java.lang.String();
            }
            return null;
        }

        @Override // com.tencent.qqmini.sdk.core.utils.a
        public boolean has(String key) {
            Intrinsics.checkNotNullParameter(key, "key");
            Object g16 = ImageCacheHelper.f98636a.g(key);
            if (g16 != null && (g16 instanceof aa)) {
                QLog.i("MemoryCacheImpl", 1, "has memory cache, key:" + key);
                return ((aa) g16).getCom.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME java.lang.String().d() != null;
            }
            QLog.i("MemoryCacheImpl", 1, "no memory cache, key:" + key);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String f(String key) {
        return this.PRE + key;
    }

    @Override // com.tencent.qqmini.sdk.core.utils.a
    public void a(final String key, final ImageItem value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        f.b(new Function0<Unit>() { // from class: com.tencent.qqmini.proxyimpl.CacheProxy$set$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                String f16;
                String str;
                CacheProxy.b bVar;
                CacheProxy.a aVar;
                f16 = CacheProxy.this.f(key);
                str = CacheProxy.this.TAG;
                QLog.i(str, 1, "set,key:" + f16);
                bVar = CacheProxy.this.memoryCache;
                bVar.a(f16, value);
                aVar = CacheProxy.this.fileCache;
                aVar.a(f16, value);
            }
        });
    }

    @Override // com.tencent.qqmini.sdk.core.utils.a
    public ImageItem get(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        String f16 = f(key);
        if (this.memoryCache.has(f16)) {
            QLog.i(this.TAG, 1, "get memorycache,key:" + f16);
            return this.memoryCache.get(f16);
        }
        QLog.i(this.TAG, 1, "get filecache,key:" + f16);
        ImageItem imageItem = this.fileCache.get(f16);
        if (imageItem != null) {
            this.memoryCache.a(f16, imageItem);
        }
        return imageItem;
    }

    @Override // com.tencent.qqmini.sdk.core.utils.a
    public boolean has(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        String f16 = f(key);
        return this.memoryCache.has(f16) || this.fileCache.has(f16);
    }
}
