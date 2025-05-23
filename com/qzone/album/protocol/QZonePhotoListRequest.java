package com.qzone.album.protocol;

import NS_MOBILE_FEEDS.s_picdata;
import NS_MOBILE_PHOTO.Album;
import NS_MOBILE_PHOTO.BannerAttachInfo;
import NS_MOBILE_PHOTO.PhotoDetailPageBanner;
import NS_MOBILE_PHOTO.RecommendPhotos;
import NS_MOBILE_PHOTO.get_photo_list_2_req;
import NS_MOBILE_PHOTO.get_photo_list_2_rsp;
import NS_MOBILE_PHOTO.s_outshare;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.qzone.album.data.model.AlbumCacheData;
import com.qzone.album.data.model.AlbumDataOutShare;
import com.qzone.album.data.model.PhotoCacheData;
import com.qzone.album.data.model.RecomAlbumList;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes39.dex */
public class QZonePhotoListRequest extends AbsCompatRequest<b> {
    private static final String FIELD_CMD = "getPhotoList2";
    private static final String TAG = "QZonePhotoListRequest";

    /* loaded from: classes39.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f43959a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f43960b;

        /* renamed from: c, reason: collision with root package name */
        public AlbumCacheData f43961c;

        /* renamed from: d, reason: collision with root package name */
        public AlbumDataOutShare f43962d;

        /* renamed from: e, reason: collision with root package name */
        public ArrayList<PhotoCacheData> f43963e;

        /* renamed from: f, reason: collision with root package name */
        public RecomAlbumList f43964f;

        /* renamed from: g, reason: collision with root package name */
        public String f43965g = "";

        /* renamed from: h, reason: collision with root package name */
        public Map<Integer, String> f43966h;

        /* renamed from: i, reason: collision with root package name */
        public ArrayList<PhotoCacheData> f43967i;

        /* renamed from: j, reason: collision with root package name */
        public RecommendPhotos f43968j;

        /* renamed from: k, reason: collision with root package name */
        public String f43969k;

