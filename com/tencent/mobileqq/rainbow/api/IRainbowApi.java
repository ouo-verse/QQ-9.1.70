package com.tencent.mobileqq.rainbow.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IRainbowApi extends QRouteApi {
    public static final String TAG = "IRainbowApi";
    public static final int TYPE_OFFICIAL_UPDATE = 1;
    public static final int TYPE_ZPLAN_AVATAR_CONFIG = 2;

    void getCmdRainbowData(String str, String str2, int i3);

    void getCmdRainbowData(String str, String str2, String str3, String str4, int i3);
}
