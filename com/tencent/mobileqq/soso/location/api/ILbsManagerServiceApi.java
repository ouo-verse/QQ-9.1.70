package com.tencent.mobileqq.soso.location.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface ILbsManagerServiceApi extends QRouteApi {
    String getBGLocateMonitorClassName();

    SosoLbsInfo getCachedLbsInfo(String str);

    String getCity();

    String getCityCode();

    String getProvince();

    void initLocationManager();

    boolean isLastLocationSuccess();

    void onDestroy();

    void pushBGLocateMonitorStart();

    void removeListener(LbsManagerServiceOnLocationChangeListener lbsManagerServiceOnLocationChangeListener);

    void startLocation(LbsManagerServiceOnLocationChangeListener lbsManagerServiceOnLocationChangeListener);
}
