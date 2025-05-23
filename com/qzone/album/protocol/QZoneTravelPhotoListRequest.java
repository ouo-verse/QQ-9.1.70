package com.qzone.album.protocol;

import NS_MOBILE_FEEDS.s_picdata;
import NS_MOBILE_PHOTO.Album;
import NS_MOBILE_PHOTO.BannerAttachInfo;
import NS_MOBILE_PHOTO.RecommendPhotos;
import NS_MOBILE_PHOTO.get_travel_photo_list_req;
import NS_MOBILE_PHOTO.get_travel_photo_list_rsp;
import NS_MOBILE_PHOTO.s_outshare;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.qzone.album.data.model.AlbumCacheData;
import com.qzone.album.data.model.AlbumDataOutShare;
import com.qzone.album.data.model.PhotoCacheData;
import com.qzone.album.protocol.QZonePhotoListRequest;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes39.dex */
public class QZoneTravelPhotoListRequest extends AbsCompatRequest<a> {
    private static final String FIELD_CMD = "getTravelPhotoList";
    private static final String TAG = "QZoneTravelPhotoListRequest";

    /* loaded from: classes39.dex */
    public static final class a extends QZonePhotoListRequest.a {
    }

    public QZoneTravelPhotoListRequest(long j3, String str, String str2, String str3, Map<Integer, String> map, int i3) {
        super(FIELD_CMD);
        super.setHostUin(j3);
        get_travel_photo_list_req get_travel_photo_list_reqVar = new get_travel_photo_list_req();
        get_travel_photo_list_reqVar.uin = j3;
        get_travel_photo_list_reqVar.albumid = str;
        get_travel_photo_list_reqVar.attach_info = str2;
        get_travel_photo_list_reqVar.password = str3;
        get_travel_photo_list_reqVar.busi_param = map;
        get_travel_photo_list_reqVar.type = i3;
        this.req = get_travel_photo_list_reqVar;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    protected long getHostUin() {
        return this.hostUin;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return FIELD_CMD;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.qzone.album.protocol.AbsCompatRequest
    public a onJceRespParse(JceStruct jceStruct) throws Exception {
        AlbumCacheData albumCacheData;
        if (QZLog.isColorLevel()) {
            QZLog.d(TAG, 4, "onRefreshTravellingPhotoListResponse ");
        }
        if (!(jceStruct instanceof get_travel_photo_list_rsp)) {
            return null;
        }
        get_travel_photo_list_rsp get_travel_photo_list_rspVar = (get_travel_photo_list_rsp) jceStruct;
        a aVar = new a();
        aVar.f43960b = get_travel_photo_list_rspVar.hasmore == 1;
        boolean z16 = !TextUtils.isEmpty(((get_travel_photo_list_req) this.req).attach_info);
        aVar.f43964f = com.qzone.album.base.Service.a.a1(get_travel_photo_list_rspVar.features);
        Album album = get_travel_photo_list_rspVar.albuminfo;
        if (album != null) {
            if (QZLog.isColorLevel()) {
                QZLog.d(TAG, 4, "album.name=" + album.name + "albumData.albumid =" + album.albumid + ";album.type=" + album.type);
            }
            aVar.f43959a = album.total;
            albumCacheData = AlbumCacheData.createFromResponse(album, get_travel_photo_list_rspVar.busi_param);
            if (!z16) {
                albumCacheData.setAlbumThemeTypeValue(9);
                albumCacheData.setPhotoPoiAreaList(get_travel_photo_list_rspVar.pos, get_travel_photo_list_rspVar.attach_info, get_travel_photo_list_rspVar.busi_param);
            }
            albumCacheData.photoSearchStatus = get_travel_photo_list_rspVar.photo_search_status;
            if (QZLog.isColorLevel()) {
                QZLog.d(TAG, 4, "birthTime=" + album.birth_time + "; type=" + album.type + "; albumName=" + album.name + "; hasMore=" + aVar.f43960b);
            }
        } else {
            albumCacheData = null;
        }
        aVar.f43961c = albumCacheData;
        if (z16) {
            aVar.f43966h = get_travel_photo_list_rspVar.busi_param;
        } else if (album != null) {
            aVar.f43966h = album.busi_param;
        }
        if (QZLog.isColorLevel()) {
            QZLog.d(TAG, 4, "busi:" + aVar.f43966h);
        }
        aVar.f43965g = get_travel_photo_list_rspVar.attach_info;
        aVar.f43963e = new ArrayList<>();
        ArrayList<s_picdata> arrayList = get_travel_photo_list_rspVar.photolist;
        if (arrayList != null) {
            int size = arrayList.size();
            if (QZLog.isColorLevel()) {
                QZLog.d(TAG, 4, "photoDataList size:" + size);
            }
            for (int i3 = 0; i3 < size; i3++) {
                s_picdata s_picdataVar = get_travel_photo_list_rspVar.photolist.get(i3);
                if (s_picdataVar != null) {
                    aVar.f43963e.add(PhotoCacheData.createFromResponse(s_picdataVar, get_travel_photo_list_rspVar.albuminfo));
                }
            }
            if (QZLog.isColorLevel()) {
                QZLog.d(TAG, 4, "photoDataList size:" + aVar.f43963e.size());
            }
        }
        s_outshare s_outshareVar = get_travel_photo_list_rspVar.shareinfo;
        if (s_outshareVar != null) {
            aVar.f43962d = AlbumDataOutShare.createFrom(s_outshareVar);
        }
        aVar.f43967i = new ArrayList<>();
        RecommendPhotos recommendPhotos = get_travel_photo_list_rspVar.recommend_photos;
        if (recommendPhotos != null) {
            aVar.f43969k = recommendPhotos.recommend_id;
            aVar.f43970l = recommendPhotos.banner;
            if (aVar.f43968j == null) {
                aVar.f43968j = new RecommendPhotos();
            }
            RecommendPhotos recommendPhotos2 = aVar.f43968j;
            RecommendPhotos recommendPhotos3 = get_travel_photo_list_rspVar.recommend_photos;
            recommendPhotos2.recommend_photos = recommendPhotos3.recommend_photos;
            ArrayList<s_picdata> arrayList2 = recommendPhotos3.recommend_photos;
            for (int i16 = 0; i16 < arrayList2.size(); i16++) {
                aVar.f43967i.add(PhotoCacheData.createFromResponse(arrayList2.get(i16), null));
            }
        }
        return aVar;
    }

    public QZoneTravelPhotoListRequest(long j3, String str, String str2, String str3, Map<Integer, String> map, int i3, BannerAttachInfo bannerAttachInfo) {
        super(FIELD_CMD);
        super.setHostUin(j3);
        get_travel_photo_list_req get_travel_photo_list_reqVar = new get_travel_photo_list_req();
        get_travel_photo_list_reqVar.uin = j3;
        get_travel_photo_list_reqVar.albumid = str;
        get_travel_photo_list_reqVar.attach_info = str2;
        get_travel_photo_list_reqVar.password = str3;
        get_travel_photo_list_reqVar.busi_param = map;
        get_travel_photo_list_reqVar.type = i3;
        get_travel_photo_list_reqVar.banner_attach_info = bannerAttachInfo;
        this.req = get_travel_photo_list_reqVar;
    }
}
