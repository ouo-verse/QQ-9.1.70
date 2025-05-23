package com.qzone.album.business.albumlist.viewmodel;

import NS_MOBILE_PHOTO.ListAllCategoryReqItem;
import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import com.qzone.adapter.feedcomponent.s;
import com.qzone.album.data.AlbumCacheDataManager;
import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.qzone.album.protocol.AbsCompatRequest;
import com.qzone.album.protocol.QZoneCategoryOpReq;
import com.qzone.album.protocol.QZoneListAllCategoryReq;
import com.qzone.album.util.e;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes39.dex */
public class a extends ViewModel {
    public long E;
    public int K;

    /* renamed from: i, reason: collision with root package name */
    protected com.qzone.album.base.Service.a f42394i;

    /* renamed from: m, reason: collision with root package name */
    protected AlbumCacheDataManager f42395m;
    protected MutableLiveData<ArrayList<PhotoCategorySummaryInfo>> C = new MutableLiveData<>();
    protected MutableLiveData<Integer> D = new MutableLiveData<>();
    public String F = "";
    public String G = "";
    private int H = 4;
    public boolean I = true;
    public boolean J = false;
    int L = 0;
    int M = -1;

    /* compiled from: P */
    /* renamed from: com.qzone.album.business.albumlist.viewmodel.a$a, reason: collision with other inner class name */
    /* loaded from: classes39.dex */
    class C0318a implements Function<ArrayList<PhotoCategorySummaryInfo>, LiveData<Boolean>> {
        C0318a() {
        }

