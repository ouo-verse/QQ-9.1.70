package gc2;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.lbssearch.httpresponse.AdInfo;
import com.tencent.mobileqq.onlinestatus.auto.location.cache.PoiBean;
import com.tencent.mobileqq.onlinestatus.auto.location.cache.PoiLoader;
import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b extends SosoInterfaceOnLocationListener {

    /* renamed from: d, reason: collision with root package name */
    private static PoiLoader f401916d = new PoiLoader("weather", 1000, 3, 1);

    /* renamed from: a, reason: collision with root package name */
    private int f401917a;

    /* renamed from: b, reason: collision with root package name */
    private Intent f401918b;

    /* renamed from: c, reason: collision with root package name */
    private WeakReference<InterfaceC10368b> f401919c;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a implements PoiLoader.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ LatLng f401920a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ SosoLbsInfo f401921b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f401922c;

        a(LatLng latLng, SosoLbsInfo sosoLbsInfo, int i3) {
            this.f401920a = latLng;
            this.f401921b = sosoLbsInfo;
            this.f401922c = i3;
        }

        @Override // com.tencent.mobileqq.onlinestatus.auto.location.cache.PoiLoader.a
        public void a(PoiBean poiBean) {
            AdInfo adInfo;
            String str;
            InterfaceC10368b interfaceC10368b = (InterfaceC10368b) b.this.f401919c.get();
            if (interfaceC10368b == null) {
                if (QLog.isColorLevel()) {
                    QLog.e("OnlineStatusWeatherLocationListener", 2, "[MovementDetector] getPoiWithLatLng error. mCallback is null ");
                    return;
                }
                return;
            }
            if (poiBean != null && (adInfo = poiBean.adInfo) != null) {
                String str2 = "";
                if (TextUtils.isEmpty(adInfo.city)) {
                    str = "";
                } else {
                    str = poiBean.adInfo.city;
                }
                if (!TextUtils.isEmpty(poiBean.adInfo.district)) {
                    str2 = poiBean.adInfo.district;
                }
                String str3 = str + str2;
                gc2.a.e(this.f401921b, poiBean.adInfo.adcode, str3);
                int i3 = this.f401922c;
                LatLng latLng = this.f401920a;
                interfaceC10368b.n(i3, latLng.latitude, latLng.longitude, poiBean.adInfo.adcode, str3, b.this.f401917a, b.this.f401918b);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.e("OnlineStatusWeatherLocationListener", 2, "[MovementDetector] getPoiWithLatLng error. adInfo is null ");
            }
            LatLng latLng2 = this.f401920a;
            interfaceC10368b.n(404, latLng2.latitude, latLng2.longitude, "", "", b.this.f401917a, b.this.f401918b);
        }
    }

    /* compiled from: P */
    /* renamed from: gc2.b$b, reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public interface InterfaceC10368b {
        void n(int i3, double d16, double d17, String str, String str2, int i16, Intent intent);
    }

    public b(int i3, Intent intent, InterfaceC10368b interfaceC10368b) {
        super(3, true, true, 60000L, false, false, "official_location");
        this.f401917a = i3;
        this.f401918b = intent;
        this.f401919c = new WeakReference<>(interfaceC10368b);
    }

    @Override // com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener
    public void onLocationFinish(int i3, SosoLbsInfo sosoLbsInfo) {
        if (this.f401919c.get() == null) {
            if (QLog.isColorLevel()) {
                QLog.e("OnlineStatusWeatherLocationListener", 2, "[MovementDetector] onLocationFinish error. mCallback is null ");
                return;
            }
            return;
        }
        if (sosoLbsInfo != null && i3 == 0) {
            SosoLocation sosoLocation = sosoLbsInfo.mLocation;
            LatLng latLng = new LatLng(sosoLocation.mLat02, sosoLocation.mLon02);
            if (QLog.isColorLevel()) {
                QLog.e("OnlineStatusWeatherLocationListener", 2, "[MovementDetector] onLocationFinish invoked. latLng : " + latLng + " errCode : " + i3);
            }
            try {
                f401916d.f(latLng, new a(latLng, sosoLbsInfo, i3));
                return;
            } catch (Throwable th5) {
                QLog.e("OnlineStatusWeatherLocationListener", 1, "getPoiWithLatLngError", th5);
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.e("OnlineStatusWeatherLocationListener", 2, "[MovementDetector] onLocationFinish error. errCode : " + i3);
        }
        this.f401919c.get().n(i3, 0.0d, 0.0d, "", "", this.f401917a, this.f401918b);
    }
}
