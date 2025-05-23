package com.tencent.gdtad.config;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes6.dex */
public interface IGdtConfigManagerForExperimentAPI extends QRouteApi {
    String[] getExperimentIdList();
}