        /* renamed from: l, reason: collision with root package name */
        public PhotoDetailPageBanner f43970l;
    }

    /* loaded from: classes39.dex */
    public static final class b extends a {

        /* renamed from: m, reason: collision with root package name */
        public String f43971m;
    }

    public QZonePhotoListRequest(get_photo_list_2_req get_photo_list_2_reqVar) {
        super(FIELD_CMD);
        super.setHostUin(get_photo_list_2_reqVar.uin);
        this.req = get_photo_list_2_reqVar;
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
    public b onJceRespParse(JceStruct jceStruct) throws Exception {
        if (QZLog.isDevelopLevel()) {
            QZLog.d(TAG, 4, "onRefreshPhotoListResponse");
        }
        if (!(jceStruct instanceof get_photo_list_2_rsp)) {
            return null;
        }
        get_photo_list_2_rsp get_photo_list_2_rspVar = (get_photo_list_2_rsp) jceStruct;
        b bVar = new b();
        bVar.f43960b = get_photo_list_2_rspVar.finish == 0;
        bVar.f43959a = (int) get_photo_list_2_rspVar.total;
        bVar.f43964f = com.qzone.album.base.Service.a.a1(get_photo_list_2_rspVar.features);
        bVar.f43963e = new ArrayList<>();
        ArrayList<s_picdata> arrayList = get_photo_list_2_rspVar.photolist;
        if (arrayList != null) {
            int size = arrayList.size();
            StringBuilder sb5 = new StringBuilder();
            for (int i3 = 0; i3 < size; i3++) {
                s_picdata s_picdataVar = get_photo_list_2_rspVar.photolist.get(i3);
                if (s_picdataVar != null) {
                    PhotoCacheData createFromResponse = PhotoCacheData.createFromResponse(s_picdataVar, get_photo_list_2_rspVar.albuminfo);
                    if (createFromResponse != null && !TextUtils.isEmpty(s_picdataVar.clientkey)) {
                        sb5.append("client_key='" + s_picdataVar.clientkey + "' OR ");
                    }
                    bVar.f43963e.add(createFromResponse);
                }
            }
            if (!TextUtils.isEmpty(sb5)) {
                bVar.f43971m = sb5.toString().substring(0, sb5.toString().length() - 3);
            }
        }
        s_outshare s_outshareVar = get_photo_list_2_rspVar.shareinfo;
        if (s_outshareVar != null) {
            bVar.f43962d = AlbumDataOutShare.createFrom(s_outshareVar);
        }
        Album album = get_photo_list_2_rspVar.albuminfo;
        if (album != null) {
            if (QZLog.isDevelopLevel()) {
                QZLog.d(TAG, 4, "coverurl:" + album.coverurl + " name:" + album.name);
            }
            AlbumCacheData createFromResponse2 = AlbumCacheData.createFromResponse(album, get_photo_list_2_rspVar.busi_param);
            bVar.f43961c = createFromResponse2;
            createFromResponse2.sortType = album.sort_type;
            createFromResponse2.setPhotoPoiAreaList(get_photo_list_2_rspVar.pos, null, null);
            bVar.f43961c.setAlbumThemeTypeValue(album.type);
            bVar.f43961c.setCommonPhotoTimeLineList(get_photo_list_2_rspVar.timeline);
            bVar.f43961c.photoSearchStatus = get_photo_list_2_rspVar.photo_search_status;
            Map<Integer, String> map = album.busi_param;
            if (map != null) {
                bVar.f43966h = map;
                if (QZLog.isColorLevel()) {
                    QZLog.d(TAG, 4, "busi:" + album.busi_param);
                }
            }
        }
        bVar.f43967i = new ArrayList<>();
        RecommendPhotos recommendPhotos = get_photo_list_2_rspVar.recommend_photos;
        if (recommendPhotos != null) {
            bVar.f43969k = recommendPhotos.recommend_id;
            bVar.f43970l = recommendPhotos.banner;
            QZLog.d(TAG, 4, "resp.recommend_photos.banner = " + get_photo_list_2_rspVar.recommend_photos.banner);
            if (bVar.f43968j == null) {
                bVar.f43968j = new RecommendPhotos();
            }
            RecommendPhotos recommendPhotos2 = bVar.f43968j;
            RecommendPhotos recommendPhotos3 = get_photo_list_2_rspVar.recommend_photos;
            recommendPhotos2.recommend_photos = recommendPhotos3.recommend_photos;
            ArrayList<s_picdata> arrayList2 = recommendPhotos3.recommend_photos;
            if (arrayList2 != null && arrayList2.size() > 0) {
                for (int i16 = 0; i16 < arrayList2.size(); i16++) {
                    PhotoCacheData createFromResponse3 = PhotoCacheData.createFromResponse(arrayList2.get(i16), null);
                    if (TextUtils.isEmpty(createFromResponse3.picItem.albumId) && TextUtils.isEmpty(createFromResponse3.videodata.albumid)) {
                        QLog.d(TAG, 1, "get response albumId is Empty");
                    }
                    bVar.f43967i.add(createFromResponse3);
                }
            }
        }
        String str = get_photo_list_2_rspVar.attach_info;
        if (str != null) {
            bVar.f43965g = str;
        }
        return bVar;
    }

    public QZonePhotoListRequest(long j3, String str, int i3, int i16, String str2, String str3, long j16, Map<Integer, String> map, boolean z16, int i17, String str4) {
        this(j3, str, i3, i16, str2, str3, j16, map, "", z16, i17, str4);
    }

    public QZonePhotoListRequest(long j3, String str, int i3, int i16, String str2, String str3, long j16, Map<Integer, String> map, boolean z16, int i17, String str4, int i18) {
        this(j3, str, i3, i16, str2, str3, j16, map, "", z16, i17, str4, i18);
    }

    public QZonePhotoListRequest(long j3, String str, int i3, int i16, String str2, String str3, long j16, Map<Integer, String> map, String str4, boolean z16, int i17, String str5) {
        super(FIELD_CMD);
        super.setHostUin(j3);
        get_photo_list_2_req get_photo_list_2_reqVar = new get_photo_list_2_req();
        get_photo_list_2_reqVar.uin = j3;
        get_photo_list_2_reqVar.albumid = str;
        get_photo_list_2_reqVar.f25041ps = i3;
        get_photo_list_2_reqVar.f25040pn = i16;
        get_photo_list_2_reqVar.password = str2;
        get_photo_list_2_reqVar.curlloc = str3;
        get_photo_list_2_reqVar.sheight = 200;
        get_photo_list_2_reqVar.swidth = 200;
        get_photo_list_2_reqVar.busi_param = map;
        get_photo_list_2_reqVar.req_url = TextUtils.isEmpty(str4) ? "" : str4;
        get_photo_list_2_reqVar.face_uin = j16;
        get_photo_list_2_reqVar.ciphertext = "";
        get_photo_list_2_reqVar.password_cleartext = 1L;
        get_photo_list_2_reqVar.type = 0;
        get_photo_list_2_reqVar.sharer = 0L;
        get_photo_list_2_reqVar.need_pos = z16;
        get_photo_list_2_reqVar.sort_type = i17;
        get_photo_list_2_reqVar.attach_info = str5;
        setResourceToRequest(map, get_photo_list_2_reqVar);
        this.req = get_photo_list_2_reqVar;
    }

    private void setResourceToRequest(Map<Integer, String> map, get_photo_list_2_req get_photo_list_2_reqVar) {
        if (map == null || get_photo_list_2_reqVar == null || !QZoneHelper.QZoneAlbumConstants.VALUE_SOURCE_FROM_XIAOWO.equals(map.get(4))) {
            return;
        }
        get_photo_list_2_reqVar.req_from = 1;
        map.remove(4);
    }

    public QZonePhotoListRequest(long j3, String str, int i3, int i16, String str2, String str3, long j16, Map<Integer, String> map, String str4, boolean z16, int i17, String str5, int i18) {
        super(FIELD_CMD);
        super.setHostUin(j3);
        get_photo_list_2_req get_photo_list_2_reqVar = new get_photo_list_2_req();
        get_photo_list_2_reqVar.uin = j3;
        get_photo_list_2_reqVar.albumid = str;
        get_photo_list_2_reqVar.f25041ps = i3;
        get_photo_list_2_reqVar.f25040pn = i16;
        get_photo_list_2_reqVar.password = str2;
        get_photo_list_2_reqVar.curlloc = str3;
        get_photo_list_2_reqVar.sheight = 200;
        get_photo_list_2_reqVar.swidth = 200;
        get_photo_list_2_reqVar.busi_param = map;
        get_photo_list_2_reqVar.req_url = TextUtils.isEmpty(str4) ? "" : str4;
        get_photo_list_2_reqVar.face_uin = j16;
        get_photo_list_2_reqVar.ciphertext = "";
        get_photo_list_2_reqVar.password_cleartext = 1L;
        get_photo_list_2_reqVar.type = i18;
        get_photo_list_2_reqVar.sharer = 0L;
        get_photo_list_2_reqVar.need_pos = z16;
        get_photo_list_2_reqVar.sort_type = i17;
        get_photo_list_2_reqVar.attach_info = str5;
        setResourceToRequest(map, get_photo_list_2_reqVar);
        this.req = get_photo_list_2_reqVar;
    }

    public QZonePhotoListRequest(long j3, String str, int i3, int i16, String str2, String str3, long j16, Map<Integer, String> map, String str4, boolean z16, int i17, String str5, int i18, BannerAttachInfo bannerAttachInfo) {
        super(FIELD_CMD);
        super.setHostUin(j3);
        get_photo_list_2_req get_photo_list_2_reqVar = new get_photo_list_2_req();
        get_photo_list_2_reqVar.uin = j3;
        get_photo_list_2_reqVar.albumid = str;
        get_photo_list_2_reqVar.f25041ps = i3;
        get_photo_list_2_reqVar.f25040pn = i16;
        get_photo_list_2_reqVar.password = str2;
        get_photo_list_2_reqVar.curlloc = str3;
        get_photo_list_2_reqVar.sheight = 200;
        get_photo_list_2_reqVar.swidth = 200;
        get_photo_list_2_reqVar.busi_param = map;
        get_photo_list_2_reqVar.req_url = TextUtils.isEmpty(str4) ? "" : str4;
        get_photo_list_2_reqVar.face_uin = j16;
        get_photo_list_2_reqVar.ciphertext = "";
        get_photo_list_2_reqVar.password_cleartext = 1L;
        get_photo_list_2_reqVar.type = i18;
        get_photo_list_2_reqVar.sharer = 0L;
        get_photo_list_2_reqVar.need_pos = z16;
        get_photo_list_2_reqVar.sort_type = i17;
        get_photo_list_2_reqVar.attach_info = str5;
        get_photo_list_2_reqVar.banner_attach_info = bannerAttachInfo;
        setResourceToRequest(map, get_photo_list_2_reqVar);
        this.req = get_photo_list_2_reqVar;
    }

    public QZonePhotoListRequest(long j3, String str, int i3, int i16, String str2, int i17, String str3, String str4, long j16, Map<Integer, String> map, String str5, String str6, int i18, int i19, long j17) {
        super(FIELD_CMD);
        super.setHostUin(j3);
        get_photo_list_2_req get_photo_list_2_reqVar = new get_photo_list_2_req();
        get_photo_list_2_reqVar.uin = j3;
        get_photo_list_2_reqVar.albumid = str;
        get_photo_list_2_reqVar.f25041ps = i3;
        get_photo_list_2_reqVar.f25040pn = i17;
        get_photo_list_2_reqVar.password = str3;
        get_photo_list_2_reqVar.curlloc = str4;
        get_photo_list_2_reqVar.sheight = 200;
        get_photo_list_2_reqVar.swidth = 200;
        get_photo_list_2_reqVar.busi_param = map;
        get_photo_list_2_reqVar.req_url = TextUtils.isEmpty(str5) ? "" : str5;
        get_photo_list_2_reqVar.face_uin = j16;
        get_photo_list_2_reqVar.ciphertext = str6;
        get_photo_list_2_reqVar.password_cleartext = i18;
        get_photo_list_2_reqVar.type = i19;
        get_photo_list_2_reqVar.sharer = j17;
        get_photo_list_2_reqVar.sort_type = i16;
        get_photo_list_2_reqVar.attach_info = str2;
        setResourceToRequest(map, get_photo_list_2_reqVar);
        this.req = get_photo_list_2_reqVar;
    }

    public QZonePhotoListRequest(long j3, String str, int i3, int i16, String str2, int i17, String str3, String str4, long j16, Map<Integer, String> map, String str5, String str6, int i18, int i19, long j17, BannerAttachInfo bannerAttachInfo) {
        super(FIELD_CMD);
        super.setHostUin(j3);
        get_photo_list_2_req get_photo_list_2_reqVar = new get_photo_list_2_req();
        get_photo_list_2_reqVar.uin = j3;
        get_photo_list_2_reqVar.albumid = str;
        get_photo_list_2_reqVar.f25041ps = i3;
        get_photo_list_2_reqVar.f25040pn = i17;
        get_photo_list_2_reqVar.password = str3;
        get_photo_list_2_reqVar.curlloc = str4;
        get_photo_list_2_reqVar.sheight = 200;
        get_photo_list_2_reqVar.swidth = 200;
        get_photo_list_2_reqVar.busi_param = map;
        get_photo_list_2_reqVar.req_url = TextUtils.isEmpty(str5) ? "" : str5;
        get_photo_list_2_reqVar.face_uin = j16;
        get_photo_list_2_reqVar.ciphertext = str6;
        get_photo_list_2_reqVar.password_cleartext = i18;
        get_photo_list_2_reqVar.type = i19;
        get_photo_list_2_reqVar.sharer = j17;
        get_photo_list_2_reqVar.sort_type = i16;
        get_photo_list_2_reqVar.attach_info = str2;
        get_photo_list_2_reqVar.banner_attach_info = bannerAttachInfo;
        setResourceToRequest(map, get_photo_list_2_reqVar);
        this.req = get_photo_list_2_reqVar;
    }
}
