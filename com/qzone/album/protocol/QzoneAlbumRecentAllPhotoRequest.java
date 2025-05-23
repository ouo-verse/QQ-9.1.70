package com.qzone.album.protocol;

import NS_MOBILE_FEEDS.s_memory_seal_off;
import NS_MOBILE_PHOTO.Album;
import NS_MOBILE_PHOTO.Photo;
import NS_MOBILE_PHOTO.PhotoFeedsData;
import NS_MOBILE_PHOTO.TabTimeLine;
import NS_MOBILE_PHOTO.get_all_feedsphoto_ex_req;
import NS_MOBILE_PHOTO.get_all_feedsphoto_ex_rsp;
import NS_MOBILE_PHOTO.photo_tab_category_control;
import NS_MOBILE_PHOTO.photo_tab_categroy_info;
import com.qq.taf.jce.JceStruct;
import com.qzone.album.data.model.AlbumCacheData;
import com.qzone.album.data.model.PhotoCacheData;
import com.qzone.album.data.model.PhotoCategoryControlInfo;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes39.dex */
public class QzoneAlbumRecentAllPhotoRequest extends AbsCompatRequest<a> {
    private static final String CMD_STRING = "get_all_feedsphoto_ex";
    private static final String TAG = "QzoneAlbumRecentAllPhotoRequest";

    /* loaded from: classes39.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public boolean f43978a;

        /* renamed from: b, reason: collision with root package name */
        public ArrayList<PhotoCategoryControlInfo> f43979b;

        /* renamed from: c, reason: collision with root package name */
        public ArrayList<AlbumCacheData> f43980c;

        /* renamed from: d, reason: collision with root package name */
        public ArrayList<PhotoCacheData> f43981d;

        /* renamed from: e, reason: collision with root package name */
        public ArrayList<TabTimeLine> f43982e;

        /* renamed from: f, reason: collision with root package name */
        public String f43983f;

        /* renamed from: g, reason: collision with root package name */
        public s_memory_seal_off f43984g;

