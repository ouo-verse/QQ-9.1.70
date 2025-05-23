package com.qzone.album.protocol;

import NS_MOBILE_PHOTO.Album;
import NS_MOBILE_PHOTO.CategoryPhoto;
import NS_MOBILE_PHOTO.ListAllCategoryReq;
import NS_MOBILE_PHOTO.ListAllCategoryReqItem;
import NS_MOBILE_PHOTO.ListAllCategoryRsp;
import NS_MOBILE_PHOTO.ListAllCategoryRspItem;
import NS_MOBILE_PHOTO.PhotoFeedsData;
import NS_MOBILE_PHOTO.SummaryInfo;
import com.qq.taf.jce.JceStruct;
import com.qzone.album.data.model.AlbumCacheData;
import com.qzone.album.data.model.PhotoCategorySinglePicInfo;
import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneListAllCategoryReq extends AbsCompatRequest<a> {
    private static final String FIELD_CMD = "asy_photo.ListAllCategory";

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public ArrayList<PhotoCategorySummaryInfo> f43952a;

        /* renamed from: b, reason: collision with root package name */
        public ArrayList<PhotoCategorySinglePicInfo> f43953b;

        /* renamed from: c, reason: collision with root package name */
        public ArrayList<AlbumCacheData> f43954c;

        /* renamed from: d, reason: collision with root package name */
        public Map<String, ArrayList<PhotoCategorySinglePicInfo>> f43955d;

        /* renamed from: e, reason: collision with root package name */
        public int f43956e = 0;
    }

    public QZoneListAllCategoryReq(long j3, Map<Integer, ListAllCategoryReqItem> map, boolean z16) {
        super(FIELD_CMD);
        ListAllCategoryReq listAllCategoryReq = new ListAllCategoryReq();
        listAllCategoryReq.host = j3;
        listAllCategoryReq.req_item_map = map;
        setGetMore(z16);
        this.req = listAllCategoryReq;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return "ListAllCategory";
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.qzone.album.protocol.AbsCompatRequest
    public a onJceRespParse(JceStruct jceStruct) throws Exception {
        ArrayList<PhotoFeedsData> arrayList;
        Album album;
        ArrayList<PhotoCategorySinglePicInfo> arrayList2;
        if (QZLog.isColorLevel()) {
            QZLog.i(QZLog.TO_DEVICE_TAG, 2, "PhotoCategoryController onListAllCategoryResponse onJceRespParse");
        }
        if (!(jceStruct instanceof ListAllCategoryRsp)) {
            QZLog.e(QZLog.TO_DEVICE_TAG, 2, "not instanceof ListAllCategoryRsp error");
            return null;
        }
        a aVar = new a();
        ListAllCategoryRsp listAllCategoryRsp = (ListAllCategoryRsp) jceStruct;
        Map<Integer, ListAllCategoryRspItem> map = listAllCategoryRsp.rsp_item_map;
        if (map != null && map.size() > 0) {
            aVar.f43952a = new ArrayList<>();
            aVar.f43953b = new ArrayList<>();
            aVar.f43954c = new ArrayList<>();
            aVar.f43955d = new HashMap();
            for (ListAllCategoryRspItem listAllCategoryRspItem : listAllCategoryRsp.rsp_item_map.values()) {
                ArrayList<SummaryInfo> arrayList3 = listAllCategoryRspItem.categoryid_summaryinfos;
                Map<String, CategoryPhoto> map2 = listAllCategoryRspItem.categoryid_photos;
                if (arrayList3 != null && arrayList3.size() > 0) {
                    Iterator<SummaryInfo> it = arrayList3.iterator();
                    while (it.hasNext()) {
                        SummaryInfo next = it.next();
                        if (next != null) {
                            PhotoCategorySummaryInfo createFrom = PhotoCategorySummaryInfo.createFrom(next, listAllCategoryRspItem.has_more, listAllCategoryRspItem.page_str, com.qzone.album.env.common.a.m().s());
                            aVar.f43952a.add(createFrom);
                            if (createFrom != null && (arrayList2 = createFrom.previewPhotos) != null && arrayList2.size() > 0) {
                                aVar.f43953b.addAll(createFrom.previewPhotos);
                            }
                        }
                    }
                    if (arrayList3.get(0) != null) {
                        aVar.f43956e = arrayList3.get(0).type;
                    }
                }
                if (map2 != null && map2.values().size() > 0) {
                    for (CategoryPhoto categoryPhoto : map2.values()) {
                        if (categoryPhoto != null && (arrayList = categoryPhoto.photos) != null && arrayList.size() > 0) {
                            ArrayList<PhotoCategorySinglePicInfo> arrayList4 = new ArrayList<>();
                            Iterator<PhotoFeedsData> it5 = categoryPhoto.photos.iterator();
                            while (it5.hasNext()) {
                                PhotoFeedsData next2 = it5.next();
                                arrayList4.add(PhotoCategorySinglePicInfo.createFrom(next2, com.qzone.album.env.common.a.m().s(), 1, aVar.f43956e, categoryPhoto.categoryid, categoryPhoto.has_more, categoryPhoto.photo_page_str));
                                if (next2 != null && (album = next2.album) != null) {
                                    aVar.f43954c.add(AlbumCacheData.createFromResponse(album));
                                }
                            }
                            aVar.f43955d.put(categoryPhoto.categoryid, arrayList4);
                        }
                    }
                }
            }
        }
        return aVar;
    }
}
