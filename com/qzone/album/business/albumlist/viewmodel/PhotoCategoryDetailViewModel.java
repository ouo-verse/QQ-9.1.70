package com.qzone.album.business.albumlist.viewmodel;

import NS_MOBILE_FEEDS.s_pic_host;
import NS_MOBILE_FEEDS.s_picdata;
import NS_MOBILE_PHOTO.GetCategoryDetailReqItem;
import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.qzone.adapter.feedcomponent.s;
import com.qzone.album.business.photolist.adapter.QZonePersonalAlbumRecentAdapter;
import com.qzone.album.data.AlbumCacheDataManager;
import com.qzone.album.data.model.AlbumCacheData;
import com.qzone.album.data.model.PhotoCacheData;
import com.qzone.album.data.model.PhotoCategorySinglePicInfo;
import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.qzone.album.protocol.AbsCompatRequest;
import com.qzone.album.protocol.QZoneCategoryOpReq;
import com.qzone.album.protocol.QZoneGetCategoryDetailReq;
import com.tencent.component.app.common.ParcelableWrapper;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes39.dex */
public class PhotoCategoryDetailViewModel extends ViewModel {
    protected MutableLiveData<PhotoCategorySummaryInfo> C = new MutableLiveData<>();
    protected MutableLiveData<ArrayList<PhotoCategorySinglePicInfo>> D = new MutableLiveData<>();
    protected MutableLiveData<ArrayList<AlbumCacheData>> E = new MutableLiveData<>();
    protected MutableLiveData<Integer> F = new MutableLiveData<>();
    public boolean G = false;
    public boolean H = false;
    private int I = -1;
    private long J;

    /* renamed from: i, reason: collision with root package name */
    protected com.qzone.album.base.Service.a f42378i;

