package com.qzone.business.lbsv2.business;

import com.qzone.common.activities.base.BaseActivity;
import com.qzone.reborn.configx.g;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.report.QzoneLbsReporter;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes39.dex */
class QZoneNewJustLocation extends LbsManagerServiceOnLocationChangeListener implements b {

    /* renamed from: g, reason: collision with root package name */
    private static Object f44529g = new Object();

    /* renamed from: h, reason: collision with root package name */
    private static ConcurrentHashMap<String, QZoneNewJustLocation> f44530h = new ConcurrentHashMap<>();

    /* renamed from: a, reason: collision with root package name */
    private boolean f44531a;

    /* renamed from: b, reason: collision with root package name */
    private LbsDataV2.GpsInfo f44532b;

    /* renamed from: c, reason: collision with root package name */
    private long f44533c;

    /* renamed from: d, reason: collision with root package name */
    private long f44534d;

    /* renamed from: e, reason: collision with root package name */
    private String f44535e;

    /* renamed from: f, reason: collision with root package name */
    private long f44536f;

    public static QZoneNewJustLocation h(String str) {
        QZoneNewJustLocation qZoneNewJustLocation = f44530h.get(str);
        if (qZoneNewJustLocation == null) {
            synchronized (f44529g) {
                qZoneNewJustLocation = f44530h.get(str);
                if (qZoneNewJustLocation == null) {
                    qZoneNewJustLocation = new QZoneNewJustLocation(str);
                    f44530h.put(str, qZoneNewJustLocation);
                }
            }
        }
        return qZoneNewJustLocation;
    }

    @Override // com.qzone.business.lbsv2.business.b
    public LbsDataV2.GpsInfo a() {
        SosoLbsInfo cachedLbsInfo = ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo(this.f44535e);
        QzoneLbsReporter.reportLocationCacheResult(cachedLbsInfo != null, this.f44535e);
        QZLog.i("QZoneNewJustLocation.NewLbsInterface", 1, "[QZ_LBS_MODULE]----getCurrGps");
        if (cachedLbsInfo != null) {
            return LbsDataV2.convertFromSoso(cachedLbsInfo.mLocation);
        }
        return null;
    }

    @Override // com.qzone.business.lbsv2.business.b
    public double b() {
        int i3;
        SosoLbsInfo cachedLbsInfo = ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo(this.f44535e);
        QzoneLbsReporter.reportLocationCacheResult(cachedLbsInfo != null, this.f44535e);
        QZLog.i("QZoneNewJustLocation.NewLbsInterface", 1, "[QZ_LBS_MODULE]----getLatitdue");
        LbsDataV2.GpsInfo convertFromSoso = cachedLbsInfo != null ? LbsDataV2.convertFromSoso(cachedLbsInfo.mLocation) : null;
        if (convertFromSoso == null || (i3 = convertFromSoso.lat) == LbsDataV2.GPS_DEFAULT_VALUE) {
            return Double.MIN_VALUE;
        }
        return (i3 * 1.0d) / 1000000.0d;
    }

