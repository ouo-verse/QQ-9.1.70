package com.tencent.qqnt.qbasealbum.urldrawable;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.SystemClock;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.adapter.image.CustomImageProps;
import com.tencent.image.DownloadParams;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.URLState;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import com.tencent.qqnt.qbasealbum.urldrawable.BlobCache;
import com.tencent.qqnt.qbasealbum.urldrawable.d;
import common.config.service.QzoneConfig;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00102\u00020\u0001:\u0001\u001dB\u0011\b\u0002\u0012\u0006\u0010+\u001a\u00020*\u00a2\u0006\u0004\b,\u0010-J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J*\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J2\u0010\u0015\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\rH\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\"\u0010\u001a\u001a\u00020\u00192\b\u0010\u0013\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\"\u0010\u001b\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\u001c\u001a\u00020\u0016R\u0014\u0010\u001f\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010(\u00a8\u0006."}, d2 = {"Lcom/tencent/qqnt/qbasealbum/urldrawable/AlbumThumbManager;", "", "Ljava/net/URL;", "url", "Lcom/tencent/image/DownloadParams;", DownloadInfo.spKey_Config, "", "i", "", "input", "g", "Lcom/tencent/qqnt/qbasealbum/urldrawable/d$a;", "buffer", "", "timeBefore", "Landroid/graphics/Bitmap;", "e", "Lcom/tencent/qqnt/qbasealbum/urldrawable/c;", "decoder", "byteKey", "key", "f", "", "k", "longKey", "", tl.h.F, "j", "d", "a", "Ljava/lang/String;", "blobCacheDir", "Ljava/lang/Object;", "b", "Ljava/lang/Object;", "mBlobLock", "Lcom/tencent/qqnt/qbasealbum/urldrawable/BlobCache;", "c", "Lcom/tencent/qqnt/qbasealbum/urldrawable/BlobCache;", "mBlobCache", "Z", "isThumbKeyUseSize", "Landroid/content/Context;", "mContext", "<init>", "(Landroid/content/Context;)V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class AlbumThumbManager {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: f, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    @Nullable
    private static volatile AlbumThumbManager f361572f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private static final d f361573g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    private static ByteBuffer f361574h;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String blobCacheDir;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Object mBlobLock;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private BlobCache mBlobCache;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isThumbKeyUseSize;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b$\u0010%J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002J\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\fR\u0014\u0010\u0012\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0013R\u0014\u0010\u0019\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0013R\u0014\u0010\u001a\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010\"\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u0006&"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/urldrawable/AlbumThumbManager$a;", "", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", CustomImageProps.QUALITY, "", "b", "key", "buffer", "", "f", "Landroid/content/Context;", "context", "", "d", "Lcom/tencent/qqnt/qbasealbum/urldrawable/AlbumThumbManager;", "e", "BLOB_CACHE_MAX_BYTES", "I", "BLOB_CACHE_MAX_ENTRIES", "BLOB_CACHE_VERSION", "BYTESBUFFER_POOL_SIZE", "BYTESBUFFER_SIZE", "DEFAULT_JPEG_QUALITY", "MEGABYTE", "TAG", "Ljava/lang/String;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "Lcom/tencent/qqnt/qbasealbum/urldrawable/AlbumThumbManager;", "Lcom/tencent/qqnt/qbasealbum/urldrawable/d;", "sCacheBufferPool", "Lcom/tencent/qqnt/qbasealbum/urldrawable/d;", "Ljava/nio/ByteBuffer;", "tempByteBuffer", "Ljava/nio/ByteBuffer;", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.qbasealbum.urldrawable.AlbumThumbManager$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
        }

        private final byte[] b(Bitmap bitmap, int quality) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(65536);
            bitmap.compress(Bitmap.CompressFormat.JPEG, quality, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            Intrinsics.checkNotNullExpressionValue(byteArray, "outputStream.toByteArray()");
            return byteArray;
        }

        static /* synthetic */ byte[] c(Companion companion, Bitmap bitmap, int i3, int i16, Object obj) {
            if ((i16 & 2) != 0) {
                i3 = 70;
            }
            return companion.b(bitmap, i3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean f(byte[] key, byte[] buffer) {
            int length = key.length;
            if (buffer.length < length) {
                return false;
            }
            for (int i3 = 0; i3 < length; i3++) {
                if (key[i3] != buffer[i3]) {
                    return false;
                }
            }
            return true;
        }

        @NotNull
        public final String d(@NotNull Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            }
            Intrinsics.checkNotNullParameter(context, "context");
            if (context.getExternalCacheDir() != null) {
                File externalCacheDir = context.getExternalCacheDir();
                Intrinsics.checkNotNull(externalCacheDir);
                String absolutePath = externalCacheDir.getAbsolutePath();
                Intrinsics.checkNotNullExpressionValue(absolutePath, "{\n                contex\u2026bsolutePath\n            }");
                return absolutePath;
            }
            String absolutePath2 = context.getCacheDir().getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath2, "context.cacheDir.absolutePath");
            return absolutePath2;
        }

        @NotNull
        public final AlbumThumbManager e(@NotNull Context context) {
            AlbumThumbManager albumThumbManager;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (AlbumThumbManager) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
            }
            Intrinsics.checkNotNullParameter(context, "context");
            AlbumThumbManager albumThumbManager2 = AlbumThumbManager.f361572f;
            if (albumThumbManager2 != null) {
                return albumThumbManager2;
            }
            synchronized (this) {
                albumThumbManager = AlbumThumbManager.f361572f;
                if (albumThumbManager == null) {
                    albumThumbManager = new AlbumThumbManager(context, null);
                    if (Intrinsics.areEqual(Build.BRAND, "Sony")) {
                        albumThumbManager.isThumbKeyUseSize = true;
                    }
                    AlbumThumbManager.f361572f = albumThumbManager;
                }
            }
            return albumThumbManager;
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45200);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
            f361573g = new d(4, 204800);
        }
    }

    public /* synthetic */ AlbumThumbManager(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            return;
        }
        iPatchRedirector.redirect((short) 4, (Object) this, (Object) context, (Object) defaultConstructorMarker);
    }

    private final Bitmap e(final URL url, DownloadParams config, final d.a buffer, final long timeBefore) {
        String str;
        URL url2;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        if (config != null && (url2 = config.url) != null) {
            str = url2.getRef();
        } else {
            str = null;
        }
        if (str == null) {
            options.inSampleSize = 1;
        } else {
            options.inJustDecodeBounds = true;
            SafeBitmapFactory.decodeByteArray(buffer.a(), buffer.c(), buffer.b(), options);
            options.inJustDecodeBounds = false;
            options.inSampleSize = URLState.calculateInSampleSize(options, config.reqWidth, config.reqHeight);
        }
        final Bitmap bitmap = SafeBitmapFactory.decodeByteArray(buffer.a(), buffer.c(), buffer.b(), options);
        if (Intrinsics.areEqual(url.getProtocol(), "qbasealbumthumb")) {
            ox3.a.a("QBaseAlbum.Thumb", new Function0<String>(url, timeBefore, buffer, bitmap) { // from class: com.tencent.qqnt.qbasealbum.urldrawable.AlbumThumbManager$createBitMapFromCache$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ Bitmap $bitmap;
                final /* synthetic */ d.a $buffer;
                final /* synthetic */ long $timeBefore;
                final /* synthetic */ URL $url;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$url = url;
                    this.$timeBefore = timeBefore;
                    this.$buffer = buffer;
                    this.$bitmap = bitmap;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, url, Long.valueOf(timeBefore), buffer, bitmap);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                    return "getThumb bitmap from cache, url:" + this.$url + ", cost:" + (SystemClock.uptimeMillis() - this.$timeBefore) + ", sizeDisk:" + this.$buffer.b() + ", sizeMemory:" + this.$bitmap.getByteCount();
                }
            });
        }
        Intrinsics.checkNotNullExpressionValue(bitmap, "bitmap");
        return bitmap;
    }

    private final Bitmap f(final URL url, c decoder, byte[] byteKey, final long timeBefore, long key) {
        final Bitmap bitmap = decoder.getBitmap(url);
        if (bitmap == null) {
            return null;
        }
        final byte[] c16 = Companion.c(INSTANCE, bitmap, 0, 2, null);
        ByteBuffer allocate = ByteBuffer.allocate(byteKey.length + c16.length);
        allocate.put(byteKey);
        allocate.put(c16);
        synchronized (this.mBlobLock) {
            try {
                BlobCache blobCache = this.mBlobCache;
                if (blobCache != null) {
                    byte[] array = allocate.array();
                    Intrinsics.checkNotNullExpressionValue(array, "newBuffer.array()");
                    blobCache.g(key, array);
                    Unit unit = Unit.INSTANCE;
                }
            } catch (IOException e16) {
                ox3.a.d("QBaseAlbum.Thumb", new Function0<String>(e16) { // from class: com.tencent.qqnt.qbasealbum.urldrawable.AlbumThumbManager$createBitMapFromUrl$1$1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ IOException $ex;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        this.$ex = e16;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) e16);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final String invoke() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                        }
                        return "decode thumb ioexception, " + this.$ex;
                    }
                });
                Unit unit2 = Unit.INSTANCE;
            }
        }
        if (Intrinsics.areEqual(url.getProtocol(), "qbasealbumthumb")) {
            ox3.a.a("QBaseAlbum.Thumb", new Function0<String>(url, timeBefore, c16, bitmap) { // from class: com.tencent.qqnt.qbasealbum.urldrawable.AlbumThumbManager$createBitMapFromUrl$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ byte[] $array;
                final /* synthetic */ Bitmap $bitmap;
                final /* synthetic */ long $timeBefore;
                final /* synthetic */ URL $url;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$url = url;
                    this.$timeBefore = timeBefore;
                    this.$array = c16;
                    this.$bitmap = bitmap;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, url, Long.valueOf(timeBefore), c16, bitmap);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                    return "getThumb bitmap from decode, url:" + this.$url + ", cost:" + (SystemClock.uptimeMillis() - this.$timeBefore) + ", sizeDisk:" + this.$array.length + ", sizeMemory:" + this.$bitmap.getByteCount();
                }
            });
        }
        return bitmap;
    }

    private final byte[] g(String input) {
        byte[] bArr = new byte[input.length() * 2];
        char[] charArray = input.toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "this as java.lang.String).toCharArray()");
        int i3 = 0;
        for (char c16 : charArray) {
            int i16 = i3 + 1;
            bArr[i3] = (byte) (c16 & '\u00ff');
            i3 = i16 + 1;
            bArr[i16] = (byte) (c16 >> '\b');
        }
        return bArr;
    }

    private final boolean h(byte[] byteKey, long longKey, d.a buffer) {
        if (byteKey != null && this.mBlobCache != null) {
            k();
            try {
                BlobCache.a aVar = new BlobCache.a();
                aVar.e(longKey);
                aVar.d(buffer.a());
                synchronized (this.mBlobLock) {
                    BlobCache blobCache = this.mBlobCache;
                    Intrinsics.checkNotNull(blobCache);
                    if (!blobCache.k(aVar)) {
                        return false;
                    }
                    Unit unit = Unit.INSTANCE;
                    Companion companion = INSTANCE;
                    byte[] a16 = aVar.a();
                    Intrinsics.checkNotNull(a16);
                    if (companion.f(byteKey, a16)) {
                        byte[] a17 = aVar.a();
                        Intrinsics.checkNotNull(a17);
                        buffer.d(a17);
                        buffer.f(byteKey.length);
                        buffer.e(aVar.c() - buffer.c());
                        return true;
                    }
                }
            } catch (IOException e16) {
                ox3.a.d("QBaseAlbum.Thumb", new Function0<String>(e16) { // from class: com.tencent.qqnt.qbasealbum.urldrawable.AlbumThumbManager$getCacheData$3
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ IOException $ex;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        this.$ex = e16;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) e16);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final String invoke() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                        }
                        return "getCacheData ioexception, " + this.$ex;
                    }
                });
            }
        }
        return false;
    }

    private final byte[] i(URL url, DownloadParams config) {
        Object obj;
        boolean z16;
        long fileSize;
        String str = "NT";
        if (this.isThumbKeyUseSize) {
            if (config != null) {
                obj = config.tag;
            } else {
                obj = null;
            }
            if (obj instanceof LocalMediaInfo) {
                Object obj2 = config.tag;
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type com.tencent.qqnt.qbasealbum.model.LocalMediaInfo");
                LocalMediaInfo localMediaInfo = (LocalMediaInfo) obj2;
                if (localMediaInfo.getModifiedDate() != 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    fileSize = localMediaInfo.getModifiedDate();
                } else {
                    fileSize = localMediaInfo.getFileSize();
                }
                str = "NT" + fileSize;
            }
        }
        return g(url.toString() + str);
    }

    private final synchronized void k() {
        if (this.mBlobCache != null) {
            return;
        }
        String str = this.blobCacheDir + "/atb";
        try {
            File file = new File(this.blobCacheDir);
            if (!file.exists()) {
                file.mkdirs();
            }
            this.mBlobCache = new BlobCache(str, 20000, QzoneConfig.DefaultValue.DEFAUL_VIDEO_TRIM_MIN_AVAIL_RAM, false, 1);
        } catch (Exception e16) {
            QLog.e("QBaseAlbum.Thumb", 2, "init blobcache", e16);
        }
    }

    public final synchronized void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        f361573g.a();
        f361574h = null;
        ox3.a.c("QBaseAlbum.Thumb", AlbumThumbManager$clear$1.INSTANCE);
    }

    @Nullable
    public final Bitmap j(@NotNull final URL url, @NotNull c decoder, @Nullable DownloadParams config) {
        long j3;
        final long j16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Bitmap) iPatchRedirector.redirect((short) 2, this, url, decoder, config);
        }
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        byte[] i3 = i(url, config);
        d dVar = f361573g;
        d.a b16 = dVar.b();
        long uptimeMillis = SystemClock.uptimeMillis();
        long a16 = e.f361612a.a(i3);
        try {
            try {
                if (h(i3, a16, b16)) {
                    Bitmap e16 = e(url, config, b16, uptimeMillis);
                    dVar.c(b16);
                    return e16;
                }
                j3 = uptimeMillis;
                try {
                    Bitmap f16 = f(url, decoder, i3, uptimeMillis, a16);
                    if (f16 != null) {
                        dVar.c(b16);
                        return f16;
                    }
                    dVar.c(b16);
                    return null;
                } catch (OutOfMemoryError e17) {
                    e = e17;
                    j16 = j3;
                    ox3.a.d("QBaseAlbum.Thumb", new Function0<String>(e) { // from class: com.tencent.qqnt.qbasealbum.urldrawable.AlbumThumbManager$getThumb$1
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ OutOfMemoryError $e;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                            this.$e = e;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) e);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function0
                        @NotNull
                        public final String invoke() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                            }
                            return "decode thumb, " + this.$e;
                        }
                    });
                    if (Intrinsics.areEqual(url.getProtocol(), "qbasealbumthumb")) {
                        ox3.a.a("QBaseAlbum.Thumb", new Function0<String>(url, j16) { // from class: com.tencent.qqnt.qbasealbum.urldrawable.AlbumThumbManager$getThumb$2
                            static IPatchRedirector $redirector_;
                            final /* synthetic */ long $timeBefore;
                            final /* synthetic */ URL $url;

                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                                this.$url = url;
                                this.$timeBefore = j16;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, this, url, Long.valueOf(j16));
                                }
                            }

                            @Override // kotlin.jvm.functions.Function0
                            @NotNull
                            public final String invoke() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                                }
                                return "getThumb bitmap OutOfMemoryError,url:" + this.$url + " cost:" + (SystemClock.uptimeMillis() - this.$timeBefore);
                            }
                        });
                    }
                    return null;
                } catch (Throwable th5) {
                    th = th5;
                    ox3.a.d("QBaseAlbum.Thumb", new Function0<String>(th) { // from class: com.tencent.qqnt.qbasealbum.urldrawable.AlbumThumbManager$getThumb$3
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ Throwable $e1;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                            this.$e1 = th;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) th);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function0
                        @NotNull
                        public final String invoke() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                            }
                            return "decode thumb, " + this.$e1;
                        }
                    });
                    if (Intrinsics.areEqual(url.getProtocol(), "qbasealbumthumb")) {
                        final long j17 = j3;
                        ox3.a.a("QBaseAlbum.Thumb", new Function0<String>(url, j17) { // from class: com.tencent.qqnt.qbasealbum.urldrawable.AlbumThumbManager$getThumb$4
                            static IPatchRedirector $redirector_;
                            final /* synthetic */ long $timeBefore;
                            final /* synthetic */ URL $url;

                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                                this.$url = url;
                                this.$timeBefore = j17;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, this, url, Long.valueOf(j17));
                                }
                            }

                            @Override // kotlin.jvm.functions.Function0
                            @NotNull
                            public final String invoke() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                                }
                                return "getThumb bitmap Throwable,url:" + this.$url + " cost:" + (SystemClock.uptimeMillis() - this.$timeBefore);
                            }
                        });
                    }
                    return null;
                }
            } catch (OutOfMemoryError e18) {
                e = e18;
                j16 = uptimeMillis;
            } catch (Throwable th6) {
                th = th6;
                j3 = uptimeMillis;
            }
        } finally {
            f361573g.c(b16);
        }
    }

    AlbumThumbManager(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.blobCacheDir = INSTANCE.d(context) + "/qbasealbum/blob/";
        this.mBlobLock = new Object();
        k();
    }
}
