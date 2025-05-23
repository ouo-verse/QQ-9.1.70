package com.tencent.mobileqq.onlinestatus.auto.location.cache;

import com.tencent.lbssearch.httpresponse.Poi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

/* compiled from: P */
/* loaded from: classes16.dex */
abstract class b {

    /* renamed from: b, reason: collision with root package name */
    protected static String f255530b = "Loader";

    /* renamed from: a, reason: collision with root package name */
    protected final String f255531a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(String str) {
        this.f255531a = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(LatLng latLng, LatLng latLng2, int i3) {
        if (latLng != null && latLng2 != null) {
            double b16 = gc2.a.b(latLng, latLng2);
            if (QLog.isColorLevel()) {
                QLog.d(f255530b, 2, "[status][poiLoader][" + this.f255531a + "] accept? this.latLng: " + latLng + " that.latLng: " + latLng2 + " distance: " + b16 + " acceptAccuracy: " + i3);
            }
            if (b16 >= i3) {
                return false;
            }
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f255530b, 2, "[status][poiLoader][" + this.f255531a + "] accept? fail this.latLng: " + latLng + " that.latLng: " + latLng2);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(String str, PoiBean poiBean) {
        String str2;
        Poi[] poiArr;
        if (QLog.isColorLevel()) {
            if (poiBean != null && (poiArr = poiBean.poiArray) != null && poiArr.length > 0) {
                QLog.d(f255530b, 2, "[status][poiLoader][" + this.f255531a + "] from: " + str + " size: " + poiBean.poiArray.length);
                Poi poi = poiBean.poiArray[0];
                QLog.d(f255530b, 2, "[status][poiLoader][" + this.f255531a + "] from: " + str + " first poi: " + poi.latLng + "-" + poi._distance);
                Poi[] poiArr2 = poiBean.poiArray;
                if (poiArr2.length >= 2) {
                    Poi poi2 = poiArr2[1];
                    QLog.d(f255530b, 2, "[status][poiLoader][" + this.f255531a + "] from: " + str + " second poi: " + poi2.latLng + "-" + poi2._distance);
                    return;
                }
                return;
            }
            String str3 = f255530b;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[status][poiLoader][");
            sb5.append(this.f255531a);
            sb5.append("] from: ");
            sb5.append(str);
            sb5.append(" result: ");
            if (poiBean != null && poiBean.poiArray != null) {
                str2 = "0";
            } else {
                str2 = "null";
            }
            sb5.append(str2);
            QLog.d(str3, 2, sb5.toString());
        }
    }
}
