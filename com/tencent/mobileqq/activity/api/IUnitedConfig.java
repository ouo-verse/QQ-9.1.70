package com.tencent.mobileqq.activity.api;

import com.tencent.mobileqq.graytip.UniteEntity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes10.dex */
public interface IUnitedConfig extends QRouteApi {
    Boolean isSwitchOn(String str, Boolean bool);

    UniteEntity parseXMLContent(String str);
}
