package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert;

import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean.CommonAlbumInfo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean.CommonStImage;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean.CommonStMedia;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean.CommonStPicSpecUrlEntry;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean.CommonStPicUrl;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.enumtype.CommonEnumMediaType;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.enumtype.CommonEnumPhotoSpec;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t\u001a\u0014\u0010\u0005\u001a\u00020\u0006*\u00020\n2\b\b\u0002\u0010\b\u001a\u00020\t\u001a\u0014\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\t\u001a\u000e\u0010\u000b\u001a\u0004\u0018\u00010\f*\u0004\u0018\u00010\u0007\u001a\n\u0010\u000b\u001a\u00020\u0006*\u00020\u0002\u001a\f\u0010\r\u001a\u00020\u0001*\u0004\u0018\u00010\f\u001a\u000e\u0010\u000e\u001a\u0004\u0018\u00010\f*\u0004\u0018\u00010\n\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003\"\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0003\u00a8\u0006\u000f"}, d2 = {"isImage", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStMedia;", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStMedia;)Z", BaseProfileQZoneComponent.KEY_IS_VIDEO, "coverUrl", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonAlbumInfo;", "photoSpec", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStImage;", "defaultCoverUrl", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStPicUrl;", AppConstants.Key.COLUMN_IS_VALID, "peekUrl", "qecommerce-biz_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonBeanExtKt {
    public static final String coverUrl(CommonAlbumInfo commonAlbumInfo, int i3) {
        return coverUrl(commonAlbumInfo.getCover(), i3);
    }

    public static /* synthetic */ String coverUrl$default(CommonAlbumInfo commonAlbumInfo, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = CommonEnumPhotoSpec.PHOTO_SPEC_ORIGIN.ordinal();
        }
        return coverUrl(commonAlbumInfo, i3);
    }

    public static final CommonStPicUrl defaultCoverUrl(CommonAlbumInfo commonAlbumInfo) {
        CommonStImage image;
        if (commonAlbumInfo == null) {
            return null;
        }
        if (isVideo(commonAlbumInfo.getCover())) {
            image = commonAlbumInfo.getCover().getVideo().getCover();
        } else {
            image = commonAlbumInfo.getCover().getImage();
        }
        return peekUrl(image);
    }

    public static final boolean isImage(CommonStMedia commonStMedia) {
        return commonStMedia.getType() == CommonEnumMediaType.IMAGE.ordinal();
    }

    public static final boolean isVideo(CommonStMedia commonStMedia) {
        return commonStMedia.getType() == CommonEnumMediaType.VIDEO.ordinal();
    }

    public static final String coverUrl(CommonStMedia commonStMedia, int i3) {
        return isImage(commonStMedia) ? coverUrl(commonStMedia.getImage(), i3) : isVideo(commonStMedia) ? coverUrl(commonStMedia.getVideo().getCover(), i3) : "";
    }

    public static /* synthetic */ String coverUrl$default(CommonStMedia commonStMedia, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = CommonEnumPhotoSpec.PHOTO_SPEC_ORIGIN.ordinal();
        }
        return coverUrl(commonStMedia, i3);
    }

    public static /* synthetic */ String coverUrl$default(CommonStImage commonStImage, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = CommonEnumPhotoSpec.PHOTO_SPEC_ORIGIN.ordinal();
        }
        return coverUrl(commonStImage, i3);
    }

    public static final String coverUrl(CommonStImage commonStImage, int i3) {
        boolean z16;
        String str;
        Object obj;
        Object orNull;
        CommonStPicUrl url;
        String url2;
        CommonStPicUrl url3;
        Iterator<T> it = commonStImage.getPhotoUrl().iterator();
        while (true) {
            z16 = true;
            str = null;
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((CommonStPicSpecUrlEntry) obj).getSpec() == i3) {
                break;
            }
        }
        CommonStPicSpecUrlEntry commonStPicSpecUrlEntry = (CommonStPicSpecUrlEntry) obj;
        if (commonStPicSpecUrlEntry != null && (url3 = commonStPicSpecUrlEntry.getUrl()) != null) {
            str = url3.getUrl();
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        }
        if (!z16) {
            return str;
        }
        orNull = CollectionsKt___CollectionsKt.getOrNull(commonStImage.getPhotoUrl(), 0);
        CommonStPicSpecUrlEntry commonStPicSpecUrlEntry2 = (CommonStPicSpecUrlEntry) orNull;
        return (commonStPicSpecUrlEntry2 == null || (url = commonStPicSpecUrlEntry2.getUrl()) == null || (url2 = url.getUrl()) == null) ? "" : url2;
    }

    public static final boolean isValid(CommonStPicUrl commonStPicUrl) {
        if (commonStPicUrl == null) {
            return false;
        }
        String url = commonStPicUrl.getUrl();
        return !(url == null || url.length() == 0);
    }

    public static final String defaultCoverUrl(CommonStMedia commonStMedia) {
        CommonStPicUrl peekUrl;
        String url;
        if (isImage(commonStMedia)) {
            CommonStPicUrl peekUrl2 = peekUrl(commonStMedia.getImage());
            if (peekUrl2 == null || (url = peekUrl2.getUrl()) == null) {
                return "";
            }
        } else if (!isVideo(commonStMedia) || (peekUrl = peekUrl(commonStMedia.getVideo().getCover())) == null || (url = peekUrl.getUrl()) == null) {
            return "";
        }
        return url;
    }

    public static final CommonStPicUrl peekUrl(CommonStImage commonStImage) {
        if (commonStImage == null) {
            return null;
        }
        if (isValid(commonStImage.getDefaultUrl())) {
            return commonStImage.getDefaultUrl();
        }
        return CommonPicUtils.INSTANCE.getDefaultUrlByCurrentFirst(commonStImage.getPhotoUrl());
    }
}
