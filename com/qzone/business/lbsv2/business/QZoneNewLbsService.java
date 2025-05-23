package com.qzone.business.lbsv2.business;

import LBS_V2_PROTOCOL.Cell_V2;
import LBS_V2_PROTOCOL.ForecastInfo;
import LBS_V2_PROTOCOL.GPS_V2;
import LBS_V2_PROTOCOL.GeoInfoCell_V2;
import LBS_V2_PROTOCOL.GeoInfo_V2;
import LBS_V2_PROTOCOL.GetBatchGeoRsp_V2;
import LBS_V2_PROTOCOL.GetBatchPoiRsp_V2;
import LBS_V2_PROTOCOL.GetLbsCombinReq_V2;
import LBS_V2_PROTOCOL.GetLbsCombinRsp_V2;
import LBS_V2_PROTOCOL.GetPoiInfoRsp_V2;
import LBS_V2_PROTOCOL.PoiInfoCell_V2;
import LBS_V2_PROTOCOL.PoiInfo_V2;
import LBS_V2_PROTOCOL.WeatherInfo_V2;
import LBS_V2_PROTOCOL.Wifi_V2;
import android.os.Handler;
import android.text.TextUtils;
import com.qzone.business.lbsv2.business.protocol.GetBatchGeoRequest;
import com.qzone.business.lbsv2.business.protocol.GetBatchPoiRequest;
import com.qzone.business.lbsv2.business.protocol.GetCombinInfoRequest;
import com.qzone.business.lbsv2.business.protocol.GetPoiListRequset;
import com.qzone.common.business.IQZoneServiceListener;
import com.qzone.common.business.QZoneBusinessLooper;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.common.event.Observable;
import com.qzone.common.protocol.request.QZoneRequest;
import com.qzone.proxy.personalitycomponent.manager.QzoneWidgetService;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheWeatherData;
import com.qzone.proxy.personalitycomponent.model.WidgetWeatherData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqnt.kernel.nativeinterface.WiFiPhotoErrorCode;
import common.config.service.QzoneConfig;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.model.GpsInfo4LocalImage;
import cooperation.qzone.model.LocalImageShootInfo;
import cooperation.qzone.report.QzoneLbsReporter;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes39.dex */
class QZoneNewLbsService extends Observable implements IQZoneServiceListener, com.qzone.business.lbsv2.business.d {

    /* renamed from: d, reason: collision with root package name */
    private boolean f44538d;

    /* renamed from: e, reason: collision with root package name */
    private SosoLbsInfo f44539e;

    /* renamed from: f, reason: collision with root package name */
    private String f44540f;

    /* renamed from: h, reason: collision with root package name */
    private int f44541h;

    /* renamed from: i, reason: collision with root package name */
    private int f44542i;

