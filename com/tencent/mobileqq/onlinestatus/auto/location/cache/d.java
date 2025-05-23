package com.tencent.mobileqq.onlinestatus.auto.location.cache;

import com.tencent.lbssearch.TencentSearch;
import com.tencent.lbssearch.httpresponse.BaseObject;
import com.tencent.lbssearch.httpresponse.HttpResponseListener;
import com.tencent.lbssearch.httpresponse.Poi;
import com.tencent.lbssearch.object.param.Geo2AddressParam;
import com.tencent.lbssearch.object.result.Geo2AddressResultObject;
import com.tencent.mobileqq.onlinestatus.auto.location.cache.PoiLoader;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.TencentMapInitializer;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.List;
import mqq.app.MobileQQ;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes16.dex */
public class d extends b {

    /* renamed from: c, reason: collision with root package name */
    private TencentSearch f255537c;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class a implements HttpResponseListener<BaseObject> {

        /* renamed from: a, reason: collision with root package name */
        private final PoiLoader.a f255538a;

        /* renamed from: b, reason: collision with root package name */
        private final LatLng f255539b;

        public a(LatLng latLng, PoiLoader.a aVar) {
            this.f255539b = latLng;
            this.f255538a = aVar;
        }

        @Override // com.tencent.map.tools.net.http.HttpResponseListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(int i3, BaseObject baseObject) {
            Geo2AddressResultObject geo2AddressResultObject;
            Geo2AddressResultObject.ReverseAddressResult reverseAddressResult;
            List<Poi> list;
            if (QLog.isColorLevel()) {
                QLog.d(b.f255530b, 2, "[status][poiLoader][" + d.this.f255531a + "] netGet onSuccess. resultCode : " + i3 + " result : " + baseObject);
            }
            if ((baseObject instanceof Geo2AddressResultObject) && (reverseAddressResult = (geo2AddressResultObject = (Geo2AddressResultObject) baseObject).result) != null && (list = reverseAddressResult.pois) != null && list.size() > 0) {
                if (QLog.isColorLevel()) {
                    QLog.d(b.f255530b, 2, "[status][poiLoader][" + d.this.f255531a + "]  netGet invoked success. latLng : " + this.f255539b + " poi_size : " + geo2AddressResultObject.result.pois.size());
                }
                Poi[] poiArr = new Poi[geo2AddressResultObject.result.pois.size()];
                LatLng latLng = this.f255539b;
                Geo2AddressResultObject.ReverseAddressResult reverseAddressResult2 = geo2AddressResultObject.result;
                PoiBean poiBean = new PoiBean(latLng, reverseAddressResult2.ad_info, (Poi[]) reverseAddressResult2.pois.toArray(poiArr));
                d.this.b("netGet", poiBean);
                this.f255538a.a(poiBean);
            }
        }

        @Override // com.tencent.map.tools.net.http.HttpResponseListener
        public void onFailure(int i3, String str, Throwable th5) {
            QLog.e(b.f255530b, 1, th5, "[status][poiLoader][" + d.this.f255531a + "] netGet invoked fail. latLng : " + this.f255539b + " errorCode : " + i3 + " errorMsg : " + str);
            this.f255538a.a(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str) {
        super(str);
        b.f255530b = "NetworkLoader";
        this.f255537c = new TencentSearch(MobileQQ.sMobileQQ);
    }

    public boolean c(LatLng latLng, int i3, PoiLoader.a aVar) {
        if (QLog.isColorLevel()) {
            QLog.e(b.f255530b, 2, "[status][poiLoader][" + this.f255531a + "] netGet. latLng: " + latLng);
        }
        if (!TencentMapInitializer.getAgreePrivacy()) {
            TencentMapInitializer.setAgreePrivacy(true);
        }
        this.f255537c.geo2address(new Geo2AddressParam(latLng).getPoi(true).setPoiOptions(new Geo2AddressParam.PoiOptions().setPolicy(1).setPageSize(fc2.a.f398274a).setPageIndex(0)), new a(latLng, aVar));
        return true;
    }
}
