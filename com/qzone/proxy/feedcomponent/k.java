package com.qzone.proxy.feedcomponent;

import android.graphics.BitmapFactory;
import com.qzone.adapter.feedcomponent.q;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.publish.ui.model.MediaWrapper;
import com.qzone.util.image.ImageInfo;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import common.config.service.QzoneConfig;
import cooperation.qzone.model.BusinessAlbumInfo;
import cooperation.qzone.model.DynamicPhotoData;

/* compiled from: P */
/* loaded from: classes39.dex */
public class k extends q {

    /* renamed from: b, reason: collision with root package name */
    String f50163b = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "PhotoBabyAlbum", "\u4eb2\u5b50\u76f8\u518c");

    /* renamed from: c, reason: collision with root package name */
    String f50164c = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "PhotoTravelAlbum", "\u65c5\u6e38\u76f8\u518c");

    /* renamed from: d, reason: collision with root package name */
    String f50165d = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "PhotoLoveAlbum", "\u60c5\u4fa3\u76f8\u518c");

    /* renamed from: e, reason: collision with root package name */
    String f50166e = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "PhotoMultiAlbum", "\u591a\u4eba\u76f8\u518c");

    /* renamed from: f, reason: collision with root package name */
    String f50167f = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "PhotoPersonalAlbum", "\u4e2a\u6027\u76f8\u518c");

    /* renamed from: g, reason: collision with root package name */
    String f50168g = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, QzoneConfig.MAIN_KEY_PHOTO_ALBUM, QzoneConfig.DefaultValue.DEFAULT_HOME_PAGE_ALBUM_TITLE);

    @Override // com.qzone.adapter.feedcomponent.q
    public VideoInfo a(Object obj) {
        MediaWrapper mediaWrapper = (MediaWrapper) obj;
        if (mediaWrapper != null) {
            return MediaWrapper.toVideoInfo(mediaWrapper.getVideoInfo());
        }
        return null;
    }

    @Override // com.qzone.adapter.feedcomponent.q
    public String e(Object obj) {
        if (!(obj instanceof BusinessAlbumInfo)) {
            return QzoneConfig.DefaultValue.DEFAULT_HOME_PAGE_ALBUM_TITLE;
        }
        int i3 = ((BusinessAlbumInfo) obj).mAlbumType;
        if (i3 == 0) {
            if (!o(obj)) {
                return QzoneConfig.DefaultValue.DEFAULT_HOME_PAGE_ALBUM_TITLE;
            }
            return "\u4e2a\u6027" + QzoneConfig.DefaultValue.DEFAULT_HOME_PAGE_ALBUM_TITLE;
        }
        if (i3 == 8) {
            return "\u4eb2\u5b50" + QzoneConfig.DefaultValue.DEFAULT_HOME_PAGE_ALBUM_TITLE;
        }
        if (i3 == 9) {
            return "\u65c5\u6e38" + QzoneConfig.DefaultValue.DEFAULT_HOME_PAGE_ALBUM_TITLE;
        }
        if (i3 == 11) {
            return "\u60c5\u4fa3" + QzoneConfig.DefaultValue.DEFAULT_HOME_PAGE_ALBUM_TITLE;
        }
        if (i3 != 12) {
            return QzoneConfig.DefaultValue.DEFAULT_HOME_PAGE_ALBUM_TITLE;
        }
        return "\u591a\u4eba" + QzoneConfig.DefaultValue.DEFAULT_HOME_PAGE_ALBUM_TITLE;
    }

    @Override // com.qzone.adapter.feedcomponent.q
    public String f(Object obj) {
        return ((ImageInfo) obj).mDescription;
    }

    @Override // com.qzone.adapter.feedcomponent.q
    public String g(Object obj) {
        DynamicPhotoData dynamicPhotoData = (DynamicPhotoData) obj;
        if (dynamicPhotoData != null) {
            return dynamicPhotoData.mTitle;
        }
        return null;
    }

    @Override // com.qzone.adapter.feedcomponent.q
    public BitmapFactory.Options h(String str) {
        return com.qzone.util.image.c.G(str);
    }

    @Override // com.qzone.adapter.feedcomponent.q
    public Object i(Object obj) {
        MediaWrapper mediaWrapper = (MediaWrapper) obj;
        if (mediaWrapper != null) {
            return mediaWrapper.getImageInfo();
        }
        return null;
    }

    @Override // com.qzone.adapter.feedcomponent.q
    public Object j(Object obj) {
        MediaWrapper mediaWrapper = (MediaWrapper) obj;
        if (mediaWrapper != null) {
            return mediaWrapper.getVideoInfo();
        }
        return null;
    }

    @Override // com.qzone.adapter.feedcomponent.q
    public String l(Object obj) {
        return ((ImageInfo) obj).mPath;
    }

    @Override // com.qzone.adapter.feedcomponent.q
    public boolean p(Object obj) {
        MediaWrapper mediaWrapper = (MediaWrapper) obj;
        return mediaWrapper != null && mediaWrapper.isImage();
    }

    @Override // com.qzone.adapter.feedcomponent.q
    public boolean q(Object obj) {
        MediaWrapper mediaWrapper = (MediaWrapper) obj;
        return mediaWrapper != null && mediaWrapper.isVideo();
    }

    @Override // com.qzone.adapter.feedcomponent.q
    public String r(Object obj) {
        return "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/qzone-platform/bottomrecom_photo.png";
    }

    @Override // com.qzone.adapter.feedcomponent.q
    public int c(Object obj) {
        if (obj == null || !(obj instanceof BusinessAlbumInfo)) {
            return -1;
        }
        return ((BusinessAlbumInfo) obj).mPrivacy;
    }

    @Override // com.qzone.adapter.feedcomponent.q
    public String d(Object obj) {
        if (obj == null || !(obj instanceof BusinessAlbumInfo)) {
            return null;
        }
        return ((BusinessAlbumInfo) obj).mTitle;
    }

    @Override // com.qzone.adapter.feedcomponent.q
    public String k(Object obj) {
        if (obj != null) {
            return String.valueOf(((ImageInfo) obj).panoramaType);
        }
        return null;
    }

    @Override // com.qzone.adapter.feedcomponent.q
    public String m(Object obj) {
        if (obj == null || !(obj instanceof BusinessAlbumInfo)) {
            return null;
        }
        return ((BusinessAlbumInfo) obj).getPrivacyDescription();
    }

    @Override // com.qzone.adapter.feedcomponent.q
    public boolean o(Object obj) {
        if (obj == null || !(obj instanceof BusinessAlbumInfo)) {
            return false;
        }
        return ((BusinessAlbumInfo) obj).isIndividualityAlbum;
    }
}