    /* renamed from: m, reason: collision with root package name */
    private static Object f44537m = new Object();
    private static ConcurrentHashMap<String, QZoneNewLbsService> C = new ConcurrentHashMap<>();

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a extends LbsManagerServiceOnLocationChangeListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f44551a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Handler f44552b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f44553c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f44554d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f44555e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, boolean z16, long j3, Handler handler, String str2, String str3, int i3) {
            super(str, z16);
            this.f44551a = j3;
            this.f44552b = handler;
            this.f44553c = str2;
            this.f44554d = str3;
            this.f44555e = i3;
        }

        @Override // com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener
        public void onLocationFinish(int i3, SosoLbsInfo sosoLbsInfo) {
            QZLog.i("QZoneNewLbsService.NewLbsInterface", 1, "[QZ_LBS_MODULE]----getMorePoiList");
            QzoneLbsReporter.reportLocationResult(i3, QZoneNewLbsService.this.f44540f, System.currentTimeMillis() - this.f44551a);
            if (sosoLbsInfo == null) {
                QZoneResult qZoneResult = new QZoneResult(999990);
                qZoneResult.setSucceed(false);
                qZoneResult.sendToHandler(this.f44552b);
                return;
            }
            GPS_V2 b16 = k5.b.b(sosoLbsInfo.mLocation);
            ArrayList<Wifi_V2> e16 = k5.b.e(sosoLbsInfo.mWifis);
            ArrayList<Cell_V2> d16 = k5.b.d(sosoLbsInfo.mCells);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[QZ_LBS_MODULE]#getMorePoiList gps param=");
            sb5.append(b16);
            sb5.append(",wifilist=");
            sb5.append((e16 == null || e16.size() <= 4) ? e16 : e16.subList(0, 3));
            sb5.append(",celllist=");
            sb5.append(d16);
            sb5.append(".");
            QZLog.i("QZoneNewLbsService", 1, sb5.toString());
            QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new GetPoiListRequset(b16, d16, e16, this.f44553c, this.f44554d, this.f44555e), this.f44552b, QZoneNewLbsService.this, 3));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class b extends LbsManagerServiceOnLocationChangeListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f44557a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Handler f44558b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f44559c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, boolean z16, long j3, Handler handler, int i3) {
            super(str, z16);
            this.f44557a = j3;
            this.f44558b = handler;
            this.f44559c = i3;
        }

        @Override // com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener
        public void onLocationFinish(int i3, SosoLbsInfo sosoLbsInfo) {
            QZLog.i("QZoneNewLbsService.NewLbsInterface", 1, "[QZ_LBS_MODULE]----refreshWidgetInfo onLocationFinish");
            QzoneLbsReporter.reportLocationResult(i3, QZoneNewLbsService.this.f44540f, System.currentTimeMillis() - this.f44557a);
            if (sosoLbsInfo != null) {
                QZoneNewLbsService.this.M(sosoLbsInfo, this.f44559c, this.f44558b);
                return;
            }
            QZoneResult qZoneResult = new QZoneResult(1000015);
            qZoneResult.setSucceed(false);
            qZoneResult.sendToHandler(this.f44558b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class c extends LbsManagerServiceOnLocationChangeListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList f44561a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f44562b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Handler f44563c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f44564d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f44565e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f44566f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ Map f44567g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(String str, boolean z16, ArrayList arrayList, int i3, Handler handler, long j3, int i16, int i17, Map map) {
            super(str, z16);
            this.f44561a = arrayList;
            this.f44562b = i3;
            this.f44563c = handler;
            this.f44564d = j3;
            this.f44565e = i16;
            this.f44566f = i17;
            this.f44567g = map;
        }

        @Override // com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener
        public void onLocationFinish(int i3, SosoLbsInfo sosoLbsInfo) {
            ArrayList arrayList;
            if (QLog.isColorLevel()) {
                QZLog.i("QZoneNewLbsService.NewLbsInterface", 1, "[QZ_LBS_MODULE]----refreshPoiList");
            }
            if (sosoLbsInfo == null && ((arrayList = this.f44561a) == null || arrayList.size() == 0)) {
                QZoneResult qZoneResult = new QZoneResult(this.f44562b);
                qZoneResult.setSucceed(false);
                qZoneResult.sendToHandler(this.f44563c);
                return;
            }
            QzoneLbsReporter.reportLocationResult(i3, QZoneNewLbsService.this.f44540f, System.currentTimeMillis() - this.f44564d);
            ArrayList arrayList2 = new ArrayList();
            if (sosoLbsInfo != null) {
                arrayList2.add(LbsDataV2.convertFromSoso(sosoLbsInfo.mLocation));
            }
            ArrayList arrayList3 = this.f44561a;
            if (arrayList3 != null) {
                int i16 = this.f44562b;
                if (i16 == 8) {
                    arrayList2.add(k5.a.e((GpsInfo4LocalImage) arrayList3.get(0)));
                } else if (i16 == 9) {
                    arrayList2.addAll(k5.a.f(arrayList3));
                }
            }
            QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new GetBatchPoiRequest(arrayList2, this.f44565e, this.f44566f, this.f44567g, false), this.f44563c, QZoneNewLbsService.this, this.f44562b));
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class d extends LbsManagerServiceOnLocationChangeListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f44569a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Handler f44570b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f44571c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f44572d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(String str, boolean z16, long j3, Handler handler, String str2, int i3) {
            super(str, z16);
            this.f44569a = j3;
            this.f44570b = handler;
            this.f44571c = str2;
            this.f44572d = i3;
        }

        @Override // com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener
        public void onLocationFinish(int i3, SosoLbsInfo sosoLbsInfo) {
            QZLog.i("QZoneNewLbsService.NewLbsInterface", 1, "[QZ_LBS_MODULE]----refreshPoiList");
            QzoneLbsReporter.reportLocationResult(i3, QZoneNewLbsService.this.f44540f, System.currentTimeMillis() - this.f44569a);
            if (sosoLbsInfo == null) {
                QZoneResult qZoneResult = new QZoneResult(999989);
                qZoneResult.setSucceed(false);
                qZoneResult.sendToHandler(this.f44570b);
                return;
            }
            GPS_V2 b16 = k5.b.b(sosoLbsInfo.mLocation);
            ArrayList<Wifi_V2> e16 = k5.b.e(sosoLbsInfo.mWifis);
            ArrayList<Cell_V2> d16 = k5.b.d(sosoLbsInfo.mCells);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[QZ_LBS_MODULE]#refreshPoiList gps param=");
            sb5.append(b16);
            sb5.append(",wifilist=");
            sb5.append((e16 == null || e16.size() <= 4) ? e16 : e16.subList(0, 3));
            sb5.append(",celllist=");
            sb5.append(d16);
            sb5.append(".");
            QZLog.i("QZoneNewLbsService", 1, sb5.toString());
            QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new GetPoiListRequset(b16, d16, e16, this.f44571c, (String) null, this.f44572d), this.f44570b, QZoneNewLbsService.this, 2));
        }
    }

    QZoneNewLbsService(String str) {
        super("Lbs");
        this.f44538d = false;
        this.f44541h = -1;
        this.f44542i = 0;
        this.f44540f = str;
    }

    private void K(Handler handler, int i3, ArrayList<GpsInfo4LocalImage> arrayList, int i16, Map<String, String> map, int i17) {
        ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).startLocation(new c(this.f44540f, false, arrayList, i17, handler, System.currentTimeMillis(), i16, i3, map));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(SosoLbsInfo sosoLbsInfo, int i3, Handler handler) {
        GPS_V2 b16 = k5.b.b(sosoLbsInfo.mLocation);
        ArrayList<Wifi_V2> e16 = k5.b.e(sosoLbsInfo.mWifis);
        ArrayList<Cell_V2> d16 = k5.b.d(sosoLbsInfo.mCells);
        LbsDataV2.GeoInfo O = O(d16);
        int i16 = (O == null || O.gpsInfo == null) ? 5 : 13;
        this.f44541h = i16;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[QZ_LBS_MODULE]#getCombininfo gps param=");
        sb5.append(b16);
        sb5.append(",wifilist=");
        sb5.append((e16 == null || e16.size() <= 4) ? e16 : e16.subList(0, 3));
        sb5.append(",celllist=");
        sb5.append(d16);
        sb5.append(".,mode=");
        sb5.append(i16);
        QZLog.i("QZoneNewLbsService", 1, sb5.toString());
        QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new GetCombinInfoRequest(b16, LbsDataV2.convertToGeoInfo_V2(O), d16, e16, 0, 1000015, i3, i16, (ArrayList<String>) null), handler, this, 4));
    }

    public static QZoneNewLbsService P(String str) {
        QZoneNewLbsService qZoneNewLbsService = C.get(str);
        if (qZoneNewLbsService == null) {
            synchronized (f44537m) {
                qZoneNewLbsService = C.get(str);
                if (qZoneNewLbsService == null) {
                    qZoneNewLbsService = new QZoneNewLbsService(str);
                    C.put(str, qZoneNewLbsService);
                }
            }
        }
        return qZoneNewLbsService;
    }

    private void U(QZoneTask qZoneTask) {
        QZoneResult result = qZoneTask.getResult(((GetBatchGeoRequest) qZoneTask.mRequest).eventId);
        if (result.getSucceed()) {
            GetBatchGeoRsp_V2 resp = ((GetBatchGeoRequest) qZoneTask.mRequest).getResp();
            if (resp != null) {
                ArrayList<GeoInfoCell_V2> arrayList = resp.vecGeoInfoCell;
                if (arrayList != null) {
                    i5.a.s().a(arrayList);
                    result.setData(J(arrayList));
                    result.setSucceed(true);
                }
            } else {
                result.setSucceed(false);
            }
        } else {
            result.setSucceed(false);
        }
        if (qZoneTask.getHandler() != null) {
            qZoneTask.sendResultMsg(result);
        }
    }

    private void V(QZoneTask qZoneTask) {
        QZoneResult result = qZoneTask.getResult(((GetBatchPoiRequest) qZoneTask.mRequest).eventId);
        if (result.getSucceed()) {
            GetBatchPoiRsp_V2 resp = ((GetBatchPoiRequest) qZoneTask.mRequest).getResp();
            if (resp != null) {
                ArrayList<PoiInfoCell_V2> arrayList = resp.vecPoiInfoCell;
                if (arrayList != null) {
                    result.setData(c0(arrayList));
                    result.setSucceed(true);
                }
            } else {
                result.setSucceed(false);
            }
        } else {
            result.setSucceed(false);
        }
        if (qZoneTask.getHandler() != null) {
            qZoneTask.sendResultMsg(result);
        }
    }

    private void W(QZoneTask qZoneTask) {
        QZoneResult result = qZoneTask.getResult(((GetBatchPoiRequest) qZoneTask.mRequest).eventId);
        if (result.getSucceed()) {
            GetBatchPoiRsp_V2 resp = ((GetBatchPoiRequest) qZoneTask.mRequest).getResp();
            if (resp != null) {
                ArrayList<PoiInfoCell_V2> arrayList = resp.vecPoiInfoCell;
                if (arrayList != null) {
                    result.setData(c0(arrayList));
                    result.setSucceed(true);
                }
            } else {
                result.setSucceed(false);
            }
        } else {
            result.setSucceed(false);
        }
        if (qZoneTask.getHandler() != null) {
            qZoneTask.sendResultMsg(result);
        }
    }

    private void X(QZoneTask qZoneTask) {
        String str;
        LbsDataV2.GetGeoInfoRsp getGeoInfoRsp;
        WeatherInfo_V2 weatherInfo_V2;
        ArrayList<ForecastInfo> arrayList;
        GetPoiInfoRsp_V2 getPoiInfoRsp_V2;
        QZoneResult result = qZoneTask.getResult(((GetCombinInfoRequest) qZoneTask.mRequest).eventId);
        if (result.getSucceed()) {
            GetLbsCombinRsp_V2 resp = ((GetCombinInfoRequest) qZoneTask.mRequest).getResp();
            if (resp != null) {
                f0(resp.request_id);
                j5.c cVar = new j5.c();
                LocalImageShootInfo localImageShootInfo = ((GetCombinInfoRequest) qZoneTask.mRequest).gpsImageInfo;
                int i3 = resp.iMood;
                if ((localImageShootInfo == null ? 0L : localImageShootInfo.captureTime) != 0) {
                    str = j5.c.a(localImageShootInfo.captureTime);
                } else {
                    str = "";
                }
                cVar.f409270b = str;
                if ((i3 & 1) <= 0 || resp.stGeoInfo == null) {
                    getGeoInfoRsp = null;
                } else {
                    getGeoInfoRsp = new LbsDataV2.GetGeoInfoRsp();
                    getGeoInfoRsp.stGps = LbsDataV2.convertToGpsInfo(resp.stGps);
                    getGeoInfoRsp.stGeoInfo = LbsDataV2.convertToGeoInfo(resp.stGeoInfo);
                    if (localImageShootInfo != null) {
                        i5.a.s().d(getGeoInfoRsp.stGeoInfo, localImageShootInfo.gpsInfo);
                    }
                    i5.a.s().B(getGeoInfoRsp.stGeoInfo);
                }
                if ((i3 & 2) > 0 && (getPoiInfoRsp_V2 = resp.stPoiInfo) != null && getPoiInfoRsp_V2.vPoiList != null) {
                    ArrayList<LbsDataV2.PoiInfo> arrayList2 = new ArrayList<>();
                    for (int i16 = 0; i16 < resp.stPoiInfo.vPoiList.size(); i16++) {
                        arrayList2.add(LbsDataV2.convertToPoiInfo(resp.stPoiInfo.vPoiList.get(i16)));
                    }
                    result.getBundle().putString("attachinfo", resp.stPoiInfo.strAttachInfo);
                    result.setHasMore(resp.stPoiInfo.iTotalNum >= 16);
                    if (arrayList2.size() > 0) {
                        LbsDataV2.PoiInfo poiInfo = arrayList2.get(0);
                        if (getGeoInfoRsp == null) {
                            getGeoInfoRsp = new LbsDataV2.GetGeoInfoRsp();
                            getGeoInfoRsp.stGps = poiInfo.gpsInfo;
                            LbsDataV2.GeoInfo geoBody = ((GetCombinInfoRequest) qZoneTask.mRequest).getGeoBody();
                            if (geoBody == null) {
                                geoBody = new LbsDataV2.GeoInfo();
                            }
                            getGeoInfoRsp.stGeoInfo = geoBody;
                            geoBody.iDistrictCode = poiInfo.districtCode;
                            geoBody.strCountry = poiInfo.country;
                            geoBody.strProvince = poiInfo.province;
                            geoBody.strCity = poiInfo.city;
                            geoBody.strDefaultName = poiInfo.poiDefaultName;
                        }
                        if (localImageShootInfo != null) {
                            k5.a.e(localImageShootInfo.gpsInfo);
                        }
                        LbsDataV2.PoiList poiList = new LbsDataV2.PoiList();
                        poiList.geoInfo = LbsDataV2.GetGeoInfoRsp.convertTo(getGeoInfoRsp);
                        poiList.poiInfos = arrayList2;
                        cVar.f409271c = poiList;
                    }
                }
                if ((i3 & 4) > 0 && (weatherInfo_V2 = resp.stWeather) != null && (arrayList = weatherInfo_V2.vecForecastInfo) != null && arrayList.size() > 0) {
                    cVar.f409269a = resp.stWeather.vecForecastInfo.get(0).strDayWeather;
                    i5.b.e().k(WidgetCacheWeatherData.createFromResponse(resp.stWeather), localImageShootInfo);
                }
                result.setData(cVar);
                result.setSucceed(true);
            } else {
                result.setSucceed(false);
            }
        } else {
            result.setSucceed(false);
        }
        if (qZoneTask.getHandler() != null) {
            qZoneTask.sendResultMsg(result);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x01b5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void Y(QZoneTask qZoneTask) {
        boolean z16;
        GetPoiInfoRsp_V2 getPoiInfoRsp_V2;
        int i3;
        int appId = ((GetCombinInfoRequest) qZoneTask.mRequest).getAppId();
        QZoneRequest qZoneRequest = qZoneTask.mRequest;
        int i16 = ((GetCombinInfoRequest) qZoneRequest).eventId;
        int mode = ((GetCombinInfoRequest) qZoneRequest).getMode();
        QZoneResult result = qZoneTask.getResult(i16);
        if (appId == 100209 || appId == 100202) {
            this.f44538d = false;
        }
        GetLbsCombinRsp_V2 resp = ((GetCombinInfoRequest) qZoneTask.mRequest).getResp();
        if (result.getSucceed() && resp != null) {
            f0(resp.request_id);
            if (mode == 1) {
                LbsDataV2.GetGeoInfoRsp getGeoInfoRsp = new LbsDataV2.GetGeoInfoRsp();
                getGeoInfoRsp.stGps = LbsDataV2.convertToGpsInfo(resp.stGps);
                getGeoInfoRsp.stGeoInfo = LbsDataV2.convertToGeoInfo(resp.stGeoInfo);
                result.setData(getGeoInfoRsp);
                e0((GetLbsCombinReq_V2) qZoneTask.mRequest.req, resp);
                r4 = true;
            } else {
                LbsDataV2.PoiList poiList = new LbsDataV2.PoiList();
                int i17 = resp.iMood;
                boolean z17 = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_LBS_SPECIAL_LOGIC_ON, 1) == 1;
                int config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_LBS_SPECIAL_LOGIC_MAX_RETRY_COUNT, 2);
                LbsDataV2.GetGeoInfoRsp getGeoInfoRsp2 = null;
                if (z17 && (i3 = this.f44541h) != -1 && i3 != i17 && (i3 & 4) > 0) {
                    QZLog.i("QZoneNewLbsService", 1, "[QZ_LBS_MODULE]#onGetLbsCombinFinish \u6709\u95ee\u9898\uff01\uff01\uff01 requestmood " + mode);
                    if (this.f44542i < config) {
                        this.f44539e = null;
                        this.f44541h = -1;
                        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).postDelayed(new Runnable() { // from class: com.qzone.business.lbsv2.business.QZoneNewLbsService.6
                            @Override // java.lang.Runnable
                            public void run() {
                                QZLog.i("QZoneNewLbsService", 1, "[QZ_LBS_MODULE]#onGetLbsCombinFinish \u6709\u95ee\u9898 and refresh");
                                QZoneNewLbsService.this.b(null, WiFiPhotoErrorCode.ERR_FILEBRIDGE_NOT_FILE);
                                QZoneNewLbsService.this.f44542i++;
                            }
                        }, 500L);
                        return;
                    } else {
                        QZLog.i("QZoneNewLbsService", 1, "[QZ_LBS_MODULE]#onGetLbsCombinFinish reach max retry count");
                        if ((mode & 4) > 0) {
                            T(result.getMessage());
                        }
                    }
                }
                this.f44541h = -1;
                QZLog.i("QZoneNewLbsService", 1, "[QZ_LBS_MODULE]#onGetLbsCombinFinish mode = ", Integer.valueOf(i17));
                if ((i17 & 1) > 0 && resp.stGeoInfo != null) {
                    getGeoInfoRsp2 = new LbsDataV2.GetGeoInfoRsp();
                    getGeoInfoRsp2.stGps = LbsDataV2.convertToGpsInfo(resp.stGps);
                    getGeoInfoRsp2.stGeoInfo = LbsDataV2.convertToGeoInfo(resp.stGeoInfo);
                    QZLog.i("QZoneNewLbsService", 1, "[QZ_LBS_MODULE]#onGetLbsCombinFinish will saveCurrentGeoInfo.");
                    e0((GetLbsCombinReq_V2) qZoneTask.mRequest.req, resp);
                }
                if ((i17 & 2) > 0 && (getPoiInfoRsp_V2 = resp.stPoiInfo) != null && getPoiInfoRsp_V2.vPoiList != null) {
                    ArrayList arrayList = new ArrayList();
                    for (int i18 = 0; i18 < resp.stPoiInfo.vPoiList.size(); i18++) {
                        arrayList.add(LbsDataV2.convertToPoiInfo(resp.stPoiInfo.vPoiList.get(i18)));
                    }
                    result.setHasMore(resp.stPoiInfo.iTotalNum >= 16);
                    result.getBundle().putString("attachinfo", resp.stPoiInfo.strAttachInfo);
                    if (arrayList.size() > 0) {
                        poiList.poiInfos.addAll(arrayList);
                        LbsDataV2.PoiInfo poiInfo = (LbsDataV2.PoiInfo) arrayList.get(0);
                        if (getGeoInfoRsp2 == null) {
                            getGeoInfoRsp2 = new LbsDataV2.GetGeoInfoRsp();
                            getGeoInfoRsp2.stGps = poiInfo.gpsInfo;
                            LbsDataV2.GeoInfo geoBody = ((GetCombinInfoRequest) qZoneTask.mRequest).getGeoBody();
                            if (geoBody == null) {
                                geoBody = new LbsDataV2.GeoInfo();
                            }
                            getGeoInfoRsp2.stGeoInfo = geoBody;
                            geoBody.iDistrictCode = poiInfo.districtCode;
                            geoBody.strCountry = poiInfo.country;
                            geoBody.strProvince = poiInfo.province;
                            geoBody.strCity = poiInfo.city;
                            geoBody.strDefaultName = poiInfo.poiDefaultName;
                        }
                        poiList.geoInfo = LbsDataV2.GetGeoInfoRsp.convertTo(getGeoInfoRsp2);
                        result.setData(poiList);
                    } else {
                        z16 = false;
                        if ((i17 & 4) > 0) {
                            WeatherInfo_V2 weatherInfo_V2 = resp.stWeather;
                            if (weatherInfo_V2 != null && weatherInfo_V2.iRet >= 0) {
                                WidgetWeatherData createFromResponse = WidgetCacheWeatherData.createFromResponse(weatherInfo_V2);
                                if (createFromResponse != null) {
                                    QZLog.i("QZoneNewLbsService", 1, "[QZ_LBS_MODULE]#onGetLbsCombinFinish getWeather Success data = " + createFromResponse.toString());
                                }
                                g0(createFromResponse);
                                if (QZLog.isColorLevel()) {
                                    StringBuilder sb5 = new StringBuilder();
                                    sb5.append("onGetWidgetInfoFinish succeed: type = 0, widgetData == null ? ");
                                    sb5.append(createFromResponse == null);
                                    QZLog.d("QZoneNewLbsService", 2, sb5.toString());
                                }
                            } else {
                                if (weatherInfo_V2 != null) {
                                    QZLog.i("QZoneNewLbsService", 1, "[QZ_LBS_MODULE]#onGetLbsCombinFinish getWeather fail iRet = " + resp.stWeather.iRet);
                                } else {
                                    QZLog.i("QZoneNewLbsService", 1, "[QZ_LBS_MODULE]#onGetLbsCombinFinish getWeather fail data = null ");
                                }
                                T(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "GetWeatherFail", "\u83b7\u53d6\u5929\u6c14\u4fe1\u606f\u5931\u8d25"));
                            }
                        }
                        r4 = z16;
                    }
                }
                z16 = true;
                if ((i17 & 4) > 0) {
                }
                r4 = z16;
            }
        } else if ((mode & 4) > 0) {
            T(result.getMessage());
        }
        result.setSucceed(r4);
        qZoneTask.sendResultMsg(result);
    }

    private void a0(QZoneTask qZoneTask) {
        QZoneResult result = qZoneTask.getResult(((GetBatchPoiRequest) qZoneTask.mRequest).eventId);
        if (result.getSucceed()) {
            GetBatchPoiRsp_V2 resp = ((GetBatchPoiRequest) qZoneTask.mRequest).getResp();
            if (resp != null) {
                ArrayList<PoiInfoCell_V2> arrayList = resp.vecPoiInfoCell;
                if (arrayList != null) {
                    result.setData(R(arrayList));
                    result.setSucceed(true);
                }
            } else {
                result.setSucceed(false);
            }
        } else {
            result.setSucceed(false);
        }
        if (qZoneTask.getHandler() != null) {
            qZoneTask.sendResultMsg(result);
        }
    }

    private void b0(QZoneTask qZoneTask) {
        QZoneResult result = qZoneTask.getResult(((GetBatchPoiRequest) qZoneTask.mRequest).eventId);
        if (result.getSucceed()) {
            GetBatchPoiRsp_V2 resp = ((GetBatchPoiRequest) qZoneTask.mRequest).getResp();
            if (resp != null) {
                ArrayList<PoiInfoCell_V2> arrayList = resp.vecPoiInfoCell;
                if (arrayList != null) {
                    result.setData(d0(arrayList));
                    result.setSucceed(true);
                }
            } else {
                result.setSucceed(false);
            }
        } else {
            result.setSucceed(false);
        }
        if (qZoneTask.getHandler() != null) {
            qZoneTask.sendResultMsg(result);
        }
    }

    private void f0(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        u5.b.w0("LbsPreferencesName", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, str);
    }

    @Override // com.qzone.business.lbsv2.business.d
    public void A(Handler handler, int i3, ArrayList<GpsInfo4LocalImage> arrayList, int i16) {
        HashMap hashMap = new HashMap();
        hashMap.put("source", "QqCircle");
        K(handler, i3, arrayList, i16, hashMap, 8);
    }

    @Override // com.qzone.business.lbsv2.business.d
    public void a(Handler handler, String str, String str2, int i3) {
        ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).startLocation(new a(this.f44540f, false, System.currentTimeMillis(), handler, str, str2, i3));
    }

    @Override // com.qzone.business.lbsv2.business.d
    public void b(Handler handler, int i3) {
        QZLog.i("QZoneNewLbsService", 1, "[QZ_LBS_MODULE]#refreshWidgetInfo");
        if (BaseApplication.getContext().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
            QZLog.i("QZoneNewLbsService", 1, "[QZ_LBS_MODULE]#no gps permission!");
            notify(5, new Object[0]);
            return;
        }
        SosoLbsInfo cachedLbsInfo = ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo(this.f44540f);
        QzoneLbsReporter.reportLocationCacheResult(cachedLbsInfo != null, this.f44540f);
        if (cachedLbsInfo != null) {
            M(cachedLbsInfo, i3, handler);
            QZLog.i("QZoneNewLbsService.NewLbsInterface", 1, "[QZ_LBS_MODULE]----refreshWidgetInfo");
        } else {
            QZLog.i("QZoneNewLbsService", 1, "[QZ_LBS_MODULE]#refreshWidgetInfo startLocation.");
            ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).startLocation(new b(this.f44540f, false, System.currentTimeMillis(), handler, i3));
        }
    }

    @Override // com.qzone.business.lbsv2.business.d
    public void f(Handler handler, int i3, ArrayList<GpsInfo4LocalImage> arrayList, int i16, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("source", "QqCircle");
        hashMap.put("keyword", str);
        K(handler, i3, arrayList, i16, hashMap, 9);
    }

    @Override // com.qzone.business.lbsv2.business.d
    public void i(Handler handler, String str, int i3) {
        ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).startLocation(new d(this.f44540f, false, System.currentTimeMillis(), handler, str, i3));
    }

    @Override // com.qzone.business.lbsv2.business.d
    public void k(Handler handler, int i3, ArrayList<GpsInfo4LocalImage> arrayList, int i16) {
        HashMap hashMap = new HashMap();
        ArrayList arrayList2 = new ArrayList();
        if (arrayList != null) {
            arrayList2.addAll(k5.a.f(arrayList));
        }
        QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new GetBatchPoiRequest(arrayList2, i16, i3, hashMap, true), handler, this, 10));
    }

    @Override // com.qzone.common.business.IQZoneServiceListener
    public void onTaskResponse(QZoneTask qZoneTask) {
        if (QZLog.isDevelopLevel()) {
            QZLog.d(QZLog.TO_DEVICE_TAG, 1, "QZoneNewLbsService\t [QZ_LBS_MODULE]onTaskResponse(), task.mType:" + qZoneTask.mType);
        }
        switch (qZoneTask.mType) {
            case 2:
                Z(qZoneTask, true);
                return;
            case 3:
                Z(qZoneTask, false);
                return;
            case 4:
                Y(qZoneTask);
                return;
            case 5:
                U(qZoneTask);
                return;
            case 6:
                X(qZoneTask);
                return;
            case 7:
                V(qZoneTask);
                break;
            case 8:
                break;
            case 9:
                b0(qZoneTask);
                return;
            case 10:
                W(qZoneTask);
                return;
            default:
                return;
        }
        a0(qZoneTask);
    }

    @Override // com.qzone.business.lbsv2.business.d
    public WidgetWeatherData q(boolean z16) {
        QZLog.i("QZoneNewLbsService", 1, "[QZ_LBS_MODULE]#getWeatherFromCache");
        if (z16 && QzoneWidgetService.getBoolean(BaseApplication.getContext(), QzoneWidgetService.WIDGET_DISABLE_CACHE, false)) {
            b(null, WiFiPhotoErrorCode.ERR_FILEBRIDGE_NOT_FILE);
            return null;
        }
        WidgetCacheWeatherData h16 = i5.b.e().h();
        QZLog.i("QZoneNewLbsService.NewLbsInterface", 1, "[QZ_LBS_MODULE]----getWeatherFromCache");
        WidgetWeatherData convertToBusinessData = h16 != null ? WidgetCacheWeatherData.convertToBusinessData(h16) : null;
        if (convertToBusinessData != null) {
            QZLog.i("QZoneNewLbsService", 1, "[QZ_LBS_MODULE]#getWeatherFromCache getWeather cache success data = " + convertToBusinessData.toString());
        }
        return convertToBusinessData;
    }

    @Override // com.qzone.business.lbsv2.business.d
    public void y(final Handler handler, String str, final int i3, final int i16, boolean z16, final ArrayList<String> arrayList) {
        QZLog.i(QZLog.TO_DEVICE_TAG, 1, "[QZ_LBS_MODULE]refreshPoiList forceRefresh:" + z16);
        final long currentTimeMillis = System.currentTimeMillis();
        ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).startLocation(new LbsManagerServiceOnLocationChangeListener(this.f44540f, false) { // from class: com.qzone.business.lbsv2.business.QZoneNewLbsService.5
            @Override // com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener
            public void onLocationFinish(int i17, final SosoLbsInfo sosoLbsInfo) {
                QZLog.i("QZoneNewLbsService.NewLbsInterface", 1, "[QZ_LBS_MODULE]----refreshPoiList2");
                QzoneLbsReporter.reportLocationResult(i17, QZoneNewLbsService.this.f44540f, System.currentTimeMillis() - currentTimeMillis);
                if (sosoLbsInfo == null) {
                    QZoneResult qZoneResult = new QZoneResult(i3);
                    qZoneResult.setSucceed(false);
                    qZoneResult.sendToHandler(handler);
                    return;
                }
                QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).post(new Runnable() { // from class: com.qzone.business.lbsv2.business.QZoneNewLbsService.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        LbsDataV2.GpsInfo convertFromSoso = LbsDataV2.convertFromSoso(sosoLbsInfo.mLocation);
                        ArrayList<Cell_V2> d16 = k5.b.d(sosoLbsInfo.mCells);
                        ArrayList<Wifi_V2> e16 = k5.b.e(sosoLbsInfo.mWifis);
                        LbsDataV2.GeoInfo O = QZoneNewLbsService.O(d16);
                        AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                        QZoneNewLbsService qZoneNewLbsService = QZoneNewLbsService.this;
                        qZoneNewLbsService.Q(handler, convertFromSoso, O, d16, e16, 0, i3, i16, qZoneNewLbsService.S(convertFromSoso) | 2, arrayList);
                    }
                });
            }
        });
    }

    private void L(Handler handler, int i3, LocalImageShootInfo localImageShootInfo, int i16, int i17, ArrayList<String> arrayList) {
        GetCombinInfoRequest getCombinInfoRequest = new GetCombinInfoRequest(k5.a.e(localImageShootInfo.gpsInfo), i5.a.s().r(localImageShootInfo.gpsInfo), localImageShootInfo.captureTime, i3, i16, i17, arrayList);
        getCombinInfoRequest.setGepsImageInfo(localImageShootInfo);
        QZoneBusinessLooper.getInstance().runTask(new QZoneTask(getCombinInfoRequest, handler, this, 6));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int S(LbsDataV2.GpsInfo gpsInfo) {
        WidgetWeatherData q16 = q(true);
        SosoLbsInfo cachedLbsInfo = ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo(this.f44540f);
        QzoneLbsReporter.reportLocationCacheResult(cachedLbsInfo != null, this.f44540f);
        int i3 = (cachedLbsInfo == null || O(k5.b.d(cachedLbsInfo.mCells)) != null) ? 2 : 3;
        return (q16 == null || QzoneWidgetService.needUpdateWidget(0, q16, false)) ? i3 | 4 : i3;
    }

    private void T(String str) {
        notify(2, str);
    }

    @Override // com.qzone.business.lbsv2.business.d
    public void B(Handler handler, String str, String str2, boolean z16, int i3, LocalImageShootInfo localImageShootInfo) {
        QZLog.i("QZoneNewLbsService.NewLbsInterface", 1, "[QZ_LBS_MODULE]----getXYPoiList");
        QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new GetPoiListRequset(k5.a.e(localImageShootInfo.gpsInfo), (ArrayList<Cell_V2>) null, (ArrayList<Wifi_V2>) null, str, str2, i3), handler, this, z16 ? 2 : 3));
    }

    private static LbsDataV2.GeoInfo N(LbsDataV2.CellInfo cellInfo) {
        j5.b o16;
        if (cellInfo == null || (o16 = i5.a.s().o(cellInfo)) == null || o16.geoInfoRsp == null || !o16.isGeoInfoValid()) {
            return null;
        }
        return o16.geoInfoRsp.stGeoInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static LbsDataV2.GeoInfo O(ArrayList<Cell_V2> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return null;
        }
        return N(LbsDataV2.covertToCellInfo(arrayList.get(0)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(Handler handler, LbsDataV2.GpsInfo gpsInfo, LbsDataV2.GeoInfo geoInfo, ArrayList<Cell_V2> arrayList, ArrayList<Wifi_V2> arrayList2, int i3, int i16, int i17, int i18, ArrayList<String> arrayList3) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[QZ_LBS_MODULE]#getLbsCombinInfo gps param=");
        sb5.append(gpsInfo);
        sb5.append(",wifilist=");
        sb5.append((arrayList2 == null || arrayList2.size() <= 4) ? arrayList2 : arrayList2.subList(0, 3));
        sb5.append(",celllist=");
        sb5.append(arrayList);
        sb5.append(".");
        QZLog.i("QZoneNewLbsService", 1, sb5.toString());
        QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new GetCombinInfoRequest(gpsInfo, geoInfo, arrayList, arrayList2, i3, i16, i17, i18, arrayList3), handler, this, 4));
    }

    private void g0(WidgetWeatherData widgetWeatherData) {
        if (widgetWeatherData != null) {
            i5.b.e().b(WidgetCacheWeatherData.createFromBusinessData(widgetWeatherData));
            notify(4, widgetWeatherData);
        }
    }

    private ArrayList<LbsDataV2.GeoInfo> J(List<GeoInfoCell_V2> list) {
        if (list == null) {
            return null;
        }
        ArrayList<LbsDataV2.GeoInfo> arrayList = new ArrayList<>(list.size());
        Iterator<GeoInfoCell_V2> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(LbsDataV2.convertToGeoInfo(it.next().stGeoInfo));
        }
        return arrayList;
    }

    private LbsDataV2.PoiList R(ArrayList<PoiInfoCell_V2> arrayList) {
        if (arrayList == null) {
            return null;
        }
        LbsDataV2.PoiList poiList = new LbsDataV2.PoiList();
        ArrayList<LbsDataV2.PoiInfo> arrayList2 = new ArrayList<>(arrayList.size());
        if (arrayList.get(0).vPoiList != null) {
            Iterator<PoiInfo_V2> it = arrayList.get(0).vPoiList.iterator();
            while (it.hasNext()) {
                arrayList2.add(LbsDataV2.convertToPoiInfo(it.next()));
            }
        }
        if (arrayList.size() > 1 && arrayList.get(1).vPoiList != null) {
            for (int i3 = 0; i3 < 5 && i3 < arrayList.get(1).vPoiList.size(); i3++) {
                arrayList2.add(1, LbsDataV2.convertToPoiInfo(arrayList.get(1).vPoiList.get(i3)));
            }
        }
        poiList.poiInfos = arrayList2;
        return poiList;
    }

    private ArrayList<LbsDataV2.PoiInfo> c0(ArrayList<PoiInfoCell_V2> arrayList) {
        PoiInfo_V2 poiInfo_V2;
        if (arrayList == null) {
            return null;
        }
        ArrayList<LbsDataV2.PoiInfo> arrayList2 = new ArrayList<>(arrayList.size());
        Iterator<PoiInfoCell_V2> it = arrayList.iterator();
        while (it.hasNext()) {
            PoiInfoCell_V2 next = it.next();
            ArrayList<PoiInfo_V2> arrayList3 = next.vPoiList;
            if (arrayList3 != null && arrayList3.size() > 0) {
                poiInfo_V2 = next.vPoiList.get(0);
            } else {
                poiInfo_V2 = new PoiInfo_V2();
            }
            arrayList2.add(LbsDataV2.convertToPoiInfo(poiInfo_V2));
        }
        return arrayList2;
    }

    private LbsDataV2.PoiList d0(ArrayList<PoiInfoCell_V2> arrayList) {
        ArrayList<PoiInfo_V2> arrayList2;
        if (arrayList == null) {
            return null;
        }
        LbsDataV2.PoiList poiList = new LbsDataV2.PoiList();
        ArrayList<LbsDataV2.PoiInfo> arrayList3 = new ArrayList<>(arrayList.size());
        Iterator<PoiInfoCell_V2> it = arrayList.iterator();
        while (it.hasNext()) {
            PoiInfoCell_V2 next = it.next();
            if (next != null && (arrayList2 = next.vPoiList) != null && arrayList2.size() > 0) {
                LbsDataV2.PoiInfo convertToPoiInfo = LbsDataV2.convertToPoiInfo(next.vPoiList.get(0));
                if (!arrayList3.contains(convertToPoiInfo)) {
                    arrayList3.add(convertToPoiInfo);
                }
            }
        }
        poiList.poiInfos = arrayList3;
        return poiList;
    }

    private void e0(GetLbsCombinReq_V2 getLbsCombinReq_V2, GetLbsCombinRsp_V2 getLbsCombinRsp_V2) {
        GeoInfo_V2 geoInfo_V2;
        if (getLbsCombinReq_V2 == null || getLbsCombinRsp_V2 == null) {
            return;
        }
        if (getLbsCombinRsp_V2.stGps != null) {
            QZLog.i("QZoneNewLbsService", 1, "[QZ_LBS_MODULE]#saveGeoInfo -> saveGps " + getLbsCombinRsp_V2.stGps);
            u5.b.G0(LbsDataV2.convertToGpsInfo(getLbsCombinRsp_V2.stGps), System.currentTimeMillis());
        }
        if (getLbsCombinRsp_V2.stGeoInfo != null) {
            QZLog.i("QZoneNewLbsService", 1, "[QZ_LBS_MODULE]#saveGeoInfo -> saveCurrentGeoInfo " + getLbsCombinRsp_V2.stGeoInfo);
            i5.a.s().B(LbsDataV2.convertToGeoInfo(getLbsCombinRsp_V2.stGeoInfo, getLbsCombinRsp_V2.stGps));
        }
        ArrayList<Cell_V2> arrayList = getLbsCombinReq_V2.vCellData;
        if (arrayList == null || arrayList.size() <= 0 || (geoInfo_V2 = getLbsCombinRsp_V2.stGeoInfo) == null || TextUtils.isEmpty(geoInfo_V2.strDefaultName)) {
            return;
        }
        LbsDataV2.GetGeoInfoRsp getGeoInfoRsp = new LbsDataV2.GetGeoInfoRsp();
        getGeoInfoRsp.stGps = LbsDataV2.convertToGpsInfo(getLbsCombinRsp_V2.stGps);
        getGeoInfoRsp.stGeoInfo = LbsDataV2.convertToGeoInfo(getLbsCombinRsp_V2.stGeoInfo);
        i5.a.s().b(LbsDataV2.covertToCellInfo(getLbsCombinReq_V2.vCellData.get(0)), getGeoInfoRsp);
    }

    @Override // com.qzone.business.lbsv2.business.d
    public void m(Handler handler, String str, int i3, int i16, boolean z16, LocalImageShootInfo localImageShootInfo, ArrayList<String> arrayList) {
        L(handler, i3, localImageShootInfo, i16, 2, arrayList);
    }

    private void Z(QZoneTask qZoneTask, boolean z16) {
        QZoneResult result = qZoneTask.getResult(z16 ? 999989 : 999990);
        GetPoiInfoRsp_V2 resp = ((GetPoiListRequset) qZoneTask.mRequest).getResp();
        if (resp != null && resp.vPoiList != null) {
            f0(resp.request_id);
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < resp.vPoiList.size(); i3++) {
                arrayList.add(LbsDataV2.convertToPoiInfo(resp.vPoiList.get(i3)));
            }
            result.getBundle().putString("attachinfo", resp.strAttachInfo);
            LbsDataV2.PoiList poiList = new LbsDataV2.PoiList();
            poiList.poiInfos.addAll(arrayList);
            result.setHasMore(resp.iHasMore == 1);
            result.setData(poiList);
        } else {
            result.setSucceed(false);
        }
        qZoneTask.sendResultMsg(result);
    }

    @Override // com.qzone.business.lbsv2.business.d
    public void n(Handler handler, int i3, LocalImageShootInfo localImageShootInfo, int i16, int i17) {
        if (localImageShootInfo == null || handler == null) {
            return;
        }
        L(handler, i3, localImageShootInfo, i16, i17, null);
    }
}
