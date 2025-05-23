package o8;

import NS_MOBILE_PHOTO.GetCategoryDetailReqItem;
import android.os.Bundle;
import android.text.TextUtils;
import com.qzone.adapter.feedcomponent.s;
import com.qzone.album.business.search.SearchFilterComposition;
import com.qzone.album.data.AlbumCacheDataManager;
import com.qzone.album.data.model.AlbumCacheData;
import com.qzone.album.data.model.PhotoCacheData;
import com.qzone.album.data.model.PhotoCategorySinglePicInfo;
import com.qzone.album.protocol.AbsCompatRequest;
import com.qzone.album.protocol.QZoneGetCategoryDetailReq;
import com.qzone.album.protocol.QZoneGetPhotoSearchRequest;
import com.qzone.album.protocol.QZoneGetRecentPhotoListByTimeLineRequest;
import com.qzone.album.protocol.QZoneQunViewPhotoRequest;
import com.qzone.album.protocol.QZoneViewPhotoRequest;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.event.EventCenter;
import com.qzone.preview.PictureViewerFactory;
import com.tencent.util.Pair;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.model.PhotoParam;
import cooperation.qzone.remote.Callback;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b implements o8.a {

    /* renamed from: a, reason: collision with root package name */
    private AbsCompatRequest.a f422194a = new a();

    /* compiled from: P */
    /* loaded from: classes38.dex */
    class a implements AbsCompatRequest.a {
        a() {
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.a
        public void a(AbsCompatRequest absCompatRequest, s sVar, int i3, String str) {
            QZoneResult qZoneResult = new QZoneResult();
            qZoneResult.setSucceed(sVar.getSucceed());
            qZoneResult.setReturnCode(sVar.getReturnCode());
            qZoneResult.setMessage(qZoneResult.getMessage());
            Bundle bundle = qZoneResult.getBundle();
            if (absCompatRequest.getParam("type") instanceof Integer) {
                bundle.putInt("type", ((Integer) absCompatRequest.getParam("type")).intValue());
            }
            if (sVar.getData() instanceof QZoneViewPhotoRequest.a) {
                bundle.putSerializable("response", ((QZoneViewPhotoRequest.a) sVar.getData()).f43977a);
            }
            if (sVar.getData() instanceof QZoneQunViewPhotoRequest.a) {
                bundle.putSerializable("response", ((QZoneQunViewPhotoRequest.a) sVar.getData()).f43975a);
            }
            Callback callback = (Callback) absCompatRequest.getParam("callback");
            if (callback != null) {
                callback.onResult(qZoneResult);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: o8.b$b, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    class C10893b implements AbsCompatRequest.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Callback f422196a;

        C10893b(Callback callback) {
            this.f422196a = callback;
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.a
        public void a(AbsCompatRequest absCompatRequest, s sVar, int i3, String str) {
            QZoneResult qZoneResult = new QZoneResult();
            qZoneResult.setSucceed(sVar.getSucceed());
            qZoneResult.setReturnCode(sVar.getReturnCode());
            qZoneResult.setMessage(sVar.getMessage());
            if (sVar.getSucceed()) {
                qZoneResult.getBundle().putSerializable("response", sVar.getBundle().getSerializable("response"));
            }
            Callback callback = this.f422196a;
            if (callback != null) {
                callback.onResult(qZoneResult);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    class d implements AbsCompatRequest.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Callback f422202a;

        d(Callback callback) {
            this.f422202a = callback;
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.a
        public void a(AbsCompatRequest absCompatRequest, s sVar, int i3, String str) {
            QZoneResult qZoneResult = new QZoneResult();
            qZoneResult.setReturnCode(sVar.getReturnCode());
            qZoneResult.setSucceed(sVar.getSucceed());
            qZoneResult.setMessage(sVar.getMessage());
            if (sVar.getSucceed() && (sVar.getData() instanceof QZoneGetCategoryDetailReq.a)) {
                QZoneGetCategoryDetailReq.a aVar = (QZoneGetCategoryDetailReq.a) sVar.getData();
                Pair<ArrayList<AlbumCacheData>, ArrayList<PhotoCacheData>> w3 = PictureViewerFactory.w(aVar.f43905a);
                ArrayList<PhotoParam> l06 = PictureViewerFactory.l0(w3.first);
                ArrayList<PhotoInfo> e06 = PictureViewerFactory.e0(w3.second);
                qZoneResult.setSucceed(true);
                qZoneResult.getBundle().putBoolean("hasMore", aVar.f43908d);
                qZoneResult.getBundle().putParcelableArrayList("photoParamList", l06);
                qZoneResult.getBundle().putParcelableArrayList("responseList", e06);
            }
            Callback callback = this.f422202a;
            if (callback != null) {
                callback.onResult(qZoneResult);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    class e implements AbsCompatRequest.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Callback f422204a;

        e(Callback callback) {
            this.f422204a = callback;
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.a
        public void a(AbsCompatRequest absCompatRequest, s sVar, int i3, String str) {
            QZoneResult qZoneResult = new QZoneResult();
            qZoneResult.setReturnCode(sVar.getReturnCode());
            qZoneResult.setSucceed(sVar.getSucceed());
            qZoneResult.setMessage(sVar.getMessage());
            if (sVar.getSucceed() && (sVar.getData() instanceof QZoneGetRecentPhotoListByTimeLineRequest.a)) {
                QZoneGetRecentPhotoListByTimeLineRequest.a aVar = (QZoneGetRecentPhotoListByTimeLineRequest.a) sVar.getData();
                ArrayList<PhotoInfo> e06 = PictureViewerFactory.e0(aVar.f43940a);
                qZoneResult.setSucceed(true);
                qZoneResult.getBundle().putBoolean("hasMore", aVar.f43943d == 1);
                qZoneResult.getBundle().putInt("direction", 2);
                qZoneResult.getBundle().putParcelableArrayList("responseList", e06);
            }
            Callback callback = this.f422204a;
            if (callback != null) {
                callback.onResult(qZoneResult);
            }
            EventCenter.getInstance().post("QzoneAlbum", 31, 2, sVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    class f implements AbsCompatRequest.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Callback f422206a;

        f(Callback callback) {
            this.f422206a = callback;
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.a
        public void a(AbsCompatRequest absCompatRequest, s sVar, int i3, String str) {
            QZoneResult qZoneResult = new QZoneResult();
            qZoneResult.setReturnCode(sVar.getReturnCode());
            qZoneResult.setSucceed(sVar.getSucceed());
            qZoneResult.setMessage(sVar.getMessage());
            if (sVar.getSucceed() && (sVar.getData() instanceof QZoneGetRecentPhotoListByTimeLineRequest.a)) {
                QZoneGetRecentPhotoListByTimeLineRequest.a aVar = (QZoneGetRecentPhotoListByTimeLineRequest.a) sVar.getData();
                ArrayList<PhotoInfo> e06 = PictureViewerFactory.e0(aVar.f43940a);
                qZoneResult.setSucceed(true);
                qZoneResult.getBundle().putBoolean("hasMore", aVar.f43943d == 1);
                qZoneResult.getBundle().putInt("direction", 1);
                qZoneResult.getBundle().putParcelableArrayList("responseList", e06);
            }
            Callback callback = this.f422206a;
            if (callback != null) {
                callback.onResult(qZoneResult);
            }
            EventCenter.getInstance().post("QzoneAlbum", 31, 1, sVar);
        }
    }

    @Override // o8.a
    public void a(Long l3, Callback callback) {
        com.qzone.album.base.Service.a.W().w0(l3.longValue(), 0L, 0L, 1, new f(callback));
    }

    @Override // o8.a
    public void b(Long l3, String str, String str2, String str3, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, String str4, HashMap<Integer, String> hashMap, Integer num6, String str5, Integer num7, Long l16, Integer num8, Long l17, Callback callback) {
        int intValue = num7.intValue();
        if (intValue == 0) {
            if (num8.intValue() == 6) {
                AbsCompatRequest A0 = com.qzone.album.base.Service.a.W().A0(l3.longValue(), str, str2, str3, num.intValue(), num2.intValue(), num3.intValue(), num4.intValue(), num5.intValue(), str4, hashMap, num6.intValue(), str5, l16.longValue(), num8.intValue(), l17.longValue(), this.f422194a);
                A0.addParam("callback", callback);
                A0.addParam("type", 75);
                return;
            } else {
                AbsCompatRequest C0 = com.qzone.album.base.Service.a.W().C0(l3.longValue(), str, str2, str3, num.intValue(), num2.intValue(), num3.intValue(), num4.intValue(), num5.intValue(), str4, hashMap, num6.intValue(), str5, l16.longValue(), this.f422194a);
                C0.addParam("callback", callback);
                C0.addParam("type", 4);
                return;
            }
        }
        if (intValue == 1) {
            AbsCompatRequest B0 = com.qzone.album.base.Service.a.W().B0(l3.longValue(), str, str2, str3, num.intValue(), num2.intValue(), num3.intValue(), num4.intValue(), num5.intValue(), str4, hashMap, num6.intValue(), str5, l16.longValue(), num8.intValue(), l17.longValue(), this.f422194a);
            B0.addParam("callback", callback);
            B0.addParam("type", 5);
        } else {
            if (intValue != 2) {
                return;
            }
            AbsCompatRequest D0 = com.qzone.album.base.Service.a.W().D0(l3.longValue(), str, str2, str3, num.intValue(), num2.intValue(), num3.intValue(), num4.intValue(), num5.intValue(), str4, hashMap, num6.intValue(), str5, l16.longValue(), num8.intValue(), l17.longValue(), this.f422194a);
            D0.addParam("callback", callback);
            D0.addParam("type", 6);
        }
    }

    @Override // o8.a
    public void c(Long l3, Integer num, String str, String str2, Callback callback) {
        HashMap hashMap = new HashMap();
        GetCategoryDetailReqItem getCategoryDetailReqItem = new GetCategoryDetailReqItem();
        getCategoryDetailReqItem.type = num.intValue();
        getCategoryDetailReqItem.categoryid = str;
        getCategoryDetailReqItem.page_str = str2;
        hashMap.put(num, getCategoryDetailReqItem);
        com.qzone.album.base.Service.a.W().R(l3.longValue(), hashMap, true, new d(callback));
    }

    @Override // o8.a
    public void d(Long l3, String str, SearchFilterComposition searchFilterComposition, String str2, Callback callback) {
        com.qzone.album.base.Service.a.W().c0(l3.longValue(), str, searchFilterComposition.typesSeq, searchFilterComposition.toChosenItemMap(), str2, new c(l3, str, callback), true);
    }

    @Override // o8.a
    public void e(Long l3, Integer num, Integer num2, Integer num3, Callback callback) {
        ArrayList<PhotoInfo> e06 = PictureViewerFactory.e0(AlbumCacheDataManager.J().W(l3.longValue(), num.intValue(), num2.intValue(), num3.intValue()));
        QZoneResult qZoneResult = new QZoneResult();
        qZoneResult.setSucceed(true);
        qZoneResult.getBundle().putInt("start", num.intValue());
        qZoneResult.getBundle().putParcelableArrayList("cacheList", e06);
        if (callback != null) {
            callback.onResult(qZoneResult);
        }
    }

    @Override // o8.a
    public void f(Long l3, Callback callback) {
        com.qzone.album.base.Service.a.W().w0(l3.longValue(), 0L, 0L, 2, new e(callback));
    }

    @Override // o8.a
    public void g(Long l3, String str, Integer num, Integer num2, Callback callback) {
        ArrayList<PhotoInfo> e06 = PictureViewerFactory.e0(AlbumCacheDataManager.J().F(str, num.intValue(), num2.intValue()));
        QZoneResult qZoneResult = new QZoneResult();
        qZoneResult.setSucceed(true);
        qZoneResult.getBundle().putInt("start", num.intValue());
        qZoneResult.getBundle().putParcelableArrayList("cacheList", e06);
        if (callback != null) {
            callback.onResult(qZoneResult);
        }
    }

    @Override // o8.a
    public void h(Integer num, Long l3, String str, String str2, String str3, Integer num2, Integer num3, Integer num4, String str4, HashMap<Integer, String> hashMap, Callback callback) {
        QZLog.i("REMOTECALL", " @getQunQzonePhotoListEx");
    }

    @Override // o8.a
    public void i(Long l3, Integer num, String str, Integer num2, Integer num3, Callback callback) {
        PhotoCacheData photoCacheData;
        ArrayList<PhotoCategorySinglePicInfo> P = AlbumCacheDataManager.J().P(l3.longValue(), num.intValue(), str, 1, num2.intValue(), num3.intValue());
        ArrayList arrayList = new ArrayList();
        if (P != null && P.size() > 0) {
            Iterator<PhotoCategorySinglePicInfo> it = P.iterator();
            while (it.hasNext()) {
                PhotoCategorySinglePicInfo next = it.next();
                if (next != null && (photoCacheData = next.singlePicInfo) != null) {
                    arrayList.add(photoCacheData);
                }
            }
        }
        ArrayList<PhotoInfo> e06 = PictureViewerFactory.e0(arrayList);
        QZoneResult qZoneResult = new QZoneResult();
        qZoneResult.setSucceed(true);
        qZoneResult.getBundle().putInt("start", num2.intValue());
        qZoneResult.getBundle().putParcelableArrayList("cacheList", e06);
        if (callback != null) {
            callback.onResult(qZoneResult);
        }
    }

    @Override // o8.a
    public void j(Long l3, Integer num, Callback callback) {
        com.qzone.album.base.Service.a.W().m0(l3.longValue(), num.intValue(), new C10893b(callback));
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    class c implements AbsCompatRequest.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Long f422198a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f422199b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Callback f422200c;

        c(Long l3, String str, Callback callback) {
            this.f422198a = l3;
            this.f422199b = str;
            this.f422200c = callback;
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.a
        public void a(AbsCompatRequest absCompatRequest, s sVar, int i3, String str) {
            ArrayList<PhotoCacheData> arrayList;
            if (sVar != null && sVar.getSucceed() && (sVar.getData() instanceof QZoneGetPhotoSearchRequest.a)) {
                QZoneResult qZoneResult = new QZoneResult();
                qZoneResult.setReturnCode(sVar.getReturnCode());
                qZoneResult.setSucceed(sVar.getSucceed());
                qZoneResult.setMessage(sVar.getMessage());
                QZoneGetPhotoSearchRequest.a aVar = (QZoneGetPhotoSearchRequest.a) sVar.getData();
                AlbumCacheData x16 = AlbumCacheDataManager.J().x(this.f422198a.longValue(), this.f422199b);
                if (x16 != null && !TextUtils.isEmpty(x16.albumname) && (arrayList = aVar.f43935e) != null && !arrayList.isEmpty()) {
                    Iterator<PhotoCacheData> it = aVar.f43935e.iterator();
                    while (it.hasNext()) {
                        PhotoCacheData next = it.next();
                        if (next != null) {
                            next.albumName = x16.albumname;
                        }
                    }
                }
                ArrayList<PhotoInfo> e06 = PictureViewerFactory.e0(aVar.f43935e);
                qZoneResult.getBundle().putBoolean("hasMore", aVar.f43938h);
                qZoneResult.getBundle().putParcelableArrayList("responseList", e06);
                qZoneResult.getBundle().putString("attachInfo", aVar.f43937g);
                Callback callback = this.f422200c;
                if (callback != null) {
                    callback.onResult(qZoneResult);
                }
            }
        }
    }
}
