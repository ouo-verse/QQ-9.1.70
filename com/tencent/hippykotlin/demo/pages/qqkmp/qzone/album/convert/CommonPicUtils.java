package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert;

import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean.CommonStImage;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean.CommonStMedia;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean.CommonStPicSpecUrlEntry;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean.CommonStPicUrl;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean.CommonStVideo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.enumtype.CommonEnumMediaType;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.enumtype.CommonEnumPhotoSpec;
import com.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006J\u0018\u0010\b\u001a\u0004\u0018\u00010\u00042\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ \u0010\u000e\u001a\u0004\u0018\u00010\u00042\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\u0010J \u0010\u0011\u001a\u0004\u0018\u00010\u00042\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\u0012\u001a\u00020\u00132\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/CommonPicUtils;", "", "()V", "getDefaultUrl", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStPicUrl;", "urlEntryList", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStPicSpecUrlEntry;", "getDefaultUrlByCurrentFirst", "getMediaId", "", QAdVrReportParams.ParamKey.MEDIA, "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStMedia;", "getMediaStPicUrlByCurrentFirst", "getPicUrlByPhotoSpec", "photoSpec", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/enumtype/CommonEnumPhotoSpec;", "getPicUrlByPhotoSpecByBigSpecWhenNotMatch", BaseProfileQZoneComponent.KEY_IS_VIDEO, "", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonPicUtils {
    public static final int $stable = 0;
    public static final CommonPicUtils INSTANCE = new CommonPicUtils();

    CommonPicUtils() {
    }

    public final CommonStPicUrl getDefaultUrl(List<CommonStPicSpecUrlEntry> urlEntryList) {
        CommonStPicUrl picUrlByPhotoSpec = getPicUrlByPhotoSpec(urlEntryList, CommonEnumPhotoSpec.PHOTO_SPEC_BIG);
        if (!CommonBeanExtKt.isValid(picUrlByPhotoSpec)) {
            picUrlByPhotoSpec = getPicUrlByPhotoSpec(urlEntryList, CommonEnumPhotoSpec.PHOTO_SPEC_CURRENT);
        }
        if (!CommonBeanExtKt.isValid(picUrlByPhotoSpec)) {
            picUrlByPhotoSpec = getPicUrlByPhotoSpec(urlEntryList, CommonEnumPhotoSpec.PHOTO_SPEC_DOWNLOAD);
        }
        return !CommonBeanExtKt.isValid(picUrlByPhotoSpec) ? getPicUrlByPhotoSpec(urlEntryList, CommonEnumPhotoSpec.PHOTO_SPEC_ORIGIN) : picUrlByPhotoSpec;
    }

    public final CommonStPicUrl getDefaultUrlByCurrentFirst(List<CommonStPicSpecUrlEntry> urlEntryList) {
        CommonStPicUrl picUrlByPhotoSpec = getPicUrlByPhotoSpec(urlEntryList, CommonEnumPhotoSpec.PHOTO_SPEC_CURRENT);
        if (!CommonBeanExtKt.isValid(picUrlByPhotoSpec)) {
            picUrlByPhotoSpec = getPicUrlByPhotoSpec(urlEntryList, CommonEnumPhotoSpec.PHOTO_SPEC_BIG);
        }
        if (!CommonBeanExtKt.isValid(picUrlByPhotoSpec)) {
            picUrlByPhotoSpec = getPicUrlByPhotoSpec(urlEntryList, CommonEnumPhotoSpec.PHOTO_SPEC_DOWNLOAD);
        }
        return !CommonBeanExtKt.isValid(picUrlByPhotoSpec) ? getPicUrlByPhotoSpec(urlEntryList, CommonEnumPhotoSpec.PHOTO_SPEC_ORIGIN) : picUrlByPhotoSpec;
    }

    public final boolean isVideo(CommonStMedia media) {
        return media != null && media.getType() == CommonEnumMediaType.VIDEO.ordinal();
    }

    public final String getMediaId(CommonStMedia media) {
        CommonStVideo video;
        CommonStImage cover;
        if (media == null) {
            return null;
        }
        if (media.getType() == CommonEnumMediaType.IMAGE.ordinal()) {
            CommonStImage image = media.getImage();
            if (image != null) {
                return image.getLloc();
            }
            return null;
        }
        if (media.getType() != CommonEnumMediaType.VIDEO.ordinal() || (video = media.getVideo()) == null || (cover = video.getCover()) == null) {
            return null;
        }
        return cover.getLloc();
    }

    public final CommonStPicUrl getPicUrlByPhotoSpec(List<CommonStPicSpecUrlEntry> urlEntryList, CommonEnumPhotoSpec photoSpec) {
        CommonStPicUrl commonStPicUrl = null;
        if (urlEntryList != null) {
            for (CommonStPicSpecUrlEntry commonStPicSpecUrlEntry : urlEntryList) {
                if (commonStPicSpecUrlEntry.getSpec() == photoSpec.ordinal()) {
                    if (commonStPicSpecUrlEntry.getUrl().getUrl().length() > 0) {
                        return commonStPicSpecUrlEntry.getUrl();
                    }
                }
                if (commonStPicUrl == null) {
                    if (commonStPicSpecUrlEntry.getUrl().getUrl().length() > 0) {
                        commonStPicUrl = commonStPicSpecUrlEntry.getUrl();
                    }
                }
            }
        }
        return commonStPicUrl;
    }

    public final CommonStPicUrl getPicUrlByPhotoSpecByBigSpecWhenNotMatch(List<CommonStPicSpecUrlEntry> urlEntryList, CommonEnumPhotoSpec photoSpec) {
        CommonStPicUrl commonStPicUrl = null;
        if (urlEntryList != null) {
            for (CommonStPicSpecUrlEntry commonStPicSpecUrlEntry : urlEntryList) {
                if (commonStPicSpecUrlEntry.getSpec() == photoSpec.ordinal()) {
                    if (commonStPicSpecUrlEntry.getUrl().getUrl().length() > 0) {
                        return commonStPicSpecUrlEntry.getUrl();
                    }
                }
                if (commonStPicSpecUrlEntry.getSpec() == CommonEnumPhotoSpec.PHOTO_SPEC_BIG.ordinal()) {
                    if (commonStPicSpecUrlEntry.getUrl().getUrl().length() > 0) {
                        commonStPicUrl = commonStPicSpecUrlEntry.getUrl();
                    }
                }
                if (commonStPicUrl == null) {
                    if (commonStPicSpecUrlEntry.getUrl().getUrl().length() > 0) {
                        commonStPicUrl = commonStPicSpecUrlEntry.getUrl();
                    }
                }
            }
        }
        return commonStPicUrl;
    }

    public final CommonStPicUrl getMediaStPicUrlByCurrentFirst(CommonStMedia media) {
        if (media == null) {
            return null;
        }
        if (isVideo(media)) {
            return getDefaultUrlByCurrentFirst(media.getVideo().getCover().getPhotoUrl());
        }
        return getDefaultUrlByCurrentFirst(media.getImage().getPhotoUrl());
    }
}
