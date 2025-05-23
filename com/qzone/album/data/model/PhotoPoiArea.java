package com.qzone.album.data.model;

import NS_MOBILE_FEEDS.album_area_item;
import NS_MOBILE_FEEDS.stPoi;
import NS_MOBILE_PHOTO.stPhotoPoiArea;
import android.text.TextUtils;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import common.config.service.QzoneConfig;

/* loaded from: classes39.dex */
public class PhotoPoiArea implements SmartParcelable {

    @NeedParcel
    public PoiInfo poiInfo;

    @NeedParcel
    public long photoNum = 0;

    @NeedParcel
    public long poiPhotoNum = 0;

    @NeedParcel
    public long startShootTime = 0;

    @NeedParcel
    public long endShootTime = 0;

    @NeedParcel
    public String description = "";

    @NeedParcel
    public String sceneryName = "";

    public static boolean equals(PhotoPoiArea photoPoiArea, PhotoPoiArea photoPoiArea2) {
        if (photoPoiArea == photoPoiArea2) {
            return true;
        }
        if (photoPoiArea == null || photoPoiArea2 == null) {
            return false;
        }
        return photoPoiArea.equals(photoPoiArea2);
    }

    public String toSceneryStr() {
        return !TextUtils.isEmpty(this.sceneryName) ? this.sceneryName : QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumEditLocation", "\u7f16\u8f91\u5730\u70b9");
    }

    public String toString() {
        return "(photoNum, " + this.photoNum + ")\n(poiPhotoNum, " + this.poiPhotoNum + ")\n(startShootTime, " + this.startShootTime + ")\n(endShootTime, " + this.endShootTime + ")\n++(poiInfo, " + this.poiInfo + ")++\n(description, " + this.description + ")\n(sceneryName, " + this.sceneryName + ")";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof PhotoPoiArea)) {
            return false;
        }
        PhotoPoiArea photoPoiArea = (PhotoPoiArea) obj;
        return this.photoNum == photoPoiArea.photoNum && this.poiPhotoNum == photoPoiArea.poiPhotoNum && this.startShootTime == photoPoiArea.startShootTime && this.endShootTime == photoPoiArea.endShootTime && this.description.equals(photoPoiArea.description) && this.sceneryName.equals(photoPoiArea.sceneryName);
    }

    public static PhotoPoiArea convertToPhotoPoiArea(album_area_item album_area_itemVar) {
        if (album_area_itemVar == null) {
            return null;
        }
        PhotoPoiArea photoPoiArea = new PhotoPoiArea();
        photoPoiArea.photoNum = album_area_itemVar.photo_num;
        photoPoiArea.poiPhotoNum = album_area_itemVar.poi_photo_num;
        photoPoiArea.startShootTime = album_area_itemVar.start_shoot_time;
        photoPoiArea.endShootTime = album_area_itemVar.end_shoot_time;
        stPoi stpoi = album_area_itemVar.poi_info;
        if (stpoi != null) {
            photoPoiArea.poiInfo = PoiInfo.createFromResponse(stpoi);
        }
        photoPoiArea.description = album_area_itemVar.description;
        photoPoiArea.sceneryName = album_area_itemVar.scenery_name.trim();
        return photoPoiArea;
    }

    public static stPhotoPoiArea convertToRequest(PhotoPoiArea photoPoiArea) {
        if (photoPoiArea == null) {
            return null;
        }
        stPhotoPoiArea stphotopoiarea = new stPhotoPoiArea();
        stphotopoiarea.photo_num = photoPoiArea.photoNum;
        stphotopoiarea.poi_photo_num = photoPoiArea.poiPhotoNum;
        stphotopoiarea.start_shoot_time = photoPoiArea.startShootTime;
        stphotopoiarea.end_shoot_time = photoPoiArea.endShootTime;
        stPoi stpoi = new stPoi();
        PoiInfo poiInfo = photoPoiArea.poiInfo;
        if (poiInfo != null) {
            stpoi.poi_id = poiInfo.poiId;
            String str = poiInfo.poiX;
            if (str == null) {
                str = "";
            }
            stpoi.poi_x = str;
            String str2 = poiInfo.poiY;
            stpoi.poi_y = str2 != null ? str2 : "";
            stpoi.poi_name = poiInfo.poiName;
            stpoi.poi_address = poiInfo.poiAddress;
            stpoi.poi_type = poiInfo.poiType;
        }
        stphotopoiarea.poi_info = stpoi;
        stphotopoiarea.description = photoPoiArea.description;
        stphotopoiarea.scenery_name = photoPoiArea.sceneryName;
        stphotopoiarea.is_userconfirmed = 1L;
        return stphotopoiarea;
    }

    public static PhotoPoiArea createFromResponse(stPhotoPoiArea stphotopoiarea) {
        if (stphotopoiarea == null) {
            return null;
        }
        PhotoPoiArea photoPoiArea = new PhotoPoiArea();
        photoPoiArea.photoNum = stphotopoiarea.photo_num;
        photoPoiArea.poiPhotoNum = stphotopoiarea.poi_photo_num;
        photoPoiArea.startShootTime = stphotopoiarea.start_shoot_time;
        photoPoiArea.endShootTime = stphotopoiarea.end_shoot_time;
        stPoi stpoi = stphotopoiarea.poi_info;
        if (stpoi != null) {
            photoPoiArea.poiInfo = PoiInfo.createFromResponse(stpoi);
        }
        photoPoiArea.description = stphotopoiarea.description;
        photoPoiArea.sceneryName = stphotopoiarea.scenery_name.trim();
        return photoPoiArea;
    }
}
