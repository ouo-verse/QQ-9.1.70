package com.qzone.album.base.Service;

import NS_MOBILE_FEEDS.s_picdata;
import NS_MOBILE_MATERIAL.CustomAlbumTemplate;
import NS_MOBILE_MATERIAL.MaterialItem;
import NS_MOBILE_PHOTO.Album;
import NS_MOBILE_PHOTO.AllowJoinShareAlbum;
import NS_MOBILE_PHOTO.ApplyJoinShareAlbum;
import NS_MOBILE_PHOTO.BannerAttachInfo;
import NS_MOBILE_PHOTO.CategoryOpReq;
import NS_MOBILE_PHOTO.EditPhoto;
import NS_MOBILE_PHOTO.GetCategoryDetailReqItem;
import NS_MOBILE_PHOTO.ListAllCategoryReqItem;
import NS_MOBILE_PHOTO.MarkFaceItemFeed;
import NS_MOBILE_PHOTO.MarkFaceItemMood;
import NS_MOBILE_PHOTO.PhotoSearchBoxChosenItem;
import NS_MOBILE_PHOTO.PicContInfo;
import NS_MOBILE_PHOTO.RecommendPhotos;
import NS_MOBILE_PHOTO.category_face_confirm_info;
import NS_MOBILE_PHOTO.modify_travel_photo_scence;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.qzone.album.base.AlbumPersonalizeManager;
import com.qzone.album.data.AlbumCacheDataManager;
import com.qzone.album.data.model.AlbumCacheData;
import com.qzone.album.data.model.AlbumSocialInfoCacheData;
import com.qzone.album.data.model.LoveAlbumTimeEvent;
import com.qzone.album.data.model.ParentingAlbumData;
import com.qzone.album.data.model.PhotoCacheData;
import com.qzone.album.data.model.PhotoCategoryControlInfo;
import com.qzone.album.data.model.PhotoCategorySinglePicInfo;
import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.qzone.album.data.model.PhotoPoiArea;
import com.qzone.album.data.model.PicContInfoCacheData;
import com.qzone.album.data.model.RecomAlbumList;
import com.qzone.album.data.model.ShareAlbumMemberCacheData;
import com.qzone.album.data.model.SharingAlbumClientAttr;
import com.qzone.album.data.model.TimeEvent;
import com.qzone.album.data.model.TravelAlbumData;
import com.qzone.album.protocol.AbsCompatRequest;
import com.qzone.album.protocol.QZoneAlbumListRequest;
import com.qzone.album.protocol.QZoneAlbumSortPhotoRequest;
import com.qzone.album.protocol.QZoneCategoryIdentifyBatchReq;
import com.qzone.album.protocol.QZoneCategoryOpReq;
import com.qzone.album.protocol.QZoneDelBatchPhotosRequest;
import com.qzone.album.protocol.QZoneGetCategoryDetailReq;
import com.qzone.album.protocol.QZoneGetPhotoListByTimeLineRequest;
import com.qzone.album.protocol.QZoneGetPhotoSearchRequest;
import com.qzone.album.protocol.QZoneGetRecentPhotoListByTimeLineRequest;
import com.qzone.album.protocol.QZoneGetShareAlbumMemberDataRequest;
import com.qzone.album.protocol.QZoneJoinShareAlbumRequest;
import com.qzone.album.protocol.QZoneListAllCategoryReq;
import com.qzone.album.protocol.QZoneMoveBatchPhotosRequest;
import com.qzone.album.protocol.QZoneOperateTravelPhotoSceneRequest;
import com.qzone.album.protocol.QZoneOptAlbumRequest;
import com.qzone.album.protocol.QZoneParentingPhotoListRequest;
import com.qzone.album.protocol.QZonePhotoListRequest;
import com.qzone.album.protocol.QZoneQueryAlbumRequest;
import com.qzone.album.protocol.QZoneQunViewPhotoRequest;
import com.qzone.album.protocol.QZoneReportP2VRecommendedRequest;
import com.qzone.album.protocol.QZoneSetPhotoListSortTypeRequest;
import com.qzone.album.protocol.QZoneTravelPhotoListRequest;
import com.qzone.album.protocol.QZoneViewPhotoRequest;
import com.qzone.album.protocol.QzoneAlbumRecentAllPhotoRequest;
import com.qzone.album.protocol.QzoneFaceOperationRequest;
import com.qzone.album.protocol.QzoneGetPhotoCommentRequest;
import com.qzone.album.protocol.QzoneGetPicContInfoRequest;
import com.qzone.album.protocol.QzoneShareToOutsiteRequest;
import com.qzone.album.ui.widget.AlbumTimeLineView;
import com.qzone.album.util.QZoneAlbumUtil;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.event.EventCenter;
import com.qzone.common.protocol.request.QZoneAddCommentRequest;
import com.qzone.common.protocol.request.QZoneForwardRequest;
import com.qzone.common.tool.ReportUtils;
import com.qzone.misc.network.qboss.protocol.QzoneQBossAdvRequest;
import com.qzone.preview.service.QZoneAlbumRequestBuilder;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import common.config.service.QzoneConfig;
import cooperation.qzone.model.BusinessAlbumInfo;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import photo_share_struct.client_attr;

