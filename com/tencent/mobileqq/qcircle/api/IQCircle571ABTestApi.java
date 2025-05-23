package com.tencent.mobileqq.qcircle.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.Map;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IQCircle571ABTestApi extends QRouteApi {
    String getAssignment(String str);

    String getAssignmentByLayerCode(String str);

    String getExpNameByLayerCode(String str);

    Map<String, String> getParamsByLayerCode(String str);

    String getStorageExpGroupName(String str);

    boolean isContrast(String str);

    boolean isExpHit(String str, String str2);

    boolean isExperiment(String str);

    boolean isStorageContrast(String str);

    boolean isStorageExperiment(String str);

    void onAccountChange();

    void reportExperimentExport(String str);
}
