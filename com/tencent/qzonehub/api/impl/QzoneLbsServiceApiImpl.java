package com.tencent.qzonehub.api.impl;

import LBS_V2_PROTOCOL.Cell_V2;
import LBS_V2_PROTOCOL.GetBatchPoiRsp_V2;
import LBS_V2_PROTOCOL.GetLbsCombinRsp_V2;
import LBS_V2_PROTOCOL.GetPoiInfoRsp_V2;
import LBS_V2_PROTOCOL.PoiInfoCell_V2;
import LBS_V2_PROTOCOL.PoiInfo_V2;
import LBS_V2_PROTOCOL.Wifi_V2;
import android.os.Bundle;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.tencent.biz.richframework.network.servlet.VSBaseServlet;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.data.QZoneCommonServlet;
import com.tencent.mobileqq.data.QzoneCommonIntent;
import com.tencent.mobileqq.qcircle.api.IQCirclePoiCallback;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQzoneLbsServiceApi;
import com.tencent.qzonehub.api.ISosoUtils;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.model.GpsInfo4LocalImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.observer.BusinessObserver;

/* compiled from: P */
/* loaded from: classes34.dex */
public class QzoneLbsServiceApiImpl implements IQzoneLbsServiceApi, BusinessObserver {
    private static final String BUSINESSID = "qzone_address_select";
    public static final int MASK_MODE_GEO = 1;
    public static final int MASK_MODE_POI = 2;
    private static final String TAG = "QcircleLbsService";
    private static final int TYPE_GET_BATCHPOI = 0;
    private static final int TYPE_GET_BATCHPOI_FOR_RECOM = 1000;
    private static final int TYPE_GET_BATCHPOI_TESTA = 2;
    private static final int TYPE_GET_BATCH_POI_FOR_QCIRCLE = 1;
    private static final int TYPE_GET_GEO = 1;
    private static final int TYPE_SEARCH_BATCH_POI_FOR_QCIRCLE = 2;
    private static final int mAppId = 100203;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes34.dex */
    public class a extends LbsManagerServiceOnLocationChangeListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f364017a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList f364018b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f364019c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f364020d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f364021e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Map f364022f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, boolean z16, int i3, ArrayList arrayList, long j3, int i16, int i17, Map map) {
            super(str, z16);
            this.f364017a = i3;
            this.f364018b = arrayList;
            this.f364019c = j3;
            this.f364020d = i16;
            this.f364021e = i17;
            this.f364022f = map;
        }

        @Override // com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener
        public void onLocationFinish(int i3, SosoLbsInfo sosoLbsInfo) {
            ArrayList arrayList;
            if (QLog.isColorLevel()) {
                QLog.i(QzoneLbsServiceApiImpl.TAG, 1, "getBatchPoiFromServer");
            }
            if (this.f364017a != 2 || sosoLbsInfo != null || ((arrayList = this.f364018b) != null && arrayList.size() != 0)) {
                AppRuntime app = QzoneLbsServiceApiImpl.this.getApp();
                if (app == null) {
                    QLog.e(QzoneLbsServiceApiImpl.TAG, 1, "getBatchPoiFromServer app == null");
                    return;
                }
                System.currentTimeMillis();
                ArrayList arrayList2 = new ArrayList();
                if (sosoLbsInfo != null) {
                    arrayList2.add(((ISosoUtils) QRoute.api(ISosoUtils.class)).convertFromSoso(sosoLbsInfo.mLocation));
                }
                ArrayList arrayList3 = this.f364018b;
                if (arrayList3 != null) {
                    int i16 = this.f364020d;
                    if (i16 == 1) {
                        arrayList2.add(gz3.a.a((GpsInfo4LocalImage) arrayList3.get(0)));
                    } else if (i16 == 2) {
                        arrayList2.addAll(gz3.a.b(arrayList3));
                    }
                }
                fz3.a aVar = new fz3.a(arrayList2, this.f364021e, this.f364022f, this.f364017a, 1);
                QzoneCommonIntent qzoneCommonIntent = new QzoneCommonIntent(app.getApplication(), QZoneCommonServlet.class);
                qzoneCommonIntent.setRequest(aVar);
                qzoneCommonIntent.setObserver(QzoneLbsServiceApiImpl.this);
                app.startServlet(qzoneCommonIntent);
                return;
            }
            QLog.e(QzoneLbsServiceApiImpl.TAG, 1, "getBatchPoiFromServer error, info == null && (gpsList == null || gpsList.size() == 0)");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes34.dex */
    public class b extends LbsManagerServiceOnLocationChangeListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f364024a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f364025b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f364026c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ArrayList f364027d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, boolean z16, long j3, int i3, int i16, ArrayList arrayList) {
            super(str, z16);
            this.f364024a = j3;
            this.f364025b = i3;
            this.f364026c = i16;
            this.f364027d = arrayList;
        }

        @Override // com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener
        public void onLocationFinish(int i3, SosoLbsInfo sosoLbsInfo) {
            QLog.i("QcircleLbsService.NewLbsInterface", 1, "[QZ_LBS_MODULE]----refreshPoiList2");
            System.currentTimeMillis();
            if (sosoLbsInfo == null) {
                QLog.e(QzoneLbsServiceApiImpl.TAG, 1, "refreshPoiList error, info == null");
                return;
            }
            LbsDataV2.GpsInfo convertFromSoso = ((ISosoUtils) QRoute.api(ISosoUtils.class)).convertFromSoso(sosoLbsInfo.mLocation);
            ArrayList<Cell_V2> d16 = com.tencent.mobileqq.qzone.api.impl.util.a.d(sosoLbsInfo.mCells);
            ArrayList<Wifi_V2> e16 = com.tencent.mobileqq.qzone.api.impl.util.a.e(sosoLbsInfo.mWifis);
            QzoneLbsServiceApiImpl.this.getLbsCombinInfo(convertFromSoso, QzoneLbsServiceApiImpl.getGeoCacheByCell(d16), d16, e16, 0, this.f364025b, this.f364026c, 3, this.f364027d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AppRuntime getApp() {
        return BaseApplicationImpl.getApplication().getRuntime();
    }

    private static LbsDataV2.GeoInfo getGeoCacheByCell(LbsDataV2.CellInfo cellInfo) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getLbsCombinInfo(LbsDataV2.GpsInfo gpsInfo, LbsDataV2.GeoInfo geoInfo, ArrayList<Cell_V2> arrayList, ArrayList<Wifi_V2> arrayList2, int i3, int i16, int i17, int i18, ArrayList<String> arrayList3) {
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("getLbsCombinInfo gps param=");
            sb5.append(gpsInfo);
            sb5.append(",wifilist=");
            sb5.append((arrayList2 == null || arrayList2.size() <= 4) ? arrayList2 : arrayList2.subList(0, 3));
            sb5.append(",celllist=");
            sb5.append(arrayList);
            sb5.append(".");
            QLog.i(TAG, 2, sb5.toString());
        }
        AppRuntime app = getApp();
        if (app == null) {
            QLog.e(TAG, 1, "getLbsCombinInfo app == null");
            return;
        }
        fz3.b bVar = new fz3.b(gpsInfo, geoInfo, arrayList, arrayList2, i3, i16, 100203, i18, arrayList3, 1);
        QzoneCommonIntent qzoneCommonIntent = new QzoneCommonIntent(app.getApplication(), QZoneCommonServlet.class);
        qzoneCommonIntent.setRequest(bVar);
        qzoneCommonIntent.setObserver(this);
        app.startServlet(qzoneCommonIntent);
    }

    private void onGetBatchPoi(int i3, JceStruct jceStruct) {
        if (jceStruct instanceof GetBatchPoiRsp_V2) {
            GetBatchPoiRsp_V2 getBatchPoiRsp_V2 = (GetBatchPoiRsp_V2) jceStruct;
            if (getBatchPoiRsp_V2 != null) {
                ArrayList<PoiInfoCell_V2> arrayList = getBatchPoiRsp_V2.vecPoiInfoCell;
                if (arrayList != null) {
                    ((IQCirclePoiCallback) QRoute.api(IQCirclePoiCallback.class)).onPoiResultBack(getRecommPoiList(arrayList, i3), 0);
                    return;
                } else {
                    QLog.e(TAG, 1, "onGetBatchPoi error poiInfoList == null");
                    return;
                }
            }
            return;
        }
        QLog.e(TAG, 1, "onGetBatchPoi error jceStruct not instanceof GetBatchPoiRsp_V2");
    }

    private void onGetBatchPoiForRecom(int i3, JceStruct jceStruct) {
        if (jceStruct instanceof GetBatchPoiRsp_V2) {
            GetBatchPoiRsp_V2 getBatchPoiRsp_V2 = (GetBatchPoiRsp_V2) jceStruct;
            if (getBatchPoiRsp_V2 != null) {
                ArrayList<PoiInfoCell_V2> arrayList = getBatchPoiRsp_V2.vecPoiInfoCell;
                if (arrayList != null) {
                    ((IQCirclePoiCallback) QRoute.api(IQCirclePoiCallback.class)).onPoiResultBack(getRecommPoiList(arrayList, i3), i3 - 1000);
                    return;
                } else {
                    ((IQCirclePoiCallback) QRoute.api(IQCirclePoiCallback.class)).onPoiResultBack(null, i3 - 1000);
                    QLog.e(TAG, 1, "onGetBatchPoi error poiInfoList == null");
                    return;
                }
            }
            ((IQCirclePoiCallback) QRoute.api(IQCirclePoiCallback.class)).onPoiResultBack(null, i3 - 1000);
            QLog.e(TAG, 1, "resp == null");
            return;
        }
        ((IQCirclePoiCallback) QRoute.api(IQCirclePoiCallback.class)).onPoiResultBack(null, i3 - 1000);
        QLog.e(TAG, 1, "onGetBatchPoi error jceStruct not instanceof GetBatchPoiRsp_V2");
    }

    private void onGetLbsCombinFinish(int i3, JceStruct jceStruct) {
        LbsDataV2.GetGeoInfoRsp getGeoInfoRsp;
        GetPoiInfoRsp_V2 getPoiInfoRsp_V2;
        if (jceStruct instanceof GetLbsCombinRsp_V2) {
            GetLbsCombinRsp_V2 getLbsCombinRsp_V2 = (GetLbsCombinRsp_V2) jceStruct;
            LbsDataV2.PoiList poiList = new LbsDataV2.PoiList();
            int i16 = getLbsCombinRsp_V2.iMood;
            QLog.i(TAG, 1, "onGetLbsCombinFinish mode = " + i16);
            if ((i16 & 1) <= 0 || getLbsCombinRsp_V2.stGeoInfo == null) {
                getGeoInfoRsp = null;
            } else {
                getGeoInfoRsp = new LbsDataV2.GetGeoInfoRsp();
                getGeoInfoRsp.stGps = LbsDataV2.convertToGpsInfo(getLbsCombinRsp_V2.stGps);
                getGeoInfoRsp.stGeoInfo = LbsDataV2.convertToGeoInfo(getLbsCombinRsp_V2.stGeoInfo);
                QLog.i(TAG, 1, "onGetLbsCombinFinish will saveCurrentGeoInfo.");
            }
            if ((i16 & 2) > 0 && (getPoiInfoRsp_V2 = getLbsCombinRsp_V2.stPoiInfo) != null && getPoiInfoRsp_V2.vPoiList != null) {
                ArrayList arrayList = new ArrayList();
                for (int i17 = 0; i17 < getLbsCombinRsp_V2.stPoiInfo.vPoiList.size(); i17++) {
                    arrayList.add(LbsDataV2.convertToPoiInfo(getLbsCombinRsp_V2.stPoiInfo.vPoiList.get(i17)));
                }
                if (arrayList.size() > 0) {
                    poiList.poiInfos.addAll(arrayList);
                    LbsDataV2.PoiInfo poiInfo = (LbsDataV2.PoiInfo) arrayList.get(0);
                    if (getGeoInfoRsp == null) {
                        getGeoInfoRsp = new LbsDataV2.GetGeoInfoRsp();
                        getGeoInfoRsp.stGps = poiInfo.gpsInfo;
                        LbsDataV2.GeoInfo geoInfo = new LbsDataV2.GeoInfo();
                        getGeoInfoRsp.stGeoInfo = geoInfo;
                        geoInfo.iDistrictCode = poiInfo.districtCode;
                        geoInfo.strCountry = poiInfo.country;
                        geoInfo.strProvince = poiInfo.province;
                        geoInfo.strCity = poiInfo.city;
                        geoInfo.strDefaultName = poiInfo.poiDefaultName;
                    }
                    poiList.geoInfo = LbsDataV2.GetGeoInfoRsp.convertTo(getGeoInfoRsp);
                    ((IQCirclePoiCallback) QRoute.api(IQCirclePoiCallback.class)).onPoiResultBack(poiList, 0);
                    return;
                }
                QLog.e(TAG, 1, "poiList.size() == 0");
                return;
            }
            QLog.e(TAG, 1, "resp.stPoiInfo.vPoiList == null");
            return;
        }
        QLog.e(TAG, 1, "onGetLbsCombinFinish error jceStruct not instanceof GetLbsCombinRsp_V2");
    }

    @Override // com.tencent.qzonehub.api.IQzoneLbsServiceApi
    public void getBatchPoiFromServer(ArrayList<GpsInfo4LocalImage> arrayList, boolean z16) {
        HashMap hashMap = new HashMap();
        hashMap.put("source", "QqCircle");
        getBatchPoiFromServer(arrayList, 100203, hashMap, 1, z16 ? 0 : 2);
    }

    @Override // com.tencent.qzonehub.api.IQzoneLbsServiceApi
    public void getBatchPoiFromServerForRecom(ArrayList<GpsInfo4LocalImage> arrayList, int i3) {
        AppRuntime app = getApp();
        if (app == null) {
            QLog.e(TAG, 1, "getBatchPoiFromServerWithoutLocation app == null");
            return;
        }
        if (arrayList != null && !arrayList.isEmpty()) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<GpsInfo4LocalImage> it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(gz3.a.a(it.next()));
            }
            HashMap hashMap = new HashMap();
            hashMap.put("source", "QqCircle");
            fz3.a aVar = new fz3.a(arrayList2, 100203, hashMap, i3 + 1000, 1);
            QzoneCommonIntent qzoneCommonIntent = new QzoneCommonIntent(app.getApplication(), QZoneCommonServlet.class);
            qzoneCommonIntent.setRequest(aVar);
            qzoneCommonIntent.setObserver(this);
            app.startServlet(qzoneCommonIntent);
            QLog.i(TAG, 1, "getBatchPoiFromServerForRecom start");
            return;
        }
        QLog.e(TAG, 1, "getBatchPoiFromServerWithoutLocation empty gpslist");
        ((IQCirclePoiCallback) QRoute.api(IQCirclePoiCallback.class)).onPoiResultBack(new LbsDataV2.PoiList(), i3);
    }

    @Override // com.tencent.qzonehub.api.IQzoneLbsServiceApi
    public void getBatchPoiFromServerWithoutLocation(ArrayList<GpsInfo4LocalImage> arrayList) {
        AppRuntime app = getApp();
        if (app == null) {
            QLog.e(TAG, 1, "getBatchPoiFromServerWithoutLocation app == null");
            return;
        }
        if (arrayList != null && !arrayList.isEmpty()) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(gz3.a.a(arrayList.get(0)));
            HashMap hashMap = new HashMap();
            hashMap.put("source", "QqCircle");
            fz3.a aVar = new fz3.a(arrayList2, 100203, hashMap, 0, 1);
            QzoneCommonIntent qzoneCommonIntent = new QzoneCommonIntent(app.getApplication(), QZoneCommonServlet.class);
            qzoneCommonIntent.setRequest(aVar);
            qzoneCommonIntent.setObserver(this);
            app.startServlet(qzoneCommonIntent);
            return;
        }
        QLog.e(TAG, 1, "getBatchPoiFromServerWithoutLocation empty gpslist");
        ((IQCirclePoiCallback) QRoute.api(IQCirclePoiCallback.class)).onPoiResultBack(new LbsDataV2.PoiList(), 0);
    }

    @Override // mqq.observer.BusinessObserver
    public void onReceive(int i3, boolean z16, Bundle bundle) {
        QLog.i(TAG, 1, "onReceive type:" + i3 + " success:" + z16);
        JceStruct jceStruct = (JceStruct) bundle.getSerializable("key_response");
        int i16 = bundle.getInt("key_response_code");
        String string = bundle.getString(VSBaseServlet.KEY_RESPONSE_MSG);
        if (!z16) {
            QLog.e(TAG, 1, String.format("type :%d, success:%b, code:%d, msg:%s, bundle:%s", Integer.valueOf(i3), Boolean.valueOf(z16), Integer.valueOf(i16), string, bundle.toString()));
        } else if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, String.format("type :%d, success:%b, code:%d, msg:%s, bundle:%s", Integer.valueOf(i3), Boolean.valueOf(z16), Integer.valueOf(i16), string, bundle.toString()));
        }
        if (getApp() == null) {
            QLog.e(TAG, 1, "onReceive app == null");
            return;
        }
        if (i3 != 0) {
            if (i3 == 1) {
                onGetLbsCombinFinish(i3, jceStruct);
                return;
            } else if (i3 != 2 && i3 != 1000) {
                if (i3 > 1000) {
                    onGetBatchPoiForRecom(i3, jceStruct);
                    return;
                }
                return;
            }
        }
        onGetBatchPoi(i3, jceStruct);
    }

    @Override // com.tencent.qzonehub.api.IQzoneLbsServiceApi
    public void refreshPoiList() {
        refreshPoiList(null, 0, 100203, true, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static LbsDataV2.GeoInfo getGeoCacheByCell(ArrayList<Cell_V2> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return null;
        }
        return getGeoCacheByCell(LbsDataV2.covertToCellInfo(arrayList.get(0)));
    }

    public void refreshPoiList(String str, int i3, int i16, boolean z16, ArrayList<String> arrayList) {
        QLog.i(TAG, 1, "[QZ_LBS_MODULE]refreshPoiList forceRefresh:" + z16);
        ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).startLocation(new b("qzone_address_select", false, System.currentTimeMillis(), i3, i16, arrayList));
    }

    public void getBatchPoiFromServer(ArrayList<GpsInfo4LocalImage> arrayList, int i3, Map<String, String> map, int i16, int i17) {
        ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).startLocation(new a("qzone_address_select", false, i17, arrayList, System.currentTimeMillis(), i16, i3, map));
    }

    private LbsDataV2.PoiList getRecommPoiList(ArrayList<PoiInfoCell_V2> arrayList, int i3) {
        if (arrayList == null) {
            return null;
        }
        LbsDataV2.PoiList poiList = new LbsDataV2.PoiList();
        ArrayList<LbsDataV2.PoiInfo> arrayList2 = new ArrayList<>(arrayList.size());
        if (i3 >= 1000) {
            Iterator<PoiInfoCell_V2> it = arrayList.iterator();
            while (it.hasNext()) {
                PoiInfoCell_V2 next = it.next();
                LbsDataV2.PoiInfo poiInfo = new LbsDataV2.PoiInfo();
                poiInfo.poiId = "local_city_id";
                String str = next.stCityName;
                poiInfo.poiName = str;
                poiInfo.city = str;
                poiInfo.gpsInfo = LbsDataV2.convertToGpsInfo(next.stGps);
                arrayList2.add(poiInfo);
                QLog.d(TAG, 1, "getRecomPoiList... cityName:", next.stCityName, " gps:" + poiInfo.gpsInfo);
            }
            poiList.poiInfos = arrayList2;
            return poiList;
        }
        if (arrayList.get(0).vPoiList != null) {
            if (i3 == 0 && !TextUtils.isEmpty(arrayList.get(0).stCityName)) {
                LbsDataV2.PoiInfo poiInfo2 = new LbsDataV2.PoiInfo();
                poiInfo2.poiId = "local_city_id";
                poiInfo2.poiName = arrayList.get(0).stCityName;
                poiInfo2.city = arrayList.get(0).stCityName;
                poiInfo2.gpsInfo = LbsDataV2.convertToGpsInfo(arrayList.get(0).stGps);
                arrayList2.add(poiInfo2);
                QLog.d(TAG, 1, "getRecommPoiList... cityname:", arrayList.get(0).stCityName);
            }
            Iterator<PoiInfo_V2> it5 = arrayList.get(0).vPoiList.iterator();
            while (it5.hasNext()) {
                arrayList2.add(LbsDataV2.convertToPoiInfo(it5.next()));
            }
        }
        if (arrayList.size() > 1 && arrayList.get(1).vPoiList != null) {
            for (int i16 = 0; i16 < 5 && i16 < arrayList.get(1).vPoiList.size(); i16++) {
                if (!arrayList2.contains(LbsDataV2.convertToPoiInfo(arrayList.get(1).vPoiList.get(i16)))) {
                    arrayList2.add(Math.min(arrayList2.size(), 1), LbsDataV2.convertToPoiInfo(arrayList.get(1).vPoiList.get(i16)));
                }
            }
        }
        poiList.poiInfos = arrayList2;
        return poiList;
    }
}
