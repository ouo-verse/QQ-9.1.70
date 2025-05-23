package oj;

import com.qzone.proxy.feedcomponent.model.ShuoshuoVideoInfo;
import com.qzone.util.image.ImageInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZoneBaseMeta$StImage;
import qzone.QZoneBaseMeta$StMedia;
import qzone.QZoneBaseMeta$StPicSpecUrlEntry;
import qzone.QZoneBaseMeta$StPicUrl;
import qzone.QZoneBaseMeta$StVideo;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0003\u00a8\u0006\u0005"}, d2 = {"Lcom/qzone/util/image/ImageInfo;", "Lqzone/QZoneBaseMeta$StMedia;", "b", "Lcom/qzone/proxy/feedcomponent/model/ShuoshuoVideoInfo;", "a", "qzone_df_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class c {
    public static final QZoneBaseMeta$StMedia a(ShuoshuoVideoInfo shuoshuoVideoInfo) {
        Intrinsics.checkNotNullParameter(shuoshuoVideoInfo, "<this>");
        QZoneBaseMeta$StVideo qZoneBaseMeta$StVideo = new QZoneBaseMeta$StVideo();
        qZoneBaseMeta$StVideo.f430340id.set("");
        qZoneBaseMeta$StVideo.height.set(shuoshuoVideoInfo.mVideoHeight);
        qZoneBaseMeta$StVideo.width.set(shuoshuoVideoInfo.mVideoWidth);
        qZoneBaseMeta$StVideo.url.set(shuoshuoVideoInfo.mVideoPath);
        qZoneBaseMeta$StVideo.video_time.set(shuoshuoVideoInfo.mDuration);
        QZoneBaseMeta$StImage qZoneBaseMeta$StImage = new QZoneBaseMeta$StImage();
        PBRepeatMessageField<QZoneBaseMeta$StPicSpecUrlEntry> pBRepeatMessageField = qZoneBaseMeta$StImage.photo_url;
        b bVar = b.f423009a;
        String str = shuoshuoVideoInfo.mCoverUrl;
        if (str == null) {
            str = "";
        }
        pBRepeatMessageField.add(b.c(bVar, str, shuoshuoVideoInfo.mVideoWidth, shuoshuoVideoInfo.mVideoHeight, 0, 8, null));
        QZoneBaseMeta$StPicUrl qZoneBaseMeta$StPicUrl = new QZoneBaseMeta$StPicUrl();
        PBStringField pBStringField = qZoneBaseMeta$StPicUrl.url;
        String str2 = shuoshuoVideoInfo.mCoverUrl;
        pBStringField.set(str2 != null ? str2 : "");
        qZoneBaseMeta$StPicUrl.width.set(shuoshuoVideoInfo.mVideoWidth);
        qZoneBaseMeta$StPicUrl.height.set(shuoshuoVideoInfo.mVideoHeight);
        qZoneBaseMeta$StImage.default_url.set(qZoneBaseMeta$StPicUrl);
        qZoneBaseMeta$StVideo.cover.set(qZoneBaseMeta$StImage);
        QZoneBaseMeta$StMedia qZoneBaseMeta$StMedia = new QZoneBaseMeta$StMedia();
        qZoneBaseMeta$StMedia.type.set(1);
        qZoneBaseMeta$StMedia.video.set(qZoneBaseMeta$StVideo);
        return qZoneBaseMeta$StMedia;
    }

    public static final QZoneBaseMeta$StMedia b(ImageInfo imageInfo) {
        Intrinsics.checkNotNullParameter(imageInfo, "<this>");
        QZoneBaseMeta$StImage qZoneBaseMeta$StImage = new QZoneBaseMeta$StImage();
        PBRepeatMessageField<QZoneBaseMeta$StPicSpecUrlEntry> pBRepeatMessageField = qZoneBaseMeta$StImage.photo_url;
        b bVar = b.f423009a;
        String mPath = imageInfo.mPath;
        Intrinsics.checkNotNullExpressionValue(mPath, "mPath");
        pBRepeatMessageField.add(bVar.b(mPath, imageInfo.photoWidth, imageInfo.photoHeight, 5));
        PBRepeatMessageField<QZoneBaseMeta$StPicSpecUrlEntry> pBRepeatMessageField2 = qZoneBaseMeta$StImage.photo_url;
        String mPath2 = imageInfo.mPath;
        Intrinsics.checkNotNullExpressionValue(mPath2, "mPath");
        pBRepeatMessageField2.add(bVar.b(mPath2, imageInfo.photoWidth, imageInfo.photoHeight, 1));
        PBRepeatMessageField<QZoneBaseMeta$StPicSpecUrlEntry> pBRepeatMessageField3 = qZoneBaseMeta$StImage.photo_url;
        String mPath3 = imageInfo.mPath;
        Intrinsics.checkNotNullExpressionValue(mPath3, "mPath");
        pBRepeatMessageField3.add(bVar.b(mPath3, imageInfo.photoWidth, imageInfo.photoHeight, 0));
        QZoneBaseMeta$StPicUrl qZoneBaseMeta$StPicUrl = new QZoneBaseMeta$StPicUrl();
        qZoneBaseMeta$StPicUrl.url.set(imageInfo.mPath);
        qZoneBaseMeta$StPicUrl.width.set(imageInfo.photoWidth);
        qZoneBaseMeta$StPicUrl.height.set(imageInfo.photoHeight);
        qZoneBaseMeta$StImage.default_url.set(qZoneBaseMeta$StPicUrl);
        QZoneBaseMeta$StMedia qZoneBaseMeta$StMedia = new QZoneBaseMeta$StMedia();
        qZoneBaseMeta$StMedia.type.set(0);
        qZoneBaseMeta$StMedia.image.set(qZoneBaseMeta$StImage);
        return qZoneBaseMeta$StMedia;
    }
}
