package com.tencent.qzonehub.api.panorama;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;

@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IPanoramaUtil extends QRouteApi {
    public static final int CYLINDER_PIECE = 36;
    public static final String MTA_EVENT_KEY_ALBUM_DLNA = "qzone_panorama";
    public static final String MTA_SUB_KEY_COVER_PANORAMA = "qzone_cover_panorama";
    public static final String MTA_SUB_KEY_FEED_PANORAMA = "qzone_feed_panorama";
    public static final String MTA_SUB_KEY_GALLERY = "qzone_gallery";
    public static final String MTA_SUB_KEY_GALLERY_PANORAMA = "qzone_gallery_panorama";
    public static final String MTA_SUB_KEY_UPLOAD_ALL_COUNT = "upload_all_count";
    public static final String MTA_SUB_KEY_UPLOAD_PANORAMA_CYLINDER = "upload_panorama_cylinder";
    public static final String MTA_SUB_KEY_UPLOAD_PANORAMA_SPHERE = "upload_panorama_sphere";
    public static final String MTA_VALUE_PANORAMA_CLICK = "click";
    public static final String MTA_VALUE_PANORAMA_EXPOSE = "expose";
    public static final String SVR_PANORAMA_BALL = "2";
    public static final String SVR_PANORAMA_CYLINDER = "1";
    public static final String SVR_PANORAMA_NORMAL = "0";
    public static final int TYPE_PANORAMA_BALL = 2;
    public static final int TYPE_PANORAMA_CYLINDER = 1;
    public static final String TYPE_PANORAMA_NAME = "panorama_type";
    public static final int TYPE_PANORAMA_NORMAL = 3;

    int computeSampleSize(Object obj, int i3, int i16);

    ArrayList<float[]> getCylinderCoordinate(float f16, boolean z16);

    ArrayList<float[]> getSphereCoordinate();

    boolean isHighDevice();

    boolean isNeedShowPanorama();

    boolean isPanoramaPhoto(int i3);

    void reportMta(String str, String str2, int i3);

    void setPanoramaType(LocalMediaInfo localMediaInfo);
}
