package mj;

import com.qzone.reborn.albumx.common.convert.bean.CommonStImage;
import com.qzone.reborn.albumx.common.convert.bean.CommonStMedia;
import com.qzone.reborn.albumx.common.convert.bean.CommonStPicSpecUrlEntry;
import com.qzone.reborn.albumx.common.convert.bean.CommonStPicUrl;
import com.qzone.reborn.albumx.common.convert.bean.CommonStVideo;
import com.qzone.reborn.albumx.common.convert.enumtype.CommonEnumMediaType;
import com.qzone.reborn.albumx.common.convert.enumtype.CommonEnumPhotoSpec;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZoneBaseMeta$StImage;
import qzone.QZoneBaseMeta$StMedia;
import qzone.QZoneBaseMeta$StPicSpecUrlEntry;
import qzone.QZoneBaseMeta$StPicUrl;
import qzone.QZoneBaseMeta$StVideo;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0005\u001a\u00020\u0004*\u00020\u0003\u001a\n\u0010\b\u001a\u00020\u0007*\u00020\u0006\u001a\n\u0010\u000b\u001a\u00020\n*\u00020\t\u001a\n\u0010\u000e\u001a\u00020\r*\u00020\f\u00a8\u0006\u000f"}, d2 = {"Lqzone/QZoneBaseMeta$StMedia;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStMedia;", "b", "Lqzone/QZoneBaseMeta$StImage;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStImage;", "a", "Lqzone/QZoneBaseMeta$StVideo;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStVideo;", "e", "Lqzone/QZoneBaseMeta$StPicSpecUrlEntry;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStPicSpecUrlEntry;", "c", "Lqzone/QZoneBaseMeta$StPicUrl;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStPicUrl;", "d", "qzone_df_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b {
    public static final CommonStImage a(QZoneBaseMeta$StImage qZoneBaseMeta$StImage) {
        Intrinsics.checkNotNullParameter(qZoneBaseMeta$StImage, "<this>");
        CommonStImage commonStImage = new CommonStImage();
        String str = qZoneBaseMeta$StImage.name.get();
        Intrinsics.checkNotNullExpressionValue(str, "this.name.get()");
        commonStImage.m(str);
        String str2 = qZoneBaseMeta$StImage.sloc.get();
        Intrinsics.checkNotNullExpressionValue(str2, "this.sloc.get()");
        commonStImage.o(str2);
        String str3 = qZoneBaseMeta$StImage.lloc.get();
        Intrinsics.checkNotNullExpressionValue(str3, "this.lloc.get()");
        commonStImage.l(str3);
        List<QZoneBaseMeta$StPicSpecUrlEntry> list = qZoneBaseMeta$StImage.photo_url.get();
        Intrinsics.checkNotNullExpressionValue(list, "this.photo_url.get()");
        for (QZoneBaseMeta$StPicSpecUrlEntry it : list) {
            List<CommonStPicSpecUrlEntry> e16 = commonStImage.e();
            Intrinsics.checkNotNullExpressionValue(it, "it");
            e16.add(c(it));
        }
        QZoneBaseMeta$StPicUrl qZoneBaseMeta$StPicUrl = qZoneBaseMeta$StImage.default_url.get();
        Intrinsics.checkNotNullExpressionValue(qZoneBaseMeta$StPicUrl, "this.default_url.get()");
        commonStImage.j(d(qZoneBaseMeta$StPicUrl));
        commonStImage.k(qZoneBaseMeta$StImage.is_gif.get());
        return commonStImage;
    }

    public static final CommonStMedia b(QZoneBaseMeta$StMedia qZoneBaseMeta$StMedia) {
        Intrinsics.checkNotNullParameter(qZoneBaseMeta$StMedia, "<this>");
        CommonStMedia commonStMedia = new CommonStMedia();
        if (qZoneBaseMeta$StMedia.type.get() == 0) {
            commonStMedia.E(CommonEnumMediaType.IMAGE.ordinal());
        } else if (qZoneBaseMeta$StMedia.type.get() == 1) {
            commonStMedia.E(CommonEnumMediaType.VIDEO.ordinal());
        }
        QZoneBaseMeta$StImage qZoneBaseMeta$StImage = qZoneBaseMeta$StMedia.image.get();
        Intrinsics.checkNotNullExpressionValue(qZoneBaseMeta$StImage, "this.image.get()");
        commonStMedia.y(a(qZoneBaseMeta$StImage));
        QZoneBaseMeta$StVideo qZoneBaseMeta$StVideo = qZoneBaseMeta$StMedia.video.get();
        Intrinsics.checkNotNullExpressionValue(qZoneBaseMeta$StVideo, "this.video.get()");
        commonStMedia.V(e(qZoneBaseMeta$StVideo));
        commonStMedia.x(qZoneBaseMeta$StMedia.desc.get());
        commonStMedia.F(qZoneBaseMeta$StMedia.uploader.get());
        commonStMedia.v(qZoneBaseMeta$StMedia.batch_id.get());
        commonStMedia.M(qZoneBaseMeta$StMedia.upload_time.get());
        return commonStMedia;
    }

    public static final CommonStPicSpecUrlEntry c(QZoneBaseMeta$StPicSpecUrlEntry qZoneBaseMeta$StPicSpecUrlEntry) {
        Intrinsics.checkNotNullParameter(qZoneBaseMeta$StPicSpecUrlEntry, "<this>");
        CommonStPicSpecUrlEntry commonStPicSpecUrlEntry = new CommonStPicSpecUrlEntry();
        switch (qZoneBaseMeta$StPicSpecUrlEntry.spec.get()) {
            case 0:
                commonStPicSpecUrlEntry.c(CommonEnumPhotoSpec.PHOTO_SPEC_ORIGIN.ordinal());
                break;
            case 1:
                commonStPicSpecUrlEntry.c(CommonEnumPhotoSpec.PHOTO_SPEC_BIG.ordinal());
                break;
            case 2:
                commonStPicSpecUrlEntry.c(CommonEnumPhotoSpec.PHOTO_SPEC_MEDIUM.ordinal());
                break;
            case 3:
                commonStPicSpecUrlEntry.c(CommonEnumPhotoSpec.PHOTO_SPEC_SMALL.ordinal());
                break;
            case 4:
                commonStPicSpecUrlEntry.c(CommonEnumPhotoSpec.PHOTO_SPEC_THUMB.ordinal());
                break;
            case 5:
                commonStPicSpecUrlEntry.c(CommonEnumPhotoSpec.PHOTO_SPEC_CURRENT.ordinal());
                break;
            case 6:
                commonStPicSpecUrlEntry.c(CommonEnumPhotoSpec.PHOTO_SPEC_DOWNLOAD.ordinal());
                break;
        }
        QZoneBaseMeta$StPicUrl qZoneBaseMeta$StPicUrl = qZoneBaseMeta$StPicSpecUrlEntry.url.get();
        Intrinsics.checkNotNullExpressionValue(qZoneBaseMeta$StPicUrl, "this.url.get()");
        commonStPicSpecUrlEntry.e(d(qZoneBaseMeta$StPicUrl));
        return commonStPicSpecUrlEntry;
    }

    public static final CommonStPicUrl d(QZoneBaseMeta$StPicUrl qZoneBaseMeta$StPicUrl) {
        Intrinsics.checkNotNullParameter(qZoneBaseMeta$StPicUrl, "<this>");
        CommonStPicUrl commonStPicUrl = new CommonStPicUrl();
        String str = qZoneBaseMeta$StPicUrl.url.get();
        Intrinsics.checkNotNullExpressionValue(str, "this.url.get()");
        commonStPicUrl.c(str);
        commonStPicUrl.e(qZoneBaseMeta$StPicUrl.width.get());
        commonStPicUrl.b(qZoneBaseMeta$StPicUrl.height.get());
        return commonStPicUrl;
    }

    public static final CommonStVideo e(QZoneBaseMeta$StVideo qZoneBaseMeta$StVideo) {
        Intrinsics.checkNotNullParameter(qZoneBaseMeta$StVideo, "<this>");
        CommonStVideo commonStVideo = new CommonStVideo();
        String str = qZoneBaseMeta$StVideo.f430340id.get();
        Intrinsics.checkNotNullExpressionValue(str, "this.id.get()");
        commonStVideo.j(str);
        String str2 = qZoneBaseMeta$StVideo.url.get();
        Intrinsics.checkNotNullExpressionValue(str2, "this.url.get()");
        commonStVideo.k(str2);
        QZoneBaseMeta$StImage qZoneBaseMeta$StImage = qZoneBaseMeta$StVideo.cover.get();
        Intrinsics.checkNotNullExpressionValue(qZoneBaseMeta$StImage, "this.cover.get()");
        commonStVideo.f(a(qZoneBaseMeta$StImage));
        commonStVideo.m(qZoneBaseMeta$StVideo.width.get());
        commonStVideo.g(qZoneBaseMeta$StVideo.height.get());
        commonStVideo.l(qZoneBaseMeta$StVideo.video_time.get());
        return commonStVideo;
    }
}
