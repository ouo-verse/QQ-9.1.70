package com.tencent.qzonehub.api;

import NS_UNDEAL_COUNT.count_info;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.Map;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IQzoneUndealCountApi extends QRouteApi {
    public static final String UNDEALCOUNT_FEEDALERT_LAST_GET_TIME = "getMapLastGetTime";

    void handleRecommendPhotoConfig(Map<Integer, count_info> map);

    boolean isShowQZoneIntimateSpaceEntrance();

    void recordQZoneShowIntimateSpaceMessageTab();
}
