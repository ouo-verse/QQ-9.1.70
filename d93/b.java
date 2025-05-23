package d93;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.mobileqq.wink.picker.MediaFilter;
import com.tencent.mobileqq.wink.picker.MediaFilteringCode;
import com.tencent.mobileqq.wink.picker.utils.MediaCompressUtils;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\u000e"}, d2 = {"Ld93/b;", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "image", "Lcom/tencent/mobileqq/wink/picker/MediaFilter;", "mediaFilter", "Lcom/tencent/mobileqq/wink/picker/MediaFilteringCode;", "b", "video", "c", QAdVrReportParams.ParamKey.MEDIA, "a", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f393235a = new b();

    b() {
    }

    private final MediaFilteringCode b(LocalMediaInfo image, MediaFilter mediaFilter) {
        boolean z16;
        boolean z17;
        int imageMinWidth = mediaFilter.getImageMinWidth();
        int imageMaxWidth = mediaFilter.getImageMaxWidth();
        int i3 = image.mediaWidth;
        boolean z18 = true;
        if (imageMinWidth <= i3 && i3 <= imageMaxWidth) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            int imageMinHeight = mediaFilter.getImageMinHeight();
            int imageMaxHeight = mediaFilter.getImageMaxHeight();
            int i16 = image.mediaHeight;
            if (imageMinHeight <= i16 && i16 <= imageMaxHeight) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                float imageMinRatio = mediaFilter.getImageMinRatio();
                float imageMaxRatio = mediaFilter.getImageMaxRatio();
                float f16 = image.mediaWidth / image.mediaHeight;
                if (imageMinRatio > f16 || f16 > imageMaxRatio) {
                    z18 = false;
                }
                if (!z18) {
                    return MediaFilteringCode.IMAGE_INVALID_RATIO;
                }
                if (image.fileSize > mediaFilter.getImageSizeBytesLimit()) {
                    return MediaFilteringCode.IMAGE_EXCEED_SIZE_LIMIT;
                }
                return MediaFilteringCode.MEDIA_VALID;
            }
        }
        return MediaFilteringCode.IMAGE_INVALID_RESOLUTION;
    }

    private final MediaFilteringCode c(LocalMediaInfo video, MediaFilter mediaFilter) {
        boolean z16;
        boolean z17;
        int videoMinWidth = mediaFilter.getVideoMinWidth();
        int videoMaxWidth = mediaFilter.getVideoMaxWidth();
        int i3 = video.mediaWidth;
        boolean z18 = true;
        if (videoMinWidth <= i3 && i3 <= videoMaxWidth) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            int videoMinHeight = mediaFilter.getVideoMinHeight();
            int videoMaxHeight = mediaFilter.getVideoMaxHeight();
            int i16 = video.mediaHeight;
            if (videoMinHeight <= i16 && i16 <= videoMaxHeight) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                float videoMinRatio = mediaFilter.getVideoMinRatio();
                float videoMaxRatio = mediaFilter.getVideoMaxRatio();
                int i17 = video.mediaWidth;
                int i18 = video.mediaHeight;
                float f16 = i17 / i18;
                if (videoMinRatio > f16 || f16 > videoMaxRatio) {
                    z18 = false;
                }
                if (!z18) {
                    return MediaFilteringCode.VIDEO_INVALID_RATIO;
                }
                if (com.tencent.mobileqq.wink.editor.export.a.f320174a.d(i17, i18) && MediaCompressUtils.f325262a.p().contains(DeviceInfoMonitor.getModel())) {
                    return MediaFilteringCode.VIDEO_INVALID_VIDEO_UN_SUPPORT_4K;
                }
                if (video.fileSize > mediaFilter.getVideoSizeBytesLimit()) {
                    return MediaFilteringCode.VIDEO_EXCEED_SIZE_LIMIT;
                }
                if (video.mDuration < mediaFilter.getVideoMinDurationMs()) {
                    return MediaFilteringCode.VIDEO_INVALID_MIN_DURATION;
                }
                if (video.mDuration > mediaFilter.getVideoMaxDurationMs()) {
                    return MediaFilteringCode.VIDEO_INVALID_MAX_DURATION;
                }
                return MediaFilteringCode.MEDIA_VALID;
            }
        }
        return MediaFilteringCode.VIDEO_INVALID_RESOLUTION;
    }

    @NotNull
    public final MediaFilteringCode a(@NotNull LocalMediaInfo media, @NotNull MediaFilter mediaFilter) {
        Intrinsics.checkNotNullParameter(media, "media");
        Intrinsics.checkNotNullParameter(mediaFilter, "mediaFilter");
        int i3 = media.mMediaType;
        if (i3 == 0) {
            return b(media, mediaFilter);
        }
        if (i3 == 1) {
            return c(media, mediaFilter);
        }
        return MediaFilteringCode.MEDIA_VALID;
    }
}
