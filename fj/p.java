package fj;

import android.text.TextUtils;
import com.qzone.reborn.albumx.common.convert.bean.CommonStImage;
import com.qzone.reborn.albumx.common.convert.bean.CommonStMedia;
import com.qzone.reborn.albumx.common.convert.bean.CommonStPicSpecUrlEntry;
import com.qzone.reborn.albumx.common.convert.bean.CommonStPicUrl;
import com.qzone.reborn.albumx.common.convert.bean.CommonStVideo;
import com.qzone.reborn.albumx.common.convert.enumtype.CommonEnumPhotoSpec;
import com.qzone.reborn.groupalbum.layer.bean.GroupAlbumLayerExtraInfoBean;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import com.tencent.richframework.gallery.bean.RFWLayerVideoInfo;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0002J\u0016\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0011\u001a\u00020\nJ\u0006\u0010\u0012\u001a\u00020\nJ\u000e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u000fJ\u000e\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u000f\u00a8\u0006\u0019"}, d2 = {"Lfj/p;", "", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "mediaInfo", "Lcom/qzone/reborn/groupalbum/layer/bean/GroupAlbumLayerExtraInfoBean;", "extraInfo", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStImage;", "b", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStVideo;", "c", "", "width", "g", "height", "f", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStMedia;", "a", "e", "d", "stMedia", "", "i", tl.h.F, "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public static final p f399467a = new p();

    p() {
    }

    private final CommonStImage b(RFWLayerItemMediaInfo mediaInfo, GroupAlbumLayerExtraInfoBean extraInfo) {
        RFWLayerPicInfo.RFWPicInfo originPicInfo;
        RFWLayerPicInfo.RFWPicInfo originPicInfo2;
        RFWLayerPicInfo.RFWPicInfo originPicInfo3;
        RFWLayerPicInfo.RFWPicInfo originPicInfo4;
        RFWLayerPicInfo.RFWPicInfo downloadPicInfo;
        RFWLayerPicInfo.RFWPicInfo downloadPicInfo2;
        RFWLayerPicInfo.RFWPicInfo downloadPicInfo3;
        RFWLayerPicInfo.RFWPicInfo downloadPicInfo4;
        RFWLayerPicInfo.RFWPicInfo bigPicInfo;
        RFWLayerPicInfo.RFWPicInfo bigPicInfo2;
        RFWLayerPicInfo.RFWPicInfo bigPicInfo3;
        RFWLayerPicInfo.RFWPicInfo bigPicInfo4;
        RFWLayerPicInfo.RFWPicInfo currentPicInfo;
        RFWLayerPicInfo.RFWPicInfo currentPicInfo2;
        RFWLayerPicInfo.RFWPicInfo currentPicInfo3;
        RFWLayerPicInfo.RFWPicInfo currentPicInfo4;
        CommonStImage commonStImage = new CommonStImage();
        String lLoc = extraInfo.getLLoc();
        if (lLoc == null) {
            lLoc = "";
        }
        commonStImage.l(lLoc);
        String sLoc = extraInfo.getSLoc();
        commonStImage.o(sLoc != null ? sLoc : "");
        ArrayList arrayList = new ArrayList();
        RFWLayerPicInfo layerPicInfo = mediaInfo.getLayerPicInfo();
        String str = null;
        int i3 = 0;
        if (!TextUtils.isEmpty((layerPicInfo == null || (currentPicInfo4 = layerPicInfo.getCurrentPicInfo()) == null) ? null : currentPicInfo4.getUrl())) {
            CommonStPicSpecUrlEntry commonStPicSpecUrlEntry = new CommonStPicSpecUrlEntry();
            commonStPicSpecUrlEntry.c(CommonEnumPhotoSpec.PHOTO_SPEC_CURRENT.ordinal());
            CommonStPicUrl commonStPicUrl = new CommonStPicUrl();
            RFWLayerPicInfo layerPicInfo2 = mediaInfo.getLayerPicInfo();
            String url = (layerPicInfo2 == null || (currentPicInfo3 = layerPicInfo2.getCurrentPicInfo()) == null) ? null : currentPicInfo3.getUrl();
            Intrinsics.checkNotNull(url);
            commonStPicUrl.c(url);
            RFWLayerPicInfo layerPicInfo3 = mediaInfo.getLayerPicInfo();
            commonStPicUrl.e(g((layerPicInfo3 == null || (currentPicInfo2 = layerPicInfo3.getCurrentPicInfo()) == null) ? 0 : currentPicInfo2.getWidth()));
            RFWLayerPicInfo layerPicInfo4 = mediaInfo.getLayerPicInfo();
            commonStPicUrl.b(f((layerPicInfo4 == null || (currentPicInfo = layerPicInfo4.getCurrentPicInfo()) == null) ? 0 : currentPicInfo.getHeight()));
            commonStPicSpecUrlEntry.e(commonStPicUrl);
            arrayList.add(commonStPicSpecUrlEntry);
        }
        RFWLayerPicInfo layerPicInfo5 = mediaInfo.getLayerPicInfo();
        if (!TextUtils.isEmpty((layerPicInfo5 == null || (bigPicInfo4 = layerPicInfo5.getBigPicInfo()) == null) ? null : bigPicInfo4.getUrl())) {
            CommonStPicSpecUrlEntry commonStPicSpecUrlEntry2 = new CommonStPicSpecUrlEntry();
            commonStPicSpecUrlEntry2.c(CommonEnumPhotoSpec.PHOTO_SPEC_BIG.ordinal());
            CommonStPicUrl commonStPicUrl2 = new CommonStPicUrl();
            RFWLayerPicInfo layerPicInfo6 = mediaInfo.getLayerPicInfo();
            String url2 = (layerPicInfo6 == null || (bigPicInfo3 = layerPicInfo6.getBigPicInfo()) == null) ? null : bigPicInfo3.getUrl();
            Intrinsics.checkNotNull(url2);
            commonStPicUrl2.c(url2);
            RFWLayerPicInfo layerPicInfo7 = mediaInfo.getLayerPicInfo();
            commonStPicUrl2.e(g((layerPicInfo7 == null || (bigPicInfo2 = layerPicInfo7.getBigPicInfo()) == null) ? 0 : bigPicInfo2.getWidth()));
            RFWLayerPicInfo layerPicInfo8 = mediaInfo.getLayerPicInfo();
            commonStPicUrl2.b(f((layerPicInfo8 == null || (bigPicInfo = layerPicInfo8.getBigPicInfo()) == null) ? 0 : bigPicInfo.getHeight()));
            commonStPicSpecUrlEntry2.e(commonStPicUrl2);
            arrayList.add(commonStPicSpecUrlEntry2);
        }
        RFWLayerPicInfo layerPicInfo9 = mediaInfo.getLayerPicInfo();
        if (!TextUtils.isEmpty((layerPicInfo9 == null || (downloadPicInfo4 = layerPicInfo9.getDownloadPicInfo()) == null) ? null : downloadPicInfo4.getUrl())) {
            CommonStPicSpecUrlEntry commonStPicSpecUrlEntry3 = new CommonStPicSpecUrlEntry();
            commonStPicSpecUrlEntry3.c(CommonEnumPhotoSpec.PHOTO_SPEC_DOWNLOAD.ordinal());
            CommonStPicUrl commonStPicUrl3 = new CommonStPicUrl();
            RFWLayerPicInfo layerPicInfo10 = mediaInfo.getLayerPicInfo();
            String url3 = (layerPicInfo10 == null || (downloadPicInfo3 = layerPicInfo10.getDownloadPicInfo()) == null) ? null : downloadPicInfo3.getUrl();
            Intrinsics.checkNotNull(url3);
            commonStPicUrl3.c(url3);
            RFWLayerPicInfo layerPicInfo11 = mediaInfo.getLayerPicInfo();
            commonStPicUrl3.e(g((layerPicInfo11 == null || (downloadPicInfo2 = layerPicInfo11.getDownloadPicInfo()) == null) ? 0 : downloadPicInfo2.getWidth()));
            RFWLayerPicInfo layerPicInfo12 = mediaInfo.getLayerPicInfo();
            commonStPicUrl3.b(f((layerPicInfo12 == null || (downloadPicInfo = layerPicInfo12.getDownloadPicInfo()) == null) ? 0 : downloadPicInfo.getHeight()));
            commonStPicSpecUrlEntry3.e(commonStPicUrl3);
            arrayList.add(commonStPicSpecUrlEntry3);
        }
        RFWLayerPicInfo layerPicInfo13 = mediaInfo.getLayerPicInfo();
        if (!TextUtils.isEmpty((layerPicInfo13 == null || (originPicInfo4 = layerPicInfo13.getOriginPicInfo()) == null) ? null : originPicInfo4.getUrl())) {
            CommonStPicSpecUrlEntry commonStPicSpecUrlEntry4 = new CommonStPicSpecUrlEntry();
            commonStPicSpecUrlEntry4.c(CommonEnumPhotoSpec.PHOTO_SPEC_ORIGIN.ordinal());
            CommonStPicUrl commonStPicUrl4 = new CommonStPicUrl();
            RFWLayerPicInfo layerPicInfo14 = mediaInfo.getLayerPicInfo();
            if (layerPicInfo14 != null && (originPicInfo3 = layerPicInfo14.getOriginPicInfo()) != null) {
                str = originPicInfo3.getUrl();
            }
            Intrinsics.checkNotNull(str);
            commonStPicUrl4.c(str);
            RFWLayerPicInfo layerPicInfo15 = mediaInfo.getLayerPicInfo();
            commonStPicUrl4.e(g((layerPicInfo15 == null || (originPicInfo2 = layerPicInfo15.getOriginPicInfo()) == null) ? 0 : originPicInfo2.getWidth()));
            RFWLayerPicInfo layerPicInfo16 = mediaInfo.getLayerPicInfo();
            if (layerPicInfo16 != null && (originPicInfo = layerPicInfo16.getOriginPicInfo()) != null) {
                i3 = originPicInfo.getHeight();
            }
            commonStPicUrl4.b(f(i3));
            commonStPicSpecUrlEntry4.e(commonStPicUrl4);
            arrayList.add(commonStPicSpecUrlEntry4);
        }
        commonStImage.n(arrayList);
        return commonStImage;
    }

    private final CommonStVideo c(RFWLayerItemMediaInfo mediaInfo, GroupAlbumLayerExtraInfoBean extraInfo) {
        CommonStVideo commonStVideo = new CommonStVideo();
        String videoId = extraInfo.getVideoId();
        Intrinsics.checkNotNull(videoId);
        commonStVideo.j(videoId);
        RFWLayerVideoInfo layerVideoInfo = mediaInfo.getLayerVideoInfo();
        String normalVideoUrl = layerVideoInfo != null ? layerVideoInfo.getNormalVideoUrl() : null;
        Intrinsics.checkNotNull(normalVideoUrl);
        commonStVideo.k(normalVideoUrl);
        commonStVideo.f(b(mediaInfo, extraInfo));
        RFWLayerVideoInfo layerVideoInfo2 = mediaInfo.getLayerVideoInfo();
        commonStVideo.m(g(layerVideoInfo2 != null ? layerVideoInfo2.getVideoWidth() : 0));
        RFWLayerVideoInfo layerVideoInfo3 = mediaInfo.getLayerVideoInfo();
        commonStVideo.g(f(layerVideoInfo3 != null ? layerVideoInfo3.getVideoHeight() : 0));
        if (mediaInfo.getLayerVideoInfo() != null) {
            commonStVideo.l(r3.getVideoDurationSec());
        }
        return commonStVideo;
    }

    public final CommonStMedia a(RFWLayerItemMediaInfo mediaInfo, GroupAlbumLayerExtraInfoBean extraInfo) {
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        CommonStMedia commonStMedia = new CommonStMedia();
        if (extraInfo.getCom.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent.KEY_IS_VIDEO java.lang.String()) {
            commonStMedia.E(1);
            commonStMedia.V(c(mediaInfo, extraInfo));
        } else {
            commonStMedia.E(0);
            commonStMedia.y(b(mediaInfo, extraInfo));
        }
        String desc = extraInfo.getDesc();
        if (desc == null) {
            desc = "";
        }
        commonStMedia.x(desc);
        String batchId = extraInfo.getBatchId();
        Intrinsics.checkNotNull(batchId);
        commonStMedia.v(Long.parseLong(batchId));
        String uploadUid = extraInfo.getUploadUid();
        commonStMedia.F(uploadUid != null ? uploadUid : "");
        return commonStMedia;
    }

    public final int d() {
        return (ImmersiveUtils.getScreenWidth() * 4) / 3;
    }

    public final int e() {
        return ImmersiveUtils.getScreenWidth();
    }

    public final String h(CommonStMedia stMedia) {
        Intrinsics.checkNotNullParameter(stMedia, "stMedia");
        return String.valueOf(stMedia.getBatchId());
    }

    public final String i(CommonStMedia stMedia) {
        Intrinsics.checkNotNullParameter(stMedia, "stMedia");
        if (stMedia.getType() == 0) {
            return stMedia.getImage().getLloc();
        }
        return stMedia.getVideo().getCover().getLloc();
    }

    private final int f(int height) {
        return height == 0 ? d() : height;
    }

    private final int g(int width) {
        return width == 0 ? e() : width;
    }
}