        /* renamed from: h, reason: collision with root package name */
        public int f43985h;
    }

    public QzoneAlbumRecentAllPhotoRequest(long j3, String str, int i3, int i16, int i17, boolean z16) {
        super(CMD_STRING);
        if (QZLog.isDevelopLevel()) {
            QZLog.d(TAG, 4, "cmd: " + getCmdString());
        }
        get_all_feedsphoto_ex_req get_all_feedsphoto_ex_reqVar = new get_all_feedsphoto_ex_req();
        get_all_feedsphoto_ex_reqVar.uin = j3;
        get_all_feedsphoto_ex_reqVar.appid = 4;
        get_all_feedsphoto_ex_reqVar.count = 10;
        get_all_feedsphoto_ex_reqVar.attach_info = str == null ? "" : str;
        get_all_feedsphoto_ex_reqVar.album_show_type = 2;
        get_all_feedsphoto_ex_reqVar.refresh_type = i3;
        get_all_feedsphoto_ex_reqVar.extrance_type = i16;
        get_all_feedsphoto_ex_reqVar.req_type = i17;
        get_all_feedsphoto_ex_reqVar.timeline_on = i17 == 3 ? false : z16;
        this.req = get_all_feedsphoto_ex_reqVar;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString() + "Photo";
    }

    public get_all_feedsphoto_ex_rsp getResp() {
        return (get_all_feedsphoto_ex_rsp) this.rsp;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        if (QZLog.isDevelopLevel()) {
            QZLog.d(TAG, 4, "unikey: " + CMD_STRING);
        }
        return CMD_STRING;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.qzone.album.protocol.AbsCompatRequest
    public a onJceRespParse(JceStruct jceStruct) throws Exception {
        ArrayList<Photo> arrayList;
        ArrayList<PhotoFeedsData> arrayList2;
        get_all_feedsphoto_ex_rsp get_all_feedsphoto_ex_rspVar;
        PhotoFeedsData photoFeedsData;
        int i3;
        ArrayList<Photo> arrayList3;
        ArrayList<photo_tab_categroy_info> arrayList4;
        if (!(jceStruct instanceof get_all_feedsphoto_ex_rsp)) {
            return null;
        }
        a aVar = new a();
        get_all_feedsphoto_ex_rsp get_all_feedsphoto_ex_rspVar2 = (get_all_feedsphoto_ex_rsp) jceStruct;
        if (get_all_feedsphoto_ex_rspVar2 != null) {
            aVar.f43982e = get_all_feedsphoto_ex_rspVar2.timeline;
            photo_tab_category_control photo_tab_category_controlVar = get_all_feedsphoto_ex_rspVar2.category_infos;
            aVar.f43978a = photo_tab_category_controlVar != null ? photo_tab_category_controlVar.is_visible : false;
            ArrayList<PhotoCategoryControlInfo> arrayList5 = new ArrayList<>();
            if (photo_tab_category_controlVar != null && (arrayList4 = photo_tab_category_controlVar.category_infos) != null && arrayList4.size() > 0) {
                for (int i16 = 0; i16 < photo_tab_category_controlVar.category_infos.size(); i16++) {
                    PhotoCategoryControlInfo photoCategoryControlInfo = new PhotoCategoryControlInfo();
                    photoCategoryControlInfo.visibility = photo_tab_category_controlVar.is_visible ? 1 : 0;
                    photoCategoryControlInfo.categoryType = photo_tab_category_controlVar.category_infos.get(i16).type;
                    ArrayList<String> arrayList6 = new ArrayList<>();
                    if (photo_tab_category_controlVar.category_infos.get(i16).url != null && photo_tab_category_controlVar.category_infos.get(i16).url.size() > 0) {
                        Iterator<String> it = photo_tab_category_controlVar.category_infos.get(i16).url.iterator();
                        while (it.hasNext()) {
                            String next = it.next();
                            if (next != null) {
                                arrayList6.add(next);
                            }
                        }
                        photoCategoryControlInfo.categoryCoverUrl = arrayList6;
                    } else {
                        photoCategoryControlInfo.categoryCoverUrl = null;
                    }
                    photoCategoryControlInfo.categoryCounter = (int) photo_tab_category_controlVar.category_infos.get(i16).count;
                    photoCategoryControlInfo.categoryStatus = photo_tab_category_controlVar.category_infos.get(i16).status;
                    arrayList5.add(photoCategoryControlInfo);
                }
            }
            aVar.f43979b = arrayList5;
            aVar.f43983f = get_all_feedsphoto_ex_rspVar2.attach_info;
            aVar.f43985h = get_all_feedsphoto_ex_rspVar2.hasmore;
            ArrayList<PhotoFeedsData> arrayList7 = get_all_feedsphoto_ex_rspVar2.all_applist_data;
            ArrayList<AlbumCacheData> arrayList8 = new ArrayList<>();
            ArrayList<PhotoCacheData> arrayList9 = new ArrayList<>();
            if (arrayList7 != null && !arrayList7.isEmpty()) {
                int i17 = 0;
                while (i17 < arrayList7.size()) {
                    PhotoFeedsData photoFeedsData2 = arrayList7.get(i17);
                    if (photoFeedsData2 != null && (arrayList = photoFeedsData2.photolist) != null && !arrayList.isEmpty()) {
                        Album album = photoFeedsData2.album;
                        AlbumCacheData createFromResponse = AlbumCacheData.createFromResponse(album);
                        if (shouldAddAlbumCacheDataToList(createFromResponse, arrayList8)) {
                            arrayList8.add(createFromResponse);
                        }
                        ArrayList<Photo> arrayList10 = photoFeedsData2.photolist;
                        int i18 = 0;
                        while (i18 < arrayList10.size()) {
                            Photo photo = arrayList10.get(i18);
                            if (photo == null) {
                                get_all_feedsphoto_ex_rspVar = get_all_feedsphoto_ex_rspVar2;
                                arrayList2 = arrayList7;
                                photoFeedsData = photoFeedsData2;
                                i3 = i18;
                                arrayList3 = arrayList10;
                            } else {
                                arrayList2 = arrayList7;
                                get_all_feedsphoto_ex_rspVar = get_all_feedsphoto_ex_rspVar2;
                                photoFeedsData = photoFeedsData2;
                                i3 = i18;
                                arrayList3 = arrayList10;
                                PhotoCacheData createFrom = PhotoCacheData.createFrom(album, photo, photoFeedsData2.appid, photoFeedsData2.pss_cell_id, photoFeedsData2.pss_cell_comm, photoFeedsData2.pss_cell_operation, photoFeedsData2.pss_cell_like, photoFeedsData2.pss_cell_comment, photo.share_info);
                                if (createFrom != null) {
                                    arrayList9.add(createFrom);
                                }
                            }
                            i18 = i3 + 1;
                            arrayList7 = arrayList2;
                            get_all_feedsphoto_ex_rspVar2 = get_all_feedsphoto_ex_rspVar;
                            photoFeedsData2 = photoFeedsData;
                            arrayList10 = arrayList3;
                        }
                    }
                    i17++;
                    arrayList7 = arrayList7;
                    get_all_feedsphoto_ex_rspVar2 = get_all_feedsphoto_ex_rspVar2;
                }
            }
            aVar.f43980c = arrayList8;
            aVar.f43981d = arrayList9;
            aVar.f43984g = get_all_feedsphoto_ex_rspVar2.stMemoryInfo;
        }
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
