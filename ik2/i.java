package ik2;

import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0002\u00a8\u0006\u000f"}, d2 = {"Lik2/i;", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "info", "Landroid/media/MediaMetadataRetriever;", "retriever", "", "b", "c", "d", QCircleScheme.AttrDetail.VIDEO_INFO, "", "a", "<init>", "()V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final i f407919a = new i();

    i() {
    }

    private final void b(LocalMediaInfo info, MediaMetadataRetriever retriever) {
        String extractMetadata = retriever.extractMetadata(9);
        Intrinsics.checkNotNull(extractMetadata);
        info.mDuration = Long.parseLong(extractMetadata);
    }

    private final void c(LocalMediaInfo info, MediaMetadataRetriever retriever) {
        info.mMimeType = retriever.extractMetadata(12);
    }

    private final void d(LocalMediaInfo info, MediaMetadataRetriever retriever) {
        String extractMetadata = retriever.extractMetadata(18);
        Intrinsics.checkNotNull(extractMetadata);
        info.mediaWidth = Integer.parseInt(extractMetadata);
        String extractMetadata2 = retriever.extractMetadata(19);
        Intrinsics.checkNotNull(extractMetadata2);
        info.mediaHeight = Integer.parseInt(extractMetadata2);
    }

    public final boolean a(@NotNull LocalMediaInfo videoInfo) {
        MediaMetadataRetriever mediaMetadataRetriever;
        Intrinsics.checkNotNullParameter(videoInfo, "videoInfo");
        String str = videoInfo.path;
        QLog.i("VideoInfoDecoder_", 2, "start decode video file: " + str);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        MediaMetadataRetriever mediaMetadataRetriever2 = null;
        try {
            mediaMetadataRetriever = new MediaMetadataRetriever();
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            mediaMetadataRetriever.setDataSource(str);
            b(videoInfo, mediaMetadataRetriever);
            c(videoInfo, mediaMetadataRetriever);
            d(videoInfo, mediaMetadataRetriever);
            try {
                mediaMetadataRetriever.release();
            } catch (Exception e16) {
                QLog.e("VideoInfoDecoder_", 2, e16, new Object[0]);
            }
            return true;
        } catch (Throwable th6) {
            th = th6;
            mediaMetadataRetriever2 = mediaMetadataRetriever;
            try {
                QLog.e("VideoInfoDecoder_", 2, "decode local video info failed, video path: " + str);
                QLog.i("VideoInfoDecoder_", 2, "", th);
                if (mediaMetadataRetriever2 == null) {
                    return false;
                }
                try {
                    mediaMetadataRetriever2.release();
                    return false;
                } catch (Exception e17) {
                    QLog.e("VideoInfoDecoder_", 2, e17, new Object[0]);
                    return false;
                }
            } catch (Throwable th7) {
                if (mediaMetadataRetriever2 != null) {
                    try {
                        mediaMetadataRetriever2.release();
                    } catch (Exception e18) {
                        QLog.e("VideoInfoDecoder_", 2, e18, new Object[0]);
                    }
                }
                throw th7;
            }
        }
    }
}
