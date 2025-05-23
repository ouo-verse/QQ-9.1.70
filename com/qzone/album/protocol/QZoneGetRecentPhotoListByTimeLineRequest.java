package com.qzone.album.protocol;

import NS_MOBILE_PHOTO.Album;
import NS_MOBILE_PHOTO.Photo;
import NS_MOBILE_PHOTO.PhotoFeedsData;
import NS_MOBILE_PHOTO.get_feedsphoto_bytimeline_req;
import NS_MOBILE_PHOTO.get_feedsphoto_bytimeline_rsp;
import com.qq.taf.jce.JceStruct;
import com.qzone.album.data.model.AlbumCacheData;
import com.qzone.album.data.model.PhotoCacheData;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes39.dex */
public class QZoneGetRecentPhotoListByTimeLineRequest extends AbsCompatRequest<a> {
    private static final String FIELD_CMD = "asy_photo.getTabPhotoByTimeLine";
    private static final String UIN_KEY = "getTabPhotoByTimeLine";

    /* loaded from: classes39.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public ArrayList<PhotoCacheData> f43940a;

        /* renamed from: b, reason: collision with root package name */
        public ArrayList<AlbumCacheData> f43941b;

        /* renamed from: c, reason: collision with root package name */
        public String f43942c = "";

        /* renamed from: d, reason: collision with root package name */
        public int f43943d;
    }

    public QZoneGetRecentPhotoListByTimeLineRequest(long j3, long j16, long j17, int i3, String str) {
        super(FIELD_CMD);
        get_feedsphoto_bytimeline_req get_feedsphoto_bytimeline_reqVar = new get_feedsphoto_bytimeline_req();
        get_feedsphoto_bytimeline_reqVar.uin = j3;
        get_feedsphoto_bytimeline_reqVar.begin_time = j16;
        get_feedsphoto_bytimeline_reqVar.end_time = j17;
        get_feedsphoto_bytimeline_reqVar.type = i3;
        get_feedsphoto_bytimeline_reqVar.attach_info = str;
        this.req = get_feedsphoto_bytimeline_reqVar;
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
        ArrayList<Photo> arrayList;
        ArrayList<PhotoFeedsData> arrayList2;
        PhotoFeedsData photoFeedsData;
        int i3;
        ArrayList<Photo> arrayList3;
        get_feedsphoto_bytimeline_rsp get_feedsphoto_bytimeline_rspVar = (get_feedsphoto_bytimeline_rsp) jceStruct;
        a aVar = new a();
        aVar.f43942c = get_feedsphoto_bytimeline_rspVar.attach_info;
        aVar.f43943d = get_feedsphoto_bytimeline_rspVar.hasmore;
        ArrayList<PhotoFeedsData> arrayList4 = get_feedsphoto_bytimeline_rspVar.all_applist_data;
        ArrayList<AlbumCacheData> arrayList5 = new ArrayList<>();
        ArrayList<PhotoCacheData> arrayList6 = new ArrayList<>();
        if (arrayList4 != null && !arrayList4.isEmpty()) {
            int i16 = 0;
            while (i16 < arrayList4.size()) {
                PhotoFeedsData photoFeedsData2 = arrayList4.get(i16);
                if (photoFeedsData2 != null && (arrayList = photoFeedsData2.photolist) != null && !arrayList.isEmpty()) {
                    Album album = photoFeedsData2.album;
                    AlbumCacheData createFromResponse = AlbumCacheData.createFromResponse(album);
                    if (shouldAddAlbumCacheDataToList(createFromResponse, arrayList5)) {
                        arrayList5.add(createFromResponse);
                    }
                    ArrayList<Photo> arrayList7 = photoFeedsData2.photolist;
                    int i17 = 0;
                    while (i17 < arrayList7.size()) {
                        Photo photo = arrayList7.get(i17);
                        if (photo == null) {
                            arrayList2 = arrayList4;
                            photoFeedsData = photoFeedsData2;
                            i3 = i17;
                            arrayList3 = arrayList7;
                        } else {
                            arrayList2 = arrayList4;
                            photoFeedsData = photoFeedsData2;
                            i3 = i17;
                            arrayList3 = arrayList7;
                            PhotoCacheData createFrom = PhotoCacheData.createFrom(album, photo, photoFeedsData2.appid, photoFeedsData2.pss_cell_id, photoFeedsData2.pss_cell_comm, photoFeedsData2.pss_cell_operation, photoFeedsData2.pss_cell_like, photoFeedsData2.pss_cell_comment, photo.share_info);
                            if (createFrom != null) {
                                arrayList6.add(createFrom);
                            }
                        }
                        i17 = i3 + 1;
                        arrayList4 = arrayList2;
                        photoFeedsData2 = photoFeedsData;
                        arrayList7 = arrayList3;
                    }
                }
                i16++;
                arrayList4 = arrayList4;
            }
        }
        aVar.f43940a = arrayList6;
        aVar.f43941b = arrayList5;
        return aVar;
    }

    private boolean shouldAddAlbumCacheDataToList(AlbumCacheData albumCacheData, ArrayList<AlbumCacheData> arrayList) {
        String str;
        if (albumCacheData == null || albumCacheData.albumid == null || arrayList == null) {
            return false;
        }
        Iterator<AlbumCacheData> it = arrayList.iterator();
        while (it.hasNext()) {
            AlbumCacheData next = it.next();
            if (next != null && (str = next.albumid) != null && str.equals(albumCacheData.albumid)) {
                return false;
            }
        }
        return true;
    }
}
