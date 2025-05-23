package com.tencent.mobileqq.qcircle.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.Map;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IQCircleABTestApi extends QRouteApi {
    String getAssignment(String str);

    String getAssignmentByLayerCode(String str);

    String getExpNameByLayerCode(String str);

    Map<String, String> getParams(String str);

    Map<String, String> getParamsByLayerCode(String str);

    boolean isContrast(String str);

    boolean isExpHit(String str, String str2);

    boolean isExpOnline(String str);

    boolean isExperiment(String str);

    boolean isTabSDKInited();

    void onAccountChange();

    void reportEvent(String str, int i3, String str2);

    void reportExpExposure(String str);

    void reportExposure(String str, String str2);
}
