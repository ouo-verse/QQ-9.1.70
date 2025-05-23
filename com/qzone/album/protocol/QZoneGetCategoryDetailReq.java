package com.qzone.album.protocol;

import NS_MOBILE_FEEDS.cell_lbs;
import NS_MOBILE_PHOTO.Album;
import NS_MOBILE_PHOTO.CategoryPhoto;
import NS_MOBILE_PHOTO.GetCategoryDetailReq;
import NS_MOBILE_PHOTO.GetCategoryDetailReqItem;
import NS_MOBILE_PHOTO.GetCategoryDetailRsp;
import NS_MOBILE_PHOTO.GetCategoryDetailRspItem;
import NS_MOBILE_PHOTO.PhotoFeedsData;
import NS_MOBILE_PHOTO.SummaryInfo;
import NS_MOBILE_PHOTO.face_show_info;
import NS_MOBILE_PHOTO.label_show_info;
import com.qq.taf.jce.JceStruct;
import com.qzone.album.data.model.AlbumCacheData;
import com.qzone.album.data.model.PhotoCategorySinglePicInfo;
import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import photo_share_struct.uin_nick_info;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneGetCategoryDetailReq extends AbsCompatRequest<a> {
    private static final String FIELD_CMD = "asy_photo.GetCategoryDetail";

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public ArrayList<PhotoCategorySinglePicInfo> f43905a = new ArrayList<>();

        /* renamed from: b, reason: collision with root package name */
        public ArrayList<AlbumCacheData> f43906b = new ArrayList<>();

        /* renamed from: c, reason: collision with root package name */
        public PhotoCategorySummaryInfo f43907c = new PhotoCategorySummaryInfo();

        /* renamed from: d, reason: collision with root package name */
        public boolean f43908d = false;

        /* renamed from: e, reason: collision with root package name */
        public String f43909e = null;

        /* renamed from: f, reason: collision with root package name */
        public int f43910f = 0;

        /* renamed from: g, reason: collision with root package name */
        public String f43911g = null;

        /* renamed from: h, reason: collision with root package name */
        public long f43912h = 0;

        /* renamed from: i, reason: collision with root package name */
        public String f43913i = "";

        /* renamed from: j, reason: collision with root package name */
        public long f43914j = 0;

        /* renamed from: k, reason: collision with root package name */
        public int f43915k = 0;

        /* renamed from: l, reason: collision with root package name */
        public ArrayList<String> f43916l = new ArrayList<>();
    }

    public QZoneGetCategoryDetailReq(long j3, Map<Integer, GetCategoryDetailReqItem> map) {
        super(FIELD_CMD);
        GetCategoryDetailReq getCategoryDetailReq = new GetCategoryDetailReq();
        getCategoryDetailReq.host = j3;
        getCategoryDetailReq.req_item_map = map;
        this.req = getCategoryDetailReq;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return "GetCategoryDetail";
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.qzone.album.protocol.AbsCompatRequest
    public a onJceRespParse(JceStruct jceStruct) throws Exception {
        GetCategoryDetailRsp getCategoryDetailRsp;
        Map<Integer, GetCategoryDetailRspItem> map;
        cell_lbs cell_lbsVar;
        face_show_info face_show_infoVar;
        uin_nick_info uin_nick_infoVar;
        label_show_info label_show_infoVar;
        a aVar = new a();
        if ((jceStruct instanceof GetCategoryDetailRsp) && (getCategoryDetailRsp = (GetCategoryDetailRsp) jceStruct) != null && (map = getCategoryDetailRsp.rsp_item_map) != null && map.size() > 0) {
            for (GetCategoryDetailRspItem getCategoryDetailRspItem : getCategoryDetailRsp.rsp_item_map.values()) {
                if (getCategoryDetailRspItem != null) {
                    SummaryInfo summaryInfo = getCategoryDetailRspItem.attr;
                    if (summaryInfo != null) {
                        aVar.f43909e = summaryInfo.url;
                        int i3 = summaryInfo.type;
                        aVar.f43910f = i3;
                        aVar.f43911g = summaryInfo.categoryid;
                        aVar.f43912h = summaryInfo.photo_num;
                        if (i3 == 4 && (label_show_infoVar = summaryInfo.label_show) != null) {
                            aVar.f43913i = label_show_infoVar.label;
                            ArrayList<String> arrayList = label_show_infoVar.labelids;
                            if (arrayList != null) {
                                aVar.f43916l = arrayList;
                            }
                        } else if (i3 == 1 && (face_show_infoVar = summaryInfo.face_show) != null && (uin_nick_infoVar = face_show_infoVar.pic_host) != null) {
                            aVar.f43913i = uin_nick_infoVar.nick;
                            aVar.f43914j = uin_nick_infoVar.uin;
                            aVar.f43915k = face_show_infoVar.status;
                            ArrayList<String> arrayList2 = face_show_infoVar.groupids;
                            if (arrayList2 != null) {
                                aVar.f43916l = arrayList2;
                            }
                        } else if (i3 == 2 && (cell_lbsVar = summaryInfo.poi_info) != null) {
                            aVar.f43913i = cell_lbsVar.location;
                        }
                    }
                    CategoryPhoto categoryPhoto = getCategoryDetailRspItem.photos;
                    if (categoryPhoto != null) {
                        aVar.f43908d = categoryPhoto.has_more;
                        Iterator<PhotoFeedsData> it = categoryPhoto.photos.iterator();
                        while (it.hasNext()) {
                            PhotoFeedsData next = it.next();
                            if (next != null) {
                                ArrayList<PhotoCategorySinglePicInfo> arrayList3 = aVar.f43905a;
                                long s16 = com.qzone.album.env.common.a.m().s();
                                int i16 = aVar.f43910f;
                                String str = aVar.f43911g;
                                CategoryPhoto categoryPhoto2 = getCategoryDetailRspItem.photos;
                                arrayList3.add(PhotoCategorySinglePicInfo.createFrom(next, s16, 1, i16, str, categoryPhoto2.has_more, categoryPhoto2.photo_page_str));
                                Album album = next.album;
                                if (album != null) {
                                    aVar.f43906b.add(AlbumCacheData.createFromResponse(album));
                                }
                            }
                        }
                    }
                }
            }
        }
        return aVar;
    }
}