    /* renamed from: m, reason: collision with root package name */
    protected AlbumCacheDataManager f42379m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class a implements AbsCompatRequest.a {
        a() {
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.a
        public void a(AbsCompatRequest absCompatRequest, s sVar, int i3, String str) {
            if (absCompatRequest instanceof QZoneCategoryOpReq) {
                PhotoCategoryDetailViewModel.this.c2(((QZoneCategoryOpReq) absCompatRequest).getOpType(), sVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class b implements AbsCompatRequest.a {
        b() {
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.a
        public void a(AbsCompatRequest absCompatRequest, s sVar, int i3, String str) {
            if (absCompatRequest instanceof QZoneCategoryOpReq) {
                PhotoCategoryDetailViewModel.this.c2(((QZoneCategoryOpReq) absCompatRequest).getOpType(), sVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class c implements AbsCompatRequest.a {
        c() {
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.a
        public void a(AbsCompatRequest absCompatRequest, s sVar, int i3, String str) {
            if (absCompatRequest instanceof QZoneCategoryOpReq) {
                PhotoCategoryDetailViewModel.this.c2(((QZoneCategoryOpReq) absCompatRequest).getOpType(), sVar);
            }
        }
    }

    public PhotoCategoryDetailViewModel() {
        QZLog.d("[PhotoAlbum]PhotoCategoryDetailViewModel", 1, "init PhotoCategoryDetailViewModel...");
        this.J = com.qzone.album.env.common.a.m().s();
        this.f42378i = com.qzone.album.base.Service.a.W();
        this.f42379m = AlbumCacheDataManager.J();
    }

    private ArrayList<PhotoCategorySinglePicInfo> O1(ArrayList<PhotoCacheData> arrayList) {
        String str;
        String str2;
        ArrayList<PhotoCategorySinglePicInfo> arrayList2 = new ArrayList<>();
        if (arrayList != null && arrayList.size() > 0 && this.D.getValue() != null && this.D.getValue().size() > 0) {
            Iterator<PhotoCategorySinglePicInfo> it = this.D.getValue().iterator();
            while (it.hasNext()) {
                PhotoCategorySinglePicInfo next = it.next();
                Iterator<PhotoCacheData> it5 = arrayList.iterator();
                while (it5.hasNext()) {
                    PhotoCacheData next2 = it5.next();
                    PhotoCacheData photoCacheData = next.singlePicInfo;
                    if (photoCacheData != null && (str = photoCacheData.lloc) != null && (str2 = next2.lloc) != null && str.equals(str2)) {
                        arrayList2.add(next);
                    }
                }
            }
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PhotoCategorySummaryInfo a2(PhotoCategorySummaryInfo photoCategorySummaryInfo, long j3) {
        QZLog.d("[PhotoAlbum]PhotoCategoryDetailViewModel", 1, "loadSummaryInfoFromCache...");
        if (photoCategorySummaryInfo == null) {
            QZLog.w("[PhotoAlbum]PhotoCategoryDetailViewModel", 1, "photoCategorySummaryInfo == null !!!");
            return null;
        }
        if (!TextUtils.isEmpty(photoCategorySummaryInfo.avatarUrl) && !TextUtils.isEmpty(photoCategorySummaryInfo.nick)) {
            return photoCategorySummaryInfo;
        }
        ArrayList<PhotoCategorySummaryInfo> Q = AlbumCacheDataManager.J().Q(j3, photoCategorySummaryInfo.categoryType, photoCategorySummaryInfo.categoryId);
        if (Q != null && Q.size() >= 1 && Q.get(0) != null) {
            if (TextUtils.isEmpty(photoCategorySummaryInfo.avatarUrl) && !TextUtils.isEmpty(Q.get(0).avatarUrl)) {
                photoCategorySummaryInfo.avatarUrl = Q.get(0).avatarUrl;
            }
            if (TextUtils.isEmpty(photoCategorySummaryInfo.nick) && !TextUtils.isEmpty(Q.get(0).nick)) {
                photoCategorySummaryInfo.nick = Q.get(0).nick;
            }
            return photoCategorySummaryInfo;
        }
        QZLog.w("[PhotoAlbum]PhotoCategoryDetailViewModel", 1, "cacheInfos == null || cacheInfos.size() < 1 || cacheInfos.get(0) == null");
        this.C.postValue(photoCategorySummaryInfo);
        return photoCategorySummaryInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c2(int i3, s sVar) {
        int i16;
        QZLog.d("[PhotoAlbum]PhotoCategoryDetailViewModel", 1, "onCategoryOp... opType : " + i3);
        Object data = sVar.getData();
        if (sVar.getSucceed() && (data instanceof QZoneCategoryOpReq.a)) {
            this.H = true;
            this.C.postValue(((QZoneCategoryOpReq.a) data).f43904d);
            if (i3 == 2 || (i16 = this.I) == 1) {
                i2(false);
                this.f42378i.N0(16);
                return;
            } else if (i3 == 3 || i16 == 4) {
                this.F.postValue(2);
                return;
            } else {
                if (i3 == 5) {
                    this.F.postValue(3);
                    return;
                }
                return;
            }
        }
        this.F.postValue(4);
    }

    public void Q1(ArrayList<PhotoCacheData> arrayList, long j3) {
        this.I = this.C.getValue().categoryType == 1 ? 3 : 4;
        QZLog.d("[PhotoAlbum]PhotoCategoryDetailViewModel", 1, "deletePhoto... opEration : " + this.I);
        ArrayList<PhotoCategorySinglePicInfo> O1 = O1(arrayList);
        if (O1 == null || O1.size() <= 0) {
            return;
        }
        PhotoCategorySummaryInfo value = this.C.getValue();
        value.photoNumber -= O1.size();
        HashMap hashMap = new HashMap();
        ArrayList arrayList2 = new ArrayList();
        for (int i3 = 0; i3 < O1.size(); i3++) {
            PhotoCategorySinglePicInfo photoCategorySinglePicInfo = O1.get(i3);
            s_picdata s_picdataVar = new s_picdata();
            s_pic_host s_pic_hostVar = new s_pic_host();
            s_picdataVar.albumid = photoCategorySinglePicInfo.albumId;
            s_picdataVar.sloc = photoCategorySinglePicInfo.sloc;
            s_picdataVar.lloc = photoCategorySinglePicInfo.lloc;
            s_pic_hostVar.uin = photoCategorySinglePicInfo.owner;
            s_picdataVar.pic_host_nick = s_pic_hostVar;
            arrayList2.add(s_picdataVar);
        }
        hashMap.put(this.C.getValue().categoryId, arrayList2);
        this.f42378i.t(j3, this.I, hashMap, value, new a());
    }

    public MutableLiveData<ArrayList<AlbumCacheData>> R1() {
        return this.E;
    }

    public MutableLiveData<PhotoCategorySummaryInfo> S1() {
        return this.C;
    }

    public MutableLiveData<ArrayList<PhotoCategorySinglePicInfo>> T1() {
        return this.D;
    }

    public MutableLiveData<Integer> U1() {
        return this.F;
    }

    public void X1(final Activity activity) {
        QZLog.d("[PhotoAlbum]PhotoCategoryDetailViewModel", 1, "loadFromIntent...");
        Intent b16 = u4.c.a().b(activity);
        if (b16 != null) {
            final PhotoCategorySummaryInfo photoCategorySummaryInfo = (PhotoCategorySummaryInfo) ParcelableWrapper.getDataFromeIntent(b16, "categorydetialssummaryinfo");
            if (photoCategorySummaryInfo == null) {
                int intExtra = b16.getIntExtra(QZoneHelper.QzonePhotoCategoryConstants.CATEGORY_BUSI_TYPE, -1);
                String stringExtra = b16.getStringExtra("categoryId");
                if (intExtra >= 0 && !TextUtils.isEmpty(stringExtra)) {
                    photoCategorySummaryInfo = new PhotoCategorySummaryInfo();
                    photoCategorySummaryInfo.categoryType = intExtra;
                    photoCategorySummaryInfo.categoryId = stringExtra;
                }
            }
            com.qzone.album.env.common.a.m().u().post(new Runnable() { // from class: com.qzone.album.business.albumlist.viewmodel.PhotoCategoryDetailViewModel.1
                @Override // java.lang.Runnable
                public void run() {
                    PhotoCategoryDetailViewModel photoCategoryDetailViewModel = PhotoCategoryDetailViewModel.this;
                    PhotoCategorySummaryInfo a26 = photoCategoryDetailViewModel.a2(photoCategorySummaryInfo, photoCategoryDetailViewModel.J);
                    PhotoCategoryDetailViewModel.this.C.postValue(a26);
                    PhotoCategoryDetailViewModel.this.Z1(activity, a26);
                }
            });
            return;
        }
        QZLog.w("[PhotoAlbum]PhotoCategoryDetailViewModel", 1, "intent == null");
    }

    public void Z1(Activity activity, PhotoCategorySummaryInfo photoCategorySummaryInfo) {
        QZLog.d("[PhotoAlbum]PhotoCategoryDetailViewModel", 1, "loadPicInfoListFromDbCache...");
        if (photoCategorySummaryInfo != null) {
            ArrayList<PhotoCategorySinglePicInfo> a06 = AlbumCacheDataManager.J().a0(this.J, photoCategorySummaryInfo.categoryType, photoCategorySummaryInfo.categoryId, 1, 0, u4.c.a().k(activity) ? 100 : 0);
            Object[] objArr = new Object[2];
            objArr[0] = "infos size:";
            objArr[1] = Integer.valueOf(a06 != null ? a06.size() : 0);
            QZLog.d("[PhotoAlbum]PhotoCategoryDetailViewModel", 1, objArr);
            this.D.postValue(a06);
            W1();
            return;
        }
        QZLog.w("[PhotoAlbum]PhotoCategoryDetailViewModel", 1, "photoCategorySummaryInfo == null");
        this.D.postValue(null);
    }

    public void b2(Intent intent) {
        String str;
        String str2;
        QZLog.d("[PhotoAlbum]PhotoCategoryDetailViewModel", 1, "modifyNick... ");
        if (intent != null) {
            String stringExtra = intent.getStringExtra("extra_choose_friend_uin");
            String stringExtra2 = intent.getStringExtra("extra_choose_friend_name");
            String stringExtra3 = intent.getStringExtra("extraChooseFriendRemark");
            if (TextUtils.isEmpty(stringExtra3)) {
                str = stringExtra;
                str2 = stringExtra2;
            } else {
                str2 = stringExtra3;
                str = stringExtra;
            }
        } else {
            str = null;
            str2 = null;
        }
        if (str != null && str.length() > 0) {
            this.I = 1;
        } else {
            this.I = 2;
        }
        QZLog.d("[PhotoAlbum]PhotoCategoryDetailViewModel", 2, "modifyNick opEration:", Integer.valueOf(this.I), " uinString:", str, " nickname:", str2);
        this.f42378i.s(this.J, this.I, this.C.getValue(), str, str2, new b());
    }

    public void d2(ArrayList<String> arrayList) {
        QZLog.d("[PhotoAlbum]PhotoCategoryDetailViewModel", 1, "onDeletePhotoFromPictureViewerResult... ");
        if (this.D.getValue() == null || this.D.getValue().size() <= 0 || arrayList == null || arrayList.size() <= 0 || this.C.getValue() == null) {
            return;
        }
        this.C.getValue().photoNumber -= arrayList.size();
        Iterator<PhotoCategorySinglePicInfo> it = this.D.getValue().iterator();
        while (it.hasNext()) {
            PhotoCategorySinglePicInfo next = it.next();
            if (next.lloc.equals(arrayList.get(0))) {
                it.remove();
                this.f42378i.C(next, 1, this.C.getValue());
            }
        }
        MutableLiveData<ArrayList<PhotoCategorySinglePicInfo>> mutableLiveData = this.D;
        mutableLiveData.postValue(mutableLiveData.getValue());
        this.H = true;
        this.f42378i.N0(16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        QZLog.d("[PhotoAlbum]PhotoCategoryDetailViewModel", 1, "onCleared...");
    }

    public void P1() {
        this.I = 5;
        QZLog.d("[PhotoAlbum]PhotoCategoryDetailViewModel", 1, "deleteGroup... opEration : " + this.I);
        this.f42378i.t(this.J, this.I, null, this.C.getValue(), new c());
    }

    public void W1() {
        QZLog.d("[PhotoAlbum]PhotoCategoryDetailViewModel", 1, "loadAlbumsCache...");
        this.E.postValue(AlbumCacheDataManager.J().G(this.J));
    }

    public void e2(boolean z16, String str, ArrayList<String> arrayList, String str2) {
        QZLog.d("[PhotoAlbum]PhotoCategoryDetailViewModel", 1, "onEditPhotoDescResult... succeeded:", Boolean.valueOf(z16));
        if (!z16 || arrayList == null || this.D.getValue() == null || this.D.getValue().size() <= 0) {
            return;
        }
        Iterator<PhotoCategorySinglePicInfo> it = this.D.getValue().iterator();
        while (it.hasNext()) {
            PhotoCategorySinglePicInfo next = it.next();
            if (next.lloc.equals(arrayList.get(0))) {
                next.singlePicInfo.desc = str2;
                this.f42379m.f0(next, 1);
            }
        }
    }

    public void f2(QZonePersonalAlbumRecentAdapter qZonePersonalAlbumRecentAdapter, String str, boolean z16, String str2, int i3, int i16) {
        PhotoCacheData v3;
        String str3;
        QZLog.d("[PhotoAlbum]PhotoCategoryDetailViewModel", 1, "onEventLikeResult... returnCode:", Integer.valueOf(i16));
        if (i16 != 0 || (v3 = qZonePersonalAlbumRecentAdapter.v(str2)) == null || v3.appid == 311 || this.D.getValue() == null || this.D.getValue().size() <= 0) {
            return;
        }
        Iterator<PhotoCategorySinglePicInfo> it = this.D.getValue().iterator();
        while (it.hasNext()) {
            PhotoCategorySinglePicInfo next = it.next();
            if (next != null && (str3 = next.lloc) != null && str3.equals(v3.lloc)) {
                next.singlePicInfo.updatePhotoPraiseAndCount(z16);
                this.f42379m.f0(next, 1);
            }
        }
    }

    public void g2(s sVar, boolean z16) {
        QZLog.d("[PhotoAlbum]PhotoCategoryDetailViewModel", 1, "onGetCategoryDetailResult... isMore:", Boolean.valueOf(z16));
        if (sVar != null && sVar.getSucceed() && sVar.getData() != null) {
            if (!z16) {
                this.D.getValue().clear();
            }
            QZoneGetCategoryDetailReq.a aVar = (QZoneGetCategoryDetailReq.a) sVar.getData();
            this.D.getValue().addAll(aVar.f43905a);
            MutableLiveData<ArrayList<PhotoCategorySinglePicInfo>> mutableLiveData = this.D;
            mutableLiveData.postValue(mutableLiveData.getValue());
            PhotoCategorySummaryInfo photoCategorySummaryInfo = aVar.f43907c;
            if (this.C.getValue() != null && photoCategorySummaryInfo != null && !z16) {
                this.C.getValue().avatarUrl = photoCategorySummaryInfo.avatarUrl;
                this.C.getValue().photoNumber = photoCategorySummaryInfo.photoNumber;
                this.C.getValue().nick = photoCategorySummaryInfo.nick;
                this.C.getValue().groupid_list = photoCategorySummaryInfo.groupid_list;
                this.C.getValue().faceUin = photoCategorySummaryInfo.faceUin;
                this.C.getValue().faceStatus = photoCategorySummaryInfo.faceStatus;
                MutableLiveData<PhotoCategorySummaryInfo> mutableLiveData2 = this.C;
                mutableLiveData2.postValue(mutableLiveData2.getValue());
            }
        } else {
            this.F.postValue(-1);
        }
        this.G = false;
    }

    public void h2(boolean z16, String str, String str2, String str3) {
        QZLog.d("[PhotoAlbum]PhotoCategoryDetailViewModel", 1, "onRecentPhotoCommentedResult... succeeded:", Boolean.valueOf(z16));
        if (z16 && str2 != null && this.D.getValue() != null && this.D.getValue().size() > 0) {
            Iterator<PhotoCategorySinglePicInfo> it = this.D.getValue().iterator();
            while (it.hasNext()) {
                PhotoCategorySinglePicInfo next = it.next();
                if (next.lloc.equals(str2)) {
                    next.singlePicInfo.cmtnum++;
                    this.f42379m.f0(next, 1);
                }
            }
        }
    }

    public void i2(final boolean z16) {
        QZLog.d("[PhotoAlbum]PhotoCategoryDetailViewModel", 1, "requestList... isGetMore:", Boolean.valueOf(z16));
        this.G = true;
        if (!z16 && this.D.getValue() != null) {
            this.D.getValue().clear();
        }
        if (this.C.getValue() != null) {
            HashMap hashMap = new HashMap();
            GetCategoryDetailReqItem getCategoryDetailReqItem = new GetCategoryDetailReqItem();
            getCategoryDetailReqItem.categoryid = this.C.getValue().categoryId;
            getCategoryDetailReqItem.type = this.C.getValue().categoryType;
            String str = "";
            if (!z16) {
                getCategoryDetailReqItem.page_str = "";
            } else {
                if (this.D.getValue() != null && this.D.getValue().size() > 0) {
                    str = this.D.getValue().get(this.D.getValue().size() - 1).pageStr;
                }
                getCategoryDetailReqItem.page_str = str;
            }
            hashMap.put(Integer.valueOf(this.C.getValue().categoryType), getCategoryDetailReqItem);
            this.f42378i.P(this.J, hashMap, z16, new AbsCompatRequest.a() { // from class: com.qzone.album.business.albumlist.viewmodel.PhotoCategoryDetailViewModel.2
                @Override // com.qzone.album.protocol.AbsCompatRequest.a
                public void a(AbsCompatRequest absCompatRequest, s sVar, int i3, String str2) {
                    PhotoCategoryDetailViewModel.this.F.postValue(1);
                    if (i3 == 0) {
                        QZLog.d("[PhotoAlbum]PhotoCategoryDetailViewModel", 1, "requestList success");
                        PhotoCategoryDetailViewModel.this.g2(sVar, z16);
                        com.qzone.album.env.common.a.m().u().post(new Runnable() { // from class: com.qzone.album.business.albumlist.viewmodel.PhotoCategoryDetailViewModel.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PhotoCategoryDetailViewModel.this.W1();
                            }
                        });
                        return;
                    }
                    QZLog.w("[PhotoAlbum]PhotoCategoryDetailViewModel", 1, "requestList failed ");
                }
            });
            return;
        }
        QZLog.w("[PhotoAlbum]PhotoCategoryDetailViewModel", 1, "mPhotoCategorySummaryInfo.getValue() == null");
    }
}
