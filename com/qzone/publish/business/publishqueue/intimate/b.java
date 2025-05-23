package com.qzone.publish.business.publishqueue.intimate;

import com.qzone.publish.ui.model.MediaWrapper;
import com.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZoneBaseMeta$StMedia;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\"\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0017\u0010\u0006\u001a\u0004\u0018\u00010\u0001*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0003\"\u0015\u0010\u000b\u001a\u00020\b*\u00020\u00078F\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\n\"\u0015\u0010\r\u001a\u00020\b*\u00020\u00078F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/qzone/publish/ui/model/MediaWrapper;", "", "b", "(Lcom/qzone/publish/ui/model/MediaWrapper;)Ljava/lang/String;", "originalPath", "a", "coverUrl", "Lqzone/QZoneBaseMeta$StMedia;", "", "c", "(Lqzone/QZoneBaseMeta$StMedia;)Z", "isImage", "d", BaseProfileQZoneComponent.KEY_IS_VIDEO, "qzone_df_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class b {
    public static final String a(MediaWrapper mediaWrapper) {
        Intrinsics.checkNotNullParameter(mediaWrapper, "<this>");
        if (mediaWrapper.isImage()) {
            return mediaWrapper.getImageInfo().mPath;
        }
        return mediaWrapper.getVideoInfo().mCoverUrl;
    }

    public static final String b(MediaWrapper mediaWrapper) {
        String videoOriginalPath;
        String str;
        Intrinsics.checkNotNullParameter(mediaWrapper, "<this>");
        if (mediaWrapper.isImage()) {
            videoOriginalPath = mediaWrapper.getImageInfo().mPath;
            str = "imageInfo.mPath";
        } else {
            videoOriginalPath = mediaWrapper.getVideoInfo().getVideoOriginalPath();
            str = "videoInfo.videoOriginalPath";
        }
        Intrinsics.checkNotNullExpressionValue(videoOriginalPath, str);
        return videoOriginalPath;
    }

    public static final boolean c(QZoneBaseMeta$StMedia qZoneBaseMeta$StMedia) {
        Intrinsics.checkNotNullParameter(qZoneBaseMeta$StMedia, "<this>");
        return qZoneBaseMeta$StMedia.type.get() == 0;
    }

    public static final boolean d(QZoneBaseMeta$StMedia qZoneBaseMeta$StMedia) {
        Intrinsics.checkNotNullParameter(qZoneBaseMeta$StMedia, "<this>");
        return qZoneBaseMeta$StMedia.type.get() == 1;
    }
}
