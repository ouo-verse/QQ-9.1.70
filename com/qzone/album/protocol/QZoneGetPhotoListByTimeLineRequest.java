package com.qzone.album.protocol;

import NS_MOBILE_FEEDS.s_picdata;
import NS_MOBILE_PHOTO.Album;
import NS_MOBILE_PHOTO.TimeEvent;
import NS_MOBILE_PHOTO.TimeLine;
import NS_MOBILE_PHOTO.get_photo_list_bytimeline_req;
import NS_MOBILE_PHOTO.get_photo_list_bytimeline_rsp;
import NS_MOBILE_PHOTO.stPhotoPoiAreaList;
import com.qq.taf.jce.JceStruct;
import com.qzone.album.data.model.AlbumCacheData;
import com.qzone.album.data.model.PhotoCacheData;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes39.dex */
public class QZoneGetPhotoListByTimeLineRequest extends AbsCompatRequest<a> {
    private static final String FIELD_CMD = "asy_photo.getPhotoListByTimeLine";
    private static final String UIN_KEY = "getPhotoListByTimeLine";

    /* loaded from: classes39.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public ArrayList<PhotoCacheData> f43922a;

        /* renamed from: b, reason: collision with root package name */
        public Album f43923b;

        /* renamed from: c, reason: collision with root package name */
        public stPhotoPoiAreaList f43924c;

        /* renamed from: d, reason: collision with root package name */
        public ArrayList<TimeLine> f43925d;

        /* renamed from: e, reason: collision with root package name */
        public Map<Integer, String> f43926e;

        /* renamed from: f, reason: collision with root package name */
        public String f43927f = "";

        /* renamed from: g, reason: collision with root package name */
        public ArrayList<TimeEvent> f43928g;

        /* renamed from: h, reason: collision with root package name */
        public ArrayList<PhotoCacheData> f43929h;

        /* renamed from: i, reason: collision with root package name */
        public AlbumCacheData f43930i;
    }

    public QZoneGetPhotoListByTimeLineRequest(long j3, String str, Map<Long, Long> map, int i3, String str2, String str3, int i16, int i17, int i18, int i19, Map<Integer, String> map2) {
        super(FIELD_CMD);
        get_photo_list_bytimeline_req get_photo_list_bytimeline_reqVar = new get_photo_list_bytimeline_req();
        get_photo_list_bytimeline_reqVar.uin = j3;
        get_photo_list_bytimeline_reqVar.albumid = str;
        get_photo_list_bytimeline_reqVar.time_range = map;
        get_photo_list_bytimeline_reqVar.sort = i3;
        get_photo_list_bytimeline_reqVar.attach_info = str2;
        get_photo_list_bytimeline_reqVar.password = str3;
        get_photo_list_bytimeline_reqVar.start = i16;
        get_photo_list_bytimeline_reqVar.num = i17;
        get_photo_list_bytimeline_reqVar.albumtype = i18;
        get_photo_list_bytimeline_reqVar.gettimeline = i19;
        get_photo_list_bytimeline_reqVar.busi_param = map2;
        this.req = get_photo_list_bytimeline_reqVar;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return UIN_KEY;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.qzone.album.protocol.AbsCompatRequest
    public a onJceRespParse(JceStruct jceStruct) throws Exception {
        get_photo_list_bytimeline_rsp get_photo_list_bytimeline_rspVar = (get_photo_list_bytimeline_rsp) jceStruct;
        a aVar = new a();
        aVar.f43923b = get_photo_list_bytimeline_rspVar.albuminfo;
        aVar.f43927f = get_photo_list_bytimeline_rspVar.attach_info;
        aVar.f43926e = get_photo_list_bytimeline_rspVar.busi_param;
        aVar.f43924c = get_photo_list_bytimeline_rspVar.pos;
        aVar.f43925d = get_photo_list_bytimeline_rspVar.timeline;
        aVar.f43928g = get_photo_list_bytimeline_rspVar.timeevent;
        int size = get_photo_list_bytimeline_rspVar.photolist.size();
        aVar.f43922a = new ArrayList<>();
        for (int i3 = 0; i3 < size; i3++) {
            s_picdata s_picdataVar = get_photo_list_bytimeline_rspVar.photolist.get(i3);
            if (s_picdataVar != null) {
                aVar.f43922a.add(PhotoCacheData.createFromResponse(s_picdataVar, get_photo_list_bytimeline_rspVar.albuminfo));
            }
        }
        return aVar;
    }

    public QZoneGetPhotoListByTimeLineRequest(get_photo_list_bytimeline_req get_photo_list_bytimeline_reqVar) {
        super(FIELD_CMD);
        this.req = get_photo_list_bytimeline_reqVar;
    }
}
