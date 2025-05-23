package com.tencent.av.abtest.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import java.util.Map;

/* compiled from: P */
@QRouteFactory(singleton = true)
@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IQavABTestApi extends QRouteApi {
    String getAssignment();

    String getGrayId();

    Map<String, String> getParams();

    boolean isContrast();

    boolean isExpHit(String str);

    boolean isExpOnline();

    boolean isExperiment();

    IQavABTestApi loadExperiment(String str);

    void reportEvent(int i3, String str);

    boolean reportExpExposure();

    void reportExposure(String str);
}
