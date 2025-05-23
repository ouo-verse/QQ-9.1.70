package f6;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Looper;
import com.qzone.proxy.feedcomponent.util.j;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import common.config.service.QzoneConfig;
import cooperation.qzone.model.Size;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b {
    private static boolean d() {
        return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_WNSSETTINGS, QzoneConfig.SECONDARY_KEY_NEW_THUMBNAIL_ENABLED, 1) == 1;
    }

    public static Size b(LocalMediaInfo localMediaInfo) {
        if (localMediaInfo == null) {
            return new Size(0, 0);
        }
        if (!d()) {
            return new Size(localMediaInfo.thumbWidth, localMediaInfo.thumbHeight);
        }
        if (localMediaInfo.mMediaType == 1) {
            return c(localMediaInfo);
        }
        return a(localMediaInfo);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0095 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008e A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Size c(LocalMediaInfo localMediaInfo) {
        MediaMetadataRetriever mediaMetadataRetriever;
        int i3;
        int i16;
        int i17 = 0;
        if (localMediaInfo == null) {
            return new Size(0, 0);
        }
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            j.j("ThumbnailSizeUtils", "[getVideoMediaThumbnailSize] current thread is main, read media size fail.", new Exception());
            return new Size(localMediaInfo.thumbWidth, localMediaInfo.thumbHeight);
        }
        try {
            mediaMetadataRetriever = new MediaMetadataRetriever();
        } catch (Throwable th5) {
            th = th5;
            mediaMetadataRetriever = null;
        }
        try {
            mediaMetadataRetriever.setDataSource(localMediaInfo.path);
            Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime();
            i16 = frameAtTime.getWidth();
            try {
                i17 = frameAtTime.getHeight();
                j.a("ThumbnailSizeUtils", 1, "[getVideoMediaThumbnailSize] thumbnailWidth: " + i16 + " | thumbnailHeight: " + i17 + " | mediaInfo: " + localMediaInfo.toString());
                mediaMetadataRetriever.release();
            } catch (Throwable th6) {
                th = th6;
                i3 = i17;
                i17 = i16;
                try {
                    j.d("ThumbnailSizeUtils", "[getVideoMediaThumbnailSize] error: ", th);
                    i16 = i17;
                    i17 = i3;
                    if (i16 != 0) {
                    }
                    i16 = localMediaInfo.thumbWidth;
                    i17 = localMediaInfo.thumbHeight;
                    return new Size(i16, i17);
                } finally {
                    if (mediaMetadataRetriever != null) {
                        mediaMetadataRetriever.release();
                    }
                }
            }
        } catch (Throwable th7) {
            th = th7;
            i3 = 0;
            j.d("ThumbnailSizeUtils", "[getVideoMediaThumbnailSize] error: ", th);
            i16 = i17;
            i17 = i3;
            if (i16 != 0) {
            }
            i16 = localMediaInfo.thumbWidth;
            i17 = localMediaInfo.thumbHeight;
            return new Size(i16, i17);
        }
        if (i16 != 0 || i17 == 0) {
            i16 = localMediaInfo.thumbWidth;
            i17 = localMediaInfo.thumbHeight;
        }
        return new Size(i16, i17);
    }

    private static Size a(LocalMediaInfo localMediaInfo) {
        int i3 = localMediaInfo == null ? 0 : localMediaInfo.mediaWidth;
        int i16 = localMediaInfo == null ? 0 : localMediaInfo.mediaHeight;
        if (i3 == 0 || i16 == 0) {
            i3 = localMediaInfo == null ? 0 : localMediaInfo.thumbWidth;
            i16 = localMediaInfo != null ? localMediaInfo.thumbHeight : 0;
        }
        return new Size(i3, i16);
    }
}