/* compiled from: P */
/* loaded from: classes39.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    private int f41963b = 0;

    /* renamed from: c, reason: collision with root package name */
    private AbsCompatRequest.b f41964c = new v();

    /* renamed from: d, reason: collision with root package name */
    private AbsCompatRequest.b f41965d = new ag();

    /* renamed from: e, reason: collision with root package name */
    private AbsCompatRequest.b f41966e = new ak();

    /* renamed from: f, reason: collision with root package name */
    private AbsCompatRequest.b f41967f = new am();

    /* renamed from: g, reason: collision with root package name */
    private AbsCompatRequest.b f41968g = new an();

    /* renamed from: h, reason: collision with root package name */
    private AbsCompatRequest.b f41969h = new ao();

    /* renamed from: i, reason: collision with root package name */
    private AbsCompatRequest.b f41970i = new ap();

    /* renamed from: j, reason: collision with root package name */
    private AbsCompatRequest.b f41971j = new C0308a();

    /* renamed from: k, reason: collision with root package name */
    private AbsCompatRequest.b f41972k = new b();

    /* renamed from: l, reason: collision with root package name */
    private AbsCompatRequest.b f41973l = new c();

    /* renamed from: m, reason: collision with root package name */
    private AbsCompatRequest.b f41974m = new d();

    /* renamed from: n, reason: collision with root package name */
    private AbsCompatRequest.b f41975n = new e();

    /* renamed from: o, reason: collision with root package name */
    private AbsCompatRequest.b f41976o = new f();

    /* renamed from: p, reason: collision with root package name */
    private AbsCompatRequest.b f41977p = new g();

    /* renamed from: q, reason: collision with root package name */
    private AbsCompatRequest.b f41978q = new h();

    /* renamed from: r, reason: collision with root package name */
    private AbsCompatRequest.b f41979r = new i();

    /* renamed from: s, reason: collision with root package name */
    private AbsCompatRequest.b f41980s = new j();

    /* renamed from: t, reason: collision with root package name */
    private AbsCompatRequest.b f41981t = new l();

    /* renamed from: u, reason: collision with root package name */
    private AbsCompatRequest.b f41982u = new m();

    /* renamed from: v, reason: collision with root package name */
    private AbsCompatRequest.b f41983v = new n();

    /* renamed from: w, reason: collision with root package name */
    private AbsCompatRequest.b f41984w = new o();

    /* renamed from: x, reason: collision with root package name */
    private AbsCompatRequest.b f41985x = new p();

    /* renamed from: y, reason: collision with root package name */
    private Object f41986y = new Object();

    /* renamed from: z, reason: collision with root package name */
    private final Object f41987z = new Object();
    private AbsCompatRequest.b A = new q();
    private AbsCompatRequest.b B = new s();
    private AbsCompatRequest.b C = new t();
    private final String D = "5";
    private AbsCompatRequest.b E = new ad();
    private AbsCompatRequest.b F = new ae();
    private AbsCompatRequest.b G = new af();
    private AbsCompatRequest.b H = new ah();
    private AbsCompatRequest.b I = new ai();
    private AbsCompatRequest.b J = new aj();

    /* renamed from: a, reason: collision with root package name */
    private AlbumCacheDataManager f41962a = AlbumCacheDataManager.J();

    /* compiled from: P */
    /* renamed from: com.qzone.album.base.Service.a$a, reason: collision with other inner class name */
    /* loaded from: classes39.dex */
    class C0308a implements AbsCompatRequest.b {

        /* compiled from: P */
        /* renamed from: com.qzone.album.base.Service.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes39.dex */
        class C0309a implements AbsCompatRequest.a {
            C0309a() {
            }

            @Override // com.qzone.album.protocol.AbsCompatRequest.a
            public void a(AbsCompatRequest absCompatRequest, com.qzone.adapter.feedcomponent.s sVar, int i3, String str) {
                a.this.E1();
            }
        }

        C0308a() {
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.b
        public boolean a(AbsCompatRequest absCompatRequest, com.qzone.adapter.feedcomponent.s sVar) {
            Long l3 = (Long) absCompatRequest.getParam("face_uin");
            Long valueOf = Long.valueOf(l3 == null ? 0L : l3.longValue());
            String str = (String) absCompatRequest.getParam("albumId");
            boolean booleanValue = ((Boolean) absCompatRequest.getParam("filterVideo")).booleanValue();
            if (!com.qzone.album.util.d.d(sVar.getReturnCode())) {
                a.this.f41962a.j(str);
            } else if (sVar.getData() instanceof QZonePhotoListRequest.b) {
                QZonePhotoListRequest.b bVar = (QZonePhotoListRequest.b) sVar.getData();
                if (bVar.f43961c != null) {
                    AlbumCacheData x16 = a.this.f41962a.x(0L, bVar.f43961c.albumid);
                    if (x16 != null && !TextUtils.isEmpty(x16.ark_content)) {
                        AlbumCacheData albumCacheData = bVar.f43961c;
                        albumCacheData.ark_id = x16.ark_id;
                        albumCacheData.view_id = x16.view_id;
                        albumCacheData.ark_content = x16.ark_content;
                    }
                    if (x16 != null && !TextUtils.isEmpty(x16.ark_content_invate)) {
                        AlbumCacheData albumCacheData2 = bVar.f43961c;
                        albumCacheData2.ark_id_invate = x16.ark_id_invate;
                        albumCacheData2.view_id_invate = x16.view_id_invate;
                        albumCacheData2.ark_content_invate = x16.ark_content_invate;
                    }
                    a.this.f41962a.j0(bVar.f43961c);
                }
                if (!TextUtils.isEmpty(bVar.f43971m)) {
                    a.this.f41962a.l0(bVar.f43971m);
                }
                if (valueOf.longValue() == 0 && bVar.f43963e != null) {
                    if (QZLog.isColorLevel()) {
                        QZLog.d("[PhotoAlbum]AlbumManager", 4, "onRefreshPhotoListResponse | faceUin == 0 | photoDataList size:" + bVar.f43963e.size());
                    }
                    if (bVar.f43961c != null) {
                        a.this.f41962a.A0(bVar.f43961c.albumid, bVar.f43963e);
                    }
                }
                if (valueOf.longValue() != 0) {
                    a.this.V0(bVar.f43963e, Boolean.FALSE);
                } else {
                    Object param = absCompatRequest.getParam("is_sorting_mode");
                    boolean booleanValue2 = param != null ? ((Boolean) param).booleanValue() : false;
                    AlbumCacheData albumCacheData3 = bVar.f43961c;
                    if (albumCacheData3 != null) {
                        a.this.z1(albumCacheData3.albumid, false, booleanValue2, bVar.f43964f, booleanValue, bVar.f43959a);
                    }
                }
                sVar.setNewCnt(bVar.f43959a);
                sVar.setHasMore(bVar.f43960b);
                AlbumCacheData albumCacheData4 = bVar.f43961c;
                if (albumCacheData4 != null && albumCacheData4.albumtype == 12) {
                    a.this.x0(albumCacheData4.ownerUin, albumCacheData4.albumid, new C0309a());
                }
            }
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class aa implements AbsCompatRequest.b {
        aa() {
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.b
        public boolean a(AbsCompatRequest absCompatRequest, com.qzone.adapter.feedcomponent.s sVar) {
            if (!(sVar.getData() instanceof QZoneJoinShareAlbumRequest.a)) {
                return true;
            }
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class ab implements AbsCompatRequest.b {
        ab() {
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.b
        public boolean a(AbsCompatRequest absCompatRequest, com.qzone.adapter.feedcomponent.s sVar) {
            if (sVar.getData() instanceof QZoneForwardRequest.a) {
                QZoneForwardRequest.a aVar = (QZoneForwardRequest.a) sVar.getData();
                sVar.setSucceed(aVar.f46119a == 0);
                QZLog.e("[PhotoAlbum]AlbumManager", "onCommentAlbum  return code: " + aVar.f46119a);
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class ac implements AbsCompatRequest.b {
        ac() {
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.b
        public boolean a(AbsCompatRequest absCompatRequest, com.qzone.adapter.feedcomponent.s sVar) {
            if (sVar.getData() instanceof QZoneForwardRequest.a) {
                QZoneForwardRequest.a aVar = (QZoneForwardRequest.a) sVar.getData();
                sVar.setSucceed(aVar.f46119a == 0);
                QZLog.e("[PhotoAlbum]AlbumManager", "onForwardAlbum  return code: " + aVar.f46119a);
            }
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class ad implements AbsCompatRequest.b {
        ad() {
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.b
        public boolean a(AbsCompatRequest absCompatRequest, com.qzone.adapter.feedcomponent.s sVar) {
            Object data = sVar.getData();
            if (sVar.getSucceed() && (data instanceof QZoneListAllCategoryReq.a)) {
                QZoneListAllCategoryReq.a aVar = (QZoneListAllCategoryReq.a) data;
                if (aVar.f43954c != null) {
                    a.this.f41962a.E0(aVar.f43954c, com.qzone.album.env.common.a.m().s(), false);
                }
                if (aVar.f43953b != null) {
                    a.this.f41962a.F0(aVar.f43953b, !absCompatRequest.isGetMore(), com.qzone.album.env.common.a.m().s(), aVar.f43956e, 0);
                }
                if (aVar.f43952a != null) {
                    if (absCompatRequest.isGetMore()) {
                        a.this.f41962a.b(com.qzone.album.env.common.a.m().s(), aVar.f43956e, aVar.f43952a);
                    } else if (aVar.f43952a.isEmpty()) {
                        a.this.f41962a.s(com.qzone.album.env.common.a.m().s(), aVar.f43956e);
                    } else {
                        a.this.f41962a.y0(com.qzone.album.env.common.a.m().s(), aVar.f43956e, aVar.f43952a);
                    }
                }
                Map<String, ArrayList<PhotoCategorySinglePicInfo>> map = aVar.f43955d;
                if (map != null) {
                    for (String str : map.keySet()) {
                        if (a.this.f41962a.M(com.qzone.album.env.common.a.m().s(), aVar.f43956e, str, 1) == null && aVar.f43955d.get(str) != null) {
                            a.this.f41962a.G0(aVar.f43955d.get(str), true, com.qzone.album.env.common.a.m().s(), aVar.f43956e, str, 1);
                        }
                    }
                }
            }
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class ae implements AbsCompatRequest.b {
        ae() {
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.b
        public boolean a(AbsCompatRequest absCompatRequest, com.qzone.adapter.feedcomponent.s sVar) {
            if (sVar.getSucceed() && (sVar.getData() instanceof QZoneGetCategoryDetailReq.a)) {
                Boolean bool = (Boolean) absCompatRequest.getParam("from_picture_viewer");
                QZoneGetCategoryDetailReq.a aVar = (QZoneGetCategoryDetailReq.a) sVar.getData();
                if (!absCompatRequest.isGetMore()) {
                    a.this.f41962a.G0(aVar.f43905a, true, com.qzone.album.env.common.a.m().s(), aVar.f43910f, aVar.f43911g, 1);
                    a.this.f41962a.E0(aVar.f43906b, com.qzone.album.env.common.a.m().s(), true);
                } else {
                    a.this.f41962a.G0(aVar.f43905a, false, com.qzone.album.env.common.a.m().s(), aVar.f43910f, aVar.f43911g, 1);
                    a.this.f41962a.E0(aVar.f43906b, com.qzone.album.env.common.a.m().s(), false);
                }
                if (bool.booleanValue()) {
                    a.this.O0(11, sVar, Boolean.valueOf(absCompatRequest.isGetMore()));
                } else {
                    PhotoCategorySummaryInfo photoCategorySummaryInfo = aVar.f43907c;
                    photoCategorySummaryInfo.avatarUrl = aVar.f43909e;
                    photoCategorySummaryInfo.photoNumber = aVar.f43912h;
                    photoCategorySummaryInfo.nick = aVar.f43913i;
                    photoCategorySummaryInfo.groupid_list = aVar.f43916l;
                    photoCategorySummaryInfo.faceUin = aVar.f43914j;
                    photoCategorySummaryInfo.faceStatus = aVar.f43915k;
                }
            }
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class af implements AbsCompatRequest.b {
        af() {
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.b
        public boolean a(AbsCompatRequest absCompatRequest, com.qzone.adapter.feedcomponent.s sVar) {
            String str;
            Object data = sVar.getData();
            if (data instanceof QZoneCategoryOpReq.a) {
                int intValue = ((Integer) absCompatRequest.getParam("operationType")).intValue();
                String str2 = (String) absCompatRequest.getParam("nick");
                PhotoCategorySummaryInfo photoCategorySummaryInfo = (PhotoCategorySummaryInfo) absCompatRequest.getParam("categorySummaryInfo");
                QZoneCategoryOpReq.a aVar = (QZoneCategoryOpReq.a) data;
                if (aVar.f43901a == 0 && photoCategorySummaryInfo != null) {
                    String str3 = photoCategorySummaryInfo.categoryId;
                    if (str2 != null && str2.length() > 0) {
                        photoCategorySummaryInfo.nick = str2;
                    }
                    Map<String, String> map = aVar.f43903c;
                    if (map != null && map.size() > 0) {
                        for (Map.Entry<String, String> entry : aVar.f43903c.entrySet()) {
                            String str4 = photoCategorySummaryInfo.categoryId;
                            if (str4 != null && str4.equals(entry.getKey())) {
                                photoCategorySummaryInfo.categoryId = entry.getValue();
                            }
                        }
                    }
                    a.this.f41962a.e0(photoCategorySummaryInfo, str3);
                    ArrayList<PhotoCategorySummaryInfo> Q = a.this.f41962a.Q(photoCategorySummaryInfo.uin, photoCategorySummaryInfo.categoryType, photoCategorySummaryInfo.categoryId);
                    if (Q != null && Q.size() > 1) {
                        PhotoCategorySummaryInfo photoCategorySummaryInfo2 = Q.get(0);
                        PhotoCategorySummaryInfo photoCategorySummaryInfo3 = Q.get(1);
                        if (photoCategorySummaryInfo2 == null || photoCategorySummaryInfo3 == null) {
                            str = null;
                        } else {
                            str = photoCategorySummaryInfo3.avatarUrl;
                            photoCategorySummaryInfo2.photoNumber += photoCategorySummaryInfo3.photoNumber;
                            photoCategorySummaryInfo2.hasMore = photoCategorySummaryInfo3.hasMore;
                            photoCategorySummaryInfo2.pageStr = photoCategorySummaryInfo3.pageStr;
                        }
                        if (photoCategorySummaryInfo3 != null) {
                            a.this.f41962a.u(photoCategorySummaryInfo3, str);
                        }
                        if (photoCategorySummaryInfo2 != null) {
                            photoCategorySummaryInfo = photoCategorySummaryInfo2;
                        }
                    }
                    if (intValue == 1) {
                        photoCategorySummaryInfo.faceStatus = 1;
                    } else if (intValue == 2) {
                        photoCategorySummaryInfo.faceStatus = 2;
                    }
                    a.this.f41962a.d0(photoCategorySummaryInfo);
                    ArrayList<PhotoCategorySinglePicInfo> O = a.this.f41962a.O(photoCategorySummaryInfo.uin, photoCategorySummaryInfo.categoryType, str3, 0, 0, 0);
                    if (O != null && O.size() > 0) {
                        Iterator<PhotoCategorySinglePicInfo> it = O.iterator();
                        while (it.hasNext()) {
                            PhotoCategorySinglePicInfo next = it.next();
                            next.categoryId = photoCategorySummaryInfo.categoryId;
                            a.this.f41962a.g0(next, 0, str3);
                        }
                    }
                    ArrayList<PhotoCategorySinglePicInfo> O2 = a.this.f41962a.O(photoCategorySummaryInfo.uin, photoCategorySummaryInfo.categoryType, str3, 1, 0, 0);
                    if (O2 != null) {
                        Iterator<PhotoCategorySinglePicInfo> it5 = O2.iterator();
                        while (it5.hasNext()) {
                            PhotoCategorySinglePicInfo next2 = it5.next();
                            next2.categoryId = photoCategorySummaryInfo.categoryId;
                            a.this.f41962a.g0(next2, 1, str3);
                        }
                    }
                    aVar.f43904d = photoCategorySummaryInfo;
                }
            }
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class ag implements AbsCompatRequest.b {
        ag() {
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.b
        public boolean a(AbsCompatRequest absCompatRequest, com.qzone.adapter.feedcomponent.s sVar) {
            String str = (String) absCompatRequest.getParam("albumId");
            if (sVar.getData() instanceof QZoneQueryAlbumRequest.a) {
                QZoneQueryAlbumRequest.a aVar = (QZoneQueryAlbumRequest.a) sVar.getData();
                String str2 = (String) absCompatRequest.getParam(AEEditorConstants.ALBUMNAME);
                if (aVar.f43973b != null) {
                    if (QZLog.isColorLevel()) {
                        QZLog.d("[PhotoAlbum]AlbumManager", 2, "onQueryAlbum albumid:" + aVar.f43973b.mAlbumId);
                    }
                    if (a.this.E0(aVar.f43973b, str, str2)) {
                        a.this.f41962a.K0(aVar.f43974c);
                    }
                }
            }
            if (sVar.getReturnCode() != -11529) {
                return true;
            }
            a.this.f41962a.n(str);
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class ah implements AbsCompatRequest.b {
        ah() {
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.b
        public boolean a(AbsCompatRequest absCompatRequest, com.qzone.adapter.feedcomponent.s sVar) {
            Object data = sVar.getData();
            if (data instanceof QZoneCategoryOpReq.a) {
                int intValue = ((Integer) absCompatRequest.getParam("operationType")).intValue();
                ArrayList arrayList = (ArrayList) absCompatRequest.getParam("photolist");
                PhotoCategorySummaryInfo photoCategorySummaryInfo = (PhotoCategorySummaryInfo) absCompatRequest.getParam("categorySummaryInfo");
                QZoneCategoryOpReq.a aVar = (QZoneCategoryOpReq.a) data;
                if (aVar.f43901a == 0 && photoCategorySummaryInfo != null) {
                    if (intValue == 5) {
                        a.this.f41962a.t(photoCategorySummaryInfo);
                        return true;
                    }
                    if (arrayList != null && arrayList.size() > 0) {
                        ArrayList<PhotoCategorySinglePicInfo> O = a.this.f41962a.O(photoCategorySummaryInfo.uin, photoCategorySummaryInfo.categoryType, photoCategorySummaryInfo.categoryId, 1, 0, 0);
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            String str = (String) it.next();
                            if (O != null && O.size() > 0) {
                                Iterator<PhotoCategorySinglePicInfo> it5 = O.iterator();
                                while (it5.hasNext()) {
                                    PhotoCategorySinglePicInfo next = it5.next();
                                    if (str.equals(next.lloc)) {
                                        a.this.f41962a.w(next, 1);
                                    }
                                }
                            }
                        }
                    }
                    if (photoCategorySummaryInfo.photoNumber > 0) {
                        a.this.f41962a.d0(photoCategorySummaryInfo);
                        if (photoCategorySummaryInfo.photoNumber <= 3) {
                            ArrayList<PhotoCategorySinglePicInfo> O2 = a.this.f41962a.O(photoCategorySummaryInfo.uin, photoCategorySummaryInfo.categoryType, photoCategorySummaryInfo.categoryId, 0, 0, 0);
                            if (arrayList != null) {
                                Iterator it6 = arrayList.iterator();
                                while (it6.hasNext()) {
                                    String str2 = (String) it6.next();
                                    if (O2 != null && O2.size() > 0) {
                                        Iterator<PhotoCategorySinglePicInfo> it7 = O2.iterator();
                                        while (it7.hasNext()) {
                                            PhotoCategorySinglePicInfo next2 = it7.next();
                                            if (str2.equals(next2.lloc)) {
                                                a.this.f41962a.w(next2, 0);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        a.this.f41962a.t(photoCategorySummaryInfo);
                    }
                    aVar.f43904d = photoCategorySummaryInfo;
                }
            }
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class ai implements AbsCompatRequest.b {
        ai() {
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.b
        public boolean a(AbsCompatRequest absCompatRequest, com.qzone.adapter.feedcomponent.s sVar) {
            if (sVar.getData() instanceof QzoneQBossAdvRequest.a) {
                QzoneQBossAdvRequest.a aVar = (QzoneQBossAdvRequest.a) sVar.getData();
                if (aVar.f48460a == 0) {
                    sVar.setSucceed(true);
                } else {
                    sVar.setSucceed(false);
                    QZLog.e("[PhotoAlbum]AlbumManager", "on Qboss fail return code: " + aVar.f48460a);
                }
            }
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class aj implements AbsCompatRequest.b {
        aj() {
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.b
        public boolean a(AbsCompatRequest absCompatRequest, com.qzone.adapter.feedcomponent.s sVar) {
            QzoneGetPicContInfoRequest.a aVar;
            Map<String, PicContInfo> map;
            String str = (String) absCompatRequest.getParam("albumId");
            if ((sVar.getData() instanceof QzoneGetPicContInfoRequest.a) && (map = (aVar = (QzoneGetPicContInfoRequest.a) sVar.getData()).f43994a) != null && map.size() != 0) {
                HashMap<String, PicContInfoCacheData> hashMap = new HashMap<>(1);
                ArrayList<PicContInfoCacheData> arrayList = new ArrayList<>(1);
                for (Map.Entry<String, PicContInfo> entry : aVar.f43994a.entrySet()) {
                    PicContInfoCacheData picContInfoCacheData = new PicContInfoCacheData();
                    picContInfoCacheData.albumid = str;
                    picContInfoCacheData.md5 = entry.getValue().md5;
                    picContInfoCacheData.size = entry.getValue().size;
                    picContInfoCacheData.url = com.qzone.album.util.i.a(entry.getKey());
                    com.qzone.album.env.common.a.m().c("[PhotoAlbum]aioSendPhotos", "[data come back] data:", picContInfoCacheData.toString());
                    arrayList.add(picContInfoCacheData);
                    hashMap.put(picContInfoCacheData.url, picContInfoCacheData);
                }
                a.this.f41962a.g(arrayList);
                aVar.f43995b = hashMap;
            }
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class ak implements AbsCompatRequest.b {
        ak() {
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.b
        public boolean a(AbsCompatRequest absCompatRequest, com.qzone.adapter.feedcomponent.s sVar) {
            if (!sVar.getSucceed()) {
                return true;
            }
            QZoneAlbumListRequest.a aVar = (QZoneAlbumListRequest.a) sVar.getData();
            long j3 = aVar.f43885a;
            a aVar2 = a.this;
            aVar2.M1(aVar2.O(j3, "albumlist"), aVar.f43888d);
            a.this.L1(j3, aVar.f43889e, aVar.f43890f, aVar.f43891g, absCompatRequest.isGetMore());
            if (aVar.f43892h != null) {
                AlbumPersonalizeManager.L().T(aVar.f43892h.stAlbumSkin);
            }
            ArrayList<AlbumCacheData> arrayList = aVar.f43887c;
            if (arrayList != null) {
                Iterator<AlbumCacheData> it = arrayList.iterator();
                while (it.hasNext()) {
                    AlbumCacheData next = it.next();
                    AlbumCacheData x16 = a.this.f41962a.x(j3, next.albumid);
                    if (x16 != null) {
                        if (next.individual == 1) {
                            MaterialItem materialItem = x16.albumTemplate;
                            next.albumTemplate = materialItem;
                            if (materialItem != null) {
                                next.albumTemplateData = (CustomAlbumTemplate) t5.b.b(CustomAlbumTemplate.class, materialItem.strExtFields);
                            }
                        }
                        if (next.getAlbumThemeTypeValue() == 8) {
                            next.parentingData = x16.parentingData;
                        }
                        if (next.getAlbumThemeTypeValue() == 11) {
                            next.loveValue = x16.loveValue;
                            next.loveTime = x16.loveTime;
                            next.parentingData = x16.parentingData;
                        }
                        if (next.getAlbumThemeTypeValue() == 9) {
                            next.travelData = x16.travelData;
                        }
                        next.sharingAlbumClientAttrArrayList = x16.sharingAlbumClientAttrArrayList;
                        next.createTime = x16.createTime;
                    }
                    if (next.albumtype == 101) {
                        next.albumid += "film";
                    }
                }
                a.this.f41962a.w0(j3, aVar.f43887c, absCompatRequest.isGetMore());
            }
            u4.a.z().f0("ar_scan_visible_" + j3, aVar.f43893i);
            sVar.setHasMore(aVar.f43886b);
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class al implements AbsCompatRequest.b {
        al() {
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.b
        public boolean a(AbsCompatRequest absCompatRequest, com.qzone.adapter.feedcomponent.s sVar) {
            if (sVar.getData() != null) {
                return true;
            }
            sVar.setSucceed(false);
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class am implements AbsCompatRequest.b {
        am() {
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.b
        public boolean a(AbsCompatRequest absCompatRequest, com.qzone.adapter.feedcomponent.s sVar) {
            Long l3 = (Long) absCompatRequest.getParam("face_uin");
            if (l3 != null) {
                l3.longValue();
            }
            String str = (String) absCompatRequest.getParam("albumId");
            if (!com.qzone.album.util.d.d(sVar.getReturnCode())) {
                a.this.f41962a.j(str);
            } else if (sVar.getData() instanceof QZonePhotoListRequest.b) {
                QZonePhotoListRequest.b bVar = (QZonePhotoListRequest.b) sVar.getData();
                if (bVar.f43961c != null) {
                    AlbumCacheData x16 = a.this.f41962a.x(0L, bVar.f43961c.albumid);
                    if (x16 != null && !TextUtils.isEmpty(x16.ark_content)) {
                        AlbumCacheData albumCacheData = bVar.f43961c;
                        albumCacheData.ark_id = x16.ark_id;
                        albumCacheData.view_id = x16.view_id;
                        albumCacheData.ark_content = x16.ark_content;
                    }
                    if (x16 != null && !TextUtils.isEmpty(x16.ark_content)) {
                        AlbumCacheData albumCacheData2 = bVar.f43961c;
                        albumCacheData2.ark_id = x16.ark_id;
                        albumCacheData2.view_id = x16.view_id;
                        albumCacheData2.ark_content = x16.ark_content;
                    }
                    a.this.f41962a.j0(bVar.f43961c);
                }
                if (!TextUtils.isEmpty(bVar.f43971m)) {
                    a.this.f41962a.l0(bVar.f43971m);
                }
                a.this.W0(bVar.f43963e, Boolean.FALSE);
                sVar.setNewCnt(bVar.f43959a);
                sVar.setHasMore(bVar.f43960b);
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class aq {

        /* renamed from: a, reason: collision with root package name */
        private static final a f42006a = new a();
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class b implements AbsCompatRequest.b {
        b() {
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.b
        public boolean a(AbsCompatRequest absCompatRequest, com.qzone.adapter.feedcomponent.s sVar) {
            String str = (String) absCompatRequest.getParam("albumId");
            boolean booleanValue = ((Boolean) absCompatRequest.getParam("filterVideo")).booleanValue();
            if (!com.qzone.album.util.d.d(sVar.getReturnCode())) {
                if (QZLog.isDevelopLevel()) {
                    QZLog.d("[PhotoAlbum]AlbumManager", 4, "onRefreshParentingPhotoListResponse failure");
                }
                a.this.f41962a.j(str);
                return true;
            }
            if (!(sVar.getData() instanceof QZoneParentingPhotoListRequest.a)) {
                return true;
            }
            QZoneParentingPhotoListRequest.a aVar = (QZoneParentingPhotoListRequest.a) sVar.getData();
            if (aVar.f43961c != null) {
                AlbumCacheData x16 = a.this.f41962a.x(0L, aVar.f43961c.albumid);
                if (x16 != null && !TextUtils.isEmpty(x16.ark_content)) {
                    AlbumCacheData albumCacheData = aVar.f43961c;
                    albumCacheData.ark_id = x16.ark_id;
                    albumCacheData.view_id = x16.view_id;
                    albumCacheData.ark_content = x16.ark_content;
                }
                if (x16 != null && !TextUtils.isEmpty(x16.ark_content_invate)) {
                    AlbumCacheData albumCacheData2 = aVar.f43961c;
                    albumCacheData2.ark_id_invate = x16.ark_id_invate;
                    albumCacheData2.view_id_invate = x16.view_id_invate;
                    albumCacheData2.ark_content_invate = x16.ark_content_invate;
                }
                a.this.f41962a.A0(aVar.f43961c.albumid, aVar.f43963e);
                a.this.f41962a.j0(aVar.f43961c);
                Object param = absCompatRequest.getParam("is_sorting_mode");
                a.this.z1(aVar.f43961c.albumid, false, param != null ? ((Boolean) param).booleanValue() : false, aVar.f43964f, booleanValue, aVar.f43959a);
            }
            sVar.setNewCnt(aVar.f43959a);
            sVar.setHasMore(aVar.f43960b);
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class c implements AbsCompatRequest.b {
        c() {
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.b
        public boolean a(AbsCompatRequest absCompatRequest, com.qzone.adapter.feedcomponent.s sVar) {
            String str = (String) absCompatRequest.getParam("albumId");
            boolean booleanValue = ((Boolean) absCompatRequest.getParam("filterVideo")).booleanValue();
            if (!com.qzone.album.util.d.d(sVar.getReturnCode())) {
                if (QZLog.isDevelopLevel()) {
                    QZLog.d("[PhotoAlbum]AlbumManager", 4, "onRefreshParentingPhotoListResponse failure");
                }
                a.this.f41962a.j(str);
                return true;
            }
            if (!(sVar.getData() instanceof QZoneTravelPhotoListRequest.a)) {
                return true;
            }
            QZoneTravelPhotoListRequest.a aVar = (QZoneTravelPhotoListRequest.a) sVar.getData();
            if (aVar.f43961c != null) {
                AlbumCacheData x16 = a.this.f41962a.x(0L, aVar.f43961c.albumid);
                if (x16 != null && !TextUtils.isEmpty(x16.ark_content)) {
                    AlbumCacheData albumCacheData = aVar.f43961c;
                    albumCacheData.ark_id = x16.ark_id;
                    albumCacheData.view_id = x16.view_id;
                    albumCacheData.ark_content = x16.ark_content;
                }
                if (x16 != null && !TextUtils.isEmpty(x16.ark_content_invate)) {
                    AlbumCacheData albumCacheData2 = aVar.f43961c;
                    albumCacheData2.ark_id_invate = x16.ark_id_invate;
                    albumCacheData2.view_id_invate = x16.view_id_invate;
                    albumCacheData2.ark_content_invate = x16.ark_content_invate;
                }
                a.this.f41962a.A0(aVar.f43961c.albumid, aVar.f43963e);
                a.this.f41962a.j0(aVar.f43961c);
                Object param = absCompatRequest.getParam("is_sorting_mode");
                a.this.z1(aVar.f43961c.albumid, false, param != null ? ((Boolean) param).booleanValue() : false, aVar.f43964f, booleanValue, aVar.f43959a);
            }
            sVar.setNewCnt(aVar.f43959a);
            sVar.setHasMore(aVar.f43960b);
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class d implements AbsCompatRequest.b {
        d() {
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.b
        public boolean a(AbsCompatRequest absCompatRequest, com.qzone.adapter.feedcomponent.s sVar) {
            Long l3 = (Long) absCompatRequest.getParam("face_uin");
            Long valueOf = Long.valueOf(l3 == null ? 0L : l3.longValue());
            boolean booleanValue = ((Boolean) absCompatRequest.getParam("filterVideo")).booleanValue();
            if (sVar.getData() instanceof QZonePhotoListRequest.b) {
                QZonePhotoListRequest.b bVar = (QZonePhotoListRequest.b) sVar.getData();
                if (valueOf.longValue() == 0 && bVar.f43963e != null) {
                    a.this.f41962a.f(bVar.f43963e);
                }
                if (valueOf.longValue() != 0) {
                    a.this.V0(bVar.f43963e, Boolean.FALSE);
                } else {
                    Object param = absCompatRequest.getParam("is_sorting_mode");
                    boolean booleanValue2 = param != null ? ((Boolean) param).booleanValue() : false;
                    AlbumCacheData albumCacheData = bVar.f43961c;
                    if (albumCacheData != null) {
                        a.this.z1(albumCacheData.albumid, false, booleanValue2, bVar.f43964f, booleanValue, bVar.f43959a);
                    }
                }
                sVar.setNewCnt(bVar.f43959a);
                sVar.setHasMore(bVar.f43960b);
            }
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class e implements AbsCompatRequest.b {
        e() {
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.b
        public boolean a(AbsCompatRequest absCompatRequest, com.qzone.adapter.feedcomponent.s sVar) {
            if (QZLog.isDevelopLevel()) {
                QZLog.d("[PhotoAlbum]AlbumManager", 4, "onMoreParentingListResponse ");
            }
            if (!(sVar.getData() instanceof QZoneParentingPhotoListRequest.a)) {
                return true;
            }
            QZoneParentingPhotoListRequest.a aVar = (QZoneParentingPhotoListRequest.a) sVar.getData();
            boolean booleanValue = ((Boolean) absCompatRequest.getParam("filterVideo")).booleanValue();
            if (aVar.f43963e != null) {
                a.this.f41962a.f(aVar.f43963e);
            }
            if (aVar.f43961c != null) {
                a.this.f41962a.v0(aVar.f43961c.albumid, aVar.f43965g, aVar.f43966h);
                Object param = absCompatRequest.getParam("is_sorting_mode");
                a.this.z1(aVar.f43961c.albumid, false, param != null ? ((Boolean) param).booleanValue() : false, aVar.f43964f, booleanValue, aVar.f43959a);
            }
            sVar.setNewCnt(aVar.f43959a);
            sVar.setHasMore(aVar.f43960b);
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class f implements AbsCompatRequest.b {
        f() {
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.b
        public boolean a(AbsCompatRequest absCompatRequest, com.qzone.adapter.feedcomponent.s sVar) {
            if (QZLog.isDevelopLevel()) {
                QZLog.d("[PhotoAlbum]AlbumManager", 4, "onMoreParentingListResponse ");
            }
            if (sVar.getData() instanceof QZoneTravelPhotoListRequest.a) {
                QZoneTravelPhotoListRequest.a aVar = (QZoneTravelPhotoListRequest.a) sVar.getData();
                boolean booleanValue = ((Boolean) absCompatRequest.getParam("filterVideo")).booleanValue();
                if (aVar.f43963e != null) {
                    com.qzone.album.env.common.a.m().c("[PhotoAlbum]AlbumNoShootTime", "onResult | respBean.photoDataList size:", Integer.valueOf(aVar.f43963e.size()));
                    a.this.f41962a.f(aVar.f43963e);
                }
                if (aVar.f43961c != null) {
                    a.this.f41962a.v0(aVar.f43961c.albumid, aVar.f43965g, aVar.f43966h);
                    com.qzone.album.env.common.a.m().c("[PhotoAlbum]AlbumNoShootTime", "onResult | respBean.busiParam:", aVar.f43966h + "\nrespBean.attachInfo:", aVar.f43965g);
                    Object param = absCompatRequest.getParam("is_sorting_mode");
                    a.this.z1(aVar.f43961c.albumid, false, param != null ? ((Boolean) param).booleanValue() : false, aVar.f43964f, booleanValue, aVar.f43959a);
                }
                sVar.setNewCnt(aVar.f43959a);
                sVar.setHasMore(aVar.f43960b);
            }
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class k implements AbsCompatRequest.b {
        k() {
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.b
        public boolean a(AbsCompatRequest absCompatRequest, com.qzone.adapter.feedcomponent.s sVar) {
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class l implements AbsCompatRequest.b {
        l() {
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.b
        public boolean a(AbsCompatRequest absCompatRequest, com.qzone.adapter.feedcomponent.s sVar) {
            Album album;
            if (sVar.getSucceed() && (album = (Album) absCompatRequest.getParam("album")) != null) {
                a.this.f41962a.J0(album);
                AlbumSocialInfoCacheData A = a.this.f41962a.A(album.albumid);
                if (A != null) {
                    A.albumdesc = album.desc;
                    A.albumname = album.name;
                }
                a.this.f41962a.L0(A);
                a.this.O0(2, album);
            }
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class m implements AbsCompatRequest.b {
        m() {
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.b
        public boolean a(AbsCompatRequest absCompatRequest, com.qzone.adapter.feedcomponent.s sVar) {
            if (QZLog.isDevelopLevel()) {
                QZLog.d("[PhotoAlbum]AlbumManager", 4, "onCreateAlbumResponse ");
            }
            if (sVar.getData() instanceof QZoneOptAlbumRequest.a) {
                QZoneOptAlbumRequest.a aVar = (QZoneOptAlbumRequest.a) sVar.getData();
                if (TextUtils.isEmpty(aVar.f43958a)) {
                    sVar.setSucceed(false);
                } else {
                    Album album = (Album) absCompatRequest.getParam("album");
                    if (album != null) {
                        album.albumid = aVar.f43958a;
                        ArrayList<AlbumCacheData> arrayList = new ArrayList<>();
                        AlbumCacheData createFromResponse = AlbumCacheData.createFromResponse(album);
                        if (createFromResponse != null) {
                            if (createFromResponse.isShareInvitePanding()) {
                                createFromResponse.setShareStatusToConfirm();
                            }
                            arrayList.add(createFromResponse);
                            u5.b.r0(createFromResponse.albumid, 1, LoginData.getInstance().getUin());
                            a.this.f41962a.w0(LoginData.getInstance().getUin(), arrayList, true);
                            a.this.O0(1, album);
                        }
                    }
                }
            }
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class n implements AbsCompatRequest.b {
        n() {
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.b
        public boolean a(AbsCompatRequest absCompatRequest, com.qzone.adapter.feedcomponent.s sVar) {
            if (sVar.getSucceed()) {
                try {
                    a.W().O0(4, (ArrayList) absCompatRequest.getParam("videoList"));
                } catch (Throwable unused) {
                    QZLog.e("[PhotoAlbum]AlbumManager", "mDeleteShuoShuoVideosListener case to ArrayList<String> exception! ");
                }
                QZLog.i("[PhotoAlbum]AlbumManager", "mDeleteShuoShuoVideosListener delete succeed");
            } else {
                QZLog.i("[PhotoAlbum]AlbumManager", "mDeleteShuoShuoVideosListener delete fail");
            }
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class o implements AbsCompatRequest.b {
        o() {
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.b
        public boolean a(AbsCompatRequest absCompatRequest, com.qzone.adapter.feedcomponent.s sVar) {
            if (!sVar.getSucceed()) {
                return true;
            }
            a.this.T0((String) absCompatRequest.getParam("albumId"), (ArrayList) absCompatRequest.getParam("photolist"), false, 4, ((Boolean) absCompatRequest.getParam("is_from_search_result")).booleanValue());
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class p implements AbsCompatRequest.b {
        p() {
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.b
        public boolean a(AbsCompatRequest absCompatRequest, com.qzone.adapter.feedcomponent.s sVar) {
            if (!sVar.getSucceed()) {
                return true;
            }
            a.this.T0((String) absCompatRequest.getParam("albumId"), (ArrayList) absCompatRequest.getParam("photolist"), false, 5, ((Boolean) absCompatRequest.getParam("is_from_search_result")).booleanValue());
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class q implements AbsCompatRequest.b {
        q() {
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.b
        public boolean a(AbsCompatRequest absCompatRequest, com.qzone.adapter.feedcomponent.s sVar) {
            AlbumCacheData x16;
            TravelAlbumData travelAlbumData;
            PhotoPoiArea photoPoiArea;
            if (QZLog.isDevelopLevel()) {
                QZLog.d("[PhotoAlbum]AlbumManager", 4, "onModifyPhotoListPoiResponse retcode:" + sVar.getReturnCode() + " msg:" + sVar.getMessage());
            }
            if (sVar.getSucceed()) {
                if (!((QZoneOperateTravelPhotoSceneRequest) absCompatRequest).singleNodeModify) {
                    a.this.N0(28);
                    return true;
                }
                String str = (String) absCompatRequest.getParam("albumId");
                if (TextUtils.isEmpty(str) || (x16 = a.this.f41962a.x(LoginData.getInstance().getUin(), str)) == null || (travelAlbumData = x16.travelData) == null || travelAlbumData.photoPoiAreaList == null || (photoPoiArea = (PhotoPoiArea) absCompatRequest.getParam("photoPoiArea")) == null) {
                    return true;
                }
                boolean z16 = false;
                int i3 = 0;
                while (true) {
                    if (i3 >= x16.travelData.photoPoiAreaList.size()) {
                        break;
                    }
                    PhotoPoiArea photoPoiArea2 = x16.travelData.photoPoiAreaList.get(i3);
                    if (photoPoiArea2 != null && photoPoiArea2.startShootTime == photoPoiArea.startShootTime && photoPoiArea2.endShootTime == photoPoiArea.endShootTime) {
                        x16.travelData.photoPoiAreaList.set(i3, photoPoiArea);
                        z16 = true;
                        break;
                    }
                    i3++;
                }
                if (z16) {
                    a.this.f41962a.I0(x16);
                }
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class r implements AbsCompatRequest.b {
        r() {
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.b
        public boolean a(AbsCompatRequest absCompatRequest, com.qzone.adapter.feedcomponent.s sVar) {
            if (QZLog.isDevelopLevel()) {
                QZLog.d("[PhotoAlbum]AlbumManager", 4, "onSetPhotoListTimeResponse retcode:" + sVar.getReturnCode() + " msg:" + sVar.getMessage());
            }
            a.this.N0(28);
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class s implements AbsCompatRequest.b {
        s() {
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.b
        public boolean a(AbsCompatRequest absCompatRequest, com.qzone.adapter.feedcomponent.s sVar) {
            if (QZLog.isDevelopLevel()) {
                QZLog.d("[PhotoAlbum]AlbumManager", 4, "onEditPhotoDescResponse retcode:" + sVar.getReturnCode() + " msg:" + sVar.getMessage());
            }
            boolean succeed = sVar.getSucceed();
            String str = (String) absCompatRequest.getParam("albumId");
            ArrayList arrayList = (ArrayList) absCompatRequest.getParam("photolist");
            String str2 = (String) absCompatRequest.getParam("desc");
            String str3 = (String) absCompatRequest.getParam("cacheKey");
            a.this.P0("QzoneAlbum", 9, Boolean.valueOf(succeed), str, arrayList, str2);
            if (sVar.getSucceed() && !TextUtils.isEmpty(str3)) {
                t5.a.b(str3);
            }
            a.this.N0(5);
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class t implements AbsCompatRequest.b {
        t() {
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.b
        public boolean a(AbsCompatRequest absCompatRequest, com.qzone.adapter.feedcomponent.s sVar) {
            ArrayList<LoveAlbumTimeEvent> arrayList;
            AlbumCacheData x16;
            if (QZLog.isDevelopLevel()) {
                QZLog.d("[PhotoAlbum]AlbumManager", 4, "onModifyPhotoBigEventResponse retcode:" + sVar.getReturnCode() + " msg:" + sVar.getMessage());
            }
            if (sVar.getSucceed()) {
                String str = (String) absCompatRequest.getParam("cacheKey");
                if (TextUtils.isEmpty(str)) {
                    t5.a.b(str);
                }
                AlbumCacheData albumCacheData = (AlbumCacheData) absCompatRequest.getParam("album");
                if (albumCacheData == null || (arrayList = albumCacheData.loveAlbumTimeEventList) == null || arrayList.size() <= 0 || (x16 = a.this.f41962a.x(LoginData.getInstance().getUin(), albumCacheData.albumid)) == null) {
                    return true;
                }
                Iterator<LoveAlbumTimeEvent> it = albumCacheData.loveAlbumTimeEventList.iterator();
                boolean z16 = false;
                while (it.hasNext()) {
                    LoveAlbumTimeEvent next = it.next();
                    if (next != null) {
                        TimeEvent a16 = TimeEvent.a(next);
                        TimeEvent g16 = com.qzone.album.util.a.g(x16, QZoneAlbumUtil.m(next.time));
                        if (g16 == null) {
                            x16.timeEventData.add(a16);
                        } else {
                            g16.f43881f = a16.f43881f;
                        }
                        z16 = true;
                    }
                }
                if (z16) {
                    a.this.f41962a.K0(x16);
                }
            }
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class u implements AbsCompatRequest.b {
        u() {
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.b
        public boolean a(AbsCompatRequest absCompatRequest, com.qzone.adapter.feedcomponent.s sVar) {
            if (QZLog.isDevelopLevel()) {
                QZLog.d("[PhotoAlbum]AlbumManager", 4, "onGetPhotoListByTimeLineResponse retcode:" + sVar.getReturnCode() + " msg:" + sVar.getMessage());
            }
            QZoneGetPhotoListByTimeLineRequest.a aVar = (QZoneGetPhotoListByTimeLineRequest.a) sVar.getData();
            if (aVar != null) {
                Album album = aVar.f43923b;
                if (album == null) {
                    sVar.setSucceed(false);
                    return true;
                }
                int i3 = album.total;
                synchronized (a.this.f41987z) {
                    int intValue = ((Integer) absCompatRequest.getParam("direction")).intValue();
                    if (intValue == 0) {
                        a.this.f41962a.A0(aVar.f43923b.albumid, aVar.f43922a);
                    } else if (intValue == 1) {
                        ArrayList<PhotoCacheData> B = a.this.f41962a.B(aVar.f43923b.albumid);
                        if (B != null) {
                            aVar.f43922a.addAll(B);
                        }
                        a.this.f41962a.A0(aVar.f43923b.albumid, aVar.f43922a);
                    } else if (intValue == 2) {
                        a.this.f41962a.f(aVar.f43922a);
                    }
                }
                aVar.f43929h = a.this.f41962a.B(aVar.f43923b.albumid);
                AlbumCacheDataManager albumCacheDataManager = a.this.f41962a;
                Album album2 = aVar.f43923b;
                aVar.f43930i = albumCacheDataManager.x(album2.uin, album2.albumid);
            } else {
                sVar.setSucceed(false);
            }
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class v implements AbsCompatRequest.b {
        v() {
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.b
        public boolean a(AbsCompatRequest absCompatRequest, com.qzone.adapter.feedcomponent.s sVar) {
            if (sVar.getData() instanceof QZoneQueryAlbumRequest.a) {
                QZoneQueryAlbumRequest.a aVar = (QZoneQueryAlbumRequest.a) sVar.getData();
                if (aVar.f43972a != null) {
                    a.this.f41962a.L0(aVar.f43972a);
                    a.this.f41962a.K0(aVar.f43974c);
                    if (QZLog.isColorLevel()) {
                        QZLog.d("[PhotoAlbum]AlbumManager", 2, "onQueryAlbumSocialInfo socialInfo albumname:" + aVar.f43972a.albumname);
                    }
                }
            }
            String str = (String) absCompatRequest.getParam("albumId");
            if (sVar.getReturnCode() != -11529) {
                return true;
            }
            a.this.f41962a.p(str);
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class x implements AbsCompatRequest.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f42030a;

        x(long j3) {
            this.f42030a = j3;
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.b
        public boolean a(AbsCompatRequest absCompatRequest, com.qzone.adapter.feedcomponent.s sVar) {
            if (QZLog.isDevelopLevel()) {
                QZLog.d("recentPhotoTimeLine", 4, "onGetRecentPhotoListByTimeLine retcode:" + sVar.getReturnCode() + " msg:" + sVar.getMessage());
            }
            QZoneGetRecentPhotoListByTimeLineRequest.a aVar = (QZoneGetRecentPhotoListByTimeLineRequest.a) sVar.getData();
            if (aVar != null) {
                synchronized (a.this.f41987z) {
                    int intValue = ((Integer) absCompatRequest.getParam("direction")).intValue();
                    Object[] objArr = new Object[6];
                    objArr[0] = "[Data come back] list size:";
                    objArr[1] = Integer.valueOf(aVar.f43940a.size());
                    objArr[2] = " \nhasMore:";
                    objArr[3] = Boolean.valueOf(aVar.f43943d == 1);
                    objArr[4] = " \nattachinfo:";
                    objArr[5] = aVar.f43942c;
                    QZLog.d("recentPhotoTimeLine", 4, objArr);
                    if (intValue == 0) {
                        a.this.f41962a.C0(aVar.f43940a, true);
                        AlbumTimeLineView.o(1, aVar.f43943d == 1, this.f42030a);
                        r2 = true;
                    } else if (intValue == 1) {
                        a.this.f41962a.C0(aVar.f43940a, false);
                        AlbumTimeLineView.o(intValue, aVar.f43943d == 1, this.f42030a);
                    } else if (intValue == 2) {
                        ArrayList<PhotoCacheData> U = a.this.f41962a.U(this.f42030a);
                        for (int size = aVar.f43940a.size() - 1; size >= 0; size--) {
                            U.add(0, aVar.f43940a.get(size));
                        }
                        a.this.f41962a.C0(U, true);
                        AlbumTimeLineView.o(intValue, aVar.f43943d == 1, this.f42030a);
                    }
                }
                ArrayList<AlbumCacheData> arrayList = aVar.f43941b;
                if (arrayList != null && !arrayList.isEmpty()) {
                    a.this.f41962a.B0(this.f42030a, aVar.f43941b, r2);
                }
                a aVar2 = a.this;
                aVar2.M1(aVar2.O(this.f42030a, "recentlist_all_timeline"), aVar.f43942c);
            } else {
                sVar.setSucceed(false);
            }
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class y implements AbsCompatRequest.b {
        y() {
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.b
        public boolean a(AbsCompatRequest absCompatRequest, com.qzone.adapter.feedcomponent.s sVar) {
            QZoneGetPhotoSearchRequest.a aVar;
            if (!(sVar.getData() instanceof QZoneGetPhotoSearchRequest.a) || (aVar = (QZoneGetPhotoSearchRequest.a) sVar.getData()) == null || aVar.f43931a != 0) {
                return true;
            }
            AlbumCacheData x16 = AlbumCacheDataManager.J().x(((Long) absCompatRequest.getParam("uin")).longValue(), (String) absCompatRequest.getParam("albumId"));
            x16.setPhotoSearchBox(aVar.f43933c);
            AlbumCacheDataManager.J().I0(x16);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class z implements AbsCompatRequest.b {
        z() {
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.b
        public boolean a(AbsCompatRequest absCompatRequest, com.qzone.adapter.feedcomponent.s sVar) {
            QZoneGetShareAlbumMemberDataRequest.a aVar;
            Album album;
            boolean z16;
            if ((sVar.getData() instanceof QZoneGetShareAlbumMemberDataRequest.a) && (aVar = (QZoneGetShareAlbumMemberDataRequest.a) sVar.getData()) != null && (album = aVar.f43946c) != null && aVar.f43947d != null) {
                long j3 = album.uin;
                String str = album.albumid;
                ArrayList<ShareAlbumMemberCacheData> arrayList = aVar.f43948e;
                AlbumCacheData x16 = AlbumCacheDataManager.J().x(j3, str);
                boolean I = com.qzone.reborn.configx.g.f53821a.b().I();
                if (x16 != null) {
                    z16 = false;
                } else {
                    if (!I || (x16 = AlbumCacheData.createFromResponse(aVar.f43946c)) == null) {
                        return true;
                    }
                    z16 = true;
                }
                x16.setShareAlbumMemberDataList(arrayList);
                ArrayList<client_attr> arrayList2 = aVar.f43946c.shareattrs;
                if (arrayList2 != null && arrayList2.size() >= 0) {
                    x16.sharingAlbumClientAttrArrayList = new ArrayList<>();
                    for (int i3 = 0; i3 < aVar.f43946c.shareattrs.size(); i3++) {
                        x16.sharingAlbumClientAttrArrayList.add(new SharingAlbumClientAttr(aVar.f43946c.shareattrs.get(i3)));
                    }
                } else if (aVar.f43946c.shareattrs == null) {
                    x16.sharingAlbumClientAttrArrayList = null;
                }
                if (z16) {
                    AlbumCacheDataManager.J().a(x16, j3);
                } else {
                    AlbumCacheDataManager.J().I0(x16);
                }
            }
            return true;
        }
    }

    a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean L0(AbsCompatRequest absCompatRequest, com.qzone.adapter.feedcomponent.s sVar, int i3, long j3, boolean z16, int i16, long j16, int i17, QzoneAlbumRecentAllPhotoRequest.a aVar) {
        ArrayList<PhotoCacheData> arrayList;
        if (aVar.f43985h != 0 && (arrayList = aVar.f43981d) != null && arrayList.isEmpty() && System.currentTimeMillis() - j16 < 360000) {
            T(new QZoneAlbumRequestBuilder().setUin(j3).setFirstStartTimeStamp(j16), absCompatRequest.getCallback());
            return true;
        }
        new Bundle().putString("ALBUM_ATTACH_INFO", aVar.f43983f);
        if (z16) {
            sVar.getBundle().putSerializable("response", absCompatRequest.rsp);
        }
        sVar.setHasMore(aVar.f43985h != 0);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean M0(AbsCompatRequest absCompatRequest, com.qzone.adapter.feedcomponent.s sVar, int i3, long j3, boolean z16, int i16, long j16, int i17, QzoneAlbumRecentAllPhotoRequest.a aVar) {
        ArrayList<PhotoCacheData> arrayList;
        if (aVar.f43985h != 0 && (arrayList = aVar.f43981d) != null && arrayList.isEmpty() && System.currentTimeMillis() - j16 < 360000) {
            U(new QZoneAlbumRequestBuilder().setUin(j3).setEntranceType(i17).setFirstStartTimeStamp(j16), absCompatRequest.getCallback());
            return true;
        }
        Bundle bundle = new Bundle();
        sVar.getBundle().putSerializable("response", absCompatRequest.rsp);
        sVar.setData(bundle);
        sVar.setHasMore(aVar.f43985h != 0);
        sVar.setSucceed(true);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M1(String str, String str2) {
        u4.a.z().h0(str, str2);
    }

    private String N(String str) {
        return u4.a.z().L(str, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String O(long j3, String str) {
        return "album_attachinfo_" + str + "_" + j3;
    }

    private void Q(long j3, Map<Integer, GetCategoryDetailReqItem> map, boolean z16, boolean z17, AbsCompatRequest.a aVar) {
        Iterator<Map.Entry<Integer, GetCategoryDetailReqItem>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            QZLog.d("[PhotoAlbum]", 1, "page_str:", it.next().getValue().page_str);
        }
        QZoneGetCategoryDetailReq qZoneGetCategoryDetailReq = new QZoneGetCategoryDetailReq(j3, map);
        qZoneGetCategoryDetailReq.addParam("from_picture_viewer", Boolean.valueOf(z17)).setGetMore(z16).setCallback(aVar).setOnJceParseListener(this.F);
        M().c(qZoneGetCategoryDetailReq, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T0(String str, ArrayList<String> arrayList, boolean z16, int i3, boolean z17) {
        if (TextUtils.isEmpty(str) || arrayList == null || arrayList.size() <= 0) {
            return;
        }
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            this.f41962a.q(next, str);
            if (z17) {
                this.f41962a.r(next, str);
            }
        }
        x1(str, z16);
        O0(i3, str, arrayList);
        if (z17) {
            Q0(str, false);
        }
    }

    private void U0(Object... objArr) {
        com.qzone.adapter.feedcomponent.e.a(u4.a.z().E(), 3, objArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V0(Object... objArr) {
        com.qzone.adapter.feedcomponent.e.a(u4.a.z().E(), 6, objArr);
    }

    public static final a W() {
        return aq.f42006a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W0(Object... objArr) {
        com.qzone.adapter.feedcomponent.e.a(u4.a.z().E(), 23, objArr);
    }

    private String X(long j3) {
        if (TextUtils.isEmpty(N(O(j3, "layer_recentlist_all")))) {
            return N(O(j3, "recentlist_all"));
        }
        return N(O(j3, "layer_recentlist_all"));
    }

    private void X0() {
        com.qzone.adapter.feedcomponent.e.a(u4.a.z().E(), 22, null);
    }

    private String Y(long j3) {
        if (TextUtils.isEmpty(N(O(j3, "layer_recentlist_all_timeline")))) {
            return N(O(j3, "recentlist_all_timeline"));
        }
        return N(O(j3, "layer_recentlist_all_timeline"));
    }

    private String Z(long j3) {
        if (TextUtils.isEmpty(N(O(j3, "layer_recent_videolist_all")))) {
            return N(O(j3, "videolist_all"));
        }
        RFWLog.d("[PhotoAlbum]AlbumManager", RFWLog.CLR, "getLayerRecentVideoAttachInfo " + N(O(j3, "layer_recent_videolist_all")));
        return N(O(j3, "layer_recent_videolist_all"));
    }

    public static RecomAlbumList a1(Map<Integer, byte[]> map) {
        RecomAlbumList recomAlbumList = new RecomAlbumList();
        recomAlbumList.parsedFromFeature(map, QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, QzoneConfig.SECONDARY_KEY_ALBUM_DETAIL_RECOM_UPPER_BOUND, 99), QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, QzoneConfig.SECONDARY_KEY_ALBUM_DETAIL_RECOM_DOWNNER_BOUND, 2));
        return recomAlbumList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c1(int i3, long j3, QzoneAlbumRecentAllPhotoRequest.a aVar) {
        ArrayList<PhotoCategoryControlInfo> arrayList = aVar.f43979b;
        if (arrayList != null) {
            if (arrayList.isEmpty()) {
                u4.a.z().f0("photocategory_data_error_" + j3, true);
            } else {
                Iterator<PhotoCategoryControlInfo> it = aVar.f43979b.iterator();
                while (it.hasNext()) {
                    ArrayList<String> arrayList2 = it.next().categoryCoverUrl;
                    if (arrayList2 == null || arrayList2.isEmpty()) {
                        u4.a.z().f0("photocategory_data_error_" + j3, true);
                    }
                }
            }
            Iterator<PhotoCategoryControlInfo> it5 = aVar.f43979b.iterator();
            while (it5.hasNext()) {
                it5.next().uin = j3;
            }
            if (aVar.f43979b.isEmpty() || i3 != 10) {
                return;
            }
            this.f41962a.x0(j3, aVar.f43979b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d1(int i3, long j3, int i16, QzoneAlbumRecentAllPhotoRequest.a aVar) {
        ArrayList<PhotoCacheData> arrayList = aVar.f43981d;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        boolean z16 = i3 == 10 && i16 == 0;
        this.f41962a.C0(aVar.f43981d, z16);
        ArrayList<AlbumCacheData> arrayList2 = aVar.f43980c;
        if (arrayList2 == null || arrayList2.isEmpty()) {
            return;
        }
        this.f41962a.B0(j3, aVar.f43980c, z16);
    }

    private void i1(long j3, String str, int i3, String str2, boolean z16, HashMap<String, String> hashMap, AbsCompatRequest.a aVar) {
        QZoneAlbumListRequest qZoneAlbumListRequest = new QZoneAlbumListRequest(j3, i3, str2, z16, hashMap);
        qZoneAlbumListRequest.setOnJceParseListener(this.f41966e);
        qZoneAlbumListRequest.setCallback(aVar);
        M().c(qZoneAlbumListRequest, str);
    }

    private boolean p() {
        return this.f41963b >= 1;
    }

    public void B(String str, ArrayList<String> arrayList, ArrayList<String> arrayList2, AbsCompatRequest.a aVar, boolean z16) {
        QZoneDelBatchPhotosRequest qZoneDelBatchPhotosRequest = new QZoneDelBatchPhotosRequest(str, arrayList, arrayList2);
        qZoneDelBatchPhotosRequest.addParam("albumId", str).addParam("photolist", arrayList).addParam("is_from_search_result", Boolean.valueOf(z16)).setCallback(aVar).setOnJceParseListener(this.f41984w);
        M().c(qZoneDelBatchPhotosRequest, null);
    }

    public void D(String str, String str2) {
        AlbumCacheDataManager albumCacheDataManager;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (albumCacheDataManager = this.f41962a) == null) {
            return;
        }
        albumCacheDataManager.q(str, str2);
        x1(str2, false);
    }

    public void E1() {
        X0();
    }

    public void F0(long j3, int i3, ApplyJoinShareAlbum applyJoinShareAlbum, AllowJoinShareAlbum allowJoinShareAlbum, AbsCompatRequest.a aVar) {
        QZoneJoinShareAlbumRequest qZoneJoinShareAlbumRequest = new QZoneJoinShareAlbumRequest(j3, i3, applyJoinShareAlbum, allowJoinShareAlbum);
        qZoneJoinShareAlbumRequest.setCallback(aVar).setOnJceParseListener(new aa());
        M().c(qZoneJoinShareAlbumRequest, null);
    }

    public void G(String str, ArrayList<String> arrayList, EditPhoto editPhoto, int i3, Map<Integer, String> map, String str2, AbsCompatRequest.a aVar) {
        QZoneAlbumSortPhotoRequest qZoneAlbumSortPhotoRequest = new QZoneAlbumSortPhotoRequest(str, arrayList, editPhoto, i3, map, null);
        qZoneAlbumSortPhotoRequest.addParam("cacheKey", str2).addParam("albumId", str).addParam("photolist", arrayList).setCallback(aVar).setOnJceParseListener(this.B);
        if (editPhoto != null) {
            qZoneAlbumSortPhotoRequest.addParam("desc", editPhoto.desc);
        }
        M().c(qZoneAlbumSortPhotoRequest, null);
    }

    public void G0(long j3, Map<Integer, ListAllCategoryReqItem> map, boolean z16, AbsCompatRequest.a aVar) {
        QZoneListAllCategoryReq qZoneListAllCategoryReq = new QZoneListAllCategoryReq(j3, map, z16);
        qZoneListAllCategoryReq.setOnJceParseListener(this.E);
        qZoneListAllCategoryReq.setCallback(aVar);
        M().c(qZoneListAllCategoryReq, null);
    }

    public void H(String str, ArrayList<String> arrayList, int i3, HashMap<Integer, String> hashMap, AbsCompatRequest.a aVar) {
        QZoneAlbumSortPhotoRequest qZoneAlbumSortPhotoRequest = new QZoneAlbumSortPhotoRequest(str, arrayList, i3, hashMap);
        qZoneAlbumSortPhotoRequest.setCallback(aVar);
        M().c(qZoneAlbumSortPhotoRequest, null);
    }

    public void H0(String str, PhotoPoiArea photoPoiArea, long j3, ArrayList<modify_travel_photo_scence> arrayList, Map<String, EditPhoto> map, boolean z16, AbsCompatRequest.a aVar) {
        QZoneOperateTravelPhotoSceneRequest qZoneOperateTravelPhotoSceneRequest = new QZoneOperateTravelPhotoSceneRequest(str, 2, photoPoiArea, j3, arrayList, map);
        qZoneOperateTravelPhotoSceneRequest.singleNodeModify = z16;
        qZoneOperateTravelPhotoSceneRequest.addParam("albumId", str).addParam("photoPoiArea", photoPoiArea).setCallback(aVar).setOnJceParseListener(this.A);
        M().c(qZoneOperateTravelPhotoSceneRequest, null);
    }

    public void J0(String str, String str2, ArrayList<String> arrayList, AbsCompatRequest.a aVar, boolean z16) {
        QZoneMoveBatchPhotosRequest qZoneMoveBatchPhotosRequest = new QZoneMoveBatchPhotosRequest(str, str2, arrayList);
        qZoneMoveBatchPhotosRequest.addParam("albumId", str).addParam("photolist", arrayList).addParam("BATCH_MOVE_DEST_ALBUM", str2).addParam("is_from_search_result", Boolean.valueOf(z16)).setCallback(aVar).setOnJceParseListener(this.f41985x);
        M().c(qZoneMoveBatchPhotosRequest, null);
    }

    public void J1(long j3, boolean z16, int i3) {
        Y0(this.f41962a.V(j3, i3), Boolean.valueOf(z16), this.f41962a.x(j3, String.valueOf(j3)));
    }

    public void K1(long j3, RecommendPhotos recommendPhotos, AbsCompatRequest.a aVar) {
        QZoneReportP2VRecommendedRequest qZoneReportP2VRecommendedRequest = new QZoneReportP2VRecommendedRequest(j3, recommendPhotos);
        qZoneReportP2VRecommendedRequest.setCallback(aVar);
        M().c(qZoneReportP2VRecommendedRequest, null);
    }

    public int[] L(long j3) {
        String[] split;
        String N = N(O(j3, "album_count_info"));
        if (N != null && !N.equals("") && (split = N.split(ContainerUtils.FIELD_DELIMITER)) != null && split.length == 3) {
            try {
                int[] iArr = new int[3];
                for (int i3 = 0; i3 < 3; i3++) {
                    iArr[i3] = Integer.valueOf(split[i3]).intValue();
                }
                return iArr;
            } catch (Exception e16) {
                QZLog.e("[PhotoAlbum]AlbumManager", "Error in casting album count info", e16);
            }
        }
        return null;
    }

    public com.qzone.album.base.Service.b M() {
        return u4.a.z().D();
    }

    public void N1(long j3, String str, int i3, AbsCompatRequest.a aVar) {
        QZoneSetPhotoListSortTypeRequest qZoneSetPhotoListSortTypeRequest = new QZoneSetPhotoListSortTypeRequest(j3, str, i3);
        qZoneSetPhotoListSortTypeRequest.setCallback(aVar);
        M().c(qZoneSetPhotoListSortTypeRequest, null);
    }

    public void O0(int i3, Object... objArr) {
        com.qzone.adapter.feedcomponent.e.a(u4.a.z().E(), i3, objArr);
    }

    public void O1(long j3, int i3, String str, ArrayList<String> arrayList, String str2, int i16, AbsCompatRequest.a aVar) {
        QzoneShareToOutsiteRequest qzoneShareToOutsiteRequest = new QzoneShareToOutsiteRequest(j3, i3, str, arrayList, str2);
        qzoneShareToOutsiteRequest.addParam("key_from_share_type", Integer.valueOf(i16)).setCallback(aVar);
        M().c(qzoneShareToOutsiteRequest, null);
    }

    public void P0(String str, int i3, Object... objArr) {
        EventCenter.getInstance().post(str, i3, objArr);
    }

    public void P1(String str, ArrayList<String> arrayList, EditPhoto editPhoto, int i3, Map<Integer, String> map, Map<String, EditPhoto> map2, AbsCompatRequest.a aVar) {
        QZoneAlbumSortPhotoRequest qZoneAlbumSortPhotoRequest = new QZoneAlbumSortPhotoRequest(str, arrayList, editPhoto, i3, map, map2);
        qZoneAlbumSortPhotoRequest.setCallback(aVar).setOnJceParseListener(new r());
        M().c(qZoneAlbumSortPhotoRequest, null);
    }

    public void Q0(String str, boolean z16) {
        AlbumCacheDataManager albumCacheDataManager;
        if (QZLog.isColorLevel()) {
            QZLog.d("[PhotoAlbum]AlbumManager", 2, "onAlbumSearchPhotoResultChanged| albumId:" + str + " needRefreshFromNet:" + z16);
        }
        if (TextUtils.isEmpty(str) || (albumCacheDataManager = this.f41962a) == null) {
            return;
        }
        com.qzone.adapter.feedcomponent.e.a(u4.a.z().E(), 29, new Object[]{albumCacheDataManager.E(str), Boolean.valueOf(z16)});
    }

    public void Q1(long j3, String str, String str2, Map<Integer, String> map, AbsCompatRequest.a aVar) {
        QZonePhotoListRequest qZonePhotoListRequest = new QZonePhotoListRequest(j3, str, 0, 1, str2, null, 0L, map, false, 0, null);
        qZonePhotoListRequest.setCallback(aVar).setOnJceParseListener(new al());
        M().c(qZonePhotoListRequest, null);
    }

    public void R0() {
        this.f41963b++;
    }

    public void S(AbsCompatRequest.a aVar) {
        QzoneQBossAdvRequest qzoneQBossAdvRequest = new QzoneQBossAdvRequest(LoginData.getInstance().getUin(), 2618, true);
        qzoneQBossAdvRequest.setOnJceParseListener(this.I).setCallback(aVar);
        M().c(qzoneQBossAdvRequest, null);
    }

    public void S0() {
        this.f41963b--;
    }

    public void Y0(Object... objArr) {
        com.qzone.adapter.feedcomponent.e.a(u4.a.z().E(), 1001, objArr);
    }

    public void Z0(long j3, int i3, MarkFaceItemFeed markFaceItemFeed, MarkFaceItemMood markFaceItemMood, AbsCompatRequest.a aVar) {
        QzoneFaceOperationRequest qzoneFaceOperationRequest = new QzoneFaceOperationRequest(j3, i3, markFaceItemFeed, markFaceItemMood);
        qzoneFaceOperationRequest.setCallback(aVar).setOnJceParseListener(new k());
        M().c(qzoneFaceOperationRequest, null);
    }

    public void b1(Handler handler, PhotoCacheData photoCacheData, int i3) {
        u4.a.z().d0(handler, photoCacheData, i3);
    }

    public void e1(String str, String str2, AbsCompatRequest.a aVar) {
        f1(str, str2, TextUtils.isEmpty(str) ? 1 : 0, aVar);
    }

    public void h1(String str, AbsCompatRequest.a aVar) {
        QZoneQueryAlbumRequest qZoneQueryAlbumRequest = new QZoneQueryAlbumRequest(str, TextUtils.isEmpty(str) ? 1 : 0);
        qZoneQueryAlbumRequest.setTimeout(5000).setCallback(aVar);
        M().c(qZoneQueryAlbumRequest, null);
    }

    public void j1(long j3, String str, int i3, HashMap<String, String> hashMap, AbsCompatRequest.a aVar) {
        i1(j3, str, i3, "", false, hashMap, aVar);
    }

    public void n1(long j3, String str, String str2, int i3, String str3, long j16, Map<Integer, String> map, String str4, boolean z16, AbsCompatRequest.a aVar, int i16, boolean z17) {
        QZonePhotoListRequest qZonePhotoListRequest = new QZonePhotoListRequest(j3, str, 0, 40, str2, str3, j16, map, str4, z16, i3, null, i16);
        qZonePhotoListRequest.addParam("face_uin", Long.valueOf(j16)).addParam("albumId", str).addParam("filterVideo", Boolean.valueOf(z17)).setOnJceParseListener(this.f41971j).setCallback(aVar);
        M().c(qZonePhotoListRequest, null);
    }

    public void p0(long j3, String str, Map<Long, Long> map, int i3, String str2, String str3, int i16, int i17, int i18, int i19, Map<Integer, String> map2, int i26, int i27, AbsCompatRequest.a aVar) {
        QZoneGetPhotoListByTimeLineRequest qZoneGetPhotoListByTimeLineRequest = new QZoneGetPhotoListByTimeLineRequest(j3, str, map, i3, str2, str3, i16, i17, i18, i19, map2);
        qZoneGetPhotoListByTimeLineRequest.addParam("direction", Integer.valueOf(i26)).addParam("photoOffset", Integer.valueOf(i27)).setCallback(aVar).setOnJceParseListener(new u());
        M().c(qZoneGetPhotoListByTimeLineRequest, null);
    }

    public AbsCompatRequest q(long j3, ArrayList<float[]> arrayList, AbsCompatRequest.a aVar, boolean z16) {
        QZoneCategoryIdentifyBatchReq qZoneCategoryIdentifyBatchReq = new QZoneCategoryIdentifyBatchReq(j3, arrayList, z16);
        qZoneCategoryIdentifyBatchReq.setCallback(aVar);
        M().c(qZoneCategoryIdentifyBatchReq, null);
        return qZoneCategoryIdentifyBatchReq;
    }

    public void q0(long j3, String str, int i3, ArrayList<Integer> arrayList, Map<Integer, PhotoSearchBoxChosenItem> map, String str2, AbsCompatRequest.a aVar) {
        QZoneGetPhotoSearchRequest qZoneGetPhotoSearchRequest = new QZoneGetPhotoSearchRequest(j3, str, i3, arrayList, map, str2);
        qZoneGetPhotoSearchRequest.setCallback(aVar).addParam("uin", Long.valueOf(j3)).addParam("albumId", str).setOnJceParseListener(new y());
        M().c(qZoneGetPhotoSearchRequest, null);
    }

    public void r(long j3, String str, ArrayList<String> arrayList, AbsCompatRequest.a aVar) {
        com.qzone.album.env.common.a.m().c("[PhotoAlbum]aioSendPhotos", "batchQueryMd5");
        QzoneGetPicContInfoRequest qzoneGetPicContInfoRequest = new QzoneGetPicContInfoRequest(j3, arrayList);
        qzoneGetPicContInfoRequest.addParam("albumId", str).setCallback(aVar).setOnJceParseListener(this.J);
        M().c(qzoneGetPicContInfoRequest, null);
    }

    public void r0(AbsCompatRequest.a aVar) {
        QzoneQBossAdvRequest qzoneQBossAdvRequest = new QzoneQBossAdvRequest(LoginData.getInstance().getUin(), 2534);
        qzoneQBossAdvRequest.setOnJceParseListener(this.I).setCallback(aVar);
        M().c(qzoneQBossAdvRequest, null);
    }

    public void s(long j3, int i3, PhotoCategorySummaryInfo photoCategorySummaryInfo, String str, String str2, AbsCompatRequest.a aVar) {
        category_face_confirm_info category_face_confirm_infoVar = new category_face_confirm_info();
        category_face_confirm_infoVar.f25035op = i3;
        if (!TextUtils.isEmpty(str)) {
            try {
                category_face_confirm_infoVar.uin = Long.parseLong(str);
            } catch (Exception e16) {
                QZLog.e("[PhotoAlbum]AlbumManager", 2, e16, new Object[0]);
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            photoCategorySummaryInfo.nick = str2;
            category_face_confirm_infoVar.label = str2;
        }
        CategoryOpReq categoryOpReq = new CategoryOpReq();
        categoryOpReq.op_uin = j3;
        categoryOpReq.f25024op = i3;
        HashMap hashMap = new HashMap();
        categoryOpReq.category_groupids = hashMap;
        hashMap.put(photoCategorySummaryInfo.categoryId, photoCategorySummaryInfo.groupid_list);
        HashMap hashMap2 = new HashMap();
        categoryOpReq.groupid_confirm_info = hashMap2;
        hashMap2.put(photoCategorySummaryInfo.categoryId, category_face_confirm_infoVar);
        QZoneCategoryOpReq qZoneCategoryOpReq = new QZoneCategoryOpReq(categoryOpReq);
        qZoneCategoryOpReq.addParam("operationType", Integer.valueOf(i3));
        qZoneCategoryOpReq.addParam("nick", str2);
        qZoneCategoryOpReq.addParam("categorySummaryInfo", photoCategorySummaryInfo);
        qZoneCategoryOpReq.setCallback(aVar);
        qZoneCategoryOpReq.setOnJceParseListener(this.G);
        M().c(qZoneCategoryOpReq, null);
    }

    public void s0(boolean z16, AbsCompatRequest.a aVar) {
        QzoneQBossAdvRequest qzoneQBossAdvRequest = new QzoneQBossAdvRequest(LoginData.getInstance().getUin(), z16 ? 2493 : 2492, true);
        qzoneQBossAdvRequest.setOnJceParseListener(this.I).setCallback(aVar).addParam("key_is_guest_mode", Boolean.valueOf(z16));
        M().c(qzoneQBossAdvRequest, null);
    }

    public void t(long j3, int i3, Map<String, ArrayList<s_picdata>> map, PhotoCategorySummaryInfo photoCategorySummaryInfo, AbsCompatRequest.a aVar) {
        CategoryOpReq categoryOpReq = new CategoryOpReq();
        categoryOpReq.op_uin = j3;
        categoryOpReq.f25024op = i3;
        categoryOpReq.groupid_photos = map;
        HashMap hashMap = new HashMap();
        categoryOpReq.category_groupids = hashMap;
        hashMap.put(photoCategorySummaryInfo.categoryId, photoCategorySummaryInfo.groupid_list);
        ArrayList arrayList = new ArrayList();
        if (map != null) {
            Iterator<Map.Entry<String, ArrayList<s_picdata>>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Iterator<s_picdata> it5 = it.next().getValue().iterator();
                while (it5.hasNext()) {
                    arrayList.add(it5.next().lloc);
                }
            }
        }
        QZoneCategoryOpReq qZoneCategoryOpReq = new QZoneCategoryOpReq(categoryOpReq);
        qZoneCategoryOpReq.addParam("photolist", arrayList);
        qZoneCategoryOpReq.addParam("categorySummaryInfo", photoCategorySummaryInfo);
        qZoneCategoryOpReq.addParam("operationType", Integer.valueOf(i3));
        qZoneCategoryOpReq.setCallback(aVar);
        qZoneCategoryOpReq.setOnJceParseListener(this.H);
        M().c(qZoneCategoryOpReq, null);
    }

    public void t0(AbsCompatRequest.a aVar) {
        QzoneQBossAdvRequest qzoneQBossAdvRequest = new QzoneQBossAdvRequest(LoginData.getInstance().getUin(), 2516, true);
        qzoneQBossAdvRequest.setOnJceParseListener(this.I).setCallback(aVar);
        M().c(qzoneQBossAdvRequest, null);
    }

    public void u(long j3) {
        M1(O(j3, "layer_recentlist_all"), "");
    }

    public AbsCompatRequest u0(String str, long j3, String str2, String str3, String str4, int i3, int i16, int i17, String str5, Map<Integer, String> map, AbsCompatRequest.a aVar) {
        QZoneQunViewPhotoRequest qZoneQunViewPhotoRequest = new QZoneQunViewPhotoRequest(str, j3, str2, str3, 100, 100, str4, i3, i16, i17, str5, map);
        qZoneQunViewPhotoRequest.setCallback(aVar);
        M().c(qZoneQunViewPhotoRequest, null);
        return qZoneQunViewPhotoRequest;
    }

    public void v(long j3) {
        M1(O(j3, "layer_recentlist_all_timeline"), "");
    }

    public AbsCompatRequest v0(long j3, String str, String str2, int i3, String str3, AbsCompatRequest.a aVar) {
        QzoneGetPhotoCommentRequest qzoneGetPhotoCommentRequest = new QzoneGetPhotoCommentRequest(j3, str, str2, i3, str3);
        qzoneGetPhotoCommentRequest.setCallback(aVar);
        M().c(qzoneGetPhotoCommentRequest, null);
        return qzoneGetPhotoCommentRequest;
    }

    public void w(long j3) {
        RFWLog.d("[PhotoAlbum]AlbumManager", RFWLog.CLR, "clearRecentVideoAttachInfoWhenExitLayer");
        M1(O(j3, "layer_recent_videolist_all"), "");
    }

    public int w1(String str, boolean z16, boolean z17, RecomAlbumList recomAlbumList, boolean z18) {
        ArrayList<PhotoCacheData> B;
        if (QZLog.isColorLevel()) {
            QZLog.d("[PhotoAlbum]AlbumManager", 2, "refreshPhotoLocalCache| albumId:" + str + " needRefreshFromNet:" + z16 + " isSortingMode:" + z17);
        }
        if (z18) {
            B = this.f41962a.D(str, false);
        } else {
            B = this.f41962a.B(str);
        }
        U0(B, Boolean.valueOf(z16), this.f41962a.x(0L, str), recomAlbumList);
        if (B != null) {
            return B.size();
        }
        return 0;
    }

    public void x0(long j3, String str, AbsCompatRequest.a aVar) {
        QZoneGetShareAlbumMemberDataRequest qZoneGetShareAlbumMemberDataRequest = new QZoneGetShareAlbumMemberDataRequest(j3, str);
        qZoneGetShareAlbumMemberDataRequest.setCallback(aVar).setOnJceParseListener(new z());
        M().c(qZoneGetShareAlbumMemberDataRequest, null);
    }

    public void z(Album album, String str, String str2, int i3, String str3, boolean z16, AbsCompatRequest.a aVar) {
        QZoneOptAlbumRequest qZoneOptAlbumRequest = new QZoneOptAlbumRequest(QZoneOptAlbumRequest.FIELD_CMD_CREATE, album, "", str2, 1, i3, str3, z16);
        qZoneOptAlbumRequest.addParam("album", album).setCallback(aVar).setOnJceParseListener(this.f41982u);
        M().c(qZoneOptAlbumRequest, str);
    }

    public void z0(long j3, String str, String str2, int i3, String str3, String str4, long j16, Map<Integer, String> map, int i16, boolean z16, AbsCompatRequest.a aVar, int i17, long j17) {
        if (QZLog.isDevelopLevel()) {
            QZLog.d("[PhotoAlbum]AlbumManager", 4, "getSharerMorePhotoList albymThemeType=" + i16);
        }
        y0(j3, str, str2, i3, str3, str4, j16, map, z16, aVar, i17, j17);
    }

    public void z1(String str, boolean z16, boolean z17, RecomAlbumList recomAlbumList, boolean z18, int i3) {
        int w16 = w1(str, z16, z17, recomAlbumList, z18);
        if (!z18 || i3 == 0) {
            return;
        }
        HashMap hashMap = new HashMap(1);
        if (w16 == 0 && i3 > 0) {
            hashMap.put("allVideo", String.valueOf(1));
        } else {
            hashMap.put("notAllVideo", String.valueOf(1));
        }
        ReportUtils.b("aioSendPhoto", hashMap);
    }

    private void C1(long j3, String str, Long l3, int i3, int i16, AbsCompatRequest.a aVar, AbsCompatRequest.b bVar) {
        QzoneAlbumRecentAllPhotoRequest qzoneAlbumRecentAllPhotoRequest = new QzoneAlbumRecentAllPhotoRequest(j3, "", 1, i16, i3, true);
        qzoneAlbumRecentAllPhotoRequest.addParam(PhotoCacheData.OWNER_UIN, Long.valueOf(j3)).setOnJceParseListener(bVar).setGetMore(false);
        qzoneAlbumRecentAllPhotoRequest.addParam("video_type", Integer.valueOf(i3));
        if (l3 != null) {
            qzoneAlbumRecentAllPhotoRequest.addParam("first_start_timestamp", l3);
        } else {
            qzoneAlbumRecentAllPhotoRequest.addParam("first_start_timestamp", Long.valueOf(System.currentTimeMillis()));
        }
        qzoneAlbumRecentAllPhotoRequest.addParam("key_entrance_type", Integer.valueOf(i16));
        qzoneAlbumRecentAllPhotoRequest.setCallback(aVar);
        M().c(qzoneAlbumRecentAllPhotoRequest, null);
    }

    public void F(Album album, String str, String str2, String str3, byte b16, AbsCompatRequest.a aVar) {
        QZoneOptAlbumRequest qZoneOptAlbumRequest = new QZoneOptAlbumRequest(QZoneOptAlbumRequest.FIELD_CMD_EDIT, album, str, str3, (QZoneAlbumUtil.r(album.type) == 1 && TextUtils.isEmpty(str3)) ? 1 : 0, -1111, null, false);
        qZoneOptAlbumRequest.setTimeout(10000);
        qZoneOptAlbumRequest.addParam("album", album).setCallback(aVar);
        if (b16 != 1) {
            qZoneOptAlbumRequest.setOnJceParseListener(this.f41981t);
        }
        M().c(qZoneOptAlbumRequest, str2);
    }

    public void N0(int i3) {
        O0(i3, null);
    }

    public void a0(long j3, int i3, HashMap<String, String> hashMap, AbsCompatRequest.a aVar) {
        i1(j3, null, i3, N(O(j3, "albumlist")), true, hashMap, aVar);
    }

    public void l1(long j3, String str, ArrayList<Integer> arrayList, Map<Integer, PhotoSearchBoxChosenItem> map, String str2, AbsCompatRequest.a aVar) {
        QZoneGetPhotoSearchRequest qZoneGetPhotoSearchRequest = new QZoneGetPhotoSearchRequest(j3, str, 2, arrayList, map, str2);
        qZoneGetPhotoSearchRequest.addParam("albumId", str).addParam(PhotoCacheData.OWNER_UIN, Long.valueOf(j3)).setOnJceParseListener(this.f41968g).setCallback(aVar);
        M().c(qZoneGetPhotoSearchRequest, null);
    }

    public void n0(long j3, String str, String str2, Map<Integer, String> map, boolean z16, AbsCompatRequest.a aVar, int i3, boolean z17) {
        Map<Integer, String> map2;
        String str3;
        AlbumCacheData albumCacheData = new AlbumCacheData();
        byte[] bArr = (byte[]) this.f41962a.y(j3, str, AlbumCacheData.TRAVEL_DATA);
        if (bArr != null) {
            try {
                Parcel obtain = Parcel.obtain();
                obtain.unmarshall(bArr, 0, bArr.length);
                obtain.setDataPosition(0);
                albumCacheData.travelData = (TravelAlbumData) ParcelableWrapper.createDataFromParcel(obtain);
                OaidMonitor.parcelRecycle(obtain);
            } catch (Exception e16) {
                QZLog.w(e16);
            }
        }
        TravelAlbumData travelAlbumData = albumCacheData.travelData;
        if (travelAlbumData != null) {
            String str4 = travelAlbumData.attach_info;
            map2 = map == null ? travelAlbumData.busi_param : map;
            str3 = str4;
        } else {
            map2 = map;
            str3 = null;
        }
        if (QZLog.isColorLevel()) {
            com.qzone.album.env.common.a.m().c("[PhotoAlbum]AlbumNoShootTime", "getMoreTravellingPhotoList | busiParam:", map2 + "\nattachInfo:", str3);
        }
        QZoneTravelPhotoListRequest qZoneTravelPhotoListRequest = new QZoneTravelPhotoListRequest(j3, str, str3, str2, map2, i3);
        qZoneTravelPhotoListRequest.addParam("is_sorting_mode", Boolean.valueOf(z16)).addParam("filterVideo", Boolean.valueOf(z17)).setCallback(aVar).setOnJceParseListener(this.f41976o);
        M().c(qZoneTravelPhotoListRequest, null);
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class g implements AbsCompatRequest.b {
        g() {
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.b
        public boolean a(AbsCompatRequest absCompatRequest, com.qzone.adapter.feedcomponent.s sVar) {
            Integer num = (Integer) absCompatRequest.getParam("orig_task_type");
            int intValue = num != null ? num.intValue() : 11;
            long longValue = ((Long) absCompatRequest.getParam(PhotoCacheData.OWNER_UIN)).longValue();
            Boolean bool = (Boolean) absCompatRequest.getParam("from_picture_viewer");
            boolean booleanValue = bool != null ? bool.booleanValue() : false;
            Integer num2 = (Integer) absCompatRequest.getParam("refresh_cache_count");
            int intValue2 = (num2 == null || num2.intValue() <= 0) ? 0 : num2.intValue();
            long currentTimeMillis = System.currentTimeMillis();
            Long l3 = (Long) absCompatRequest.getParam("first_start_timestamp");
            if (l3 != null && l3.longValue() < currentTimeMillis) {
                currentTimeMillis = l3.longValue();
            }
            int intValue3 = ((Integer) absCompatRequest.getParam("key_entrance_type")).intValue();
            if (sVar.getData() == null) {
                return true;
            }
            QzoneAlbumRecentAllPhotoRequest.a aVar = (QzoneAlbumRecentAllPhotoRequest.a) sVar.getData();
            if (aVar != null) {
                a aVar2 = a.this;
                aVar2.M1(aVar2.O(longValue, "layer_recentlist_all"), aVar.f43983f);
            }
            return !a.this.L0(absCompatRequest, sVar, intValue, longValue, booleanValue, intValue2, currentTimeMillis, intValue3, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean K0(AbsCompatRequest absCompatRequest, com.qzone.adapter.feedcomponent.s sVar, int i3, long j3, boolean z16, int i16, long j16, int i17, QzoneAlbumRecentAllPhotoRequest.a aVar) {
        com.qzone.adapter.feedcomponent.s sVar2;
        int size;
        ArrayList<PhotoCacheData> arrayList;
        boolean z17 = true;
        if (aVar.f43985h != 0 && (arrayList = aVar.f43981d) != null && arrayList.isEmpty() && System.currentTimeMillis() - j16 < 360000) {
            l0(j3, z16, Integer.valueOf(i3), Integer.valueOf(((QZoneResult) sVar.a()).what), Integer.valueOf(i16), Long.valueOf(j16), i17, absCompatRequest.getCallback());
            return true;
        }
        if (i3 == 10 && aVar.f43985h != 0 && aVar.f43981d != null && System.currentTimeMillis() - j16 < 360000 && (size = i16 + aVar.f43981d.size()) < 15) {
            l0(j3, z16, Integer.valueOf(i3), Integer.valueOf(((QZoneResult) sVar.a()).what), Integer.valueOf(size), Long.valueOf(j16), i17, absCompatRequest.getCallback());
            return true;
        }
        new Bundle().putString("ALBUM_ATTACH_INFO", aVar.f43983f);
        if (z16) {
            sVar.getBundle().putSerializable("response", absCompatRequest.rsp);
            W().O0(8, Integer.valueOf(aVar.f43985h));
        }
        if (aVar.f43985h != 0) {
            sVar2 = sVar;
        } else {
            sVar2 = sVar;
            z17 = false;
        }
        sVar2.setHasMore(z17);
        return false;
    }

    public void B1(long j3, String str, int i3, AbsCompatRequest.a aVar) {
        C1(j3, str, null, 1, i3, aVar, this.f41978q);
    }

    public void C(PhotoCategorySinglePicInfo photoCategorySinglePicInfo, int i3, PhotoCategorySummaryInfo photoCategorySummaryInfo) {
        ArrayList<PhotoCategorySinglePicInfo> O;
        if (photoCategorySinglePicInfo != null) {
            this.f41962a.w(photoCategorySinglePicInfo, i3);
        }
        if (photoCategorySummaryInfo.photoNumber > 0) {
            this.f41962a.d0(photoCategorySummaryInfo);
            if (photoCategorySummaryInfo.photoNumber > 3 || (O = this.f41962a.O(photoCategorySummaryInfo.uin, photoCategorySummaryInfo.categoryType, photoCategorySummaryInfo.categoryId, 0, 0, 0)) == null || O.size() <= 0 || photoCategorySinglePicInfo == null || photoCategorySinglePicInfo.lloc == null) {
                return;
            }
            Iterator<PhotoCategorySinglePicInfo> it = O.iterator();
            while (it.hasNext()) {
                PhotoCategorySinglePicInfo next = it.next();
                if (photoCategorySinglePicInfo.lloc.equals(next.lloc)) {
                    this.f41962a.w(next, 0);
                }
            }
            return;
        }
        this.f41962a.t(photoCategorySummaryInfo);
    }

    public void E(ArrayList<String> arrayList, AbsCompatRequest.a aVar) {
        if (arrayList != null && arrayList.size() >= 1) {
            QZoneDelBatchPhotosRequest qZoneDelBatchPhotosRequest = new QZoneDelBatchPhotosRequest(arrayList);
            qZoneDelBatchPhotosRequest.addParam("videoList", arrayList).setCallback(aVar).setOnJceParseListener(this.f41983v);
            M().c(qZoneDelBatchPhotosRequest, null);
            return;
        }
        QZLog.e("[PhotoAlbum]AlbumManager", "deleteShuoShuoVideos videoList is empty !! ");
    }

    public void I(AlbumCacheData albumCacheData, String str, AbsCompatRequest.a aVar) {
        QZoneOptAlbumRequest qZoneOptAlbumRequest = new QZoneOptAlbumRequest(albumCacheData.createAlbumRequestModel(1, albumCacheData, -1));
        qZoneOptAlbumRequest.addParam("cacheKey", str).addParam("album", albumCacheData).setCallback(aVar).setOnJceParseListener(this.C);
        M().c(qZoneOptAlbumRequest, null);
    }

    public void I1(long j3, String str, int i3, AbsCompatRequest.a aVar) {
        C1(j3, str, null, 2, i3, aVar, this.f41980s);
    }

    public void e0(long j3, String str, String str2, int i3, String str3, String str4, long j16, Map<Integer, String> map, boolean z16, AbsCompatRequest.a aVar, boolean z17, int i16, boolean z18) {
        QZonePhotoListRequest qZonePhotoListRequest = new QZonePhotoListRequest(j3, str, this.f41962a.R(str), 40, str2, str4, j16, map, z17, i3, str3, i16);
        qZonePhotoListRequest.addParam("face_uin", Long.valueOf(j16)).addParam("is_sorting_mode", Boolean.valueOf(z16)).addParam("filterVideo", Boolean.valueOf(z18)).setCallback(aVar).setOnJceParseListener(this.f41974m);
        M().c(qZonePhotoListRequest, null);
    }

    public void f1(String str, String str2, int i3, AbsCompatRequest.a aVar) {
        if (str == null) {
            str = "";
        }
        QZoneQueryAlbumRequest qZoneQueryAlbumRequest = new QZoneQueryAlbumRequest(str, i3);
        qZoneQueryAlbumRequest.addParam("albumId", str).addParam(AEEditorConstants.ALBUMNAME, str2).setCallback(aVar).setOnJceParseListener(this.f41965d);
        M().c(qZoneQueryAlbumRequest, null);
    }

    public void g1(String str, String str2, long j3, boolean z16, boolean z17, String str3, AbsCompatRequest.a aVar) {
        String str4 = str == null ? "" : str;
        QZoneQueryAlbumRequest qZoneQueryAlbumRequest = new QZoneQueryAlbumRequest(str4, 3, j3, z16, z17, str3);
        qZoneQueryAlbumRequest.addParam("albumId", str4).addParam(AEEditorConstants.ALBUMNAME, str2).setCallback(aVar).setOnJceParseListener(this.f41964c);
        M().c(qZoneQueryAlbumRequest, null);
    }

    public void h0(long j3, String str, String str2, int i3, String str3, String str4, long j16, Map<Integer, String> map, int i16, boolean z16, AbsCompatRequest.a aVar, int i17, boolean z17) {
        if (QZLog.isDevelopLevel()) {
            QZLog.d("[PhotoAlbum]AlbumManager", 4, "getMorePhotoList albymThemeType=" + i16);
        }
        switch (i16) {
            case 8:
            case 11:
                f0(j3, str, str2, map, z16, aVar, i17, z17);
                return;
            case 9:
                n0(j3, str, str2, map, z16, aVar, i17, z17);
                return;
            case 10:
            default:
                e0(j3, str, str2, i3, str3, str4, j16, map, z16, aVar, false, i17, z17);
                return;
            case 12:
                e0(j3, str, str2, i3, str3, str4, j16, map, z16, aVar, true, i17, z17);
                return;
        }
    }

    public void s1(long j3, String str, String str2, String str3, long j16, Map<Integer, String> map, int i3, int i16, String str4, AbsCompatRequest.a aVar, int i17, boolean z16) {
        if (QZLog.isDevelopLevel()) {
            QZLog.d("[PhotoAlbum]AlbumManager", 4, "refreshPhotoList albumThemeType=" + i3);
        }
        switch (i3) {
            case 8:
            case 11:
                p1(j3, str, str2, i3, map, aVar, i17, z16);
                return;
            case 9:
                F1(j3, str, str2, map, aVar, i17, z16);
                return;
            case 10:
            default:
                n1(j3, str, str2, i16, str3, j16, map, str4, false, aVar, i17, z16);
                return;
            case 12:
                n1(j3, str, str2, i16, str3, j16, map, str4, true, aVar, i17, z16);
                return;
        }
    }

    public void t1(long j3, String str, String str2, String str3, long j16, Map<Integer, String> map, int i3, int i16, String str4, AbsCompatRequest.a aVar, int i17, boolean z16, BannerAttachInfo bannerAttachInfo) {
        if (QZLog.isDevelopLevel()) {
            QZLog.d("[PhotoAlbum]AlbumManager", 4, "refreshPhotoList albumThemeType=" + i3);
        }
        switch (i3) {
            case 8:
            case 11:
                q1(j3, str, str2, i3, map, aVar, i17, z16, bannerAttachInfo);
                return;
            case 9:
                G1(j3, str, str2, map, aVar, i17, z16, bannerAttachInfo);
                return;
            case 10:
            default:
                o1(j3, str, str2, i16, str3, j16, map, str4, false, aVar, i17, z16, bannerAttachInfo);
                return;
            case 12:
                o1(j3, str, str2, i16, str3, j16, map, str4, true, aVar, i17, z16, bannerAttachInfo);
                return;
        }
    }

    public void x1(String str, boolean z16) {
        y1(str, z16, true, null);
    }

    public void y(Handler handler, PhotoCacheData photoCacheData, int i3, String str, boolean z16, long j3) {
        if (photoCacheData != null) {
            if (!photoCacheData.picItem.busi_param.containsKey(2)) {
                photoCacheData.picItem.busi_param.put(2, photoCacheData.picItem.lloc);
            }
            if (!photoCacheData.picItem.busi_param.containsKey(1)) {
                photoCacheData.picItem.busi_param.put(1, photoCacheData.picItem.sloc);
            }
            if (!photoCacheData.picItem.busi_param.containsKey(15)) {
                photoCacheData.picItem.busi_param.put(15, photoCacheData.picItem.bigUrl.url);
            }
            u4.a.z().n(handler, photoCacheData, i3, str, z16, j3);
            return;
        }
        QZLog.e("[PhotoAlbum]AlbumManager", "commentSinglePhotoOrVideo photoCacheData null");
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class h implements AbsCompatRequest.b {
        h() {
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.b
        public boolean a(AbsCompatRequest absCompatRequest, com.qzone.adapter.feedcomponent.s sVar) {
            ArrayList<PhotoCacheData> arrayList;
            int i3 = absCompatRequest.isGetMore() ? 11 : 10;
            Integer num = (Integer) absCompatRequest.getParam("orig_task_type");
            if (num != null) {
                i3 = num.intValue();
            }
            int i16 = i3;
            long longValue = ((Long) absCompatRequest.getParam(PhotoCacheData.OWNER_UIN)).longValue();
            Boolean bool = (Boolean) absCompatRequest.getParam("from_picture_viewer");
            boolean booleanValue = bool != null ? bool.booleanValue() : false;
            Integer num2 = (Integer) absCompatRequest.getParam("refresh_cache_count");
            int intValue = (num2 == null || num2.intValue() <= 0) ? 0 : num2.intValue();
            long currentTimeMillis = System.currentTimeMillis();
            Long l3 = (Long) absCompatRequest.getParam("first_start_timestamp");
            if (l3 != null && l3.longValue() < currentTimeMillis) {
                currentTimeMillis = l3.longValue();
            }
            long j3 = currentTimeMillis;
            int intValue2 = ((Integer) absCompatRequest.getParam("key_entrance_type")).intValue();
            if (sVar.getData() == null) {
                return true;
            }
            QzoneAlbumRecentAllPhotoRequest.a aVar = (QzoneAlbumRecentAllPhotoRequest.a) sVar.getData();
            if (!absCompatRequest.isGetMore()) {
                u4.a.z().f0("photocategory_data_error_" + longValue, false);
                u4.a.z().f0("photocategory_" + longValue, aVar.f43978a);
                a.this.c1(i16, longValue, aVar);
            }
            a aVar2 = a.this;
            aVar2.M1(aVar2.O(longValue, "recentlist_all"), aVar.f43983f);
            a.this.d1(i16, longValue, intValue, aVar);
            if (a.this.K0(absCompatRequest, sVar, i16, longValue, booleanValue, intValue, j3, intValue2, aVar)) {
                return false;
            }
            if (i16 != 10 || aVar.f43985h != 0 || (arrayList = aVar.f43981d) == null || !arrayList.isEmpty() || intValue != 0) {
                return true;
            }
            a.this.f41962a.k(LoginData.getInstance().getUin());
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class w implements AbsCompatRequest.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QZoneAlbumRequestBuilder f42028a;

        w(QZoneAlbumRequestBuilder qZoneAlbumRequestBuilder) {
            this.f42028a = qZoneAlbumRequestBuilder;
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.b
        public boolean a(AbsCompatRequest absCompatRequest, com.qzone.adapter.feedcomponent.s sVar) {
            if (sVar == null) {
                return true;
            }
            RFWLog.d("[PhotoAlbum]AlbumManager", RFWLog.CLR, "onGetRecentPhotoListByTimeLine retcode:" + sVar.getReturnCode() + " msg:" + sVar.getMessage());
            QZoneGetRecentPhotoListByTimeLineRequest.a aVar = (QZoneGetRecentPhotoListByTimeLineRequest.a) sVar.getData();
            if (aVar == null) {
                sVar.setSucceed(false);
                return true;
            }
            if (sVar.getBundle() != null) {
                sVar.getBundle().putSerializable("response", absCompatRequest.rsp);
            }
            a aVar2 = a.this;
            aVar2.M1(aVar2.O(this.f42028a.uin, "layer_recentlist_all_timeline"), aVar.f43942c);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L1(long j3, int i3, int i16, int i17, boolean z16) {
        if (z16) {
            return;
        }
        M1(O(j3, "album_count_info"), i3 + ContainerUtils.FIELD_DELIMITER + i16 + ContainerUtils.FIELD_DELIMITER + i17 + ContainerUtils.FIELD_DELIMITER);
    }

    public void A1(long j3, int i3, AbsCompatRequest.a aVar) {
        C1(j3, null, null, 1, i3, aVar, this.f41978q);
    }

    public void H1(long j3, int i3, AbsCompatRequest.a aVar) {
        C1(j3, null, null, 2, i3, aVar, this.f41980s);
    }

    public void K(AlbumCacheData albumCacheData, String str, AbsCompatRequest.a aVar) {
        long j3 = albumCacheData.ownerUin;
        String str2 = albumCacheData.albumid;
        J(4, 0, j3, str2, null, str, 4, str2, albumCacheData.albumtype, albumCacheData.busi_param, null, aVar);
    }

    public void T(QZoneAlbumRequestBuilder qZoneAlbumRequestBuilder, AbsCompatRequest.a aVar) {
        if (qZoneAlbumRequestBuilder == null) {
            return;
        }
        if (!p()) {
            RFWLog.i("[PhotoAlbum]AlbumManager", RFWLog.CLR, "getFeedxLayerMoreRecentList not available");
            return;
        }
        QzoneAlbumRecentAllPhotoRequest qzoneAlbumRecentAllPhotoRequest = new QzoneAlbumRecentAllPhotoRequest(qZoneAlbumRequestBuilder.uin, X(qZoneAlbumRequestBuilder.uin), 2, 0, 1, false);
        qzoneAlbumRecentAllPhotoRequest.addParam(PhotoCacheData.OWNER_UIN, Long.valueOf(qZoneAlbumRequestBuilder.uin)).addParam("from_picture_viewer", Boolean.TRUE).setOnJceParseListener(this.f41977p).setCallback(aVar).setGetMore(true);
        qzoneAlbumRecentAllPhotoRequest.addParam("key_entrance_type", 0);
        long j3 = qZoneAlbumRequestBuilder.firstStartTimeStamp;
        if (j3 != 0) {
            qzoneAlbumRecentAllPhotoRequest.addParam("first_start_timestamp", Long.valueOf(j3));
        } else {
            qzoneAlbumRecentAllPhotoRequest.addParam("first_start_timestamp", Long.valueOf(System.currentTimeMillis()));
        }
        M().c(qzoneAlbumRecentAllPhotoRequest, null);
    }

    public void U(QZoneAlbumRequestBuilder qZoneAlbumRequestBuilder, AbsCompatRequest.a aVar) {
        if (qZoneAlbumRequestBuilder == null) {
            return;
        }
        if (!p()) {
            RFWLog.i("[PhotoAlbum]AlbumManager", RFWLog.CLR, "getFeedxLayerMoreRecentVideoList not available");
            return;
        }
        QzoneAlbumRecentAllPhotoRequest qzoneAlbumRecentAllPhotoRequest = new QzoneAlbumRecentAllPhotoRequest(qZoneAlbumRequestBuilder.uin, Z(qZoneAlbumRequestBuilder.uin), 2, 0, 2, false);
        qzoneAlbumRecentAllPhotoRequest.addParam(PhotoCacheData.OWNER_UIN, Long.valueOf(qZoneAlbumRequestBuilder.uin)).addParam("from_picture_viewer", Boolean.FALSE).setOnJceParseListener(this.f41979r).setCallback(aVar).setGetMore(true);
        qzoneAlbumRecentAllPhotoRequest.addParam("key_entrance_type", Integer.valueOf(qZoneAlbumRequestBuilder.entranceType));
        long j3 = qZoneAlbumRequestBuilder.firstStartTimeStamp;
        if (j3 != 0) {
            qzoneAlbumRecentAllPhotoRequest.addParam("first_start_timestamp", Long.valueOf(j3));
        } else {
            qzoneAlbumRecentAllPhotoRequest.addParam("first_start_timestamp", Long.valueOf(System.currentTimeMillis()));
        }
        M().c(qzoneAlbumRecentAllPhotoRequest, null);
    }

    public void V(QZoneAlbumRequestBuilder qZoneAlbumRequestBuilder, AbsCompatRequest.a aVar) {
        if (qZoneAlbumRequestBuilder == null) {
            return;
        }
        QZoneGetRecentPhotoListByTimeLineRequest qZoneGetRecentPhotoListByTimeLineRequest = new QZoneGetRecentPhotoListByTimeLineRequest(qZoneAlbumRequestBuilder.uin, qZoneAlbumRequestBuilder.startTime, qZoneAlbumRequestBuilder.endTime, qZoneAlbumRequestBuilder.direction, Y(qZoneAlbumRequestBuilder.uin));
        qZoneGetRecentPhotoListByTimeLineRequest.addParam("direction", Integer.valueOf(qZoneAlbumRequestBuilder.direction)).setCallback(aVar).setOnJceParseListener(new w(qZoneAlbumRequestBuilder));
        M().c(qZoneGetRecentPhotoListByTimeLineRequest, null);
    }

    public void c0(long j3, String str, ArrayList<Integer> arrayList, Map<Integer, PhotoSearchBoxChosenItem> map, String str2, AbsCompatRequest.a aVar, boolean z16) {
        AbsCompatRequest.b bVar;
        if (z16) {
            bVar = this.f41970i;
        } else {
            bVar = this.f41969h;
        }
        QZoneGetPhotoSearchRequest qZoneGetPhotoSearchRequest = new QZoneGetPhotoSearchRequest(j3, str, 2, arrayList, map, str2);
        qZoneGetPhotoSearchRequest.addParam("albumId", str).addParam(PhotoCacheData.OWNER_UIN, Long.valueOf(j3)).setOnJceParseListener(bVar).setCallback(aVar);
        M().c(qZoneGetPhotoSearchRequest, null);
    }

    public void f0(long j3, String str, String str2, Map<Integer, String> map, boolean z16, AbsCompatRequest.a aVar, int i3, boolean z17) {
        Map<Integer, String> map2;
        String str3;
        AlbumCacheData albumCacheData = new AlbumCacheData();
        byte[] bArr = (byte[]) this.f41962a.y(j3, str, AlbumCacheData.PARENTING_DATA);
        if (bArr != null) {
            try {
                Parcel obtain = Parcel.obtain();
                obtain.unmarshall(bArr, 0, bArr.length);
                obtain.setDataPosition(0);
                albumCacheData.parentingData = (ParentingAlbumData) ParcelableWrapper.createDataFromParcel(obtain);
                OaidMonitor.parcelRecycle(obtain);
            } catch (Exception e16) {
                QZLog.w(e16);
            }
        }
        ParentingAlbumData parentingAlbumData = albumCacheData.parentingData;
        if (parentingAlbumData != null) {
            String str4 = parentingAlbumData.attach_info;
            map2 = map == null ? parentingAlbumData.busi_param : map;
            str3 = str4;
        } else {
            map2 = map;
            str3 = null;
        }
        if (QZLog.isColorLevel()) {
            QZLog.d("[PhotoAlbum]AlbumManager", 2, "getMoreParentingPhotoList | attach_info:" + str3 + " busi_param:" + map2);
        }
        QZoneParentingPhotoListRequest qZoneParentingPhotoListRequest = new QZoneParentingPhotoListRequest(j3, str, str3, str2, map2, 0, i3);
        qZoneParentingPhotoListRequest.addParam("is_sorting_mode", Boolean.valueOf(z16)).addParam("albumId", str).addParam("filterVideo", Boolean.valueOf(z17)).setCallback(aVar).setOnJceParseListener(this.f41975n);
        M().c(qZoneParentingPhotoListRequest, null);
    }

    public void m1(long j3, int i3, AbsCompatRequest.a aVar) {
        C1(j3, null, null, 3, i3, aVar, this.f41980s);
    }

    public void w0(long j3, long j16, long j17, int i3, AbsCompatRequest.a aVar) {
        String str;
        if (i3 != 0) {
            str = N(O(j3, "recentlist_all_timeline"));
        } else {
            str = "";
        }
        String str2 = str;
        QZLog.d("recentPhotoTimeLine", 1, "[request] uin:", Long.valueOf(j3), " beginTime:", Long.valueOf(j16), " endTime:", Long.valueOf(j17), " direction:", Integer.valueOf(i3), " attachInfo:", str2);
        QZoneGetRecentPhotoListByTimeLineRequest qZoneGetRecentPhotoListByTimeLineRequest = new QZoneGetRecentPhotoListByTimeLineRequest(j3, j16, j17, i3, str2);
        qZoneGetRecentPhotoListByTimeLineRequest.addParam("direction", Integer.valueOf(i3)).setCallback(aVar).setOnJceParseListener(new x(j3));
        M().c(qZoneGetRecentPhotoListByTimeLineRequest, null);
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class an implements AbsCompatRequest.b {
        an() {
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.b
        public boolean a(AbsCompatRequest absCompatRequest, com.qzone.adapter.feedcomponent.s sVar) {
            if (absCompatRequest == null || sVar == null) {
                return false;
            }
            String str = (String) absCompatRequest.getParam("albumId");
            if ((sVar.getData() instanceof QZoneGetPhotoSearchRequest.a) && !TextUtils.isEmpty(str)) {
                QZoneGetPhotoSearchRequest.a aVar = (QZoneGetPhotoSearchRequest.a) sVar.getData();
                a.this.f41962a.l(str);
                ArrayList<PhotoCacheData> arrayList = aVar.f43935e;
                if (arrayList != null && !arrayList.isEmpty()) {
                    a.this.f41962a.u0(str, aVar.f43935e);
                }
                sVar.setNewCnt(aVar.f43936f);
                sVar.setHasMore(aVar.f43938h);
                sVar.setSucceed(true);
                a.this.Q0(str, false);
            } else {
                sVar.setSucceed(false);
            }
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class ao implements AbsCompatRequest.b {
        ao() {
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.b
        public boolean a(AbsCompatRequest absCompatRequest, com.qzone.adapter.feedcomponent.s sVar) {
            if (absCompatRequest == null || sVar == null) {
                return false;
            }
            String str = (String) absCompatRequest.getParam("albumId");
            if ((sVar.getData() instanceof QZoneGetPhotoSearchRequest.a) && !TextUtils.isEmpty(str)) {
                QZoneGetPhotoSearchRequest.a aVar = (QZoneGetPhotoSearchRequest.a) sVar.getData();
                if (aVar.f43935e != null) {
                    a.this.f41962a.h(str, aVar.f43935e);
                }
                a.this.Q0(str, false);
                sVar.setNewCnt(aVar.f43936f);
                sVar.setHasMore(aVar.f43938h);
                sVar.setSucceed(true);
            }
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class ap implements AbsCompatRequest.b {
        ap() {
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.b
        public boolean a(AbsCompatRequest absCompatRequest, com.qzone.adapter.feedcomponent.s sVar) {
            if (absCompatRequest == null || sVar == null) {
                return false;
            }
            String str = (String) absCompatRequest.getParam("albumId");
            if ((sVar.getData() instanceof QZoneGetPhotoSearchRequest.a) && !TextUtils.isEmpty(str)) {
                QZoneGetPhotoSearchRequest.a aVar = (QZoneGetPhotoSearchRequest.a) sVar.getData();
                if (aVar.f43935e != null) {
                    a.this.f41962a.h(str, aVar.f43935e);
                }
                a.this.Q0(str, false);
                sVar.setNewCnt(aVar.f43936f);
                sVar.setHasMore(aVar.f43938h);
                sVar.setSucceed(true);
                com.qzone.adapter.feedcomponent.e.a(u4.a.z().E(), 30, sVar);
            }
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class j implements AbsCompatRequest.b {
        j() {
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.b
        public boolean a(AbsCompatRequest absCompatRequest, com.qzone.adapter.feedcomponent.s sVar) {
            HashMap hashMap;
            int i3;
            ArrayList<PhotoCacheData> arrayList;
            int size;
            ArrayList<PhotoCacheData> arrayList2;
            int i16 = absCompatRequest.isGetMore() ? 51 : 50;
            Integer num = (Integer) absCompatRequest.getParam("orig_task_type");
            int intValue = ((Integer) absCompatRequest.getParam("video_type")).intValue();
            if (num != null) {
                i16 = num.intValue();
            }
            long longValue = ((Long) absCompatRequest.getParam(PhotoCacheData.OWNER_UIN)).longValue();
            Boolean bool = (Boolean) absCompatRequest.getParam("from_picture_viewer");
            boolean booleanValue = bool != null ? bool.booleanValue() : false;
            Integer num2 = (Integer) absCompatRequest.getParam("refresh_cache_count");
            int intValue2 = (num2 == null || num2.intValue() <= 0) ? 0 : num2.intValue();
            long currentTimeMillis = System.currentTimeMillis();
            Long l3 = (Long) absCompatRequest.getParam("first_start_timestamp");
            if (l3 != null && l3.longValue() < currentTimeMillis) {
                currentTimeMillis = l3.longValue();
            }
            int intValue3 = ((Integer) absCompatRequest.getParam("key_entrance_type")).intValue();
            HashMap hashMap2 = (HashMap) absCompatRequest.getParam("params_map");
            if (sVar.getData() != null) {
                QzoneAlbumRecentAllPhotoRequest.a aVar = (QzoneAlbumRecentAllPhotoRequest.a) sVar.getData();
                if (intValue == 3) {
                    a aVar2 = a.this;
                    aVar2.M1(aVar2.O(longValue, "freindvideolist_all"), aVar.f43983f);
                } else {
                    a aVar3 = a.this;
                    aVar3.M1(aVar3.O(longValue, "videolist_all"), aVar.f43983f);
                }
                ArrayList<PhotoCacheData> arrayList3 = aVar.f43981d;
                if (arrayList3 != null && !arrayList3.isEmpty()) {
                    boolean z16 = i16 == 50 && intValue2 == 0;
                    if (intValue == 3) {
                        a.this.f41962a.z0(aVar.f43981d, z16);
                    } else {
                        a.this.f41962a.D0(aVar.f43981d, z16);
                    }
                    ArrayList<AlbumCacheData> arrayList4 = aVar.f43980c;
                    if (arrayList4 != null && !arrayList4.isEmpty()) {
                        a.this.f41962a.B0(longValue, aVar.f43980c, z16);
                    }
                }
                if (aVar.f43985h != 0 && (arrayList2 = aVar.f43981d) != null && arrayList2.isEmpty() && System.currentTimeMillis() - currentTimeMillis < 360000) {
                    a.this.k0(longValue, booleanValue, Integer.valueOf(i16), Integer.valueOf(((QZoneResult) sVar.a()).what), Integer.valueOf(intValue2), Long.valueOf(currentTimeMillis), 2, intValue3, absCompatRequest.getCallback(), hashMap2);
                    return false;
                }
                if (i16 != 50) {
                    hashMap = hashMap2;
                    i3 = 50;
                } else {
                    if (aVar.f43985h != 0 && aVar.f43981d != null && System.currentTimeMillis() - currentTimeMillis < 360000 && (size = aVar.f43981d.size() + intValue2) < 15) {
                        a.this.k0(longValue, booleanValue, Integer.valueOf(i16), Integer.valueOf(((QZoneResult) sVar.a()).what), Integer.valueOf(size), Long.valueOf(currentTimeMillis), 2, intValue3, absCompatRequest.getCallback(), hashMap2);
                        return false;
                    }
                    hashMap = hashMap2;
                    i3 = 50;
                }
                if (i16 == i3 && aVar.f43985h == 0 && (arrayList = aVar.f43981d) != null && arrayList.isEmpty() && intValue2 == 0) {
                    if (intValue == 3) {
                        a.this.f41962a.i(LoginData.getInstance().getUin());
                    } else {
                        a.this.f41962a.m(LoginData.getInstance().getUin());
                    }
                }
                a.this.J1(longValue, false, intValue);
                if (booleanValue) {
                    sVar.getBundle().putSerializable("response", absCompatRequest.rsp);
                }
                if (hashMap != null) {
                    Bundle bundle = new Bundle();
                    sVar.setObjectData(bundle);
                }
                sVar.setHasMore(aVar.f43985h != 0);
                sVar.setSucceed(true);
                return true;
            }
            if (com.qzone.album.util.d.d(sVar.getReturnCode())) {
                return true;
            }
            a.this.f41962a.m(longValue);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean E0(BusinessAlbumInfo businessAlbumInfo, String str, String str2) {
        if (businessAlbumInfo != null && str != null && businessAlbumInfo.getId() != null) {
            if (str.equals("") && !str.equals(businessAlbumInfo.getId())) {
                return true;
            }
            if (str2 != null && !str2.equals(businessAlbumInfo.mTitle) && str.equals(businessAlbumInfo.getId())) {
                return true;
            }
        }
        return false;
    }

    public void F1(long j3, String str, String str2, Map<Integer, String> map, AbsCompatRequest.a aVar, int i3, boolean z16) {
        boolean z17 = false;
        if (map != null && ("1".equals(map.get(2)) || "2".equals(map.get(2)))) {
            z17 = true;
        }
        QZoneTravelPhotoListRequest qZoneTravelPhotoListRequest = new QZoneTravelPhotoListRequest(j3, str, null, str2, map, i3);
        qZoneTravelPhotoListRequest.addParam("is_sorting_mode", Boolean.valueOf(z17)).addParam("albumId", str).addParam("filterVideo", Boolean.valueOf(z16)).setCallback(aVar).setOnJceParseListener(this.f41973l);
        M().c(qZoneTravelPhotoListRequest, null);
    }

    public void b0(long j3, AbsCompatRequest.a aVar) {
        a0(j3, 0, null, aVar);
    }

    public void A(String str, ArrayList<String> arrayList, ArrayList<String> arrayList2, AbsCompatRequest.a aVar) {
        B(str, arrayList, arrayList2, aVar, false);
    }

    public void G1(long j3, String str, String str2, Map<Integer, String> map, AbsCompatRequest.a aVar, int i3, boolean z16, BannerAttachInfo bannerAttachInfo) {
        boolean z17 = false;
        if (map != null && ("1".equals(map.get(2)) || "2".equals(map.get(2)))) {
            z17 = true;
        }
        QZoneTravelPhotoListRequest qZoneTravelPhotoListRequest = new QZoneTravelPhotoListRequest(j3, str, null, str2, map, i3, bannerAttachInfo);
        qZoneTravelPhotoListRequest.addParam("is_sorting_mode", Boolean.valueOf(z17)).addParam("albumId", str).addParam("filterVideo", Boolean.valueOf(z16)).setCallback(aVar).setOnJceParseListener(this.f41973l);
        M().c(qZoneTravelPhotoListRequest, null);
    }

    public void I0(String str, String str2, ArrayList<String> arrayList, AbsCompatRequest.a aVar) {
        J0(str, str2, arrayList, aVar, false);
    }

    public void P(long j3, Map<Integer, GetCategoryDetailReqItem> map, boolean z16, AbsCompatRequest.a aVar) {
        Q(j3, map, z16, false, aVar);
    }

    public void R(long j3, Map<Integer, GetCategoryDetailReqItem> map, boolean z16, AbsCompatRequest.a aVar) {
        Q(j3, map, z16, true, aVar);
    }

    public void k1(long j3, HashMap<String, String> hashMap, AbsCompatRequest.a aVar) {
        j1(j3, null, 2, hashMap, aVar);
    }

    public void p1(long j3, String str, String str2, int i3, Map<Integer, String> map, AbsCompatRequest.a aVar, int i16, boolean z16) {
        boolean z17 = false;
        if (map != null && ("1".equals(map.get(2)) || "2".equals(map.get(2)))) {
            z17 = true;
        }
        QZoneParentingPhotoListRequest qZoneParentingPhotoListRequest = new QZoneParentingPhotoListRequest(j3, str, null, str2, map, i3, i16);
        qZoneParentingPhotoListRequest.addParam("is_sorting_mode", Boolean.valueOf(z17)).addParam("albumId", str).addParam("albumtype", Integer.valueOf(i3)).addParam("filterVideo", Boolean.valueOf(z16)).setCallback(aVar).setOnJceParseListener(this.f41972k);
        M().c(qZoneParentingPhotoListRequest, null);
    }

    public void q1(long j3, String str, String str2, int i3, Map<Integer, String> map, AbsCompatRequest.a aVar, int i16, boolean z16, BannerAttachInfo bannerAttachInfo) {
        boolean z17 = false;
        if (map != null && ("1".equals(map.get(2)) || "2".equals(map.get(2)))) {
            z17 = true;
        }
        QZoneParentingPhotoListRequest qZoneParentingPhotoListRequest = new QZoneParentingPhotoListRequest(j3, str, null, str2, map, i3, i16, bannerAttachInfo);
        qZoneParentingPhotoListRequest.addParam("is_sorting_mode", Boolean.valueOf(z17)).addParam("albumId", str).addParam("albumtype", Integer.valueOf(i3)).addParam("filterVideo", Boolean.valueOf(z16)).setCallback(aVar).setOnJceParseListener(this.f41972k);
        M().c(qZoneParentingPhotoListRequest, null);
    }

    public void x(String str, String str2, long j3, boolean z16, Map<Integer, String> map, AbsCompatRequest.a aVar) {
        if (map != null) {
            map.put(34, "5");
        }
        QZoneAddCommentRequest qZoneAddCommentRequest = new QZoneAddCommentRequest(0, 4, j3, str, str2, null, 0, map, null, z16, null);
        qZoneAddCommentRequest.setCallback(aVar).setOnJceParseListener(new ab());
        M().c(qZoneAddCommentRequest, null);
    }

    public void y1(String str, boolean z16, boolean z17, RecomAlbumList recomAlbumList) {
        w1(str, z16, z17, recomAlbumList, false);
    }

    public void j0(long j3, int i3, AbsCompatRequest.a aVar) {
        l0(j3, false, null, null, null, null, i3, aVar);
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class i implements AbsCompatRequest.b {
        i() {
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.b
        public boolean a(AbsCompatRequest absCompatRequest, com.qzone.adapter.feedcomponent.s sVar) {
            if (absCompatRequest == null || sVar == null) {
                return false;
            }
            long longValue = ((Long) absCompatRequest.getParam(PhotoCacheData.OWNER_UIN)).longValue();
            long currentTimeMillis = System.currentTimeMillis();
            Long l3 = (Long) absCompatRequest.getParam("first_start_timestamp");
            if (l3 != null && l3.longValue() < currentTimeMillis) {
                currentTimeMillis = l3.longValue();
            }
            long j3 = currentTimeMillis;
            int intValue = ((Integer) absCompatRequest.getParam("key_entrance_type")).intValue();
            if (sVar.getData() != null) {
                QzoneAlbumRecentAllPhotoRequest.a aVar = (QzoneAlbumRecentAllPhotoRequest.a) sVar.getData();
                if (aVar != null) {
                    RFWLog.d("[PhotoAlbum]AlbumManager", RFWLog.CLR, "save recent video list attach info is " + aVar.f43983f);
                    a aVar2 = a.this;
                    aVar2.M1(aVar2.O(longValue, "layer_recent_videolist_all"), aVar.f43983f);
                }
                return !a.this.M0(absCompatRequest, sVar, 51, longValue, false, 0, j3, intValue, aVar);
            }
            if (!com.qzone.album.util.d.d(sVar.getReturnCode()) && a.this.f41962a != null) {
                a.this.f41962a.m(longValue);
            }
            return true;
        }
    }

    public void d0(long j3, int i3, AbsCompatRequest.a aVar) {
        k0(j3, false, null, null, null, null, 3, i3, aVar, null);
    }

    public void m0(long j3, int i3, AbsCompatRequest.a aVar) {
        k0(j3, true, null, null, null, null, i3, 0, aVar, null);
    }

    public void o0(long j3, int i3, AbsCompatRequest.a aVar) {
        k0(j3, false, null, null, null, null, 2, i3, aVar, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k0(long j3, boolean z16, Integer num, Integer num2, Integer num3, Long l3, int i3, int i16, AbsCompatRequest.a aVar, HashMap<String, Object> hashMap) {
        String str;
        AbsCompatRequest.b bVar;
        if (!p()) {
            QZLog.i("[PhotoAlbum]AlbumManager", "getMoreRecentList not available");
            return;
        }
        if (i3 == 1) {
            str = N(O(j3, "recentlist_all"));
        } else if (i3 == 2) {
            str = N(O(j3, "videolist_all"));
        } else if (i3 == 3) {
            str = N(O(j3, "freindvideolist_all"));
        } else {
            str = "";
        }
        String str2 = str;
        if (i3 == 1) {
            bVar = this.f41978q;
        } else {
            bVar = this.f41980s;
        }
        QzoneAlbumRecentAllPhotoRequest qzoneAlbumRecentAllPhotoRequest = new QzoneAlbumRecentAllPhotoRequest(j3, str2, 2, i16, i3, false);
        qzoneAlbumRecentAllPhotoRequest.addParam(PhotoCacheData.OWNER_UIN, Long.valueOf(j3)).addParam("from_picture_viewer", Boolean.valueOf(z16)).setOnJceParseListener(bVar).setCallback(aVar).setGetMore(true);
        qzoneAlbumRecentAllPhotoRequest.addParam("video_type", Integer.valueOf(i3));
        if (num != null) {
            qzoneAlbumRecentAllPhotoRequest.addParam("orig_task_type", num);
        }
        if (num2 != null) {
            qzoneAlbumRecentAllPhotoRequest.addParam("orig_result_what", num2);
        }
        if (num3 != null) {
            qzoneAlbumRecentAllPhotoRequest.addParam("refresh_cache_count", num3);
        }
        if (l3 != null) {
            qzoneAlbumRecentAllPhotoRequest.addParam("first_start_timestamp", l3);
        } else {
            qzoneAlbumRecentAllPhotoRequest.addParam("first_start_timestamp", Long.valueOf(System.currentTimeMillis()));
        }
        qzoneAlbumRecentAllPhotoRequest.addParam("key_entrance_type", Integer.valueOf(i16));
        if (hashMap != null) {
            qzoneAlbumRecentAllPhotoRequest.addParam("params_map", hashMap);
        }
        M().c(qzoneAlbumRecentAllPhotoRequest, null);
    }

    private void l0(long j3, boolean z16, Integer num, Integer num2, Integer num3, Long l3, int i3, AbsCompatRequest.a aVar) {
        k0(j3, z16, num, num2, num3, l3, 1, i3, aVar, null);
    }

    public void o1(long j3, String str, String str2, int i3, String str3, long j16, Map<Integer, String> map, String str4, boolean z16, AbsCompatRequest.a aVar, int i16, boolean z17, BannerAttachInfo bannerAttachInfo) {
        QZonePhotoListRequest qZonePhotoListRequest = new QZonePhotoListRequest(j3, str, 0, 40, str2, str3, j16, map, str4, z16, i3, null, i16, bannerAttachInfo);
        qZonePhotoListRequest.addParam("face_uin", Long.valueOf(j16)).addParam("albumId", str).addParam("filterVideo", Boolean.valueOf(z17)).setOnJceParseListener(this.f41971j).setCallback(aVar);
        M().c(qZonePhotoListRequest, null);
    }

    public void y0(long j3, String str, String str2, int i3, String str3, String str4, long j16, Map<Integer, String> map, boolean z16, AbsCompatRequest.a aVar, int i16, long j17) {
        QZonePhotoListRequest qZonePhotoListRequest = new QZonePhotoListRequest(j3, str, this.f41962a.R(str), i3, str3, 40, str2, str4, j16, map, "", "", 1, i16, j17);
        qZonePhotoListRequest.addParam("face_uin", Long.valueOf(j16)).addParam("is_sorting_mode", Boolean.valueOf(z16)).setCallback(aVar).setOnJceParseListener(this.f41974m);
        M().c(qZonePhotoListRequest, null);
    }

    public void J(int i3, int i16, long j3, String str, ArrayList<String> arrayList, String str2, int i17, String str3, int i18, Map<Integer, String> map, String str4, AbsCompatRequest.a aVar) {
        QZLog.d("[PhotoAlbum]AlbumManager", 4, "forwardAlbum");
        QZoneForwardRequest qZoneForwardRequest = new QZoneForwardRequest(i3, i16, j3, str, arrayList, str2, "", "", null, 0, 0, 0, "", i17, str3, i18, map, str4, null);
        qZoneForwardRequest.setCallback(aVar).setOnJceParseListener(new ac());
        M().c(qZoneForwardRequest, null);
    }

    public void r1(long j3, String str, String str2, String str3, long j16, Map<Integer, String> map, int i3, int i16, String str4, AbsCompatRequest.a aVar) {
        s1(j3, str, str2, str3, j16, map, i3, i16, str4, aVar, 0, false);
    }

    public void v1(long j3, String str, String str2, String str3, long j16, Map<Integer, String> map, int i3, int i16, String str4, AbsCompatRequest.a aVar, boolean z16) {
        s1(j3, str, str2, str3, j16, map, i3, i16, str4, aVar, 0, z16);
    }

    public void g0(long j3, String str, String str2, int i3, String str3, String str4, long j16, Map<Integer, String> map, int i16, boolean z16, AbsCompatRequest.a aVar) {
        h0(j3, str, str2, i3, str3, str4, j16, map, i16, z16, aVar, 0, false);
    }

    public void u1(long j3, String str, String str2, String str3, long j16, Map<Integer, String> map, int i3, int i16, String str4, AbsCompatRequest.a aVar, BannerAttachInfo bannerAttachInfo) {
        t1(j3, str, str2, str3, j16, map, i3, i16, str4, aVar, 0, false, bannerAttachInfo);
    }

    public void i0(long j3, String str, String str2, int i3, String str3, String str4, long j16, Map<Integer, String> map, int i16, boolean z16, AbsCompatRequest.a aVar, boolean z17) {
        h0(j3, str, str2, i3, str3, str4, j16, map, i16, z16, aVar, 0, z17);
    }

    public AbsCompatRequest C0(long j3, String str, String str2, String str3, int i3, int i16, int i17, int i18, int i19, String str4, Map<Integer, String> map, int i26, String str5, long j16, AbsCompatRequest.a aVar) {
        QZoneViewPhotoRequest qZoneViewPhotoRequest = new QZoneViewPhotoRequest(j3, str, str2, 1, 1, str3, i3, i16, i17, i18, i19, str4, map, i26, str5, j16, 0, 0L);
        qZoneViewPhotoRequest.setCallback(aVar);
        M().c(qZoneViewPhotoRequest, null);
        return qZoneViewPhotoRequest;
    }

    public void D1(long j3, String str, String str2, int i3, String str3, String str4, long j16, Map<Integer, String> map, String str5, String str6, int i16, int i17, long j17, AbsCompatRequest.a aVar, BannerAttachInfo bannerAttachInfo) {
        QZonePhotoListRequest qZonePhotoListRequest = new QZonePhotoListRequest(j3, str, 0, i3, str3, 40, str2, str4, j16, map, str5, str6, i16, i17, j17, bannerAttachInfo);
        qZonePhotoListRequest.addParam("face_uin", Long.valueOf(j16)).addParam("albumId", str).setOnJceParseListener(this.f41967f).setCallback(aVar);
        M().c(qZonePhotoListRequest, null);
    }

    public AbsCompatRequest A0(long j3, String str, String str2, String str3, int i3, int i16, int i17, int i18, int i19, String str4, Map<Integer, String> map, int i26, String str5, long j16, int i27, long j17, AbsCompatRequest.a aVar) {
        QZoneViewPhotoRequest qZoneViewPhotoRequest = new QZoneViewPhotoRequest(j3, str, str2, 1, 1, str3, i3, i16, i17, i18, i19, str4, map, i26, str5, j16, i27, j17);
        qZoneViewPhotoRequest.setCallback(aVar);
        M().c(qZoneViewPhotoRequest, null);
        return qZoneViewPhotoRequest;
    }

    public AbsCompatRequest B0(long j3, String str, String str2, String str3, int i3, int i16, int i17, int i18, int i19, String str4, Map<Integer, String> map, int i26, String str5, long j16, int i27, long j17, AbsCompatRequest.a aVar) {
        QZoneViewPhotoRequest qZoneViewPhotoRequest = new QZoneViewPhotoRequest(j3, str, str2, 1, 0, str3, i3, i16, i17, i18, i19, str4, map, i26, str5, j16, i27, j17);
        qZoneViewPhotoRequest.setCallback(aVar);
        M().c(qZoneViewPhotoRequest, null);
        return qZoneViewPhotoRequest;
    }

    public AbsCompatRequest D0(long j3, String str, String str2, String str3, int i3, int i16, int i17, int i18, int i19, String str4, Map<Integer, String> map, int i26, String str5, long j16, int i27, long j17, AbsCompatRequest.a aVar) {
        QZoneViewPhotoRequest qZoneViewPhotoRequest = new QZoneViewPhotoRequest(j3, str, str2, 0, 1, str3, i3, i16, i17, i18, i19, str4, map, i26, str5, j16, i27, j17);
        qZoneViewPhotoRequest.setCallback(aVar);
        M().c(qZoneViewPhotoRequest, null);
        return qZoneViewPhotoRequest;
    }
}
