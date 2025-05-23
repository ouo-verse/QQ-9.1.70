package f11;

import android.app.Application;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.util.Size;
import androidx.annotation.WorkerThread;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import java.io.File;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b%\u0010&J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u001a\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0013\u001a\u00020\u0002H\u0002J\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J!\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0013\u001a\u00020\u0002H\u0002J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0012\u0010 \u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001f\u001a\u00020\u001eH\u0002J\u001c\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060!2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u001a\u0010$\u001a\u0004\u0018\u00010\u00042\b\u0010#\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006'"}, d2 = {"Lf11/c;", "", "", "videoPath", "Landroid/graphics/Bitmap;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "maxSize", DomainData.DOMAIN_NAME, "Landroid/content/res/AssetFileDescriptor;", "descriptor", "p", "i", "Landroid/net/Uri;", LayoutAttrDefine.CLICK_URI, "j", "k", MimeHelper.IMAGE_SUBTYPE_BITMAP, "b", "path", "g", "Landroid/content/Context;", "context", "o", "", "a", "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/Long;", "c", "f", "e", "Landroid/media/MediaMetadataRetriever;", "retriever", "d", "Lkotlin/Pair;", h.F, "videoUri", "l", "<init>", "()V", "libra-extension-video_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f397590a = new c();

    c() {
    }

    private final Long a(Context context, String videoPath) {
        Cursor query = ContactsMonitor.query(context.getContentResolver(), MediaStore.Video.Media.EXTERNAL_CONTENT_URI, new String[]{"_id"}, "_data=?", new String[]{videoPath}, null);
        if (query == null) {
            RFWLog.w("RFWVideoUtils", RFWLog.USR, "[convertFileUriToContentUri] failed, path=" + videoPath);
            return null;
        }
        Cursor cursor = query;
        try {
            Cursor cursor2 = cursor;
            if (cursor2.moveToFirst()) {
                Long valueOf = Long.valueOf(cursor2.getLong(cursor2.getColumnIndexOrThrow("_id")));
                CloseableKt.closeFinally(cursor, null);
                return valueOf;
            }
            CloseableKt.closeFinally(cursor, null);
            return null;
        } finally {
        }
    }

    private final Bitmap b(Bitmap bitmap, int maxSize) {
        int roundToInt;
        int roundToInt2;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int min = Math.min(width, height);
        if (min > maxSize) {
            float f16 = maxSize / min;
            roundToInt = MathKt__MathJVMKt.roundToInt(width * f16);
            roundToInt2 = MathKt__MathJVMKt.roundToInt(f16 * height);
            try {
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, roundToInt, roundToInt2, true);
                bitmap.recycle();
                Intrinsics.checkNotNullExpressionValue(createScaledBitmap, "Bitmap.createScaledBitma\u2026 bitmap\n                }");
                return createScaledBitmap;
            } catch (OutOfMemoryError e16) {
                RFWLog.w("RFWVideoUtils", RFWLog.USR, "[downScaleBitmap] oom, exc=" + e16);
                return bitmap;
            }
        }
        return bitmap;
    }

    private final Bitmap c(AssetFileDescriptor descriptor) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(descriptor.getFileDescriptor(), descriptor.getStartOffset(), descriptor.getLength());
            return d(mediaMetadataRetriever);
        } catch (RuntimeException e16) {
            RFWLog.e("RFWVideoUtils", RFWLog.USR, "[extractVideoFirstFrame] error descriptor:" + descriptor, e16);
            return null;
        }
    }

    private final Bitmap d(MediaMetadataRetriever retriever) {
        int i3;
        StringBuilder sb5;
        try {
            try {
                try {
                    Bitmap frameAtTime = retriever.getFrameAtTime(0L, 3);
                    if (frameAtTime != null) {
                        try {
                            retriever.release();
                        } catch (RuntimeException e16) {
                            RFWLog.i("RFWVideoUtils", RFWLog.USR, "[extractVideoFirstFrame] release retriever, exc=" + e16);
                        }
                        return frameAtTime;
                    }
                    RFWLog.i("RFWVideoUtils", RFWLog.USR, "[extractVideoFirstFrame] try OPTION_CLOSEST_SYNC");
                    Bitmap frameAtTime2 = retriever.getFrameAtTime(500L, 2);
                    if (frameAtTime2 != null) {
                        try {
                            retriever.release();
                        } catch (RuntimeException e17) {
                            RFWLog.i("RFWVideoUtils", RFWLog.USR, "[extractVideoFirstFrame] release retriever, exc=" + e17);
                        }
                        return frameAtTime2;
                    }
                    RFWLog.i("RFWVideoUtils", RFWLog.USR, "[extractVideoFirstFrame] try OPTION_PREVIOUS_SYNC");
                    Bitmap frameAtTime3 = retriever.getFrameAtTime(500L, 0);
                    if (frameAtTime3 != null) {
                        try {
                            retriever.release();
                        } catch (RuntimeException e18) {
                            RFWLog.i("RFWVideoUtils", RFWLog.USR, "[extractVideoFirstFrame] release retriever, exc=" + e18);
                        }
                        return frameAtTime3;
                    }
                    RFWLog.i("RFWVideoUtils", RFWLog.USR, "[extractVideoFirstFrame] try OPTION_CLOSEST");
                    Bitmap frameAtTime4 = retriever.getFrameAtTime(500L, 3);
                    if (frameAtTime4 != null) {
                        try {
                            retriever.release();
                        } catch (RuntimeException e19) {
                            RFWLog.i("RFWVideoUtils", RFWLog.USR, "[extractVideoFirstFrame] release retriever, exc=" + e19);
                        }
                        return frameAtTime4;
                    }
                    try {
                        retriever.release();
                    } catch (RuntimeException e26) {
                        RFWLog.i("RFWVideoUtils", RFWLog.USR, "[extractVideoFirstFrame] release retriever, exc=" + e26);
                    }
                    return null;
                } catch (OutOfMemoryError e27) {
                    RFWLog.i("RFWVideoUtils", RFWLog.USR, "[extractVideoFirstFrame] OOM, exc=" + e27);
                    try {
                        retriever.release();
                    } catch (RuntimeException e28) {
                        e = e28;
                        i3 = RFWLog.USR;
                        sb5 = new StringBuilder();
                        sb5.append("[extractVideoFirstFrame] release retriever, exc=");
                        sb5.append(e);
                        RFWLog.i("RFWVideoUtils", i3, sb5.toString());
                        return null;
                    }
                    return null;
                } catch (RuntimeException e29) {
                    RFWLog.i("RFWVideoUtils", RFWLog.USR, "[extractVideoFirstFrame] exc=" + e29);
                    try {
                        retriever.release();
                    } catch (RuntimeException e36) {
                        e = e36;
                        i3 = RFWLog.USR;
                        sb5 = new StringBuilder();
                        sb5.append("[extractVideoFirstFrame] release retriever, exc=");
                        sb5.append(e);
                        RFWLog.i("RFWVideoUtils", i3, sb5.toString());
                        return null;
                    }
                    return null;
                }
            } catch (IllegalArgumentException e37) {
                RFWLog.i("RFWVideoUtils", RFWLog.USR, "[extractVideoFirstFrame] exc=" + e37);
                try {
                    retriever.release();
                } catch (RuntimeException e38) {
                    e = e38;
                    i3 = RFWLog.USR;
                    sb5 = new StringBuilder();
                    sb5.append("[extractVideoFirstFrame] release retriever, exc=");
                    sb5.append(e);
                    RFWLog.i("RFWVideoUtils", i3, sb5.toString());
                    return null;
                }
                return null;
            }
        } catch (Throwable th5) {
            try {
                retriever.release();
            } catch (RuntimeException e39) {
                RFWLog.i("RFWVideoUtils", RFWLog.USR, "[extractVideoFirstFrame] release retriever, exc=" + e39);
            }
            throw th5;
        }
    }

    private final Bitmap e(Uri uri) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(RFWApplication.getApplication(), uri);
            return d(mediaMetadataRetriever);
        } catch (RuntimeException e16) {
            RFWLog.e("RFWVideoUtils", RFWLog.USR, "[extractVideoFirstFrame] error uri:" + uri, e16);
            return null;
        }
    }

    private final Bitmap f(String path) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(path);
            return d(mediaMetadataRetriever);
        } catch (RuntimeException e16) {
            RFWLog.e("RFWVideoUtils", RFWLog.USR, "[extractVideoFirstFrame] error path:" + path, e16);
            return null;
        }
    }

    private final Bitmap g(String path) {
        Bitmap createVideoThumbnail;
        Pair<Integer, Integer> h16 = h(path);
        RFWLog.i("RFWVideoUtils", RFWLog.USR, "[extractVideoFirstFrame] try using ThumbnailUtils, path=" + path);
        try {
            if (Build.VERSION.SDK_INT >= 29 && h16.getFirst().intValue() > 0 && h16.getSecond().intValue() > 0) {
                createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(new File(path), new Size(h16.getFirst().intValue(), h16.getSecond().intValue()), null);
            } else {
                createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(path, 1);
            }
            return createVideoThumbnail;
        } catch (Exception e16) {
            RFWLog.w("RFWVideoUtils", RFWLog.USR, "[extractVideoFirstFrame] failed, exc=" + e16 + ", path=" + path);
            return null;
        }
    }

    @JvmStatic
    @NotNull
    public static final Pair<Integer, Integer> h(@NotNull String videoPath) {
        Intrinsics.checkNotNullParameter(videoPath, "videoPath");
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(videoPath);
                String extractMetadata = mediaMetadataRetriever.extractMetadata(18);
                String extractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
                if (extractMetadata != null && extractMetadata2 != null) {
                    return new Pair<>(Integer.valueOf(Integer.parseInt(extractMetadata)), Integer.valueOf(Integer.parseInt(extractMetadata2)));
                }
                return new Pair<>(0, 0);
            } catch (Exception e16) {
                RFWLog.w("RFWVideoUtils", RFWLog.USR, "[getVideoSize] path=" + videoPath + " exc=" + e16);
                mediaMetadataRetriever.release();
                return new Pair<>(0, 0);
            }
        } finally {
            mediaMetadataRetriever.release();
        }
    }

    private final Bitmap i(AssetFileDescriptor descriptor) {
        Bitmap c16 = c(descriptor);
        if (c16 == null) {
            RFWLog.w("RFWVideoUtils", RFWLog.USR, "[getVideoThumb], failed to extract first frame, descriptor=" + descriptor);
            return null;
        }
        return c16;
    }

    private final Bitmap j(Uri uri) {
        Bitmap e16 = e(uri);
        if (e16 == null) {
            RFWLog.w("RFWVideoUtils", RFWLog.USR, "[getVideoThumb], failed to extract first frame, uri=" + uri);
            return null;
        }
        return e16;
    }

    private final Bitmap k(String videoPath) {
        Bitmap f16 = f(videoPath);
        if (f16 != null) {
            return f16;
        }
        RFWLog.w("RFWVideoUtils", RFWLog.USR, "[getVideoThumb], failed to extract first frame, videoPath=" + videoPath);
        Bitmap g16 = g(videoPath);
        if (g16 != null) {
            return g16;
        }
        RFWLog.w("RFWVideoUtils", RFWLog.USR, "[getVideoThumb], failed to create from util, videoPath=" + videoPath);
        Application application = RFWApplication.getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "RFWApplication.getApplication()");
        Bitmap o16 = o(application, videoPath);
        if (o16 != null) {
            return o16;
        }
        RFWLog.w("RFWVideoUtils", RFWLog.USR, "[getVideoThumb], failed to get from album, videoPath=" + videoPath);
        return null;
    }

    @JvmStatic
    @WorkerThread
    @Nullable
    public static final Bitmap m(@NotNull String videoPath) {
        Intrinsics.checkNotNullParameter(videoPath, "videoPath");
        return n(videoPath, 640);
    }

    @JvmStatic
    @WorkerThread
    @Nullable
    public static final Bitmap n(@NotNull String videoPath, int maxSize) {
        Intrinsics.checkNotNullParameter(videoPath, "videoPath");
        long currentTimeMillis = System.currentTimeMillis();
        c cVar = f397590a;
        Bitmap k3 = cVar.k(videoPath);
        if (k3 != null) {
            if (maxSize <= 0) {
                maxSize = 640;
            }
            Bitmap b16 = cVar.b(k3, maxSize);
            long currentTimeMillis2 = System.currentTimeMillis();
            if (RFWLog.isColorLevel()) {
                RFWLog.d("RFWVideoUtils", RFWLog.CLR, "getVideoThumbnail => success, width=" + b16.getWidth() + ", height=" + b16.getHeight() + ", videoPath=" + videoPath + ", cost:" + (currentTimeMillis2 - currentTimeMillis) + "ms");
            }
            return b16;
        }
        return null;
    }

    private final Bitmap o(Context context, String videoPath) {
        try {
            Long a16 = a(context, videoPath);
            if (a16 == null) {
                RFWLog.w("RFWVideoUtils", RFWLog.USR, "[getVideoThumbnailFromAlbum] failed to get video id, path=" + videoPath);
                return null;
            }
            return MediaStore.Video.Thumbnails.getThumbnail(context.getContentResolver(), a16.longValue(), 1, null);
        } catch (Exception e16) {
            RFWLog.w("RFWVideoUtils", RFWLog.USR, "[getVideoThumbnailFromAlbum] exc=" + e16 + " path=" + videoPath);
            return null;
        }
    }

    @JvmStatic
    @WorkerThread
    @Nullable
    public static final Bitmap p(@NotNull AssetFileDescriptor descriptor, int maxSize) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        long currentTimeMillis = System.currentTimeMillis();
        c cVar = f397590a;
        Bitmap i3 = cVar.i(descriptor);
        if (i3 != null) {
            if (maxSize <= 0) {
                maxSize = 640;
            }
            Bitmap b16 = cVar.b(i3, maxSize);
            long currentTimeMillis2 = System.currentTimeMillis();
            if (RFWLog.isColorLevel()) {
                RFWLog.d("RFWVideoUtils", RFWLog.CLR, "getVideoThumbnail => success, width=" + b16.getWidth() + ", height=" + b16.getHeight() + ", videoPath=" + descriptor + ", cost:" + (currentTimeMillis2 - currentTimeMillis) + "ms");
            }
            return b16;
        }
        return null;
    }

    @Nullable
    public final Bitmap l(@Nullable Uri videoUri, int maxSize) {
        if (videoUri == null) {
            return null;
        }
        try {
            Bitmap j3 = j(videoUri);
            if (j3 == null) {
                return null;
            }
            if (maxSize <= 0) {
                maxSize = 640;
            }
            return b(j3, maxSize);
        } catch (Exception e16) {
            RFWLog.w("RFWVideoUtils", RFWLog.USR, "[getVideoThumbFromUri] exc=" + e16 + " uri=" + videoUri);
            return null;
        }
    }
}
