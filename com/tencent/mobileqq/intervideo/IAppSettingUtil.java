package com.tencent.mobileqq.intervideo;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IAppSettingUtil extends QRouteApi {
    String getSubVersion();
}