        @Override // androidx.arch.core.util.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public MutableLiveData<Boolean> apply(ArrayList<PhotoCategorySummaryInfo> arrayList) {
            MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>();
            if (arrayList != null && arrayList.size() > 0) {
                boolean z16 = arrayList.get(arrayList.size() - 1).hasMore == 1;
                a aVar = a.this;
                aVar.G = aVar.F;
                if (!TextUtils.isEmpty(arrayList.get(arrayList.size() - 1).pageStr)) {
                    a.this.F = arrayList.get(arrayList.size() - 1).pageStr;
                }
                mutableLiveData.setValue(Boolean.valueOf(z16));
                QZLog.d("[PhotoAlbum]PhotoCategoryViewModel", 1, "HasMore apply...\n mPageStr:", a.this.F);
            }
            return mutableLiveData;
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class b implements AbsCompatRequest.a {
        b() {
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.a
        public void a(AbsCompatRequest absCompatRequest, s sVar, int i3, String str) {
            a.this.U1(sVar, absCompatRequest.isGetMore());
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class c implements AbsCompatRequest.a {
        c() {
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.a
        public void a(AbsCompatRequest absCompatRequest, s sVar, int i3, String str) {
            a.this.W1(sVar);
        }
    }

    public a() {
        QZLog.d("[PhotoAlbum]PhotoCategoryViewModel", 1, "init PhotoCategoryViewModel...");
        this.E = com.qzone.album.env.common.a.m().s();
        this.f42394i = com.qzone.album.base.Service.a.W();
        this.f42395m = AlbumCacheDataManager.J();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W1(s sVar) {
        PhotoCategorySummaryInfo photoCategorySummaryInfo;
        Object data = sVar.getData();
        if (sVar.getSucceed() && (data instanceof QZoneCategoryOpReq.a)) {
            QZoneCategoryOpReq.a aVar = (QZoneCategoryOpReq.a) data;
            if (aVar.f43901a == 0) {
                if (this.C.getValue() != null && this.C.getValue().size() > 0 && (photoCategorySummaryInfo = aVar.f43904d) != null && !TextUtils.isEmpty(photoCategorySummaryInfo.categoryId)) {
                    if (this.C.getValue().size() > this.K && this.C.getValue().get(this.K) != null) {
                        this.C.getValue().get(this.K).photoNumber = aVar.f43904d.photoNumber;
                        this.C.getValue().get(this.K).nick = aVar.f43904d.nick;
                        this.C.getValue().get(this.K).faceStatus = aVar.f43904d.faceStatus;
                    }
                    for (int i3 = 0; i3 < this.C.getValue().size(); i3++) {
                        if (this.C.getValue().get(i3) != null && aVar.f43904d.categoryId.equals(this.C.getValue().get(i3).categoryId)) {
                            this.C.getValue().get(i3).photoNumber = aVar.f43904d.photoNumber;
                            this.C.getValue().get(i3).nick = aVar.f43904d.nick;
                            this.C.getValue().get(i3).faceStatus = aVar.f43904d.faceStatus;
                        }
                    }
                }
                MutableLiveData<ArrayList<PhotoCategorySummaryInfo>> mutableLiveData = this.C;
                mutableLiveData.postValue(mutableLiveData.getValue());
                this.J = true;
                return;
            }
            this.D.postValue(8);
        }
    }

    private void Z1(ArrayList<PhotoCategorySummaryInfo> arrayList, boolean z16) {
        ArrayList<PhotoCategorySummaryInfo> value = this.C.getValue();
        if (value == null) {
            value = new ArrayList<>();
        }
        if (!z16) {
            this.F = "";
            this.G = "";
            value.clear();
            this.I = true;
            this.L = 0;
        }
        if (arrayList == null || arrayList.size() <= 0) {
            if (z16) {
                return;
            }
            this.D.postValue(7);
        } else {
            value.addAll(arrayList);
            this.C.postValue(value);
            QZLog.d("[PhotoAlbum]PhotoCategoryViewModel", 1, "processSummaryInfo...\n", " getMore:", Boolean.valueOf(z16), " request items size:", Integer.valueOf(arrayList.size()), " all items size:", Integer.valueOf(value.size()));
        }
    }

    public MutableLiveData<Boolean> O1() {
        return (MutableLiveData) Transformations.switchMap(this.C, new C0318a());
    }

    public int P1() {
        return this.H;
    }

    public MutableLiveData<ArrayList<PhotoCategorySummaryInfo>> Q1() {
        return this.C;
    }

    public MutableLiveData<Integer> R1() {
        return this.D;
    }

    public boolean X1() {
        if (this.F == null) {
            this.F = "";
        }
        return !this.F.equals(this.G);
    }

    public void a2(Activity activity) {
        QZLog.d("[PhotoAlbum]PhotoCategoryViewModel", 1, "readIntentData...");
        Intent b16 = u4.c.a().b(activity);
        if (b16 != null) {
            this.H = b16.getIntExtra("categorybusitype", 1);
        }
        this.E = com.qzone.album.env.common.a.m().s();
        if (e.a(0) != null) {
            QZLog.i(QZLog.TO_DEVICE_TAG, 2, "[PhotoAlbum]PhotoCategoryViewModelget Drawable not null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U1(s sVar, boolean z16) {
        QZLog.d("[PhotoAlbum]PhotoCategoryViewModel", 1, "onCategoryListResult... getmore:", Boolean.valueOf(z16));
        Object data = sVar.getData();
        if (sVar.getSucceed() && (data instanceof QZoneListAllCategoryReq.a)) {
            Z1(((QZoneListAllCategoryReq.a) data).f43952a, z16);
        }
    }

    public void N1(int i3, PhotoCategorySummaryInfo photoCategorySummaryInfo, String str, String str2) {
        QZLog.d("[PhotoAlbum]PhotoCategoryViewModel", 1, "categoryOpConfirm... opCode:", Integer.valueOf(i3), " faceuin:", str, " nick:", str2);
        com.qzone.album.base.Service.a.W().s(this.E, i3, photoCategorySummaryInfo, str, str2, new c());
    }

    public void S1(boolean z16) {
        QZLog.d("[PhotoAlbum]PhotoCategoryViewModel", 1, "listAllCategory... loadMore:", Boolean.valueOf(z16));
        if (!z16) {
            this.F = "";
            this.G = "";
        }
        this.G = this.F;
        HashMap hashMap = new HashMap();
        ListAllCategoryReqItem listAllCategoryReqItem = new ListAllCategoryReqItem();
        listAllCategoryReqItem.page_str = this.F;
        hashMap.put(Integer.valueOf(this.H), listAllCategoryReqItem);
        com.qzone.album.base.Service.a.W().G0(this.E, hashMap, z16, new b());
    }

    public void T1(Activity activity) {
        QZLog.d("[PhotoAlbum]PhotoCategoryViewModel", 1, "loadDbCache...");
        Z1(AlbumCacheDataManager.J().Z(this.E, this.H), false);
    }
}
