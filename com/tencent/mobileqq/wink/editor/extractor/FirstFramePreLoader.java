package com.tencent.mobileqq.wink.editor.extractor;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.Handler;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.wink.editor.clipping.thumbnail.ThumbAssetModel;
import com.tencent.mobileqq.wink.editor.clipping.thumbnail.ThumbnailGeneratorHelper;
import com.tencent.mobileqq.wink.editor.clipping.thumbnail.m;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.videocut.model.MediaType;
import common.config.service.QzoneConfig;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001,B\t\b\u0002\u00a2\u0006\u0004\b*\u0010+J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007J\b\u0010\b\u001a\u00020\u0006H\u0007J\b\u0010\t\u001a\u00020\u0006H\u0007J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u000e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0004J\u0006\u0010\u000f\u001a\u00020\u0006J\u0016\u0010\u0010\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bJ\u0016\u0010\u0011\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001b\u0010!\u001a\u00020\u001c8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/extractor/FirstFramePreLoader;", "", "Landroid/graphics/Bitmap;", "g", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "localMediaInfo", "", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "p", "mediaInfo", "Lcom/tencent/videocut/model/MediaType;", "type", tl.h.F, "o", "i", "j", "l", "", "mp4Path", "", DomainData.DOMAIN_NAME, "b", "Landroid/graphics/Bitmap;", "cachedBm", "c", "Ljava/lang/String;", "cachedCoverVideoPath", "Landroid/os/Handler;", "d", "Lkotlin/Lazy;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/os/Handler;", "generateHandler", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/ThumbnailGeneratorHelper;", "e", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/ThumbnailGeneratorHelper;", "generatorHelper", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/d;", "f", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/d;", "runnableHandler", "<init>", "()V", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class FirstFramePreLoader {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static Bitmap cachedBm;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy generateHandler;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static ThumbnailGeneratorHelper generatorHelper;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final com.tencent.mobileqq.wink.editor.clipping.thumbnail.d runnableHandler;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final FirstFramePreLoader f320286a = new FirstFramePreLoader();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String cachedCoverVideoPath = "invalid_path";

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0015\u0010\u0016J$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/extractor/FirstFramePreLoader$a;", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/e;", "", "tag", "", "startTimeMs", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "a", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "getMediaInfo", "()Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "mediaInfo", "Lcom/tencent/videocut/model/MediaType;", "b", "Lcom/tencent/videocut/model/MediaType;", "getMediaType", "()Lcom/tencent/videocut/model/MediaType;", "mediaType", "<init>", "(Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;Lcom/tencent/videocut/model/MediaType;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a implements com.tencent.mobileqq.wink.editor.clipping.thumbnail.e {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final LocalMediaInfo mediaInfo;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final MediaType mediaType;

        public a(@NotNull LocalMediaInfo mediaInfo, @NotNull MediaType mediaType) {
            Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
            Intrinsics.checkNotNullParameter(mediaType, "mediaType");
            this.mediaInfo = mediaInfo;
            this.mediaType = mediaType;
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0060  */
        @Override // com.tencent.mobileqq.wink.editor.clipping.thumbnail.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(@Nullable Object tag, long startTimeMs, @Nullable Bitmap bitmap) {
            ThumbnailGeneratorHelper thumbnailGeneratorHelper;
            ThumbnailGeneratorHelper thumbnailGeneratorHelper2;
            ThumbAssetModel model;
            boolean z16;
            if (startTimeMs == 0) {
                w53.b.f("FirstFramePreLoader", "[extractFirstFrame] succeed");
                if (this.mediaType == MediaType.IMAGE) {
                    String str = this.mediaInfo.path;
                    if (str != null && str.length() != 0) {
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                    if (!z16) {
                        int k3 = com.tencent.mobileqq.wink.utils.f.k(this.mediaInfo.path);
                        if (k3 == 0) {
                            FirstFramePreLoader.cachedBm = bitmap;
                        } else {
                            FirstFramePreLoader firstFramePreLoader = FirstFramePreLoader.f320286a;
                            FirstFramePreLoader.cachedBm = com.tencent.mobileqq.wink.utils.f.s(k3, bitmap);
                        }
                        thumbnailGeneratorHelper = FirstFramePreLoader.generatorHelper;
                        if (thumbnailGeneratorHelper != null || (model = thumbnailGeneratorHelper.getModel()) == null || (r3 = model.getAssetPath()) == null) {
                            String str2 = "invalid_path";
                        }
                        FirstFramePreLoader.cachedCoverVideoPath = str2;
                        thumbnailGeneratorHelper2 = FirstFramePreLoader.generatorHelper;
                        if (thumbnailGeneratorHelper2 != null) {
                            thumbnailGeneratorHelper2.release();
                        }
                        FirstFramePreLoader.generatorHelper = null;
                    }
                }
                FirstFramePreLoader.cachedBm = bitmap;
                thumbnailGeneratorHelper = FirstFramePreLoader.generatorHelper;
                if (thumbnailGeneratorHelper != null) {
                }
                String str22 = "invalid_path";
                FirstFramePreLoader.cachedCoverVideoPath = str22;
                thumbnailGeneratorHelper2 = FirstFramePreLoader.generatorHelper;
                if (thumbnailGeneratorHelper2 != null) {
                }
                FirstFramePreLoader.generatorHelper = null;
            }
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f320294a;

        static {
            int[] iArr = new int[MediaType.values().length];
            try {
                iArr[MediaType.IMAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MediaType.VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f320294a = iArr;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/wink/editor/extractor/FirstFramePreLoader$c", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/d;", "Ljava/lang/Runnable;", "runnable", "", "postRunnable", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c implements com.tencent.mobileqq.wink.editor.clipping.thumbnail.d {
        c() {
        }

        @Override // com.tencent.mobileqq.wink.editor.clipping.thumbnail.d
        public void postRunnable(@Nullable Runnable runnable) {
            Handler m3 = FirstFramePreLoader.f320286a.m();
            if (runnable == null) {
                return;
            }
            m3.postAtFrontOfQueue(runnable);
        }
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Handler>() { // from class: com.tencent.mobileqq.wink.editor.extractor.FirstFramePreLoader$generateHandler$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Handler invoke() {
                BaseHandlerThread baseHandlerThread = new BaseHandlerThread("FirstFramePreLoader", 0);
                baseHandlerThread.start();
                return new Handler(baseHandlerThread.getLooper());
            }
        });
        generateHandler = lazy;
        runnableHandler = new c();
    }

    FirstFramePreLoader() {
    }

    @JvmStatic
    @Nullable
    public static final Bitmap g() {
        Bitmap bitmap = cachedBm;
        if (bitmap != null) {
            boolean z16 = false;
            if (bitmap != null && bitmap.isRecycled()) {
                z16 = true;
            }
            if (!z16) {
                w53.b.f("FirstFramePreLoader", "consumeFirstFrame");
                return cachedBm;
            }
        }
        w53.b.f("FirstFramePreLoader", "consumeFirstFrame  null");
        return null;
    }

    private final void h(LocalMediaInfo mediaInfo, MediaType type) {
        m mVar = new m(new a(mediaInfo, type), mediaInfo.mediaWidth, mediaInfo.mediaHeight, runnableHandler);
        ThumbnailGeneratorHelper thumbnailGeneratorHelper = generatorHelper;
        if (thumbnailGeneratorHelper != null) {
            thumbnailGeneratorHelper.release();
        }
        String str = mediaInfo.path;
        Intrinsics.checkNotNullExpressionValue(str, "mediaInfo.path");
        ThumbnailGeneratorHelper thumbnailGeneratorHelper2 = new ThumbnailGeneratorHelper(mVar, new ThumbAssetModel(str, type.ordinal(), mediaInfo.mDuration * 1000));
        generatorHelper = thumbnailGeneratorHelper2;
        thumbnailGeneratorHelper2.a(0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(LocalMediaInfo mediaInfo, MediaType type) {
        Intrinsics.checkNotNullParameter(mediaInfo, "$mediaInfo");
        Intrinsics.checkNotNullParameter(type, "$type");
        f320286a.l(mediaInfo, type);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Handler m() {
        return (Handler) generateHandler.getValue();
    }

    @JvmStatic
    public static final void p() {
        cachedBm = null;
        cachedCoverVideoPath = "invalid_path";
        ThumbnailGeneratorHelper thumbnailGeneratorHelper = generatorHelper;
        if (thumbnailGeneratorHelper != null) {
            thumbnailGeneratorHelper.release();
        }
        generatorHelper = null;
    }

    @JvmStatic
    public static final void q() {
        w53.b.f("FirstFramePreLoader", "reset");
        Bitmap bitmap = cachedBm;
        if (bitmap != null) {
            bitmap.recycle();
        }
        cachedBm = null;
        cachedCoverVideoPath = "invalid_path";
        ThumbnailGeneratorHelper thumbnailGeneratorHelper = generatorHelper;
        if (thumbnailGeneratorHelper != null) {
            thumbnailGeneratorHelper.release();
        }
        generatorHelper = null;
    }

    @JvmStatic
    public static final void r(@Nullable LocalMediaInfo localMediaInfo) {
        if (localMediaInfo == null) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            String str = localMediaInfo.path;
            Intrinsics.checkNotNullExpressionValue(str, "localMediaInfo.path");
            new BitmapFactory.Options().inJustDecodeBounds = true;
            cachedBm = BitmapFactory.decodeFile(str);
            Result.m476constructorimpl(Unit.INSTANCE);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
    }

    public final void i() {
        ThumbnailGeneratorHelper thumbnailGeneratorHelper = generatorHelper;
        if (thumbnailGeneratorHelper != null) {
            thumbnailGeneratorHelper.release();
        }
        generatorHelper = null;
    }

    public final void j(@NotNull final LocalMediaInfo mediaInfo, @NotNull final MediaType type) {
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        Intrinsics.checkNotNullParameter(type, "type");
        int i3 = b.f320294a[type.ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                if (QzoneConfig.enableFirstEditorFrame(((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount())) {
                    m().postAtFrontOfQueue(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.extractor.h
                        @Override // java.lang.Runnable
                        public final void run() {
                            FirstFramePreLoader.k(LocalMediaInfo.this, type);
                        }
                    });
                    return;
                } else {
                    h(mediaInfo, type);
                    return;
                }
            }
            return;
        }
        h(mediaInfo, type);
    }

    public final void l(@NotNull LocalMediaInfo mediaInfo, @NotNull MediaType type) {
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        Intrinsics.checkNotNullParameter(type, "type");
        w53.b.f("FirstFramePreLoader", "getFrameBitmap");
        String str = mediaInfo.path;
        Intrinsics.checkNotNullExpressionValue(str, "mediaInfo.path");
        Bitmap bitmap = null;
        if (n(str)) {
            w53.b.f("FirstFramePreLoader", "getFrameBitmap skip HDR Video: " + mediaInfo.path);
            cachedBm = null;
            return;
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(mediaInfo.path);
            bitmap = mediaMetadataRetriever.getFrameAtTime();
        } finally {
            try {
                cachedBm = bitmap;
                w53.b.f("FirstFramePreLoader", "getFrameBitmap--end");
            } finally {
            }
        }
        cachedBm = bitmap;
        w53.b.f("FirstFramePreLoader", "getFrameBitmap--end");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0042, code lost:
    
        if (r4.containsKey("color-standard") == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0049, code lost:
    
        if (r4.getInteger("color-standard") != 6) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x004b, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004f, code lost:
    
        return r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean n(@NotNull String mp4Path) {
        boolean startsWith$default;
        Intrinsics.checkNotNullParameter(mp4Path, "mp4Path");
        boolean z16 = false;
        if (Build.VERSION.SDK_INT < 24) {
            return false;
        }
        MediaExtractor mediaExtractor = new MediaExtractor();
        try {
            try {
                mediaExtractor.setDataSource(mp4Path);
                int trackCount = mediaExtractor.getTrackCount();
                int i3 = 0;
                while (true) {
                    if (i3 >= trackCount) {
                        break;
                    }
                    MediaFormat trackFormat = mediaExtractor.getTrackFormat(i3);
                    Intrinsics.checkNotNullExpressionValue(trackFormat, "extractor.getTrackFormat(i)");
                    String string = trackFormat.getString("mime");
                    if (string != null) {
                        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(string, "video", false, 2, null);
                        if (startsWith$default) {
                            break;
                        }
                    }
                    i3++;
                }
            } catch (Exception e16) {
                w53.b.d("FirstFramePreLoader", "Error checking HDR status", e16);
            }
            return false;
        } finally {
            mediaExtractor.release();
        }
    }

    public final void o(@NotNull LocalMediaInfo mediaInfo) {
        MediaType mediaType;
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        w53.b.f("FirstFramePreLoader", "[preloadFirstFrameAsync] start");
        if (e93.i.E(mediaInfo)) {
            cachedBm = null;
            cachedCoverVideoPath = "invalid_path";
        } else {
            if (!Intrinsics.areEqual(cachedCoverVideoPath, "invalid_path") && Intrinsics.areEqual(mediaInfo.path, cachedCoverVideoPath)) {
                w53.b.f("FirstFramePreLoader", "[preloadFirstFrameAsync] cache hit");
                return;
            }
            cachedBm = null;
            cachedCoverVideoPath = "invalid_path";
            if (e93.i.G(mediaInfo)) {
                mediaType = MediaType.IMAGE;
            } else {
                mediaType = MediaType.VIDEO;
            }
            j(mediaInfo, mediaType);
        }
    }
}