    @Override // com.qzone.business.lbsv2.business.b
    public LbsDataV2.GpsInfo c() {
        SosoLbsInfo cachedLbsInfo = ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo(this.f44535e);
        QzoneLbsReporter.reportLocationCacheResult(cachedLbsInfo != null, this.f44535e);
        QZLog.i("QZoneNewJustLocation.NewLbsInterface", 1, "[QZ_LBS_MODULE]----getGpsInfo");
        LbsDataV2.GpsInfo convertFromSoso = cachedLbsInfo != null ? LbsDataV2.convertFromSoso(cachedLbsInfo.mLocation) : null;
        if (convertFromSoso == null) {
            if (BaseApplication.getContext() != null && BaseApplication.getContext().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
                return null;
            }
            if (!g.f53821a.b().q()) {
                QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).post(new Runnable() { // from class: com.qzone.business.lbsv2.business.QZoneNewJustLocation.1
                    @Override // java.lang.Runnable
                    public void run() {
                        QZoneNewJustLocation.h(QZoneNewJustLocation.this.f44535e).f();
                    }
                });
            } else {
                QLog.e("QZoneRequest", 2, "disable silent locate in QZoneNewJustLocation getGpsInfo");
            }
        }
        return convertFromSoso;
    }

    @Override // com.qzone.business.lbsv2.business.b
    public double d() {
        int i3;
        SosoLbsInfo cachedLbsInfo = ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo(this.f44535e);
        QzoneLbsReporter.reportLocationCacheResult(cachedLbsInfo != null, this.f44535e);
        QZLog.i("QZoneNewJustLocation.NewLbsInterface", 1, "[QZ_LBS_MODULE]----getLongtitude");
        LbsDataV2.GpsInfo convertFromSoso = cachedLbsInfo != null ? LbsDataV2.convertFromSoso(cachedLbsInfo.mLocation) : null;
        if (convertFromSoso == null || (i3 = convertFromSoso.lon) == LbsDataV2.GPS_DEFAULT_VALUE) {
            return Double.MIN_VALUE;
        }
        return (i3 * 1.0d) / 1000000.0d;
    }

    @Override // com.qzone.business.lbsv2.business.b
    public LbsDataV2.PoiInfo e() {
        SosoLbsInfo cachedLbsInfo = ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo(this.f44535e);
        QzoneLbsReporter.reportLocationCacheResult(cachedLbsInfo != null, this.f44535e);
        QZLog.i("QZoneNewJustLocation.NewLbsInterface", 1, "[QZ_LBS_MODULE]----getCurrPoiInfo");
        if (cachedLbsInfo != null) {
            return LbsDataV2.convertPoiInfoFromSoso(cachedLbsInfo.mLocation);
        }
        return null;
    }

    @Override // com.qzone.business.lbsv2.business.b
    public void f() {
        if (BaseActivity.getisStratActivity()) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                if (!this.f44531a && currentTimeMillis - this.f44533c >= this.f44534d) {
                    this.f44533c = currentTimeMillis;
                    this.f44531a = true;
                    QZLog.i("QZoneNewJustLocation", "[QZ_LBS_MODULE] startLocation");
                    this.f44536f = System.currentTimeMillis();
                    ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).startLocation(this);
                    return;
                }
                QZLog.i("QZoneNewJustLocation", "[QZ_LBS_MODULE] mIsGettingLocation = " + this.f44531a + ", (now - mLastGetLocationTime) ) = " + ((currentTimeMillis - this.f44533c) / 1000) + ", so return");
            } catch (Exception e16) {
                QZLog.e("QZoneNewJustLocation", "[QZ_LBS_MODULE]exception ", e16);
            }
        }
    }

    @Override // com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener
    public void onLocationFinish(int i3, SosoLbsInfo sosoLbsInfo) {
        if (i3 == 0) {
            this.f44534d = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_LOCATE_INTERVAL, 60000L);
            this.f44532b = LbsDataV2.convertFromSoso(sosoLbsInfo.mLocation);
            QZLog.i("QZoneNewJustLocation.NewLbsInterface", 1, "[QZ_LBS_MODULE]#onGetDeviceData succeed! just location--->gps=" + this.f44532b);
        } else {
            if (i3 == 2) {
                this.f44534d *= 10;
            } else {
                this.f44534d *= 2;
            }
            QZLog.e("QZoneNewJustLocation.NewLbsInterface", "[QZ_LBS_MODULE]location failed: error in force gps info update..");
        }
        this.f44531a = false;
        QzoneLbsReporter.reportLocationResult(i3, this.f44535e, System.currentTimeMillis() - this.f44536f);
    }

    QZoneNewJustLocation(String str) {
        super(str, false);
        this.f44531a = false;
        this.f44534d = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_LOCATE_INTERVAL, 60000L);
        this.f44535e = str;
    }
}
