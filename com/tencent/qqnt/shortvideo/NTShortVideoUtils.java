package com.tencent.qqnt.shortvideo;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Size;
import com.tencent.hippy.qq.adapter.image.CustomImageProps;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.filebrowser.MimeTypeParser;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;
import com.tencent.qqnt.aio.utils.m;
import com.tencent.qqnt.freesia_wrapper.FreesiaWrapperImpl;
import java.io.File;
import java.io.FileOutputStream;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b5\u00106J\u0018\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002H\u0007J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0007J\b\u0010\f\u001a\u00020\u0002H\u0007J\b\u0010\r\u001a\u00020\u0002H\u0003J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0007\u001a\u00020\u0002H\u0007J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0007J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J\u0018\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0016\u001a\u00020\u0002H\u0002J\u0014\u0010\u001a\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0002J\u001a\u0010\u001d\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J!\u0010 \u001a\u0004\u0018\u00010\b2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u0018H\u0002\u00a2\u0006\u0004\b \u0010!J!\u0010\"\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0007\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\"\u0010#J\u0012\u0010$\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0016\u001a\u00020\u0002H\u0002J\u001c\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100%2\u0006\u0010\u0007\u001a\u00020\u0002H\u0007J\b\u0010(\u001a\u00020'H\u0002J\u0016\u0010+\u001a\u00020\u00022\u0006\u0010)\u001a\u00020\u00022\u0006\u0010*\u001a\u00020'J\u0010\u0010,\u001a\u00020'2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002J\u001a\u0010-\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018J\u0016\u00100\u001a\u00020'2\u0006\u0010.\u001a\u00020\u00022\u0006\u0010/\u001a\u00020\u0010R\u001b\u00104\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u00101\u001a\u0004\b2\u00103\u00a8\u00067"}, d2 = {"Lcom/tencent/qqnt/shortvideo/NTShortVideoUtils;", "", "", "sourcePath", MimeTypeParser.ATTR_EXTENSION, h.F, "g", "videoPath", "", "f", "strMd5", "l", "k", "i", "Landroid/graphics/Bitmap;", "r", "", "max_length", ReportConstant.COSTREPORT_PREFIX, "p", MimeHelper.IMAGE_SUBTYPE_BITMAP, "b", "path", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/net/Uri;", "videoUri", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/content/Context;", "context", "t", "Landroid/content/ContentResolver;", "contentResolver", DomainData.DOMAIN_NAME, "(Landroid/content/ContentResolver;Landroid/net/Uri;)Ljava/lang/Long;", "a", "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/Long;", "c", "Lkotlin/Pair;", "o", "", "v", "inputVideoPath", CustomImageProps.QUALITY, "e", "u", "d", "videoInput", "videoInPutCodecFormat", "w", "Lkotlin/Lazy;", "j", "()Ljava/lang/String;", "shortVideoTempDir", "<init>", "()V", "shortvideo_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class NTShortVideoUtils {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final NTShortVideoUtils f362199a = new NTShortVideoUtils();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy shortVideoTempDir;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.qqnt.shortvideo.NTShortVideoUtils$shortVideoTempDir$2
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                String absolutePath;
                BaseApplication context = BaseApplication.getContext();
                File externalCacheDir = context.getExternalCacheDir();
                return (externalCacheDir == null || (absolutePath = externalCacheDir.getAbsolutePath()) == null) ? context.getCacheDir().getAbsolutePath() : absolutePath;
            }
        });
        shortVideoTempDir = lazy;
    }

    NTShortVideoUtils() {
    }

    private final Long a(Context context, String videoPath) {
        Cursor query = ContactsMonitor.query(context.getContentResolver(), MediaStore.Video.Media.EXTERNAL_CONTENT_URI, new String[]{"_id"}, "_data=?", new String[]{videoPath}, null);
        if (query == null) {
            QLog.w(ShortVideoUtils.TAG, 1, "[convertFileUriToContentUri] failed, path=" + videoPath);
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

    private final Bitmap b(Bitmap bitmap, int max_length) {
        int roundToInt;
        int roundToInt2;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int max = Math.max(width, height);
        if (max > max_length) {
            float f16 = max_length / max;
            roundToInt = MathKt__MathJVMKt.roundToInt(width * f16);
            roundToInt2 = MathKt__MathJVMKt.roundToInt(f16 * height);
            try {
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, roundToInt, roundToInt2, true);
                bitmap.recycle();
                Intrinsics.checkNotNullExpressionValue(createScaledBitmap, "{\n                Bitmap\u2026          }\n            }");
                return createScaledBitmap;
            } catch (OutOfMemoryError e16) {
                QLog.w(ShortVideoUtils.TAG, 1, "[downScaleBitmap] oom, exc=" + e16);
                return bitmap;
            }
        }
        return bitmap;
    }

    private final Bitmap c(String path) {
        StringBuilder sb5;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                try {
                    mediaMetadataRetriever.setDataSource(path);
                    Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(-1L);
                    if (frameAtTime != null) {
                        try {
                            mediaMetadataRetriever.release();
                        } catch (RuntimeException e16) {
                            QLog.i(ShortVideoUtils.TAG, 1, "[extractVideoFirstFrame] release retriever, exc=" + e16);
                        }
                        return frameAtTime;
                    }
                    QLog.i(ShortVideoUtils.TAG, 1, "[extractVideoFirstFrame] try OPTION_CLOSEST_SYNC, path=" + path);
                    Bitmap frameAtTime2 = mediaMetadataRetriever.getFrameAtTime(500L, 2);
                    if (frameAtTime2 != null) {
                        try {
                            mediaMetadataRetriever.release();
                        } catch (RuntimeException e17) {
                            QLog.i(ShortVideoUtils.TAG, 1, "[extractVideoFirstFrame] release retriever, exc=" + e17);
                        }
                        return frameAtTime2;
                    }
                    QLog.i(ShortVideoUtils.TAG, 1, "[extractVideoFirstFrame] try OPTION_PREVIOUS_SYNC, path=" + path);
                    Bitmap frameAtTime3 = mediaMetadataRetriever.getFrameAtTime(500L, 0);
                    if (frameAtTime3 != null) {
                        try {
                            mediaMetadataRetriever.release();
                        } catch (RuntimeException e18) {
                            QLog.i(ShortVideoUtils.TAG, 1, "[extractVideoFirstFrame] release retriever, exc=" + e18);
                        }
                        return frameAtTime3;
                    }
                    QLog.i(ShortVideoUtils.TAG, 1, "[extractVideoFirstFrame] try OPTION_CLOSEST, path=" + path);
                    Bitmap frameAtTime4 = mediaMetadataRetriever.getFrameAtTime(500L, 3);
                    if (frameAtTime4 != null) {
                        try {
                            mediaMetadataRetriever.release();
                        } catch (RuntimeException e19) {
                            QLog.i(ShortVideoUtils.TAG, 1, "[extractVideoFirstFrame] release retriever, exc=" + e19);
                        }
                        return frameAtTime4;
                    }
                    try {
                        mediaMetadataRetriever.release();
                    } catch (RuntimeException e26) {
                        QLog.i(ShortVideoUtils.TAG, 1, "[extractVideoFirstFrame] release retriever, exc=" + e26);
                    }
                    return null;
                } catch (OutOfMemoryError e27) {
                    QLog.i(ShortVideoUtils.TAG, 1, "[extractVideoFirstFrame] OOM, exc=" + e27 + " path=" + path);
                    try {
                        mediaMetadataRetriever.release();
                    } catch (RuntimeException e28) {
                        e = e28;
                        sb5 = new StringBuilder();
                        sb5.append("[extractVideoFirstFrame] release retriever, exc=");
                        sb5.append(e);
                        QLog.i(ShortVideoUtils.TAG, 1, sb5.toString());
                        return null;
                    }
                    return null;
                } catch (RuntimeException e29) {
                    QLog.i(ShortVideoUtils.TAG, 1, "[extractVideoFirstFrame] exc=" + e29 + " path=" + path);
                    try {
                        mediaMetadataRetriever.release();
                    } catch (RuntimeException e36) {
                        e = e36;
                        sb5 = new StringBuilder();
                        sb5.append("[extractVideoFirstFrame] release retriever, exc=");
                        sb5.append(e);
                        QLog.i(ShortVideoUtils.TAG, 1, sb5.toString());
                        return null;
                    }
                    return null;
                }
            } catch (IllegalArgumentException e37) {
                QLog.i(ShortVideoUtils.TAG, 1, "[extractVideoFirstFrame] exc=" + e37 + " path=" + path);
                try {
                    mediaMetadataRetriever.release();
                } catch (RuntimeException e38) {
                    e = e38;
                    sb5 = new StringBuilder();
                    sb5.append("[extractVideoFirstFrame] release retriever, exc=");
                    sb5.append(e);
                    QLog.i(ShortVideoUtils.TAG, 1, sb5.toString());
                    return null;
                }
                return null;
            }
        } catch (Throwable th5) {
            try {
                mediaMetadataRetriever.release();
            } catch (RuntimeException e39) {
                QLog.i(ShortVideoUtils.TAG, 1, "[extractVideoFirstFrame] release retriever, exc=" + e39);
            }
            throw th5;
        }
    }

    @JvmStatic
    public static final long f(@NotNull String videoPath) {
        Intrinsics.checkNotNullParameter(videoPath, "videoPath");
        long j3 = -1;
        if (!new File(videoPath).exists()) {
            if (QLog.isColorLevel()) {
                QLog.e(ShortVideoUtils.TAG, 2, "Path:" + videoPath + ", not exits!");
            }
            return -1L;
        }
        ReportMediaPlayer reportMediaPlayer = new ReportMediaPlayer();
        try {
            try {
                reportMediaPlayer.setDataSource(videoPath);
                reportMediaPlayer.prepare();
                j3 = reportMediaPlayer.getDuration();
            } catch (Exception e16) {
                e16.printStackTrace();
                if (QLog.isColorLevel()) {
                    QLog.d(ShortVideoUtils.TAG, 2, "getDuration", e16);
                }
            }
            return j3;
        } finally {
            reportMediaPlayer.release();
        }
    }

    private final String g(String sourcePath, String extension) {
        String md5 = MD5.toMD5(sourcePath);
        StringBuilder sb5 = new StringBuilder(j());
        String str = File.separator;
        sb5.append(str);
        sb5.append("shortvideo");
        sb5.append(str);
        sb5.append(md5);
        sb5.append(".");
        sb5.append(extension);
        if (QLog.isColorLevel()) {
            QLog.d(ShortVideoUtils.TAG, 2, "getShortVideoCompressPath: sourcePath=" + sourcePath + " compressPath=" + ((Object) sb5));
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "sb.toString()");
        return sb6;
    }

    private final String h(String sourcePath, String extension) {
        String md5 = MD5.toMD5(sourcePath);
        StringBuilder sb5 = new StringBuilder(j());
        String str = File.separator;
        sb5.append(str);
        sb5.append("shortvideo");
        sb5.append(str);
        sb5.append(md5);
        sb5.append("_raw");
        sb5.append(".");
        sb5.append(extension);
        if (QLog.isColorLevel()) {
            QLog.d(ShortVideoUtils.TAG, 2, "getShortVideoCompressPath: sourcePath=" + sourcePath + " compressPath=" + ((Object) sb5));
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "sb.toString()");
        return sb6;
    }

    @JvmStatic
    private static final String i() {
        StringBuilder sb5 = new StringBuilder(f362199a.j());
        String str = File.separator;
        sb5.append(str);
        sb5.append("shortvideo");
        sb5.append(str);
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "sb.toString()");
        return sb6;
    }

    private final String j() {
        Object value = shortVideoTempDir.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-shortVideoTempDir>(...)");
        return (String) value;
    }

    @JvmStatic
    @NotNull
    public static final String k() {
        StringBuilder sb5 = new StringBuilder(i());
        sb5.append("thumbs");
        sb5.append(File.separator);
        File file = new File(sb5.toString());
        if (!file.exists()) {
            file.mkdirs();
        }
        String str = ((Object) sb5) + ".nomedia";
        if (!new File(str).exists()) {
            m.b(str);
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "sb.toString()");
        return sb6;
    }

    @JvmStatic
    @NotNull
    public static final String l(@NotNull String strMd5, @NotNull String extension) {
        Intrinsics.checkNotNullParameter(strMd5, "strMd5");
        Intrinsics.checkNotNullParameter(extension, "extension");
        String str = k() + strMd5 + "." + extension;
        Intrinsics.checkNotNullExpressionValue(str, "sb.toString()");
        return str;
    }

    private final Bitmap m(String path) {
        Bitmap createVideoThumbnail;
        Pair<Integer, Integer> o16 = o(path);
        QLog.i(ShortVideoUtils.TAG, 1, "[extractVideoFirstFrame] try using ThumbnailUtils, path=" + path);
        try {
            if (Build.VERSION.SDK_INT >= 29 && o16.getFirst().intValue() > 0 && o16.getSecond().intValue() > 0) {
                createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(new File(path), new Size(o16.getFirst().intValue(), o16.getSecond().intValue()), null);
            } else {
                createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(path, 1);
            }
            return createVideoThumbnail;
        } catch (Exception e16) {
            QLog.w(ShortVideoUtils.TAG, 1, "[extractVideoFirstFrame] failed, exc=" + e16 + ", path=" + path);
            return null;
        }
    }

    private final Long n(ContentResolver contentResolver, Uri videoUri) {
        Long l3;
        Cursor query = ContactsMonitor.query(contentResolver, videoUri, new String[]{"_id"}, null, null, null);
        if (query == null) {
            return null;
        }
        Cursor cursor = query;
        try {
            Cursor cursor2 = cursor;
            if (cursor2.moveToFirst()) {
                l3 = Long.valueOf(cursor2.getLong(cursor2.getColumnIndexOrThrow("_id")));
            } else {
                l3 = null;
            }
            CloseableKt.closeFinally(cursor, null);
            return l3;
        } catch (Throwable th5) {
            try {
                throw th5;
            } catch (Throwable th6) {
                CloseableKt.closeFinally(cursor, th5);
                throw th6;
            }
        }
    }

    @JvmStatic
    @NotNull
    public static final Pair<Integer, Integer> o(@NotNull String videoPath) {
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
                QLog.w(ShortVideoUtils.TAG, 1, "[getVideoSize] path=" + videoPath + " exc=" + e16);
                mediaMetadataRetriever.release();
                return new Pair<>(0, 0);
            }
        } finally {
            mediaMetadataRetriever.release();
        }
    }

    private final Bitmap p(String videoPath) {
        Bitmap c16 = c(videoPath);
        if (c16 != null) {
            return c16;
        }
        QLog.w(ShortVideoUtils.TAG, 1, "[getVideoThumb], failed to extract first frame, videoPath=" + videoPath);
        Bitmap m3 = m(videoPath);
        if (m3 != null) {
            return m3;
        }
        QLog.w(ShortVideoUtils.TAG, 1, "[getVideoThumb], failed to create from util, videoPath=" + videoPath);
        BaseApplication context = BaseApplication.context;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Bitmap t16 = t(context, videoPath);
        if (t16 != null) {
            return t16;
        }
        QLog.w(ShortVideoUtils.TAG, 1, "[getVideoThumb], failed to get from album, videoPath=" + videoPath);
        return null;
    }

    private final Bitmap q(Uri videoUri) {
        if (videoUri == null) {
            return null;
        }
        Bitmap l3 = f11.c.f397590a.l(videoUri, 640);
        if (l3 != null) {
            return l3;
        }
        try {
            ContentResolver contentResolver = BaseApplication.context.getContentResolver();
            Intrinsics.checkNotNullExpressionValue(contentResolver, "contentResolver");
            Long n3 = n(contentResolver, videoUri);
            if (n3 == null) {
                QLog.i(ShortVideoUtils.TAG, 1, "[getVideoThumbFromUri] failed to get video id, uri=" + videoUri);
                return null;
            }
            return MediaStore.Video.Thumbnails.getThumbnail(contentResolver, n3.longValue(), 1, null);
        } catch (Exception e16) {
            QLog.w(ShortVideoUtils.TAG, 1, "[getVideoThumbFromUri] exc=" + e16 + " uri=" + videoUri);
            return null;
        }
    }

    @JvmStatic
    @Nullable
    public static final Bitmap r(@NotNull String videoPath) {
        Intrinsics.checkNotNullParameter(videoPath, "videoPath");
        try {
            return f11.c.m(videoPath);
        } catch (IllegalArgumentException e16) {
            QLog.i(ShortVideoUtils.TAG, 1, "getVideoThumbnail exception:" + e16.getMessage());
            return null;
        } catch (RuntimeException e17) {
            QLog.i(ShortVideoUtils.TAG, 1, "getVideoThumbnail exception:" + e17.getMessage());
            return null;
        }
    }

    @JvmStatic
    @Nullable
    public static final Bitmap s(@NotNull String videoPath, int max_length) {
        Intrinsics.checkNotNullParameter(videoPath, "videoPath");
        if (max_length <= 0) {
            max_length = 640;
        }
        long currentTimeMillis = System.currentTimeMillis();
        NTShortVideoUtils nTShortVideoUtils = f362199a;
        Bitmap p16 = nTShortVideoUtils.p(videoPath);
        if (p16 == null) {
            return null;
        }
        Bitmap b16 = nTShortVideoUtils.b(p16, max_length);
        long currentTimeMillis2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
            QLog.d(ShortVideoUtils.TAG, 2, "getVideoThumbnail => success, width=" + b16.getWidth() + ", height=" + b16.getHeight() + ", videoPath=" + videoPath + ", cost:" + (currentTimeMillis2 - currentTimeMillis) + "ms");
        }
        return b16;
    }

    private final Bitmap t(Context context, String videoPath) {
        try {
            Long a16 = a(context, videoPath);
            if (a16 == null) {
                QLog.w(ShortVideoUtils.TAG, 1, "[getVideoThumbnailFromAlbum] failed to get video id, path=" + videoPath);
                return null;
            }
            return MediaStore.Video.Thumbnails.getThumbnail(context.getContentResolver(), a16.longValue(), 1, null);
        } catch (Exception e16) {
            QLog.w(ShortVideoUtils.TAG, 1, "[getVideoThumbnailFromAlbum] exc=" + e16 + " path=" + videoPath);
            return null;
        }
    }

    private final boolean v() {
        if (com.tencent.qqnt.util.b.f362976b.isPublicVersion() && !FreesiaWrapperImpl.INSTANCE.b().isSwitchOn("raw_video_compress_switch", false)) {
            return false;
        }
        return true;
    }

    @Nullable
    public final String d(@NotNull String videoPath, @Nullable Uri videoUri) {
        Intrinsics.checkNotNullParameter(videoPath, "videoPath");
        String l3 = l(MD5.toMD5(videoPath) + "_" + System.nanoTime(), "jpg");
        m.f352305a.c(l3);
        Bitmap r16 = r(videoPath);
        if (r16 == null) {
            r16 = q(videoUri);
        }
        if (r16 == null) {
            QLog.w(ShortVideoUtils.TAG, 1, "failed to get video thumb, videoPath=" + videoPath + " thumbPath=" + l3);
            return null;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(l3);
            try {
                r16.compress(Bitmap.CompressFormat.JPEG, 80, fileOutputStream);
                CloseableKt.closeFinally(fileOutputStream, null);
                return l3;
            } finally {
            }
        } catch (Exception unused) {
            QLog.i(ShortVideoUtils.TAG, 1, "failed to write video thumb, videoPath=" + videoPath + ", thumbPath=" + l3);
            return null;
        }
    }

    @NotNull
    public final String e(@NotNull String inputVideoPath, boolean quality) {
        Intrinsics.checkNotNullParameter(inputVideoPath, "inputVideoPath");
        if (quality) {
            return h(inputVideoPath, "mp4");
        }
        return g(inputVideoPath, "mp4");
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0039, code lost:
    
        r8 = kotlin.text.StringsKt__StringsJVMKt.equals(r4, "video/hevc", true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0041, code lost:
    
        r1 = r8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean u(@Nullable String path) {
        boolean startsWith$default;
        boolean z16 = false;
        if (TextUtils.isEmpty(path)) {
            return false;
        }
        MediaExtractor mediaExtractor = new MediaExtractor();
        try {
            try {
                Intrinsics.checkNotNull(path);
                mediaExtractor.setDataSource(path);
                int trackCount = mediaExtractor.getTrackCount();
                int i3 = 0;
                while (true) {
                    if (i3 >= trackCount) {
                        break;
                    }
                    MediaFormat trackFormat = mediaExtractor.getTrackFormat(i3);
                    Intrinsics.checkNotNullExpressionValue(trackFormat, "mediaExtractor.getTrackFormat(i)");
                    String string = trackFormat.getString("mime");
                    Intrinsics.checkNotNull(string);
                    startsWith$default = StringsKt__StringsJVMKt.startsWith$default(string, "video/", false, 2, null);
                    if (startsWith$default) {
                        break;
                    }
                    i3++;
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(ShortVideoUtils.TAG, 2, "isH265FormatShortVideo e:", e16);
                }
            }
            return z16;
        } finally {
            mediaExtractor.release();
        }
    }

    public final boolean w(@NotNull String videoInput, int videoInPutCodecFormat) {
        Intrinsics.checkNotNullParameter(videoInput, "videoInput");
        if (new File(videoInput).length() >= ShortVideoConstants.VIDEO_SIZE_LIMIT) {
            return true;
        }
        if (v()) {
            QLog.i(ShortVideoUtils.TAG, 1, "shouldCompressRawVideo: switchOpen, so return false");
            return false;
        }
        if (videoInPutCodecFormat == 1) {
            return true;
        }
        return false;
    }
}
