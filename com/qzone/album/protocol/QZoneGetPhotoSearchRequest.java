package com.qzone.album.protocol;

import NS_MOBILE_PHOTO.Album;
import NS_MOBILE_PHOTO.GetPhotoSearchReq;
import NS_MOBILE_PHOTO.GetPhotoSearchRsp;
import NS_MOBILE_PHOTO.Photo;
import NS_MOBILE_PHOTO.PhotoFeedsData;
import NS_MOBILE_PHOTO.PhotoSearchBox;
import NS_MOBILE_PHOTO.PhotoSearchBoxChosenItem;
import NS_MOBILE_PHOTO.PhotoSearchBoxPhoto;
import NS_MOBILE_PHOTO.s_outshare;
import com.qq.taf.jce.JceStruct;
import com.qzone.album.data.model.AlbumDataOutShare;
import com.qzone.album.data.model.PhotoCacheData;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes39.dex */
public class QZoneGetPhotoSearchRequest extends AbsCompatRequest<a> {
    private static final String CMD_STRING = "asy_photo.GetPhotoSearch";
    private static final String UNI_KEY = "GetPhotoSearch";

    /* loaded from: classes39.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public int f43931a;

        /* renamed from: b, reason: collision with root package name */
        public String f43932b;

        /* renamed from: c, reason: collision with root package name */
        public PhotoSearchBox f43933c;

        /* renamed from: d, reason: collision with root package name */
        public PhotoSearchBoxPhoto f43934d;

        /* renamed from: e, reason: collision with root package name */
        public ArrayList<PhotoCacheData> f43935e;

        /* renamed from: f, reason: collision with root package name */
        public long f43936f;

        /* renamed from: g, reason: collision with root package name */
        public String f43937g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f43938h;

        /* renamed from: i, reason: collision with root package name */
        public AlbumDataOutShare f43939i;
    }

    public QZoneGetPhotoSearchRequest(long j3, String str, int i3, ArrayList<Integer> arrayList, Map<Integer, PhotoSearchBoxChosenItem> map, String str2) {
        super(CMD_STRING);
        super.setHostUin(this.hostUin);
        GetPhotoSearchReq getPhotoSearchReq = new GetPhotoSearchReq();
        getPhotoSearchReq.uin = j3;
        getPhotoSearchReq.albumid = str;
        getPhotoSearchReq.req_type = i3;
        getPhotoSearchReq.types = arrayList;
        getPhotoSearchReq.items = map;
        getPhotoSearchReq.attach_info = str2;
        this.req = getPhotoSearchReq;
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
        return UNI_KEY;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.qzone.album.protocol.AbsCompatRequest
    public a onJceRespParse(JceStruct jceStruct) throws Exception {
        ArrayList<Photo> arrayList;
        ArrayList<PhotoFeedsData> arrayList2;
        int i3;
        ArrayList<Photo> arrayList3;
        if (QZLog.isDevelopLevel()) {
            QZLog.d(this.TAG, 4, "onRefreshPhotoListResponse");
        }
        if (!(jceStruct instanceof GetPhotoSearchRsp)) {
            return null;
        }
        GetPhotoSearchRsp getPhotoSearchRsp = (GetPhotoSearchRsp) jceStruct;
        a aVar = new a();
        aVar.f43931a = getPhotoSearchRsp.ret;
        aVar.f43932b = getPhotoSearchRsp.f25027msg;
        aVar.f43933c = getPhotoSearchRsp.photo_search_box;
        PhotoSearchBoxPhoto photoSearchBoxPhoto = getPhotoSearchRsp.photo_search_box_photo;
        aVar.f43934d = photoSearchBoxPhoto;
        if (photoSearchBoxPhoto != null) {
            ArrayList<PhotoFeedsData> arrayList4 = photoSearchBoxPhoto.photos;
            ArrayList<PhotoCacheData> arrayList5 = new ArrayList<>();
            if (arrayList4 != null && !arrayList4.isEmpty()) {
                int i16 = 0;
                while (i16 < arrayList4.size()) {
                    PhotoFeedsData photoFeedsData = arrayList4.get(i16);
                    if (photoFeedsData != null && (arrayList = photoFeedsData.photolist) != null && !arrayList.isEmpty()) {
                        Album album = photoFeedsData.album;
                        ArrayList<Photo> arrayList6 = photoFeedsData.photolist;
                        int i17 = 0;
                        while (i17 < arrayList6.size()) {
                            Photo photo = arrayList6.get(i17);
                            if (photo == null || album == null) {
                                arrayList2 = arrayList4;
                                i3 = i17;
                                arrayList3 = arrayList6;
                            } else {
                                arrayList2 = arrayList4;
                                i3 = i17;
                                arrayList3 = arrayList6;
                                PhotoCacheData createFrom = PhotoCacheData.createFrom(album, photo, photoFeedsData.appid, photoFeedsData.pss_cell_id, photoFeedsData.pss_cell_comm, photoFeedsData.pss_cell_operation, photoFeedsData.pss_cell_like, photoFeedsData.pss_cell_comment, photo.share_info, true);
                                if (createFrom != null) {
                                    arrayList5.add(createFrom);
                                }
                            }
                            i17 = i3 + 1;
                            arrayList4 = arrayList2;
                            arrayList6 = arrayList3;
                        }
                    }
                    i16++;
                    arrayList4 = arrayList4;
                }
            }
            aVar.f43935e = arrayList5;
            PhotoSearchBoxPhoto photoSearchBoxPhoto2 = aVar.f43934d;
            aVar.f43936f = photoSearchBoxPhoto2.total;
            aVar.f43937g = photoSearchBoxPhoto2.attach_info;
            aVar.f43938h = photoSearchBoxPhoto2.hasmore;
            s_outshare s_outshareVar = getPhotoSearchRsp.shareinfo;
            if (s_outshareVar != null) {
                aVar.f43939i = AlbumDataOutShare.createFrom(s_outshareVar);
            }
        }
        return aVar;
    }
}
